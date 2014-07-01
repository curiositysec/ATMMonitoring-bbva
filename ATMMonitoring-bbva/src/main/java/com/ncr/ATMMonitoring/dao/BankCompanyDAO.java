package com.ncr.ATMMonitoring.dao;

import java.util.List;

import com.ncr.ATMMonitoring.pojo.BankCompany;

/**
 * The Interface BankCompanyDAO.
 * 
 * Dao with the operations for managing BankCompany Pojos.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface BankCompanyDAO {

    /**
     * Adds the bank company.
     * 
     * @param bank
     *            the bank company
     */
    public void addBankCompany(BankCompany bank);

    /**
     * Gets the bank company with the given id.
     * 
     * @param id
     *            the id
     * @return the bank company, or null if it doesn't exist
     */
    public BankCompany getBankCompany(Integer id);

    /**
     * Lists all bank companies.
     * 
     * @return the list
     */
    public List<BankCompany> listBankCompanies();

    /**
     * Updates bank company.
     * 
     * @param bank
     *            the bank
     */
    public void updateBankCompany(BankCompany bank);

    /**
     * Removes the bank company with the given id.
     * 
     * @param id
     *            the id
     */
    public void removeBankCompany(Integer id);

    /**
     * Gets the bank company with the given vat.
     * 
     * @param vat
     *            the vat
     * @return the bank company, or null if it doesn't exist
     */
	public BankCompany getBankCompanyByVat(String vat);
}
