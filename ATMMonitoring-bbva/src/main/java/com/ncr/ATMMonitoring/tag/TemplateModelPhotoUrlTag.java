package com.ncr.ATMMonitoring.tag;

import com.ncr.ATMMonitoring.pojo.Terminal;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

// TODO: Auto-generated Javadoc
/**
 * The Class TemplateModelPhotoUrlTag.
 * 
 * @author Rafael Luque (rafael.luque@osoco.es)
 */
public class TemplateModelPhotoUrlTag extends SimpleTagSupport {

    /** The atm. */
    private Terminal atm;

    /** The manufacturer. */
    private String manufacturer;

    /** The width. */
    private Integer width;

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
     */
    public void doTag() throws JspException, IOException {
	String url = null;
	if (manufacturer != null) {
	    url = "resources/images/logo/" + manufacturer.toLowerCase()
		    + ".png";
	} else if ((atm != null) && (atm.getTerminalModel() != null)) {
	    if (atm.getTerminalModel().getPhoto() != null) {
		url = "terminals/models/image/"
			+ atm.getTerminalModel().getId();
		if (width != null) {
		    url += "?width=" + width;
		}
	    } else {
		url = "resources/images/logo/"
			+ atm.getTerminalModel().getManufacturer()
				.toLowerCase() + ".png";
	    }
	} else {
	    url = "resources/images/ejemplo/no_photo.png";
	}
	getJspContext().getOut().write(url);
    }

    /**
     * Sets the atm.
     * 
     * @param atm
     *            the new atm
     */
    public void setAtm(Terminal atm) {
	this.atm = atm;
    }

    /**
     * Sets the manufacturer.
     * 
     * @param manufacturer
     *            the new manufacturer
     */
    public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
    }

    /**
     * Sets the width.
     * 
     * @param width
     *            the new width
     */
    public void setWidth(Integer width) {
	this.width = width;
    }

}
