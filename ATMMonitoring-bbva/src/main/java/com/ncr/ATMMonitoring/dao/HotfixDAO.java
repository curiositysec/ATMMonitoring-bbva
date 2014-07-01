package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Hotfix;

/**
 * The Interface HotfixDAO.
 * 
 * Dao with the operations for managing Hotfix Pojos.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface HotfixDAO {

    /**
     * Adds the hotfix.
     * 
     * @param hotfix
     *            the hotfix
     */
    public void addHotfix(Hotfix hotfix);

    /**
     * Lists all hotfixes.
     * 
     * @return the list
     */
    public List<Hotfix> listHotfix();

    /**
     * Gets the hotfix with the given id.
     * 
     * @param id
     *            the id
     * @return the hotfix, or null if it doesn't exist
     */
    public Hotfix getHotfix(Integer id);

    /**
     * Removes the hotfix with the given id.
     * 
     * @param id
     *            the id
     */
    public void removeHotfix(Integer id);
}
