package com.ncr.ATMMonitoring.service;

import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.BankCompanyDAO;
import com.ncr.ATMMonitoring.dao.RoleDAO;
import com.ncr.ATMMonitoring.dao.UserDAO;
import com.ncr.ATMMonitoring.parser.exception.FileNotReadableException;
import com.ncr.ATMMonitoring.parser.exception.NoParserFoundException;
import com.ncr.ATMMonitoring.parser.exception.ParserException;
import com.ncr.ATMMonitoring.parser.office.ParseOfficeChainBuilder;
import com.ncr.ATMMonitoring.parser.office.dto.OfficeInfo;
import com.ncr.ATMMonitoring.parser.users.ParseRolesChainBuilder;
import com.ncr.ATMMonitoring.parser.users.ParseUsersChainBuilder;
import com.ncr.ATMMonitoring.parser.users.dto.RolesInfo;
import com.ncr.ATMMonitoring.parser.users.dto.UsersInfo;
import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.Location;
import com.ncr.ATMMonitoring.pojo.Role;
import com.ncr.ATMMonitoring.pojo.User;

/**
 * The Class UserServiceImpl.
 * 
 * Default implementation of the UserService.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	 /** The logger. */
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
    
    /** The user dao. */
    @Autowired
    private UserDAO userDAO;
    
    /** The role dao. */
    @Autowired
    private RoleDAO roleDAO;
    
    /** The bank dao. */
    @Autowired
    private BankCompanyDAO bankDAO;

    /** The password encoder. */
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
	/**
     * Executes the parser onto the given Inputstream
     * 
     * @param excel
     *            {@link InputStream} with the excel file
     * @throws ParserException
     * @throws FileNotReadableException
     * @throws NoParserFoundException
     */
    private void parseFile(String excel, InputStream mdc) throws ParserException, FileNotReadableException, NoParserFoundException {
		Collection<UsersInfo> users = ParseUsersChainBuilder.parse(excel);
		Collection<RolesInfo> perfiles = ParseRolesChainBuilder.parse(mdc);
		for (UsersInfo user : users) {
			//Buscamos en el listado de perfiles los datos del username igual al que hemos cogido
			for(RolesInfo perfil : perfiles){
				if(perfil.getUsername().equalsIgnoreCase(user.getQid()))
					handleParserSuccess(user,perfil);
			}

		}
    }

    /**
     * Saves the user info in the Database
     * 
     * @param user
     *            the UsersInfo to save
     */
    private void handleParserSuccess(UsersInfo user, RolesInfo perfil) {
    	logger.info("handleParserSuccess: Busqueda de usuarios por Username");

    	//Obtenemos de la base de datos los usuarios con el Username indicado
    	//- Si el usuario es null, hay que dar de alta el usuario pero antes hay que ver que tenga un Rol
    	//- Si el usuario ya existe, se busca el rol en el Mdc. Si no está, se deja el Rol que tuviera
		User usr = getUserByUsernameLoop(user.getQid());
		Role rl = getRoleById(Integer.parseInt(perfil.getRol()));
		if(rl==null){
			logger.info("HandleParserSuccess: The rol with id " + Integer.parseInt(perfil.getRol()) + " is null. Return");
			return;
		}	
		
		//Si el usuario no existe, creamos uno
		if (usr == null) {
			logger.info("handleParserSuccess: usr null");
		
			usr = new User();
			usr.setUsername(user.getQid());
			usr.setPassword("");
			
		}
		
		//Si existe o no, le actualizamos el Rol, Nombre y Apellidos
		usr.setRole(rl);
		usr.setFirstname(user.getFirstname());
		usr.setLastname(user.getLastname1() + " " + user.getLastname2());
		
		//El Dashboard se crea solo cuando el user se conecta
		
		//El bank_id lo vamos a marcar mediante el código del país
		//La lista de bancos tendrá en el campo Vat_in el código que viene en el fichero xlsx
		//De esta forma obtenemos el banco al que pertenece. Si no se pone, petan los Terminals
		BankCompany bc = getBankByVat(user.getCountry());
		if(bc==null){
			logger.info("HandleParserSuccess: The bank with vat " + user.getCountry() + " is null. Return");
			return;
		}
		
		usr.setBankCompany(bc);
		//
		
		//Hacemos persistente en base de datos
		if (usr.getId() != null) {
			logger.info("User updated");
		    updateUser(usr);
		} else {
			logger.info("New user added");
		    addUser(usr);
		}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.UserService#addUser(com.ncr.ATMMonitoring
     * .pojo.User)
     */
    @Override
    public void addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDAO.addUser(user);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.UserService#updateUser(com.ncr.ATMMonitoring
     * .pojo.User)
     */
    @Override
    public void updateUser(User user) {
	userDAO.updateUser(user);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.service.UserService#updatePassword(com.ncr.
     * ATMMonitoring.pojo.User)
     */
    @Override
    public void updatePassword(User user) {
	user.setPassword(passwordEncoder.encode(user.getPassword()));
	userDAO.updateUser(user);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.service.UserService#listUsers()
     */
    @Override
    public List<User> listUsers() {
	return userDAO.listUsers();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.UserService#listUsers(java.lang.String,
     * java.lang.String)
     */
    @Override
    public List<User> listUsers(String sort, String order) {
	return userDAO.listUsers(sort, order);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.UserService#listUsersByBankCompanies(java
     * .util.Set)
     */
    @Override
    public List<User> listUsersByBankCompanies(Set<BankCompany> banks) {
	return userDAO.listUsersByBankCompanies(banks);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.UserService#listUsersByBankCompany(com.
     * ncr.ATMMonitoring.pojo.BankCompany)
     */
    @Override
    public List<User> listUsersByBankCompany(BankCompany bank) {
	return userDAO.listUsersByBankCompany(bank);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.service.UserService#getUser(java.lang.Integer)
     */
    @Override
    public User getUser(Integer id) {
	return userDAO.getUser(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.UserService#getUserByUsername(java.lang
     * .String)
     */
    @Override
    @Transactional(readOnly = true)
    public User getUserByUsername(String username) {
    	return userDAO.getUserByUsername(username);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.UserService#removeUser(java.lang.Integer)
     */
    @Override
    public void removeUser(Integer id) {
	userDAO.removeUser(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.UserService#loadUserByUsername(java.lang
     * .String)
     */
    @Override
    public User loadUserByUsername(String username)
	    throws UsernameNotFoundException {
	User user = userDAO.getUserByUsername(username);
	if (user != null) {
	    user.setLastLogin(new Date());
	    userDAO.updateUser(user);
	}
	return user;
    }

	@Override
	public boolean storeUsersInfo(String excelFile, InputStream mdcFile) {
		boolean parsed = false;
		try {
		    this.parseFile(excelFile, mdcFile);
		    parsed = true;
		} catch (ParserException e) {
		    logger.error("Can not parse any of the files: " + excelFile + " or " + mdcFile
			    + " due to an error: ", e);
		} catch (FileNotReadableException e) {
		    logger.error("Can not read any of the files: " + excelFile + " or " + mdcFile, e);
		} catch (NoParserFoundException e) {
		    logger.error("Any of the files " + excelFile + " or " + mdcFile
			    + " can not be processed by any configured parser (" + e + ")");
		}
	
		return parsed;
	}

	@Override
	public User getUserByUsernameLoop(String username) {
		// TODO Auto-generated method stub
		return userDAO.getUserByUsernameLoop(username);
	}

	@Override
	public Role getRoleById(Integer id) {
		return roleDAO.getRoleById(id);
	}

	@Override
	public BankCompany getBankByVat(String vat) {
		// TODO Auto-generated method stub
		return bankDAO.getBankCompanyByVat(vat);
	}
}
