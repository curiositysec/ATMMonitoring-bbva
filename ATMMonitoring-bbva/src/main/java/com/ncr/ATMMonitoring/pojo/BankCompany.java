package com.ncr.ATMMonitoring.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

/**
 * The BankCompany Pojo.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "bank_companies")
public class BankCompany implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6497721184766729099L;

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "bank_companies_id_seq")
    @SequenceGenerator(name = "bank_companies_id_seq", sequenceName = "bank_companies_id_seq", allocationSize = 1)
    private Integer id;

    /** The name. */
    @Column(name = "name", length = 50, unique = true, nullable = false)
    private String name;

    /** The vat in. */
    @Column(name = "vat_in", length = 15, unique = true, nullable = true)
    @Index(name = "vatInIndex")
    private String vatIN;

    /** The parent company. */
    @ManyToOne
    @JoinColumn(name = "parent_company")
    private BankCompany parentCompany;

    /** The sub bank companies. */
    @OneToMany(mappedBy = "parentCompany")
    private Set<BankCompany> subBankCompanies;

    /**
     * Gets the id.
     * 
     * @return the id
     */
    public Integer getId() {
	return id;
    }

    /**
     * Sets the id.
     * 
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
	this.id = id;
    }

    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * Sets the name.
     * 
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Gets the parent company.
     * 
     * @return the parent company
     */
    public BankCompany getParentCompany() {
	return parentCompany;
    }

    /**
     * Sets the parent company.
     * 
     * @param parentCompany
     *            the new parent company
     */
    public void setParentCompany(BankCompany parentCompany) {
	this.parentCompany = parentCompany;
    }

    /**
     * Gets the subcompanies.
     * 
     * @return the subcompanies
     */
    public Set<BankCompany> getSubBankCompanies() {
	return subBankCompanies;
    }

    /**
     * Sets the sub bank companies.
     * 
     * @param subBankCompanies
     *            the new sub bank companies
     */
    public void setSubBankCompanies(Set<BankCompany> subBankCompanies) {
	this.subBankCompanies = subBankCompanies;
    }

    /**
     * Gets the manageable bank companies (i.e. this bank company and its
     * subcompanies)
     * 
     * @return the manageable bank companies
     */
    public Set<BankCompany> getManageableBankCompanies() {
	Set<BankCompany> bankCompanies = new HashSet<BankCompany>();
	bankCompanies.add(this);
	for (BankCompany subBankCompany : subBankCompanies) {
	    bankCompanies.addAll(subBankCompany.getManageableBankCompanies());
	}
	return bankCompanies;
    }

    /**
     * Gets the vat in.
     * 
     * @return the vat in
     */
    public String getVatIN() {
	return vatIN;
    }

    /**
     * Sets the vat in.
     * 
     * @param vatIN
     *            the new vat in
     */
    public void setVatIN(String vatIN) {
	this.vatIN = vatIN;
    }
}