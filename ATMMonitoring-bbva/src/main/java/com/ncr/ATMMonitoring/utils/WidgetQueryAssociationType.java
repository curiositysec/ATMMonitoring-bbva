package com.ncr.ATMMonitoring.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.hibernate.type.Type;

import com.ncr.ATMMonitoring.pojo.FinancialDevice;
import com.ncr.ATMMonitoring.pojo.HardwareDevice;
import com.ncr.ATMMonitoring.pojo.HardwareDevice.DeviceClassId;
import com.ncr.ATMMonitoring.pojo.Hotfix;
import com.ncr.ATMMonitoring.pojo.Installation;
import com.ncr.ATMMonitoring.pojo.InternetExplorer;
import com.ncr.ATMMonitoring.pojo.JxfsComponent;
import com.ncr.ATMMonitoring.pojo.OperatingSystem;
import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.Software;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.ATMMonitoring.pojo.XfsComponent;

/**
 * The types of associations for group by field widget quieries
 * 
 * 
 * @author jmartin
 * 
 */
public enum WidgetQueryAssociationType {

    TERMINAL(null, "terminal", Terminal.getComboboxes()), INSTALLATION(
	    "installations", "installation", Installation.getComboboxes()), GEO_INFO(
	    "installations", "installation", buildInstallationPlacesCombobox()), FINANCIAL_DEVICES(
	    "financialDevices", "financialDevice", FinancialDevice
		    .getComboboxes()), XFS_COMPONENT(
	    "financialDevices.xfsComponents", "xfsComponent", XfsComponent
		    .getComboboxes()), JXFS_COMPONENT(
	    "financialDevices.jxfsComponents", "jxfsComponent", JxfsComponent
		    .getComboboxes()), HOTFIX("hotfixes", "hotfix", Hotfix
	    .getComboboxes()), INTERNET_EXPLORER(
	    "auditableInternetExplorers.internetExplorer", "internetExplorer",
	    InternetExplorer.getComboboxes()), OPERATING_SYSTEM(
	    "configs.operatingSystems", "operatingSystem", OperatingSystem
		    .getComboboxes()), SOFTWARE("configs.software", "software",
	    Software.getComboboxes()), HARDWARE_COMPUTER_SYSTEM(
	    DeviceClassId.COMPUTER_SYSTEM), HARDWARE_PROCESSOR(
	    DeviceClassId.PROCESSOR), HARDWARE_PHYSICAL_MEMORY(
	    DeviceClassId.PHYSICAL_MEMORY), HARDWARE_DISK_DRIVE(
	    DeviceClassId.DISK_DRIVE), HARDWARE_LOGICAL_DISK(
	    DeviceClassId.LOGICAL_DISK), HARDWARE_BASE_BOARD(
	    DeviceClassId.BASE_BOARD), HARDWARE_NETWORK_ADAPTER(
	    DeviceClassId.NETWORK_ADAPTER), HARDWARE_FLOPPY_DRIVE(
	    DeviceClassId.FLOPPY_DRIVE), HARDWARE_CDROM_DRIVE(
	    DeviceClassId.CDROM_DRIVE), HARDWARE_SOUND_DEVICE(
	    DeviceClassId.SOUND_DEVICE), HARDWARE_DISPLAY_CONFIGURATION(
	    DeviceClassId.DISPLAY_CONFIGURATION), HARDWARE_USB_CONTROLLER(
	    DeviceClassId.USB_CONTROLLER), HARDWARE_USB_HUB(
	    DeviceClassId.USB_HUB), HARDWARE_SERIAL_PORT(
	    DeviceClassId.SERIAL_PORT), HARDWARE_PARALLEL_PORT(
	    DeviceClassId.PARALLEL_PORT), HARDWARE_1394_CONTROLLER(
	    DeviceClassId._1394_CONTROLLER), HARDWARE_SCSI_CONTROLLER(
	    DeviceClassId.SCSI_CONTROLLER), HARDWARE_DESKTOP_MONITOR(
	    DeviceClassId.DESKTOP_MONITOR), HARDWARE_KEYBOARD(
	    DeviceClassId.KEYBOARD), HARDWARE_POINTING_DEVICE(
	    DeviceClassId.POINTING_DEVICE), HARDWARE_SYSTEM_SLOT(
	    DeviceClassId.SYSTEM_SLOT), HARDWARE_BIOS(DeviceClassId.BIOS), HARDWARE_VIDEO_CONTROLLER(
	    DeviceClassId.VIDEO_CONTROLLER);

    /** The association name */
    private String associationName;

    /** The combobox name */
    private String comboboxName;

    /** Comboboxes */
    private Map<String, ?> comboboxes;

    /** Association names */
    private String[] associationNames;

    /** The las association name */
    private String lastAssociationName;

    /** The hardware class */
    private String hardwareClass;

    /**
     * Constructor
     * 
     * @param associationName
     *            The association name
     * @param comboboxName
     *            The combobox name
     * @param comboboxes
     *            The comboboxes
     * @param hardwareClass
     *            The hardware class
     */
    private WidgetQueryAssociationType(String associationName,
	    String comboboxName, Map<String, ?> comboboxes, String hardwareClass) {
	this.hardwareClass = hardwareClass;
	this.comboboxes = comboboxes;
	this.associationName = associationName;
	this.comboboxName = comboboxName;
	if (associationName != null) {
	    associationNames = associationName.split("\\.");
	    lastAssociationName = associationNames[associationNames.length - 1];
	}
    }

    /**
     * Buils an installation place combobox
     * 
     * @return The installatin place combobox
     */
    private static Map<String, ?> buildInstallationPlacesCombobox() {
	Map<String, ?> comboboxes = new HashMap<String, Object>();
	String[] fields = { "location.addressCityAndCountry",
		"location.addressCountry" };
	for (String field : fields) {
	    comboboxes.put(field, null);
	}
	return comboboxes;
    }

    /**
     * Constructor
     * 
     * @param associationName
     *            The association name
     * @param comboboxName
     *            The combobox name
     * @param comboboxes
     *            The comboboxes
     */
    private WidgetQueryAssociationType(String associationName,
	    String comboboxName, Map<String, ?> comboboxes) {
	this(associationName, comboboxName, comboboxes, null);
    }

    /**
     * Constructor
     * 
     * @param hardwareDeviceClassId
     *            The hardware device class id
     */
    private WidgetQueryAssociationType(DeviceClassId hardwareDeviceClassId) {
	this("hardwareDevices", "hardwareDevice", HardwareDevice
		.getComboboxesByDeviceClassId(hardwareDeviceClassId),
		HardwareDevice.getDeviceClasses().get(hardwareDeviceClassId));
    }

    /**
     * Find widget query association type by combobox name
     * 
     * @param comboboxName
     *            The combobox name
     * @return The widget query association type
     */
    public static WidgetQueryAssociationType findByComboboxName(
	    String comboboxName) {
	for (WidgetQueryAssociationType associationType : values()) {
	    if (associationType.comboboxName == comboboxName) {
		return associationType;
	    }
	}
	return null;
    }

    /**
     * Find widget query association type by association name
     * 
     * @param comboboxName
     *            The association name
     * @return The widget query association type
     */
    public static WidgetQueryAssociationType findByAssociationName(
	    String associationName) {
	for (WidgetQueryAssociationType associationType : values()) {
	    if (associationType.associationName == associationName) {
		return associationType;
	    }
	}
	return null;
    }

    /**
     * Build gruoup nmae
     * 
     * @param defaultAssociationName
     *            The defaultAssociationName
     * @param groupByField
     *            The group by field
     * @return The groupName
     */
    public String buildGroupName(String defaultAssociationName,
	    String groupByField) {
	String association = (associationName != null) ? lastAssociationName
		: defaultAssociationName;
	return association + "." + groupByField;
    }

    /**
     * Build the join hql
     * 
     * @param rootTableAlias
     *            Root table alias
     * @return The join hql
     */
    public String buildJoin(String rootTableAlias) {
	String join = "";
	if (associationName != null) {
	    String sourceAssociation = rootTableAlias;

	    for (String associationName : associationNames) {
		join += " join " + sourceAssociation + "." + associationName
			+ " " + associationName;
		sourceAssociation = associationName;
	    }
	}
	return join;
    }

    /**
     * Build where hlq
     * 
     * @param queryDate
     *            The query date
     * @param query
     *            The query
     * @param values
     *            The values
     * @param types
     *            The types
     * @param locale
     *            The locale
     * @return The string with the where hql
     */
    public String buildWhere(Date queryDate, Query query, List<Object> values,
	    List<Type> types, Locale locale) {
	String where = " ";
	if (associationName != null) {
	    String associationNameForApplyWhere = associationNames[0];
	    if (queryDate == null) {
		where = " and " + associationNameForApplyWhere
			+ ".endDate = null ";
	    } else {
		where = " and "
			+ query.buildIsAuditableElementActiveByDateWhere(
				associationNameForApplyWhere + ".", values,
				types, locale, queryDate);
	    }

	    if (this.hardwareClass != null) {
		where += " and " + associationNameForApplyWhere
			+ ".hardwareClass = " + "'" + this.hardwareClass + "' ";
	    }
	}

	return where + " ";
    }

    /**
     * Get the comboboxes
     * 
     * @return The comboboxes
     */
    public Map<String, ?> getComboboxes() {
	return comboboxes;
    }

    /**
     * Build the I18n message code
     * 
     * @param fieldsSepparatedByPoints
     *            The fields sepparated by points
     * @return The i18n message code
     */
    public String buildI18nMessage(String fieldsSepparatedByPoints) {
	String i18nMessage = "label.";

	String[] fields = fieldsSepparatedByPoints.split("\\.");
	if (fields.length > 1) {
	    return i18nMessage + fieldsSepparatedByPoints;
	} else {
	    return i18nMessage + this.comboboxName + "."
		    + fieldsSepparatedByPoints;
	}
    }
}
