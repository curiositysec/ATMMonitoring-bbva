package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.PhysicalCashUnit;

/**
 * The Interface PhysicalCashUnitService.
 * 
 * It contains the physical cash unit related methods.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface PhysicalCashUnitService {

    /**
     * Adds the physical cash unit.
     * 
     * @param physicalCashUnit
     *            the physical cash unit
     */
    public void addPhysicalCashUnit(PhysicalCashUnit physicalCashUnit);

    /**
     * Gets the physical cash unit by its id.
     * 
     * @param id
     *            the physical cash unit id
     * @return the physical cash unit
     */
    public PhysicalCashUnit getPhysicalCashUnit(Integer id);

    /**
     * List physical cash units.
     * 
     * @return the physical cash unit list
     */
    public List<PhysicalCashUnit> listPhysicalCashUnits();
}