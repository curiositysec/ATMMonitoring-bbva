package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.UpsQuery;

/**
 * The Interface UpsQueryDAO.
 * 
 * Dao with the operations for managing UpsQuery Pojos.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface UpsQueryDAO {

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
     * Lists all UPS queries.
     * 
     * @return the list
     */
    public List<UpsQuery> listUpsQueries();

    /**
     * Gets the UPS query with the given id.
     * 
     * @param id
     *            the id
     * @return the UPS query, or null if it doesn't exist
     */
    public UpsQuery getUpsQuery(Integer id);

    /**
     * Updates UPS query.
     * 
     * @param upsQuery
     *            the UPS query
     */
    public void updateUpsQuery(UpsQuery upsQuery);
}
