package com.ncr.ATMMonitoring.dao;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.HardwareDevice;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.ATMMonitoring.utils.TrialEndedException;
import com.ncr.ATMMonitoring.utils.Utils;
import com.ncr.agent.baseData.ATMDataStorePojo;
import com.ncr.agent.baseData.os.module.BaseBoardPojo;

/**
 * The Class TerminalDAOImpl.
 * 
 * Default implementation of TerminalDAO.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class TerminalDAOImpl extends AbstractGenericDAO<Terminal> implements
	TerminalDAO {

    /** Base offset to multiply to the country code for computing the offset. */
    private final static int baseOffset = 1000000;

    /** The encrypted max number of terminals this version can handle. */
    @Value("${license.terminalsLimit}")
    private String terminalsLimit;

    /** The key for the current license. */
    @Value("${license.licenseKey}")
    private String licenseKey;

    /**
     * The ISO country numeric code, which will be used for computing an offset
     * to add to the matricula value retrieved from DB.
     */
    @Value("${config.countryIsoNumericCode}")
    private int countryIsoNumericCode;

    /** The logger. */
    static private Logger logger = Logger.getLogger(TerminalDAOImpl.class
	    .getName());

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.TerminalDAO#addTerminal(com.ncr.ATMMonitoring
     * .pojo.Terminal)
     */
    @Override
    public void addTerminal(Terminal terminal) {
	try {
	    if (terminal.getMatricula() == null) {
		terminal.setMatricula(getNextMatricula());
		sessionFactory.getCurrentSession().save(terminal);
		logger.info("Created new terminal with id " + terminal.getId()
			+ ", IP " + terminal.getIp() + " and NEW matricula "
			+ terminal.getMatricula());
	    } else {
		sessionFactory.getCurrentSession().save(terminal);
		logger.info("Created new terminal with id " + terminal.getId()
			+ ", IP " + terminal.getIp() + " and matricula "
			+ terminal.getMatricula());
	    }
	} catch (TrialEndedException e) {
	    if (e.getCause() != null) {
		logger.fatal(e.getMessage(), e);
	    } else {
		logger.fatal(e.getMessage());
	    }
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.TerminalDAO#updateTerminal(com.ncr.ATMMonitoring
     * .pojo.Terminal)
     */
    @Override
    public void updateTerminal(Terminal terminal) {
	update(terminal);
	logger.info("Updated terminal with id " + terminal.getId() + ", IP "
		+ terminal.getIp() + " and matricula "
		+ terminal.getMatricula());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.TerminalDAO#listTerminalsByBankCompanies(java
     * .util.Set)
     */
    @Override
    public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> banks) {
	return listTerminalsByBankCompanies(banks, "serialNumber", "asc", null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.TerminalDAO#listTerminalsByIdsAndBankCompanies
     * (java .util.List, java.util.Set)
     */
    public List<Terminal> listTerminalsByIdsAndBankCompanies(
	    List<Integer> terminalIds, Set<BankCompany> banks) {
	return listTerminalsByBankCompanies(banks, "serialNumber", "asc",
		terminalIds);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.TerminalDAO#listTerminalsByBankCompanies(java
     * .util.Set, java.lang.String, java.lang.String, java.util.List)
     */
    @Override
    public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> banks,
	    String sort, String order, List<Integer> terminalIds) {
	Criterion restriction = (banks.size() > 0) ? Restrictions.or(
		Restrictions.in("bankCompany", banks),
		Restrictions.isNull("bankCompany")) : Restrictions
		.isNull("bankCompany");

	if (terminalIds != null) {
	    restriction = Restrictions.and(restriction,
		    Restrictions.in("id", terminalIds));
	}

	Criteria criteria = sessionFactory.getCurrentSession()
		.createCriteria(Terminal.class).add(restriction);

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
     * @see
     * com.ncr.ATMMonitoring.dao.TerminalDAO#listTerminalsByBankCompany(com.
     * ncr.ATMMonitoring.pojo.BankCompany)
     */
    @Override
    public List<Terminal> listTerminalsByBankCompany(BankCompany bank) {
	return sessionFactory
		.getCurrentSession()
		.createCriteria(Terminal.class)
		.add(Restrictions.or(Restrictions.eq("bankCompany", bank),
			Restrictions.isNull("bankCompany")))
		.addOrder(Order.asc("serialNumber"))
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.TerminalDAO#listTerminals()
     */
    @Override
    public List<Terminal> listTerminals() {
	return sessionFactory.getCurrentSession()
		.createCriteria(Terminal.class)
		.addOrder(Order.asc("serialNumber"))
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.TerminalDAO#getTerminalsByHQL(java.util.List,
     * java.util.List, java.lang.String)
     */
    @Override
    public List<Terminal> getTerminalsByHQL(List<Object> values,
	    List<Type> types, String hql) {
	return getTerminalsByHQL(values, types, hql, null, null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.TerminalDAO#getTerminalsByHQL(java.util.List,
     * java.util.List, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public List<Terminal> getTerminalsByHQL(List<Object> values,
	    List<Type> types, String hql, String sort, String order) {
	if (sort != null) {
	    hql += " order by terminal." + sort;
	    if (order != null) {
		hql += " " + order;
	    }
	}
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	query.setParameters(values.toArray(), types.toArray(new Type[0]));
	logger.debug("Executing the HQL sentence '" + hql
		+ "' with the values " + values + "and types " + types);
	try {
	    return query.list();
	} catch (HibernateException e) {
	    logger.error(
		    "There was an error while executing the HQL sentence '"
			    + hql + "' with the values " + values
			    + "and types " + types, e);
	    throw e;
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.TerminalDAO#getTerminal(java.lang.Integer)
     */
    @Override
    public Terminal getTerminal(Integer id) {
	return get(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.TerminalDAO#getTerminalBySerialNumber(java.
     * lang.String)
     */
    @Override
    public Terminal getTerminalBySerialNumber(String serialNumber) {
	Terminal result = (Terminal) sessionFactory.getCurrentSession()
		.createCriteria(Terminal.class)
		.add(Restrictions.eq("serialNumber", serialNumber))
		.setMaxResults(1).uniqueResult();
	return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.TerminalDAO#getTerminalByIp(java.lang.String)
     */
    @Override
    public Terminal getTerminalByIp(String ip) {
	Terminal result = (Terminal) sessionFactory.getCurrentSession()
		.createCriteria(Terminal.class).add(Restrictions.eq("ip", ip))
		.setMaxResults(1).uniqueResult();
	return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.TerminalDAO#getTerminalByMac(java.lang.String)
     */
    @Override
    public Terminal getTerminalByMac(String mac) {
	Terminal result = (Terminal) sessionFactory.getCurrentSession()
		.createCriteria(Terminal.class)
		.add(Restrictions.eq("mac", mac)).setMaxResults(1)
		.uniqueResult();
	return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.TerminalDAO#getTerminalByMatricula(java.lang
     * .Long)
     */
    @Override
    public Terminal getTerminalByMatricula(Long matricula) {
	Terminal result = (Terminal) sessionFactory.getCurrentSession()
		.createCriteria(Terminal.class)
		.add(Restrictions.eq("matricula", matricula)).setMaxResults(1)
		.uniqueResult();
	return result;
    }

    /**
     * Gets the next generated id.
     * 
     * @return the next generated id
     * @throws TrialEndedException
     */
    private Long getNextMatricula() throws TrialEndedException {
	try {
	    if ((licenseKey == null) || (licenseKey.length() != 16)) {
		throw new TrialEndedException(
			"The configured license key isn't correct."
				+ " Terminal data won't be saved. Please contact the support team.");
	    }
	    if ((terminalsLimit == null) || (terminalsLimit.length() < 1)) {
		throw new TrialEndedException(
			"The configured terminal number limit key isn't correct."
				+ " Terminal data won't be saved. Please contact the support team.");
	    }
	    long terminalsLimit = Long.parseLong(Utils.decrypt(licenseKey,
		    this.terminalsLimit));
	    BigInteger terminals = (BigInteger) sessionFactory
		    .getCurrentSession()
		    .createSQLQuery(
			    "select count(distinct(matricula)) from terminals")
		    .uniqueResult();
	    if ((terminalsLimit != Utils.NO_TERMINAL_LIMIT)
		    && (terminals.longValue() > terminalsLimit)) {
		throw new TrialEndedException(
			"You have exceeded the maximum number of different "
				+ "terminals to store during the trial. Terminal data won't be saved.");
	    }
	} catch (GeneralSecurityException e) {
	    throw new TrialEndedException(
		    "There was some problem while checking your license key."
			    + " Terminal data won't be saved. Please contact the support team.",
		    e);
	} catch (NumberFormatException e) {
	    throw new TrialEndedException(
		    "The configured terminal number limit key isn't correct."
			    + " Terminal data won't be saved. Please contact the support team.",
		    e);
	} catch (ArrayIndexOutOfBoundsException e) {
	    throw new TrialEndedException(
		    "The configured terminal number limit key isn't correct."
			    + " Terminal data won't be saved. Please contact the support team.",
		    e);
	}
	BigInteger seq = (BigInteger) sessionFactory.getCurrentSession()
		.createSQLQuery("select nextval('terminals_matricula_seq')")
		.uniqueResult();
	return (countryIsoNumericCode * baseOffset) + seq.longValue();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.TerminalDAO#getTerminalBySimilarity(com.ncr
     * .agent.baseData.ATMDataStorePojo)
     */
    @Override
    public Terminal getTerminalBySimilarity(ATMDataStorePojo terminal) {
	Vector baseBoards = terminal.getvBaseBoard();
	String serialNumber = (baseBoards.size() > 0) ? ((BaseBoardPojo) baseBoards
		.get(0)).getSerialNumber() : null;
	logger.debug("SERIAL: " + serialNumber);
	Terminal result = (Terminal) sessionFactory
		.getCurrentSession()
		.createCriteria(Terminal.class)
		.createAlias("hardwareDevices", "hw")
		.add(Restrictions.or(
			Restrictions.and(Restrictions.eq("ip",
				terminal.getCurrentip()), Restrictions.eq(
				"mac", terminal.getCurrentmac()), Restrictions
				.isNotNull("mac"),
				Restrictions.isNotNull("ip"), Restrictions.ne(
					"mac", ""), Restrictions.ne("ip", "")),
			Restrictions.and(
				Restrictions.eq("ip", terminal.getCurrentip()),
				Restrictions
					.eq("hw.serialNumber", serialNumber),
				Restrictions
					.eq("hw.hardwareClass",
						HardwareDevice
							.getDeviceclasses()
							.get(HardwareDevice.DeviceClassId.BASE_BOARD)),
				Restrictions.isNotNull("hw.serialNumber"),
				Restrictions.isNotNull("ip"), Restrictions.ne(
					"hw.serialNumber", ""), Restrictions
					.ne("ip", "")),
			Restrictions.and(
				Restrictions
					.eq("mac", terminal.getCurrentmac()),
				Restrictions
					.eq("hw.serialNumber", serialNumber),
				Restrictions
					.eq("hw.hardwareClass",
						HardwareDevice
							.getDeviceclasses()
							.get(HardwareDevice.DeviceClassId.BASE_BOARD)),
				Restrictions.isNotNull("hw.serialNumber"),
				Restrictions.isNotNull("mac"), Restrictions.ne(
					"hw.serialNumber", ""), Restrictions
					.ne("mac", "")))).setMaxResults(1)
		.uniqueResult();
	return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.TerminalDAO#deleteAllTerminalData()
     */
    @Override
    public void deleteAllTerminalData() {
	sessionFactory
		.getCurrentSession()
		.createSQLQuery(
			"DELETE FROM terminals_installations;"
				+ "DELETE FROM terminals_auditable_software_aggregate;"
				+ "DELETE FROM terminals_auditable_internet_explorer;"
				+ "DELETE FROM terminal_config_software;"
				+ "DELETE FROM t_config_op_system;"
				+ "DELETE FROM terminal_configs;"
				+ "DELETE FROM logical_cash_units;"
				+ "DELETE FROM physical_cash_units;"
				+ "DELETE FROM financial_device_jxfs_component;"
				+ "DELETE FROM financial_device_xfs_component;"
				+ "DELETE FROM xfs_components;"
				+ "DELETE FROM jxfs_components;"
				+ "DELETE FROM financial_devices;"
				+ "DELETE FROM hardware_devices;"
				+ "DELETE FROM hotfixes;"
				+ "DELETE FROM software;"
				+ "DELETE FROM auditable_software_aggregate;"
				+ "DELETE FROM software_aggregates;"
				+ "DELETE FROM operating_systems;"
				+ "DELETE FROM auditable_internet_explorer;"
				+ "DELETE FROM internet_explorers;"
				+ "DELETE FROM terminals;"
				+ "DELETE FROM installations;").executeUpdate();
    }
}
