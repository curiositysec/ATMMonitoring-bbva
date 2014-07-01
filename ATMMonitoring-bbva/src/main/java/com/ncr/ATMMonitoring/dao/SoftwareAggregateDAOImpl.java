package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.SoftwareAggregate;

/**
 * The Class SoftwareAggregateDAOImpl.
 * 
 * Default implementation of SoftwareAggregateDAO.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class SoftwareAggregateDAOImpl extends
	AbstractGenericDAO<SoftwareAggregate> implements SoftwareAggregateDAO {

    /** The logger. */
    static private Logger logger = Logger
	    .getLogger(SoftwareAggregateDAOImpl.class.getName());

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.SoftwareAggregateDAO#addSoftwareAggregate(com
     * .ncr.ATMMonitoring.pojo.SoftwareAggregate)
     */
    @Override
    public void addSoftwareAggregate(SoftwareAggregate softwareAggregate) {
	add(softwareAggregate);
	logger.debug("Created new Software Aggregate with id "
		+ softwareAggregate.getId());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.SoftwareAggregateDAO#listSoftwareAggregate()
     */
    @Override
    public List<SoftwareAggregate> listSoftwareAggregate() {
	return sessionFactory.getCurrentSession()
		.createCriteria(SoftwareAggregate.class)
		.addOrder(Order.asc("name"))
		.addOrder(Order.desc("major_version"))
		.addOrder(Order.desc("minor_version"))
		.addOrder(Order.desc("build_version"))
		.addOrder(Order.desc("revision_version"))
		.addOrder(Order.asc("remaining_version"))
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.SoftwareAggregateDAO#getSoftwareAggregate(java
     * .lang.Integer)
     */
    @Override
    public SoftwareAggregate getSoftwareAggregate(Integer id) {
	return get(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.SoftwareAggregateDAO#
     * getSoftwareAggregateByVersionName(java.lang.Integer, java.lang.Integer,
     * java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String)
     */
    @Override
    public SoftwareAggregate getSoftwareAggregateByVersionName(
	    Integer majorVersion, Integer minorVersion, Integer buildVersion,
	    Integer revisionVersion, String remainingVersion, String name) {

	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
		SoftwareAggregate.class);
	if (majorVersion == null) {
	    criteria.add(Restrictions.isNull("majorVersion"));
	} else {
	    criteria.add(Restrictions.eq("majorVersion", majorVersion));
	}
	if (minorVersion == null) {
	    criteria.add(Restrictions.isNull("minorVersion"));
	} else {
	    criteria.add(Restrictions.eq("minorVersion", minorVersion));
	}
	if (buildVersion == null) {
	    criteria.add(Restrictions.isNull("buildVersion"));
	} else {
	    criteria.add(Restrictions.eq("buildVersion", buildVersion));
	}
	if (revisionVersion == null) {
	    criteria.add(Restrictions.isNull("revisionVersion"));
	} else {
	    criteria.add(Restrictions.eq("revisionVersion", revisionVersion));
	}
	if (remainingVersion == null) {
	    criteria.add(Restrictions.isNull("remainingVersion"));
	} else {
	    criteria.add(Restrictions.eq("remainingVersion", remainingVersion));
	}
	if (name == null) {
	    return (SoftwareAggregate) criteria
		    .add(Restrictions.isNull("name")).uniqueResult();
	} else {
	    return (SoftwareAggregate) criteria.add(
		    Restrictions.eq("name", name)).uniqueResult();
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.SoftwareAggregateDAO#removeSoftwareAggregate
     * (java.lang.Integer)
     */
    @Override
    public void removeSoftwareAggregate(Integer id) {
	delete(id);
    }
}