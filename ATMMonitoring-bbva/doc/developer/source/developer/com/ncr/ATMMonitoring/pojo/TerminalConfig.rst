.. java:import:: java.util HashSet

.. java:import:: java.util Set

.. java:import:: javax.persistence Column

.. java:import:: javax.persistence Entity

.. java:import:: javax.persistence FetchType

.. java:import:: javax.persistence GeneratedValue

.. java:import:: javax.persistence GenerationType

.. java:import:: javax.persistence Id

.. java:import:: javax.persistence JoinColumn

.. java:import:: javax.persistence JoinTable

.. java:import:: javax.persistence ManyToMany

.. java:import:: javax.persistence ManyToOne

.. java:import:: javax.persistence OrderBy

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

.. java:import:: javax.persistence UniqueConstraint

.. java:import:: org.hibernate.annotations Cascade

.. java:import:: org.hibernate.annotations CascadeType

TerminalConfig
==============

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class TerminalConfig extends Auditable

   The TerminalConfig Pojo.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
equals
^^^^^^

.. java:method:: @Override public boolean equals(Object o)
   :outertype: TerminalConfig

getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: TerminalConfig

   Gets the id.

   :return: the id

getOperatingSystems
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<OperatingSystem> getOperatingSystems()
   :outertype: TerminalConfig

   Gets the operating systems.

   :return: the operatingSystems

getSoftware
^^^^^^^^^^^

.. java:method:: public Set<Software> getSoftware()
   :outertype: TerminalConfig

   Gets the software.

   :return: the software

getTerminal
^^^^^^^^^^^

.. java:method:: public Terminal getTerminal()
   :outertype: TerminalConfig

   Gets the terminal.

   :return: the terminal

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: TerminalConfig

   Sets the id.

   :param id: the id to set

setOperatingSystems
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setOperatingSystems(Set<OperatingSystem> operatingSystems)
   :outertype: TerminalConfig

   Sets the operating systems.

   :param operatingSystems: the operatingSystems to set

setSoftware
^^^^^^^^^^^

.. java:method:: public void setSoftware(Set<Software> software)
   :outertype: TerminalConfig

   Sets the software.

   :param software: the software to set

setTerminal
^^^^^^^^^^^

.. java:method:: public void setTerminal(Terminal terminal)
   :outertype: TerminalConfig

   Sets the terminal.

   :param terminal: the terminal to set

