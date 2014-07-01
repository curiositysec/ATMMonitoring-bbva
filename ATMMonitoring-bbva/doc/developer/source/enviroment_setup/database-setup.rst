**************
Database Setup
**************
This section explains how to install PostgresSQL and configure ATM Inventory's database.

Software Requisites And Assumptions
===================================
* This guide was written with commands for **CentOS 6.5** and similar OS's.
* The DBMS must be **PostgreSQL 8.3+**. Please check the `PostgreSQL requirements <http://www.postgresql.org/docs/8.3/static/install-requirements.html>`_.
* It is assumed that we have administrator permissions in our local system.

Installation
============
*YUM Configuration*
*******************
#. Open the file **/etc/yum.repos.d/CentOS-Base.repo**
#. Add the next line into the sections *[Base]* and *[Update]*:

	.. code-block:: bash

		exclude=postgresql

#. Save the file.

*Download And Install*
**********************
#. First of all, it is necessary to know the processor architecture (x86 or x64). If you are unsure about it or can't find it out, stick to x86.
#. Go to `PostgreSQL RPM Building Project - Repository Packages  <http://yum.postgresql.org/repopackages.php#pg93>`_ and download the file for your OS, architecture and the desired PostgreSQL version (we recommend installing the later version).
#. Install the downloaded file:

	.. code-block:: bash

		rpm -ivh <file_name>.rpm

#. Open a console and write the following command:

	.. code-block:: bash

		$ yum list postgres*

	.. .. image:: images-db/image06.png
 
	After executing the command you will see an output similar to this listing all the available PostgreSQL packages:

	.. image:: images-db/image04.png
		:align: center
      	
#. Then write the following for installing the desired PostgreSQL server package:

	.. code-block:: bash

		$ yum install postgresql<version>-server

	For example:

	.. code-block:: bash

		$ yum install postgresql93-server

	.. .. image:: images-db/image02.png
		
	Output should look like this:

	.. image:: images-db/image08.png
		:align: center

.. note:: installation instructions will assume from now on that the installed **PostgreSQL version is 9.3** (the latest one when this doc
	was written), which means that in everyplace you see that number or similar (e.g. *93*) you must replace it with your actual version
	if you are not using precisely that one.

*Verifying The Installation*
****************************
#. Check that the path **/var/lib/pgsql/9.3/data** exists.
#. Start the PostgreSQL server using the following command

	.. code-block:: bash

		$ service postgresql-9.3 initdb

	.. .. image:: images-db/image03.png
      
#. Wait until the following message appears:

	.. image:: images-db/image05.png
      
#. If this error happens:

	.. image:: images-db/image07.png

	delete the whole **/var/lib/pgsql/9.3/data** directory ( including the folder *data*) and start the server again.

*Allow Connections By User + Password*
**************************************

PostgreSQL by default doesn't allow users to log in by user and password or from outside localhost, so we must change its configuration:

#. Open the file :  **/var/lib/pgsql/data/9.3/pg_hba.conf** 
  
	* You should see something like this at the end of the file:

		.. code-block:: bash
		 
				# TYPE  DATABASE    USER        CIDR-ADDRESS          METHOD
		 
				# "local" is for Unix domain socket connections only
				local   all         all                               ident
				# IPv4 local connections:
				host    all         all         127.0.0.1/32          ident
				# IPv6 local connections:
				host    all         all         ::1/128               ident
		      

	* In order to simply allow user+password authentication on every connection, just replace **ident** (or whichever values you have in the last column in every line) with **md5**, so it looks like this:

		.. code-block:: bash

				# TYPE  DATABASE    USER        CIDR-ADDRESS          METHOD
		 
				# "local" is for Unix domain socket connections only
				local   all         all                               md5
				# IPv4 local connections:
				host    all         all         127.0.0.1/32          md5
				# IPv6 local connections:
				host    all         all         ::1/128               md5
	
   
	.. note:: you probably have a section like this a bit earlier in that file:
		
			.. code-block:: bash

						# Database administrative login by Unix domain socket
						local   all         postgres                          ident
				
		which allows the postgres user to still login by *ident* in the local machine (which means the computer user *postgres* can directly login). It's strongly discouraged to remove this line.

#. Edit the file : **/var/lib/pgsql/9.1/data/postgresql.conf** 
   * Search for this line:

	.. code-block:: bash

		#listen_addresses = 'localhost'
	
	Make it look like this:

	.. code-block:: bash

		listen_addresses = '*'

*Optional Configuration*
************************
* In order to configure the database server to automatically start when logging in with the current computer username, execute the following command:

	.. code-block:: bash
	
		chkconfig postgresql-9.3 on

*More Information On Installing PostgreSQL*
*******************************************
*  `Postgres YUM Instalation <http://wiki.postgresql.org/wiki/YUM_Installation>`_.

.. note:: installation instructions will assume from now on that all the database connections are established from local computer to the default PostgreSQL port, so no port or ip needs to be specified. In case you are in a different scenario (e.g. remote connection), please refer to the `psql <http://www.postgresql.org/docs/9.3/static/app-psql.html>`_ and `pgAdmin <http://www.pgadmin.org/docs/1.8/index.html>`_ documentation for further info onto those options.
	
 
*Changing The Password Of The Database User 'postgres'*
*******************************************************

By default PostgreSQL creates an admin user with the login 'postgres' and no effective password. If we want to set its password, which is
strongly encouraged, we must follow the next steps:

	.. _postgresql_interpreter:

#. In the command line type the following for starting the PostgreSQL interpreter:

	.. code-block:: bash
	
		sudo -u postgres psql

	and enter the local superuser password.

#.  When the PostgreSQL interpreter shows something like 

	.. code-block:: bash
	
		psql (9.3)
		Type "help" for help.
		postgres=#

	Type:

	.. code-block:: bash
	
		postgres=# ALTER USER postgres WITH PASSWORD '<new_password>';

Setting Up The Database For ATM Inventory
=========================================
#. Create the database with the name *inventory* (or any other name you wish) by any of these methods:
	* Using a PostgreSQL admin tool (like `pgAdmin <http://www.pgadmin.org/>`_) or the command line interpreter (as we `previously explained`__), write the following as the PostgreSQL user *postgres* (or any other user with enough permissions to create a new database):

	__ postgresql_interpreter_

			.. code-block:: bash
	
				CREATE DATABASE inventory OWNER postgres;
         
	* Using the **createdb** command:

            .. code-block:: bash
      
                  $ sudo -u postgres createdb inventory

	* and enter the local superuser password.

#. Restore the database structure and starting data:
	* Execute the following :download:`sql script <minimum_dump.sql>` as PostgreSQL user *postgres* (or any other user with admin permission onto the database *inventory*):
		
.. include:: minimum_dump_create1.rst

.. include:: minimum_dump_create2.rst

.. include:: minimum_dump_insert.rst

