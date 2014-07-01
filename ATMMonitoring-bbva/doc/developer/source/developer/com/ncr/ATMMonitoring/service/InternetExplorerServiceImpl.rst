.. java:import:: java.util List

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.dao.InternetExplorerDAO

.. java:import:: com.ncr ATMMonitoring.pojo.InternetExplorer

InternetExplorerServiceImpl
===========================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class InternetExplorerServiceImpl implements InternetExplorerService

   The Class InternetExplorerServiceImpl. Default implementation of the InternetExplorerService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addInternetExplorer
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addInternetExplorer(InternetExplorer internetExplorer)
   :outertype: InternetExplorerServiceImpl

getInternetExplorer
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public InternetExplorer getInternetExplorer(Integer id)
   :outertype: InternetExplorerServiceImpl

getInternetExplorerByVersion
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public InternetExplorer getInternetExplorerByVersion(Integer majorVersion, Integer minorVersion, Integer buildVersion, Integer revisionVersion, String remainingVersion)
   :outertype: InternetExplorerServiceImpl

listInternetExplorer
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<InternetExplorer> listInternetExplorer()
   :outertype: InternetExplorerServiceImpl

removeInternetExplorer
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void removeInternetExplorer(Integer id)
   :outertype: InternetExplorerServiceImpl

