package com.ncr.ATMMonitoring.pojo;

import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * The TerminalConfig Pojo.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "terminal_configs", uniqueConstraints = { @UniqueConstraint(columnNames = {
	"terminal_id", "start_date" }) })
public class TerminalConfig extends Auditable {

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "terminal_configs_id_seq")
    @SequenceGenerator(name = "terminal_configs_id_seq", sequenceName = "terminal_configs_id_seq", allocationSize = 1)
    private Integer id;

    /** The terminal. */
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.REFRESH)
    @JoinColumn(name = "terminal_id")
    private Terminal terminal = new Terminal();

    /** The software. */
    @ManyToMany(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @JoinTable(name = "terminal_config_software", joinColumns = { @JoinColumn(name = "terminal_config_id") }, inverseJoinColumns = { @JoinColumn(name = "software_id") })
    @OrderBy("name asc, major_version desc, minor_version desc, build_version desc, revision_version desc, remaining_version asc")
    private Set<Software> software = new HashSet<Software>();

    /** The operating systems. */
    @ManyToMany(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @JoinTable(name = "t_config_op_system", joinColumns = { @JoinColumn(name = "terminal_config_id") }, inverseJoinColumns = { @JoinColumn(name = "operating_system_id") })
    @OrderBy("name asc, major_version desc, minor_version desc, build_version desc, revision_version desc, remaining_version asc")
    private Set<OperatingSystem> operatingSystems = new HashSet<OperatingSystem>();

    // Code with support for Terminal Config AUTHORS
    //
    // @ManyToOne
    // @Cascade(CascadeType.REFRESH)
    // @JoinColumn(name = "user_id")
    // private User author;
    //
    // /**
    // * @return the author
    // */
    // public User getAuthor() {
    // return author;
    // }
    //
    // /**
    // * @param author
    // * the author to set
    // */
    // public void setAuthor(User author) {
    // this.author = author;
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
     * Gets the software.
     * 
     * @return the software
     */
    public Set<Software> getSoftware() {
	return software;
    }

    /**
     * Sets the software.
     * 
     * @param software
     *            the software to set
     */
    public void setSoftware(Set<Software> software) {
	this.software = software;
    }

    /**
     * Gets the operating systems.
     * 
     * @return the operatingSystems
     */
    public Set<OperatingSystem> getOperatingSystems() {
	return operatingSystems;
    }

    /**
     * Sets the operating systems.
     * 
     * @param operatingSystems
     *            the operatingSystems to set
     */
    public void setOperatingSystems(Set<OperatingSystem> operatingSystems) {
	this.operatingSystems = operatingSystems;
    }

    @Override
    public boolean equals(Object o) {
	if (!(o instanceof TerminalConfig)) {
	    return false;
	}
	TerminalConfig tc = (TerminalConfig) o;
	Set<Software> swAux = tc.getSoftware();
	Set<OperatingSystem> osAux = tc.getOperatingSystems();
	if (!((swAux.size() == software.size()) && (osAux.size() == operatingSystems
		.size()))) {
	    return false;
	}
	for (Software sw : software) {
	    if (!swAux.contains(sw)) {
		return false;
	    }
	}
	for (OperatingSystem os : operatingSystems) {
	    if (!osAux.contains(os)) {
		return false;
	    }
	}
	return true;
    }

}