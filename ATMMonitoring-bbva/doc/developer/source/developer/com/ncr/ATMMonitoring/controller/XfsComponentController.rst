.. java:import:: java.security Principal

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: javax.servlet.http HttpServletRequest

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Controller

.. java:import:: org.springframework.web.bind.annotation PathVariable

.. java:import:: org.springframework.web.bind.annotation RequestMapping

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

.. java:import:: com.ncr ATMMonitoring.pojo.FinancialDevice

.. java:import:: com.ncr ATMMonitoring.pojo.JxfsComponent

.. java:import:: com.ncr ATMMonitoring.pojo.XfsComponent

.. java:import:: com.ncr ATMMonitoring.service.BankCompanyService

.. java:import:: com.ncr ATMMonitoring.service.XfsComponentService

XfsComponentController
======================

.. java:package:: com.ncr.ATMMonitoring.controller
   :noindex:

.. java:type:: @Controller public class XfsComponentController extends GenericController

   The Class XfsComponentController. Controller for handling user related HTTP petitions.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
jxfsComponentDetails
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String jxfsComponentDetails(Integer jxfsComponentId, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: XfsComponentController

   Jxfs component details URL.

   :param jxfsComponentId: the jxfs component id
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

xfsComponentDetails
^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String xfsComponentDetails(Integer xfsComponentId, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: XfsComponentController

   Xfs component details URL.

   :param xfsComponentId: the xfs component id
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

