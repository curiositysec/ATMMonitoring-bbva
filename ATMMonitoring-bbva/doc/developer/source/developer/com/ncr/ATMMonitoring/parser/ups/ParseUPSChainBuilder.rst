.. java:import:: java.io IOException

.. java:import:: java.io InputStream

.. java:import:: java.lang.reflect Modifier

.. java:import:: java.net URL

.. java:import:: java.util ArrayList

.. java:import:: java.util Collection

.. java:import:: java.util List

.. java:import:: java.util Set

.. java:import:: org.apache.commons.collections CollectionUtils

.. java:import:: org.apache.commons.collections Predicate

.. java:import:: org.apache.log4j Logger

.. java:import:: org.reflections Reflections

.. java:import:: org.reflections.util ClasspathHelper

.. java:import:: org.reflections.util ConfigurationBuilder

.. java:import:: com.ncr ATMMonitoring.parser.ups.annotation.UPSParser

.. java:import:: com.ncr ATMMonitoring.parser.ups.dto.UPSInfo

.. java:import:: com.ncr ATMMonitoring.parser.ups.exception.NoParserFoundException

.. java:import:: com.ncr ATMMonitoring.parser.ups.exception.ParserException

.. java:import:: com.ncr ATMMonitoring.parser.ups.exception.XMLNotReadableException

ParseUPSChainBuilder
====================

.. java:package:: com.ncr.ATMMonitoring.parser.ups
   :noindex:

.. java:type:: public class ParseUPSChainBuilder

   Class that builds and executes the chain of responsibility of UPS Parsers  Is possible to add parsers just adding classes to the classpath, all the classes that extends from \ :java:ref:`ParseUPSXML`\  and are annotated with \ :java:ref:`UPSParser`\  will be added automatically The new classes can be added in jar format, is only required that all the new classes are in the classpath. To prioritize some classes in the chain use the annotation \ :java:ref:`UPSParser`\  with the value \ :java:ref:`UPSParser.HIGH_PRIORITY`\  as follows

   :author: Otto Abreu

Fields
------
logger
^^^^^^

.. java:field:: protected static final Logger logger
   :outertype: ParseUPSChainBuilder

   The logger.

Methods
-------
getInstance
^^^^^^^^^^^

.. java:method:: public static ParseUPSChainBuilder getInstance()
   :outertype: ParseUPSChainBuilder

   Returns a new instance of the class

   :return: ParseUPSChainBuilder

parse
^^^^^

.. java:method:: public static UPSInfo parse(InputStream xmlFile) throws ParserException, XMLNotReadableException, NoParserFoundException
   :outertype: ParseUPSChainBuilder

   Extract the information from the given xml in InputStream format

   :param xmlFile: \ :java:ref:`InputStream`\
   :return: \ :java:ref:`UPSInfo`\

