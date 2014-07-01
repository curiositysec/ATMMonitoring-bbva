.. java:import:: java.util List

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate Criteria

.. java:import:: org.hibernate.criterion Order

.. java:import:: org.hibernate.criterion Restrictions

.. java:import:: org.springframework.stereotype Repository

.. java:import:: com.ncr ATMMonitoring.pojo.Widget

WidgetDAOImpl
=============

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: @Repository public class WidgetDAOImpl extends AbstractGenericDAO<Widget> implements WidgetDAO

   The Class WidgetDAOImpl. Default implementation of WidgetDAO.

   :author: Rafael Luque (rafael.luque@osoco.es)

Methods
-------
delete
^^^^^^

.. java:method:: @Override public void delete(Widget widget)
   :outertype: WidgetDAOImpl

findById
^^^^^^^^

.. java:method:: @Override public Widget findById(int id)
   :outertype: WidgetDAOImpl

findDefaultWidgets
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Widget> findDefaultWidgets()
   :outertype: WidgetDAOImpl

save
^^^^

.. java:method:: @Override public void save(Widget widget)
   :outertype: WidgetDAOImpl

update
^^^^^^

.. java:method:: @Override public void update(Widget widget)
   :outertype: WidgetDAOImpl

