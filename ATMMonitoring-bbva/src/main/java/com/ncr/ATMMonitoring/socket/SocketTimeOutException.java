package com.ncr.ATMMonitoring.socket;

import java.util.HashSet;
import java.util.Set;

/**
 * The Class SocketTimeOutException.
 * 
 * Exception thrown when we receive no response in the expected time during
 * socket communication.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class SocketTimeOutException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2908900346083264402L;

    /** The ips. */
    protected Set<String> ips = new HashSet<String>();

    /**
     * Instantiates a new socket time out exception.
     * 
     * @param string
     *            the ip that raised the timeout
     */
    public SocketTimeOutException(String string) {
	super();
	ips.add(string);
    }

    /**
     * Instantiates a new socket time out exception.
     * 
     * @param strings
     *            the ips that raised the timeout
     */
    public SocketTimeOutException(Set<String> strings) {
	super();
	ips = strings;
    }

    /**
     * Gets the ips list as html code.
     * 
     * @return the ips list
     */
    public String getIpsHtmlList() {
	String ipList = "";
	for (String ip : ips) {
	    ipList += "<br>" + ip;
	}
	return ipList.replaceFirst("<br>", "");
    }

    /**
     * Gets the ips list.
     * 
     * @return the ips list
     */
    public Set<String> getIps() {
	return ips;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Throwable#getMessage()
     */
    public String getMessage() {
	return "Timeout expired for answer from Terminals with IPs "
		+ ips.toString();
    }

}
