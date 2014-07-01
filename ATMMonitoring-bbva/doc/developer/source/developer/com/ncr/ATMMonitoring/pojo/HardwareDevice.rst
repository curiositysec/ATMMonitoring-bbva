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

HardwareDevice
==============

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class HardwareDevice extends Auditable

   The HardwareDevice Pojo.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Constructors
------------
HardwareDevice
^^^^^^^^^^^^^^

.. java:constructor:: public HardwareDevice()
   :outertype: HardwareDevice

   Instantiates a new hardware device.

HardwareDevice
^^^^^^^^^^^^^^

.. java:constructor:: public HardwareDevice(_1394ControllerPojo hw)
   :outertype: HardwareDevice

   Instantiates a new hardware device with the given 1394 controller data from the agent.

   :param hw: the hw

HardwareDevice
^^^^^^^^^^^^^^

.. java:constructor:: public HardwareDevice(BaseBoardPojo hw)
   :outertype: HardwareDevice

   Instantiates a new hardware device with the given base board data from the agent.

   :param hw: the hw

HardwareDevice
^^^^^^^^^^^^^^

.. java:constructor:: public HardwareDevice(BiosPojo hw)
   :outertype: HardwareDevice

   Instantiates a new hardware device with the given bios data from the agent.

   :param hw: the hw

HardwareDevice
^^^^^^^^^^^^^^

.. java:constructor:: public HardwareDevice(CDROMDrivePojo hw)
   :outertype: HardwareDevice

   Instantiates a new hardware device with the given cd rom drive data from the agent.

   :param hw: the hw

HardwareDevice
^^^^^^^^^^^^^^

.. java:constructor:: public HardwareDevice(ComputerSystemPojo hw)
   :outertype: HardwareDevice

   Instantiates a new hardware device with the given computer system data from the agent.

   :param hw: the hw

HardwareDevice
^^^^^^^^^^^^^^

.. java:constructor:: public HardwareDevice(DesktopMonitorPojo hw)
   :outertype: HardwareDevice

   Instantiates a new hardware device with the given desktop monitor data from the agent.

   :param hw: the hw

HardwareDevice
^^^^^^^^^^^^^^

.. java:constructor:: public HardwareDevice(DiskDrivePojo hw)
   :outertype: HardwareDevice

   Instantiates a new hardware device with the given disk drive data from the agent.

   :param hw: the hw

HardwareDevice
^^^^^^^^^^^^^^

.. java:constructor:: public HardwareDevice(FloppyDrivePojo hw)
   :outertype: HardwareDevice

   Instantiates a new hardware device with the given floppy drive data from the agent.

   :param hw: the hw

HardwareDevice
^^^^^^^^^^^^^^

.. java:constructor:: public HardwareDevice(KeyboardPojo hw)
   :outertype: HardwareDevice

   Instantiates a new hardware device with the given keyboard data from the agent.

   :param hw: the hw

HardwareDevice
^^^^^^^^^^^^^^

.. java:constructor:: public HardwareDevice(LogicalDiskPojo hw)
   :outertype: HardwareDevice

   Instantiates a new hardware device with the given logical disk data from the agent.

   :param hw: the hw

HardwareDevice
^^^^^^^^^^^^^^

.. java:constructor:: public HardwareDevice(NetworkAdapterSettingPojo hw)
   :outertype: HardwareDevice

   Instantiates a new hardware device with the given network adapter setting data from the agent.

   :param hw: the hw

HardwareDevice
^^^^^^^^^^^^^^

.. java:constructor:: public HardwareDevice(ParallelPortPojo hw)
   :outertype: HardwareDevice

   Instantiates a new hardware device with the given parallel port data from the agent.

   :param hw: the hw

HardwareDevice
^^^^^^^^^^^^^^

.. java:constructor:: public HardwareDevice(PhysicalMemoryPojo hw)
   :outertype: HardwareDevice

   Instantiates a new hardware device with the given physical memory data from the agent.

   :param hw: the hw

HardwareDevice
^^^^^^^^^^^^^^

.. java:constructor:: public HardwareDevice(PointingDevicePojo hw)
   :outertype: HardwareDevice

   Instantiates a new hardware device with the given pointing device data from the agent.

   :param hw: the hw

HardwareDevice
^^^^^^^^^^^^^^

.. java:constructor:: public HardwareDevice(ProcessorPojo hw)
   :outertype: HardwareDevice

   Instantiates a new hardware device with the given processor data from the agent.

   :param hw: the hw

HardwareDevice
^^^^^^^^^^^^^^

.. java:constructor:: public HardwareDevice(SCSIControllerPojo hw)
   :outertype: HardwareDevice

   Instantiates a new hardware device with the given scsi controller data from the agent.

   :param hw: the hw

HardwareDevice
^^^^^^^^^^^^^^

.. java:constructor:: public HardwareDevice(SerialPortPojo hw)
   :outertype: HardwareDevice

   Instantiates a new hardware device with the given serial port data from the agent.

   :param hw: the hw

HardwareDevice
^^^^^^^^^^^^^^

.. java:constructor:: public HardwareDevice(SoundDevicePojo hw)
   :outertype: HardwareDevice

   Instantiates a new hardware device with the given sound device data from the agent.

   :param hw: the hw

HardwareDevice
^^^^^^^^^^^^^^

.. java:constructor:: public HardwareDevice(SystemSlotPojo hw)
   :outertype: HardwareDevice

   Instantiates a new hardware device with the given system slot data from the agent.

   :param hw: the hw

HardwareDevice
^^^^^^^^^^^^^^

.. java:constructor:: public HardwareDevice(USBControllerPojo hw)
   :outertype: HardwareDevice

   Instantiates a new hardware device with the given usb controller data from the agent.

   :param hw: the hw

HardwareDevice
^^^^^^^^^^^^^^

.. java:constructor:: public HardwareDevice(UsbHubPojo hw)
   :outertype: HardwareDevice

   Instantiates a new hardware device with the given usb hub data from the agent.

   :param hw: the hw

HardwareDevice
^^^^^^^^^^^^^^

.. java:constructor:: public HardwareDevice(VideoControllerPojo hw)
   :outertype: HardwareDevice

   Instantiates a new hardware device with the given video controller data from the agent.

   :param hw: the hw

Methods
-------
equals
^^^^^^

.. java:method:: @Override public boolean equals(Object obj)
   :outertype: HardwareDevice

filter1394Controller
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static Set<HardwareDevice> filter1394Controller(Set<HardwareDevice> hardwareDevs)
   :outertype: HardwareDevice

   Filter a collecion of hardware devices by type '1394 controller'.

   :param hardwareDevs: the hardware devs
   :return: the filtered hardware devs

filterBaseBoard
^^^^^^^^^^^^^^^

.. java:method:: public static Set<HardwareDevice> filterBaseBoard(Set<HardwareDevice> hardwareDevs)
   :outertype: HardwareDevice

   Filter a collecion of hardware devices by device type 'base board'.

   :param hardwareDevs: the hardware devs
   :return: the filtered hardware devs

filterBios
^^^^^^^^^^

.. java:method:: public static Set<HardwareDevice> filterBios(Set<HardwareDevice> hardwareDevs)
   :outertype: HardwareDevice

   Filter a collecion of hardware devices by device type 'bios'.

   :param hardwareDevs: the hardware devs
   :return: the filtered hardware devs

filterCdromDrive
^^^^^^^^^^^^^^^^

.. java:method:: public static Set<HardwareDevice> filterCdromDrive(Set<HardwareDevice> hardwareDevs)
   :outertype: HardwareDevice

   Filter a collecion of hardware devices by device type 'cdrom drive'.

   :param hardwareDevs: the hardware devs
   :return: the filtered hardware devs

filterComputerSystem
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static Set<HardwareDevice> filterComputerSystem(Set<HardwareDevice> hardwareDevs)
   :outertype: HardwareDevice

   Filter a collecion of hardware devices by device type 'computer system'.

   :param hardwareDevs: the hardware devs
   :return: the filtered hardware devs

filterDesktopMonitor
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static Set<HardwareDevice> filterDesktopMonitor(Set<HardwareDevice> hardwareDevs)
   :outertype: HardwareDevice

   Filter a collecion of hardware devices by device type 'desktop monitor'.

   :param hardwareDevs: the hardware devs
   :return: the filtered hardware devs

filterDiskDrive
^^^^^^^^^^^^^^^

.. java:method:: public static Set<HardwareDevice> filterDiskDrive(Set<HardwareDevice> hardwareDevs)
   :outertype: HardwareDevice

   Filter a collecion of hardware devices by device type 'disk drive'.

   :param hardwareDevs: the hardware devs
   :return: the filtered hardware devs

filterDisplayConfiguration
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static Set<HardwareDevice> filterDisplayConfiguration(Set<HardwareDevice> hardwareDevs)
   :outertype: HardwareDevice

   Filter a collecion of hardware devices by device type 'display configuration'.

   :param hardwareDevs: the hardware devs
   :return: the filtered hardware devs

filterFloppyDrive
^^^^^^^^^^^^^^^^^

.. java:method:: public static Set<HardwareDevice> filterFloppyDrive(Set<HardwareDevice> hardwareDevs)
   :outertype: HardwareDevice

   Filter a collecion of hardware devices by device type 'floppy drive'.

   :param hardwareDevs: the hardware devs
   :return: the filtered hardware devs

filterKeyboard
^^^^^^^^^^^^^^

.. java:method:: public static Set<HardwareDevice> filterKeyboard(Set<HardwareDevice> hardwareDevs)
   :outertype: HardwareDevice

   Filter a collecion of hardware devices by device type 'keyboard'.

   :param hardwareDevs: the hardware devs
   :return: the filtered hardware devs

filterLogicalDisk
^^^^^^^^^^^^^^^^^

.. java:method:: public static Set<HardwareDevice> filterLogicalDisk(Set<HardwareDevice> hardwareDevs)
   :outertype: HardwareDevice

   Filter a collecion of hardware devices by device type 'logical disk'.

   :param hardwareDevs: the hardware devs
   :return: the filtered hardware devs

filterNetworkAdapter
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static Set<HardwareDevice> filterNetworkAdapter(Set<HardwareDevice> hardwareDevs)
   :outertype: HardwareDevice

   Filter a collecion of hardware devices by device type 'network adapter'.

   :param hardwareDevs: the hardware devs
   :return: the filtered hardware devs

filterParallelPort
^^^^^^^^^^^^^^^^^^

.. java:method:: public static Set<HardwareDevice> filterParallelPort(Set<HardwareDevice> hardwareDevs)
   :outertype: HardwareDevice

   Filter a collecion of hardware devices by device type 'parallel port'.

   :param hardwareDevs: the hardware devs
   :return: the filtered hardware devs

filterPhysicalMemory
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static Set<HardwareDevice> filterPhysicalMemory(Set<HardwareDevice> hardwareDevs)
   :outertype: HardwareDevice

   Filter a collecion of hardware devices by device type 'physical memory'.

   :param hardwareDevs: the hardware devs
   :return: the filtered hardware devs

filterPointingDevice
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static Set<HardwareDevice> filterPointingDevice(Set<HardwareDevice> hardwareDevs)
   :outertype: HardwareDevice

   Filter a collecion of hardware devices by device type 'pointing device'.

   :param hardwareDevs: the hardware devs
   :return: the filtered hardware devs

filterProcessor
^^^^^^^^^^^^^^^

.. java:method:: public static Set<HardwareDevice> filterProcessor(Set<HardwareDevice> hardwareDevs)
   :outertype: HardwareDevice

   Filter a collecion of hardware devices by device 'type processor'.

   :param hardwareDevs: the hardware devs
   :return: the filtered hardware devs

filterScsiController
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static Set<HardwareDevice> filterScsiController(Set<HardwareDevice> hardwareDevs)
   :outertype: HardwareDevice

   Filter a collecion of hardware devices by device type 'scsi controller'.

   :param hardwareDevs: the hardware devs
   :return: the filtered hardware devs

filterSerialPort
^^^^^^^^^^^^^^^^

.. java:method:: public static Set<HardwareDevice> filterSerialPort(Set<HardwareDevice> hardwareDevs)
   :outertype: HardwareDevice

   Filter a collecion of hardware devices by device type 'serial port'.

   :param hardwareDevs: the hardware devs
   :return: the filtered hardware devs

filterSoundDevice
^^^^^^^^^^^^^^^^^

.. java:method:: public static Set<HardwareDevice> filterSoundDevice(Set<HardwareDevice> hardwareDevs)
   :outertype: HardwareDevice

   Filter a collecion of hardware devices by device type 'sound device'.

   :param hardwareDevs: the hardware devs
   :return: the filtered hardware devs

filterSystemSlot
^^^^^^^^^^^^^^^^

.. java:method:: public static Set<HardwareDevice> filterSystemSlot(Set<HardwareDevice> hardwareDevs)
   :outertype: HardwareDevice

   Filter a collecion of hardware devices by device type 'system slot'.

   :param hardwareDevs: the hardware devs
   :return: the filtered hardware devs

filterUsbController
^^^^^^^^^^^^^^^^^^^

.. java:method:: public static Set<HardwareDevice> filterUsbController(Set<HardwareDevice> hardwareDevs)
   :outertype: HardwareDevice

   Filter a collecion of hardware devices by device type 'usb controller'.

   :param hardwareDevs: the hardware devs
   :return: the filtered hardware devs

filterUsbHub
^^^^^^^^^^^^

.. java:method:: public static Set<HardwareDevice> filterUsbHub(Set<HardwareDevice> hardwareDevs)
   :outertype: HardwareDevice

   Filter a collecion of hardware devices by device type 'usb hub'.

   :param hardwareDevs: the hardware devs
   :return: the filtered hardware devs

filterVideoController
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static Set<HardwareDevice> filterVideoController(Set<HardwareDevice> hardwareDevs)
   :outertype: HardwareDevice

   Filter a collecion of hardware devices by device type 'video controller'.

   :param hardwareDevs: the hardware devs
   :return: the filtered hardware devs

getAdapterRam
^^^^^^^^^^^^^

.. java:method:: public Integer getAdapterRam()
   :outertype: HardwareDevice

   Gets the adapter ram.

   :return: the adapterRam

getAdapterType
^^^^^^^^^^^^^^

.. java:method:: public String getAdapterType()
   :outertype: HardwareDevice

   Gets the adapter type.

   :return: the adapterType

getAddressWidth
^^^^^^^^^^^^^^^

.. java:method:: public Integer getAddressWidth()
   :outertype: HardwareDevice

   Gets the address width.

   :return: the addressWidth

getArchitecture
^^^^^^^^^^^^^^^

.. java:method:: public String getArchitecture()
   :outertype: HardwareDevice

   Gets the architecture.

   :return: the architecture

getBitsPerPixel
^^^^^^^^^^^^^^^

.. java:method:: public Integer getBitsPerPixel()
   :outertype: HardwareDevice

   Gets the bits per pixel.

   :return: the bitsPerPixel

getBytesPerSector
^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getBytesPerSector()
   :outertype: HardwareDevice

   Gets the bytes per sector.

   :return: the bytesPerSector

getCapacity
^^^^^^^^^^^

.. java:method:: public Long getCapacity()
   :outertype: HardwareDevice

   Gets the capacity.

   :return: the capacity

getCaption
^^^^^^^^^^

.. java:method:: public String getCaption()
   :outertype: HardwareDevice

   Gets the caption.

   :return: the caption

getColors
^^^^^^^^^

.. java:method:: public Integer getColors()
   :outertype: HardwareDevice

   Gets the colors.

   :return: the colors

getComboboxes
^^^^^^^^^^^^^

.. java:method:: public static Map<String, Map> getComboboxes()
   :outertype: HardwareDevice

   Gets the comboboxes data for the query GUI.

   :return: the comboboxes data

getComboboxesByDeviceClassId
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static Map<String, Map> getComboboxesByDeviceClassId(DeviceClassId deviceClassId)
   :outertype: HardwareDevice

getCurrentBitsPerPixel
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getCurrentBitsPerPixel()
   :outertype: HardwareDevice

   Gets the current bits per pixel.

   :return: the currentBitsPerPixel

getCurrentClockSpeed
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getCurrentClockSpeed()
   :outertype: HardwareDevice

   Gets the current clock speed.

   :return: the currentClockSpeed

getCurrentHorizontalResolution
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getCurrentHorizontalResolution()
   :outertype: HardwareDevice

   Gets the current horizontal resolution.

   :return: the currentHorizontalResolution

getCurrentLanguage
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getCurrentLanguage()
   :outertype: HardwareDevice

   Gets the current language.

   :return: the currentLanguage

getCurrentNumberOfColors
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Long getCurrentNumberOfColors()
   :outertype: HardwareDevice

   Gets the current number of colors.

   :return: the currentNumberOfColors

getCurrentRefreshRate
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getCurrentRefreshRate()
   :outertype: HardwareDevice

   Gets the current refresh rate.

   :return: the currentRefreshRate

getCurrentTimeZone
^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getCurrentTimeZone()
   :outertype: HardwareDevice

   Gets the current time zone.

   :return: the currentTimeZone

getCurrentUsage
^^^^^^^^^^^^^^^

.. java:method:: public Integer getCurrentUsage()
   :outertype: HardwareDevice

   Gets the current usage.

   :return: the currentUsage

getCurrentVerticalResolution
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getCurrentVerticalResolution()
   :outertype: HardwareDevice

   Gets the current vertical resolution.

   :return: the currentVerticalResolution

getDataWidth
^^^^^^^^^^^^

.. java:method:: public Integer getDataWidth()
   :outertype: HardwareDevice

   Gets the data width.

   :return: the dataWidth

getDaylightInEffect
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getDaylightInEffect()
   :outertype: HardwareDevice

   Gets the daylight in effect.

   :return: the daylightInEffect

getDefaultIpGateway
^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getDefaultIpGateway()
   :outertype: HardwareDevice

   Gets the default ip gateway.

   :return: the defaultIpGateway

getDescription
^^^^^^^^^^^^^^

.. java:method:: public String getDescription()
   :outertype: HardwareDevice

   Gets the description.

   :return: the description

getDeviceClasses
^^^^^^^^^^^^^^^^

.. java:method:: public static Map<DeviceClassId, String> getDeviceClasses()
   :outertype: HardwareDevice

getDeviceId
^^^^^^^^^^^

.. java:method:: public String getDeviceId()
   :outertype: HardwareDevice

   Gets the device id.

   :return: the deviceId

getDeviceclasses
^^^^^^^^^^^^^^^^

.. java:method:: public static Map<DeviceClassId, String> getDeviceclasses()
   :outertype: HardwareDevice

   Gets the deviceclasses (i.e. 'desktop monitor', 'usb hub', 'keyboard'...).

   :return: the deviceclasses

getDhcpEnabled
^^^^^^^^^^^^^^

.. java:method:: public Boolean getDhcpEnabled()
   :outertype: HardwareDevice

   Gets the dhcp enabled.

   :return: the dhcpEnabled

getDhcpServer
^^^^^^^^^^^^^

.. java:method:: public String getDhcpServer()
   :outertype: HardwareDevice

   Gets the dhcp server.

   :return: the dhcpServer

getDisplayType
^^^^^^^^^^^^^^

.. java:method:: public Boolean getDisplayType()
   :outertype: HardwareDevice

   Gets the display type.

   :return: the displayType

getDomain
^^^^^^^^^

.. java:method:: public String getDomain()
   :outertype: HardwareDevice

   Gets the domain.

   :return: the domain

getDriverName
^^^^^^^^^^^^^

.. java:method:: public String getDriverName()
   :outertype: HardwareDevice

   Gets the driver name.

   :return: the driverName

getExtClock
^^^^^^^^^^^

.. java:method:: public Integer getExtClock()
   :outertype: HardwareDevice

   Gets the ext clock.

   :return: the extClock

getFileSystem
^^^^^^^^^^^^^

.. java:method:: public String getFileSystem()
   :outertype: HardwareDevice

   Gets the file system.

   :return: the fileSystem

getFirmwareRevision
^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getFirmwareRevision()
   :outertype: HardwareDevice

   Gets the firmware revision.

   :return: the firmwareRevision

getFreeSpace
^^^^^^^^^^^^

.. java:method:: public Long getFreeSpace()
   :outertype: HardwareDevice

   Gets the free space.

   :return: the freeSpace

getHardwareClass
^^^^^^^^^^^^^^^^

.. java:method:: public String getHardwareClass()
   :outertype: HardwareDevice

   Gets the hardware class.

   :return: the hardwareClass

getHardwareNameVersion
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getHardwareNameVersion()
   :outertype: HardwareDevice

   Gets the hardware name version.

   :return: the hardware name and version concatenated

getHardwareType
^^^^^^^^^^^^^^^

.. java:method:: public String getHardwareType()
   :outertype: HardwareDevice

   Gets the hardware type.

   :return: the hardwareType

getHardwareVersion
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getHardwareVersion()
   :outertype: HardwareDevice

   Gets the hardware version.

   :return: the hardwareVersion

getHorizontalRes
^^^^^^^^^^^^^^^^

.. java:method:: public Integer getHorizontalRes()
   :outertype: HardwareDevice

   Gets the horizontal res.

   :return: the horizontalRes

getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: HardwareDevice

   Gets the id.

   :return: the id

getInterfaceIndex
^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getInterfaceIndex()
   :outertype: HardwareDevice

   Gets the interface index.

   :return: the interfaceIndex

getIpAddress
^^^^^^^^^^^^

.. java:method:: public String getIpAddress()
   :outertype: HardwareDevice

   Gets the ip address.

   :return: the ipAddress

getIpSubnet
^^^^^^^^^^^

.. java:method:: public String getIpSubnet()
   :outertype: HardwareDevice

   Gets the ip subnet.

   :return: the ipSubnet

getLayout
^^^^^^^^^

.. java:method:: public String getLayout()
   :outertype: HardwareDevice

   Gets the layout.

   :return: the layout

getMacAddress
^^^^^^^^^^^^^

.. java:method:: public String getMacAddress()
   :outertype: HardwareDevice

   Gets the mac address.

   :return: the macAddress

getManufacturer
^^^^^^^^^^^^^^^

.. java:method:: public String getManufacturer()
   :outertype: HardwareDevice

   Gets the manufacturer.

   :return: the manufacturer

getMaxBaudRate
^^^^^^^^^^^^^^

.. java:method:: public Integer getMaxBaudRate()
   :outertype: HardwareDevice

   Gets the max baud rate.

   :return: the maxBaudRate

getMaxClockSpeed
^^^^^^^^^^^^^^^^

.. java:method:: public Integer getMaxClockSpeed()
   :outertype: HardwareDevice

   Gets the max clock speed.

   :return: the maxClockSpeed

getMaxMediaSize
^^^^^^^^^^^^^^^

.. java:method:: public Integer getMaxMediaSize()
   :outertype: HardwareDevice

   Gets the max media size.

   :return: the maxMediaSize

getMediaType
^^^^^^^^^^^^

.. java:method:: public String getMediaType()
   :outertype: HardwareDevice

   Gets the media type.

   :return: the mediaType

getModel
^^^^^^^^

.. java:method:: public String getModel()
   :outertype: HardwareDevice

   Gets the model.

   :return: the model

getMonitorManufacturer
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getMonitorManufacturer()
   :outertype: HardwareDevice

   Gets the monitor manufacturer.

   :return: the monitorManufacturer

getMonitorType
^^^^^^^^^^^^^^

.. java:method:: public String getMonitorType()
   :outertype: HardwareDevice

   Gets the monitor type.

   :return: the monitorType

getName
^^^^^^^

.. java:method:: public String getName()
   :outertype: HardwareDevice

   Gets the name.

   :return: the name

getNameVersion
^^^^^^^^^^^^^^

.. java:method:: public String getNameVersion()
   :outertype: HardwareDevice

   Gets the name version.

   :return: the name and version concatenated

getNetConnectionId
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getNetConnectionId()
   :outertype: HardwareDevice

   Gets the net connection id.

   :return: the netConnectionId

getNetConnectionStatus
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getNetConnectionStatus()
   :outertype: HardwareDevice

   Gets the net connection status.

   :return: the netConnectionStatus

getNumberOfPorts
^^^^^^^^^^^^^^^^

.. java:method:: public Integer getNumberOfPorts()
   :outertype: HardwareDevice

   Gets the number of ports.

   :return: the numberOfPorts

getNumberOfProcessors
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getNumberOfProcessors()
   :outertype: HardwareDevice

   Gets the number of processors.

   :return: the numberOfProcessors

getPartitions
^^^^^^^^^^^^^

.. java:method:: public Integer getPartitions()
   :outertype: HardwareDevice

   Gets the partitions.

   :return: the partitions

getPixelsPerXLogicalInch
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getPixelsPerXLogicalInch()
   :outertype: HardwareDevice

   Gets the pixels per x logical inch.

   :return: the pixelsPerXLogicalInch

getPixelsPerYLogicalInch
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getPixelsPerYLogicalInch()
   :outertype: HardwareDevice

   Gets the pixels per y logical inch.

   :return: the pixelsPerYLogicalInch

getPointingType
^^^^^^^^^^^^^^^

.. java:method:: public Integer getPointingType()
   :outertype: HardwareDevice

   Gets the pointing type.

   :return: the pointingType

getPrimaryBios
^^^^^^^^^^^^^^

.. java:method:: public Boolean getPrimaryBios()
   :outertype: HardwareDevice

   Gets the primary bios.

   :return: the primaryBios

getProduct
^^^^^^^^^^

.. java:method:: public String getProduct()
   :outertype: HardwareDevice

   Gets the product.

   :return: the product

getProtocolCode
^^^^^^^^^^^^^^^

.. java:method:: public String getProtocolCode()
   :outertype: HardwareDevice

   Gets the protocol code.

   :return: the protocolCode

getProtocolSupported
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getProtocolSupported()
   :outertype: HardwareDevice

   Gets the protocol supported.

   :return: the protocolSupported

getRefreshRate
^^^^^^^^^^^^^^

.. java:method:: public Integer getRefreshRate()
   :outertype: HardwareDevice

   Gets the refresh rate.

   :return: the refreshRate

getReleaseDate
^^^^^^^^^^^^^^

.. java:method:: public Date getReleaseDate()
   :outertype: HardwareDevice

   Gets the release date.

   :return: the releaseDate

getSectorsPerTrack
^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getSectorsPerTrack()
   :outertype: HardwareDevice

   Gets the sectors per track.

   :return: the sectorsPerTrack

getSeparator
^^^^^^^^^^^^

.. java:method:: public static char getSeparator()
   :outertype: HardwareDevice

   Gets the separator.

   :return: the separator

getSerialNumber
^^^^^^^^^^^^^^^

.. java:method:: public String getSerialNumber()
   :outertype: HardwareDevice

   Gets the serial number.

   :return: the serialNumber

getSignature
^^^^^^^^^^^^

.. java:method:: public String getSignature()
   :outertype: HardwareDevice

   Gets the signature.

   :return: the signature

getSize
^^^^^^^

.. java:method:: public Long getSize()
   :outertype: HardwareDevice

   Gets the size.

   :return: the size

getSlotDesignation
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSlotDesignation()
   :outertype: HardwareDevice

   Gets the slot designation.

   :return: the slotDesignation

getSmbiosMajorVersion
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getSmbiosMajorVersion()
   :outertype: HardwareDevice

   Gets the smbios major version.

   :return: the smbiosMajorVersion

getSmbiosMinorVersion
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getSmbiosMinorVersion()
   :outertype: HardwareDevice

   Gets the smbios minor version.

   :return: the smbiosMinorVersion

getSmbiosPresent
^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getSmbiosPresent()
   :outertype: HardwareDevice

   Gets the smbios present.

   :return: the smbiosPresent

getSmbiosVersion
^^^^^^^^^^^^^^^^

.. java:method:: public String getSmbiosVersion()
   :outertype: HardwareDevice

   Gets the smbios version.

   :return: the smbiosVersion

getSpeed
^^^^^^^^

.. java:method:: public Long getSpeed()
   :outertype: HardwareDevice

   Gets the speed.

   :return: the speed

getStatus
^^^^^^^^^

.. java:method:: public String getStatus()
   :outertype: HardwareDevice

   Gets the status.

   :return: the status

getStatusInfo
^^^^^^^^^^^^^

.. java:method:: public String getStatusInfo()
   :outertype: HardwareDevice

   Gets the status info.

   :return: the statusInfo

getStepping
^^^^^^^^^^^

.. java:method:: public Integer getStepping()
   :outertype: HardwareDevice

   Gets the stepping.

   :return: the stepping

getTag
^^^^^^

.. java:method:: public String getTag()
   :outertype: HardwareDevice

   Gets the tag.

   :return: the tag

getTerminal
^^^^^^^^^^^

.. java:method:: public Terminal getTerminal()
   :outertype: HardwareDevice

   Gets the terminal.

   :return: the terminal

getTotalCylinders
^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getTotalCylinders()
   :outertype: HardwareDevice

   Gets the total cylinders.

   :return: the totalCylinders

getTotalPhysicalMemory
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Long getTotalPhysicalMemory()
   :outertype: HardwareDevice

   Gets the total physical memory.

   :return: the totalPhysicalMemory

getTracksPerCylinder
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getTracksPerCylinder()
   :outertype: HardwareDevice

   Gets the tracks per cylinder.

   :return: the tracksPerCylinder

getUsbVersion
^^^^^^^^^^^^^

.. java:method:: public String getUsbVersion()
   :outertype: HardwareDevice

   Gets the usb version.

   :return: the usbRemainingVersion

getVersion
^^^^^^^^^^

.. java:method:: public String getVersion()
   :outertype: HardwareDevice

   Gets the version.

   :return: the version

getVerticalRes
^^^^^^^^^^^^^^

.. java:method:: public Integer getVerticalRes()
   :outertype: HardwareDevice

   Gets the vertical res.

   :return: the verticalRes

getVideoMemory
^^^^^^^^^^^^^^

.. java:method:: public Integer getVideoMemory()
   :outertype: HardwareDevice

   Gets the video memory.

   :return: the videoMemory

getVideoProcessor
^^^^^^^^^^^^^^^^^

.. java:method:: public String getVideoProcessor()
   :outertype: HardwareDevice

   Gets the video processor.

   :return: the videoProcessor

getVolumeName
^^^^^^^^^^^^^

.. java:method:: public String getVolumeName()
   :outertype: HardwareDevice

   Gets the volume name.

   :return: the volumeName

getVolumeSerialNumber
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getVolumeSerialNumber()
   :outertype: HardwareDevice

   Gets the volume serial number.

   :return: the volumeSerialNumber

getWorkgroup
^^^^^^^^^^^^

.. java:method:: public String getWorkgroup()
   :outertype: HardwareDevice

   Gets the workgroup.

   :return: the workgroup

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: HardwareDevice

setAdapterRam
^^^^^^^^^^^^^

.. java:method:: public void setAdapterRam(Integer adapterRam)
   :outertype: HardwareDevice

   Sets the adapter ram.

   :param adapterRam: the adapterRam to set

setAdapterType
^^^^^^^^^^^^^^

.. java:method:: public void setAdapterType(String adapterType)
   :outertype: HardwareDevice

   Sets the adapter type.

   :param adapterType: the adapterType to set

setAddressWidth
^^^^^^^^^^^^^^^

.. java:method:: public void setAddressWidth(Integer addressWidth)
   :outertype: HardwareDevice

   Sets the address width.

   :param addressWidth: the addressWidth to set

setArchitecture
^^^^^^^^^^^^^^^

.. java:method:: public void setArchitecture(String architecture)
   :outertype: HardwareDevice

   Sets the architecture.

   :param architecture: the architecture to set

setBitsPerPixel
^^^^^^^^^^^^^^^

.. java:method:: public void setBitsPerPixel(Integer bitsPerPixel)
   :outertype: HardwareDevice

   Sets the bits per pixel.

   :param bitsPerPixel: the bitsPerPixel to set

setBytesPerSector
^^^^^^^^^^^^^^^^^

.. java:method:: public void setBytesPerSector(Integer bytesPerSector)
   :outertype: HardwareDevice

   Sets the bytes per sector.

   :param bytesPerSector: the bytesPerSector to set

setCapacity
^^^^^^^^^^^

.. java:method:: public void setCapacity(Long capacity)
   :outertype: HardwareDevice

   Sets the capacity.

   :param capacity: the capacity to set

setCaption
^^^^^^^^^^

.. java:method:: public void setCaption(String caption)
   :outertype: HardwareDevice

   Sets the caption.

   :param caption: the caption to set

setColors
^^^^^^^^^

.. java:method:: public void setColors(Integer colors)
   :outertype: HardwareDevice

   Sets the colors.

   :param colors: the colors to set

setCurrentBitsPerPixel
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setCurrentBitsPerPixel(Integer currentBitsPerPixel)
   :outertype: HardwareDevice

   Sets the current bits per pixel.

   :param currentBitsPerPixel: the currentBitsPerPixel to set

setCurrentClockSpeed
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setCurrentClockSpeed(Integer currentClockSpeed)
   :outertype: HardwareDevice

   Sets the current clock speed.

   :param currentClockSpeed: the currentClockSpeed to set

setCurrentHorizontalResolution
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setCurrentHorizontalResolution(Integer currentHorizontalResolution)
   :outertype: HardwareDevice

   Sets the current horizontal resolution.

   :param currentHorizontalResolution: the currentHorizontalResolution to set

setCurrentLanguage
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setCurrentLanguage(String currentLanguage)
   :outertype: HardwareDevice

   Sets the current language.

   :param currentLanguage: the currentLanguage to set

setCurrentNumberOfColors
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setCurrentNumberOfColors(Long currentNumberOfColors)
   :outertype: HardwareDevice

   Sets the current number of colors.

   :param currentNumberOfColors: the currentNumberOfColors to set

setCurrentRefreshRate
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setCurrentRefreshRate(Integer currentRefreshRate)
   :outertype: HardwareDevice

   Sets the current refresh rate.

   :param currentRefreshRate: the currentRefreshRate to set

setCurrentTimeZone
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setCurrentTimeZone(Integer currentTimeZone)
   :outertype: HardwareDevice

   Sets the current time zone.

   :param currentTimeZone: the currentTimeZone to set

setCurrentUsage
^^^^^^^^^^^^^^^

.. java:method:: public void setCurrentUsage(Integer currentUsage)
   :outertype: HardwareDevice

   Sets the current usage.

   :param currentUsage: the currentUsage to set

setCurrentVerticalResolution
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setCurrentVerticalResolution(Integer currentVerticalResolution)
   :outertype: HardwareDevice

   Sets the current vertical resolution.

   :param currentVerticalResolution: the currentVerticalResolution to set

setDataWidth
^^^^^^^^^^^^

.. java:method:: public void setDataWidth(Integer dataWidth)
   :outertype: HardwareDevice

   Sets the data width.

   :param dataWidth: the dataWidth to set

setDaylightInEffect
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setDaylightInEffect(Boolean daylightInEffect)
   :outertype: HardwareDevice

   Sets the daylight in effect.

   :param daylightInEffect: the daylightInEffect to set

setDefaultIpGateway
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setDefaultIpGateway(String defaultIpGateway)
   :outertype: HardwareDevice

   Sets the default ip gateway.

   :param defaultIpGateway: the defaultIpGateway to set

setDescription
^^^^^^^^^^^^^^

.. java:method:: public void setDescription(String description)
   :outertype: HardwareDevice

   Sets the description.

   :param description: the description to set

setDeviceId
^^^^^^^^^^^

.. java:method:: public void setDeviceId(String deviceId)
   :outertype: HardwareDevice

   Sets the device id.

   :param deviceId: the deviceId to set

setDhcpEnabled
^^^^^^^^^^^^^^

.. java:method:: public void setDhcpEnabled(Boolean dhcpEnabled)
   :outertype: HardwareDevice

   Sets the dhcp enabled.

   :param dhcpEnabled: the dhcpEnabled to set

setDhcpServer
^^^^^^^^^^^^^

.. java:method:: public void setDhcpServer(String dhcpServer)
   :outertype: HardwareDevice

   Sets the dhcp server.

   :param dhcpServer: the dhcpServer to set

setDisplayType
^^^^^^^^^^^^^^

.. java:method:: public void setDisplayType(Boolean displayType)
   :outertype: HardwareDevice

   Sets the display type.

   :param displayType: the displayType to set

setDomain
^^^^^^^^^

.. java:method:: public void setDomain(String domain)
   :outertype: HardwareDevice

   Sets the domain.

   :param domain: the domain to set

setDriverName
^^^^^^^^^^^^^

.. java:method:: public void setDriverName(String driverName)
   :outertype: HardwareDevice

   Sets the driver name.

   :param driverName: the driverName to set

setExtClock
^^^^^^^^^^^

.. java:method:: public void setExtClock(Integer extClock)
   :outertype: HardwareDevice

   Sets the ext clock.

   :param extClock: the extClock to set

setFileSystem
^^^^^^^^^^^^^

.. java:method:: public void setFileSystem(String fileSystem)
   :outertype: HardwareDevice

   Sets the file system.

   :param fileSystem: the fileSystem to set

setFirmwareRevision
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFirmwareRevision(String firmwareRevision)
   :outertype: HardwareDevice

   Sets the firmware revision.

   :param firmwareRevision: the firmwareRevision to set

setFreeSpace
^^^^^^^^^^^^

.. java:method:: public void setFreeSpace(Long freeSpace)
   :outertype: HardwareDevice

   Sets the free space.

   :param freeSpace: the freeSpace to set

setHardwareClass
^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareClass(String hardwareClass)
   :outertype: HardwareDevice

   Sets the hardware class.

   :param hardwareClass: the hardwareClass to set

setHardwareType
^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareType(String hardwareType)
   :outertype: HardwareDevice

   Sets the hardware type.

   :param hardwareType: the hardwareType to set

setHardwareVersion
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareVersion(String hardwareVersion)
   :outertype: HardwareDevice

   Sets the hardware version.

   :param hardwareVersion: the hardwareVersion to set

setHorizontalRes
^^^^^^^^^^^^^^^^

.. java:method:: public void setHorizontalRes(Integer horizontalRes)
   :outertype: HardwareDevice

   Sets the horizontal res.

   :param horizontalRes: the horizontalRes to set

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: HardwareDevice

   Sets the id.

   :param id: the id to set

setInterfaceIndex
^^^^^^^^^^^^^^^^^

.. java:method:: public void setInterfaceIndex(Integer interfaceIndex)
   :outertype: HardwareDevice

   Sets the interface index.

   :param interfaceIndex: the interfaceIndex to set

setIpAddress
^^^^^^^^^^^^

.. java:method:: public void setIpAddress(String ipAddress)
   :outertype: HardwareDevice

   Sets the ip address.

   :param ipAddress: the ipAddress to set

setIpSubnet
^^^^^^^^^^^

.. java:method:: public void setIpSubnet(String ipSubnet)
   :outertype: HardwareDevice

   Sets the ip subnet.

   :param ipSubnet: the ipSubnet to set

setLayout
^^^^^^^^^

.. java:method:: public void setLayout(String layout)
   :outertype: HardwareDevice

   Sets the layout.

   :param layout: the layout to set

setMacAddress
^^^^^^^^^^^^^

.. java:method:: public void setMacAddress(String macAddress)
   :outertype: HardwareDevice

   Sets the mac address.

   :param macAddress: the macAddress to set

setManufacturer
^^^^^^^^^^^^^^^

.. java:method:: public void setManufacturer(String manufacturer)
   :outertype: HardwareDevice

   Sets the manufacturer.

   :param manufacturer: the manufacturer to set

setMaxBaudRate
^^^^^^^^^^^^^^

.. java:method:: public void setMaxBaudRate(Integer maxBaudRate)
   :outertype: HardwareDevice

   Sets the max baud rate.

   :param maxBaudRate: the maxBaudRate to set

setMaxClockSpeed
^^^^^^^^^^^^^^^^

.. java:method:: public void setMaxClockSpeed(Integer maxClockSpeed)
   :outertype: HardwareDevice

   Sets the max clock speed.

   :param maxClockSpeed: the maxClockSpeed to set

setMaxMediaSize
^^^^^^^^^^^^^^^

.. java:method:: public void setMaxMediaSize(Integer maxMediaSize)
   :outertype: HardwareDevice

   Sets the max media size.

   :param maxMediaSize: the maxMediaSize to set

setMediaType
^^^^^^^^^^^^

.. java:method:: public void setMediaType(String mediaType)
   :outertype: HardwareDevice

   Sets the media type.

   :param mediaType: the mediaType to set

setModel
^^^^^^^^

.. java:method:: public void setModel(String model)
   :outertype: HardwareDevice

   Sets the model.

   :param model: the model to set

setMonitorManufacturer
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setMonitorManufacturer(String monitorManufacturer)
   :outertype: HardwareDevice

   Sets the monitor manufacturer.

   :param monitorManufacturer: the monitorManufacturer to set

setMonitorType
^^^^^^^^^^^^^^

.. java:method:: public void setMonitorType(String monitorType)
   :outertype: HardwareDevice

   Sets the monitor type.

   :param monitorType: the monitorType to set

setName
^^^^^^^

.. java:method:: public void setName(String name)
   :outertype: HardwareDevice

   Sets the name.

   :param name: the name to set

setNetConnectionId
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setNetConnectionId(String netConnectionId)
   :outertype: HardwareDevice

   Sets the net connection id.

   :param netConnectionId: the netConnectionId to set

setNetConnectionStatus
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setNetConnectionStatus(String netConnectionStatus)
   :outertype: HardwareDevice

   Sets the net connection status.

   :param netConnectionStatus: the netConnectionStatus to set

setNumberOfPorts
^^^^^^^^^^^^^^^^

.. java:method:: public void setNumberOfPorts(Integer numberOfPorts)
   :outertype: HardwareDevice

   Sets the number of ports.

   :param numberOfPorts: the numberOfPorts to set

setNumberOfProcessors
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setNumberOfProcessors(Integer numberOfProcessors)
   :outertype: HardwareDevice

   Sets the number of processors.

   :param numberOfProcessors: the numberOfProcessors to set

setPartitions
^^^^^^^^^^^^^

.. java:method:: public void setPartitions(Integer partitions)
   :outertype: HardwareDevice

   Sets the partitions.

   :param partitions: the partitions to set

setPixelsPerXLogicalInch
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setPixelsPerXLogicalInch(Integer pixelsPerXLogicalInch)
   :outertype: HardwareDevice

   Sets the pixels per x logical inch.

   :param pixelsPerXLogicalInch: the pixelsPerXLogicalInch to set

setPixelsPerYLogicalInch
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setPixelsPerYLogicalInch(Integer pixelsPerYLogicalInch)
   :outertype: HardwareDevice

   Sets the pixels per y logical inch.

   :param pixelsPerYLogicalInch: the pixelsPerYLogicalInch to set

setPointingType
^^^^^^^^^^^^^^^

.. java:method:: public void setPointingType(Integer pointingType)
   :outertype: HardwareDevice

   Sets the pointing type.

   :param pointingType: the pointingType to set

setPrimaryBios
^^^^^^^^^^^^^^

.. java:method:: public void setPrimaryBios(Boolean primaryBios)
   :outertype: HardwareDevice

   Sets the primary bios.

   :param primaryBios: the primaryBios to set

setProduct
^^^^^^^^^^

.. java:method:: public void setProduct(String product)
   :outertype: HardwareDevice

   Sets the product.

   :param product: the product to set

setProtocolCode
^^^^^^^^^^^^^^^

.. java:method:: public void setProtocolCode(String protocolCode)
   :outertype: HardwareDevice

   Sets the protocol code.

   :param protocolCode: the protocolCode to set

setProtocolSupported
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setProtocolSupported(Integer protocolSupported)
   :outertype: HardwareDevice

   Sets the protocol supported.

   :param protocolSupported: the protocolSupported to set

setRefreshRate
^^^^^^^^^^^^^^

.. java:method:: public void setRefreshRate(Integer refreshRate)
   :outertype: HardwareDevice

   Sets the refresh rate.

   :param refreshRate: the refreshRate to set

setReleaseDate
^^^^^^^^^^^^^^

.. java:method:: public void setReleaseDate(Date releaseDate)
   :outertype: HardwareDevice

   Sets the release date.

   :param releaseDate: the releaseDate to set

setSectorsPerTrack
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSectorsPerTrack(Integer sectorsPerTrack)
   :outertype: HardwareDevice

   Sets the sectors per track.

   :param sectorsPerTrack: the sectorsPerTrack to set

setSerialNumber
^^^^^^^^^^^^^^^

.. java:method:: public void setSerialNumber(String serialNumber)
   :outertype: HardwareDevice

   Sets the serial number.

   :param serialNumber: the serialNumber to set

setSignature
^^^^^^^^^^^^

.. java:method:: public void setSignature(String signature)
   :outertype: HardwareDevice

   Sets the signature.

   :param signature: the signature to set

setSize
^^^^^^^

.. java:method:: public void setSize(Long size)
   :outertype: HardwareDevice

   Sets the size.

   :param size: the size to set

setSlotDesignation
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSlotDesignation(String slotDesignation)
   :outertype: HardwareDevice

   Sets the slot designation.

   :param slotDesignation: the slotDesignation to set

setSmbiosMajorVersion
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSmbiosMajorVersion(Integer smbiosMajorVersion)
   :outertype: HardwareDevice

   Sets the smbios major version.

   :param smbiosMajorVersion: the smbiosMajorVersion to set

setSmbiosMinorVersion
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSmbiosMinorVersion(Integer smbiosMinorVersion)
   :outertype: HardwareDevice

   Sets the smbios minor version.

   :param smbiosMinorVersion: the smbiosMinorVersion to set

setSmbiosPresent
^^^^^^^^^^^^^^^^

.. java:method:: public void setSmbiosPresent(Boolean smbiosPresent)
   :outertype: HardwareDevice

   Sets the smbios present.

   :param smbiosPresent: the smbiosPresent to set

setSmbiosVersion
^^^^^^^^^^^^^^^^

.. java:method:: public void setSmbiosVersion(String smbiosVersion)
   :outertype: HardwareDevice

   Sets the smbios version.

   :param smbiosVersion: the smbiosVersion to set

setSpeed
^^^^^^^^

.. java:method:: public void setSpeed(Long speed)
   :outertype: HardwareDevice

   Sets the speed.

   :param speed: the speed to set

setStatus
^^^^^^^^^

.. java:method:: public void setStatus(String status)
   :outertype: HardwareDevice

   Sets the status.

   :param status: the status to set

setStatusInfo
^^^^^^^^^^^^^

.. java:method:: public void setStatusInfo(String statusInfo)
   :outertype: HardwareDevice

   Sets the status info.

   :param statusInfo: the statusInfo to set

setStepping
^^^^^^^^^^^

.. java:method:: public void setStepping(Integer stepping)
   :outertype: HardwareDevice

   Sets the stepping.

   :param stepping: the stepping to set

setTag
^^^^^^

.. java:method:: public void setTag(String tag)
   :outertype: HardwareDevice

   Sets the tag.

   :param tag: the tag to set

setTerminal
^^^^^^^^^^^

.. java:method:: public void setTerminal(Terminal terminal)
   :outertype: HardwareDevice

   Sets the terminal.

   :param terminal: the terminal to set

setTotalCylinders
^^^^^^^^^^^^^^^^^

.. java:method:: public void setTotalCylinders(Integer totalCylinders)
   :outertype: HardwareDevice

   Sets the total cylinders.

   :param totalCylinders: the totalCylinders to set

setTotalPhysicalMemory
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setTotalPhysicalMemory(Long totalPhysicalMemory)
   :outertype: HardwareDevice

   Sets the total physical memory.

   :param totalPhysicalMemory: the totalPhysicalMemory to set

setTracksPerCylinder
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setTracksPerCylinder(Integer tracksPerCylinder)
   :outertype: HardwareDevice

   Sets the tracks per cylinder.

   :param tracksPerCylinder: the tracksPerCylinder to set

setUsbVersion
^^^^^^^^^^^^^

.. java:method:: public void setUsbVersion(String usbVersion)
   :outertype: HardwareDevice

   Sets the usb version.

   :param usbVersion: the usbVersion to set

setVersion
^^^^^^^^^^

.. java:method:: public void setVersion(String version)
   :outertype: HardwareDevice

   Sets the version.

   :param version: the version to set

setVerticalRes
^^^^^^^^^^^^^^

.. java:method:: public void setVerticalRes(Integer verticalRes)
   :outertype: HardwareDevice

   Sets the vertical res.

   :param verticalRes: the verticalRes to set

setVideoMemory
^^^^^^^^^^^^^^

.. java:method:: public void setVideoMemory(Integer videoMemory)
   :outertype: HardwareDevice

   Sets the video memory.

   :param videoMemory: the videoMemory to set

setVideoProcessor
^^^^^^^^^^^^^^^^^

.. java:method:: public void setVideoProcessor(String videoProcessor)
   :outertype: HardwareDevice

   Sets the video processor.

   :param videoProcessor: the videoProcessor to set

setVolumeName
^^^^^^^^^^^^^

.. java:method:: public void setVolumeName(String volumeName)
   :outertype: HardwareDevice

   Sets the volume name.

   :param volumeName: the volumeName to set

setVolumeSerialNumber
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setVolumeSerialNumber(String volumeSerialNumber)
   :outertype: HardwareDevice

   Sets the volume serial number.

   :param volumeSerialNumber: the volumeSerialNumber to set

setWorkgroup
^^^^^^^^^^^^

.. java:method:: public void setWorkgroup(String workgroup)
   :outertype: HardwareDevice

   Sets the workgroup.

   :param workgroup: the workgroup to set

