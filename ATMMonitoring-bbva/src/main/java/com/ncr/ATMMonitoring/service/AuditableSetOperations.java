package com.ncr.ATMMonitoring.service;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import com.ncr.ATMMonitoring.pojo.Auditable;

/**
 * The auditable set operations interface
 * 
 * It contains the auditable set operations related actions
 * 
 * @author Julián Martín
 * 
 */
public interface AuditableSetOperations {

    /**
     * Build the auditable changes map for a collection
     * 
     * @param auditableElements
     *            The collection of auditable elements
     * @return The auditable changes map
     */
    public Map<Date, Integer> buildAuditableChangesForCollection(
	    Set<? extends Auditable> auditableElements);

    /**
     * Get the current auditable element by date
     * 
     * @param auditableElements
     *            The auditable elements collection
     * @param date
     *            The date
     * @return The current auditable element by date
     */
    public <T extends Auditable> T getCurrentAuditableElementByDate(
	    Set<T> auditableElements, Date date);

    /**
     * Get the current auditable element
     * 
     * @param auditableElements
     *            The auditable elements collection
     * @return The current auditable element
     */
    public <T extends Auditable> T getCurrentAuditable(Set<T> auditableElements);

    /**
     * Get the created auditable elementes by date
     * 
     * @param auditableElements
     *            The auditable elements
     * @param date
     *            The date
     * @return The collection of auditable elements
     */
    public <T extends Auditable> Set<T> getCreatedAuditableElementsByDate(
	    Set<T> auditableElements, Date date);

    /**
     * Get the active auditable elements by date
     * 
     * @param auditableElements
     *            The collecton of auditable elements
     * @param date
     *            The date
     * @return The collection of auditable elements active by date
     */
    public <T extends Auditable> Set<T> getActiveAuditableElementsByDate(
	    Set<T> auditableElements, Date date);

    /**
     * Set the current auditable element
     * 
     * @param auditableElements
     *            The collection of auditable elements
     * @param newauditableElement
     *            The new auditableElement
     */
    public <T extends Auditable> void setCurrentAuditableElement(
	    Set<T> auditableElements, T newauditableElement);

    /**
     * Updates a collection of auditable elements. Adds new elements to first
     * collection and set end date to elements that are not present on second
     * collection.
     * 
     * @param auditableElements
     *            The current collection of auditable elements
     * @param newAuditableElements
     *            The new collection of auditables elements
     */
    public <T extends Auditable> void updateAuditableElements(
	    Set<T> auditableElements, Set<T> newAuditableElements);
}
