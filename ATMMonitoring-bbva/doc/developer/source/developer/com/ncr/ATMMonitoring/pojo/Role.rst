.. java:import:: java.io Serializable

.. java:import:: java.util ArrayList

.. java:import:: java.util Collection

.. java:import:: java.util List

.. java:import:: java.util Set

.. java:import:: javax.persistence Column

.. java:import:: javax.persistence Entity

.. java:import:: javax.persistence GeneratedValue

.. java:import:: javax.persistence GenerationType

.. java:import:: javax.persistence Id

.. java:import:: javax.persistence OneToMany

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

.. java:import:: org.springframework.security.core GrantedAuthority

.. java:import:: org.springframework.security.core.authority SimpleGrantedAuthority

Role
====

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class Role implements Serializable

   The Role Pojo.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
getAuthorities
^^^^^^^^^^^^^^

.. java:method:: public Collection<? extends GrantedAuthority> getAuthorities()
   :outertype: Role

   Returns the granted authorities for this role.

   :return: the list of granted authorities

getCanAccessReports
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getCanAccessReports()
   :outertype: Role

   Gets the reports access flag.

   :return: the canAccessReports flag

getCanEditTerminals
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getCanEditTerminals()
   :outertype: Role

   Whether the users is can edit terminal data.

   :return: the terminal data edition flag

getCanRequestUpdate
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getCanRequestUpdate()
   :outertype: Role

   Gets the update request usage flag.

   :return: the canRequestUpdate flag

getCanSchedule
^^^^^^^^^^^^^^

.. java:method:: public Boolean getCanSchedule()
   :outertype: Role

   Gets the schedule usage flag.

   :return: the canSchedule flag

getCanUseQueries
^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getCanUseQueries()
   :outertype: Role

   Gets the query usage flag.

   :return: the canUseQueries flag

getCanViewTerminals
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Boolean getCanViewTerminals()
   :outertype: Role

   Gets the terminal data access flag.

   :return: the canViewTerminals flag

getDescription
^^^^^^^^^^^^^^

.. java:method:: public String getDescription()
   :outertype: Role

   Gets the description.

   :return: the description

getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: Role

   Gets the id.

   :return: the id

getManageable
^^^^^^^^^^^^^

.. java:method:: public Boolean getManageable()
   :outertype: Role

   Whether the role is manageable (i.e. can be assigned and modified).

   :return: the manageable flag

getName
^^^^^^^

.. java:method:: public String getName()
   :outertype: Role

   Gets the name.

   :return: the name

getUserManager
^^^^^^^^^^^^^^

.. java:method:: public Boolean getUserManager()
   :outertype: Role

   Gets the user management flag.

   :return: the userManager flag

getUsers
^^^^^^^^

.. java:method:: public Set<User> getUsers()
   :outertype: Role

setCanAccessReports
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setCanAccessReports(Boolean canAccessReports)
   :outertype: Role

   Sets the reports access flag.

   :param canAccessReports: the canAccessReports flag to set

setCanEditTerminals
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setCanEditTerminals(Boolean canEditTerminals)
   :outertype: Role

   Sets the terminal data edition flag.

   :param manageable: the terminal data edition flag to set

setCanRequestUpdate
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setCanRequestUpdate(Boolean canRequestUpdate)
   :outertype: Role

   Sets the update request usage flag.

   :param canRequestUpdate: the canRequestUpdate flag to set

setCanSchedule
^^^^^^^^^^^^^^

.. java:method:: public void setCanSchedule(Boolean canSchedule)
   :outertype: Role

   Sets the schedule usage flag.

   :param canSchedule: the canSchedule flag to set

setCanUseQueries
^^^^^^^^^^^^^^^^

.. java:method:: public void setCanUseQueries(Boolean canUseQueries)
   :outertype: Role

   Sets the query usage flag.

   :param canUseQueries: the canUseQueries flag to set

setCanViewTerminals
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setCanViewTerminals(Boolean canViewTerminals)
   :outertype: Role

   Sets the terminal data access flag.

   :param canViewTerminals: the canViewTerminals flag to set

setDescription
^^^^^^^^^^^^^^

.. java:method:: public void setDescription(String description)
   :outertype: Role

   Sets the description.

   :param description: the description to set

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: Role

   Sets the id.

   :param id: the id to set

setManageable
^^^^^^^^^^^^^

.. java:method:: public void setManageable(Boolean manageable)
   :outertype: Role

   Sets the manageable flag.

   :param manageable: the manageable flag to set

setName
^^^^^^^

.. java:method:: public void setName(String name)
   :outertype: Role

   Sets the name.

   :param name: the name to set

setUserManager
^^^^^^^^^^^^^^

.. java:method:: public void setUserManager(Boolean userManager)
   :outertype: Role

   Sets the user management flag.

   :param userManager: the userManager flag to set

setUsers
^^^^^^^^

.. java:method:: public void setUsers(Set<User> users)
   :outertype: Role

