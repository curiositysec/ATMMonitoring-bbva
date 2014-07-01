.. java:import:: javax.persistence Column

.. java:import:: javax.persistence Entity

.. java:import:: javax.persistence GeneratedValue

.. java:import:: javax.persistence GenerationType

.. java:import:: javax.persistence Id

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

.. java:import:: javax.persistence UniqueConstraint

.. java:import:: org.hibernate.annotations Type

.. java:import:: com.ncr.agent.baseData.vendor.utils FinancialPackagePojo

SoftwareAggregate
=================

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class SoftwareAggregate

   The SoftwareAggregate Pojo.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Constructors
------------
SoftwareAggregate
^^^^^^^^^^^^^^^^^

.. java:constructor:: public SoftwareAggregate()
   :outertype: SoftwareAggregate

   Instantiates a new software aggregate.

SoftwareAggregate
^^^^^^^^^^^^^^^^^

.. java:constructor:: public SoftwareAggregate(FinancialPackagePojo pkg)
   :outertype: SoftwareAggregate

   Instantiates a new software aggregate with the given software aggregate data from the agent.

   :param pkg: the pkg

Methods
-------
equals
^^^^^^

.. java:method:: @Override public boolean equals(Object obj)
   :outertype: SoftwareAggregate

getBuildVersion
^^^^^^^^^^^^^^^

.. java:method:: public Integer getBuildVersion()
   :outertype: SoftwareAggregate

   Gets the builds the version.

   :return: the buildVersion

getDescription
^^^^^^^^^^^^^^

.. java:method:: public String getDescription()
   :outertype: SoftwareAggregate

   Gets the description.

   :return: the description

getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: SoftwareAggregate

   Gets the id.

   :return: the id

getMajorVersion
^^^^^^^^^^^^^^^

.. java:method:: public Integer getMajorVersion()
   :outertype: SoftwareAggregate

   Gets the major version.

   :return: the majorVersion

getMinorVersion
^^^^^^^^^^^^^^^

.. java:method:: public Integer getMinorVersion()
   :outertype: SoftwareAggregate

   Gets the minor version.

   :return: the minorVersion

getName
^^^^^^^

.. java:method:: public String getName()
   :outertype: SoftwareAggregate

   Gets the name.

   :return: the name

getNameVersion
^^^^^^^^^^^^^^

.. java:method:: public String getNameVersion()
   :outertype: SoftwareAggregate

   Gets the name version.

   :return: the name and version concatenated

getNumber
^^^^^^^^^

.. java:method:: public Integer getNumber()
   :outertype: SoftwareAggregate

   Gets the number.

   :return: the number

getProfile
^^^^^^^^^^

.. java:method:: public String getProfile()
   :outertype: SoftwareAggregate

   Gets the profile.

   :return: the profile

getRemainingVersion
^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getRemainingVersion()
   :outertype: SoftwareAggregate

   Gets the remaining version.

   :return: the remainingVersion

getRevisionVersion
^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getRevisionVersion()
   :outertype: SoftwareAggregate

   Gets the revision version.

   :return: the revisionVersion

getVersion
^^^^^^^^^^

.. java:method:: public String getVersion()
   :outertype: SoftwareAggregate

   Gets the version.

   :return: the version complete

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: SoftwareAggregate

setBuildVersion
^^^^^^^^^^^^^^^

.. java:method:: public void setBuildVersion(Integer buildVersion)
   :outertype: SoftwareAggregate

   Sets the builds the version.

   :param buildVersion: the buildVersion to set

setDescription
^^^^^^^^^^^^^^

.. java:method:: public void setDescription(String description)
   :outertype: SoftwareAggregate

   Sets the description.

   :param description: the description to set

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: SoftwareAggregate

   Sets the id.

   :param id: the id to set

setMajorVersion
^^^^^^^^^^^^^^^

.. java:method:: public void setMajorVersion(Integer majorVersion)
   :outertype: SoftwareAggregate

   Sets the major version.

   :param majorVersion: the majorVersion to set

setMinorVersion
^^^^^^^^^^^^^^^

.. java:method:: public void setMinorVersion(Integer minorVersion)
   :outertype: SoftwareAggregate

   Sets the minor version.

   :param minorVersion: the minorVersion to set

setName
^^^^^^^

.. java:method:: public void setName(String name)
   :outertype: SoftwareAggregate

   Sets the name.

   :param name: the name to set

setNumber
^^^^^^^^^

.. java:method:: public void setNumber(Integer number)
   :outertype: SoftwareAggregate

   Sets the number.

   :param number: the number to set

setProfile
^^^^^^^^^^

.. java:method:: public void setProfile(String profile)
   :outertype: SoftwareAggregate

   Sets the profile.

   :param profile: the profile to set

setRemainingVersion
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setRemainingVersion(String remainingVersion)
   :outertype: SoftwareAggregate

   Sets the remaining version.

   :param remainingVersion: the remainingVersion to set

setRevisionVersion
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setRevisionVersion(Integer revisionVersion)
   :outertype: SoftwareAggregate

   Sets the revision version.

   :param revisionVersion: the revisionVersion to set

setVersion
^^^^^^^^^^

.. java:method:: public void setVersion(String version)
   :outertype: SoftwareAggregate

   Sets the version.

   :param version: the complete version to set

