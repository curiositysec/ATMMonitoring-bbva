package com.ncr.ATMMonitoring.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * The differents regions on the world
 * 
 * @author jmartin
 * 
 */
public enum RegionType {
    WORLD("world", null),

    // --------------------------AFRICA-------------------------------

    AFRICA("002", WORLD), NORTHERN_AFRICA("015", AFRICA), WESTERN_AFRICA("011",
	    AFRICA), MIDDLE_AFRICA("017", AFRICA), EASTERN_AFRICA("014", AFRICA), SOUTHERN_AFRICA(
	    "018", AFRICA),

    // --------------------------EUROPA-------------------------------

    EUROPE("150", WORLD), NORTHERN_EUROPE("154", EUROPE), WESTERN_EUROPE("155",
	    EUROPE), EASTERN_EUROPE("151", EUROPE),

    SOUTHERN_EUROPE("039", EUROPE), SPAIN("ES", SOUTHERN_EUROPE), ITALY("IT",
	    SOUTHERN_EUROPE),
    // --------------------------AMERICA-------------------------------
    AMERICAS("019", WORLD), NORTHERN_AMERICA("021", AMERICAS), CARIBBEAN("029",
	    AMERICAS), CENTRAL_AMERICA("013", AMERICAS), SOUTH_AMERICA("005",
	    AMERICAS),

    // --------------------------ASIA-------------------------------
    ASIA("142", WORLD), CENTRAL_ASIA("143", ASIA), EASTERN_ASIA("030", ASIA), SOUTHERN_ASIA(
	    "034", ASIA), SOUTH_EASTERN_ASIA("035", ASIA), WESTERN_ASIA("145",
	    ASIA),

    // --------------------------OCEANIA-------------------------------
    OCEANIA("009", WORLD), AUSTRALIA_AND_NEW_ZEALAND("053", OCEANIA), MELANESIA(
	    "054", OCEANIA), MICRONESIA("057", OCEANIA), POLYNESIA("061",
	    OCEANIA);

    /** The region code */
    private String regionCode;

    /** The parent region */
    private RegionType parentRegion;

    /** The child regiogs */
    private List<RegionType> childrenRegion = new ArrayList<RegionType>();

    /**
     * Constructor
     * 
     * @param regionCode
     *            The region code
     * @param parentRegion
     *            The parent region
     */
    private RegionType(String regionCode, RegionType parentRegion) {
	this.regionCode = regionCode;
	this.parentRegion = parentRegion;

	if (this.parentRegion != null) {
	    this.parentRegion.childrenRegion.add(this);
	}
    }

    /**
     * Indicate if a region is a continent
     * 
     * @return True if is a continent. False otherwise
     */
    public boolean isContinent() {
	return this.parentRegion == WORLD;
    }

    /**
     * Indicate if a region is a sub-continent
     * 
     * @return True if is a sub-continent. False otherwise
     */
    public boolean isSubContinent() {
	return this.parentRegion.isContinent();
    }

    /**
     * Indicate if a region is a country
     * 
     * @return True if is a country. False otherwise
     */
    public boolean isCountry() {
	return this.parentRegion.isSubContinent();
    }

    /**
     * Gets the children region
     * 
     * @return The childrens
     */
    public List<RegionType> getChildrenRegion() {
	return this.childrenRegion;
    }

    /**
     * Get the region code
     * 
     * @return The region code
     */
    public String getCode() {
	return this.regionCode;
    }
}