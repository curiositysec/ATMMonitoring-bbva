package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.HardwareDeviceDAO;
import com.ncr.ATMMonitoring.pojo.HardwareDevice;

/**
 * The Class HardwareDeviceServiceImpl.
 * 
 * Default implementation of the HardwareDeviceService.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("hardwareDeviceService")
@Transactional
public class HardwareDeviceServiceImpl implements HardwareDeviceService {

    /** The hardware device dao. */
    @Autowired
    private HardwareDeviceDAO hardwareDeviceDAO;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.HardwareDeviceService#addHardwareDevice
     * (com.ncr.ATMMonitoring.pojo.HardwareDevice)
     */
    @Override
    public void addHardwareDevice(HardwareDevice hardwareDevice) {
	hardwareDeviceDAO.addHardwareDevice(hardwareDevice);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.HardwareDeviceService#listHardwareDevices()
     */
    @Override
    public List<HardwareDevice> listHardwareDevices() {
	return hardwareDeviceDAO.listHardwareDevices();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.HardwareDeviceService#getHardwareDevice
     * (java.lang.Integer)
     */
    @Override
    public HardwareDevice getHardwareDevice(Integer id) {
	return hardwareDeviceDAO.getHardwareDevice(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.HardwareDeviceService#removeHardwareDevice
     * (java.lang.Integer)
     */
    @Override
    public void removeHardwareDevice(Integer id) {
	hardwareDeviceDAO.removeHardwareDevice(id);
    }
}