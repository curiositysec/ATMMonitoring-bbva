.. java:import:: java.io InputStream

.. java:import:: java.security GeneralSecurityException

.. java:import:: java.text ParseException

.. java:import:: java.text SimpleDateFormat

.. java:import:: java.util Collection

.. java:import:: java.util Date

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Set

.. java:import:: java.util Vector

.. java:import:: org.apache.commons.io IOUtils

.. java:import:: org.apache.log4j Logger

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.beans.factory.annotation Value

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.dao.TerminalDAO

.. java:import:: com.ncr ATMMonitoring.pojo.AuditableInternetExplorer

.. java:import:: com.ncr ATMMonitoring.pojo.AuditableSoftwareAggregate

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

.. java:import:: com.ncr ATMMonitoring.pojo.FinancialDevice

.. java:import:: com.ncr ATMMonitoring.pojo.HardwareDevice

.. java:import:: com.ncr ATMMonitoring.pojo.Hotfix

.. java:import:: com.ncr ATMMonitoring.pojo.Installation

.. java:import:: com.ncr ATMMonitoring.pojo.InternetExplorer

.. java:import:: com.ncr ATMMonitoring.pojo.JxfsComponent

.. java:import:: com.ncr ATMMonitoring.pojo.OperatingSystem

.. java:import:: com.ncr ATMMonitoring.pojo.Software

.. java:import:: com.ncr ATMMonitoring.pojo.SoftwareAggregate

.. java:import:: com.ncr ATMMonitoring.pojo.Terminal

.. java:import:: com.ncr ATMMonitoring.pojo.TerminalConfig

.. java:import:: com.ncr ATMMonitoring.pojo.TerminalModel

.. java:import:: com.ncr ATMMonitoring.pojo.XfsComponent

.. java:import:: com.ncr ATMMonitoring.socket.ATMWrongDataException

.. java:import:: com.ncr ATMMonitoring.utils.Utils

.. java:import:: com.ncr.agent.baseData ATMDataStorePojo

.. java:import:: com.ncr.agent.baseData.os.module BaseBoardPojo

.. java:import:: com.ncr.agent.baseData.os.module BiosPojo

.. java:import:: com.ncr.agent.baseData.os.module CDROMDrivePojo

.. java:import:: com.ncr.agent.baseData.os.module ComputerSystemPojo

.. java:import:: com.ncr.agent.baseData.os.module DesktopMonitorPojo

.. java:import:: com.ncr.agent.baseData.os.module DiskDrivePojo

.. java:import:: com.ncr.agent.baseData.os.module FloppyDrivePojo

.. java:import:: com.ncr.agent.baseData.os.module HotfixPojo

.. java:import:: com.ncr.agent.baseData.os.module IExplorerPojo

.. java:import:: com.ncr.agent.baseData.os.module KeyboardPojo

.. java:import:: com.ncr.agent.baseData.os.module LogicalDiskPojo

.. java:import:: com.ncr.agent.baseData.os.module NetworkAdapterSettingPojo

.. java:import:: com.ncr.agent.baseData.os.module OperatingSystemPojo

.. java:import:: com.ncr.agent.baseData.os.module ParallelPortPojo

.. java:import:: com.ncr.agent.baseData.os.module PhysicalMemoryPojo

.. java:import:: com.ncr.agent.baseData.os.module PointingDevicePojo

.. java:import:: com.ncr.agent.baseData.os.module ProcessorPojo

.. java:import:: com.ncr.agent.baseData.os.module ProductPojo

.. java:import:: com.ncr.agent.baseData.os.module SCSIControllerPojo

.. java:import:: com.ncr.agent.baseData.os.module SerialPortPojo

.. java:import:: com.ncr.agent.baseData.os.module SoundDevicePojo

.. java:import:: com.ncr.agent.baseData.os.module SystemSlotPojo

.. java:import:: com.ncr.agent.baseData.os.module USBControllerPojo

.. java:import:: com.ncr.agent.baseData.os.module UsbHubPojo

.. java:import:: com.ncr.agent.baseData.os.module VideoControllerPojo

.. java:import:: com.ncr.agent.baseData.os.module._1394ControllerPojo

.. java:import:: com.ncr.agent.baseData.standard.jxfs.alm CapabilitiesJxfsALMCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.cam CapabilitiesJxfsCAMCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.cdr CapabilitiesJxfsCDRCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.chk CapabilitiesJxfsCHKCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.dep CapabilitiesJxfsDEPCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.msd CapabilitiesJxfsMSDCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.pin CapabilitiesJxfsPINCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.ptr CapabilitiesJxfsPTRCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.scn CapabilitiesJxfsSCNCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.siu CapabilitiesJxfsSIUCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.tio CapabilitiesJxfsTIOCollector

.. java:import:: com.ncr.agent.baseData.standard.jxfs.vdm CapabilitiesJxfsVDMCollector

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

.. java:import:: com.ncr.agent.baseData.vendor.utils FinancialDevicePojo

.. java:import:: com.ncr.agent.baseData.vendor.utils FinancialPackagePojo

.. java:import:: com.ncr.agent.baseData.vendor.utils FinancialTerminalPojo

TerminalServiceImpl
===================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class TerminalServiceImpl implements TerminalService

   The Class TerminalServiceImpl. Default implementation of the TerminalService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addInstallationAndUpdateHistoricalData
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addInstallationAndUpdateHistoricalData(Terminal terminal, Installation installation)
   :outertype: TerminalServiceImpl

addTerminal
^^^^^^^^^^^

.. java:method:: @Override public void addTerminal(Terminal terminal)
   :outertype: TerminalServiceImpl

checkDateLicense
^^^^^^^^^^^^^^^^

.. java:method:: @Override public void checkDateLicense()
   :outertype: TerminalServiceImpl

getTerminal
^^^^^^^^^^^

.. java:method:: @Override public Terminal getTerminal(Integer id)
   :outertype: TerminalServiceImpl

importJsonTerminal
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean importJsonTerminal(InputStream is)
   :outertype: TerminalServiceImpl

listTerminals
^^^^^^^^^^^^^

.. java:method:: @Override public List<Terminal> listTerminals()
   :outertype: TerminalServiceImpl

listTerminalsByBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> banks)
   :outertype: TerminalServiceImpl

listTerminalsByBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> banks, String sort, String order)
   :outertype: TerminalServiceImpl

listTerminalsByBankCompany
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Terminal> listTerminalsByBankCompany(BankCompany bank)
   :outertype: TerminalServiceImpl

listTerminalsByIdsAndBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Terminal> listTerminalsByIdsAndBankCompanies(List<Integer> terminalIds, Set<BankCompany> bankCompanies)
   :outertype: TerminalServiceImpl

loadTerminalByIp
^^^^^^^^^^^^^^^^

.. java:method:: @Override public Terminal loadTerminalByIp(String ip)
   :outertype: TerminalServiceImpl

loadTerminalByMac
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Terminal loadTerminalByMac(String mac)
   :outertype: TerminalServiceImpl

loadTerminalByMatricula
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Terminal loadTerminalByMatricula(Long matricula)
   :outertype: TerminalServiceImpl

loadTerminalBySerialNumber
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Terminal loadTerminalBySerialNumber(String serialNumber)
   :outertype: TerminalServiceImpl

persistDataStoreTerminal
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Terminal persistDataStoreTerminal(ATMDataStorePojo dataStoreTerminal)
   :outertype: TerminalServiceImpl

updateTerminal
^^^^^^^^^^^^^^

.. java:method:: @Override public void updateTerminal(Terminal terminal)
   :outertype: TerminalServiceImpl

