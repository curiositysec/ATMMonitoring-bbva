package com.ncr.ATMMonitoring.service;

import com.ncr.ATMMonitoring.pojo.Dashboard;
import com.ncr.ATMMonitoring.pojo.User;

/**
 * The Interface DashboardService.
 * 
 * It contains the dashboard related methods.
 * 
 * @author Rafael Luque (rafael.luque@osoco.es)
 */
public interface DashboardService {

    /**
     * Find dashboard by user.
     * 
     * @param user
     *            the user
     * @return the dashboard
     */
    public Dashboard findDashboardByUser(User user);

    /**
     * Find or create dashboard by user.
     * 
     * @param user
     *            the user
     * @return the dashboard
     */
    public Dashboard findOrCreateDashboardByUser(User user);

    /**
     * Creates the default dashboard for user.
     * 
     * @param user
     *            the user
     * @return the dashboard
     */
    public Dashboard createDefaultDashboardForUser(User user);

    /**
     * Save dashboard.
     * 
     * @param dashboard
     *            the dashboard
     */
    public void saveDashboard(Dashboard dashboard);

}
