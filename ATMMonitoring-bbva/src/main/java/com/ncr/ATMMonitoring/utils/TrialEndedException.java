package com.ncr.ATMMonitoring.utils;

/**
 * The TrialEnded exception.
 * 
 * Exception raised (and always internally caught and managed) when the software
 * trial period has reached its end.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */
public class TrialEndedException extends Exception {

    /** The serial field */
    private static final long serialVersionUID = 8973608074217634386L;

    /**
     * Constructor that simply accepts a message.
     * 
     * @param message
     *            the exception message
     */
    public TrialEndedException(String msg) {
	super(msg);
    }

    /**
     * Constructor that accepts both another Throwable (usually an Exception) as
     * the cause of the constructed one and a message.
     * 
     * @param message
     *            the exception message
     * @param exc
     *            the cause of this exception
     */
    public TrialEndedException(String msg, Exception e) {
	super(msg, e);
    }

}
