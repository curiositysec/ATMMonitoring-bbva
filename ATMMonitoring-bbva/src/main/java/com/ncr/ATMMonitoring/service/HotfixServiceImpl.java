package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.HotfixDAO;
import com.ncr.ATMMonitoring.pojo.Hotfix;

/**
 * The Class HotfixServiceImpl.
 * 
 * Default implementation of the HotfixService.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("hotfixService")
@Transactional
public class HotfixServiceImpl implements HotfixService {

    /** The hotfix dao. */
    @Autowired
    private HotfixDAO hotfixDAO;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.HotfixService#addHotfix(com.ncr.ATMMonitoring
     * .pojo.Hotfix)
     */
    @Override
    public void addHotfix(Hotfix hotfix) {
	hotfixDAO.addHotfix(hotfix);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.service.HotfixService#listHotfix()
     */
    @Override
    public List<Hotfix> listHotfix() {
	return hotfixDAO.listHotfix();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.HotfixService#getHotfix(java.lang.Integer)
     */
    @Override
    public Hotfix getHotfix(Integer id) {
	return hotfixDAO.getHotfix(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.HotfixService#removeHotfix(java.lang.Integer
     * )
     */
    @Override
    public void removeHotfix(Integer id) {
	hotfixDAO.removeHotfix(id);
    }
}