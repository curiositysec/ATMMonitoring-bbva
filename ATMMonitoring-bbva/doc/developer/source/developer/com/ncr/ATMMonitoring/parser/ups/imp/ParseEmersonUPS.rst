.. java:import:: java.io InputStream

.. java:import:: java.text ParseException

.. java:import:: java.text SimpleDateFormat

.. java:import:: java.util Date

.. java:import:: java.util.concurrent TimeUnit

.. java:import:: java.util.regex Matcher

.. java:import:: java.util.regex Pattern

.. java:import:: org.w3c.dom DOMException

.. java:import:: org.w3c.dom Element

.. java:import:: org.w3c.dom Node

.. java:import:: org.w3c.dom NodeList

.. java:import:: com.ncr ATMMonitoring.parser.ups.ParseUPSChainBuilder

.. java:import:: com.ncr ATMMonitoring.parser.ups.annotation.UPSParser

.. java:import:: com.ncr ATMMonitoring.parser.ups.dto.UPSInfo

.. java:import:: com.ncr ATMMonitoring.parser.ups.exception.NoParserFoundException

.. java:import:: com.ncr ATMMonitoring.parser.ups.exception.ParserException

.. java:import:: com.ncr ATMMonitoring.parser.ups.exception.XMLNotReadableException

ParseEmersonUPS
===============

.. java:package:: com.ncr.ATMMonitoring.parser.ups.imp
   :noindex:

.. java:type:: @UPSParser public class ParseEmersonUPS extends ParseUPSDom

   Class that parses an Emerson UPS XML with the following structure: <PK-C1-UPS>   <NUMPUESTO></NUMPUESTO>   <IP_UPS></IP_UPS>   <FIRMWARE_UPS></FIRMWARE_UPS>   <ESTADO_UPS></ESTADO_UPS>   <PORCENTAJE_CARGA_UPS></PORCENTAJE_CARGA_UPS>   <PORCENTAJE_GASTO_UPS></PORCENTAJE_GASTO_UPS>   <ALARMAS_UPS></ALARMAS_UPS>   <NOMBRE_UPS></NOMBRE_UPS>   <MODELO_UPS></MODELO_UPS>   <NUM_SERIE_UPS></NUM_SERIE_UPS>   <TIEMPO_ENCENDIDO_UPS></TIEMPO_ENCENDIDO_UPS>   <AUTONOMIA_UPS></AUTONOMIA_UPS>   <AUD_FMO_UPS></AUD_FMO_UPS>   <STATUS></STATUS>   <FECHA_ULTIMA_EJECUCION></FECHA_ULTIMA_EJECUCION> <PK-C1-UPSS> Do not call the parser directly, call

   :author: Otto Abreu

Methods
-------
applyParser
^^^^^^^^^^^

.. java:method:: @Override protected UPSInfo applyParser() throws ParserException, XMLNotReadableException, NoParserFoundException
   :outertype: ParseEmersonUPS

canParseXML
^^^^^^^^^^^

.. java:method:: @Override protected boolean canParseXML() throws ParserException, XMLNotReadableException
   :outertype: ParseEmersonUPS

