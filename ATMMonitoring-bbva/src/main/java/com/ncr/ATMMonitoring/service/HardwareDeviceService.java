package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.HardwareDevice;

/**
 * The Interface HardwareDeviceService.
 * 
 * It contains the hardware related methods.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface HardwareDeviceService {

    /**
     * Adds the hardware device.
     * 
     * @param hardwareDevice
     *            the hardware device
     */
    public void addHardwareDevice(HardwareDevice hardwareDevice);

    /**
     * Removes the hardware device by its id.
     * 
     * @param id
     *            the hardware device id
     */
    public void removeHardwareDevice(Integer id);

    /**
     * Gets the hardware device by its id.
     * 
     * @param id
     *            the hardware device id
     * @return the hardware device
     */
    public HardwareDevice getHardwareDevice(Integer id);

    /**
     * List all hardware devices.
     * 
     * @return the hardware device list
     */
    public List<HardwareDevice> listHardwareDevices();
}