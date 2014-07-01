package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Installation;

/**
 * The Interface InstallationService.
 * 
 * It contains the installation related methods.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface InstallationService {

    /**
     * Adds the installation.
     * 
     * @param installation
     *            the installation
     */
    public void addInstallation(Installation installation);

    /**
     * Gets the installation by its id.
     * 
     * @param id
     *            the installation id
     * @return the installation
     */
    public Installation getInstallation(Integer id);

    /**
     * List installations.
     * 
     * @return the installation list
     */
    public List<Installation> listInstallations();

    /**
     * Update installation.
     * 
     * @param installation
     *            the installation
     */
    public void updateInstallation(Installation installation);

    /**
     * Removes the installation by its id.
     * 
     * @param id
     *            the installation id
     */
    public void removeInstallation(Integer id);
}