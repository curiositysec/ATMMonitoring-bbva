.. java:import:: java.util List

.. java:import:: java.util Set

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.dao.BankCompanyDAO

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

.. java:import:: com.ncr ATMMonitoring.pojo.User

BankCompanyServiceImpl
======================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class BankCompanyServiceImpl implements BankCompanyService

   The Class BankCompanyServiceImpl. Default implementation of the BankCompanyService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addBankCompany
^^^^^^^^^^^^^^

.. java:method:: @Override public void addBankCompany(BankCompany bank)
   :outertype: BankCompanyServiceImpl

getBankCompany
^^^^^^^^^^^^^^

.. java:method:: @Override public BankCompany getBankCompany(Integer id)
   :outertype: BankCompanyServiceImpl

getUserManageableBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Set<BankCompany> getUserManageableBankCompanies(String username)
   :outertype: BankCompanyServiceImpl

listBankCompanies
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<BankCompany> listBankCompanies()
   :outertype: BankCompanyServiceImpl

removeBankCompany
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void removeBankCompany(Integer id)
   :outertype: BankCompanyServiceImpl

updateBankCompany
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void updateBankCompany(BankCompany bank)
   :outertype: BankCompanyServiceImpl

