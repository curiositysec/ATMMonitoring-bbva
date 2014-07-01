*****************************
Introduction to ATM Inventory
*****************************

ATM Inventory is a web application that allows us to manage the data of a set of ATM's holistically. On top of allowing us to add, edit and remove an ATM from the system, if the ATMs have the agent supplied with the application installed, the server can communicate with them to receive their data at any time. The agent can also send the ATM data by its own (e.g. when it detects a change in the ATM configuration). 

The application also allows us to schedule updates of the ATM data for specific times on a weekly or monthly basis.

It also has its own queries engine that allows us to execute a series of restrictions on all data when displaying a list of ATMs, the queries can be combined with scheduled updates to update the data of only a subset of ATMs .


Features Summary
----------------
- Full management of ATM data with a complete data model that includes all hardware and software components, and other meta-entities such as installation or location.

- ATM Data recovery in real time [1]_.

- Custom query engine that allows us to fetch the ATMs filtering by checking their attributes through multiple operations.

- Allows to plan the ATM data updates weekly or monthly, can be based on a query to limit updates to a subset of machines.

.. [1] *The agent developed jointly with the server application must be installed in the ATMs.*

Comunication Agent-Server
-------------------------

Communication is established through SSL Sockets, without using the full SSL support, leaving at side the authentication by certificates.

Authentication
&&&&&&&&&&&&&&

Method involves an exchange of tokens between client and server. We start from a random string generated in the server, then is sent  to the agent. The hash of this string along with two more string hashes resident in the agent (configurable value),  are concatenated and the hash is recalculated to send it  to the server. The server calculates the hash of the same way with configurable strings ,  the server posses two configurable strings, one named  "current" and other "legacy" and are use to compare to what the agent has sent. If the hashes are equal, are considered authenticated and the communication between them continues. If it does not, the server calculates the hash but with the string "legacy". If neither matches, the hash from the agent shall not be considered properly authenticated and communication will be cut. If they match with “legacy”, the agent will send the configurable string "current" to be updated in the agent and both ends of the communication are considered authenticated.

Encryption
&&&&&&&&&&

It is done by using a file called "keystore" (SSL stores the certificates and the necessary encryption algorithms in this file) that will be distributed along with the agent, due it can not be guaranteed that all ATMs can generate locally that file because not all the Java Virtual Machine implementations seem to have proper support for it. The keystore password is saved in the properties of the agent.

Agent collected Information
---------------------------

ATM Inventory(Server) communicates with an Agent(Client) that is able to catch all the information provided by the ATM in order to be stored in the NCR HSAM Database. Although it is mainly intented to be run in ATMs, it is also able to collect information from any other devices.

It is divided into two main pieces, *HSAMAgent.jar* and *XFSCollector.dll*.

   *  **HSAMAgent.jar** The Java based core of the HSAM Agent. It manages all the processes  to collect the required information from the Operating System, Hardware, Software and any other specific information from ATMs (XFS, J/XFS, Financial Devices, etc).
   * **XFSCollector.dll** A C++ based collector of the information coming from the standard XFS. It is directly managed by the core agent. It automatically detects the highest XFS version supported for each XFS Service Provider starting from XFS 3.10 to XFS 2.00 and extracts the Capabilities information. 

The NCR HSAM Agent performs the following actions:


   * *ATM Information Collector* that gathers all the ATM information and stores it in a JSON formatted file (`<http://www.json.org>`_).
   * *Server Requests Receptor* for getting on-demand information. When an update order is received the ATM information is refreshed and restored into a JSON file. Once finished, the server is notified.
   * *Request Sender for notifying the server* that an update has been completed and a data update can be requested after a manual or scheduled demand for updating, or after refreshing the ATMinformation the first time the agent starts up.

To know more about the information gathered by the agent please see the :doc:`Agent Collected Information <collected-info>`

Agent Autoupdate
----------------
The agent has the ability to perform an autoupdate, this means if a new version of the agent is released, it will be downloaded  and restart itself. This way it is not necessary to reinstall  the agent in each ATM each time a new version is released. 

This process is made by an independent and separate piece of code that contains some methods that can initiate the Agent, to get latest version, stop and free the resources that the executing agent have taken. To check for updates,it is needed to configure a text file where the autoupdate can find the latest version, the MD5 of the file to download and the URL where to find the newest version.The text file will have three lines where the information will be, the first one holds the latest version, the second one the URL where the newest version is, and finally the MD5 of the file to be downloaded.

The autoupdate checks every N (configurable value) seconds if a new version have being released, to do so it reads the first line of the text  file named before, and compare the obtained value with the result of the execution of the method in charge of obtaining the current running version. If a new version is detected, the new JAR will be downloaded from the URL present in the text file. After the new file is downloaded, the current executing JAR version is moved to an temporary folder. Then checks if the MD5 of the downloaded file matches with the obtained one from the text file. 

If the MD5 of the file does not match, the autopdate will retry the process N times ( configurable parameter), if the MD5 matches, and no error were detected in the process, it will stop the old version, start the new one and delete the old version from the temporary folder. If an error occurs during the start process, the new JAR will be deleted and the old version will be moved from the temporary folder and will start.

In cases where unexpected errors occurs, the process just will retry in the next cycle in  a normal way, also the autoupdate have  a very explicative log where is posible to see almost all that have happen in the process, this log is independent from the Agent log

It is possible to avoid the autoupdate process by a configurable parameter, this will only execute the current version of the Agent 


The process can be summarized as follow:

   #. The autoupdate starts
   #. The autoupdate starts the agent version present in the classpath. 
   #. Checks for an Update and an update was detected. 
   #. The new file is downloaded, then the MD5 is checked (if it fails, it will try again until N times), then it will unzip and move / copy / merge files. 
   #. For the running agent waits until it frees its resources ( to avoid a forced stop).
   #. Execute the downloaded agent after the runing one is stoped. If all goes well, delete the old one, and if not, restore it and launch again the previous version.
   #. If the new version is being executed, it will not detect a new update, unless the agent was downgraded, it will start again the process.