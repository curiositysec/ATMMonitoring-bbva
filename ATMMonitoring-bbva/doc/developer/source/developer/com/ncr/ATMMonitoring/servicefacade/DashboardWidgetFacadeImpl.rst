.. java:import:: java.util Collections

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: java.util Locale

.. java:import:: java.util Map

.. java:import:: org.apache.log4j Logger

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: com.ncr ATMMonitoring.pojo.Dashboard

.. java:import:: com.ncr ATMMonitoring.pojo.User

.. java:import:: com.ncr ATMMonitoring.pojo.Widget

.. java:import:: com.ncr ATMMonitoring.pojo.WidgetCategory

.. java:import:: com.ncr ATMMonitoring.service.DashboardService

.. java:import:: com.ncr ATMMonitoring.service.UserService

.. java:import:: com.ncr ATMMonitoring.service.WidgetCategoryService

.. java:import:: com.ncr ATMMonitoring.service.WidgetService

.. java:import:: com.ncr ATMMonitoring.servicefacade.DashboardWidgetFacade

DashboardWidgetFacadeImpl
=========================

.. java:package:: com.ncr.ATMMonitoring.servicefacade
   :noindex:

.. java:type:: @Service public class DashboardWidgetFacadeImpl implements DashboardWidgetFacade

   :author: Otto Abreu

Methods
-------
addOrRemoveWidgetToLibrary
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addOrRemoveWidgetToLibrary(int widgetId, String username, int categoryId)
   :outertype: DashboardWidgetFacadeImpl

addWidgetToUser
^^^^^^^^^^^^^^^

.. java:method:: @Override public void addWidgetToUser(String username, Widget widget, List<Integer> widgetsId)
   :outertype: DashboardWidgetFacadeImpl

changeDashboardColumms
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void changeDashboardColumms(String username, int columns)
   :outertype: DashboardWidgetFacadeImpl

executeQueryForWidget
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<?> executeQueryForWidget(String username, int widgetId, Locale locale)
   :outertype: DashboardWidgetFacadeImpl

findAllCategoryWidgets
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<WidgetCategory> findAllCategoryWidgets(boolean fetchType)
   :outertype: DashboardWidgetFacadeImpl

getDashboard
^^^^^^^^^^^^

.. java:method:: @Override public Dashboard getDashboard(String username)
   :outertype: DashboardWidgetFacadeImpl

getVisiblesAndInvisiblesWidgets
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Map<String, List<Widget>> getVisiblesAndInvisiblesWidgets(String username)
   :outertype: DashboardWidgetFacadeImpl

getWidget
^^^^^^^^^

.. java:method:: @Override public Widget getWidget(int widgetId)
   :outertype: DashboardWidgetFacadeImpl

hideShowWidget
^^^^^^^^^^^^^^

.. java:method:: @Override public void hideShowWidget(int widgetId, String username, boolean hideShow)
   :outertype: DashboardWidgetFacadeImpl

removeWidgetFromUser
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void removeWidgetFromUser(int widgetId, String username)
   :outertype: DashboardWidgetFacadeImpl

updateWidgetDefaultStatus
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void updateWidgetDefaultStatus(int widgetId, String username, boolean setAsDefault)
   :outertype: DashboardWidgetFacadeImpl

updateWidgetPosition
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void updateWidgetPosition(String username, int widgetId, int oldPosition, int newPosition)
   :outertype: DashboardWidgetFacadeImpl

userHasWidget
^^^^^^^^^^^^^

.. java:method:: @Override public boolean userHasWidget(int widgetId, String username)
   :outertype: DashboardWidgetFacadeImpl

userHasWidget
^^^^^^^^^^^^^

.. java:method:: @Override public boolean userHasWidget(Widget widget, String username)
   :outertype: DashboardWidgetFacadeImpl

