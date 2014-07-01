.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.dao.DashboardDAO

.. java:import:: com.ncr ATMMonitoring.pojo.Dashboard

.. java:import:: com.ncr ATMMonitoring.pojo.User

DashboardServiceImpl
====================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class DashboardServiceImpl implements DashboardService

   The Class DashboardServiceImpl. Default implementation of the DashboardService.

   :author: Rafael Luque (rafael.luque@osoco.es)

Methods
-------
createDefaultDashboardForUser
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Dashboard createDefaultDashboardForUser(User user)
   :outertype: DashboardServiceImpl

findDashboardByUser
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Dashboard findDashboardByUser(User user)
   :outertype: DashboardServiceImpl

findOrCreateDashboardByUser
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Dashboard findOrCreateDashboardByUser(User user)
   :outertype: DashboardServiceImpl

saveDashboard
^^^^^^^^^^^^^

.. java:method:: @Override public void saveDashboard(Dashboard dashboard)
   :outertype: DashboardServiceImpl

