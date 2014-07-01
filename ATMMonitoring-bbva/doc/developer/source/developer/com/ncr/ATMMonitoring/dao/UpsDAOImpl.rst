.. java:import:: java.util List

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate Criteria

.. java:import:: org.hibernate.criterion Criterion

.. java:import:: org.hibernate.criterion Restrictions

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.Ups

UpsDAOImpl
==========

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class UpsDAOImpl extends AbstractGenericDAO<Ups> implements UpsDAO

   The Class UpsDAOImpl. Default implementation of UpsDAO.

   :author: Otto Abreu

Methods
-------
addUps
^^^^^^

.. java:method:: @Override public void addUps(Ups ups)
   :outertype: UpsDAOImpl

getUps
^^^^^^

.. java:method:: @Override public Ups getUps(int id)
   :outertype: UpsDAOImpl

getUpsBySerialNumber
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Ups getUpsBySerialNumber(String seriesNumber)
   :outertype: UpsDAOImpl

getUpsBySerialNumberAndModel
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Ups getUpsBySerialNumberAndModel(String seriesNumber, String model)
   :outertype: UpsDAOImpl

listAllUps
^^^^^^^^^^

.. java:method:: @Override public List<Ups> listAllUps()
   :outertype: UpsDAOImpl

removeUps
^^^^^^^^^

.. java:method:: @Override public void removeUps(int id)
   :outertype: UpsDAOImpl

updateUps
^^^^^^^^^

.. java:method:: @Override public void updateUps(Ups ups)
   :outertype: UpsDAOImpl

