*******************
Developer Notes
*******************
Code Structure
===============

The whole program was designed in the usual way for a Spring/Hibernate one, with the following logical layers from bottom to top:

#. POJOs (Plain Old Java Object): the objects that store the DB entities' data. We have one class for each entity (DB table), and they
   describe our complete DB model.
#. DAO: we have both facades and actual implementations, and they are the ones responsible for calling the Hibernate methods used
   for retrieving, creating, updating and deleting data from the DB. Their functions are intended to be simple and atomic, with little
   business logic. There is one DAO class for each POJO class.
#. Service: we have again both facades and implementations. Services are the ones in charge of doing most of the business logic,
   including calling the DAOs they need. We have one Service class for each one of the POJO classes, though some of them are really
   scarcely used and their main purpose right now is to keep code more organised. We also have an additional Service for the Socket
   communication with the ATMs.
#. Controllers: the classes that map the URLs with the methods to execute and servlets to deliver for each of them. We have one Controller
   for each of the main POJOs that will have their own GUIs, each one with a method for each GET/POST URL, which in most cases return either
   a JSP file name or a redirect order.

Besides all these classes, we also have some additional ones for very specific purposes: some classes for the Socket communication,
including two Exceptions; one that wraps the queries' operations; and an Utils that contains a bunch of static methods that are used
in several places.
And we have the JSP (JavaServer Pages) files (under src/main/webapp/WEB-INF/jsp), which contain the code that produces the HTML (with
JavaScript and CSS) for our pages. There are also tags, jsp code used in many places and wrapped in a different file for avoiding
code repetition.
As any other Spring/Hibernate application, we also have the xml config files (pom, web, applicationContext...), config properties
files (messages with the translation strings, jdbc with the DB config, log4j with those properties, config with application-specific
options and inventory with the agent project ones), JavaScript libraries, CSS style sheets and images.


Sensitive code sections
========================

#. Query designer comboboxes: the comboboxes for the queries design page are filled in a way that is intended to be easily modifiable. For
   achieving this we created the class Operation, which is the one that does all low level real work related to the query operations. First of all,
   it stores in several structures the data related to those operations. In one of them it stores a mapping from the operations string ids
   to an enum values (the enum allows us to use a switch sentence). It also has another structure that holds all the operations allowed for
   each data type, along with a boolean that tells us whether the operation needs a parameter or not (e.g. Is Null does not need a parameter).
   Above the Operation, the POJOs of the entities referred in the comboboxes create another structure for storing the fields for the comboboxes
   with their proper operations retrieved from Operation based on their data type. In the jsp file queries we create a JavaScript structure
   based on that HashMap with the whole comboboxes config, which we will use to populated the comboboxes through JavaScript on demand.
#. Version storage: most version fields are stored in five independent fields in DB: major version, minor version, build version, revision
   version and remaining version. The first four fields store the usual version numbers as integers, and the last one stores a string with
   the remaining characters (e.g. 1.2.43.21.alpha), or the whole version in case it can't be parsed in the other fields. In every case we store
   a version this way we also have commodity functions for both retrieving and setting the whole version as a string with one call.
#. Socket sinchronization: all the Socket sinchronization code is included in the subpackage 'socket'. This includes the service with the methods
   called from the proper Controller, and the SocketListener which is the one that does the Socket requests and response reception itself. This
   Listener includes a @PostConstruct annotated method that creates the response listener and a @PreDestruct method that releases the resources
   used by the listener before destroying the servlet. It's also important pointing that the ScheduledUpdateService includes a @Scheduled
   annotated method which checks the scheduled updates according to the cron expression (each minute by default) and calls the SocketService
   function for updating the proper Terminals in case we have a scheduled update.
   
   
