package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.FinancialDevice;

/**
 * The Class FinancialDeviceDAOImpl.
 * 
 * Default implementation of FinancialDeviceDAO.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class FinancialDeviceDAOImpl extends AbstractGenericDAO<FinancialDevice>
	implements FinancialDeviceDAO {

    /** The logger. */
    static private Logger logger = Logger
	    .getLogger(FinancialDeviceDAOImpl.class.getName());

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.FinancialDeviceDAO#addFinancialDevice(com.ncr
     * .ATMMonitoring.pojo.FinancialDevice)
     */
    @Override
    public void addFinancialDevice(FinancialDevice financialDevice) {
	add(financialDevice);
	logger.debug("Created new Financial Device with id "
		+ financialDevice.getId());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.FinancialDeviceDAO#listFinancialDevices()
     */
    @Override
    public List<FinancialDevice> listFinancialDevices() {
	return list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.FinancialDeviceDAO#getFinancialDevice(java.
     * lang.Integer)
     */
    @Override
    public FinancialDevice getFinancialDevice(Integer id) {
	return get(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.FinancialDeviceDAO#removeFinancialDevice(java
     * .lang.Integer)
     */
    @Override
    public void removeFinancialDevice(Integer id) {
	delete(id);
    }
}