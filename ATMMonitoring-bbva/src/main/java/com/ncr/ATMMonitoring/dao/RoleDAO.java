package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Role;

/**
 * The Interface RoleDAO.
 * 
 * Dao with the operations for managing Role Pojos.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface RoleDAO {

    /**
     * Adds the role.
     * 
     * @param role
     *            the role
     */
    public void addRole(Role role);

    /**
     * Updates the role.
     * 
     * @param role
     *            the role
     */
    public void updateRole(Role role);

    /**
     * Delete role.
     * 
     * @param role
     *            the role
     */
    public void deleteRole(Role role);

    /**
     * Gets the role with the given id.
     * 
     * @param id
     *            the id
     * @return the role, or null if it doesn't exist
     */
    public Role getRole(Integer id);

    /**
     * Gets the role with the given name.
     * 
     * @param name
     *            the name
     * @return the role, or null if it doesn't exist
     */
    public Role getRoleByName(String name);

    /**
     * Lists all roles.
     * 
     * @return the list
     */
    public List<Role> listRoles();

    /**
     * List manageable roles.
     * 
     * @return the list
     */
    public List<Role> listManageableRoles();

    /**
     * List sorted manageable roles.
     * 
     * @param sort
     *            the sort
     * @param order
     *            the order
     * 
     * @return the list
     */
    public List<Role> listManageableRoles(String order, String sort);

    /**
     * Removes the role with the given id.
     * 
     * @param id
     *            the id
     */
    public void removeRole(Integer id);
    
    /**
     * Gets the role with the given id.
     * 
     * @param id
     *            the id
     * @return the role, or null if it doesn't exist
     */
    public Role getRoleById(Integer id);
    
}
