package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.WidgetCategoryDAO;
import com.ncr.ATMMonitoring.pojo.WidgetCategory;

/**
 * The WidgetCategoryServiceImpl
 * 
 * The default implementation for WidgetCategoryService
 * 
 * @author jmartin
 * 
 */
@Service("WidgetCategoryService")
@Transactional
public class WidgetCategoryServiceImpl implements WidgetCategoryService {

    /** The widget categoryDAO */
    @Autowired
    private WidgetCategoryDAO widgetCategoryDAO;

    /**
     * @see WidgetCategoryService
     */
    @Override
    public List<WidgetCategory> findAll() {
	return widgetCategoryDAO.findAll();
    }

    /**
     * @see WidgetCategoryService
     */
    @Override
    public void updateWidgetCategory(WidgetCategory widgetCategory) {
	widgetCategoryDAO.updateWidgetCategory(widgetCategory);
    }

}
