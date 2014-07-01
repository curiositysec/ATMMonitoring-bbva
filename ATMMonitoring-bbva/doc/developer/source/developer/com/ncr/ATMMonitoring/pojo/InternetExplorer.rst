.. java:import:: java.util Map

.. java:import:: java.util TreeMap

.. java:import:: javax.persistence Column

.. java:import:: javax.persistence Entity

.. java:import:: javax.persistence GeneratedValue

.. java:import:: javax.persistence GenerationType

.. java:import:: javax.persistence Id

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

.. java:import:: javax.persistence UniqueConstraint

.. java:import:: org.hibernate.annotations Type

.. java:import:: com.ncr ATMMonitoring.utils.Operation

.. java:import:: com.ncr.agent.baseData.os.module IExplorerPojo

InternetExplorer
================

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class InternetExplorer

   The InternetExplorer Pojo.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Constructors
------------
InternetExplorer
^^^^^^^^^^^^^^^^

.. java:constructor:: public InternetExplorer()
   :outertype: InternetExplorer

   Instantiates a new internet explorer.

InternetExplorer
^^^^^^^^^^^^^^^^

.. java:constructor:: public InternetExplorer(IExplorerPojo ie)
   :outertype: InternetExplorer

   Instantiates a new internet explorer with the given internet explorer data from the agent.

   :param ie: the ie

Methods
-------
equals
^^^^^^

.. java:method:: @Override public boolean equals(Object obj)
   :outertype: InternetExplorer

getBuildVersion
^^^^^^^^^^^^^^^

.. java:method:: public Integer getBuildVersion()
   :outertype: InternetExplorer

   Gets the builds the version.

   :return: the buildVersion

getComboboxes
^^^^^^^^^^^^^

.. java:method:: public static Map<String, Map> getComboboxes()
   :outertype: InternetExplorer

   Gets the comboboxes data for the query GUI.

   :return: the comboboxes data

getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: InternetExplorer

   Gets the id.

   :return: the id

getMajorVersion
^^^^^^^^^^^^^^^

.. java:method:: public Integer getMajorVersion()
   :outertype: InternetExplorer

   Gets the major version.

   :return: the majorVersion

getMinorVersion
^^^^^^^^^^^^^^^

.. java:method:: public Integer getMinorVersion()
   :outertype: InternetExplorer

   Gets the minor version.

   :return: the minorVersion

getRemainingVersion
^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getRemainingVersion()
   :outertype: InternetExplorer

   Gets the remaining version.

   :return: the remainingVersion

getRevisionVersion
^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getRevisionVersion()
   :outertype: InternetExplorer

   Gets the revision version.

   :return: the revisionVersion

getVersion
^^^^^^^^^^

.. java:method:: public String getVersion()
   :outertype: InternetExplorer

   Gets the whole version.

   :return: the version complete

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: InternetExplorer

setBuildVersion
^^^^^^^^^^^^^^^

.. java:method:: public void setBuildVersion(Integer buildVersion)
   :outertype: InternetExplorer

   Sets the builds the version.

   :param buildVersion: the buildVersion to set

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: InternetExplorer

   Sets the id.

   :param id: the id to set

setMajorVersion
^^^^^^^^^^^^^^^

.. java:method:: public void setMajorVersion(Integer majorVersion)
   :outertype: InternetExplorer

   Sets the major version.

   :param majorVersion: the majorVersion to set

setMinorVersion
^^^^^^^^^^^^^^^

.. java:method:: public void setMinorVersion(Integer minorVersion)
   :outertype: InternetExplorer

   Sets the minor version.

   :param minorVersion: the minorVersion to set

setRemainingVersion
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setRemainingVersion(String remainingVersion)
   :outertype: InternetExplorer

   Sets the remaining version.

   :param remainingVersion: the remainingVersion to set

setRevisionVersion
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setRevisionVersion(Integer revisionVersion)
   :outertype: InternetExplorer

   Sets the revision version.

   :param revisionVersion: the revisionVersion to set

setVersion
^^^^^^^^^^

.. java:method:: public void setVersion(String version)
   :outertype: InternetExplorer

   Sets the version.

   :param version: the complete version to set

