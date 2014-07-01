package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.LogicalCashUnit;

/**
 * The Interface LogicalCashUnitDAO.
 * 
 * Dao with the operations for managing LogicalCashUnit Pojos.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface LogicalCashUnitDAO {

    /**
     * Adds the logical cash unit.
     * 
     * @param logicalCashUnit
     *            the logical cash unit
     */
    public void addLogicalCashUnit(LogicalCashUnit logicalCashUnit);

    /**
     * Lists all logical cash units.
     * 
     * @return the list
     */
    public List<LogicalCashUnit> listLogicalCashUnits();

    /**
     * Gets the logical cash unit with the given id.
     * 
     * @param id
     *            the id
     * @return the logical cash unit, or null if it doesn't exist
     */
    public LogicalCashUnit getLogicalCashUnit(Integer id);
}
