package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The Class HelpController.
 * 
 * Controller for handling help related HTTP petitions.
 * 
 * @author Rafael Luque (rafael.luque@osoco.es)
 * @author Otto Abreu
 */
@Controller
public class HelpController extends GenericController {

    /**
     * Show default help URL.
     * 
     * @param map
     *            the map
     * @param principal
     *            the principal
     * @param request
     *            the request
     * @return the petition response
     */
    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String showHelp(Map<String, Object> map, Principal principal,
	    HttpServletRequest request) {
	String userMsg = "";
	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	}
	map.put("userMsg", userMsg);
	return "redirect:/help/user-main";
    }

    /**
     * Show section help URL.
     * 
     * @param map
     *            the map
     * @param principal
     *            the principal
     * @param request
     *            the request
     * @return the petition response
     */
    @RequestMapping(value = "/help/{section}", method = RequestMethod.GET)
    public String showDashboardHelp(@PathVariable("section") String section,
	    Map<String, Object> map, Principal principal,
	    HttpServletRequest request) {
	String userMsg = "";
	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	}
	map.put("userMsg", userMsg);
	map.put("section", section);
	return "helpTemplate";
    }

}
