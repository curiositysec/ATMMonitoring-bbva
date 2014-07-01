.. java:import:: java.util Calendar

.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.ScheduledUpdate

ScheduledUpdateDAO
==================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface ScheduledUpdateDAO

   The Interface ScheduledUpdateDAO. Dao with the operations for managing ScheduledUpdate Pojos.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addScheduledUpdate
^^^^^^^^^^^^^^^^^^

.. java:method:: public void addScheduledUpdate(ScheduledUpdate scheduledUpdate)
   :outertype: ScheduledUpdateDAO

   Adds the scheduled update.

   :param scheduledUpdate: the scheduled update

existsMonthlyScheduledUpdate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean existsMonthlyScheduledUpdate(ScheduledUpdate scheduledUpdate)
   :outertype: ScheduledUpdateDAO

   Checks whether a monthly scheduled update already exists.

   :param scheduledUpdate: the scheduled update
   :return: true if it does exist

existsWeeklyScheduledUpdate
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean existsWeeklyScheduledUpdate(ScheduledUpdate scheduledUpdate)
   :outertype: ScheduledUpdateDAO

   Checks whether a weekly scheduled update already exists.

   :param scheduledUpdate: the scheduled update
   :return: true if it does exist

getScheduledUpdate
^^^^^^^^^^^^^^^^^^

.. java:method:: public ScheduledUpdate getScheduledUpdate(Integer id)
   :outertype: ScheduledUpdateDAO

   Gets the scheduled update with the given id.

   :param id: the id
   :return: the scheduled update, or null if it doesn't exist

listMonthlyScheduledUpdates
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<ScheduledUpdate> listMonthlyScheduledUpdates()
   :outertype: ScheduledUpdateDAO

   Lists all monthly scheduled updates.

   :return: the list

listValidScheduledUpdates
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<ScheduledUpdate> listValidScheduledUpdates(Calendar date)
   :outertype: ScheduledUpdateDAO

   Lists all valid scheduled updates.

   :param date: the date
   :return: the list

listWeeklyScheduledUpdates
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<ScheduledUpdate> listWeeklyScheduledUpdates()
   :outertype: ScheduledUpdateDAO

   Lists all weekly scheduled updates.

   :return: the list

removeScheduledUpdate
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void removeScheduledUpdate(Integer id)
   :outertype: ScheduledUpdateDAO

   Removes the scheduled update with the given id.

   :param id: the id

