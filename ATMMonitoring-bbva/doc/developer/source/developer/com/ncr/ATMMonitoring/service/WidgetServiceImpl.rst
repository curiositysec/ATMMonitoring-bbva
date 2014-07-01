.. java:import:: org.apache.log4j Logger

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: java.util Locale

.. java:import:: java.util Set

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.pojo.Dashboard

.. java:import:: com.ncr ATMMonitoring.pojo.Query

.. java:import:: com.ncr ATMMonitoring.pojo.User

.. java:import:: com.ncr ATMMonitoring.pojo.Widget

.. java:import:: com.ncr ATMMonitoring.pojo.WidgetCategory

.. java:import:: com.ncr ATMMonitoring.dao.WidgetCategoryDAO

.. java:import:: com.ncr ATMMonitoring.dao.WidgetDAO

WidgetServiceImpl
=================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class WidgetServiceImpl implements WidgetService

   The Class WidgetServiceImpl. Default implementation of the WidgetService.

   :author: Rafael Luque (rafael.luque@osoco.es)

Methods
-------
addOrRemoveWidgetToLibrary
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addOrRemoveWidgetToLibrary(Integer widgetId, User user, Integer categoryId)
   :outertype: WidgetServiceImpl

addWidgetsFromLibrary
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addWidgetsFromLibrary(List<Integer> widgetIds, User user)
   :outertype: WidgetServiceImpl

copyDefaultWidgetsToUserDashboard
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Widget> copyDefaultWidgetsToUserDashboard(User user)
   :outertype: WidgetServiceImpl

createWidgetForUser
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void createWidgetForUser(Widget widget, User loggedUser)
   :outertype: WidgetServiceImpl

deleteWidgetFromUser
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void deleteWidgetFromUser(Integer widgetId, User user)
   :outertype: WidgetServiceImpl

executeQuery
^^^^^^^^^^^^

.. java:method:: @Override public List<?> executeQuery(Widget widget, Locale locale)
   :outertype: WidgetServiceImpl

findCategoryById
^^^^^^^^^^^^^^^^

.. java:method:: @Override public WidgetCategory findCategoryById(Integer categoryId)
   :outertype: WidgetServiceImpl

findDefaultWidgets
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Widget> findDefaultWidgets()
   :outertype: WidgetServiceImpl

findLibraryWidgetsByCategory
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<WidgetCategory> findLibraryWidgetsByCategory()
   :outertype: WidgetServiceImpl

findWidgetById
^^^^^^^^^^^^^^

.. java:method:: @Override public Widget findWidgetById(int widgetId)
   :outertype: WidgetServiceImpl

isWidgetOwnedByUser
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Boolean isWidgetOwnedByUser(Widget widget, User user)
   :outertype: WidgetServiceImpl

saveWidget
^^^^^^^^^^

.. java:method:: @Override public void saveWidget(Widget widget)
   :outertype: WidgetServiceImpl

setWidgetDefault
^^^^^^^^^^^^^^^^

.. java:method:: @Override public void setWidgetDefault(Integer widgetId, User user, boolean isDefault)
   :outertype: WidgetServiceImpl

