.. java:import:: java.util List

.. java:import:: org.hibernate Criteria

.. java:import:: org.hibernate.criterion Restrictions

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.WidgetCategory

WidgetCategoryDAOImpl
=====================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class WidgetCategoryDAOImpl extends AbstractGenericDAO<WidgetCategory> implements WidgetCategoryDAO

   The Class WidgetCategoryDAOImpl. Default implementation of WidgetCategoryDAO.

   :author: jmartin

Methods
-------
findAll
^^^^^^^

.. java:method:: @Override public List<WidgetCategory> findAll()
   :outertype: WidgetCategoryDAOImpl

findCategoryById
^^^^^^^^^^^^^^^^

.. java:method:: @Override public WidgetCategory findCategoryById(Integer categoryId)
   :outertype: WidgetCategoryDAOImpl

findLibraryWidgetsByCategory
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<WidgetCategory> findLibraryWidgetsByCategory()
   :outertype: WidgetCategoryDAOImpl

updateWidgetCategory
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void updateWidgetCategory(WidgetCategory widgetCategory)
   :outertype: WidgetCategoryDAOImpl

