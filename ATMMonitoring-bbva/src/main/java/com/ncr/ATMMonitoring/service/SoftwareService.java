package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Software;

/**
 * The Interface SoftwareService.
 * 
 * It contains the software related methods.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface SoftwareService {

    /**
     * Adds the software.
     * 
     * @param software
     *            the software
     */
    public void addSoftware(Software software);

    /**
     * Gets the software by its id.
     * 
     * @param id
     *            the software id
     * @return the software
     */
    public Software getSoftware(Integer id);

    /**
     * List software.
     * 
     * @return the software list
     */
    public List<Software> listSoftware();
}