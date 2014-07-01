package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.Widget;

/**
 * The Class WidgetDAOImpl.
 * 
 * Default implementation of WidgetDAO.
 * 
 * @author Rafael Luque (rafael.luque@osoco.es)
 */

@Repository
public class WidgetDAOImpl extends AbstractGenericDAO<Widget> implements
	WidgetDAO {

    /** The logger. */
    static private Logger logger = Logger.getLogger(WidgetDAOImpl.class
	    .getName());

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.WidgetDAO#save(com.ncr.ATMMonitoring.pojo.Widget
     * )
     */
    @Override
    public void save(Widget widget) {
	add(widget);
	logger.debug("Created new Widget with id " + widget.getId());
    }

    /**
     * @see com.ncr.ATMMonitoring.dao.WidgetDAO#update(com.ncr.ATMMonitoring.pojo
     *      .Widget)
     */
    @Override
    public void update(Widget widget) {
	super.update(widget);
	logger.debug("Updated Widget with id " + widget.getId());
    }

    @Override
    public void delete(Widget widget) {
	logger.debug("Going to delete widget with id " + widget.getId());
	super.delete(widget);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.WidgetDAO#findDefaultWidgets()
     */
    @Override
    public List<Widget> findDefaultWidgets() {
	return sessionFactory.getCurrentSession().createCriteria(Widget.class)
		.add(Restrictions.eq("defaultWidget", true))
		.addOrder(Order.asc("title"))
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.WidgetDAO#findById(int)
     */
    @Override
    public Widget findById(int id) {
	return get(id);
    }

}
