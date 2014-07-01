.. java:import:: java.util List

.. java:import:: java.util Set

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

BankCompanyService
==================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface BankCompanyService

   The Interface BankCompanyService. It contains the bank related methods.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addBankCompany
^^^^^^^^^^^^^^

.. java:method:: public void addBankCompany(BankCompany bank)
   :outertype: BankCompanyService

   Adds the bank company.

   :param bank: the bank company

getBankCompany
^^^^^^^^^^^^^^

.. java:method:: public BankCompany getBankCompany(Integer id)
   :outertype: BankCompanyService

   Gets the bank company by its id.

   :param id: the bank company id
   :return: the bank company

getUserManageableBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  Set<BankCompany> getUserManageableBankCompanies(String username)
   :outertype: BankCompanyService

   Returns the BankCompanies associated to a user

   :param username: String
   :return: Set

listBankCompanies
^^^^^^^^^^^^^^^^^

.. java:method:: public List<BankCompany> listBankCompanies()
   :outertype: BankCompanyService

   List bank companies.

   :return: the bank companies list

removeBankCompany
^^^^^^^^^^^^^^^^^

.. java:method:: public void removeBankCompany(Integer id)
   :outertype: BankCompanyService

   Removes the bank company by its id..

   :param id: the bank company id

updateBankCompany
^^^^^^^^^^^^^^^^^

.. java:method:: public void updateBankCompany(BankCompany bank)
   :outertype: BankCompanyService

   Update bank company.

   :param bank: the bank company

