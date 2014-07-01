.. java:import:: java.util ArrayList

.. java:import:: java.util Collection

.. java:import:: java.util List

.. java:import:: javax.annotation PostConstruct

.. java:import:: org.apache.commons.collections CollectionUtils

.. java:import:: org.apache.commons.io.filefilter IOFileFilter

.. java:import:: org.apache.commons.lang StringUtils

.. java:import:: org.apache.log4j Logger

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.beans.factory.annotation Value

.. java:import:: org.springframework.scheduling.annotation Scheduled

.. java:import:: org.springframework.stereotype Component

.. java:import:: com.ncr ATMMonitoring.handler.FileInDiskHandler

.. java:import:: com.ncr ATMMonitoring.handler.exception.FileHandlerException

.. java:import:: com.ncr ATMMonitoring.service.UpsService

UPSGetXMLTask
=============

.. java:package:: com.ncr.ATMMonitoring.scheduledtask
   :noindex:

.. java:type:: @Component public class UPSGetXMLTask

   Scheduled task that reads XML files with UPS data from the file system and processes them. To know which files it must read and what to do with them, this class uses the following properties:

   ..

   * \ **config.upsfolder**\ : Required, holds the system path where the xml are
   * \ *config.upstask.behavior*\
   * \ *config.upstask.copyto*\

   This class uses \ :java:ref:`IOFileFilter`\  and FileUtils

   :author: Otto Abreu

Methods
-------
checkForUPSUpdates
^^^^^^^^^^^^^^^^^^

.. java:method:: @Scheduled public void checkForUPSUpdates()
   :outertype: UPSGetXMLTask

   Scheduled task that checks the folder for XML, and calls the service to begin the XML processing

initTask
^^^^^^^^

.. java:method:: @PostConstruct public void initTask()
   :outertype: UPSGetXMLTask

   Method that create the folder in the object instance

