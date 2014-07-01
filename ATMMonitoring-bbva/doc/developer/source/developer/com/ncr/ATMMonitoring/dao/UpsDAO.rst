.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.Ups

UpsDAO
======

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface UpsDAO

   The Interface UpsDAO. Dao with the operations for managing Ups Pojos.

   :author: Otto Abreu

Methods
-------
addUps
^^^^^^

.. java:method:: public void addUps(Ups ups)
   :outertype: UpsDAO

   Adds a new Ups to the database

   :param ups: the UPS to add

getUps
^^^^^^

.. java:method:: public Ups getUps(int id)
   :outertype: UpsDAO

   Returns the UPS that matches the given id

   :param id: the id of the UPS we want to retrieve

getUpsBySerialNumber
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Ups getUpsBySerialNumber(String seriesNumber)
   :outertype: UpsDAO

   Returns a Ups by the given series number

   :param seriesNumber: the series number to search for
   :return: the UPS that matches the given parameters, or null if it can't be found

getUpsBySerialNumberAndModel
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Ups getUpsBySerialNumberAndModel(String seriesNumber, String model)
   :outertype: UpsDAO

   Returns a Ups by the given series number and model

   :param seriesNumber: the series number to search for
   :param model: the model to search for
   :return: the UPS that matches the given parameters, or null if it can't be found

listAllUps
^^^^^^^^^^

.. java:method:: public List<Ups> listAllUps()
   :outertype: UpsDAO

   Returns all the ups from the DB

   :return: a list with all the UPS stored

removeUps
^^^^^^^^^

.. java:method:: public void removeUps(int id)
   :outertype: UpsDAO

   Removes from the DB the UPS that matches with the given id

   :param id: the id of the UPS we want to delete

updateUps
^^^^^^^^^

.. java:method:: public void updateUps(Ups ups)
   :outertype: UpsDAO

   Updates the data of an UPS

   :param ups: the UPS to update

