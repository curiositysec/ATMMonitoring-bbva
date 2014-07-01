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

WidgetCategory
==============

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class WidgetCategory implements Serializable

   The widget category POJO

   :author: jmartin

Constructors
------------
WidgetCategory
^^^^^^^^^^^^^^

.. java:constructor:: public WidgetCategory()
   :outertype: WidgetCategory

   Default constructor

Methods
-------
getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: WidgetCategory

   Get the id

   :return: The id

getName
^^^^^^^

.. java:method:: public String getName()
   :outertype: WidgetCategory

   Get the name

   :return: the name

getWidgets
^^^^^^^^^^

.. java:method:: public List<Widget> getWidgets()
   :outertype: WidgetCategory

   Get widgets

   :return: The widgets

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: WidgetCategory

   Set the id

   :param id: The id

setName
^^^^^^^

.. java:method:: public void setName(String name)
   :outertype: WidgetCategory

   Set the name

   :param name: The name

setWidgets
^^^^^^^^^^

.. java:method:: public void setWidgets(List<Widget> widgets)
   :outertype: WidgetCategory

   Set the widgets

   :param widgets: The widgets

