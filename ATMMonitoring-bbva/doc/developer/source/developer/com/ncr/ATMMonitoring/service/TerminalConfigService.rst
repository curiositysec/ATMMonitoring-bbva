.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.TerminalConfig

TerminalConfigService
=====================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface TerminalConfigService

   The Interface TerminalConfigService. It contains the terminal config related methods.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addTerminalConfig
^^^^^^^^^^^^^^^^^

.. java:method:: public void addTerminalConfig(TerminalConfig terminalConfig)
   :outertype: TerminalConfigService

   Adds the terminal config.

   :param terminalConfig: the terminal config

getTerminalConfig
^^^^^^^^^^^^^^^^^

.. java:method:: public TerminalConfig getTerminalConfig(Integer id)
   :outertype: TerminalConfigService

   Gets the terminal config by its id.

   :param id: the terminal config id
   :return: the terminal config

listTerminalConfig
^^^^^^^^^^^^^^^^^^

.. java:method:: public List<TerminalConfig> listTerminalConfig()
   :outertype: TerminalConfigService

   List terminal config.

   :return: the terminal config list

