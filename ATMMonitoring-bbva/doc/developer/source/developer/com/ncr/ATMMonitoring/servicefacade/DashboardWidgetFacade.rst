.. java:import:: java.util List

.. java:import:: java.util Locale

.. java:import:: java.util Map

.. java:import:: com.ncr ATMMonitoring.pojo.Dashboard

.. java:import:: com.ncr ATMMonitoring.pojo.Widget

.. java:import:: com.ncr ATMMonitoring.pojo.WidgetCategory

.. java:import:: com.ncr ATMMonitoring.service.DashboardService

.. java:import:: com.ncr ATMMonitoring.service.UserService

.. java:import:: com.ncr ATMMonitoring.service.WidgetService

DashboardWidgetFacade
=====================

.. java:package:: com.ncr.ATMMonitoring.servicefacade
   :noindex:

.. java:type:: public interface DashboardWidgetFacade

   Service that is an implementation of the Facade pattern that provides a simplified interface for the interaction between the services \ :java:ref:`DashboardService`\  , \ :java:ref:`WidgetService`\  and \ :java:ref:`UserService`\

   :author: Otto Abreu

Fields
------
GET_ALL_CATEGORY_WIDGETS
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field::  boolean GET_ALL_CATEGORY_WIDGETS
   :outertype: DashboardWidgetFacade

   indicate that all the category widgets will be retrieved

GET_LIBRARY_BYCATEGORY
^^^^^^^^^^^^^^^^^^^^^^

.. java:field::  boolean GET_LIBRARY_BYCATEGORY
   :outertype: DashboardWidgetFacade

   indicate that will find all library widgets by category

HIDE
^^^^

.. java:field::  boolean HIDE
   :outertype: DashboardWidgetFacade

   Constant used to set an widget as not visible HIDE = false;;

INVISIBLE_WIDGETS
^^^^^^^^^^^^^^^^^

.. java:field::  String INVISIBLE_WIDGETS
   :outertype: DashboardWidgetFacade

   Used as key for knowing the list of invisible widgets INVISIBLE_WIDGETS = "invisible";

SET_WIDGET_AS_DEFAULT
^^^^^^^^^^^^^^^^^^^^^

.. java:field::  boolean SET_WIDGET_AS_DEFAULT
   :outertype: DashboardWidgetFacade

   Constant used to mark as default SET_WIDGET_AS_DEFAULT = true;

SET_WIDGET_AS_NO_DEFAULT
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field::  boolean SET_WIDGET_AS_NO_DEFAULT
   :outertype: DashboardWidgetFacade

   Constant used to remove the default mark from a widget SET_WIDGET_AS_NO_DEFAULT = false;

VISIBLE
^^^^^^^

.. java:field::  boolean VISIBLE
   :outertype: DashboardWidgetFacade

   Constant used to set an widget as visible VISIBLE = true;

VISIBLE_WIDGETS
^^^^^^^^^^^^^^^

.. java:field::  String VISIBLE_WIDGETS
   :outertype: DashboardWidgetFacade

   Used as key for knowing the list of visible widgets VISIBLE_WIDGETS = "visible";

Methods
-------
addOrRemoveWidgetToLibrary
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  void addOrRemoveWidgetToLibrary(int widgetId, String username, int categoryId)
   :outertype: DashboardWidgetFacade

   :param widgetsId: int with a valid widget id
   :param username: String with the username
   :param categoryId:

addWidgetToUser
^^^^^^^^^^^^^^^

.. java:method::  void addWidgetToUser(String username, Widget widget, List<Integer> widgetsId)
   :outertype: DashboardWidgetFacade

   Associates one custom widget or widgets from the library to the given user If the param widget is present, this method will associate the given widget to the user If the param widgetsId is present will associate the given library widgets id to the user

   :param username: String with the username
   :param widget: the widget to be added
   :param widgetsId: List list with valid ids with widgets from the library

changeDashboardColumms
^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  void changeDashboardColumms(String username, int columns)
   :outertype: DashboardWidgetFacade

   Modifies the number of columns un the dashboard

   :param username: S tring
   :param columns: int

executeQueryForWidget
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<?> executeQueryForWidget(String username, int widgetId, Locale locale)
   :outertype: DashboardWidgetFacade

   Execute a query for the given widget

   :param username:
   :param widgetId:
   :param locale:
   :return: List>

findAllCategoryWidgets
^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  List<WidgetCategory> findAllCategoryWidgets(boolean fetchType)
   :outertype: DashboardWidgetFacade

   Retrieves all the Category by category or just all to specify the param fechtype please use \ :java:ref:`DashboardWidgetFacade.GET_ALL_CATEGORY_WIDGETS`\  for retrieving all the WidgetCategory with no restrictions, otherwise use \ :java:ref:`DashboardWidgetFacade.GET_LIBRARY_BYCATEGORY`\  to retrieve only by category

   :return: List

getDashboard
^^^^^^^^^^^^

.. java:method::  Dashboard getDashboard(String username)
   :outertype: DashboardWidgetFacade

   Return the dashboard associated to the given user. If the user does not have a dashboard, a default will be returned

   :param username: String with the username
   :return: Dashboard

getVisiblesAndInvisiblesWidgets
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  Map<String, List<Widget>> getVisiblesAndInvisiblesWidgets(String username)
   :outertype: DashboardWidgetFacade

   Returns two list with the visible and invisible widgets of the dashboard The list are inside a map, to retrieve the Visible list, please use \ :java:ref:`DashboardWidgetFacade.VISIBLE_WIDGETS`\  as key, to retrieve the Invisible list, please use \ :java:ref:`DashboardWidgetFacade.INVISIBLE_WIDGETS`\  as key

getWidget
^^^^^^^^^

.. java:method::  Widget getWidget(int widgetId)
   :outertype: DashboardWidgetFacade

   Returns the widget that matches the given id

   :param widgetsId: int with a valid widget id
   :return: Widget

hideShowWidget
^^^^^^^^^^^^^^

.. java:method::  void hideShowWidget(int widgetId, String username, boolean hideShow)
   :outertype: DashboardWidgetFacade

   Marks a widget as visible or invisible  To specify if the method will make a widget visible please use \ :java:ref:`DashboardWidgetFacade.VISIBLE`\ , to hide it use \ :java:ref:`DashboardWidgetFacade.HIDE`\

   :param widgetsId: int with a valid widget id
   :param username: String with the username
   :param hideShow:

removeWidgetFromUser
^^^^^^^^^^^^^^^^^^^^

.. java:method::  void removeWidgetFromUser(int widgetsId, String username)
   :outertype: DashboardWidgetFacade

   Remove the association between the user and the widget

   :param widgetsId: int with a valid widget id
   :param username: String with the username

updateWidgetDefaultStatus
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  void updateWidgetDefaultStatus(int widgetId, String username, boolean setAsDefault)
   :outertype: DashboardWidgetFacade

   Updates the status of a widget marking it as default or not To specify if the method will mark a widget as default please use \ :java:ref:`DashboardWidgetFacade.SET_WIDGET_AS_DEFAULT`\ , to remove the default mark \ :java:ref:`DashboardWidgetFacade.SET_WIDGET_AS_NO_DEFAULT`\

   :param widgetsId: int with a valid widget id
   :param username: String with the username
   :param setAsDefault:

updateWidgetPosition
^^^^^^^^^^^^^^^^^^^^

.. java:method::  void updateWidgetPosition(String username, int widgetId, int oldPosition, int newPosition)
   :outertype: DashboardWidgetFacade

   Modifies the position of the widget inside the dashboard

   :param username: String with the username
   :param widgetId: int with a valid widget id
   :param oldPosition: old position in the dashboard
   :param newPosition: new position in the dashboard

userHasWidget
^^^^^^^^^^^^^

.. java:method::  boolean userHasWidget(int widgetId, String username)
   :outertype: DashboardWidgetFacade

   Returns if the user has an association with the given widget (true) or if the association does not exist (false)

   :param widgetsId: int with a valid widget id
   :param username: String with the username
   :return: boolean

userHasWidget
^^^^^^^^^^^^^

.. java:method::  boolean userHasWidget(Widget widget, String username)
   :outertype: DashboardWidgetFacade

   Returns if the user has an association with the given widget (true) or if the association does not exist (false)

   :param widget: valid widget
   :param username: String with the username

