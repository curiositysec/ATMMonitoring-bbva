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
 * The Auditable Sofware aggregate
 * 
 * @author jmartin
 * 
 */
@Entity(name = "auditable_software_aggregate")
public class AuditableSoftwareAggregate extends Auditable {

    /** The id */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auditable_software_aggregate_id_seq")
    @SequenceGenerator(name = "auditable_software_aggregate_id_seq", sequenceName = "auditable_software_aggregate_id_seq", allocationSize = 1)
    private Integer id;

    /** The internet explorer */
    @ManyToOne
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "software_aggregate_id")
    @Cascade(CascadeType.ALL)
    private SoftwareAggregate softwareAggregate;

    /** Default constructor */
    public AuditableSoftwareAggregate() {
    }

    /**
     * Constructor
     * 
     * @param internetExplorer
     *            The internet explorer
     */
    public AuditableSoftwareAggregate(SoftwareAggregate softwareAggregate) {
	this();
	this.softwareAggregate = softwareAggregate;
    }

    /**
     * Gets the software aggregate
     * 
     * @return The software aggregate
     */
    public SoftwareAggregate getSoftwareAggregate() {
	return softwareAggregate;
    }

    /**
     * Sets the software aggregate
     * 
     * @param softwareAggregate
     *            The software aggregate
     */
    public void setSoftwareAggregate(SoftwareAggregate softwareAggregate) {
	this.softwareAggregate = softwareAggregate;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime
		* result
		+ ((softwareAggregate == null) ? 0 : softwareAggregate
			.hashCode());
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
	AuditableSoftwareAggregate other = (AuditableSoftwareAggregate) obj;
	if (softwareAggregate == null) {
	    if (other.softwareAggregate != null)
		return false;
	} else if (!softwareAggregate.equals(other.softwareAggregate))
	    return false;
	return true;
    }

}
