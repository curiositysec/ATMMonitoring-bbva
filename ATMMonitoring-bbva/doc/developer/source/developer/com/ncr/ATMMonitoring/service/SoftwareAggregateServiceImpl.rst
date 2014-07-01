.. java:import:: java.util List

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.dao.SoftwareAggregateDAO

.. java:import:: com.ncr ATMMonitoring.pojo.SoftwareAggregate

SoftwareAggregateServiceImpl
============================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class SoftwareAggregateServiceImpl implements SoftwareAggregateService

   The Class SoftwareAggregateServiceImpl. Default implementation of the SoftwareAggregateService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addSoftwareAggregate
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addSoftwareAggregate(SoftwareAggregate softwareAggregate)
   :outertype: SoftwareAggregateServiceImpl

getSoftwareAggregate
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public SoftwareAggregate getSoftwareAggregate(Integer id)
   :outertype: SoftwareAggregateServiceImpl

getSoftwareAggregateByVersionName
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public SoftwareAggregate getSoftwareAggregateByVersionName(Integer majorVersion, Integer minorVersion, Integer buildVersion, Integer revisionVersion, String remainingVersion, String name)
   :outertype: SoftwareAggregateServiceImpl

listSoftwareAggregate
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<SoftwareAggregate> listSoftwareAggregate()
   :outertype: SoftwareAggregateServiceImpl

removeSoftwareAggregate
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void removeSoftwareAggregate(Integer id)
   :outertype: SoftwareAggregateServiceImpl

