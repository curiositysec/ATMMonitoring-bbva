.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.Location

LocationDAO
===========

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface LocationDAO

   The Interface LocationDAO. Dao with the operations for managing Location Pojos.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addLocation
^^^^^^^^^^^

.. java:method:: public void addLocation(Location location)
   :outertype: LocationDAO

   Adds the location.

   :param location: the location

getLocation
^^^^^^^^^^^

.. java:method:: public Location getLocation(Integer id)
   :outertype: LocationDAO

   Gets the location with the given id.

   :param id: the id
   :return: the location, or null if it doesn't exist

listLocations
^^^^^^^^^^^^^

.. java:method:: public List<Location> listLocations()
   :outertype: LocationDAO

   Lists all locations.

   :return: the list

removeLocation
^^^^^^^^^^^^^^

.. java:method:: public void removeLocation(Integer id)
   :outertype: LocationDAO

   Removes the location with the given id.

   :param id: the id

updateLocation
^^^^^^^^^^^^^^

.. java:method:: public void updateLocation(Location location)
   :outertype: LocationDAO

   Updates location.

   :param location: the location

