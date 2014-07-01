package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Hotfix;

/**
 * The Interface HotfixService.
 * 
 * It contains the hotfix related methods.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface HotfixService {

    /**
     * Adds the hotfix.
     * 
     * @param hotfix
     *            the hotfix
     */
    public void addHotfix(Hotfix hotfix);

    /**
     * Removes the hotfix by its id.
     * 
     * @param id
     *            the hotfix id
     */
    public void removeHotfix(Integer id);

    /**
     * Gets the hotfix by its id.
     * 
     * @param id
     *            the hotfix id
     * @return the hotfix
     */
    public Hotfix getHotfix(Integer id);

    /**
     * List hotfix.
     * 
     * @return the hotfix list
     */
    public List<Hotfix> listHotfix();
}