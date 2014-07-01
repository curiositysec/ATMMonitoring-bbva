.. java:import:: java.util List

.. java:import:: java.util Set

.. java:import:: org.springframework.security.core.userdetails UserDetailsService

.. java:import:: org.springframework.security.core.userdetails UsernameNotFoundException

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

.. java:import:: com.ncr ATMMonitoring.pojo.User

UserService
===========

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface UserService extends UserDetailsService

   The Interface UserService. It contains the user related methods.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addUser
^^^^^^^

.. java:method:: public void addUser(User user)
   :outertype: UserService

   Adds the user.

   :param user: the user

getUser
^^^^^^^

.. java:method:: public User getUser(Integer id)
   :outertype: UserService

   Gets the user by its id.

   :param id: the user id
   :return: the user

getUserByUsername
^^^^^^^^^^^^^^^^^

.. java:method:: public User getUserByUsername(String username)
   :outertype: UserService

   Gets the user by username.

   :param username: the username
   :return: the user by username

listUsers
^^^^^^^^^

.. java:method:: public List<User> listUsers()
   :outertype: UserService

   List users with the default sorting.

   :return: the user list

listUsers
^^^^^^^^^

.. java:method:: public List<User> listUsers(String sort, String order)
   :outertype: UserService

   List sorted users.

   :param sort: the sort
   :param order: the order
   :return: the user list

listUsersByBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<User> listUsersByBankCompanies(Set<BankCompany> banks)
   :outertype: UserService

   List users by bank companies.

   :param banks: the bank companies
   :return: the user list

listUsersByBankCompany
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<User> listUsersByBankCompany(BankCompany bank)
   :outertype: UserService

   List users by bank company.

   :param bank: the bank company
   :return: the user list

loadUserByUsername
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public User loadUserByUsername(String username) throws UsernameNotFoundException
   :outertype: UserService

removeUser
^^^^^^^^^^

.. java:method:: public void removeUser(Integer id)
   :outertype: UserService

   Removes the user by its id.

   :param id: the user id

updatePassword
^^^^^^^^^^^^^^

.. java:method:: public void updatePassword(User user)
   :outertype: UserService

   Update password.

   :param user: the user

updateUser
^^^^^^^^^^

.. java:method:: public void updateUser(User user)
   :outertype: UserService

   Update user.

   :param user: the user

