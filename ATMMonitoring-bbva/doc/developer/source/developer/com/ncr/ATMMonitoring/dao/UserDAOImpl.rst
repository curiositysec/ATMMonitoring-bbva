.. java:import:: java.util List

.. java:import:: java.util Set

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate Criteria

.. java:import:: org.hibernate.criterion Criterion

.. java:import:: org.hibernate.criterion Order

.. java:import:: org.hibernate.criterion Restrictions

.. java:import:: org.springframework.security.core.userdetails UsernameNotFoundException

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

.. java:import:: com.ncr ATMMonitoring.pojo.User

UserDAOImpl
===========

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class UserDAOImpl extends AbstractGenericDAO<User> implements UserDAO

   The Class UserDAOImpl. Default implementation of UserDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addUser
^^^^^^^

.. java:method:: @Override public void addUser(User user)
   :outertype: UserDAOImpl

getUser
^^^^^^^

.. java:method:: @Override public User getUser(Integer id)
   :outertype: UserDAOImpl

getUserByUsername
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public User getUserByUsername(String username)
   :outertype: UserDAOImpl

listUsers
^^^^^^^^^

.. java:method:: @Override public List<User> listUsers(String sort, String order)
   :outertype: UserDAOImpl

listUsers
^^^^^^^^^

.. java:method:: @Override public List<User> listUsers()
   :outertype: UserDAOImpl

listUsersByBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<User> listUsersByBankCompanies(Set<BankCompany> banks)
   :outertype: UserDAOImpl

listUsersByBankCompany
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<User> listUsersByBankCompany(BankCompany bank)
   :outertype: UserDAOImpl

removeUser
^^^^^^^^^^

.. java:method:: @Override public void removeUser(Integer id)
   :outertype: UserDAOImpl

updateUser
^^^^^^^^^^

.. java:method:: @Override public void updateUser(User user)
   :outertype: UserDAOImpl

