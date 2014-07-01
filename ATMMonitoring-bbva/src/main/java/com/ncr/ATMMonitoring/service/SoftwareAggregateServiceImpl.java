package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.SoftwareAggregateDAO;
import com.ncr.ATMMonitoring.pojo.SoftwareAggregate;

/**
 * The Class SoftwareAggregateServiceImpl.
 * 
 * Default implementation of the SoftwareAggregateService.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("softwareAggregateService")
@Transactional
public class SoftwareAggregateServiceImpl implements SoftwareAggregateService {

    /** The software aggregate dao. */
    @Autowired
    private SoftwareAggregateDAO softwareAggregateDAO;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.SoftwareAggregateService#addSoftwareAggregate
     * (com.ncr.ATMMonitoring.pojo.SoftwareAggregate)
     */
    @Override
    public void addSoftwareAggregate(SoftwareAggregate softwareAggregate) {
	softwareAggregateDAO.addSoftwareAggregate(softwareAggregate);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.SoftwareAggregateService#listSoftwareAggregate
     * ()
     */
    @Override
    public List<SoftwareAggregate> listSoftwareAggregate() {
	return softwareAggregateDAO.listSoftwareAggregate();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.SoftwareAggregateService#getSoftwareAggregate
     * (java.lang.Integer)
     */
    @Override
    public SoftwareAggregate getSoftwareAggregate(Integer id) {
	return softwareAggregateDAO.getSoftwareAggregate(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.service.SoftwareAggregateService#
     * getSoftwareAggregateByVersionName(java.lang.Integer, java.lang.Integer,
     * java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String)
     */
    @Override
    public SoftwareAggregate getSoftwareAggregateByVersionName(
	    Integer majorVersion, Integer minorVersion, Integer buildVersion,
	    Integer revisionVersion, String remainingVersion, String name) {
	return softwareAggregateDAO.getSoftwareAggregateByVersionName(
		majorVersion, minorVersion, buildVersion, revisionVersion,
		remainingVersion, name);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.service.SoftwareAggregateService#
     * removeSoftwareAggregate(java.lang.Integer)
     */
    @Override
    public void removeSoftwareAggregate(Integer id) {
	softwareAggregateDAO.removeSoftwareAggregate(id);
    }
}