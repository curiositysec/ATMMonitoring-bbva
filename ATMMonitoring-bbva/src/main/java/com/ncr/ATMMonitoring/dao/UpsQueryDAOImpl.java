package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.UpsQuery;

/**
 * The Class UpsQueryDAOImpl.
 * 
 * Default implementation of UpsQueryDAO.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class UpsQueryDAOImpl extends AbstractGenericDAO<UpsQuery> implements
	UpsQueryDAO {

    /** The logger. */
    static private Logger logger = Logger.getLogger(UpsQueryDAOImpl.class
	    .getName());

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.UpsQueryDAO#addUpsQuery(com.ncr.ATMMonitoring
     * .pojo.UpsQuery)
     */
    @Override
    public void addUpsQuery(UpsQuery upsQuery) {
	add(upsQuery);
	logger.debug("Created new UpsQuery with id " + upsQuery.getId());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.UpsQueryDAO#deleteUpsQuery(com.ncr.ATMMonitoring
     * .pojo.UpsQuery)
     */
    @Override
    public void deleteUpsQuery(UpsQuery upsQuery) {
	delete(upsQuery);
	logger.debug("Deleted UpsQuery with id " + upsQuery.getId());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.UpsQueryDAO#updateUpsQuery(com.ncr.ATMMonitoring
     * .pojo.UpsQuery)
     */
    @Override
    public void updateUpsQuery(UpsQuery upsQuery) {
	update(upsQuery);
	logger.debug("Updated UpsQuery with id " + upsQuery.getId());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.UpsQueryDAO#listUpsQueries()
     */
    @Override
    public List<UpsQuery> listUpsQueries() {
	return sessionFactory.getCurrentSession().createCriteria(Query.class)
		.addOrder(Order.asc("name"))
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.UpsQueryDAO#getUpsQuery(java.lang.Integer)
     */
    @Override
    public UpsQuery getUpsQuery(Integer id) {
	return get(id);
    }
}
