.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.FinancialDevice

FinancialDeviceService
======================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface FinancialDeviceService

   The Interface FinancialDeviceService. It contains the financial device related methods.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addFinancialDevice
^^^^^^^^^^^^^^^^^^

.. java:method:: public void addFinancialDevice(FinancialDevice financialDevice)
   :outertype: FinancialDeviceService

   Adds the financial device.

   :param financialDevice: the financial device

getFinancialDevice
^^^^^^^^^^^^^^^^^^

.. java:method:: public FinancialDevice getFinancialDevice(Integer id)
   :outertype: FinancialDeviceService

   Gets the financial device by its id.

   :param id: the financial device id
   :return: the financial device

listFinancialDevices
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<FinancialDevice> listFinancialDevices()
   :outertype: FinancialDeviceService

   List all financial devices.

   :return: the list

removeFinancialDevice
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void removeFinancialDevice(Integer id)
   :outertype: FinancialDeviceService

   Removes the financial device by its id..

   :param id: the financial device id

