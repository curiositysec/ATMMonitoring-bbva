.. java:import:: java.util Calendar

.. java:import:: java.util Date

.. java:import:: java.util List

.. java:import:: java.util TimeZone

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate Criteria

.. java:import:: org.hibernate.criterion Order

.. java:import:: org.hibernate.criterion Restrictions

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.ScheduledUpdate

ScheduledUpdateDAOImpl
======================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class ScheduledUpdateDAOImpl extends AbstractGenericDAO<ScheduledUpdate> implements ScheduledUpdateDAO

   The Class ScheduledUpdateDAOImpl. Default implementation of ScheduledUpdateDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addScheduledUpdate
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addScheduledUpdate(ScheduledUpdate scheduledUpdate)
   :outertype: ScheduledUpdateDAOImpl

existsMonthlyScheduledUpdate
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean existsMonthlyScheduledUpdate(ScheduledUpdate scheduledUpdate)
   :outertype: ScheduledUpdateDAOImpl

existsWeeklyScheduledUpdate
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean existsWeeklyScheduledUpdate(ScheduledUpdate scheduledUpdate)
   :outertype: ScheduledUpdateDAOImpl

getScheduledUpdate
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public ScheduledUpdate getScheduledUpdate(Integer id)
   :outertype: ScheduledUpdateDAOImpl

listMonthlyScheduledUpdates
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<ScheduledUpdate> listMonthlyScheduledUpdates()
   :outertype: ScheduledUpdateDAOImpl

listValidScheduledUpdates
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<ScheduledUpdate> listValidScheduledUpdates(Calendar date)
   :outertype: ScheduledUpdateDAOImpl

listWeeklyScheduledUpdates
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<ScheduledUpdate> listWeeklyScheduledUpdates()
   :outertype: ScheduledUpdateDAOImpl

removeScheduledUpdate
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void removeScheduledUpdate(Integer id)
   :outertype: ScheduledUpdateDAOImpl

