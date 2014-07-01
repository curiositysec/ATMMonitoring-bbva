package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.hibernate.type.Type;

import com.ncr.ATMMonitoring.pojo.Ups;

/**
 * The Interface UpsDAO.
 * 
 * Dao with the operations for managing Ups Pojos.
 * 
 * @author Otto Abreu
 * 
 */
public interface UpsDAO {

    /**
     * Returns the UPS that matches the given id
     * 
     * @param id
     *            the id of the UPS we want to retrieve
     */
    public Ups getUps(int id);

    /**
     * Removes from the DB the UPS that matches with the given id
     * 
     * @param id
     *            the id of the UPS we want to delete
     */
    public void removeUps(int id);

    /**
     * Updates the data of an UPS
     * 
     * @param ups
     *            the UPS to update
     */
    public void updateUps(Ups ups);

    /**
     * Returns all the ups from the DB with the default ordering and sorting
     * 
     * @return a list with all the UPS stored
     */
    public List<Ups> listAllUps();

    /**
     * Adds a new Ups to the database
     * 
     * @param ups
     *            the UPS to add
     */
    public void addUps(Ups ups);

    /**
     * Returns a Ups by the given series number
     * 
     * @param seriesNumber
     *            the series number to search for
     * @return the UPS that matches the given parameters, or null if it can't be
     *         found
     */
    public Ups getUpsBySerialNumber(String seriesNumber);

    /**
     * 
     * Returns a Ups by the given series number and model
     * 
     * @param seriesNumber
     *            the series number to search for
     * @param model
     *            the model to search for
     * 
     * @return the UPS that matches the given parameters, or null if it can't be
     *         found
     */
    public Ups getUpsBySerialNumberAndModel(String seriesNumber, String model);

    /**
     * Lists all UPS with a specific order and sorting.
     * 
     * @param sort
     *            the sort
     * @param order
     *            the order
     * @return the list
     */
    public List<Ups> listUps(String sort, String order);

    /**
     * Gets the UPS's by HQL. Used for the query engine.
     * 
     * @param values
     *            the values of the HQL parameters
     * @param types
     *            the types of the HQL parameters
     * @param hql
     *            the HQL itself
     * @return the UPS's that fulfill the HQL
     */
    public List<Ups> getUpsByHQL(List<Object> values, List<Type> types,
	    String hql);

    /**
     * Gets the UPS's by HQL with a specific order and sorting. Used for the
     * query engine.
     * 
     * @param values
     *            the values of the HQL parameters
     * @param types
     *            the types of the HQL parameters
     * @param hql
     *            the HQL itself
     * @param sort
     *            the sort
     * @param order
     *            the order
     * @return the UPS's that fulfill the HQL
     */
    public List<Ups> getUpsByHQL(List<Object> values, List<Type> types,
	    String hql, String sort, String order);

}
