XMLNotReadableException
=======================

.. java:package:: com.ncr.ATMMonitoring.parser.ups.exception
   :noindex:

.. java:type:: public class XMLNotReadableException extends Exception

   Indicates that the XML can not be read by the parser

   :author: Otto Abreu

Fields
------
IO_ERROR
^^^^^^^^

.. java:field:: public static final String IO_ERROR
   :outertype: XMLNotReadableException

   IO_ERROR = "Can not read the XML due an IO error";

PARSE_ELEMENT_ERROR
^^^^^^^^^^^^^^^^^^^

.. java:field:: public static final String PARSE_ELEMENT_ERROR
   :outertype: XMLNotReadableException

   PARSE_ELEMENT_ERROR = "A element of the XML does not have the expected format value and can not be read" ;

PARSE_ERROR
^^^^^^^^^^^

.. java:field:: public static final String PARSE_ERROR
   :outertype: XMLNotReadableException

   PARSE_ERROR = "Can not parse the XML due an error while reading the file (SAXExeption) " ;

Constructors
------------
XMLNotReadableException
^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public XMLNotReadableException(String arg0)
   :outertype: XMLNotReadableException

   :param arg0:

XMLNotReadableException
^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public XMLNotReadableException(Throwable arg0)
   :outertype: XMLNotReadableException

   :param arg0:

XMLNotReadableException
^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public XMLNotReadableException(String arg0, Throwable arg1)
   :outertype: XMLNotReadableException

   :param arg0:
   :param arg1:

