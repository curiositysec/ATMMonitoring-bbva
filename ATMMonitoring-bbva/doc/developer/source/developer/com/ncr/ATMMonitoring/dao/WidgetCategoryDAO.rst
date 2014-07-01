.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.WidgetCategory

WidgetCategoryDAO
=================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface WidgetCategoryDAO

   The Interface WidgetCategoryDAO. Dao with the operations for managing Widget Category Pojos.

   :author: jmartin

Methods
-------
findAll
^^^^^^^

.. java:method:: public List<WidgetCategory> findAll()
   :outertype: WidgetCategoryDAO

   Find all widget category

   :return: A list with the widget category

findCategoryById
^^^^^^^^^^^^^^^^

.. java:method:: public WidgetCategory findCategoryById(Integer categoryId)
   :outertype: WidgetCategoryDAO

   Find a category by id

   :param categoryId: The category id
   :return: The widget category

findLibraryWidgetsByCategory
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<WidgetCategory> findLibraryWidgetsByCategory()
   :outertype: WidgetCategoryDAO

   Find all library widgets by category

   :return: A list with the category widgets

updateWidgetCategory
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void updateWidgetCategory(WidgetCategory widgetCategory)
   :outertype: WidgetCategoryDAO

   Update a widget category

   :param widgetCategory: The widget category

