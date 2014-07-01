.. java:import:: java.security Principal

.. java:import:: java.util Date

.. java:import:: java.util Map

.. java:import:: javax.servlet.http HttpServletRequest

.. java:import:: javax.validation Valid

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

.. java:import:: com.ncr ATMMonitoring.controller.propertyeditor.DatePropertyEditor

.. java:import:: com.ncr ATMMonitoring.pojo.Installation

.. java:import:: com.ncr ATMMonitoring.pojo.Location

.. java:import:: com.ncr ATMMonitoring.service.InstallationService

.. java:import:: com.ncr ATMMonitoring.service.LocationService

InstallationController
======================

.. java:package:: com.ncr.ATMMonitoring.controller
   :noindex:

.. java:type:: @Controller public class InstallationController extends GenericController

   The Class InstallationController. Controller for handling installation related HTTP petitions.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addInstallation
^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String addInstallation(Installation installation, BindingResult result, Map<String, Object> map, HttpServletRequest request, String p, Principal principal)
   :outertype: InstallationController

   Add installation URL.

   :param installation: the installation
   :param result: the result
   :param map: the map
   :param request: the request
   :param p: the page number
   :param principal: the principal
   :return: the petition response

addLocation
^^^^^^^^^^^

.. java:method:: @RequestMapping public String addLocation(Location location, BindingResult result, Map<String, Object> map, HttpServletRequest request, String p, Principal principal)
   :outertype: InstallationController

   Add location URL.

   :param location: the location
   :param result: the result
   :param map: the map
   :param request: the request
   :param p: the page number
   :param principal: the principal
   :return: the petition response

binder
^^^^^^

.. java:method:: @InitBinder protected void binder(WebDataBinder binder) throws Exception
   :outertype: InstallationController

   Binds custom editors.

   :param binder: the binder

deleteInstallation
^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String deleteInstallation(Integer installationId)
   :outertype: InstallationController

   Delete installation URL.

   :param installationId: the installation id
   :return: the petition response

deleteLocation
^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String deleteLocation(Integer locationId)
   :outertype: InstallationController

   Delete location URL.

   :param locationId: the location id
   :return: the petition response

installationDetails
^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String installationDetails(Integer installationId, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: InstallationController

   Installation details URL.

   :param installationId: the installation id
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

listInstallations
^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String listInstallations(Map<String, Object> map, Principal principal, String p, HttpServletRequest request)
   :outertype: InstallationController

   List installations URL.

   :param map: the map
   :param principal: the principal
   :param p: the page number
   :param request: the request
   :return: the petition response

listLocations
^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String listLocations(Map<String, Object> map, Principal principal, String p, HttpServletRequest request)
   :outertype: InstallationController

   List locations URL.

   :param map: the map
   :param principal: the principal
   :param p: the page number
   :param request: the request
   :return: the petition response

locationDetails
^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String locationDetails(Integer locationId, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: InstallationController

   Location details URL.

   :param locationId: the location id
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

redirectToInstallations
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String redirectToInstallations()
   :outertype: InstallationController

   Redirect to installations list URL.

   :return: the petition response

redirectToLocations
^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String redirectToLocations()
   :outertype: InstallationController

   Redirect to locations URL.

   :return: the petition response

updateInstallation
^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String updateInstallation(Installation installation, BindingResult result, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: InstallationController

   Update installation URL.

   :param installation: the installation
   :param result: the result
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

updateLocation
^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String updateLocation(Location location, BindingResult result, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: InstallationController

   Update location URL.

   :param location: the location
   :param result: the result
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

