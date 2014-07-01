.. java:import:: java.util List

.. java:import:: java.util Locale

.. java:import:: com.ncr ATMMonitoring.pojo.User

.. java:import:: com.ncr ATMMonitoring.pojo.Widget

.. java:import:: com.ncr ATMMonitoring.pojo.WidgetCategory

WidgetService
=============

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface WidgetService

   The Interface WidgetService. It contains the widget related methods.

   :author: Rafael Luque (rafael.luque@osoco.es)

Methods
-------
addOrRemoveWidgetToLibrary
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addOrRemoveWidgetToLibrary(Integer widgetId, User user, Integer categoryId)
   :outertype: WidgetService

   Add or removes a widget from library

   :param widgetId: The widget id
   :param user: The widget owner
   :param categoryId: The category id

addWidgetsFromLibrary
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addWidgetsFromLibrary(List<Integer> widgetIds, User user)
   :outertype: WidgetService

   Adds a widget to a user from widget library

   :param widgetIds: The widget ids
   :param user: The user

copyDefaultWidgetsToUserDashboard
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Widget> copyDefaultWidgetsToUserDashboard(User user)
   :outertype: WidgetService

   Copy default widgets to user dashboard.

   :param user: the user
   :param dashboard: the dashboard
   :return: the list

createWidgetForUser
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void createWidgetForUser(Widget widget, User user)
   :outertype: WidgetService

   Create a widget and assign it to a user

   :param widget: The widget
   :param user: the user

deleteWidgetFromUser
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void deleteWidgetFromUser(Integer widgetId, User loggedUser)
   :outertype: WidgetService

   Delete a widget from user

   :param widgetId: widget id
   :param loggedUser: user

executeQuery
^^^^^^^^^^^^

.. java:method:: public List<?> executeQuery(Widget widget, Locale locale)
   :outertype: WidgetService

   Execute query.

   :param widget: the widget
   :param locale: the locale
   :return: the list

findCategoryById
^^^^^^^^^^^^^^^^

.. java:method:: public WidgetCategory findCategoryById(Integer categoryId)
   :outertype: WidgetService

   Find category by id

   :param categoryId: The category id
   :return: The category

findDefaultWidgets
^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Widget> findDefaultWidgets()
   :outertype: WidgetService

   Find default widgets.

   :return: the list

findLibraryWidgetsByCategory
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<WidgetCategory> findLibraryWidgetsByCategory()
   :outertype: WidgetService

   Find category widgets

   :return: The category widgets

findWidgetById
^^^^^^^^^^^^^^

.. java:method:: public Widget findWidgetById(int widgetId)
   :outertype: WidgetService

   Find widget by id.

   :param widgetId: the widget id
   :return: the widget

isWidgetOwnedByUser
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean isWidgetOwnedByUser(Widget widget, User user)
   :outertype: WidgetService

   Is widget owner by user

   :param widget: The widget
   :param user: The user
   :return: Ther operation result

saveWidget
^^^^^^^^^^

.. java:method:: public void saveWidget(Widget widget)
   :outertype: WidgetService

   Save widget.

   :param widget: the widget

setWidgetDefault
^^^^^^^^^^^^^^^^

.. java:method:: public void setWidgetDefault(Integer widgetId, User user, boolean isDefault)
   :outertype: WidgetService

   Set widget default

   :param widgetId: The widget id
   :param user: The user
   :param isDefault: The default value

