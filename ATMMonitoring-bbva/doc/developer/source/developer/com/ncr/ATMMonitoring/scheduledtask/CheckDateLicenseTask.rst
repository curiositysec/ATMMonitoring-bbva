.. java:import:: org.apache.log4j Logger

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.scheduling.annotation Scheduled

.. java:import:: org.springframework.stereotype Component

.. java:import:: com.ncr ATMMonitoring.service.TerminalService

CheckDateLicenseTask
====================

.. java:package:: com.ncr.ATMMonitoring.scheduledtask
   :noindex:

.. java:type:: @Component public class CheckDateLicenseTask

   Class that periodically checks the date-limited license

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
processIps
^^^^^^^^^^

.. java:method:: @Scheduled public void processIps()
   :outertype: CheckDateLicenseTask

   Method that calls the service in order to check the date-limited license

