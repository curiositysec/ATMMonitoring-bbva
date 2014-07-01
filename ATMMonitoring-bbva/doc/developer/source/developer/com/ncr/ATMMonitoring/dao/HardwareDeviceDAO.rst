.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.HardwareDevice

HardwareDeviceDAO
=================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface HardwareDeviceDAO

   The Interface HardwareDeviceDAO. Dao with the operations for managing HardwareDevice Pojos.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addHardwareDevice
^^^^^^^^^^^^^^^^^

.. java:method:: public void addHardwareDevice(HardwareDevice hardwareDevice)
   :outertype: HardwareDeviceDAO

   Adds the hardware device.

   :param hardwareDevice: the hardware device

getHardwareDevice
^^^^^^^^^^^^^^^^^

.. java:method:: public HardwareDevice getHardwareDevice(Integer id)
   :outertype: HardwareDeviceDAO

   Gets the hardware device with the given id.

   :param id: the id
   :return: the hardware device, or null if it doesn't exist

listHardwareDevices
^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<HardwareDevice> listHardwareDevices()
   :outertype: HardwareDeviceDAO

   Lists all hardware devices.

   :return: the list

removeHardwareDevice
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void removeHardwareDevice(Integer id)
   :outertype: HardwareDeviceDAO

   Removes the hardware device with the given id.

   :param id: the id

