package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.FinancialDeviceDAO;
import com.ncr.ATMMonitoring.pojo.FinancialDevice;

/**
 * The Class FinancialDeviceServiceImpl.
 * 
 * Default implementation of the FinancialDeviceService.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("financialDeviceService")
@Transactional
public class FinancialDeviceServiceImpl implements FinancialDeviceService {

    /** The financial device dao. */
    @Autowired
    private FinancialDeviceDAO financialDeviceDAO;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.FinancialDeviceService#addFinancialDevice
     * (com.ncr.ATMMonitoring.pojo.FinancialDevice)
     */
    @Override
    public void addFinancialDevice(FinancialDevice financialDevice) {
	financialDeviceDAO.addFinancialDevice(financialDevice);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.FinancialDeviceService#listFinancialDevices
     * ()
     */
    @Override
    public List<FinancialDevice> listFinancialDevices() {
	return financialDeviceDAO.listFinancialDevices();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.FinancialDeviceService#getFinancialDevice
     * (java.lang.Integer)
     */
    @Override
    public FinancialDevice getFinancialDevice(Integer id) {
	return financialDeviceDAO.getFinancialDevice(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.FinancialDeviceService#removeFinancialDevice
     * (java.lang.Integer)
     */
    @Override
    public void removeFinancialDevice(Integer id) {
	financialDeviceDAO.removeFinancialDevice(id);
    }
}