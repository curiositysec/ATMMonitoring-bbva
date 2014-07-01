.. java:import:: java.util Map

.. java:import:: java.util TreeMap

.. java:import:: javax.persistence Column

.. java:import:: javax.persistence Entity

.. java:import:: javax.persistence GeneratedValue

.. java:import:: javax.persistence GenerationType

.. java:import:: javax.persistence Id

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

.. java:import:: org.hibernate.annotations Type

.. java:import:: com.ncr ATMMonitoring.utils.Operation

.. java:import:: com.ncr.agent.baseData.os.module OperatingSystemPojo

OperatingSystem
===============

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class OperatingSystem

   The OperatingSystem Pojo.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Constructors
------------
OperatingSystem
^^^^^^^^^^^^^^^

.. java:constructor:: public OperatingSystem()
   :outertype: OperatingSystem

   Instantiates a new operating system.

OperatingSystem
^^^^^^^^^^^^^^^

.. java:constructor:: public OperatingSystem(OperatingSystemPojo os)
   :outertype: OperatingSystem

   Instantiates a new operating system with the given operating system data from the agent.

   :param os: the os

Methods
-------
equals
^^^^^^

.. java:method:: @Override public boolean equals(Object obj)
   :outertype: OperatingSystem

getBuildVersion
^^^^^^^^^^^^^^^

.. java:method:: public Integer getBuildVersion()
   :outertype: OperatingSystem

   Gets the builds the version.

   :return: the buildVersion

getComboboxes
^^^^^^^^^^^^^

.. java:method:: public static Map<String, Map> getComboboxes()
   :outertype: OperatingSystem

   Gets the comboboxes data for the query GUI.

   :return: the comboboxes data

getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: OperatingSystem

   Gets the id.

   :return: the id

getMajorVersion
^^^^^^^^^^^^^^^

.. java:method:: public Integer getMajorVersion()
   :outertype: OperatingSystem

   Gets the major version.

   :return: the majorVersion

getManufacturer
^^^^^^^^^^^^^^^

.. java:method:: public String getManufacturer()
   :outertype: OperatingSystem

   Gets the manufacturer.

   :return: the manufacturer

getMinorVersion
^^^^^^^^^^^^^^^

.. java:method:: public Integer getMinorVersion()
   :outertype: OperatingSystem

   Gets the minor version.

   :return: the minorVersion

getName
^^^^^^^

.. java:method:: public String getName()
   :outertype: OperatingSystem

   Gets the name.

   :return: the name

getNameVersion
^^^^^^^^^^^^^^

.. java:method:: public String getNameVersion()
   :outertype: OperatingSystem

   Gets the name version.

   :return: the name and version concatenated

getOrganization
^^^^^^^^^^^^^^^

.. java:method:: public String getOrganization()
   :outertype: OperatingSystem

   Gets the organization.

   :return: the organization

getOsLanguage
^^^^^^^^^^^^^

.. java:method:: public String getOsLanguage()
   :outertype: OperatingSystem

   Gets the os language.

   :return: the oSLanguage

getOsType
^^^^^^^^^

.. java:method:: public String getOsType()
   :outertype: OperatingSystem

   Gets the os type.

   :return: the oSType

getRemainingVersion
^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getRemainingVersion()
   :outertype: OperatingSystem

   Gets the remaining version.

   :return: the remainingVersion

getRevisionVersion
^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getRevisionVersion()
   :outertype: OperatingSystem

   Gets the revision version.

   :return: the revisionVersion

getSerialNumber
^^^^^^^^^^^^^^^

.. java:method:: public String getSerialNumber()
   :outertype: OperatingSystem

   Gets the serial number.

   :return: the serialNumber

getServicePackBuildVersion
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getServicePackBuildVersion()
   :outertype: OperatingSystem

   Gets the service pack build version.

   :return: the servicePackBuildVersion

getServicePackMajorVersion
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getServicePackMajorVersion()
   :outertype: OperatingSystem

   Gets the service pack major version.

   :return: the servicePackMajorVersion

getServicePackMinorVersion
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getServicePackMinorVersion()
   :outertype: OperatingSystem

   Gets the service pack minor version.

   :return: the servicePackMinorVersion

getServicePackRemainingVersion
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getServicePackRemainingVersion()
   :outertype: OperatingSystem

   Gets the service pack remaining version.

   :return: the servicePackRemainingVersion

getServicePackRevisionVersion
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getServicePackRevisionVersion()
   :outertype: OperatingSystem

   Gets the service pack revision version.

   :return: the servicePackRevisionVersion

getServicePackVersion
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getServicePackVersion()
   :outertype: OperatingSystem

   Gets the service pack version.

   :return: the Service Pack version complete

getVersion
^^^^^^^^^^

.. java:method:: public String getVersion()
   :outertype: OperatingSystem

   Gets the version.

   :return: the version complete

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: OperatingSystem

setBuildVersion
^^^^^^^^^^^^^^^

.. java:method:: public void setBuildVersion(Integer buildVersion)
   :outertype: OperatingSystem

   Sets the builds the version.

   :param buildVersion: the buildVersion to set

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: OperatingSystem

   Sets the id.

   :param id: the id to set

setMajorVersion
^^^^^^^^^^^^^^^

.. java:method:: public void setMajorVersion(Integer majorVersion)
   :outertype: OperatingSystem

   Sets the major version.

   :param majorVersion: the majorVersion to set

setManufacturer
^^^^^^^^^^^^^^^

.. java:method:: public void setManufacturer(String manufacturer)
   :outertype: OperatingSystem

   Sets the manufacturer.

   :param manufacturer: the manufacturer to set

setMinorVersion
^^^^^^^^^^^^^^^

.. java:method:: public void setMinorVersion(Integer minorVersion)
   :outertype: OperatingSystem

   Sets the minor version.

   :param minorVersion: the minorVersion to set

setName
^^^^^^^

.. java:method:: public void setName(String name)
   :outertype: OperatingSystem

   Sets the name.

   :param name: the name to set

setOrganization
^^^^^^^^^^^^^^^

.. java:method:: public void setOrganization(String organization)
   :outertype: OperatingSystem

   Sets the organization.

   :param organization: the organization to set

setOsLanguage
^^^^^^^^^^^^^

.. java:method:: public void setOsLanguage(String oSLanguage)
   :outertype: OperatingSystem

   Sets the os language.

   :param oSLanguage: the oSLanguage to set

setOsType
^^^^^^^^^

.. java:method:: public void setOsType(String oSType)
   :outertype: OperatingSystem

   Sets the os type.

   :param oSType: the oSType to set

setRemainingVersion
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setRemainingVersion(String remainingVersion)
   :outertype: OperatingSystem

   Sets the remaining version.

   :param remainingVersion: the remainingVersion to set

setRevisionVersion
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setRevisionVersion(Integer revisionVersion)
   :outertype: OperatingSystem

   Sets the revision version.

   :param revisionVersion: the revisionVersion to set

setSerialNumber
^^^^^^^^^^^^^^^

.. java:method:: public void setSerialNumber(String serialNumber)
   :outertype: OperatingSystem

   Sets the serial number.

   :param serialNumber: the serialNumber to set

setServicePackBuildVersion
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setServicePackBuildVersion(Integer servicePackBuildVersion)
   :outertype: OperatingSystem

   Sets the service pack build version.

   :param servicePackBuildVersion: the servicePackBuildVersion to set

setServicePackMajorVersion
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setServicePackMajorVersion(Integer servicePackMajorVersion)
   :outertype: OperatingSystem

   Sets the service pack major version.

   :param servicePackMajorVersion: the servicePackMajorVersion to set

setServicePackMinorVersion
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setServicePackMinorVersion(Integer servicePackMinorVersion)
   :outertype: OperatingSystem

   Sets the service pack minor version.

   :param servicePackMinorVersion: the servicePackMinorVersion to set

setServicePackRemainingVersion
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setServicePackRemainingVersion(String servicePackRemainingVersion)
   :outertype: OperatingSystem

   Sets the service pack remaining version.

   :param servicePackRemainingVersion: the servicePackRemainingVersion to set

setServicePackRevisionVersion
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setServicePackRevisionVersion(Integer servicePackRevisionVersion)
   :outertype: OperatingSystem

   Sets the service pack revision version.

   :param servicePackRevisionVersion: the servicePackRevisionVersion to set

setServicePackVersion
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setServicePackVersion(String version)
   :outertype: OperatingSystem

   Sets the service pack version.

   :param version: the complete Service Pack version to set

setVersion
^^^^^^^^^^

.. java:method:: public void setVersion(String version)
   :outertype: OperatingSystem

   Sets the version.

   :param version: the complete version to set

