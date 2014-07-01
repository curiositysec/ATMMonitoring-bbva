.. java:import:: java.util List

.. java:import:: org.apache.log4j Logger

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.JxfsComponent

JxfsComponentDAOImpl
====================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class JxfsComponentDAOImpl extends AbstractGenericDAO<JxfsComponent> implements JxfsComponentDAO

   The Class JxfsComponentDAOImpl. Default implementation of JxfsComponentDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addJxfsComponent
^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addJxfsComponent(JxfsComponent jxfsComponent)
   :outertype: JxfsComponentDAOImpl

getJxfsComponent
^^^^^^^^^^^^^^^^

.. java:method:: @Override public JxfsComponent getJxfsComponent(Integer id)
   :outertype: JxfsComponentDAOImpl

listJxfsComponents
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<JxfsComponent> listJxfsComponents()
   :outertype: JxfsComponentDAOImpl

