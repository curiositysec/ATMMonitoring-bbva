package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.WidgetCategory;

/**
 * The Interface WidgetCategoryDAO.
 * 
 * Dao with the operations for managing Widget Category Pojos.
 * 
 * @author jmartin
 * 
 */
public interface WidgetCategoryDAO {

    /**
     * Find all library widgets by category
     * 
     * @return A list with the category widgets
     */
    public List<WidgetCategory> findLibraryWidgetsByCategory();

    /**
     * Find a category by id
     * 
     * @param categoryId
     *            The category id
     * @return The widget category
     */
    public WidgetCategory findCategoryById(Integer categoryId);

    /**
     * Find all widget category
     * 
     * @return A list with the widget category
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
