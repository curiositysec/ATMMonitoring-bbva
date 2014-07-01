QueueHandlerException
=====================

.. java:package:: com.ncr.ATMMonitoring.handler.exception
   :noindex:

.. java:type:: public class QueueHandlerException extends RuntimeException

   Exception that indicate an error while operating over the queue

   :author: Otto Abreu

Fields
------
DESTROY_ERROR
^^^^^^^^^^^^^

.. java:field:: public static final String DESTROY_ERROR
   :outertype: QueueHandlerException

   DESTROY_ERROR ="Can not destroy the queue due an IO error: ";

FILE_PATH_NOT_FOUND
^^^^^^^^^^^^^^^^^^^

.. java:field:: public static final String FILE_PATH_NOT_FOUND
   :outertype: QueueHandlerException

   FILE_PATH_NOT_FOUND = "Queue File Path not found, check the prioperty file for values: config.queue.filestore.path , and config.queue.file.name" ;

GENERAL_ERROR
^^^^^^^^^^^^^

.. java:field:: public static final String GENERAL_ERROR
   :outertype: QueueHandlerException

   GENERAL_ERROR ="A general error occurs while operating over the queue, exception: ";

NOT_AN_IP
^^^^^^^^^

.. java:field:: public static final String NOT_AN_IP
   :outertype: QueueHandlerException

   NOT_AN_IP ="The value that is trying to add is not a valid IPV4 or IPV6: value: ";

NULL_OPERATION_ERROR
^^^^^^^^^^^^^^^^^^^^

.. java:field:: public static final String NULL_OPERATION_ERROR
   :outertype: QueueHandlerException

   NULL_OPERATION = "This operation can not be made because the queue is null, either the load method was not called or it fails to load the queue."

READ_IO_ERROR
^^^^^^^^^^^^^

.. java:field:: public static final String READ_IO_ERROR
   :outertype: QueueHandlerException

   READ_IO_ERROR = "Can not read the queue due a IOException";

SAVE_IO_ERROR
^^^^^^^^^^^^^

.. java:field:: public static final String SAVE_IO_ERROR
   :outertype: QueueHandlerException

   SAVE_IO_ERROR = "Can not save the queue state due a IOException";

Constructors
------------
QueueHandlerException
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public QueueHandlerException(String message, Throwable cause)
   :outertype: QueueHandlerException

   Constructor that accepts both another Throwable (usually an Exception) as the cause of the constructed one and a message.

   :param message: the exception message
   :param cause: the cause of this exception

QueueHandlerException
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public QueueHandlerException(String message)
   :outertype: QueueHandlerException

   Constructor that simply accepts a message.

   :param message: the exception message

QueueHandlerException
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public QueueHandlerException(Throwable cause)
   :outertype: QueueHandlerException

   Constructor that accepts another Throwable (usually an Exception) as the cause of the constructed one.

   :param cause: the cause of this exception

