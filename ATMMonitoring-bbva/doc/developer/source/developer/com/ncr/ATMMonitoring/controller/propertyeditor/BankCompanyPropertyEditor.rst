.. java:import:: java.beans PropertyEditorSupport

.. java:import:: com.ncr ATMMonitoring.service.BankCompanyService

BankCompanyPropertyEditor
=========================

.. java:package:: com.ncr.ATMMonitoring.controller.propertyeditor
   :noindex:

.. java:type:: public class BankCompanyPropertyEditor extends PropertyEditorSupport

   The Class BankCompanyPropertyEditor. Custom PropertyEditor for Bank Company input values (Bank Company id as an integer).

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Constructors
------------
BankCompanyPropertyEditor
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public BankCompanyPropertyEditor(BankCompanyService bankCompanyService)
   :outertype: BankCompanyPropertyEditor

   Instantiates a new bank company property editor.

   :param bankCompanyService: the bank company service

Methods
-------
setAsText
^^^^^^^^^

.. java:method:: @Override public void setAsText(String name)
   :outertype: BankCompanyPropertyEditor

