package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.Ups;

/**
 * The Class UpsDAOImpl.
 * 
 * Default implementation of UpsDAO.
 * 
 * @author Otto Abreu
 * 
 */
@Repository
public class UpsDAOImpl extends AbstractGenericDAO<Ups> implements UpsDAO {

    /** The logger. */
    private static final Logger logger = Logger.getLogger(UpsDAOImpl.class);

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.UpsDAO#getUps(int)
     */
    @Override
    public Ups getUps(int id) {
	return this.get(id);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.UpsDAO#getUpsBySerialNumber(java.lang.String)
     */
    @Override
    public Ups getUpsBySerialNumber(String seriesNumber) {

	// Ups ups = null;
	logger.debug("series number: " + seriesNumber);
	Ups ups = this.getOnlyOneResultFromList(Restrictions.eq("seriesNumber",
		seriesNumber));

	return ups;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.UpsDAO#removeUps(int)
     */
    @Override
    public void removeUps(int id) {
	this.delete(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.UpsDAO#updateUps(com.ncr.ATMMonitoring.pojo
     * .Ups)
     */
    @Override
    public void updateUps(Ups ups) {
	this.update(ups);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.UpsDAO#listAllUps()
     */
    @Override
    public List<Ups> listAllUps() {
	return listUps("seriesNumber", "asc");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.UpsDAO#addUps(com.ncr.ATMMonitoring.pojo.Ups)
     */
    @Override
    public void addUps(Ups ups) {
	this.add(ups);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.UpsDAO#getUpsBySerialNumberAndModel(java.lang
     * .String, java.lang.String)
     */
    @Override
    public Ups getUpsBySerialNumberAndModel(String seriesNumber, String model) {

	logger.debug("Get UPS by series number: " + seriesNumber + " model: "
		+ model);
	Ups ups = this.getOnlyOneResultFromList(Restrictions.and(
		Restrictions.eq("seriesNumber", seriesNumber),
		Restrictions.eq("model", model)));
	return ups;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.UpsDAO#listUps(java.lang.String,
     * java.lang.String)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Ups> listUps(String sort, String order) {
	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
		Ups.class);
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

    /**
     * Returns the ups that matches the given criterions. To add a criterion
     * please use {@link Restrictions} or another class that implement
     * {@link Criterion}
     * 
     * @param criterions
     *            {@link Criterion}
     * @return List<Ups>
     */
    @SuppressWarnings("unchecked")
    private List<Ups> listUps(Criterion... criterions) {
	Criteria crit = sessionFactory.getCurrentSession().createCriteria(
		Ups.class);
	for (Criterion rest : criterions) {
	    crit.add(rest);
	}
	return (List<Ups>) crit.list();
    }

    /**
     * Executes the method {@link UpsDAO#listUps(Criterion...)} applying the
     * given Criterion for fetching only one result
     * 
     * @param criteria
     *            Criterion
     * @return Ups
     */
    private Ups getOnlyOneResultFromList(Criterion criteria) {
	Ups ups = null;

	List<Ups> fetch = this.listUps(criteria);
	if (fetch != null && !fetch.isEmpty()) {

	    ups = fetch.get(0);

	}

	return ups;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.UpsDAO#getUpsByHQL(java.util.List,
     * java.util.List, java.lang.String)
     */
    @Override
    public List<Ups> getUpsByHQL(List<Object> values, List<Type> types,
	    String hql) {
	return getUpsByHQL(values, types, hql, null, null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.UpsDAO#getUpsByHQL(java.util.List,
     * java.util.List, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public List<Ups> getUpsByHQL(List<Object> values, List<Type> types,
	    String hql, String sort, String order) {
	if (sort != null) {
	    hql += " order by ups." + sort;
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
}
