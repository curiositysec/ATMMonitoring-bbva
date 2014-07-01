package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The Class ExternalReportsController.
 */
@Controller
public class ExternalReportsController extends GenericController {

    /**
     * Request terminals update.
     * 
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     */
    @RequestMapping(value = "/externalreports", method = RequestMethod.GET)
    public void requestTerminalsUpdate(Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {

	String userMsg = "";
	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	}
	map.put("userMsg", userMsg);
	return;// "/externalreports.jsp";
    }
}