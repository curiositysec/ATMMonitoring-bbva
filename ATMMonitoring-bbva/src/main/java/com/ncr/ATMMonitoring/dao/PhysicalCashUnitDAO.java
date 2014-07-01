package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.PhysicalCashUnit;

/**
 * The Interface PhysicalCashUnitDAO.
 * 
 * Dao with the operations for managing PhysicalCashUnit Pojos.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface PhysicalCashUnitDAO {

    /**
     * Adds the physical cash unit.
     * 
     * @param physicalCashUnit
     *            the physical cash unit
     */
    public void addPhysicalCashUnit(PhysicalCashUnit physicalCashUnit);

    /**
     * Lists all physical cash units.
     * 
     * @return the list
     */
    public List<PhysicalCashUnit> listPhysicalCashUnits();

    /**
     * Gets the physical cash unit with the given id.
     * 
     * @param id
     *            the id
     * @return the physical cash unit, or null if it doesn't exist
     */
    public PhysicalCashUnit getPhysicalCashUnit(Integer id);
}
