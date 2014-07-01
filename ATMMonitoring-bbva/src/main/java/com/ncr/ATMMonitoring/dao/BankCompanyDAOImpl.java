package com.ncr.ATMMonitoring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ncr.ATMMonitoring.pojo.BankCompany;

/**
 * The Class BankCompanyDAOImpl.
 * 
 * Default implementation of BankCompanyDAO.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Repository
public class BankCompanyDAOImpl extends AbstractGenericDAO<BankCompany>
	implements BankCompanyDAO {

    /** The logger. */
    static private Logger logger = Logger.getLogger(BankCompanyDAOImpl.class
	    .getName());

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.BankCompanyDAO#addBankCompany(com.ncr.ATMMonitoring
     * .pojo.BankCompany)
     */
    @Override
    public void addBankCompany(BankCompany bank) {
	add(bank);
	logger.debug("Created new Bank Company with id " + bank.getId());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.BankCompanyDAO#getBankCompany(java.lang.Integer
     * )
     */
    @Override
    public BankCompany getBankCompany(Integer id) {
	return get(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.BankCompanyDAO#listBankCompanies()
     */
    @Override
    public List<BankCompany> listBankCompanies() {
	return list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.dao.BankCompanyDAO#updateBankCompany(com.ncr.
     * ATMMonitoring.pojo.BankCompany)
     */
    @Override
    public void updateBankCompany(BankCompany bankCompany) {
	update(bankCompany);
	logger.info("Updated Bank Company with id " + bankCompany.getId());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.BankCompanyDAO#removeBankCompany(java.lang.
     * Integer)
     */
    @Override
    public void removeBankCompany(Integer id) {
	delete(id);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.dao.BankCompanyDAO#getBankCompanyByVat(java.lang.
     * String)
     */
    @Override
    public BankCompany getBankCompanyByVat(String vat) {
    	BankCompany result = (BankCompany) sessionFactory.getCurrentSession().createCriteria(BankCompany.class).add(Restrictions.eq("vatIN", vat)).uniqueResult();
		if (result == null) 
		{
		    logger.error("Requested User with username '" + vat + "' was not found");
		}
		return result;
    }
}