.. java:import:: java.util HashSet

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: java.util TreeMap

.. java:import:: javax.persistence Column

.. java:import:: javax.persistence Entity

.. java:import:: javax.persistence FetchType

.. java:import:: javax.persistence GeneratedValue

.. java:import:: javax.persistence GenerationType

.. java:import:: javax.persistence Id

.. java:import:: javax.persistence JoinColumn

.. java:import:: javax.persistence JoinTable

.. java:import:: javax.persistence ManyToMany

.. java:import:: javax.persistence ManyToOne

.. java:import:: javax.persistence OrderBy

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

.. java:import:: org.hibernate.annotations Cascade

.. java:import:: org.hibernate.annotations CascadeType

.. java:import:: org.hibernate.annotations Type

.. java:import:: com.ncr ATMMonitoring.utils.Operation

.. java:import:: com.ncr ATMMonitoring.utils.Utils

.. java:import:: com.ncr.agent.baseData.vendor.utils FinancialDevicePojo

FinancialDevice
===============

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class FinancialDevice extends Auditable

   The FinancialDevice Pojo.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Constructors
------------
FinancialDevice
^^^^^^^^^^^^^^^

.. java:constructor:: public FinancialDevice()
   :outertype: FinancialDevice

   Instantiates a new financial device.

FinancialDevice
^^^^^^^^^^^^^^^

.. java:constructor:: public FinancialDevice(FinancialDevicePojo device)
   :outertype: FinancialDevice

   Instantiates a new financial device with the given financial device data from the agent.

   :param device: the device

Methods
-------
equals
^^^^^^

.. java:method:: @Override public boolean equals(Object obj)
   :outertype: FinancialDevice

getCaption
^^^^^^^^^^

.. java:method:: public String getCaption()
   :outertype: FinancialDevice

   Gets the caption.

   :return: the caption

getComboboxes
^^^^^^^^^^^^^

.. java:method:: public static Map<String, Map> getComboboxes()
   :outertype: FinancialDevice

   Gets the comboboxes data for the query GUI.

   :return: the comboboxes data

getDescription
^^^^^^^^^^^^^^

.. java:method:: public String getDescription()
   :outertype: FinancialDevice

   Gets the description.

   :return: the description

getDeviceInstance
^^^^^^^^^^^^^^^^^

.. java:method:: public String getDeviceInstance()
   :outertype: FinancialDevice

   Gets the device instance.

   :return: the deviceInstance

getDeviceStatus
^^^^^^^^^^^^^^^

.. java:method:: public String getDeviceStatus()
   :outertype: FinancialDevice

   Gets the device status.

   :return: the deviceStatus

getFirmwareNameVersion
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getFirmwareNameVersion()
   :outertype: FinancialDevice

   Gets a string with the firmware name and version.

   :return: the firmware name and version concatenated

getFirmwareVersion
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getFirmwareVersion()
   :outertype: FinancialDevice

   Gets the firmware version.

   :return: the firmwareVersion

getHotSwappable
^^^^^^^^^^^^^^^

.. java:method:: public Boolean getHotSwappable()
   :outertype: FinancialDevice

   Gets the hot swappable.

   :return: the hotSwappable

getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: FinancialDevice

   Gets the id.

   :return: the id

getJxfsComponents
^^^^^^^^^^^^^^^^^

.. java:method:: public Set<JxfsComponent> getJxfsComponents()
   :outertype: FinancialDevice

   Gets the jxfs components.

   :return: the jxfs components

getManufacturer
^^^^^^^^^^^^^^^

.. java:method:: public String getManufacturer()
   :outertype: FinancialDevice

   Gets the manufacturer.

   :return: the manufacturer

getModel
^^^^^^^^

.. java:method:: public String getModel()
   :outertype: FinancialDevice

   Gets the model.

   :return: the model

getName
^^^^^^^

.. java:method:: public String getName()
   :outertype: FinancialDevice

   Gets the name.

   :return: the name

getNameVersion
^^^^^^^^^^^^^^

.. java:method:: public String getNameVersion()
   :outertype: FinancialDevice

   Gets the name version.

   :return: the name and version concatenated

getPmStatus
^^^^^^^^^^^

.. java:method:: public String getPmStatus()
   :outertype: FinancialDevice

   Gets the pm status.

   :return: the pmStatus

getRemovable
^^^^^^^^^^^^

.. java:method:: public Boolean getRemovable()
   :outertype: FinancialDevice

   Gets the removable.

   :return: the removable

getReplaceable
^^^^^^^^^^^^^^

.. java:method:: public Boolean getReplaceable()
   :outertype: FinancialDevice

   Gets the replaceable.

   :return: the replaceable

getSerialNumber
^^^^^^^^^^^^^^^

.. java:method:: public String getSerialNumber()
   :outertype: FinancialDevice

   Gets the serial number.

   :return: the serialNumber

getTerminal
^^^^^^^^^^^

.. java:method:: public Terminal getTerminal()
   :outertype: FinancialDevice

   Gets the terminal.

   :return: the terminal

getUniversalId
^^^^^^^^^^^^^^

.. java:method:: public String getUniversalId()
   :outertype: FinancialDevice

   Gets the universal id.

   :return: the universalId

getVariant
^^^^^^^^^^

.. java:method:: public String getVariant()
   :outertype: FinancialDevice

   Gets the variant.

   :return: the variant

getVersion
^^^^^^^^^^

.. java:method:: public String getVersion()
   :outertype: FinancialDevice

   Gets the version.

   :return: the version

getXfsComponents
^^^^^^^^^^^^^^^^

.. java:method:: public Set<XfsComponent> getXfsComponents()
   :outertype: FinancialDevice

   Gets the xfs components.

   :return: the xfsComponents

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: FinancialDevice

setCaption
^^^^^^^^^^

.. java:method:: public void setCaption(String caption)
   :outertype: FinancialDevice

   Sets the caption.

   :param caption: the caption to set

setDescription
^^^^^^^^^^^^^^

.. java:method:: public void setDescription(String description)
   :outertype: FinancialDevice

   Sets the description.

   :param description: the description to set

setDeviceInstance
^^^^^^^^^^^^^^^^^

.. java:method:: public void setDeviceInstance(String deviceInstance)
   :outertype: FinancialDevice

   Sets the device instance.

   :param deviceInstance: the deviceInstance to set

setDeviceStatus
^^^^^^^^^^^^^^^

.. java:method:: public void setDeviceStatus(String deviceStatus)
   :outertype: FinancialDevice

   Sets the device status.

   :param deviceStatus: the deviceStatus to set

setFirmwareVersion
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFirmwareVersion(String firmwareVersion)
   :outertype: FinancialDevice

   Sets the firmware version.

   :param firmwareVersion: the firmwareVersion to set

setHotSwappable
^^^^^^^^^^^^^^^

.. java:method:: public void setHotSwappable(Boolean hotSwappable)
   :outertype: FinancialDevice

   Sets the hot swappable.

   :param hotSwappable: the hotSwappable to set

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: FinancialDevice

   Sets the id.

   :param id: the id to set

setJxfsComponents
^^^^^^^^^^^^^^^^^

.. java:method:: public void setJxfsComponents(Set<JxfsComponent> jxfsComponents)
   :outertype: FinancialDevice

   Sets the jxfs components.

   :param jxfsComponents: the new jxfs components

setManufacturer
^^^^^^^^^^^^^^^

.. java:method:: public void setManufacturer(String manufacturer)
   :outertype: FinancialDevice

   Sets the manufacturer.

   :param manufacturer: the manufacturer to set

setModel
^^^^^^^^

.. java:method:: public void setModel(String model)
   :outertype: FinancialDevice

   Sets the model.

   :param model: the model to set

setName
^^^^^^^

.. java:method:: public void setName(String name)
   :outertype: FinancialDevice

   Sets the name.

   :param name: the name to set

setPmStatus
^^^^^^^^^^^

.. java:method:: public void setPmStatus(String pmStatus)
   :outertype: FinancialDevice

   Sets the pm status.

   :param pmStatus: the pmStatus to set

setRemovable
^^^^^^^^^^^^

.. java:method:: public void setRemovable(Boolean removable)
   :outertype: FinancialDevice

   Sets the removable.

   :param removable: the removable to set

setReplaceable
^^^^^^^^^^^^^^

.. java:method:: public void setReplaceable(Boolean replaceable)
   :outertype: FinancialDevice

   Sets the replaceable.

   :param replaceable: the replaceable to set

setSerialNumber
^^^^^^^^^^^^^^^

.. java:method:: public void setSerialNumber(String serialNumber)
   :outertype: FinancialDevice

   Sets the serial number.

   :param serialNumber: the serialNumber to set

setTerminal
^^^^^^^^^^^

.. java:method:: public void setTerminal(Terminal terminal)
   :outertype: FinancialDevice

   Sets the terminal.

   :param terminal: the terminal to set

setUniversalId
^^^^^^^^^^^^^^

.. java:method:: public void setUniversalId(String universalId)
   :outertype: FinancialDevice

   Sets the universal id.

   :param universalId: the universalId to set

setVariant
^^^^^^^^^^

.. java:method:: public void setVariant(String variant)
   :outertype: FinancialDevice

   Sets the variant.

   :param variant: the variant to set

setVersion
^^^^^^^^^^

.. java:method:: public void setVersion(String version)
   :outertype: FinancialDevice

   Sets the version.

   :param version: the version to set

setXfsComponents
^^^^^^^^^^^^^^^^

.. java:method:: public void setXfsComponents(Set<XfsComponent> xfsComponents)
   :outertype: FinancialDevice

   Sets the xfs components.

   :param xfsComponents: the xfsComponents to set

