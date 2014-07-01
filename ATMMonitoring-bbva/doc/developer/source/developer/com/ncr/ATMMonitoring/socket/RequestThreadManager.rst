.. java:import:: java.io InputStream

.. java:import:: java.security KeyStore

.. java:import:: java.security.cert X509Certificate

.. java:import:: java.util ArrayList

.. java:import:: java.util Collections

.. java:import:: java.util Iterator

.. java:import:: java.util List

.. java:import:: java.util Properties

.. java:import:: java.util Queue

.. java:import:: javax.net ServerSocketFactory

.. java:import:: javax.net SocketFactory

.. java:import:: javax.net.ssl KeyManagerFactory

.. java:import:: javax.net.ssl SSLContext

.. java:import:: javax.net.ssl TrustManager

.. java:import:: javax.net.ssl X509TrustManager

.. java:import:: org.apache.log4j Logger

.. java:import:: org.springframework.core.io ClassPathResource

.. java:import:: org.springframework.core.io.support PropertiesLoaderUtils

RequestThreadManager
====================

.. java:package:: com.ncr.ATMMonitoring.socket
   :noindex:

.. java:type:: public class RequestThreadManager extends Thread

   The Class RequestThreadManager. The class in charge of distributing the pending to request data ip's among multiple RequestThread's.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Constructors
------------
RequestThreadManager
^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RequestThreadManager(double maxThreads, double maxTerminals, int timeOut, int agentPort, int sleepTime, int maxTime, SocketService socketService, Queue<String> actualQueue)
   :outertype: RequestThreadManager

   Instantiates a new request thread manager.

   :param maxThreads: the max number of threads
   :param maxTerminals: the max number of terminals per thread
   :param timeOut: the response time out
   :param agentPort: the agent port
   :param sleepTime: the sleep time between checks onto the sub-threads
   :param maxTime: the max time we wait for the whole process to end
   :param socketService: the socket service
   :param ips: the ips

Methods
-------
getClientSocketFactory
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static SocketFactory getClientSocketFactory()
   :outertype: RequestThreadManager

   Gets the client socket factory.

   :return: the clientSocketFactory

getHashSeed
^^^^^^^^^^^

.. java:method:: public String getHashSeed()
   :outertype: RequestThreadManager

   Gets the hash seed.

   :return: the hash seed

getIpToProcess
^^^^^^^^^^^^^^

.. java:method:: public String getIpToProcess()
   :outertype: RequestThreadManager

   Returns the first ip to process in the queue

getOldHashSeed
^^^^^^^^^^^^^^

.. java:method:: public String getOldHashSeed()
   :outertype: RequestThreadManager

   Gets the old hash seed.

   :return: the old hash seed

getServerSocketFactory
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static ServerSocketFactory getServerSocketFactory()
   :outertype: RequestThreadManager

   Gets the server socket factory.

   :return: the serverSocketFactory

handleIpError
^^^^^^^^^^^^^

.. java:method:: public void handleIpError(String ip)
   :outertype: RequestThreadManager

   Handle ip error.

   :param ip: the ip

handleIpSuccess
^^^^^^^^^^^^^^^

.. java:method:: public Long handleIpSuccess(String json)
   :outertype: RequestThreadManager

   Handle ip success.

   :param json: the json
   :return: the long

run
^^^

.. java:method:: public void run()
   :outertype: RequestThreadManager

