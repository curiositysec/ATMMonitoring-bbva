ParserException
===============

.. java:package:: com.ncr.ATMMonitoring.parser.ups.exception
   :noindex:

.. java:type:: public class ParserException extends Exception

   Indicates that some error (unrelated to the read process) happened while executing the parsing operation

   :author: Otto Abreu

Fields
------
GENERAL_ERROR
^^^^^^^^^^^^^

.. java:field:: public static final String GENERAL_ERROR
   :outertype: ParserException

   GENERAL_ERROR = "Can not continue with the parse operation due a general error: ";

PARSER_CONFIGURATION_ERROR
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: public static final String PARSER_CONFIGURATION_ERROR
   :outertype: ParserException

   DOCUMENT_BUILDER_ERROR = "Can not get the document builder, the file will not be parsed";

Constructors
------------
ParserException
^^^^^^^^^^^^^^^

.. java:constructor:: public ParserException(String message)
   :outertype: ParserException

   Constructor that simply accepts a message.

   :param message: the exception message

ParserException
^^^^^^^^^^^^^^^

.. java:constructor:: public ParserException(Throwable exc)
   :outertype: ParserException

   Constructor that accepts another Throwable (usually an Exception) as the cause of the constructed one.

   :param exc: the cause of this exception

ParserException
^^^^^^^^^^^^^^^

.. java:constructor:: public ParserException(String message, Throwable exc)
   :outertype: ParserException

   Constructor that accepts both another Throwable (usually an Exception) as the cause of the constructed one and a message.

   :param message: the exception message
   :param exc: the cause of this exception

