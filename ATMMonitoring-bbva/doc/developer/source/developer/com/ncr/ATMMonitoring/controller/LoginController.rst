.. java:import:: java.util Map

.. java:import:: org.springframework.stereotype Controller

.. java:import:: org.springframework.web.bind.annotation RequestMapping

.. java:import:: org.springframework.web.bind.annotation RequestMethod

LoginController
===============

.. java:package:: com.ncr.ATMMonitoring.controller
   :noindex:

.. java:type:: @Controller public class LoginController

   The Class LoginController. Controller for handling login related HTTP petitions.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
login
^^^^^

.. java:method:: @RequestMapping public String login()
   :outertype: LoginController

   Login URL.

   :return: the petition response

loginFailed
^^^^^^^^^^^

.. java:method:: @RequestMapping public String loginFailed(Map<String, Object> map)
   :outertype: LoginController

   Login failed URL.

   :param map: the map
   :return: the petition response

preLogin
^^^^^^^^

.. java:method:: @RequestMapping public String preLogin()
   :outertype: LoginController

   Render a page for redirect on the client to the correct login page. Is used for avoid login page on iframes

   :return: The request result

printWelcome
^^^^^^^^^^^^

.. java:method:: @RequestMapping public String printWelcome()
   :outertype: LoginController

   Index URL.

   :return: the petition response

redirectToIndex
^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String redirectToIndex()
   :outertype: LoginController

   Base URL.

   :return: the petition response

