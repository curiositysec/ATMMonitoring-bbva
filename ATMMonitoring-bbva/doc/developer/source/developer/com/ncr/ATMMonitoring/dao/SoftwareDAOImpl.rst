.. java:import:: java.util List

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate Criteria

.. java:import:: org.hibernate.criterion Order

.. java:import:: org.hibernate.criterion Restrictions

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.Software

SoftwareDAOImpl
===============

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class SoftwareDAOImpl extends AbstractGenericDAO<Software> implements SoftwareDAO

   The Class SoftwareDAOImpl. Default implementation of SoftwareDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addSoftware
^^^^^^^^^^^

.. java:method:: @Override public void addSoftware(Software software)
   :outertype: SoftwareDAOImpl

getSoftware
^^^^^^^^^^^

.. java:method:: @Override public Software getSoftware(Integer id)
   :outertype: SoftwareDAOImpl

getSoftwareByIdentifyingNumber
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Software getSoftwareByIdentifyingNumber(String id)
   :outertype: SoftwareDAOImpl

listSoftware
^^^^^^^^^^^^

.. java:method:: @Override public List<Software> listSoftware()
   :outertype: SoftwareDAOImpl

