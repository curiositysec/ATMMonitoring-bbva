package com.ncr.ATMMonitoring.dao;

import java.util.List;
import java.util.Set;

import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.User;

/**
 * The Interface UserDAO.
 * 
 * Dao with the operations for managing User Pojos.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface UserDAO {

    /**
     * Adds the user.
     * 
     * @param user
     *            the user
     */
    public void addUser(User user);

    /**
     * Update user.
     * 
     * @param user
     *            the user
     */
    public void updateUser(User user);

    /**
     * Lists all users for the given bank companies.
     * 
     * @param bank
     *            the bank companies
     * @return the list
     */
    public List<User> listUsersByBankCompanies(Set<BankCompany> bank);

    /**
     * List all users for the given bank company.
     * 
     * @param bank
     *            the bank company
     * @return the list
     */
    public List<User> listUsersByBankCompany(BankCompany bank);

    /**
     * Lists all users with the default sorting.
     * 
     * @return the list
     */
    public List<User> listUsers();

    /**
     * Lists all users.
     * 
     * @param sort
     *            the sort
     * @param order
     *            the order
     * 
     * @return the list
     */
    public List<User> listUsers(String order, String sort);

    /**
     * Gets the user with the given id.
     * 
     * @param id
     *            the id
     * @return the user, or null if it doesn't exist
     */
    public User getUser(Integer id);

    /**
     * Removes the user with the given id.
     * 
     * @param id
     *            the id
     */
    public void removeUser(Integer id);

    /**
     * Gets the user by username.
     * 
     * @param username
     *            the username
     * @return the user by username, or null if it doesn't exist
     */
    public User getUserByUsername(String username);
    
    /**
     * Get the user by username for loops
     * 
     * @param username
     * 			  the username
     * @return the user by username or null if it doesn't exist
     */
    public User getUserByUsernameLoop(String username);

}
