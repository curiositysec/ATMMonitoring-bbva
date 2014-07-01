.. java:import:: javax.persistence Column

.. java:import:: javax.persistence Entity

.. java:import:: javax.persistence FetchType

.. java:import:: javax.persistence GeneratedValue

.. java:import:: javax.persistence GenerationType

.. java:import:: javax.persistence Id

.. java:import:: javax.persistence JoinColumn

.. java:import:: javax.persistence ManyToOne

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

.. java:import:: org.hibernate.annotations Cascade

.. java:import:: org.hibernate.annotations CascadeType

.. java:import:: org.hibernate.annotations Type

PhysicalCashUnit
================

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class PhysicalCashUnit

   The PhysicalCashUnit Pojo.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
getHardwareSensor
^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getHardwareSensor()
   :outertype: PhysicalCashUnit

   Gets the hardware sensor.

   :return: the hardwareSensor

getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: PhysicalCashUnit

   Gets the id.

   :return: the id

getLogicalCashUnit
^^^^^^^^^^^^^^^^^^

.. java:method:: public LogicalCashUnit getLogicalCashUnit()
   :outertype: PhysicalCashUnit

   Gets the logical cash unit.

   :return: the logicalCashUnit

getMaximum
^^^^^^^^^^

.. java:method:: public Integer getMaximum()
   :outertype: PhysicalCashUnit

   Gets the maximum.

   :return: the maximum

getName
^^^^^^^

.. java:method:: public String getName()
   :outertype: PhysicalCashUnit

   Gets the name.

   :return: the name

getUnitId
^^^^^^^^^

.. java:method:: public Integer getUnitId()
   :outertype: PhysicalCashUnit

   Gets the unit id.

   :return: the unitId

setHardwareSensor
^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareSensor(Boolean hardwareSensor)
   :outertype: PhysicalCashUnit

   Sets the hardware sensor.

   :param hardwareSensor: the hardwareSensor to set

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: PhysicalCashUnit

   Sets the id.

   :param id: the id to set

setLogicalCashUnit
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setLogicalCashUnit(LogicalCashUnit logicalCashUnit)
   :outertype: PhysicalCashUnit

   Sets the logical cash unit.

   :param logicalCashUnit: the logicalCashUnit to set

setMaximum
^^^^^^^^^^

.. java:method:: public void setMaximum(Integer maximum)
   :outertype: PhysicalCashUnit

   Sets the maximum.

   :param maximum: the maximum to set

setName
^^^^^^^

.. java:method:: public void setName(String name)
   :outertype: PhysicalCashUnit

   Sets the name.

   :param name: the name to set

setUnitId
^^^^^^^^^

.. java:method:: public void setUnitId(Integer unitId)
   :outertype: PhysicalCashUnit

   Sets the unit id.

   :param unitId: the unitId to set

