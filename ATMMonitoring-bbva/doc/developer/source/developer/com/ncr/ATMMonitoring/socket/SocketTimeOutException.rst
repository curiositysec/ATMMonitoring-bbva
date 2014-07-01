.. java:import:: java.util HashSet

.. java:import:: java.util Set

SocketTimeOutException
======================

.. java:package:: com.ncr.ATMMonitoring.socket
   :noindex:

.. java:type:: public class SocketTimeOutException extends Exception

   The Class SocketTimeOutException. Exception thrown when we receive no response in the expected time during socket communication.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Fields
------
ips
^^^

.. java:field:: protected Set<String> ips
   :outertype: SocketTimeOutException

   The ips.

Constructors
------------
SocketTimeOutException
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SocketTimeOutException(String string)
   :outertype: SocketTimeOutException

   Instantiates a new socket time out exception.

   :param string: the ip that raised the timeout

SocketTimeOutException
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SocketTimeOutException(Set<String> strings)
   :outertype: SocketTimeOutException

   Instantiates a new socket time out exception.

   :param strings: the ips that raised the timeout

Methods
-------
getIps
^^^^^^

.. java:method:: public Set<String> getIps()
   :outertype: SocketTimeOutException

   Gets the ips list.

   :return: the ips list

getIpsHtmlList
^^^^^^^^^^^^^^

.. java:method:: public String getIpsHtmlList()
   :outertype: SocketTimeOutException

   Gets the ips list as html code.

   :return: the ips list

getMessage
^^^^^^^^^^

.. java:method:: public String getMessage()
   :outertype: SocketTimeOutException

