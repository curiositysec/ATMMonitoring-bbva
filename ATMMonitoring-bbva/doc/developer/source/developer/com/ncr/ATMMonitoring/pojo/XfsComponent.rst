.. java:import:: java.util ArrayList

.. java:import:: java.util HashSet

.. java:import:: java.util List

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

.. java:import:: javax.persistence OneToMany

.. java:import:: javax.persistence OrderBy

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

.. java:import:: org.hibernate.annotations Cascade

.. java:import:: org.hibernate.annotations CascadeType

.. java:import:: org.hibernate.annotations Type

.. java:import:: com.ncr ATMMonitoring.utils.Operation

.. java:import:: com.ncr ATMMonitoring.utils.Utils

.. java:import:: com.ncr.agent.baseData.standard.xfs.module ALM

.. java:import:: com.ncr.agent.baseData.standard.xfs.module BCR

.. java:import:: com.ncr.agent.baseData.standard.xfs.module CAM

.. java:import:: com.ncr.agent.baseData.standard.xfs.module CDM

.. java:import:: com.ncr.agent.baseData.standard.xfs.module CEU

.. java:import:: com.ncr.agent.baseData.standard.xfs.module CHK

.. java:import:: com.ncr.agent.baseData.standard.xfs.module CIM

.. java:import:: com.ncr.agent.baseData.standard.xfs.module CRD

.. java:import:: com.ncr.agent.baseData.standard.xfs.module DEP

.. java:import:: com.ncr.agent.baseData.standard.xfs.module IDC

.. java:import:: com.ncr.agent.baseData.standard.xfs.module IPM

.. java:import:: com.ncr.agent.baseData.standard.xfs.module PIN

.. java:import:: com.ncr.agent.baseData.standard.xfs.module PTR

.. java:import:: com.ncr.agent.baseData.standard.xfs.module SIU

.. java:import:: com.ncr.agent.baseData.standard.xfs.module TTU

.. java:import:: com.ncr.agent.baseData.standard.xfs.module VDM

XfsComponent
============

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class XfsComponent

   The XfsComponent Pojo.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Constructors
------------
XfsComponent
^^^^^^^^^^^^

.. java:constructor:: public XfsComponent()
   :outertype: XfsComponent

   Instantiates a new xfs component.

XfsComponent
^^^^^^^^^^^^

.. java:constructor:: public XfsComponent(ALM xfs)
   :outertype: XfsComponent

   Instantiates a new xfs component based on ALM data from the agent.

   :param xfs: the ALM

XfsComponent
^^^^^^^^^^^^

.. java:constructor:: public XfsComponent(BCR xfs)
   :outertype: XfsComponent

   Instantiates a new xfs component based on BCR data from the agent.

   :param xfs: the BCR

XfsComponent
^^^^^^^^^^^^

.. java:constructor:: public XfsComponent(CAM xfs)
   :outertype: XfsComponent

   Instantiates a new xfs component based on CAM data from the agent.

   :param xfs: the CAM

XfsComponent
^^^^^^^^^^^^

.. java:constructor:: public XfsComponent(CDM xfs)
   :outertype: XfsComponent

   Instantiates a new xfs component based on CDM data from the agent.

   :param xfs: the CDM

XfsComponent
^^^^^^^^^^^^

.. java:constructor:: public XfsComponent(CEU xfs)
   :outertype: XfsComponent

   Instantiates a new xfs component based on CEU data from the agent.

   :param xfs: the CEU

XfsComponent
^^^^^^^^^^^^

.. java:constructor:: public XfsComponent(CHK xfs)
   :outertype: XfsComponent

   Instantiates a new xfs component based on CHK data from the agent.

   :param xfs: the CHK

XfsComponent
^^^^^^^^^^^^

.. java:constructor:: public XfsComponent(CIM xfs)
   :outertype: XfsComponent

   Instantiates a new xfs component based on CIM data from the agent.

   :param xfs: the CIM

XfsComponent
^^^^^^^^^^^^

.. java:constructor:: public XfsComponent(CRD xfs)
   :outertype: XfsComponent

   Instantiates a new xfs component based on CRD data from the agent.

   :param xfs: the CRD

XfsComponent
^^^^^^^^^^^^

.. java:constructor:: public XfsComponent(DEP xfs)
   :outertype: XfsComponent

   Instantiates a new xfs component based on DEP data from the agent.

   :param xfs: the DEP

XfsComponent
^^^^^^^^^^^^

.. java:constructor:: public XfsComponent(IDC xfs)
   :outertype: XfsComponent

   Instantiates a new xfs component based on IDC data from the agent.

   :param xfs: the IDC

XfsComponent
^^^^^^^^^^^^

.. java:constructor:: public XfsComponent(IPM xfs)
   :outertype: XfsComponent

   Instantiates a new xfs component based on IPM data from the agent.

   :param xfs: the IPM

XfsComponent
^^^^^^^^^^^^

.. java:constructor:: public XfsComponent(PIN xfs)
   :outertype: XfsComponent

   Instantiates a new xfs component based on PIN data from the agent.

   :param xfs: the PIN

XfsComponent
^^^^^^^^^^^^

.. java:constructor:: public XfsComponent(PTR xfs)
   :outertype: XfsComponent

   Instantiates a new xfs component based on PTR data from the agent.

   :param xfs: the PTR

XfsComponent
^^^^^^^^^^^^

.. java:constructor:: public XfsComponent(SIU xfs)
   :outertype: XfsComponent

   Instantiates a new xfs component based on SIU data from the agent.

   :param xfs: the SIU

XfsComponent
^^^^^^^^^^^^

.. java:constructor:: public XfsComponent(TTU xfs)
   :outertype: XfsComponent

   Instantiates a new xfs component based on TTU data from the agent.

   :param xfs: the TTU

XfsComponent
^^^^^^^^^^^^

.. java:constructor:: public XfsComponent(VDM xfs)
   :outertype: XfsComponent

   Instantiates a new xfs component based on VDM data from the agent.

   :param xfs: the VDM

Methods
-------
equals
^^^^^^

.. java:method:: @Override public boolean equals(Object obj)
   :outertype: XfsComponent

getAcceptMedia
^^^^^^^^^^^^^^

.. java:method:: public Boolean getAcceptMedia()
   :outertype: XfsComponent

   Gets the accept media.

   :return: the accept media

getAlgorithms
^^^^^^^^^^^^^

.. java:method:: public String getAlgorithms()
   :outertype: XfsComponent

   Gets the algorithms.

   :return: the algorithms

getAutobeep
^^^^^^^^^^^

.. java:method:: public String getAutobeep()
   :outertype: XfsComponent

   Gets the autobeep.

   :return: the autobeep

getAutodeposit
^^^^^^^^^^^^^^

.. java:method:: public Boolean getAutodeposit()
   :outertype: XfsComponent

getAutoretractPeriod
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getAutoretractPeriod()
   :outertype: XfsComponent

   Gets the autoretract period.

   :return: the autoretract period

getAuxiliaries
^^^^^^^^^^^^^^

.. java:method:: public String getAuxiliaries()
   :outertype: XfsComponent

   Gets the auxiliaries.

   :return: the auxiliaries

getBackImageColorFormat
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getBackImageColorFormat()
   :outertype: XfsComponent

   Gets the back image color format.

   :return: the back image color format

getBackscanColor
^^^^^^^^^^^^^^^^

.. java:method:: public String getBackscanColor()
   :outertype: XfsComponent

   Gets the backscan color.

   :return: the backscan color

getCamdata
^^^^^^^^^^

.. java:method:: public String getCamdata()
   :outertype: XfsComponent

   Gets the camdata.

   :return: the camdata

getCameras
^^^^^^^^^^

.. java:method:: public String getCameras()
   :outertype: XfsComponent

   Gets the cameras.

   :return: the cameras

getCanFilterSymbologies
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getCanFilterSymbologies()
   :outertype: XfsComponent

   Gets the can filter symbologies.

   :return: the can filter symbologies

getCards
^^^^^^^^

.. java:method:: public Integer getCards()
   :outertype: XfsComponent

   Gets the cards.

   :return: the cards

getCashin
^^^^^^^^^

.. java:method:: public Boolean getCashin()
   :outertype: XfsComponent

getCharSupport
^^^^^^^^^^^^^^

.. java:method:: public String getCharSupport()
   :outertype: XfsComponent

   Gets the char support.

   :return: the char support

getChipPower
^^^^^^^^^^^^

.. java:method:: public String getChipPower()
   :outertype: XfsComponent

   Gets the chip power.

   :return: the chip power

getChipProtocol
^^^^^^^^^^^^^^^

.. java:method:: public String getChipProtocol()
   :outertype: XfsComponent

   Gets the chip protocol.

   :return: the chip protocol

getChipio
^^^^^^^^^

.. java:method:: public Boolean getChipio()
   :outertype: XfsComponent

   Gets the chipio.

   :return: the chipio

getCodeLineFormat
^^^^^^^^^^^^^^^^^

.. java:method:: public String getCodeLineFormat()
   :outertype: XfsComponent

   Gets the code line format.

   :return: the code line format

getCoins
^^^^^^^^

.. java:method:: public Boolean getCoins()
   :outertype: XfsComponent

getComboboxes
^^^^^^^^^^^^^

.. java:method:: public static Map<String, Map> getComboboxes()
   :outertype: XfsComponent

   Gets the comboboxes data for the query GUI.

   :return: the comboboxes data

getComparemagneticstripe
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getComparemagneticstripe()
   :outertype: XfsComponent

   Gets the comparemagneticstripe.

   :return: the comparemagneticstripe

getCompound
^^^^^^^^^^^

.. java:method:: public Boolean getCompound()
   :outertype: XfsComponent

   Gets the compound.

   :return: the compound

getControl
^^^^^^^^^^

.. java:method:: public String getControl()
   :outertype: XfsComponent

   Gets the control.

   :return: the control

getCursor
^^^^^^^^^

.. java:method:: public Boolean getCursor()
   :outertype: XfsComponent

   Gets the cursor.

   :return: the cursor

getCylinders
^^^^^^^^^^^^

.. java:method:: public Boolean getCylinders()
   :outertype: XfsComponent

getDefaultBackscanColor
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getDefaultBackscanColor()
   :outertype: XfsComponent

   Gets the default backscan color.

   :return: the default backscan color

getDefaultFrontscanColor
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getDefaultFrontscanColor()
   :outertype: XfsComponent

   Gets the default frontscan color.

   :return: the default frontscan color

getDeptransport
^^^^^^^^^^^^^^^

.. java:method:: public Boolean getDeptransport()
   :outertype: XfsComponent

   Gets the deptransport.

   :return: the deptransport

getDerivationAlgorithms
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getDerivationAlgorithms()
   :outertype: XfsComponent

   Gets the derivation algorithms.

   :return: the derivation algorithms

getDipMode
^^^^^^^^^^

.. java:method:: public String getDipMode()
   :outertype: XfsComponent

   Gets the dip mode.

   :return: the dip mode

getDispenseTo
^^^^^^^^^^^^^

.. java:method:: public String getDispenseTo()
   :outertype: XfsComponent

   Gets the dispense to.

   :return: the dispense to

getDisplay
^^^^^^^^^^

.. java:method:: public String getDisplay()
   :outertype: XfsComponent

   Gets the display.

   :return: the display

getDisplayLight
^^^^^^^^^^^^^^^

.. java:method:: public Boolean getDisplayLight()
   :outertype: XfsComponent

   Gets the display light.

   :return: the display light

getDoors
^^^^^^^^

.. java:method:: public String getDoors()
   :outertype: XfsComponent

   Gets the doors.

   :return: the doors

getEjectPosition
^^^^^^^^^^^^^^^^

.. java:method:: public String getEjectPosition()
   :outertype: XfsComponent

   Gets the eject position.

   :return: the eject position

getEmvHashAlgorithm
^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getEmvHashAlgorithm()
   :outertype: XfsComponent

   Gets the emv hash algorithm.

   :return: the emv hash algorithm

getEmvImportSchemes
^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getEmvImportSchemes()
   :outertype: XfsComponent

   Gets the emv import schemes.

   :return: the emv import schemes

getEncioProtocols
^^^^^^^^^^^^^^^^^

.. java:method:: public String getEncioProtocols()
   :outertype: XfsComponent

   Gets the encio protocols.

   :return: the encio protocols

getEncodenames
^^^^^^^^^^^^^^

.. java:method:: public String getEncodenames()
   :outertype: XfsComponent

   Gets the encodenames.

   :return: the encodenames

getEncoder
^^^^^^^^^^

.. java:method:: public Boolean getEncoder()
   :outertype: XfsComponent

   Gets the encoder.

   :return: the encoder

getEndorser
^^^^^^^^^^^

.. java:method:: public Boolean getEndorser()
   :outertype: XfsComponent

   Gets the endorser.

   :return: the endorser

getEnvelopesupply
^^^^^^^^^^^^^^^^^

.. java:method:: public String getEnvelopesupply()
   :outertype: XfsComponent

   Gets the envelopesupply.

   :return: the envelopesupply

getExchangeTypes
^^^^^^^^^^^^^^^^

.. java:method:: public String getExchangeTypes()
   :outertype: XfsComponent

   Gets the exchange types.

   :return: the exchange types

getExtents
^^^^^^^^^^

.. java:method:: public String getExtents()
   :outertype: XfsComponent

   Gets the extents.

   :return: the extents

getExtra
^^^^^^^^

.. java:method:: public String getExtra()
   :outertype: XfsComponent

   Gets the extra.

   :return: the extra

getFinancialDevices
^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<FinancialDevice> getFinancialDevices()
   :outertype: XfsComponent

   Gets the financial devices.

   :return: the financial devices

getFontnames
^^^^^^^^^^^^

.. java:method:: public String getFontnames()
   :outertype: XfsComponent

   Gets the fontnames.

   :return: the fontnames

getForms
^^^^^^^^

.. java:method:: public Boolean getForms()
   :outertype: XfsComponent

   Gets the forms.

   :return: the forms

getFrontImageColorFormat
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getFrontImageColorFormat()
   :outertype: XfsComponent

   Gets the front image color format.

   :return: the front image color format

getFrontscanColor
^^^^^^^^^^^^^^^^^

.. java:method:: public String getFrontscanColor()
   :outertype: XfsComponent

   Gets the frontscan color.

   :return: the frontscan color

getGuidlights
^^^^^^^^^^^^^

.. java:method:: public String getGuidlights()
   :outertype: XfsComponent

   Gets the guidlights.

   :return: the guidlights

getHasCashBox
^^^^^^^^^^^^^

.. java:method:: public Boolean getHasCashBox()
   :outertype: XfsComponent

   Gets the checks for cash box.

   :return: the checks for cash box

getHasInsertedSensor
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getHasInsertedSensor()
   :outertype: XfsComponent

   Gets the checks for inserted sensor.

   :return: the checks for inserted sensor

getHasShutter
^^^^^^^^^^^^^

.. java:method:: public Boolean getHasShutter()
   :outertype: XfsComponent

   Gets the checks for shutter.

   :return: the checks for shutter

getHasTakenSensor
^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getHasTakenSensor()
   :outertype: XfsComponent

   Gets the checks for taken sensor.

   :return: the checks for taken sensor

getHsmVendor
^^^^^^^^^^^^

.. java:method:: public String getHsmVendor()
   :outertype: XfsComponent

   Gets the hsm vendor.

   :return: the hsm vendor

getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: XfsComponent

   Gets the id.

   :return: the id

getIdConnect
^^^^^^^^^^^^

.. java:method:: public Boolean getIdConnect()
   :outertype: XfsComponent

   Gets the id connect.

   :return: the id connect

getIdKey
^^^^^^^^

.. java:method:: public String getIdKey()
   :outertype: XfsComponent

   Gets the id key.

   :return: the id key

getImageSource
^^^^^^^^^^^^^^

.. java:method:: public String getImageSource()
   :outertype: XfsComponent

   Gets the image source.

   :return: the image source

getImageType
^^^^^^^^^^^^

.. java:method:: public String getImageType()
   :outertype: XfsComponent

   Gets the image type.

   :return: the image type

getImagecapture
^^^^^^^^^^^^^^^

.. java:method:: public String getImagecapture()
   :outertype: XfsComponent

   Gets the imagecapture.

   :return: the imagecapture

getIndicators
^^^^^^^^^^^^^

.. java:method:: public String getIndicators()
   :outertype: XfsComponent

   Gets the indicators.

   :return: the indicators

getInsertOrientation
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getInsertOrientation()
   :outertype: XfsComponent

   Gets the insert orientation.

   :return: the insert orientation

getIntermediateStacker
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getIntermediateStacker()
   :outertype: XfsComponent

   Gets the intermediate stacker.

   :return: the intermediate stacker

getIsApplicationRefuse
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getIsApplicationRefuse()
   :outertype: XfsComponent

   Gets the checks if is application refuse.

   :return: the checks if is application refuse

getIsAutofeed
^^^^^^^^^^^^^

.. java:method:: public Boolean getIsAutofeed()
   :outertype: XfsComponent

   Gets the checks if is autofeed.

   :return: the checks if is autofeed

getIsCardTakenSensor
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getIsCardTakenSensor()
   :outertype: XfsComponent

   Gets the checks if is card taken sensor.

   :return: the checks if is card taken sensor

getIsCompareSignatures
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getIsCompareSignatures()
   :outertype: XfsComponent

   Gets the checks if is compare signatures.

   :return: the checks if is compare signatures

getIsHsmJournaling
^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getIsHsmJournaling()
   :outertype: XfsComponent

   Gets the checks if is hsm journaling.

   :return: the checks if is hsm journaling

getIsIntermediateStacker
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getIsIntermediateStacker()
   :outertype: XfsComponent

   Gets the checks if is intermediate stacker.

   :return: the checks if is intermediate stacker

getIsItemsTakenSensor
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getIsItemsTakenSensor()
   :outertype: XfsComponent

   Gets the checks if is items taken sensor.

   :return: the checks if is items taken sensor

getIsKeyImportThroughParts
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getIsKeyImportThroughParts()
   :outertype: XfsComponent

   Gets the checks if is key import through parts.

   :return: the checks if is key import through parts

getIsMediaPresented
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getIsMediaPresented()
   :outertype: XfsComponent

   Gets the checks if is media presented.

   :return: the checks if is media presented

getIsPinCanPersistAfterUse
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getIsPinCanPersistAfterUse()
   :outertype: XfsComponent

   Gets the checks if is pin can persist after use.

   :return: the checks if is pin can persist after use

getIsPrepareDispense
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getIsPrepareDispense()
   :outertype: XfsComponent

   Gets the checks if is prepare dispense.

   :return: the checks if is prepare dispense

getIsPresentControl
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getIsPresentControl()
   :outertype: XfsComponent

   Gets the checks if is present control.

   :return: the checks if is present control

getIsRescan
^^^^^^^^^^^

.. java:method:: public Boolean getIsRescan()
   :outertype: XfsComponent

   Gets the checks if is rescan.

   :return: the checks if is rescan

getIsRetractCountsItems
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getIsRetractCountsItems()
   :outertype: XfsComponent

   Gets the checks if is retract counts items.

   :return: the checks if is retract counts items

getIsRetractToTransport
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getIsRetractToTransport()
   :outertype: XfsComponent

   Gets the checks if is retract to transport.

   :return: the checks if is retract to transport

getIsSafeDoor
^^^^^^^^^^^^^

.. java:method:: public Boolean getIsSafeDoor()
   :outertype: XfsComponent

   Gets the checks if is safe door.

   :return: the checks if is safe door

getIsSetPinBlockDataRequired
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getIsSetPinBlockDataRequired()
   :outertype: XfsComponent

   Gets the checks if is set pin block data required.

   :return: the checks if is set pin block data required

getIsStamp
^^^^^^^^^^

.. java:method:: public Boolean getIsStamp()
   :outertype: XfsComponent

   Gets the checks if is stamp.

   :return: the checks if is stamp

getIsTypeCombined
^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getIsTypeCombined()
   :outertype: XfsComponent

   Gets the checks if is type combined.

   :return: the checks if is type combined

getItemInfoTypes
^^^^^^^^^^^^^^^^

.. java:method:: public String getItemInfoTypes()
   :outertype: XfsComponent

   Gets the item info types.

   :return: the item info types

getKeyBlockImportFormats
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getKeyBlockImportFormats()
   :outertype: XfsComponent

   Gets the key block import formats.

   :return: the key block import formats

getKeyCheckModes
^^^^^^^^^^^^^^^^

.. java:method:: public String getKeyCheckModes()
   :outertype: XfsComponent

   Gets the key check modes.

   :return: the key check modes

getKeyLock
^^^^^^^^^^

.. java:method:: public Boolean getKeyLock()
   :outertype: XfsComponent

   Gets the key lock.

   :return: the key lock

getKeyNum
^^^^^^^^^

.. java:method:: public Integer getKeyNum()
   :outertype: XfsComponent

   Gets the key num.

   :return: the key num

getKeys
^^^^^^^

.. java:method:: public String getKeys()
   :outertype: XfsComponent

getLogical
^^^^^^^^^^

.. java:method:: public String getLogical()
   :outertype: XfsComponent

   Gets the logical.

   :return: the logical

getLogicalCashUnits
^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<LogicalCashUnit> getLogicalCashUnits()
   :outertype: XfsComponent

   Gets the logical cash units.

   :return: the logical cash units

getMagneticstriperead
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getMagneticstriperead()
   :outertype: XfsComponent

   Gets the magneticstriperead.

   :return: the magneticstriperead

getMagneticstripewrite
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getMagneticstripewrite()
   :outertype: XfsComponent

   Gets the magneticstripewrite.

   :return: the magneticstripewrite

getMax2Retract
^^^^^^^^^^^^^^

.. java:method:: public Integer getMax2Retract()
   :outertype: XfsComponent

getMaxBills
^^^^^^^^^^^

.. java:method:: public Integer getMaxBills()
   :outertype: XfsComponent

getMaxCashInItems
^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getMaxCashInItems()
   :outertype: XfsComponent

   Gets the max cash in items.

   :return: the max cash in items

getMaxCoins
^^^^^^^^^^^

.. java:method:: public Integer getMaxCoins()
   :outertype: XfsComponent

getMaxDataLength
^^^^^^^^^^^^^^^^

.. java:method:: public Integer getMaxDataLength()
   :outertype: XfsComponent

   Gets the max data length.

   :return: the max data length

getMaxDispenseItems
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getMaxDispenseItems()
   :outertype: XfsComponent

   Gets the max dispense items.

   :return: the max dispense items

getMaxMediaOnStacker
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getMaxMediaOnStacker()
   :outertype: XfsComponent

   Gets the max media on stacker.

   :return: the max media on stacker

getMaxNumChars
^^^^^^^^^^^^^^

.. java:method:: public Integer getMaxNumChars()
   :outertype: XfsComponent

   Gets the max num chars.

   :return: the max num chars

getMaxPictures
^^^^^^^^^^^^^^

.. java:method:: public Integer getMaxPictures()
   :outertype: XfsComponent

   Gets the max pictures.

   :return: the max pictures

getMaxRetract
^^^^^^^^^^^^^

.. java:method:: public String getMaxRetract()
   :outertype: XfsComponent

   Gets the max retract.

   :return: the max retract

getMediaTaken
^^^^^^^^^^^^^

.. java:method:: public Boolean getMediaTaken()
   :outertype: XfsComponent

   Gets the media taken.

   :return: the media taken

getMemoryChipProtocols
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getMemoryChipProtocols()
   :outertype: XfsComponent

   Gets the memory chip protocols.

   :return: the memory chip protocols

getMicr
^^^^^^^

.. java:method:: public Boolean getMicr()
   :outertype: XfsComponent

   Gets the micr.

   :return: the micr

getMoveItems
^^^^^^^^^^^^

.. java:method:: public String getMoveItems()
   :outertype: XfsComponent

   Gets the move items.

   :return: the move items

getMultiPage
^^^^^^^^^^^^

.. java:method:: public Boolean getMultiPage()
   :outertype: XfsComponent

   Gets the multi page.

   :return: the multi page

getNumLeds
^^^^^^^^^^

.. java:method:: public Integer getNumLeds()
   :outertype: XfsComponent

   Gets the num leds.

   :return: the num leds

getOcr
^^^^^^

.. java:method:: public Boolean getOcr()
   :outertype: XfsComponent

   Gets the ocr.

   :return: the ocr

getOutputPositions
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getOutputPositions()
   :outertype: XfsComponent

getPaperSources
^^^^^^^^^^^^^^^

.. java:method:: public String getPaperSources()
   :outertype: XfsComponent

   Gets the paper sources.

   :return: the paper sources

getPinFormats
^^^^^^^^^^^^^

.. java:method:: public String getPinFormats()
   :outertype: XfsComponent

   Gets the pin formats.

   :return: the pin formats

getPockets
^^^^^^^^^^

.. java:method:: public Integer getPockets()
   :outertype: XfsComponent

getPositions
^^^^^^^^^^^^

.. java:method:: public String getPositions()
   :outertype: XfsComponent

   Gets the positions.

   :return: the positions

getPowerOff
^^^^^^^^^^^

.. java:method:: public String getPowerOff()
   :outertype: XfsComponent

   Gets the power off.

   :return: the power off

getPowerOn
^^^^^^^^^^

.. java:method:: public String getPowerOn()
   :outertype: XfsComponent

   Gets the power on.

   :return: the power on

getPowerSaveControl
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getPowerSaveControl()
   :outertype: XfsComponent

   Gets the power save control.

   :return: the power save control

getPresentationAlgorithms
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getPresentationAlgorithms()
   :outertype: XfsComponent

   Gets the presentation algorithms.

   :return: the presentation algorithms

getPrintOnRetracts
^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getPrintOnRetracts()
   :outertype: XfsComponent

   Gets the prints the on retracts.

   :return: the prints the on retracts

getPrintSize
^^^^^^^^^^^^

.. java:method:: public String getPrintSize()
   :outertype: XfsComponent

   Gets the prints the size.

   :return: the prints the size

getPrinter
^^^^^^^^^^

.. java:method:: public Boolean getPrinter()
   :outertype: XfsComponent

   Gets the printer.

   :return: the printer

getProgramaticallyDeactivate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getProgramaticallyDeactivate()
   :outertype: XfsComponent

   Gets the programatically deactivate.

   :return: the programatically deactivate

getProvider
^^^^^^^^^^^

.. java:method:: public String getProvider()
   :outertype: XfsComponent

   Gets the provider.

   :return: the provider

getReadForm
^^^^^^^^^^^

.. java:method:: public String getReadForm()
   :outertype: XfsComponent

   Gets the read form.

   :return: the read form

getReadTracks
^^^^^^^^^^^^^

.. java:method:: public String getReadTracks()
   :outertype: XfsComponent

   Gets the read tracks.

   :return: the read tracks

getRefill
^^^^^^^^^

.. java:method:: public Boolean getRefill()
   :outertype: XfsComponent

   Gets the refill.

   :return: the refill

getResetControl
^^^^^^^^^^^^^^^

.. java:method:: public String getResetControl()
   :outertype: XfsComponent

   Gets the reset control.

   :return: the reset control

getResolutions
^^^^^^^^^^^^^^

.. java:method:: public String getResolutions()
   :outertype: XfsComponent

   Gets the resolutions.

   :return: the resolutions

getRetract
^^^^^^^^^^

.. java:method:: public Boolean getRetract()
   :outertype: XfsComponent

getRetractAreas
^^^^^^^^^^^^^^^

.. java:method:: public String getRetractAreas()
   :outertype: XfsComponent

   Gets the retract areas.

   :return: the retract areas

getRetractBins
^^^^^^^^^^^^^^

.. java:method:: public String getRetractBins()
   :outertype: XfsComponent

   Gets the retract bins.

   :return: the retract bins

getRetractStackerActions
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getRetractStackerActions()
   :outertype: XfsComponent

   Gets the retract stacker actions.

   :return: the retract stacker actions

getRetractToDeposit
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getRetractToDeposit()
   :outertype: XfsComponent

getRetractTransportActions
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getRetractTransportActions()
   :outertype: XfsComponent

   Gets the retract transport actions.

   :return: the retract transport actions

getRetractenvelope
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getRetractenvelope()
   :outertype: XfsComponent

   Gets the retractenvelope.

   :return: the retractenvelope

getRsaAuthenticationScheme
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getRsaAuthenticationScheme()
   :outertype: XfsComponent

   Gets the rsa authentication scheme.

   :return: the rsa authentication scheme

getRsaCryptAlgorithm
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getRsaCryptAlgorithm()
   :outertype: XfsComponent

   Gets the rsa crypt algorithm.

   :return: the rsa crypt algorithm

getRsaKeycheckMode
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getRsaKeycheckMode()
   :outertype: XfsComponent

   Gets the rsa keycheck mode.

   :return: the rsa keycheck mode

getRsaSignatureAlgorithm
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getRsaSignatureAlgorithm()
   :outertype: XfsComponent

   Gets the rsa signature algorithm.

   :return: the rsa signature algorithm

getSecurityType
^^^^^^^^^^^^^^^

.. java:method:: public String getSecurityType()
   :outertype: XfsComponent

   Gets the security type.

   :return: the security type

getSensors
^^^^^^^^^^

.. java:method:: public String getSensors()
   :outertype: XfsComponent

   Gets the sensors.

   :return: the sensors

getShutterControl
^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getShutterControl()
   :outertype: XfsComponent

   Gets the shutter control.

   :return: the shutter control

getSignatureScheme
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSignatureScheme()
   :outertype: XfsComponent

   Gets the signature scheme.

   :return: the signature scheme

getStamp
^^^^^^^^

.. java:method:: public String getStamp()
   :outertype: XfsComponent

   Gets the stamp.

   :return: the stamp

getSymbologies
^^^^^^^^^^^^^^

.. java:method:: public String getSymbologies()
   :outertype: XfsComponent

   Gets the symbologies.

   :return: the symbologies

getToner
^^^^^^^^

.. java:method:: public Boolean getToner()
   :outertype: XfsComponent

   Gets the toner.

   :return: the toner

getType
^^^^^^^

.. java:method:: public String getType()
   :outertype: XfsComponent

   Gets the type.

   :return: the type

getValidationAlgorithms
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getValidationAlgorithms()
   :outertype: XfsComponent

   Gets the validation algorithms.

   :return: the validation algorithms

getVandalCheck
^^^^^^^^^^^^^^

.. java:method:: public Boolean getVandalCheck()
   :outertype: XfsComponent

getWindowsPrinter
^^^^^^^^^^^^^^^^^

.. java:method:: public String getWindowsPrinter()
   :outertype: XfsComponent

   Gets the windows printer.

   :return: the windows printer

getWriteForm
^^^^^^^^^^^^

.. java:method:: public String getWriteForm()
   :outertype: XfsComponent

   Gets the write form.

   :return: the write form

getWriteMode
^^^^^^^^^^^^

.. java:method:: public String getWriteMode()
   :outertype: XfsComponent

   Gets the write mode.

   :return: the write mode

getWriteTracks
^^^^^^^^^^^^^^

.. java:method:: public String getWriteTracks()
   :outertype: XfsComponent

   Gets the write tracks.

   :return: the write tracks

getXfsClass
^^^^^^^^^^^

.. java:method:: public String getXfsClass()
   :outertype: XfsComponent

   Gets the xfs class.

   :return: the xfs class

getXfsclasses
^^^^^^^^^^^^^

.. java:method:: public static Set<String> getXfsclasses()
   :outertype: XfsComponent

   Gets the xfsclasses (i.e. ALM, BCR, CAM, CDM...).

   :return: the xfsclasses

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: XfsComponent

setAcceptMedia
^^^^^^^^^^^^^^

.. java:method:: public void setAcceptMedia(Boolean acceptMedia)
   :outertype: XfsComponent

   Sets the accept media.

   :param acceptMedia: the new accept media

setAlgorithms
^^^^^^^^^^^^^

.. java:method:: public void setAlgorithms(String algorithms)
   :outertype: XfsComponent

   Sets the algorithms.

   :param algorithms: the new algorithms

setAutobeep
^^^^^^^^^^^

.. java:method:: public void setAutobeep(String autobeep)
   :outertype: XfsComponent

   Sets the autobeep.

   :param autobeep: the new autobeep

setAutodeposit
^^^^^^^^^^^^^^

.. java:method:: public void setAutodeposit(Boolean autodeposit)
   :outertype: XfsComponent

setAutoretractPeriod
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setAutoretractPeriod(Integer autoretractPeriod)
   :outertype: XfsComponent

   Sets the autoretract period.

   :param autoretractPeriod: the new autoretract period

setAuxiliaries
^^^^^^^^^^^^^^

.. java:method:: public void setAuxiliaries(String auxiliaries)
   :outertype: XfsComponent

   Sets the auxiliaries.

   :param auxiliaries: the new auxiliaries

setBackImageColorFormat
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setBackImageColorFormat(String backImageColorFormat)
   :outertype: XfsComponent

   Sets the back image color format.

   :param backImageColorFormat: the new back image color format

setBackscanColor
^^^^^^^^^^^^^^^^

.. java:method:: public void setBackscanColor(String backscanColor)
   :outertype: XfsComponent

   Sets the backscan color.

   :param backscanColor: the new backscan color

setCamdata
^^^^^^^^^^

.. java:method:: public void setCamdata(String camdata)
   :outertype: XfsComponent

   Sets the camdata.

   :param camdata: the new camdata

setCameras
^^^^^^^^^^

.. java:method:: public void setCameras(String cameras)
   :outertype: XfsComponent

   Sets the cameras.

   :param cameras: the new cameras

setCanFilterSymbologies
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setCanFilterSymbologies(Boolean canFilterSymbologies)
   :outertype: XfsComponent

   Sets the can filter symbologies.

   :param canFilterSymbologies: the new can filter symbologies

setCards
^^^^^^^^

.. java:method:: public void setCards(Integer cards)
   :outertype: XfsComponent

   Sets the cards.

   :param cards: the new cards

setCashin
^^^^^^^^^

.. java:method:: public void setCashin(Boolean cashin)
   :outertype: XfsComponent

setCharSupport
^^^^^^^^^^^^^^

.. java:method:: public void setCharSupport(String charSupport)
   :outertype: XfsComponent

   Sets the char support.

   :param charSupport: the new char support

setChipPower
^^^^^^^^^^^^

.. java:method:: public void setChipPower(String chipPower)
   :outertype: XfsComponent

   Sets the chip power.

   :param chipPower: the new chip power

setChipProtocol
^^^^^^^^^^^^^^^

.. java:method:: public void setChipProtocol(String chipProtocol)
   :outertype: XfsComponent

   Sets the chip protocol.

   :param chipProtocol: the new chip protocol

setChipio
^^^^^^^^^

.. java:method:: public void setChipio(Boolean chipio)
   :outertype: XfsComponent

   Sets the chipio.

   :param chipio: the new chipio

setCodeLineFormat
^^^^^^^^^^^^^^^^^

.. java:method:: public void setCodeLineFormat(String codeLineFormat)
   :outertype: XfsComponent

   Sets the code line format.

   :param codeLineFormat: the new code line format

setCoins
^^^^^^^^

.. java:method:: public void setCoins(Boolean coins)
   :outertype: XfsComponent

setComparemagneticstripe
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setComparemagneticstripe(Boolean comparemagneticstripe)
   :outertype: XfsComponent

   Sets the comparemagneticstripe.

   :param comparemagneticstripe: the new comparemagneticstripe

setCompound
^^^^^^^^^^^

.. java:method:: public void setCompound(Boolean compound)
   :outertype: XfsComponent

   Sets the compound.

   :param compound: the new compound

setControl
^^^^^^^^^^

.. java:method:: public void setControl(String control)
   :outertype: XfsComponent

   Sets the control.

   :param control: the new control

setCursor
^^^^^^^^^

.. java:method:: public void setCursor(Boolean cursor)
   :outertype: XfsComponent

   Sets the cursor.

   :param cursor: the new cursor

setCylinders
^^^^^^^^^^^^

.. java:method:: public void setCylinders(Boolean cylinders)
   :outertype: XfsComponent

setDefaultBackscanColor
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setDefaultBackscanColor(String defaultBackscanColor)
   :outertype: XfsComponent

   Sets the default backscan color.

   :param defaultBackscanColor: the new default backscan color

setDefaultFrontscanColor
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setDefaultFrontscanColor(String defaultFrontscanColor)
   :outertype: XfsComponent

   Sets the default frontscan color.

   :param defaultFrontscanColor: the new default frontscan color

setDeptransport
^^^^^^^^^^^^^^^

.. java:method:: public void setDeptransport(Boolean deptransport)
   :outertype: XfsComponent

   Sets the deptransport.

   :param deptransport: the new deptransport

setDerivationAlgorithms
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setDerivationAlgorithms(String derivationAlgorithms)
   :outertype: XfsComponent

   Sets the derivation algorithms.

   :param derivationAlgorithms: the new derivation algorithms

setDipMode
^^^^^^^^^^

.. java:method:: public void setDipMode(String dipMode)
   :outertype: XfsComponent

   Sets the dip mode.

   :param dipMode: the new dip mode

setDispenseTo
^^^^^^^^^^^^^

.. java:method:: public void setDispenseTo(String dispenseTo)
   :outertype: XfsComponent

   Sets the dispense to.

   :param dispenseTo: the new dispense to

setDisplay
^^^^^^^^^^

.. java:method:: public void setDisplay(String display)
   :outertype: XfsComponent

   Sets the display.

   :param display: the new display

setDisplayLight
^^^^^^^^^^^^^^^

.. java:method:: public void setDisplayLight(Boolean displayLight)
   :outertype: XfsComponent

   Sets the display light.

   :param displayLight: the new display light

setDoors
^^^^^^^^

.. java:method:: public void setDoors(String doors)
   :outertype: XfsComponent

   Sets the doors.

   :param doors: the new doors

setEjectPosition
^^^^^^^^^^^^^^^^

.. java:method:: public void setEjectPosition(String ejectPosition)
   :outertype: XfsComponent

   Sets the eject position.

   :param ejectPosition: the new eject position

setEmvHashAlgorithm
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setEmvHashAlgorithm(String emvHashAlgorithm)
   :outertype: XfsComponent

   Sets the emv hash algorithm.

   :param emvHashAlgorithm: the new emv hash algorithm

setEmvImportSchemes
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setEmvImportSchemes(String emvImportSchemes)
   :outertype: XfsComponent

   Sets the emv import schemes.

   :param emvImportSchemes: the new emv import schemes

setEncioProtocols
^^^^^^^^^^^^^^^^^

.. java:method:: public void setEncioProtocols(String encioProtocols)
   :outertype: XfsComponent

   Sets the encio protocols.

   :param encioProtocols: the new encio protocols

setEncodenames
^^^^^^^^^^^^^^

.. java:method:: public void setEncodenames(String encodenames)
   :outertype: XfsComponent

   Sets the encodenames.

   :param encodenames: the new encodenames

setEncoder
^^^^^^^^^^

.. java:method:: public void setEncoder(Boolean encoder)
   :outertype: XfsComponent

   Sets the encoder.

   :param encoder: the new encoder

setEndorser
^^^^^^^^^^^

.. java:method:: public void setEndorser(Boolean endorser)
   :outertype: XfsComponent

   Sets the endorser.

   :param endorser: the new endorser

setEnvelopesupply
^^^^^^^^^^^^^^^^^

.. java:method:: public void setEnvelopesupply(String envelopesupply)
   :outertype: XfsComponent

   Sets the envelopesupply.

   :param envelopesupply: the new envelopesupply

setExchangeTypes
^^^^^^^^^^^^^^^^

.. java:method:: public void setExchangeTypes(String exchangeTypes)
   :outertype: XfsComponent

   Sets the exchange types.

   :param exchangeTypes: the new exchange types

setExtents
^^^^^^^^^^

.. java:method:: public void setExtents(String extents)
   :outertype: XfsComponent

   Sets the extents.

   :param extents: the new extents

setExtra
^^^^^^^^

.. java:method:: public void setExtra(String extra)
   :outertype: XfsComponent

   Sets the extra.

   :param extra: the new extra

setFinancialDevices
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFinancialDevices(List<FinancialDevice> financialDevices)
   :outertype: XfsComponent

   Sets the financial devices.

   :param financialDevices: the new financial devices

setFontnames
^^^^^^^^^^^^

.. java:method:: public void setFontnames(String fontnames)
   :outertype: XfsComponent

   Sets the fontnames.

   :param fontnames: the new fontnames

setForms
^^^^^^^^

.. java:method:: public void setForms(Boolean forms)
   :outertype: XfsComponent

   Sets the forms.

   :param forms: the new forms

setFrontImageColorFormat
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFrontImageColorFormat(String frontImageColorFormat)
   :outertype: XfsComponent

   Sets the front image color format.

   :param frontImageColorFormat: the new front image color format

setFrontscanColor
^^^^^^^^^^^^^^^^^

.. java:method:: public void setFrontscanColor(String frontscanColor)
   :outertype: XfsComponent

   Sets the frontscan color.

   :param frontscanColor: the new frontscan color

setGuidlights
^^^^^^^^^^^^^

.. java:method:: public void setGuidlights(String guidlights)
   :outertype: XfsComponent

   Sets the guidlights.

   :param guidlights: the new guidlights

setHasCashBox
^^^^^^^^^^^^^

.. java:method:: public void setHasCashBox(Boolean hasCashBox)
   :outertype: XfsComponent

   Sets the checks for cash box.

   :param hasCashBox: the new checks for cash box

setHasInsertedSensor
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHasInsertedSensor(Boolean hasInsertedSensor)
   :outertype: XfsComponent

   Sets the checks for inserted sensor.

   :param hasInsertedSensor: the new checks for inserted sensor

setHasShutter
^^^^^^^^^^^^^

.. java:method:: public void setHasShutter(Boolean hasShutter)
   :outertype: XfsComponent

   Sets the checks for shutter.

   :param hasShutter: the new checks for shutter

setHasTakenSensor
^^^^^^^^^^^^^^^^^

.. java:method:: public void setHasTakenSensor(Boolean hasTakenSensor)
   :outertype: XfsComponent

   Sets the checks for taken sensor.

   :param hasTakenSensor: the new checks for taken sensor

setHsmVendor
^^^^^^^^^^^^

.. java:method:: public void setHsmVendor(String hsmVendor)
   :outertype: XfsComponent

   Sets the hsm vendor.

   :param hsmVendor: the new hsm vendor

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: XfsComponent

   Sets the id.

   :param id: the new id

setIdConnect
^^^^^^^^^^^^

.. java:method:: public void setIdConnect(Boolean idConnect)
   :outertype: XfsComponent

   Sets the id connect.

   :param idConnect: the new id connect

setIdKey
^^^^^^^^

.. java:method:: public void setIdKey(String idKey)
   :outertype: XfsComponent

   Sets the id key.

   :param idKey: the new id key

setImageSource
^^^^^^^^^^^^^^

.. java:method:: public void setImageSource(String imageSource)
   :outertype: XfsComponent

   Sets the image source.

   :param imageSource: the new image source

setImageType
^^^^^^^^^^^^

.. java:method:: public void setImageType(String imageType)
   :outertype: XfsComponent

   Sets the image type.

   :param imageType: the new image type

setImagecapture
^^^^^^^^^^^^^^^

.. java:method:: public void setImagecapture(String imagecapture)
   :outertype: XfsComponent

   Sets the imagecapture.

   :param imagecapture: the new imagecapture

setIndicators
^^^^^^^^^^^^^

.. java:method:: public void setIndicators(String indicators)
   :outertype: XfsComponent

   Sets the indicators.

   :param indicators: the new indicators

setInsertOrientation
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setInsertOrientation(String insertOrientation)
   :outertype: XfsComponent

   Sets the insert orientation.

   :param insertOrientation: the new insert orientation

setIntermediateStacker
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setIntermediateStacker(Integer intermediateStacker)
   :outertype: XfsComponent

   Sets the intermediate stacker.

   :param intermediateStacker: the new intermediate stacker

setIsApplicationRefuse
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setIsApplicationRefuse(Boolean isApplicationRefuse)
   :outertype: XfsComponent

   Sets the checks if is application refuse.

   :param isApplicationRefuse: the new checks if is application refuse

setIsAutofeed
^^^^^^^^^^^^^

.. java:method:: public void setIsAutofeed(Boolean isAutofeed)
   :outertype: XfsComponent

   Sets the checks if is autofeed.

   :param isAutofeed: the new checks if is autofeed

setIsCardTakenSensor
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setIsCardTakenSensor(Boolean isCardTakenSensor)
   :outertype: XfsComponent

   Sets the checks if is card taken sensor.

   :param isCardTakenSensor: the new checks if is card taken sensor

setIsCompareSignatures
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setIsCompareSignatures(Boolean isCompareSignatures)
   :outertype: XfsComponent

   Sets the checks if is compare signatures.

   :param isCompareSignatures: the new checks if is compare signatures

setIsHsmJournaling
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setIsHsmJournaling(Boolean isHsmJournaling)
   :outertype: XfsComponent

   Sets the checks if is hsm journaling.

   :param isHsmJournaling: the new checks if is hsm journaling

setIsIntermediateStacker
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setIsIntermediateStacker(Boolean isIntermediateStacker)
   :outertype: XfsComponent

   Sets the checks if is intermediate stacker.

   :param isIntermediateStacker: the new checks if is intermediate stacker

setIsItemsTakenSensor
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setIsItemsTakenSensor(Boolean isItemsTakenSensor)
   :outertype: XfsComponent

   Sets the checks if is items taken sensor.

   :param isItemsTakenSensor: the new checks if is items taken sensor

setIsKeyImportThroughParts
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setIsKeyImportThroughParts(Boolean isKeyImportThroughParts)
   :outertype: XfsComponent

   Sets the checks if is key import through parts.

   :param isKeyImportThroughParts: the new checks if is key import through parts

setIsMediaPresented
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setIsMediaPresented(Boolean isMediaPresented)
   :outertype: XfsComponent

   Sets the checks if is media presented.

   :param isMediaPresented: the new checks if is media presented

setIsPinCanPersistAfterUse
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setIsPinCanPersistAfterUse(Boolean isPinCanPersistAfterUse)
   :outertype: XfsComponent

   Sets the checks if is pin can persist after use.

   :param isPinCanPersistAfterUse: the new checks if is pin can persist after use

setIsPrepareDispense
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setIsPrepareDispense(Boolean isPrepareDispense)
   :outertype: XfsComponent

   Sets the checks if is prepare dispense.

   :param isPrepareDispense: the new checks if is prepare dispense

setIsPresentControl
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setIsPresentControl(Boolean isPresentControl)
   :outertype: XfsComponent

   Sets the checks if is present control.

   :param isPresentControl: the new checks if is present control

setIsRescan
^^^^^^^^^^^

.. java:method:: public void setIsRescan(Boolean isRescan)
   :outertype: XfsComponent

   Sets the checks if is rescan.

   :param isRescan: the new checks if is rescan

setIsRetractCountsItems
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setIsRetractCountsItems(Boolean isRetractCountsItems)
   :outertype: XfsComponent

   Sets the checks if is retract counts items.

   :param isRetractCountsItems: the new checks if is retract counts items

setIsRetractToTransport
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setIsRetractToTransport(Boolean isRetractToTransport)
   :outertype: XfsComponent

   Sets the checks if is retract to transport.

   :param isRetractToTransport: the new checks if is retract to transport

setIsSafeDoor
^^^^^^^^^^^^^

.. java:method:: public void setIsSafeDoor(Boolean isSafeDoor)
   :outertype: XfsComponent

   Sets the checks if is safe door.

   :param isSafeDoor: the new checks if is safe door

setIsSetPinBlockDataRequired
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setIsSetPinBlockDataRequired(Boolean isSetPinBlockDataRequired)
   :outertype: XfsComponent

   Sets the checks if is set pin block data required.

   :param isSetPinBlockDataRequired: the new checks if is set pin block data required

setIsStamp
^^^^^^^^^^

.. java:method:: public void setIsStamp(Boolean isStamp)
   :outertype: XfsComponent

   Sets the checks if is stamp.

   :param isStamp: the new checks if is stamp

setIsTypeCombined
^^^^^^^^^^^^^^^^^

.. java:method:: public void setIsTypeCombined(Boolean isTypeCombined)
   :outertype: XfsComponent

   Sets the checks if is type combined.

   :param isTypeCombined: the new checks if is type combined

setItemInfoTypes
^^^^^^^^^^^^^^^^

.. java:method:: public void setItemInfoTypes(String itemInfoTypes)
   :outertype: XfsComponent

   Sets the item info types.

   :param itemInfoTypes: the new item info types

setKeyBlockImportFormats
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setKeyBlockImportFormats(String keyBlockImportFormats)
   :outertype: XfsComponent

   Sets the key block import formats.

   :param keyBlockImportFormats: the new key block import formats

setKeyCheckModes
^^^^^^^^^^^^^^^^

.. java:method:: public void setKeyCheckModes(String keyCheckModes)
   :outertype: XfsComponent

   Sets the key check modes.

   :param keyCheckModes: the new key check modes

setKeyLock
^^^^^^^^^^

.. java:method:: public void setKeyLock(Boolean keyLock)
   :outertype: XfsComponent

   Sets the key lock.

   :param keyLock: the new key lock

setKeyNum
^^^^^^^^^

.. java:method:: public void setKeyNum(Integer keyNum)
   :outertype: XfsComponent

   Sets the key num.

   :param keyNum: the new key num

setKeys
^^^^^^^

.. java:method:: public void setKeys(String keys)
   :outertype: XfsComponent

setLogical
^^^^^^^^^^

.. java:method:: public void setLogical(String logical)
   :outertype: XfsComponent

   Sets the logical.

   :param logical: the new logical

setLogicalCashUnits
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setLogicalCashUnits(List<LogicalCashUnit> logicalCashUnits)
   :outertype: XfsComponent

   Sets the logical cash units.

   :param logicalCashUnits: the new logical cash units

setMagneticstriperead
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setMagneticstriperead(Boolean magneticstriperead)
   :outertype: XfsComponent

   Sets the magneticstriperead.

   :param magneticstriperead: the new magneticstriperead

setMagneticstripewrite
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setMagneticstripewrite(Boolean magneticstripewrite)
   :outertype: XfsComponent

   Sets the magneticstripewrite.

   :param magneticstripewrite: the new magneticstripewrite

setMax2Retract
^^^^^^^^^^^^^^

.. java:method:: public void setMax2Retract(Integer max2Retract)
   :outertype: XfsComponent

setMaxBills
^^^^^^^^^^^

.. java:method:: public void setMaxBills(Integer maxBills)
   :outertype: XfsComponent

setMaxCashInItems
^^^^^^^^^^^^^^^^^

.. java:method:: public void setMaxCashInItems(Integer maxCashInItems)
   :outertype: XfsComponent

   Sets the max cash in items.

   :param maxCashInItems: the new max cash in items

setMaxCoins
^^^^^^^^^^^

.. java:method:: public void setMaxCoins(Integer maxCoins)
   :outertype: XfsComponent

setMaxDataLength
^^^^^^^^^^^^^^^^

.. java:method:: public void setMaxDataLength(Integer maxDataLength)
   :outertype: XfsComponent

   Sets the max data length.

   :param maxDataLength: the new max data length

setMaxDispenseItems
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setMaxDispenseItems(Integer maxDispenseItems)
   :outertype: XfsComponent

   Sets the max dispense items.

   :param maxDispenseItems: the new max dispense items

setMaxMediaOnStacker
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setMaxMediaOnStacker(Integer maxMediaOnStacker)
   :outertype: XfsComponent

   Sets the max media on stacker.

   :param maxMediaOnStacker: the new max media on stacker

setMaxNumChars
^^^^^^^^^^^^^^

.. java:method:: public void setMaxNumChars(Integer maxNumChars)
   :outertype: XfsComponent

   Sets the max num chars.

   :param maxNumChars: the new max num chars

setMaxPictures
^^^^^^^^^^^^^^

.. java:method:: public void setMaxPictures(Integer maxPictures)
   :outertype: XfsComponent

   Sets the max pictures.

   :param maxPictures: the new max pictures

setMaxRetract
^^^^^^^^^^^^^

.. java:method:: public void setMaxRetract(String maxRetract)
   :outertype: XfsComponent

   Sets the max retract.

   :param maxRetract: the new max retract

setMediaTaken
^^^^^^^^^^^^^

.. java:method:: public void setMediaTaken(Boolean mediaTaken)
   :outertype: XfsComponent

   Sets the media taken.

   :param mediaTaken: the new media taken

setMemoryChipProtocols
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setMemoryChipProtocols(String memoryChipProtocols)
   :outertype: XfsComponent

   Sets the memory chip protocols.

   :param memoryChipProtocols: the new memory chip protocols

setMicr
^^^^^^^

.. java:method:: public void setMicr(Boolean micr)
   :outertype: XfsComponent

   Sets the micr.

   :param micr: the new micr

setMoveItems
^^^^^^^^^^^^

.. java:method:: public void setMoveItems(String moveItems)
   :outertype: XfsComponent

   Sets the move items.

   :param moveItems: the new move items

setMultiPage
^^^^^^^^^^^^

.. java:method:: public void setMultiPage(Boolean multiPage)
   :outertype: XfsComponent

   Sets the multi page.

   :param multiPage: the new multi page

setNumLeds
^^^^^^^^^^

.. java:method:: public void setNumLeds(Integer numLeds)
   :outertype: XfsComponent

   Sets the num leds.

   :param numLeds: the new num leds

setOcr
^^^^^^

.. java:method:: public void setOcr(Boolean ocr)
   :outertype: XfsComponent

   Sets the ocr.

   :param ocr: the new ocr

setOutputPositions
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setOutputPositions(String outputPositions)
   :outertype: XfsComponent

setPaperSources
^^^^^^^^^^^^^^^

.. java:method:: public void setPaperSources(String paperSources)
   :outertype: XfsComponent

   Sets the paper sources.

   :param paperSources: the new paper sources

setPinFormats
^^^^^^^^^^^^^

.. java:method:: public void setPinFormats(String pinFormats)
   :outertype: XfsComponent

   Sets the pin formats.

   :param pinFormats: the new pin formats

setPockets
^^^^^^^^^^

.. java:method:: public void setPockets(Integer pockets)
   :outertype: XfsComponent

setPositions
^^^^^^^^^^^^

.. java:method:: public void setPositions(String positions)
   :outertype: XfsComponent

   Sets the positions.

   :param positions: the new positions

setPowerOff
^^^^^^^^^^^

.. java:method:: public void setPowerOff(String powerOff)
   :outertype: XfsComponent

   Sets the power off.

   :param powerOff: the new power off

setPowerOn
^^^^^^^^^^

.. java:method:: public void setPowerOn(String powerOn)
   :outertype: XfsComponent

   Sets the power on.

   :param powerOn: the new power on

setPowerSaveControl
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setPowerSaveControl(Boolean powerSaveControl)
   :outertype: XfsComponent

   Sets the power save control.

   :param powerSaveControl: the new power save control

setPresentationAlgorithms
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setPresentationAlgorithms(String presentationAlgorithms)
   :outertype: XfsComponent

   Sets the presentation algorithms.

   :param presentationAlgorithms: the new presentation algorithms

setPrintOnRetracts
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setPrintOnRetracts(Boolean printOnRetracts)
   :outertype: XfsComponent

   Sets the prints the on retracts.

   :param printOnRetracts: the new prints the on retracts

setPrintSize
^^^^^^^^^^^^

.. java:method:: public void setPrintSize(String printSize)
   :outertype: XfsComponent

   Sets the prints the size.

   :param printSize: the new prints the size

setPrinter
^^^^^^^^^^

.. java:method:: public void setPrinter(Boolean printer)
   :outertype: XfsComponent

   Sets the printer.

   :param printer: the new printer

setProgramaticallyDeactivate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setProgramaticallyDeactivate(Boolean programaticallyDeactivate)
   :outertype: XfsComponent

   Sets the programatically deactivate.

   :param programaticallyDeactivate: the new programatically deactivate

setProvider
^^^^^^^^^^^

.. java:method:: public void setProvider(String provider)
   :outertype: XfsComponent

   Sets the provider.

   :param provider: the new provider

setReadForm
^^^^^^^^^^^

.. java:method:: public void setReadForm(String readForm)
   :outertype: XfsComponent

   Sets the read form.

   :param readForm: the new read form

setReadTracks
^^^^^^^^^^^^^

.. java:method:: public void setReadTracks(String readTracks)
   :outertype: XfsComponent

   Sets the read tracks.

   :param readTracks: the new read tracks

setRefill
^^^^^^^^^

.. java:method:: public void setRefill(Boolean refill)
   :outertype: XfsComponent

   Sets the refill.

   :param refill: the new refill

setResetControl
^^^^^^^^^^^^^^^

.. java:method:: public void setResetControl(String resetControl)
   :outertype: XfsComponent

   Sets the reset control.

   :param resetControl: the new reset control

setResolutions
^^^^^^^^^^^^^^

.. java:method:: public void setResolutions(String resolutions)
   :outertype: XfsComponent

   Sets the resolutions.

   :param resolutions: the new resolutions

setRetract
^^^^^^^^^^

.. java:method:: public void setRetract(Boolean retract)
   :outertype: XfsComponent

setRetractAreas
^^^^^^^^^^^^^^^

.. java:method:: public void setRetractAreas(String retractAreas)
   :outertype: XfsComponent

   Sets the retract areas.

   :param retractAreas: the new retract areas

setRetractBins
^^^^^^^^^^^^^^

.. java:method:: public void setRetractBins(String retractBins)
   :outertype: XfsComponent

   Sets the retract bins.

   :param retractBins: the new retract bins

setRetractStackerActions
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setRetractStackerActions(String retractStackerActions)
   :outertype: XfsComponent

   Sets the retract stacker actions.

   :param retractStackerActions: the new retract stacker actions

setRetractToDeposit
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setRetractToDeposit(Boolean retractToDeposit)
   :outertype: XfsComponent

setRetractTransportActions
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setRetractTransportActions(String retractTransportActions)
   :outertype: XfsComponent

   Sets the retract transport actions.

   :param retractTransportActions: the new retract transport actions

setRetractenvelope
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setRetractenvelope(String retractenvelope)
   :outertype: XfsComponent

   Sets the retractenvelope.

   :param retractenvelope: the new retractenvelope

setRsaAuthenticationScheme
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setRsaAuthenticationScheme(String rsaAuthenticationScheme)
   :outertype: XfsComponent

   Sets the rsa authentication scheme.

   :param rsaAuthenticationScheme: the new rsa authentication scheme

setRsaCryptAlgorithm
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setRsaCryptAlgorithm(String rsaCryptAlgorithm)
   :outertype: XfsComponent

   Sets the rsa crypt algorithm.

   :param rsaCryptAlgorithm: the new rsa crypt algorithm

setRsaKeycheckMode
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setRsaKeycheckMode(String rsaKeycheckMode)
   :outertype: XfsComponent

   Sets the rsa keycheck mode.

   :param rsaKeycheckMode: the new rsa keycheck mode

setRsaSignatureAlgorithm
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setRsaSignatureAlgorithm(String rsaSignatureAlgorithm)
   :outertype: XfsComponent

   Sets the rsa signature algorithm.

   :param rsaSignatureAlgorithm: the new rsa signature algorithm

setSecurityType
^^^^^^^^^^^^^^^

.. java:method:: public void setSecurityType(String securityType)
   :outertype: XfsComponent

   Sets the security type.

   :param securityType: the new security type

setSensors
^^^^^^^^^^

.. java:method:: public void setSensors(String sensors)
   :outertype: XfsComponent

   Sets the sensors.

   :param sensors: the new sensors

setShutterControl
^^^^^^^^^^^^^^^^^

.. java:method:: public void setShutterControl(Boolean shutterControl)
   :outertype: XfsComponent

   Sets the shutter control.

   :param shutterControl: the new shutter control

setSignatureScheme
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSignatureScheme(String signatureScheme)
   :outertype: XfsComponent

   Sets the signature scheme.

   :param signatureScheme: the new signature scheme

setStamp
^^^^^^^^

.. java:method:: public void setStamp(String stamp)
   :outertype: XfsComponent

   Sets the stamp.

   :param stamp: the new stamp

setSymbologies
^^^^^^^^^^^^^^

.. java:method:: public void setSymbologies(String symbologies)
   :outertype: XfsComponent

   Sets the symbologies.

   :param symbologies: the new symbologies

setToner
^^^^^^^^

.. java:method:: public void setToner(Boolean toner)
   :outertype: XfsComponent

   Sets the toner.

   :param toner: the new toner

setType
^^^^^^^

.. java:method:: public void setType(String type)
   :outertype: XfsComponent

   Sets the type.

   :param type: the new type

setValidationAlgorithms
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setValidationAlgorithms(String validationAlgorithms)
   :outertype: XfsComponent

   Sets the validation algorithms.

   :param validationAlgorithms: the new validation algorithms

setVandalCheck
^^^^^^^^^^^^^^

.. java:method:: public void setVandalCheck(Boolean vandalCheck)
   :outertype: XfsComponent

setWindowsPrinter
^^^^^^^^^^^^^^^^^

.. java:method:: public void setWindowsPrinter(String windowsPrinter)
   :outertype: XfsComponent

   Sets the windows printer.

   :param windowsPrinter: the new windows printer

setWriteForm
^^^^^^^^^^^^

.. java:method:: public void setWriteForm(String writeForm)
   :outertype: XfsComponent

   Sets the write form.

   :param writeForm: the new write form

setWriteMode
^^^^^^^^^^^^

.. java:method:: public void setWriteMode(String writeMode)
   :outertype: XfsComponent

   Sets the write mode.

   :param writeMode: the new write mode

setWriteTracks
^^^^^^^^^^^^^^

.. java:method:: public void setWriteTracks(String writeTracks)
   :outertype: XfsComponent

   Sets the write tracks.

   :param writeTracks: the new write tracks

setXfsClass
^^^^^^^^^^^

.. java:method:: public void setXfsClass(String xfsClass)
   :outertype: XfsComponent

   Sets the xfs class.

   :param xfsClass: the new xfs class

