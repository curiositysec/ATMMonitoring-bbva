package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Software;

/**
 * The Interface SoftwareDAO.
 * 
 * Dao with the operations for managing Software Pojos.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface SoftwareDAO {

    /**
     * Adds the software.
     * 
     * @param software
     *            the software
     */
    public void addSoftware(Software software);

    /**
     * Lists all software.
     * 
     * @return the list
     */
    public List<Software> listSoftware();

    /**
     * Gets the software with the given id.
     * 
     * @param id
     *            the id
     * @return the software, or null if it doesn't exist
     */
    public Software getSoftware(Integer id);

    /**
     * Gets the software by identifying number.
     * 
     * @param id
     *            the id
     * @return the software by identifying number, or null if it doesn't exist
     */
    public Software getSoftwareByIdentifyingNumber(String id);
}
