.. java:import:: java.util List

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.dao.OperatingSystemDAO

.. java:import:: com.ncr ATMMonitoring.pojo.OperatingSystem

OperatingSystemServiceImpl
==========================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class OperatingSystemServiceImpl implements OperatingSystemService

   The Class OperatingSystemServiceImpl. Default implementation of the OperatingSystemService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addOperatingSystem
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addOperatingSystem(OperatingSystem operatingSystem)
   :outertype: OperatingSystemServiceImpl

getOperatingSystem
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public OperatingSystem getOperatingSystem(Integer id)
   :outertype: OperatingSystemServiceImpl

listOperatingSystem
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<OperatingSystem> listOperatingSystem()
   :outertype: OperatingSystemServiceImpl

