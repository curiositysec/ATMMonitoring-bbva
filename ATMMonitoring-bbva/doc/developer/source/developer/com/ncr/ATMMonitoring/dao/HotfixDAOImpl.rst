.. java:import:: java.util List

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate Criteria

.. java:import:: org.hibernate.criterion Order

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.Hotfix

HotfixDAOImpl
=============

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class HotfixDAOImpl extends AbstractGenericDAO<Hotfix> implements HotfixDAO

   The Class HotfixDAOImpl. Default implementation of HotfixDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addHotfix
^^^^^^^^^

.. java:method:: @Override public void addHotfix(Hotfix hotfix)
   :outertype: HotfixDAOImpl

getHotfix
^^^^^^^^^

.. java:method:: @Override public Hotfix getHotfix(Integer id)
   :outertype: HotfixDAOImpl

listHotfix
^^^^^^^^^^

.. java:method:: @Override public List<Hotfix> listHotfix()
   :outertype: HotfixDAOImpl

removeHotfix
^^^^^^^^^^^^

.. java:method:: @Override public void removeHotfix(Integer id)
   :outertype: HotfixDAOImpl

