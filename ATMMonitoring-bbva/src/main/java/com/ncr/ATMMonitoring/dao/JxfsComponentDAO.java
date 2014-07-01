package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.JxfsComponent;

/**
 * The Interface JxfsComponentDAO.
 * 
 * Dao with the operations for managing JxfsComponent Pojos.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface JxfsComponentDAO {

    /**
     * Adds the jxfs component.
     * 
     * @param jxfsComponent
     *            the jxfs component
     */
    public void addJxfsComponent(JxfsComponent jxfsComponent);

    /**
     * Lists all jxfs components.
     * 
     * @return the list
     */
    public List<JxfsComponent> listJxfsComponents();

    /**
     * Gets the jxfs component with the given id.
     * 
     * @param id
     *            the id
     * @return the jxfs component, or null if it doesn't exist
     */
    public JxfsComponent getJxfsComponent(Integer id);
}
