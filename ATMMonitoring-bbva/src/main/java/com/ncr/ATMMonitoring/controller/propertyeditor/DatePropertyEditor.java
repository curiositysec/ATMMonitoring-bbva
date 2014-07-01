package com.ncr.ATMMonitoring.controller.propertyeditor;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Class DatePropertyEditor.
 * 
 * Custom PropertyEditor for Date input values.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class DatePropertyEditor extends PropertyEditorSupport {

    private static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";
    /**
     * Flag for using current time as default value if a void or invalid one is
     * supplied.
     */
    private boolean nowAsDefault = false;

    /**
     * The date formmater
     */

    private static SimpleDateFormat formatter = new SimpleDateFormat(
	    DEFAULT_DATE_FORMAT);

    /**
     * Instantiates a new date property editor.
     */
    public DatePropertyEditor() {
    }

    /**
     * Instantiates a new date property editor.
     * 
     * @param nowAsDefault
     *            flag for using current time as default value if a void or
     *            invalid one is supplied.
     */
    public DatePropertyEditor(boolean nowAsDefault) {
	this.nowAsDefault = nowAsDefault;
    }

    @Override
    public void setAsText(final String date) {
	if (nowAsDefault || date != null && !date.equals("")) {
	    try {
		setValue(formatter.parse(date));
	    } catch (Exception e) {
		if (nowAsDefault) {
		    setValue(new Date());
		} else {
		    e.printStackTrace();
		}
	    }
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.beans.PropertyEditorSupport#getAsText()
     */
    @Override
    public String getAsText() {
	Date value = (Date) getValue();
	return (value != null) ? formatter.format(value) : "";
    }
}