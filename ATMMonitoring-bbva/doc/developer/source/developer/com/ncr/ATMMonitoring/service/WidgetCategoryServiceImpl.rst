.. java:import:: java.util List

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.dao.WidgetCategoryDAO

.. java:import:: com.ncr ATMMonitoring.pojo.WidgetCategory

WidgetCategoryServiceImpl
=========================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class WidgetCategoryServiceImpl implements WidgetCategoryService

   The WidgetCategoryServiceImpl The default implementation for WidgetCategoryService

   :author: jmartin

Methods
-------
findAll
^^^^^^^

.. java:method:: @Override public List<WidgetCategory> findAll()
   :outertype: WidgetCategoryServiceImpl

updateWidgetCategory
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void updateWidgetCategory(WidgetCategory widgetCategory)
   :outertype: WidgetCategoryServiceImpl

