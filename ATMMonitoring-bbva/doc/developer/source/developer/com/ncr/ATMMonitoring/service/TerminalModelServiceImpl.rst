.. java:import:: java.util ArrayList

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.dao.TerminalModelDAO

.. java:import:: com.ncr ATMMonitoring.pojo.TerminalModel

TerminalModelServiceImpl
========================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class TerminalModelServiceImpl implements TerminalModelService

   The Class TerminalModelServiceImpl. Default implementation of the TerminalModelService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addTerminalModel
^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addTerminalModel(TerminalModel role)
   :outertype: TerminalModelServiceImpl

getTerminalModel
^^^^^^^^^^^^^^^^

.. java:method:: @Override public TerminalModel getTerminalModel(Integer id)
   :outertype: TerminalModelServiceImpl

getTerminalModelByModel
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public TerminalModel getTerminalModelByModel(String model)
   :outertype: TerminalModelServiceImpl

getTerminalModelByProductClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public TerminalModel getTerminalModelByProductClass(String productClass)
   :outertype: TerminalModelServiceImpl

listTerminalModels
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<TerminalModel> listTerminalModels()
   :outertype: TerminalModelServiceImpl

listTerminalModelsByManufacturer
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Map<String, List<TerminalModel>> listTerminalModelsByManufacturer()
   :outertype: TerminalModelServiceImpl

removeTerminalModel
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void removeTerminalModel(Integer id)
   :outertype: TerminalModelServiceImpl

updateTerminalModel
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void updateTerminalModel(TerminalModel terminalModel)
   :outertype: TerminalModelServiceImpl

