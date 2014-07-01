.. java:import:: java.text DateFormat

.. java:import:: java.text SimpleDateFormat

.. java:import:: java.util ArrayList

.. java:import:: java.util Collection

.. java:import:: java.util Date

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Locale

.. java:import:: java.util Set

.. java:import:: javax.persistence Column

.. java:import:: javax.persistence Entity

.. java:import:: javax.persistence FetchType

.. java:import:: javax.persistence GeneratedValue

.. java:import:: javax.persistence GenerationType

.. java:import:: javax.persistence Id

.. java:import:: javax.persistence JoinColumn

.. java:import:: javax.persistence ManyToOne

.. java:import:: javax.persistence OneToMany

.. java:import:: javax.persistence OneToOne

.. java:import:: javax.persistence OrderBy

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

.. java:import:: javax.validation.constraints Size

.. java:import:: org.hibernate.annotations Cascade

.. java:import:: org.hibernate.annotations CascadeType

.. java:import:: org.hibernate.validator.constraints NotEmpty

.. java:import:: org.springframework.security.core GrantedAuthority

.. java:import:: org.springframework.security.core.userdetails UserDetails

User
====

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class User implements UserDetails

   The User Pojo.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Constructors
------------
User
^^^^

.. java:constructor:: public User()
   :outertype: User

   Instantiates a new user.

Methods
-------
getAuthorities
^^^^^^^^^^^^^^

.. java:method:: @Override public Collection<? extends GrantedAuthority> getAuthorities()
   :outertype: User

getBankCompany
^^^^^^^^^^^^^^

.. java:method:: public BankCompany getBankCompany()
   :outertype: User

   Gets the bank company.

   :return: the bankCompany

getDashboard
^^^^^^^^^^^^

.. java:method:: public Dashboard getDashboard()
   :outertype: User

   Gets the dashboard.

   :return: the dashboard

getFirstname
^^^^^^^^^^^^

.. java:method:: public String getFirstname()
   :outertype: User

   Gets the firstname.

   :return: the firstname

getHtmlWelcomeMessage
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getHtmlWelcomeMessage(Locale locale)
   :outertype: User

   Gets the html welcome message customized with the user data.

   :param locale: the locale
   :return: the html welcome message

getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: User

   Gets the id.

   :return: the id

getLastLogin
^^^^^^^^^^^^

.. java:method:: public Date getLastLogin()
   :outertype: User

   Gets the last login date.

   :return: the last login date, or null if there is no previous login info

getLastname
^^^^^^^^^^^

.. java:method:: public String getLastname()
   :outertype: User

   Gets the lastname.

   :return: the lastname

getManageableBankCompanies
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<BankCompany> getManageableBankCompanies()
   :outertype: User

   Gets the manageable bank companies.

   :return: the manageable bank companies

getMonthlyScheduledUpdates
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<ScheduledUpdate> getMonthlyScheduledUpdates()
   :outertype: User

   Gets the monthly scheduled updates for the user's queries.

   :return: the monthly scheduled updates

getPassword
^^^^^^^^^^^

.. java:method:: @Override public String getPassword()
   :outertype: User

getQueries
^^^^^^^^^^

.. java:method:: public Set<Query> getQueries()
   :outertype: User

   Gets the queries.

   :return: the queries

getRole
^^^^^^^

.. java:method:: public Role getRole()
   :outertype: User

   Gets the role.

   :return: the role

getUsername
^^^^^^^^^^^

.. java:method:: @Override public String getUsername()
   :outertype: User

getWeeklyScheduledUpdates
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<ScheduledUpdate> getWeeklyScheduledUpdates()
   :outertype: User

   Gets the weekly scheduled updates for the user's queries.

   :return: the weekly scheduled updates

isAccountNonExpired
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean isAccountNonExpired()
   :outertype: User

isAccountNonLocked
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean isAccountNonLocked()
   :outertype: User

isCredentialsNonExpired
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean isCredentialsNonExpired()
   :outertype: User

isEnabled
^^^^^^^^^

.. java:method:: @Override public boolean isEnabled()
   :outertype: User

setBankCompany
^^^^^^^^^^^^^^

.. java:method:: public void setBankCompany(BankCompany bankCompany)
   :outertype: User

   Sets the bank company.

   :param bankCompany: the bankCompany to set

setDashboard
^^^^^^^^^^^^

.. java:method:: public void setDashboard(Dashboard dashboard)
   :outertype: User

   Sets the dashboard.

   :param dashboard: the new dashboard

setFirstname
^^^^^^^^^^^^

.. java:method:: public void setFirstname(String firstname)
   :outertype: User

   Sets the firstname.

   :param firstname: the new firstname

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: User

   Sets the id.

   :param id: the new id

setLastLogin
^^^^^^^^^^^^

.. java:method:: public void setLastLogin(Date lastLogin)
   :outertype: User

   Sets the last login date.

   :param lastLogin: the last login date to set

setLastname
^^^^^^^^^^^

.. java:method:: public void setLastname(String lastname)
   :outertype: User

   Sets the lastname.

   :param lastname: the new lastname

setPassword
^^^^^^^^^^^

.. java:method:: public void setPassword(String password)
   :outertype: User

   Sets the password.

   :param password: the new password

setQueries
^^^^^^^^^^

.. java:method:: public void setQueries(Set<Query> queries)
   :outertype: User

   Sets the queries.

   :param queries: the queries to set

setRole
^^^^^^^

.. java:method:: public void setRole(Role role)
   :outertype: User

   Sets the role.

   :param role: the new role

setUsername
^^^^^^^^^^^

.. java:method:: public void setUsername(String username)
   :outertype: User

   Sets the username.

   :param username: the new username

