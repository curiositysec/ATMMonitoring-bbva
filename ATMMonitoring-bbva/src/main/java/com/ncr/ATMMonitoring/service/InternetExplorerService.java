package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.InternetExplorer;

/**
 * The Interface InternetExplorerService.
 * 
 * It contains the Internet Explorer related methods.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface InternetExplorerService {

    /**
     * Adds the internet explorer.
     * 
     * @param internetExplorer
     *            the internet explorer
     */
    public void addInternetExplorer(InternetExplorer internetExplorer);

    /**
     * Removes the internet explorer by its id.
     * 
     * @param id
     *            the internet explorer id
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
     * @return the internet explorer by version
     */
    public InternetExplorer getInternetExplorerByVersion(Integer majorVersion,
	    Integer minorVersion, Integer buildVersion,
	    Integer revisionVersion, String remainingVersion);

    /**
     * Gets the internet explorer by its id.
     * 
     * @param id
     *            the internet explorer id
     * @return the internet explorer
     */
    public InternetExplorer getInternetExplorer(Integer id);

    /**
     * List internet explorer.
     * 
     * @return the internet explorer list
     */
    public List<InternetExplorer> listInternetExplorer();
}