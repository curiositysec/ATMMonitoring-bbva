package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.Role;

/**
 * The Class RoleDAOImpl.
 * 
 * Default implementation of RoleDAO.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class RoleDAOImpl extends AbstractGenericDAO<Role> implements RoleDAO {

    /** The logger. */
    static private Logger logger = Logger
	    .getLogger(RoleDAOImpl.class.getName());

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.RoleDAO#addRole(com.ncr.ATMMonitoring.pojo.
     * Role)
     */
    @Override
    public void addRole(Role role) {
	add(role);
	logger.debug("Created new Role with id " + role.getId());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.RoleDAO#updateRole(com.ncr.ATMMonitoring.pojo
     * .Role)
     */
    @Override
    public void updateRole(Role role) {
	update(role);
	logger.info("Updated Role with id " + role.getId() + " and name "
		+ role.getName());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.RoleDAO#deleteRole(com.ncr.ATMMonitoring.pojo
     * .Role)
     */
    @Override
    public void deleteRole(Role role) {
	delete(role);
	logger.debug("Deleted Role with id " + role.getId());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.RoleDAO#getRole(java.lang.Integer)
     */
    @Override
    public Role getRole(Integer id) {
    	return get(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.RoleDAO#getRoleByName(java.lang.String)
     */
    @Override
    public Role getRoleByName(String name) {
	Role result = (Role) sessionFactory.getCurrentSession()
		.createCriteria(Role.class).add(Restrictions.eq("name", name))
		.setMaxResults(1).uniqueResult();
	return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.RoleDAO#listRoles()
     */
    @Override
    public List<Role> listRoles() {
	return list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.RoleDAO#listManageableRoles()
     */
    @Override
    public List<Role> listManageableRoles() {
	return sessionFactory.getCurrentSession().createCriteria(Role.class)
		.add(Restrictions.eq("manageable", true))
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.RoleDAO#listManageableRoles(java.lang.String,
     * java.lang.String)
     */
    @Override
    public List<Role> listManageableRoles(String sort, String order) {
		Criteria criteria = sessionFactory.getCurrentSession()
			.createCriteria(Role.class)
			.add(Restrictions.eq("manageable", true));
	
		if ((sort != null) && (order != null)) {
		    if ("asc".equals(order)) {
			criteria.addOrder(Order.asc(sort));
		    } else {
			criteria.addOrder(Order.desc(sort));
		    }
		}
		return criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.RoleDAO#removeRole(java.lang.Integer)
     */
    @Override
    public void removeRole(Integer id) {
	delete(id);
    }

	@Override
	public Role getRoleById(Integer id) {
		// TODO Auto-generated method stub
		Role result = (Role) sessionFactory.getCurrentSession()
				.createCriteria(Role.class).add(Restrictions.eq("id", id))
				.setMaxResults(1).uniqueResult();
		return result;
	}
}