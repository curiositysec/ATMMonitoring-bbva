package com.ncr.ATMMonitoring.controller.propertyeditor;

import java.beans.PropertyEditorSupport;

import com.ncr.ATMMonitoring.service.BankCompanyService;

/**
 * The Class BankCompanyPropertyEditor.
 * 
 * Custom PropertyEditor for Bank Company input values (Bank Company id as an
 * integer).
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class BankCompanyPropertyEditor extends PropertyEditorSupport {

    /** The bank company service. */
    private BankCompanyService bankCompanyService;

    /**
     * Instantiates a new bank company property editor.
     * 
     * @param bankCompanyService
     *            the bank company service
     */
    public BankCompanyPropertyEditor(BankCompanyService bankCompanyService) {
	this.bankCompanyService = bankCompanyService;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.beans.PropertyEditorSupport#setAsText(java.lang.String)
     */
    @Override
    public void setAsText(final String name) {
	if ((name != null) && (name.length() > 0)) {
	    setValue(bankCompanyService.getBankCompany(Integer.valueOf(name)));
	} else {
	    setValue(null);
	}
    }
}