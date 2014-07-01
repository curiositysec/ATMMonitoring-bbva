.. java:import:: java.util Date

.. java:import:: javax.persistence Column

.. java:import:: javax.persistence MappedSuperclass

Auditable
=========

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @MappedSuperclass public abstract class Auditable

   Domain class for auditable elements related actions

   :author: jmartin

Fields
------
dateCreated
^^^^^^^^^^^

.. java:field:: @Column protected Date dateCreated
   :outertype: Auditable

   The date created

endDate
^^^^^^^

.. java:field:: @Column protected Date endDate
   :outertype: Auditable

   The end date

startDate
^^^^^^^^^

.. java:field:: @Column protected Date startDate
   :outertype: Auditable

   The start date

Methods
-------
exists
^^^^^^

.. java:method:: public boolean exists(Date searchDate)
   :outertype: Auditable

   Indicate if an auditable element exists by date

   :param searchDate: The search date
   :return: True if auditable element exists at the search date. False otherwhise.

getDateCreated
^^^^^^^^^^^^^^

.. java:method:: public Date getDateCreated()
   :outertype: Auditable

   Get the date created

   :return: The date created

getDefaultDate
^^^^^^^^^^^^^^

.. java:method:: public static Date getDefaultDate()
   :outertype: Auditable

   Get the default date

   :return: The default date

getEndDate
^^^^^^^^^^

.. java:method:: public Date getEndDate()
   :outertype: Auditable

   Get the end date

   :return: The end date

getStartDate
^^^^^^^^^^^^

.. java:method:: public Date getStartDate()
   :outertype: Auditable

   Get the start date

   :return: The start date

isActive
^^^^^^^^

.. java:method:: public boolean isActive(Date searchDate)
   :outertype: Auditable

   Indicate if an auditable element is active by date

   :param searchDate: The search date
   :return: True if auditable element is active at the search date. False otherwhise.

setDateCreated
^^^^^^^^^^^^^^

.. java:method:: public void setDateCreated(Date dateCreated)
   :outertype: Auditable

   Set the date created

   :param dateCreated: The date created

setEndDate
^^^^^^^^^^

.. java:method:: public void setEndDate(Date endDate)
   :outertype: Auditable

   Set the end date

   :param endDate: The end date

setStartDate
^^^^^^^^^^^^

.. java:method:: public void setStartDate(Date startDate)
   :outertype: Auditable

   Set the start date

   :param startDate: The start date

