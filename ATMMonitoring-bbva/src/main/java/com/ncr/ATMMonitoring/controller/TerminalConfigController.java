package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncr.ATMMonitoring.controller.propertyeditor.SoftwarePropertyEditor;
import com.ncr.ATMMonitoring.pojo.Software;
import com.ncr.ATMMonitoring.pojo.TerminalConfig;
import com.ncr.ATMMonitoring.service.SoftwareService;
import com.ncr.ATMMonitoring.servicefacade.AtmFacade;

/**
 * The Class TerminalConfigController.
 * 
 * Controller for handling terminal config related HTTP petitions.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Controller
public class TerminalConfigController extends GenericController {

    /** The atm service facade. */
    @Autowired
    private AtmFacade atmService;

    /** The software service. */
    @Autowired
    private SoftwareService softwareService;

    /**
     * Binds custom property editors.
     * 
     * @param binder
     *            the binder
     * @throws Exception
     *             the exception
     */
    @InitBinder
    protected void binder(WebDataBinder binder) throws Exception {
	binder.registerCustomEditor(Software.class, new SoftwarePropertyEditor(
		softwareService));
    }

    /**
     * Terminal config details URL.
     * 
     * @param terminalConfigId
     *            the terminal config id
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping("/terminals/swConfigs/details/{configId}")
    public String terminalConfigDetails(
	    @PathVariable("configId") Integer terminalConfigId,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {
	TerminalConfig terminalConfig = this.atmService
		.getATMMachine(terminalConfigId);
	if (terminalConfig == null) {
	    return "redirect:/terminals/list";
	}
	String userMsg = "";
	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	}
	map.put("userMsg", userMsg);
	map.put("config", terminalConfig);

	return "terminalConfigDetails";
    }

}