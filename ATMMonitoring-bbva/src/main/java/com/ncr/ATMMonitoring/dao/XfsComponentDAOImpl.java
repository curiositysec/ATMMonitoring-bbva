package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.XfsComponent;

/**
 * The Class XfsComponentDAOImpl.
 * 
 * Default implementation of XfsComponentDAO.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class XfsComponentDAOImpl extends AbstractGenericDAO<XfsComponent>
	implements XfsComponentDAO {

    /** The logger. */
    static private Logger logger = Logger.getLogger(XfsComponentDAOImpl.class
	    .getName());

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.XfsComponentDAO#addXfsComponent(com.ncr.
     * ATMMonitoring.pojo.XfsComponent)
     */
    @Override
    public void addXfsComponent(XfsComponent xfsComponent) {
	add(xfsComponent);
	logger.debug("Created new Xfs Component with id "
		+ xfsComponent.getId());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.XfsComponentDAO#listXfsComponents()
     */
    @Override
    public List<XfsComponent> listXfsComponents() {
	return list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.XfsComponentDAO#getXfsComponent(java.lang.Integer
     * )
     */
    @Override
    public XfsComponent getXfsComponent(Integer id) {
	return get(id);
    }
}