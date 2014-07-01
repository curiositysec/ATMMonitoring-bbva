.. java:import:: java.util List

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.stereotype Service

.. java:import:: org.springframework.transaction.annotation Transactional

.. java:import:: com.ncr ATMMonitoring.dao.TerminalConfigDAO

.. java:import:: com.ncr ATMMonitoring.pojo.TerminalConfig

TerminalConfigServiceImpl
=========================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: @Service @Transactional public class TerminalConfigServiceImpl implements TerminalConfigService

   The Class TerminalConfigServiceImpl. Default implementation of the TerminalConfigService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addTerminalConfig
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addTerminalConfig(TerminalConfig terminalConfig)
   :outertype: TerminalConfigServiceImpl

getTerminalConfig
^^^^^^^^^^^^^^^^^

.. java:method:: @Override public TerminalConfig getTerminalConfig(Integer id)
   :outertype: TerminalConfigServiceImpl

listTerminalConfig
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<TerminalConfig> listTerminalConfig()
   :outertype: TerminalConfigServiceImpl

