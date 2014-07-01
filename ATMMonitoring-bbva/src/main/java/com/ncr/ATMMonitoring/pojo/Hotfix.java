package com.ncr.ATMMonitoring.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
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
import com.ncr.agent.baseData.os.module.HotfixPojo;

/**
 * The Hotfix Pojo.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "hotfixes")
public class Hotfix extends Auditable {

    /** The logger. */
    static private Logger logger = Logger.getLogger(Hotfix.class.getName());

    /** The comboboxes data related to this entity for the query designer. */
    private static final Map<String, Map> comboboxes;

    static {
	comboboxes = new TreeMap<String, Map>();
	Map<String, Map> stringOperations = Operation
		.getOperationsByType(Operation.DataType.STRING);
	comboboxes.put("number",
		Operation.getOperationsByType(Operation.DataType.NUMBER));
	comboboxes.put("fixComments", stringOperations);
	comboboxes.put("hotfixId", stringOperations);
	comboboxes.put("description", stringOperations);
	comboboxes.put("startDate",
		Operation.getOperationsByType(Operation.DataType.DATE));
    }

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotfixes_id_seq")
    @SequenceGenerator(name = "hotfixes_id_seq", sequenceName = "hotfixes_id_seq", allocationSize = 1)
    private Integer id;

    /** The terminal. */
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.REFRESH)
    @JoinColumn(name = "terminal_id")
    private Terminal terminal;

    /** The number. */
    @Column(name = "numbr")
    private Integer number;

    /** The fix comments. */
    @Column(name = "fix_comments")
    @Type(type = "text")
    private String fixComments;

    /** The hotfix id. */
    @Column(name = "hotfix_id")
    @Type(type = "text")
    private String hotfixId;

    /** The description. */
    @Column(name = "description")
    @Type(type = "text")
    private String description;

    /**
     * Instantiates a new hotfix.
     */
    public Hotfix() {
    }

    /**
     * Instantiates a new hotfix with the given hotfix data from the agent.
     * 
     * @param hotfix
     *            the hotfix
     */
    public Hotfix(HotfixPojo hotfix) {
	this.description = hotfix.getDescription();
	this.fixComments = hotfix.getFixComments();
	this.hotfixId = hotfix.getHotfixID();
	if (hotfix.getInstalledOn().length() > 0) {
	    try {
		String[] date = hotfix.getInstalledOn().split("/");
		String pattern = "dd/MM/";
		if (date.length >= 3) {
		    String day = date[0];
		    if (day.length() > 2) {
			day = day.substring(0, 2);
		    } else if (day.length() == 1) {
			day = "0" + day;
		    } else if (day.length() != 2) {
			day = null;
		    }
		    String month = date[1];
		    if (month.length() > 2) {
			month = month.substring(0, 2);
		    } else if (month.length() == 1) {
			month = "0" + month;
		    } else if (month.length() != 2) {
			month = null;
		    }
		    String year = date[2];
		    if (year.length() >= 4) {
			year = year.substring(0, 4);
			pattern += "yyyy";
		    } else if (year.length() == 2) {
			pattern += "yy";
		    } else {
			year = null;
		    }
		    if ((year != null) && (month != null) && (day != null)) {
			this.startDate = new SimpleDateFormat(pattern)
				.parse(day + "/" + month + "/" + year);
		    } else {
			logger.error("Couldn't parse Hotfix date '"
				+ hotfix.getInstalledOn() + "'");
			this.startDate = null;
		    }
		}
	    } catch (ParseException e) {
		logger.error("Couldn't parse Hotfix date.", e);
		this.startDate = null;
	    }
	}
    }

    /**
     * Instantiates a new agent hotfix data with the current attributes.
     * 
     * @return the agent hotfix data
     */
    public HotfixPojo getInventoryPojo() {
	HotfixPojo pojo = new HotfixPojo();
	pojo.setDescription(description);
	pojo.setFixComments(fixComments);
	pojo.setHotfixID(hotfixId);
	if (startDate != null) {
	    pojo.setInstalledOn(new SimpleDateFormat("dd/MM/yyyy")
		    .format(startDate));
	}
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
     * Gets the number.
     * 
     * @return the number
     */
    public Integer getNumber() {
	return number;
    }

    /**
     * Sets the number.
     * 
     * @param number
     *            the number to set
     */
    public void setNumber(Integer number) {
	this.number = number;
    }

    /**
     * Gets the fix comments.
     * 
     * @return the fixComments
     */
    public String getFixComments() {
	return fixComments;
    }

    /**
     * Sets the fix comments.
     * 
     * @param fixComments
     *            the fixComments to set
     */
    public void setFixComments(String fixComments) {
	this.fixComments = fixComments;
    }

    /**
     * Gets the hotfix id.
     * 
     * @return the hotfixId
     */
    public String getHotfixId() {
	return hotfixId;
    }

    /**
     * Sets the hotfix id.
     * 
     * @param hotfixId
     *            the hotfixId to set
     */
    public void setHotfixId(String hotfixId) {
	this.hotfixId = hotfixId;
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

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((description == null) ? 0 : description.hashCode());
	result = prime * result
		+ ((fixComments == null) ? 0 : fixComments.hashCode());
	result = prime * result
		+ ((hotfixId == null) ? 0 : hotfixId.hashCode());
	result = prime * result + ((number == null) ? 0 : number.hashCode());
	result = prime * result
		+ ((terminal == null) ? 0 : terminal.hashCode());
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
	Hotfix other = (Hotfix) obj;
	if (description == null) {
	    if (other.description != null)
		return false;
	} else if (!description.equals(other.description))
	    return false;
	if (fixComments == null) {
	    if (other.fixComments != null)
		return false;
	} else if (!fixComments.equals(other.fixComments))
	    return false;
	if (hotfixId == null) {
	    if (other.hotfixId != null)
		return false;
	} else if (!hotfixId.equals(other.hotfixId))
	    return false;
	if (number == null) {
	    if (other.number != null)
		return false;
	} else if (!number.equals(other.number))
	    return false;
	if (terminal == null) {
	    if (other.terminal != null)
		return false;
	} else if (!terminal.equals(other.terminal))
	    return false;
	return true;
    }

}