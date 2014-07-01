.. java:import:: java.util List

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.dao.LocationDAO

.. java:import:: com.ncr ATMMonitoring.pojo.Location

LocationServiceImpl
===================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class LocationServiceImpl implements LocationService

   The Class LocationServiceImpl. Default implementation of the LocationService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addLocation
^^^^^^^^^^^

.. java:method:: @Override public void addLocation(Location role)
   :outertype: LocationServiceImpl

getLocation
^^^^^^^^^^^

.. java:method:: @Override public Location getLocation(Integer id)
   :outertype: LocationServiceImpl

listLocations
^^^^^^^^^^^^^

.. java:method:: @Override public List<Location> listLocations()
   :outertype: LocationServiceImpl

removeLocation
^^^^^^^^^^^^^^

.. java:method:: @Override public void removeLocation(Integer id)
   :outertype: LocationServiceImpl

updateLocation
^^^^^^^^^^^^^^

.. java:method:: @Override public void updateLocation(Location location)
   :outertype: LocationServiceImpl

