.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.Role

RoleDAO
=======

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface RoleDAO

   The Interface RoleDAO. Dao with the operations for managing Role Pojos.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addRole
^^^^^^^

.. java:method:: public void addRole(Role role)
   :outertype: RoleDAO

   Adds the role.

   :param role: the role

deleteRole
^^^^^^^^^^

.. java:method:: public void deleteRole(Role role)
   :outertype: RoleDAO

   Delete role.

   :param role: the role

getRole
^^^^^^^

.. java:method:: public Role getRole(Integer id)
   :outertype: RoleDAO

   Gets the role with the given id.

   :param id: the id
   :return: the role, or null if it doesn't exist

getRoleByName
^^^^^^^^^^^^^

.. java:method:: public Role getRoleByName(String name)
   :outertype: RoleDAO

   Gets the role with the given name.

   :param name: the name
   :return: the role, or null if it doesn't exist

listManageableRoles
^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Role> listManageableRoles()
   :outertype: RoleDAO

   List manageable roles.

   :return: the list

listManageableRoles
^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Role> listManageableRoles(String order, String sort)
   :outertype: RoleDAO

   List sorted manageable roles.

   :param sort: the sort
   :param order: the order
   :return: the list

listRoles
^^^^^^^^^

.. java:method:: public List<Role> listRoles()
   :outertype: RoleDAO

   Lists all roles.

   :return: the list

removeRole
^^^^^^^^^^

.. java:method:: public void removeRole(Integer id)
   :outertype: RoleDAO

   Removes the role with the given id.

   :param id: the id

updateRole
^^^^^^^^^^

.. java:method:: public void updateRole(Role role)
   :outertype: RoleDAO

   Updates the role.

   :param role: the role

