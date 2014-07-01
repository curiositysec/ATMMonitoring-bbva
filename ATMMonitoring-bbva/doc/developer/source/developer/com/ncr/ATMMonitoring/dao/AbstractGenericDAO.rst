.. java:import:: java.lang.reflect ParameterizedType

.. java:import:: java.util List

.. java:import:: org.hibernate Criteria

.. java:import:: org.hibernate SessionFactory

.. java:import:: org.springframework.beans.factory.annotation Autowired

AbstractGenericDAO
==================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @SuppressWarnings public abstract class AbstractGenericDAO<T>

   The Class AbstractGenericDAO. This parameterized class contains the basic methods which will be used by all Daos.

   :param <T>: the Pojo the specific Dao will manage

Fields
------
sessionFactory
^^^^^^^^^^^^^^

.. java:field:: @Autowired protected SessionFactory sessionFactory
   :outertype: AbstractGenericDAO

   The session factory.

Methods
-------
add
^^^

.. java:method:: protected void add(T object)
   :outertype: AbstractGenericDAO

   Saves the Pojo.

   :param object: the Pojo to save

delete
^^^^^^

.. java:method:: protected void delete(T object)
   :outertype: AbstractGenericDAO

   Deletes the Pojo.

   :param object: the Pojo to delete

delete
^^^^^^

.. java:method:: protected void delete(Integer id)
   :outertype: AbstractGenericDAO

   Deletes the row with the given id.

   :param id: the id to delete

get
^^^

.. java:method:: protected T get(Integer id)
   :outertype: AbstractGenericDAO

   Gets the Pojo by its id.

   :param id: the id which we want to retrieve
   :return: the Pojo with the given id, or null if it doesn't exist

getDomainClass
^^^^^^^^^^^^^^

.. java:method:: protected Class getDomainClass()
   :outertype: AbstractGenericDAO

   Gets the specific Pojo class.

   :return: the specific Pojo class

list
^^^^

.. java:method:: protected List<T> list()
   :outertype: AbstractGenericDAO

   Lists all the Pojos.

   :return: the list with all the Pojos

update
^^^^^^

.. java:method:: protected void update(T object)
   :outertype: AbstractGenericDAO

   Updates the Pojo.

   :param object: the Pojo to update

