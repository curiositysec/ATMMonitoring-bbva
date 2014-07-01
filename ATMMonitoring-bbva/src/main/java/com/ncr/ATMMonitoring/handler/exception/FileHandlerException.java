package com.ncr.ATMMonitoring.handler.exception;

import com.ncr.ATMMonitoring.handler.FileInDiskHandler;

/**
 * Indicates an error while performing an operation in the
 * {@link FileInDiskHandler}
 * 
 * @author Otto Abreu
 * 
 */
public class FileHandlerException extends RuntimeException {

    /** The serial id */
    private static final long serialVersionUID = 7451665440382160410L;

    /**
     * GET_INPUTSTREAM_ERROR ="Can not get the inputstream for file: ";
     */
    public static final String GET_INPUTSTREAM_ERROR = "Can not get the inputstream for file: ";

    /**
     * TOUCH_ERROR ="Can not execute the touch operation  for file:";
     */
    public static final String TOUCH_ERROR = "Can not execute the touch operation for file: ";

    /**
     * DELETE_ERROR ="Can not execute the delete operation for file: ";
     */
    public static final String DELETE_ERROR = "Can not execute the delete operation for file: ";

    /**
     * FILE_EXTENSION_ERROR =
     * "The given file extension do not match ^(\\.[a-zA-Z0-9]{2,5})$ : ";
     */
    public static final String FILE_EXTENSION_ERROR = "The given file extension do not match ^(\\.[a-zA-Z0-9]{2,5})$ : ";

    /**
     * MOVE_ERROR =
     * "Can not execute the move/copy operation for file and dir : ";
     */
    public static final String MOVE_ERROR = "Can not execute the move/copy operation for file and dir : ";

    /**
     * MOVE_NULL_ERROR =
     * "Can not execute the move/copy operation  because file or dir are null: "
     * ;
     */
    public static final String MOVE_NULL_ERROR = "Can not execute the move/copy operation  because file or dir are null: ";

    /**
     * NOT_A_VALID_FILE_FOLDER=
     * "One of the given params is not a file or a folder: ";
     */
    public static final String NOT_A_VALID_FILE_FOLDER = "One of the given params is not a file or a folder: ";

    /**
     * Constructor that accepts both another Throwable (usually an Exception) as
     * the cause of the constructed one and a message.
     * 
     * @param message
     *            the exception message
     * @param exc
     *            the cause of this exception
     */
    public FileHandlerException(String message, Throwable cause) {
	super(message, cause);
    }

    /**
     * Constructor that simply accepts a message.
     * 
     * @param message
     *            the exception message
     */
    public FileHandlerException(String message) {
	super(message);
    }

}
