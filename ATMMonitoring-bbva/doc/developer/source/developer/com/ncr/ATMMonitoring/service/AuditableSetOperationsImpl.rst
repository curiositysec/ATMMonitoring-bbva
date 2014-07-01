.. java:import:: java.util Arrays

.. java:import:: java.util Date

.. java:import:: java.util HashMap

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: com.ncr ATMMonitoring.pojo.Auditable

AuditableSetOperationsImpl
==========================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public class AuditableSetOperationsImpl implements AuditableSetOperations

Methods
-------
buildAuditableChangesForCollection
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Map<Date, Integer> buildAuditableChangesForCollection(Set<? extends Auditable> auditableElements)
   :outertype: AuditableSetOperationsImpl

getActiveAuditableElementsByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public <T extends Auditable> Set<T> getActiveAuditableElementsByDate(Set<T> auditableElements, Date date)
   :outertype: AuditableSetOperationsImpl

getCreatedAuditableElementsByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public <T extends Auditable> Set<T> getCreatedAuditableElementsByDate(Set<T> auditableElements, Date date)
   :outertype: AuditableSetOperationsImpl

getCurrentAuditable
^^^^^^^^^^^^^^^^^^^

.. java:method:: public <T extends Auditable> T getCurrentAuditable(Set<T> auditableElements)
   :outertype: AuditableSetOperationsImpl

getCurrentAuditableElementByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public <T extends Auditable> T getCurrentAuditableElementByDate(Set<T> auditableElements, Date date)
   :outertype: AuditableSetOperationsImpl

setCurrentAuditableElement
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public <T extends Auditable> void setCurrentAuditableElement(Set<T> auditableElements, T newAuditableElement)
   :outertype: AuditableSetOperationsImpl

updateAuditableElements
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public <T extends Auditable> void updateAuditableElements(Set<T> auditableElements, Set<T> newAuditableElements)
   :outertype: AuditableSetOperationsImpl

