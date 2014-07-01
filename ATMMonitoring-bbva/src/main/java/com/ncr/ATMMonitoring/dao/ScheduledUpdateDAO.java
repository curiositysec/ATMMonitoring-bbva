package com.ncr.ATMMonitoring.dao;

import java.util.Calendar;
import java.util.List;

import com.ncr.ATMMonitoring.pojo.ScheduledUpdate;

/**
 * The Interface ScheduledUpdateDAO.
 * 
 * Dao with the operations for managing ScheduledUpdate Pojos.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface ScheduledUpdateDAO {

    /**
     * Adds the scheduled update.
     * 
     * @param scheduledUpdate
     *            the scheduled update
     */
    public void addScheduledUpdate(ScheduledUpdate scheduledUpdate);

    /**
     * Lists all monthly scheduled updates.
     * 
     * @return the list
     */
    public List<ScheduledUpdate> listMonthlyScheduledUpdates();

    /**
     * Lists all weekly scheduled updates.
     * 
     * @return the list
     */
    public List<ScheduledUpdate> listWeeklyScheduledUpdates();

    /**
     * Gets the scheduled update with the given id.
     * 
     * @param id
     *            the id
     * @return the scheduled update, or null if it doesn't exist
     */
    public ScheduledUpdate getScheduledUpdate(Integer id);

    /**
     * Removes the scheduled update with the given id.
     * 
     * @param id
     *            the id
     */
    public void removeScheduledUpdate(Integer id);

    /**
     * Lists all valid scheduled updates.
     * 
     * @param date
     *            the date
     * @return the list
     */
    public List<ScheduledUpdate> listValidScheduledUpdates(Calendar date);

    /**
     * Checks whether a monthly scheduled update already exists.
     * 
     * @param scheduledUpdate
     *            the scheduled update
     * @return true if it does exist
     */
    public boolean existsMonthlyScheduledUpdate(ScheduledUpdate scheduledUpdate);

    /**
     * Checks whether a weekly scheduled update already exists.
     * 
     * @param scheduledUpdate
     *            the scheduled update
     * @return true if it does exist
     */
    public boolean existsWeeklyScheduledUpdate(ScheduledUpdate scheduledUpdate);
}
