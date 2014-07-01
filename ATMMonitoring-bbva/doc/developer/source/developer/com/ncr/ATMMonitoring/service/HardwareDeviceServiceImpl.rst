.. java:import:: java.util List

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.dao.HardwareDeviceDAO

.. java:import:: com.ncr ATMMonitoring.pojo.HardwareDevice

HardwareDeviceServiceImpl
=========================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class HardwareDeviceServiceImpl implements HardwareDeviceService

   The Class HardwareDeviceServiceImpl. Default implementation of the HardwareDeviceService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addHardwareDevice
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addHardwareDevice(HardwareDevice hardwareDevice)
   :outertype: HardwareDeviceServiceImpl

getHardwareDevice
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public HardwareDevice getHardwareDevice(Integer id)
   :outertype: HardwareDeviceServiceImpl

listHardwareDevices
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<HardwareDevice> listHardwareDevices()
   :outertype: HardwareDeviceServiceImpl

removeHardwareDevice
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void removeHardwareDevice(Integer id)
   :outertype: HardwareDeviceServiceImpl

