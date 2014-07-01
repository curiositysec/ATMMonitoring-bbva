package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.LogicalCashUnit;

/**
 * The Interface LogicalCashUnitService.
 * 
 * It contains the logical cash unit related methods.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface LogicalCashUnitService {

    /**
     * Adds the logical cash unit.
     * 
     * @param logicalCashUnit
     *            the logical cash unit
     */
    public void addLogicalCashUnit(LogicalCashUnit logicalCashUnit);

    /**
     * Gets the logical cash unit by its id.
     * 
     * @param id
     *            the logical cash unit id
     * @return the logical cash unit
     */
    public LogicalCashUnit getLogicalCashUnit(Integer id);

    /**
     * List logical cash units.
     * 
     * @return the logical cash unit list
     */
    public List<LogicalCashUnit> listLogicalCashUnits();
}