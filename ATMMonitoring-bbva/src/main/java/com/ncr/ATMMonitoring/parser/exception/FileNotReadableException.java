package com.ncr.ATMMonitoring.parser.exception;

/**
 * Indicates that the file can not be read by the parser
 * 
 * @author Otto Abreu
 * 
 */
public class FileNotReadableException extends Exception {

    /**
     * The serial field
     */
    private static final long serialVersionUID = 573882647940391413L;

    /**
     * IO_ERROR = "Can not read the file due an IO error";
     */
    public static final String IO_ERROR = "Can not read the File due an IO error";

    /**
     * PARSE_ERROR =
     * "Can not parse the file due an error while reading the file (SAXExeption) "
     * ;
     */
    public static final String PARSE_ERROR = "Can not parse the file due an error while reading the file (SAXExeption) ";

    /**
     * PARSE_ELEMENT_ERROR =
     * "A element of the file does not have the expected format value and can not be read"
     * ;
     */
    public static final String PARSE_ELEMENT_ERROR = "A element of the file does not have the expected format value and can not be read ";
    
    /**
     * FILE_NOT_FOUND ="Can not find the file with the given path: ";
     */
    public static final String FILE_NOT_FOUND ="Can not find the file with the given path: ";

    /**
     * @param arg0
     */
    public FileNotReadableException(String arg0) {
	super(arg0);
	// TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     */
    public FileNotReadableException(Throwable arg0) {
	super(arg0);
	// TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     * @param arg1
     */
    public FileNotReadableException(String arg0, Throwable arg1) {
	super(arg0, arg1);
	// TODO Auto-generated constructor stub
    }

}
