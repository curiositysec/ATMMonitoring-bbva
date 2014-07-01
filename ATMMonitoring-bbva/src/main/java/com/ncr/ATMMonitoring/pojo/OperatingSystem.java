package com.ncr.ATMMonitoring.pojo;

import java.util.Map;
import java.util.TreeMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.ncr.ATMMonitoring.utils.Operation;
import com.ncr.agent.baseData.os.module.OperatingSystemPojo;

/**
 * The OperatingSystem Pojo.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "operating_systems")
public class OperatingSystem {

    /** The comboboxes data related to this entity for the query designer. */
    private static final Map<String, Map> comboboxes;

    static {
	comboboxes = new TreeMap<String, Map>();
	Map<String, Map> stringOperations = Operation
		.getOperationsByType(Operation.DataType.STRING);
	comboboxes.put("osType", stringOperations);
	comboboxes.put("name", stringOperations);
	comboboxes.put("majorVersion",
		Operation.getOperationsByType(Operation.DataType.VERSION));
	comboboxes.put("serialNumber", stringOperations);
	comboboxes.put("servicePackMajorVersion",
		Operation.getOperationsByType(Operation.DataType.VERSION));
	comboboxes.put("osLanguage", stringOperations);
	comboboxes.put("manufacturer", stringOperations);
	comboboxes.put("organization", stringOperations);
    }

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "operating_systems_id_seq")
    @SequenceGenerator(name = "operating_systems_id_seq", sequenceName = "operating_systems_id_seq", allocationSize = 1)
    private Integer id;

    /** The os type. */
    @Column(name = "os_type")
    @Type(type = "text")
    private String osType;

    /** The name. */
    @Column(name = "name")
    @Type(type = "text")
    private String name;

    /** The serial number. */
    @Column(name = "serial_number")
    @Type(type = "text")
    private String serialNumber;

    /** The manufacturer. */
    @Column(name = "manufacturer")
    @Type(type = "text")
    private String manufacturer;

    /** The major version. */
    @Column(name = "major_version")
    private Integer majorVersion;

    /** The minor version. */
    @Column(name = "minor_version")
    private Integer minorVersion;

    /** The build version. */
    @Column(name = "build_version")
    private Integer buildVersion;

    /** The revision version. */
    @Column(name = "revision_version")
    private Integer revisionVersion;

    /** The remaining version. */
    @Column(name = "remaining_version")
    @Type(type = "text")
    private String remainingVersion;

    /** The service pack major version. */
    @Column(name = "service_pack_major_version")
    private Integer servicePackMajorVersion;

    /** The service pack minor version. */
    @Column(name = "service_pack_minor_version")
    private Integer servicePackMinorVersion;

    /** The service pack build version. */
    @Column(name = "service_pack_build_version")
    private Integer servicePackBuildVersion;

    /** The service pack revision version. */
    @Column(name = "service_pack_revision_version")
    private Integer servicePackRevisionVersion;

    /** The service pack remaining version. */
    @Column(name = "service_pack_remaining_version")
    @Type(type = "text")
    private String servicePackRemainingVersion;

    /** The organization. */
    @Column(name = "organization")
    @Type(type = "text")
    private String organization;

    /** The os language. */
    @Column(name = "os_language")
    @Type(type = "text")
    private String osLanguage;

    // We don't need this for now
    // @ManyToMany
    // @Cascade(CascadeType.ALL)
    // @JoinTable(name = "t_config_op_system", joinColumns = {
    // @JoinColumn(name = "operating_system_id") }, inverseJoinColumns = {
    // @JoinColumn(name = "terminal_config_id") })
    // private Set<TerminalConfig> configs;

    /**
     * Instantiates a new operating system.
     */
    public OperatingSystem() {
    }

    /**
     * Instantiates a new operating system with the given operating system data
     * from the agent.
     * 
     * @param os
     *            the os
     */
    public OperatingSystem(OperatingSystemPojo os) {
	if (os.getVersion() != null) {
	    this.setVersion(os.getVersion());
	}
	if (os.getSpversion() != null) {
	    this.setServicePackVersion(os.getSpversion());
	}
	this.manufacturer = os.getManufacturer();
	this.name = os.getName();
	this.organization = os.getOrganization();
	this.osLanguage = os.getOslanguage();
	this.osType = os.getOstype();
	if ((os.getSerialnumber() != null)
		&& (os.getSerialnumber().length() > 0)
		&& !os.getSerialnumber().equals("null")) {
	    this.serialNumber = os.getSerialnumber();
	}
    }

    /**
     * Instantiates a new agent operating system data with the current
     * attributes.
     * 
     * @return the agent operating system data
     */
    public OperatingSystemPojo getInventoryPojo() {
	OperatingSystemPojo pojo = new OperatingSystemPojo();
	pojo.setVersion(getVersion());
	pojo.setSPVersion(getServicePackVersion());
	pojo.setManufacturer(manufacturer);
	pojo.setName(name);
	pojo.setOrganization(organization);
	pojo.setOSLanguage(osLanguage);
	pojo.setOSType(osType);
	pojo.setSerialNumber(serialNumber);
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
     * Gets the version.
     * 
     * @return the version complete
     */
    public String getVersion() {
	String version = null;
	if (majorVersion != null) {
	    version = majorVersion.toString();
	    if (minorVersion != null) {
		version += "." + minorVersion.toString();
		if (buildVersion != null) {
		    version += "." + buildVersion.toString();
		    if (revisionVersion != null) {
			version += "." + revisionVersion.toString();
			if (remainingVersion != null) {
			    version += "." + remainingVersion;
			}
		    }
		}
	    }
	} else {
	    if ((remainingVersion != null) && (remainingVersion != "")) {
		version = remainingVersion;
	    }
	}
	return version;
    }

    /**
     * Sets the version.
     * 
     * @param version
     *            the complete version to set
     */
    public void setVersion(String version) {
	String[] versions = version.split("\\.", 5);
	switch (versions.length) {
	case 5:
	    setRemainingVersion(versions[4]);
	case 4:
	    setRevisionVersion(new Integer(versions[3]));
	case 3:
	    setBuildVersion(new Integer(versions[2]));
	case 2:
	    setMinorVersion(new Integer(versions[1]));
	    setMajorVersion(new Integer(versions[0]));
	    break;
	case 1:
	    try {
		setMajorVersion(new Integer(versions[0]));
	    } catch (NumberFormatException e) {
		setRemainingVersion(versions[0]);
	    }
	case 0:
	    break;
	}
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
     * Gets the major version.
     * 
     * @return the majorVersion
     */
    public Integer getMajorVersion() {
	return majorVersion;
    }

    /**
     * Gets the minor version.
     * 
     * @return the minorVersion
     */
    public Integer getMinorVersion() {
	return minorVersion;
    }

    /**
     * Gets the builds the version.
     * 
     * @return the buildVersion
     */
    public Integer getBuildVersion() {
	return buildVersion;
    }

    /**
     * Gets the revision version.
     * 
     * @return the revisionVersion
     */
    public Integer getRevisionVersion() {
	return revisionVersion;
    }

    /**
     * Sets the major version.
     * 
     * @param majorVersion
     *            the majorVersion to set
     */
    public void setMajorVersion(Integer majorVersion) {
	this.majorVersion = majorVersion;
    }

    /**
     * Sets the minor version.
     * 
     * @param minorVersion
     *            the minorVersion to set
     */
    public void setMinorVersion(Integer minorVersion) {
	this.minorVersion = minorVersion;
    }

    /**
     * Sets the builds the version.
     * 
     * @param buildVersion
     *            the buildVersion to set
     */
    public void setBuildVersion(Integer buildVersion) {
	this.buildVersion = buildVersion;
    }

    /**
     * Sets the revision version.
     * 
     * @param revisionVersion
     *            the revisionVersion to set
     */
    public void setRevisionVersion(Integer revisionVersion) {
	this.revisionVersion = revisionVersion;
    }

    /**
     * Gets the remaining version.
     * 
     * @return the remainingVersion
     */
    public String getRemainingVersion() {
	return remainingVersion;
    }

    /**
     * Sets the remaining version.
     * 
     * @param remainingVersion
     *            the remainingVersion to set
     */
    public void setRemainingVersion(String remainingVersion) {
	this.remainingVersion = remainingVersion;
    }

    /**
     * Gets the os type.
     * 
     * @return the oSType
     */
    public String getOsType() {
	return osType;
    }

    /**
     * Sets the os type.
     * 
     * @param oSType
     *            the oSType to set
     */
    public void setOsType(String oSType) {
	osType = oSType;
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
     * Gets the service pack major version.
     * 
     * @return the servicePackMajorVersion
     */
    public Integer getServicePackMajorVersion() {
	return servicePackMajorVersion;
    }

    /**
     * Sets the service pack major version.
     * 
     * @param servicePackMajorVersion
     *            the servicePackMajorVersion to set
     */
    public void setServicePackMajorVersion(Integer servicePackMajorVersion) {
	this.servicePackMajorVersion = servicePackMajorVersion;
    }

    /**
     * Gets the service pack minor version.
     * 
     * @return the servicePackMinorVersion
     */
    public Integer getServicePackMinorVersion() {
	return servicePackMinorVersion;
    }

    /**
     * Sets the service pack minor version.
     * 
     * @param servicePackMinorVersion
     *            the servicePackMinorVersion to set
     */
    public void setServicePackMinorVersion(Integer servicePackMinorVersion) {
	this.servicePackMinorVersion = servicePackMinorVersion;
    }

    /**
     * Gets the service pack build version.
     * 
     * @return the servicePackBuildVersion
     */
    public Integer getServicePackBuildVersion() {
	return servicePackBuildVersion;
    }

    /**
     * Sets the service pack build version.
     * 
     * @param servicePackBuildVersion
     *            the servicePackBuildVersion to set
     */
    public void setServicePackBuildVersion(Integer servicePackBuildVersion) {
	this.servicePackBuildVersion = servicePackBuildVersion;
    }

    /**
     * Gets the service pack revision version.
     * 
     * @return the servicePackRevisionVersion
     */
    public Integer getServicePackRevisionVersion() {
	return servicePackRevisionVersion;
    }

    /**
     * Sets the service pack revision version.
     * 
     * @param servicePackRevisionVersion
     *            the servicePackRevisionVersion to set
     */
    public void setServicePackRevisionVersion(Integer servicePackRevisionVersion) {
	this.servicePackRevisionVersion = servicePackRevisionVersion;
    }

    /**
     * Gets the service pack remaining version.
     * 
     * @return the servicePackRemainingVersion
     */
    public String getServicePackRemainingVersion() {
	return servicePackRemainingVersion;
    }

    /**
     * Sets the service pack remaining version.
     * 
     * @param servicePackRemainingVersion
     *            the servicePackRemainingVersion to set
     */
    public void setServicePackRemainingVersion(
	    String servicePackRemainingVersion) {
	this.servicePackRemainingVersion = servicePackRemainingVersion;
    }

    /**
     * Gets the service pack version.
     * 
     * @return the Service Pack version complete
     */
    public String getServicePackVersion() {
	String version = null;
	if (servicePackMajorVersion != null) {
	    version = servicePackMajorVersion.toString();
	    if (servicePackMinorVersion != null) {
		version += "." + servicePackMinorVersion.toString();
		if (servicePackBuildVersion != null) {
		    version += "." + servicePackBuildVersion.toString();
		    if (servicePackRevisionVersion != null) {
			version += "." + servicePackRevisionVersion.toString();
			if (servicePackRemainingVersion != null) {
			    version += "." + servicePackRemainingVersion;
			}
		    }
		}
	    }
	} else {
	    if ((servicePackRemainingVersion != null)
		    && (servicePackRemainingVersion != "")) {
		version = servicePackRemainingVersion;
	    }
	}
	return version;
    }

    /**
     * Sets the service pack version.
     * 
     * @param version
     *            the complete Service Pack version to set
     */
    public void setServicePackVersion(String version) {
	String[] versions = version.split("\\.", 5);
	switch (versions.length) {
	case 5:
	    setServicePackRemainingVersion(versions[4]);
	case 4:
	    setServicePackRevisionVersion(new Integer(versions[3]));
	case 3:
	    setServicePackBuildVersion(new Integer(versions[2]));
	case 2:
	    setServicePackMinorVersion(new Integer(versions[1]));
	    setServicePackMajorVersion(new Integer(versions[0]));
	    break;
	case 1:
	    try {
		setServicePackMajorVersion(new Integer(versions[0]));
	    } catch (NumberFormatException e) {
		setServicePackRemainingVersion(versions[0]);
	    }
	case 0:
	    break;
	}
    }

    /**
     * Gets the organization.
     * 
     * @return the organization
     */
    public String getOrganization() {
	return organization;
    }

    /**
     * Sets the organization.
     * 
     * @param organization
     *            the organization to set
     */
    public void setOrganization(String organization) {
	this.organization = organization;
    }

    /**
     * Gets the os language.
     * 
     * @return the oSLanguage
     */
    public String getOsLanguage() {
	return osLanguage;
    }

    /**
     * Sets the os language.
     * 
     * @param oSLanguage
     *            the oSLanguage to set
     */
    public void setOsLanguage(String oSLanguage) {
	osLanguage = oSLanguage;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((buildVersion == null) ? 0 : buildVersion.hashCode());
	result = prime * result
		+ ((majorVersion == null) ? 0 : majorVersion.hashCode());
	result = prime * result
		+ ((manufacturer == null) ? 0 : manufacturer.hashCode());
	result = prime * result
		+ ((minorVersion == null) ? 0 : minorVersion.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result
		+ ((organization == null) ? 0 : organization.hashCode());
	result = prime * result
		+ ((osLanguage == null) ? 0 : osLanguage.hashCode());
	result = prime * result + ((osType == null) ? 0 : osType.hashCode());
	result = prime
		* result
		+ ((remainingVersion == null) ? 0 : remainingVersion.hashCode());
	result = prime * result
		+ ((revisionVersion == null) ? 0 : revisionVersion.hashCode());
	result = prime * result
		+ ((serialNumber == null) ? 0 : serialNumber.hashCode());
	result = prime
		* result
		+ ((servicePackBuildVersion == null) ? 0
			: servicePackBuildVersion.hashCode());
	result = prime
		* result
		+ ((servicePackMajorVersion == null) ? 0
			: servicePackMajorVersion.hashCode());
	result = prime
		* result
		+ ((servicePackMinorVersion == null) ? 0
			: servicePackMinorVersion.hashCode());
	result = prime
		* result
		+ ((servicePackRemainingVersion == null) ? 0
			: servicePackRemainingVersion.hashCode());
	result = prime
		* result
		+ ((servicePackRevisionVersion == null) ? 0
			: servicePackRevisionVersion.hashCode());
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
	OperatingSystem other = (OperatingSystem) obj;
	if (buildVersion == null) {
	    if (other.buildVersion != null)
		return false;
	} else if (!buildVersion.equals(other.buildVersion))
	    return false;
	if (majorVersion == null) {
	    if (other.majorVersion != null)
		return false;
	} else if (!majorVersion.equals(other.majorVersion))
	    return false;
	if (manufacturer == null) {
	    if (other.manufacturer != null)
		return false;
	} else if (!manufacturer.equals(other.manufacturer))
	    return false;
	if (minorVersion == null) {
	    if (other.minorVersion != null)
		return false;
	} else if (!minorVersion.equals(other.minorVersion))
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	if (organization == null) {
	    if (other.organization != null)
		return false;
	} else if (!organization.equals(other.organization))
	    return false;
	if (osLanguage == null) {
	    if (other.osLanguage != null)
		return false;
	} else if (!osLanguage.equals(other.osLanguage))
	    return false;
	if (osType == null) {
	    if (other.osType != null)
		return false;
	} else if (!osType.equals(other.osType))
	    return false;
	if (remainingVersion == null) {
	    if (other.remainingVersion != null)
		return false;
	} else if (!remainingVersion.equals(other.remainingVersion))
	    return false;
	if (revisionVersion == null) {
	    if (other.revisionVersion != null)
		return false;
	} else if (!revisionVersion.equals(other.revisionVersion))
	    return false;
	if (serialNumber == null) {
	    if (other.serialNumber != null)
		return false;
	} else if (!serialNumber.equals(other.serialNumber))
	    return false;
	if (servicePackBuildVersion == null) {
	    if (other.servicePackBuildVersion != null)
		return false;
	} else if (!servicePackBuildVersion
		.equals(other.servicePackBuildVersion))
	    return false;
	if (servicePackMajorVersion == null) {
	    if (other.servicePackMajorVersion != null)
		return false;
	} else if (!servicePackMajorVersion
		.equals(other.servicePackMajorVersion))
	    return false;
	if (servicePackMinorVersion == null) {
	    if (other.servicePackMinorVersion != null)
		return false;
	} else if (!servicePackMinorVersion
		.equals(other.servicePackMinorVersion))
	    return false;
	if (servicePackRemainingVersion == null) {
	    if (other.servicePackRemainingVersion != null)
		return false;
	} else if (!servicePackRemainingVersion
		.equals(other.servicePackRemainingVersion))
	    return false;
	if (servicePackRevisionVersion == null) {
	    if (other.servicePackRevisionVersion != null)
		return false;
	} else if (!servicePackRevisionVersion
		.equals(other.servicePackRevisionVersion))
	    return false;
	return true;
    }
}