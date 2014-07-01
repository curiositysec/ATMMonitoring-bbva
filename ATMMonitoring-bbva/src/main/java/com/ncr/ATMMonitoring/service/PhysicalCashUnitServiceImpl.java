package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.PhysicalCashUnitDAO;
import com.ncr.ATMMonitoring.pojo.PhysicalCashUnit;

/**
 * The Class PhysicalCashUnitServiceImpl.
 * 
 * Default implementation of the PhysicalCashUnitService.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("physicalCashUnitService")
@Transactional
public class PhysicalCashUnitServiceImpl implements PhysicalCashUnitService {

    /** The physical cash unit dao. */
    @Autowired
    private PhysicalCashUnitDAO physicalCashUnitDAO;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.PhysicalCashUnitService#addPhysicalCashUnit
     * (com.ncr.ATMMonitoring.pojo.PhysicalCashUnit)
     */
    @Override
    public void addPhysicalCashUnit(PhysicalCashUnit physicalCashUnit) {
	physicalCashUnitDAO.addPhysicalCashUnit(physicalCashUnit);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.PhysicalCashUnitService#listPhysicalCashUnits
     * ()
     */
    @Override
    public List<PhysicalCashUnit> listPhysicalCashUnits() {
	return physicalCashUnitDAO.listPhysicalCashUnits();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.PhysicalCashUnitService#getPhysicalCashUnit
     * (java.lang.Integer)
     */
    @Override
    public PhysicalCashUnit getPhysicalCashUnit(Integer id) {
	return physicalCashUnitDAO.getPhysicalCashUnit(id);
    }
}