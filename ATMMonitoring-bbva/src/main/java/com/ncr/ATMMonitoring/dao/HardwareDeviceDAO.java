package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.HardwareDevice;

/**
 * The Interface HardwareDeviceDAO.
 * 
 * Dao with the operations for managing HardwareDevice Pojos.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface HardwareDeviceDAO {

    /**
     * Adds the hardware device.
     * 
     * @param hardwareDevice
     *            the hardware device
     */
    public void addHardwareDevice(HardwareDevice hardwareDevice);

    /**
     * Lists all hardware devices.
     * 
     * @return the list
     */
    public List<HardwareDevice> listHardwareDevices();

    /**
     * Gets the hardware device with the given id.
     * 
     * @param id
     *            the id
     * @return the hardware device, or null if it doesn't exist
     */
    public HardwareDevice getHardwareDevice(Integer id);

    /**
     * Removes the hardware device with the given id.
     * 
     * @param id
     *            the id
     */
    public void removeHardwareDevice(Integer id);
}
