.. java:import:: java.io Serializable

.. java:import:: java.util Date

.. java:import:: java.util HashMap

.. java:import:: java.util Map

.. java:import:: javax.persistence Column

.. java:import:: javax.persistence Entity

.. java:import:: javax.persistence GeneratedValue

.. java:import:: javax.persistence GenerationType

.. java:import:: javax.persistence Id

.. java:import:: javax.persistence JoinColumn

.. java:import:: javax.persistence ManyToOne

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

.. java:import:: com.ncr ATMMonitoring.utils.RegionType

.. java:import:: com.ncr ATMMonitoring.utils.WidgetQueryAssociationType

Widget
======

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class Widget implements Serializable

   The Widget Pojo.

   :author: Rafael Luque (rafael.luque@osoco.es)

Constructors
------------
Widget
^^^^^^

.. java:constructor:: public Widget()
   :outertype: Widget

   Instantiates a new widget.

Widget
^^^^^^

.. java:constructor:: public Widget(Widget source)
   :outertype: Widget

   Instantiates a new widget.

   :param source: the source

Methods
-------
equals
^^^^^^

.. java:method:: @Override public boolean equals(Object o)
   :outertype: Widget

getCategory
^^^^^^^^^^^

.. java:method:: public WidgetCategory getCategory()
   :outertype: Widget

getChartType
^^^^^^^^^^^^

.. java:method:: public ChartType getChartType()
   :outertype: Widget

   Gets the chart type.

   :return: the chart type

getDashboard
^^^^^^^^^^^^

.. java:method:: public Dashboard getDashboard()
   :outertype: Widget

   Gets the dashboard.

   :return: the dashboard

getGroupBy
^^^^^^^^^^

.. java:method:: public String getGroupBy()
   :outertype: Widget

   Gets the group by.

   :return: the group by

getGroupByEntity
^^^^^^^^^^^^^^^^

.. java:method:: public WidgetQueryAssociationType getGroupByEntity()
   :outertype: Widget

   Gets the group by entity.

   :return: the group by entity

getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: Widget

   Gets the id.

   :return: the id

getOrder
^^^^^^^^

.. java:method:: public Integer getOrder()
   :outertype: Widget

   Gets the order.

   :return: the order

getOwner
^^^^^^^^

.. java:method:: public User getOwner()
   :outertype: Widget

   Gets the owner.

   :return: the owner

getQuery
^^^^^^^^

.. java:method:: public Query getQuery()
   :outertype: Widget

   Gets the query.

   :return: the query

getQueryDate
^^^^^^^^^^^^

.. java:method:: public Date getQueryDate()
   :outertype: Widget

getRegion
^^^^^^^^^

.. java:method:: public RegionType getRegion()
   :outertype: Widget

getTitle
^^^^^^^^

.. java:method:: public String getTitle()
   :outertype: Widget

   Gets the title.

   :return: the title

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: Widget

isDefaultWidget
^^^^^^^^^^^^^^^

.. java:method:: public boolean isDefaultWidget()
   :outertype: Widget

   Checks if is default widget.

   :return: true, if is default widget

isLibraryWidget
^^^^^^^^^^^^^^^

.. java:method:: public boolean isLibraryWidget()
   :outertype: Widget

isVisible
^^^^^^^^^

.. java:method:: public boolean isVisible()
   :outertype: Widget

   Checks if is visible.

   :return: true, if is visible

setCategory
^^^^^^^^^^^

.. java:method:: public void setCategory(WidgetCategory category)
   :outertype: Widget

setChartType
^^^^^^^^^^^^

.. java:method:: public void setChartType(ChartType chartType)
   :outertype: Widget

   Sets the chart type.

   :param chartType: the new chart type

setDashboard
^^^^^^^^^^^^

.. java:method:: public void setDashboard(Dashboard dashboard)
   :outertype: Widget

   Sets the dashboard.

   :param dashboard: the new dashboard

setDefaultWidget
^^^^^^^^^^^^^^^^

.. java:method:: public void setDefaultWidget(boolean defaultWidget)
   :outertype: Widget

   Sets the default widget.

   :param defaultWidget: the new default widget

setGroupBy
^^^^^^^^^^

.. java:method:: public void setGroupBy(String groupBy)
   :outertype: Widget

   Sets the group by.

   :param groupBy: the new group by

setGroupByEntity
^^^^^^^^^^^^^^^^

.. java:method:: public void setGroupByEntity(WidgetQueryAssociationType groupByEntity)
   :outertype: Widget

   Sets the group by entity.

   :param groupByEntity: the new group by entity

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: Widget

   Sets the id.

   :param id: the new id

setOrder
^^^^^^^^

.. java:method:: public void setOrder(Integer order)
   :outertype: Widget

   Sets the order.

   :param order: the new order

setOwner
^^^^^^^^

.. java:method:: public void setOwner(User owner)
   :outertype: Widget

   Sets the owner.

   :param owner: the new owner

setQuery
^^^^^^^^

.. java:method:: public void setQuery(Query query)
   :outertype: Widget

   Sets the query.

   :param query: the new query

setQueryDate
^^^^^^^^^^^^

.. java:method:: public void setQueryDate(Date queryDate)
   :outertype: Widget

setRegion
^^^^^^^^^

.. java:method:: public void setRegion(RegionType region)
   :outertype: Widget

setTitle
^^^^^^^^

.. java:method:: public void setTitle(String title)
   :outertype: Widget

   Sets the title.

   :param title: the new title

setVisible
^^^^^^^^^^

.. java:method:: public void setVisible(boolean visible)
   :outertype: Widget

   Sets the visible.

   :param visible: the new visible

toJSON
^^^^^^

.. java:method:: public Map<String, Object> toJSON()
   :outertype: Widget

   To json.

   :return: the map

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: Widget

