.. java:import:: java.io File

.. java:import:: java.io FileInputStream

.. java:import:: java.io FileNotFoundException

.. java:import:: java.io FileOutputStream

.. java:import:: java.io IOException

.. java:import:: java.io ObjectInputStream

.. java:import:: java.io ObjectOutputStream

.. java:import:: java.util Collection

.. java:import:: java.util LinkedList

.. java:import:: java.util Queue

.. java:import:: java.util.concurrent ConcurrentLinkedQueue

.. java:import:: java.util.regex Matcher

.. java:import:: java.util.regex Pattern

.. java:import:: org.apache.commons.lang StringUtils

.. java:import:: org.apache.log4j Logger

.. java:import:: org.springframework.beans.factory.annotation Value

.. java:import:: org.springframework.stereotype Component

.. java:import:: com.ncr ATMMonitoring.handler.exception.FileHandlerException

.. java:import:: com.ncr ATMMonitoring.handler.exception.QueueHandlerException

QueueHandler
============

.. java:package:: com.ncr.ATMMonitoring.handler
   :noindex:

.. java:type:: @Component public class QueueHandler

   Class that encapsulate the ATM ip to be updated queue  To use this class is mandatory to load first the queue using the \ :java:ref:`QueueHandler.loadQueue()`\  method, then execute the operations (add, remove) and finally save the status using \ :java:ref:`QueueHandler.save()`\ . If the save method is not called, the actual status of the queue will not be save in disk, except if the destroy method is called This class need that the properties \ **config.queue.filestore.path**\  and \ **config.queue.file.name**\  are configured as follows

   ..

   * \ **config.queue.filestore.path**\ : must specify a valid system path and end with a /
   * \ **config.queue.file.name**\  must specify a file name with extension, example: queue.bin

   :author: Otto Abreu

Methods
-------
add
^^^

.. java:method:: public synchronized void add(String ip) throws QueueHandlerException
   :outertype: QueueHandler

   Adds an ip to the queue this will \ **NOT**\  save the queue state in filesystem

   :param ip:

addAll
^^^^^^

.. java:method:: public synchronized void addAll(Collection<String> ips) throws QueueHandlerException
   :outertype: QueueHandler

   Adds all the ips from the given collection.  This will \ **NOT**\  save the queue state in filesystem

   :param ips: Collection

destroy
^^^^^^^

.. java:method:: public synchronized void destroy() throws QueueHandlerException
   :outertype: QueueHandler

   Clean the queue and then delete the file from the filesystem It is not necessary to call \ :java:ref:`QueueHandler.save()`\  after calling this method

element
^^^^^^^

.. java:method:: public String element()
   :outertype: QueueHandler

   Retrieves, but does not remove, the head of this queue. Null if the queue is empty

isEmpty
^^^^^^^

.. java:method:: public boolean isEmpty() throws QueueHandlerException
   :outertype: QueueHandler

   Tells if the queue is empty e this will \ **NOT**\  save the queue state in filesystem

   :return: boolean

loadQueue
^^^^^^^^^

.. java:method:: @SuppressWarnings public synchronized void loadQueue() throws QueueHandlerException
   :outertype: QueueHandler

   Loads the queue Object, this method performs the deserialization process

peek
^^^^

.. java:method:: public String peek()
   :outertype: QueueHandler

   Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.

poll
^^^^

.. java:method:: public synchronized String poll()
   :outertype: QueueHandler

   Retrieves and removes the head of this queue, or returns null if this queue is empty.

   :return: String

removeAll
^^^^^^^^^

.. java:method:: public synchronized void removeAll() throws QueueHandlerException
   :outertype: QueueHandler

   removes all the elements of the queue, this will not execute the save process  this will \ **NOT**\  save the queue state in filesystem

removeElement
^^^^^^^^^^^^^

.. java:method:: public synchronized void removeElement(String ip) throws QueueHandlerException
   :outertype: QueueHandler

   Removes the given IP from the queue  this will \ **NOT**\  save the queue state in filesystem

   :param ip: String

removeElements
^^^^^^^^^^^^^^

.. java:method:: public synchronized void removeElements(Collection<String> ips) throws QueueHandlerException
   :outertype: QueueHandler

   Removes all the given IP from the queue  this will \ **NOT**\  save the queue state in filesystem

   :param ip: String

save
^^^^

.. java:method:: public synchronized void save() throws QueueHandlerException
   :outertype: QueueHandler

   Saves the queue in filesystem. This method perform the serialization process

   :param terminalsIpQueue:

size
^^^^

.. java:method:: public int size() throws QueueHandlerException
   :outertype: QueueHandler

   returns the size of the queue

viewQueue
^^^^^^^^^

.. java:method:: public Queue<String> viewQueue()
   :outertype: QueueHandler

   Returns a copy of this queue, if the queue is null will return null, empty otherwise

   :return: Queue

