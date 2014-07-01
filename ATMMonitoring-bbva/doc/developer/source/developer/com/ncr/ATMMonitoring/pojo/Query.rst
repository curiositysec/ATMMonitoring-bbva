.. java:import:: java.io Serializable

.. java:import:: java.text DateFormat

.. java:import:: java.util Date

.. java:import:: java.util HashMap

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Locale

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: java.util TreeMap

.. java:import:: javax.persistence Column

.. java:import:: javax.persistence Entity

.. java:import:: javax.persistence FetchType

.. java:import:: javax.persistence GeneratedValue

.. java:import:: javax.persistence GenerationType

.. java:import:: javax.persistence Id

.. java:import:: javax.persistence JoinColumn

.. java:import:: javax.persistence ManyToOne

.. java:import:: javax.persistence OneToMany

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

.. java:import:: org.hibernate.annotations Cascade

.. java:import:: org.hibernate.annotations CascadeType

.. java:import:: org.hibernate.type Type

.. java:import:: com.ncr ATMMonitoring.utils.Operation

.. java:import:: com.ncr ATMMonitoring.utils.Operation.DataType

.. java:import:: com.ncr ATMMonitoring.utils.WidgetQueryAssociationType

Query
=====

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class Query implements Serializable

   The Query Pojo.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
buildIsAuditableElementActiveByDateWhere
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String buildIsAuditableElementActiveByDateWhere(String fieldNamePrefix, List<Object> values, List<Type> types, Locale locale, Date queryDate)
   :outertype: Query

equals
^^^^^^

.. java:method:: @Override public boolean equals(Object o)
   :outertype: Query

getComboboxes
^^^^^^^^^^^^^

.. java:method:: public static Map<String, Map> getComboboxes()
   :outertype: Query

   Gets the comboboxes data for the query GUI.

   :return: the comboboxes data

getCreationDate
^^^^^^^^^^^^^^^

.. java:method:: public Date getCreationDate()
   :outertype: Query

   Gets the creation date.

   :return: the creation date

getCreationDateShort
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getCreationDateShort()
   :outertype: Query

   Gets the creation date short.

   :return: the creation date short

getDescription
^^^^^^^^^^^^^^

.. java:method:: public String getDescription()
   :outertype: Query

   Gets the description.

   :return: the description

getFeatSwCB1
^^^^^^^^^^^^

.. java:method:: public Boolean getFeatSwCB1()
   :outertype: Query

   Gets the feat sw checkbox1 value.

   :return: the featSwCB1

getFeatSwCB2
^^^^^^^^^^^^

.. java:method:: public Boolean getFeatSwCB2()
   :outertype: Query

   Gets the feat sw checkbox2 value.

   :return: the featSwCB2

getFeatSwCB3
^^^^^^^^^^^^

.. java:method:: public Boolean getFeatSwCB3()
   :outertype: Query

   Gets the feat sw checkbox3 value.

   :return: the featSwCB3

getFeatSwCB4
^^^^^^^^^^^^

.. java:method:: public Boolean getFeatSwCB4()
   :outertype: Query

   Gets the feat sw checkbox4 value.

   :return: the featSwCB4

getFeatSwCB5
^^^^^^^^^^^^

.. java:method:: public Boolean getFeatSwCB5()
   :outertype: Query

   Gets the feat sw checkbox5 value.

   :return: the featSwCB5

getFeatSwCombo11
^^^^^^^^^^^^^^^^

.. java:method:: public String getFeatSwCombo11()
   :outertype: Query

   Gets the feat sw combo11 value.

   :return: the featSwCombo11

getFeatSwCombo12
^^^^^^^^^^^^^^^^

.. java:method:: public String getFeatSwCombo12()
   :outertype: Query

   Gets the feat sw combo12 value.

   :return: the featSwCombo12

getFeatSwCombo21
^^^^^^^^^^^^^^^^

.. java:method:: public String getFeatSwCombo21()
   :outertype: Query

   Gets the feat sw combo21 value.

   :return: the featSwCombo21

getFeatSwCombo22
^^^^^^^^^^^^^^^^

.. java:method:: public String getFeatSwCombo22()
   :outertype: Query

   Gets the feat sw combo22 value.

   :return: the featSwCombo22

getFeatSwCombo31
^^^^^^^^^^^^^^^^

.. java:method:: public String getFeatSwCombo31()
   :outertype: Query

   Gets the feat sw combo31 value.

   :return: the featSwCombo31

getFeatSwCombo32
^^^^^^^^^^^^^^^^

.. java:method:: public String getFeatSwCombo32()
   :outertype: Query

   Gets the feat sw combo32 value.

   :return: the featSwCombo32

getFeatSwCombo41
^^^^^^^^^^^^^^^^

.. java:method:: public String getFeatSwCombo41()
   :outertype: Query

   Gets the feat sw combo41 value.

   :return: the featSwCombo41

getFeatSwCombo42
^^^^^^^^^^^^^^^^

.. java:method:: public String getFeatSwCombo42()
   :outertype: Query

   Gets the feat sw combo42 value.

   :return: the featSwCombo42

getFeatSwCombo51
^^^^^^^^^^^^^^^^

.. java:method:: public String getFeatSwCombo51()
   :outertype: Query

   Gets the feat sw combo51 value.

   :return: the featSwCombo51

getFeatSwCombo52
^^^^^^^^^^^^^^^^

.. java:method:: public String getFeatSwCombo52()
   :outertype: Query

   Gets the feat sw combo52 value.

   :return: the featSwCombo52

getFeatSwField1
^^^^^^^^^^^^^^^

.. java:method:: public String getFeatSwField1()
   :outertype: Query

   Gets the feat sw field1 value.

   :return: the featSwField1

getFeatSwField2
^^^^^^^^^^^^^^^

.. java:method:: public String getFeatSwField2()
   :outertype: Query

   Gets the feat sw field2 value.

   :return: the featSwField2

getFeatSwField3
^^^^^^^^^^^^^^^

.. java:method:: public String getFeatSwField3()
   :outertype: Query

   Gets the feat sw field3 value.

   :return: the featSwField3

getFeatSwField4
^^^^^^^^^^^^^^^

.. java:method:: public String getFeatSwField4()
   :outertype: Query

   Gets the feat sw field4 value.

   :return: the featSwField4

getFeatSwField5
^^^^^^^^^^^^^^^

.. java:method:: public String getFeatSwField5()
   :outertype: Query

   Gets the feat sw field5 value.

   :return: the featSwField5

getFinancialDeviceCB1
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getFinancialDeviceCB1()
   :outertype: Query

   Gets the financial device checkbox1 value.

   :return: the financialDeviceCB1

getFinancialDeviceCB2
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getFinancialDeviceCB2()
   :outertype: Query

   Gets the financial device checkbox2 value.

   :return: the financialDeviceCB2

getFinancialDeviceCB3
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getFinancialDeviceCB3()
   :outertype: Query

   Gets the financial device checkbox3 value.

   :return: the financialDeviceCB3

getFinancialDeviceCB4
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getFinancialDeviceCB4()
   :outertype: Query

   Gets the financial device checkbox4 value.

   :return: the financialDeviceCB4

getFinancialDeviceCB5
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getFinancialDeviceCB5()
   :outertype: Query

   Gets the financial device checkbox5 value.

   :return: the financialDeviceCB5

getFinancialDeviceCombo11
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getFinancialDeviceCombo11()
   :outertype: Query

   Gets the financial device combo11 value.

   :return: the financialDeviceCombo11

getFinancialDeviceCombo12
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getFinancialDeviceCombo12()
   :outertype: Query

   Gets the financial device combo12 value.

   :return: the financialDeviceCombo12

getFinancialDeviceCombo21
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getFinancialDeviceCombo21()
   :outertype: Query

   Gets the financial device combo21 value.

   :return: the financialDeviceCombo21

getFinancialDeviceCombo22
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getFinancialDeviceCombo22()
   :outertype: Query

   Gets the financial device combo22 value.

   :return: the financialDeviceCombo22

getFinancialDeviceCombo31
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getFinancialDeviceCombo31()
   :outertype: Query

   Gets the financial device combo31 value.

   :return: the financialDeviceCombo31

getFinancialDeviceCombo32
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getFinancialDeviceCombo32()
   :outertype: Query

   Gets the financial device combo32 value.

   :return: the financialDeviceCombo32

getFinancialDeviceCombo41
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getFinancialDeviceCombo41()
   :outertype: Query

   Gets the financial device combo41 value.

   :return: the financialDeviceCombo41

getFinancialDeviceCombo42
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getFinancialDeviceCombo42()
   :outertype: Query

   Gets the financial device combo42 value.

   :return: the financialDeviceCombo42

getFinancialDeviceCombo51
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getFinancialDeviceCombo51()
   :outertype: Query

   Gets the financial device combo51 value.

   :return: the financialDeviceCombo51

getFinancialDeviceCombo52
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getFinancialDeviceCombo52()
   :outertype: Query

   Gets the financial device combo52 value.

   :return: the financialDeviceCombo52

getFinancialDeviceField1
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getFinancialDeviceField1()
   :outertype: Query

   Gets the financial device field1 value.

   :return: the financialDeviceField1

getFinancialDeviceField2
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getFinancialDeviceField2()
   :outertype: Query

   Gets the financial device field2 value.

   :return: the financialDeviceField2

getFinancialDeviceField3
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getFinancialDeviceField3()
   :outertype: Query

   Gets the financial device field3 value.

   :return: the financialDeviceField3

getFinancialDeviceField4
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getFinancialDeviceField4()
   :outertype: Query

   Gets the financial device field4 value.

   :return: the financialDeviceField4

getFinancialDeviceField5
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getFinancialDeviceField5()
   :outertype: Query

   Gets the financial device field5 value.

   :return: the financialDeviceField5

getHQL
^^^^^^

.. java:method:: public String getHQL(List<Object> values, List<Type> types, Locale locale)
   :outertype: Query

   Gets the HQL for the stored data, and stores values and types in the passed variables. No duplicated data is shown and terminals are ordered by serial number and id.

   :param values: where we want it to store the values
   :param types: where we want it to store the types
   :param locale: the user's locale
   :return: the resulting HQL

getHQL
^^^^^^

.. java:method:: public String getHQL(List<Object> values, List<Type> types, Locale locale, boolean order, Date queryDate)
   :outertype: Query

getHQL
^^^^^^

.. java:method:: public String getHQL(List<Object> values, List<Type> types, Locale locale, boolean order)
   :outertype: Query

   Gets the HQL for the stored data, and stores values and types in the passed variables. No duplicated data is shown.

   :param values: where we want it to store the values
   :param types: where we want it to store the types
   :param locale: the user's locale
   :param order: whether we want the terminals ordered by serial number and id
   :return: the resulting HQL

getHQL
^^^^^^

.. java:method:: public String getHQL(List<Object> values, List<Type> types, Locale locale, boolean distinct, boolean order, Date queryDate)
   :outertype: Query

   Gets the HQL for the stored data, and stores values and types in the passed variables.

   :param values: where we want it to store the values
   :param types: where we want it to store the types
   :param locale: the user's locale
   :param distinct: whether we want to prevent duplicated data to appear
   :param order: whether we want the terminals ordered by serial number and id
   :return: the resulting HQL

getHQLGroupingBy
^^^^^^^^^^^^^^^^

.. java:method:: public String getHQLGroupingBy(List<Object> values, List<Type> types, Locale locale, WidgetQueryAssociationType queryAssociationType, String groupByField, Date queryDate)
   :outertype: Query

   Gets the HQL grouping by.

   :param values: where we want it to store the values
   :param types: where we want it to store the types
   :param locale: the locale
   :param groupByEntity: the group by entity
   :param groupByField: the group by field
   :return: the hQL grouping by

getHardwareDeviceCB1
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getHardwareDeviceCB1()
   :outertype: Query

   Gets the hardware device checkbox1 value.

   :return: the hardwareDeviceCB1

getHardwareDeviceCB2
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getHardwareDeviceCB2()
   :outertype: Query

   Gets the hardware device checkbox2 value.

   :return: the hardwareDeviceCB2

getHardwareDeviceCB3
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getHardwareDeviceCB3()
   :outertype: Query

   Gets the hardware device checkbox3 value.

   :return: the hardwareDeviceCB3

getHardwareDeviceCB4
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getHardwareDeviceCB4()
   :outertype: Query

   Gets the hardware device checkbox4 value.

   :return: the hardwareDeviceCB4

getHardwareDeviceCB5
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getHardwareDeviceCB5()
   :outertype: Query

   Gets the hardware device checkbox5 value.

   :return: the hardwareDeviceCB5

getHardwareDeviceCombo11
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getHardwareDeviceCombo11()
   :outertype: Query

   Gets the hardware device combo11 value.

   :return: the hardwareDeviceCombo11

getHardwareDeviceCombo12
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getHardwareDeviceCombo12()
   :outertype: Query

   Gets the hardware device combo12 value.

   :return: the hardwareDeviceCombo12

getHardwareDeviceCombo13
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getHardwareDeviceCombo13()
   :outertype: Query

   Gets the hardware device combo13 value.

   :return: the hardwareDeviceCombo13

getHardwareDeviceCombo21
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getHardwareDeviceCombo21()
   :outertype: Query

   Gets the hardware device combo21 value.

   :return: the hardwareDeviceCombo21

getHardwareDeviceCombo22
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getHardwareDeviceCombo22()
   :outertype: Query

   Gets the hardware device combo22 value.

   :return: the hardwareDeviceCombo22

getHardwareDeviceCombo23
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getHardwareDeviceCombo23()
   :outertype: Query

   Gets the hardware device combo23 value.

   :return: the hardwareDeviceCombo23

getHardwareDeviceCombo31
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getHardwareDeviceCombo31()
   :outertype: Query

   Gets the hardware device combo31 value.

   :return: the hardwareDeviceCombo31

getHardwareDeviceCombo32
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getHardwareDeviceCombo32()
   :outertype: Query

   Gets the hardware device combo32 value.

   :return: the hardwareDeviceCombo32

getHardwareDeviceCombo33
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getHardwareDeviceCombo33()
   :outertype: Query

   Gets the hardware device combo33 value.

   :return: the hardwareDeviceCombo33

getHardwareDeviceCombo41
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getHardwareDeviceCombo41()
   :outertype: Query

   Gets the hardware device combo41 value.

   :return: the hardwareDeviceCombo41

getHardwareDeviceCombo42
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getHardwareDeviceCombo42()
   :outertype: Query

   Gets the hardware device combo42 value.

   :return: the hardwareDeviceCombo42

getHardwareDeviceCombo43
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getHardwareDeviceCombo43()
   :outertype: Query

   Gets the hardware device combo43 value.

   :return: the hardwareDeviceCombo43

getHardwareDeviceCombo51
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getHardwareDeviceCombo51()
   :outertype: Query

   Gets the hardware device combo51 value.

   :return: the hardwareDeviceCombo51

getHardwareDeviceCombo52
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getHardwareDeviceCombo52()
   :outertype: Query

   Gets the hardware device combo52 value.

   :return: the hardwareDeviceCombo52

getHardwareDeviceCombo53
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getHardwareDeviceCombo53()
   :outertype: Query

   Gets the hardware device combo53 value.

   :return: the hardwareDeviceCombo53

getHardwareDeviceField1
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getHardwareDeviceField1()
   :outertype: Query

   Gets the hardware device field1 value.

   :return: the hardwareDeviceField1

getHardwareDeviceField2
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getHardwareDeviceField2()
   :outertype: Query

   Gets the hardware device field2 value.

   :return: the hardwareDeviceField2

getHardwareDeviceField3
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getHardwareDeviceField3()
   :outertype: Query

   Gets the hardware device field3 value.

   :return: the hardwareDeviceField3

getHardwareDeviceField4
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getHardwareDeviceField4()
   :outertype: Query

   Gets the hardware device field4 value.

   :return: the hardwareDeviceField4

getHardwareDeviceField5
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getHardwareDeviceField5()
   :outertype: Query

   Gets the hardware device field5 value.

   :return: the hardwareDeviceField5

getHotfixCB1
^^^^^^^^^^^^

.. java:method:: public Boolean getHotfixCB1()
   :outertype: Query

   Gets the hotfix checkbox1 value.

   :return: the hotfixCB1

getHotfixCB2
^^^^^^^^^^^^

.. java:method:: public Boolean getHotfixCB2()
   :outertype: Query

   Gets the hotfix checkbox2 value.

   :return: the hotfixCB2

getHotfixCB3
^^^^^^^^^^^^

.. java:method:: public Boolean getHotfixCB3()
   :outertype: Query

   Gets the hotfix checkbox3 value.

   :return: the hotfixCB3

getHotfixCB4
^^^^^^^^^^^^

.. java:method:: public Boolean getHotfixCB4()
   :outertype: Query

   Gets the hotfix checkbox4 value.

   :return: the hotfixCB4

getHotfixCB5
^^^^^^^^^^^^

.. java:method:: public Boolean getHotfixCB5()
   :outertype: Query

   Gets the hotfix checkbox5 value.

   :return: the hotfixCB5

getHotfixCombo11
^^^^^^^^^^^^^^^^

.. java:method:: public String getHotfixCombo11()
   :outertype: Query

   Gets the hotfix combo11 value.

   :return: the hotfixCombo11

getHotfixCombo12
^^^^^^^^^^^^^^^^

.. java:method:: public String getHotfixCombo12()
   :outertype: Query

   Gets the hotfix combo12 value.

   :return: the hotfixCombo12

getHotfixCombo21
^^^^^^^^^^^^^^^^

.. java:method:: public String getHotfixCombo21()
   :outertype: Query

   Gets the hotfix combo21 value.

   :return: the hotfixCombo21

getHotfixCombo22
^^^^^^^^^^^^^^^^

.. java:method:: public String getHotfixCombo22()
   :outertype: Query

   Gets the hotfix combo22 value.

   :return: the hotfixCombo22

getHotfixCombo31
^^^^^^^^^^^^^^^^

.. java:method:: public String getHotfixCombo31()
   :outertype: Query

   Gets the hotfix combo31 value.

   :return: the hotfixCombo31

getHotfixCombo32
^^^^^^^^^^^^^^^^

.. java:method:: public String getHotfixCombo32()
   :outertype: Query

   Gets the hotfix combo32 value.

   :return: the hotfixCombo32

getHotfixCombo41
^^^^^^^^^^^^^^^^

.. java:method:: public String getHotfixCombo41()
   :outertype: Query

   Gets the hotfix combo41 value.

   :return: the hotfixCombo41

getHotfixCombo42
^^^^^^^^^^^^^^^^

.. java:method:: public String getHotfixCombo42()
   :outertype: Query

   Gets the hotfix combo42 value.

   :return: the hotfixCombo42

getHotfixCombo51
^^^^^^^^^^^^^^^^

.. java:method:: public String getHotfixCombo51()
   :outertype: Query

   Gets the hotfix combo51 value.

   :return: the hotfixCombo51

getHotfixCombo52
^^^^^^^^^^^^^^^^

.. java:method:: public String getHotfixCombo52()
   :outertype: Query

   Gets the hotfix combo52 value.

   :return: the hotfixCombo52

getHotfixField1
^^^^^^^^^^^^^^^

.. java:method:: public String getHotfixField1()
   :outertype: Query

   Gets the hotfix field1 value.

   :return: the hotfixField1

getHotfixField2
^^^^^^^^^^^^^^^

.. java:method:: public String getHotfixField2()
   :outertype: Query

   Gets the hotfix field2 value.

   :return: the hotfixField2

getHotfixField3
^^^^^^^^^^^^^^^

.. java:method:: public String getHotfixField3()
   :outertype: Query

   Gets the hotfix field3 value.

   :return: the hotfixField3

getHotfixField4
^^^^^^^^^^^^^^^

.. java:method:: public String getHotfixField4()
   :outertype: Query

   Gets the hotfix field4 value.

   :return: the hotfixField4

getHotfixField5
^^^^^^^^^^^^^^^

.. java:method:: public String getHotfixField5()
   :outertype: Query

   Gets the hotfix field5 value.

   :return: the hotfixField5

getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: Query

   Gets the id.

   :return: the id

getInternetExplorerCB1
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getInternetExplorerCB1()
   :outertype: Query

   Gets the internet explorer checkbox1 value.

   :return: the internetExplorerCB1

getInternetExplorerCB2
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getInternetExplorerCB2()
   :outertype: Query

   Gets the internet explorer checkbox2 value.

   :return: the internetExplorerCB2

getInternetExplorerCombo11
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getInternetExplorerCombo11()
   :outertype: Query

   Gets the internet explorer combo11 value.

   :return: the internetExplorerCombo11

getInternetExplorerCombo12
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getInternetExplorerCombo12()
   :outertype: Query

   Gets the internet explorer combo12 value.

   :return: the internetExplorerCombo12

getInternetExplorerCombo21
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getInternetExplorerCombo21()
   :outertype: Query

   Gets the internet explorer combo21 value.

   :return: the internetExplorerCombo21

getInternetExplorerCombo22
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getInternetExplorerCombo22()
   :outertype: Query

   Gets the internet explorer combo22 value.

   :return: the internetExplorerCombo22

getInternetExplorerField1
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getInternetExplorerField1()
   :outertype: Query

   Gets the internet explorer field1 value.

   :return: the internetExplorerField1

getInternetExplorerField2
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getInternetExplorerField2()
   :outertype: Query

   Gets the internet explorer field2 value.

   :return: the internetExplorerField2

getJxfsComponentCB1
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getJxfsComponentCB1()
   :outertype: Query

   Gets the jxfs component checkbox1 value.

   :return: the jxfs component checkbox1 value

getJxfsComponentCB2
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getJxfsComponentCB2()
   :outertype: Query

   Gets the jxfs component checkbox2 value.

   :return: the jxfs component checkbox2 value

getJxfsComponentCB3
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getJxfsComponentCB3()
   :outertype: Query

   Gets the jxfs component checkbox3 value.

   :return: the jxfs component checkbox3 value

getJxfsComponentCB4
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getJxfsComponentCB4()
   :outertype: Query

   Gets the jxfs component checkbox4 value.

   :return: the jxfs component checkbox4 value

getJxfsComponentCB5
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getJxfsComponentCB5()
   :outertype: Query

   Gets the jxfs component checkbox5 value.

   :return: the jxfs component checkbox5 value

getJxfsComponentCombo11
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getJxfsComponentCombo11()
   :outertype: Query

   Gets the jxfs component combo11 value.

   :return: the jxfs component combo11 value

getJxfsComponentCombo12
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getJxfsComponentCombo12()
   :outertype: Query

   Gets the jxfs component combo12 value.

   :return: the jxfs component combo12 value

getJxfsComponentCombo21
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getJxfsComponentCombo21()
   :outertype: Query

   Gets the jxfs component combo21 value.

   :return: the jxfs component combo21 value

getJxfsComponentCombo22
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getJxfsComponentCombo22()
   :outertype: Query

   Gets the jxfs component combo22 value.

   :return: the jxfs component combo22 value

getJxfsComponentCombo31
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getJxfsComponentCombo31()
   :outertype: Query

   Gets the jxfs component combo31 value.

   :return: the jxfs component combo31 value

getJxfsComponentCombo32
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getJxfsComponentCombo32()
   :outertype: Query

   Gets the jxfs component combo32 value.

   :return: the jxfs component combo32 value

getJxfsComponentCombo41
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getJxfsComponentCombo41()
   :outertype: Query

   Gets the jxfs component combo41 value.

   :return: the jxfs component combo41 value

getJxfsComponentCombo42
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getJxfsComponentCombo42()
   :outertype: Query

   Gets the jxfs component combo42 value.

   :return: the jxfs component combo42 value

getJxfsComponentCombo51
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getJxfsComponentCombo51()
   :outertype: Query

   Gets the jxfs component combo51 value.

   :return: the jxfs component combo51 value

getJxfsComponentCombo52
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getJxfsComponentCombo52()
   :outertype: Query

   Gets the jxfs component combo52 value.

   :return: the jxfs component combo52 value

getJxfsComponentField1
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getJxfsComponentField1()
   :outertype: Query

   Gets the jxfs component field1 value.

   :return: the jxfs component field1 value

getJxfsComponentField2
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getJxfsComponentField2()
   :outertype: Query

   Gets the jxfs component field2 value.

   :return: the jxfs component field2 value

getJxfsComponentField3
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getJxfsComponentField3()
   :outertype: Query

   Gets the jxfs component field3 value.

   :return: the jxfs component field3 value

getJxfsComponentField4
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getJxfsComponentField4()
   :outertype: Query

   Gets the jxfs component field4 value.

   :return: the jxfs component field4 value

getJxfsComponentField5
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getJxfsComponentField5()
   :outertype: Query

   Gets the jxfs component field5 value.

   :return: the jxfs component field5 value

getLocale
^^^^^^^^^

.. java:method:: public String getLocale()
   :outertype: Query

   Gets the locale.

   :return: the locale

getName
^^^^^^^

.. java:method:: public String getName()
   :outertype: Query

   Gets the name.

   :return: the name

getOperatingSystemCB1
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getOperatingSystemCB1()
   :outertype: Query

   Gets the operating system checkbox1 value.

   :return: the operatingSystemCB1

getOperatingSystemCB2
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getOperatingSystemCB2()
   :outertype: Query

   Gets the operating system checkbox2 value.

   :return: the operatingSystemCB2

getOperatingSystemCB3
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getOperatingSystemCB3()
   :outertype: Query

   Gets the operating system checkbox3 value.

   :return: the operatingSystemCB3

getOperatingSystemCB4
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getOperatingSystemCB4()
   :outertype: Query

   Gets the operating system checkbox4 value.

   :return: the operatingSystemCB4

getOperatingSystemCB5
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getOperatingSystemCB5()
   :outertype: Query

   Gets the operating system checkbox5 value.

   :return: the operatingSystemCB5

getOperatingSystemCombo11
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getOperatingSystemCombo11()
   :outertype: Query

   Gets the operating system combo11 value.

   :return: the operatingSystemCombo11

getOperatingSystemCombo12
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getOperatingSystemCombo12()
   :outertype: Query

   Gets the operating system combo12 value.

   :return: the operatingSystemCombo12

getOperatingSystemCombo21
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getOperatingSystemCombo21()
   :outertype: Query

   Gets the operating system combo21 value.

   :return: the operatingSystemCombo21

getOperatingSystemCombo22
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getOperatingSystemCombo22()
   :outertype: Query

   Gets the operating system combo22 value.

   :return: the operatingSystemCombo22

getOperatingSystemCombo31
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getOperatingSystemCombo31()
   :outertype: Query

   Gets the operating system combo31 value.

   :return: the operatingSystemCombo31

getOperatingSystemCombo32
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getOperatingSystemCombo32()
   :outertype: Query

   Gets the operating system combo32 value.

   :return: the operatingSystemCombo32

getOperatingSystemCombo41
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getOperatingSystemCombo41()
   :outertype: Query

   Gets the operating system combo41 value.

   :return: the operatingSystemCombo41

getOperatingSystemCombo42
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getOperatingSystemCombo42()
   :outertype: Query

   Gets the operating system combo42 value.

   :return: the operatingSystemCombo42

getOperatingSystemCombo51
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getOperatingSystemCombo51()
   :outertype: Query

   Gets the operating system combo51 value.

   :return: the operatingSystemCombo51

getOperatingSystemCombo52
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getOperatingSystemCombo52()
   :outertype: Query

   Gets the operating system combo52 value.

   :return: the operatingSystemCombo52

getOperatingSystemField1
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getOperatingSystemField1()
   :outertype: Query

   Gets the operating system field1 value.

   :return: the operatingSystemField1

getOperatingSystemField2
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getOperatingSystemField2()
   :outertype: Query

   Gets the operating system field2 value.

   :return: the operatingSystemField2

getOperatingSystemField3
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getOperatingSystemField3()
   :outertype: Query

   Gets the operating system field3 value.

   :return: the operatingSystemField3

getOperatingSystemField4
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getOperatingSystemField4()
   :outertype: Query

   Gets the operating system field4 value.

   :return: the operatingSystemField4

getOperatingSystemField5
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getOperatingSystemField5()
   :outertype: Query

   Gets the operating system field5 value.

   :return: the operatingSystemField5

getScheduledUpdates
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<ScheduledUpdate> getScheduledUpdates()
   :outertype: Query

   Gets the scheduled updates.

   :return: the scheduled updates

getSoftwareCB1
^^^^^^^^^^^^^^

.. java:method:: public Boolean getSoftwareCB1()
   :outertype: Query

   Gets the software checkbox1 value.

   :return: the softwareCB1

getSoftwareCB2
^^^^^^^^^^^^^^

.. java:method:: public Boolean getSoftwareCB2()
   :outertype: Query

   Gets the software checkbox2 value.

   :return: the softwareCB2

getSoftwareCB3
^^^^^^^^^^^^^^

.. java:method:: public Boolean getSoftwareCB3()
   :outertype: Query

   Gets the software checkbox3 value.

   :return: the softwareCB3

getSoftwareCB4
^^^^^^^^^^^^^^

.. java:method:: public Boolean getSoftwareCB4()
   :outertype: Query

   Gets the software checkbox4 value.

   :return: the softwareCB4

getSoftwareCB5
^^^^^^^^^^^^^^

.. java:method:: public Boolean getSoftwareCB5()
   :outertype: Query

   Gets the software checkbox5 value.

   :return: the softwareCB5

getSoftwareCombo11
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSoftwareCombo11()
   :outertype: Query

   Gets the software combo11 value.

   :return: the softwareCombo11

getSoftwareCombo12
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSoftwareCombo12()
   :outertype: Query

   Gets the software combo12 value.

   :return: the softwareCombo12

getSoftwareCombo21
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSoftwareCombo21()
   :outertype: Query

   Gets the software combo21 value.

   :return: the softwareCombo21

getSoftwareCombo22
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSoftwareCombo22()
   :outertype: Query

   Gets the software combo22 value.

   :return: the softwareCombo22

getSoftwareCombo31
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSoftwareCombo31()
   :outertype: Query

   Gets the software combo31 value.

   :return: the softwareCombo31

getSoftwareCombo32
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSoftwareCombo32()
   :outertype: Query

   Gets the software combo32 value.

   :return: the softwareCombo32

getSoftwareCombo41
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSoftwareCombo41()
   :outertype: Query

   Gets the software combo41 value.

   :return: the softwareCombo41

getSoftwareCombo42
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSoftwareCombo42()
   :outertype: Query

   Gets the software combo42 value.

   :return: the softwareCombo42

getSoftwareCombo51
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSoftwareCombo51()
   :outertype: Query

   Gets the software combo51 value.

   :return: the softwareCombo51

getSoftwareCombo52
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getSoftwareCombo52()
   :outertype: Query

   Gets the software combo52 value.

   :return: the softwareCombo52

getSoftwareField1
^^^^^^^^^^^^^^^^^

.. java:method:: public String getSoftwareField1()
   :outertype: Query

   Gets the software field1 value.

   :return: the softwareField1

getSoftwareField2
^^^^^^^^^^^^^^^^^

.. java:method:: public String getSoftwareField2()
   :outertype: Query

   Gets the software field2 value.

   :return: the softwareField2

getSoftwareField3
^^^^^^^^^^^^^^^^^

.. java:method:: public String getSoftwareField3()
   :outertype: Query

   Gets the software field3 value.

   :return: the softwareField3

getSoftwareField4
^^^^^^^^^^^^^^^^^

.. java:method:: public String getSoftwareField4()
   :outertype: Query

   Gets the software field4 value.

   :return: the softwareField4

getSoftwareField5
^^^^^^^^^^^^^^^^^

.. java:method:: public String getSoftwareField5()
   :outertype: Query

   Gets the software field5 value.

   :return: the softwareField5

getTerminalCB1
^^^^^^^^^^^^^^

.. java:method:: public Boolean getTerminalCB1()
   :outertype: Query

   Gets the terminal checkbox1 value.

   :return: the terminalCB1

getTerminalCB2
^^^^^^^^^^^^^^

.. java:method:: public Boolean getTerminalCB2()
   :outertype: Query

   Gets the terminal checkbox2 value.

   :return: the terminalCB2

getTerminalCB3
^^^^^^^^^^^^^^

.. java:method:: public Boolean getTerminalCB3()
   :outertype: Query

   Gets the terminal checkbox3 value.

   :return: the terminalCB3

getTerminalCB4
^^^^^^^^^^^^^^

.. java:method:: public Boolean getTerminalCB4()
   :outertype: Query

   Gets the terminal checkbox4 value.

   :return: the terminalCB4

getTerminalCB5
^^^^^^^^^^^^^^

.. java:method:: public Boolean getTerminalCB5()
   :outertype: Query

   Gets the terminal checkbox5 value.

   :return: the terminalCB5

getTerminalCombo11
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getTerminalCombo11()
   :outertype: Query

   Gets the terminal combo11 value.

   :return: the terminalCombo11

getTerminalCombo12
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getTerminalCombo12()
   :outertype: Query

   Gets the terminal combo12 value.

   :return: the terminalCombo12

getTerminalCombo21
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getTerminalCombo21()
   :outertype: Query

   Gets the terminal combo21 value.

   :return: the terminalCombo21

getTerminalCombo22
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getTerminalCombo22()
   :outertype: Query

   Gets the terminal combo22 value.

   :return: the terminalCombo22

getTerminalCombo31
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getTerminalCombo31()
   :outertype: Query

   Gets the terminal combo31 value.

   :return: the terminalCombo31

getTerminalCombo32
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getTerminalCombo32()
   :outertype: Query

   Gets the terminal combo32 value.

   :return: the terminalCombo32

getTerminalCombo41
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getTerminalCombo41()
   :outertype: Query

   Gets the terminal combo41 value.

   :return: the terminalCombo41

getTerminalCombo42
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getTerminalCombo42()
   :outertype: Query

   Gets the terminal combo42 value.

   :return: the terminalCombo42

getTerminalCombo51
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getTerminalCombo51()
   :outertype: Query

   Gets the terminal combo51 value.

   :return: the terminalCombo51

getTerminalCombo52
^^^^^^^^^^^^^^^^^^

.. java:method:: public String getTerminalCombo52()
   :outertype: Query

   Gets the terminal combo52 value.

   :return: the terminalCombo52

getTerminalField1
^^^^^^^^^^^^^^^^^

.. java:method:: public String getTerminalField1()
   :outertype: Query

   Gets the terminal field1 value.

   :return: the terminalField1

getTerminalField2
^^^^^^^^^^^^^^^^^

.. java:method:: public String getTerminalField2()
   :outertype: Query

   Gets the terminal field2 value.

   :return: the terminalField2

getTerminalField3
^^^^^^^^^^^^^^^^^

.. java:method:: public String getTerminalField3()
   :outertype: Query

   Gets the terminal field3 value.

   :return: the terminalField3

getTerminalField4
^^^^^^^^^^^^^^^^^

.. java:method:: public String getTerminalField4()
   :outertype: Query

   Gets the terminal field4 value.

   :return: the terminalField4

getTerminalField5
^^^^^^^^^^^^^^^^^

.. java:method:: public String getTerminalField5()
   :outertype: Query

   Gets the terminal field5 value.

   :return: the terminalField5

getTrueLocale
^^^^^^^^^^^^^

.. java:method:: public Locale getTrueLocale()
   :outertype: Query

   Gets the true locale.

   :return: the true locale

getUser
^^^^^^^

.. java:method:: public User getUser()
   :outertype: Query

   Gets the user.

   :return: the user

getXfsComponentCB1
^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getXfsComponentCB1()
   :outertype: Query

   Gets the xfs component checkbox1 value.

   :return: the xfs component checkbox1 value

getXfsComponentCB2
^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getXfsComponentCB2()
   :outertype: Query

   Gets the xfs component checkbox2 value.

   :return: the xfs component checkbox2 value

getXfsComponentCB3
^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getXfsComponentCB3()
   :outertype: Query

   Gets the xfs component checkbox3 value.

   :return: the xfs component checkbox3 value

getXfsComponentCB4
^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getXfsComponentCB4()
   :outertype: Query

   Gets the xfs component checkbox4 value.

   :return: the xfs component checkbox4 value

getXfsComponentCB5
^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getXfsComponentCB5()
   :outertype: Query

   Gets the xfs component checkbox5 value.

   :return: the xfs component checkbox5 value

getXfsComponentCombo11
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getXfsComponentCombo11()
   :outertype: Query

   Gets the xfs component combo11 value.

   :return: the xfs component combo11 value

getXfsComponentCombo12
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getXfsComponentCombo12()
   :outertype: Query

   Gets the xfs component combo12 value.

   :return: the xfs component combo12 value

getXfsComponentCombo21
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getXfsComponentCombo21()
   :outertype: Query

   Gets the xfs component combo21 value.

   :return: the xfs component combo21 value

getXfsComponentCombo22
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getXfsComponentCombo22()
   :outertype: Query

   Gets the xfs component combo22 value.

   :return: the xfs component combo22 value

getXfsComponentCombo31
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getXfsComponentCombo31()
   :outertype: Query

   Gets the xfs component combo31 value.

   :return: the xfs component combo31 value

getXfsComponentCombo32
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getXfsComponentCombo32()
   :outertype: Query

   Gets the xfs component combo32 value.

   :return: the xfs component combo32 value

getXfsComponentCombo41
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getXfsComponentCombo41()
   :outertype: Query

   Gets the xfs component combo41 value.

   :return: the xfs component combo41 value

getXfsComponentCombo42
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getXfsComponentCombo42()
   :outertype: Query

   Gets the xfs component combo42 value.

   :return: the xfs component combo42 value

getXfsComponentCombo51
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getXfsComponentCombo51()
   :outertype: Query

   Gets the xfs component combo51 value.

   :return: the xfs component combo51 value

getXfsComponentCombo52
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getXfsComponentCombo52()
   :outertype: Query

   Gets the xfs component combo52 value.

   :return: the xfs component combo52 value

getXfsComponentField1
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getXfsComponentField1()
   :outertype: Query

   Gets the xfs component field1 value.

   :return: the xfs component field1 value

getXfsComponentField2
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getXfsComponentField2()
   :outertype: Query

   Gets the xfs component field2 value.

   :return: the xfs component field2 value

getXfsComponentField3
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getXfsComponentField3()
   :outertype: Query

   Gets the xfs component field3 value.

   :return: the xfs component field3 value

getXfsComponentField4
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getXfsComponentField4()
   :outertype: Query

   Gets the xfs component field4 value.

   :return: the xfs component field4 value

getXfsComponentField5
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getXfsComponentField5()
   :outertype: Query

   Gets the xfs component field5 value.

   :return: the xfs component field5 value

getXfsSwCB1
^^^^^^^^^^^

.. java:method:: public Boolean getXfsSwCB1()
   :outertype: Query

   Gets the xfs sw checkbox1 value.

   :return: the xfsSwCB1

getXfsSwCB2
^^^^^^^^^^^

.. java:method:: public Boolean getXfsSwCB2()
   :outertype: Query

   Gets the xfs sw checkbox2 value.

   :return: the xfsSwCB2

getXfsSwCB3
^^^^^^^^^^^

.. java:method:: public Boolean getXfsSwCB3()
   :outertype: Query

   Gets the xfs sw checkbox3 value.

   :return: the xfsSwCB3

getXfsSwCB4
^^^^^^^^^^^

.. java:method:: public Boolean getXfsSwCB4()
   :outertype: Query

   Gets the xfs sw checkbox4 value.

   :return: the xfsSwCB4

getXfsSwCB5
^^^^^^^^^^^

.. java:method:: public Boolean getXfsSwCB5()
   :outertype: Query

   Gets the xfs sw checkbox5 value.

   :return: the xfsSwCB5

getXfsSwCombo11
^^^^^^^^^^^^^^^

.. java:method:: public String getXfsSwCombo11()
   :outertype: Query

   Gets the xfs sw combo11 value.

   :return: the xfsSwCombo11

getXfsSwCombo12
^^^^^^^^^^^^^^^

.. java:method:: public String getXfsSwCombo12()
   :outertype: Query

   Gets the xfs sw combo12 value.

   :return: the xfsSwCombo12

getXfsSwCombo21
^^^^^^^^^^^^^^^

.. java:method:: public String getXfsSwCombo21()
   :outertype: Query

   Gets the xfs sw combo21 value.

   :return: the xfsSwCombo21

getXfsSwCombo22
^^^^^^^^^^^^^^^

.. java:method:: public String getXfsSwCombo22()
   :outertype: Query

   Gets the xfs sw combo22 value.

   :return: the xfsSwCombo22

getXfsSwCombo31
^^^^^^^^^^^^^^^

.. java:method:: public String getXfsSwCombo31()
   :outertype: Query

   Gets the xfs sw combo31 value.

   :return: the xfsSwCombo31

getXfsSwCombo32
^^^^^^^^^^^^^^^

.. java:method:: public String getXfsSwCombo32()
   :outertype: Query

   Gets the xfs sw combo32 value.

   :return: the xfsSwCombo32

getXfsSwCombo41
^^^^^^^^^^^^^^^

.. java:method:: public String getXfsSwCombo41()
   :outertype: Query

   Gets the xfs sw combo41 value.

   :return: the xfsSwCombo41

getXfsSwCombo42
^^^^^^^^^^^^^^^

.. java:method:: public String getXfsSwCombo42()
   :outertype: Query

   Gets the xfs sw combo42 value.

   :return: the xfsSwCombo42

getXfsSwCombo51
^^^^^^^^^^^^^^^

.. java:method:: public String getXfsSwCombo51()
   :outertype: Query

   Gets the xfs sw combo51 value.

   :return: the xfsSwCombo51

getXfsSwCombo52
^^^^^^^^^^^^^^^

.. java:method:: public String getXfsSwCombo52()
   :outertype: Query

   Gets the xfs sw combo52 value.

   :return: the xfsSwCombo52

getXfsSwField1
^^^^^^^^^^^^^^

.. java:method:: public String getXfsSwField1()
   :outertype: Query

   Gets the xfs sw field1 value.

   :return: the xfsSwField1

getXfsSwField2
^^^^^^^^^^^^^^

.. java:method:: public String getXfsSwField2()
   :outertype: Query

   Gets the xfs sw field2 value.

   :return: the xfsSwField2

getXfsSwField3
^^^^^^^^^^^^^^

.. java:method:: public String getXfsSwField3()
   :outertype: Query

   Gets the xfs sw field3 value.

   :return: the xfsSwField3

getXfsSwField4
^^^^^^^^^^^^^^

.. java:method:: public String getXfsSwField4()
   :outertype: Query

   Gets the xfs sw field4 value.

   :return: the xfsSwField4

getXfsSwField5
^^^^^^^^^^^^^^

.. java:method:: public String getXfsSwField5()
   :outertype: Query

   Gets the xfs sw field5 value.

   :return: the xfsSwField5

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: Query

setCreationDate
^^^^^^^^^^^^^^^

.. java:method:: public void setCreationDate(Date creationDate)
   :outertype: Query

   Sets the creation date.

   :param creationDate: the new creation date

setDescription
^^^^^^^^^^^^^^

.. java:method:: public void setDescription(String description)
   :outertype: Query

   Sets the description.

   :param description: the new description

setFeatSwCB1
^^^^^^^^^^^^

.. java:method:: public void setFeatSwCB1(Boolean featSwCB1)
   :outertype: Query

   Sets the feat sw checkbox1 value.

   :param featSwCB1: the featSwCB1 to set

setFeatSwCB2
^^^^^^^^^^^^

.. java:method:: public void setFeatSwCB2(Boolean featSwCB2)
   :outertype: Query

   Sets the feat sw checkbox2 value.

   :param featSwCB2: the featSwCB2 to set

setFeatSwCB3
^^^^^^^^^^^^

.. java:method:: public void setFeatSwCB3(Boolean featSwCB3)
   :outertype: Query

   Sets the feat sw checkbox3 value.

   :param featSwCB3: the featSwCB3 to set

setFeatSwCB4
^^^^^^^^^^^^

.. java:method:: public void setFeatSwCB4(Boolean featSwCB4)
   :outertype: Query

   Sets the feat sw checkbox4 value.

   :param featSwCB4: the featSwCB4 to set

setFeatSwCB5
^^^^^^^^^^^^

.. java:method:: public void setFeatSwCB5(Boolean featSwCB5)
   :outertype: Query

   Sets the feat sw checkbox5 value.

   :param featSwCB5: the featSwCB5 to set

setFeatSwCombo11
^^^^^^^^^^^^^^^^

.. java:method:: public void setFeatSwCombo11(String featSwCombo11)
   :outertype: Query

   Sets the feat sw combo11 value.

   :param featSwCombo11: the featSwCombo11 to set

setFeatSwCombo12
^^^^^^^^^^^^^^^^

.. java:method:: public void setFeatSwCombo12(String featSwCombo12)
   :outertype: Query

   Sets the feat sw combo12 value.

   :param featSwCombo12: the featSwCombo12 to set

setFeatSwCombo21
^^^^^^^^^^^^^^^^

.. java:method:: public void setFeatSwCombo21(String featSwCombo21)
   :outertype: Query

   Sets the feat sw combo21 value.

   :param featSwCombo21: the featSwCombo21 to set

setFeatSwCombo22
^^^^^^^^^^^^^^^^

.. java:method:: public void setFeatSwCombo22(String featSwCombo22)
   :outertype: Query

   Sets the feat sw combo22 value.

   :param featSwCombo22: the featSwCombo22 to set

setFeatSwCombo31
^^^^^^^^^^^^^^^^

.. java:method:: public void setFeatSwCombo31(String featSwCombo31)
   :outertype: Query

   Sets the feat sw combo31 value.

   :param featSwCombo31: the featSwCombo31 to set

setFeatSwCombo32
^^^^^^^^^^^^^^^^

.. java:method:: public void setFeatSwCombo32(String featSwCombo32)
   :outertype: Query

   Sets the feat sw combo32 value.

   :param featSwCombo32: the featSwCombo32 to set

setFeatSwCombo41
^^^^^^^^^^^^^^^^

.. java:method:: public void setFeatSwCombo41(String featSwCombo41)
   :outertype: Query

   Sets the feat sw combo41 value.

   :param featSwCombo41: the featSwCombo41 to set

setFeatSwCombo42
^^^^^^^^^^^^^^^^

.. java:method:: public void setFeatSwCombo42(String featSwCombo42)
   :outertype: Query

   Sets the feat sw combo42 value.

   :param featSwCombo42: the featSwCombo42 to set

setFeatSwCombo51
^^^^^^^^^^^^^^^^

.. java:method:: public void setFeatSwCombo51(String featSwCombo51)
   :outertype: Query

   Sets the feat sw combo51 value.

   :param featSwCombo51: the featSwCombo51 to set

setFeatSwCombo52
^^^^^^^^^^^^^^^^

.. java:method:: public void setFeatSwCombo52(String featSwCombo52)
   :outertype: Query

   Sets the feat sw combo52 value.

   :param featSwCombo52: the featSwCombo52 to set

setFeatSwField1
^^^^^^^^^^^^^^^

.. java:method:: public void setFeatSwField1(String featSwField1)
   :outertype: Query

   Sets the feat sw field1 value.

   :param featSwField1: the featSwField1 to set

setFeatSwField2
^^^^^^^^^^^^^^^

.. java:method:: public void setFeatSwField2(String featSwField2)
   :outertype: Query

   Sets the feat sw field2 value.

   :param featSwField2: the featSwField2 to set

setFeatSwField3
^^^^^^^^^^^^^^^

.. java:method:: public void setFeatSwField3(String featSwField3)
   :outertype: Query

   Sets the feat sw field3 value.

   :param featSwField3: the featSwField3 to set

setFeatSwField4
^^^^^^^^^^^^^^^

.. java:method:: public void setFeatSwField4(String featSwField4)
   :outertype: Query

   Sets the feat sw field4 value.

   :param featSwField4: the featSwField4 to set

setFeatSwField5
^^^^^^^^^^^^^^^

.. java:method:: public void setFeatSwField5(String featSwField5)
   :outertype: Query

   Sets the feat sw field5 value.

   :param featSwField5: the featSwField5 to set

setFinancialDeviceCB1
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFinancialDeviceCB1(Boolean financialDeviceCB1)
   :outertype: Query

   Sets the financial device checkbox1 value.

   :param financialDeviceCB1: the financialDeviceCB1 to set

setFinancialDeviceCB2
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFinancialDeviceCB2(Boolean financialDeviceCB2)
   :outertype: Query

   Sets the financial device checkbox2 value.

   :param financialDeviceCB2: the financialDeviceCB2 to set

setFinancialDeviceCB3
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFinancialDeviceCB3(Boolean financialDeviceCB3)
   :outertype: Query

   Sets the financial device checkbox3 value.

   :param financialDeviceCB3: the financialDeviceCB3 to set

setFinancialDeviceCB4
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFinancialDeviceCB4(Boolean financialDeviceCB4)
   :outertype: Query

   Sets the financial device checkbox4 value.

   :param financialDeviceCB4: the financialDeviceCB4 to set

setFinancialDeviceCB5
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFinancialDeviceCB5(Boolean financialDeviceCB5)
   :outertype: Query

   Sets the financial device checkbox5 value.

   :param financialDeviceCB5: the financialDeviceCB5 to set

setFinancialDeviceCombo11
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFinancialDeviceCombo11(String financialDeviceCombo11)
   :outertype: Query

   Sets the financial device combo11 value.

   :param financialDeviceCombo11: the financialDeviceCombo11 to set

setFinancialDeviceCombo12
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFinancialDeviceCombo12(String financialDeviceCombo12)
   :outertype: Query

   Sets the financial device combo12 value.

   :param financialDeviceCombo12: the financialDeviceCombo12 to set

setFinancialDeviceCombo21
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFinancialDeviceCombo21(String financialDeviceCombo21)
   :outertype: Query

   Sets the financial device combo21 value.

   :param financialDeviceCombo21: the financialDeviceCombo21 to set

setFinancialDeviceCombo22
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFinancialDeviceCombo22(String financialDeviceCombo22)
   :outertype: Query

   Sets the financial device combo22 value.

   :param financialDeviceCombo22: the financialDeviceCombo22 to set

setFinancialDeviceCombo31
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFinancialDeviceCombo31(String financialDeviceCombo31)
   :outertype: Query

   Sets the financial device combo31 value.

   :param financialDeviceCombo31: the financialDeviceCombo31 to set

setFinancialDeviceCombo32
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFinancialDeviceCombo32(String financialDeviceCombo32)
   :outertype: Query

   Sets the financial device combo32 value.

   :param financialDeviceCombo32: the financialDeviceCombo32 to set

setFinancialDeviceCombo41
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFinancialDeviceCombo41(String financialDeviceCombo41)
   :outertype: Query

   Sets the financial device combo41 value.

   :param financialDeviceCombo41: the financialDeviceCombo41 to set

setFinancialDeviceCombo42
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFinancialDeviceCombo42(String financialDeviceCombo42)
   :outertype: Query

   Sets the financial device combo42 value.

   :param financialDeviceCombo42: the financialDeviceCombo42 to set

setFinancialDeviceCombo51
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFinancialDeviceCombo51(String financialDeviceCombo51)
   :outertype: Query

   Sets the financial device combo51 value.

   :param financialDeviceCombo51: the financialDeviceCombo51 to set

setFinancialDeviceCombo52
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFinancialDeviceCombo52(String financialDeviceCombo52)
   :outertype: Query

   Sets the financial device combo52 value.

   :param financialDeviceCombo52: the financialDeviceCombo52 to set

setFinancialDeviceField1
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFinancialDeviceField1(String financialDeviceField1)
   :outertype: Query

   Sets the financial device field1 value.

   :param financialDeviceField1: the financialDeviceField1 to set

setFinancialDeviceField2
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFinancialDeviceField2(String financialDeviceField2)
   :outertype: Query

   Sets the financial device field2 value.

   :param financialDeviceField2: the financialDeviceField2 to set

setFinancialDeviceField3
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFinancialDeviceField3(String financialDeviceField3)
   :outertype: Query

   Sets the financial device field3 value.

   :param financialDeviceField3: the financialDeviceField3 to set

setFinancialDeviceField4
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFinancialDeviceField4(String financialDeviceField4)
   :outertype: Query

   Sets the financial device field4 value.

   :param financialDeviceField4: the financialDeviceField4 to set

setFinancialDeviceField5
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setFinancialDeviceField5(String financialDeviceField5)
   :outertype: Query

   Sets the financial device field5 value.

   :param financialDeviceField5: the financialDeviceField5 to set

setHardwareDeviceCB1
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDeviceCB1(Boolean hardwareDeviceCB1)
   :outertype: Query

   Sets the hardware device checkbox1 value.

   :param hardwareDeviceCB1: the hardwareDeviceCB1 to set

setHardwareDeviceCB2
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDeviceCB2(Boolean hardwareDeviceCB2)
   :outertype: Query

   Sets the hardware device checkbox2 value.

   :param hardwareDeviceCB2: the hardwareDeviceCB2 to set

setHardwareDeviceCB3
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDeviceCB3(Boolean hardwareDeviceCB3)
   :outertype: Query

   Sets the hardware device checkbox3 value.

   :param hardwareDeviceCB3: the hardwareDeviceCB3 to set

setHardwareDeviceCB4
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDeviceCB4(Boolean hardwareDeviceCB4)
   :outertype: Query

   Sets the hardware device checkbox4 value.

   :param hardwareDeviceCB4: the hardwareDeviceCB4 to set

setHardwareDeviceCB5
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDeviceCB5(Boolean hardwareDeviceCB5)
   :outertype: Query

   Sets the hardware device checkbox5 value.

   :param hardwareDeviceCB5: the hardwareDeviceCB5 to set

setHardwareDeviceCombo11
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDeviceCombo11(String hardwareDeviceCombo11)
   :outertype: Query

   Sets the hardware device combo11 value.

   :param hardwareDeviceCombo11: the hardwareDeviceCombo11 to set

setHardwareDeviceCombo12
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDeviceCombo12(String hardwareDeviceCombo12)
   :outertype: Query

   Sets the hardware device combo12 value.

   :param hardwareDeviceCombo12: the hardwareDeviceCombo12 to set

setHardwareDeviceCombo13
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDeviceCombo13(String hardwareDeviceCombo13)
   :outertype: Query

   Sets the hardware device combo13 value.

   :param hardwareDeviceCombo13: the hardwareDeviceCombo13 to set

setHardwareDeviceCombo21
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDeviceCombo21(String hardwareDeviceCombo21)
   :outertype: Query

   Sets the hardware device combo21 value.

   :param hardwareDeviceCombo21: the hardwareDeviceCombo21 to set

setHardwareDeviceCombo22
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDeviceCombo22(String hardwareDeviceCombo22)
   :outertype: Query

   Sets the hardware device combo22 value.

   :param hardwareDeviceCombo22: the hardwareDeviceCombo22 to set

setHardwareDeviceCombo23
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDeviceCombo23(String hardwareDeviceCombo23)
   :outertype: Query

   Sets the hardware device combo23 value.

   :param hardwareDeviceCombo23: the hardwareDeviceCombo23 to set

setHardwareDeviceCombo31
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDeviceCombo31(String hardwareDeviceCombo31)
   :outertype: Query

   Sets the hardware device combo31 value.

   :param hardwareDeviceCombo31: the hardwareDeviceCombo31 to set

setHardwareDeviceCombo32
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDeviceCombo32(String hardwareDeviceCombo32)
   :outertype: Query

   Sets the hardware device combo32 value.

   :param hardwareDeviceCombo32: the hardwareDeviceCombo32 to set

setHardwareDeviceCombo33
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDeviceCombo33(String hardwareDeviceCombo33)
   :outertype: Query

   Sets the hardware device combo33 value.

   :param hardwareDeviceCombo33: the hardwareDeviceCombo33 to set

setHardwareDeviceCombo41
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDeviceCombo41(String hardwareDeviceCombo41)
   :outertype: Query

   Sets the hardware device combo41 value.

   :param hardwareDeviceCombo41: the hardwareDeviceCombo41 to set

setHardwareDeviceCombo42
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDeviceCombo42(String hardwareDeviceCombo42)
   :outertype: Query

   Sets the hardware device combo42 value.

   :param hardwareDeviceCombo42: the hardwareDeviceCombo42 to set

setHardwareDeviceCombo43
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDeviceCombo43(String hardwareDeviceCombo43)
   :outertype: Query

   Sets the hardware device combo43 value.

   :param hardwareDeviceCombo43: the hardwareDeviceCombo43 to set

setHardwareDeviceCombo51
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDeviceCombo51(String hardwareDeviceCombo51)
   :outertype: Query

   Sets the hardware device combo51 value.

   :param hardwareDeviceCombo51: the hardwareDeviceCombo51 to set

setHardwareDeviceCombo52
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDeviceCombo52(String hardwareDeviceCombo52)
   :outertype: Query

   Sets the hardware device combo52 value.

   :param hardwareDeviceCombo52: the hardwareDeviceCombo52 to set

setHardwareDeviceCombo53
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDeviceCombo53(String hardwareDeviceCombo53)
   :outertype: Query

   Sets the hardware device combo53 value.

   :param hardwareDeviceCombo53: the hardwareDeviceCombo53 to set

setHardwareDeviceField1
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDeviceField1(String hardwareDeviceField1)
   :outertype: Query

   Sets the hardware device field1 value.

   :param hardwareDeviceField1: the hardwareDeviceField1 to set

setHardwareDeviceField2
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDeviceField2(String hardwareDeviceField2)
   :outertype: Query

   Sets the hardware device field2 value.

   :param hardwareDeviceField2: the hardwareDeviceField2 to set

setHardwareDeviceField3
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDeviceField3(String hardwareDeviceField3)
   :outertype: Query

   Sets the hardware device field3 value.

   :param hardwareDeviceField3: the hardwareDeviceField3 to set

setHardwareDeviceField4
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDeviceField4(String hardwareDeviceField4)
   :outertype: Query

   Sets the hardware device field4 value.

   :param hardwareDeviceField4: the hardwareDeviceField4 to set

setHardwareDeviceField5
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHardwareDeviceField5(String hardwareDeviceField5)
   :outertype: Query

   Sets the hardware device field5 value.

   :param hardwareDeviceField5: the hardwareDeviceField5 to set

setHotfixCB1
^^^^^^^^^^^^

.. java:method:: public void setHotfixCB1(Boolean hotfixCB1)
   :outertype: Query

   Sets the hotfix checkbox1 value.

   :param hotfixCB1: the hotfixCB1 to set

setHotfixCB2
^^^^^^^^^^^^

.. java:method:: public void setHotfixCB2(Boolean hotfixCB2)
   :outertype: Query

   Sets the hotfix checkbox2 value.

   :param hotfixCB2: the hotfixCB2 to set

setHotfixCB3
^^^^^^^^^^^^

.. java:method:: public void setHotfixCB3(Boolean hotfixCB3)
   :outertype: Query

   Sets the hotfix checkbox3 value.

   :param hotfixCB3: the hotfixCB3 to set

setHotfixCB4
^^^^^^^^^^^^

.. java:method:: public void setHotfixCB4(Boolean hotfixCB4)
   :outertype: Query

   Sets the hotfix checkbox4 value.

   :param hotfixCB4: the hotfixCB4 to set

setHotfixCB5
^^^^^^^^^^^^

.. java:method:: public void setHotfixCB5(Boolean hotfixCB5)
   :outertype: Query

   Sets the hotfix checkbox5 value.

   :param hotfixCB5: the hotfixCB5 to set

setHotfixCombo11
^^^^^^^^^^^^^^^^

.. java:method:: public void setHotfixCombo11(String hotfixCombo11)
   :outertype: Query

   Sets the hotfix combo11 value.

   :param hotfixCombo11: the hotfixCombo11 to set

setHotfixCombo12
^^^^^^^^^^^^^^^^

.. java:method:: public void setHotfixCombo12(String hotfixCombo12)
   :outertype: Query

   Sets the hotfix combo12 value.

   :param hotfixCombo12: the hotfixCombo12 to set

setHotfixCombo21
^^^^^^^^^^^^^^^^

.. java:method:: public void setHotfixCombo21(String hotfixCombo21)
   :outertype: Query

   Sets the hotfix combo21 value.

   :param hotfixCombo21: the hotfixCombo21 to set

setHotfixCombo22
^^^^^^^^^^^^^^^^

.. java:method:: public void setHotfixCombo22(String hotfixCombo22)
   :outertype: Query

   Sets the hotfix combo22 value.

   :param hotfixCombo22: the hotfixCombo22 to set

setHotfixCombo31
^^^^^^^^^^^^^^^^

.. java:method:: public void setHotfixCombo31(String hotfixCombo31)
   :outertype: Query

   Sets the hotfix combo31 value.

   :param hotfixCombo31: the hotfixCombo31 to set

setHotfixCombo32
^^^^^^^^^^^^^^^^

.. java:method:: public void setHotfixCombo32(String hotfixCombo32)
   :outertype: Query

   Sets the hotfix combo32 value.

   :param hotfixCombo32: the hotfixCombo32 to set

setHotfixCombo41
^^^^^^^^^^^^^^^^

.. java:method:: public void setHotfixCombo41(String hotfixCombo41)
   :outertype: Query

   Sets the hotfix combo41 value.

   :param hotfixCombo41: the hotfixCombo41 to set

setHotfixCombo42
^^^^^^^^^^^^^^^^

.. java:method:: public void setHotfixCombo42(String hotfixCombo42)
   :outertype: Query

   Sets the hotfix combo42 value.

   :param hotfixCombo42: the hotfixCombo42 to set

setHotfixCombo51
^^^^^^^^^^^^^^^^

.. java:method:: public void setHotfixCombo51(String hotfixCombo51)
   :outertype: Query

   Sets the hotfix combo51 value.

   :param hotfixCombo51: the hotfixCombo51 to set

setHotfixCombo52
^^^^^^^^^^^^^^^^

.. java:method:: public void setHotfixCombo52(String hotfixCombo52)
   :outertype: Query

   Sets the hotfix combo52 value.

   :param hotfixCombo52: the hotfixCombo52 to set

setHotfixField1
^^^^^^^^^^^^^^^

.. java:method:: public void setHotfixField1(String hotfixField1)
   :outertype: Query

   Sets the hotfix field1 value.

   :param hotfixField1: the hotfixField1 to set

setHotfixField2
^^^^^^^^^^^^^^^

.. java:method:: public void setHotfixField2(String hotfixField2)
   :outertype: Query

   Sets the hotfix field2 value.

   :param hotfixField2: the hotfixField2 to set

setHotfixField3
^^^^^^^^^^^^^^^

.. java:method:: public void setHotfixField3(String hotfixField3)
   :outertype: Query

   Sets the hotfix field3 value.

   :param hotfixField3: the hotfixField3 to set

setHotfixField4
^^^^^^^^^^^^^^^

.. java:method:: public void setHotfixField4(String hotfixField4)
   :outertype: Query

   Sets the hotfix field4 value.

   :param hotfixField4: the hotfixField4 to set

setHotfixField5
^^^^^^^^^^^^^^^

.. java:method:: public void setHotfixField5(String hotfixField5)
   :outertype: Query

   Sets the hotfix field5 value.

   :param hotfixField5: the hotfixField5 to set

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: Query

   Sets the id.

   :param id: the id to set

setInternetExplorerCB1
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setInternetExplorerCB1(Boolean internetExplorerCB1)
   :outertype: Query

   Sets the internet explorer checkbox1 value.

   :param internetExplorerCB1: the internetExplorerCB1 to set

setInternetExplorerCB2
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setInternetExplorerCB2(Boolean internetExplorerCB2)
   :outertype: Query

   Sets the internet explorer checkbox2 value.

   :param internetExplorerCB2: the internetExplorerCB2 to set

setInternetExplorerCombo11
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setInternetExplorerCombo11(String internetExplorerCombo11)
   :outertype: Query

   Sets the internet explorer combo11 value.

   :param internetExplorerCombo11: the internetExplorerCombo11 to set

setInternetExplorerCombo12
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setInternetExplorerCombo12(String internetExplorerCombo12)
   :outertype: Query

   Sets the internet explorer combo12 value.

   :param internetExplorerCombo12: the internetExplorerCombo12 to set

setInternetExplorerCombo21
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setInternetExplorerCombo21(String internetExplorerCombo21)
   :outertype: Query

   Sets the internet explorer combo21 value.

   :param internetExplorerCombo21: the internetExplorerCombo21 to set

setInternetExplorerCombo22
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setInternetExplorerCombo22(String internetExplorerCombo22)
   :outertype: Query

   Sets the internet explorer combo22 value.

   :param internetExplorerCombo22: the internetExplorerCombo22 to set

setInternetExplorerField1
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setInternetExplorerField1(String internetExplorerField1)
   :outertype: Query

   Sets the internet explorer field1 value.

   :param internetExplorerField1: the internetExplorerField1 to set

setInternetExplorerField2
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setInternetExplorerField2(String internetExplorerField2)
   :outertype: Query

   Sets the internet explorer field2 value.

   :param internetExplorerField2: the internetExplorerField2 to set

setJxfsComponentCB1
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setJxfsComponentCB1(Boolean jxfsComponentCB1)
   :outertype: Query

   Sets the jxfs component checkbox1 value.

   :param jxfsComponentCB1: the new jxfs component checkbox1 value

setJxfsComponentCB2
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setJxfsComponentCB2(Boolean jxfsComponentCB2)
   :outertype: Query

   Sets the jxfs component checkbox2 value.

   :param jxfsComponentCB2: the new jxfs component checkbox2 value

setJxfsComponentCB3
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setJxfsComponentCB3(Boolean jxfsComponentCB3)
   :outertype: Query

   Sets the jxfs component checkbox3 value.

   :param jxfsComponentCB3: the new jxfs component checkbox3 value

setJxfsComponentCB4
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setJxfsComponentCB4(Boolean jxfsComponentCB4)
   :outertype: Query

   Sets the jxfs component checkbox4 value.

   :param jxfsComponentCB4: the new jxfs component checkbox4 value

setJxfsComponentCB5
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setJxfsComponentCB5(Boolean jxfsComponentCB5)
   :outertype: Query

   Sets the jxfs component checkbox5 value.

   :param jxfsComponentCB5: the new jxfs component checkbox5 value

setJxfsComponentCombo11
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setJxfsComponentCombo11(String jxfsComponentCombo11)
   :outertype: Query

   Sets the jxfs component combo11 value.

   :param jxfsComponentCombo11: the new jxfs component combo11 value

setJxfsComponentCombo12
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setJxfsComponentCombo12(String jxfsComponentCombo12)
   :outertype: Query

   Sets the jxfs component combo12 value.

   :param jxfsComponentCombo12: the new jxfs component combo12 value

setJxfsComponentCombo21
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setJxfsComponentCombo21(String jxfsComponentCombo21)
   :outertype: Query

   Sets the jxfs component combo21 value.

   :param jxfsComponentCombo21: the new jxfs component combo21 value

setJxfsComponentCombo22
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setJxfsComponentCombo22(String jxfsComponentCombo22)
   :outertype: Query

   Sets the jxfs component combo22 value.

   :param jxfsComponentCombo22: the new jxfs component combo22 value

setJxfsComponentCombo31
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setJxfsComponentCombo31(String jxfsComponentCombo31)
   :outertype: Query

   Sets the jxfs component combo31 value.

   :param jxfsComponentCombo31: the new jxfs component combo31 value

setJxfsComponentCombo32
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setJxfsComponentCombo32(String jxfsComponentCombo32)
   :outertype: Query

   Sets the jxfs component combo32 value.

   :param jxfsComponentCombo32: the new jxfs component combo32 value

setJxfsComponentCombo41
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setJxfsComponentCombo41(String jxfsComponentCombo41)
   :outertype: Query

   Sets the jxfs component combo41 value.

   :param jxfsComponentCombo41: the new jxfs component combo41 value

setJxfsComponentCombo42
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setJxfsComponentCombo42(String jxfsComponentCombo42)
   :outertype: Query

   Sets the jxfs component combo42 value.

   :param jxfsComponentCombo42: the new jxfs component combo42 value

setJxfsComponentCombo51
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setJxfsComponentCombo51(String jxfsComponentCombo51)
   :outertype: Query

   Sets the jxfs component combo51 value.

   :param jxfsComponentCombo51: the new jxfs component combo51 value

setJxfsComponentCombo52
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setJxfsComponentCombo52(String jxfsComponentCombo52)
   :outertype: Query

   Sets the jxfs component combo52 value.

   :param jxfsComponentCombo52: the new jxfs component combo52 value

setJxfsComponentField1
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setJxfsComponentField1(String jxfsComponentField1)
   :outertype: Query

   Sets the jxfs component field1 value.

   :param jxfsComponentField1: the new jxfs component field1 value

setJxfsComponentField2
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setJxfsComponentField2(String jxfsComponentField2)
   :outertype: Query

   Sets the jxfs component field2 value.

   :param jxfsComponentField2: the new jxfs component field2 value

setJxfsComponentField3
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setJxfsComponentField3(String jxfsComponentField3)
   :outertype: Query

   Sets the jxfs component field3 value.

   :param jxfsComponentField3: the new jxfs component field3 value

setJxfsComponentField4
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setJxfsComponentField4(String jxfsComponentField4)
   :outertype: Query

   Sets the jxfs component field4 value.

   :param jxfsComponentField4: the new jxfs component field4 value

setJxfsComponentField5
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setJxfsComponentField5(String jxfsComponentField5)
   :outertype: Query

   Sets the jxfs component field5 value.

   :param jxfsComponentField5: the new jxfs component field5 value

setLocale
^^^^^^^^^

.. java:method:: public void setLocale(String locale)
   :outertype: Query

   Sets the locale.

   :param locale: the new locale

setName
^^^^^^^

.. java:method:: public void setName(String name)
   :outertype: Query

   Sets the name.

   :param name: the name to set

setOperatingSystemCB1
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setOperatingSystemCB1(Boolean operatingSystemCB1)
   :outertype: Query

   Sets the operating system checkbox1 value.

   :param operatingSystemCB1: the operatingSystemCB1 to set

setOperatingSystemCB2
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setOperatingSystemCB2(Boolean operatingSystemCB2)
   :outertype: Query

   Sets the operating system checkbox2 value.

   :param operatingSystemCB2: the operatingSystemCB2 to set

setOperatingSystemCB3
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setOperatingSystemCB3(Boolean operatingSystemCB3)
   :outertype: Query

   Sets the operating system checkbox3 value.

   :param operatingSystemCB3: the operatingSystemCB3 to set

setOperatingSystemCB4
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setOperatingSystemCB4(Boolean operatingSystemCB4)
   :outertype: Query

   Sets the operating system checkbox4 value.

   :param operatingSystemCB4: the operatingSystemCB4 to set

setOperatingSystemCB5
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setOperatingSystemCB5(Boolean operatingSystemCB5)
   :outertype: Query

   Sets the operating system checkbox5 value.

   :param operatingSystemCB5: the operatingSystemCB5 to set

setOperatingSystemCombo11
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setOperatingSystemCombo11(String operatingSystemCombo11)
   :outertype: Query

   Sets the operating system combo11 value.

   :param operatingSystemCombo11: the operatingSystemCombo11 to set

setOperatingSystemCombo12
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setOperatingSystemCombo12(String operatingSystemCombo12)
   :outertype: Query

   Sets the operating system combo12 value.

   :param operatingSystemCombo12: the operatingSystemCombo12 to set

setOperatingSystemCombo21
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setOperatingSystemCombo21(String operatingSystemCombo21)
   :outertype: Query

   Sets the operating system combo21 value.

   :param operatingSystemCombo21: the operatingSystemCombo21 to set

setOperatingSystemCombo22
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setOperatingSystemCombo22(String operatingSystemCombo22)
   :outertype: Query

   Sets the operating system combo22 value.

   :param operatingSystemCombo22: the operatingSystemCombo22 to set

setOperatingSystemCombo31
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setOperatingSystemCombo31(String operatingSystemCombo31)
   :outertype: Query

   Sets the operating system combo31 value.

   :param operatingSystemCombo31: the operatingSystemCombo31 to set

setOperatingSystemCombo32
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setOperatingSystemCombo32(String operatingSystemCombo32)
   :outertype: Query

   Sets the operating system combo32 value.

   :param operatingSystemCombo32: the operatingSystemCombo32 to set

setOperatingSystemCombo41
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setOperatingSystemCombo41(String operatingSystemCombo41)
   :outertype: Query

   Sets the operating system combo41 value.

   :param operatingSystemCombo41: the operatingSystemCombo41 to set

setOperatingSystemCombo42
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setOperatingSystemCombo42(String operatingSystemCombo42)
   :outertype: Query

   Sets the operating system combo42 value.

   :param operatingSystemCombo42: the operatingSystemCombo42 to set

setOperatingSystemCombo51
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setOperatingSystemCombo51(String operatingSystemCombo51)
   :outertype: Query

   Sets the operating system combo51 value.

   :param operatingSystemCombo51: the operatingSystemCombo51 to set

setOperatingSystemCombo52
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setOperatingSystemCombo52(String operatingSystemCombo52)
   :outertype: Query

   Sets the operating system combo52 value.

   :param operatingSystemCombo52: the operatingSystemCombo52 to set

setOperatingSystemField1
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setOperatingSystemField1(String operatingSystemField1)
   :outertype: Query

   Sets the operating system field1 value.

   :param operatingSystemField1: the operatingSystemField1 to set

setOperatingSystemField2
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setOperatingSystemField2(String operatingSystemField2)
   :outertype: Query

   Sets the operating system field2 value.

   :param operatingSystemField2: the operatingSystemField2 to set

setOperatingSystemField3
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setOperatingSystemField3(String operatingSystemField3)
   :outertype: Query

   Sets the operating system field3 value.

   :param operatingSystemField3: the operatingSystemField3 to set

setOperatingSystemField4
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setOperatingSystemField4(String operatingSystemField4)
   :outertype: Query

   Sets the operating system field4 value.

   :param operatingSystemField4: the operatingSystemField4 to set

setOperatingSystemField5
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setOperatingSystemField5(String operatingSystemField5)
   :outertype: Query

   Sets the operating system field5 value.

   :param operatingSystemField5: the operatingSystemField5 to set

setScheduledUpdates
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setScheduledUpdates(Set<ScheduledUpdate> scheduledUpdates)
   :outertype: Query

   Sets the scheduled updates.

   :param scheduledUpdates: the new scheduled updates

setSoftwareCB1
^^^^^^^^^^^^^^

.. java:method:: public void setSoftwareCB1(Boolean softwareCB1)
   :outertype: Query

   Sets the software checkbox1 value.

   :param softwareCB1: the softwareCB1 to set

setSoftwareCB2
^^^^^^^^^^^^^^

.. java:method:: public void setSoftwareCB2(Boolean softwareCB2)
   :outertype: Query

   Sets the software checkbox2 value.

   :param softwareCB2: the softwareCB2 to set

setSoftwareCB3
^^^^^^^^^^^^^^

.. java:method:: public void setSoftwareCB3(Boolean softwareCB3)
   :outertype: Query

   Sets the software checkbox3 value.

   :param softwareCB3: the softwareCB3 to set

setSoftwareCB4
^^^^^^^^^^^^^^

.. java:method:: public void setSoftwareCB4(Boolean softwareCB4)
   :outertype: Query

   Sets the software checkbox4 value.

   :param softwareCB4: the softwareCB4 to set

setSoftwareCB5
^^^^^^^^^^^^^^

.. java:method:: public void setSoftwareCB5(Boolean softwareCB5)
   :outertype: Query

   Sets the software checkbox5 value.

   :param softwareCB5: the softwareCB5 to set

setSoftwareCombo11
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSoftwareCombo11(String softwareCombo11)
   :outertype: Query

   Sets the software combo11 value.

   :param softwareCombo11: the softwareCombo11 to set

setSoftwareCombo12
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSoftwareCombo12(String softwareCombo12)
   :outertype: Query

   Sets the software combo12 value.

   :param softwareCombo12: the softwareCombo12 to set

setSoftwareCombo21
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSoftwareCombo21(String softwareCombo21)
   :outertype: Query

   Sets the software combo21 value.

   :param softwareCombo21: the softwareCombo21 to set

setSoftwareCombo22
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSoftwareCombo22(String softwareCombo22)
   :outertype: Query

   Sets the software combo22 value.

   :param softwareCombo22: the softwareCombo22 to set

setSoftwareCombo31
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSoftwareCombo31(String softwareCombo31)
   :outertype: Query

   Sets the software combo31 value.

   :param softwareCombo31: the softwareCombo31 to set

setSoftwareCombo32
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSoftwareCombo32(String softwareCombo32)
   :outertype: Query

   Sets the software combo32 value.

   :param softwareCombo32: the softwareCombo32 to set

setSoftwareCombo41
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSoftwareCombo41(String softwareCombo41)
   :outertype: Query

   Sets the software combo41 value.

   :param softwareCombo41: the softwareCombo41 to set

setSoftwareCombo42
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSoftwareCombo42(String softwareCombo42)
   :outertype: Query

   Sets the software combo42 value.

   :param softwareCombo42: the softwareCombo42 to set

setSoftwareCombo51
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSoftwareCombo51(String softwareCombo51)
   :outertype: Query

   Sets the software combo51 value.

   :param softwareCombo51: the softwareCombo51 to set

setSoftwareCombo52
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSoftwareCombo52(String softwareCombo52)
   :outertype: Query

   Sets the software combo52 value.

   :param softwareCombo52: the softwareCombo52 to set

setSoftwareField1
^^^^^^^^^^^^^^^^^

.. java:method:: public void setSoftwareField1(String softwareField1)
   :outertype: Query

   Sets the software field1 value.

   :param softwareField1: the softwareField1 to set

setSoftwareField2
^^^^^^^^^^^^^^^^^

.. java:method:: public void setSoftwareField2(String softwareField2)
   :outertype: Query

   Sets the software field2 value.

   :param softwareField2: the softwareField2 to set

setSoftwareField3
^^^^^^^^^^^^^^^^^

.. java:method:: public void setSoftwareField3(String softwareField3)
   :outertype: Query

   Sets the software field3 value.

   :param softwareField3: the softwareField3 to set

setSoftwareField4
^^^^^^^^^^^^^^^^^

.. java:method:: public void setSoftwareField4(String softwareField4)
   :outertype: Query

   Sets the software field4 value.

   :param softwareField4: the softwareField4 to set

setSoftwareField5
^^^^^^^^^^^^^^^^^

.. java:method:: public void setSoftwareField5(String softwareField5)
   :outertype: Query

   Sets the software field5 value.

   :param softwareField5: the softwareField5 to set

setTerminalCB1
^^^^^^^^^^^^^^

.. java:method:: public void setTerminalCB1(Boolean terminalCB1)
   :outertype: Query

   Sets the terminal checkbox1 value.

   :param terminalCB1: the terminalCB1 to set

setTerminalCB2
^^^^^^^^^^^^^^

.. java:method:: public void setTerminalCB2(Boolean terminalCB2)
   :outertype: Query

   Sets the terminal checkbox2 value.

   :param terminalCB2: the terminalCB2 to set

setTerminalCB3
^^^^^^^^^^^^^^

.. java:method:: public void setTerminalCB3(Boolean terminalCB3)
   :outertype: Query

   Sets the terminal checkbox3 value.

   :param terminalCB3: the terminalCB3 to set

setTerminalCB4
^^^^^^^^^^^^^^

.. java:method:: public void setTerminalCB4(Boolean terminalCB4)
   :outertype: Query

   Sets the terminal checkbox4 value.

   :param terminalCB4: the terminalCB4 to set

setTerminalCB5
^^^^^^^^^^^^^^

.. java:method:: public void setTerminalCB5(Boolean terminalCB5)
   :outertype: Query

   Sets the terminal checkbox5 value.

   :param terminalCB5: the terminalCB5 to set

setTerminalCombo11
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setTerminalCombo11(String terminalCombo11)
   :outertype: Query

   Sets the terminal combo11 value.

   :param terminalCombo11: the terminalCombo11 to set

setTerminalCombo12
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setTerminalCombo12(String terminalCombo12)
   :outertype: Query

   Sets the terminal combo12 value.

   :param terminalCombo12: the terminalCombo12 to set

setTerminalCombo21
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setTerminalCombo21(String terminalCombo21)
   :outertype: Query

   Sets the terminal combo21 value.

   :param terminalCombo21: the terminalCombo21 to set

setTerminalCombo22
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setTerminalCombo22(String terminalCombo22)
   :outertype: Query

   Sets the terminal combo22 value.

   :param terminalCombo22: the terminalCombo22 to set

setTerminalCombo31
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setTerminalCombo31(String terminalCombo31)
   :outertype: Query

   Sets the terminal combo31 value.

   :param terminalCombo31: the terminalCombo31 to set

setTerminalCombo32
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setTerminalCombo32(String terminalCombo32)
   :outertype: Query

   Sets the terminal combo32 value.

   :param terminalCombo32: the terminalCombo32 to set

setTerminalCombo41
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setTerminalCombo41(String terminalCombo41)
   :outertype: Query

   Sets the terminal combo41 value.

   :param terminalCombo41: the terminalCombo41 to set

setTerminalCombo42
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setTerminalCombo42(String terminalCombo42)
   :outertype: Query

   Sets the terminal combo42 value.

   :param terminalCombo42: the terminalCombo42 to set

setTerminalCombo51
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setTerminalCombo51(String terminalCombo51)
   :outertype: Query

   Sets the terminal combo51 value.

   :param terminalCombo51: the terminalCombo51 to set

setTerminalCombo52
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setTerminalCombo52(String terminalCombo52)
   :outertype: Query

   Sets the terminal combo52 value.

   :param terminalCombo52: the terminalCombo52 to set

setTerminalField1
^^^^^^^^^^^^^^^^^

.. java:method:: public void setTerminalField1(String terminalField1)
   :outertype: Query

   Sets the terminal field1 value.

   :param terminalField1: the terminalField1 to set

setTerminalField2
^^^^^^^^^^^^^^^^^

.. java:method:: public void setTerminalField2(String terminalField2)
   :outertype: Query

   Sets the terminal field2 value.

   :param terminalField2: the terminalField2 to set

setTerminalField3
^^^^^^^^^^^^^^^^^

.. java:method:: public void setTerminalField3(String terminalField3)
   :outertype: Query

   Sets the terminal field3 value.

   :param terminalField3: the terminalField3 to set

setTerminalField4
^^^^^^^^^^^^^^^^^

.. java:method:: public void setTerminalField4(String terminalField4)
   :outertype: Query

   Sets the terminal field4 value.

   :param terminalField4: the terminalField4 to set

setTerminalField5
^^^^^^^^^^^^^^^^^

.. java:method:: public void setTerminalField5(String terminalField5)
   :outertype: Query

   Sets the terminal field5 value.

   :param terminalField5: the terminalField5 to set

setTrueLocale
^^^^^^^^^^^^^

.. java:method:: public void setTrueLocale(Locale locale)
   :outertype: Query

   Sets the true locale.

   :param locale: the new true locale

setUser
^^^^^^^

.. java:method:: public void setUser(User user)
   :outertype: Query

   Sets the user.

   :param user: the user to set

setXfsComponentCB1
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setXfsComponentCB1(Boolean xfsComponentCB1)
   :outertype: Query

   Sets the xfs component checkbox1 value.

   :param xfsComponentCB1: the new xfs component checkbox1 value

setXfsComponentCB2
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setXfsComponentCB2(Boolean xfsComponentCB2)
   :outertype: Query

   Sets the xfs component checkbox2 value.

   :param xfsComponentCB2: the new xfs component checkbox2 value

setXfsComponentCB3
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setXfsComponentCB3(Boolean xfsComponentCB3)
   :outertype: Query

   Sets the xfs component checkbox3 value.

   :param xfsComponentCB3: the new xfs component checkbox3 value

setXfsComponentCB4
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setXfsComponentCB4(Boolean xfsComponentCB4)
   :outertype: Query

   Sets the xfs component checkbox4 value.

   :param xfsComponentCB4: the new xfs component checkbox4 value

setXfsComponentCB5
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setXfsComponentCB5(Boolean xfsComponentCB5)
   :outertype: Query

   Sets the xfs component checkbox5 value.

   :param xfsComponentCB5: the new xfs component checkbox5 value

setXfsComponentCombo11
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setXfsComponentCombo11(String xfsComponentCombo11)
   :outertype: Query

   Sets the xfs component combo11 value.

   :param xfsComponentCombo11: the new xfs component combo11 value

setXfsComponentCombo12
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setXfsComponentCombo12(String xfsComponentCombo12)
   :outertype: Query

   Sets the xfs component combo12 value.

   :param xfsComponentCombo12: the new xfs component combo12 value

setXfsComponentCombo21
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setXfsComponentCombo21(String xfsComponentCombo21)
   :outertype: Query

   Sets the xfs component combo21 value.

   :param xfsComponentCombo21: the new xfs component combo21 value

setXfsComponentCombo22
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setXfsComponentCombo22(String xfsComponentCombo22)
   :outertype: Query

   Sets the xfs component combo22 value.

   :param xfsComponentCombo22: the new xfs component combo22 value

setXfsComponentCombo31
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setXfsComponentCombo31(String xfsComponentCombo31)
   :outertype: Query

   Sets the xfs component combo31 value.

   :param xfsComponentCombo31: the new xfs component combo31 value

setXfsComponentCombo32
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setXfsComponentCombo32(String xfsComponentCombo32)
   :outertype: Query

   Sets the xfs component combo32 value.

   :param xfsComponentCombo32: the new xfs component combo32 value

setXfsComponentCombo41
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setXfsComponentCombo41(String xfsComponentCombo41)
   :outertype: Query

   Sets the xfs component combo41 value.

   :param xfsComponentCombo41: the new xfs component combo41 value

setXfsComponentCombo42
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setXfsComponentCombo42(String xfsComponentCombo42)
   :outertype: Query

   Sets the xfs component combo42 value.

   :param xfsComponentCombo42: the new xfs component combo42 value

setXfsComponentCombo51
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setXfsComponentCombo51(String xfsComponentCombo51)
   :outertype: Query

   Sets the xfs component combo51 value.

   :param xfsComponentCombo51: the new xfs component combo51 value

setXfsComponentCombo52
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setXfsComponentCombo52(String xfsComponentCombo52)
   :outertype: Query

   Sets the xfs component combo52 value.

   :param xfsComponentCombo52: the new xfs component combo52 value

setXfsComponentField1
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setXfsComponentField1(String xfsComponentField1)
   :outertype: Query

   Sets the xfs component field1 value.

   :param xfsComponentField1: the new xfs component field1 value

setXfsComponentField2
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setXfsComponentField2(String xfsComponentField2)
   :outertype: Query

   Sets the xfs component field2 value.

   :param xfsComponentField2: the new xfs component field2 value

setXfsComponentField3
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setXfsComponentField3(String xfsComponentField3)
   :outertype: Query

   Sets the xfs component field3 value.

   :param xfsComponentField3: the new xfs component field3 value

setXfsComponentField4
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setXfsComponentField4(String xfsComponentField4)
   :outertype: Query

   Sets the xfs component field4 value.

   :param xfsComponentField4: the new xfs component field4 value

setXfsComponentField5
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setXfsComponentField5(String xfsComponentField5)
   :outertype: Query

   Sets the xfs component field5 value.

   :param xfsComponentField5: the new xfs component field5 value

setXfsSwCB1
^^^^^^^^^^^

.. java:method:: public void setXfsSwCB1(Boolean xfsSwCB1)
   :outertype: Query

   ets the xfs sw checkbox1 value.

   :param xfsSwCB1: the xfsSwCB1 to set

setXfsSwCB2
^^^^^^^^^^^

.. java:method:: public void setXfsSwCB2(Boolean xfsSwCB2)
   :outertype: Query

   Sets the xfs sw checkbox2 value.

   :param xfsSwCB2: the xfsSwCB2 to set

setXfsSwCB3
^^^^^^^^^^^

.. java:method:: public void setXfsSwCB3(Boolean xfsSwCB3)
   :outertype: Query

   Sets the xfs sw checkbox3 value.

   :param xfsSwCB3: the xfsSwCB3 to set

setXfsSwCB4
^^^^^^^^^^^

.. java:method:: public void setXfsSwCB4(Boolean xfsSwCB4)
   :outertype: Query

   Sets the xfs sw checkbox4 value.

   :param xfsSwCB4: the xfsSwCB4 to set

setXfsSwCB5
^^^^^^^^^^^

.. java:method:: public void setXfsSwCB5(Boolean xfsSwCB5)
   :outertype: Query

   Sets the xfs sw checkbox5 value.

   :param xfsSwCB5: the xfsSwCB5 to set

setXfsSwCombo11
^^^^^^^^^^^^^^^

.. java:method:: public void setXfsSwCombo11(String xfsSwCombo11)
   :outertype: Query

   Sets the xfs sw combo11 value.

   :param xfsSwCombo11: the xfsSwCombo11 to set

setXfsSwCombo12
^^^^^^^^^^^^^^^

.. java:method:: public void setXfsSwCombo12(String xfsSwCombo12)
   :outertype: Query

   Sets the xfs sw combo12 value.

   :param xfsSwCombo12: the xfsSwCombo12 to set

setXfsSwCombo21
^^^^^^^^^^^^^^^

.. java:method:: public void setXfsSwCombo21(String xfsSwCombo21)
   :outertype: Query

   Sets the xfs sw combo21 value.

   :param xfsSwCombo21: the xfsSwCombo21 to set

setXfsSwCombo22
^^^^^^^^^^^^^^^

.. java:method:: public void setXfsSwCombo22(String xfsSwCombo22)
   :outertype: Query

   Sets the xfs sw combo22 value.

   :param xfsSwCombo22: the xfsSwCombo22 to set

setXfsSwCombo31
^^^^^^^^^^^^^^^

.. java:method:: public void setXfsSwCombo31(String xfsSwCombo31)
   :outertype: Query

   Sets the xfs sw combo31 value.

   :param xfsSwCombo31: the xfsSwCombo31 to set

setXfsSwCombo32
^^^^^^^^^^^^^^^

.. java:method:: public void setXfsSwCombo32(String xfsSwCombo32)
   :outertype: Query

   Sets the xfs sw combo32 value.

   :param xfsSwCombo32: the xfsSwCombo32 to set

setXfsSwCombo41
^^^^^^^^^^^^^^^

.. java:method:: public void setXfsSwCombo41(String xfsSwCombo41)
   :outertype: Query

   Sets the xfs sw combo41 value.

   :param xfsSwCombo41: the xfsSwCombo41 to set

setXfsSwCombo42
^^^^^^^^^^^^^^^

.. java:method:: public void setXfsSwCombo42(String xfsSwCombo42)
   :outertype: Query

   Sets the xfs sw combo42 value.

   :param xfsSwCombo42: the xfsSwCombo42 to set

setXfsSwCombo51
^^^^^^^^^^^^^^^

.. java:method:: public void setXfsSwCombo51(String xfsSwCombo51)
   :outertype: Query

   Sets the xfs sw combo51 value.

   :param xfsSwCombo51: the xfsSwCombo51 to set

setXfsSwCombo52
^^^^^^^^^^^^^^^

.. java:method:: public void setXfsSwCombo52(String xfsSwCombo52)
   :outertype: Query

   Sets the xfs sw combo52 value.

   :param xfsSwCombo52: the xfsSwCombo52 to set

setXfsSwField1
^^^^^^^^^^^^^^

.. java:method:: public void setXfsSwField1(String xfsSwField1)
   :outertype: Query

   Sets the xfs sw field1 value.

   :param xfsSwField1: the xfsSwField1 to set

setXfsSwField2
^^^^^^^^^^^^^^

.. java:method:: public void setXfsSwField2(String xfsSwField2)
   :outertype: Query

   Sets the xfs sw field2 value.

   :param xfsSwField2: the xfsSwField2 to set

setXfsSwField3
^^^^^^^^^^^^^^

.. java:method:: public void setXfsSwField3(String xfsSwField3)
   :outertype: Query

   Sets the xfs sw field3 value.

   :param xfsSwField3: the xfsSwField3 to set

setXfsSwField4
^^^^^^^^^^^^^^

.. java:method:: public void setXfsSwField4(String xfsSwField4)
   :outertype: Query

   Sets the xfs sw field4 value.

   :param xfsSwField4: the xfsSwField4 to set

setXfsSwField5
^^^^^^^^^^^^^^

.. java:method:: public void setXfsSwField5(String xfsSwField5)
   :outertype: Query

   Sets the xfs sw field5 value.

   :param xfsSwField5: the xfsSwField5 to set

