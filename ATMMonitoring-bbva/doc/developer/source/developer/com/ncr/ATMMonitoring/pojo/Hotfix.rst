.. java:import:: java.text ParseException

.. java:import:: java.text SimpleDateFormat

.. java:import:: java.util Map

.. java:import:: java.util TreeMap

.. java:import:: javax.persistence Column

.. java:import:: javax.persistence Entity

.. java:import:: javax.persistence FetchType

.. java:import:: javax.persistence GeneratedValue

.. java:import:: javax.persistence GenerationType

.. java:import:: javax.persistence Id

.. java:import:: javax.persistence JoinColumn

.. java:import:: javax.persistence ManyToOne

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate.annotations Cascade

.. java:import:: org.hibernate.annotations CascadeType

.. java:import:: org.hibernate.annotations Type

.. java:import:: com.ncr ATMMonitoring.utils.Operation

.. java:import:: com.ncr.agent.baseData.os.module HotfixPojo

Hotfix
======

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class Hotfix extends Auditable

   The Hotfix Pojo.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Constructors
------------
Hotfix
^^^^^^

.. java:constructor:: public Hotfix()
   :outertype: Hotfix

   Instantiates a new hotfix.

Hotfix
^^^^^^

.. java:constructor:: public Hotfix(HotfixPojo hotfix)
   :outertype: Hotfix

   Instantiates a new hotfix with the given hotfix data from the agent.

   :param hotfix: the hotfix

Methods
-------
equals
^^^^^^

.. java:method:: @Override public boolean equals(Object obj)
   :outertype: Hotfix

getComboboxes
^^^^^^^^^^^^^

.. java:method:: public static Map<String, Map> getComboboxes()
   :outertype: Hotfix

   Gets the comboboxes data for the query GUI.

   :return: the comboboxes data

getDescription
^^^^^^^^^^^^^^

.. java:method:: public String getDescription()
   :outertype: Hotfix

   Gets the description.

   :return: the description

getFixComments
^^^^^^^^^^^^^^

.. java:method:: public String getFixComments()
   :outertype: Hotfix

   Gets the fix comments.

   :return: the fixComments

getHotfixId
^^^^^^^^^^^

.. java:method:: public String getHotfixId()
   :outertype: Hotfix

   Gets the hotfix id.

   :return: the hotfixId

getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: Hotfix

   Gets the id.

   :return: the id

getNumber
^^^^^^^^^

.. java:method:: public Integer getNumber()
   :outertype: Hotfix

   Gets the number.

   :return: the number

getTerminal
^^^^^^^^^^^

.. java:method:: public Terminal getTerminal()
   :outertype: Hotfix

   Gets the terminal.

   :return: the terminal

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: Hotfix

setDescription
^^^^^^^^^^^^^^

.. java:method:: public void setDescription(String description)
   :outertype: Hotfix

   Sets the description.

   :param description: the description to set

setFixComments
^^^^^^^^^^^^^^

.. java:method:: public void setFixComments(String fixComments)
   :outertype: Hotfix

   Sets the fix comments.

   :param fixComments: the fixComments to set

setHotfixId
^^^^^^^^^^^

.. java:method:: public void setHotfixId(String hotfixId)
   :outertype: Hotfix

   Sets the hotfix id.

   :param hotfixId: the hotfixId to set

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: Hotfix

   Sets the id.

   :param id: the id to set

setNumber
^^^^^^^^^

.. java:method:: public void setNumber(Integer number)
   :outertype: Hotfix

   Sets the number.

   :param number: the number to set

setTerminal
^^^^^^^^^^^

.. java:method:: public void setTerminal(Terminal terminal)
   :outertype: Hotfix

   Sets the terminal.

   :param terminal: the terminal to set

