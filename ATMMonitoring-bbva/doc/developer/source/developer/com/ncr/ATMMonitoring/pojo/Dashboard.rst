.. java:import:: java.io Serializable

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: javax.persistence Column

.. java:import:: javax.persistence Entity

.. java:import:: javax.persistence FetchType

.. java:import:: javax.persistence GeneratedValue

.. java:import:: javax.persistence GenerationType

.. java:import:: javax.persistence Id

.. java:import:: javax.persistence OneToMany

.. java:import:: javax.persistence OrderBy

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

.. java:import:: org.hibernate.annotations Cascade

.. java:import:: org.hibernate.annotations CascadeType

Dashboard
=========

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class Dashboard implements Serializable

   The Dashboard Pojo.

   :author: Rafael Luque (rafael.luque@osoco.es)

Constructors
------------
Dashboard
^^^^^^^^^

.. java:constructor:: public Dashboard()
   :outertype: Dashboard

   Instantiates a new dashboard.

Methods
-------
getColumns
^^^^^^^^^^

.. java:method:: public Integer getColumns()
   :outertype: Dashboard

   Gets the columns.

   :return: the columns

getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: Dashboard

   Gets the id.

   :return: the id

getVisibleWidgets
^^^^^^^^^^^^^^^^^

.. java:method:: public List<Widget> getVisibleWidgets()
   :outertype: Dashboard

   Gets the visible widgets.

   :return: the visible widgets

getWidgets
^^^^^^^^^^

.. java:method:: public List<Widget> getWidgets()
   :outertype: Dashboard

   Gets the widgets.

   :return: the widgets

setColumns
^^^^^^^^^^

.. java:method:: public void setColumns(Integer columns)
   :outertype: Dashboard

   Sets the columns.

   :param columns: the new columns

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: Dashboard

   Sets the id.

   :param id: the new id

setWidgets
^^^^^^^^^^

.. java:method:: public void setWidgets(List<Widget> widgets)
   :outertype: Dashboard

   Sets the widgets.

   :param widgets: the new widgets

