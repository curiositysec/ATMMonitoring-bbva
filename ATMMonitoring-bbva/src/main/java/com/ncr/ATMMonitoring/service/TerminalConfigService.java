package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.TerminalConfig;

/**
 * The Interface TerminalConfigService.
 * 
 * It contains the terminal config related methods.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface TerminalConfigService {

    /**
     * Adds the terminal config.
     * 
     * @param terminalConfig
     *            the terminal config
     */
    public void addTerminalConfig(TerminalConfig terminalConfig);

    /**
     * Gets the terminal config by its id.
     * 
     * @param id
     *            the terminal config id
     * @return the terminal config
     */
    public TerminalConfig getTerminalConfig(Integer id);

    /**
     * List terminal config.
     * 
     * @return the terminal config list
     */
    public List<TerminalConfig> listTerminalConfig();
}