.. java:import:: java.util Date

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: com.ncr ATMMonitoring.pojo.Auditable

AuditableSetOperations
======================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface AuditableSetOperations

   The auditable set operations interface It contains the auditable set operations related actions

   :author: Julián Martín

Methods
-------
buildAuditableChangesForCollection
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Map<Date, Integer> buildAuditableChangesForCollection(Set<? extends Auditable> auditableElements)
   :outertype: AuditableSetOperations

   Build the auditable changes map for a collection

   :param auditableElements: The collection of auditable elements
   :return: The auditable changes map

getActiveAuditableElementsByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public <T extends Auditable> Set<T> getActiveAuditableElementsByDate(Set<T> auditableElements, Date date)
   :outertype: AuditableSetOperations

   Get the active auditable elements by date

   :param auditableElements: The collecton of auditable elements
   :param date: The date
   :return: The collection of auditable elements active by date

getCreatedAuditableElementsByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public <T extends Auditable> Set<T> getCreatedAuditableElementsByDate(Set<T> auditableElements, Date date)
   :outertype: AuditableSetOperations

   Get the created auditable elementes by date

   :param auditableElements: The auditable elements
   :param date: The date
   :return: The collection of auditable elements

getCurrentAuditable
^^^^^^^^^^^^^^^^^^^

.. java:method:: public <T extends Auditable> T getCurrentAuditable(Set<T> auditableElements)
   :outertype: AuditableSetOperations

   Get the current auditable element

   :param auditableElements: The auditable elements collection
   :return: The current auditable element

getCurrentAuditableElementByDate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public <T extends Auditable> T getCurrentAuditableElementByDate(Set<T> auditableElements, Date date)
   :outertype: AuditableSetOperations

   Get the current auditable element by date

   :param auditableElements: The auditable elements collection
   :param date: The date
   :return: The current auditable element by date

setCurrentAuditableElement
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public <T extends Auditable> void setCurrentAuditableElement(Set<T> auditableElements, T newauditableElement)
   :outertype: AuditableSetOperations

   Set the current auditable element

   :param auditableElements: The collection of auditable elements
   :param newauditableElement: The new auditableElement

updateAuditableElements
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public <T extends Auditable> void updateAuditableElements(Set<T> auditableElements, Set<T> newAuditableElements)
   :outertype: AuditableSetOperations

   Updates a collection of auditable elements. Adds new elements to first collection and set end date to elements that are not present on second collection.

   :param auditableElements: The current collection of auditable elements
   :param newAuditableElements: The new collection of auditables elements

