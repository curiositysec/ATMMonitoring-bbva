package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.InternetExplorer;

/**
 * The Class InternetExplorerDAOImpl.
 * 
 * Default implementation of InternetExplorerDAO.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class InternetExplorerDAOImpl extends
	AbstractGenericDAO<InternetExplorer> implements InternetExplorerDAO {

    /** The logger. */
    static private Logger logger = Logger
	    .getLogger(InternetExplorerDAOImpl.class.getName());

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.InternetExplorerDAO#addInternetExplorer(com
     * .ncr.ATMMonitoring.pojo.InternetExplorer)
     */
    @Override
    public void addInternetExplorer(InternetExplorer internetExplorer) {
	add(internetExplorer);
	logger.debug("Created new Internet Explorer with id "
		+ internetExplorer.getId());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.InternetExplorerDAO#listInternetExplorer()
     */
    @Override
    public List<InternetExplorer> listInternetExplorer() {
	return sessionFactory.getCurrentSession()
		.createCriteria(InternetExplorer.class)
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
     * com.ncr.ATMMonitoring.dao.InternetExplorerDAO#getInternetExplorer(java
     * .lang.Integer)
     */
    @Override
    public InternetExplorer getInternetExplorer(Integer id) {
	return get(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.InternetExplorerDAO#removeInternetExplorer(
     * java.lang.Integer)
     */
    @Override
    public void removeInternetExplorer(Integer id) {
	delete(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.InternetExplorerDAO#getInternetExplorerByVersion
     * (java.lang.Integer, java.lang.Integer, java.lang.Integer,
     * java.lang.Integer, java.lang.String)
     */
    @Override
    public InternetExplorer getInternetExplorerByVersion(Integer majorVersion,
	    Integer minorVersion, Integer buildVersion,
	    Integer revisionVersion, String remainingVersion) {
	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
		InternetExplorer.class);
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
	    return (InternetExplorer) criteria.add(
		    Restrictions.isNull("remainingVersion")).uniqueResult();
	} else {
	    return (InternetExplorer) criteria.add(
		    Restrictions.eq("remainingVersion", remainingVersion))
		    .uniqueResult();
	}
    }
}