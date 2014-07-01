package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.InternetExplorerDAO;
import com.ncr.ATMMonitoring.pojo.InternetExplorer;

/**
 * The Class InternetExplorerServiceImpl.
 * 
 * Default implementation of the InternetExplorerService.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("internetExplorerService")
@Transactional
public class InternetExplorerServiceImpl implements InternetExplorerService {

    /** The internet explorer dao. */
    @Autowired
    private InternetExplorerDAO internetExplorerDAO;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.InternetExplorerService#addInternetExplorer
     * (com.ncr.ATMMonitoring.pojo.InternetExplorer)
     */
    @Override
    public void addInternetExplorer(InternetExplorer internetExplorer) {
	internetExplorerDAO.addInternetExplorer(internetExplorer);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.InternetExplorerService#listInternetExplorer
     * ()
     */
    @Override
    public List<InternetExplorer> listInternetExplorer() {
	return internetExplorerDAO.listInternetExplorer();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.InternetExplorerService#getInternetExplorer
     * (java.lang.Integer)
     */
    @Override
    public InternetExplorer getInternetExplorer(Integer id) {
	return internetExplorerDAO.getInternetExplorer(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.InternetExplorerService#removeInternetExplorer
     * (java.lang.Integer)
     */
    @Override
    public void removeInternetExplorer(Integer id) {
	internetExplorerDAO.removeInternetExplorer(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.service.InternetExplorerService#
     * getInternetExplorerByVersion(java.lang.Integer, java.lang.Integer,
     * java.lang.Integer, java.lang.Integer, java.lang.String)
     */
    @Override
    public InternetExplorer getInternetExplorerByVersion(Integer majorVersion,
	    Integer minorVersion, Integer buildVersion,
	    Integer revisionVersion, String remainingVersion) {
	return internetExplorerDAO.getInternetExplorerByVersion(majorVersion,
		minorVersion, buildVersion, revisionVersion, remainingVersion);
    }
}