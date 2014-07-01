.. java:import:: java.io IOException

.. java:import:: java.io PrintWriter

.. java:import:: java.net Socket

.. java:import:: org.apache.log4j Logger

SocketListenerThread
====================

.. java:package:: com.ncr.ATMMonitoring.socket
   :noindex:

.. java:type:: public class SocketListenerThread extends Thread

   The Class SocketListenerThread. Threads which process the incoming connections when listening for the ATMs' agents.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Constructors
------------
SocketListenerThread
^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SocketListenerThread(Socket socket, String okMessage, SocketListener parent)
   :outertype: SocketListenerThread

   Instantiates a new socket listener thread.

   :param socket: the socket
   :param okMessage: the ok message to send to the agent
   :param parent: the socket listener parent

Methods
-------
run
^^^

.. java:method:: public void run()
   :outertype: SocketListenerThread

