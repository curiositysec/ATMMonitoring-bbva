package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.InstallationDAO;
import com.ncr.ATMMonitoring.pojo.Installation;

/**
 * The Class InstallationServiceImpl.
 * 
 * Default implementation of the InstallationService.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service
@Transactional
public class InstallationServiceImpl implements InstallationService {

    /** The installation dao. */
    @Autowired
    private InstallationDAO installationDAO;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.InstallationService#addInstallation(com
     * .ncr.ATMMonitoring.pojo.Installation)
     */
    @Override
    public void addInstallation(Installation role) {
	installationDAO.addInstallation(role);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.InstallationService#getInstallation(java
     * .lang.Integer)
     */
    @Override
    public Installation getInstallation(Integer id) {
	return installationDAO.getInstallation(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.InstallationService#listInstallations()
     */
    @Override
    public List<Installation> listInstallations() {
	return installationDAO.listInstallations();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.InstallationService#updateInstallation(
     * com.ncr.ATMMonitoring.pojo.Installation)
     */
    @Override
    public void updateInstallation(Installation installation) {
	installationDAO.updateInstallation(installation);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.InstallationService#removeInstallation(
     * java.lang.Integer)
     */
    @Override
    public void removeInstallation(Integer id) {
	installationDAO.removeInstallation(id);
    }
}