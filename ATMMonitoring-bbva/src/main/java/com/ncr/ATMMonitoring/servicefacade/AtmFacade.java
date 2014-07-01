package com.ncr.ATMMonitoring.servicefacade;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.Installation;
import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.ScheduledUpdate;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.ATMMonitoring.pojo.TerminalConfig;
import com.ncr.ATMMonitoring.pojo.TerminalModel;
import com.ncr.ATMMonitoring.service.InstallationService;
import com.ncr.ATMMonitoring.service.ScheduledUpdateService;
import com.ncr.ATMMonitoring.service.TerminalConfigService;
import com.ncr.ATMMonitoring.service.TerminalModelService;
import com.ncr.ATMMonitoring.service.TerminalService;

/**
 * Service that is an implementation of the Facade pattern that provides a
 * simplified interface for the interaction with the services
 * {@link TerminalService}, {@link TerminalModelService},
 * {@link ScheduledUpdateService}, {@link TerminalConfigService} and
 * {@link InstallationService}.<br>
 * Holds all the operations related to the ATMs, such as scheduling updates and
 * Cruds operations
 * 
 * @author Otto Abreu
 * 
 */
public interface AtmFacade {

    /**
     * Constant that specifies an update operation
     */
    final int UPDATE = 0;

    /**
     * Constant that specifies an add operation
     */
    final int ADD = 1;

    /**
     * To define a search for monthly updates
     */
    final int MONTHLY = 0;

    /**
     * To define a search for weekly updates
     */
    final int WEEKLY = 1;

    /**
     * Indicates that the search will return the elements in ascendent order
     */
    final String ORDER_ASC = "asc";

    /**
     * Indicates that the search will return the elements in descendent order
     */
    final String ORDER_DESC = "desc";

    /**
     * Returns a list with all the ScheduledUpdate that matches the given update
     * type <br>
     * To return a list with weekly updates please use {@link AtmFacade#WEEKLY},
     * To return a list with monthly updates please use
     * {@link AtmFacade#MONTHLY}
     * 
     * @param updateType
     *            int indicate the type of update to fetch ( weekly or monthly)
     * @return List<ScheduledUpdate>
     */
    List<ScheduledUpdate> listScheduledUpdates(int updateType);

    /**
     * Returns a list with all the ScheduledUpdate that matches the given update
     * type and are associated with the given user <br>
     * To return a list with weekly updates please use {@link AtmFacade#WEEKLY},
     * To return a list with monthly updates please use
     * {@link AtmFacade#MONTHLY}
     * 
     * @param username
     *            String with the username
     * @param updateType
     *            int indicate the type of update to fetch ( weekly or monthly)
     * @return List<ScheduledUpdate>
     */
    List<ScheduledUpdate> listScheduledUpdates(String username, int updateType);

    /**
     * Adds the given {@link ScheduledUpdate}
     * 
     * @param scheduledUpdate
     *            ScheduledUpdate to be added
     */
    void addScheduledUpdate(ScheduledUpdate scheduledUpdate);

    /**
     * Removes the {@link ScheduledUpdate} that matches the given id
     * 
     * @param updateId
     */
    void removeScheduledUpdate(int updateId);

    /**
     * Tells if exist in the Database a {@link ScheduledUpdate} with the given
     * Id<br>
     * if a {@link ScheduledUpdate} is found returns true, false otherwise
     * 
     * @param update
     *            ScheduledUpdate
     * @return boolean
     */
    boolean existScheduledUpdate(ScheduledUpdate update);

    /**
     * Adds a physical ATM machine to the Database<br>
     * <i>Note:</i> An ATM machine refers to the physical configuration of the
     * ATM, such as memory, Hard drive, etc. see ({@link TerminalConfig}
     * 
     * @param terminalConfig
     */
    void addATMMachine(TerminalConfig terminalConfig);

    /**
     * Returns a list with all the ATM machines in the Database<br>
     * <i>Note:</i> An ATM machine refers to the physical configuration of the
     * ATM, such as memory, Hard drive, etc. see ({@link TerminalConfig}
     * 
     * @return List<TerminalConfig>
     */
    List<TerminalConfig> listATMMachines();

    /**
     * Return the {@link TerminalConfig} that matches with the given id
     * 
     * @param atmId
     *            int
     * @return TerminalConfig
     */
    TerminalConfig getATMMachine(int atmId);

    /**
     * Method that returns a list of ATM ({@link Terminal}) related to the banks
     * {@link BankCompany} given<br>
     * *
     * <ul>
     * <li>Search by several Bank companies: Fill the list with different
     * {@link BankCompany} element</li>
     * <li>Search by ONE Bank company: Fill the list with only one
     * {@link BankCompany} element</li>
     * </ul>
     * To specify the param order please use: {@link AtmFacade#ORDER_ASC} for an
     * ascendant order and {@link AtmFacade#ORDER_DESC} for descendant
     * 
     * @param banksCompanies
     *            Set<BankCompany> will search based on the given Bank companies
     * @return List<Terminal>
     */
    List<Terminal> listATMByBanks(Set<BankCompany> banksCompanies, String sort,
	    String order);

    /**
     * Method that returns a list of ATM ({@link Terminal}) related to the banks
     * {@link BankCompany} and only those with the given ids
     * 
     * @param banksCompanies
     *            Set<BankCompany> will search based on the given Bank companies
     * @param ids
     *            List<Integer> with the ids
     * @return List<Terminal>
     */
    List<Terminal> listATMByBanksAndAtmId(Set<BankCompany> banksCompanies,
	    List<Integer> ids);

    /**
     * Retuns all the ATM in the database
     * 
     * @return List<Terminal>
     */
    List<Terminal> listAllATM();

    /**
     * Method that returns an ATM ({@link Terminal}) using the criteria given<br>
     * <b><i>Important</i>: ONLY ONE PARAMETER CAN BE USED OF
     * atmId,serialNumber, matricula, ip AND macAdress , THIS MEANS ONLY ONE CAN
     * NOT BE NULL, OTHERWISE WILL EXECUTE THE FIRST NOT NULL PARAM RECEIVED</b><br>
     * Examples of use:<br>
     * <ul>
     * <li>Search by serial number: getATM(null,serialNumber, null, null,null);</li>
     * <li>Search by matricula: getATM(null,null, matricula, null,null);</li>
     * *
     * <li>Search by IP: getATM(null,null, null, ip,null);</li>
     * <li>Search by MAC Address: getATM(null,null, null, null,macAddress);</li>
     * </ul>
     * 
     * @param serialNumber
     *            String if not null will search based on the given serial
     *            number
     * @param matricula
     *            Long if not null will search based on the given matricula
     * @param ip
     *            String if not null will search based on the given ip
     * @param macAddress
     *            String if not null will search based on the given Mac Address
     * @return Terminal
     */
    Terminal getATM(String serialNumber, Long matricula, String ip,
	    String macAddress);

    /**
     * Returns the {@link Terminal} associated to the given id
     * 
     * @param id
     * @return
     */
    Terminal getATMById(int id);

    /**
     * Execute an add or update operation on the given {@link Terminal}<br>
     * To execute an add operation please use {@link AtmFacade#ADD}, To update
     * please use {@link AtmFacade#UPDATE} in the operType param
     * 
     * @param terminal
     *            Terminal to be updated or added
     * @param operType
     *            int that indicate if the given Terminal will be added or
     *            updated
     */
    void addUpdateATM(Terminal terminal, int operType);

    /**
     * Adds the info of the ATM using the given {@link InputStream}<br>
     * The file must be a valid JSON string used by the ATMs
     * 
     * @param file
     *            Inputstream
     */
    void addATMByFile(InputStream file);

    /**
     * Executes a remote update on the given ATM and returns the
     * {@link Terminal} object to be updated<br>
     * Returns null if the given id does not match any Terminal on the Database<br>
     * If the id matches with a {@link Terminal} in the Database, the remote
     * update will be asked<br>
     * 
     * @param atmId
     */
    Terminal atmSnmpUpdate(int atmId);

    /**
     * Executes a remote update based on the result of the given query <br>
     * If the query is null, will update all the ATMs in the DB<br>
     * 
     * @param query
     *            Query
     */
    void atmSnmpUpdate(Query query);

    /**
     * Returns all the models of ATMs registered in the Database
     * 
     * @return List<TerminalModel>
     */
    List<TerminalModel> listATMModels();

    /**
     * Returns all the models of ATMs registered in the Database but organized
     * by the manufacturer<br>
     * The key of the returning map is the name of the manufacturer
     * 
     * @return Map<String,List<TerminalModel>
     */
    Map<String, List<TerminalModel>> listATMModelsByManufacturer();

    /**
     * Execute an add or update operation on the given {@link TerminalModel}<br>
     * <br>
     * To execute an add operation please use {@link AtmFacade#ADD}, To update
     * please use {@link AtmFacade#UPDATE} in the operType param
     * 
     * @param terminalModel
     *            TerminalModel to be updated or added
     * @param operType
     *            int that indicate if the given Terminal will be added or
     *            updated
     */
    void addUpdateATMModel(TerminalModel terminalModel, int operType);

    /**
     * Returns the ATM model that matches with the ID
     * 
     * @param modelId
     *            int with a valid ID
     * @return TerminalModel
     */
    TerminalModel getATMModel(int modelId);

    /**
     * Removes the {@link TerminalModel} that matches the given id
     * 
     * @param atmModelId
     */
    void removeATMModel(int atmModelId);

    /**
     * Execute an add or update operation on the given {@link Installation}<br>
     * <br>
     * To execute an add operation please use {@link AtmFacade#ADD}, To update
     * please use {@link AtmFacade#UPDATE} in the operType param
     * 
     * @param installation
     *            Installation to be updated or added
     * @param operType
     *            int that indicate if the given Terminal will be added or
     *            updated
     */
    void addUpdateATMInstallation(Installation installation, int operType);

    /**
     * Returns all the installations of ATMs registered in the Database
     * 
     * @return List<Installation>
     */
    List<Installation> listATMInstallations();

    /**
     * Return the {@link Installation} that matches with the given id
     * 
     * @param installationId
     *            int
     * @return Installation
     */
    Installation getATMInstallation(int installationId);

    /**
     * Removes the {@link Installation} that matches the given id
     * 
     * @param installationId
     */
    void removeATMInstallation(int installationId);

}
