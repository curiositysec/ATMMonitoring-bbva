package com.ncr.ATMMonitoring.dao;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The Class AbstractGenericDAO.
 * 
 * This parameterized class contains the basic methods which will be used by all
 * Daos.
 * 
 * @param <T>
 *            the Pojo the specific Dao will manage
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public abstract class AbstractGenericDAO<T> {

    /** The specific Pojo class. */
    private Class<T> domainClass = getDomainClass();

    /** The session factory. */
    @Autowired
    protected SessionFactory sessionFactory;

    /**
     * Gets the specific Pojo class.
     * 
     * @return the specific Pojo class
     */
    protected Class getDomainClass() {
	if (domainClass == null) {
	    ParameterizedType thisType = (ParameterizedType) getClass()
		    .getGenericSuperclass();
	    domainClass = (Class) thisType.getActualTypeArguments()[0];
	}
	return domainClass;
    }

    /**
     * Saves the Pojo.
     * 
     * @param object
     *            the Pojo to save
     */
    protected void add(T object) {
	sessionFactory.getCurrentSession().save(object);
    }

    /**
     * Deletes the Pojo.
     * 
     * @param object
     *            the Pojo to delete
     */
    protected void delete(T object) {
	sessionFactory.getCurrentSession().delete(object);
    }

    /**
     * Deletes the row with the given id.
     * 
     * @param id
     *            the id to delete
     */
    protected void delete(Integer id) {
	T object = (T) sessionFactory.getCurrentSession().load(
		getDomainClass(), id);
	if (object != null) {
	    delete(object);
	}
    }

    /**
     * Updates the Pojo.
     * 
     * @param object
     *            the Pojo to update
     */
    protected void update(T object) {
	sessionFactory.getCurrentSession().update(
		sessionFactory.getCurrentSession().merge(object));
    }

    /**
     * Lists all the Pojos.
     * 
     * @return the list with all the Pojos
     */
    protected List<T> list() {
	return sessionFactory.getCurrentSession()
		.createCriteria(getDomainClass())
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    /**
     * Gets the Pojo by its id.
     * 
     * @param id
     *            the id which we want to retrieve
     * @return the Pojo with the given id, or null if it doesn't exist
     */
    protected T get(Integer id) {
	if (id != null) {
	    return (T) sessionFactory.getCurrentSession().get(getDomainClass(),
		    id);
	} else {
	    return null;
	}

    }
    
    /**
     * Add restrictions eq or is null to the criteria 
     * @param criteriaValues
     * @param entityClass
     * @return Criteria
     */
    protected Criteria setupCriteriaForEqualComparison(Map<String,Object> criteriaValues, Class entityClass){
	
	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
		entityClass);
	
	this.addRestrictionsEqIsNullToCriteria(criteria, criteriaValues);
	
	return criteria;
    }
    
    
    private void addRestrictionsEqIsNullToCriteria(Criteria criteria, Map<String,Object> criteriaValues ){
	
	for (Map.Entry<String, Object> entry :  criteriaValues.entrySet()){
	    
	    String criteriaKey = entry.getKey();
	    Object criteriaValue = entry.getValue();
	    
	    if(criteriaValue != null){
		criteria.add(Restrictions.eq(criteriaKey,criteriaValue));
		
	    }else{
		
		criteria.add(Restrictions.isNull(criteriaKey));
	    }
	}
    }
    
    protected Map<String,Object> getCriteriaRestrictionForSoftwareEntities(Integer majorVersion, Integer minorVersion, Integer buildVersion,
	    Integer revisionVersion, String remainingVersion, String name){
	Map<String,Object> queryRestrictions = new HashMap<String,Object>();
	queryRestrictions.put("majorVersion", majorVersion);
	queryRestrictions.put("minorVersion", minorVersion);
	queryRestrictions.put("buildVersion", buildVersion);
	queryRestrictions.put("revisionVersion", revisionVersion);
	queryRestrictions.put("remainingVersion", remainingVersion);
	queryRestrictions.put("name", name);
	
	return queryRestrictions;
    }
}
