.. java:import:: java.beans PropertyEditorSupport

.. java:import:: com.ncr ATMMonitoring.service.SoftwareService

SoftwarePropertyEditor
======================

.. java:package:: com.ncr.ATMMonitoring.controller.propertyeditor
   :noindex:

.. java:type:: public class SoftwarePropertyEditor extends PropertyEditorSupport

   The Class SoftwarePropertyEditor. Custom PropertyEditor for Software input values (Software id as an integer).

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Constructors
------------
SoftwarePropertyEditor
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SoftwarePropertyEditor(SoftwareService softwareService)
   :outertype: SoftwarePropertyEditor

   Instantiates a new software property editor.

   :param softwareService: the software service

Methods
-------
setAsText
^^^^^^^^^

.. java:method:: @Override public void setAsText(String name)
   :outertype: SoftwarePropertyEditor

