package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Query;

/**
 * The Interface QueryDAO.
 * 
 * Dao with the operations for managing Query Pojos.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface QueryDAO {

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
     * Lists all queries.
     * 
     * @return the list
     */
    public List<Query> listQueries();

    /**
     * Gets the query with the given id.
     * 
     * @param id
     *            the id
     * @return the query, or null if it doesn't exist
     */
    public Query getQuery(Integer id);

    /**
     * Updates query.
     * 
     * @param query
     *            the query
     */
    public void updateQuery(Query query);
}
