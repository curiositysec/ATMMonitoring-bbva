.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: com.ncr ATMMonitoring.pojo.TerminalModel

TerminalModelService
====================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface TerminalModelService

   The Interface TerminalModelService. It contains the terminal model related methods.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addTerminalModel
^^^^^^^^^^^^^^^^

.. java:method:: public void addTerminalModel(TerminalModel terminalModel)
   :outertype: TerminalModelService

   Adds the terminal model.

   :param terminalModel: the terminal model

getTerminalModel
^^^^^^^^^^^^^^^^

.. java:method:: public TerminalModel getTerminalModel(Integer id)
   :outertype: TerminalModelService

   Gets the terminal model by its id.

   :param id: the terminal model id
   :return: the terminal model

getTerminalModelByModel
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public TerminalModel getTerminalModelByModel(String model)
   :outertype: TerminalModelService

   Gets the terminal model by model.

   :param model: the model
   :return: the terminal model by model

getTerminalModelByProductClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public TerminalModel getTerminalModelByProductClass(String productClass)
   :outertype: TerminalModelService

   Gets the terminal model by product class.

   :param productClass: the product class
   :return: the terminal model by product class

listTerminalModels
^^^^^^^^^^^^^^^^^^

.. java:method:: public List<TerminalModel> listTerminalModels()
   :outertype: TerminalModelService

   List terminal models.

   :return: the terminal model list

listTerminalModelsByManufacturer
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Map<String, List<TerminalModel>> listTerminalModelsByManufacturer()
   :outertype: TerminalModelService

   List terminal models by manufacturer.

   :return: the map with a terminal list for each manufacturer name

removeTerminalModel
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void removeTerminalModel(Integer id)
   :outertype: TerminalModelService

   Removes the terminal model by its id.

   :param id: , if successful the terminal model id

updateTerminalModel
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void updateTerminalModel(TerminalModel terminalModel)
   :outertype: TerminalModelService

   Update terminal model.

   :param terminalModel: the terminal model

