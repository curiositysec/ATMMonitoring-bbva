.. java:import:: java.security Principal

.. java:import:: java.util ArrayList

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: java.util Locale

.. java:import:: java.util Map

.. java:import:: javax.servlet.http HttpServletRequest

.. java:import:: org.apache.log4j Logger

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.http HttpStatus

.. java:import:: org.springframework.stereotype Controller

.. java:import:: org.springframework.web.bind.annotation RequestMapping

.. java:import:: org.springframework.web.bind.annotation RequestMethod

.. java:import:: org.springframework.web.bind.annotation RequestParam

.. java:import:: org.springframework.web.bind.annotation ResponseBody

.. java:import:: org.springframework.web.bind.annotation ResponseStatus

.. java:import:: org.springframework.web.servlet.support RequestContextUtils

.. java:import:: com.ncr ATMMonitoring.pojo.Dashboard

.. java:import:: com.ncr ATMMonitoring.pojo.Widget

.. java:import:: com.ncr ATMMonitoring.servicefacade.DashboardWidgetFacade

DashboardController
===================

.. java:package:: com.ncr.ATMMonitoring.controller
   :noindex:

.. java:type:: @Controller public class DashboardController extends GenericController

   Controller for Dashboard related actions.

   :author: Rafael Luque (rafael.luque@osoco.es)

Fields
------
SESSION_KEY_DASHBOARD
^^^^^^^^^^^^^^^^^^^^^

.. java:field:: public static final String SESSION_KEY_DASHBOARD
   :outertype: DashboardController

SESSION_KEY_WIDGET_LIST
^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: public static final String SESSION_KEY_WIDGET_LIST
   :outertype: DashboardController

Methods
-------
changeColumns
^^^^^^^^^^^^^

.. java:method:: @RequestMapping @ResponseStatus public void changeColumns(int columns, HttpServletRequest request, Principal principal)
   :outertype: DashboardController

   Change columns.

   :param columns: the columns
   :param request: the request
   :param principal: the principal

hideChart
^^^^^^^^^

.. java:method:: @RequestMapping @ResponseStatus public void hideChart(int widgetId, HttpServletRequest request, Principal principal)
   :outertype: DashboardController

   Hide chart.

   :param widgetId: the widget id
   :param request: the request
   :param principal: the principal

newWidget
^^^^^^^^^

.. java:method:: @RequestMapping public String newWidget(HttpServletRequest request)
   :outertype: DashboardController

   Show new widget form

   :return: the petition response

showChart
^^^^^^^^^

.. java:method:: @RequestMapping @ResponseStatus public void showChart(int widgetId, HttpServletRequest request, Principal principal)
   :outertype: DashboardController

   Show chart.

   :param widgetId: the widget id
   :param request: the request
   :param principal: the principal

showDashboard
^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String showDashboard(Map<String, Object> map, Principal principal, HttpServletRequest request)
   :outertype: DashboardController

   Show dashboard.

   :param map: the map
   :param principal: the principal
   :param request: the request
   :return: the string

showDashboardChart
^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping @ResponseBody public Map showDashboardChart(HttpServletRequest request, Principal principal)
   :outertype: DashboardController

   Show dashboard chart.

   :param request: the request
   :param principal: the principal
   :return: the map

showDashboardChart
^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping @ResponseBody public Map showDashboardChart(int widgetId, HttpServletRequest request, Principal principal)
   :outertype: DashboardController

   Show dashboard chart.

   :param widgetId: the widget id
   :param request: the request
   :param principal: the principal
   :return: the map

updateChartPosition
^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping @ResponseStatus public void updateChartPosition(int widgetId, int oldPosition, int newPosition, HttpServletRequest request, Principal principal)
   :outertype: DashboardController

   Update chart position.

   :param widgetId: the widget id
   :param oldPosition: the old position
   :param newPosition: the new position
   :param request: the request
   :param principal: the principal

