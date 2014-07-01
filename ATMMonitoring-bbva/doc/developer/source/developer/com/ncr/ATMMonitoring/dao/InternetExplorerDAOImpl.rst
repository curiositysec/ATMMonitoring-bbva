.. java:import:: java.util List

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate Criteria

.. java:import:: org.hibernate.criterion Order

.. java:import:: org.hibernate.criterion Restrictions

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.InternetExplorer

InternetExplorerDAOImpl
=======================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class InternetExplorerDAOImpl extends AbstractGenericDAO<InternetExplorer> implements InternetExplorerDAO

   The Class InternetExplorerDAOImpl. Default implementation of InternetExplorerDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addInternetExplorer
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addInternetExplorer(InternetExplorer internetExplorer)
   :outertype: InternetExplorerDAOImpl

getInternetExplorer
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public InternetExplorer getInternetExplorer(Integer id)
   :outertype: InternetExplorerDAOImpl

getInternetExplorerByVersion
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public InternetExplorer getInternetExplorerByVersion(Integer majorVersion, Integer minorVersion, Integer buildVersion, Integer revisionVersion, String remainingVersion)
   :outertype: InternetExplorerDAOImpl

listInternetExplorer
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<InternetExplorer> listInternetExplorer()
   :outertype: InternetExplorerDAOImpl

removeInternetExplorer
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void removeInternetExplorer(Integer id)
   :outertype: InternetExplorerDAOImpl

