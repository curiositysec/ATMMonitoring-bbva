.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.JxfsComponent

.. java:import:: com.ncr ATMMonitoring.pojo.XfsComponent

XfsComponentService
===================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface XfsComponentService

   The Interface XfsComponentService. It contains the xfs/jxfs component related methods.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addJxfsComponent
^^^^^^^^^^^^^^^^

.. java:method:: public void addJxfsComponent(JxfsComponent jxfsComponent)
   :outertype: XfsComponentService

   Adds the jxfs component.

   :param jxfsComponent: the jxfs component

addXfsComponent
^^^^^^^^^^^^^^^

.. java:method:: public void addXfsComponent(XfsComponent xfsComponent)
   :outertype: XfsComponentService

   Adds the xfs component.

   :param xfsComponent: the xfs component

getJxfsComponent
^^^^^^^^^^^^^^^^

.. java:method:: public JxfsComponent getJxfsComponent(Integer id)
   :outertype: XfsComponentService

   Gets the jxfs component by its id.

   :param id: the jxfs component id
   :return: the jxfs component

getXfsComponent
^^^^^^^^^^^^^^^

.. java:method:: public XfsComponent getXfsComponent(Integer id)
   :outertype: XfsComponentService

   Gets the xfs component by its id.

   :param id: the xfs component id
   :return: the xfs component

listJxfsComponents
^^^^^^^^^^^^^^^^^^

.. java:method:: public List<JxfsComponent> listJxfsComponents()
   :outertype: XfsComponentService

   List jxfs components.

   :return: the jxfs component list

listXfsComponents
^^^^^^^^^^^^^^^^^

.. java:method:: public List<XfsComponent> listXfsComponents()
   :outertype: XfsComponentService

   List xfs components.

   :return: the xfs component list

