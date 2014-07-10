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
@Table(name = "auditable_operating_systems")
public class AuditableOperatingSystem extends Auditable {

    /** The id */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auditable_operating_systems_id_seq")
    @SequenceGenerator(name = "auditable_operating_systems_id_seq", sequenceName = "auditable_operating_systems_id_seq", allocationSize = 1)
    private Integer id;


    @ManyToOne
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "os_id")
    @Cascade(CascadeType.ALL)
    private OperatingSystem os;
    
    

    public AuditableOperatingSystem(OperatingSystem os) {
	super();
	this.os = os;
    }

    public AuditableOperatingSystem() {
	super();
	
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OperatingSystem getOs() {
        return os;
    }

    public void setOs(OperatingSystem os) {
        this.os = os;
    }

    @Override
    public int hashCode() {
	final int prime = 4231 ;
	int result = 18;
	result = prime * result + ((os == null) ? 0 : os.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	boolean equal = false;
	if (this == obj) {

	    equal = true;

	} else if ((obj instanceof AuditableOperatingSystem) && (os != null)) {

	    AuditableOperatingSystem other = (AuditableOperatingSystem) obj;
	    if (other.os != null) {

		equal = os.equals(other.os);
	    }

	}

	return equal;
    }

}
