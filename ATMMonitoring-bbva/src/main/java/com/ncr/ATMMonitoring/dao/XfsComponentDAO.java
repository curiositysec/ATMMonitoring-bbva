package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.XfsComponent;

/**
 * The Interface XfsComponentDAO.
 * 
 * Dao with the operations for managing XfsComponent Pojos.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface XfsComponentDAO {

    /**
     * Adds the xfs component.
     * 
     * @param xfsComponent
     *            the xfs component
     */
    public void addXfsComponent(XfsComponent xfsComponent);

    /**
     * Lists all xfs components.
     * 
     * @return the list
     */
    public List<XfsComponent> listXfsComponents();

    /**
     * Gets the xfs component with the given id.
     * 
     * @param id
     *            the id
     * @return the xfs component, or null if it doesn't exist
     */
    public XfsComponent getXfsComponent(Integer id);
}
