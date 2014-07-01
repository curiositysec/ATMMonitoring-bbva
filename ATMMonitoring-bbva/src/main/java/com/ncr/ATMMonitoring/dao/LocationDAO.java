package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Location;

/**
 * The Interface LocationDAO.
 * 
 * Dao with the operations for managing Location Pojos.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface LocationDAO {

    /**
     * Adds the location.
     * 
     * @param location
     *            the location
     */
    public void addLocation(Location location);

    /**
     * Gets the location with the given id.
     * 
     * @param id
     *            the id
     * @return the location, or null if it doesn't exist
     */
    public Location getLocation(Integer id);

    /**
     * Gets the location with the given office code.
     * 
     * @param officeCode
     *            the office code
     * @return the location, or null if it doesn't exist
     */
    public Location getLocationByOfficeCode(String officeCode);

    /**
     * Lists all locations.
     * 
     * @return the list
     */
    public List<Location> listLocations();

    /**
     * Updates location.
     * 
     * @param location
     *            the location
     */
    public void updateLocation(Location location);

    /**
     * Removes the location with the given id.
     * 
     * @param id
     *            the id
     */
    public void removeLocation(Integer id);

    /**
     * Search locations.
     * 
     * @param field
     *            the field we want to search by
     * @param terms
     *            the terms we want to search by
     * 
     * @return the list of locations that match the terms for the field
     */
    public List<Location> searchLocations(String field, String[] terms);
}
