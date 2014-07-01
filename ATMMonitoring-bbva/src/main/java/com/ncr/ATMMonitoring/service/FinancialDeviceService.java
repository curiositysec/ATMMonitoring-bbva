package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.FinancialDevice;

/**
 * The Interface FinancialDeviceService.
 * 
 * It contains the financial device related methods.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface FinancialDeviceService {

    /**
     * Adds the financial device.
     * 
     * @param financialDevice
     *            the financial device
     */
    public void addFinancialDevice(FinancialDevice financialDevice);

    /**
     * Removes the financial device by its id..
     * 
     * @param id
     *            the financial device id
     */
    public void removeFinancialDevice(Integer id);

    /**
     * Gets the financial device by its id.
     * 
     * @param id
     *            the financial device id
     * @return the financial device
     */
    public FinancialDevice getFinancialDevice(Integer id);

    /**
     * List all financial devices.
     * 
     * @return the list
     */
    public List<FinancialDevice> listFinancialDevices();
}