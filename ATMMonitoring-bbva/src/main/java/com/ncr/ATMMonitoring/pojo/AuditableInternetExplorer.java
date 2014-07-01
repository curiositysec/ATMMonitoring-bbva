package com.ncr.ATMMonitoring.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * 
 * The Auditable Internet Explorer Pojo.
 * 
 * @author jmartin
 * 
 */
@Entity(name = "auditable_internet_explorer")
public class AuditableInternetExplorer extends Auditable {

    /** The id */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auditable_internet_explorers_id_seq")
    @SequenceGenerator(name = "auditable_internet_explorers_id_seq", sequenceName = "auditable_internet_explorers_id_seq", allocationSize = 1)
    private Integer id;

    /** The internet explorer */
    @ManyToOne
    @PrimaryKeyJoinColumn
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "internet_explorer_id")
    private InternetExplorer internetExplorer;

    /** Default constructor */
    public AuditableInternetExplorer() {
    }

    /**
     * Constructor
     * 
     * @param internetExplorer
     *            The internet explorer
     */
    public AuditableInternetExplorer(InternetExplorer internetExplorer) {
	this();
	this.internetExplorer = internetExplorer;
    }

    /**
     * Get the internet explorer
     * 
     * @return The internet explorer
     */
    public InternetExplorer getInternetExplorer() {
	return internetExplorer;
    }

    /**
     * Set the internet explorer
     * 
     * @param The
     *            internet explorer
     */
    public void setInternetExplorer(InternetExplorer internetExplorer) {
	this.internetExplorer = internetExplorer;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime
		* result
		+ ((internetExplorer == null) ? 0 : internetExplorer.hashCode());
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
	AuditableInternetExplorer other = (AuditableInternetExplorer) obj;
	if (internetExplorer == null) {
	    if (other.internetExplorer != null)
		return false;
	} else if (!internetExplorer.equals(other.internetExplorer))
	    return false;
	return true;
    }
}
