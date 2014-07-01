.. java:import:: java.io Serializable

.. java:import:: java.util HashSet

.. java:import:: java.util Set

.. java:import:: javax.persistence Column

.. java:import:: javax.persistence Entity

.. java:import:: javax.persistence GeneratedValue

.. java:import:: javax.persistence GenerationType

.. java:import:: javax.persistence Id

.. java:import:: javax.persistence JoinColumn

.. java:import:: javax.persistence ManyToOne

.. java:import:: javax.persistence OneToMany

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

.. java:import:: org.hibernate.annotations Index

BankCompany
===========

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class BankCompany implements Serializable

   The BankCompany Pojo.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: BankCompany

   Gets the id.

   :return: the id

getManageableBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<BankCompany> getManageableBankCompanies()
   :outertype: BankCompany

   Gets the manageable bank companies (i.e. this bank company and its subcompanies)

   :return: the manageable bank companies

getName
^^^^^^^

.. java:method:: public String getName()
   :outertype: BankCompany

   Gets the name.

   :return: the name

getParentCompany
^^^^^^^^^^^^^^^^

.. java:method:: public BankCompany getParentCompany()
   :outertype: BankCompany

   Gets the parent company.

   :return: the parent company

getSubBankCompanies
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<BankCompany> getSubBankCompanies()
   :outertype: BankCompany

   Gets the subcompanies.

   :return: the subcompanies

getVatIN
^^^^^^^^

.. java:method:: public String getVatIN()
   :outertype: BankCompany

   Gets the vat in.

   :return: the vat in

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: BankCompany

   Sets the id.

   :param id: the id to set

setName
^^^^^^^

.. java:method:: public void setName(String name)
   :outertype: BankCompany

   Sets the name.

   :param name: the name to set

setParentCompany
^^^^^^^^^^^^^^^^

.. java:method:: public void setParentCompany(BankCompany parentCompany)
   :outertype: BankCompany

   Sets the parent company.

   :param parentCompany: the new parent company

setSubBankCompanies
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSubBankCompanies(Set<BankCompany> subBankCompanies)
   :outertype: BankCompany

   Sets the sub bank companies.

   :param subBankCompanies: the new sub bank companies

setVatIN
^^^^^^^^

.. java:method:: public void setVatIN(String vatIN)
   :outertype: BankCompany

   Sets the vat in.

   :param vatIN: the new vat in

