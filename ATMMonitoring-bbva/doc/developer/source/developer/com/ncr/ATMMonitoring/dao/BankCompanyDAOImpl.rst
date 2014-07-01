.. java:import:: java.util List

.. java:import:: org.apache.log4j Logger

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

BankCompanyDAOImpl
==================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class BankCompanyDAOImpl extends AbstractGenericDAO<BankCompany> implements BankCompanyDAO

   The Class BankCompanyDAOImpl. Default implementation of BankCompanyDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addBankCompany
^^^^^^^^^^^^^^

.. java:method:: @Override public void addBankCompany(BankCompany bank)
   :outertype: BankCompanyDAOImpl

getBankCompany
^^^^^^^^^^^^^^

.. java:method:: @Override public BankCompany getBankCompany(Integer id)
   :outertype: BankCompanyDAOImpl

listBankCompanies
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<BankCompany> listBankCompanies()
   :outertype: BankCompanyDAOImpl

removeBankCompany
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void removeBankCompany(Integer id)
   :outertype: BankCompanyDAOImpl

updateBankCompany
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void updateBankCompany(BankCompany bankCompany)
   :outertype: BankCompanyDAOImpl

