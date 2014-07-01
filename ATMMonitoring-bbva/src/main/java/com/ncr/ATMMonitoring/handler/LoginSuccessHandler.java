package com.ncr.ATMMonitoring.handler;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.access.WebInvocationPrivilegeEvaluator;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

/**
 * The handler LoginSuccessHandler.
 * 
 * Custom login success handler that sends user managers to the users management
 * page after login, and every other user to the dashboard.
 */
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    /**
     * Privilege evaluator for checking if the user has access to the original
     * page before redirecting.
     */
    @Autowired
    private WebInvocationPrivilegeEvaluator privilegeEvaluator;

    /** Servlet context we use for retrieving the context path. */
    @Autowired
    private ServletContext servletContext;

    /**
     * Request cache for retrieving the originally requested URL that required
     * logging in.
     */
    private RequestCache requestCache = new HttpSessionRequestCache();

    /** The users access allowed roles. */
    @Value("${security.usersAccessAllowedRoles}")
    private String usersAccessAllowedRoles;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.security.web.authentication.AuthenticationSuccessHandler
     * #onAuthenticationSuccess(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse,
     * org.springframework.security.core.Authentication)
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
	    HttpServletResponse response, Authentication authentication)
	    throws IOException, ServletException {

	SavedRequest savedRequest = requestCache.getRequest(request, response);
	String targetUrl = (savedRequest != null) ? savedRequest
		.getRedirectUrl() : null;
	String contextPath = servletContext.getContextPath();
	targetUrl = ((targetUrl != null) && (contextPath != null)) ? targetUrl
		.substring(targetUrl.indexOf(contextPath)
			+ contextPath.length()) : null;
	// If there was no originally requested URL, or the logged in user han
	// no access to it, we redirect it to the default page for its role
	if ((targetUrl == null)
		|| (!privilegeEvaluator.isAllowed(targetUrl, authentication))) {
	    Set<String> roles = AuthorityUtils
		    .authorityListToSet(authentication.getAuthorities());
	    for (String role : usersAccessAllowedRoles.split(",")) {
		if (roles.contains(role.replace("'", ""))) {
		    getRedirectStrategy().sendRedirect(request, response,
			    "/users");
		    return;
		}
	    }
	    getRedirectStrategy().sendRedirect(request, response, "/dashboard");
	    return;
	}

	clearAuthenticationAttributes(request);

	// Use the DefaultSavedRequest URL
	getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }

    public void setRequestCache(RequestCache requestCache) {
	this.requestCache = requestCache;
    }
}
