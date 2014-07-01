package com.ncr.ATMMonitoring.service;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.ATMMonitoring.pojo.Ups;
import com.ncr.ATMMonitoring.pojo.UpsQuery;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.utils.WidgetQueryAssociationType;

//TODO: Auto-generated Javadoc
/**
 * The Interface QueryService.
 * 
 * It contains the query related methods.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface QueryService {

    /**
     * Adds the query.
     * 
     * @param query
     *            the query
     */
    public void addQuery(Query query);

    /**
     * Delete query.
     * 
     * @param query
     *            the query
     */
    public void deleteQuery(Query query);

    /**
     * Gets the query by its id.
     * 
     * @param id
     *            the query id
     * @return the query
     */
    public Query getQuery(Integer id);

    /**
     * Update query.
     * 
     * @param query
     *            the query
     */
    public void updateQuery(Query query);

    /**
     * Execute query.
     * 
     * @param query
     *            the query
     * @param locale
     *            the locale
     * @param sort
     *            the fields for sorting terminals
     * @param order
     *            the order for sorting terminals
     * @param queryDate
     *            date for query to auditable elements
     * @return the terminal list
     */
    public List<Terminal> executeQuery(Query query, Locale locale, String sort,
	    String order, Date queryDate);

    /**
     * Execute query.
     * 
     * @param query
     *            the query
     * @param locale
     *            the locale
     * @param sort
     *            the fields for sorting terminals
     * @param order
     *            the order for sorting terminals
     * @return the terminal list
     */
    public List<Terminal> executeQuery(Query query, Locale locale, String sort,
	    String order);

    /**
     * Execute query.
     * 
     * @param query
     *            the query
     * @param locale
     *            the locale
     * @return the terminal list
     */
    public List<Terminal> executeQuery(Query query, Locale locale);

    /**
     * Execute query.
     * 
     * @param query
     *            the query
     * @return the terminal list
     */
    public List<Terminal> executeQuery(Query query);

    /**
     * List queries.
     * 
     * @return the query list
     */
    public List<Query> listQueries();

    /**
     * Find or create query.
     * 
     * @param query
     *            the query
     * @return the query
     */
    public Query findOrCreateQuery(Query query);

    /**
     * Execute query grouping by.
     * 
     * @param query
     *            the query
     * @param groupByEntity
     *            the group by entity
     * @param groupBy
     *            the group by
     * @param locale
     *            the locale
     * @return the query list
     */
    public List<?> executeQueryGroupingBy(Query query,
	    WidgetQueryAssociationType groupByEntity, String groupBy,
	    Locale locale, Date queryDate);

    /**
     * Returns the queries associated to one user<br>
     * First search for a user from the given username, then extract the queries
     * associated
     * 
     * @param username
     *            String
     * @return Set<Query>
     */
    Set<Query> getQueriesByUser(String username);

    /***
     * Returns the queries associated to one user<br>
     * Extract the queries associated to the User object
     * 
     * @param user
     *            user
     * @return Set<Query>
     */
    Set<Query> getQueriesByUser(User user);

    /**
     * Return true if the given query belong to the user
     * 
     * @param query
     *            {@link Query}
     * @param username
     *            String
     * @return boolean
     */
    boolean queryBelongToUser(Query query, String username);

    /**
     * Adds the query. and linkit to the given user
     * 
     * @param query
     *            the query
     * @param username
     *            String The user
     */
    void addQuery(Query query, String username);

    /**
     * Update query. if the query does not have a owner or username param is
     * different from the set in the Query object sets the new value to the
     * Query object and perform the update
     * 
     * @param query
     *            the query
     * @param username
     *            String The user
     */
    public void updateQuery(Query query, String username);

    /**
     * Adds the UPS query.
     * 
     * @param upsQuery
     *            the UPS query
     */
    public void addUpsQuery(UpsQuery upsQuery);

    /**
     * Delete UPS query.
     * 
     * @param upsQuery
     *            the UPS query
     */
    public void deleteUpsQuery(UpsQuery upsQuery);

    /**
     * Gets the UPS query by its id.
     * 
     * @param id
     *            the UPS query id
     * @return the UPS query
     */
    public UpsQuery getUpsQuery(Integer id);

    /**
     * Update UPS query.
     * 
     * @param upsQuery
     *            the UPS query
     */
    public void updateUpsQuery(UpsQuery upsQuery);

    /**
     * Returns the UPS queries associated to one user<br>
     * First search for a user from the given username, then extract the UPS
     * queries associated
     * 
     * @param username
     *            String
     * @return Set<UpsQuery>
     */
    Set<UpsQuery> getUpsQueriesByUser(String username);

    /***
     * Returns the UPS queries associated to one user<br>
     * Extract the UPS queries associated to the User object
     * 
     * @param user
     *            user
     * @return Set<UpsQuery>
     */
    Set<UpsQuery> getUpsQueriesByUser(User user);

    /**
     * Return true if the given UPS query belongs to the user
     * 
     * @param upsQuery
     *            {@link UpsQuery}
     * @param username
     *            String
     * @return boolean
     */
    boolean upsQueryBelongToUser(UpsQuery upsQuery, String username);

    /**
     * Adds the UPS query and links it to the given user
     * 
     * @param upsQuery
     *            the UPS query
     * @param username
     *            String The user
     */
    void addUpsQuery(UpsQuery upsQuery, String username);

    /**
     * Update UPS query. If the query does not have a owner or username param is
     * different from the set in the Query object sets the new value to the
     * Query object and perform the update
     * 
     * @param upsQuery
     *            the UPS query
     * @param username
     *            String The user
     */
    public void updateUpsQuery(UpsQuery upsQuery, String username);

    /**
     * Execute UPS query.
     * 
     * @param upsQuery
     *            the UPS query
     * @param locale
     *            the locale
     * @param sort
     *            the fields for sorting terminals
     * @param order
     *            the order for sorting terminals
     * @return the terminal list
     */
    public List<Ups> executeUpsQuery(UpsQuery upsQuery, Locale locale,
	    String sort, String order);

    /**
     * Execute UPS query.
     * 
     * @param upsQuery
     *            the UPS query
     * @param locale
     *            the locale
     * @return the terminal list
     */
    public List<Ups> executeUpsQuery(UpsQuery upsQuery, Locale locale);

    /**
     * Execute UPS query.
     * 
     * @param upsQuery
     *            the UPS query
     * @return the terminal list
     */
    public List<Ups> executeUpsQuery(UpsQuery upsQuery);

    /**
     * List UPS queries.
     * 
     * @return the query list
     */
    public List<UpsQuery> listUpsQueries();

    /**
     * Find or create UPS query.
     * 
     * @param upsQuery
     *            the UPS query
     * @return the upsQuery
     */
    public UpsQuery findOrCreateUpsQuery(UpsQuery upsQuery);

}
