package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.OperatingSystem;

/**
 * The Interface OperatingSystemService.
 * 
 * It contains the operating system related methods.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface OperatingSystemService {

    /**
     * Adds the operating system.
     * 
     * @param operatingSystem
     *            the operating system
     */
    public void addOperatingSystem(OperatingSystem operatingSystem);

    /**
     * Gets the operating system by its id.
     * 
     * @param id
     *            the operating system id
     * @return the operating system
     */
    public OperatingSystem getOperatingSystem(Integer id);

    /**
     * List operating system.
     * 
     * @return the operating system list
     */
    public List<OperatingSystem> listOperatingSystem();
}