.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.SoftwareAggregate

SoftwareAggregateService
========================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface SoftwareAggregateService

   The Interface SoftwareAggregateService. It contains the software aggregate related methods.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addSoftwareAggregate
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addSoftwareAggregate(SoftwareAggregate softwareAggregate)
   :outertype: SoftwareAggregateService

   Adds the software aggregate.

   :param softwareAggregate: the software aggregate

getSoftwareAggregate
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public SoftwareAggregate getSoftwareAggregate(Integer id)
   :outertype: SoftwareAggregateService

   Gets the software aggregate.

   :param id: the software aggregate id
   :return: the software aggregate

getSoftwareAggregateByVersionName
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public SoftwareAggregate getSoftwareAggregateByVersionName(Integer majorVersion, Integer minorVersion, Integer buildVersion, Integer revisionVersion, String remainingVersion, String name)
   :outertype: SoftwareAggregateService

   Gets the software aggregate by version name.

   :param majorVersion: the major version
   :param minorVersion: the minor version
   :param buildVersion: the build version
   :param revisionVersion: the revision version
   :param remainingVersion: the remaining version
   :param name: the name
   :return: the software aggregate by version name

listSoftwareAggregate
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<SoftwareAggregate> listSoftwareAggregate()
   :outertype: SoftwareAggregateService

   List software aggregate.

   :return: the software aggregate list

removeSoftwareAggregate
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void removeSoftwareAggregate(Integer id)
   :outertype: SoftwareAggregateService

   Removes the software aggregate by its id.

   :param id: the software aggregate id

