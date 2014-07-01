package com.ncr.ATMMonitoring.service;

import java.io.InputStream;
import java.util.List;

import com.ncr.ATMMonitoring.pojo.Location;

/**
 * The Interface LocationService.
 * 
 * It contains the location related methods.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface LocationService {

    /**
     * Adds the location.
     * 
     * @param location
     *            the location
     */
    public void addLocation(Location location);

    /**
     * Gets the location by its id.
     * 
     * @param id
     *            the location id
     * @return the location
     */
    public Location getLocation(Integer id);

    /**
     * Gets the location by its office code.
     * 
     * @param officeCode
     *            the location office code
     * @return the location
     */
    public Location getLocationByOfficeCode(String officeCode);

    /**
     * List locations.
     * 
     * @return the location list
     */
    public List<Location> listLocations();

    /**
     * Update location.
     * 
     * @param location
     *            the location
     */
    public void updateLocation(Location location);

    /**
     * Removes the location by its id.
     * 
     * @param id
     *            the location id
     */
    public void removeLocation(Integer id);

    /**
     * Parses the txt file, extracts the information and stores it in the
     * database. Returns true if the file was successfully processed by the
     * parser
     * 
     * @param txtFile
     *            String with a valid file path
     * @return true if the file was parsed, false otherwise
     */
    public boolean storeOfficesInfo(InputStream txtFile);

    /**
     * Search locations by address.
     * 
     * @param field
     *            the field we want to search by
     * @param term
     *            the term we want to search by
     * 
     * @return the list of locations that match the terms
     */
    public List<Location> searchLocations(String field, String term);

}