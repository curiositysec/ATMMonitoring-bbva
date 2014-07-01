.. java:import:: java.beans PropertyEditorSupport

.. java:import:: com.ncr ATMMonitoring.service.RoleService

RolePropertyEditor
==================

.. java:package:: com.ncr.ATMMonitoring.controller.propertyeditor
   :noindex:

.. java:type:: public class RolePropertyEditor extends PropertyEditorSupport

   The Class RolePropertyEditor. Custom PropertyEditor for Role input values (Role id as an integer).

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Constructors
------------
RolePropertyEditor
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RolePropertyEditor(RoleService roleService)
   :outertype: RolePropertyEditor

   Instantiates a new role property editor.

   :param roleService: the role service

Methods
-------
setAsText
^^^^^^^^^

.. java:method:: @Override public void setAsText(String name)
   :outertype: RolePropertyEditor

