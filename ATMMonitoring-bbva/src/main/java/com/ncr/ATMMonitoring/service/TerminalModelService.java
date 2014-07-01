package com.ncr.ATMMonitoring.service;

import java.util.List;
import java.util.Map;

import com.ncr.ATMMonitoring.pojo.TerminalModel;

/**
 * The Interface TerminalModelService.
 * 
 * It contains the terminal model related methods.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface TerminalModelService {

    /**
     * Adds the terminal model.
     * 
     * @param terminalModel
     *            the terminal model
     */
    public void addTerminalModel(TerminalModel terminalModel);

    /**
     * Gets the terminal model by its id.
     * 
     * @param id
     *            the terminal model id
     * @return the terminal model
     */
    public TerminalModel getTerminalModel(Integer id);

    /**
     * Gets the terminal model by model.
     * 
     * @param model
     *            the model
     * @return the terminal model by model
     */
    public TerminalModel getTerminalModelByModel(String model);

    /**
     * Gets the terminal model by product class.
     * 
     * @param productClass
     *            the product class
     * @return the terminal model by product class
     */
    public TerminalModel getTerminalModelByProductClass(String productClass);

    /**
     * List terminal models.
     * 
     * @return the terminal model list
     */
    public List<TerminalModel> listTerminalModels();

    /**
     * List terminal models by manufacturer.
     * 
     * @return the map with a terminal list for each manufacturer name
     */
    public Map<String, List<TerminalModel>> listTerminalModelsByManufacturer();

    /**
     * Update terminal model.
     * 
     * @param terminalModel
     *            the terminal model
     */
    public void updateTerminalModel(TerminalModel terminalModel);

    /**
     * Removes the terminal model by its id.
     * 
     * @param id
     *            , if successful the terminal model id
     */
    public void removeTerminalModel(Integer id);
}