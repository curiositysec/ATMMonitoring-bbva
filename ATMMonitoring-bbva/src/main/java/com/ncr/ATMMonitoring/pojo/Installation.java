package com.ncr.ATMMonitoring.pojo;

import java.util.Map;
import java.util.TreeMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.ncr.ATMMonitoring.utils.Operation;

/**
 * The Installation Pojo.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "installations")
public class Installation extends Auditable {
    /** The Constant locationClasses. */
    private static final String[] locationClasses = { "internal_lobby",
	    "internal_vestibule", "external_ttw", "external_driveup" };

    /** The comboboxes data related to this entity for the query designer. */
    private static final Map<String, Map> comboboxes;

    static {
	comboboxes = new TreeMap<String, Map>();
	Map<String, Map> operations = Operation
		.getOperationsByType(Operation.DataType.STRING);
	String[] fields = { "luCode", "type", "post", "processed",
		"locationClass", "ip", "location.addressStreet",
		"location.addressNumber", "location.addressPostcode",
		"location.addressCity", "location.addressCountry",
		"location.office", "location.bank", "location.bankCompany" };

	for (String field : fields) {
	    comboboxes.put(field, operations);
	}
    }

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "installations_id_seq")
    @SequenceGenerator(name = "installations_id_seq", sequenceName = "installations_id_seq", allocationSize = 1)
    private Integer id;

    /** The location. */
    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "location_id")
    private Location location = new Location();

    /** The lu code. */
    @Column(name = "lu_code", length = 20)
    private String luCode;

    /** The type. */
    @Column(name = "type", length = 50)
    private String type;

    /** The post. */
    @Column(name = "post", length = 30)
    private String post;

    /** The processed. */
    @Column(name = "processed")
    private Boolean processed;

    /** The location class. */
    @Column(name = "location_class", length = 50)
    private String locationClass;

    /** The ip. */
    @Column(name = "ip", length = 50)
    private String ip;

    // We don't need this for now
    // @OneToMany(mappedBy = "installation")
    // @Cascade(CascadeType.ALL)
    // private Set<Terminal> terminals;
    //
    // public Set<Terminal> getTerminals() {
    // return terminals;
    // }
    //
    // public void setTerminals(Set<Terminal> terminals) {
    // this.terminals = terminals;
    // }

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
     * Gets the location.
     * 
     * @return the location
     */
    public Location getLocation() {
	return location;
    }

    /**
     * Sets the location.
     * 
     * @param location
     *            the new location
     */
    public void setLocation(Location location) {
	this.location = location;
    }

    /**
     * Gets the lu code.
     * 
     * @return the lu code
     */
    public String getLuCode() {
	return luCode;
    }

    /**
     * Sets the lu code.
     * 
     * @param luCode
     *            the new lu code
     */
    public void setLuCode(String luCode) {
	this.luCode = luCode;
    }

    /**
     * Gets the type.
     * 
     * @return the type
     */
    public String getType() {
	return type;
    }

    /**
     * Sets the type.
     * 
     * @param type
     *            the new type
     */
    public void setType(String type) {
	this.type = type;
    }

    /**
     * Gets the post.
     * 
     * @return the post
     */
    public String getPost() {
	return post;
    }

    /**
     * Sets the post.
     * 
     * @param post
     *            the new post
     */
    public void setPost(String post) {
	this.post = post;
    }

    /**
     * Gets the processed.
     * 
     * @return the processed
     */
    public Boolean getProcessed() {
	return processed;
    }

    /**
     * Sets the processed.
     * 
     * @param processed
     *            the new processed
     */
    public void setProcessed(Boolean processed) {
	this.processed = processed;
    }

    /**
     * Gets the location class.
     * 
     * @return the location class
     */
    public String getLocationClass() {
	return locationClass;
    }

    /**
     * Sets the location class.
     * 
     * @param locationClass
     *            the new location class
     */
    public void setLocationClass(String locationClass) {
	this.locationClass = locationClass;
    }

    /**
     * Gets the ip.
     * 
     * @return the ip
     */
    public String getIp() {
	return ip;
    }

    /**
     * Sets the ip.
     * 
     * @param ip
     *            the new ip
     */
    public void setIp(String ip) {
	this.ip = ip;
    }

    /**
     * Gets the location classes.
     * 
     * @return the location classes
     */
    public static String[] getLocationclasses() {
	return locationClasses;
    }

    /**
     * Gets the comboboxes data for the query GUI.
     * 
     * @return the comboboxes data
     */
    public static Map<String, Map> getComboboxes() {
	return comboboxes;
    }
}