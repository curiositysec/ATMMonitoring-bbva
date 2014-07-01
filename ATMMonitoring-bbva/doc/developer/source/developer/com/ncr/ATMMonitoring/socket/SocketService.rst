.. java:import:: java.util Collection

.. java:import:: com.ncr ATMMonitoring.pojo.Query

.. java:import:: com.ncr ATMMonitoring.pojo.Terminal

SocketService
=============

.. java:package:: com.ncr.ATMMonitoring.socket
   :noindex:

.. java:type:: public interface SocketService

   The Interface SocketService. This service contains the methods used for requesting the terminals' data through the agent.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
getHashSeed
^^^^^^^^^^^

.. java:method:: public String getHashSeed()
   :outertype: SocketService

   Gets the configurable hash seed.

   :return: the configurable hash seed

getIpToProcess
^^^^^^^^^^^^^^

.. java:method:: public String getIpToProcess()
   :outertype: SocketService

   Load the current queue and extracts one ip from the queue, saving its status afterwards

   :return: String

getOldHashSeed
^^^^^^^^^^^^^^

.. java:method:: public String getOldHashSeed()
   :outertype: SocketService

   Gets the old configurable hash seed.

   :return: the old configurable hash seed

processAwaitingIps
^^^^^^^^^^^^^^^^^^

.. java:method:: public void processAwaitingIps()
   :outertype: SocketService

   Process ips waiting to be requested their data.

processTerminalJson
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Long processTerminalJson(String json)
   :outertype: SocketService

   Process terminal json.

   :param json: the json
   :return: the generated id of the resulting ATM, or null if there was an error

updateAllTerminalsSocket
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void updateAllTerminalsSocket()
   :outertype: SocketService

   Insert all terminals' ip's into the waiting ones list.

updateTerminalSocket
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void updateTerminalSocket(Terminal terminal)
   :outertype: SocketService

   Insert a terminal's ip into the waiting ones list.

   :param terminal: the terminal whose ip we want to request

updateTerminalSocket
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void updateTerminalSocket(String ip)
   :outertype: SocketService

   Insert an ip into the waiting ones list.

   :param ip: the ip to insert

updateTerminalsSocket
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void updateTerminalsSocket(Collection<String> ips)
   :outertype: SocketService

   Insert a series of ip's into the waiting ones list.

   :param ips: the ips to insert

updateTerminalsSocket
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void updateTerminalsSocket(Query query)
   :outertype: SocketService

   Execute a query and insert the resulting terminals' ip's into the waiting ones list.

   :param query: the query to execute

