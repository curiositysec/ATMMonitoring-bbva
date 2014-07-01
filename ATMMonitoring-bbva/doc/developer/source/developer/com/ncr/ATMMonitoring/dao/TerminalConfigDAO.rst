.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.TerminalConfig

TerminalConfigDAO
=================

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface TerminalConfigDAO

   The Interface TerminalConfigDAO. Dao with the operations for managing TerminalConfig Pojos.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addTerminalConfig
^^^^^^^^^^^^^^^^^

.. java:method:: public void addTerminalConfig(TerminalConfig terminalConfig)
   :outertype: TerminalConfigDAO

   Adds the terminal config.

   :param terminalConfig: the terminal config

getTerminalConfig
^^^^^^^^^^^^^^^^^

.. java:method:: public TerminalConfig getTerminalConfig(Integer id)
   :outertype: TerminalConfigDAO

   Gets the terminal config with the given id.

   :param id: the id
   :return: the terminal config, or null if it doesn't exist

listTerminalConfig
^^^^^^^^^^^^^^^^^^

.. java:method:: public List<TerminalConfig> listTerminalConfig()
   :outertype: TerminalConfigDAO

   Lists all terminal config.

   :return: the list

