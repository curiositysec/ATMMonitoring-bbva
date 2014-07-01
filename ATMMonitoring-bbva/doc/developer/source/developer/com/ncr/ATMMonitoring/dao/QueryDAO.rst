.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.Query

QueryDAO
========

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface QueryDAO

   The Interface QueryDAO. Dao with the operations for managing Query Pojos.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addQuery
^^^^^^^^

.. java:method:: public void addQuery(Query query)
   :outertype: QueryDAO

   Adds the query.

   :param query: the query

deleteQuery
^^^^^^^^^^^

.. java:method:: public void deleteQuery(Query query)
   :outertype: QueryDAO

   Delete query.

   :param query: the query

getQuery
^^^^^^^^

.. java:method:: public Query getQuery(Integer id)
   :outertype: QueryDAO

   Gets the query with the given id.

   :param id: the id
   :return: the query, or null if it doesn't exist

listQueries
^^^^^^^^^^^

.. java:method:: public List<Query> listQueries()
   :outertype: QueryDAO

   Lists all queries.

   :return: the list

updateQuery
^^^^^^^^^^^

.. java:method:: public void updateQuery(Query query)
   :outertype: QueryDAO

   Updates query.

   :param query: the query

