.. java:import:: java.util List

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.dao.InstallationDAO

.. java:import:: com.ncr ATMMonitoring.pojo.Installation

InstallationServiceImpl
=======================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class InstallationServiceImpl implements InstallationService

   The Class InstallationServiceImpl. Default implementation of the InstallationService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addInstallation
^^^^^^^^^^^^^^^

.. java:method:: @Override public void addInstallation(Installation role)
   :outertype: InstallationServiceImpl

getInstallation
^^^^^^^^^^^^^^^

.. java:method:: @Override public Installation getInstallation(Integer id)
   :outertype: InstallationServiceImpl

listInstallations
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Installation> listInstallations()
   :outertype: InstallationServiceImpl

removeInstallation
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void removeInstallation(Integer id)
   :outertype: InstallationServiceImpl

updateInstallation
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void updateInstallation(Installation installation)
   :outertype: InstallationServiceImpl

