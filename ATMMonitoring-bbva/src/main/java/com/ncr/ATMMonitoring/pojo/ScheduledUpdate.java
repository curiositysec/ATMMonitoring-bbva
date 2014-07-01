package com.ncr.ATMMonitoring.pojo;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Formula;

/**
 * The ScheduledUpdate Pojo.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "scheduled_updates", uniqueConstraints = {
	@UniqueConstraint(columnNames = { "month_day", "hours", "minutes" }),
	@UniqueConstraint(columnNames = { "week_day", "hours", "minutes" }) })
public class ScheduledUpdate {

    /** The logger. */
    static private Logger logger = Logger.getLogger(ScheduledUpdate.class
	    .getName());

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scheduled_updates_id_seq")
    @SequenceGenerator(name = "scheduled_updates_id_seq", sequenceName = "scheduled_updates_id_seq", allocationSize = 1)
    private Integer id;

    /** The week day. */
    @Column(name = "week_day")
    @Min(0)
    @Max(6)
    private Short weekDay = null;

    /** The month day. */
    @Column(name = "month_day")
    @Min(1)
    @Max(31)
    private Short monthDay = null;

    /** The hour. */
    @Column(name = "hours")
    @Min(0)
    @Max(23)
    private Short hour = 0;

    /** The minute. */
    @Column(name = "minutes")
    @Min(0)
    @Max(59)
    private Short minute = 0;

    /** The time zone. */
    @Column(name = "time_zone")
    @Min(-12)
    @Max(12)
    private Short timeZone = new Double(
	    TimeZone.getDefault().getRawOffset() / (3600000)).shortValue();

    /** The gmt hour. */
    @Formula("(hours - time_zone + 24) % 24")
    private Short gmtHour;

    /** The gmt week day. */
    @Formula("((week_day + 7 + floor((hours - time_zone) / 24.0) - 1) % 7) + 1")
    private Short gmtWeekDay;

    /** The gmt month day. */
    @Formula("((month_day + 30 + floor((hours - time_zone) / 24.0) - 1) % 30) + 1")
    private Short gmtMonthDay;

    /** The name. */
    @Column(name = "name", length = 50)
    private String name;

    /** The description. */
    @Column(name = "description", length = 200)
    private String description;

    /** The start date. */
    @Column(name = "start_date")
    private Date startDate;

    /** The query. */
    @ManyToOne
    @JoinColumn(name = "query_id")
    private Query query;

    /**
     * Gets the id.
     * 
     * @return the id
     */
    public Integer getId() {
	return id;
    }

    /**
     * Sets the id.
     * 
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
	this.id = id;
    }

    /**
     * Gets the week day.
     * 
     * @return the weekDay
     */
    public Short getWeekDay() {
	return weekDay;
    }

    /**
     * Sets the week day.
     * 
     * @param weekDay
     *            the weekDay to set
     */
    public void setWeekDay(Short weekDay) {
	this.weekDay = weekDay;
    }

    /**
     * Gets the month day.
     * 
     * @return the monthDay
     */
    public Short getMonthDay() {
	return monthDay;
    }

    /**
     * Sets the month day.
     * 
     * @param monthDay
     *            the monthDay to set
     */
    public void setMonthDay(Short monthDay) {
	this.monthDay = monthDay;
    }

    /**
     * Gets the hour.
     * 
     * @return the hour
     */
    public Short getHour() {
	return hour;
    }

    /**
     * Sets the hour.
     * 
     * @param hour
     *            the hour to set
     */
    public void setHour(Short hour) {
	this.hour = hour;
    }

    /**
     * Gets the minute.
     * 
     * @return the minute
     */
    public Short getMinute() {
	return minute;
    }

    /**
     * Sets the minute.
     * 
     * @param minute
     *            the minute to set
     */
    public void setMinute(Short minute) {
	this.minute = minute;
    }

    /**
     * Gets the query.
     * 
     * @return the query
     */
    public Query getQuery() {
	return query;
    }

    /**
     * Sets the query.
     * 
     * @param query
     *            the new query
     */
    public void setQuery(Query query) {
	this.query = query;
    }

    /**
     * Checks if is weekly.
     * 
     * @return true, if is weekly
     */
    public boolean isWeekly() {
	return (monthDay == null);
    }

    /**
     * Gets the event dates.
     * 
     * @param fromUnixTime
     *            the from unix time
     * @param toUnixTime
     *            the to unix time
     * @return the event dates
     */
    public List<Date> getEventDates(long fromUnixTime, long toUnixTime) {
	List<Date> events = new ArrayList();
	Date fromDate = new Date(fromUnixTime * 1000L);
	Date toDate = new Date(toUnixTime * 1000L);
	logger.debug("fromDate: " + fromDate + ", toDate: " + toDate);
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(fromDate);
	calendar.set(Calendar.HOUR_OF_DAY, hour);
	calendar.set(Calendar.MINUTE, minute);

	if (isWeekly()) {
	    calendar.set(Calendar.DAY_OF_WEEK, weekDay);
	} else {
	    calendar.set(Calendar.DAY_OF_MONTH, monthDay);
	    Date event = calendar.getTime();
	    if (event.getTime() < fromDate.getTime()) {
		calendar.add(Calendar.MONTH, 1);
	    }
	}

	while (calendar.getTime().getTime() < toDate.getTime()) {
	    Date event = calendar.getTime();
	    events.add(event);
	    if (isWeekly()) {
		calendar.add(Calendar.DAY_OF_MONTH, 7);
	    } else {
		calendar.add(Calendar.MONTH, 1);
	    }
	}

	return events;
    }

    /**
     * Gets the complete hour.
     * 
     * @return the complete hour
     */
    public String getCompleteHour() {
	String completeHour = "";
	if (hour < 10) {
	    completeHour += "0";
	}
	completeHour += hour.toString() + ":";
	if (minute < 10) {
	    completeHour += "0";
	}
	completeHour += minute.toString();
	return completeHour;
    }

    /**
     * Gets the time zone.
     * 
     * @return the time zone
     */
    public Short getTimeZone() {
	return timeZone;
    }

    /**
     * Gets the time zone name.
     * 
     * @return the time zone name
     */
    public String getTimeZoneName() {
	String name = "GMT ";
	if (timeZone > 0) {
	    name += "+";
	}
	return (name + timeZone);
    }

    /**
     * Sets the time zone.
     * 
     * @param timeZone
     *            the new time zone
     */
    public void setTimeZone(Short timeZone) {
	this.timeZone = timeZone;
    }

    /**
     * Gets the hour translated to GMT time.
     * 
     * @return the GMT hour
     */
    public Short getGmtHour() {
	return gmtHour;
    }

    /**
     * Sets the GMT hour.
     * 
     * @param gmtHour
     *            the new GMT hour
     */
    public void setGmtHour(Short gmtHour) {
	this.gmtHour = gmtHour;
    }

    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * Sets the name.
     * 
     * @param name
     *            the new name
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Gets the description.
     * 
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /**
     * Sets the description.
     * 
     * @param description
     *            the new description
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * Gets the start date.
     * 
     * @return the start date
     */
    public Date getStartDate() {
	return startDate;
    }

    /**
     * Gets the start date short.
     * 
     * @return the start date short
     */
    public String getStartDateShort() {
	return (startDate != null) ? DateFormat.getDateInstance(
		DateFormat.SHORT, Locale.getDefault()).format(startDate) : "";
    }

    /**
     * Sets the start date.
     * 
     * @param startDate
     *            the new start date
     */
    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    /**
     * Gets the week day translated to GMT time.
     * 
     * @return the GMT week day
     */
    public Short getGmtWeekDay() {
	return gmtWeekDay;
    }

    /**
     * Sets the GMT week day.
     * 
     * @param gmtWeekDay
     *            the new GMT week day
     */
    public void setGmtWeekDay(Short gmtWeekDay) {
	this.gmtWeekDay = gmtWeekDay;
    }

    /**
     * Gets the month day translated to GMT time.
     * 
     * @return the GMT month day
     */
    public Short getGmtMonthDay() {
	return gmtMonthDay;
    }

    /**
     * Sets the month day translated to GMT time.
     * 
     * @param gmtMonthDay
     *            the new GMT month day
     */
    public void setGmtMonthDay(Short gmtMonthDay) {
	this.gmtMonthDay = gmtMonthDay;
    }
}