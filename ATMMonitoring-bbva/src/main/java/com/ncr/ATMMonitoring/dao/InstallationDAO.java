package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Installation;

/**
 * The Interface InstallationDAO.
 * 
 * Dao with the operations for managing Installation Pojos.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface InstallationDAO {

    /**
     * Adds the installation.
     * 
     * @param installation
     *            the installation
     */
    public void addInstallation(Installation installation);

    /**
     * Gets the installation with the given id.
     * 
     * @param id
     *            the id
     * @return the installation, or null if it doesn't exist
     */
    public Installation getInstallation(Integer id);

    /**
     * Lists all installations.
     * 
     * @return the list
     */
    public List<Installation> listInstallations();

    /**
     * Updates installation.
     * 
     * @param installation
     *            the installation
     */
    public void updateInstallation(Installation installation);

    /**
     * Removes the installation with the given id.
     * 
     * @param id
     *            the id
     */
    public void removeInstallation(Integer id);
}
