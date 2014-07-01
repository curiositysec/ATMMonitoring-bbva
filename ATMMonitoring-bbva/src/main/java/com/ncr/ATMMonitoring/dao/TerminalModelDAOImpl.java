package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.TerminalModel;

/**
 * The Class TerminalModelDAOImpl.
 * 
 * Default implementation of TerminalModelDAO.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class TerminalModelDAOImpl extends AbstractGenericDAO<TerminalModel>
	implements TerminalModelDAO {

    /** The logger. */
    static private Logger logger = Logger.getLogger(TerminalModelDAOImpl.class
	    .getName());

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.TerminalModelDAO#addTerminalModel(com.ncr.
     * ATMMonitoring.pojo.TerminalModel)
     */
    @Override
    public void addTerminalModel(TerminalModel terminalModel) {
	add(terminalModel);
	logger.debug("Created new Terminal Model with id "
		+ terminalModel.getId());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.TerminalModelDAO#getTerminalModel(java.lang
     * .Integer)
     */
    @Override
    public TerminalModel getTerminalModel(Integer id) {
	return get(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.TerminalModelDAO#listTerminalModels()
     */
    @Override
    public List<TerminalModel> listTerminalModels() {
	return list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.TerminalModelDAO#updateTerminalModel(com.ncr
     * .ATMMonitoring.pojo.TerminalModel)
     */
    @Override
    public void updateTerminalModel(TerminalModel terminalModel) {
	update(terminalModel);
	logger.info("Updated Terminal Model with id " + terminalModel.getId());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.TerminalModelDAO#removeTerminalModel(java.lang
     * .Integer)
     */
    @Override
    public void removeTerminalModel(Integer id) {
	delete(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.TerminalModelDAO#getTerminalModelByModel(java
     * .lang.String)
     */
    @Override
    public TerminalModel getTerminalModelByModel(String model) {
	return (TerminalModel) sessionFactory.getCurrentSession()
		.createCriteria(TerminalModel.class)
		.add(Restrictions.eq("model", model)).uniqueResult();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.TerminalModelDAO#getTerminalModelByProductClass
     * (java.lang.String)
     */
    @Override
    public TerminalModel getTerminalModelByProductClass(String productClass) {
	return (TerminalModel) sessionFactory.getCurrentSession()
		.createCriteria(TerminalModel.class)
		.add(Restrictions.eq("productClass", productClass))
		.uniqueResult();
    }
}