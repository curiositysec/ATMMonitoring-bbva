package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.TerminalConfig;

/**
 * The Class TerminalConfigDAOImpl.
 * 
 * Default implementation of TerminalConfigDAO.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class TerminalConfigDAOImpl extends AbstractGenericDAO<TerminalConfig>
	implements TerminalConfigDAO {

    /** The logger. */
    static private Logger logger = Logger.getLogger(TerminalConfigDAOImpl.class
	    .getName());

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.TerminalConfigDAO#addTerminalConfig(com.ncr
     * .ATMMonitoring.pojo.TerminalConfig)
     */
    @Override
    public void addTerminalConfig(TerminalConfig terminalConfig) {
	add(terminalConfig);
	logger.debug("Created new Terminal Config with id "
		+ terminalConfig.getId());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.TerminalConfigDAO#listTerminalConfig()
     */
    @Override
    public List<TerminalConfig> listTerminalConfig() {
	return list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.TerminalConfigDAO#getTerminalConfig(java.lang
     * .Integer)
     */
    @Override
    public TerminalConfig getTerminalConfig(Integer id) {
	return get(id);
    }
}