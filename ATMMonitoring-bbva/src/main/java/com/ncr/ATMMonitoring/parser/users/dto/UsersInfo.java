package com.ncr.ATMMonitoring.parser.users.dto;

/**
 * DTO that holds the basic information retrieved from an office txt line
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 * 
 */
public class UsersInfo {

    /** The full user code. */
    private String code;

    /** The user name. */
    private String firstname;

    /** The user lastname1. */
    private String lastname1;

    /** The user lastname2. */
    private String lastname2;

    /** The user country. */
    private String country;

    /** The user QID */
    private String qid;

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
     * Getter for the firstname
     * 
     * @return the firstname
     */
    public String getFirstname() {
	return firstname;
    }

    /**
     * Setter for the firstname
     * 
     * @param firstname
     *            the name to set
     */
    public void setFirstname(String firstname) {
	this.firstname = firstname;
    }

    /**
     * Getter for the first lastname
     * 
     * @return the first lastname
     */
    public String getLastname1() {
	return lastname1;
    }

    /**
     * Setter for the first lastname
     * 
     * @param lastname1
     *            the lastname to set
     */
    public void setLastname1(String lastname1) {
	this.lastname1 = lastname1;
    }
    
    /**
     * Getter for the second lastname
     * 
     * @return the second lastname
     */
    public String getLastname2() {
	return lastname2;
    }

    /**
     * Setter for the second lastname
     * 
     * @param lastname2
     *            the lastname to set
     */
    public void setLastname2(String lastname2) {
	this.lastname2 = lastname2;
    }

    /**
     * Getter for the country
     * 
     * @return the country
     */
    public String getCountry() {
    	return country;
    }

    /**
     * Setter for the country
     * 
     * @param postcode
     *            the country to set
     */
    public void setCountry(String country) {
    	this.country = country;
    }

    /**
     * Getter for the qid
     * 
     * @return the qid
     */
    public String getQid() {
    	return qid;
    }

    /**
     * Setter for the qid
     * 
     * @param qid
     *            the qid to set
     */
    public void setQid(String qid) {
    	this.qid = qid;
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
		sb.append("| firstname= " + this.firstname);
		sb.append("| lastname1= " + this.lastname1);
		sb.append("| lastname2= " + this.lastname2);
		sb.append("| country= " + this.country);
		sb.append("| qid= " + this.qid);
		
		sb.append(" ]");
		return sb.toString();
    }

}
