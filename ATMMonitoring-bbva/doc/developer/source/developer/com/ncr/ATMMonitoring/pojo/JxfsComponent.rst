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

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

.. java:import:: org.hibernate.annotations Cascade

.. java:import:: org.hibernate.annotations CascadeType

.. java:import:: org.hibernate.annotations Type

.. java:import:: com.ncr ATMMonitoring.utils.Operation

.. java:import:: com.ncr ATMMonitoring.utils.Utils

.. java:import:: com.ncr.agent.baseData.standard.jxfs.alm CapabilitiesJxfsALMCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.cam CapabilitiesJxfsCAMCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.cdr CapabilitiesJxfsCDRCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.cdr PositionsJxfsCDRCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.chk CapabilitiesJxfsCHKCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.dep CapabilitiesJxfsDEPCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.msd CapabilitiesJxfsMSDCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.pin CapabilitiesJxfsPINCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.pin PINSecureKeyDetailCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.ptr CapabilitiesJxfsPTRCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.scn BarcodeCapabilitiesCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.scn CapabilitiesJxfsSCNCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.scn ChequeCapabilitiesCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.scn ImageCapabilitiesCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.scn ScnCapabilitiesCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.siu CapabilitiesJxfsSIUCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.tio CapabilitiesJxfsTIOCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.vdm CapabilitiesJxfsVDMCollector

JxfsComponent
=============

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class JxfsComponent

   The JxfsComponent Pojo.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Constructors
------------
JxfsComponent
^^^^^^^^^^^^^

.. java:constructor:: public JxfsComponent()
   :outertype: JxfsComponent

   Instantiates a new jxfs component.

JxfsComponent
^^^^^^^^^^^^^

.. java:constructor:: public JxfsComponent(CapabilitiesJxfsALMCollector jxfs)
   :outertype: JxfsComponent

   Instantiates a new jxfs component with the given ALM data from the agent.

   :param jxfs: the ALM

JxfsComponent
^^^^^^^^^^^^^

.. java:constructor:: public JxfsComponent(CapabilitiesJxfsCAMCollector jxfs)
   :outertype: JxfsComponent

   Instantiates a new jxfs component with the given CAM data from the agent.

   :param jxfs: the CAM

JxfsComponent
^^^^^^^^^^^^^

.. java:constructor:: public JxfsComponent(CapabilitiesJxfsCDRCollector jxfs)
   :outertype: JxfsComponent

   Instantiates a new jxfs component with the given CDR data from the agent.

   :param jxfs: the CDR

JxfsComponent
^^^^^^^^^^^^^

.. java:constructor:: public JxfsComponent(CapabilitiesJxfsCHKCollector jxfs)
   :outertype: JxfsComponent

   Instantiates a new jxfs component with the given CHK data from the agent.

   :param jxfs: the CHK

JxfsComponent
^^^^^^^^^^^^^

.. java:constructor:: public JxfsComponent(CapabilitiesJxfsDEPCollector jxfs)
   :outertype: JxfsComponent

   Instantiates a new jxfs component with the given DEP data from the agent.

   :param jxfs: the DEP

JxfsComponent
^^^^^^^^^^^^^

.. java:constructor:: public JxfsComponent(CapabilitiesJxfsMSDCollector jxfs)
   :outertype: JxfsComponent

   Instantiates a new jxfs component with the given MSD data from the agent.

   :param jxfs: the MSD

JxfsComponent
^^^^^^^^^^^^^

.. java:constructor:: public JxfsComponent(CapabilitiesJxfsPINCollector jxfs)
   :outertype: JxfsComponent

   Instantiates a new jxfs component with the given PIN data from the agent.

   :param jxfs: the PIN

JxfsComponent
^^^^^^^^^^^^^

.. java:constructor:: public JxfsComponent(CapabilitiesJxfsPTRCollector jxfs)
   :outertype: JxfsComponent

   Instantiates a new jxfs component with the given PTR data from the agent.

   :param jxfs: the PTR

JxfsComponent
^^^^^^^^^^^^^

.. java:constructor:: public JxfsComponent(CapabilitiesJxfsSCNCollector jxfs)
   :outertype: JxfsComponent

   Instantiates a new jxfs component with the given SCN data from the agent.

   :param jxfs: the SCN

JxfsComponent
^^^^^^^^^^^^^

.. java:constructor:: public JxfsComponent(CapabilitiesJxfsSIUCollector jxfs)
   :outertype: JxfsComponent

   Instantiates a new jxfs component with the given SIU data from the agent.

   :param jxfs: the SIU

JxfsComponent
^^^^^^^^^^^^^

.. java:constructor:: public JxfsComponent(CapabilitiesJxfsTIOCollector jxfs)
   :outertype: JxfsComponent

   Instantiates a new jxfs component with the given TIO data from the agent.

   :param jxfs: the TIO

JxfsComponent
^^^^^^^^^^^^^

.. java:constructor:: public JxfsComponent(CapabilitiesJxfsVDMCollector jxfs)
   :outertype: JxfsComponent

   Instantiates a new jxfs component with the given VDM data from the agent.

   :param jxfs: the VDM

Methods
-------
equals
^^^^^^

.. java:method:: @Override public boolean equals(Object obj)
   :outertype: JxfsComponent

getAcceptLimit
^^^^^^^^^^^^^^

.. java:method:: public String getAcceptLimit()
   :outertype: JxfsComponent

   Gets the accept limit.

   :return: the accept limit

getAutopresent
^^^^^^^^^^^^^^

.. java:method:: public String getAutopresent()
   :outertype: JxfsComponent

   Gets the autopresent.

   :return: the autopresent

getAuxiliaries
^^^^^^^^^^^^^^

.. java:method:: public String getAuxiliaries()
   :outertype: JxfsComponent

   Gets the auxiliaries.

   :return: the auxiliaries

getAvailableResolution
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getAvailableResolution()
   :outertype: JxfsComponent

   Gets the available resolution.

   :return: the available resolution

getBaitTrap
^^^^^^^^^^^

.. java:method:: public String getBaitTrap()
   :outertype: JxfsComponent

   Gets the bait trap.

   :return: the bait trap

getBarcodeCapabilities
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getBarcodeCapabilities()
   :outertype: JxfsComponent

   Gets the barcode capabilities.

   :return: the barcode capabilities

getBeepOnPressSupported
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getBeepOnPressSupported()
   :outertype: JxfsComponent

   Gets the beep on press supported.

   :return: the beep on press supported

getBeepSupported
^^^^^^^^^^^^^^^^

.. java:method:: public String getBeepSupported()
   :outertype: JxfsComponent

   Gets the beep supported.

   :return: the beep supported

getBillsTakenSensor
^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getBillsTakenSensor()
   :outertype: JxfsComponent

   Gets the bills taken sensor.

   :return: the bills taken sensor

getCashbox
^^^^^^^^^^

.. java:method:: public String getCashbox()
   :outertype: JxfsComponent

   Gets the cashbox.

   :return: the cashbox

getCategory2
^^^^^^^^^^^^

.. java:method:: public String getCategory2()
   :outertype: JxfsComponent

   Gets the category2.

   :return: the category2

getCategory3
^^^^^^^^^^^^

.. java:method:: public String getCategory3()
   :outertype: JxfsComponent

   Gets the category3.

   :return: the category3

getCdType
^^^^^^^^^

.. java:method:: public String getCdType()
   :outertype: JxfsComponent

   Gets the cd type.

   :return: the cd type

getCheckVandalism
^^^^^^^^^^^^^^^^^

.. java:method:: public String getCheckVandalism()
   :outertype: JxfsComponent

   Gets the check vandalism.

   :return: the check vandalism

getChequeCapabilities
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getChequeCapabilities()
   :outertype: JxfsComponent

   Gets the cheque capabilities.

   :return: the cheque capabilities

getCoins
^^^^^^^^

.. java:method:: public String getCoins()
   :outertype: JxfsComponent

   Gets the coins.

   :return: the coins

getComboboxes
^^^^^^^^^^^^^

.. java:method:: public static Map<String, Map> getComboboxes()
   :outertype: JxfsComponent

   Gets the comboboxes data for the query GUI.

   :return: the comboboxes data

getComplex
^^^^^^^^^^

.. java:method:: public String getComplex()
   :outertype: JxfsComponent

   Gets the complex.

   :return: the complex

getCompound
^^^^^^^^^^^

.. java:method:: public String getCompound()
   :outertype: JxfsComponent

   Gets the compound.

   :return: the compound

getCreateSignatureCommandSupported
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getCreateSignatureCommandSupported()
   :outertype: JxfsComponent

   Gets the creates the signature command supported.

   :return: the creates the signature command supported

getCtrlTurn
^^^^^^^^^^^

.. java:method:: public String getCtrlTurn()
   :outertype: JxfsComponent

   Gets the ctrl turn.

   :return: the ctrl turn

getCursorSupported
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getCursorSupported()
   :outertype: JxfsComponent

   Gets the cursor supported.

   :return: the cursor supported

getCylinders
^^^^^^^^^^^^

.. java:method:: public String getCylinders()
   :outertype: JxfsComponent

   Gets the cylinders.

   :return: the cylinders

getDefaultInputPosition
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getDefaultInputPosition()
   :outertype: JxfsComponent

   Gets the default input position.

   :return: the default input position

getDefaultOutputPosition
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getDefaultOutputPosition()
   :outertype: JxfsComponent

   Gets the default output position.

   :return: the default output position

getDefaultRollbackPosition
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getDefaultRollbackPosition()
   :outertype: JxfsComponent

   Gets the default rollback position.

   :return: the default rollback position

getDeposit
^^^^^^^^^^

.. java:method:: public String getDeposit()
   :outertype: JxfsComponent

   Gets the deposit.

   :return: the deposit

getDetector
^^^^^^^^^^^

.. java:method:: public String getDetector()
   :outertype: JxfsComponent

   Gets the detector.

   :return: the detector

getDeviceControlName
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getDeviceControlName()
   :outertype: JxfsComponent

   Gets the device control name.

   :return: the device control name

getDeviceId
^^^^^^^^^^^

.. java:method:: public String getDeviceId()
   :outertype: JxfsComponent

   Gets the device id.

   :return: the device id

getDeviceOrientation
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getDeviceOrientation()
   :outertype: JxfsComponent

   Gets the device orientation.

   :return: the device orientation

getDeviceScanningBothLongSide
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getDeviceScanningBothLongSide()
   :outertype: JxfsComponent

   Gets the device scanning both long side.

   :return: the device scanning both long side

getDeviceScanningBothShortSide
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getDeviceScanningBothShortSide()
   :outertype: JxfsComponent

   Gets the device scanning both short side.

   :return: the device scanning both short side

getDeviceServiceName
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getDeviceServiceName()
   :outertype: JxfsComponent

   Gets the device service name.

   :return: the device service name

getDeviceType
^^^^^^^^^^^^^

.. java:method:: public String getDeviceType()
   :outertype: JxfsComponent

   Gets the device type.

   :return: the device type

getDispense
^^^^^^^^^^^

.. java:method:: public String getDispense()
   :outertype: JxfsComponent

   Gets the dispense.

   :return: the dispense

getDisplayLightSupported
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getDisplayLightSupported()
   :outertype: JxfsComponent

   Gets the display light supported.

   :return: the display light supported

getDoors
^^^^^^^^

.. java:method:: public String getDoors()
   :outertype: JxfsComponent

   Gets the doors.

   :return: the doors

getEjectStatus
^^^^^^^^^^^^^^

.. java:method:: public String getEjectStatus()
   :outertype: JxfsComponent

   Gets the eject status.

   :return: the eject status

getEntry
^^^^^^^^

.. java:method:: public String getEntry()
   :outertype: JxfsComponent

   Gets the entry.

   :return: the entry

getEnvSupply
^^^^^^^^^^^^

.. java:method:: public String getEnvSupply()
   :outertype: JxfsComponent

   Gets the env supply.

   :return: the env supply

getEscrow
^^^^^^^^^

.. java:method:: public String getEscrow()
   :outertype: JxfsComponent

   Gets the escrow.

   :return: the escrow

getEscrowSize
^^^^^^^^^^^^^

.. java:method:: public Integer getEscrowSize()
   :outertype: JxfsComponent

   Gets the escrow size.

   :return: the escrow size

getEventOnStartSupported
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getEventOnStartSupported()
   :outertype: JxfsComponent

   Gets the event on start supported.

   :return: the event on start supported

getExtent
^^^^^^^^^

.. java:method:: public String getExtent()
   :outertype: JxfsComponent

   Gets the extent.

   :return: the extent

getFinancialDevices
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<FinancialDevice> getFinancialDevices()
   :outertype: JxfsComponent

   Gets the financial devices.

   :return: the financial devices

getGuidlights
^^^^^^^^^^^^^

.. java:method:: public String getGuidlights()
   :outertype: JxfsComponent

   Gets the guidlights.

   :return: the guidlights

getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: JxfsComponent

   Gets the id.

   :return: the id

getIdKey
^^^^^^^^

.. java:method:: public String getIdKey()
   :outertype: JxfsComponent

   Gets the id key.

   :return: the id key

getImageCapabilities
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getImageCapabilities()
   :outertype: JxfsComponent

   Gets the image capabilities.

   :return: the image capabilities

getImageCapture
^^^^^^^^^^^^^^^

.. java:method:: public String getImageCapture()
   :outertype: JxfsComponent

   Gets the image capture.

   :return: the image capture

getIndicators
^^^^^^^^^^^^^

.. java:method:: public String getIndicators()
   :outertype: JxfsComponent

   Gets the indicators.

   :return: the indicators

getInputCookSupported
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getInputCookSupported()
   :outertype: JxfsComponent

   Gets the input cook supported.

   :return: the input cook supported

getInputPositions
^^^^^^^^^^^^^^^^^

.. java:method:: public String getInputPositions()
   :outertype: JxfsComponent

   Gets the input positions.

   :return: the input positions

getInputRawSupported
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getInputRawSupported()
   :outertype: JxfsComponent

   Gets the input raw supported.

   :return: the input raw supported

getInsertTextSupported
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getInsertTextSupported()
   :outertype: JxfsComponent

   Gets the insert text supported.

   :return: the insert text supported

getIntermediateStacker
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getIntermediateStacker()
   :outertype: JxfsComponent

   Gets the intermediate stacker.

   :return: the intermediate stacker

getJxfsClass
^^^^^^^^^^^^

.. java:method:: public String getJxfsClass()
   :outertype: JxfsComponent

   Gets the jxfs class.

   :return: the jxfs class

getJxfsclasses
^^^^^^^^^^^^^^

.. java:method:: public static Set<String> getJxfsclasses()
   :outertype: JxfsComponent

   Gets the jxfs classes (i.e. ALM, CAM, CDM...).

   :return: the jxfs classes

getKeyboardLockSupported
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getKeyboardLockSupported()
   :outertype: JxfsComponent

   Gets the keyboard lock supported.

   :return: the keyboard lock supported

getKeyboardSupported
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getKeyboardSupported()
   :outertype: JxfsComponent

   Gets the keyboard supported.

   :return: the keyboard supported

getKeysSupported
^^^^^^^^^^^^^^^^

.. java:method:: public String getKeysSupported()
   :outertype: JxfsComponent

   Gets the keys supported.

   :return: the keys supported

getMaxDataLength
^^^^^^^^^^^^^^^^

.. java:method:: public Integer getMaxDataLength()
   :outertype: JxfsComponent

   Gets the max data length.

   :return: the max data length

getMaxInBills
^^^^^^^^^^^^^

.. java:method:: public Integer getMaxInBills()
   :outertype: JxfsComponent

   Gets the max in bills.

   :return: the max in bills

getMaxInCoins
^^^^^^^^^^^^^

.. java:method:: public Integer getMaxInCoins()
   :outertype: JxfsComponent

   Gets the max in coins.

   :return: the max in coins

getMaxLed
^^^^^^^^^

.. java:method:: public Integer getMaxLed()
   :outertype: JxfsComponent

   Gets the max led.

   :return: the max led

getMaxNumOfChars
^^^^^^^^^^^^^^^^

.. java:method:: public Integer getMaxNumOfChars()
   :outertype: JxfsComponent

   Gets the max num of chars.

   :return: the max num of chars

getMaxOutBills
^^^^^^^^^^^^^^

.. java:method:: public Integer getMaxOutBills()
   :outertype: JxfsComponent

   Gets the max out bills.

   :return: the max out bills

getMaxOutCoins
^^^^^^^^^^^^^^

.. java:method:: public Integer getMaxOutCoins()
   :outertype: JxfsComponent

   Gets the max out coins.

   :return: the max out coins

getMaxPictures
^^^^^^^^^^^^^^

.. java:method:: public Integer getMaxPictures()
   :outertype: JxfsComponent

   Gets the max pictures.

   :return: the max pictures

getMaxRetract
^^^^^^^^^^^^^

.. java:method:: public Integer getMaxRetract()
   :outertype: JxfsComponent

   Gets the max retract.

   :return: the max retract

getMaxStacker
^^^^^^^^^^^^^

.. java:method:: public Integer getMaxStacker()
   :outertype: JxfsComponent

   Gets the max stacker.

   :return: the max stacker

getMultipleCurrenciesCashInSupported
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getMultipleCurrenciesCashInSupported()
   :outertype: JxfsComponent

   Gets the multiple currencies cash in supported.

   :return: the multiple currencies cash in supported

getNumberOfKeys
^^^^^^^^^^^^^^^

.. java:method:: public Integer getNumberOfKeys()
   :outertype: JxfsComponent

   Gets the number of keys.

   :return: the number of keys

getOrientationToBeScanned
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getOrientationToBeScanned()
   :outertype: JxfsComponent

   Gets the orientation to be scanned.

   :return: the orientation to be scanned

getOutputPositions
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getOutputPositions()
   :outertype: JxfsComponent

   Gets the output positions.

   :return: the output positions

getPositions
^^^^^^^^^^^^

.. java:method:: public String getPositions()
   :outertype: JxfsComponent

   Gets the positions.

   :return: the positions

getPowerOff
^^^^^^^^^^^

.. java:method:: public String getPowerOff()
   :outertype: JxfsComponent

   Gets the power off.

   :return: the power off

getPowerOn
^^^^^^^^^^

.. java:method:: public String getPowerOn()
   :outertype: JxfsComponent

   Gets the power on.

   :return: the power on

getPrint
^^^^^^^^

.. java:method:: public String getPrint()
   :outertype: JxfsComponent

   Gets the prints the.

   :return: the prints the

getPtrCapabilities
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getPtrCapabilities()
   :outertype: JxfsComponent

   Gets the ptr capabilities.

   :return: the ptr capabilities

getPtrControlMedia
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getPtrControlMedia()
   :outertype: JxfsComponent

   Gets the ptr control media.

   :return: the ptr control media

getReadFonts
^^^^^^^^^^^^

.. java:method:: public String getReadFonts()
   :outertype: JxfsComponent

   Gets the read fonts.

   :return: the read fonts

getReadForm
^^^^^^^^^^^

.. java:method:: public String getReadForm()
   :outertype: JxfsComponent

   Gets the read form.

   :return: the read form

getReadImage
^^^^^^^^^^^^

.. java:method:: public String getReadImage()
   :outertype: JxfsComponent

   Gets the read image.

   :return: the read image

getReadKeyboardDataWithDefault
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getReadKeyboardDataWithDefault()
   :outertype: JxfsComponent

   Gets the read keyboard data with default.

   :return: the read keyboard data with default

getReadMicr
^^^^^^^^^^^

.. java:method:: public String getReadMicr()
   :outertype: JxfsComponent

   Gets the read micr.

   :return: the read micr

getReadOcr
^^^^^^^^^^

.. java:method:: public String getReadOcr()
   :outertype: JxfsComponent

   Gets the read ocr.

   :return: the read ocr

getReadStatus
^^^^^^^^^^^^^

.. java:method:: public String getReadStatus()
   :outertype: JxfsComponent

   Gets the read status.

   :return: the read status

getRefill
^^^^^^^^^

.. java:method:: public String getRefill()
   :outertype: JxfsComponent

   Gets the refill.

   :return: the refill

getRemoteKeyLoad
^^^^^^^^^^^^^^^^

.. java:method:: public String getRemoteKeyLoad()
   :outertype: JxfsComponent

   Gets the remote key load.

   :return: the remote key load

getRetain
^^^^^^^^^

.. java:method:: public String getRetain()
   :outertype: JxfsComponent

   Gets the retain.

   :return: the retain

getRetract
^^^^^^^^^^

.. java:method:: public String getRetract()
   :outertype: JxfsComponent

   Gets the retract.

   :return: the retract

getSafeDoorCmd
^^^^^^^^^^^^^^

.. java:method:: public String getSafeDoorCmd()
   :outertype: JxfsComponent

   Gets the safe door cmd.

   :return: the safe door cmd

getSafeDoorSequence
^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSafeDoorSequence()
   :outertype: JxfsComponent

   Gets the safe door sequence.

   :return: the safe door sequence

getScnCapabilities
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getScnCapabilities()
   :outertype: JxfsComponent

   Gets the scn capabilities.

   :return: the scn capabilities

getSecureKeyDetail
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSecureKeyDetail()
   :outertype: JxfsComponent

   Gets the secure key detail.

   :return: the secure key detail

getSecureKeyEntryState
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSecureKeyEntryState()
   :outertype: JxfsComponent

   Gets the secure key entry state.

   :return: the secure key entry state

getSecureKeyEntrySupported
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSecureKeyEntrySupported()
   :outertype: JxfsComponent

   Gets the secure key entry supported.

   :return: the secure key entry supported

getSecureModuleType
^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSecureModuleType()
   :outertype: JxfsComponent

   Gets the secure module type.

   :return: the secure module type

getSensors
^^^^^^^^^^

.. java:method:: public String getSensors()
   :outertype: JxfsComponent

   Gets the sensors.

   :return: the sensors

getShutterCmd
^^^^^^^^^^^^^

.. java:method:: public String getShutterCmd()
   :outertype: JxfsComponent

   Gets the shutter cmd.

   :return: the shutter cmd

getSilentAlarm
^^^^^^^^^^^^^^

.. java:method:: public String getSilentAlarm()
   :outertype: JxfsComponent

   Gets the silent alarm.

   :return: the silent alarm

getStatus
^^^^^^^^^

.. java:method:: public String getStatus()
   :outertype: JxfsComponent

   Gets the status.

   :return: the status

getSupportedChipPresentationModes
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSupportedChipPresentationModes()
   :outertype: JxfsComponent

   Gets the supported chip presentation modes.

   :return: the supported chip presentation modes

getSupportedChipProtocols
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSupportedChipProtocols()
   :outertype: JxfsComponent

   Gets the supported chip protocols.

   :return: the supported chip protocols

getSupportedCryptoModes
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSupportedCryptoModes()
   :outertype: JxfsComponent

   Gets the supported crypto modes.

   :return: the supported crypto modes

getSupportedFdKeys
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSupportedFdKeys()
   :outertype: JxfsComponent

   Gets the supported fd keys.

   :return: the supported fd keys

getSupportedPinFormats
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSupportedPinFormats()
   :outertype: JxfsComponent

   Gets the supported pin formats.

   :return: the supported pin formats

getSupportedReadTracks
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSupportedReadTracks()
   :outertype: JxfsComponent

   Gets the supported read tracks.

   :return: the supported read tracks

getSupportedTextAttributes
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSupportedTextAttributes()
   :outertype: JxfsComponent

   Gets the supported text attributes.

   :return: the supported text attributes

getSupportedValidationAlgorithms
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSupportedValidationAlgorithms()
   :outertype: JxfsComponent

   Gets the supported validation algorithms.

   :return: the supported validation algorithms

getSupportedWriteHicoTracks
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSupportedWriteHicoTracks()
   :outertype: JxfsComponent

   Gets the supported write hico tracks.

   :return: the supported write hico tracks

getSupportedWriteTracks
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSupportedWriteTracks()
   :outertype: JxfsComponent

   Gets the supported write tracks.

   :return: the supported write tracks

getTestCashUnit
^^^^^^^^^^^^^^^

.. java:method:: public String getTestCashUnit()
   :outertype: JxfsComponent

   Gets the test cash unit.

   :return: the test cash unit

getTransport
^^^^^^^^^^^^

.. java:method:: public String getTransport()
   :outertype: JxfsComponent

   Gets the transport.

   :return: the transport

getTrustedUser
^^^^^^^^^^^^^^

.. java:method:: public String getTrustedUser()
   :outertype: JxfsComponent

   Gets the trusted user.

   :return: the trusted user

getUnfit
^^^^^^^^

.. java:method:: public String getUnfit()
   :outertype: JxfsComponent

   Gets the unfit.

   :return: the unfit

getVendorData
^^^^^^^^^^^^^

.. java:method:: public String getVendorData()
   :outertype: JxfsComponent

   Gets the vendor data.

   :return: the vendor data

getWriteForm
^^^^^^^^^^^^

.. java:method:: public String getWriteForm()
   :outertype: JxfsComponent

   Gets the write form.

   :return: the write form

getWriteMode
^^^^^^^^^^^^

.. java:method:: public String getWriteMode()
   :outertype: JxfsComponent

   Gets the write mode.

   :return: the write mode

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: JxfsComponent

setAcceptLimit
^^^^^^^^^^^^^^

.. java:method:: public void setAcceptLimit(String acceptLimit)
   :outertype: JxfsComponent

   Sets the accept limit.

   :param acceptLimit: the new accept limit

setAutopresent
^^^^^^^^^^^^^^

.. java:method:: public void setAutopresent(String autopresent)
   :outertype: JxfsComponent

   Sets the autopresent.

   :param autopresent: the new autopresent

setAuxiliaries
^^^^^^^^^^^^^^

.. java:method:: public void setAuxiliaries(String auxiliaries)
   :outertype: JxfsComponent

   Sets the auxiliaries.

   :param auxiliaries: the new auxiliaries

setAvailableResolution
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setAvailableResolution(String availableResolution)
   :outertype: JxfsComponent

   Sets the available resolution.

   :param availableResolution: the new available resolution

setBaitTrap
^^^^^^^^^^^

.. java:method:: public void setBaitTrap(String baitTrap)
   :outertype: JxfsComponent

   Sets the bait trap.

   :param baitTrap: the new bait trap

setBarcodeCapabilities
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setBarcodeCapabilities(String barcodeCapabilities)
   :outertype: JxfsComponent

   Sets the barcode capabilities.

   :param barcodeCapabilities: the new barcode capabilities

setBeepOnPressSupported
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setBeepOnPressSupported(String beepOnPressSupported)
   :outertype: JxfsComponent

   Sets the beep on press supported.

   :param beepOnPressSupported: the new beep on press supported

setBeepSupported
^^^^^^^^^^^^^^^^

.. java:method:: public void setBeepSupported(String beepSupported)
   :outertype: JxfsComponent

   Sets the beep supported.

   :param beepSupported: the new beep supported

setBillsTakenSensor
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setBillsTakenSensor(String billsTakenSensor)
   :outertype: JxfsComponent

   Sets the bills taken sensor.

   :param billsTakenSensor: the new bills taken sensor

setCashbox
^^^^^^^^^^

.. java:method:: public void setCashbox(String cashbox)
   :outertype: JxfsComponent

   Sets the cashbox.

   :param cashbox: the new cashbox

setCategory2
^^^^^^^^^^^^

.. java:method:: public void setCategory2(String category2)
   :outertype: JxfsComponent

   Sets the category2.

   :param category2: the new category2

setCategory3
^^^^^^^^^^^^

.. java:method:: public void setCategory3(String category3)
   :outertype: JxfsComponent

   Sets the category3.

   :param category3: the new category3

setCdType
^^^^^^^^^

.. java:method:: public void setCdType(String cdType)
   :outertype: JxfsComponent

   Sets the cd type.

   :param cdType: the new cd type

setCheckVandalism
^^^^^^^^^^^^^^^^^

.. java:method:: public void setCheckVandalism(String checkVandalism)
   :outertype: JxfsComponent

   Sets the check vandalism.

   :param checkVandalism: the new check vandalism

setChequeCapabilities
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setChequeCapabilities(String chequeCapabilities)
   :outertype: JxfsComponent

   Sets the cheque capabilities.

   :param chequeCapabilities: the new cheque capabilities

setCoins
^^^^^^^^

.. java:method:: public void setCoins(String coins)
   :outertype: JxfsComponent

   Sets the coins.

   :param coins: the new coins

setComplex
^^^^^^^^^^

.. java:method:: public void setComplex(String complex)
   :outertype: JxfsComponent

   Sets the complex.

   :param complex: the new complex

setCompound
^^^^^^^^^^^

.. java:method:: public void setCompound(String compound)
   :outertype: JxfsComponent

   Sets the compound.

   :param compound: the new compound

setCreateSignatureCommandSupported
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setCreateSignatureCommandSupported(String createSignatureCommandSupported)
   :outertype: JxfsComponent

   Sets the creates the signature command supported.

   :param createSignatureCommandSupported: the new creates the signature command supported

setCtrlTurn
^^^^^^^^^^^

.. java:method:: public void setCtrlTurn(String ctrlTurn)
   :outertype: JxfsComponent

   Sets the ctrl turn.

   :param ctrlTurn: the new ctrl turn

setCursorSupported
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setCursorSupported(String cursorSupported)
   :outertype: JxfsComponent

   Sets the cursor supported.

   :param cursorSupported: the new cursor supported

setCylinders
^^^^^^^^^^^^

.. java:method:: public void setCylinders(String cylinders)
   :outertype: JxfsComponent

   Sets the cylinders.

   :param cylinders: the new cylinders

setDefaultInputPosition
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setDefaultInputPosition(String defaultInputPosition)
   :outertype: JxfsComponent

   Sets the default input position.

   :param defaultInputPosition: the new default input position

setDefaultOutputPosition
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setDefaultOutputPosition(String defaultOutputPosition)
   :outertype: JxfsComponent

   Sets the default output position.

   :param defaultOutputPosition: the new default output position

setDefaultRollbackPosition
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setDefaultRollbackPosition(Integer defaultRollbackPosition)
   :outertype: JxfsComponent

   Sets the default rollback position.

   :param defaultRollbackPosition: the new default rollback position

setDeposit
^^^^^^^^^^

.. java:method:: public void setDeposit(String deposit)
   :outertype: JxfsComponent

   Sets the deposit.

   :param deposit: the new deposit

setDetector
^^^^^^^^^^^

.. java:method:: public void setDetector(String detector)
   :outertype: JxfsComponent

   Sets the detector.

   :param detector: the new detector

setDeviceControlName
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setDeviceControlName(String deviceControlName)
   :outertype: JxfsComponent

   Sets the device control name.

   :param deviceControlName: the new device control name

setDeviceId
^^^^^^^^^^^

.. java:method:: public void setDeviceId(String deviceId)
   :outertype: JxfsComponent

   Sets the device id.

   :param deviceId: the new device id

setDeviceOrientation
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setDeviceOrientation(String deviceOrientation)
   :outertype: JxfsComponent

   Sets the device orientation.

   :param deviceOrientation: the new device orientation

setDeviceScanningBothLongSide
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setDeviceScanningBothLongSide(String deviceScanningBothLongSide)
   :outertype: JxfsComponent

   Sets the device scanning both long side.

   :param deviceScanningBothLongSide: the new device scanning both long side

setDeviceScanningBothShortSide
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setDeviceScanningBothShortSide(String deviceScanningBothShortSide)
   :outertype: JxfsComponent

   Sets the device scanning both short side.

   :param deviceScanningBothShortSide: the new device scanning both short side

setDeviceServiceName
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setDeviceServiceName(String deviceServiceName)
   :outertype: JxfsComponent

   Sets the device service name.

   :param deviceServiceName: the new device service name

setDeviceType
^^^^^^^^^^^^^

.. java:method:: public void setDeviceType(String deviceType)
   :outertype: JxfsComponent

   Sets the device type.

   :param deviceType: the new device type

setDispense
^^^^^^^^^^^

.. java:method:: public void setDispense(String dispense)
   :outertype: JxfsComponent

   Sets the dispense.

   :param dispense: the new dispense

setDisplayLightSupported
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setDisplayLightSupported(String displayLightSupported)
   :outertype: JxfsComponent

   Sets the display light supported.

   :param displayLightSupported: the new display light supported

setDoors
^^^^^^^^

.. java:method:: public void setDoors(String doors)
   :outertype: JxfsComponent

   Sets the doors.

   :param doors: the new doors

setEjectStatus
^^^^^^^^^^^^^^

.. java:method:: public void setEjectStatus(String ejectStatus)
   :outertype: JxfsComponent

   Sets the eject status.

   :param ejectStatus: the new eject status

setEntry
^^^^^^^^

.. java:method:: public void setEntry(String entry)
   :outertype: JxfsComponent

   Sets the entry.

   :param entry: the new entry

setEnvSupply
^^^^^^^^^^^^

.. java:method:: public void setEnvSupply(String envSupply)
   :outertype: JxfsComponent

   Sets the env supply.

   :param envSupply: the new env supply

setEscrow
^^^^^^^^^

.. java:method:: public void setEscrow(String escrow)
   :outertype: JxfsComponent

   Sets the escrow.

   :param escrow: the new escrow

setEscrowSize
^^^^^^^^^^^^^

.. java:method:: public void setEscrowSize(Integer escrowSize)
   :outertype: JxfsComponent

   Sets the escrow size.

   :param escrowSize: the new escrow size

setEventOnStartSupported
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setEventOnStartSupported(String eventOnStartSupported)
   :outertype: JxfsComponent

   Sets the event on start supported.

   :param eventOnStartSupported: the new event on start supported

setExtent
^^^^^^^^^

.. java:method:: public void setExtent(String extent)
   :outertype: JxfsComponent

   Sets the extent.

   :param extent: the new extent

setFinancialDevices
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFinancialDevices(Set<FinancialDevice> financialDevices)
   :outertype: JxfsComponent

   Sets the financial devices.

   :param financialDevices: the new financial devices

setGuidlights
^^^^^^^^^^^^^

.. java:method:: public void setGuidlights(String guidlights)
   :outertype: JxfsComponent

   Sets the guidlights.

   :param guidlights: the new guidlights

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: JxfsComponent

   Sets the id.

   :param id: the new id

setIdKey
^^^^^^^^

.. java:method:: public void setIdKey(String idKey)
   :outertype: JxfsComponent

   Sets the id key.

   :param idKey: the new id key

setImageCapabilities
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setImageCapabilities(String imageCapabilities)
   :outertype: JxfsComponent

   Sets the image capabilities.

   :param imageCapabilities: the new image capabilities

setImageCapture
^^^^^^^^^^^^^^^

.. java:method:: public void setImageCapture(String imageCapture)
   :outertype: JxfsComponent

   Sets the image capture.

   :param imageCapture: the new image capture

setIndicators
^^^^^^^^^^^^^

.. java:method:: public void setIndicators(String indicators)
   :outertype: JxfsComponent

   Sets the indicators.

   :param indicators: the new indicators

setInputCookSupported
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setInputCookSupported(String inputCookSupported)
   :outertype: JxfsComponent

   Sets the input cook supported.

   :param inputCookSupported: the new input cook supported

setInputPositions
^^^^^^^^^^^^^^^^^

.. java:method:: public void setInputPositions(String inputPositions)
   :outertype: JxfsComponent

   Sets the input positions.

   :param inputPositions: the new input positions

setInputRawSupported
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setInputRawSupported(String inputRawSupported)
   :outertype: JxfsComponent

   Sets the input raw supported.

   :param inputRawSupported: the new input raw supported

setInsertTextSupported
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setInsertTextSupported(String insertTextSupported)
   :outertype: JxfsComponent

   Sets the insert text supported.

   :param insertTextSupported: the new insert text supported

setIntermediateStacker
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setIntermediateStacker(String intermediateStacker)
   :outertype: JxfsComponent

   Sets the intermediate stacker.

   :param intermediateStacker: the new intermediate stacker

setJxfsClass
^^^^^^^^^^^^

.. java:method:: public void setJxfsClass(String jxfsClass)
   :outertype: JxfsComponent

   Sets the jxfs class.

   :param jxfsClass: the new jxfs class

setKeyboardLockSupported
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setKeyboardLockSupported(String keyboardLockSupported)
   :outertype: JxfsComponent

   Sets the keyboard lock supported.

   :param keyboardLockSupported: the new keyboard lock supported

setKeyboardSupported
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setKeyboardSupported(String keyboardSupported)
   :outertype: JxfsComponent

   Sets the keyboard supported.

   :param keyboardSupported: the new keyboard supported

setKeysSupported
^^^^^^^^^^^^^^^^

.. java:method:: public void setKeysSupported(String keysSupported)
   :outertype: JxfsComponent

   Sets the keys supported.

   :param keysSupported: the new keys supported

setMaxDataLength
^^^^^^^^^^^^^^^^

.. java:method:: public void setMaxDataLength(Integer maxDataLength)
   :outertype: JxfsComponent

   Sets the max data length.

   :param maxDataLength: the new max data length

setMaxInBills
^^^^^^^^^^^^^

.. java:method:: public void setMaxInBills(Integer maxInBills)
   :outertype: JxfsComponent

   Sets the max in bills.

   :param maxInBills: the new max in bills

setMaxInCoins
^^^^^^^^^^^^^

.. java:method:: public void setMaxInCoins(Integer maxInCoins)
   :outertype: JxfsComponent

   Sets the max in coins.

   :param maxInCoins: the new max in coins

setMaxLed
^^^^^^^^^

.. java:method:: public void setMaxLed(Integer maxLed)
   :outertype: JxfsComponent

   Sets the max led.

   :param maxLed: the new max led

setMaxNumOfChars
^^^^^^^^^^^^^^^^

.. java:method:: public void setMaxNumOfChars(Integer maxNumOfChars)
   :outertype: JxfsComponent

   Sets the max num of chars.

   :param maxNumOfChars: the new max num of chars

setMaxOutBills
^^^^^^^^^^^^^^

.. java:method:: public void setMaxOutBills(Integer maxOutBills)
   :outertype: JxfsComponent

   Sets the max out bills.

   :param maxOutBills: the new max out bills

setMaxOutCoins
^^^^^^^^^^^^^^

.. java:method:: public void setMaxOutCoins(Integer maxOutCoins)
   :outertype: JxfsComponent

   Sets the max out coins.

   :param maxOutCoins: the new max out coins

setMaxPictures
^^^^^^^^^^^^^^

.. java:method:: public void setMaxPictures(Integer maxPictures)
   :outertype: JxfsComponent

   Sets the max pictures.

   :param maxPictures: the new max pictures

setMaxRetract
^^^^^^^^^^^^^

.. java:method:: public void setMaxRetract(Integer maxRetract)
   :outertype: JxfsComponent

   Sets the max retract.

   :param maxRetract: the new max retract

setMaxStacker
^^^^^^^^^^^^^

.. java:method:: public void setMaxStacker(Integer maxStacker)
   :outertype: JxfsComponent

   Sets the max stacker.

   :param maxStacker: the new max stacker

setMultipleCurrenciesCashInSupported
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setMultipleCurrenciesCashInSupported(String multipleCurrenciesCashInSupported)
   :outertype: JxfsComponent

   Sets the multiple currencies cash in supported.

   :param multipleCurrenciesCashInSupported: the new multiple currencies cash in supported

setNumberOfKeys
^^^^^^^^^^^^^^^

.. java:method:: public void setNumberOfKeys(Integer numberOfKeys)
   :outertype: JxfsComponent

   Sets the number of keys.

   :param numberOfKeys: the new number of keys

setOrientationToBeScanned
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setOrientationToBeScanned(String orientationToBeScanned)
   :outertype: JxfsComponent

   Sets the orientation to be scanned.

   :param orientationToBeScanned: the new orientation to be scanned

setOutputPositions
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setOutputPositions(String outputPositions)
   :outertype: JxfsComponent

   Sets the output positions.

   :param outputPositions: the new output positions

setPositions
^^^^^^^^^^^^

.. java:method:: public void setPositions(String positions)
   :outertype: JxfsComponent

   Sets the positions.

   :param positions: the new positions

setPowerOff
^^^^^^^^^^^

.. java:method:: public void setPowerOff(String powerOff)
   :outertype: JxfsComponent

   Sets the power off.

   :param powerOff: the new power off

setPowerOn
^^^^^^^^^^

.. java:method:: public void setPowerOn(String powerOn)
   :outertype: JxfsComponent

   Sets the power on.

   :param powerOn: the new power on

setPrint
^^^^^^^^

.. java:method:: public void setPrint(String print)
   :outertype: JxfsComponent

   Sets the prints the.

   :param print: the new prints the

setPtrCapabilities
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setPtrCapabilities(String ptrCapabilities)
   :outertype: JxfsComponent

   Sets the ptr capabilities.

   :param ptrCapabilities: the new ptr capabilities

setPtrControlMedia
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setPtrControlMedia(String ptrControlMedia)
   :outertype: JxfsComponent

   Sets the ptr control media.

   :param ptrControlMedia: the new ptr control media

setReadFonts
^^^^^^^^^^^^

.. java:method:: public void setReadFonts(String readFonts)
   :outertype: JxfsComponent

   Sets the read fonts.

   :param readFonts: the new read fonts

setReadForm
^^^^^^^^^^^

.. java:method:: public void setReadForm(String readForm)
   :outertype: JxfsComponent

   Sets the read form.

   :param readForm: the new read form

setReadImage
^^^^^^^^^^^^

.. java:method:: public void setReadImage(String readImage)
   :outertype: JxfsComponent

   Sets the read image.

   :param readImage: the new read image

setReadKeyboardDataWithDefault
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setReadKeyboardDataWithDefault(String readKeyboardDataWithDefault)
   :outertype: JxfsComponent

   Sets the read keyboard data with default.

   :param readKeyboardDataWithDefault: the new read keyboard data with default

setReadMicr
^^^^^^^^^^^

.. java:method:: public void setReadMicr(String readMicr)
   :outertype: JxfsComponent

   Sets the read micr.

   :param readMicr: the new read micr

setReadOcr
^^^^^^^^^^

.. java:method:: public void setReadOcr(String readOcr)
   :outertype: JxfsComponent

   Sets the read ocr.

   :param readOcr: the new read ocr

setReadStatus
^^^^^^^^^^^^^

.. java:method:: public void setReadStatus(String readStatus)
   :outertype: JxfsComponent

   Sets the read status.

   :param readStatus: the new read status

setRefill
^^^^^^^^^

.. java:method:: public void setRefill(String refill)
   :outertype: JxfsComponent

   Sets the refill.

   :param refill: the new refill

setRemoteKeyLoad
^^^^^^^^^^^^^^^^

.. java:method:: public void setRemoteKeyLoad(String remoteKeyLoad)
   :outertype: JxfsComponent

   Sets the remote key load.

   :param remoteKeyLoad: the new remote key load

setRetain
^^^^^^^^^

.. java:method:: public void setRetain(String retain)
   :outertype: JxfsComponent

   Sets the retain.

   :param retain: the new retain

setRetract
^^^^^^^^^^

.. java:method:: public void setRetract(String retract)
   :outertype: JxfsComponent

   Sets the retract.

   :param retract: the new retract

setSafeDoorCmd
^^^^^^^^^^^^^^

.. java:method:: public void setSafeDoorCmd(String safeDoorCmd)
   :outertype: JxfsComponent

   Sets the safe door cmd.

   :param safeDoorCmd: the new safe door cmd

setSafeDoorSequence
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSafeDoorSequence(String safeDoorSequence)
   :outertype: JxfsComponent

   Sets the safe door sequence.

   :param safeDoorSequence: the new safe door sequence

setScnCapabilities
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setScnCapabilities(String scnCapabilities)
   :outertype: JxfsComponent

   Sets the scn capabilities.

   :param scnCapabilities: the new scn capabilities

setSecureKeyDetail
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSecureKeyDetail(String secureKeyDetail)
   :outertype: JxfsComponent

   Sets the secure key detail.

   :param secureKeyDetail: the new secure key detail

setSecureKeyEntryState
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSecureKeyEntryState(String secureKeyEntryState)
   :outertype: JxfsComponent

   Sets the secure key entry state.

   :param secureKeyEntryState: the new secure key entry state

setSecureKeyEntrySupported
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSecureKeyEntrySupported(String secureKeyEntrySupported)
   :outertype: JxfsComponent

   Sets the secure key entry supported.

   :param secureKeyEntrySupported: the new secure key entry supported

setSecureModuleType
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSecureModuleType(String secureModuleType)
   :outertype: JxfsComponent

   Sets the secure module type.

   :param secureModuleType: the new secure module type

setSensors
^^^^^^^^^^

.. java:method:: public void setSensors(String sensors)
   :outertype: JxfsComponent

   Sets the sensors.

   :param sensors: the new sensors

setShutterCmd
^^^^^^^^^^^^^

.. java:method:: public void setShutterCmd(String shutterCmd)
   :outertype: JxfsComponent

   Sets the shutter cmd.

   :param shutterCmd: the new shutter cmd

setSilentAlarm
^^^^^^^^^^^^^^

.. java:method:: public void setSilentAlarm(String silentAlarm)
   :outertype: JxfsComponent

   Sets the silent alarm.

   :param silentAlarm: the new silent alarm

setStatus
^^^^^^^^^

.. java:method:: public void setStatus(String status)
   :outertype: JxfsComponent

   Sets the status.

   :param status: the new status

setSupportedChipPresentationModes
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSupportedChipPresentationModes(String supportedChipPresentationModes)
   :outertype: JxfsComponent

   Sets the supported chip presentation modes.

   :param supportedChipPresentationModes: the new supported chip presentation modes

setSupportedChipProtocols
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSupportedChipProtocols(String supportedChipProtocols)
   :outertype: JxfsComponent

   Sets the supported chip protocols.

   :param supportedChipProtocols: the new supported chip protocols

setSupportedCryptoModes
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSupportedCryptoModes(String supportedCryptoModes)
   :outertype: JxfsComponent

   Sets the supported crypto modes.

   :param supportedCryptoModes: the new supported crypto modes

setSupportedFdKeys
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSupportedFdKeys(String supportedFdKeys)
   :outertype: JxfsComponent

   Sets the supported fd keys.

   :param supportedFdKeys: the new supported fd keys

setSupportedPinFormats
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSupportedPinFormats(String supportedPinFormats)
   :outertype: JxfsComponent

   Sets the supported pin formats.

   :param supportedPinFormats: the new supported pin formats

setSupportedReadTracks
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSupportedReadTracks(String supportedReadTracks)
   :outertype: JxfsComponent

   Sets the supported read tracks.

   :param supportedReadTracks: the new supported read tracks

setSupportedTextAttributes
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSupportedTextAttributes(String supportedTextAttributes)
   :outertype: JxfsComponent

   Sets the supported text attributes.

   :param supportedTextAttributes: the new supported text attributes

setSupportedValidationAlgorithms
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSupportedValidationAlgorithms(String supportedValidationAlgorithms)
   :outertype: JxfsComponent

   Sets the supported validation algorithms.

   :param supportedValidationAlgorithms: the new supported validation algorithms

setSupportedWriteHicoTracks
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSupportedWriteHicoTracks(String supportedWriteHicoTracks)
   :outertype: JxfsComponent

   Sets the supported write hico tracks.

   :param supportedWriteHicoTracks: the new supported write hico tracks

setSupportedWriteTracks
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSupportedWriteTracks(String supportedWriteTracks)
   :outertype: JxfsComponent

   Sets the supported write tracks.

   :param supportedWriteTracks: the new supported write tracks

setTestCashUnit
^^^^^^^^^^^^^^^

.. java:method:: public void setTestCashUnit(String testCashUnit)
   :outertype: JxfsComponent

   Sets the test cash unit.

   :param testCashUnit: the new test cash unit

setTransport
^^^^^^^^^^^^

.. java:method:: public void setTransport(String transport)
   :outertype: JxfsComponent

   Sets the transport.

   :param transport: the new transport

setTrustedUser
^^^^^^^^^^^^^^

.. java:method:: public void setTrustedUser(String trustedUser)
   :outertype: JxfsComponent

   Sets the trusted user.

   :param trustedUser: the new trusted user

setUnfit
^^^^^^^^

.. java:method:: public void setUnfit(String unfit)
   :outertype: JxfsComponent

   Sets the unfit.

   :param unfit: the new unfit

setVendorData
^^^^^^^^^^^^^

.. java:method:: public void setVendorData(String vendorData)
   :outertype: JxfsComponent

   Sets the vendor data.

   :param vendorData: the new vendor data

setWriteForm
^^^^^^^^^^^^

.. java:method:: public void setWriteForm(String writeForm)
   :outertype: JxfsComponent

   Sets the write form.

   :param writeForm: the new write form

setWriteMode
^^^^^^^^^^^^

.. java:method:: public void setWriteMode(String writeMode)
   :outertype: JxfsComponent

   Sets the write mode.

   :param writeMode: the new write mode

