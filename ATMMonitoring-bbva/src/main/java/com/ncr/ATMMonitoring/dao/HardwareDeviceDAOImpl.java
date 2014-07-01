package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.HardwareDevice;

/**
 * The Class HardwareDeviceDAOImpl.
 * 
 * Default implementation of HardwareDeviceDAO.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class HardwareDeviceDAOImpl extends AbstractGenericDAO<HardwareDevice>
	implements HardwareDeviceDAO {

    /** The logger. */
    static private Logger logger = Logger.getLogger(HardwareDeviceDAOImpl.class
	    .getName());

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.HardwareDeviceDAO#addHardwareDevice(com.ncr
     * .ATMMonitoring.pojo.HardwareDevice)
     */
    @Override
    public void addHardwareDevice(HardwareDevice hardwareDevice) {
	add(hardwareDevice);
	logger.debug("Created new Hardware Device with id "
		+ hardwareDevice.getId());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.HardwareDeviceDAO#listHardwareDevices()
     */
    @Override
    public List<HardwareDevice> listHardwareDevices() {
	return list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.HardwareDeviceDAO#getHardwareDevice(java.lang
     * .Integer)
     */
    @Override
    public HardwareDevice getHardwareDevice(Integer id) {
	return get(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.HardwareDeviceDAO#removeHardwareDevice(java
     * .lang.Integer)
     */
    @Override
    public void removeHardwareDevice(Integer id) {
	delete(id);
    }
}