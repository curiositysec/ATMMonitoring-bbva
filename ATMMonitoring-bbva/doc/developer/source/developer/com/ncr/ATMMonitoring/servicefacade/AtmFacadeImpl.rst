.. java:import:: java.io InputStream

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: org.apache.commons.lang StringUtils

.. java:import:: org.apache.log4j Logger

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

.. java:import:: com.ncr ATMMonitoring.pojo.Installation

.. java:import:: com.ncr ATMMonitoring.pojo.Query

.. java:import:: com.ncr ATMMonitoring.pojo.ScheduledUpdate

.. java:import:: com.ncr ATMMonitoring.pojo.Terminal

.. java:import:: com.ncr ATMMonitoring.pojo.TerminalConfig

.. java:import:: com.ncr ATMMonitoring.pojo.TerminalModel

.. java:import:: com.ncr ATMMonitoring.pojo.User

.. java:import:: com.ncr ATMMonitoring.service.InstallationService

.. java:import:: com.ncr ATMMonitoring.service.ScheduledUpdateService

.. java:import:: com.ncr ATMMonitoring.service.TerminalConfigService

.. java:import:: com.ncr ATMMonitoring.service.TerminalModelService

.. java:import:: com.ncr ATMMonitoring.service.TerminalService

.. java:import:: com.ncr ATMMonitoring.service.UserService

.. java:import:: com.ncr ATMMonitoring.servicefacade.AtmFacade

.. java:import:: com.ncr ATMMonitoring.socket.SocketService

AtmFacadeImpl
=============

.. java:package:: com.ncr.ATMMonitoring.servicefacade
   :noindex:

.. java:type:: @Service public class AtmFacadeImpl implements AtmFacade

   Default implementation of the AtmFacade

   :author: Otto Abreu

Methods
-------
addATMByFile
^^^^^^^^^^^^

.. java:method:: @Override public void addATMByFile(InputStream file)
   :outertype: AtmFacadeImpl

addATMMachine
^^^^^^^^^^^^^

.. java:method:: @Override public void addATMMachine(TerminalConfig terminalConfig)
   :outertype: AtmFacadeImpl

addScheduledUpdate
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addScheduledUpdate(ScheduledUpdate scheduledUpdate)
   :outertype: AtmFacadeImpl

addUpdateATM
^^^^^^^^^^^^

.. java:method:: @Override public void addUpdateATM(Terminal terminal, int operType)
   :outertype: AtmFacadeImpl

addUpdateATMInstallation
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addUpdateATMInstallation(Installation installation, int operType)
   :outertype: AtmFacadeImpl

addUpdateATMModel
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addUpdateATMModel(TerminalModel terminalModel, int operType)
   :outertype: AtmFacadeImpl

atmSnmpUpdate
^^^^^^^^^^^^^

.. java:method:: @Override public Terminal atmSnmpUpdate(int atmId)
   :outertype: AtmFacadeImpl

atmSnmpUpdate
^^^^^^^^^^^^^

.. java:method:: @Override public void atmSnmpUpdate(Query query)
   :outertype: AtmFacadeImpl

existScheduledUpdate
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean existScheduledUpdate(ScheduledUpdate update)
   :outertype: AtmFacadeImpl

getATM
^^^^^^

.. java:method:: @Override public Terminal getATM(String serialNumber, Long matricula, String ip, String macAddress)
   :outertype: AtmFacadeImpl

getATMById
^^^^^^^^^^

.. java:method:: @Override public Terminal getATMById(int id)
   :outertype: AtmFacadeImpl

getATMInstallation
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Installation getATMInstallation(int installationId)
   :outertype: AtmFacadeImpl

getATMMachine
^^^^^^^^^^^^^

.. java:method:: @Override public TerminalConfig getATMMachine(int atmId)
   :outertype: AtmFacadeImpl

getATMModel
^^^^^^^^^^^

.. java:method:: @Override public TerminalModel getATMModel(int modelId)
   :outertype: AtmFacadeImpl

listATMByBanks
^^^^^^^^^^^^^^

.. java:method:: @Override public List<Terminal> listATMByBanks(Set<BankCompany> banksCompanies, String sort, String order)
   :outertype: AtmFacadeImpl

listATMByBanksAndAtmId
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Terminal> listATMByBanksAndAtmId(Set<BankCompany> banksCompanies, List<Integer> ids)
   :outertype: AtmFacadeImpl

listATMInstallations
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Installation> listATMInstallations()
   :outertype: AtmFacadeImpl

listATMMachines
^^^^^^^^^^^^^^^

.. java:method:: @Override public List<TerminalConfig> listATMMachines()
   :outertype: AtmFacadeImpl

listATMModels
^^^^^^^^^^^^^

.. java:method:: @Override public List<TerminalModel> listATMModels()
   :outertype: AtmFacadeImpl

listATMModelsByManufacturer
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Map<String, List<TerminalModel>> listATMModelsByManufacturer()
   :outertype: AtmFacadeImpl

listAllATM
^^^^^^^^^^

.. java:method:: @Override public List<Terminal> listAllATM()
   :outertype: AtmFacadeImpl

listScheduledUpdates
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<ScheduledUpdate> listScheduledUpdates(int updateType)
   :outertype: AtmFacadeImpl

listScheduledUpdates
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<ScheduledUpdate> listScheduledUpdates(String username, int updateType)
   :outertype: AtmFacadeImpl

removeATMInstallation
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void removeATMInstallation(int installationId)
   :outertype: AtmFacadeImpl

removeATMModel
^^^^^^^^^^^^^^

.. java:method:: @Override public void removeATMModel(int atmModelId)
   :outertype: AtmFacadeImpl

removeScheduledUpdate
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void removeScheduledUpdate(int updateId)
   :outertype: AtmFacadeImpl

