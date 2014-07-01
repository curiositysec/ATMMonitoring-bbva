.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.OperatingSystem

OperatingSystemDAO
==================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface OperatingSystemDAO

   The Interface OperatingSystemDAO. Dao with the operations for managing OperatingSystem Pojos.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addOperatingSystem
^^^^^^^^^^^^^^^^^^

.. java:method:: public void addOperatingSystem(OperatingSystem operatingSystem)
   :outertype: OperatingSystemDAO

   Adds the operating system.

   :param operatingSystem: the operating system

getOperatingSystem
^^^^^^^^^^^^^^^^^^

.. java:method:: public OperatingSystem getOperatingSystem(Integer id)
   :outertype: OperatingSystemDAO

   Gets the operating system with the given id.

   :param id: the id
   :return: the operating system, or null if it doesn't exist

listOperatingSystem
^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<OperatingSystem> listOperatingSystem()
   :outertype: OperatingSystemDAO

   Lists all operating systems.

   :return: the list

