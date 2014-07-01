package com.ncr.ATMMonitoring.service;

import java.util.List;
import java.util.Set;

import com.ncr.ATMMonitoring.pojo.BankCompany;

/**
 * The Interface BankCompanyService.
 * 
 * It contains the bank related methods.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface BankCompanyService {

    /**
     * Adds the bank company.
     * 
     * @param bank
     *            the bank company
     */
    public void addBankCompany(BankCompany bank);

    /**
     * Gets the bank company by its id.
     * 
     * @param id
     *            the bank company id
     * @return the bank company
     */
    public BankCompany getBankCompany(Integer id);

    /**
     * List bank companies.
     * 
     * @return the bank companies list
     */
    public List<BankCompany> listBankCompanies();

    /**
     * Update bank company.
     * 
     * @param bank
     *            the bank company
     */
    public void updateBankCompany(BankCompany bank);

    /**
     * Removes the bank company by its id..
     * 
     * @param id
     *            the bank company id
     */
    public void removeBankCompany(Integer id);

    /**
     * Returns the BankCompanies associated to a user
     * 
     * @param username
     *            String
     * @return Set<BankCompany>
     */
    Set<BankCompany> getUserManageableBankCompanies(String username);
}