.. java:import:: java.io InputStream

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

.. java:import:: com.ncr ATMMonitoring.pojo.Installation

.. java:import:: com.ncr ATMMonitoring.pojo.Query

.. java:import:: com.ncr ATMMonitoring.pojo.ScheduledUpdate

.. java:import:: com.ncr ATMMonitoring.pojo.Terminal

.. java:import:: com.ncr ATMMonitoring.pojo.TerminalConfig

.. java:import:: com.ncr ATMMonitoring.pojo.TerminalModel

.. java:import:: com.ncr ATMMonitoring.service.InstallationService

.. java:import:: com.ncr ATMMonitoring.service.ScheduledUpdateService

.. java:import:: com.ncr ATMMonitoring.service.TerminalConfigService

.. java:import:: com.ncr ATMMonitoring.service.TerminalModelService

.. java:import:: com.ncr ATMMonitoring.service.TerminalService

AtmFacade
=========

.. java:package:: com.ncr.ATMMonitoring.servicefacade
   :noindex:

.. java:type:: public interface AtmFacade

   Service that is an implementation of the Facade pattern that provides a simplified interface for the interaction with the services \ :java:ref:`TerminalService`\ , \ :java:ref:`TerminalModelService`\ , \ :java:ref:`ScheduledUpdateService`\ , \ :java:ref:`TerminalConfigService`\  and \ :java:ref:`InstallationService`\ . Holds all the operations related to the ATMs, such as scheduling updates and Cruds operations

   :author: Otto Abreu

Fields
------
ADD
^^^

.. java:field:: final int ADD
   :outertype: AtmFacade

   Constant that specifies an add operation

MONTHLY
^^^^^^^

.. java:field:: final int MONTHLY
   :outertype: AtmFacade

   To define a search for monthly updates

ORDER_ASC
^^^^^^^^^

.. java:field:: final String ORDER_ASC
   :outertype: AtmFacade

   Indicates that the search will return the elements in ascendent order

ORDER_DESC
^^^^^^^^^^

.. java:field:: final String ORDER_DESC
   :outertype: AtmFacade

   Indicates that the search will return the elements in descendent order

UPDATE
^^^^^^

.. java:field:: final int UPDATE
   :outertype: AtmFacade

   Constant that specifies an update operation

WEEKLY
^^^^^^

.. java:field:: final int WEEKLY
   :outertype: AtmFacade

   To define a search for weekly updates

Methods
-------
addATMByFile
^^^^^^^^^^^^

.. java:method::  void addATMByFile(InputStream file)
   :outertype: AtmFacade

   Adds the info of the ATM using the given \ :java:ref:`InputStream`\  The file must be a valid JSON string used by the ATMs

   :param file: Inputstream

addATMMachine
^^^^^^^^^^^^^

.. java:method::  void addATMMachine(TerminalConfig terminalConfig)
   :outertype: AtmFacade

   Adds a physical ATM machine to the Database \ *Note:*\  An ATM machine refers to the physical configuration of the ATM, such as memory, Hard drive, etc. see (\ :java:ref:`TerminalConfig`\

   :param terminalConfig:

addScheduledUpdate
^^^^^^^^^^^^^^^^^^

.. java:method::  void addScheduledUpdate(ScheduledUpdate scheduledUpdate)
   :outertype: AtmFacade

   Adds the given \ :java:ref:`ScheduledUpdate`\

   :param scheduledUpdate: ScheduledUpdate to be added

addUpdateATM
^^^^^^^^^^^^

.. java:method::  void addUpdateATM(Terminal terminal, int operType)
   :outertype: AtmFacade

   Execute an add or update operation on the given \ :java:ref:`Terminal`\  To execute an add operation please use \ :java:ref:`AtmFacade.ADD`\ , To update please use \ :java:ref:`AtmFacade.UPDATE`\  in the operType param

   :param terminal: Terminal to be updated or added
   :param operType: int that indicate if the given Terminal will be added or updated

addUpdateATMInstallation
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  void addUpdateATMInstallation(Installation installation, int operType)
   :outertype: AtmFacade

   Execute an add or update operation on the given \ :java:ref:`Installation`\   To execute an add operation please use \ :java:ref:`AtmFacade.ADD`\ , To update please use \ :java:ref:`AtmFacade.UPDATE`\  in the operType param

   :param installation: Installation to be updated or added
   :param operType: int that indicate if the given Terminal will be added or updated

addUpdateATMModel
^^^^^^^^^^^^^^^^^

.. java:method::  void addUpdateATMModel(TerminalModel terminalModel, int operType)
   :outertype: AtmFacade

   Execute an add or update operation on the given \ :java:ref:`TerminalModel`\   To execute an add operation please use \ :java:ref:`AtmFacade.ADD`\ , To update please use \ :java:ref:`AtmFacade.UPDATE`\  in the operType param

   :param terminalModel: TerminalModel to be updated or added
   :param operType: int that indicate if the given Terminal will be added or updated

atmSnmpUpdate
^^^^^^^^^^^^^

.. java:method::  Terminal atmSnmpUpdate(int atmId)
   :outertype: AtmFacade

   Executes a remote update on the given ATM and returns the \ :java:ref:`Terminal`\  object to be updated Returns null if the given id does not match any Terminal on the Database If the id matches with a \ :java:ref:`Terminal`\  in the Database, the remote update will be asked

   :param atmId:

atmSnmpUpdate
^^^^^^^^^^^^^

.. java:method::  void atmSnmpUpdate(Query query)
   :outertype: AtmFacade

   Executes a remote update based on the result of the given query  If the query is null, will update all the ATMs in the DB

   :param query: Query

existScheduledUpdate
^^^^^^^^^^^^^^^^^^^^

.. java:method::  boolean existScheduledUpdate(ScheduledUpdate update)
   :outertype: AtmFacade

   Tells if exist in the Database a \ :java:ref:`ScheduledUpdate`\  with the given Id if a \ :java:ref:`ScheduledUpdate`\  is found returns true, false otherwise

   :param update: ScheduledUpdate
   :return: boolean

getATM
^^^^^^

.. java:method::  Terminal getATM(String serialNumber, Long matricula, String ip, String macAddress)
   :outertype: AtmFacade

   Method that returns an ATM (\ :java:ref:`Terminal`\ ) using the criteria given Important: ONLY ONE PARAMETER CAN BE USED OF
   atmId,serialNumber, matricula, ip AND macAdress , THIS MEANS ONLY ONE CAN
   NOT BE NULL, OTHERWISE WILL EXECUTE THE FIRST NOT NULL PARAM RECEIVED Examples of use:

   ..

   * Search by serial number: getATM(null,serialNumber, null, null,null);
   * Search by matricula: getATM(null,null, matricula, null,null);
   * Search by IP: getATM(null,null, null, ip,null);
   * Search by MAC Address: getATM(null,null, null, null,macAddress);

   :param serialNumber: String if not null will search based on the given serial number
   :param matricula: Long if not null will search based on the given matricula
   :param ip: String if not null will search based on the given ip
   :param macAddress: String if not null will search based on the given Mac Address
   :return: Terminal

getATMById
^^^^^^^^^^

.. java:method::  Terminal getATMById(int id)
   :outertype: AtmFacade

   Returns the \ :java:ref:`Terminal`\  associated to the given id

   :param id:

getATMInstallation
^^^^^^^^^^^^^^^^^^

.. java:method::  Installation getATMInstallation(int installationId)
   :outertype: AtmFacade

   Return the \ :java:ref:`Installation`\  that matches with the given id

   :param installationId: int
   :return: Installation

getATMMachine
^^^^^^^^^^^^^

.. java:method::  TerminalConfig getATMMachine(int atmId)
   :outertype: AtmFacade

   Return the \ :java:ref:`TerminalConfig`\  that matches with the given id

   :param atmId: int
   :return: TerminalConfig

getATMModel
^^^^^^^^^^^

.. java:method::  TerminalModel getATMModel(int modelId)
   :outertype: AtmFacade

   Returns the ATM model that matches with the ID

   :param modelId: int with a valid ID
   :return: TerminalModel

listATMByBanks
^^^^^^^^^^^^^^

.. java:method::  List<Terminal> listATMByBanks(Set<BankCompany> banksCompanies, String sort, String order)
   :outertype: AtmFacade

   Method that returns a list of ATM (\ :java:ref:`Terminal`\ ) related to the banks \ :java:ref:`BankCompany`\  given *

   ..

   * Search by several Bank companies: Fill the list with different \ :java:ref:`BankCompany`\  element
   * Search by ONE Bank company: Fill the list with only one \ :java:ref:`BankCompany`\  element

   To specify the param order please use: \ :java:ref:`AtmFacade.ORDER_ASC`\  for an ascendant order and \ :java:ref:`AtmFacade.ORDER_DESC`\  for descendant

   :param banksCompanies: Set will search based on the given Bank companies
   :return: List

listATMByBanksAndAtmId
^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  List<Terminal> listATMByBanksAndAtmId(Set<BankCompany> banksCompanies, List<Integer> ids)
   :outertype: AtmFacade

   Method that returns a list of ATM (\ :java:ref:`Terminal`\ ) related to the banks \ :java:ref:`BankCompany`\  and only those with the given ids

   :param banksCompanies: Set will search based on the given Bank companies
   :param ids: List with the ids
   :return: List

listATMInstallations
^^^^^^^^^^^^^^^^^^^^

.. java:method::  List<Installation> listATMInstallations()
   :outertype: AtmFacade

   Returns all the installations of ATMs registered in the Database

   :return: List

listATMMachines
^^^^^^^^^^^^^^^

.. java:method::  List<TerminalConfig> listATMMachines()
   :outertype: AtmFacade

   Returns a list with all the ATM machines in the Database \ *Note:*\  An ATM machine refers to the physical configuration of the ATM, such as memory, Hard drive, etc. see (\ :java:ref:`TerminalConfig`\

   :return: List

listATMModels
^^^^^^^^^^^^^

.. java:method::  List<TerminalModel> listATMModels()
   :outertype: AtmFacade

   Returns all the models of ATMs registered in the Database

   :return: List

listATMModelsByManufacturer
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  Map<String, List<TerminalModel>> listATMModelsByManufacturer()
   :outertype: AtmFacade

   Returns all the models of ATMs registered in the Database but organized by the manufacturer The key of the returning map is the name of the manufacturer

   :return: Map

listAllATM
^^^^^^^^^^

.. java:method::  List<Terminal> listAllATM()
   :outertype: AtmFacade

   Retuns all the ATM in the database

   :return: List

listScheduledUpdates
^^^^^^^^^^^^^^^^^^^^

.. java:method::  List<ScheduledUpdate> listScheduledUpdates(int updateType)
   :outertype: AtmFacade

   Returns a list with all the ScheduledUpdate that matches the given update type  To return a list with weekly updates please use \ :java:ref:`AtmFacade.WEEKLY`\ , To return a list with monthly updates please use \ :java:ref:`AtmFacade.MONTHLY`\

   :param updateType: int indicate the type of update to fetch ( weekly or monthly)
   :return: List

listScheduledUpdates
^^^^^^^^^^^^^^^^^^^^

.. java:method::  List<ScheduledUpdate> listScheduledUpdates(String username, int updateType)
   :outertype: AtmFacade

   Returns a list with all the ScheduledUpdate that matches the given update type and are associated with the given user  To return a list with weekly updates please use \ :java:ref:`AtmFacade.WEEKLY`\ , To return a list with monthly updates please use \ :java:ref:`AtmFacade.MONTHLY`\

   :param username: String with the username
   :param updateType: int indicate the type of update to fetch ( weekly or monthly)
   :return: List

removeATMInstallation
^^^^^^^^^^^^^^^^^^^^^

.. java:method::  void removeATMInstallation(int installationId)
   :outertype: AtmFacade

   Removes the \ :java:ref:`Installation`\  that matches the given id

   :param installationId:

removeATMModel
^^^^^^^^^^^^^^

.. java:method::  void removeATMModel(int atmModelId)
   :outertype: AtmFacade

   Removes the \ :java:ref:`TerminalModel`\  that matches the given id

   :param atmModelId:

removeScheduledUpdate
^^^^^^^^^^^^^^^^^^^^^

.. java:method::  void removeScheduledUpdate(int updateId)
   :outertype: AtmFacade

   Removes the \ :java:ref:`ScheduledUpdate`\  that matches the given id

   :param updateId:

