package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.InternetExplorer;

/**
 * The Interface InternetExplorerDAO.
 * 
 * Dao with the operations for managing InternetExplorer Pojos.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface InternetExplorerDAO {

    /**
     * Adds the internet explorer.
     * 
     * @param internetExplorer
     *            the internet explorer
     */
    public void addInternetExplorer(InternetExplorer internetExplorer);

    /**
     * Lists all internet explorers.
     * 
     * @return the list
     */
    public List<InternetExplorer> listInternetExplorer();

    /**
     * Gets the internet explorer with the given id.
     * 
     * @param id
     *            the id
     * @return the internet explorer, or null if it doesn't exist
     */
    public InternetExplorer getInternetExplorer(Integer id);

    /**
     * Removes the internet explorer with the given id.
     * 
     * @param id
     *            the id
     */
    public void removeInternetExplorer(Integer id);

    /**
     * Gets the internet explorer by version.
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
     * @return the internet explorer by version, or null if it doesn't exist
     */
    public InternetExplorer getInternetExplorerByVersion(Integer majorVersion,
	    Integer minorVersion, Integer buildVersion,
	    Integer revisionVersion, String remainingVersion);
}
