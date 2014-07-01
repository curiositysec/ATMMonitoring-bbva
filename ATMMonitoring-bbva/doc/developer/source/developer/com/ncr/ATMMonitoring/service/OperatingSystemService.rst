.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.OperatingSystem

OperatingSystemService
======================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface OperatingSystemService

   The Interface OperatingSystemService. It contains the operating system related methods.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addOperatingSystem
^^^^^^^^^^^^^^^^^^

.. java:method:: public void addOperatingSystem(OperatingSystem operatingSystem)
   :outertype: OperatingSystemService

   Adds the operating system.

   :param operatingSystem: the operating system

getOperatingSystem
^^^^^^^^^^^^^^^^^^

.. java:method:: public OperatingSystem getOperatingSystem(Integer id)
   :outertype: OperatingSystemService

   Gets the operating system by its id.

   :param id: the operating system id
   :return: the operating system

listOperatingSystem
^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<OperatingSystem> listOperatingSystem()
   :outertype: OperatingSystemService

   List operating system.

   :return: the operating system list

