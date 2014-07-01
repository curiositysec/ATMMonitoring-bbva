.. java:import:: java.util List

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.dao.FinancialDeviceDAO

.. java:import:: com.ncr ATMMonitoring.pojo.FinancialDevice

FinancialDeviceServiceImpl
==========================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class FinancialDeviceServiceImpl implements FinancialDeviceService

   The Class FinancialDeviceServiceImpl. Default implementation of the FinancialDeviceService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addFinancialDevice
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addFinancialDevice(FinancialDevice financialDevice)
   :outertype: FinancialDeviceServiceImpl

getFinancialDevice
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public FinancialDevice getFinancialDevice(Integer id)
   :outertype: FinancialDeviceServiceImpl

listFinancialDevices
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<FinancialDevice> listFinancialDevices()
   :outertype: FinancialDeviceServiceImpl

removeFinancialDevice
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void removeFinancialDevice(Integer id)
   :outertype: FinancialDeviceServiceImpl

