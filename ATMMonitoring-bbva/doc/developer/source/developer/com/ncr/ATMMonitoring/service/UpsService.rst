.. java:import:: java.io InputStream

.. java:import:: java.util Collection

.. java:import:: java.util List

UpsService
==========

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface UpsService

   The Interface UpsService. It contains the UPS related methods.

   :author: Otto Abreu

Methods
-------
deleteUPS
^^^^^^^^^

.. java:method:: public void deleteUPS(int id)
   :outertype: UpsService

   Deletes the information related to an UPS

   :param id: the id of the UPS we want to delete

storeUPSinfo
^^^^^^^^^^^^

.. java:method:: public List<String> storeUPSinfo(List<String> xmlFiles)
   :outertype: UpsService

   Generates the XML files, extracts the information and stores it in the database. It will return the list of not processed (parsed) files, empty if all were processed

   :param xmlFiles: List with valid file paths
   :return: List with the not processed files

storeUPSinfo
^^^^^^^^^^^^

.. java:method:: public boolean storeUPSinfo(InputStream xmlFile)
   :outertype: UpsService

   Generates the XML file, extracts the information and stores it in the database. Return true if the file was processed by the parser

   :param xmlFile: InputStream with a valid XML file
   :return: true if the file was parsed, false otherwise

storeUPSinfo
^^^^^^^^^^^^

.. java:method:: public List<InputStream> storeUPSinfo(Collection<InputStream> xmlFiles)
   :outertype: UpsService

   Generates the XML files, extracts the information and stores it in the database. It will return the List of not processed (parsed) files, empty if all were processed.

   :param xmlFiles: Collection with valid inputstreams
   :return: List with the not processed files

storeUPSinfo
^^^^^^^^^^^^

.. java:method:: public boolean storeUPSinfo(String xmlFile)
   :outertype: UpsService

   Generates the XML files, extract the information and store it in the database. Returns true if the file was processed by the parser

   :param xmlFiles: String with a valid file path
   :return: true if the file was parsed, false otherwise

