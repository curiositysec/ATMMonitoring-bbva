.. java:import:: java.io InputStream

.. java:import:: java.util ArrayList

.. java:import:: java.util Collection

.. java:import:: java.util List

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate HibernateException

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.dao.UpsDAO

.. java:import:: com.ncr ATMMonitoring.handler.FileInDiskHandler

.. java:import:: com.ncr ATMMonitoring.parser.ups.ParseUPSChainBuilder

.. java:import:: com.ncr ATMMonitoring.parser.ups.dto.UPSInfo

.. java:import:: com.ncr ATMMonitoring.parser.ups.exception.NoParserFoundException

.. java:import:: com.ncr ATMMonitoring.parser.ups.exception.ParserException

.. java:import:: com.ncr ATMMonitoring.parser.ups.exception.XMLNotReadableException

.. java:import:: com.ncr ATMMonitoring.pojo.Ups

UpsServiceImpl
==============

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class UpsServiceImpl implements UpsService

   The Class UpsServiceImpl. Default implementation of the UpsService.

   :author: Otto Abreu

Methods
-------
deleteUPS
^^^^^^^^^

.. java:method:: @Override public void deleteUPS(int id)
   :outertype: UpsServiceImpl

storeUPSinfo
^^^^^^^^^^^^

.. java:method:: @Override public List<String> storeUPSinfo(List<String> xmlFiles)
   :outertype: UpsServiceImpl

storeUPSinfo
^^^^^^^^^^^^

.. java:method:: @Override public List<InputStream> storeUPSinfo(Collection<InputStream> xmlFiles)
   :outertype: UpsServiceImpl

storeUPSinfo
^^^^^^^^^^^^

.. java:method:: @Override public boolean storeUPSinfo(InputStream xmlFile)
   :outertype: UpsServiceImpl

storeUPSinfo
^^^^^^^^^^^^

.. java:method:: @Override public boolean storeUPSinfo(String xmlFile)
   :outertype: UpsServiceImpl

