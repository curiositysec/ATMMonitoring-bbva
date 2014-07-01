.. java:import:: java.util List

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate Criteria

.. java:import:: org.hibernate.criterion Order

.. java:import:: org.hibernate.criterion Restrictions

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.SoftwareAggregate

SoftwareAggregateDAOImpl
========================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class SoftwareAggregateDAOImpl extends AbstractGenericDAO<SoftwareAggregate> implements SoftwareAggregateDAO

   The Class SoftwareAggregateDAOImpl. Default implementation of SoftwareAggregateDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addSoftwareAggregate
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addSoftwareAggregate(SoftwareAggregate softwareAggregate)
   :outertype: SoftwareAggregateDAOImpl

getSoftwareAggregate
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public SoftwareAggregate getSoftwareAggregate(Integer id)
   :outertype: SoftwareAggregateDAOImpl

getSoftwareAggregateByVersionName
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public SoftwareAggregate getSoftwareAggregateByVersionName(Integer majorVersion, Integer minorVersion, Integer buildVersion, Integer revisionVersion, String remainingVersion, String name)
   :outertype: SoftwareAggregateDAOImpl

listSoftwareAggregate
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<SoftwareAggregate> listSoftwareAggregate()
   :outertype: SoftwareAggregateDAOImpl

removeSoftwareAggregate
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void removeSoftwareAggregate(Integer id)
   :outertype: SoftwareAggregateDAOImpl

