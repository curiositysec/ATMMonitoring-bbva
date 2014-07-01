package com.ncr.ATMMonitoring.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Type;

/**
 * The Location Pojo.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "locations", uniqueConstraints = { @UniqueConstraint(columnNames = {
	"address_street", "address_city", "address_postcode", "address_country" }) })
public class Location {

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "locations_id_seq")
    @SequenceGenerator(name = "locations_id_seq", sequenceName = "locations_id_seq", allocationSize = 1)
    private Integer id;

    /** The address street. */
    @Column(name = "address_street")
    @Type(type = "text")
    private String addressStreet;

    /** The address postcode. */
    @Column(name = "address_postcode")
    @Type(type = "text")
    private String addressPostcode;

    /** The address city. */
    @Column(name = "address_city")
    @Type(type = "text")
    private String addressCity;

    /** The address country. */
    @Column(name = "address_country")
    @Type(type = "text")
    private String addressCountry;

    /** The city + country + postcode. */
    @Formula("address_city || ' (' || address_country || '), ' || address_postcode")
    private String addressCityAndCountry;

    /** The complete address. */
    @Formula("address_street || ', ' || address_city || ' (' || address_country || '), ' || address_postcode")
    private String completeAddress;

    /** The coord x. */
    @Column(name = "coord_x")
    private Double coordX;

    /** The coord y. */
    @Column(name = "coord_y")
    private Double coordY;

    /** The displaced. */
    @Column(name = "displaced")
    private Boolean displaced;

    /** The office. */
    @Column(name = "office", length = 50)
    private String office;

    /** The bank. */
    @Column(name = "bank", length = 50)
    private String bank;

    /** The bank company. */
    @Column(name = "bank_company", length = 50)
    private String bankCompany;

    /** The public access. */
    @Column(name = "public_access")
    private Boolean publicAccess;

    /** The office code. */
    @Column(name = "office_code", unique = true)
    private String officeCode;

    // We don't need this for now
    // @OneToMany(mappedBy = "installation")
    // @Cascade(CascadeType.ALL)
    // private Set<Installation> installations
    // public Set<Installation> getInstallation() {
    // return installations;
    // }
    //
    // public void setInstallations(Set<Installation> installations) {
    // this.installations = installations;
    // }

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
     * Gets the coord x.
     * 
     * @return the coord x
     */
    public Double getCoordX() {
	return coordX;
    }

    /**
     * Sets the coord x.
     * 
     * @param coordX
     *            the new coord x
     */
    public void setCoordX(Double coordX) {
	this.coordX = coordX;
    }

    /**
     * Gets the coord y.
     * 
     * @return the coord y
     */
    public Double getCoordY() {
	return coordY;
    }

    /**
     * Sets the coord y.
     * 
     * @param coordY
     *            the new coord y
     */
    public void setCoordY(Double coordY) {
	this.coordY = coordY;
    }

    /**
     * Gets the office.
     * 
     * @return the office
     */
    public String getOffice() {
	return office;
    }

    /**
     * Sets the office.
     * 
     * @param office
     *            the new office
     */
    public void setOffice(String office) {
	this.office = office;
    }

    /**
     * Gets the bank.
     * 
     * @return the bank
     */
    public String getBank() {
	return bank;
    }

    /**
     * Sets the bank.
     * 
     * @param bank
     *            the new bank
     */
    public void setBank(String bank) {
	this.bank = bank;
    }

    /**
     * Gets the bank company.
     * 
     * @return the bank company
     */
    public String getBankCompany() {
	return bankCompany;
    }

    /**
     * Sets the bank company.
     * 
     * @param bankCompany
     *            the new bank company
     */
    public void setBankCompany(String bankCompany) {
	this.bankCompany = bankCompany;
    }

    /**
     * Gets the public access.
     * 
     * @return the public access
     */
    public Boolean getPublicAccess() {
	return publicAccess;
    }

    /**
     * Sets the public access.
     * 
     * @param publicAccess
     *            the new public access
     */
    public void setPublicAccess(Boolean publicAccess) {
	this.publicAccess = publicAccess;
    }

    /**
     * Gets the address street.
     * 
     * @return the address street
     */
    public String getAddressStreet() {
	return addressStreet;
    }

    /**
     * Sets the address street.
     * 
     * @param addressStreet
     *            the new address street
     */
    public void setAddressStreet(String addressStreet) {
	this.addressStreet = addressStreet;
    }

    /**
     * Gets the address postcode.
     * 
     * @return the address postcode
     */
    public String getAddressPostcode() {
	return addressPostcode;
    }

    /**
     * Sets the address postcode.
     * 
     * @param addressPostcode
     *            the new address postcode
     */
    public void setAddressPostcode(String addressPostcode) {
	this.addressPostcode = addressPostcode;
    }

    /**
     * Gets the address city.
     * 
     * @return the address city
     */
    public String getAddressCity() {
	return addressCity;
    }

    /**
     * Sets the address city.
     * 
     * @param addressCity
     *            the new address city
     */
    public void setAddressCity(String addressCity) {
	this.addressCity = addressCity;
    }

    /**
     * Gets the address country.
     * 
     * @return the address country
     */
    public String getAddressCountry() {
	return addressCountry;
    }

    /**
     * Sets the address country.
     * 
     * @param addressCountry
     *            the new address country
     */
    public void setAddressCountry(String addressCountry) {
	this.addressCountry = addressCountry;
    }

    /**
     * Gets the city + country + postcode.
     * 
     * @return the city + country + postcode
     */
    public String getAddressCityAndCountry() {
	return addressCityAndCountry;
    }

    /**
     * Gets the complete address.
     * 
     * @return the complete address
     */
    public String getCompleteAddress() {
	return completeAddress;
    }

    /**
     * Gets the displaced.
     * 
     * @return the displaced
     */
    public Boolean getDisplaced() {
	return displaced;
    }

    /**
     * Sets the displaced.
     * 
     * @param displaced
     *            the new displaced
     */
    public void setDisplaced(Boolean displaced) {
	this.displaced = displaced;
    }

    public boolean hasCoordinates() {
	return coordX != null && coordY != null;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((coordX == null) ? 0 : coordX.hashCode());
	result = prime * result + ((coordY == null) ? 0 : coordY.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Location other = (Location) obj;
	if (coordX == null) {
	    if (other.coordX != null)
		return false;
	} else if (!coordX.equals(other.coordX))
	    return false;
	if (coordY == null) {
	    if (other.coordY != null)
		return false;
	} else if (!coordY.equals(other.coordY))
	    return false;
	return true;
    }

    /**
     * Gets the office code.
     * 
     * @return the office code
     */
    public String getOfficeCode() {
	return officeCode;
    }

    /**
     * Sets the office code.
     * 
     * @param officeCode
     *            the office code to set
     */
    public void setOfficeCode(String officeCode) {
	this.officeCode = officeCode;
    }

}