package com.ncr.ATMMonitoring.service;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.LocationDAO;
import com.ncr.ATMMonitoring.parser.exception.FileNotReadableException;
import com.ncr.ATMMonitoring.parser.exception.NoParserFoundException;
import com.ncr.ATMMonitoring.parser.exception.ParserException;
import com.ncr.ATMMonitoring.parser.office.ParseOfficeChainBuilder;
import com.ncr.ATMMonitoring.parser.office.dto.OfficeInfo;
import com.ncr.ATMMonitoring.pojo.Location;

/**
 * The Class LocationServiceImpl.
 * 
 * Default implementation of the LocationService.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service
@Transactional
public class LocationServiceImpl implements LocationService {

    /** The logger. */
    private static final Logger logger = Logger
	    .getLogger(LocationServiceImpl.class);

    /** The location dao. */
    @Autowired
    private LocationDAO locationDAO;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.LocationService#storeOfficesInfo(java.io
     * .InputStream)
     */
    @Override
    public boolean storeOfficesInfo(InputStream txtFile) {
		boolean parsed = false;
		try {
	
		    this.parseFile(txtFile);
		    parsed = true;
	
		} catch (ParserException e) {
		    logger.error("Can not parse the file: " + txtFile
			    + " due to an error: ", e);
		} catch (FileNotReadableException e) {
		    logger.error("Can not read the file: " + txtFile, e);
		} catch (NoParserFoundException e) {
		    logger.error("The file " + txtFile
			    + " can not be processed by any configured parser ", e);
		}
	
		return parsed;
    }

    /**
     * Executes the parser onto the given Inputstream
     * 
     * @param txt
     *            {@link InputStream} with the txt file
     * @throws ParserException
     * @throws FileNotReadableException
     * @throws NoParserFoundException
     */
    private void parseFile(InputStream txt) throws ParserException,
	    FileNotReadableException, NoParserFoundException {
		Collection<OfficeInfo> offices = ParseOfficeChainBuilder.parse(txt);
		for (OfficeInfo office : offices) {
		    handleParserSuccess(office);
		}
    }

    /**
     * Saves the office info in the Database
     * 
     * @param office
     *            the OfficeInfo to save
     */
    private void handleParserSuccess(OfficeInfo office) {
	Location location = getLocationByOfficeCode(office.getCode());
	if (location == null) {
	    location = new Location();
	    location.setOfficeCode(office.getCode());
	}
	location.setAddressCity(office.getCity());
	location.setAddressStreet(office.getAddress());
	location.setAddressCountry(office.getCountry());
	// if (office.getCountry() != null && office.getCountry().length() == 2)
	// {
	// location.setAddressCountry(new Locale("", office.getCountry())
	// .getDisplayCountry(new Locale("en")));
	// }
	location.setAddressPostcode(office.getPostcode());
	location.setOffice(office.getName());
	if (location.getId() != null) {
	    updateLocation(location);
	} else {
	    addLocation(location);
	}
	// logger.debug("Processed office with code " +
	// location.getOfficeCode());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.service.LocationService#addLocation(com.ncr.
     * ATMMonitoring.pojo.Location)
     */
    @Override
    public void addLocation(Location role) {
	locationDAO.addLocation(role);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.LocationService#getLocation(java.lang.Integer
     * )
     */
    @Override
    public Location getLocation(Integer id) {
	return locationDAO.getLocation(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.LocationService#getLocationByOfficeCode
     * (java.lang.String)
     */
    @Override
    public Location getLocationByOfficeCode(String officeCode) {
	return locationDAO.getLocationByOfficeCode(officeCode);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.service.LocationService#listLocations()
     */
    @Override
    public List<Location> listLocations() {
	return locationDAO.listLocations();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.LocationService#updateLocation(com.ncr.
     * ATMMonitoring.pojo.Location)
     */
    @Override
    public void updateLocation(Location location) {
	locationDAO.updateLocation(location);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.LocationService#removeLocation(java.lang
     * .Integer)
     */
    @Override
    public void removeLocation(Integer id) {
	locationDAO.removeLocation(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.service.LocationService#searchLocations
     * (java.lang.String, java.lang.String)
     */
    @Override
    public List<Location> searchLocations(String field, String terms) {
	if (terms == null) {
	    return locationDAO.searchLocations(field, new String[0]);
	} else {
	    return locationDAO.searchLocations(field, terms.split("\\s+"));
	}
    }
}