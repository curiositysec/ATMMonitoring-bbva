=============================================
ATM Inventory: ATM management web application
=============================================

.. sectnum::
   :depth: 3
   :suffix: .
   :start: 0
.. contents:: Table of contents

Introduction to ATM Inventory
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

ATM Inventory is a web application which allows us to manage all the data we have from a collection of ATM in an integral way. On top of allowing us to add, delete and edit ATMs and their data, if they have the proper agent installed, server can communicate with them and receive their data at any time, starting the communication from either the server or the ATM (e.g. when it detects a config change). This data updates can also be scheduled weekly or monthly at specific times. It also has a powerful query engine that allows us to impose restrictions onto the ATMs' data and filter them, being particularly useful when combined with the scheduled updates so we can update only a subset of ATMs.

Functionalities summary
***********************

- Management of ATM data with a complete data modelo which includes all its hw and sw components, as well as meta-entities like installation and location.

- Real-time data retrieval from the ATMs [1]_.

- Custom engine query which allows us to filter the ATMs by several operations onto their attributes and related entities.

- Updates of the ATMs' data can be scheduled on a weekly or monthly basis, with the option of using a query for updating only a subset of ATMs.

.. [1] the ATMs must have the agent developed along with the server application correctly installed and configured.

User manual
~~~~~~~~~~~

Now we will explain all the functionalities offered by the application, detailing their options and user interfaces:

.. include:: user-main.rst
.. include:: login-logout.rst
.. include:: dashboard.rst
.. include:: terminals.rst
.. include:: reports.rst
.. include:: scheduled_updates.rst
.. include:: users.rst
