.. java:import:: java.text DateFormat

.. java:import:: java.util ArrayList

.. java:import:: java.util Calendar

.. java:import:: java.util Date

.. java:import:: java.util List

.. java:import:: java.util Locale

.. java:import:: java.util TimeZone

.. java:import:: javax.persistence Column

.. java:import:: javax.persistence Entity

.. java:import:: javax.persistence GeneratedValue

.. java:import:: javax.persistence GenerationType

.. java:import:: javax.persistence Id

.. java:import:: javax.persistence JoinColumn

.. java:import:: javax.persistence ManyToOne

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

.. java:import:: javax.persistence UniqueConstraint

.. java:import:: javax.validation.constraints Max

.. java:import:: javax.validation.constraints Min

.. java:import:: org.apache.log4j Logger

.. java:import:: org.hibernate.annotations Formula

ScheduledUpdate
===============

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class ScheduledUpdate

   The ScheduledUpdate Pojo.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
getCompleteHour
^^^^^^^^^^^^^^^

.. java:method:: public String getCompleteHour()
   :outertype: ScheduledUpdate

   Gets the complete hour.

   :return: the complete hour

getDescription
^^^^^^^^^^^^^^

.. java:method:: public String getDescription()
   :outertype: ScheduledUpdate

   Gets the description.

   :return: the description

getEventDates
^^^^^^^^^^^^^

.. java:method:: public List<Date> getEventDates(long fromUnixTime, long toUnixTime)
   :outertype: ScheduledUpdate

   Gets the event dates.

   :param fromUnixTime: the from unix time
   :param toUnixTime: the to unix time
   :return: the event dates

getGmtHour
^^^^^^^^^^

.. java:method:: public Short getGmtHour()
   :outertype: ScheduledUpdate

   Gets the hour translated to GMT time.

   :return: the GMT hour

getGmtMonthDay
^^^^^^^^^^^^^^

.. java:method:: public Short getGmtMonthDay()
   :outertype: ScheduledUpdate

   Gets the month day translated to GMT time.

   :return: the GMT month day

getGmtWeekDay
^^^^^^^^^^^^^

.. java:method:: public Short getGmtWeekDay()
   :outertype: ScheduledUpdate

   Gets the week day translated to GMT time.

   :return: the GMT week day

getHour
^^^^^^^

.. java:method:: public Short getHour()
   :outertype: ScheduledUpdate

   Gets the hour.

   :return: the hour

getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: ScheduledUpdate

   Gets the id.

   :return: the id

getMinute
^^^^^^^^^

.. java:method:: public Short getMinute()
   :outertype: ScheduledUpdate

   Gets the minute.

   :return: the minute

getMonthDay
^^^^^^^^^^^

.. java:method:: public Short getMonthDay()
   :outertype: ScheduledUpdate

   Gets the month day.

   :return: the monthDay

getName
^^^^^^^

.. java:method:: public String getName()
   :outertype: ScheduledUpdate

   Gets the name.

   :return: the name

getQuery
^^^^^^^^

.. java:method:: public Query getQuery()
   :outertype: ScheduledUpdate

   Gets the query.

   :return: the query

getStartDate
^^^^^^^^^^^^

.. java:method:: public Date getStartDate()
   :outertype: ScheduledUpdate

   Gets the start date.

   :return: the start date

getStartDateShort
^^^^^^^^^^^^^^^^^

.. java:method:: public String getStartDateShort()
   :outertype: ScheduledUpdate

   Gets the start date short.

   :return: the start date short

getTimeZone
^^^^^^^^^^^

.. java:method:: public Short getTimeZone()
   :outertype: ScheduledUpdate

   Gets the time zone.

   :return: the time zone

getTimeZoneName
^^^^^^^^^^^^^^^

.. java:method:: public String getTimeZoneName()
   :outertype: ScheduledUpdate

   Gets the time zone name.

   :return: the time zone name

getWeekDay
^^^^^^^^^^

.. java:method:: public Short getWeekDay()
   :outertype: ScheduledUpdate

   Gets the week day.

   :return: the weekDay

isWeekly
^^^^^^^^

.. java:method:: public boolean isWeekly()
   :outertype: ScheduledUpdate

   Checks if is weekly.

   :return: true, if is weekly

setDescription
^^^^^^^^^^^^^^

.. java:method:: public void setDescription(String description)
   :outertype: ScheduledUpdate

   Sets the description.

   :param description: the new description

setGmtHour
^^^^^^^^^^

.. java:method:: public void setGmtHour(Short gmtHour)
   :outertype: ScheduledUpdate

   Sets the GMT hour.

   :param gmtHour: the new GMT hour

setGmtMonthDay
^^^^^^^^^^^^^^

.. java:method:: public void setGmtMonthDay(Short gmtMonthDay)
   :outertype: ScheduledUpdate

   Sets the month day translated to GMT time.

   :param gmtMonthDay: the new GMT month day

setGmtWeekDay
^^^^^^^^^^^^^

.. java:method:: public void setGmtWeekDay(Short gmtWeekDay)
   :outertype: ScheduledUpdate

   Sets the GMT week day.

   :param gmtWeekDay: the new GMT week day

setHour
^^^^^^^

.. java:method:: public void setHour(Short hour)
   :outertype: ScheduledUpdate

   Sets the hour.

   :param hour: the hour to set

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: ScheduledUpdate

   Sets the id.

   :param id: the id to set

setMinute
^^^^^^^^^

.. java:method:: public void setMinute(Short minute)
   :outertype: ScheduledUpdate

   Sets the minute.

   :param minute: the minute to set

setMonthDay
^^^^^^^^^^^

.. java:method:: public void setMonthDay(Short monthDay)
   :outertype: ScheduledUpdate

   Sets the month day.

   :param monthDay: the monthDay to set

setName
^^^^^^^

.. java:method:: public void setName(String name)
   :outertype: ScheduledUpdate

   Sets the name.

   :param name: the new name

setQuery
^^^^^^^^

.. java:method:: public void setQuery(Query query)
   :outertype: ScheduledUpdate

   Sets the query.

   :param query: the new query

setStartDate
^^^^^^^^^^^^

.. java:method:: public void setStartDate(Date startDate)
   :outertype: ScheduledUpdate

   Sets the start date.

   :param startDate: the new start date

setTimeZone
^^^^^^^^^^^

.. java:method:: public void setTimeZone(Short timeZone)
   :outertype: ScheduledUpdate

   Sets the time zone.

   :param timeZone: the new time zone

setWeekDay
^^^^^^^^^^

.. java:method:: public void setWeekDay(Short weekDay)
   :outertype: ScheduledUpdate

   Sets the week day.

   :param weekDay: the weekDay to set

