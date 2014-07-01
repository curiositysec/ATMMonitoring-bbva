.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

BankCompanyDAO
==============

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface BankCompanyDAO

   The Interface BankCompanyDAO. Dao with the operations for managing BankCompany Pojos.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addBankCompany
^^^^^^^^^^^^^^

.. java:method:: public void addBankCompany(BankCompany bank)
   :outertype: BankCompanyDAO

   Adds the bank company.

   :param bank: the bank company

getBankCompany
^^^^^^^^^^^^^^

.. java:method:: public BankCompany getBankCompany(Integer id)
   :outertype: BankCompanyDAO

   Gets the bank company with the given id.

   :param id: the id
   :return: the bank company, or null if it doesn't exist

listBankCompanies
^^^^^^^^^^^^^^^^^

.. java:method:: public List<BankCompany> listBankCompanies()
   :outertype: BankCompanyDAO

   Lists all bank companies.

   :return: the list

removeBankCompany
^^^^^^^^^^^^^^^^^

.. java:method:: public void removeBankCompany(Integer id)
   :outertype: BankCompanyDAO

   Removes the bank company with the given id.

   :param id: the id

updateBankCompany
^^^^^^^^^^^^^^^^^

.. java:method:: public void updateBankCompany(BankCompany bank)
   :outertype: BankCompanyDAO

   Updates bank company.

   :param bank: the bank

