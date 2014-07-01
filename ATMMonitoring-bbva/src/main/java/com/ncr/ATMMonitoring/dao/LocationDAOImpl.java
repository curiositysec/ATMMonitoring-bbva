package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.Location;

/**
 * The Class LocationDAOImpl.
 * 
 * Default implementation of LocationDAO.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class LocationDAOImpl extends AbstractGenericDAO<Location> implements
	LocationDAO {

    /** The logger. */
    static private Logger logger = Logger.getLogger(LocationDAOImpl.class
	    .getName());

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.LocationDAO#addLocation(com.ncr.ATMMonitoring
     * .pojo.Location)
     */
    @Override
    public void addLocation(Location location) {
	sessionFactory.getCurrentSession().save(location);
	logger.info("Created new Location with id " + location.getId());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.LocationDAO#getLocation(java.lang.Integer)
     */
    @Override
    public Location getLocation(Integer id) {
	return get(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.LocationDAO#listLocations()
     */
    @Override
    public List<Location> listLocations() {
	return list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.LocationDAO#updateLocation(com.ncr.ATMMonitoring
     * .pojo.Location)
     */
    @Override
    public void updateLocation(Location location) {
	update(location);
	logger.info("Updated Location with id " + location.getId());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.LocationDAO#removeLocation(java.lang.Integer)
     */
    @Override
    public void removeLocation(Integer id) {
	delete(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.LocationDAO#getLocationByOfficeCode(java.lang
     * .String)
     */
    @Override
    public Location getLocationByOfficeCode(String officeCode) {
	return (Location) sessionFactory.getCurrentSession()
		.createCriteria(Location.class)
		.add(Restrictions.eq("officeCode", officeCode)).uniqueResult();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.LocationDAO#searchLocations(java.lang
     * .String, java.lang.String[])
     */
    @Override
    public List<Location> searchLocations(String field, String[] terms) {
	Criteria query = sessionFactory.getCurrentSession().createCriteria(
		getDomainClass());
	for (String term : terms) {
	    logger.debug("Term: '" + term + "'");
	    query.add(Restrictions.ilike(field, "%" + term + "%"));
	}
	return query.addOrder(Order.asc(field)).setMaxResults(100)
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
}