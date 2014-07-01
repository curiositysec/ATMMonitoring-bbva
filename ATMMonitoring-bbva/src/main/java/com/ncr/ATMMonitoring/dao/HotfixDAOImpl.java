package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.Hotfix;

/**
 * The Class HotfixDAOImpl.
 * 
 * Default implementation of HotfixDAO.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class HotfixDAOImpl extends AbstractGenericDAO<Hotfix> implements
	HotfixDAO {

    /** The logger. */
    static private Logger logger = Logger.getLogger(HotfixDAOImpl.class
	    .getName());

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.HotfixDAO#addHotfix(com.ncr.ATMMonitoring.pojo
     * .Hotfix)
     */
    @Override
    public void addHotfix(Hotfix hotfix) {
	add(hotfix);
	logger.debug("Created new Hotfix with id " + hotfix.getId());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.HotfixDAO#listHotfix()
     */
    @Override
    public List<Hotfix> listHotfix() {
	return sessionFactory.getCurrentSession().createCriteria(Hotfix.class)
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
     * @see com.ncr.ATMMonitoring.dao.HotfixDAO#getHotfix(java.lang.Integer)
     */
    @Override
    public Hotfix getHotfix(Integer id) {
	return get(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.HotfixDAO#removeHotfix(java.lang.Integer)
     */
    @Override
    public void removeHotfix(Integer id) {
	delete(id);
    }
}