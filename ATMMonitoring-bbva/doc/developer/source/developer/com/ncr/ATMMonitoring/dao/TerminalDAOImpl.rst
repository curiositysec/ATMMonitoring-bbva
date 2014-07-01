.. java:import:: java.math BigInteger

.. java:import:: java.security GeneralSecurityException

.. java:import:: java.util List

.. java:import:: java.util Set

.. java:import:: java.util Vector

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate Criteria

.. java:import:: org.hibernate HibernateException

.. java:import:: org.hibernate Query

.. java:import:: org.hibernate.criterion Criterion

.. java:import:: org.hibernate.criterion Order

.. java:import:: org.hibernate.criterion Restrictions

.. java:import:: org.hibernate.type Type

.. java:import:: org.springframework.beans.factory.annotation Value

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

.. java:import:: com.ncr ATMMonitoring.pojo.HardwareDevice

.. java:import:: com.ncr ATMMonitoring.pojo.Terminal

.. java:import:: com.ncr ATMMonitoring.utils.TrialEndedException

.. java:import:: com.ncr ATMMonitoring.utils.Utils

.. java:import:: com.ncr.agent.baseData ATMDataStorePojo

.. java:import:: com.ncr.agent.baseData.os.module BaseBoardPojo

TerminalDAOImpl
===============

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class TerminalDAOImpl extends AbstractGenericDAO<Terminal> implements TerminalDAO

   The Class TerminalDAOImpl. Default implementation of TerminalDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addTerminal
^^^^^^^^^^^

.. java:method:: @Override public void addTerminal(Terminal terminal)
   :outertype: TerminalDAOImpl

deleteAllTerminalData
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void deleteAllTerminalData()
   :outertype: TerminalDAOImpl

getTerminal
^^^^^^^^^^^

.. java:method:: @Override public Terminal getTerminal(Integer id)
   :outertype: TerminalDAOImpl

getTerminalByIp
^^^^^^^^^^^^^^^

.. java:method:: @Override public Terminal getTerminalByIp(String ip)
   :outertype: TerminalDAOImpl

getTerminalByMac
^^^^^^^^^^^^^^^^

.. java:method:: @Override public Terminal getTerminalByMac(String mac)
   :outertype: TerminalDAOImpl

getTerminalByMatricula
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Terminal getTerminalByMatricula(Long matricula)
   :outertype: TerminalDAOImpl

getTerminalBySerialNumber
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Terminal getTerminalBySerialNumber(String serialNumber)
   :outertype: TerminalDAOImpl

getTerminalBySimilarity
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Terminal getTerminalBySimilarity(ATMDataStorePojo terminal)
   :outertype: TerminalDAOImpl

getTerminalsByHQL
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Terminal> getTerminalsByHQL(List<Object> values, List<Type> types, String hql)
   :outertype: TerminalDAOImpl

getTerminalsByHQL
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Terminal> getTerminalsByHQL(List<Object> values, List<Type> types, String hql, String sort, String order)
   :outertype: TerminalDAOImpl

listTerminals
^^^^^^^^^^^^^

.. java:method:: @Override public List<Terminal> listTerminals()
   :outertype: TerminalDAOImpl

listTerminalsByBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> banks)
   :outertype: TerminalDAOImpl

listTerminalsByBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> banks, String sort, String order, List<Integer> terminalIds)
   :outertype: TerminalDAOImpl

listTerminalsByBankCompany
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Terminal> listTerminalsByBankCompany(BankCompany bank)
   :outertype: TerminalDAOImpl

listTerminalsByIdsAndBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Terminal> listTerminalsByIdsAndBankCompanies(List<Integer> terminalIds, Set<BankCompany> banks)
   :outertype: TerminalDAOImpl

updateTerminal
^^^^^^^^^^^^^^

.. java:method:: @Override public void updateTerminal(Terminal terminal)
   :outertype: TerminalDAOImpl

