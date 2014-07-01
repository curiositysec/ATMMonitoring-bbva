package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.LogicalCashUnitDAO;
import com.ncr.ATMMonitoring.pojo.LogicalCashUnit;

/**
 * The Class LogicalCashUnitServiceImpl.
 * 
 * Default implementation of the LogicalCashUnitService.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("logicalCashUnitService")
@Transactional
public class LogicalCashUnitServiceImpl implements LogicalCashUnitService {

    /** The logical cash unit dao. */
    @Autowired
    private LogicalCashUnitDAO logicalCashUnitDAO;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.LogicalCashUnitService#addLogicalCashUnit
     * (com.ncr.ATMMonitoring.pojo.LogicalCashUnit)
     */
    @Override
    public void addLogicalCashUnit(LogicalCashUnit logicalCashUnit) {
	logicalCashUnitDAO.addLogicalCashUnit(logicalCashUnit);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.LogicalCashUnitService#listLogicalCashUnits
     * ()
     */
    @Override
    public List<LogicalCashUnit> listLogicalCashUnits() {
	return logicalCashUnitDAO.listLogicalCashUnits();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.LogicalCashUnitService#getLogicalCashUnit
     * (java.lang.Integer)
     */
    @Override
    public LogicalCashUnit getLogicalCashUnit(Integer id) {
	return logicalCashUnitDAO.getLogicalCashUnit(id);
    }
}