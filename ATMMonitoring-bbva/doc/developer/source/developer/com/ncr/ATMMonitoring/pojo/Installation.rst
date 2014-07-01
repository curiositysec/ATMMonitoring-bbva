.. java:import:: java.util Map

.. java:import:: java.util TreeMap

.. java:import:: javax.persistence Column

.. java:import:: javax.persistence Entity

.. java:import:: javax.persistence GeneratedValue

.. java:import:: javax.persistence GenerationType

.. java:import:: javax.persistence Id

.. java:import:: javax.persistence JoinColumn

.. java:import:: javax.persistence ManyToOne

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

.. java:import:: org.hibernate.annotations Cascade

.. java:import:: org.hibernate.annotations CascadeType

.. java:import:: com.ncr ATMMonitoring.utils.Operation

Installation
============

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class Installation extends Auditable

   The Installation Pojo.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
getComboboxes
^^^^^^^^^^^^^

.. java:method:: public static Map<String, Map> getComboboxes()
   :outertype: Installation

   Gets the comboboxes data for the query GUI.

   :return: the comboboxes data

getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: Installation

   Gets the id.

   :return: the id

getIp
^^^^^

.. java:method:: public String getIp()
   :outertype: Installation

   Gets the ip.

   :return: the ip

getLocation
^^^^^^^^^^^

.. java:method:: public Location getLocation()
   :outertype: Installation

   Gets the location.

   :return: the location

getLocationClass
^^^^^^^^^^^^^^^^

.. java:method:: public String getLocationClass()
   :outertype: Installation

   Gets the location class.

   :return: the location class

getLocationclasses
^^^^^^^^^^^^^^^^^^

.. java:method:: public static String getLocationclasses()
   :outertype: Installation

   Gets the location classes.

   :return: the location classes

getLuCode
^^^^^^^^^

.. java:method:: public String getLuCode()
   :outertype: Installation

   Gets the lu code.

   :return: the lu code

getPost
^^^^^^^

.. java:method:: public String getPost()
   :outertype: Installation

   Gets the post.

   :return: the post

getProcessed
^^^^^^^^^^^^

.. java:method:: public Boolean getProcessed()
   :outertype: Installation

   Gets the processed.

   :return: the processed

getType
^^^^^^^

.. java:method:: public String getType()
   :outertype: Installation

   Gets the type.

   :return: the type

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: Installation

   Sets the id.

   :param id: the id to set

setIp
^^^^^

.. java:method:: public void setIp(String ip)
   :outertype: Installation

   Sets the ip.

   :param ip: the new ip

setLocation
^^^^^^^^^^^

.. java:method:: public void setLocation(Location location)
   :outertype: Installation

   Sets the location.

   :param location: the new location

setLocationClass
^^^^^^^^^^^^^^^^

.. java:method:: public void setLocationClass(String locationClass)
   :outertype: Installation

   Sets the location class.

   :param locationClass: the new location class

setLuCode
^^^^^^^^^

.. java:method:: public void setLuCode(String luCode)
   :outertype: Installation

   Sets the lu code.

   :param luCode: the new lu code

setPost
^^^^^^^

.. java:method:: public void setPost(String post)
   :outertype: Installation

   Sets the post.

   :param post: the new post

setProcessed
^^^^^^^^^^^^

.. java:method:: public void setProcessed(Boolean processed)
   :outertype: Installation

   Sets the processed.

   :param processed: the new processed

setType
^^^^^^^

.. java:method:: public void setType(String type)
   :outertype: Installation

   Sets the type.

   :param type: the new type

