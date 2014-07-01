package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.SoftwareDAO;
import com.ncr.ATMMonitoring.pojo.Software;

/**
 * The Class SoftwareServiceImpl.
 * 
 * Default implementation of the SoftwareService.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("softwareService")
@Transactional
public class SoftwareServiceImpl implements SoftwareService {

    /** The software dao. */
    @Autowired
    private SoftwareDAO softwareDAO;

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.service.SoftwareService#addSoftware(com.ncr.
     * ATMMonitoring.pojo.Software)
     */
    @Override
    public void addSoftware(Software software) {
	softwareDAO.addSoftware(software);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.service.SoftwareService#listSoftware()
     */
    @Override
    public List<Software> listSoftware() {
	return softwareDAO.listSoftware();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.SoftwareService#getSoftware(java.lang.Integer
     * )
     */
    @Override
    public Software getSoftware(Integer id) {
	return softwareDAO.getSoftware(id);
    }
}