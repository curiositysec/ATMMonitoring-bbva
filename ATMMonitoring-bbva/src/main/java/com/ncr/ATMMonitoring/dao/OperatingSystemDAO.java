package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.OperatingSystem;

/**
 * The Interface OperatingSystemDAO.
 * 
 * Dao with the operations for managing OperatingSystem Pojos.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface OperatingSystemDAO {

    /**
     * Adds the operating system.
     * 
     * @param operatingSystem
     *            the operating system
     */
    public void addOperatingSystem(OperatingSystem operatingSystem);

    /**
     * Lists all operating systems.
     * 
     * @return the list
     */
    public List<OperatingSystem> listOperatingSystem();

    /**
     * Gets the operating system with the given id.
     * 
     * @param id
     *            the id
     * @return the operating system, or null if it doesn't exist
     */
    public OperatingSystem getOperatingSystem(Integer id);
}
