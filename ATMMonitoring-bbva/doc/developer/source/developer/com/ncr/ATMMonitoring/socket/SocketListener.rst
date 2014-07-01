.. java:import:: java.io IOException

.. java:import:: java.net ServerSocket

.. java:import:: java.net SocketException

.. java:import:: javax.annotation PostConstruct

.. java:import:: javax.annotation PreDestroy

.. java:import:: org.apache.log4j Logger

.. java:import:: org.springframework.beans.factory.annotation Value

.. java:import:: org.springframework.stereotype Component

SocketListener
==============

.. java:package:: com.ncr.ATMMonitoring.socket
   :noindex:

.. java:type:: @Component public class SocketListener extends Thread

   The listener interface for receiving socket events. The class that is interested in processing a socket event implements this interface, and the object created with that class is registered with a component using the component's addSocketListener method. When
   the socket event occurs, that object's appropriate
   method is invoked.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Constructors
------------
SocketListener
^^^^^^^^^^^^^^

.. java:constructor:: public SocketListener()
   :outertype: SocketListener

   Instantiates a new socket listener.

SocketListener
^^^^^^^^^^^^^^

.. java:constructor:: public SocketListener(String okMessage)
   :outertype: SocketListener

   Instantiates a new socket listener.

   :param okMessage: the ok message

Methods
-------
checkDestroy
^^^^^^^^^^^^

.. java:method:: @PreDestroy public void checkDestroy()
   :outertype: SocketListener

   Release resources from the listener if it was initialized.

checkInit
^^^^^^^^^

.. java:method:: @PostConstruct public void checkInit()
   :outertype: SocketListener

   Check whether the listener should be initialized or not according to the configuration, and initialize it if that's the case.

doDestroy
^^^^^^^^^

.. java:method:: public void doDestroy() throws IOException
   :outertype: SocketListener

   Stop the listener.

doInit
^^^^^^

.. java:method:: public void doInit() throws IOException
   :outertype: SocketListener

   Initialize the listener.

requestData
^^^^^^^^^^^

.. java:method:: public void requestData(String ip)
   :outertype: SocketListener

   Request data from an ip through the socket service.

   :param ip: the ip

run
^^^

.. java:method:: public void run()
   :outertype: SocketListener

setSocketService
^^^^^^^^^^^^^^^^

.. java:method:: public void setSocketService(SocketService socketService)
   :outertype: SocketListener

   Sets the socket service.

   :param socketService: the new socket service

