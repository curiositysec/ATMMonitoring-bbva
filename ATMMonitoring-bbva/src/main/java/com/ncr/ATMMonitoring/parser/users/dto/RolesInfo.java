package com.ncr.ATMMonitoring.parser.users.dto;

/**
 * DTO that holds the basic information retrieved from an mdc txt line
 * 
 * @author Eva Pindado (EP410008@ncr.com)
 * 
 */
public class RolesInfo {

	/** The full user alias. */
    private String username;

    /** The user rol. */
    private String rol;
    
    /** The app code */
    private String code;

    /**
     * Getter for the username
     * 
     * @return the username
     */
	public String getUsername() {
		return username;
	}

	/**
     * Setter for the username
     * 
     * @param username
     *            the username to set
     */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
     * Getter for the rol
     * 
     * @return the rol
     */
	public String getRol() {
		return rol;
	}

	/**
     * Setter for the rol
     * 
     * @param rol
     *            the rol to set
     */
	public void setRol(String rol) {
		this.rol = rol;
	}
	
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
     * @param rol
     *            the code to set
     */
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	 /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
	public String toString() {
		return "RolesInfo [username=" + username + ", rol=" + rol + "]";
	}
}
