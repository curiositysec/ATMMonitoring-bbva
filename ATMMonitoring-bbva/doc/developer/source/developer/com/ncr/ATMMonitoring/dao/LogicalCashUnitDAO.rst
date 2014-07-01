.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.LogicalCashUnit

LogicalCashUnitDAO
==================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface LogicalCashUnitDAO

   The Interface LogicalCashUnitDAO. Dao with the operations for managing LogicalCashUnit Pojos.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addLogicalCashUnit
^^^^^^^^^^^^^^^^^^

.. java:method:: public void addLogicalCashUnit(LogicalCashUnit logicalCashUnit)
   :outertype: LogicalCashUnitDAO

   Adds the logical cash unit.

   :param logicalCashUnit: the logical cash unit

getLogicalCashUnit
^^^^^^^^^^^^^^^^^^

.. java:method:: public LogicalCashUnit getLogicalCashUnit(Integer id)
   :outertype: LogicalCashUnitDAO

   Gets the logical cash unit with the given id.

   :param id: the id
   :return: the logical cash unit, or null if it doesn't exist

listLogicalCashUnits
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<LogicalCashUnit> listLogicalCashUnits()
   :outertype: LogicalCashUnitDAO

   Lists all logical cash units.

   :return: the list

