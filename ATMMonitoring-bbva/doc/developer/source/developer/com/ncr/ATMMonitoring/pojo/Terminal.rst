.. java:import:: java.util Date

.. java:import:: java.util HashMap

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

.. java:import:: javax.persistence ManyToOne

.. java:import:: javax.persistence OneToMany

.. java:import:: javax.persistence OrderBy

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

.. java:import:: javax.persistence Transient

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate.annotations Cascade

.. java:import:: org.hibernate.annotations CascadeType

.. java:import:: org.hibernate.annotations Type

.. java:import:: com.ncr ATMMonitoring.service.AuditableSetOperations

.. java:import:: com.ncr ATMMonitoring.service.AuditableSetOperationsImpl

.. java:import:: com.ncr ATMMonitoring.socket.ATMWrongDataException

.. java:import:: com.ncr ATMMonitoring.utils.Operation

.. java:import:: com.ncr.agent.baseData ATMDataStorePojo

.. java:import:: com.ncr.agent.baseData.vendor.utils FinancialTerminalPojo

Terminal
========

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class Terminal

   The Terminal Pojo.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Constructors
------------
Terminal
^^^^^^^^

.. java:constructor:: public Terminal()
   :outertype: Terminal

   Instantiates a new terminal.

Terminal
^^^^^^^^

.. java:constructor:: public Terminal(ATMDataStorePojo terminal) throws ATMWrongDataException
   :outertype: Terminal

   Instantiates a new terminal with the given terminal data from the agent.

   :param terminal: the terminal

Methods
-------
buildHistoricalChanges
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Map<Class<? extends Auditable>, Map<Date, Integer>> buildHistoricalChanges()
   :outertype: Terminal

   Build the historical changes

   :return: The historicalChanges

getActiveAuditableInternetExplorersByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<AuditableInternetExplorer> getActiveAuditableInternetExplorersByDate(Date date)
   :outertype: Terminal

   Get the auditable internet explorers by date

   :param date: The date
   :return: The auditable internet explorers

getActiveAuditableSoftwareAggregatesByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<AuditableSoftwareAggregate> getActiveAuditableSoftwareAggregatesByDate(Date date)
   :outertype: Terminal

   Get active software aggregates by date

   :param date: The date
   :return: The active software aggregates

getActiveBaseBoardsByDate
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getActiveBaseBoardsByDate(Date date)
   :outertype: Terminal

   :return: the hardwareDevices

getActiveBiosByDate
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getActiveBiosByDate(Date date)
   :outertype: Terminal

   :return: the hardwareDevices

getActiveCdromDrivesByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getActiveCdromDrivesByDate(Date date)
   :outertype: Terminal

   :return: the hardwareDevices

getActiveComputerSystemsByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getActiveComputerSystemsByDate(Date date)
   :outertype: Terminal

   :return: the hardwareDevices

getActiveControllers1394ByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getActiveControllers1394ByDate(Date date)
   :outertype: Terminal

   :return: the hardwareDevices

getActiveDesktopMonitorsByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getActiveDesktopMonitorsByDate(Date date)
   :outertype: Terminal

   :return: the hardwareDevices

getActiveDiskDrivesByDate
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getActiveDiskDrivesByDate(Date date)
   :outertype: Terminal

   :return: the hardwareDevices

getActiveFinancialDevicesByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<FinancialDevice> getActiveFinancialDevicesByDate(Date date)
   :outertype: Terminal

   Get the active financial devices by date

   :param date: The date
   :return: The active financial devices

getActiveFloppyDrivesByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getActiveFloppyDrivesByDate(Date date)
   :outertype: Terminal

   :return: the hardwareDevices

getActiveHardwareDevicesByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getActiveHardwareDevicesByDate(Date date)
   :outertype: Terminal

   Get active hardware device by date

   :param date: The date
   :return: The active hardware device

getActiveHotfixesByDate
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<Hotfix> getActiveHotfixesByDate(Date date)
   :outertype: Terminal

   Get the active hotfixes by date

   :param date: The date
   :return: The active hotfixes

getActiveInstallationsByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<Installation> getActiveInstallationsByDate(Date date)
   :outertype: Terminal

   Get the active installations by date

   :param date: The date
   :return: The active installations

getActiveKeyboardsByDate
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getActiveKeyboardsByDate(Date date)
   :outertype: Terminal

   :return: the hardwareDevices

getActiveLogicalDisksByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getActiveLogicalDisksByDate(Date date)
   :outertype: Terminal

   :return: the hardwareDevices

getActiveNetworkAdaptersByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getActiveNetworkAdaptersByDate(Date date)
   :outertype: Terminal

   :return: the hardwareDevices

getActiveParallelPortsByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getActiveParallelPortsByDate(Date date)
   :outertype: Terminal

   :return: the hardwareDevices

getActivePhysicalMemoriesByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getActivePhysicalMemoriesByDate(Date date)
   :outertype: Terminal

   :return: the hardwareDevices

getActivePointingDevicesByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getActivePointingDevicesByDate(Date date)
   :outertype: Terminal

   :return: the hardwareDevices

getActiveProcessorsByDate
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getActiveProcessorsByDate(Date date)
   :outertype: Terminal

   :return: the hardwareDevices

getActiveScsiControllersByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getActiveScsiControllersByDate(Date date)
   :outertype: Terminal

   :return: the hardwareDevices

getActiveSerialPortsByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getActiveSerialPortsByDate(Date date)
   :outertype: Terminal

   :return: the hardwareDevices

getActiveSoundDevicesByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getActiveSoundDevicesByDate(Date date)
   :outertype: Terminal

   :return: the hardwareDevices

getActiveSystemSlotsByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getActiveSystemSlotsByDate(Date date)
   :outertype: Terminal

   :return: the hardwareDevices

getActiveUsbControllersByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getActiveUsbControllersByDate(Date date)
   :outertype: Terminal

   :return: the hardwareDevices

getActiveVideoControllersByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getActiveVideoControllersByDate(Date date)
   :outertype: Terminal

   :return: the hardwareDevices

getBank
^^^^^^^

.. java:method:: public String getBank()
   :outertype: Terminal

   Gets the bank.

   :return: the bank

getBankCompany
^^^^^^^^^^^^^^

.. java:method:: public BankCompany getBankCompany()
   :outertype: Terminal

   Gets the bank company.

   :return: the bankCompany

getBaseBoards
^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getBaseBoards()
   :outertype: Terminal

   Gets the base boards.

   :return: the hardwareDevices

getBios
^^^^^^^

.. java:method:: public Set<HardwareDevice> getBios()
   :outertype: Terminal

   Gets the bios.

   :return: the hardwareDevices

getBranch
^^^^^^^^^

.. java:method:: public String getBranch()
   :outertype: Terminal

   Gets the branch.

   :return: the branch

getCdromDrives
^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getCdromDrives()
   :outertype: Terminal

   Gets the cdrom drives.

   :return: the hardwareDevices

getComboboxes
^^^^^^^^^^^^^

.. java:method:: public static Map<String, Map> getComboboxes()
   :outertype: Terminal

   Gets the comboboxes data for the query designer.

   :return: the comboboxes data

getComputerSystems
^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getComputerSystems()
   :outertype: Terminal

   Gets the computer systems.

   :return: the hardwareDevices

getConfigs
^^^^^^^^^^

.. java:method:: public Set<TerminalConfig> getConfigs()
   :outertype: Terminal

   Gets the configs.

   :return: the configs

getControllers1394
^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getControllers1394()
   :outertype: Terminal

   Gets the controllers1394.

   :return: the hardwareDevices

getCsvDescription
^^^^^^^^^^^^^^^^^

.. java:method:: public String getCsvDescription()
   :outertype: Terminal

   Gets a recap of the terminal data in csv format.

getCsvHeader
^^^^^^^^^^^^

.. java:method:: public static String getCsvHeader()
   :outertype: Terminal

   Gets the csv header for exporting terminals' data.

   :return: the csv header

getCurrentInstallation
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Installation getCurrentInstallation()
   :outertype: Terminal

   Get the current installation

   :return: The current installation

getCurrentInstallationByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Installation getCurrentInstallationByDate(Date date)
   :outertype: Terminal

   Get the current installation by date

   :param date: The date
   :return: The current installation

getCurrentTerminalConfig
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public TerminalConfig getCurrentTerminalConfig()
   :outertype: Terminal

   Get the current terminal config

   :return: The terminal config

getCurrentTerminalConfigActiveByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public TerminalConfig getCurrentTerminalConfigActiveByDate(Date date)
   :outertype: Terminal

   Get current terminal config active by date

   :param date: The date
   :return: The current terminal config

getDesktopMonitors
^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getDesktopMonitors()
   :outertype: Terminal

   Gets the desktop monitors.

   :return: the hardwareDevices

getDiskDrives
^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getDiskDrives()
   :outertype: Terminal

   Gets the disk drives.

   :return: the hardwareDevices

getFinancialDevices
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<FinancialDevice> getFinancialDevices()
   :outertype: Terminal

   Gets the financial devices.

   :return: the financialDevices

getFloppyDrives
^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getFloppyDrives()
   :outertype: Terminal

   Gets the floppy drives.

   :return: the hardwareDevices

getFrontReplenish
^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getFrontReplenish()
   :outertype: Terminal

   Gets the front replenish.

   :return: the frontReplenish

getGeographicAddress
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getGeographicAddress()
   :outertype: Terminal

   Gets the geographic address.

   :return: the geographicAddress

getHardwareDevices
^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getHardwareDevices()
   :outertype: Terminal

   Gets the hardware devices.

   :return: the hardwareDevices

getHotfixes
^^^^^^^^^^^

.. java:method:: public Set<Hotfix> getHotfixes()
   :outertype: Terminal

   Gets the hotfixes.

   :return: the hotfixes

getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: Terminal

   Gets the id.

   :return: the id

getInstallations
^^^^^^^^^^^^^^^^

.. java:method:: public Set<Installation> getInstallations()
   :outertype: Terminal

   Get the installations

   :return: The installations

getInternetExplorers
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<InternetExplorer> getInternetExplorers()
   :outertype: Terminal

   Gets the internet explorers.

   :return: the internetExplorers

getIp
^^^^^

.. java:method:: public String getIp()
   :outertype: Terminal

   Gets the ip.

   :return: the ip

getKeyboards
^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getKeyboards()
   :outertype: Terminal

   Gets the keyboards.

   :return: the hardwareDevices

getLogicalDisks
^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getLogicalDisks()
   :outertype: Terminal

   Gets the logical disks.

   :return: the hardwareDevices

getMac
^^^^^^

.. java:method:: public String getMac()
   :outertype: Terminal

   Gets the mac.

   :return: the mac

getManufacturingSite
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getManufacturingSite()
   :outertype: Terminal

   Gets the manufacturing site.

   :return: the manufacturingSite

getMatricula
^^^^^^^^^^^^

.. java:method:: public Long getMatricula()
   :outertype: Terminal

   Gets the generated id.

   :return: the generated id

getNetworkAdapters
^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getNetworkAdapters()
   :outertype: Terminal

   Gets the network adapters.

   :return: the hardwareDevices

getParallelPorts
^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getParallelPorts()
   :outertype: Terminal

   Gets the parallel ports.

   :return: the hardwareDevices

getPhysicalMemories
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getPhysicalMemories()
   :outertype: Terminal

   Gets the physical memories.

   :return: the hardwareDevices

getPointingDevices
^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getPointingDevices()
   :outertype: Terminal

   Gets the pointing devices.

   :return: the hardwareDevices

getProcessors
^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getProcessors()
   :outertype: Terminal

   Gets the processors.

   :return: the hardwareDevices

getProductClassDescription
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getProductClassDescription()
   :outertype: Terminal

   Gets the product class description.

   :return: the productClassDescription

getScsiControllers
^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getScsiControllers()
   :outertype: Terminal

   Gets the scsi controllers.

   :return: the hardwareDevices

getSerialNumber
^^^^^^^^^^^^^^^

.. java:method:: public String getSerialNumber()
   :outertype: Terminal

   Gets the serial number.

   :return: the serialNumber

getSerialPorts
^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getSerialPorts()
   :outertype: Terminal

   Gets the serial ports.

   :return: the hardwareDevices

getSoftwareAggregates
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<SoftwareAggregate> getSoftwareAggregates()
   :outertype: Terminal

   Gets the software aggregates.

   :return: the softwareAggregates

getSoundDevices
^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getSoundDevices()
   :outertype: Terminal

   Gets the sound devices.

   :return: the hardwareDevices

getSystemSlots
^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getSystemSlots()
   :outertype: Terminal

   Gets the system slots.

   :return: the hardwareDevices

getTerminalModel
^^^^^^^^^^^^^^^^

.. java:method:: public TerminalModel getTerminalModel()
   :outertype: Terminal

   Gets the terminal model.

   :return: the terminal model

getTerminalType
^^^^^^^^^^^^^^^

.. java:method:: public String getTerminalType()
   :outertype: Terminal

   Gets the terminal type.

   :return: the terminalType

getTerminalVendor
^^^^^^^^^^^^^^^^^

.. java:method:: public String getTerminalVendor()
   :outertype: Terminal

   Gets the terminal vendor.

   :return: the terminalVendor

getTracerNumber
^^^^^^^^^^^^^^^

.. java:method:: public String getTracerNumber()
   :outertype: Terminal

   Gets the tracer number.

   :return: the tracerNumber

getUsbControllers
^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getUsbControllers()
   :outertype: Terminal

   Gets the usb controllers.

   :return: the hardwareDevices

getVideoControllers
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<HardwareDevice> getVideoControllers()
   :outertype: Terminal

   Gets the video controllers.

   :return: the hardwareDevices

replaceTerminalData
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void replaceTerminalData(Terminal terminal)
   :outertype: Terminal

   Replaces most terminal fields with the data from another Terminal entity.

   :param terminal: the terminal with its data rewritten

replaceTerminalDataWoVoidValues
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void replaceTerminalDataWoVoidValues(Terminal terminal)
   :outertype: Terminal

   Replaces most terminal fields with the data from another Terminal entity ignoring null or void values so they don't overwrite the original values.

   :param terminal: the terminal with its data rewritten

setAuditableInternetExplorers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setAuditableInternetExplorers(Set<AuditableInternetExplorer> auditableInternetExplorers)
   :outertype: Terminal

   Sets the internet explorers.

   :param internetExplorers: the internetExplorers to set

setBank
^^^^^^^

.. java:method:: public void setBank(String bank)
   :outertype: Terminal

   Sets the bank.

   :param bank: the bank to set

setBankCompany
^^^^^^^^^^^^^^

.. java:method:: public void setBankCompany(BankCompany bankCompany)
   :outertype: Terminal

   Sets the bank company.

   :param bankCompany: the bankCompany to set

setBranch
^^^^^^^^^

.. java:method:: public void setBranch(String branch)
   :outertype: Terminal

   Sets the branch.

   :param branch: the branch to set

setConfigs
^^^^^^^^^^

.. java:method:: public void setConfigs(Set<TerminalConfig> configs)
   :outertype: Terminal

   Sets the configs.

   :param configs: the configs to set

setCurrentInstallation
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setCurrentInstallation(Installation installation)
   :outertype: Terminal

   Set current installation

   :param installation: The current installation

setCurrentTerminalConfig
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setCurrentTerminalConfig(TerminalConfig terminalConfig)
   :outertype: Terminal

   Set the current terminal config

   :param terminalConfig: The terminal config

setFinancialDevices
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFinancialDevices(Set<FinancialDevice> financialDevices)
   :outertype: Terminal

   Sets the financial devices.

   :param financialDevices: the financialDevices to set

setFrontReplenish
^^^^^^^^^^^^^^^^^

.. java:method:: public void setFrontReplenish(Boolean frontReplenish)
   :outertype: Terminal

   Sets the front replenish.

   :param frontReplenish: the frontReplenish to set

setGeographicAddress
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setGeographicAddress(String geographicAddress)
   :outertype: Terminal

   Sets the geographic address.

   :param geographicAddress: the geographicAddress to set

setHardwareDevices
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDevices(Set<HardwareDevice> hardwareDevices)
   :outertype: Terminal

   Sets the hardware devices.

   :param hardwareDevices: the hardwareDevices to set

setHotfixes
^^^^^^^^^^^

.. java:method:: public void setHotfixes(Set<Hotfix> hotfixes)
   :outertype: Terminal

   Sets the hotfixes.

   :param hotfixes: the hotfixes to set

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: Terminal

   Sets the id.

   :param id: the id to set

setIp
^^^^^

.. java:method:: public void setIp(String ip)
   :outertype: Terminal

   Sets the ip.

   :param ip: the ip to set

setMac
^^^^^^

.. java:method:: public void setMac(String mac)
   :outertype: Terminal

   Sets the mac.

   :param mac: the mac to set

setManufacturingSite
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setManufacturingSite(String manufacturingSite)
   :outertype: Terminal

   Sets the manufacturing site.

   :param manufacturingSite: the manufacturingSite to set

setMatricula
^^^^^^^^^^^^

.. java:method:: public void setMatricula(Long matricula)
   :outertype: Terminal

   Sets the generated id.

   :param matricula: the new generated id

setProductClassDescription
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setProductClassDescription(String productClassDescription)
   :outertype: Terminal

   Sets the product class description.

   :param productClassDescription: the productClassDescription to set

setSerialNumber
^^^^^^^^^^^^^^^

.. java:method:: public void setSerialNumber(String serialNumber)
   :outertype: Terminal

   Sets the serial number.

   :param serialNumber: the serialNumber to set

setTerminalModel
^^^^^^^^^^^^^^^^

.. java:method:: public void setTerminalModel(TerminalModel terminalModel)
   :outertype: Terminal

   Sets the terminal model.

   :param terminalModel: the new terminal model

setTerminalType
^^^^^^^^^^^^^^^

.. java:method:: public void setTerminalType(String terminalType)
   :outertype: Terminal

   Sets the terminal type.

   :param terminalType: the terminalType to set

setTerminalVendor
^^^^^^^^^^^^^^^^^

.. java:method:: public void setTerminalVendor(String terminalVendor)
   :outertype: Terminal

   Sets the terminal vendor.

   :param terminalVendor: the terminalVendor to set

setTracerNumber
^^^^^^^^^^^^^^^

.. java:method:: public void setTracerNumber(String tracerNumber)
   :outertype: Terminal

   Sets the tracer number.

   :param tracerNumber: the tracerNumber to set

updateAuditableInternetExplorers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void updateAuditableInternetExplorers(Set<AuditableInternetExplorer> newAuditableInternetExplorers)
   :outertype: Terminal

   Update the collection of auditable internet explorer

   :param newAuditableInternetExplorers: the internetExplorers to set

updateAuditableSoftwareAggregates
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void updateAuditableSoftwareAggregates(Set<AuditableSoftwareAggregate> newAuditableSoftwareAggregate)
   :outertype: Terminal

   Update the collection of auditable sofware aggregates

   :param newAuditableSoftwareAggregate: the new software aggregates

updateFinancialDevices
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void updateFinancialDevices(Set<FinancialDevice> newFinancialDevices)
   :outertype: Terminal

   Update the collection financial devices of auditable elements

   :param hardwareDevices: The financial devices

updateHardwareDevices
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void updateHardwareDevices(Set<HardwareDevice> newHardwareDevices)
   :outertype: Terminal

   Update the collection hardware devices of auditable elements

   :param hardwareDevices: The hardware devices

updateHotfixes
^^^^^^^^^^^^^^

.. java:method:: public void updateHotfixes(Set<Hotfix> newHotfixes)
   :outertype: Terminal

   Update the collection hardware devices of auditable elements

   :param hardwareDevices: The hotfixes

