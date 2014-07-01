.. java:import:: java.security Principal

.. java:import:: java.util Map

.. java:import:: javax.servlet.http HttpServletRequest

.. java:import:: org.springframework.stereotype Controller

.. java:import:: org.springframework.web.bind.annotation PathVariable

.. java:import:: org.springframework.web.bind.annotation RequestMapping

.. java:import:: org.springframework.web.bind.annotation RequestMethod

HelpController
==============

.. java:package:: com.ncr.ATMMonitoring.controller
   :noindex:

.. java:type:: @Controller public class HelpController extends GenericController

   The Class HelpController. Controller for handling help related HTTP petitions.

   :author: Otto Abreu

Methods
-------
showDashboardHelp
^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String showDashboardHelp(String section, Map<String, Object> map, Principal principal, HttpServletRequest request)
   :outertype: HelpController

   Show section help URL.

   :param map: the map
   :param principal: the principal
   :param request: the request
   :return: the petition response

showHelp
^^^^^^^^

.. java:method:: @RequestMapping public String showHelp(Map<String, Object> map, Principal principal, HttpServletRequest request)
   :outertype: HelpController

   Show default help URL.

   :param map: the map
   :param principal: the principal
   :param request: the request
   :return: the petition response

