package com.ncr.ATMMonitoring.parser.exception;

/**
 * Indicates that the file cannot be processed by any parser found in the
 * classpath
 * 
 * @author Otto Abreu
 * 
 */
public class NoParserFoundException extends Exception {

    /**
     * NO_PARSER_FOUND =
     * "The given file can not be processed by any parser present in the classpath, check the configured parsers or add a new one to the classpath"
     * ;
     */
    public static final String NO_PARSER_FOUND = "The given file can not be processed by any parser present in the classpath, check the configured parsers or add a new one to the classpath, file:  \n";

    /**
     * NO_PARSERS_FOUND =
     * "The builder can not find parsers in the classpath, impossible to begin the process"
     * ;
     */
    public static final String NO_PARSERS_FOUND = "The builder can not find parsers in the classpath, impossible to begin the process";

    /**
     * The serial field
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor that simply accepts a message.
     * 
     * @param message
     *            the exception message
     */
    public NoParserFoundException(String message) {
	super(message);
    }

}
