package com.ncr.ATMMonitoring.parser.office.dto;

/**
 * DTO that holds the basic information retrieved from an office txt line
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 * 
 */
public class OfficeInfo {

    /** The full office code. */
    private String code;

    /** The office name. */
    private String name;

    /** The office address. */
    private String address;

    /** The office postcode. */
    private String postcode;

    /** The office city. */
    private String city;

    /** The office country code. */
    private String country;

    /**
     * Getter for the code
     * 
     * @return the code
     */
    public String getCode() {
	return code;
    }

    /**
     * Setter for the code
     * 
     * @param code
     *            the code to set
     */
    public void setCode(String code) {
	this.code = code;
    }

    /**
     * Getter for the name
     * 
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * Setter for the name
     * 
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Getter for the address
     * 
     * @return the address
     */
    public String getAddress() {
	return address;
    }

    /**
     * Setter for the address
     * 
     * @param address
     *            the address to set
     */
    public void setAddress(String address) {
	this.address = address;
    }

    /**
     * Getter for the postcode
     * 
     * @return the postcode
     */
    public String getPostcode() {
	return postcode;
    }

    /**
     * Setter for the postcode
     * 
     * @param postcode
     *            the postcode to set
     */
    public void setPostcode(String postcode) {
	this.postcode = postcode;
    }

    /**
     * Getter for the city
     * 
     * @return the city
     */
    public String getCity() {
	return city;
    }

    /**
     * Setter for the city
     * 
     * @param city
     *            the city to set
     */
    public void setCity(String city) {
	this.city = city;
    }

    /**
     * Getter for the country code
     * 
     * @return the country code
     */
    public String getCountry() {
	return country;
    }

    /**
     * Setter for the country code
     * 
     * @param country
     *            the country code to set
     */
    public void setCountry(String country) {
	this.country = country;
    }

    @Override
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {
	StringBuffer sb = new StringBuffer("[");
	sb.append("| code= " + this.code);
	sb.append("| name= " + this.name);
	sb.append("| address= " + this.address);
	sb.append("| postcode= " + this.postcode);
	sb.append("| city= " + this.city);
	sb.append("| country= " + this.country);
	sb.append(" ]");
	return sb.toString();
    }

}
