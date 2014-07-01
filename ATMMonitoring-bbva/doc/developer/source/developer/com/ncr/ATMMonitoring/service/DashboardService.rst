.. java:import:: com.ncr ATMMonitoring.pojo.Dashboard

.. java:import:: com.ncr ATMMonitoring.pojo.User

DashboardService
================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface DashboardService

   The Interface DashboardService. It contains the dashboard related methods.

   :author: Rafael Luque (rafael.luque@osoco.es)

Methods
-------
createDefaultDashboardForUser
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Dashboard createDefaultDashboardForUser(User user)
   :outertype: DashboardService

   Creates the default dashboard for user.

   :param user: the user
   :return: the dashboard

findDashboardByUser
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Dashboard findDashboardByUser(User user)
   :outertype: DashboardService

   Find dashboard by user.

   :param user: the user
   :return: the dashboard

findOrCreateDashboardByUser
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Dashboard findOrCreateDashboardByUser(User user)
   :outertype: DashboardService

   Find or create dashboard by user.

   :param user: the user
   :return: the dashboard

saveDashboard
^^^^^^^^^^^^^

.. java:method:: public void saveDashboard(Dashboard dashboard)
   :outertype: DashboardService

   Save dashboard.

   :param dashboard: the dashboard

