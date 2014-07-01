package com.ncr.ATMMonitoring.servicefacade;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.Installation;
import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.ScheduledUpdate;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.ATMMonitoring.pojo.TerminalConfig;
import com.ncr.ATMMonitoring.pojo.TerminalModel;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.service.InstallationService;
import com.ncr.ATMMonitoring.service.ScheduledUpdateService;
import com.ncr.ATMMonitoring.service.TerminalConfigService;
import com.ncr.ATMMonitoring.service.TerminalModelService;
import com.ncr.ATMMonitoring.service.TerminalService;
import com.ncr.ATMMonitoring.service.UserService;
import com.ncr.ATMMonitoring.servicefacade.AtmFacade;
import com.ncr.ATMMonitoring.socket.SocketService;

/**
 * Default implementation of the AtmFacade
 * 
 * @author Otto Abreu
 * 
 */
@Service
public class AtmFacadeImpl implements AtmFacade {

    /** The logger. */
    static private Logger logger = Logger.getLogger(AtmFacadeImpl.class);

    /** The terminal service. */
    @Autowired
    private TerminalService terminalService;

    /** The terminal model service. */
    @Autowired
    private TerminalModelService terminalModelService;

    /** The installation service. */
    @Autowired
    private InstallationService installationService;

    /** The socket service. */
    @Autowired
    private SocketService socketService;

    /** The user service. */
    @Autowired
    private UserService userService;

    /** The scheduled update service. */
    @Autowired
    private ScheduledUpdateService scheduledUpdateService;
    /** The terminal config service */
    @Autowired
    private TerminalConfigService terminalConfigService;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.serviceFacade.ATMFacade#listScheduledUpdates(int)
     */
    @Override
    public List<ScheduledUpdate> listScheduledUpdates(int updateType) {
	List<ScheduledUpdate> updates = null;

	switch (updateType) {
	case AtmFacade.MONTHLY:
	    updates = this.scheduledUpdateService.listMonthlyScheduledUpdates();
	    break;
	case AtmFacade.WEEKLY:
	    updates = this.scheduledUpdateService.listWeeklyScheduledUpdates();
	    break;
	default:
	    String msg = "received a wrong operation indicator (" + updateType
		    + ") for adding, should be " + AtmFacade.MONTHLY + "or "
		    + AtmFacade.WEEKLY;
	    logger.error(msg);
	    throw new IllegalArgumentException(msg);

	}
	return updates;

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.serviceFacade.ATMFacade#listScheduledUpdates(java
     * .lang.String, int)
     */
    @Override
    public List<ScheduledUpdate> listScheduledUpdates(String username,
	    int updateType) {

	User loggedUser = this.userService.getUserByUsername(username);
	List<ScheduledUpdate> updates = null;

	switch (updateType) {

	case AtmFacade.MONTHLY:
	    updates = loggedUser.getMonthlyScheduledUpdates();
	    break;
	case AtmFacade.WEEKLY:
	    updates = loggedUser.getWeeklyScheduledUpdates();
	    break;
	default:
	    String msg = "received a wrong operation indicator (" + updateType
		    + ") for adding, should be " + AtmFacade.MONTHLY + "or "
		    + AtmFacade.WEEKLY;
	    logger.error(msg);
	    throw new IllegalArgumentException(msg);

	}
	return updates;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.serviceFacade.ATMFacade#addScheduledUpdate(com.
     * ncr.ATMMonitoring.pojo.ScheduledUpdate)
     */
    @Override
    public void addScheduledUpdate(ScheduledUpdate scheduledUpdate) {
	this.scheduledUpdateService.addScheduledUpdate(scheduledUpdate);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.serviceFacade.ATMFacade#removeScheduledUpdate(int)
     */
    @Override
    public void removeScheduledUpdate(int updateId) {
	this.scheduledUpdateService.removeScheduledUpdate(updateId);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.serviceFacade.ATMFacade#existScheduledUpdate(com
     * .ncr.ATMMonitoring.pojo.ScheduledUpdate)
     */
    @Override
    public boolean existScheduledUpdate(ScheduledUpdate update) {

	return this.scheduledUpdateService.existsScheduledUpdate(update);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serviceFacade.ATMFacade#addATMMachine(com.ncr.
     * ATMMonitoring.pojo.TerminalConfig)
     */
    @Override
    public void addATMMachine(TerminalConfig terminalConfig) {
	this.terminalConfigService.addTerminalConfig(terminalConfig);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serviceFacade.ATMFacade#listATMMachines()
     */
    @Override
    public List<TerminalConfig> listATMMachines() {
	return this.terminalConfigService.listTerminalConfig();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serviceFacade.ATMFacade#getATMMachine(int)
     */
    @Override
    public TerminalConfig getATMMachine(int atmId) {
	return this.terminalConfigService.getTerminalConfig(atmId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serviceFacade.ATMFacade#getATM(Integer,
     * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public Terminal getATM(String serialNumber, Long matricula, String ip,
	    String macAddress) {

	Terminal terminal = null;

	if (!StringUtils.isEmpty(serialNumber)) {
	    terminal = this.terminalService
		    .loadTerminalBySerialNumber(serialNumber);
	} else if (matricula != null) {
	    terminal = this.terminalService.loadTerminalByMatricula(matricula);
	} else if (!StringUtils.isEmpty(ip)) {
	    terminal = this.terminalService.loadTerminalByIp(ip);
	} else if (!StringUtils.isEmpty(macAddress)) {
	    terminal = this.terminalService.loadTerminalByMac(macAddress);
	}

	return terminal;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serviceFacade.ATMFacade#atmSnmpUpdate(int)
     */
    @Override
    public Terminal atmSnmpUpdate(int atmId) {

	Terminal terminal = this.getATMById(atmId);
	if (terminal != null) {
	    logger.debug("request snmp update for terminal" + atmId);
	    this.socketService.updateTerminalSocket(terminal);
	}

	return terminal;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serviceFacade.ATMFacade#atmSnmpUpdate(com.ncr.
     * ATMMonitoring.pojo.Query, java.lang.String)
     */
    @Override
    public void atmSnmpUpdate(Query query) {

	if (query != null) {

	    this.socketService.updateTerminalsSocket(query);

	} else {
	    this.socketService.updateAllTerminalsSocket();
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serviceFacade.ATMFacade#addUpdateATM(com.ncr.
     * ATMMonitoring.pojo.Terminal, int)
     */
    @Override
    public void addUpdateATM(Terminal terminal, int operType) {
	switch (operType) {

	case AtmFacade.ADD:
	    this.terminalService.addTerminal(terminal);
	    break;

	case AtmFacade.UPDATE:
	    this.terminalService.updateTerminal(terminal);
	    break;

	default:
	    logger.error("received a wrong operation indicator (" + operType
		    + ") for adding, should be " + AtmFacade.ADD + "or "
		    + AtmFacade.UPDATE);
	    throw new IllegalArgumentException(
		    "received a wrong operation indicator (" + operType
			    + ") for adding, should be " + AtmFacade.ADD
			    + "or " + AtmFacade.UPDATE);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serviceFacade.ATMFacade#addATMByFile(java.io.
     * InputStream)
     */
    @Override
    public void addATMByFile(InputStream file) {
	this.terminalService.importJsonTerminal(file);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serviceFacade.ATMFacade#listATMModels()
     */
    @Override
    public List<TerminalModel> listATMModels() {

	return this.terminalModelService.listTerminalModels();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.serviceFacade.ATMFacade#listATMModelsByManufacturer
     * ()
     */
    @Override
    public Map<String, List<TerminalModel>> listATMModelsByManufacturer() {
	return this.terminalModelService.listTerminalModelsByManufacturer();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.serviceFacade.ATMFacade#addUpdateATMModel(com.ncr
     * .ATMMonitoring.pojo.TerminalModel, int)
     */
    @Override
    public void addUpdateATMModel(TerminalModel terminalModel, int operType) {
	switch (operType) {

	case AtmFacade.ADD:
	    this.terminalModelService.addTerminalModel(terminalModel);
	    break;

	case AtmFacade.UPDATE:
	    this.terminalModelService.updateTerminalModel(terminalModel);
	    break;

	default:

	    String msg = "Received a wrong operation indicator (" + operType
		    + ") for adding, should be " + AtmFacade.ADD + "or "
		    + AtmFacade.UPDATE;
	    logger.error(msg);
	    throw new IllegalArgumentException(msg);
	}

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serviceFacade.ATMFacade#removeATMModel(int)
     */
    @Override
    public void removeATMModel(int atmModelId) {
	this.terminalModelService.removeTerminalModel(atmModelId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.serviceFacade.ATMFacade#addUpdateATMInstallation
     * (com.ncr.ATMMonitoring.pojo.Installation, int)
     */
    @Override
    public void addUpdateATMInstallation(Installation installation, int operType) {

	switch (operType) {

	case AtmFacade.ADD:
	    this.installationService.addInstallation(installation);
	    break;

	case AtmFacade.UPDATE:
	    this.installationService.updateInstallation(installation);
	    break;

	default:
	    String msg = "Received a wrong operation indicator (" + operType
		    + ") for adding, should be " + AtmFacade.ADD + "or "
		    + AtmFacade.UPDATE;
	    logger.error(msg);
	    throw new IllegalArgumentException(msg);

	}

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serviceFacade.ATMFacade#listATMInstallations()
     */
    @Override
    public List<Installation> listATMInstallations() {

	return this.installationService.listInstallations();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.serviceFacade.ATMFacade#getATMInstallation(int)
     */
    @Override
    public Installation getATMInstallation(int installationId) {
	return this.installationService.getInstallation(installationId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.serviceFacade.ATMFacade#removeATMInstallation(int)
     */
    @Override
    public void removeATMInstallation(int installationId) {
	this.installationService.removeInstallation(installationId);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.serviceFacade.ATMFacade#listATMByBanks(java.util
     * .Set, java.lang.String, java.lang.String)
     */
    @Override
    public List<Terminal> listATMByBanks(Set<BankCompany> banksCompanies,
	    String sort, String order) {
	List<Terminal> atmByBanks = null;

	if (banksCompanies.size() > 1) {

	    if (StringUtils.isEmpty(sort) && (StringUtils.isEmpty(order))) {

		atmByBanks = this.terminalService
			.listTerminalsByBankCompanies(banksCompanies);

	    } else {

		atmByBanks = this.terminalService.listTerminalsByBankCompanies(
			banksCompanies, sort, order);
	    }

	} else {

	    atmByBanks = this.terminalService
		    .listTerminalsByBankCompany(banksCompanies.iterator()
			    .next());
	}
	return atmByBanks;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.serviceFacade.ATMFacade#listATMByBanksAndAtmId(
     * java.util.Set, java.util.List)
     */
    @Override
    public List<Terminal> listATMByBanksAndAtmId(
	    Set<BankCompany> banksCompanies, List<Integer> ids) {
	return this.terminalService.listTerminalsByIdsAndBankCompanies(ids,
		banksCompanies);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serviceFacade.ATMFacade#getATMById(int)
     */
    @Override
    public Terminal getATMById(int id) {
	return this.terminalService.getTerminal(id);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serviceFacade.ATMFacade#listAllATM()
     */
    @Override
    public List<Terminal> listAllATM() {

	return this.terminalService.listTerminals();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.serviceFacade.ATMFacade#getATMModel(int)
     */
    @Override
    public TerminalModel getATMModel(int modelId) {

	return this.terminalModelService.getTerminalModel(modelId);
    }

}
