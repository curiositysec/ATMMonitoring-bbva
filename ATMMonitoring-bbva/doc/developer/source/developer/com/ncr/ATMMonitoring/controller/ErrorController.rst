.. java:import:: java.security Principal

.. java:import:: java.util Map

.. java:import:: javax.servlet.http HttpServletRequest

.. java:import:: org.apache.log4j Logger

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Controller

.. java:import:: org.springframework.web.bind.annotation RequestMapping

.. java:import:: com.ncr ATMMonitoring.service.BankCompanyService

ErrorController
===============

.. java:package:: com.ncr.ATMMonitoring.controller
   :noindex:

.. java:type:: @Controller public class ErrorController extends GenericController

   The Class ErrorController. Controller for handling HTTP petitions that resulted in an error.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
error
^^^^^

.. java:method:: @RequestMapping public String error(Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: ErrorController

   Generic error.

   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

error403
^^^^^^^^

.. java:method:: @RequestMapping public String error403(Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: ErrorController

   403 error.

   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

error404
^^^^^^^^

.. java:method:: @RequestMapping public String error404(Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: ErrorController

   404 error.

   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

