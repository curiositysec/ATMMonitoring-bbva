.. java:import:: java.util List

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.dao.JxfsComponentDAO

.. java:import:: com.ncr ATMMonitoring.dao.XfsComponentDAO

.. java:import:: com.ncr ATMMonitoring.pojo.JxfsComponent

.. java:import:: com.ncr ATMMonitoring.pojo.XfsComponent

XfsComponentServiceImpl
=======================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class XfsComponentServiceImpl implements XfsComponentService

   The Class XfsComponentServiceImpl. Default implementation of the XfsComponentService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addJxfsComponent
^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addJxfsComponent(JxfsComponent jxfsComponent)
   :outertype: XfsComponentServiceImpl

addXfsComponent
^^^^^^^^^^^^^^^

.. java:method:: @Override public void addXfsComponent(XfsComponent xfsComponent)
   :outertype: XfsComponentServiceImpl

getJxfsComponent
^^^^^^^^^^^^^^^^

.. java:method:: @Override public JxfsComponent getJxfsComponent(Integer id)
   :outertype: XfsComponentServiceImpl

getXfsComponent
^^^^^^^^^^^^^^^

.. java:method:: @Override public XfsComponent getXfsComponent(Integer id)
   :outertype: XfsComponentServiceImpl

listJxfsComponents
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<JxfsComponent> listJxfsComponents()
   :outertype: XfsComponentServiceImpl

listXfsComponents
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<XfsComponent> listXfsComponents()
   :outertype: XfsComponentServiceImpl

