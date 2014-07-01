package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Widget;

/**
 * The Interface WidgetDAO.
 * 
 * Dao with the operations for managing Widget Pojos.
 * 
 * @author Rafael Luque (rafael.luque@osoco.es)
 */

public interface WidgetDAO {

    /**
     * Saves a widget.
     * 
     * @param widget
     *            the widget
     */
    public void save(Widget widget);

    /**
     * Updates widget.
     * 
     * @param widget
     *            the widget
     */
    public void update(Widget widget);

    /**
     * Find default widgets.
     * 
     * @return the list
     */
    public List<Widget> findDefaultWidgets();

    /**
     * Find widget by id.
     * 
     * @param id
     *            the id
     * @return the widget, or null if it doesn't exist
     */
    public Widget findById(int id);

    public void delete(Widget widget);
}
