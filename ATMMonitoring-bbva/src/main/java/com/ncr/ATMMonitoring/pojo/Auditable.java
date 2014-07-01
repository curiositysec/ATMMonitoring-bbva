package com.ncr.ATMMonitoring.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Domain class for auditable elements related actions
 * 
 * @author jmartin
 * 
 */
@MappedSuperclass
public abstract class Auditable {

    /** The date created */
    @Column(name = "date_created")
    protected Date dateCreated = new Date();

    /** The start date */
    @Column(name = "start_date")
    protected Date startDate;

    /** The end date */
    @Column(name = "end_date")
    protected Date endDate;

    /**
     * Get the date created
     * 
     * @return The date created
     */
    public Date getDateCreated() {
	return dateCreated;
    }

    /**
     * Set the date created
     * 
     * @param dateCreated
     *            The date created
     */
    public void setDateCreated(Date dateCreated) {
	this.dateCreated = dateCreated;
    }

    /**
     * Get the start date
     * 
     * @return The start date
     */
    public Date getStartDate() {
	return startDate;
    }

    /**
     * Set the start date
     * 
     * @param startDate
     *            The start date
     */
    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    /**
     * Get the end date
     * 
     * @return The end date
     */
    public Date getEndDate() {
	return endDate;
    }

    /**
     * Set the end date
     * 
     * @param endDate
     *            The end date
     */
    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    /**
     * Indicate if an auditable element is active by date
     * 
     * @param searchDate
     *            The search date
     * @return True if auditable element is active at the search date. False
     *         otherwhise.
     */
    public boolean isActive(Date searchDate) {
	return isBetweenStartAndEndDate(searchDate == null ? getDefaultDate()
		: searchDate);
    }

    /**
     * Indicate if an auditable element exists by date
     * 
     * @param searchDate
     *            The search date
     * @return True if auditable element exists at the search date. False
     *         otherwhise.
     */
    public boolean exists(Date searchDate) {
	return (searchDate == null) ? true
		: isGreaterOrEqualsThanStartDate(searchDate);
    }

    /**
     * Indicate if start and end date are between the search date
     * 
     * @param searchDate
     *            The search date
     * @return True if start and end date are between the search date. False
     *         otherwhise.
     */
    private boolean isBetweenStartAndEndDate(Date searchDate) {
	return isGreaterOrEqualsThanStartDate(searchDate)
		&& isLowerThanEndDate(searchDate);
    }

    /**
     * Indicate if a search date is greater or equals than auditable element
     * start date.
     * 
     * @param searchDate
     *            The search date
     * @return True if the search date is greater or equals than auditable
     *         element start date. False otherwhise.
     */
    private boolean isGreaterOrEqualsThanStartDate(Date searchDate) {
	return startDate == null || searchDate.compareTo(startDate) >= 0;
    }

    /**
     * Indicate if a search date is lower than auditable element end date.
     * 
     * @param searchDate
     *            The search date
     * @return True if the search date is lower than auditable element end date.
     *         False otherwhise.
     */
    private boolean isLowerThanEndDate(Date searchDate) {
	return endDate == null || searchDate.compareTo(endDate) < 0;
    }

    /**
     * Get the default date
     * 
     * @return The default date
     */
    public static Date getDefaultDate() {
	return new Date();
    }
}
