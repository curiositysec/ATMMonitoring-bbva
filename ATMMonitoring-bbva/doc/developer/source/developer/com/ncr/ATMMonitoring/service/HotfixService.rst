.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.Hotfix

HotfixService
=============

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface HotfixService

   The Interface HotfixService. It contains the hotfix related methods.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addHotfix
^^^^^^^^^

.. java:method:: public void addHotfix(Hotfix hotfix)
   :outertype: HotfixService

   Adds the hotfix.

   :param hotfix: the hotfix

getHotfix
^^^^^^^^^

.. java:method:: public Hotfix getHotfix(Integer id)
   :outertype: HotfixService

   Gets the hotfix by its id.

   :param id: the hotfix id
   :return: the hotfix

listHotfix
^^^^^^^^^^

.. java:method:: public List<Hotfix> listHotfix()
   :outertype: HotfixService

   List hotfix.

   :return: the hotfix list

removeHotfix
^^^^^^^^^^^^

.. java:method:: public void removeHotfix(Integer id)
   :outertype: HotfixService

   Removes the hotfix by its id.

   :param id: the hotfix id

