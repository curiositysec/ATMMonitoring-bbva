.. java:import:: java.util List

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.dao.SoftwareDAO

.. java:import:: com.ncr ATMMonitoring.pojo.Software

SoftwareServiceImpl
===================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class SoftwareServiceImpl implements SoftwareService

   The Class SoftwareServiceImpl. Default implementation of the SoftwareService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addSoftware
^^^^^^^^^^^

.. java:method:: @Override public void addSoftware(Software software)
   :outertype: SoftwareServiceImpl

getSoftware
^^^^^^^^^^^

.. java:method:: @Override public Software getSoftware(Integer id)
   :outertype: SoftwareServiceImpl

getSoftwareByIdentifyingNumber
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Software getSoftwareByIdentifyingNumber(String id)
   :outertype: SoftwareServiceImpl

listSoftware
^^^^^^^^^^^^

.. java:method:: @Override public List<Software> listSoftware()
   :outertype: SoftwareServiceImpl

