package com.ncr.ATMMonitoring.manager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.service.UserService;

/**
 * The Class RemoteAuthenticationManager.
 * 
 * Class in charge of the remote authentication by a simple username.
 */
@Component
public class RemoteAuthenticationManager implements AuthenticationManager {

    /** The logger. */
    static private Logger logger = Logger
	    .getLogger(RemoteAuthenticationManager.class.getName());

    /** The user service. */
    @Autowired
    private UserService userService;

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.authentication.AuthenticationManager#
     * authenticate(org.springframework.security.core.Authentication)
     */
    @Override
    public Authentication authenticate(Authentication authentication)
	    throws AuthenticationException {
	logger.debug("Remote login try with username "
		+ authentication.getName());
	try {
	    User user = userService
		    .loadUserByUsername(authentication.getName());
	    if (user != null) {
		logger.debug("Successful remote login try with username "
			+ authentication.getName());
		return new UsernamePasswordAuthenticationToken(
			authentication.getName(), "", user.getAuthorities());
	    }
	} catch (UsernameNotFoundException e) {
	}
	logger.info("Unsuccessful remote login try with username "
		+ authentication.getName());
	return null;
    }

    /**
     * Method in charge of a manual authentication process for a remote agent
     * via a simple username.
     * 
     * @param authentication
     *            the authentication token with just an username
     */
    public void fullAuthenticate(Authentication authentication) {
		SecurityContextHolder.getContext().setAuthentication(authenticate(authentication));
    }
}
