package com.ncr.ATMMonitoring.dao;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.User;

/**
 * The Class UserDAOImpl.
 * 
 * Default implementation of UserDAO.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class UserDAOImpl extends AbstractGenericDAO<User> implements UserDAO {

    /** The logger. */
    static private Logger logger = Logger
	    .getLogger(UserDAOImpl.class.getName());

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.UserDAO#addUser(com.ncr.ATMMonitoring.pojo.
     * User)
     */
    @Override
    public void addUser(User user) {
	add(user);
	logger.info("Created new User with id " + user.getId()
		+ " and username " + user.getUsername());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.UserDAO#updateUser(com.ncr.ATMMonitoring.pojo
     * .User)
     */
    @Override
    public void updateUser(User user) {
	update(user);
	logger.info("Updated User with id " + user.getId() + " and username "
		+ user.getUsername());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.UserDAO#listUsers(java.lang.String,
     * java.lang.String)
     */
    @Override
    public List<User> listUsers(String sort, String order) {
	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
		User.class);

	if ((sort != null) && (order != null)) {
	    if ("asc".equals(order)) {
		criteria.addOrder(Order.asc(sort));
	    } else {
		criteria.addOrder(Order.desc(sort));
	    }
	}
	return criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
		.list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.UserDAO#listUsers()
     */
    @Override
    public List<User> listUsers() {
	return sessionFactory.getCurrentSession().createCriteria(User.class)
		.addOrder(Order.asc("lastname"))
		.addOrder(Order.asc("username"))
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.UserDAO#listUsersByBankCompanies(java.util.Set)
     */
    @Override
    public List<User> listUsersByBankCompanies(Set<BankCompany> banks) {
	Criterion restriction = (banks.size() > 0) ? Restrictions.or(
		Restrictions.in("bankCompany", banks),
		Restrictions.isNull("bankCompany")) : Restrictions
		.isNull("bankCompany");
	return sessionFactory.getCurrentSession().createCriteria(User.class)
		.add(restriction).addOrder(Order.asc("lastname"))
		.addOrder(Order.asc("username"))
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.UserDAO#listUsersByBankCompany(com.ncr.
     * ATMMonitoring.pojo.BankCompany)
     */
    @Override
    public List<User> listUsersByBankCompany(BankCompany bank) {
	return sessionFactory
		.getCurrentSession()
		.createCriteria(User.class)
		.add(Restrictions.or(Restrictions.eq("bankCompany", bank),
			Restrictions.isNull("bankCompany")))
		.addOrder(Order.asc("lastname"))
		.addOrder(Order.asc("username"))
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.UserDAO#getUser(java.lang.Integer)
     */
    @Override
    public User getUser(Integer id) {
	return get(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.UserDAO#removeUser(java.lang.Integer)
     */
    @Override
    public void removeUser(Integer id) {
	User user = (User) sessionFactory.getCurrentSession().load(User.class,
		id);
	if (user != null) {
	    delete(user);
	    logger.info("Deleted User with id " + id + " and username "
		    + user.getUsername());
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.UserDAO#getUserByUsername(java.lang.String)
     */
    @Override
    public User getUserByUsername(String username) {
		User result = (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
		if (result == null) 
		{
		    logger.error("Requested User with username '" + username + "' was not found");
		    throw new UsernameNotFoundException("User with username '" + username + "' not found");
		}
		return result;
    }

	@Override
	public User getUserByUsernameLoop(String username) {
		User result = (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
		if (result == null) 
		{
		    logger.error("Requested User with username '" + username + "' was not found");
		}
		return result;
	}
}