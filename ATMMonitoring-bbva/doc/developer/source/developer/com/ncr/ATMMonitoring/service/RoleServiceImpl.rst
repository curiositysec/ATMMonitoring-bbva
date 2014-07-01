.. java:import:: java.util List

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.dao.RoleDAO

.. java:import:: com.ncr ATMMonitoring.pojo.Role

RoleServiceImpl
===============

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class RoleServiceImpl implements RoleService

   The Class RoleServiceImpl. Default implementation of the RoleService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addRole
^^^^^^^

.. java:method:: @Override public void addRole(Role role)
   :outertype: RoleServiceImpl

deleteRole
^^^^^^^^^^

.. java:method:: @Override public void deleteRole(Role role)
   :outertype: RoleServiceImpl

getRole
^^^^^^^

.. java:method:: @Override public Role getRole(Integer id)
   :outertype: RoleServiceImpl

getRoleByName
^^^^^^^^^^^^^

.. java:method:: @Override public Role getRoleByName(String name)
   :outertype: RoleServiceImpl

listManageableRoles
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Role> listManageableRoles()
   :outertype: RoleServiceImpl

listManageableRoles
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Role> listManageableRoles(String sort, String order)
   :outertype: RoleServiceImpl

listRoles
^^^^^^^^^

.. java:method:: @Override public List<Role> listRoles()
   :outertype: RoleServiceImpl

removeRole
^^^^^^^^^^

.. java:method:: @Override public void removeRole(Integer id)
   :outertype: RoleServiceImpl

updateRole
^^^^^^^^^^

.. java:method:: @Override public void updateRole(Role role)
   :outertype: RoleServiceImpl

