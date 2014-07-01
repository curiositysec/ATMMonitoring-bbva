package com.ncr.ATMMonitoring.handler.exception;

/**
 * Exception that indicate an error while operating over the queue
 * 
 * @author Otto Abreu
 * 
 */
public class QueueHandlerException extends RuntimeException {

    /** The serial id */
    private static final long serialVersionUID = 6407955972290438414L;

    /**
     * NULL_OPERATION =
     * "This operation can not be made because the queue is null, either the load method was not called or it fails to load the queue."
     */
    public static final String NULL_OPERATION_ERROR = "This operation can not be made because the queue is null, either the load method was not called or it fails to load the queue.";

    /**
     * FILE_PATH_NOT_FOUND =
     * "Queue File Path not found, check the prioperty file for values: config.queue.filestore.path , and config.queue.file.name"
     * ;
     */
    public static final String FILE_PATH_NOT_FOUND = "Queue File Path not found, check the prioperty file for values: config.queue.filestore.path , and config.queue.file.name";

    /**
     * SAVE_IO_ERROR = "Can not save the queue state due a IOException";
     */
    public static final String SAVE_IO_ERROR = "Can not save the queue state due a IOException";

    /**
     * READ_IO_ERROR = "Can not read the queue  due a IOException";
     */
    public static final String READ_IO_ERROR = "Can not read the queue  due a IOException";

    /**
     * GENERAL_ERROR
     * ="A general error occurs while operating over the queue, exception: ";
     */
    public static final String GENERAL_ERROR = "A general error occurs while operating over the queue, exception: ";

    /**
     * NOT_AN_IP
     * ="The value that is trying to add is not a valid IPV4 or IPV6: value: ";
     */
    public static final String NOT_AN_IP = "The value that is trying to add is not a valid IPV4 or IPV6: value: ";

    /**
     * DESTROY_ERROR ="Can not destroy the queue due an IO error: ";
     */
    public static final String DESTROY_ERROR = "Can not destroy the queue due an IO error: ";

    /**
     * Constructor that accepts both another Throwable (usually an Exception) as
     * the cause of the constructed one and a message.
     * 
     * @param message
     *            the exception message
     * @param cause
     *            the cause of this exception
     */
    public QueueHandlerException(String message, Throwable cause) {
	super(message, cause);
    }

    /**
     * Constructor that simply accepts a message.
     * 
     * @param message
     *            the exception message
     */
    public QueueHandlerException(String message) {
	super(message);
    }

    /**
     * Constructor that accepts another Throwable (usually an Exception) as the
     * cause of the constructed one.
     * 
     * @param cause
     *            the cause of this exception
     */
    public QueueHandlerException(Throwable cause) {
	super(cause);
    }

}
