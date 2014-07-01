.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.PhysicalCashUnit

PhysicalCashUnitDAO
===================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface PhysicalCashUnitDAO

   The Interface PhysicalCashUnitDAO. Dao with the operations for managing PhysicalCashUnit Pojos.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addPhysicalCashUnit
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addPhysicalCashUnit(PhysicalCashUnit physicalCashUnit)
   :outertype: PhysicalCashUnitDAO

   Adds the physical cash unit.

   :param physicalCashUnit: the physical cash unit

getPhysicalCashUnit
^^^^^^^^^^^^^^^^^^^

.. java:method:: public PhysicalCashUnit getPhysicalCashUnit(Integer id)
   :outertype: PhysicalCashUnitDAO

   Gets the physical cash unit with the given id.

   :param id: the id
   :return: the physical cash unit, or null if it doesn't exist

listPhysicalCashUnits
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<PhysicalCashUnit> listPhysicalCashUnits()
   :outertype: PhysicalCashUnitDAO

   Lists all physical cash units.

   :return: the list

