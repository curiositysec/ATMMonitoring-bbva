package com.ncr.ATMMonitoring.dao;

import com.ncr.ATMMonitoring.pojo.Dashboard;

/**
 * The Interface DashboardDAO.
 * 
 * Dao with the operations for managing Dashboard Pojos.
 * 
 * @author Rafael Luque (rafael.luque@osoco.es)
 */

public interface DashboardDAO {

    /**
     * Adds the Dashboard.
     * 
     * @param dashboard
     *            the dashboard
     */
    public void save(Dashboard dashboard);

}
