.. java:import:: java.util List

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.dao.PhysicalCashUnitDAO

.. java:import:: com.ncr ATMMonitoring.pojo.PhysicalCashUnit

PhysicalCashUnitServiceImpl
===========================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class PhysicalCashUnitServiceImpl implements PhysicalCashUnitService

   The Class PhysicalCashUnitServiceImpl. Default implementation of the PhysicalCashUnitService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addPhysicalCashUnit
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addPhysicalCashUnit(PhysicalCashUnit physicalCashUnit)
   :outertype: PhysicalCashUnitServiceImpl

getPhysicalCashUnit
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public PhysicalCashUnit getPhysicalCashUnit(Integer id)
   :outertype: PhysicalCashUnitServiceImpl

listPhysicalCashUnits
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<PhysicalCashUnit> listPhysicalCashUnits()
   :outertype: PhysicalCashUnitServiceImpl

