package com.ncr.ATMMonitoring.service;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.Role;

/**
 * The Interface RoleService.
 * 
 * It contains the role related methods.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface RoleService {

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
    public void deleteRole(Role query);

    /**
     * Gets the role by its id.
     * 
     * @param id
     *            the role id
     * @return the role
     */
    public Role getRole(Integer id);

    /**
     * Gets the role by its name.
     * 
     * @param name
     *            the role name
     * @return the role
     */
    public Role getRoleByName(String name);

    /**
     * List roles.
     * 
     * @return the role list
     */
    public List<Role> listRoles();

    /**
     * List manageable roles.
     * 
     * @return the role list
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
     * @return the role list
     */
    public List<Role> listManageableRoles(String sort, String order);

    /**
     * Removes the role by its id.
     * 
     * @param id
     *            the role id
     */
    public void removeRole(Integer id);

    /**
     * Gets the role by its id.
     * 
     * @param id
     *            the role id
     * @return the role
     */
	public Role getRoleById(Integer id);
}