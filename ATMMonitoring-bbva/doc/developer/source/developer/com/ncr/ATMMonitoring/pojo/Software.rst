.. java:import:: java.text ParseException

.. java:import:: java.text SimpleDateFormat

.. java:import:: java.util Date

.. java:import:: java.util Map

.. java:import:: java.util TreeMap

.. java:import:: javax.persistence Column

.. java:import:: javax.persistence Entity

.. java:import:: javax.persistence GeneratedValue

.. java:import:: javax.persistence GenerationType

.. java:import:: javax.persistence Id

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate.annotations Type

.. java:import:: com.ncr ATMMonitoring.utils.Operation

.. java:import:: com.ncr.agent.baseData.os.module ProductPojo

Software
========

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class Software

   The Software Pojo.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Constructors
------------
Software
^^^^^^^^

.. java:constructor:: public Software()
   :outertype: Software

   Instantiates a new software.

Software
^^^^^^^^

.. java:constructor:: public Software(ProductPojo sw)
   :outertype: Software

   Instantiates a new software with the given software data from the agent.

   :param sw: the sw

Methods
-------
equals
^^^^^^

.. java:method:: @Override public boolean equals(Object obj)
   :outertype: Software

getBuildVersion
^^^^^^^^^^^^^^^

.. java:method:: public Integer getBuildVersion()
   :outertype: Software

   Gets the builds the version.

   :return: the buildVersion

getCaption
^^^^^^^^^^

.. java:method:: public String getCaption()
   :outertype: Software

   Gets the caption.

   :return: the caption

getComboboxes
^^^^^^^^^^^^^

.. java:method:: public static Map<String, Map> getComboboxes()
   :outertype: Software

   Gets the comboboxes data for the query GUI.

   :return: the comboboxes data

getDescription
^^^^^^^^^^^^^^

.. java:method:: public String getDescription()
   :outertype: Software

   Gets the description.

   :return: the description

getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: Software

   Gets the id.

   :return: the id

getIdentifyingNumber
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getIdentifyingNumber()
   :outertype: Software

   Gets the identifying number.

   :return: the identifyingNumber

getInstallDate
^^^^^^^^^^^^^^

.. java:method:: public Date getInstallDate()
   :outertype: Software

   Gets the install date.

   :return: the installDate

getLanguage
^^^^^^^^^^^

.. java:method:: public String getLanguage()
   :outertype: Software

   Gets the language.

   :return: the language

getLocalPackage
^^^^^^^^^^^^^^^

.. java:method:: public String getLocalPackage()
   :outertype: Software

   Gets the local package.

   :return: the localPackage

getMajorVersion
^^^^^^^^^^^^^^^

.. java:method:: public Integer getMajorVersion()
   :outertype: Software

   Gets the major version.

   :return: the majorVersion

getMinorVersion
^^^^^^^^^^^^^^^

.. java:method:: public Integer getMinorVersion()
   :outertype: Software

   Gets the minor version.

   :return: the minorVersion

getName
^^^^^^^

.. java:method:: public String getName()
   :outertype: Software

   Gets the name.

   :return: the name

getNameVersion
^^^^^^^^^^^^^^

.. java:method:: public String getNameVersion()
   :outertype: Software

   Gets the name version.

   :return: the name and version concatenated

getPackageName
^^^^^^^^^^^^^^

.. java:method:: public String getPackageName()
   :outertype: Software

   Gets the package name.

   :return: the packageName

getProductId
^^^^^^^^^^^^

.. java:method:: public String getProductId()
   :outertype: Software

   Gets the product id.

   :return: the productId

getRemainingVersion
^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getRemainingVersion()
   :outertype: Software

   Gets the remaining version.

   :return: the remainingVersion

getRevisionVersion
^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getRevisionVersion()
   :outertype: Software

   Gets the revision version.

   :return: the revisionVersion

getSwType
^^^^^^^^^

.. java:method:: public String getSwType()
   :outertype: Software

   Gets the sw type.

   :return: the swType

getVendor
^^^^^^^^^

.. java:method:: public String getVendor()
   :outertype: Software

   Gets the vendor.

   :return: the vendor

getVersion
^^^^^^^^^^

.. java:method:: public String getVersion()
   :outertype: Software

   Gets the version.

   :return: the version complete

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: Software

setBuildVersion
^^^^^^^^^^^^^^^

.. java:method:: public void setBuildVersion(Integer buildVersion)
   :outertype: Software

   Sets the builds the version.

   :param buildVersion: the buildVersion to set

setCaption
^^^^^^^^^^

.. java:method:: public void setCaption(String caption)
   :outertype: Software

   Sets the caption.

   :param caption: the caption to set

setDescription
^^^^^^^^^^^^^^

.. java:method:: public void setDescription(String description)
   :outertype: Software

   Sets the description.

   :param description: the description to set

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: Software

   Sets the id.

   :param id: the id to set

setIdentifyingNumber
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setIdentifyingNumber(String identifyingNumber)
   :outertype: Software

   Sets the identifying number.

   :param identifyingNumber: the identifyingNumber to set

setInstallDate
^^^^^^^^^^^^^^

.. java:method:: public void setInstallDate(Date installDate)
   :outertype: Software

   Sets the install date.

   :param installDate: the installDate to set

setLanguage
^^^^^^^^^^^

.. java:method:: public void setLanguage(String language)
   :outertype: Software

   Sets the language.

   :param language: the language to set

setLocalPackage
^^^^^^^^^^^^^^^

.. java:method:: public void setLocalPackage(String localPackage)
   :outertype: Software

   Sets the local package.

   :param localPackage: the localPackage to set

setMajorVersion
^^^^^^^^^^^^^^^

.. java:method:: public void setMajorVersion(Integer majorVersion)
   :outertype: Software

   Sets the major version.

   :param majorVersion: the majorVersion to set

setMinorVersion
^^^^^^^^^^^^^^^

.. java:method:: public void setMinorVersion(Integer minorVersion)
   :outertype: Software

   Sets the minor version.

   :param minorVersion: the minorVersion to set

setName
^^^^^^^

.. java:method:: public void setName(String name)
   :outertype: Software

   Sets the name.

   :param name: the name to set

setPackageName
^^^^^^^^^^^^^^

.. java:method:: public void setPackageName(String packageName)
   :outertype: Software

   Sets the package name.

   :param packageName: the packageName to set

setProductId
^^^^^^^^^^^^

.. java:method:: public void setProductId(String productId)
   :outertype: Software

   Sets the product id.

   :param productId: the productId to set

setRemainingVersion
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setRemainingVersion(String remainingVersion)
   :outertype: Software

   Sets the remaining version.

   :param remainingVersion: the remainingVersion to set

setRevisionVersion
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setRevisionVersion(Integer revisionVersion)
   :outertype: Software

   Sets the revision version.

   :param revisionVersion: the revisionVersion to set

setSwType
^^^^^^^^^

.. java:method:: public void setSwType(String swType)
   :outertype: Software

   Sets the sw type.

   :param swType: the swType to set

setVendor
^^^^^^^^^

.. java:method:: public void setVendor(String vendor)
   :outertype: Software

   Sets the vendor.

   :param vendor: the vendor to set

setVersion
^^^^^^^^^^

.. java:method:: public void setVersion(String version)
   :outertype: Software

   Sets the version.

   :param version: the complete version to set

