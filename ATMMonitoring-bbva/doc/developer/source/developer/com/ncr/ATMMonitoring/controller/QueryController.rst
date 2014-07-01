.. java:import:: java.io BufferedOutputStream

.. java:import:: java.io IOException

.. java:import:: java.io OutputStream

.. java:import:: java.io OutputStreamWriter

.. java:import:: java.security Principal

.. java:import:: java.text DateFormat

.. java:import:: java.text SimpleDateFormat

.. java:import:: java.util ArrayList

.. java:import:: java.util Date

.. java:import:: java.util List

.. java:import:: java.util Locale

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: javax.servlet.http HttpServletRequest

.. java:import:: javax.servlet.http HttpServletResponse

.. java:import:: org.apache.log4j Logger

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.beans.factory.annotation Value

.. java:import:: org.springframework.beans.support PagedListHolder

.. java:import:: org.springframework.stereotype Controller

.. java:import:: org.springframework.web.bind.annotation ModelAttribute

.. java:import:: org.springframework.web.bind.annotation RequestMapping

.. java:import:: org.springframework.web.bind.annotation RequestMethod

.. java:import:: org.springframework.web.servlet.mvc.support RedirectAttributes

.. java:import:: org.springframework.web.servlet.support RequestContextUtils

.. java:import:: org.springframework.web.util WebUtils

.. java:import:: com.ncr ATMMonitoring.pojo.Query

.. java:import:: com.ncr ATMMonitoring.pojo.Terminal

.. java:import:: com.ncr ATMMonitoring.service.QueryService

QueryController
===============

.. java:package:: com.ncr.ATMMonitoring.controller
   :noindex:

.. java:type:: @Controller public class QueryController extends GenericController

   The Class QueryController. Controller for handling query related HTTP petitions.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Fields
------
DEFAULT_ORDER
^^^^^^^^^^^^^

.. java:field:: public static final String DEFAULT_ORDER
   :outertype: QueryController

   The default sorting order for terminals in csv downloads.

DEFAULT_SORT
^^^^^^^^^^^^

.. java:field:: public static final String DEFAULT_SORT
   :outertype: QueryController

   The default field for sorting terminals in csv downloads.

Methods
-------
createQuery
^^^^^^^^^^^

.. java:method:: @RequestMapping public String createQuery(Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: QueryController

   Create query URL.

   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

deleteUserQuery
^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String deleteUserQuery(Integer queryId, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: QueryController

   Delete user query URL.

   :param queryId: the query id
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

downloadResultsCsv
^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public void downloadResultsCsv(Query query, HttpServletResponse response, HttpServletRequest request, String sort, String order)
   :outertype: QueryController

   Download query results as csv URL.

   :param query: the query
   :param response: the response
   :param request: the request
   :param sort: the fields for sorting the results
   :param order: the sorting order

listQueries
^^^^^^^^^^^

.. java:method:: @RequestMapping public String listQueries(Map<String, Object> map, HttpServletRequest request, Principal principal, String p)
   :outertype: QueryController

   List queries URL.

   :param map: the map
   :param request: the request
   :param principal: the principal
   :param p: the page number
   :return: the petition response

redirectFromWrongResults
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String redirectFromWrongResults()
   :outertype: QueryController

   Wrong download query results as csv URL.

   :return: the petition response

redirectFromWrongResultsExport
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String redirectFromWrongResultsExport()
   :outertype: QueryController

   Wrong download query results as csv URL.

   :return: the petition response

redirectToQueries
^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String redirectToQueries()
   :outertype: QueryController

   Redirect to queries URL.

   :return: the petition response

saveOrUpdateQuery
^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String saveOrUpdateQuery(Query query, Map<String, Object> map, HttpServletRequest request, Principal principal, RedirectAttributes redirectAttributes, String p, String sort, String order) throws Exception
   :outertype: QueryController

   Save or update query URL.

   :param query: the query
   :param map: the map
   :param request: the request
   :param principal: the principal
   :param redirectAttributes: the redirect attributes
   :param p: the page number
   :param sort: the sort
   :param order: the order
   :return: the petition response

selectUserQuery
^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String selectUserQuery(Query query, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: QueryController

   Select user query URL.

   :param query: the query
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

showUserQuery
^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String showUserQuery(Integer queryId, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: QueryController

   Show user query URL.

   :param queryId: the query id
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

