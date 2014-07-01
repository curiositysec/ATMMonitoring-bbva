package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.SoftwareAggregate;

/**
 * The Interface SoftwareAggregateDAO.
 * 
 * Dao with the operations for managing SoftwareAggregate Pojos.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface SoftwareAggregateDAO {

    /**
     * Adds the software aggregate.
     * 
     * @param softwareAggregate
     *            the software aggregate
     */
    public void addSoftwareAggregate(SoftwareAggregate softwareAggregate);

    /**
     * Lists all software aggregates.
     * 
     * @return the list
     */
    public List<SoftwareAggregate> listSoftwareAggregate();

    /**
     * Gets the software aggregate with the given id.
     * 
     * @param id
     *            the id
     * @return the software aggregate, or null if it doesn't exist
     */
    public SoftwareAggregate getSoftwareAggregate(Integer id);

    /**
     * Gets the software aggregate by version and name.
     * 
     * @param majorVersion
     *            the major version
     * @param minorVersion
     *            the minor version
     * @param buildVersion
     *            the build version
     * @param revisionVersion
     *            the revision version
     * @param remainingVersion
     *            the remaining version
     * @param name
     *            the name
     * @return the software aggregate by version and name, or null if it doesn't
     *         exist
     */
    public SoftwareAggregate getSoftwareAggregateByVersionName(
	    Integer majorVersion, Integer minorVersion, Integer buildVersion,
	    Integer revisionVersion, String remainingVersion, String name);

    /**
     * Removes the software aggregate with the given id.
     * 
     * @param id
     *            the id
     */
    public void removeSoftwareAggregate(Integer id);
}
