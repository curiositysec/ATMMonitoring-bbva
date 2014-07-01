.. java:import:: java.awt.image BufferedImage

.. java:import:: java.io BufferedOutputStream

.. java:import:: java.io IOException

.. java:import:: java.io OutputStream

.. java:import:: java.io OutputStreamWriter

.. java:import:: java.security Principal

.. java:import:: java.util ArrayList

.. java:import:: java.util Date

.. java:import:: java.util HashMap

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Locale

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: javax.imageio ImageIO

.. java:import:: javax.servlet.http HttpServletRequest

.. java:import:: javax.servlet.http HttpServletResponse

.. java:import:: javax.validation Valid

.. java:import:: org.apache.log4j Logger

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.beans.factory.annotation Value

.. java:import:: org.springframework.beans.support PagedListHolder

.. java:import:: org.springframework.stereotype Controller

.. java:import:: org.springframework.validation BindingResult

.. java:import:: org.springframework.web.bind WebDataBinder

.. java:import:: org.springframework.web.bind.annotation InitBinder

.. java:import:: org.springframework.web.bind.annotation ModelAttribute

.. java:import:: org.springframework.web.bind.annotation PathVariable

.. java:import:: org.springframework.web.bind.annotation RequestMapping

.. java:import:: org.springframework.web.bind.annotation RequestMethod

.. java:import:: org.springframework.web.bind.annotation RequestParam

.. java:import:: org.springframework.web.multipart.commons CommonsMultipartFile

.. java:import:: org.springframework.web.servlet.mvc.support RedirectAttributes

.. java:import:: org.springframework.web.servlet.support RequestContextUtils

.. java:import:: com.ncr ATMMonitoring.controller.propertyeditor.DatePropertyEditor

.. java:import:: com.ncr ATMMonitoring.pojo.Auditable

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

.. java:import:: com.ncr ATMMonitoring.pojo.Installation

.. java:import:: com.ncr ATMMonitoring.pojo.Location

.. java:import:: com.ncr ATMMonitoring.pojo.Query

.. java:import:: com.ncr ATMMonitoring.pojo.Terminal

.. java:import:: com.ncr ATMMonitoring.pojo.TerminalModel

.. java:import:: com.ncr ATMMonitoring.service.BankCompanyService

.. java:import:: com.ncr ATMMonitoring.service.LocationService

.. java:import:: com.ncr ATMMonitoring.service.QueryService

.. java:import:: com.ncr ATMMonitoring.servicefacade.AtmFacade

TerminalController
==================

.. java:package:: com.ncr.ATMMonitoring.controller
   :noindex:

.. java:type:: @Controller public class TerminalController extends GenericController

   The Class TerminalController. Controller for handling terminal related HTTP petitions.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Fields
------
DEFAULT_ORDER
^^^^^^^^^^^^^

.. java:field:: public static final String DEFAULT_ORDER
   :outertype: TerminalController

   The Constant DEFAULT_ORDER.

DEFAULT_SORT
^^^^^^^^^^^^

.. java:field:: public static final String DEFAULT_SORT
   :outertype: TerminalController

   The Constant DEFAULT_SORT.

Methods
-------
addTerminal
^^^^^^^^^^^

.. java:method:: @RequestMapping public String addTerminal(Terminal terminal, BindingResult result, Map<String, Object> map, HttpServletRequest request, Principal principal, String p)
   :outertype: TerminalController

   Add terminal URL.

   :param terminal: the terminal
   :param result: the result
   :param map: the map
   :param request: the request
   :param principal: the principal
   :param p: the page number
   :return: the petition response

addTerminalModel
^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String addTerminalModel(TerminalModel terminalModel, CommonsMultipartFile photo, BindingResult result, Map<String, Object> map, HttpServletRequest request, String p, Principal principal)
   :outertype: TerminalController

   Add terminal model URL.

   :param terminalModel: the terminal model
   :param photo: the photo
   :param result: the result
   :param map: the map
   :param request: the request
   :param p: the page number
   :param principal: the principal
   :return: the petition response

binder
^^^^^^

.. java:method:: @InitBinder protected void binder(WebDataBinder binder) throws Exception
   :outertype: TerminalController

   Binds custom property editors.

   :param binder: the binder

deleteTerminalModel
^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String deleteTerminalModel(Integer terminalModelId)
   :outertype: TerminalController

   Delete terminal model URL.

   :param terminalModelId: the terminal model id
   :return: the petition response

downloadResultsCsv
^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public void downloadResultsCsv(HttpServletResponse response, HttpServletRequest request, Principal principal)
   :outertype: TerminalController

   Download all terminals data as csv URL.

   :param response: the response
   :param request: the request
   :param principal: the principal

downloadResultsCsvForQuery
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public void downloadResultsCsvForQuery(Integer queryId, HttpServletResponse response, HttpServletRequest request)
   :outertype: TerminalController

   Download terminals data csv from query URL.

   :param queryId: the query id
   :param response: the response
   :param request: the request

getTerminalModelImage
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public void getTerminalModelImage(Integer terminalModelId, HttpServletRequest request, HttpServletResponse response, String width, String height)
   :outertype: TerminalController

   Get terminal model image URL.

   :param terminalModelId: the terminal model id
   :param request: the request
   :param response: the response
   :param width: the required image width
   :param height: the required image height
   :return: the terminal model image

importTerminal
^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String importTerminal(CommonsMultipartFile file) throws IOException
   :outertype: TerminalController

   Import terminals from json file URL.

   :param file: the json file
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

listTerminalModels
^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String listTerminalModels(Map<String, Object> map, Principal principal, String p, HttpServletRequest request)
   :outertype: TerminalController

   List terminal models URL.

   :param map: the map
   :param principal: the principal
   :param p: the page number
   :param request: the request
   :return: the petition response

listTerminals
^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String listTerminals(Map<String, Object> map, Principal principal, String p, String sort, String order, HttpServletRequest request)
   :outertype: TerminalController

   List terminals URL.

   :param map: the map
   :param principal: the principal
   :param p: the page number
   :param sort: the fields for sorting terminals
   :param order: the order for sorting terminals
   :param request: the request
   :param request: the queryDate
   :return: the petition response

listTerminalsByQuery
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String listTerminalsByQuery(Map<String, Object> map, Integer queryId, Principal principal, String p, String sort, String order, HttpServletRequest request, Date queryDate)
   :outertype: TerminalController

   List terminals by query URL.

   :param map: the map
   :param queryId: the query id
   :param principal: the principal
   :param p: the page number
   :param sort: the fields for sorting terminals
   :param order: the order for sorting terminals
   :param request: the request
   :param queryDate: the date the date
   :return: the petition response

newInstallation
^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String newInstallation(Installation installation, BindingResult result, Map<String, Object> map, String matricula, HttpServletRequest request, Principal principal)
   :outertype: TerminalController

   New installation URL.

   :param installation: the installation
   :param result: the result
   :param map: the map
   :param matricula: the generated id
   :param request: the request
   :param principal: the principal
   :return: the petition response

newInstallationForm
^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String newInstallationForm(Map<String, Object> map, String matricula)
   :outertype: TerminalController

   New installation form URL.

   :param map: the map
   :param matricula: the generated id
   :return: the petition response

redirectToTerminalModels
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String redirectToTerminalModels()
   :outertype: TerminalController

   Redirect to terminal models URL.

   :return: the petition response

redirectToTerminals
^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String redirectToTerminals()
   :outertype: TerminalController

   Redirect to terminals URL.

   :return: the petition response

requestTerminalUpdateById
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String requestTerminalUpdateById(Integer terminalId, RedirectAttributes redirectAttributes, Principal principal)
   :outertype: TerminalController

   Request terminal update by id URL.

   :param terminalId: the terminal id
   :param redirectAttributes: the redirect attributes
   :param principal: the principal
   :return: the petition response

requestTerminalsUpdateByQuery
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String requestTerminalsUpdateByQuery(String queryId, Principal principal, RedirectAttributes redirectAttributes)
   :outertype: TerminalController

   Request query results' terminals update URL.

   :param queryId: the query id
   :param principal: the principal
   :param redirectAttributes: the redirect attributes
   :return: the petition response

terminalDetails
^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String terminalDetails(Integer terminalId, Map<String, Object> map, HttpServletRequest request, Principal principal, Long dateTime, String preselectedTab)
   :outertype: TerminalController

   Terminal details URL.

   :param terminalId: the terminal id
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

terminalModelDetails
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String terminalModelDetails(Integer terminalModelId, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: TerminalController

   Terminal model details URL.

   :param terminalModelId: the terminal model id
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

terminalSummary
^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String terminalSummary(ArrayList<Integer> terminalIds, Map<String, Object> model, HttpServletRequest request, Principal principal, Long dateTime)
   :outertype: TerminalController

updateTerminal
^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String updateTerminal(Terminal terminal, BindingResult result, Map<String, Object> map, RedirectAttributes redirectAttributes, HttpServletRequest request, Principal principal)
   :outertype: TerminalController

   Update terminal URL.

   :param terminal: the terminal
   :param result: the result
   :param map: the map
   :param redirectAttributes: the redirect attributes
   :param request: the request
   :param principal: the principal
   :return: the petition response

updateTerminalModel
^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String updateTerminalModel(TerminalModel terminalModel, CommonsMultipartFile photo, BindingResult result, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: TerminalController

   Update terminal model URL.

   :param terminalModel: the terminal model
   :param photo: the photo
   :param result: the result
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

viewNewTerminal
^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String viewNewTerminal(Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: TerminalController

   New terminal form URL.

   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

