package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.WidgetCategory;

/**
 * 
 * Service with the operations related with widgets categories.
 * 
 * @author jmartin
 * 
 */
public interface WidgetCategoryService {

    /**
     * Find all widget categories
     * 
     * @return The widget categories
     */
    public List<WidgetCategory> findAll();

    /**
     * Update a widget category
     * 
     * @param widgetCategory
     *            The widget category
     */
    public void updateWidgetCategory(WidgetCategory widgetCategory);
}
