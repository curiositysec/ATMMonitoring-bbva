.. java:import:: java.security Principal

.. java:import:: java.util ArrayList

.. java:import:: java.util Date

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: javax.servlet.http HttpServletRequest

.. java:import:: javax.validation Valid

.. java:import:: org.apache.log4j Logger

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.http HttpStatus

.. java:import:: org.springframework.stereotype Controller

.. java:import:: org.springframework.validation BindingResult

.. java:import:: org.springframework.web.bind WebDataBinder

.. java:import:: org.springframework.web.bind.annotation InitBinder

.. java:import:: org.springframework.web.bind.annotation ModelAttribute

.. java:import:: org.springframework.web.bind.annotation PathVariable

.. java:import:: org.springframework.web.bind.annotation RequestMapping

.. java:import:: org.springframework.web.bind.annotation RequestMethod

.. java:import:: org.springframework.web.bind.annotation RequestParam

.. java:import:: org.springframework.web.bind.annotation ResponseStatus

.. java:import:: com.ncr ATMMonitoring.controller.propertyeditor.DatePropertyEditor

.. java:import:: com.ncr ATMMonitoring.pojo.Query

.. java:import:: com.ncr ATMMonitoring.pojo.Widget

.. java:import:: com.ncr ATMMonitoring.pojo.WidgetCategory

.. java:import:: com.ncr ATMMonitoring.service.QueryService

.. java:import:: com.ncr ATMMonitoring.servicefacade.DashboardWidgetFacade

.. java:import:: com.ncr ATMMonitoring.utils.RegionType

.. java:import:: com.ncr ATMMonitoring.utils.WidgetQueryAssociationType

WidgetController
================

.. java:package:: com.ncr.ATMMonitoring.controller
   :noindex:

.. java:type:: @Controller public class WidgetController extends GenericController

   Controller for Widget related actions.

   :author: jmartin

Methods
-------
addFromLibrary
^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String addFromLibrary(ArrayList<Integer> widgetIds, Principal principal, HttpServletRequest request)
   :outertype: WidgetController

   Add a widget to user dashboard from library

   :param widgetIds: A list with the widgets ids
   :param principal: The principal user
   :return: The request response

addToLibrary
^^^^^^^^^^^^

.. java:method:: @RequestMapping public String addToLibrary(Integer widgetId, Integer categoryId, Principal principal, HttpServletRequest request)
   :outertype: WidgetController

   Add a widget to library

   :param widgetId: The widget id
   :param categoryId: The category id
   :param principal: The principal user
   :return: The request response

binder
^^^^^^

.. java:method:: @InitBinder protected void binder(WebDataBinder binder) throws Exception
   :outertype: WidgetController

   Binds custom editors.

   :param binder: the binder

createWidget
^^^^^^^^^^^^

.. java:method:: @RequestMapping public String createWidget(Map<String, Object> model, Principal principal, HttpServletRequest request)
   :outertype: WidgetController

   Show creates new widget form

   :param model: The model
   :param principal: The principal user
   :return: the request response

createWidgetFromLibrary
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String createWidgetFromLibrary(Map<String, Object> model, Principal principal, HttpServletRequest request)
   :outertype: WidgetController

   Creates a new widget from library

   :param model: The model
   :param principal: The principal user
   :return: The request response

deleteWidget
^^^^^^^^^^^^

.. java:method:: @RequestMapping @ResponseStatus public void deleteWidget(Integer widgetId, Principal principal, HttpServletRequest request)
   :outertype: WidgetController

   Delete a widget

   :param widgetId: The widget id
   :param principal: The principal user

editWidget
^^^^^^^^^^

.. java:method:: @RequestMapping public String editWidget(Map<String, Object> model, Integer widgetId, Principal principal, HttpServletRequest request)
   :outertype: WidgetController

   Edit a widget

   :param model: The model
   :param widgetId: The widget id
   :param principal: The principal user
   :return: The request response

removeFromLibrary
^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping @ResponseStatus public void removeFromLibrary(Integer widgetId, Principal principal, HttpServletRequest request)
   :outertype: WidgetController

   Remove a widget from library

   :param widgetId: The widget id
   :param principal: The principal user

setAsDefault
^^^^^^^^^^^^

.. java:method:: @RequestMapping @ResponseStatus public void setAsDefault(Integer widgetId, Principal principal, HttpServletRequest request)
   :outertype: WidgetController

   Set a widget as default

   :param widgetId: The widget id
   :param principal: The principal user

showAddToLibraryForm
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String showAddToLibraryForm(Map<String, Object> model, Integer widgetId, Principal principal, HttpServletRequest request)
   :outertype: WidgetController

   Show add widget to library form

   :param model: The model
   :param widgetId: The widget id
   :param principal: The principal user
   :return: The petition response

unsetAsDefault
^^^^^^^^^^^^^^

.. java:method:: @RequestMapping @ResponseStatus public void unsetAsDefault(Integer widgetId, Principal principal, HttpServletRequest request)
   :outertype: WidgetController

   Unset a widget as default

   :param widgetId: The widget id
   :param principal: The principal user

updateWidget
^^^^^^^^^^^^

.. java:method:: @RequestMapping public String updateWidget(Widget widget, BindingResult result, Map<String, Object> model, HttpServletRequest request, Principal principal)
   :outertype: WidgetController

   Update a widget

   :param widget: The widget
   :param result: The binding result
   :param model: The model
   :param request: The request
   :param principal: The principal user
   :return: The request response

