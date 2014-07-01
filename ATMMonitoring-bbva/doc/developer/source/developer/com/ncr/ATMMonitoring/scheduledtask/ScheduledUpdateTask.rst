.. java:import:: org.apache.log4j Logger

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.scheduling.annotation Scheduled

.. java:import:: org.springframework.stereotype Component

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.service.ScheduledUpdateService

ScheduledUpdateTask
===================

.. java:package:: com.ncr.ATMMonitoring.scheduledtask
   :noindex:

.. java:type:: @Component public class ScheduledUpdateTask

   Class that periodically checks if there are any Scheduled updates to execute

   :author: Otto Abreu

Methods
-------
callToCheckCurrentUpdates
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Scheduled @Transactional public void callToCheckCurrentUpdates()
   :outertype: ScheduledUpdateTask

   Method that checks if there are any Scheduled updates to execute, and in that case runs them

