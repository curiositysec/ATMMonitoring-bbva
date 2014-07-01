.. java:import:: java.util List

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.dao.HotfixDAO

.. java:import:: com.ncr ATMMonitoring.pojo.Hotfix

HotfixServiceImpl
=================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class HotfixServiceImpl implements HotfixService

   The Class HotfixServiceImpl. Default implementation of the HotfixService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addHotfix
^^^^^^^^^

.. java:method:: @Override public void addHotfix(Hotfix hotfix)
   :outertype: HotfixServiceImpl

getHotfix
^^^^^^^^^

.. java:method:: @Override public Hotfix getHotfix(Integer id)
   :outertype: HotfixServiceImpl

listHotfix
^^^^^^^^^^

.. java:method:: @Override public List<Hotfix> listHotfix()
   :outertype: HotfixServiceImpl

removeHotfix
^^^^^^^^^^^^

.. java:method:: @Override public void removeHotfix(Integer id)
   :outertype: HotfixServiceImpl

