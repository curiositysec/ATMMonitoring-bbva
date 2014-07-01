package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncr.ATMMonitoring.service.BankCompanyService;

/**
 * The Class ErrorController.
 * 
 * Controller for handling HTTP petitions that resulted in an error.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Controller
public class ErrorController extends GenericController {

    /** The logger. */
    static private Logger logger = Logger.getLogger(ErrorController.class
	    .getName());

    /** The bank company service. */
    @Autowired
    private BankCompanyService bankCompanyService;

    /**
     * 404 error.
     * 
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * 
     * @return the petition response
     */
    @RequestMapping(value = { "/404" })
    public String error404(Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {
	String userMsg = "";
	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	}
	map.put("userMsg", userMsg);
	return "404";
    }

    /**
     * 403 error.
     * 
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * 
     * @return the petition response
     */
    @RequestMapping(value = { "/403" })
    public String error403(Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {
	String userMsg = "";
	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	}
	map.put("userMsg", userMsg);
	return "403";
    }

    /**
     * Generic error.
     * 
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * 
     * @return the petition response
     */
    @RequestMapping(value = { "/error" })
    public String error(Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {
	String userMsg = "";
	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	}
	map.put("userMsg", userMsg);
	return "error";
    }

}
