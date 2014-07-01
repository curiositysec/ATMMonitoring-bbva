package com.ncr.ATMMonitoring.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;

import com.ncr.ATMMonitoring.utils.Operation;
import com.ncr.ATMMonitoring.utils.Utils;
import com.ncr.agent.baseData.os.module.BaseBoardPojo;
import com.ncr.agent.baseData.os.module.BiosPojo;
import com.ncr.agent.baseData.os.module.CDROMDrivePojo;
import com.ncr.agent.baseData.os.module.ComputerSystemPojo;
import com.ncr.agent.baseData.os.module.DesktopMonitorPojo;
import com.ncr.agent.baseData.os.module.DiskDrivePojo;
import com.ncr.agent.baseData.os.module.FloppyDrivePojo;
import com.ncr.agent.baseData.os.module.KeyboardPojo;
import com.ncr.agent.baseData.os.module.LogicalDiskPojo;
import com.ncr.agent.baseData.os.module.NetworkAdapterSettingPojo;
import com.ncr.agent.baseData.os.module.ParallelPortPojo;
import com.ncr.agent.baseData.os.module.PhysicalMemoryPojo;
import com.ncr.agent.baseData.os.module.PointingDevicePojo;
import com.ncr.agent.baseData.os.module.ProcessorPojo;
import com.ncr.agent.baseData.os.module.SCSIControllerPojo;
import com.ncr.agent.baseData.os.module.SerialPortPojo;
import com.ncr.agent.baseData.os.module.SoundDevicePojo;
import com.ncr.agent.baseData.os.module.SystemSlotPojo;
import com.ncr.agent.baseData.os.module.USBControllerPojo;
import com.ncr.agent.baseData.os.module.UsbHubPojo;
import com.ncr.agent.baseData.os.module.VideoControllerPojo;
import com.ncr.agent.baseData.os.module._1394ControllerPojo;

/**
 * The HardwareDevice Pojo.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "hardware_devices")
public class HardwareDevice extends Auditable {

    /** The logger. */
    static private Logger logger = Logger.getLogger(HardwareDevice.class
	    .getName());

    /** The comboboxes data related to this entity for the query designer. */
    private static final Map<String, Map> comboboxes;

    static {
	comboboxes = new TreeMap<String, Map>();
	Map<String, Map> stringOperations = Operation
		.getOperationsByType(Operation.DataType.STRING);
	Map<String, Map> dateOperations = Operation
		.getOperationsByType(Operation.DataType.DATE);
	Map<String, Map> numberOperations = Operation
		.getOperationsByType(Operation.DataType.NUMBER);
	Map<String, Map> boolOperations = Operation
		.getOperationsByType(Operation.DataType.BOOLEAN);

	Map<String, Map> values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("caption", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("model", stringOperations);
	values.put("description", stringOperations);
	values.put("numberOfProcessors", numberOperations);
	values.put("totalPhysicalMemory", numberOperations);
	values.put("domain", stringOperations);
	values.put("workgroup", stringOperations);
	values.put("status", stringOperations);
	values.put("currentTimeZone", numberOperations);
	values.put("daylightInEffect", boolOperations);
	comboboxes.put("Win32_ComputerSystem", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("caption", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("architecture", stringOperations);
	values.put("addressWidth", numberOperations);
	values.put("dataWidth", numberOperations);
	values.put("currentClockSpeed", numberOperations);
	values.put("maxClockSpeed", numberOperations);
	values.put("extClock", numberOperations);
	values.put("stepping", numberOperations);
	values.put("status", stringOperations);
	comboboxes.put("Win32_Processor", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("capacity", numberOperations);
	values.put("status", stringOperations);
	comboboxes.put("Win32_PhysicalMemory", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("model", stringOperations);
	values.put("caption", stringOperations);
	values.put("partitions", numberOperations);
	values.put("size", numberOperations);
	values.put("status", stringOperations);
	values.put("description", stringOperations);
	values.put("deviceId", stringOperations);
	values.put("firmwareRevision", stringOperations);
	values.put("serialNumber", stringOperations);
	values.put("mediaType", stringOperations);
	values.put("maxMediaSize", numberOperations);
	values.put("totalCylinders", numberOperations);
	values.put("tracksPerCylinder", numberOperations);
	values.put("sectorsPerTrack", numberOperations);
	values.put("bytesPerSector", numberOperations);
	values.put("signature", stringOperations);
	comboboxes.put("Win32_DiskDrive", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("size", numberOperations);
	values.put("freeSpace", numberOperations);
	values.put("fileSystem", stringOperations);
	values.put("caption", stringOperations);
	values.put("description", stringOperations);
	values.put("deviceId", stringOperations);
	values.put("volumeName", stringOperations);
	values.put("volumeSerialNumber", stringOperations);
	comboboxes.put("Win32_LogicalDisk", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("model", stringOperations);
	values.put("status", stringOperations);
	values.put("product", stringOperations);
	values.put("serialNumber", stringOperations);
	comboboxes.put("Win32_BaseBoard", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("adapterType", stringOperations);
	values.put("description", stringOperations);
	values.put("caption", stringOperations);
	values.put("dhcpEnabled", boolOperations);
	values.put("dhcpServer", stringOperations);
	values.put("ipAddress", stringOperations);
	values.put("ipSubnet", stringOperations);
	values.put("defaultIpGateway", stringOperations);
	values.put("macAddress", stringOperations);
	values.put("speed", numberOperations);
	values.put("netConnectionId", stringOperations);
	values.put("netConnectionStatus", stringOperations);
	values.put("status", stringOperations);
	values.put("interfaceIndex", numberOperations);
	comboboxes.put("Win32_NetworkAdapter", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("mediaType", stringOperations);
	values.put("deviceId", stringOperations);
	values.put("description", stringOperations);
	values.put("status", stringOperations);
	values.put("caption", stringOperations);
	comboboxes.put("Win32_FloppyDrive", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("mediaType", stringOperations);
	values.put("deviceId", stringOperations);
	values.put("status", stringOperations);
	values.put("caption", stringOperations);
	comboboxes.put("Win32_CDROMDrive", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("status", stringOperations);
	values.put("caption", stringOperations);
	comboboxes.put("Win32_SoundDevice", values);

	// values = new TreeMap<String, Map>();
	// values.put("name", stringOperations);
	// values.put("videoProcessor", stringOperations);
	// values.put("videoMemory", numberOperations);
	// values.put("bitsPerPixel", numberOperations);
	// values.put("colors", numberOperations);
	// values.put("horizontalRes", numberOperations);
	// values.put("verticalRes", numberOperations);
	// values.put("refreshRate", numberOperations);
	// values.put("description", stringOperations);
	// comboboxes.put("Win32_DisplayConfiguration", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("caption", stringOperations);
	values.put("deviceId", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("status", stringOperations);
	values.put("protocolSupported", numberOperations);
	comboboxes.put("Win32_USBController", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("numberOfPorts", numberOperations);
	values.put("description", stringOperations);
	values.put("protocolCode", stringOperations);
	values.put("usbVersion", stringOperations);
	values.put("status", stringOperations);
	comboboxes.put("Win32_USBHub", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("caption", stringOperations);
	values.put("deviceId", stringOperations);
	values.put("maxBaudRate", numberOperations);
	values.put("status", stringOperations);
	comboboxes.put("Win32_SerialPort", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("caption", stringOperations);
	values.put("deviceId", stringOperations);
	values.put("status", stringOperations);
	comboboxes.put("Win32_ParallelPort", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("caption", stringOperations);
	values.put("deviceId", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("status", stringOperations);
	values.put("description", stringOperations);
	comboboxes.put("Win32_1394Controller", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("description", stringOperations);
	values.put("caption", stringOperations);
	values.put("statusInfo", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("driverName", stringOperations);
	values.put("hardwareVersion", stringOperations);
	comboboxes.put("Win32_SCSIController", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("caption", stringOperations);
	values.put("deviceId", stringOperations);
	values.put("displayType", boolOperations);
	values.put("monitorType", stringOperations);
	values.put("monitorManufacturer", stringOperations);
	values.put("status", stringOperations);
	values.put("pixelsPerXLogicalInch", numberOperations);
	values.put("pixelsPerYLogicalInch", numberOperations);
	comboboxes.put("Win32_DesktopMonitor", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("caption", stringOperations);
	values.put("description", stringOperations);
	values.put("layout", stringOperations);
	values.put("status", stringOperations);
	comboboxes.put("Win32_Keyboard", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("caption", stringOperations);
	values.put("description", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("hardwareType", stringOperations);
	values.put("pointingType", numberOperations);
	values.put("status", stringOperations);
	comboboxes.put("Win32_PointingDevice", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("caption", stringOperations);
	values.put("serialNumber", stringOperations);
	values.put("slotDesignation", stringOperations);
	values.put("currentUsage", numberOperations);
	values.put("tag", stringOperations);
	values.put("version", stringOperations);
	comboboxes.put("Win32_SystemSlot", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("manufacturer", stringOperations);
	values.put("smbiosVersion", stringOperations);
	values.put("smbiosMajorVersion", numberOperations);
	values.put("smbiosMinorVersion", numberOperations);
	values.put("caption", stringOperations);
	values.put("currentLanguage", stringOperations);
	values.put("primaryBios", boolOperations);
	values.put("releaseDate", dateOperations);
	values.put("serialNumber", stringOperations);
	values.put("smbiosPresent", boolOperations);
	values.put("version", stringOperations);
	values.put("status", stringOperations);
	comboboxes.put("Win32_Bios", values);

	values = new TreeMap<String, Map>();
	values.put("name", stringOperations);
	values.put("videoProcessor", stringOperations);
	values.put("description", stringOperations);
	values.put("adapterRam", numberOperations);
	values.put("currentBitsPerPixel", numberOperations);
	values.put("currentNumberOfColors", numberOperations);
	values.put("currentHorizontalResolution", numberOperations);
	values.put("currentVerticalResolution", numberOperations);
	values.put("currentRefreshRate", numberOperations);
	comboboxes.put("Win32_VideoController", values);
	values = new TreeMap<String, Map>();
	for (String hwDevice : comboboxes.keySet()) {
	    Map<String, Map> aux = comboboxes.get(hwDevice);
	    for (String name : aux.keySet()) {
		values.put(name, aux.get(name));
	    }
	}
	comboboxes.put("allHwDevices", values);
    }

    /** The Constant separator. */
    private static final char separator = ';';

    /** The Constant deviceClasses. */
    private static final Map<DeviceClassId, String> deviceClasses;

    /**
     * The Enum DeviceClassId.
     */
    public static enum DeviceClassId {

	/** The computer system. */
	COMPUTER_SYSTEM,
	/** The processor. */
	PROCESSOR,
	/** The physical memory. */
	PHYSICAL_MEMORY,
	/** The disk drive. */
	DISK_DRIVE,
	/** The logical disk. */
	LOGICAL_DISK,
	/** The base board. */
	BASE_BOARD,
	/** The network adapter. */
	NETWORK_ADAPTER,
	/** The floppy drive. */
	FLOPPY_DRIVE,
	/** The cdrom drive. */
	CDROM_DRIVE,
	/** The sound device. */
	SOUND_DEVICE,
	/** The display configuration. */
	DISPLAY_CONFIGURATION,
	/** The usb controller. */
	USB_CONTROLLER,
	/** The usb hub. */
	USB_HUB,
	/** The serial port. */
	SERIAL_PORT,
	/** The parallel port. */
	PARALLEL_PORT,
	/** The _1394_ controller. */
	_1394_CONTROLLER,
	/** The scsi controller. */
	SCSI_CONTROLLER,
	/** The desktop monitor. */
	DESKTOP_MONITOR,
	/** The keyboard. */
	KEYBOARD,
	/** The pointing device. */
	POINTING_DEVICE,
	/** The system slot. */
	SYSTEM_SLOT,
	/** The bios. */
	BIOS,
	/** The video controller. */
	VIDEO_CONTROLLER
    }

    static {
	deviceClasses = new HashMap<DeviceClassId, String>();
	deviceClasses
		.put(DeviceClassId.COMPUTER_SYSTEM, "Win32_ComputerSystem");
	deviceClasses.put(DeviceClassId.PROCESSOR, "Win32_Processor");
	deviceClasses
		.put(DeviceClassId.PHYSICAL_MEMORY, "Win32_PhysicalMemory");
	deviceClasses.put(DeviceClassId.DISK_DRIVE, "Win32_DiskDrive");
	deviceClasses.put(DeviceClassId.LOGICAL_DISK, "Win32_LogicalDisk");
	deviceClasses.put(DeviceClassId.BASE_BOARD, "Win32_BaseBoard");
	deviceClasses
		.put(DeviceClassId.NETWORK_ADAPTER, "Win32_NetworkAdapter");
	deviceClasses.put(DeviceClassId.FLOPPY_DRIVE, "Win32_FloppyDrive");
	deviceClasses.put(DeviceClassId.CDROM_DRIVE, "Win32_CDROMDrive");
	deviceClasses.put(DeviceClassId.SOUND_DEVICE, "Win32_SoundDevice");
	deviceClasses.put(DeviceClassId.DISPLAY_CONFIGURATION,
		"Win32_DisplayConfiguration");
	deviceClasses.put(DeviceClassId.USB_CONTROLLER, "Win32_USBController");
	deviceClasses.put(DeviceClassId.USB_HUB, "Win32_USBHub");
	deviceClasses.put(DeviceClassId.SERIAL_PORT, "Win32_SerialPort");
	deviceClasses.put(DeviceClassId.PARALLEL_PORT, "Win32_ParallelPort");
	deviceClasses.put(DeviceClassId._1394_CONTROLLER,
		"Win32_1394Controller");
	deviceClasses
		.put(DeviceClassId.SCSI_CONTROLLER, "Win32_SCSIController");
	deviceClasses
		.put(DeviceClassId.DESKTOP_MONITOR, "Win32_DesktopMonitor");
	deviceClasses.put(DeviceClassId.KEYBOARD, "Win32_Keyboard");
	deviceClasses
		.put(DeviceClassId.POINTING_DEVICE, "Win32_PointingDevice");
	deviceClasses.put(DeviceClassId.SYSTEM_SLOT, "Win32_SystemSlot");
	deviceClasses.put(DeviceClassId.BIOS, "Win32_Bios");
	deviceClasses.put(DeviceClassId.VIDEO_CONTROLLER,
		"Win32_VideoController");
    }

    /**
     * Filter a collecion of hardware devices by device type.
     * 
     * @param hardwareDevs
     *            the hardware devs
     * @param deviceClass
     *            the device type
     * @return the filtered hardware devs
     */
    private static Set<HardwareDevice> filterByClass(
	    Set<HardwareDevice> hardwareDevs, String deviceClass) {
	Set<HardwareDevice> result = new HashSet<HardwareDevice>();
	for (HardwareDevice dev : hardwareDevs) {
	    if ((dev.getHardwareClass() != null)
		    && (dev.getHardwareClass().equals(deviceClass))) {
		result.add(dev);
	    }
	}
	return result;
    }

    /**
     * Filter a collecion of hardware devices by device type 'computer system'.
     * 
     * @param hardwareDevs
     *            the hardware devs
     * @return the filtered hardware devs
     */
    public static Set<HardwareDevice> filterComputerSystem(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.COMPUTER_SYSTEM));
    }

    /**
     * Filter a collecion of hardware devices by device 'type processor'.
     * 
     * @param hardwareDevs
     *            the hardware devs
     * @return the filtered hardware devs
     */
    public static Set<HardwareDevice> filterProcessor(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.PROCESSOR));
    }

    /**
     * Filter a collecion of hardware devices by device type 'physical memory'.
     * 
     * @param hardwareDevs
     *            the hardware devs
     * @return the filtered hardware devs
     */
    public static Set<HardwareDevice> filterPhysicalMemory(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.PHYSICAL_MEMORY));
    }

    /**
     * Filter a collecion of hardware devices by device type 'disk drive'.
     * 
     * @param hardwareDevs
     *            the hardware devs
     * @return the filtered hardware devs
     */
    public static Set<HardwareDevice> filterDiskDrive(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.DISK_DRIVE));
    }

    /**
     * Filter a collecion of hardware devices by device type 'logical disk'.
     * 
     * @param hardwareDevs
     *            the hardware devs
     * @return the filtered hardware devs
     */
    public static Set<HardwareDevice> filterLogicalDisk(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.LOGICAL_DISK));
    }

    /**
     * Filter a collecion of hardware devices by device type 'base board'.
     * 
     * @param hardwareDevs
     *            the hardware devs
     * @return the filtered hardware devs
     */
    public static Set<HardwareDevice> filterBaseBoard(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.BASE_BOARD));
    }

    /**
     * Filter a collecion of hardware devices by device type 'network adapter'.
     * 
     * @param hardwareDevs
     *            the hardware devs
     * @return the filtered hardware devs
     */
    public static Set<HardwareDevice> filterNetworkAdapter(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.NETWORK_ADAPTER));
    }

    /**
     * Filter a collecion of hardware devices by device type 'floppy drive'.
     * 
     * @param hardwareDevs
     *            the hardware devs
     * @return the filtered hardware devs
     */
    public static Set<HardwareDevice> filterFloppyDrive(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.FLOPPY_DRIVE));
    }

    /**
     * Filter a collecion of hardware devices by device type 'cdrom drive'.
     * 
     * @param hardwareDevs
     *            the hardware devs
     * @return the filtered hardware devs
     */
    public static Set<HardwareDevice> filterCdromDrive(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.CDROM_DRIVE));
    }

    /**
     * Filter a collecion of hardware devices by device type 'sound device'.
     * 
     * @param hardwareDevs
     *            the hardware devs
     * @return the filtered hardware devs
     */
    public static Set<HardwareDevice> filterSoundDevice(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.SOUND_DEVICE));
    }

    /**
     * Filter a collecion of hardware devices by device type 'display
     * configuration'.
     * 
     * @param hardwareDevs
     *            the hardware devs
     * @return the filtered hardware devs
     */
    public static Set<HardwareDevice> filterDisplayConfiguration(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.DISPLAY_CONFIGURATION));
    }

    /**
     * Filter a collecion of hardware devices by device type 'usb controller'.
     * 
     * @param hardwareDevs
     *            the hardware devs
     * @return the filtered hardware devs
     */
    public static Set<HardwareDevice> filterUsbController(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.USB_CONTROLLER));
    }

    /**
     * Filter a collecion of hardware devices by device type 'usb hub'.
     * 
     * @param hardwareDevs
     *            the hardware devs
     * @return the filtered hardware devs
     */
    public static Set<HardwareDevice> filterUsbHub(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.USB_HUB));
    }

    /**
     * Filter a collecion of hardware devices by device type 'serial port'.
     * 
     * @param hardwareDevs
     *            the hardware devs
     * @return the filtered hardware devs
     */
    public static Set<HardwareDevice> filterSerialPort(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.SERIAL_PORT));
    }

    /**
     * Filter a collecion of hardware devices by device type 'parallel port'.
     * 
     * @param hardwareDevs
     *            the hardware devs
     * @return the filtered hardware devs
     */
    public static Set<HardwareDevice> filterParallelPort(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.PARALLEL_PORT));
    }

    /**
     * Filter a collecion of hardware devices by type '1394 controller'.
     * 
     * @param hardwareDevs
     *            the hardware devs
     * @return the filtered hardware devs
     */
    public static Set<HardwareDevice> filter1394Controller(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId._1394_CONTROLLER));
    }

    /**
     * Filter a collecion of hardware devices by device type 'scsi controller'.
     * 
     * @param hardwareDevs
     *            the hardware devs
     * @return the filtered hardware devs
     */
    public static Set<HardwareDevice> filterScsiController(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.SCSI_CONTROLLER));
    }

    /**
     * Filter a collecion of hardware devices by device type 'desktop monitor'.
     * 
     * @param hardwareDevs
     *            the hardware devs
     * @return the filtered hardware devs
     */
    public static Set<HardwareDevice> filterDesktopMonitor(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.DESKTOP_MONITOR));
    }

    /**
     * Filter a collecion of hardware devices by device type 'keyboard'.
     * 
     * @param hardwareDevs
     *            the hardware devs
     * @return the filtered hardware devs
     */
    public static Set<HardwareDevice> filterKeyboard(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.KEYBOARD));
    }

    /**
     * Filter a collecion of hardware devices by device type 'pointing device'.
     * 
     * @param hardwareDevs
     *            the hardware devs
     * @return the filtered hardware devs
     */
    public static Set<HardwareDevice> filterPointingDevice(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.POINTING_DEVICE));
    }

    /**
     * Filter a collecion of hardware devices by device type 'system slot'.
     * 
     * @param hardwareDevs
     *            the hardware devs
     * @return the filtered hardware devs
     */
    public static Set<HardwareDevice> filterSystemSlot(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.SYSTEM_SLOT));
    }

    /**
     * Filter a collecion of hardware devices by device type 'bios'.
     * 
     * @param hardwareDevs
     *            the hardware devs
     * @return the filtered hardware devs
     */
    public static Set<HardwareDevice> filterBios(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.BIOS));
    }

    /**
     * Filter a collecion of hardware devices by device type 'video controller'.
     * 
     * @param hardwareDevs
     *            the hardware devs
     * @return the filtered hardware devs
     */
    public static Set<HardwareDevice> filterVideoController(
	    Set<HardwareDevice> hardwareDevs) {
	return filterByClass(hardwareDevs,
		deviceClasses.get(DeviceClassId.VIDEO_CONTROLLER));
    }

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hardware_devices_id_seq")
    @SequenceGenerator(name = "hardware_devices_id_seq", sequenceName = "hardware_devices_id_seq", allocationSize = 1)
    private Integer id;

    /** The terminal. */
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.REFRESH)
    @JoinColumn(name = "terminal_id")
    private Terminal terminal;

    /** The hardware class. */
    @Column(name = "hardware_class", length = 100, nullable = false)
    private String hardwareClass;

    /** The name. */
    @Column(name = "name")
    @Type(type = "text")
    private String name;

    /** The manufacturer. */
    @Column(name = "manufacturer")
    @Type(type = "text")
    private String manufacturer;

    /** The model. */
    @Column(name = "model")
    @Type(type = "text")
    private String model;

    /** The number of processors. */
    @Column(name = "number_of_processors")
    private Integer numberOfProcessors;

    /** The caption. */
    @Column(name = "caption")
    @Type(type = "text")
    private String caption;

    /** The total physical memory. */
    @Column(name = "total_physical_memory")
    private Long totalPhysicalMemory;

    /** The description. */
    @Column(name = "description")
    @Type(type = "text")
    private String description;

    /** The current time zone. */
    @Column(name = "current_time_zone")
    private Integer currentTimeZone;

    /** The daylight in effect. */
    @Column(name = "daylight_in_effect")
    private Boolean daylightInEffect;

    /** The domain. */
    @Column(name = "domain")
    @Type(type = "text")
    private String domain;

    /** The workgroup. */
    @Column(name = "workgroup")
    @Type(type = "text")
    private String workgroup;

    /** The status. */
    @Column(name = "status")
    @Type(type = "text")
    private String status;

    /** The architecture. */
    @Column(name = "architecture")
    @Type(type = "text")
    private String architecture;

    /** The protocol code. */
    @Column(name = "protocol_code")
    @Type(type = "text")
    private String protocolCode;

    /** The address width. */
    @Column(name = "address_width")
    private Integer addressWidth;

    /** The data width. */
    @Column(name = "data_width")
    private Integer dataWidth;

    /** The number of ports. */
    @Column(name = "number_of_ports")
    private Integer numberOfPorts;

    /** The current clock speed. */
    @Column(name = "current_clock_speed")
    private Integer currentClockSpeed;

    /** The ext clock. */
    @Column(name = "ext_clock")
    private Integer extClock;

    /** The stepping. */
    @Column(name = "stepping")
    private Integer stepping;

    /** The capacity. */
    @Column(name = "capacity")
    private Long capacity;

    /** The speed. */
    @Column(name = "speed")
    private Long speed;

    /** The partitions. */
    @Column(name = "partitions")
    private Integer partitions;

    /** The size. */
    @Column(name = "size_")
    private Long size;

    /** The free space. */
    @Column(name = "free_space")
    private Long freeSpace;

    /** The product. */
    @Column(name = "product")
    @Type(type = "text")
    private String product;

    /** The file system. */
    @Column(name = "file_system")
    @Type(type = "text")
    private String fileSystem;

    /** The version. */
    @Column(name = "version")
    @Type(type = "text")
    private String version;

    /** The usb version. */
    @Column(name = "usb_version")
    @Type(type = "text")
    private String usbVersion;

    /** The adapter type. */
    @Column(name = "adapter_type")
    @Type(type = "text")
    private String adapterType;

    /** The dhcp enabled. */
    @Column(name = "dhcp_enabled")
    private Boolean dhcpEnabled;

    /** The dhcp server. */
    @Column(name = "dhcp_server")
    @Type(type = "text")
    private String dhcpServer;

    /** The ip address. */
    @Column(name = "ip_address")
    @Type(type = "text")
    private String ipAddress;

    /** The ip subnet. */
    @Column(name = "ip_subnet")
    @Type(type = "text")
    private String ipSubnet;

    /** The default ip gateway. */
    @Column(name = "default_ip_gateway")
    @Type(type = "text")
    private String defaultIpGateway;

    /** The mac address. */
    @Column(name = "mac_address", length = 17)
    private String macAddress;

    /** The net connection id. */
    @Column(name = "net_connection_id")
    @Type(type = "text")
    private String netConnectionId;

    /** The net connection status. */
    @Column(name = "net_connection_status")
    @Type(type = "text")
    private String netConnectionStatus;

    /** The video memory. */
    @Column(name = "video_memory")
    private Integer videoMemory;

    /** The device id. */
    @Column(name = "device_id")
    @Type(type = "text")
    private String deviceId;

    /** The max baud rate. */
    @Column(name = "max_baud_rate")
    private Integer maxBaudRate;

    /** The display type. */
    @Column(name = "display_type")
    private Boolean displayType;

    /** The monitor manufacturer. */
    @Column(name = "monitor_manufacturer")
    @Type(type = "text")
    private String monitorManufacturer;

    /** The signature. */
    @Column(name = "signature")
    @Type(type = "text")
    private String signature;

    /** The monitor type. */
    @Column(name = "monitor_type")
    @Type(type = "text")
    private String monitorType;

    /** The pixels per x logical inch. */
    @Column(name = "pixels_per_x_logical_inch")
    private Integer pixelsPerXLogicalInch;

    /** The pixels per y logical inch. */
    @Column(name = "pixels_per_y_logical_inch")
    private Integer pixelsPerYLogicalInch;

    /** The layout. */
    @Column(name = "layout")
    @Type(type = "text")
    private String layout;

    /** The hardware type. */
    @Column(name = "hardware_type")
    @Type(type = "text")
    private String hardwareType;

    /** The pointing type. */
    @Column(name = "pointing_type")
    private Integer pointingType;

    /** The current usage. */
    @Column(name = "current_usage")
    private Integer currentUsage;

    /** The serial number. */
    @Column(name = "serial_number")
    @Type(type = "text")
    private String serialNumber;

    /** The slot designation. */
    @Column(name = "slot_designation")
    @Type(type = "text")
    private String slotDesignation;

    /** The tag. */
    @Column(name = "tag")
    @Type(type = "text")
    private String tag;

    /** The smbios version. */
    @Column(name = "smbios_version")
    @Type(type = "text")
    private String smbiosVersion;

    /** The smbios major version. */
    @Column(name = "smbios_major_version")
    private Integer smbiosMajorVersion;

    /** The smbios minor version. */
    @Column(name = "smbios_minor_version")
    private Integer smbiosMinorVersion;

    /** The current language. */
    @Column(name = "current_language")
    @Type(type = "text")
    private String currentLanguage;

    /** The primary bios. */
    @Column(name = "primary_bios")
    private Boolean primaryBios;

    /** The release date. */
    @Column(name = "release_date")
    private Date releaseDate;

    /** The smbios present. */
    @Column(name = "smbios_present")
    private Boolean smbiosPresent;

    /** The Bits per pixel. */
    @Column(name = "bits_per_pixel")
    private Integer BitsPerPixel;

    /** The current bits per pixel. */
    @Column(name = "current_bits_per_pixel")
    private Integer currentBitsPerPixel;

    /** The current number of colors. */
    @Column(name = "current_number_of_colors")
    private Long currentNumberOfColors;

    /** The colors. */
    @Column(name = "colors")
    private Integer colors;

    /** The current refresh rate. */
    @Column(name = "current_refresh_rate")
    private Integer currentRefreshRate;

    /** The current horizontal resolution. */
    @Column(name = "current_horizontal_resolution")
    private Integer currentHorizontalResolution;

    /** The current vertical resolution. */
    @Column(name = "current_vertical_resolution")
    private Integer currentVerticalResolution;

    /** The refresh rate. */
    @Column(name = "refresh_rate")
    private Integer refreshRate;

    /** The horizontal res. */
    @Column(name = "horizontal_res")
    private Integer horizontalRes;

    /** The vertical res. */
    @Column(name = "vertical_res")
    private Integer verticalRes;

    /** The adapter ram. */
    @Column(name = "adapter_ram")
    private Integer adapterRam;

    /** The firmware revision. */
    @Column(name = "firmware_revision")
    @Type(type = "text")
    private String firmwareRevision;

    /** The max clock speed. */
    @Column(name = "max_clock_speed")
    private Integer maxClockSpeed;

    /** The max media size. */
    @Column(name = "max_media_size")
    private Integer maxMediaSize;

    /** The media type. */
    @Column(name = "media_type")
    @Type(type = "text")
    private String mediaType;

    /** The hardware version. */
    @Column(name = "hardware_version")
    @Type(type = "text")
    private String hardwareVersion;

    /** The status info. */
    @Column(name = "status_info")
    @Type(type = "text")
    private String statusInfo;

    /** The total cylinders. */
    @Column(name = "total_cylinders")
    private Integer totalCylinders;

    /** The tracks per cylinder. */
    @Column(name = "tracks_per_cylinder")
    private Integer tracksPerCylinder;

    /** The sectors per track. */
    @Column(name = "sectors_per_track")
    private Integer sectorsPerTrack;

    /** The bytes per sector. */
    @Column(name = "bytes_per_sector")
    private Integer bytesPerSector;

    /** The video processor. */
    @Column(name = "video_processor")
    @Type(type = "text")
    private String videoProcessor;

    /** The volume serial number. */
    @Column(name = "volume_serial_number")
    @Type(type = "text")
    private String volumeSerialNumber;

    /** The driver name. */
    @Column(name = "driver_name")
    @Type(type = "text")
    private String driverName;

    /** The interface index. */
    @Column(name = "interface_index")
    private Integer interfaceIndex;

    /** The protocol supported. */
    @Column(name = "protocol_supported")
    private Integer protocolSupported;

    /** The volume name. */
    @Column(name = "volume_name")
    @Type(type = "text")
    private String volumeName;

    /**
     * Instantiates a new hardware device.
     */
    public HardwareDevice() {
    }

    /**
     * Instantiates a new hardware device with the given 1394 controller data
     * from the agent.
     * 
     * @param hw
     *            the hw
     */
    public HardwareDevice(_1394ControllerPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId._1394_CONTROLLER));
	this.caption = hw.getCaption();
	this.description = hw.getDescription();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    /**
     * Instantiates a new hardware device with the given base board data from
     * the agent.
     * 
     * @param hw
     *            the hw
     */
    public HardwareDevice(BaseBoardPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.BASE_BOARD));
	this.model = hw.getModel();
	this.product = hw.getProduct();
	this.serialNumber = hw.getSerialNumber();
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    /**
     * Instantiates a new hardware device with the given bios data from the
     * agent.
     * 
     * @param hw
     *            the hw
     */
    public HardwareDevice(BiosPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.BIOS));
	this.setCaption(hw.getCaption());
	this.setCurrentLanguage(hw.getCurrentLanguage());
	this.setPrimaryBios(Boolean.parseBoolean(hw.getPrimaryBIOS()));
	if ((hw.getReleaseDate() != null) && (hw.getReleaseDate().length() > 0)
		&& (!hw.getReleaseDate().equals("null"))) {
	    try {
		this.setReleaseDate(new SimpleDateFormat("yyyyMMdd").parse(hw
			.getReleaseDate().substring(0, 8)));
	    } catch (ParseException e) {
		logger.error("Couldn't parse Bios date.", e);
		this.releaseDate = null;
	    }
	}
	this.setSmbiosVersion(Utils.unescapeJsonChain(hw.getSmBIOSVersion()));
	this.setVersion(Utils.unescapeJsonChain(hw.getVersion()));
	this.serialNumber = hw.getSerialNumber();
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    /**
     * Instantiates a new hardware device with the given cd rom drive data from
     * the agent.
     * 
     * @param hw
     *            the hw
     */
    public HardwareDevice(CDROMDrivePojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.CDROM_DRIVE));
	this.caption = hw.getCaption();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	this.manufacturer = hw.getManufacturer();
	this.mediaType = hw.getMediaType();
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    /**
     * Instantiates a new hardware device with the given computer system data
     * from the agent.
     * 
     * @param hw
     *            the hw
     */
    public HardwareDevice(ComputerSystemPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.COMPUTER_SYSTEM));
	this.caption = hw.getCaption();
	if ((hw.getCurrentTimeZone() != null)
		&& (hw.getCurrentTimeZone().length() > 0)
		&& (!hw.getCurrentTimeZone().equals("null"))) {
	    try {
		this.currentTimeZone = Integer
			.parseInt(hw.getCurrentTimeZone());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.daylightInEffect = Boolean.parseBoolean(hw.getDaylightInEffect());
	this.description = hw.getDescription();
	this.domain = hw.getDomain();
	this.manufacturer = hw.getManufacturer();
	this.model = hw.getModel();
	this.name = hw.getName();
	if ((hw.getNumberOfProcessors() != null)
		&& (hw.getNumberOfProcessors().length() > 0)
		&& (!hw.getNumberOfProcessors().equals("null"))) {
	    try {
		this.numberOfProcessors = Integer.parseInt(hw
			.getNumberOfProcessors());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.status = hw.getStatus();

	// EP410008 - 12/02/2013 - Added length > 0
	if ((hw.getTotalPhysicalMemory() != null)
		&& (hw.getTotalPhysicalMemory().length() > 0)
		&& (!hw.getTotalPhysicalMemory().equals("null"))) {
	    try {
		this.totalPhysicalMemory = Long.parseLong(hw
			.getTotalPhysicalMemory());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	// <--
	this.workgroup = hw.getWorkgroup();
    }

    /**
     * Instantiates a new hardware device with the given desktop monitor data
     * from the agent.
     * 
     * @param hw
     *            the hw
     */
    public HardwareDevice(DesktopMonitorPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.DESKTOP_MONITOR));
	this.caption = hw.getCaption();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	this.displayType = Boolean.parseBoolean(hw.getDisplayType());
	this.monitorManufacturer = hw.getMonitorManufacturer();
	this.monitorType = hw.getMonitorType();
	this.name = hw.getName();
	if ((hw.getPixelsPerXLogicalInch() != null)
		&& (hw.getPixelsPerXLogicalInch().length() > 0)
		&& (!hw.getPixelsPerXLogicalInch().equals("null"))) {
	    try {
		this.pixelsPerXLogicalInch = Integer.parseInt(hw
			.getPixelsPerXLogicalInch());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	if ((hw.getPixelsPerYLogicalInch() != null)
		&& (hw.getPixelsPerYLogicalInch().length() > 0)
		&& (!hw.getPixelsPerYLogicalInch().equals("null"))) {
	    try {
		this.pixelsPerYLogicalInch = Integer.parseInt(hw
			.getPixelsPerYLogicalInch());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.status = hw.getStatus();
    }

    /**
     * Instantiates a new hardware device with the given disk drive data from
     * the agent.
     * 
     * @param hw
     *            the hw
     */
    public HardwareDevice(DiskDrivePojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.DISK_DRIVE));
	if ((hw.getBytesPerSector() != null)
		&& (hw.getBytesPerSector().length() > 0)
		&& (!hw.getBytesPerSector().equals("null"))) {
	    try {
		this.bytesPerSector = Integer.parseInt(hw.getBytesPerSector());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.caption = hw.getCaption();
	this.description = hw.getDescription();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	this.manufacturer = hw.getManufacturer();
	if ((hw.getMaxMediaSize() != null)
		&& (hw.getMaxMediaSize().length() > 0)
		&& (!hw.getMaxMediaSize().equals("null"))) {
	    try {
		this.maxMediaSize = Integer.parseInt(hw.getMaxMediaSize());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	// this.firmwareRevision = hw.getFirmwareRevision();
	this.mediaType = hw.getMediaType();
	this.model = hw.getModel();
	this.name = hw.getName();
	if ((hw.getPartitions() != null) && (hw.getPartitions().length() > 0)
		&& (!hw.getPartitions().equals("null"))) {
	    try {
		this.partitions = Integer.parseInt(hw.getPartitions());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	if ((hw.getSectorsPerTrack() != null)
		&& (hw.getSectorsPerTrack().length() > 0)
		&& (!hw.getSectorsPerTrack().equals("null"))) {
	    try {
		this.sectorsPerTrack = Integer
			.parseInt(hw.getSectorsPerTrack());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	// this.serialNumber = hw.getSerialNumber();
	this.signature = hw.getSignature();
	this.size = Long.parseLong(hw.getSize());
	this.status = hw.getStatus();
	if ((hw.getTotalCylinders() != null)
		&& (hw.getTotalCylinders().length() > 0)
		&& (!hw.getTotalCylinders().equals("null"))) {
	    try {
		this.totalCylinders = Integer.parseInt(hw.getTotalCylinders());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	if ((hw.getTracksPerCylinder() != null)
		&& (hw.getTracksPerCylinder().length() > 0)
		&& (!hw.getTracksPerCylinder().equals("null"))) {
	    try {
		this.tracksPerCylinder = Integer.parseInt(hw
			.getTracksPerCylinder());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
    }

    /**
     * Instantiates a new hardware device with the given floppy drive data from
     * the agent.
     * 
     * @param hw
     *            the hw
     */
    public HardwareDevice(FloppyDrivePojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.FLOPPY_DRIVE));
	this.caption = hw.getCaption();
	this.description = hw.getDescription();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	this.manufacturer = hw.getManufacturer();
	// this.mediaType = hw.getMediaType();
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    /**
     * Instantiates a new hardware device with the given keyboard data from the
     * agent.
     * 
     * @param hw
     *            the hw
     */
    public HardwareDevice(KeyboardPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.KEYBOARD));
	this.caption = hw.getCaption();
	this.description = hw.getDescription();
	this.layout = hw.getLayout();
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    /**
     * Instantiates a new hardware device with the given logical disk data from
     * the agent.
     * 
     * @param hw
     *            the hw
     */
    public HardwareDevice(LogicalDiskPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.LOGICAL_DISK));
	this.caption = hw.getCaption();
	this.description = hw.getDescription();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	this.fileSystem = hw.getFileSystem();
	if ((hw.getFreeSpace() != null) && (hw.getFreeSpace().length() > 0)
		&& (!hw.getFreeSpace().equals("null"))) {
	    try {
		this.freeSpace = Long.parseLong(hw.getFreeSpace());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.name = hw.getName();
	if ((hw.getSize() != null) && (hw.getSize().length() > 0)
		&& (!hw.getSize().equals("null"))) {
	    try {
		this.size = Long.parseLong(hw.getSize());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.volumeName = hw.getVolumeName();
	this.volumeSerialNumber = hw.getVolumeSerialNumber();
    }

    /**
     * Instantiates a new hardware device with the given network adapter setting
     * data from the agent.
     * 
     * @param hw
     *            the hw
     */
    public HardwareDevice(NetworkAdapterSettingPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.NETWORK_ADAPTER));
	this.adapterType = hw.getAdapterType();
	this.caption = hw.getCaption();
	this.defaultIpGateway = hw.getDefaultIPGateway();
	this.description = hw.getDescription();
	this.dhcpEnabled = Boolean.parseBoolean(hw.getDhcpEnabled());
	this.dhcpServer = hw.getDhcpServer();
	if ((hw.getInterfaceIndex() != null)
		&& (hw.getInterfaceIndex().length() > 0)
		&& (!hw.getInterfaceIndex().equals("null"))) {
	    try {
		this.interfaceIndex = Integer.parseInt(hw.getInterfaceIndex());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.ipAddress = hw.getIpAddress();
	this.ipSubnet = hw.getIpSubnet();
	this.macAddress = hw.getMacAddress();
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	this.netConnectionId = hw.getNetConnectionID();
	this.netConnectionStatus = hw.getNetConnectionStatus();
	if ((hw.getSpeed() != null) && (hw.getSpeed().length() > 0)
		&& (!hw.getSpeed().equals("null"))) {
	    try {
		this.speed = Long.parseLong(hw.getSpeed());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.status = hw.getStatus();
    }

    /**
     * Instantiates a new hardware device with the given parallel port data from
     * the agent.
     * 
     * @param hw
     *            the hw
     */
    public HardwareDevice(ParallelPortPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.PARALLEL_PORT));
	this.caption = hw.getCaption();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    /**
     * Instantiates a new hardware device with the given physical memory data
     * from the agent.
     * 
     * @param hw
     *            the hw
     */
    public HardwareDevice(PhysicalMemoryPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.PHYSICAL_MEMORY));
	if ((hw.getCapacity() != null) && (hw.getCapacity().length() > 0)
		&& (!hw.getCapacity().equals("null"))) {
	    try {
		this.capacity = Long.parseLong(hw.getCapacity());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    /**
     * Instantiates a new hardware device with the given pointing device data
     * from the agent.
     * 
     * @param hw
     *            the hw
     */
    public HardwareDevice(PointingDevicePojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.POINTING_DEVICE));
	this.caption = hw.getCaption();
	this.description = hw.getDescription();
	this.hardwareType = hw.getHardwareType();
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	if ((hw.getPointingType() != null)
		&& (hw.getPointingType().length() > 0)
		&& (!hw.getPointingType().equals("null"))) {
	    try {
		this.pointingType = Integer.parseInt(hw.getPointingType());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.status = hw.getStatus();
    }

    /**
     * Instantiates a new hardware device with the given processor data from the
     * agent.
     * 
     * @param hw
     *            the hw
     */
    public HardwareDevice(ProcessorPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.PROCESSOR));
	if ((hw.getAddressWidth() != null)
		&& (hw.getAddressWidth().length() > 0)
		&& (!hw.getAddressWidth().equals("null"))) {
	    try {
		this.addressWidth = Integer.parseInt(hw.getAddressWidth());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.architecture = hw.getArchitecture();
	this.caption = hw.getCaption();
	if ((hw.getCurrentClockSpeed() != null)
		&& (hw.getCurrentClockSpeed().length() > 0)
		&& (!hw.getCurrentClockSpeed().equals("null"))) {
	    try {
		this.currentClockSpeed = Integer.parseInt(hw
			.getCurrentClockSpeed());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	if ((hw.getDataWidth() != null) && (hw.getDataWidth().length() > 0)
		&& (!hw.getDataWidth().equals("null"))) {
	    try {
		this.dataWidth = Integer.parseInt(hw.getDataWidth());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	if ((hw.getExtClock() != null) && (hw.getExtClock().length() > 0)
		&& (!hw.getExtClock().equals("null"))) {
	    try {
		this.extClock = Integer.parseInt(hw.getExtClock());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.manufacturer = hw.getManufacturer();
	if ((hw.getMaxClockSpeed() != null)
		&& (hw.getMaxClockSpeed().length() > 0)
		&& (!hw.getMaxClockSpeed().equals("null"))) {
	    try {
		this.maxClockSpeed = Integer.parseInt(hw.getMaxClockSpeed());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.name = hw.getName();
	// if (hw.getNumberOfCores().length() > 0) {
	// this.numberOfProcessors = Integer.parseInt(hw.getNumberOfCores());
	// }
	this.status = hw.getStatus();
    }

    /**
     * Instantiates a new hardware device with the given scsi controller data
     * from the agent.
     * 
     * @param hw
     *            the hw
     */
    public HardwareDevice(SCSIControllerPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.SCSI_CONTROLLER));
	this.caption = hw.getCaption();
	this.description = hw.getDescription();
	this.driverName = hw.getDriverName();
	this.setHardwareVersion(hw.getHardwareVersion());
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	this.statusInfo = hw.getStatusInfo();
    }

    /**
     * Instantiates a new hardware device with the given serial port data from
     * the agent.
     * 
     * @param hw
     *            the hw
     */
    public HardwareDevice(SerialPortPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.SERIAL_PORT));
	this.caption = hw.getCaption();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	if ((hw.getMaxBaudRate() != null) && (hw.getMaxBaudRate().length() > 0)
		&& (!hw.getMaxBaudRate().equals("null"))) {
	    try {
		this.maxBaudRate = Integer.parseInt(hw.getMaxBaudRate());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    /**
     * Instantiates a new hardware device with the given sound device data from
     * the agent.
     * 
     * @param hw
     *            the hw
     */
    public HardwareDevice(SoundDevicePojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.SOUND_DEVICE));
	this.caption = hw.getCaption();
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	this.status = hw.getStatus();
    }

    /**
     * Instantiates a new hardware device with the given system slot data from
     * the agent.
     * 
     * @param hw
     *            the hw
     */
    public HardwareDevice(SystemSlotPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.SYSTEM_SLOT));
	this.caption = hw.getCaption();
	if ((hw.getCurrentUsage() != null)
		&& (hw.getCurrentUsage().length() > 0)
		&& (!hw.getCurrentUsage().equals("null"))) {
	    try {
		this.currentUsage = Integer.parseInt(hw.getCurrentUsage());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	this.serialNumber = hw.getSerialNumber();
	this.slotDesignation = hw.getSlotDesignation();
	this.tag = hw.getTag();
	this.setVersion(Utils.unescapeJsonChain(hw.getVersion()));
    }

    /**
     * Instantiates a new hardware device with the given usb controller data
     * from the agent.
     * 
     * @param hw
     *            the hw
     */
    public HardwareDevice(USBControllerPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.USB_CONTROLLER));
	this.caption = hw.getCaption();
	this.deviceId = Utils.unescapeJsonChain(hw.getDeviceID());
	this.manufacturer = hw.getManufacturer();
	this.name = hw.getName();
	if ((hw.getProtocolSupported() != null)
		&& (hw.getProtocolSupported().length() > 0)
		&& (!hw.getProtocolSupported().equals("null"))) {
	    try {
		this.protocolSupported = Integer.parseInt(hw
			.getProtocolSupported());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.status = hw.getStatus();
    }

    /**
     * Instantiates a new hardware device with the given usb hub data from the
     * agent.
     * 
     * @param hw
     *            the hw
     */
    public HardwareDevice(UsbHubPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.USB_HUB));
	this.description = hw.getDescription();
	this.name = hw.getName();
	if ((hw.getNumberOfPorts() != null)
		&& (hw.getNumberOfPorts().length() > 0)
		&& (!hw.getNumberOfPorts().equals("null"))) {
	    try {
		this.numberOfPorts = Integer.parseInt(hw.getNumberOfPorts());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.protocolCode = hw.getProtocolCode();
	this.status = hw.getStatus();
	this.setUsbVersion(hw.getUsbVersion());
    }

    /**
     * Instantiates a new hardware device with the given video controller data
     * from the agent.
     * 
     * @param hw
     *            the hw
     */
    public HardwareDevice(VideoControllerPojo hw) {
	this.setHardwareClass(deviceClasses.get(DeviceClassId.VIDEO_CONTROLLER));
	if ((hw.getAdapterRAM() != null) && (hw.getAdapterRAM().length() > 0)
		&& (!hw.getAdapterRAM().equals("null"))) {
	    try {
		this.adapterRam = Integer.parseInt(hw.getAdapterRAM());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	// EP410008 - 12/02/2013 - Added length > 0
	if ((hw.getCurrentBitsPerPixel() != null)
		&& (hw.getCurrentBitsPerPixel().length() > 0)
		&& (!hw.getCurrentBitsPerPixel().equals("null"))) {
	    try {
		this.currentBitsPerPixel = Integer.parseInt(hw
			.getCurrentBitsPerPixel());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	if ((hw.getCurrentHorizontalResolution() != null)
		&& (hw.getCurrentHorizontalResolution().length() > 0)
		&& (!hw.getCurrentHorizontalResolution().equals("null"))) {
	    try {
		this.currentHorizontalResolution = Integer.parseInt(hw
			.getCurrentHorizontalResolution());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	if ((hw.getCurrentNumberOfColors() != null)
		&& (hw.getCurrentNumberOfColors().length() > 0)
		&& (!hw.getCurrentNumberOfColors().equals("null"))) {
	    try {
		this.currentNumberOfColors = Long.parseLong(hw
			.getCurrentNumberOfColors());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	if ((hw.getCurrentRefreshRate() != null)
		&& (hw.getCurrentRefreshRate().length() > 0)
		&& (!hw.getCurrentRefreshRate().equals("null"))) {
	    try {
		this.currentRefreshRate = Integer.parseInt(hw
			.getCurrentRefreshRate());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	if ((hw.getCurrentVerticalResolution() != null)
		&& (hw.getCurrentVerticalResolution().length() > 0)
		&& (!hw.getCurrentVerticalResolution().equals("null"))) {
	    try {
		this.currentVerticalResolution = Integer.parseInt(hw
			.getCurrentVerticalResolution());
	    } catch (NumberFormatException e) {
		logger.warn("Error when parsing number.", e);
	    }
	}
	this.description = hw.getDescription();
	this.name = hw.getName();
	this.videoProcessor = hw.getVideoProcessor();
    }

    /**
     * Instantiates a new agent specific hardware device data with the current
     * attributes.
     * 
     * @return the agent hardware device data
     */
    public Object getInventoryPojo() {
	if (hardwareClass == null) {
	    return null;
	}

	if (hardwareClass.equals(HardwareDevice.deviceClasses
		.get(HardwareDevice.DeviceClassId._1394_CONTROLLER))) {
	    _1394ControllerPojo pojo = new _1394ControllerPojo();
	    pojo.setCaption(caption);
	    pojo.setDescription(description);
	    pojo.setDeviceID(deviceId);
	    pojo.setManufacturer(manufacturer);
	    pojo.setName(name);
	    pojo.setStatus(status);
	    return pojo;
	}

	if (hardwareClass.equals(HardwareDevice.deviceClasses
		.get(HardwareDevice.DeviceClassId.BASE_BOARD))) {
	    BaseBoardPojo pojo = new BaseBoardPojo();
	    pojo.setModel(model);
	    pojo.setProduct(product);
	    pojo.setSerialNumber(serialNumber);
	    pojo.setManufacturer(manufacturer);
	    pojo.setName(name);
	    pojo.setStatus(status);
	    return pojo;
	}

	if (hardwareClass.equals(HardwareDevice.deviceClasses
		.get(HardwareDevice.DeviceClassId.BIOS))) {
	    BiosPojo pojo = new BiosPojo();
	    pojo.setCurrentLanguage(currentLanguage);
	    if (primaryBios != null) {
		pojo.setPrimaryBIOS(Boolean.valueOf(primaryBios).toString());
	    }
	    if (releaseDate != null) {
		pojo.setReleaseDate(new SimpleDateFormat("yyyyMMdd")
			.format(releaseDate));
	    }
	    pojo.setSmBIOSVersion(getSmbiosVersion());
	    pojo.setVersion(getVersion());
	    pojo.setSerialNumber(serialNumber);
	    pojo.setManufacturer(manufacturer);
	    pojo.setName(name);
	    pojo.setStatus(status);
	    return pojo;
	}

	if (hardwareClass.equals(HardwareDevice.deviceClasses
		.get(HardwareDevice.DeviceClassId.CDROM_DRIVE))) {
	    CDROMDrivePojo pojo = new CDROMDrivePojo();
	    pojo.setCaption(caption);
	    pojo.setDeviceID(deviceId);
	    pojo.setManufacturer(manufacturer);
	    pojo.setMediaType(mediaType);
	    pojo.setName(name);
	    pojo.setStatus(status);
	    return pojo;
	}

	if (hardwareClass.equals(HardwareDevice.deviceClasses
		.get(HardwareDevice.DeviceClassId.COMPUTER_SYSTEM))) {
	    ComputerSystemPojo pojo = new ComputerSystemPojo();
	    pojo.setCaption(caption);
	    if (currentTimeZone != null) {
		pojo.setCurrentTimeZone(Integer.valueOf(currentTimeZone)
			.toString());
	    }
	    if (daylightInEffect != null) {
		pojo.setDaylightInEffect(Boolean.valueOf(daylightInEffect)
			.toString());
	    }
	    pojo.setDescription(description);
	    pojo.setDomain(domain);
	    pojo.setManufacturer(manufacturer);
	    pojo.setModel(model);
	    pojo.setName(name);
	    if (numberOfProcessors != null) {
		pojo.setNumberOfProcessors(new Integer(numberOfProcessors)
			.toString());
	    }
	    pojo.setStatus(status);
	    if (totalPhysicalMemory != null) {
		pojo.setTotalPhysicalMemory(new Long(totalPhysicalMemory)
			.toString());
	    }
	    pojo.setWorkgroup(workgroup);
	    return pojo;
	}

	if (hardwareClass.equals(HardwareDevice.deviceClasses
		.get(HardwareDevice.DeviceClassId.DESKTOP_MONITOR))) {
	    DesktopMonitorPojo pojo = new DesktopMonitorPojo();
	    pojo.setCaption(caption);
	    pojo.setDeviceID(deviceId);
	    if (displayType != null) {
		pojo.setDisplayType(Boolean.valueOf(displayType).toString());
	    }
	    pojo.setMonitorManufacturer(monitorManufacturer);
	    pojo.setMonitorType(monitorType);
	    pojo.setName(name);
	    if (pixelsPerXLogicalInch != null) {
		pojo.setPixelsPerXLogicalInch(new Integer(pixelsPerXLogicalInch)
			.toString());
	    }
	    if (pixelsPerYLogicalInch != null) {
		pojo.setPixelsPerYLogicalInch(new Integer(pixelsPerYLogicalInch)
			.toString());
	    }
	    pojo.setStatus(status);
	    return pojo;
	}

	if (hardwareClass.equals(HardwareDevice.deviceClasses
		.get(HardwareDevice.DeviceClassId.DISK_DRIVE))) {
	    DiskDrivePojo pojo = new DiskDrivePojo();
	    if (bytesPerSector != null) {
		pojo.setBytesPerSector(new Integer(bytesPerSector).toString());
	    }
	    pojo.setCaption(caption);
	    pojo.setDescription(description);
	    pojo.setDeviceID(deviceId);
	    pojo.setManufacturer(manufacturer);
	    if (maxMediaSize != null) {
		pojo.setMaxMediaSize(new Integer(maxMediaSize).toString());
	    }
	    pojo.setMediaType(mediaType);
	    pojo.setModel(model);
	    pojo.setName(name);
	    if (partitions != null) {
		pojo.setPartitions(new Integer(partitions).toString());
	    }
	    if (sectorsPerTrack != null) {
		pojo.setSectorsPerTrack(new Integer(sectorsPerTrack).toString());
	    }
	    pojo.setSignature(signature);
	    if (size != null) {
		pojo.setSize(new Long(size).toString());
	    }
	    pojo.setStatus(status);
	    if (totalCylinders != null) {
		pojo.setTotalCylinders(new Integer(totalCylinders).toString());
	    }
	    if (tracksPerCylinder != null) {
		pojo.setTracksPerCylinder(new Integer(tracksPerCylinder)
			.toString());
	    }
	    return pojo;
	}

	if (hardwareClass.equals(HardwareDevice.deviceClasses
		.get(HardwareDevice.DeviceClassId.FLOPPY_DRIVE))) {
	    FloppyDrivePojo pojo = new FloppyDrivePojo();
	    pojo.setCaption(caption);
	    pojo.setDescription(description);
	    pojo.setDeviceID(deviceId);
	    pojo.setManufacturer(manufacturer);
	    pojo.setName(name);
	    pojo.setStatus(status);
	    return pojo;
	}

	if (hardwareClass.equals(HardwareDevice.deviceClasses
		.get(HardwareDevice.DeviceClassId.KEYBOARD))) {
	    KeyboardPojo pojo = new KeyboardPojo();
	    pojo.setCaption(caption);
	    pojo.setDescription(description);
	    pojo.setLayout(layout);
	    pojo.setName(name);
	    pojo.setStatus(status);
	    return pojo;
	}

	if (hardwareClass.equals(HardwareDevice.deviceClasses
		.get(HardwareDevice.DeviceClassId.LOGICAL_DISK))) {
	    LogicalDiskPojo pojo = new LogicalDiskPojo();
	    pojo.setCaption(caption);
	    pojo.setDescription(description);
	    pojo.setDeviceID(deviceId);
	    pojo.setFileSystem(fileSystem);
	    if (freeSpace != null) {
		pojo.setFreeSpace(new Long(freeSpace).toString());
	    }
	    pojo.setName(name);
	    if (size != null) {
		pojo.setSize(new Long(size).toString());
	    }
	    pojo.setVolumeName(volumeName);
	    pojo.setVolumeSerialNumber(volumeSerialNumber);
	    return pojo;
	}

	if (hardwareClass.equals(HardwareDevice.deviceClasses
		.get(HardwareDevice.DeviceClassId.NETWORK_ADAPTER))) {
	    NetworkAdapterSettingPojo pojo = new NetworkAdapterSettingPojo();
	    pojo.setAdapterType(adapterType);
	    pojo.setCaption(caption);
	    pojo.setDefaultIPGateway(defaultIpGateway);
	    pojo.setDescription(description);
	    if (dhcpEnabled != null) {
		pojo.setDhcpEnabled(Boolean.valueOf(dhcpEnabled).toString());
	    }
	    pojo.setDhcpServer(dhcpServer);
	    if (interfaceIndex != null) {
		pojo.setInterfaceIndex(new Integer(interfaceIndex).toString());
	    }
	    pojo.setIpAddress(ipAddress);
	    pojo.setIpSubnet(ipSubnet);
	    pojo.setMacAddress(macAddress);
	    pojo.setManufacturer(manufacturer);
	    pojo.setName(name);
	    pojo.setNetConnectionID(netConnectionId);
	    pojo.setNetConnectionStatus(netConnectionStatus);
	    if (speed != null) {
		pojo.setSpeed(new Long(speed).toString());
	    }
	    pojo.setStatus(status);
	    return pojo;
	}

	if (hardwareClass.equals(HardwareDevice.deviceClasses
		.get(HardwareDevice.DeviceClassId.PARALLEL_PORT))) {
	    ParallelPortPojo pojo = new ParallelPortPojo();
	    pojo.setCaption(caption);
	    pojo.setDeviceID(deviceId);
	    pojo.setName(name);
	    pojo.setStatus(status);
	    return pojo;
	}

	if (hardwareClass.equals(HardwareDevice.deviceClasses
		.get(HardwareDevice.DeviceClassId.PHYSICAL_MEMORY))) {
	    PhysicalMemoryPojo pojo = new PhysicalMemoryPojo();
	    if (capacity != null) {
		pojo.setCapacity(new Long(capacity).toString());
	    }
	    pojo.setManufacturer(manufacturer);
	    pojo.setName(name);
	    pojo.setStatus(status);
	    return pojo;
	}

	if (hardwareClass.equals(HardwareDevice.deviceClasses
		.get(HardwareDevice.DeviceClassId.POINTING_DEVICE))) {
	    PointingDevicePojo pojo = new PointingDevicePojo();
	    pojo.setCaption(caption);
	    pojo.setDescription(description);
	    pojo.setHardwareType(hardwareType);
	    pojo.setManufacturer(manufacturer);
	    pojo.setName(name);
	    if (pointingType != null) {
		pojo.setPointingType(new Integer(pointingType).toString());
	    }
	    pojo.setStatus(status);
	    return pojo;
	}

	if (hardwareClass.equals(HardwareDevice.deviceClasses
		.get(HardwareDevice.DeviceClassId.PROCESSOR))) {
	    ProcessorPojo pojo = new ProcessorPojo();
	    if (addressWidth != null) {
		pojo.setAddressWidth(new Integer(addressWidth).toString());
	    }
	    pojo.setArchitecture(architecture);
	    pojo.setCaption(caption);
	    if (currentClockSpeed != null) {
		pojo.setCurrentClockSpeed(new Integer(currentClockSpeed)
			.toString());
	    }
	    if (dataWidth != null) {
		pojo.setDataWidth(new Integer(dataWidth).toString());
	    }
	    if (extClock != null) {
		pojo.setExtClock(new Integer(extClock).toString());
	    }
	    pojo.setManufacturer(manufacturer);
	    if (maxClockSpeed != null) {
		pojo.setMaxClockSpeed(new Integer(maxClockSpeed).toString());
	    }
	    pojo.setName(name);
	    pojo.setStatus(status);
	    return pojo;
	}

	if (hardwareClass.equals(HardwareDevice.deviceClasses
		.get(HardwareDevice.DeviceClassId.SCSI_CONTROLLER))) {
	    SCSIControllerPojo pojo = new SCSIControllerPojo();
	    pojo.setCaption(caption);
	    pojo.setDescription(description);
	    pojo.setDriverName(driverName);
	    pojo.setHardwareVersion(hardwareVersion);
	    pojo.setManufacturer(manufacturer);
	    pojo.setName(name);
	    pojo.setStatusInfo(statusInfo);
	    return pojo;
	}

	if (hardwareClass.equals(HardwareDevice.deviceClasses
		.get(HardwareDevice.DeviceClassId.SERIAL_PORT))) {
	    SerialPortPojo pojo = new SerialPortPojo();
	    pojo.setCaption(caption);
	    pojo.setDeviceID(deviceId);
	    if (maxBaudRate != null) {
		pojo.setMaxBaudRate(new Integer(maxBaudRate).toString());
	    }
	    pojo.setName(name);
	    pojo.setStatus(status);
	    return pojo;
	}

	if (hardwareClass.equals(HardwareDevice.deviceClasses
		.get(HardwareDevice.DeviceClassId.SOUND_DEVICE))) {
	    SoundDevicePojo pojo = new SoundDevicePojo();
	    pojo.setCaption(caption);
	    pojo.setManufacturer(manufacturer);
	    pojo.setName(name);
	    pojo.setStatus(status);
	    return pojo;
	}

	if (hardwareClass.equals(HardwareDevice.deviceClasses
		.get(HardwareDevice.DeviceClassId.SYSTEM_SLOT))) {
	    SystemSlotPojo pojo = new SystemSlotPojo();
	    pojo.setCaption(caption);
	    if (currentUsage != null) {
		pojo.setCurrentUsage(new Integer(currentUsage).toString());
	    }
	    pojo.setManufacturer(manufacturer);
	    pojo.setName(name);
	    pojo.setSerialNumber(serialNumber);
	    pojo.setSlotDesignation(slotDesignation);
	    pojo.setTag(tag);
	    pojo.setVersion(getVersion());
	    return pojo;
	}

	if (hardwareClass.equals(HardwareDevice.deviceClasses
		.get(HardwareDevice.DeviceClassId.USB_CONTROLLER))) {
	    USBControllerPojo pojo = new USBControllerPojo();
	    pojo.setCaption(caption);
	    pojo.setDeviceID(deviceId);
	    pojo.setManufacturer(manufacturer);
	    pojo.setName(name);
	    if (protocolSupported != null) {
		pojo.setProtocolSupported(new Integer(protocolSupported)
			.toString());
	    }
	    pojo.setStatus(status);
	    return pojo;
	}

	if (hardwareClass.equals(HardwareDevice.deviceClasses
		.get(HardwareDevice.DeviceClassId.USB_HUB))) {
	    UsbHubPojo pojo = new UsbHubPojo();
	    pojo.setDescription(description);
	    pojo.setName(name);
	    if (numberOfPorts != null) {
		pojo.setNumberOfPorts(new Integer(numberOfPorts).toString());
	    }
	    pojo.setProtocolCode(protocolCode);
	    pojo.setStatus(status);
	    pojo.setUsbVersion(getUsbVersion());
	    return pojo;
	}

	if (hardwareClass.equals(HardwareDevice.deviceClasses
		.get(HardwareDevice.DeviceClassId.VIDEO_CONTROLLER))) {
	    VideoControllerPojo pojo = new VideoControllerPojo();
	    if (adapterRam != null) {
		pojo.setAdapterRAM(new Integer(adapterRam).toString());
	    }
	    if (currentBitsPerPixel != null) {
		pojo.setCurrentBitsPerPixel(new Integer(currentBitsPerPixel)
			.toString());
	    }
	    if (currentHorizontalResolution != null) {
		pojo.setCurrentHorizontalResolution(new Integer(
			currentHorizontalResolution).toString());
	    }
	    if (currentNumberOfColors != null) {
		pojo.setCurrentNumberOfColors(new Long(currentNumberOfColors)
			.toString());
	    }
	    if (currentRefreshRate != null) {
		pojo.setCurrentRefreshRate(new Integer(currentRefreshRate)
			.toString());
	    }
	    if (currentVerticalResolution != null) {
		pojo.setCurrentVerticalResolution(new Integer(
			currentVerticalResolution).toString());
	    }
	    pojo.setDescription(description);
	    pojo.setName(name);
	    pojo.setVideoProcessor(videoProcessor);
	    return pojo;
	}

	return null;
    }

    /**
     * Gets the comboboxes data for the query GUI.
     * 
     * @return the comboboxes data
     */
    public static Map<String, Map> getComboboxes() {
	return comboboxes;
    }

    public static Map<String, Map> getComboboxesByDeviceClassId(
	    DeviceClassId deviceClassId) {
	return comboboxes.get(deviceClasses.get(deviceClassId));
    }

    public static Map<DeviceClassId, String> getDeviceClasses() {
	return deviceClasses;
    }

    /**
     * Gets the id.
     * 
     * @return the id
     */
    public Integer getId() {
	return id;
    }

    /**
     * Sets the id.
     * 
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
	this.id = id;
    }

    /**
     * Gets the hardware class.
     * 
     * @return the hardwareClass
     */
    public String getHardwareClass() {
	return hardwareClass;
    }

    /**
     * Sets the hardware class.
     * 
     * @param hardwareClass
     *            the hardwareClass to set
     */
    public void setHardwareClass(String hardwareClass) {
	this.hardwareClass = hardwareClass;
    }

    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * Sets the name.
     * 
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Gets the terminal.
     * 
     * @return the terminal
     */
    public Terminal getTerminal() {
	return terminal;
    }

    /**
     * Sets the terminal.
     * 
     * @param terminal
     *            the terminal to set
     */
    public void setTerminal(Terminal terminal) {
	this.terminal = terminal;
    }

    /**
     * Gets the manufacturer.
     * 
     * @return the manufacturer
     */
    public String getManufacturer() {
	return manufacturer;
    }

    /**
     * Sets the manufacturer.
     * 
     * @param manufacturer
     *            the manufacturer to set
     */
    public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
    }

    /**
     * Gets the model.
     * 
     * @return the model
     */
    public String getModel() {
	return model;
    }

    /**
     * Sets the model.
     * 
     * @param model
     *            the model to set
     */
    public void setModel(String model) {
	this.model = model;
    }

    /**
     * Gets the number of processors.
     * 
     * @return the numberOfProcessors
     */
    public Integer getNumberOfProcessors() {
	return numberOfProcessors;
    }

    /**
     * Sets the number of processors.
     * 
     * @param numberOfProcessors
     *            the numberOfProcessors to set
     */
    public void setNumberOfProcessors(Integer numberOfProcessors) {
	this.numberOfProcessors = numberOfProcessors;
    }

    /**
     * Gets the caption.
     * 
     * @return the caption
     */
    public String getCaption() {
	return caption;
    }

    /**
     * Sets the caption.
     * 
     * @param caption
     *            the caption to set
     */
    public void setCaption(String caption) {
	this.caption = caption;
    }

    /**
     * Gets the total physical memory.
     * 
     * @return the totalPhysicalMemory
     */
    public Long getTotalPhysicalMemory() {
	return totalPhysicalMemory;
    }

    /**
     * Sets the total physical memory.
     * 
     * @param totalPhysicalMemory
     *            the totalPhysicalMemory to set
     */
    public void setTotalPhysicalMemory(Long totalPhysicalMemory) {
	this.totalPhysicalMemory = totalPhysicalMemory;
    }

    /**
     * Gets the description.
     * 
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /**
     * Sets the description.
     * 
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * Gets the current time zone.
     * 
     * @return the currentTimeZone
     */
    public Integer getCurrentTimeZone() {
	return currentTimeZone;
    }

    /**
     * Sets the current time zone.
     * 
     * @param currentTimeZone
     *            the currentTimeZone to set
     */
    public void setCurrentTimeZone(Integer currentTimeZone) {
	this.currentTimeZone = currentTimeZone;
    }

    /**
     * Gets the daylight in effect.
     * 
     * @return the daylightInEffect
     */
    public Boolean getDaylightInEffect() {
	return daylightInEffect;
    }

    /**
     * Sets the daylight in effect.
     * 
     * @param daylightInEffect
     *            the daylightInEffect to set
     */
    public void setDaylightInEffect(Boolean daylightInEffect) {
	this.daylightInEffect = daylightInEffect;
    }

    /**
     * Gets the domain.
     * 
     * @return the domain
     */
    public String getDomain() {
	return domain;
    }

    /**
     * Sets the domain.
     * 
     * @param domain
     *            the domain to set
     */
    public void setDomain(String domain) {
	this.domain = domain;
    }

    /**
     * Gets the workgroup.
     * 
     * @return the workgroup
     */
    public String getWorkgroup() {
	return workgroup;
    }

    /**
     * Sets the workgroup.
     * 
     * @param workgroup
     *            the workgroup to set
     */
    public void setWorkgroup(String workgroup) {
	this.workgroup = workgroup;
    }

    /**
     * Gets the status.
     * 
     * @return the status
     */
    public String getStatus() {
	return status;
    }

    /**
     * Sets the status.
     * 
     * @param status
     *            the status to set
     */
    public void setStatus(String status) {
	this.status = status;
    }

    /**
     * Gets the architecture.
     * 
     * @return the architecture
     */
    public String getArchitecture() {
	return architecture;
    }

    /**
     * Sets the architecture.
     * 
     * @param architecture
     *            the architecture to set
     */
    public void setArchitecture(String architecture) {
	this.architecture = architecture;
    }

    /**
     * Gets the address width.
     * 
     * @return the addressWidth
     */
    public Integer getAddressWidth() {
	return addressWidth;
    }

    /**
     * Sets the address width.
     * 
     * @param addressWidth
     *            the addressWidth to set
     */
    public void setAddressWidth(Integer addressWidth) {
	this.addressWidth = addressWidth;
    }

    /**
     * Gets the current clock speed.
     * 
     * @return the currentClockSpeed
     */
    public Integer getCurrentClockSpeed() {
	return currentClockSpeed;
    }

    /**
     * Sets the current clock speed.
     * 
     * @param currentClockSpeed
     *            the currentClockSpeed to set
     */
    public void setCurrentClockSpeed(Integer currentClockSpeed) {
	this.currentClockSpeed = currentClockSpeed;
    }

    /**
     * Gets the ext clock.
     * 
     * @return the extClock
     */
    public Integer getExtClock() {
	return extClock;
    }

    /**
     * Sets the ext clock.
     * 
     * @param extClock
     *            the extClock to set
     */
    public void setExtClock(Integer extClock) {
	this.extClock = extClock;
    }

    /**
     * Gets the stepping.
     * 
     * @return the stepping
     */
    public Integer getStepping() {
	return stepping;
    }

    /**
     * Sets the stepping.
     * 
     * @param stepping
     *            the stepping to set
     */
    public void setStepping(Integer stepping) {
	this.stepping = stepping;
    }

    /**
     * Gets the capacity.
     * 
     * @return the capacity
     */
    public Long getCapacity() {
	return capacity;
    }

    /**
     * Sets the capacity.
     * 
     * @param capacity
     *            the capacity to set
     */
    public void setCapacity(Long capacity) {
	this.capacity = capacity;
    }

    /**
     * Gets the speed.
     * 
     * @return the speed
     */
    public Long getSpeed() {
	return speed;
    }

    /**
     * Sets the speed.
     * 
     * @param speed
     *            the speed to set
     */
    public void setSpeed(Long speed) {
	this.speed = speed;
    }

    /**
     * Gets the partitions.
     * 
     * @return the partitions
     */
    public Integer getPartitions() {
	return partitions;
    }

    /**
     * Sets the partitions.
     * 
     * @param partitions
     *            the partitions to set
     */
    public void setPartitions(Integer partitions) {
	this.partitions = partitions;
    }

    /**
     * Gets the size.
     * 
     * @return the size
     */
    public Long getSize() {
	return size;
    }

    /**
     * Sets the size.
     * 
     * @param size
     *            the size to set
     */
    public void setSize(Long size) {
	this.size = size;
    }

    /**
     * Gets the free space.
     * 
     * @return the freeSpace
     */
    public Long getFreeSpace() {
	return freeSpace;
    }

    /**
     * Sets the free space.
     * 
     * @param freeSpace
     *            the freeSpace to set
     */
    public void setFreeSpace(Long freeSpace) {
	this.freeSpace = freeSpace;
    }

    /**
     * Gets the file system.
     * 
     * @return the fileSystem
     */
    public String getFileSystem() {
	return fileSystem;
    }

    /**
     * Sets the file system.
     * 
     * @param fileSystem
     *            the fileSystem to set
     */
    public void setFileSystem(String fileSystem) {
	this.fileSystem = fileSystem;
    }

    /**
     * Gets the version.
     * 
     * @return the version
     */
    public String getVersion() {
	return version;
    }

    /**
     * Sets the version.
     * 
     * @param version
     *            the version to set
     */
    public void setVersion(String version) {
	this.version = version;
    }

    /**
     * Gets the name version.
     * 
     * @return the name and version concatenated
     */
    public String getNameVersion() {
	return name + " (V. " + getVersion() + ")";
    }

    /**
     * Gets the adapter type.
     * 
     * @return the adapterType
     */
    public String getAdapterType() {
	return adapterType;
    }

    /**
     * Sets the adapter type.
     * 
     * @param adapterType
     *            the adapterType to set
     */
    public void setAdapterType(String adapterType) {
	this.adapterType = adapterType;
    }

    /**
     * Gets the dhcp enabled.
     * 
     * @return the dhcpEnabled
     */
    public Boolean getDhcpEnabled() {
	return dhcpEnabled;
    }

    /**
     * Sets the dhcp enabled.
     * 
     * @param dhcpEnabled
     *            the dhcpEnabled to set
     */
    public void setDhcpEnabled(Boolean dhcpEnabled) {
	this.dhcpEnabled = dhcpEnabled;
    }

    /**
     * Gets the dhcp server.
     * 
     * @return the dhcpServer
     */
    public String getDhcpServer() {
	return dhcpServer;
    }

    /**
     * Sets the dhcp server.
     * 
     * @param dhcpServer
     *            the dhcpServer to set
     */
    public void setDhcpServer(String dhcpServer) {
	this.dhcpServer = dhcpServer;
    }

    /**
     * Gets the ip address.
     * 
     * @return the ipAddress
     */
    public String getIpAddress() {
	return ipAddress;
    }

    /**
     * Sets the ip address.
     * 
     * @param ipAddress
     *            the ipAddress to set
     */
    public void setIpAddress(String ipAddress) {
	this.ipAddress = ipAddress;
    }

    /**
     * Gets the ip subnet.
     * 
     * @return the ipSubnet
     */
    public String getIpSubnet() {
	return ipSubnet;
    }

    /**
     * Sets the ip subnet.
     * 
     * @param ipSubnet
     *            the ipSubnet to set
     */
    public void setIpSubnet(String ipSubnet) {
	this.ipSubnet = ipSubnet;
    }

    /**
     * Gets the default ip gateway.
     * 
     * @return the defaultIpGateway
     */
    public String getDefaultIpGateway() {
	return defaultIpGateway;
    }

    /**
     * Sets the default ip gateway.
     * 
     * @param defaultIpGateway
     *            the defaultIpGateway to set
     */
    public void setDefaultIpGateway(String defaultIpGateway) {
	this.defaultIpGateway = defaultIpGateway;
    }

    /**
     * Gets the mac address.
     * 
     * @return the macAddress
     */
    public String getMacAddress() {
	return macAddress;
    }

    /**
     * Sets the mac address.
     * 
     * @param macAddress
     *            the macAddress to set
     */
    public void setMacAddress(String macAddress) {
	this.macAddress = macAddress;
    }

    /**
     * Gets the net connection id.
     * 
     * @return the netConnectionId
     */
    public String getNetConnectionId() {
	return netConnectionId;
    }

    /**
     * Sets the net connection id.
     * 
     * @param netConnectionId
     *            the netConnectionId to set
     */
    public void setNetConnectionId(String netConnectionId) {
	this.netConnectionId = netConnectionId;
    }

    /**
     * Gets the net connection status.
     * 
     * @return the netConnectionStatus
     */
    public String getNetConnectionStatus() {
	return netConnectionStatus;
    }

    /**
     * Sets the net connection status.
     * 
     * @param netConnectionStatus
     *            the netConnectionStatus to set
     */
    public void setNetConnectionStatus(String netConnectionStatus) {
	this.netConnectionStatus = netConnectionStatus;
    }

    /**
     * Gets the device id.
     * 
     * @return the deviceId
     */
    public String getDeviceId() {
	return deviceId;
    }

    /**
     * Sets the device id.
     * 
     * @param deviceId
     *            the deviceId to set
     */
    public void setDeviceId(String deviceId) {
	this.deviceId = deviceId;
    }

    /**
     * Gets the max baud rate.
     * 
     * @return the maxBaudRate
     */
    public Integer getMaxBaudRate() {
	return maxBaudRate;
    }

    /**
     * Sets the max baud rate.
     * 
     * @param maxBaudRate
     *            the maxBaudRate to set
     */
    public void setMaxBaudRate(Integer maxBaudRate) {
	this.maxBaudRate = maxBaudRate;
    }

    /**
     * Gets the display type.
     * 
     * @return the displayType
     */
    public Boolean getDisplayType() {
	return displayType;
    }

    /**
     * Sets the display type.
     * 
     * @param displayType
     *            the displayType to set
     */
    public void setDisplayType(Boolean displayType) {
	this.displayType = displayType;
    }

    /**
     * Gets the monitor manufacturer.
     * 
     * @return the monitorManufacturer
     */
    public String getMonitorManufacturer() {
	return monitorManufacturer;
    }

    /**
     * Sets the monitor manufacturer.
     * 
     * @param monitorManufacturer
     *            the monitorManufacturer to set
     */
    public void setMonitorManufacturer(String monitorManufacturer) {
	this.monitorManufacturer = monitorManufacturer;
    }

    /**
     * Gets the monitor type.
     * 
     * @return the monitorType
     */
    public String getMonitorType() {
	return monitorType;
    }

    /**
     * Sets the monitor type.
     * 
     * @param monitorType
     *            the monitorType to set
     */
    public void setMonitorType(String monitorType) {
	this.monitorType = monitorType;
    }

    /**
     * Gets the pixels per x logical inch.
     * 
     * @return the pixelsPerXLogicalInch
     */
    public Integer getPixelsPerXLogicalInch() {
	return pixelsPerXLogicalInch;
    }

    /**
     * Sets the pixels per x logical inch.
     * 
     * @param pixelsPerXLogicalInch
     *            the pixelsPerXLogicalInch to set
     */
    public void setPixelsPerXLogicalInch(Integer pixelsPerXLogicalInch) {
	this.pixelsPerXLogicalInch = pixelsPerXLogicalInch;
    }

    /**
     * Gets the pixels per y logical inch.
     * 
     * @return the pixelsPerYLogicalInch
     */
    public Integer getPixelsPerYLogicalInch() {
	return pixelsPerYLogicalInch;
    }

    /**
     * Sets the pixels per y logical inch.
     * 
     * @param pixelsPerYLogicalInch
     *            the pixelsPerYLogicalInch to set
     */
    public void setPixelsPerYLogicalInch(Integer pixelsPerYLogicalInch) {
	this.pixelsPerYLogicalInch = pixelsPerYLogicalInch;
    }

    /**
     * Gets the layout.
     * 
     * @return the layout
     */
    public String getLayout() {
	return layout;
    }

    /**
     * Sets the layout.
     * 
     * @param layout
     *            the layout to set
     */
    public void setLayout(String layout) {
	this.layout = layout;
    }

    /**
     * Gets the hardware type.
     * 
     * @return the hardwareType
     */
    public String getHardwareType() {
	return hardwareType;
    }

    /**
     * Sets the hardware type.
     * 
     * @param hardwareType
     *            the hardwareType to set
     */
    public void setHardwareType(String hardwareType) {
	this.hardwareType = hardwareType;
    }

    /**
     * Gets the pointing type.
     * 
     * @return the pointingType
     */
    public Integer getPointingType() {
	return pointingType;
    }

    /**
     * Sets the pointing type.
     * 
     * @param pointingType
     *            the pointingType to set
     */
    public void setPointingType(Integer pointingType) {
	this.pointingType = pointingType;
    }

    /**
     * Gets the current usage.
     * 
     * @return the currentUsage
     */
    public Integer getCurrentUsage() {
	return currentUsage;
    }

    /**
     * Sets the current usage.
     * 
     * @param currentUsage
     *            the currentUsage to set
     */
    public void setCurrentUsage(Integer currentUsage) {
	this.currentUsage = currentUsage;
    }

    /**
     * Gets the serial number.
     * 
     * @return the serialNumber
     */
    public String getSerialNumber() {
	return serialNumber;
    }

    /**
     * Sets the serial number.
     * 
     * @param serialNumber
     *            the serialNumber to set
     */
    public void setSerialNumber(String serialNumber) {
	this.serialNumber = serialNumber;
    }

    /**
     * Gets the slot designation.
     * 
     * @return the slotDesignation
     */
    public String getSlotDesignation() {
	return slotDesignation;
    }

    /**
     * Sets the slot designation.
     * 
     * @param slotDesignation
     *            the slotDesignation to set
     */
    public void setSlotDesignation(String slotDesignation) {
	this.slotDesignation = slotDesignation;
    }

    /**
     * Gets the tag.
     * 
     * @return the tag
     */
    public String getTag() {
	return tag;
    }

    /**
     * Sets the tag.
     * 
     * @param tag
     *            the tag to set
     */
    public void setTag(String tag) {
	this.tag = tag;
    }

    /**
     * Gets the smbios version.
     * 
     * @return the smbiosVersion
     */
    public String getSmbiosVersion() {
	return smbiosVersion;
    }

    /**
     * Sets the smbios version.
     * 
     * @param smbiosVersion
     *            the smbiosVersion to set
     */
    public void setSmbiosVersion(String smbiosVersion) {
	this.smbiosVersion = smbiosVersion;
    }

    /**
     * Gets the smbios major version.
     * 
     * @return the smbiosMajorVersion
     */
    public Integer getSmbiosMajorVersion() {
	return smbiosMajorVersion;
    }

    /**
     * Sets the smbios major version.
     * 
     * @param smbiosMajorVersion
     *            the smbiosMajorVersion to set
     */
    public void setSmbiosMajorVersion(Integer smbiosMajorVersion) {
	this.smbiosMajorVersion = smbiosMajorVersion;
    }

    /**
     * Gets the smbios minor version.
     * 
     * @return the smbiosMinorVersion
     */
    public Integer getSmbiosMinorVersion() {
	return smbiosMinorVersion;
    }

    /**
     * Sets the smbios minor version.
     * 
     * @param smbiosMinorVersion
     *            the smbiosMinorVersion to set
     */
    public void setSmbiosMinorVersion(Integer smbiosMinorVersion) {
	this.smbiosMinorVersion = smbiosMinorVersion;
    }

    /**
     * Gets the current language.
     * 
     * @return the currentLanguage
     */
    public String getCurrentLanguage() {
	return currentLanguage;
    }

    /**
     * Sets the current language.
     * 
     * @param currentLanguage
     *            the currentLanguage to set
     */
    public void setCurrentLanguage(String currentLanguage) {
	this.currentLanguage = currentLanguage;
    }

    /**
     * Gets the primary bios.
     * 
     * @return the primaryBios
     */
    public Boolean getPrimaryBios() {
	return primaryBios;
    }

    /**
     * Sets the primary bios.
     * 
     * @param primaryBios
     *            the primaryBios to set
     */
    public void setPrimaryBios(Boolean primaryBios) {
	this.primaryBios = primaryBios;
    }

    /**
     * Gets the release date.
     * 
     * @return the releaseDate
     */
    public Date getReleaseDate() {
	return releaseDate;
    }

    /**
     * Sets the release date.
     * 
     * @param releaseDate
     *            the releaseDate to set
     */
    public void setReleaseDate(Date releaseDate) {
	this.releaseDate = releaseDate;
    }

    /**
     * Gets the smbios present.
     * 
     * @return the smbiosPresent
     */
    public Boolean getSmbiosPresent() {
	return smbiosPresent;
    }

    /**
     * Sets the smbios present.
     * 
     * @param smbiosPresent
     *            the smbiosPresent to set
     */
    public void setSmbiosPresent(Boolean smbiosPresent) {
	this.smbiosPresent = smbiosPresent;
    }

    /**
     * Gets the bits per pixel.
     * 
     * @return the bitsPerPixel
     */
    public Integer getBitsPerPixel() {
	return BitsPerPixel;
    }

    /**
     * Sets the bits per pixel.
     * 
     * @param bitsPerPixel
     *            the bitsPerPixel to set
     */
    public void setBitsPerPixel(Integer bitsPerPixel) {
	BitsPerPixel = bitsPerPixel;
    }

    /**
     * Gets the deviceclasses (i.e. 'desktop monitor', 'usb hub',
     * 'keyboard'...).
     * 
     * @return the deviceclasses
     */
    public static Map<DeviceClassId, String> getDeviceclasses() {
	return deviceClasses;
    }

    /**
     * Gets the current bits per pixel.
     * 
     * @return the currentBitsPerPixel
     */
    public Integer getCurrentBitsPerPixel() {
	return currentBitsPerPixel;
    }

    /**
     * Sets the current bits per pixel.
     * 
     * @param currentBitsPerPixel
     *            the currentBitsPerPixel to set
     */
    public void setCurrentBitsPerPixel(Integer currentBitsPerPixel) {
	this.currentBitsPerPixel = currentBitsPerPixel;
    }

    /**
     * Gets the current number of colors.
     * 
     * @return the currentNumberOfColors
     */
    public Long getCurrentNumberOfColors() {
	return currentNumberOfColors;
    }

    /**
     * Sets the current number of colors.
     * 
     * @param currentNumberOfColors
     *            the currentNumberOfColors to set
     */
    public void setCurrentNumberOfColors(Long currentNumberOfColors) {
	this.currentNumberOfColors = currentNumberOfColors;
    }

    /**
     * Gets the current refresh rate.
     * 
     * @return the currentRefreshRate
     */
    public Integer getCurrentRefreshRate() {
	return currentRefreshRate;
    }

    /**
     * Sets the current refresh rate.
     * 
     * @param currentRefreshRate
     *            the currentRefreshRate to set
     */
    public void setCurrentRefreshRate(Integer currentRefreshRate) {
	this.currentRefreshRate = currentRefreshRate;
    }

    /**
     * Gets the current horizontal resolution.
     * 
     * @return the currentHorizontalResolution
     */
    public Integer getCurrentHorizontalResolution() {
	return currentHorizontalResolution;
    }

    /**
     * Sets the current horizontal resolution.
     * 
     * @param currentHorizontalResolution
     *            the currentHorizontalResolution to set
     */
    public void setCurrentHorizontalResolution(
	    Integer currentHorizontalResolution) {
	this.currentHorizontalResolution = currentHorizontalResolution;
    }

    /**
     * Gets the current vertical resolution.
     * 
     * @return the currentVerticalResolution
     */
    public Integer getCurrentVerticalResolution() {
	return currentVerticalResolution;
    }

    /**
     * Sets the current vertical resolution.
     * 
     * @param currentVerticalResolution
     *            the currentVerticalResolution to set
     */
    public void setCurrentVerticalResolution(Integer currentVerticalResolution) {
	this.currentVerticalResolution = currentVerticalResolution;
    }

    /**
     * Gets the adapter ram.
     * 
     * @return the adapterRam
     */
    public Integer getAdapterRam() {
	return adapterRam;
    }

    /**
     * Sets the adapter ram.
     * 
     * @param adapterRam
     *            the adapterRam to set
     */
    public void setAdapterRam(Integer adapterRam) {
	this.adapterRam = adapterRam;
    }

    /**
     * Gets the firmware revision.
     * 
     * @return the firmwareRevision
     */
    public String getFirmwareRevision() {
	return firmwareRevision;
    }

    /**
     * Sets the firmware revision.
     * 
     * @param firmwareRevision
     *            the firmwareRevision to set
     */
    public void setFirmwareRevision(String firmwareRevision) {
	this.firmwareRevision = firmwareRevision;
    }

    /**
     * Gets the max clock speed.
     * 
     * @return the maxClockSpeed
     */
    public Integer getMaxClockSpeed() {
	return maxClockSpeed;
    }

    /**
     * Sets the max clock speed.
     * 
     * @param maxClockSpeed
     *            the maxClockSpeed to set
     */
    public void setMaxClockSpeed(Integer maxClockSpeed) {
	this.maxClockSpeed = maxClockSpeed;
    }

    /**
     * Gets the max media size.
     * 
     * @return the maxMediaSize
     */
    public Integer getMaxMediaSize() {
	return maxMediaSize;
    }

    /**
     * Sets the max media size.
     * 
     * @param maxMediaSize
     *            the maxMediaSize to set
     */
    public void setMaxMediaSize(Integer maxMediaSize) {
	this.maxMediaSize = maxMediaSize;
    }

    /**
     * Gets the media type.
     * 
     * @return the mediaType
     */
    public String getMediaType() {
	return mediaType;
    }

    /**
     * Sets the media type.
     * 
     * @param mediaType
     *            the mediaType to set
     */
    public void setMediaType(String mediaType) {
	this.mediaType = mediaType;
    }

    /**
     * Gets the hardware version.
     * 
     * @return the hardwareVersion
     */
    public String getHardwareVersion() {
	return hardwareVersion;
    }

    /**
     * Sets the hardware version.
     * 
     * @param hardwareVersion
     *            the hardwareVersion to set
     */
    public void setHardwareVersion(String hardwareVersion) {
	this.hardwareVersion = hardwareVersion;
    }

    /**
     * Gets the hardware name version.
     * 
     * @return the hardware name and version concatenated
     */
    public String getHardwareNameVersion() {
	return name + " (V. " + getHardwareVersion() + ")";
    }

    /**
     * Gets the status info.
     * 
     * @return the statusInfo
     */
    public String getStatusInfo() {
	return statusInfo;
    }

    /**
     * Sets the status info.
     * 
     * @param statusInfo
     *            the statusInfo to set
     */
    public void setStatusInfo(String statusInfo) {
	this.statusInfo = statusInfo;
    }

    /**
     * Gets the total cylinders.
     * 
     * @return the totalCylinders
     */
    public Integer getTotalCylinders() {
	return totalCylinders;
    }

    /**
     * Sets the total cylinders.
     * 
     * @param totalCylinders
     *            the totalCylinders to set
     */
    public void setTotalCylinders(Integer totalCylinders) {
	this.totalCylinders = totalCylinders;
    }

    /**
     * Gets the tracks per cylinder.
     * 
     * @return the tracksPerCylinder
     */
    public Integer getTracksPerCylinder() {
	return tracksPerCylinder;
    }

    /**
     * Sets the tracks per cylinder.
     * 
     * @param tracksPerCylinder
     *            the tracksPerCylinder to set
     */
    public void setTracksPerCylinder(Integer tracksPerCylinder) {
	this.tracksPerCylinder = tracksPerCylinder;
    }

    /**
     * Gets the sectors per track.
     * 
     * @return the sectorsPerTrack
     */
    public Integer getSectorsPerTrack() {
	return sectorsPerTrack;
    }

    /**
     * Sets the sectors per track.
     * 
     * @param sectorsPerTrack
     *            the sectorsPerTrack to set
     */
    public void setSectorsPerTrack(Integer sectorsPerTrack) {
	this.sectorsPerTrack = sectorsPerTrack;
    }

    /**
     * Gets the video processor.
     * 
     * @return the videoProcessor
     */
    public String getVideoProcessor() {
	return videoProcessor;
    }

    /**
     * Sets the video processor.
     * 
     * @param videoProcessor
     *            the videoProcessor to set
     */
    public void setVideoProcessor(String videoProcessor) {
	this.videoProcessor = videoProcessor;
    }

    /**
     * Gets the volume serial number.
     * 
     * @return the volumeSerialNumber
     */
    public String getVolumeSerialNumber() {
	return volumeSerialNumber;
    }

    /**
     * Sets the volume serial number.
     * 
     * @param volumeSerialNumber
     *            the volumeSerialNumber to set
     */
    public void setVolumeSerialNumber(String volumeSerialNumber) {
	this.volumeSerialNumber = volumeSerialNumber;
    }

    /**
     * Gets the driver name.
     * 
     * @return the driverName
     */
    public String getDriverName() {
	return driverName;
    }

    /**
     * Sets the driver name.
     * 
     * @param driverName
     *            the driverName to set
     */
    public void setDriverName(String driverName) {
	this.driverName = driverName;
    }

    /**
     * Gets the interface index.
     * 
     * @return the interfaceIndex
     */
    public Integer getInterfaceIndex() {
	return interfaceIndex;
    }

    /**
     * Sets the interface index.
     * 
     * @param interfaceIndex
     *            the interfaceIndex to set
     */
    public void setInterfaceIndex(Integer interfaceIndex) {
	this.interfaceIndex = interfaceIndex;
    }

    /**
     * Gets the protocol supported.
     * 
     * @return the protocolSupported
     */
    public Integer getProtocolSupported() {
	return protocolSupported;
    }

    /**
     * Sets the protocol supported.
     * 
     * @param protocolSupported
     *            the protocolSupported to set
     */
    public void setProtocolSupported(Integer protocolSupported) {
	this.protocolSupported = protocolSupported;
    }

    /**
     * Gets the volume name.
     * 
     * @return the volumeName
     */
    public String getVolumeName() {
	return volumeName;
    }

    /**
     * Sets the volume name.
     * 
     * @param volumeName
     *            the volumeName to set
     */
    public void setVolumeName(String volumeName) {
	this.volumeName = volumeName;
    }

    /**
     * Gets the bytes per sector.
     * 
     * @return the bytesPerSector
     */
    public Integer getBytesPerSector() {
	return bytesPerSector;
    }

    /**
     * Sets the bytes per sector.
     * 
     * @param bytesPerSector
     *            the bytesPerSector to set
     */
    public void setBytesPerSector(Integer bytesPerSector) {
	this.bytesPerSector = bytesPerSector;
    }

    /**
     * Gets the data width.
     * 
     * @return the dataWidth
     */
    public Integer getDataWidth() {
	return dataWidth;
    }

    /**
     * Sets the data width.
     * 
     * @param dataWidth
     *            the dataWidth to set
     */
    public void setDataWidth(Integer dataWidth) {
	this.dataWidth = dataWidth;
    }

    /**
     * Gets the product.
     * 
     * @return the product
     */
    public String getProduct() {
	return product;
    }

    /**
     * Sets the product.
     * 
     * @param product
     *            the product to set
     */
    public void setProduct(String product) {
	this.product = product;
    }

    /**
     * Gets the colors.
     * 
     * @return the colors
     */
    public Integer getColors() {
	return colors;
    }

    /**
     * Sets the colors.
     * 
     * @param colors
     *            the colors to set
     */
    public void setColors(Integer colors) {
	this.colors = colors;
    }

    /**
     * Gets the refresh rate.
     * 
     * @return the refreshRate
     */
    public Integer getRefreshRate() {
	return refreshRate;
    }

    /**
     * Sets the refresh rate.
     * 
     * @param refreshRate
     *            the refreshRate to set
     */
    public void setRefreshRate(Integer refreshRate) {
	this.refreshRate = refreshRate;
    }

    /**
     * Gets the horizontal res.
     * 
     * @return the horizontalRes
     */
    public Integer getHorizontalRes() {
	return horizontalRes;
    }

    /**
     * Sets the horizontal res.
     * 
     * @param horizontalRes
     *            the horizontalRes to set
     */
    public void setHorizontalRes(Integer horizontalRes) {
	this.horizontalRes = horizontalRes;
    }

    /**
     * Gets the vertical res.
     * 
     * @return the verticalRes
     */
    public Integer getVerticalRes() {
	return verticalRes;
    }

    /**
     * Sets the vertical res.
     * 
     * @param verticalRes
     *            the verticalRes to set
     */
    public void setVerticalRes(Integer verticalRes) {
	this.verticalRes = verticalRes;
    }

    /**
     * Gets the video memory.
     * 
     * @return the videoMemory
     */
    public Integer getVideoMemory() {
	return videoMemory;
    }

    /**
     * Sets the video memory.
     * 
     * @param videoMemory
     *            the videoMemory to set
     */
    public void setVideoMemory(Integer videoMemory) {
	this.videoMemory = videoMemory;
    }

    /**
     * Gets the protocol code.
     * 
     * @return the protocolCode
     */
    public String getProtocolCode() {
	return protocolCode;
    }

    /**
     * Sets the protocol code.
     * 
     * @param protocolCode
     *            the protocolCode to set
     */
    public void setProtocolCode(String protocolCode) {
	this.protocolCode = protocolCode;
    }

    /**
     * Gets the number of ports.
     * 
     * @return the numberOfPorts
     */
    public Integer getNumberOfPorts() {
	return numberOfPorts;
    }

    /**
     * Sets the number of ports.
     * 
     * @param numberOfPorts
     *            the numberOfPorts to set
     */
    public void setNumberOfPorts(Integer numberOfPorts) {
	this.numberOfPorts = numberOfPorts;
    }

    /**
     * Gets the usb version.
     * 
     * @return the usbRemainingVersion
     */
    public String getUsbVersion() {
	return usbVersion;
    }

    /**
     * Sets the usb version.
     * 
     * @param usbVersion
     *            the usbVersion to set
     */
    public void setUsbVersion(String usbVersion) {
	this.usbVersion = usbVersion;
    }

    /**
     * Gets the separator.
     * 
     * @return the separator
     */
    public static char getSeparator() {
	return separator;
    }

    /**
     * Gets the signature.
     * 
     * @return the signature
     */
    public String getSignature() {
	return signature;
    }

    /**
     * Sets the signature.
     * 
     * @param signature
     *            the signature to set
     */
    public void setSignature(String signature) {
	this.signature = signature;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((BitsPerPixel == null) ? 0 : BitsPerPixel.hashCode());
	result = prime * result
		+ ((adapterRam == null) ? 0 : adapterRam.hashCode());
	result = prime * result
		+ ((adapterType == null) ? 0 : adapterType.hashCode());
	result = prime * result
		+ ((addressWidth == null) ? 0 : addressWidth.hashCode());
	result = prime * result
		+ ((architecture == null) ? 0 : architecture.hashCode());
	result = prime * result
		+ ((bytesPerSector == null) ? 0 : bytesPerSector.hashCode());
	result = prime * result
		+ ((capacity == null) ? 0 : capacity.hashCode());
	result = prime * result + ((caption == null) ? 0 : caption.hashCode());
	result = prime * result + ((colors == null) ? 0 : colors.hashCode());
	result = prime
		* result
		+ ((currentBitsPerPixel == null) ? 0 : currentBitsPerPixel
			.hashCode());
	result = prime
		* result
		+ ((currentClockSpeed == null) ? 0 : currentClockSpeed
			.hashCode());
	result = prime
		* result
		+ ((currentHorizontalResolution == null) ? 0
			: currentHorizontalResolution.hashCode());
	result = prime * result
		+ ((currentLanguage == null) ? 0 : currentLanguage.hashCode());
	result = prime
		* result
		+ ((currentNumberOfColors == null) ? 0 : currentNumberOfColors
			.hashCode());
	result = prime
		* result
		+ ((currentRefreshRate == null) ? 0 : currentRefreshRate
			.hashCode());
	result = prime * result
		+ ((currentTimeZone == null) ? 0 : currentTimeZone.hashCode());
	result = prime * result
		+ ((currentUsage == null) ? 0 : currentUsage.hashCode());
	result = prime
		* result
		+ ((currentVerticalResolution == null) ? 0
			: currentVerticalResolution.hashCode());
	result = prime * result
		+ ((dataWidth == null) ? 0 : dataWidth.hashCode());
	result = prime
		* result
		+ ((daylightInEffect == null) ? 0 : daylightInEffect.hashCode());
	result = prime
		* result
		+ ((defaultIpGateway == null) ? 0 : defaultIpGateway.hashCode());
	result = prime * result
		+ ((description == null) ? 0 : description.hashCode());
	result = prime * result
		+ ((deviceId == null) ? 0 : deviceId.hashCode());
	result = prime * result
		+ ((dhcpEnabled == null) ? 0 : dhcpEnabled.hashCode());
	result = prime * result
		+ ((dhcpServer == null) ? 0 : dhcpServer.hashCode());
	result = prime * result
		+ ((displayType == null) ? 0 : displayType.hashCode());
	result = prime * result + ((domain == null) ? 0 : domain.hashCode());
	result = prime * result
		+ ((driverName == null) ? 0 : driverName.hashCode());
	result = prime * result
		+ ((extClock == null) ? 0 : extClock.hashCode());
	result = prime * result
		+ ((fileSystem == null) ? 0 : fileSystem.hashCode());
	result = prime
		* result
		+ ((firmwareRevision == null) ? 0 : firmwareRevision.hashCode());
	result = prime * result
		+ ((freeSpace == null) ? 0 : freeSpace.hashCode());
	result = prime * result
		+ ((hardwareClass == null) ? 0 : hardwareClass.hashCode());
	result = prime * result
		+ ((hardwareType == null) ? 0 : hardwareType.hashCode());
	result = prime * result
		+ ((hardwareVersion == null) ? 0 : hardwareVersion.hashCode());
	result = prime * result
		+ ((horizontalRes == null) ? 0 : horizontalRes.hashCode());
	result = prime * result
		+ ((interfaceIndex == null) ? 0 : interfaceIndex.hashCode());
	result = prime * result
		+ ((ipAddress == null) ? 0 : ipAddress.hashCode());
	result = prime * result
		+ ((ipSubnet == null) ? 0 : ipSubnet.hashCode());
	result = prime * result + ((layout == null) ? 0 : layout.hashCode());
	result = prime * result
		+ ((macAddress == null) ? 0 : macAddress.hashCode());
	result = prime * result
		+ ((manufacturer == null) ? 0 : manufacturer.hashCode());
	result = prime * result
		+ ((maxBaudRate == null) ? 0 : maxBaudRate.hashCode());
	result = prime * result
		+ ((maxClockSpeed == null) ? 0 : maxClockSpeed.hashCode());
	result = prime * result
		+ ((maxMediaSize == null) ? 0 : maxMediaSize.hashCode());
	result = prime * result
		+ ((mediaType == null) ? 0 : mediaType.hashCode());
	result = prime * result + ((model == null) ? 0 : model.hashCode());
	result = prime
		* result
		+ ((monitorManufacturer == null) ? 0 : monitorManufacturer
			.hashCode());
	result = prime * result
		+ ((monitorType == null) ? 0 : monitorType.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result
		+ ((netConnectionId == null) ? 0 : netConnectionId.hashCode());
	result = prime
		* result
		+ ((netConnectionStatus == null) ? 0 : netConnectionStatus
			.hashCode());
	result = prime * result
		+ ((numberOfPorts == null) ? 0 : numberOfPorts.hashCode());
	result = prime
		* result
		+ ((numberOfProcessors == null) ? 0 : numberOfProcessors
			.hashCode());
	result = prime * result
		+ ((partitions == null) ? 0 : partitions.hashCode());
	result = prime
		* result
		+ ((pixelsPerXLogicalInch == null) ? 0 : pixelsPerXLogicalInch
			.hashCode());
	result = prime
		* result
		+ ((pixelsPerYLogicalInch == null) ? 0 : pixelsPerYLogicalInch
			.hashCode());
	result = prime * result
		+ ((pointingType == null) ? 0 : pointingType.hashCode());
	result = prime * result
		+ ((primaryBios == null) ? 0 : primaryBios.hashCode());
	result = prime * result + ((product == null) ? 0 : product.hashCode());
	result = prime * result
		+ ((protocolCode == null) ? 0 : protocolCode.hashCode());
	result = prime
		* result
		+ ((protocolSupported == null) ? 0 : protocolSupported
			.hashCode());
	result = prime * result
		+ ((refreshRate == null) ? 0 : refreshRate.hashCode());
	result = prime * result
		+ ((sectorsPerTrack == null) ? 0 : sectorsPerTrack.hashCode());
	result = prime * result
		+ ((serialNumber == null) ? 0 : serialNumber.hashCode());
	result = prime * result
		+ ((signature == null) ? 0 : signature.hashCode());
	result = prime * result + ((size == null) ? 0 : size.hashCode());
	result = prime * result
		+ ((slotDesignation == null) ? 0 : slotDesignation.hashCode());
	result = prime
		* result
		+ ((smbiosMajorVersion == null) ? 0 : smbiosMajorVersion
			.hashCode());
	result = prime
		* result
		+ ((smbiosMinorVersion == null) ? 0 : smbiosMinorVersion
			.hashCode());
	result = prime * result
		+ ((smbiosPresent == null) ? 0 : smbiosPresent.hashCode());
	result = prime * result
		+ ((smbiosVersion == null) ? 0 : smbiosVersion.hashCode());
	result = prime * result + ((speed == null) ? 0 : speed.hashCode());
	result = prime * result + ((status == null) ? 0 : status.hashCode());
	result = prime * result
		+ ((statusInfo == null) ? 0 : statusInfo.hashCode());
	result = prime * result
		+ ((stepping == null) ? 0 : stepping.hashCode());
	result = prime * result + ((tag == null) ? 0 : tag.hashCode());
	result = prime * result
		+ ((terminal == null) ? 0 : terminal.hashCode());
	result = prime * result
		+ ((totalCylinders == null) ? 0 : totalCylinders.hashCode());
	result = prime
		* result
		+ ((totalPhysicalMemory == null) ? 0 : totalPhysicalMemory
			.hashCode());
	result = prime
		* result
		+ ((tracksPerCylinder == null) ? 0 : tracksPerCylinder
			.hashCode());
	result = prime * result
		+ ((usbVersion == null) ? 0 : usbVersion.hashCode());
	result = prime * result + ((version == null) ? 0 : version.hashCode());
	result = prime * result
		+ ((verticalRes == null) ? 0 : verticalRes.hashCode());
	result = prime * result
		+ ((videoMemory == null) ? 0 : videoMemory.hashCode());
	result = prime * result
		+ ((videoProcessor == null) ? 0 : videoProcessor.hashCode());
	result = prime * result
		+ ((volumeName == null) ? 0 : volumeName.hashCode());
	result = prime
		* result
		+ ((volumeSerialNumber == null) ? 0 : volumeSerialNumber
			.hashCode());
	result = prime * result
		+ ((workgroup == null) ? 0 : workgroup.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	HardwareDevice other = (HardwareDevice) obj;
	if (hardwareClass == null) {
	    if (other.hardwareClass != null)
		return false;
	} else if (!hardwareClass.equals(other.hardwareClass))
	    return false;
	if (BitsPerPixel == null) {
	    if (other.BitsPerPixel != null)
		return false;
	} else if (!BitsPerPixel.equals(other.BitsPerPixel))
	    return false;
	if (adapterRam == null) {
	    if (other.adapterRam != null)
		return false;
	} else if (!adapterRam.equals(other.adapterRam))
	    return false;
	if (adapterType == null) {
	    if (other.adapterType != null)
		return false;
	} else if (!adapterType.equals(other.adapterType))
	    return false;
	if (addressWidth == null) {
	    if (other.addressWidth != null)
		return false;
	} else if (!addressWidth.equals(other.addressWidth))
	    return false;
	if (architecture == null) {
	    if (other.architecture != null)
		return false;
	} else if (!architecture.equals(other.architecture))
	    return false;
	if (bytesPerSector == null) {
	    if (other.bytesPerSector != null)
		return false;
	} else if (!bytesPerSector.equals(other.bytesPerSector))
	    return false;
	if (capacity == null) {
	    if (other.capacity != null)
		return false;
	} else if (!capacity.equals(other.capacity))
	    return false;
	if (caption == null) {
	    if (other.caption != null)
		return false;
	} else if (!caption.equals(other.caption))
	    return false;
	if (colors == null) {
	    if (other.colors != null)
		return false;
	} else if (!colors.equals(other.colors))
	    return false;
	if (currentBitsPerPixel == null) {
	    if (other.currentBitsPerPixel != null)
		return false;
	} else if (!currentBitsPerPixel.equals(other.currentBitsPerPixel))
	    return false;
	if (currentClockSpeed == null) {
	    if (other.currentClockSpeed != null)
		return false;
	} else if (!currentClockSpeed.equals(other.currentClockSpeed))
	    return false;
	if (currentHorizontalResolution == null) {
	    if (other.currentHorizontalResolution != null)
		return false;
	} else if (!currentHorizontalResolution
		.equals(other.currentHorizontalResolution))
	    return false;
	if (currentLanguage == null) {
	    if (other.currentLanguage != null)
		return false;
	} else if (!currentLanguage.equals(other.currentLanguage))
	    return false;
	if (currentNumberOfColors == null) {
	    if (other.currentNumberOfColors != null)
		return false;
	} else if (!currentNumberOfColors.equals(other.currentNumberOfColors))
	    return false;
	if (currentRefreshRate == null) {
	    if (other.currentRefreshRate != null)
		return false;
	} else if (!currentRefreshRate.equals(other.currentRefreshRate))
	    return false;
	if (currentTimeZone == null) {
	    if (other.currentTimeZone != null)
		return false;
	} else if (!currentTimeZone.equals(other.currentTimeZone))
	    return false;
	if (currentUsage == null) {
	    if (other.currentUsage != null)
		return false;
	} else if (!currentUsage.equals(other.currentUsage))
	    return false;
	if (currentVerticalResolution == null) {
	    if (other.currentVerticalResolution != null)
		return false;
	} else if (!currentVerticalResolution
		.equals(other.currentVerticalResolution))
	    return false;
	if (dataWidth == null) {
	    if (other.dataWidth != null)
		return false;
	} else if (!dataWidth.equals(other.dataWidth))
	    return false;
	if (daylightInEffect == null) {
	    if (other.daylightInEffect != null)
		return false;
	} else if (!daylightInEffect.equals(other.daylightInEffect))
	    return false;
	if (defaultIpGateway == null) {
	    if (other.defaultIpGateway != null)
		return false;
	} else if (!defaultIpGateway.equals(other.defaultIpGateway))
	    return false;
	if (description == null) {
	    if (other.description != null)
		return false;
	} else if (!description.equals(other.description))
	    return false;
	if (deviceId == null) {
	    if (other.deviceId != null)
		return false;
	} else if (!deviceId.equals(other.deviceId))
	    return false;
	if (dhcpEnabled == null) {
	    if (other.dhcpEnabled != null)
		return false;
	} else if (!dhcpEnabled.equals(other.dhcpEnabled))
	    return false;
	if (dhcpServer == null) {
	    if (other.dhcpServer != null)
		return false;
	} else if (!dhcpServer.equals(other.dhcpServer))
	    return false;
	if (displayType == null) {
	    if (other.displayType != null)
		return false;
	} else if (!displayType.equals(other.displayType))
	    return false;
	if (domain == null) {
	    if (other.domain != null)
		return false;
	} else if (!domain.equals(other.domain))
	    return false;
	if (driverName == null) {
	    if (other.driverName != null)
		return false;
	} else if (!driverName.equals(other.driverName))
	    return false;
	if (extClock == null) {
	    if (other.extClock != null)
		return false;
	} else if (!extClock.equals(other.extClock))
	    return false;
	if (fileSystem == null) {
	    if (other.fileSystem != null)
		return false;
	} else if (!fileSystem.equals(other.fileSystem))
	    return false;
	if (firmwareRevision == null) {
	    if (other.firmwareRevision != null)
		return false;
	} else if (!firmwareRevision.equals(other.firmwareRevision))
	    return false;
	if (freeSpace == null) {
	    if (other.freeSpace != null)
		return false;
	} else if (!freeSpace.equals(other.freeSpace))
	    return false;
	if (hardwareType == null) {
	    if (other.hardwareType != null)
		return false;
	} else if (!hardwareType.equals(other.hardwareType))
	    return false;
	if (hardwareVersion == null) {
	    if (other.hardwareVersion != null)
		return false;
	} else if (!hardwareVersion.equals(other.hardwareVersion))
	    return false;
	if (horizontalRes == null) {
	    if (other.horizontalRes != null)
		return false;
	} else if (!horizontalRes.equals(other.horizontalRes))
	    return false;
	if (interfaceIndex == null) {
	    if (other.interfaceIndex != null)
		return false;
	} else if (!interfaceIndex.equals(other.interfaceIndex))
	    return false;
	if (ipAddress == null) {
	    if (other.ipAddress != null)
		return false;
	} else if (!ipAddress.equals(other.ipAddress))
	    return false;
	if (ipSubnet == null) {
	    if (other.ipSubnet != null)
		return false;
	} else if (!ipSubnet.equals(other.ipSubnet))
	    return false;
	if (layout == null) {
	    if (other.layout != null)
		return false;
	} else if (!layout.equals(other.layout))
	    return false;
	if (macAddress == null) {
	    if (other.macAddress != null)
		return false;
	} else if (!macAddress.equals(other.macAddress))
	    return false;
	if (manufacturer == null) {
	    if (other.manufacturer != null)
		return false;
	} else if (!manufacturer.equals(other.manufacturer))
	    return false;
	if (maxBaudRate == null) {
	    if (other.maxBaudRate != null)
		return false;
	} else if (!maxBaudRate.equals(other.maxBaudRate))
	    return false;
	if (maxClockSpeed == null) {
	    if (other.maxClockSpeed != null)
		return false;
	} else if (!maxClockSpeed.equals(other.maxClockSpeed))
	    return false;
	if (maxMediaSize == null) {
	    if (other.maxMediaSize != null)
		return false;
	} else if (!maxMediaSize.equals(other.maxMediaSize))
	    return false;
	if (mediaType == null) {
	    if (other.mediaType != null)
		return false;
	} else if (!mediaType.equals(other.mediaType))
	    return false;
	if (model == null) {
	    if (other.model != null)
		return false;
	} else if (!model.equals(other.model))
	    return false;
	if (monitorManufacturer == null) {
	    if (other.monitorManufacturer != null)
		return false;
	} else if (!monitorManufacturer.equals(other.monitorManufacturer))
	    return false;
	if (monitorType == null) {
	    if (other.monitorType != null)
		return false;
	} else if (!monitorType.equals(other.monitorType))
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	if (netConnectionId == null) {
	    if (other.netConnectionId != null)
		return false;
	} else if (!netConnectionId.equals(other.netConnectionId))
	    return false;
	if (netConnectionStatus == null) {
	    if (other.netConnectionStatus != null)
		return false;
	} else if (!netConnectionStatus.equals(other.netConnectionStatus))
	    return false;
	if (numberOfPorts == null) {
	    if (other.numberOfPorts != null)
		return false;
	} else if (!numberOfPorts.equals(other.numberOfPorts))
	    return false;
	if (numberOfProcessors == null) {
	    if (other.numberOfProcessors != null)
		return false;
	} else if (!numberOfProcessors.equals(other.numberOfProcessors))
	    return false;
	if (partitions == null) {
	    if (other.partitions != null)
		return false;
	} else if (!partitions.equals(other.partitions))
	    return false;
	if (pixelsPerXLogicalInch == null) {
	    if (other.pixelsPerXLogicalInch != null)
		return false;
	} else if (!pixelsPerXLogicalInch.equals(other.pixelsPerXLogicalInch))
	    return false;
	if (pixelsPerYLogicalInch == null) {
	    if (other.pixelsPerYLogicalInch != null)
		return false;
	} else if (!pixelsPerYLogicalInch.equals(other.pixelsPerYLogicalInch))
	    return false;
	if (pointingType == null) {
	    if (other.pointingType != null)
		return false;
	} else if (!pointingType.equals(other.pointingType))
	    return false;
	if (primaryBios == null) {
	    if (other.primaryBios != null)
		return false;
	} else if (!primaryBios.equals(other.primaryBios))
	    return false;
	if (product == null) {
	    if (other.product != null)
		return false;
	} else if (!product.equals(other.product))
	    return false;
	if (protocolCode == null) {
	    if (other.protocolCode != null)
		return false;
	} else if (!protocolCode.equals(other.protocolCode))
	    return false;
	if (protocolSupported == null) {
	    if (other.protocolSupported != null)
		return false;
	} else if (!protocolSupported.equals(other.protocolSupported))
	    return false;
	if (refreshRate == null) {
	    if (other.refreshRate != null)
		return false;
	} else if (!refreshRate.equals(other.refreshRate))
	    return false;
	if (releaseDate == null) {
	    if (other.releaseDate != null)
		return false;
	} else if (!(releaseDate.getTime() == other.releaseDate.getTime()))
	    return false;
	if (sectorsPerTrack == null) {
	    if (other.sectorsPerTrack != null)
		return false;
	} else if (!sectorsPerTrack.equals(other.sectorsPerTrack))
	    return false;
	if (serialNumber == null) {
	    if (other.serialNumber != null)
		return false;
	} else if (!serialNumber.equals(other.serialNumber))
	    return false;
	if (signature == null) {
	    if (other.signature != null)
		return false;
	} else if (!signature.equals(other.signature))
	    return false;
	if (size == null) {
	    if (other.size != null)
		return false;
	} else if (!size.equals(other.size))
	    return false;
	if (slotDesignation == null) {
	    if (other.slotDesignation != null)
		return false;
	} else if (!slotDesignation.equals(other.slotDesignation))
	    return false;
	if (smbiosMajorVersion == null) {
	    if (other.smbiosMajorVersion != null)
		return false;
	} else if (!smbiosMajorVersion.equals(other.smbiosMajorVersion))
	    return false;
	if (smbiosMinorVersion == null) {
	    if (other.smbiosMinorVersion != null)
		return false;
	} else if (!smbiosMinorVersion.equals(other.smbiosMinorVersion))
	    return false;
	if (smbiosPresent == null) {
	    if (other.smbiosPresent != null)
		return false;
	} else if (!smbiosPresent.equals(other.smbiosPresent))
	    return false;
	if (smbiosVersion == null) {
	    if (other.smbiosVersion != null)
		return false;
	} else if (!smbiosVersion.equals(other.smbiosVersion))
	    return false;
	if (speed == null) {
	    if (other.speed != null)
		return false;
	} else if (!speed.equals(other.speed))
	    return false;
	if (status == null) {
	    if (other.status != null)
		return false;
	} else if (!status.equals(other.status))
	    return false;
	if (statusInfo == null) {
	    if (other.statusInfo != null)
		return false;
	} else if (!statusInfo.equals(other.statusInfo))
	    return false;
	if (stepping == null) {
	    if (other.stepping != null)
		return false;
	} else if (!stepping.equals(other.stepping))
	    return false;
	if (tag == null) {
	    if (other.tag != null)
		return false;
	} else if (!tag.equals(other.tag))
	    return false;
	if (terminal == null) {
	    if (other.terminal != null)
		return false;
	} else if (!terminal.equals(other.terminal))
	    return false;
	if (totalCylinders == null) {
	    if (other.totalCylinders != null)
		return false;
	} else if (!totalCylinders.equals(other.totalCylinders))
	    return false;
	if (totalPhysicalMemory == null) {
	    if (other.totalPhysicalMemory != null)
		return false;
	} else if (!totalPhysicalMemory.equals(other.totalPhysicalMemory))
	    return false;
	if (tracksPerCylinder == null) {
	    if (other.tracksPerCylinder != null)
		return false;
	} else if (!tracksPerCylinder.equals(other.tracksPerCylinder))
	    return false;
	if (usbVersion == null) {
	    if (other.usbVersion != null)
		return false;
	} else if (!usbVersion.equals(other.usbVersion))
	    return false;
	if (version == null) {
	    if (other.version != null)
		return false;
	} else if (!version.equals(other.version))
	    return false;
	if (verticalRes == null) {
	    if (other.verticalRes != null)
		return false;
	} else if (!verticalRes.equals(other.verticalRes))
	    return false;
	if (videoMemory == null) {
	    if (other.videoMemory != null)
		return false;
	} else if (!videoMemory.equals(other.videoMemory))
	    return false;
	if (videoProcessor == null) {
	    if (other.videoProcessor != null)
		return false;
	} else if (!videoProcessor.equals(other.videoProcessor))
	    return false;
	if (volumeName == null) {
	    if (other.volumeName != null)
		return false;
	} else if (!volumeName.equals(other.volumeName))
	    return false;
	if (volumeSerialNumber == null) {
	    if (other.volumeSerialNumber != null)
		return false;
	} else if (!volumeSerialNumber.equals(other.volumeSerialNumber))
	    return false;
	if (workgroup == null) {
	    if (other.workgroup != null)
		return false;
	} else if (!workgroup.equals(other.workgroup))
	    return false;
	return true;
    }
}