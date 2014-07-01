.. java:import:: java.security Principal

.. java:import:: java.util Map

.. java:import:: javax.servlet.http HttpServletRequest

.. java:import:: org.springframework.stereotype Controller

.. java:import:: org.springframework.web.bind.annotation RequestMapping

.. java:import:: org.springframework.web.bind.annotation RequestMethod

ExternalReportsController
=========================

.. java:package:: com.ncr.ATMMonitoring.controller
   :noindex:

.. java:type:: @Controller public class ExternalReportsController extends GenericController

   The Class ExternalReportsController.

Methods
-------
requestTerminalsUpdate
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public void requestTerminalsUpdate(Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: ExternalReportsController

   Request terminals update.

   :param map: the map
   :param request: the request
   :param principal: the principal

