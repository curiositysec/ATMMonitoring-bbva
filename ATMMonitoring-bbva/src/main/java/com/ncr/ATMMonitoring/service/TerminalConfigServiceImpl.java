package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.TerminalConfigDAO;
import com.ncr.ATMMonitoring.pojo.TerminalConfig;

/**
 * The Class TerminalConfigServiceImpl.
 * 
 * Default implementation of the TerminalConfigService.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("terminalConfigService")
@Transactional
public class TerminalConfigServiceImpl implements TerminalConfigService {

    /** The terminal config dao. */
    @Autowired
    private TerminalConfigDAO terminalConfigDAO;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.TerminalConfigService#addTerminalConfig
     * (com.ncr.ATMMonitoring.pojo.TerminalConfig)
     */
    @Override
    public void addTerminalConfig(TerminalConfig terminalConfig) {
	terminalConfigDAO.addTerminalConfig(terminalConfig);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.TerminalConfigService#listTerminalConfig()
     */
    @Override
    public List<TerminalConfig> listTerminalConfig() {
	return terminalConfigDAO.listTerminalConfig();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.TerminalConfigService#getTerminalConfig
     * (java.lang.Integer)
     */
    @Override
    public TerminalConfig getTerminalConfig(Integer id) {
	return terminalConfigDAO.getTerminalConfig(id);
    }
}