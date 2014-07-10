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
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
@Entity
@Table(name = "auditable_software")
public class AuditableSoftware extends Auditable {

    /** The id */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auditable_software_id_seq")
    @SequenceGenerator(name = "auditable_software_id_seq", sequenceName = "auditable_software_id_seq", allocationSize = 1)
    private Integer id;


    @ManyToOne
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "software_id")
    @Cascade(CascadeType.ALL)
    private Software software;
    
    

    public AuditableSoftware(Software software) {
	super();
	this.software = software;
    }

    public AuditableSoftware() {
	super();
	
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    @Override
    public int hashCode() {
	final int prime = 4231 ;
	int result = 18;
	result = prime * result + ((software == null) ? 0 : software.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	boolean equal = false;
	if (this == obj) {

	    equal = true;

	} else if ((obj instanceof AuditableSoftware) && (software != null)) {

	    AuditableSoftware other = (AuditableSoftware) obj;
	    if (other.software != null) {

		equal = software.equals(other.software);
	    }

	}

	return equal;
    }


}
