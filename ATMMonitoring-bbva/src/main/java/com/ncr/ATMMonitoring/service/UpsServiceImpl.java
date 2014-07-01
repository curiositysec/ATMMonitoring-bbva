package com.ncr.ATMMonitoring.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.UpsDAO;
import com.ncr.ATMMonitoring.handler.FileInDiskHandler;
import com.ncr.ATMMonitoring.parser.exception.NoParserFoundException;
import com.ncr.ATMMonitoring.parser.exception.ParserException;
import com.ncr.ATMMonitoring.parser.exception.FileNotReadableException;
import com.ncr.ATMMonitoring.parser.ups.ParseUPSChainBuilder;
import com.ncr.ATMMonitoring.parser.ups.dto.UPSInfo;
import com.ncr.ATMMonitoring.pojo.Ups;

/**
 * The Class UpsServiceImpl.
 * 
 * Default implementation of the UpsService.
 * 
 * @author Otto Abreu
 * 
 */
/**
 * @author george
 * 
 */
@Service
@Transactional
public class UpsServiceImpl implements UpsService {

    /** The logger. */
    private static final Logger logger = Logger.getLogger(UpsServiceImpl.class);

    /** The UPS DAO. */
    @Autowired
    private UpsDAO upsDao;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.UPSService#storeUPSinfo(java.util.List)
     */
    @Override
    public List<String> storeUPSinfo(List<String> xmlFiles) {
	List<String> errors = new ArrayList<String>();

	for (String file : xmlFiles) {
	    try {
		if (!this.storeUPSinfo(file)) {
		    errors.add(file);
		}
	    } catch (HibernateException e) {
		errors.add(file);
		logger.error(
			"The UPS processing found an Database error while saving the info of one XML",
			e);
	    }

	}
	logger.info("XML parsing process end normally: " + errors.isEmpty());
	return errors;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.UPSService#storeUPSinfo(java.util.Collection
     * )
     */
    @Override
    public List<InputStream> storeUPSinfo(Collection<InputStream> xmlFiles) {
	List<InputStream> errors = new ArrayList<InputStream>();

	for (InputStream is : xmlFiles) {

	    try {
		if (!this.storeUPSinfo(is)) {
		    errors.add(is);
		}
	    } catch (HibernateException e) {
		errors.add(is);
		logger.error(
			"The UPS processing found an Database error while saving the info of one XML",
			e);
	    }
	}

	logger.info("XML parsing process ends normally: " + errors.isEmpty());
	return errors;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.UPSService#storeUPSinfo(java.io.InputStream
     * )
     */
    @Override
    public boolean storeUPSinfo(InputStream xmlFile) {
	boolean parsed = false;
	try {

	    this.parseFile(xmlFile);
	    parsed = true;

	} catch (ParserException e) {
	    logger.error("Can not parse the file: " + xmlFile
		    + " due an error: ", e);
	} catch (FileNotReadableException e) {
	    logger.error("Can not Read the file: " + xmlFile, e);
	} catch (NoParserFoundException e) {
	    logger.error("The file " + xmlFile
		    + " can not be processed by any configured parser ", e);
	}

	return parsed;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.UPSService#storeUPSinfo(java.lang.String)
     */
    @Override
    public boolean storeUPSinfo(String xmlFile) {
	boolean parsed = false;

	InputStream xml = FileInDiskHandler.getFileInputStream(xmlFile);
	parsed = this.storeUPSinfo(xml);
	return parsed;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.service.UPSService#deleteUPS(int)
     */
    @Override
    public void deleteUPS(int id) {

	this.upsDao.removeUps(id);
	logger.info("removed ups with id: " + id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.UpsService#addUps(com.ncr.ATMMonitoring
     * .pojo.Ups)
     */
    @Override
    public void addUps(Ups ups) {
	upsDao.addUps(ups);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.service.UpsService#getUps(java.lang.Integer)
     */
    @Override
    public Ups getUps(Integer id) {
	return upsDao.getUps(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.UpsService#getUpsBySeriesNumber(java.lang
     * .String)
     */
    @Override
    public Ups getUpsBySeriesNumber(String seriesNumber) {
	return upsDao.getUpsBySerialNumber(seriesNumber);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.UpsService#updateUps(com.ncr.ATMMonitoring
     * .pojo.Ups)
     */
    @Override
    public void updateUps(Ups ups) {
	upsDao.updateUps(ups);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.service.UpsService#listUps(java.lang.String,
     * java.lang.String)
     */
    @Override
    public List<Ups> listUps(String sort, String order) {
	return upsDao.listUps(sort, order);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.service.UpsService#listUps()
     */
    @Override
    public List<Ups> listUps() {
	return upsDao.listAllUps();
    }

    /**
     * Saves the ups info in the Database
     * 
     * @param file
     *            the UPSInfo to save
     */

    private void handleParserSuccess(UPSInfo file) {

	String seriesNumber = file.getSeriesNumber();
	String model = file.getModel();
	Ups ups = this.getEntity(file);
	// verify if is an update or a new information
	Ups toUpdate = this.upsDao.getUpsBySerialNumberAndModel(seriesNumber,
		model);

	if (toUpdate == null) {
	    logger.info("adding new UPS to the Database with series number: "
		    + seriesNumber + " and model: " + model);
	    this.upsDao.addUps(ups);

	} else {
	    logger.info("Updating ups with: " + seriesNumber + " model: "
		    + model + " and id: " + toUpdate.getId());
	    ups.setId(toUpdate.getId());
	    this.upsDao.updateUps(ups);
	}

	if (file.getExtraInfo() != null) {
	    // TODO calls the class/method responsible to handle this part of
	    // the object
	}
    }

    /**
     * Executes the parser onto the given Inputstream
     * 
     * @param xml
     *            {@link InputStream} with the XML
     * @return UPSInfo with the extracted info
     * @throws ParserException
     * @throws FileNotReadableException
     * @throws NoParserFoundException
     */
    private void parseFile(InputStream xml) throws ParserException,
	    FileNotReadableException, NoParserFoundException {

	UPSInfo xmlInfo = ParseUPSChainBuilder.parse(xml);
	this.handleParserSuccess(xmlInfo);
    }

    /**
     * Fills the entity with the data from the DTO
     * 
     * @param info
     *            UPSInfo
     * @return Ups
     */
    private Ups getEntity(UPSInfo info) {

	Ups ups = new Ups();
	ups.setIp(info.getIp());
	ups.setFirmware(info.getFirmware());
	ups.setRunningStatus(info.getRunningStatus());
	ups.setChargePercentage(info.getChargePercentage());
	ups.setExpensePercentage(info.getExpensePercentage());
	ups.setAlarmMsg(info.getAlarmMsg());
	ups.setType(info.getType());
	ups.setModel(info.getModel());
	ups.setSeriesNumber(info.getSeriesNumber());
	ups.setRunningTimeMillisec(info.getRunningTimeMillisec());
	ups.setAutonomyMillisec(info.getAutonomyMillisec());
	ups.setNumPosition(info.getNumPosition());
	ups.setAudFmo(info.getAudFmo());
	ups.setGeneralStatusMsg(info.getGeneralStatusMsg());
	ups.setLastExecutionDate(info.getLastExecutionDate());
	ups.setOriginalXML(info.getOriginalXML());
	return ups;

    }
}
