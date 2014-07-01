.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.Installation

InstallationDAO
===============

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface InstallationDAO

   The Interface InstallationDAO. Dao with the operations for managing Installation Pojos.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addInstallation
^^^^^^^^^^^^^^^

.. java:method:: public void addInstallation(Installation installation)
   :outertype: InstallationDAO

   Adds the installation.

   :param installation: the installation

getInstallation
^^^^^^^^^^^^^^^

.. java:method:: public Installation getInstallation(Integer id)
   :outertype: InstallationDAO

   Gets the installation with the given id.

   :param id: the id
   :return: the installation, or null if it doesn't exist

listInstallations
^^^^^^^^^^^^^^^^^

.. java:method:: public List<Installation> listInstallations()
   :outertype: InstallationDAO

   Lists all installations.

   :return: the list

removeInstallation
^^^^^^^^^^^^^^^^^^

.. java:method:: public void removeInstallation(Integer id)
   :outertype: InstallationDAO

   Removes the installation with the given id.

   :param id: the id

updateInstallation
^^^^^^^^^^^^^^^^^^

.. java:method:: public void updateInstallation(Installation installation)
   :outertype: InstallationDAO

   Updates installation.

   :param installation: the installation

