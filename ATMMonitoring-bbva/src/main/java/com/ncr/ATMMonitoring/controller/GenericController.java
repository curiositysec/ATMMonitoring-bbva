package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.service.UserService;

/**
 * The class GenericController
 * 
 * Holds the common method between the controllers
 * 
 * @author Otto Abreu
 * 
 */
@Controller
public abstract class GenericController {

    /** The User service. */
    @Autowired
    private UserService userService;

    /** The user greeting session parameter id. */
    private static final String USER_GREETING = "userGreeting";

    /**
     * Obtains the greeting for the user from the current session (or from DB if
     * the session doesn't have it).
     * 
     * @param principal
     *            the user principal
     * @param request
     *            the http request
     * @return the greeting message
     */
    protected String getUserGreeting(Principal principal,
	    HttpServletRequest request) {

	String greeting = (String) request.getSession().getAttribute(
		USER_GREETING);

	if (greeting == null) {

	    User user = this.userService.getUserByUsername(principal.getName());
	    greeting = this.getUserGreetingFromUser(user, request);
	}
	return greeting;
    }

    /**
     * Obtains the greeting for the user from the current session (or from DB if
     * the session doesn't have it).
     * 
     * @param loggedUser
     *            the logged user
     * @param request
     *            the http request
     * @return the greeting message
     */
    protected String getUserGreeting(User loggedUser, HttpServletRequest request) {

	String greeting = (String) request.getSession().getAttribute(
		USER_GREETING);

	if (greeting == null) {

	    greeting = this.getUserGreetingFromUser(loggedUser, request);
	}
	return greeting;
    }

    /**
     * Clears a value from the session.
     * 
     * @param request
     *            the http request
     * @param sessionKey
     *            the value to clear
     */
    protected void clearSession(HttpServletRequest request, String sessionKey) {
	request.getSession().setAttribute(sessionKey, null);
    }

    /**
     * Obtains the greeting for the user from DB.
     * 
     * @param loggedUser
     *            the logged user
     * @param request
     *            the http request
     * @return the greeting message
     */
    private String getUserGreetingFromUser(User loggedUser,
	    HttpServletRequest request) {
	String greeting = "";
	Locale locale = RequestContextUtils.getLocale(request);
	greeting = loggedUser.getHtmlWelcomeMessage(locale);
	request.getSession().setAttribute(USER_GREETING, greeting);

	return greeting;
    }
}
