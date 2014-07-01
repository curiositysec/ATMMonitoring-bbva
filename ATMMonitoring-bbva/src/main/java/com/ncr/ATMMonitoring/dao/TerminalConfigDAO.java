package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.TerminalConfig;

/**
 * The Interface TerminalConfigDAO.
 * 
 * Dao with the operations for managing TerminalConfig Pojos.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface TerminalConfigDAO {

    /**
     * Adds the terminal config.
     * 
     * @param terminalConfig
     *            the terminal config
     */
    public void addTerminalConfig(TerminalConfig terminalConfig);

    /**
     * Lists all terminal config.
     * 
     * @return the list
     */
    public List<TerminalConfig> listTerminalConfig();

    /**
     * Gets the terminal config with the given id.
     * 
     * @param id
     *            the id
     * @return the terminal config, or null if it doesn't exist
     */
    public TerminalConfig getTerminalConfig(Integer id);
}
