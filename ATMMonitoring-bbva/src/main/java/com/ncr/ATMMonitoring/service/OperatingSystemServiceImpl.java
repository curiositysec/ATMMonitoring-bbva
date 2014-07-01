package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.OperatingSystemDAO;
import com.ncr.ATMMonitoring.pojo.OperatingSystem;

/**
 * The Class OperatingSystemServiceImpl.
 * 
 * Default implementation of the OperatingSystemService.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("operatingSystemService")
@Transactional
public class OperatingSystemServiceImpl implements OperatingSystemService {

    /** The operating system dao. */
    @Autowired
    private OperatingSystemDAO operatingSystemDAO;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.OperatingSystemService#addOperatingSystem
     * (com.ncr.ATMMonitoring.pojo.OperatingSystem)
     */
    @Override
    public void addOperatingSystem(OperatingSystem operatingSystem) {
	operatingSystemDAO.addOperatingSystem(operatingSystem);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.OperatingSystemService#listOperatingSystem
     * ()
     */
    @Override
    public List<OperatingSystem> listOperatingSystem() {
	return operatingSystemDAO.listOperatingSystem();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.OperatingSystemService#getOperatingSystem
     * (java.lang.Integer)
     */
    @Override
    public OperatingSystem getOperatingSystem(Integer id) {
	return operatingSystemDAO.getOperatingSystem(id);
    }
}