.. java:import:: com.ncr ATMMonitoring.handler.FileInDiskHandler

FileHandlerException
====================

.. java:package:: com.ncr.ATMMonitoring.handler.exception
   :noindex:

.. java:type:: public class FileHandlerException extends RuntimeException

   Indicates an error while performing an operation in the \ :java:ref:`FileInDiskHandler`\

   :author: Otto Abreu

Fields
------
DELETE_ERROR
^^^^^^^^^^^^

.. java:field:: public static final String DELETE_ERROR
   :outertype: FileHandlerException

   DELETE_ERROR ="Can not execute the delete operation for file: ";

FILE_EXTENSION_ERROR
^^^^^^^^^^^^^^^^^^^^

.. java:field:: public static final String FILE_EXTENSION_ERROR
   :outertype: FileHandlerException

   FILE_EXTENSION_ERROR = "The given file extension do not match ^(\\.[a-zA-Z0-9]{2,5})$ : ";

GET_INPUTSTREAM_ERROR
^^^^^^^^^^^^^^^^^^^^^

.. java:field:: public static final String GET_INPUTSTREAM_ERROR
   :outertype: FileHandlerException

   GET_INPUTSTREAM_ERROR ="Can not get the inputstream for file: ";

MOVE_ERROR
^^^^^^^^^^

.. java:field:: public static final String MOVE_ERROR
   :outertype: FileHandlerException

   MOVE_ERROR = "Can not execute the move/copy operation for file and dir : ";

MOVE_NULL_ERROR
^^^^^^^^^^^^^^^

.. java:field:: public static final String MOVE_NULL_ERROR
   :outertype: FileHandlerException

   MOVE_NULL_ERROR = "Can not execute the move/copy operation because file or dir are null: " ;

NOT_A_VALID_FILE_FOLDER
^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: public static final String NOT_A_VALID_FILE_FOLDER
   :outertype: FileHandlerException

   NOT_A_VALID_FILE_FOLDER= "One of the given params is not a file or a folder: ";

TOUCH_ERROR
^^^^^^^^^^^

.. java:field:: public static final String TOUCH_ERROR
   :outertype: FileHandlerException

   TOUCH_ERROR ="Can not execute the touch operation for file:";

Constructors
------------
FileHandlerException
^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public FileHandlerException(String message, Throwable cause)
   :outertype: FileHandlerException

   Constructor that accepts both another Throwable (usually an Exception) as the cause of the constructed one and a message.

   :param message: the exception message
   :param exc: the cause of this exception

FileHandlerException
^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public FileHandlerException(String message)
   :outertype: FileHandlerException

   Constructor that simply accepts a message.

   :param message: the exception message

