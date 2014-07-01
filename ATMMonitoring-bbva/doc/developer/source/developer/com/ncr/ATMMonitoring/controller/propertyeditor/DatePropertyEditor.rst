.. java:import:: java.beans PropertyEditorSupport

.. java:import:: java.text SimpleDateFormat

.. java:import:: java.util Date

DatePropertyEditor
==================

.. java:package:: com.ncr.ATMMonitoring.controller.propertyeditor
   :noindex:

.. java:type:: public class DatePropertyEditor extends PropertyEditorSupport

   The Class DatePropertyEditor. Custom PropertyEditor for Date input values.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Constructors
------------
DatePropertyEditor
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DatePropertyEditor()
   :outertype: DatePropertyEditor

   Instantiates a new date property editor.

DatePropertyEditor
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DatePropertyEditor(boolean nowAsDefault)
   :outertype: DatePropertyEditor

   Instantiates a new date property editor.

   :param nowAsDefault: flag for using current time as default value if a void or invalid one is supplied.

Methods
-------
getAsText
^^^^^^^^^

.. java:method:: @Override public String getAsText()
   :outertype: DatePropertyEditor

setAsText
^^^^^^^^^

.. java:method:: @Override public void setAsText(String date)
   :outertype: DatePropertyEditor

