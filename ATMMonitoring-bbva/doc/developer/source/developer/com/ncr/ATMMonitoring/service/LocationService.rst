.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.Location

LocationService
===============

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface LocationService

   The Interface LocationService. It contains the location related methods.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addLocation
^^^^^^^^^^^

.. java:method:: public void addLocation(Location location)
   :outertype: LocationService

   Adds the location.

   :param location: the location

getLocation
^^^^^^^^^^^

.. java:method:: public Location getLocation(Integer id)
   :outertype: LocationService

   Gets the location by its id.

   :param id: the location id
   :return: the location

listLocations
^^^^^^^^^^^^^

.. java:method:: public List<Location> listLocations()
   :outertype: LocationService

   List locations.

   :return: the location list

removeLocation
^^^^^^^^^^^^^^

.. java:method:: public void removeLocation(Integer id)
   :outertype: LocationService

   Removes the location by its id.

   :param id: the location id

updateLocation
^^^^^^^^^^^^^^

.. java:method:: public void updateLocation(Location location)
   :outertype: LocationService

   Update location.

   :param location: the location

