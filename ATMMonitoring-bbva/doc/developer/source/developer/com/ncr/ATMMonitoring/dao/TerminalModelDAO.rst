.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.TerminalModel

TerminalModelDAO
================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface TerminalModelDAO

   The Interface TerminalModelDAO. Dao with the operations for managing TerminalModel Pojos.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addTerminalModel
^^^^^^^^^^^^^^^^

.. java:method:: public void addTerminalModel(TerminalModel terminalModel)
   :outertype: TerminalModelDAO

   Adds the terminal model.

   :param terminalModel: the terminal model

getTerminalModel
^^^^^^^^^^^^^^^^

.. java:method:: public TerminalModel getTerminalModel(Integer id)
   :outertype: TerminalModelDAO

   Gets the terminal model with the given id.

   :param id: the id
   :return: the terminal model, or null if it doesn't exist

getTerminalModelByModel
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public TerminalModel getTerminalModelByModel(String model)
   :outertype: TerminalModelDAO

   Gets the terminal model by model.

   :param model: the model
   :return: the terminal model by model, or null if it doesn't exist

getTerminalModelByProductClass
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public TerminalModel getTerminalModelByProductClass(String productClass)
   :outertype: TerminalModelDAO

   Gets the terminal model by product class.

   :param productClass: the product class
   :return: the terminal model by product class, or null if it doesn't exist

listTerminalModels
^^^^^^^^^^^^^^^^^^

.. java:method:: public List<TerminalModel> listTerminalModels()
   :outertype: TerminalModelDAO

   List terminal models.

   :return: the list

removeTerminalModel
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void removeTerminalModel(Integer id)
   :outertype: TerminalModelDAO

   Removes the terminal model with the given id.

   :param id: the id

updateTerminalModel
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void updateTerminalModel(TerminalModel terminalModel)
   :outertype: TerminalModelDAO

   Update terminal model.

   :param terminalModel: the terminal model

