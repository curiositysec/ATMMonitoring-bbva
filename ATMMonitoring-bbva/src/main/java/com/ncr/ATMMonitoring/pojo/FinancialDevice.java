package com.ncr.ATMMonitoring.pojo;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;

import com.ncr.ATMMonitoring.utils.Operation;
import com.ncr.ATMMonitoring.utils.Utils;
import com.ncr.agent.baseData.vendor.utils.FinancialDevicePojo;

/**
 * The FinancialDevice Pojo.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "financial_devices")
public class FinancialDevice extends Auditable {

    /** The comboboxes data related to this entity for the query designer. */
    private static final Map<String, Map> comboboxes;

    static {
	comboboxes = new TreeMap<String, Map>();
	Map<String, Map> stringOperations = Operation
		.getOperationsByType(Operation.DataType.STRING);
	Map<String, Map> boolOperations = Operation
		.getOperationsByType(Operation.DataType.BOOLEAN);
	comboboxes.put("caption", stringOperations);
	comboboxes.put("description", stringOperations);
	comboboxes.put("deviceInstance", stringOperations);
	comboboxes.put("deviceStatus", stringOperations);
	comboboxes.put("firmwareVersion", stringOperations);
	comboboxes.put("hotSwappable", boolOperations);
	comboboxes.put("manufacturer", stringOperations);
	comboboxes.put("model", stringOperations);
	comboboxes.put("name", stringOperations);
	comboboxes.put("pmStatus", stringOperations);
	comboboxes.put("replaceable", boolOperations);
	comboboxes.put("removable", boolOperations);
	comboboxes.put("serialNumber", stringOperations);
	comboboxes.put("universalId", stringOperations);
	comboboxes.put("variant", stringOperations);
	comboboxes.put("version", stringOperations);
    }

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "financial_devices_id_seq")
    @SequenceGenerator(name = "financial_devices_id_seq", sequenceName = "financial_devices_id_seq", allocationSize = 1)
    private Integer id;

    /** The terminal. */
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.REFRESH)
    @JoinColumn(name = "terminal_id")
    private Terminal terminal;

    /** The xfs components. */
    @ManyToMany(fetch = FetchType.LAZY)
    @OrderBy("xfs_class asc")
    @Cascade(CascadeType.ALL)
    @JoinTable(name = "financial_device_xfs_component", joinColumns = { @JoinColumn(name = "financial_device_id") }, inverseJoinColumns = { @JoinColumn(name = "xfs_component_id") })
    private Set<XfsComponent> xfsComponents = new HashSet<XfsComponent>();

    /** The jxfs components. */
    @ManyToMany(fetch = FetchType.LAZY)
    @OrderBy("jxfs_class asc")
    @Cascade(CascadeType.ALL)
    @JoinTable(name = "financial_device_jxfs_component", joinColumns = { @JoinColumn(name = "financial_device_id") }, inverseJoinColumns = { @JoinColumn(name = "jxfs_component_id") })
    private Set<JxfsComponent> jxfsComponents = new HashSet<JxfsComponent>();

    /** The device instance. */
    @Column(name = "device_instance")
    @Type(type = "text")
    private String deviceInstance;

    /** The device status. */
    @Column(name = "device_status")
    @Type(type = "text")
    private String deviceStatus;

    /** The hot swappable. */
    @Column(name = "hot_swappable")
    private Boolean hotSwappable;

    /** The removable. */
    @Column(name = "removable")
    private Boolean removable;

    /** The replaceable. */
    @Column(name = "replaceable")
    private Boolean replaceable;

    /** The pm status. */
    @Column(name = "pm_status")
    @Type(type = "text")
    private String pmStatus;

    /** The universal id. */
    @Column(name = "universal_id")
    @Type(type = "text")
    private String universalId;

    /** The model. */
    @Column(name = "model")
    @Type(type = "text")
    private String model;

    /** The variant. */
    @Column(name = "variant")
    @Type(type = "text")
    private String variant;

    /** The serial number. */
    @Column(name = "serial_number")
    @Type(type = "text")
    private String serialNumber;

    /** The name. */
    @Column(name = "name")
    @Type(type = "text")
    private String name;

    /** The caption. */
    @Column(name = "caption")
    @Type(type = "text")
    private String caption;

    /** The description. */
    @Column(name = "description")
    @Type(type = "text")
    private String description;

    /** The manufacturer. */
    @Column(name = "manufacturer")
    @Type(type = "text")
    private String manufacturer;

    /** The firmware version. */
    @Column(name = "firmware_version")
    @Type(type = "text")
    private String firmwareVersion;

    /** The version. */
    @Column(name = "version")
    @Type(type = "text")
    private String version;

    /**
     * Instantiates a new financial device.
     */
    public FinancialDevice() {
    }

    /**
     * Instantiates a new financial device with the given financial device data
     * from the agent.
     * 
     * @param device
     *            the device
     */
    public FinancialDevice(FinancialDevicePojo device) {
	this.setFirmwareVersion(Utils.unescapeJsonChain(device
		.getFirmwareversion()));
	this.setVersion(Utils.unescapeJsonChain(device.getVersion()));
	this.caption = device.getCaption();
	this.description = device.getDescription();
	this.deviceInstance = device.getDeviceinstance();
	this.deviceStatus = device.getDevicestatus();
	this.hotSwappable = Boolean.parseBoolean(device.getHotswappable());
	this.model = device.getModel();
	this.name = device.getName();
	this.pmStatus = device.getPmstatus();
	this.removable = Boolean.parseBoolean(device.getRemovable());
	this.replaceable = Boolean.parseBoolean(device.getReplaceable());
	// if ((device.getSerialnumber() != null)
	// && (device.getSerialnumber().length() > 0)
	// && (!device.getSerialnumber().equals("null"))) {
	this.serialNumber = Utils.unescapeJsonChain(device.getSerialnumber());
	// }
	this.universalId = Utils.unescapeJsonChain(device.getUniversalid());
	this.variant = device.getVariant();
    }

    /**
     * Instantiates a new agent financial device data with the current
     * attributes.
     * 
     * @return the agent financial device data
     */
    public FinancialDevicePojo getInventoryPojo() {
	FinancialDevicePojo pojo = new FinancialDevicePojo();
	pojo.setFirmwareversion(getFirmwareVersion());
	pojo.setVersion(getVersion());
	pojo.setCaption(caption);
	pojo.setDescription(description);
	pojo.setDeviceinstance(deviceInstance);
	pojo.setDevicestatus(deviceStatus);
	if (hotSwappable != null) {
	    pojo.setHotswappable(Boolean.valueOf(hotSwappable).toString());
	}
	pojo.setModel(model);
	pojo.setName(name);
	pojo.setPmstatus(pmStatus);
	if (removable != null) {
	    pojo.setRemovable(Boolean.valueOf(removable).toString());
	}
	if (replaceable != null) {
	    pojo.setReplaceable(Boolean.valueOf(replaceable).toString());
	}
	pojo.setSerialnumber(serialNumber);
	pojo.setUniversalid(universalId);
	pojo.setVariant(variant);
	return pojo;
    }

    /**
     * Gets the comboboxes data for the query GUI.
     * 
     * @return the comboboxes data
     */
    public static Map<String, Map> getComboboxes() {
	return comboboxes;
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
     * Gets the variant.
     * 
     * @return the variant
     */
    public String getVariant() {
	return variant;
    }

    /**
     * Sets the variant.
     * 
     * @param variant
     *            the variant to set
     */
    public void setVariant(String variant) {
	this.variant = variant;
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
     * Gets the xfs components.
     * 
     * @return the xfsComponents
     */
    public Set<XfsComponent> getXfsComponents() {
	return xfsComponents;
    }

    /**
     * Sets the xfs components.
     * 
     * @param xfsComponents
     *            the xfsComponents to set
     */
    public void setXfsComponents(Set<XfsComponent> xfsComponents) {
	this.xfsComponents = xfsComponents;
    }

    /**
     * Gets the firmware version.
     * 
     * @return the firmwareVersion
     */
    public String getFirmwareVersion() {
	return firmwareVersion;
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
     * Sets the firmware version.
     * 
     * @param firmwareVersion
     *            the firmwareVersion to set
     */
    public void setFirmwareVersion(String firmwareVersion) {
	this.firmwareVersion = firmwareVersion;
    }

    /**
     * Gets a string with the firmware name and version.
     * 
     * @return the firmware name and version concatenated
     */
    public String getFirmwareNameVersion() {
	return name + " (V. " + getFirmwareVersion() + ")";
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
     * Gets the device instance.
     * 
     * @return the deviceInstance
     */
    public String getDeviceInstance() {
	return deviceInstance;
    }

    /**
     * Sets the device instance.
     * 
     * @param deviceInstance
     *            the deviceInstance to set
     */
    public void setDeviceInstance(String deviceInstance) {
	this.deviceInstance = deviceInstance;
    }

    /**
     * Gets the device status.
     * 
     * @return the deviceStatus
     */
    public String getDeviceStatus() {
	return deviceStatus;
    }

    /**
     * Sets the device status.
     * 
     * @param deviceStatus
     *            the deviceStatus to set
     */
    public void setDeviceStatus(String deviceStatus) {
	this.deviceStatus = deviceStatus;
    }

    /**
     * Gets the hot swappable.
     * 
     * @return the hotSwappable
     */
    public Boolean getHotSwappable() {
	return hotSwappable;
    }

    /**
     * Sets the hot swappable.
     * 
     * @param hotSwappable
     *            the hotSwappable to set
     */
    public void setHotSwappable(Boolean hotSwappable) {
	this.hotSwappable = hotSwappable;
    }

    /**
     * Gets the removable.
     * 
     * @return the removable
     */
    public Boolean getRemovable() {
	return removable;
    }

    /**
     * Sets the removable.
     * 
     * @param removable
     *            the removable to set
     */
    public void setRemovable(Boolean removable) {
	this.removable = removable;
    }

    /**
     * Gets the replaceable.
     * 
     * @return the replaceable
     */
    public Boolean getReplaceable() {
	return replaceable;
    }

    /**
     * Sets the replaceable.
     * 
     * @param replaceable
     *            the replaceable to set
     */
    public void setReplaceable(Boolean replaceable) {
	this.replaceable = replaceable;
    }

    /**
     * Gets the pm status.
     * 
     * @return the pmStatus
     */
    public String getPmStatus() {
	return pmStatus;
    }

    /**
     * Sets the pm status.
     * 
     * @param pmStatus
     *            the pmStatus to set
     */
    public void setPmStatus(String pmStatus) {
	this.pmStatus = pmStatus;
    }

    /**
     * Gets the universal id.
     * 
     * @return the universalId
     */
    public String getUniversalId() {
	return universalId;
    }

    /**
     * Sets the universal id.
     * 
     * @param universalId
     *            the universalId to set
     */
    public void setUniversalId(String universalId) {
	this.universalId = universalId;
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
     * Gets the jxfs components.
     * 
     * @return the jxfs components
     */
    public Set<JxfsComponent> getJxfsComponents() {
	return jxfsComponents;
    }

    /**
     * Sets the jxfs components.
     * 
     * @param jxfsComponents
     *            the new jxfs components
     */
    public void setJxfsComponents(Set<JxfsComponent> jxfsComponents) {
	this.jxfsComponents = jxfsComponents;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((caption == null) ? 0 : caption.hashCode());
	result = prime * result
		+ ((description == null) ? 0 : description.hashCode());
	result = prime * result
		+ ((deviceInstance == null) ? 0 : deviceInstance.hashCode());
	result = prime * result
		+ ((deviceStatus == null) ? 0 : deviceStatus.hashCode());
	result = prime * result
		+ ((firmwareVersion == null) ? 0 : firmwareVersion.hashCode());
	result = prime * result
		+ ((hotSwappable == null) ? 0 : hotSwappable.hashCode());
	result = prime * result
		+ ((manufacturer == null) ? 0 : manufacturer.hashCode());
	result = prime * result + ((model == null) ? 0 : model.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result
		+ ((pmStatus == null) ? 0 : pmStatus.hashCode());
	result = prime * result
		+ ((removable == null) ? 0 : removable.hashCode());
	result = prime * result
		+ ((replaceable == null) ? 0 : replaceable.hashCode());
	result = prime * result
		+ ((serialNumber == null) ? 0 : serialNumber.hashCode());
	result = prime * result
		+ ((universalId == null) ? 0 : universalId.hashCode());
	result = prime * result + ((variant == null) ? 0 : variant.hashCode());
	result = prime * result + ((version == null) ? 0 : version.hashCode());
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
	FinancialDevice other = (FinancialDevice) obj;
	if (caption == null) {
	    if (other.caption != null)
		return false;
	} else if (!caption.equals(other.caption))
	    return false;
	if (description == null) {
	    if (other.description != null)
		return false;
	} else if (!description.equals(other.description))
	    return false;
	if (deviceInstance == null) {
	    if (other.deviceInstance != null)
		return false;
	} else if (!deviceInstance.equals(other.deviceInstance))
	    return false;
	if (deviceStatus == null) {
	    if (other.deviceStatus != null)
		return false;
	} else if (!deviceStatus.equals(other.deviceStatus))
	    return false;
	if (firmwareVersion == null) {
	    if (other.firmwareVersion != null)
		return false;
	} else if (!firmwareVersion.equals(other.firmwareVersion))
	    return false;
	if (hotSwappable == null) {
	    if (other.hotSwappable != null)
		return false;
	} else if (!hotSwappable.equals(other.hotSwappable))
	    return false;
	if (jxfsComponents == null) {
	    if (other.jxfsComponents != null)
		return false;
	} else if (!jxfsComponents.equals(other.jxfsComponents))
	    return false;
	if (manufacturer == null) {
	    if (other.manufacturer != null)
		return false;
	} else if (!manufacturer.equals(other.manufacturer))
	    return false;
	if (model == null) {
	    if (other.model != null)
		return false;
	} else if (!model.equals(other.model))
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	if (pmStatus == null) {
	    if (other.pmStatus != null)
		return false;
	} else if (!pmStatus.equals(other.pmStatus))
	    return false;
	if (removable == null) {
	    if (other.removable != null)
		return false;
	} else if (!removable.equals(other.removable))
	    return false;
	if (replaceable == null) {
	    if (other.replaceable != null)
		return false;
	} else if (!replaceable.equals(other.replaceable))
	    return false;
	if (serialNumber == null) {
	    if (other.serialNumber != null)
		return false;
	} else if (!serialNumber.equals(other.serialNumber))
	    return false;
	if (universalId == null) {
	    if (other.universalId != null)
		return false;
	} else if (!universalId.equals(other.universalId))
	    return false;
	if (variant == null) {
	    if (other.variant != null)
		return false;
	} else if (!variant.equals(other.variant))
	    return false;
	if (version == null) {
	    if (other.version != null)
		return false;
	} else if (!version.equals(other.version))
	    return false;
	if (xfsComponents == null) {
	    if (other.xfsComponents != null)
		return false;
	} else if (!xfsComponents.equals(other.xfsComponents)) {
	    return false;
	}
	return true;
    }
}