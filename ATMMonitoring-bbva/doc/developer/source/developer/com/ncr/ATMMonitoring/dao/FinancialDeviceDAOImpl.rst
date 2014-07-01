.. java:import:: java.util List

.. java:import:: org.apache.log4j Logger

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.FinancialDevice

FinancialDeviceDAOImpl
======================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class FinancialDeviceDAOImpl extends AbstractGenericDAO<FinancialDevice> implements FinancialDeviceDAO

   The Class FinancialDeviceDAOImpl. Default implementation of FinancialDeviceDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addFinancialDevice
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addFinancialDevice(FinancialDevice financialDevice)
   :outertype: FinancialDeviceDAOImpl

getFinancialDevice
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public FinancialDevice getFinancialDevice(Integer id)
   :outertype: FinancialDeviceDAOImpl

listFinancialDevices
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<FinancialDevice> listFinancialDevices()
   :outertype: FinancialDeviceDAOImpl

removeFinancialDevice
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void removeFinancialDevice(Integer id)
   :outertype: FinancialDeviceDAOImpl

