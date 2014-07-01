.. java:import:: java.util List

.. java:import:: java.util Set

.. java:import:: org.hibernate.type Type

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

.. java:import:: com.ncr ATMMonitoring.pojo.Terminal

.. java:import:: com.ncr.agent.baseData ATMDataStorePojo

TerminalDAO
===========

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface TerminalDAO

   The Interface TerminalDAO. Dao with the operations for managing Terminal Pojos.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addTerminal
^^^^^^^^^^^

.. java:method:: public void addTerminal(Terminal terminal)
   :outertype: TerminalDAO

   Adds the terminal.

   :param terminal: the terminal

deleteAllTerminalData
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void deleteAllTerminalData()
   :outertype: TerminalDAO

   Deletes all the terminals' related data from the DB.

getTerminal
^^^^^^^^^^^

.. java:method:: public Terminal getTerminal(Integer id)
   :outertype: TerminalDAO

   Gets the terminal with the given id.

   :param id: the id
   :return: the terminal, or null if it doesn't exist

getTerminalByIp
^^^^^^^^^^^^^^^

.. java:method:: public Terminal getTerminalByIp(String ip)
   :outertype: TerminalDAO

   Gets the terminal by ip.

   :param ip: the ip
   :return: the terminal by ip, or null if it doesn't exist

getTerminalByMac
^^^^^^^^^^^^^^^^

.. java:method:: public Terminal getTerminalByMac(String mac)
   :outertype: TerminalDAO

   Gets the terminal by mac.

   :param mac: the mac
   :return: the terminal by mac, or null if it doesn't exist

getTerminalByMatricula
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Terminal getTerminalByMatricula(Long matricula)
   :outertype: TerminalDAO

   Gets the terminal by the generated id.

   :param matricula: the generated id
   :return: the terminal by the generated id, or null if it doesn't exist

getTerminalBySerialNumber
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Terminal getTerminalBySerialNumber(String serialNumber)
   :outertype: TerminalDAO

   Gets the terminal by serial number.

   :param serialNumber: the serial number
   :return: the terminal by serial number, or null if it doesn't exist

getTerminalBySimilarity
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Terminal getTerminalBySimilarity(ATMDataStorePojo terminal)
   :outertype: TerminalDAO

   Gets the terminal by similarity. This means that we retrieve terminals that share at least two of some key fields values (MAC, IP, serial number). If we have more than one similar terminal stored, it simply returns the first one by its internal order.

   :param terminal: the terminal
   :return: the terminal by similarity, or null if it doesn't exist

getTerminalsByHQL
^^^^^^^^^^^^^^^^^

.. java:method:: public List<Terminal> getTerminalsByHQL(List<Object> values, List<Type> types, String hql)
   :outertype: TerminalDAO

   Gets the terminals by HQL. Used for the query engine.

   :param values: the values of the HQL parameters
   :param types: the types of the HQL parameters
   :param hql: the HQL itself
   :return: the terminals that fulfill the HQL

getTerminalsByHQL
^^^^^^^^^^^^^^^^^

.. java:method:: public List<Terminal> getTerminalsByHQL(List<Object> values, List<Type> types, String hql, String sort, String order)
   :outertype: TerminalDAO

   Gets the terminals by HQL with a specific order and sorting. Used for the query engine.

   :param values: the values of the HQL parameters
   :param types: the types of the HQL parameters
   :param hql: the HQL itself
   :param sort: the sort
   :param order: the order
   :return: the terminals that fulfill the HQL

listTerminals
^^^^^^^^^^^^^

.. java:method:: public List<Terminal> listTerminals()
   :outertype: TerminalDAO

   Lists all terminals.

   :return: the list

listTerminalsByBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> bank)
   :outertype: TerminalDAO

   Lists all terminals for the given bank companies.

   :param bank: the bank companies
   :return: the list

listTerminalsByBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> bank, String sort, String order, List<Integer> terminalIds)
   :outertype: TerminalDAO

   Lists all terminals for the given bank companies with a specific order and sorting.

   :param bank: the bank companies
   :param sort: the sort
   :param order: the order
   :return: the list

listTerminalsByBankCompany
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Terminal> listTerminalsByBankCompany(BankCompany bank)
   :outertype: TerminalDAO

   List all terminals for the given bank company.

   :param bank: the bank company
   :return: the list

listTerminalsByIdsAndBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Terminal> listTerminalsByIdsAndBankCompanies(List<Integer> ids, Set<BankCompany> bank)
   :outertype: TerminalDAO

updateTerminal
^^^^^^^^^^^^^^

.. java:method:: public void updateTerminal(Terminal terminal)
   :outertype: TerminalDAO

   Update terminal.

   :param terminal: the terminal

