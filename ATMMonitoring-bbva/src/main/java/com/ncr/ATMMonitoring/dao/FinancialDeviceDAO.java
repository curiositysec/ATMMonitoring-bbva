package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.FinancialDevice;

/**
 * The Interface FinancialDeviceDAO.
 * 
 * Dao with the operations for managing FinancialDevice Pojos.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface FinancialDeviceDAO {

    /**
     * Adds the financial device.
     * 
     * @param financialDevice
     *            the financial device
     */
    public void addFinancialDevice(FinancialDevice financialDevice);

    /**
     * Lists all financial devices.
     * 
     * @return the list
     */
    public List<FinancialDevice> listFinancialDevices();

    /**
     * Gets the financial device with the given id.
     * 
     * @param id
     *            the id
     * @return the financial device, or null if it doesn't exist
     */
    public FinancialDevice getFinancialDevice(Integer id);

    /**
     * Removes the financial device.
     * 
     * @param id
     *            the id
     */
    public void removeFinancialDevice(Integer id);
}
