.. java:import:: java.io IOException

.. java:import:: java.util Set

.. java:import:: javax.servlet ServletContext

.. java:import:: javax.servlet ServletException

.. java:import:: javax.servlet.http HttpServletRequest

.. java:import:: javax.servlet.http HttpServletResponse

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.beans.factory.annotation Value

.. java:import:: org.springframework.security.core Authentication

.. java:import:: org.springframework.security.core.authority AuthorityUtils

.. java:import:: org.springframework.security.web.access WebInvocationPrivilegeEvaluator

.. java:import:: org.springframework.security.web.authentication SimpleUrlAuthenticationSuccessHandler

.. java:import:: org.springframework.security.web.savedrequest HttpSessionRequestCache

.. java:import:: org.springframework.security.web.savedrequest RequestCache

.. java:import:: org.springframework.security.web.savedrequest SavedRequest

LoginSuccessHandler
===================

.. java:package:: com.ncr.ATMMonitoring.handler
   :noindex:

.. java:type:: public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler

   The handler LoginSuccessHandler. Custom login success handler that sends user managers to the users management page after login, and every other user to the dashboard.

Methods
-------
onAuthenticationSuccess
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException
   :outertype: LoginSuccessHandler

setRequestCache
^^^^^^^^^^^^^^^

.. java:method:: public void setRequestCache(RequestCache requestCache)
   :outertype: LoginSuccessHandler

