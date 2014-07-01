.. java:import:: java.security Principal

.. java:import:: java.util HashSet

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: javax.servlet.http HttpServletRequest

.. java:import:: javax.validation Valid

.. java:import:: org.apache.log4j Logger

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.beans.factory.annotation Value

.. java:import:: org.springframework.beans.support PagedListHolder

.. java:import:: org.springframework.stereotype Controller

.. java:import:: org.springframework.validation BindingResult

.. java:import:: org.springframework.web.bind WebDataBinder

.. java:import:: org.springframework.web.bind.annotation InitBinder

.. java:import:: org.springframework.web.bind.annotation ModelAttribute

.. java:import:: org.springframework.web.bind.annotation PathVariable

.. java:import:: org.springframework.web.bind.annotation RequestMapping

.. java:import:: org.springframework.web.bind.annotation RequestMethod

.. java:import:: com.ncr ATMMonitoring.controller.propertyeditor.BankCompanyPropertyEditor

.. java:import:: com.ncr ATMMonitoring.controller.propertyeditor.RolePropertyEditor

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

.. java:import:: com.ncr ATMMonitoring.pojo.Role

.. java:import:: com.ncr ATMMonitoring.pojo.User

.. java:import:: com.ncr ATMMonitoring.service.BankCompanyService

.. java:import:: com.ncr ATMMonitoring.service.RoleService

.. java:import:: com.ncr ATMMonitoring.service.UserService

UserController
==============

.. java:package:: com.ncr.ATMMonitoring.controller
   :noindex:

.. java:type:: @Controller public class UserController extends GenericController

   The Class UserController. Controller for handling user related HTTP petitions.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Fields
------
DEFAULT_ROLE_ORDER
^^^^^^^^^^^^^^^^^^

.. java:field:: public static final String DEFAULT_ROLE_ORDER
   :outertype: UserController

   The Constant DEFAULT_USER_ORDER.

DEFAULT_ROLE_SORT
^^^^^^^^^^^^^^^^^

.. java:field:: public static final String DEFAULT_ROLE_SORT
   :outertype: UserController

   The Constant DEFAULT_ROLE_SORT.

DEFAULT_USER_ORDER
^^^^^^^^^^^^^^^^^^

.. java:field:: public static final String DEFAULT_USER_ORDER
   :outertype: UserController

   The Constant DEFAULT_USER_ORDER.

DEFAULT_USER_SORT
^^^^^^^^^^^^^^^^^

.. java:field:: public static final String DEFAULT_USER_SORT
   :outertype: UserController

   The Constant DEFAULT_USER_SORT.

Methods
-------
addRole
^^^^^^^

.. java:method:: @RequestMapping public String addRole(Role role, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: UserController

   Add role URL.

   :param role: the role
   :param result: the result
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

binder
^^^^^^

.. java:method:: @InitBinder protected void binder(WebDataBinder binder) throws Exception
   :outertype: UserController

   Binds custom property editors.

   :param binder: the binder

deleteUserQuery
^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String deleteUserQuery(Integer roleId, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: UserController

   Delete role URL.

   :param roleId: the role id
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

listUsersAndRoles
^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String listUsersAndRoles(Map<String, Object> map, Principal principal, String p1, String sort1, String order1, String p2, String sort2, String order2, HttpServletRequest request)
   :outertype: UserController

   List users and roles URL.

   :param map: the map
   :param principal: the principal
   :param p1: the page number for users
   :param sort1: the field for sorting users
   :param order1: the order for sorting users
   :param p2: the page number for roles
   :param sort2: the field for sorting roles
   :param order2: the order for sorting roles
   :param request: the request
   :return: the petition response

newGroup
^^^^^^^^

.. java:method:: @RequestMapping public String newGroup(Map<String, Object> map, Principal principal, HttpServletRequest request)
   :outertype: UserController

   New group URL.

   :return: the petition response

redirectToRoles
^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String redirectToRoles()
   :outertype: UserController

   Redirect to roles list URL.

   :return: the petition response

redirectToUsers
^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String redirectToUsers()
   :outertype: UserController

   Redirect to users list URL.

   :return: the petition response

roleDetails
^^^^^^^^^^^

.. java:method:: @RequestMapping public String roleDetails(Integer roleId, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: UserController

   User details URL.

   :param roleId: the user id
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

updateRole
^^^^^^^^^^

.. java:method:: @RequestMapping public String updateRole(Role role, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: UserController

   Update role URL.

   :param role: the role
   :param result: the result
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

updateUser
^^^^^^^^^^

.. java:method:: @RequestMapping public String updateUser(User user, BindingResult result, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: UserController

   Update user URL.

   :param user: the user
   :param result: the result
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

userDetails
^^^^^^^^^^^

.. java:method:: @RequestMapping public String userDetails(Integer userId, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: UserController

   User details URL.

   :param userId: the user id
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the petition response

