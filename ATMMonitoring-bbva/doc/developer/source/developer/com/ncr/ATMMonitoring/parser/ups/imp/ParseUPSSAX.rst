.. java:import:: java.io IOException

.. java:import:: java.io InputStream

.. java:import:: javax.xml.parsers DocumentBuilder

.. java:import:: javax.xml.parsers ParserConfigurationException

.. java:import:: javax.xml.parsers SAXParser

.. java:import:: javax.xml.parsers SAXParserFactory

.. java:import:: org.xml.sax SAXException

.. java:import:: org.xml.sax.helpers DefaultHandler

.. java:import:: com.ncr ATMMonitoring.parser.ups.ParseUPSChainBuilder

.. java:import:: com.ncr ATMMonitoring.parser.ups.ParseUPSXML

.. java:import:: com.ncr ATMMonitoring.parser.ups.exception.ParserException

.. java:import:: com.ncr ATMMonitoring.parser.ups.exception.XMLNotReadableException

ParseUPSSAX
===========

.. java:package:: com.ncr.ATMMonitoring.parser.ups.imp
   :noindex:

.. java:type:: public abstract class ParseUPSSAX extends ParseUPSXML

   Class that defines a parse based on SAX Do not call the parser directly, call

   :author: Otto Abreu

Methods
-------
getDefaultHandler
^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract DefaultHandler getDefaultHandler()
   :outertype: ParseUPSSAX

   Holds the logic related to how parse the XML

   :return: \ :java:ref:`DefaultHandler`\

parse
^^^^^

.. java:method:: protected void parse(InputStream xmlFile) throws ParserException, XMLNotReadableException
   :outertype: ParseUPSSAX

   Executes the Parse method in the \ :java:ref:`SAXParser`\  The concrete class must implement the logic related to the

   :param xmlFile: InputStream

