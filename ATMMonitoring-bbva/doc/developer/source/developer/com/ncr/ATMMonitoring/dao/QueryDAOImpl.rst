.. java:import:: java.util List

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate Criteria

.. java:import:: org.hibernate.criterion Order

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.Query

QueryDAOImpl
============

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class QueryDAOImpl extends AbstractGenericDAO<Query> implements QueryDAO

   The Class QueryDAOImpl. Default implementation of QueryDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addQuery
^^^^^^^^

.. java:method:: @Override public void addQuery(Query query)
   :outertype: QueryDAOImpl

deleteQuery
^^^^^^^^^^^

.. java:method:: @Override public void deleteQuery(Query query)
   :outertype: QueryDAOImpl

getQuery
^^^^^^^^

.. java:method:: @Override public Query getQuery(Integer id)
   :outertype: QueryDAOImpl

listQueries
^^^^^^^^^^^

.. java:method:: @Override public List<Query> listQueries()
   :outertype: QueryDAOImpl

updateQuery
^^^^^^^^^^^

.. java:method:: @Override public void updateQuery(Query query)
   :outertype: QueryDAOImpl

