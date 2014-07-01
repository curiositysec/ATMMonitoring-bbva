package com.ncr.ATMMonitoring.socket;

/**
 * The Class ATMWrongDataException.
 * 
 * This exception is thrown when data received from an ATM's agent is invalid
 * for our model.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class ATMWrongDataException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8600512565515109648L;

    /**
     * Instantiates a new ATM wrong data exception.
     * 
     * @param message
     *            the message
     */
    public ATMWrongDataException(String message) {
	super(message);
    }
}
