.. java:import:: java.text DateFormat

.. java:import:: java.text ParseException

.. java:import:: java.util Calendar

.. java:import:: java.util Date

.. java:import:: java.util List

.. java:import:: java.util Locale

.. java:import:: java.util Map

.. java:import:: java.util TreeMap

.. java:import:: org.hibernate.type CalendarType

.. java:import:: org.hibernate.type FloatType

.. java:import:: org.hibernate.type IntegerType

.. java:import:: org.hibernate.type StringType

.. java:import:: org.hibernate.type Type

Operation
=========

.. java:package:: com.ncr.ATMMonitoring.utils
   :noindex:

.. java:type:: public abstract class Operation

   The Class Operation. Class for constructing all the query engine operations' HQL.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
getConstraintHQL
^^^^^^^^^^^^^^^^

.. java:method:: public static String getConstraintHQL(String column, String operation, String value, List<Object> values, List<Type> types, Locale locale)
   :outertype: Operation

   Gets the HQL constraint for an specific column with an operation which accepts a value.

   :param column: the column for checking the constraint
   :param operation: the operation to check
   :param value: the specified value for the constraint
   :param values: where we want it to store the values
   :param types: where we want it to store the types
   :param locale: the user's locale
   :return: the HQL constraint

getOperationsByType
^^^^^^^^^^^^^^^^^^^

.. java:method:: public static Map<String, Map> getOperationsByType(DataType type)
   :outertype: Operation

   Gets the operations by data type.

   :param type: the data type
   :return: the operations by type

needsNotVoidValue
^^^^^^^^^^^^^^^^^

.. java:method:: public static boolean needsNotVoidValue(String operation)
   :outertype: Operation

   Tells if a operations needs to be provided a not-void value.

   :param operation: the operation
   :return: true, if the operation doesn't accept void values

