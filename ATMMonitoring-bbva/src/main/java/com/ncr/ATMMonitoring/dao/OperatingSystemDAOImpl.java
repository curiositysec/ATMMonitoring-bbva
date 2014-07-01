package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.OperatingSystem;

/**
 * The Class OperatingSystemDAOImpl.
 * 
 * Default implementation of OperatingSystemDAO.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class OperatingSystemDAOImpl extends AbstractGenericDAO<OperatingSystem>
	implements OperatingSystemDAO {

    /** The logger. */
    static private Logger logger = Logger
	    .getLogger(OperatingSystemDAOImpl.class.getName());

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.OperatingSystemDAO#addOperatingSystem(com.ncr
     * .ATMMonitoring.pojo.OperatingSystem)
     */
    @Override
    public void addOperatingSystem(OperatingSystem operatingSystem) {
	add(operatingSystem);
	logger.debug("Created new Operating System with id "
		+ operatingSystem.getId());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.OperatingSystemDAO#listOperatingSystem()
     */
    @Override
    public List<OperatingSystem> listOperatingSystem() {
	return sessionFactory.getCurrentSession()
		.createCriteria(OperatingSystem.class)
		.addOrder(Order.asc("name"))
		.addOrder(Order.desc("major_version"))
		.addOrder(Order.desc("minor_version"))
		.addOrder(Order.desc("build_version"))
		.addOrder(Order.desc("revision_version"))
		.addOrder(Order.desc("remaining_version"))
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.OperatingSystemDAO#getOperatingSystem(java.
     * lang.Integer)
     */
    @Override
    public OperatingSystem getOperatingSystem(Integer id) {
	return get(id);
    }
}