.. java:import:: java.util List

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate.criterion Restrictions

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.TerminalModel

TerminalModelDAOImpl
====================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class TerminalModelDAOImpl extends AbstractGenericDAO<TerminalModel> implements TerminalModelDAO

   The Class TerminalModelDAOImpl. Default implementation of TerminalModelDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addTerminalModel
^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addTerminalModel(TerminalModel terminalModel)
   :outertype: TerminalModelDAOImpl

getTerminalModel
^^^^^^^^^^^^^^^^

.. java:method:: @Override public TerminalModel getTerminalModel(Integer id)
   :outertype: TerminalModelDAOImpl

getTerminalModelByModel
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public TerminalModel getTerminalModelByModel(String model)
   :outertype: TerminalModelDAOImpl

getTerminalModelByProductClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public TerminalModel getTerminalModelByProductClass(String productClass)
   :outertype: TerminalModelDAOImpl

listTerminalModels
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<TerminalModel> listTerminalModels()
   :outertype: TerminalModelDAOImpl

removeTerminalModel
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void removeTerminalModel(Integer id)
   :outertype: TerminalModelDAOImpl

updateTerminalModel
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void updateTerminalModel(TerminalModel terminalModel)
   :outertype: TerminalModelDAOImpl

