package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.ncr.ATMMonitoring.pojo.Dashboard;
import com.ncr.ATMMonitoring.pojo.Widget;
import com.ncr.ATMMonitoring.servicefacade.DashboardWidgetFacade;

/**
 * Controller for Dashboard related actions.
 * 
 * @author Rafael Luque (rafael.luque@osoco.es)
 */
@Controller
public class DashboardController extends GenericController {

    /** The logger. */
    static private Logger logger = Logger.getLogger(DashboardController.class
	    .getName());

    public static final String SESSION_KEY_WIDGET_LIST = "widgets";

    public static final String SESSION_KEY_DASHBOARD = "userDashboard";

    @Autowired
    private DashboardWidgetFacade dashboardWidgets;

    /**
     * Show dashboard.
     * 
     * @param map
     *            the map
     * @param principal
     *            the principal
     * @param request
     *            the request
     * @return the string
     */
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String showDashboard(Map<String, Object> map, Principal principal,
	    HttpServletRequest request) {
	String userMsg = "";
	Dashboard dashboard = null;
	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	    dashboard = (Dashboard) request.getSession().getAttribute(
		    SESSION_KEY_DASHBOARD);
	    logger.debug("Dasboard loaded from session: " + dashboard);
	    if (dashboard == null) {

		dashboard = this.dashboardWidgets.getDashboard(principal
			.getName());
		request.getSession().setAttribute(SESSION_KEY_DASHBOARD,
			dashboard);
	    }

	}

	map.put("userMsg", userMsg);
	map.put("dashboard", dashboard);
	map.put("columnOptions", Dashboard.ColumnOptions.values());
	return "dashboard";
    }

    /**
     * Show dashboard chart.
     * 
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the map
     */
    @RequestMapping(method = RequestMethod.GET, value = "/dashboard/charts")
    @ResponseBody
    public Map showDashboardChart(HttpServletRequest request,
	    Principal principal) {
	Map result = null;
	if (principal != null) {
	    @SuppressWarnings("unchecked")
	    Map<String, List<Widget>> allWidgets = (Map<String, List<Widget>>) request
		    .getSession().getAttribute(SESSION_KEY_WIDGET_LIST);
	    logger.debug("Widget list loaded from session: " + allWidgets);

	    if (allWidgets == null) {

		allWidgets = this.dashboardWidgets
			.getVisiblesAndInvisiblesWidgets(principal.getName());

		request.getSession().setAttribute(SESSION_KEY_WIDGET_LIST,
			allWidgets);
	    }

	    List<Widget> visibleWidgets = allWidgets
		    .get(DashboardWidgetFacade.VISIBLE_WIDGETS);
	    List<Widget> hiddenWidgets = allWidgets
		    .get(DashboardWidgetFacade.INVISIBLE_WIDGETS);

	    result = new HashMap();
	    result.put("visibleCharts", toJSON(visibleWidgets));
	    result.put("hiddenCharts", toJSON(hiddenWidgets));
	}
	return result;
    }

    /**
     * Show dashboard chart.
     * 
     * @param widgetId
     *            the widget id
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the map
     */
    @RequestMapping(method = RequestMethod.GET, value = "/dashboard/chart", params = "widgetId")
    @ResponseBody
    public Map showDashboardChart(@RequestParam int widgetId,
	    HttpServletRequest request, Principal principal) {
	Map result = null;
	if (principal != null) {
	    try {
		Locale locale = RequestContextUtils.getLocale(request);
		List<?> queryResults = this.dashboardWidgets
			.executeQueryForWidget(principal.getName(), widgetId,
				locale);
		result = toGoogleChartJSON(queryResults);

	    } catch (Exception e) {
		logger.error("An error occurs", e);
	    }
	}

	return result;
    }

    /**
     * Update chart position.
     * 
     * @param widgetId
     *            the widget id
     * @param oldPosition
     *            the old position
     * @param newPosition
     *            the new position
     * @param request
     *            the request
     * @param principal
     *            the principal
     */
    @RequestMapping(method = RequestMethod.POST, value = "/dashboard/updateChartPosition")
    @ResponseStatus(HttpStatus.OK)
    public void updateChartPosition(@RequestParam("widgetId") int widgetId,
	    @RequestParam("oldPosition") int oldPosition,
	    @RequestParam("newPosition") int newPosition,
	    HttpServletRequest request, Principal principal) {
	if ((principal != null) && (oldPosition != newPosition)) {
	    this.dashboardWidgets.updateWidgetPosition(principal.getName(),
		    widgetId, oldPosition, newPosition);
	}
    }

    /**
     * Hide chart.
     * 
     * @param widgetId
     *            the widget id
     * @param request
     *            the request
     * @param principal
     *            the principal
     */
    @RequestMapping(method = RequestMethod.POST, value = "/dashboard/hideChart")
    @ResponseStatus(HttpStatus.OK)
    public void hideChart(@RequestParam("widgetId") int widgetId,
	    HttpServletRequest request, Principal principal) {
	if (principal != null) {
	    this.dashboardWidgets.hideShowWidget(widgetId, principal.getName(),
		    DashboardWidgetFacade.HIDE);
	    this.clearSession(request, SESSION_KEY_WIDGET_LIST);

	}
    }

    /**
     * Show chart.
     * 
     * @param widgetId
     *            the widget id
     * @param request
     *            the request
     * @param principal
     *            the principal
     */
    @RequestMapping(method = RequestMethod.POST, value = "/dashboard/showChart")
    @ResponseStatus(HttpStatus.OK)
    public void showChart(@RequestParam("widgetId") int widgetId,
	    HttpServletRequest request, Principal principal) {
	if (principal != null) {
	    this.dashboardWidgets.hideShowWidget(widgetId, principal.getName(),
		    DashboardWidgetFacade.VISIBLE);
	    this.clearSession(request, SESSION_KEY_WIDGET_LIST);

	}
    }

    /**
     * Change columns.
     * 
     * @param columns
     *            the columns
     * @param request
     *            the request
     * @param principal
     *            the principal
     */
    @RequestMapping(method = RequestMethod.POST, value = "/dashboard/changeColumns")
    @ResponseStatus(HttpStatus.OK)
    public void changeColumns(@RequestParam("columns") int columns,
	    HttpServletRequest request, Principal principal) {
	if (principal != null) {
	    this.dashboardWidgets.changeDashboardColumms(principal.getName(),
		    columns);
	    this.clearSession(request, SESSION_KEY_DASHBOARD);
	}
    }

    /**
     * Show new widget form
     * 
     * @return the petition response
     */
    @RequestMapping(method = RequestMethod.GET, value = "/dashboard/newWidget")
    public String newWidget(HttpServletRequest request) {
	this.clearSession(request, DashboardController.SESSION_KEY_WIDGET_LIST);
	return "widget/newWidget";
    }

    // Private Methods
    // ----------------------------------------------------------------------

    /**
     * Converts query results to google chart json.
     * 
     * @param queryResults
     *            the query results
     * @return the map with the json data
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private Map<String, List> toGoogleChartJSON(List queryResults) {
	logger.debug("Converting query results [" + queryResults
		+ "] into Google Charts JSON...");
	Map<String, List> result = new HashMap<String, List>();

	List columns = new ArrayList();
	Map column1 = new HashMap();
	column1.put("label", "Terminals");
	column1.put("type", "string");

	Map column2 = new HashMap();
	column2.put("label", "Count");
	column2.put("type", "number");

	columns.add(column1);
	columns.add(column2);

	List rows = new ArrayList(queryResults.size());

	for (int i = 0; i < queryResults.size(); i++) {
	    Object label = ((Map) queryResults.get(i)).get("groupName");
	    label = (label == null || label.equals("")) ? "Desconocido" : label;
	    Long value = (Long) ((Map) queryResults.get(i)).get("count");
	    logger.debug(label + " -> " + value);

	    Map row = new HashMap();
	    List cells = new ArrayList();
	    Map cell1 = new HashMap();
	    cell1.put("v", label);

	    Map cell2 = new HashMap();
	    cell2.put("v", value);

	    cells.add(cell1);
	    cells.add(cell2);

	    row.put("c", cells);
	    rows.add(row);
	}

	result.put("cols", columns);
	result.put("rows", rows);

	return result;
    }

    /**
     * Converts widgets to json.
     * 
     * @param widgets
     *            the widgets
     * @return the list with the widgets' jsons
     */
    private List<Map> toJSON(List<Widget> widgets) {
	List<Map> result = new ArrayList<Map>(widgets.size());
	for (Widget widget : widgets) {
	    result.add(widget.toJSON());
	}
	return result;
    }

}
