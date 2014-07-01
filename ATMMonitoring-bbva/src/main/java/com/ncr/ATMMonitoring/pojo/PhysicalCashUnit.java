package com.ncr.ATMMonitoring.pojo;

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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;

/**
 * The PhysicalCashUnit Pojo.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "physical_cash_units")
public class PhysicalCashUnit {

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "physical_cash_units_id_seq")
    @SequenceGenerator(name = "physical_cash_units_id_seq", sequenceName = "physical_cash_units_id_seq", allocationSize = 1)
    private Integer id;

    /** The logical cash unit. */
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.REFRESH)
    @JoinColumn(name = "logical_cash_unit_id")
    private LogicalCashUnit logicalCashUnit;

    /** The name. */
    @Column(name = "name")
    @Type(type = "text")
    private String name;

    /** The unit id. */
    @Column(name = "unit_id")
    private Integer unitId;

    /** The maximum. */
    @Column(name = "maximum")
    private Integer maximum;

    /** The hardware sensor. */
    @Column(name = "hardware_sensor")
    private Boolean hardwareSensor;

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
     * Gets the logical cash unit.
     * 
     * @return the logicalCashUnit
     */
    public LogicalCashUnit getLogicalCashUnit() {
	return logicalCashUnit;
    }

    /**
     * Sets the logical cash unit.
     * 
     * @param logicalCashUnit
     *            the logicalCashUnit to set
     */
    public void setLogicalCashUnit(LogicalCashUnit logicalCashUnit) {
	this.logicalCashUnit = logicalCashUnit;
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
     * Gets the unit id.
     * 
     * @return the unitId
     */
    public Integer getUnitId() {
	return unitId;
    }

    /**
     * Sets the unit id.
     * 
     * @param unitId
     *            the unitId to set
     */
    public void setUnitId(Integer unitId) {
	this.unitId = unitId;
    }

    /**
     * Gets the maximum.
     * 
     * @return the maximum
     */
    public Integer getMaximum() {
	return maximum;
    }

    /**
     * Sets the maximum.
     * 
     * @param maximum
     *            the maximum to set
     */
    public void setMaximum(Integer maximum) {
	this.maximum = maximum;
    }

    /**
     * Gets the hardware sensor.
     * 
     * @return the hardwareSensor
     */
    public Boolean getHardwareSensor() {
	return hardwareSensor;
    }

    /**
     * Sets the hardware sensor.
     * 
     * @param hardwareSensor
     *            the hardwareSensor to set
     */
    public void setHardwareSensor(Boolean hardwareSensor) {
	this.hardwareSensor = hardwareSensor;
    }

}