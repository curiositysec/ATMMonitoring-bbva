.. java:import:: java.util List

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate Criteria

.. java:import:: org.hibernate.criterion Order

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.OperatingSystem

OperatingSystemDAOImpl
======================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class OperatingSystemDAOImpl extends AbstractGenericDAO<OperatingSystem> implements OperatingSystemDAO

   The Class OperatingSystemDAOImpl. Default implementation of OperatingSystemDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addOperatingSystem
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addOperatingSystem(OperatingSystem operatingSystem)
   :outertype: OperatingSystemDAOImpl

getOperatingSystem
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public OperatingSystem getOperatingSystem(Integer id)
   :outertype: OperatingSystemDAOImpl

listOperatingSystem
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<OperatingSystem> listOperatingSystem()
   :outertype: OperatingSystemDAOImpl

