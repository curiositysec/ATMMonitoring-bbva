package com.ncr.ATMMonitoring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.DashboardDAO;

import com.ncr.ATMMonitoring.pojo.Dashboard;
import com.ncr.ATMMonitoring.pojo.User;

// TODO: Auto-generated Javadoc
/**
 * The Class DashboardServiceImpl.
 * 
 * Default implementation of the DashboardService.
 * 
 * @author Rafael Luque (rafael.luque@osoco.es)
 */

@Service("dashboardService")
@Transactional
public class DashboardServiceImpl implements DashboardService {

    /** The widget service. */
    @Autowired
    private WidgetService widgetService;

    /** The user service. */
    @Autowired
    private UserService userService;

    /** The dashboard dao. */
    @Autowired
    private DashboardDAO dashboardDAO;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.DashboardService#findDashboardByUser(com
     * .ncr.ATMMonitoring.pojo.User)
     */
    @Override
    public Dashboard findDashboardByUser(User user) {
	return (user != null) ? user.getDashboard() : null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.DashboardService#findOrCreateDashboardByUser
     * (com.ncr.ATMMonitoring.pojo.User)
     */
    @Override
    public Dashboard findOrCreateDashboardByUser(User user) {
	Dashboard aDashboard = findDashboardByUser(user);
	if (aDashboard == null) {
	    aDashboard = createDefaultDashboardForUser(user);
	}
	return aDashboard;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.DashboardService#createDefaultDashboardForUser
     * (com.ncr.ATMMonitoring.pojo.User)
     */
    @Override
    public Dashboard createDefaultDashboardForUser(User user) {
	Dashboard aDashboard = new Dashboard();
	aDashboard.setColumns(4); // TODO: retrieve value from config
	saveDashboard(aDashboard);
	user.setDashboard(aDashboard);
	widgetService.copyDefaultWidgetsToUserDashboard(user);
	userService.updateUser(user);
	return aDashboard;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.DashboardService#saveDashboard(com.ncr.
     * ATMMonitoring.pojo.Dashboard)
     */
    @Override
    public void saveDashboard(Dashboard dashboard) {
	dashboardDAO.save(dashboard);
    }

}
