package com.ncr.ATMMonitoring.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.type.Type;

import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.agent.baseData.ATMDataStorePojo;

/**
 * The Interface TerminalDAO.
 * 
 * Dao with the operations for managing Terminal Pojos.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface TerminalDAO {

    /**
     * Adds the terminal.
     * 
     * @param terminal
     *            the terminal
     */
    public void addTerminal(Terminal terminal);

    /**
     * Lists all terminals for the given bank companies.
     * 
     * @param bank
     *            the bank companies
     * @return the list of terminals
     */
    public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> bank);

    /**
     * Lists all terminals for the given bank companies with the default order
     * and sorting, optionally filtering by a set of ids (including only those
     * terminals if present).
     * 
     * @param terminalIds
     *            the optional set of ids to filter by
     * @param bank
     *            the bank companies
     * @return the list of terminals
     */
    public List<Terminal> listTerminalsByIdsAndBankCompanies(List<Integer> ids,
	    Set<BankCompany> bank);

    /**
     * Lists all terminals for the given bank companies with a specific order
     * and sorting, optionally filtering by a set of ids (including only those
     * terminals if present).
     * 
     * @param bank
     *            the bank companies
     * @param sort
     *            the sort
     * @param order
     *            the order
     * @param terminalIds
     *            the optional set of ids to filter by
     * @return the list of terminals
     */
    public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> bank,
	    String sort, String order, List<Integer> terminalIds);

    /**
     * List all terminals for the given bank company.
     * 
     * @param bank
     *            the bank company
     * @return the list of terminals
     */
    public List<Terminal> listTerminalsByBankCompany(BankCompany bank);

    /**
     * Lists all terminals.
     * 
     * @return the list of terminals
     */
    public List<Terminal> listTerminals();

    /**
     * Gets the terminal with the given id.
     * 
     * @param id
     *            the id
     * @return the terminal, or null if it doesn't exist
     */
    public Terminal getTerminal(Integer id);

    /**
     * Gets the terminals by HQL. Used for the query engine.
     * 
     * @param values
     *            the values of the HQL parameters
     * @param types
     *            the types of the HQL parameters
     * @param hql
     *            the HQL itself
     * @return the terminals that fulfill the HQL
     */
    public List<Terminal> getTerminalsByHQL(List<Object> values,
	    List<Type> types, String hql);

    /**
     * Gets the terminals by HQL with a specific order and sorting. Used for the
     * query engine.
     * 
     * @param values
     *            the values of the HQL parameters
     * @param types
     *            the types of the HQL parameters
     * @param hql
     *            the HQL itself
     * @param sort
     *            the sort
     * @param order
     *            the order
     * @return the terminals that fulfill the HQL
     */
    public List<Terminal> getTerminalsByHQL(List<Object> values,
	    List<Type> types, String hql, String sort, String order);

    /**
     * Update terminal.
     * 
     * @param terminal
     *            the terminal
     */
    public void updateTerminal(Terminal terminal);

    /**
     * Gets the terminal by serial number.
     * 
     * @param serialNumber
     *            the serial number
     * @return the terminal by serial number, or null if it doesn't exist
     */
    public Terminal getTerminalBySerialNumber(String serialNumber);

    /**
     * Gets the terminal by ip.
     * 
     * @param ip
     *            the ip
     * @return the terminal by ip, or null if it doesn't exist
     */
    public Terminal getTerminalByIp(String ip);

    /**
     * Gets the terminal by mac.
     * 
     * @param mac
     *            the mac
     * @return the terminal by mac, or null if it doesn't exist
     */
    public Terminal getTerminalByMac(String mac);

    /**
     * Gets the terminal by the generated id.
     * 
     * @param matricula
     *            the generated id
     * @return the terminal by the generated id, or null if it doesn't exist
     */
    public Terminal getTerminalByMatricula(Long matricula);

    /**
     * Gets the terminal by similarity. This means that we retrieve terminals
     * that share at least two of some key fields values (MAC, IP, serial
     * number). If we have more than one similar terminal stored, it simply
     * returns the first one by its internal order.
     * 
     * @param terminal
     *            the terminal
     * @return the terminal by similarity, or null if it doesn't exist
     */
    public Terminal getTerminalBySimilarity(ATMDataStorePojo terminal);

    /**
     * Deletes all the terminals' related data from the DB.
     */
    public void deleteAllTerminalData();
}
