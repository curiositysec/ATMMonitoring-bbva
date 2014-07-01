.. java:import:: java.io InputStream

.. java:import:: java.util List

.. java:import:: java.util Set

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

.. java:import:: com.ncr ATMMonitoring.pojo.Installation

.. java:import:: com.ncr ATMMonitoring.pojo.Terminal

.. java:import:: com.ncr.agent.baseData ATMDataStorePojo

TerminalService
===============

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface TerminalService

   The Interface TerminalService. It contains the terminal related methods.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addInstallationAndUpdateHistoricalData
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addInstallationAndUpdateHistoricalData(Terminal terminal, Installation installation)
   :outertype: TerminalService

   Add an installation and update his historical data

   :param terminal: The terminal
   :param installation: The installation

addTerminal
^^^^^^^^^^^

.. java:method:: public void addTerminal(Terminal terminal)
   :outertype: TerminalService

   Adds the terminal.

   :param terminal: the terminal

checkDateLicense
^^^^^^^^^^^^^^^^

.. java:method:: public void checkDateLicense()
   :outertype: TerminalService

   Check if date license has expired, and delete terminals' data in that case.

getTerminal
^^^^^^^^^^^

.. java:method:: public Terminal getTerminal(Integer id)
   :outertype: TerminalService

   Gets the terminal by its id.

   :param id: the terminal id
   :return: the terminal

importJsonTerminal
^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean importJsonTerminal(InputStream jsonFile)
   :outertype: TerminalService

   Import terminal from json.

   :param jsonFile: the json file
   :return: true, if successful

listTerminals
^^^^^^^^^^^^^

.. java:method:: public List<Terminal> listTerminals()
   :outertype: TerminalService

   List terminals.

   :return: the terminal list

listTerminalsByBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> banks)
   :outertype: TerminalService

   List terminals by bank companies.

   :param banks: the bank companies
   :return: the terminal list

listTerminalsByBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> banks, String sort, String order)
   :outertype: TerminalService

   List terminals by bank companies.

   :param banks: the bank companies
   :param sort: the fields for sorting terminals
   :param order: the order for sorting terminals
   :return: the terminal list

listTerminalsByBankCompany
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Terminal> listTerminalsByBankCompany(BankCompany bank)
   :outertype: TerminalService

   List terminals by bank company.

   :param bank: the bank company
   :return: the terminal list

listTerminalsByIdsAndBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Terminal> listTerminalsByIdsAndBankCompanies(List<Integer> terminalIds, Set<BankCompany> bankCompanies)
   :outertype: TerminalService

   List terminals by ids and bank companies

   :param terminalIds: The terminal ids
   :param bankCompanies: The bank companies
   :return: The list of terminals

loadTerminalByIp
^^^^^^^^^^^^^^^^

.. java:method:: public Terminal loadTerminalByIp(String ip)
   :outertype: TerminalService

   Get terminal by ip.

   :param ip: the ip
   :return: the terminal

loadTerminalByMac
^^^^^^^^^^^^^^^^^

.. java:method:: public Terminal loadTerminalByMac(String mac)
   :outertype: TerminalService

   Get terminal by mac.

   :param mac: the mac
   :return: the terminal

loadTerminalByMatricula
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Terminal loadTerminalByMatricula(Long matricula)
   :outertype: TerminalService

   Get terminal by generated id.

   :param matricula: the generated id
   :return: the terminal

loadTerminalBySerialNumber
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Terminal loadTerminalBySerialNumber(String serialNumber)
   :outertype: TerminalService

   Get terminal by serial number.

   :param serialNumber: the serial number
   :return: the terminal

persistDataStoreTerminal
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Terminal persistDataStoreTerminal(ATMDataStorePojo dataStoreTerminal)
   :outertype: TerminalService

   Persist data store terminal from an agent's pojo.

   :param dataStoreTerminal: the agent's pojo
   :return: the terminal

updateTerminal
^^^^^^^^^^^^^^

.. java:method:: public void updateTerminal(Terminal terminal)
   :outertype: TerminalService

   Update terminal.

   :param terminal: the terminal

