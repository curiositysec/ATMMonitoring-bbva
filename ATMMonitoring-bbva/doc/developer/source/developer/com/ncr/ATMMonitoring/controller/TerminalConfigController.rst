.. java:import:: java.security Principal

.. java:import:: java.util Map

.. java:import:: javax.servlet.http HttpServletRequest

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Controller

.. java:import:: org.springframework.web.bind WebDataBinder

.. java:import:: org.springframework.web.bind.annotation InitBinder

.. java:import:: org.springframework.web.bind.annotation PathVariable

.. java:import:: org.springframework.web.bind.annotation RequestMapping

.. java:import:: com.ncr ATMMonitoring.controller.propertyeditor.SoftwarePropertyEditor

.. java:import:: com.ncr ATMMonitoring.pojo.Software

.. java:import:: com.ncr ATMMonitoring.pojo.TerminalConfig

.. java:import:: com.ncr ATMMonitoring.service.SoftwareService

.. java:import:: com.ncr ATMMonitoring.servicefacade.AtmFacade

TerminalConfigController
========================

.. java:package:: com.ncr.ATMMonitoring.controller
   :noindex:

.. java:type:: @Controller public class TerminalConfigController extends GenericController

   The Class TerminalConfigController. Controller for handling terminal config related HTTP petitions.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
binder
^^^^^^

.. java:method:: @InitBinder protected void binder(WebDataBinder binder) throws Exception
   :outertype: TerminalConfigController

   Binds custom property editors.

   :param binder: the binder

terminalConfigDetails
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String terminalConfigDetails(Integer terminalConfigId, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: TerminalConfigController

   Terminal config details URL.

   :param terminalConfigId: the terminal config id
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

