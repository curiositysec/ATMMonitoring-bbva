package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ncr.ATMMonitoring.controller.propertyeditor.DatePropertyEditor;
import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.Widget;
import com.ncr.ATMMonitoring.pojo.WidgetCategory;
import com.ncr.ATMMonitoring.service.QueryService;
import com.ncr.ATMMonitoring.servicefacade.DashboardWidgetFacade;
import com.ncr.ATMMonitoring.utils.RegionType;
import com.ncr.ATMMonitoring.utils.WidgetQueryAssociationType;

/**
 * Controller for Widget related actions.
 * 
 * @author jmartin
 * 
 */
@Controller
public class WidgetController extends GenericController {

    /** The logger. */
    static private Logger logger = Logger.getLogger(WidgetController.class
	    .getName());

    /** The dashboard + widget service facade */
    @Autowired
    private DashboardWidgetFacade dashboardWidgets;

    /** The query Service */
    @Autowired
    private QueryService queryService;

    /**
     * Binds custom editors.
     * 
     * @param binder
     *            the binder
     * @throws Exception
     *             the exception
     */
    @InitBinder
    protected void binder(WebDataBinder binder) throws Exception {
	binder.registerCustomEditor(Date.class, new DatePropertyEditor());
    }

    /**
     * Show creates new widget form
     * 
     * @param model
     *            The model
     * @param principal
     *            The principal user
     * @return the request response
     */
    @RequestMapping(method = RequestMethod.GET, value = "/dashboard/create")
    public String createWidget(Map<String, Object> model, Principal principal,
	    HttpServletRequest request) {
	this.clearSession(request, DashboardController.SESSION_KEY_WIDGET_LIST);
	return createOrEditWidget(model, principal, null);
    }

    /**
     * Creates a new widget from library
     * 
     * @param model
     *            The model
     * @param principal
     *            The principal user
     * @return The request response
     */
    @RequestMapping(method = RequestMethod.GET, value = "/dashboard/createFromLibrary")
    public String createWidgetFromLibrary(Map<String, Object> model,
	    Principal principal, HttpServletRequest request) {

	if (principal != null) {
	    model.put(
		    "categories",
		    this.dashboardWidgets
			    .findAllCategoryWidgets(DashboardWidgetFacade.GET_LIBRARY_BYCATEGORY));
	}
	this.clearSession(request, DashboardController.SESSION_KEY_WIDGET_LIST);
	return "widget/createFromLibrary";
    }

    /**
     * Edit a widget
     * 
     * @param model
     *            The model
     * @param widgetId
     *            The widget id
     * @param principal
     *            The principal user
     * @return The request response
     */
    @RequestMapping(method = RequestMethod.GET, value = "/dashboard/edit/{widgetId}")
    public String editWidget(Map<String, Object> model,
	    @PathVariable("widgetId") Integer widgetId, Principal principal,
	    HttpServletRequest request) {
	this.clearSession(request, DashboardController.SESSION_KEY_WIDGET_LIST);
	return createOrEditWidget(model, principal, widgetId);
    }

    /**
     * Delete a widget
     * 
     * @param widgetId
     *            The widget id
     * @param principal
     *            The principal user
     */
    @RequestMapping(method = RequestMethod.POST, value = "/dashboard/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteWidget(@RequestParam("widgetId") Integer widgetId,
	    Principal principal, HttpServletRequest request) {

	if (principal != null) {
	    try {
		this.dashboardWidgets.removeWidgetFromUser(widgetId,
			principal.getName());

	    } catch (Exception e) {
		logger.error("An error occurs", e);
	    }
	}
	this.clearSession(request, DashboardController.SESSION_KEY_WIDGET_LIST);
    }

    /**
     * Update a widget
     * 
     * @param widget
     *            The widget
     * @param result
     *            The binding result
     * @param model
     *            The model
     * @param request
     *            The request
     * @param principal
     *            The principal user
     * @return The request response
     */
    @RequestMapping(value = "/dashboard/save", method = RequestMethod.POST)
    public String updateWidget(@Valid @ModelAttribute("widget") Widget widget,
	    BindingResult result, Map<String, Object> model,
	    HttpServletRequest request, Principal principal) {

	if (principal != null) {
	    this.dashboardWidgets.addWidgetToUser(principal.getName(), widget,
		    null);

	}
	this.clearSession(request, DashboardController.SESSION_KEY_WIDGET_LIST);
	return "closeIframeUpdateParent";
    }

    /**
     * Add a widget to user dashboard from library
     * 
     * @param widgetIds
     *            A list with the widgets ids
     * @param principal
     *            The principal user
     * @return The request response
     */
    @RequestMapping(value = "/dashboard/addFromLibrary", method = RequestMethod.POST)
    public String addFromLibrary(
	    @RequestParam(value = "widgetIds", required = false) ArrayList<Integer> widgetIds,
	    Principal principal, HttpServletRequest request) {

	if (principal != null) {
	    this.dashboardWidgets.addWidgetToUser(principal.getName(), null,
		    widgetIds);
	}
	this.clearSession(request, DashboardController.SESSION_KEY_WIDGET_LIST);
	return "closeIframeUpdateParent";
    }

    /**
     * Show add widget to library form
     * 
     * @param model
     *            The model
     * @param widgetId
     *            The widget id
     * @param principal
     *            The principal user
     * @return The petition response
     */
    @RequestMapping(value = "/dashboard/showAddToLibraryForm/{widgetId}", method = RequestMethod.GET)
    public String showAddToLibraryForm(Map<String, Object> model,
	    @PathVariable("widgetId") Integer widgetId, Principal principal,
	    HttpServletRequest request) {

	List<WidgetCategory> widgetCategory = this.dashboardWidgets
		.findAllCategoryWidgets(DashboardWidgetFacade.GET_ALL_CATEGORY_WIDGETS);
	model.put("widgetId", widgetId);
	model.put("categories", widgetCategory);
	this.clearSession(request, DashboardController.SESSION_KEY_WIDGET_LIST);
	return "widget/addToLibrary";
    }

    /**
     * Add a widget to library
     * 
     * @param widgetId
     *            The widget id
     * @param categoryId
     *            The category id
     * @param principal
     *            The principal user
     * @return The request response
     */
    @RequestMapping(value = "/dashboard/addToLibrary", method = RequestMethod.POST)
    public String addToLibrary(
	    @RequestParam(value = "widgetId") Integer widgetId,
	    @RequestParam(value = "categoryId") Integer categoryId,
	    Principal principal, HttpServletRequest request) {
	addOrRemoveWidgetFromLibrary(widgetId, principal, categoryId);

	return "closeIframeUpdateParent";
    }

    /**
     * Remove a widget from library
     * 
     * @param widgetId
     *            The widget id
     * @param principal
     *            The principal user
     */
    @RequestMapping(value = "/dashboard/removeFromLibrary", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void removeFromLibrary(
	    @RequestParam(value = "widgetId") Integer widgetId,
	    Principal principal, HttpServletRequest request) {
	addOrRemoveWidgetFromLibrary(widgetId, principal, null);
    }

    /**
     * Set a widget as default
     * 
     * @param widgetId
     *            The widget id
     * @param principal
     *            The principal user
     */
    @RequestMapping(value = "/dashboard/setAsDefault", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void setAsDefault(
	    @RequestParam(value = "widgetId") Integer widgetId,
	    Principal principal, HttpServletRequest request) {
	this.clearSession(request, DashboardController.SESSION_KEY_WIDGET_LIST);
	setWidgetDefault(widgetId, principal, true);
    }

    /**
     * Unset a widget as default
     * 
     * @param widgetId
     *            The widget id
     * @param principal
     *            The principal user
     */
    @RequestMapping(value = "/dashboard/unsetAsDefault", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void unsetAsDefault(
	    @RequestParam(value = "widgetId") Integer widgetId,
	    Principal principal, HttpServletRequest request) {
	this.clearSession(request, DashboardController.SESSION_KEY_WIDGET_LIST);
	setWidgetDefault(widgetId, principal, false);
    }

    /**
     * Set a widget as default
     * 
     * @param widgetId
     *            The widget id
     * @param principal
     *            The principal user
     * @param isDefault
     *            Indicates if default is true or false
     */
    private void setWidgetDefault(Integer widgetId, Principal principal,
	    boolean isDefault) {
	if (widgetId != null && principal != null) {
	    this.dashboardWidgets.updateWidgetDefaultStatus(widgetId,
		    principal.getName(), isDefault);
	}
    }

    /**
     * Create or edit a widget
     * 
     * @param model
     *            The model
     * @param principal
     *            The principal user
     * @param widgetId
     *            The widget id
     * @return The petition response
     */
    private String createOrEditWidget(Map<String, Object> model,
	    Principal principal, Integer widgetId) {
	Set<Query> userQueries = null;
	String operationType = "create";
	Widget widget = new Widget();

	if (principal != null) {
	    userQueries = this.queryService.getQueriesByUser(principal
		    .getName());

	    if (widgetId != null) {
		Widget widgetToEdit = this.dashboardWidgets.getWidget(widgetId);
		if (this.dashboardWidgets.userHasWidget(widgetToEdit,
			principal.getName())) {
		    widget = widgetToEdit;
		    operationType = "edit";
		}
	    }
	}

	model.put("userQueries", userQueries);

	model.put("chartTypes", Widget.ChartType.values());
	model.put("regionTypes", RegionType.values());

	model.put("queryTypes", WidgetQueryAssociationType.values());
	model.put("widget", widget);
	model.put("operationType", operationType);

	return "widget/createOrEdit";
    }

    /**
     * Add or remove a widget from library
     * 
     * @param widgetId
     *            the widget id
     * @param principal
     *            the principal user
     * @param categoryId
     *            the category id
     */
    private void addOrRemoveWidgetFromLibrary(Integer widgetId,
	    Principal principal, Integer categoryId) {
	if (widgetId != null && principal != null) {

	    this.dashboardWidgets.addOrRemoveWidgetToLibrary(widgetId,
		    principal.getName(), categoryId);
	}
    }
}
