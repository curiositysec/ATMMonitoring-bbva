.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.Software

SoftwareDAO
===========

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface SoftwareDAO

   The Interface SoftwareDAO. Dao with the operations for managing Software Pojos.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addSoftware
^^^^^^^^^^^

.. java:method:: public void addSoftware(Software software)
   :outertype: SoftwareDAO

   Adds the software.

   :param software: the software

getSoftware
^^^^^^^^^^^

.. java:method:: public Software getSoftware(Integer id)
   :outertype: SoftwareDAO

   Gets the software with the given id.

   :param id: the id
   :return: the software, or null if it doesn't exist

getSoftwareByIdentifyingNumber
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Software getSoftwareByIdentifyingNumber(String id)
   :outertype: SoftwareDAO

   Gets the software by identifying number.

   :param id: the id
   :return: the software by identifying number, or null if it doesn't exist

listSoftware
^^^^^^^^^^^^

.. java:method:: public List<Software> listSoftware()
   :outertype: SoftwareDAO

   Lists all software.

   :return: the list

