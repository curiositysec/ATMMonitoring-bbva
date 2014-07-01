.. java:import:: java.util ArrayList

.. java:import:: java.util Date

.. java:import:: java.util List

.. java:import:: java.util Locale

.. java:import:: java.util Set

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate.type Type

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.dao.QueryDAO

.. java:import:: com.ncr ATMMonitoring.dao.TerminalDAO

.. java:import:: com.ncr ATMMonitoring.pojo.Query

.. java:import:: com.ncr ATMMonitoring.pojo.Terminal

.. java:import:: com.ncr ATMMonitoring.pojo.User

.. java:import:: com.ncr ATMMonitoring.utils.WidgetQueryAssociationType

QueryServiceImpl
================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class QueryServiceImpl implements QueryService

   The Class QueryServiceImpl. Default implementation of the QueryService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addQuery
^^^^^^^^

.. java:method:: @Override public void addQuery(Query query)
   :outertype: QueryServiceImpl

addQuery
^^^^^^^^

.. java:method:: @Override public void addQuery(Query query, String username)
   :outertype: QueryServiceImpl

deleteQuery
^^^^^^^^^^^

.. java:method:: @Override public void deleteQuery(Query query)
   :outertype: QueryServiceImpl

executeQuery
^^^^^^^^^^^^

.. java:method:: @Override public List<Terminal> executeQuery(Query query)
   :outertype: QueryServiceImpl

executeQuery
^^^^^^^^^^^^

.. java:method:: @Override public List<Terminal> executeQuery(Query query, Locale locale)
   :outertype: QueryServiceImpl

executeQuery
^^^^^^^^^^^^

.. java:method:: @Override public List<Terminal> executeQuery(Query query, Locale locale, String sort, String order)
   :outertype: QueryServiceImpl

executeQuery
^^^^^^^^^^^^

.. java:method:: @Override public List<Terminal> executeQuery(Query query, Locale locale, String sort, String order, Date queryDate)
   :outertype: QueryServiceImpl

executeQueryGroupingBy
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<?> executeQueryGroupingBy(Query query, WidgetQueryAssociationType groupByEntity, String groupByField, Locale locale, Date queryDate)
   :outertype: QueryServiceImpl

findOrCreateQuery
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Query findOrCreateQuery(Query query)
   :outertype: QueryServiceImpl

getQueriesByUser
^^^^^^^^^^^^^^^^

.. java:method:: @Override public Set<Query> getQueriesByUser(String username)
   :outertype: QueryServiceImpl

getQueriesByUser
^^^^^^^^^^^^^^^^

.. java:method:: @Override public Set<Query> getQueriesByUser(User user)
   :outertype: QueryServiceImpl

getQuery
^^^^^^^^

.. java:method:: @Override public Query getQuery(Integer id)
   :outertype: QueryServiceImpl

listQueries
^^^^^^^^^^^

.. java:method:: @Override public List<Query> listQueries()
   :outertype: QueryServiceImpl

queryBelongToUser
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean queryBelongToUser(Query query, String username)
   :outertype: QueryServiceImpl

updateQuery
^^^^^^^^^^^

.. java:method:: @Override public void updateQuery(Query query)
   :outertype: QueryServiceImpl

updateQuery
^^^^^^^^^^^

.. java:method:: @Override public void updateQuery(Query query, String username)
   :outertype: QueryServiceImpl

