package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.JxfsComponent;
import com.ncr.ATMMonitoring.pojo.XfsComponent;

/**
 * The Interface XfsComponentService.
 * 
 * It contains the xfs/jxfs component related methods.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface XfsComponentService {

    /**
     * Adds the xfs component.
     * 
     * @param xfsComponent
     *            the xfs component
     */
    public void addXfsComponent(XfsComponent xfsComponent);

    /**
     * Gets the xfs component by its id.
     * 
     * @param id
     *            the xfs component id
     * @return the xfs component
     */
    public XfsComponent getXfsComponent(Integer id);

    /**
     * List xfs components.
     * 
     * @return the xfs component list
     */
    public List<XfsComponent> listXfsComponents();

    /**
     * Adds the jxfs component.
     * 
     * @param jxfsComponent
     *            the jxfs component
     */
    public void addJxfsComponent(JxfsComponent jxfsComponent);

    /**
     * Gets the jxfs component by its id.
     * 
     * @param id
     *            the jxfs component id
     * @return the jxfs component
     */
    public JxfsComponent getJxfsComponent(Integer id);

    /**
     * List jxfs components.
     * 
     * @return the jxfs component list
     */
    public List<JxfsComponent> listJxfsComponents();
}