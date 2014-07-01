.. java:import:: java.util Date

.. java:import:: java.util List

.. java:import:: java.util Set

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.security.core.userdetails UsernameNotFoundException

.. java:import:: org.springframework.security.crypto.password PasswordEncoder

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.dao.UserDAO

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

.. java:import:: com.ncr ATMMonitoring.pojo.User

UserServiceImpl
===============

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class UserServiceImpl implements UserService

   The Class UserServiceImpl. Default implementation of the UserService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addUser
^^^^^^^

.. java:method:: @Override public void addUser(User user)
   :outertype: UserServiceImpl

getUser
^^^^^^^

.. java:method:: @Override public User getUser(Integer id)
   :outertype: UserServiceImpl

getUserByUsername
^^^^^^^^^^^^^^^^^

.. java:method:: @Override @Transactional public User getUserByUsername(String username)
   :outertype: UserServiceImpl

listUsers
^^^^^^^^^

.. java:method:: @Override public List<User> listUsers()
   :outertype: UserServiceImpl

listUsers
^^^^^^^^^

.. java:method:: @Override public List<User> listUsers(String sort, String order)
   :outertype: UserServiceImpl

listUsersByBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<User> listUsersByBankCompanies(Set<BankCompany> banks)
   :outertype: UserServiceImpl

listUsersByBankCompany
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<User> listUsersByBankCompany(BankCompany bank)
   :outertype: UserServiceImpl

loadUserByUsername
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public User loadUserByUsername(String username) throws UsernameNotFoundException
   :outertype: UserServiceImpl

removeUser
^^^^^^^^^^

.. java:method:: @Override public void removeUser(Integer id)
   :outertype: UserServiceImpl

updatePassword
^^^^^^^^^^^^^^

.. java:method:: @Override public void updatePassword(User user)
   :outertype: UserServiceImpl

updateUser
^^^^^^^^^^

.. java:method:: @Override public void updateUser(User user)
   :outertype: UserServiceImpl

