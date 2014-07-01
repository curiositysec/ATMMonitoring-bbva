.. java:import:: java.util List

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.dao.LogicalCashUnitDAO

.. java:import:: com.ncr ATMMonitoring.pojo.LogicalCashUnit

LogicalCashUnitServiceImpl
==========================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class LogicalCashUnitServiceImpl implements LogicalCashUnitService

   The Class LogicalCashUnitServiceImpl. Default implementation of the LogicalCashUnitService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addLogicalCashUnit
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addLogicalCashUnit(LogicalCashUnit logicalCashUnit)
   :outertype: LogicalCashUnitServiceImpl

getLogicalCashUnit
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public LogicalCashUnit getLogicalCashUnit(Integer id)
   :outertype: LogicalCashUnitServiceImpl

listLogicalCashUnits
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<LogicalCashUnit> listLogicalCashUnits()
   :outertype: LogicalCashUnitServiceImpl

