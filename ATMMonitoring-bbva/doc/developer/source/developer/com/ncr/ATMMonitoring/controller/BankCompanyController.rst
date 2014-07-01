.. java:import:: java.security Principal

.. java:import:: java.util Map

.. java:import:: javax.servlet.http HttpServletRequest

.. java:import:: javax.validation Valid

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.beans.factory.annotation Value

.. java:import:: org.springframework.beans.support PagedListHolder

.. java:import:: org.springframework.stereotype Controller

.. java:import:: org.springframework.validation BindingResult

.. java:import:: org.springframework.web.bind.annotation ModelAttribute

.. java:import:: org.springframework.web.bind.annotation PathVariable

.. java:import:: org.springframework.web.bind.annotation RequestMapping

.. java:import:: org.springframework.web.bind.annotation RequestMethod

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

.. java:import:: com.ncr ATMMonitoring.service.BankCompanyService

BankCompanyController
=====================

.. java:package:: com.ncr.ATMMonitoring.controller
   :noindex:

.. java:type:: @Controller public class BankCompanyController extends GenericController

   The Class BankCompanyController. Controller for handling bank company related HTTP petitions.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addBankCompany
^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String addBankCompany(BankCompany bankCompany, BindingResult result, Map<String, Object> map, HttpServletRequest request, String p, Principal principal)
   :outertype: BankCompanyController

   Add bank company URL.

   :param bankCompany: the bank company
   :param result: the result
   :param map: the map
   :param request: the request
   :param p: the page number
   :param principal: the principal
   :return: the petition response

bankCompanyDetails
^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String bankCompanyDetails(Integer bankCompanyId, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: BankCompanyController

   Bank company details URL.

   :param bankCompanyId: the bank company id
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

deleteBankCompany
^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String deleteBankCompany(Integer bankCompanyId)
   :outertype: BankCompanyController

   Delete bank company URL.

   :param bankCompanyId: the bank company id
   :return: the petition response

listBankCompanies
^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String listBankCompanies(Map<String, Object> map, Principal principal, String p, HttpServletRequest request)
   :outertype: BankCompanyController

   List bank companies URL.

   :param map: the map
   :param principal: the principal
   :param p: the page number
   :param request: the request
   :return: the petition response

redirectToBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String redirectToBankCompanies()
   :outertype: BankCompanyController

   Redirect to bank companies URL.

   :return: the petition response

updateBankCompany
^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String updateBankCompany(BankCompany bankCompany, BindingResult result, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: BankCompanyController

   Update bank company URL.

   :param bankCompany: the bank company
   :param result: the result
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

