.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.Installation

InstallationService
===================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface InstallationService

   The Interface InstallationService. It contains the installation related methods.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addInstallation
^^^^^^^^^^^^^^^

.. java:method:: public void addInstallation(Installation installation)
   :outertype: InstallationService

   Adds the installation.

   :param installation: the installation

getInstallation
^^^^^^^^^^^^^^^

.. java:method:: public Installation getInstallation(Integer id)
   :outertype: InstallationService

   Gets the installation by its id.

   :param id: the installation id
   :return: the installation

listInstallations
^^^^^^^^^^^^^^^^^

.. java:method:: public List<Installation> listInstallations()
   :outertype: InstallationService

   List installations.

   :return: the installation list

removeInstallation
^^^^^^^^^^^^^^^^^^

.. java:method:: public void removeInstallation(Integer id)
   :outertype: InstallationService

   Removes the installation by its id.

   :param id: the installation id

updateInstallation
^^^^^^^^^^^^^^^^^^

.. java:method:: public void updateInstallation(Installation installation)
   :outertype: InstallationService

   Update installation.

   :param installation: the installation

