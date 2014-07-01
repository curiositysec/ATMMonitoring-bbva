.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.PhysicalCashUnit

PhysicalCashUnitService
=======================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface PhysicalCashUnitService

   The Interface PhysicalCashUnitService. It contains the physical cash unit related methods.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addPhysicalCashUnit
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addPhysicalCashUnit(PhysicalCashUnit physicalCashUnit)
   :outertype: PhysicalCashUnitService

   Adds the physical cash unit.

   :param physicalCashUnit: the physical cash unit

getPhysicalCashUnit
^^^^^^^^^^^^^^^^^^^

.. java:method:: public PhysicalCashUnit getPhysicalCashUnit(Integer id)
   :outertype: PhysicalCashUnitService

   Gets the physical cash unit by its id.

   :param id: the physical cash unit id
   :return: the physical cash unit

listPhysicalCashUnits
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<PhysicalCashUnit> listPhysicalCashUnits()
   :outertype: PhysicalCashUnitService

   List physical cash units.

   :return: the physical cash unit list

