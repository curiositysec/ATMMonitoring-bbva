package com.ncr.ATMMonitoring.servicefacade;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.ncr.ATMMonitoring.pojo.Dashboard;
import com.ncr.ATMMonitoring.pojo.Widget;
import com.ncr.ATMMonitoring.pojo.WidgetCategory;
import com.ncr.ATMMonitoring.service.DashboardService;
import com.ncr.ATMMonitoring.service.UserService;
import com.ncr.ATMMonitoring.service.WidgetService;

/**
 * Service that is an implementation of the Facade pattern that provides a
 * simplified interface for the interaction between the services
 * {@link DashboardService} , {@link WidgetService} and {@link UserService}
 * 
 * @author Otto Abreu
 * 
 */
public interface DashboardWidgetFacade {
    /**
     * Constant used to set an widget as visible VISIBLE = true;
     */
    boolean VISIBLE = true;
    /**
     * Constant used to set an widget as not visible HIDE = false;;
     */
    boolean HIDE = false;

    /**
     * Constant used to mark as default SET_WIDGET_AS_DEFAULT = true;
     */
    boolean SET_WIDGET_AS_DEFAULT = true;
    /**
     * Constant used to remove the default mark from a widget
     * SET_WIDGET_AS_NO_DEFAULT = false;
     */
    boolean SET_WIDGET_AS_NO_DEFAULT = false;
    /**
     * Used as key for knowing the list of visible widgets VISIBLE_WIDGETS =
     * "visible";
     */
    String VISIBLE_WIDGETS = "visible";

    /**
     * Used as key for knowing the list of invisible widgets INVISIBLE_WIDGETS =
     * "invisible";
     */
    String INVISIBLE_WIDGETS = "invisible";
    /**
     * indicate that all the category widgets will be retrieved
     */
    boolean GET_ALL_CATEGORY_WIDGETS = true;

    /**
     * indicate that will find all library widgets by category
     */
    boolean GET_LIBRARY_BYCATEGORY = false;

    /**
     * Return the dashboard associated to the given user. If the user does not
     * have a dashboard, a default will be returned
     * 
     * @param username
     *            String with the username
     * @return Dashboard
     */
    Dashboard getDashboard(String username);

    /**
     * Modifies the position of the widget inside the dashboard
     * 
     * @param username
     *            String with the username
     * @param widgetId
     *            int with a valid widget id
     * @param oldPosition
     *            old position in the dashboard
     * @param newPosition
     *            new position in the dashboard
     */
    void updateWidgetPosition(String username, int widgetId, int oldPosition,
	    int newPosition);

    /**
     * Returns two list with the visible and invisible widgets of the dashboard<br>
     * The list are inside a map, to retrieve the Visible list, please use
     * {@link DashboardWidgetFacade#VISIBLE_WIDGETS} as key, to retrieve the
     * Invisible list, please use
     * {@link DashboardWidgetFacade#INVISIBLE_WIDGETS} as key
     * 
     * @returnMap<String, List<Widget>>
     */
    Map<String, List<Widget>> getVisiblesAndInvisiblesWidgets(String username);

    /**
     * Marks a widget as visible or invisible <br>
     * To specify if the method will make a widget visible please use
     * {@link DashboardWidgetFacade#VISIBLE}, to hide it use
     * {@link DashboardWidgetFacade#HIDE}
     * 
     * @param widgetsId
     *            int with a valid widget id
     * @param username
     *            String with the username
     * @param hideShow
     */
    void hideShowWidget(int widgetId, String username, boolean hideShow);

    /**
     * Modifies the number of columns un the dashboard
     * 
     * @param username
     *            S tring
     * @param columns
     *            int
     */
    void changeDashboardColumms(String username, int columns);

    /**
     * Execute a query for the given widget
     * 
     * @param username
     * @param widgetId
     * @param locale
     * @return List<?>
     */
    public List<?> executeQueryForWidget(String username, int widgetId,
	    Locale locale);

    /**
     * Associates one custom widget or widgets from the library to the given
     * user<br>
     * If the param widget is present, this method will associate the given
     * widget to the user<br>
     * If the param widgetsId is present will associate the given library
     * widgets id to the user
     * 
     * @param username
     *            String with the username
     * @param widget
     *            the widget to be added
     * 
     * @param widgetsId
     *            List<Integer> list with valid ids with widgets from the
     *            library
     * 
     */
    void addWidgetToUser(String username, Widget widget, List<Integer> widgetsId);

    /**
     * Remove the association between the user and the widget
     * 
     * @param widgetsId
     *            int with a valid widget id
     * @param username
     *            String with the username
     */
    void removeWidgetFromUser(int widgetsId, String username);

    /**
     * Updates the status of a widget marking it as default or not To specify if
     * the method will mark a widget as default please use
     * {@link DashboardWidgetFacade#SET_WIDGET_AS_DEFAULT}, to remove the
     * default mark {@link DashboardWidgetFacade#SET_WIDGET_AS_NO_DEFAULT}
     * 
     * @param widgetsId
     *            int with a valid widget id
     * @param username
     *            String with the username
     * @param setAsDefault
     */
    void updateWidgetDefaultStatus(int widgetId, String username,
	    boolean setAsDefault);

    /**
     * Returns if the user has an association with the given widget (true) or if
     * the association does not exist (false)
     * 
     * @param widgetsId
     *            int with a valid widget id
     * @param username
     *            String with the username
     * @return boolean
     */
    boolean userHasWidget(int widgetId, String username);

    /**
     * Returns if the user has an association with the given widget (true) or if
     * the association does not exist (false)
     * 
     * @param widget
     *            valid widget
     * @param username
     *            String with the username
     * @return
     */
    boolean userHasWidget(Widget widget, String username);

    /**
     * Returns the widget that matches the given id
     * 
     * @param widgetsId
     *            int with a valid widget id
     * @return Widget
     */
    Widget getWidget(int widgetId);

    /**
     * 
     * @param widgetsId
     *            int with a valid widget id
     * @param username
     *            String with the username
     * @param categoryId
     */
    void addOrRemoveWidgetToLibrary(int widgetId, String username,
	    int categoryId);

    /**
     * Retrieves all the Category by category or just all<br>
     * to specify the param fechtype please use
     * {@link DashboardWidgetFacade#GET_ALL_CATEGORY_WIDGETS} for retrieving all
     * the WidgetCategory with no restrictions, otherwise use
     * {@link DashboardWidgetFacade#GET_LIBRARY_BYCATEGORY} to retrieve only by
     * category
     * 
     * @return List<WidgetCategory>
     */
    List<WidgetCategory> findAllCategoryWidgets(boolean fetchType);

}
