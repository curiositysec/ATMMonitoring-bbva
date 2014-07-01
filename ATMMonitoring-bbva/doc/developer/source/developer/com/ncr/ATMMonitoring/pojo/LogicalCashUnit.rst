.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Set

.. java:import:: javax.persistence Column

.. java:import:: javax.persistence Entity

.. java:import:: javax.persistence FetchType

.. java:import:: javax.persistence GeneratedValue

.. java:import:: javax.persistence GenerationType

.. java:import:: javax.persistence Id

.. java:import:: javax.persistence JoinColumn

.. java:import:: javax.persistence ManyToOne

.. java:import:: javax.persistence OneToMany

.. java:import:: javax.persistence OrderBy

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

.. java:import:: org.hibernate.annotations Cascade

.. java:import:: org.hibernate.annotations CascadeType

.. java:import:: org.hibernate.annotations Type

.. java:import:: com.ncr ATMMonitoring.utils.Utils

LogicalCashUnit
===============

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class LogicalCashUnit

   The LogicalCashUnit Pojo.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
equals
^^^^^^

.. java:method:: @Override public boolean equals(Object obj)
   :outertype: LogicalCashUnit

getCurrencyId
^^^^^^^^^^^^^

.. java:method:: public String getCurrencyId()
   :outertype: LogicalCashUnit

   Gets the currency id.

   :return: the currencyId

getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: LogicalCashUnit

   Gets the id.

   :return: the id

getMaximum
^^^^^^^^^^

.. java:method:: public Integer getMaximum()
   :outertype: LogicalCashUnit

   Gets the maximum.

   :return: the maximum

getMinimum
^^^^^^^^^^

.. java:method:: public Integer getMinimum()
   :outertype: LogicalCashUnit

   Gets the minimum.

   :return: the minimum

getName
^^^^^^^

.. java:method:: public String getName()
   :outertype: LogicalCashUnit

   Gets the name.

   :return: the name

getPhysicalCashUnits
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<PhysicalCashUnit> getPhysicalCashUnits()
   :outertype: LogicalCashUnit

   Gets the physical cash units.

   :return: the physicalCashUnits

getType
^^^^^^^

.. java:method:: public String getType()
   :outertype: LogicalCashUnit

   Gets the type.

   :return: the type

getUnitId
^^^^^^^^^

.. java:method:: public Integer getUnitId()
   :outertype: LogicalCashUnit

   Gets the unit id.

   :return: the unitId

getValues
^^^^^^^^^

.. java:method:: public String getValues()
   :outertype: LogicalCashUnit

   Gets the values.

   :return: the values

getValuesSplit
^^^^^^^^^^^^^^

.. java:method:: public List<Integer> getValuesSplit()
   :outertype: LogicalCashUnit

   Gets the values split by the separator.

   :return: the values

getXfsComponent
^^^^^^^^^^^^^^^

.. java:method:: public XfsComponent getXfsComponent()
   :outertype: LogicalCashUnit

   Gets the xfs component.

   :return: the xfsComponent

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: LogicalCashUnit

setCurrencyId
^^^^^^^^^^^^^

.. java:method:: public void setCurrencyId(String currencyId)
   :outertype: LogicalCashUnit

   Sets the currency id.

   :param currencyId: the currencyId to set

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: LogicalCashUnit

   Sets the id.

   :param id: the id to set

setMaximum
^^^^^^^^^^

.. java:method:: public void setMaximum(Integer maximum)
   :outertype: LogicalCashUnit

   Sets the maximum.

   :param maximum: the maximum to set

setMinimum
^^^^^^^^^^

.. java:method:: public void setMinimum(Integer minimum)
   :outertype: LogicalCashUnit

   Sets the minimum.

   :param minimum: the minimum to set

setName
^^^^^^^

.. java:method:: public void setName(String name)
   :outertype: LogicalCashUnit

   Sets the name.

   :param name: the name to set

setPhysicalCashUnits
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setPhysicalCashUnits(Set<PhysicalCashUnit> physicalCashUnits)
   :outertype: LogicalCashUnit

   Sets the physical cash units.

   :param physicalCashUnits: the physicalCashUnits to set

setType
^^^^^^^

.. java:method:: public void setType(String type)
   :outertype: LogicalCashUnit

   Sets the type.

   :param type: the type to set

setUnitId
^^^^^^^^^

.. java:method:: public void setUnitId(Integer unitId)
   :outertype: LogicalCashUnit

   Sets the unit id.

   :param unitId: the unitId to set

setValues
^^^^^^^^^

.. java:method:: public void setValues(String values)
   :outertype: LogicalCashUnit

   Sets the values.

   :param values: the values to set

setValues
^^^^^^^^^

.. java:method:: public void setValues(List<Integer> values)
   :outertype: LogicalCashUnit

   Sets the values.

   :param values: the values to set

setXfsComponent
^^^^^^^^^^^^^^^

.. java:method:: public void setXfsComponent(XfsComponent xfsComponent)
   :outertype: LogicalCashUnit

   Sets the xfs component.

   :param xfsComponent: the xfsComponent to set

