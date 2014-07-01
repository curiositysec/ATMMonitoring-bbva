.. java:import:: java.text ParseException

.. java:import:: java.text SimpleDateFormat

.. java:import:: java.util Date

.. java:import:: java.util HashMap

.. java:import:: java.util HashSet

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: java.util TreeMap

.. java:import:: javax.persistence Column

.. java:import:: javax.persistence Entity

.. java:import:: javax.persistence FetchType

.. java:import:: javax.persistence GeneratedValue

.. java:import:: javax.persistence GenerationType

.. java:import:: javax.persistence Id

.. java:import:: javax.persistence JoinColumn

.. java:import:: javax.persistence ManyToOne

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate.annotations Cascade

.. java:import:: org.hibernate.annotations CascadeType

.. java:import:: org.hibernate.annotations Type

.. java:import:: com.ncr ATMMonitoring.utils.Operation

.. java:import:: com.ncr ATMMonitoring.utils.Utils

.. java:import:: com.ncr.agent.baseData.os.module BaseBoardPojo

.. java:import:: com.ncr.agent.baseData.os.module BiosPojo

.. java:import:: com.ncr.agent.baseData.os.module CDROMDrivePojo

.. java:import:: com.ncr.agent.baseData.os.module ComputerSystemPojo

.. java:import:: com.ncr.agent.baseData.os.module DesktopMonitorPojo

.. java:import:: com.ncr.agent.baseData.os.module DiskDrivePojo

.. java:import:: com.ncr.agent.baseData.os.module FloppyDrivePojo

.. java:import:: com.ncr.agent.baseData.os.module KeyboardPojo

.. java:import:: com.ncr.agent.baseData.os.module LogicalDiskPojo

.. java:import:: com.ncr.agent.baseData.os.module NetworkAdapterSettingPojo

.. java:import:: com.ncr.agent.baseData.os.module ParallelPortPojo

.. java:import:: com.ncr.agent.baseData.os.module PhysicalMemoryPojo

.. java:import:: com.ncr.agent.baseData.os.module PointingDevicePojo

.. java:import:: com.ncr.agent.baseData.os.module ProcessorPojo

.. java:import:: com.ncr.agent.baseData.os.module SCSIControllerPojo

.. java:import:: com.ncr.agent.baseData.os.module SerialPortPojo

.. java:import:: com.ncr.agent.baseData.os.module SoundDevicePojo

.. java:import:: com.ncr.agent.baseData.os.module SystemSlotPojo

.. java:import:: com.ncr.agent.baseData.os.module USBControllerPojo

.. java:import:: com.ncr.agent.baseData.os.module UsbHubPojo

.. java:import:: com.ncr.agent.baseData.os.module VideoControllerPojo

.. java:import:: com.ncr.agent.baseData.os.module._1394ControllerPojo

HardwareDevice.DeviceClassId
============================

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: public static enum DeviceClassId
   :outertype: HardwareDevice

   The Enum DeviceClassId.

Enum Constants
--------------
BASE_BOARD
^^^^^^^^^^

.. java:field:: public static final HardwareDevice.DeviceClassId BASE_BOARD
   :outertype: HardwareDevice.DeviceClassId

   The base board.

BIOS
^^^^

.. java:field:: public static final HardwareDevice.DeviceClassId BIOS
   :outertype: HardwareDevice.DeviceClassId

   The bios.

CDROM_DRIVE
^^^^^^^^^^^

.. java:field:: public static final HardwareDevice.DeviceClassId CDROM_DRIVE
   :outertype: HardwareDevice.DeviceClassId

   The cdrom drive.

COMPUTER_SYSTEM
^^^^^^^^^^^^^^^

.. java:field:: public static final HardwareDevice.DeviceClassId COMPUTER_SYSTEM
   :outertype: HardwareDevice.DeviceClassId

   The computer system.

DESKTOP_MONITOR
^^^^^^^^^^^^^^^

.. java:field:: public static final HardwareDevice.DeviceClassId DESKTOP_MONITOR
   :outertype: HardwareDevice.DeviceClassId

   The desktop monitor.

DISK_DRIVE
^^^^^^^^^^

.. java:field:: public static final HardwareDevice.DeviceClassId DISK_DRIVE
   :outertype: HardwareDevice.DeviceClassId

   The disk drive.

DISPLAY_CONFIGURATION
^^^^^^^^^^^^^^^^^^^^^

.. java:field:: public static final HardwareDevice.DeviceClassId DISPLAY_CONFIGURATION
   :outertype: HardwareDevice.DeviceClassId

   The display configuration.

FLOPPY_DRIVE
^^^^^^^^^^^^

.. java:field:: public static final HardwareDevice.DeviceClassId FLOPPY_DRIVE
   :outertype: HardwareDevice.DeviceClassId

   The floppy drive.

KEYBOARD
^^^^^^^^

.. java:field:: public static final HardwareDevice.DeviceClassId KEYBOARD
   :outertype: HardwareDevice.DeviceClassId

   The keyboard.

LOGICAL_DISK
^^^^^^^^^^^^

.. java:field:: public static final HardwareDevice.DeviceClassId LOGICAL_DISK
   :outertype: HardwareDevice.DeviceClassId

   The logical disk.

NETWORK_ADAPTER
^^^^^^^^^^^^^^^

.. java:field:: public static final HardwareDevice.DeviceClassId NETWORK_ADAPTER
   :outertype: HardwareDevice.DeviceClassId

   The network adapter.

PARALLEL_PORT
^^^^^^^^^^^^^

.. java:field:: public static final HardwareDevice.DeviceClassId PARALLEL_PORT
   :outertype: HardwareDevice.DeviceClassId

   The parallel port.

PHYSICAL_MEMORY
^^^^^^^^^^^^^^^

.. java:field:: public static final HardwareDevice.DeviceClassId PHYSICAL_MEMORY
   :outertype: HardwareDevice.DeviceClassId

   The physical memory.

POINTING_DEVICE
^^^^^^^^^^^^^^^

.. java:field:: public static final HardwareDevice.DeviceClassId POINTING_DEVICE
   :outertype: HardwareDevice.DeviceClassId

   The pointing device.

PROCESSOR
^^^^^^^^^

.. java:field:: public static final HardwareDevice.DeviceClassId PROCESSOR
   :outertype: HardwareDevice.DeviceClassId

   The processor.

SCSI_CONTROLLER
^^^^^^^^^^^^^^^

.. java:field:: public static final HardwareDevice.DeviceClassId SCSI_CONTROLLER
   :outertype: HardwareDevice.DeviceClassId

   The scsi controller.

SERIAL_PORT
^^^^^^^^^^^

.. java:field:: public static final HardwareDevice.DeviceClassId SERIAL_PORT
   :outertype: HardwareDevice.DeviceClassId

   The serial port.

SOUND_DEVICE
^^^^^^^^^^^^

.. java:field:: public static final HardwareDevice.DeviceClassId SOUND_DEVICE
   :outertype: HardwareDevice.DeviceClassId

   The sound device.

SYSTEM_SLOT
^^^^^^^^^^^

.. java:field:: public static final HardwareDevice.DeviceClassId SYSTEM_SLOT
   :outertype: HardwareDevice.DeviceClassId

   The system slot.

USB_CONTROLLER
^^^^^^^^^^^^^^

.. java:field:: public static final HardwareDevice.DeviceClassId USB_CONTROLLER
   :outertype: HardwareDevice.DeviceClassId

   The usb controller.

USB_HUB
^^^^^^^

.. java:field:: public static final HardwareDevice.DeviceClassId USB_HUB
   :outertype: HardwareDevice.DeviceClassId

   The usb hub.

VIDEO_CONTROLLER
^^^^^^^^^^^^^^^^

.. java:field:: public static final HardwareDevice.DeviceClassId VIDEO_CONTROLLER
   :outertype: HardwareDevice.DeviceClassId

   The video controller.

_1394_CONTROLLER
^^^^^^^^^^^^^^^^

.. java:field:: public static final HardwareDevice.DeviceClassId _1394_CONTROLLER
   :outertype: HardwareDevice.DeviceClassId

   The _1394_ controller.

