package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.TerminalModel;

/**
 * The Interface TerminalModelDAO.
 * 
 * Dao with the operations for managing TerminalModel Pojos.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface TerminalModelDAO {

    /**
     * Adds the terminal model.
     * 
     * @param terminalModel
     *            the terminal model
     */
    public void addTerminalModel(TerminalModel terminalModel);

    /**
     * Gets the terminal model with the given id.
     * 
     * @param id
     *            the id
     * @return the terminal model, or null if it doesn't exist
     */
    public TerminalModel getTerminalModel(Integer id);

    /**
     * Gets the terminal model by model.
     * 
     * @param model
     *            the model
     * @return the terminal model by model, or null if it doesn't exist
     */
    public TerminalModel getTerminalModelByModel(String model);

    /**
     * Gets the terminal model by product class.
     * 
     * @param productClass
     *            the product class
     * @return the terminal model by product class, or null if it doesn't exist
     */
    public TerminalModel getTerminalModelByProductClass(String productClass);

    /**
     * List terminal models.
     * 
     * @return the list
     */
    public List<TerminalModel> listTerminalModels();

    /**
     * Update terminal model.
     * 
     * @param terminalModel
     *            the terminal model
     */
    public void updateTerminalModel(TerminalModel terminalModel);

    /**
     * Removes the terminal model with the given id.
     * 
     * @param id
     *            the id
     */
    public void removeTerminalModel(Integer id);
}
