.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.HardwareDevice

HardwareDeviceService
=====================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface HardwareDeviceService

   The Interface HardwareDeviceService. It contains the hardware related methods.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addHardwareDevice
^^^^^^^^^^^^^^^^^

.. java:method:: public void addHardwareDevice(HardwareDevice hardwareDevice)
   :outertype: HardwareDeviceService

   Adds the hardware device.

   :param hardwareDevice: the hardware device

getHardwareDevice
^^^^^^^^^^^^^^^^^

.. java:method:: public HardwareDevice getHardwareDevice(Integer id)
   :outertype: HardwareDeviceService

   Gets the hardware device by its id.

   :param id: the hardware device id
   :return: the hardware device

listHardwareDevices
^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<HardwareDevice> listHardwareDevices()
   :outertype: HardwareDeviceService

   List all hardware devices.

   :return: the hardware device list

removeHardwareDevice
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void removeHardwareDevice(Integer id)
   :outertype: HardwareDeviceService

   Removes the hardware device by its id.

   :param id: the hardware device id

