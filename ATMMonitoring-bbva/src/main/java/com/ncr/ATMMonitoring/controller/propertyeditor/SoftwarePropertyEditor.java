package com.ncr.ATMMonitoring.controller.propertyeditor;

import java.beans.PropertyEditorSupport;

import com.ncr.ATMMonitoring.service.SoftwareService;

/**
 * The Class SoftwarePropertyEditor.
 * 
 * Custom PropertyEditor for Software input values (Software id as an integer).
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class SoftwarePropertyEditor extends PropertyEditorSupport {

    /** The software service. */
    private SoftwareService softwareService;

    /**
     * Instantiates a new software property editor.
     * 
     * @param softwareService
     *            the software service
     */
    public SoftwarePropertyEditor(SoftwareService softwareService) {
	this.softwareService = softwareService;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.beans.PropertyEditorSupport#setAsText(java.lang.String)
     */
    @Override
    public void setAsText(final String name) {
	setValue(softwareService.getSoftware(Integer.valueOf(name)));
    }
}