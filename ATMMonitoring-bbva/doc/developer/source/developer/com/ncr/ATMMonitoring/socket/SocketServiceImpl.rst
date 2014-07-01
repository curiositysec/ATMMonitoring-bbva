.. java:import:: java.util Collection

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Set

.. java:import:: javax.annotation PostConstruct

.. java:import:: org.apache.log4j Logger

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.beans.factory.annotation Value

.. java:import:: org.springframework.stereotype Service

.. java:import:: com.ncr ATMMonitoring.handler.QueueHandler

.. java:import:: com.ncr ATMMonitoring.pojo.Query

.. java:import:: com.ncr ATMMonitoring.pojo.Terminal

.. java:import:: com.ncr ATMMonitoring.service.QueryService

.. java:import:: com.ncr ATMMonitoring.service.TerminalService

.. java:import:: com.ncr.agent.baseData ATMDataStorePojo

SocketServiceImpl
=================

.. java:package:: com.ncr.ATMMonitoring.socket
   :noindex:

.. java:type:: @Service public class SocketServiceImpl implements SocketService

   The Class SocketServiceImpl. Default implementation of SocketService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
getHashSeed
^^^^^^^^^^^

.. java:method:: public String getHashSeed()
   :outertype: SocketServiceImpl

getIpToProcess
^^^^^^^^^^^^^^

.. java:method:: @Override public String getIpToProcess()
   :outertype: SocketServiceImpl

getOldHashSeed
^^^^^^^^^^^^^^

.. java:method:: public String getOldHashSeed()
   :outertype: SocketServiceImpl

init
^^^^

.. java:method:: @PostConstruct public void init()
   :outertype: SocketServiceImpl

   Inits the socketListener by setting this object as its service.

processAwaitingIps
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void processAwaitingIps()
   :outertype: SocketServiceImpl

processTerminalJson
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Long processTerminalJson(String json)
   :outertype: SocketServiceImpl

updateAllTerminalsSocket
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void updateAllTerminalsSocket()
   :outertype: SocketServiceImpl

updateTerminalSocket
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void updateTerminalSocket(Terminal terminal)
   :outertype: SocketServiceImpl

updateTerminalSocket
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void updateTerminalSocket(String ip)
   :outertype: SocketServiceImpl

updateTerminalsSocket
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void updateTerminalsSocket(Collection<String> ips)
   :outertype: SocketServiceImpl

updateTerminalsSocket
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void updateTerminalsSocket(Query query)
   :outertype: SocketServiceImpl

