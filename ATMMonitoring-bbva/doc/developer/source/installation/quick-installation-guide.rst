************************
Quick Installation Guide
************************

Client Side(ATM)
================


The NCR HSAM Agent is the piece of the NCR HSAM able to catch all the information provided by the ATM in order to be stored in the NCR HSAM Database. Although it is mainly intented to be run in ATMs, it is also able to collect information from any other devices.

It is divided into two main pieces, *HSAMAgent.jar* and *XFSCollector.dll*.
	* **HSAMAgent.jar**: The Java based core of the HSAM Agent. It manages all the processes to collect the required information from the Operating System,Hardware, Software and any other specific information from ATMs(XFS, J/XFS, Financial Devices, etc).
	* **XFSCollector.dll**: A C++ based collector of the information coming from the SW based onthe standard XFS. It is directly managed by the core agent. It automatically detects the highest XFS version supported for each XFS Service Provider starting from XFS 3.10 to XFS 2.00 and extracts the Capabilities information.

The NCR HSAM Agent performs the following actions:
	* ATM Information Collector that gathers all the ATM information and stores it in a JSON formatted file (www.json.org).
	* Server Requests Receptor for getting on-demand information. When an update order is received the ATM information is refreshed and restored into the JSON results file. Once finished, the server is notified.
	* Request Sender for notifying the server that an update has been completed and a data update can be requested after a manual or scheduled demand for updating, or after refreshing the ATM information the first time the agent starts up.

NCR HSAM Agent Requirements
---------------------------
The minimum requirements for running the NCR HSAM Agent are:

	* Windows NT (*)/XP/7
	* Java 1.5
	* Service Providers XFS 2.00 – J/XFS Device Services CWA 2001 -
	* Optional for collecting ATM standard information.
	* *Windows Management Instrumentation* Service Started.
	* For NCR ATMs with Windows XP/7 – WMIDProv package
	* (*) Extra requirements only for Windows NT
		* *Windows Management Instrumentation (WMI) Core 1.5* (**wmint4.exe**)
		* For NCR ATMs – Apply the following XFS Manager Error
			.. note:: Workaround:
				* *HKEY_CLASSES_ROOT\WOSA/XFS_ROOT\XFS_MANAGER ShareMapAddr(REG_SZ)=”67000000*
				* 256 MB RAM


NCR HSAM Agent Installation
---------------------------

#. Unzip the package *HSAMAgent.zip* in C:\. The following folder structure should be created:

	.. image:: images-install/image25.png
			:align: center

#. Copy the “XFSCollector.dll” file in a folder contained in the System Path – It is strongly recommended to use the path *C:\Windows\System32*.
#. Execute the *Matricula.reg* file to create the registry key to be used for handling the ATM Id.

NCR HSAM Agent Configuration
----------------------------

#. J/XFS Configuration
	* The *read.repository* file should include the desired J/XFS configuration for the application INVENTORYAGENT.
	* The System Classpath should include the J/XFS *kernel*.


#. HSAMAgent.cfg (only for J/XFS ATMs)
	* *workstation name* key Computer name.
	* *config_key* key – Application name according to the *read.repository* application name (INVENTORYAGENT).
	* *sdm_addparm_1* key – Path where J/XFS is installed.


#. Config.properties ((*) Mandatory)
	* SERVER_IP (*) – HSAM Server IP.
	* CONFIG_FILE_PATH (*) – *HSAMAgent.cfg* path.
	* AGENT_PORT (*) – HSAM Agent port.
	* SERVER_PORT (*) – HSAM Server port.
	* DEVICE_TYPE (*) – Device where the agent is running (currently only ATM supported).
	* SERVER_TIMEOUT – Waiting timer for a server response.ar y reemplazar
	* OK_MESSAGE – Success response message to the server.
	* SCHEDULE_SLEEP_TIME – Timer for checking configuration changes.
	* THREAD_CONTROL_SLEEP_TIME – Timer for checking the execution thread.
	* SCHEDULED_CHECK_NOTIFY_SERVER – Indicates if any change in the system configuration should be notified to the server.
	* SCHEDULED_CHECK_WRITE_FILE – Indicates if a new JSON file have to be created if a change in the system configuration is detected.
	* SCHEDULED_CHECK_WRITE_FILE_PATH – Data file path.
	* NOTIFY_SERVER_FIRST_TIME – Indicates if the Agent has to notify the Server the first time it starts up.
	* LOG_LEVEL – From lowest to highest level OFF, SEVERE, WARNING, INFO, CONFIG, FINE, FINER, FINEST, ALL.
	* LOG_FILE – Log file path.
	* LOG_FILE_MAX_SIZE – Max size of log file in bytes.
	* LOG_FILE_MAX_NUMBER – Max number of log files.
	* STARTUP_SUPPORT (Reserved)
	* VENDOR_DEPENDENCIES_SUPPORT (Reserved)


NCR HSAM Agent Execution
------------------------

The NCR HSAM Agent can be executed from a cmd or a bat file from the path where the agent is located (C:\HSAM Agent\Core), by sending the following sentence:
	
	.. code-block:: bash

		java –classpath “%CLASSPATH%;C:\HSAM Agent\Core\HSAMAgent.jar” com.ncr.agent.AgentStartup

The NCR HSAM Agent can be executed at any time since it waits for the Aptra Platform to be completely started up.


Server Side
===========

Apache Tomcat
-------------
Install the product (plaese verify the *Host Manager* is also selected during the process) from:`<http://tomcat.apache.org/download70.cgi>`_.
The Tomcat service can be automatically started by changing the “Startup type” property to *Automatic*.
.. warning:: The Tomcat version must be 7

PostgreSQL
----------
Install the product. Please set the following data during PostgreSQL installation :):
	* User: postgres (default)
	* Password: qwerty

Download postgres from `<http://www.postgresql.org/download/>`_.

From *pgAdmin*, create a new database called “inventory” and run the script *HSAMSchemaDataPostgreSQL.sql* to create the database.
To run sql scripts in PostgreSQL, execute the following sentence from the *bin* folder in the PostgreSQL installation path:
	
	.. code-block:: bash

		psql –U username –d inventory > HSAMSchemaDataPostgreSQL.sql path

(where username is the PostgreSQL user, usually *postgres*)

Server Side Deployment
----------------------
#. Make sure that the Tomcat is running
#. Put the *.war* file inside the webbaps folder ( in a Windows environment with a default Tomcat installation will be in  C:\\Program Files\\Apache Software Foundation\\Tomcat x.x\\webapps)
	* This will initiate the Tomcat  autodeploy process.
#. After the autodeploy process have ended, a new folder will be created inside the webapps folder, with the same name as the *.war* file
	* Example:
		* War file name: **atm.war**
		* New Folder created inside webapps: **C:\Program Files\Apache Software Foundation\Tomcat x.x\webapps\atm**
#. Make sure that the recently created folder have the following structure basic structure:
 atm
	*WEB-INF
		* classes
		* lib
		* jsp
		* tags
	* resources
	* META-INF

.. warning:: It is not necessary to create any folder, is an automatic process made by Tomcat, do not create the folder structure by yourself

Configuration Files
-------------------
Once the war file is deployed ( the application folder is created inside the webapps folder) go to the \\webapps\\atm\\WEB-INF\\classes folder inside the appliaction folder and edit the property file called **jdbc.properties** this file contains the parameters to allow the connection with the database such as user, password, etc.  edit  or confirm the values as follows:
	#. **jdbc.databaseurl** =jdbc\:postgresql\://{server}\:{port}/inventory
		* Replace {server} with the name or ip where the postgres instance is running, the same with the {port}
			* if Tomcat and Postgres resides in the same machine, can be used *localhost*
		
		.. note:: to know the port where the postgres instance is listening execute the following SQL sentence: 
			
			.. code-block:: sql

				select * from pg_settings where name = 'port'

	#. **jdbc.username** = postgres
	#. **jdbc.password** = qwerty
		* If the password for the postgres user is not qwerty, change the value for the one used during the postgres installation.
	#. Restart the Tomcat server

The **Config.properties** (available in \\WEB-INF\\classes) This file contains the NCR HSAM Server settings. Be aware that some of the settings must be exactly the same configured in the HSAM Agent side such as *config.serverSocketPort*, *config.agentSocketPort* and *config.agentOkMessage*.

Test the Installation
---------------------
Once all the configuration is done, go, using any of the most common browsers Chrome, Firefox, Opera, Internet Explorer (7 and above), Safari, to:
	* `<http://localhost:8080/folderName>`_ (Local Access)
	* `<http://IPserver:8080/folderName>`_ (External Access)

where folderName matches the name of the folder created during the deployment process, using the example in `Server Side Deployment` the URL will be  http://localhost:8080/atm from there will be possible to see the login page of the application.

	* `<http://localhost:8080/atm>`_ (Local Access)
	* `<http://IPserver:8080/atm>`_ (External Access)

.. note:: The port 8080 is the default port used by Tomcat, if the listening port was changed during the installation, replace this value for the one set in the installation.

.. warning:: If after going to the URL where the application should be, and you get an *Error 404 page not found* even though the application seems to be deployed ( the folder was created during the deployment), it is necessary to see the server logs *catalina.log*  and *localhost.log* available in {TOMCAT_INSTALLATION_PATH} /log in order to find the root of the error.

The default user and password (SUPERADMIN rol) for accessing the application are ‘admin’ for both fields. All ATMs will enroll automatically in the NCR HSAM the first time the HSAM Agent starts up. After a while, the ATM should be listed in the Terminal List.
