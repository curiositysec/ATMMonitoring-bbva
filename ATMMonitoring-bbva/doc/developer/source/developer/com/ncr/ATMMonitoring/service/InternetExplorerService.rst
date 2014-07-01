.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.InternetExplorer

InternetExplorerService
=======================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface InternetExplorerService

   The Interface InternetExplorerService. It contains the Internet Explorer related methods.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addInternetExplorer
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addInternetExplorer(InternetExplorer internetExplorer)
   :outertype: InternetExplorerService

   Adds the internet explorer.

   :param internetExplorer: the internet explorer

getInternetExplorer
^^^^^^^^^^^^^^^^^^^

.. java:method:: public InternetExplorer getInternetExplorer(Integer id)
   :outertype: InternetExplorerService

   Gets the internet explorer by its id.

   :param id: the internet explorer id
   :return: the internet explorer

getInternetExplorerByVersion
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public InternetExplorer getInternetExplorerByVersion(Integer majorVersion, Integer minorVersion, Integer buildVersion, Integer revisionVersion, String remainingVersion)
   :outertype: InternetExplorerService

   Gets the internet explorer by version.

   :param majorVersion: the major version
   :param minorVersion: the minor version
   :param buildVersion: the build version
   :param revisionVersion: the revision version
   :param remainingVersion: the remaining version
   :return: the internet explorer by version

listInternetExplorer
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<InternetExplorer> listInternetExplorer()
   :outertype: InternetExplorerService

   List internet explorer.

   :return: the internet explorer list

removeInternetExplorer
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void removeInternetExplorer(Integer id)
   :outertype: InternetExplorerService

   Removes the internet explorer by its id.

   :param id: the internet explorer id

