package com.ncr.ATMMonitoring.service;

import java.util.List;
import java.util.Locale;

import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.pojo.Widget;
import com.ncr.ATMMonitoring.pojo.WidgetCategory;

/**
 * The Interface WidgetService.
 * 
 * It contains the widget related methods.
 * 
 * @author Rafael Luque (rafael.luque@osoco.es)
 */
public interface WidgetService {

    /**
     * Find default widgets.
     * 
     * @return the list
     */
    public List<Widget> findDefaultWidgets();

    /**
     * Find widget by id.
     * 
     * @param widgetId
     *            the widget id
     * @return the widget
     */
    public Widget findWidgetById(int widgetId);

    /**
     * Save widget.
     * 
     * @param widget
     *            the widget
     */
    public void saveWidget(Widget widget);

    /**
     * Copy default widgets to user dashboard.
     * 
     * @param user
     *            the user
     * @param dashboard
     *            the dashboard
     * @return the list
     */
    public List<Widget> copyDefaultWidgetsToUserDashboard(User user);

    /**
     * Execute query.
     * 
     * @param widget
     *            the widget
     * @param locale
     *            the locale
     * @return the list
     */
    public List<?> executeQuery(Widget widget, Locale locale);

    /**
     * Delete a widget from user
     * 
     * @param widgetId
     *            widget id
     * @param loggedUser
     *            user
     */
    public void deleteWidgetFromUser(Integer widgetId, User loggedUser);

    /**
     * Is widget owner by user
     * 
     * @param widget
     *            The widget
     * @param user
     *            The user
     * @return Ther operation result
     */
    public Boolean isWidgetOwnedByUser(Widget widget, User user);

    /**
     * Create a widget and assign it to a user
     * 
     * @param widget
     *            The widget
     * @param user
     *            the user
     */
    public void createWidgetForUser(Widget widget, User user);

    /**
     * Adds a widget to a user from widget library
     * 
     * @param widgetIds
     *            The widget ids
     * @param user
     *            The user
     */
    public void addWidgetsFromLibrary(List<Integer> widgetIds, User user);

    /**
     * Find category widgets
     * 
     * @return The category widgets
     */
    public List<WidgetCategory> findLibraryWidgetsByCategory();

    /**
     * Add or removes a widget from library
     * 
     * @param widgetId
     *            The widget id
     * @param user
     *            The widget owner
     * @param categoryId
     *            The category id
     */
    public void addOrRemoveWidgetToLibrary(Integer widgetId, User user,
	    Integer categoryId);

    /**
     * Set widget default
     * 
     * @param widgetId
     *            The widget id
     * @param user
     *            The user
     * @param isDefault
     *            The default value
     */
    public void setWidgetDefault(Integer widgetId, User user, boolean isDefault);

    /**
     * Find category by id
     * 
     * @param categoryId
     *            The category id
     * @return The category
     */
    public WidgetCategory findCategoryById(Integer categoryId);
}
