.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.JxfsComponent

JxfsComponentDAO
================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface JxfsComponentDAO

   The Interface JxfsComponentDAO. Dao with the operations for managing JxfsComponent Pojos.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addJxfsComponent
^^^^^^^^^^^^^^^^

.. java:method:: public void addJxfsComponent(JxfsComponent jxfsComponent)
   :outertype: JxfsComponentDAO

   Adds the jxfs component.

   :param jxfsComponent: the jxfs component

getJxfsComponent
^^^^^^^^^^^^^^^^

.. java:method:: public JxfsComponent getJxfsComponent(Integer id)
   :outertype: JxfsComponentDAO

   Gets the jxfs component with the given id.

   :param id: the id
   :return: the jxfs component, or null if it doesn't exist

listJxfsComponents
^^^^^^^^^^^^^^^^^^

.. java:method:: public List<JxfsComponent> listJxfsComponents()
   :outertype: JxfsComponentDAO

   Lists all jxfs components.

   :return: the list

