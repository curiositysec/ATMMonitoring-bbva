.. java:import:: java.text DateFormat

.. java:import:: java.util Calendar

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Set

.. java:import:: org.apache.log4j Logger

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.dao.ScheduledUpdateDAO

.. java:import:: com.ncr ATMMonitoring.pojo.ScheduledUpdate

.. java:import:: com.ncr ATMMonitoring.pojo.Terminal

.. java:import:: com.ncr ATMMonitoring.socket.SocketService

ScheduledUpdateServiceImpl
==========================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class ScheduledUpdateServiceImpl implements ScheduledUpdateService

   The Class ScheduledUpdateServiceImpl. Default implementation of the ScheduledUpdateService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addScheduledUpdate
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addScheduledUpdate(ScheduledUpdate scheduledUpdate)
   :outertype: ScheduledUpdateServiceImpl

checkCurrentUpdates
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void checkCurrentUpdates()
   :outertype: ScheduledUpdateServiceImpl

existsScheduledUpdate
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean existsScheduledUpdate(ScheduledUpdate scheduledUpdate)
   :outertype: ScheduledUpdateServiceImpl

listMonthlyScheduledUpdates
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<ScheduledUpdate> listMonthlyScheduledUpdates()
   :outertype: ScheduledUpdateServiceImpl

listWeeklyScheduledUpdates
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<ScheduledUpdate> listWeeklyScheduledUpdates()
   :outertype: ScheduledUpdateServiceImpl

removeScheduledUpdate
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void removeScheduledUpdate(Integer id)
   :outertype: ScheduledUpdateServiceImpl

