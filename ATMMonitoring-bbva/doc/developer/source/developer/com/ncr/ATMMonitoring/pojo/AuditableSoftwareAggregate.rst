.. java:import:: javax.persistence Column

.. java:import:: javax.persistence Entity

.. java:import:: javax.persistence GeneratedValue

.. java:import:: javax.persistence GenerationType

.. java:import:: javax.persistence Id

.. java:import:: javax.persistence JoinColumn

.. java:import:: javax.persistence ManyToOne

.. java:import:: javax.persistence PrimaryKeyJoinColumn

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: org.hibernate.annotations Cascade

.. java:import:: org.hibernate.annotations CascadeType

AuditableSoftwareAggregate
==========================

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity public class AuditableSoftwareAggregate extends Auditable

   The Auditable Sofware aggregate

   :author: jmartin

Constructors
------------
AuditableSoftwareAggregate
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public AuditableSoftwareAggregate()
   :outertype: AuditableSoftwareAggregate

   Default constructor

AuditableSoftwareAggregate
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public AuditableSoftwareAggregate(SoftwareAggregate softwareAggregate)
   :outertype: AuditableSoftwareAggregate

   Constructor

   :param internetExplorer: The internet explorer

Methods
-------
equals
^^^^^^

.. java:method:: @Override public boolean equals(Object obj)
   :outertype: AuditableSoftwareAggregate

getSoftwareAggregate
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public SoftwareAggregate getSoftwareAggregate()
   :outertype: AuditableSoftwareAggregate

   Gets the software aggregate

   :return: The software aggregate

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: AuditableSoftwareAggregate

setSoftwareAggregate
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSoftwareAggregate(SoftwareAggregate softwareAggregate)
   :outertype: AuditableSoftwareAggregate

   Sets the software aggregate

   :param softwareAggregate: The software aggregate

