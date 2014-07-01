package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.LogicalCashUnit;

/**
 * The Class LogicalCashUnitDAOImpl.
 * 
 * Default implementation of LogicalCashUnitDAO.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class LogicalCashUnitDAOImpl extends AbstractGenericDAO<LogicalCashUnit>
	implements LogicalCashUnitDAO {

    /** The logger. */
    static private Logger logger = Logger
	    .getLogger(LogicalCashUnitDAOImpl.class.getName());

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.LogicalCashUnitDAO#addLogicalCashUnit(com.ncr
     * .ATMMonitoring.pojo.LogicalCashUnit)
     */
    @Override
    public void addLogicalCashUnit(LogicalCashUnit logicalCashUnit) {
	add(logicalCashUnit);
	logger.debug("Created new Logical Cash Unit with id "
		+ logicalCashUnit.getId());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.LogicalCashUnitDAO#listLogicalCashUnits()
     */
    @Override
    public List<LogicalCashUnit> listLogicalCashUnits() {
	return list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.LogicalCashUnitDAO#getLogicalCashUnit(java.
     * lang.Integer)
     */
    @Override
    public LogicalCashUnit getLogicalCashUnit(Integer id) {
	return get(id);
    }
}