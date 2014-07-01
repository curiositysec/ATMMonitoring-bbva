.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.Widget

WidgetDAO
=========

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface WidgetDAO

   The Interface WidgetDAO. Dao with the operations for managing Widget Pojos.

   :author: Rafael Luque (rafael.luque@osoco.es)

Methods
-------
delete
^^^^^^

.. java:method:: public void delete(Widget widget)
   :outertype: WidgetDAO

findById
^^^^^^^^

.. java:method:: public Widget findById(int id)
   :outertype: WidgetDAO

   Find widget by id.

   :param id: the id
   :return: the widget, or null if it doesn't exist

findDefaultWidgets
^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Widget> findDefaultWidgets()
   :outertype: WidgetDAO

   Find default widgets.

   :return: the list

save
^^^^

.. java:method:: public void save(Widget widget)
   :outertype: WidgetDAO

   Saves a widget.

   :param widget: the widget

update
^^^^^^

.. java:method:: public void update(Widget widget)
   :outertype: WidgetDAO

   Updates widget.

   :param widget: the widget

