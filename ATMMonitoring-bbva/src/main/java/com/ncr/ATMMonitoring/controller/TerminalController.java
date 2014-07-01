package com.ncr.ATMMonitoring.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.ncr.ATMMonitoring.controller.propertyeditor.DatePropertyEditor;
import com.ncr.ATMMonitoring.pojo.Auditable;
import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.Installation;
import com.ncr.ATMMonitoring.pojo.Location;
import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.ATMMonitoring.pojo.TerminalModel;
import com.ncr.ATMMonitoring.service.BankCompanyService;
import com.ncr.ATMMonitoring.service.LocationService;
import com.ncr.ATMMonitoring.service.QueryService;
import com.ncr.ATMMonitoring.servicefacade.AtmFacade;

/**
 * The Class TerminalController.
 * 
 * Controller for handling terminal related HTTP petitions.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Controller
public class TerminalController extends GenericController {

    /** The logger. */
    static private Logger logger = Logger.getLogger(TerminalController.class
	    .getName());

    /** The agent push comm model state. */
    @Value("${config.agentPushState}")
    private String agentPushState;

    /** The Constant DEFAULT_SORT. */
    public static final String DEFAULT_SORT = "serialNumber";

    /** The Constant DEFAULT_ORDER. */
    public static final String DEFAULT_ORDER = AtmFacade.ORDER_ASC;

    /** The can alter terminals roles. */
    @Value("${security.terminalsManagementAllowedRoles}")
    private String canManageTerminalsRoles;

    /** The page size. */
    @Value("${config.terminalsPageSize}")
    private int pageSize;

    /** The terminal models page size. */
    @Value("${config.terminalModelsPageSize}")
    private int terminalModelsPageSize;

    /** The atm service facade. */
    @Autowired
    private AtmFacade atmservice;

    /** The query service. */
    @Autowired
    private QueryService queryService;

    /** The location service. */
    @Autowired
    private LocationService locationService;

    /** The bank company service */
    @Autowired
    private BankCompanyService bankCompanyService;

    /**
     * Binds custom property editors.
     * 
     * @param binder
     *            the binder
     * @throws Exception
     *             the exception
     */
    @InitBinder
    protected void binder(WebDataBinder binder) throws Exception {
	binder.registerCustomEditor(Date.class, new DatePropertyEditor());
    }

    /**
     * Request query results' terminals update URL.
     * 
     * @param queryId
     *            the query id
     * @param principal
     *            the principal
     * @param redirectAttributes
     *            the redirect attributes
     * @return the petition response
     */
    @RequestMapping(value = "/terminals/request", method = RequestMethod.GET)
    public String requestTerminalsUpdateByQuery(String queryId,
	    Principal principal, RedirectAttributes redirectAttributes) {
	if (agentPushState.equalsIgnoreCase("on")) {
	    return "redirect:/dashboard";
	}
	if ((queryId != null) && (principal != null)) {
	    Query query = queryService.getQuery(Integer.parseInt(queryId));
	    if (this.queryService.queryBelongToUser(query, principal.getName())) {
		this.atmservice.atmSnmpUpdate(query);
	    }
	} else {
	    this.atmservice.atmSnmpUpdate(null);
	    redirectAttributes.addFlashAttribute("success",
		    "success.snmpUpdateAll");
	}

	try {
	    // We wait to avoid not loading the recently added DB data
	    Thread.sleep(1000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	return "redirect:/terminals/list";
    }

    /**
     * Request terminal update by id URL.
     * 
     * @param terminalId
     *            the terminal id
     * @param redirectAttributes
     *            the redirect attributes
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping("/terminals/request/{terminalId}")
    public String requestTerminalUpdateById(
	    @PathVariable("terminalId") Integer terminalId,
	    RedirectAttributes redirectAttributes, Principal principal) {
	if (agentPushState.equalsIgnoreCase("on")) {
	    return "redirect:/dashboard";
	}
	Terminal terminal = this.atmservice.atmSnmpUpdate(terminalId);

	if (terminal == null) {
	    return "redirect:/terminals/list";
	}
	// try {
	// logger.debug("request snmp update for terminal" + terminalId);
	// socketService.updateTerminalSocket(terminal);
	// redirectAttributes.addFlashAttribute("success",
	// "success.snmpUpdateTerminal");
	// } catch (SnmpTimeOutException e) {
	// String userMsg = "";
	// Locale locale = RequestContextUtils.getLocale(request);
	// if (principal != null) {
	// User loggedUser = userService.getUserByUsername(principal.getName());
	// userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	// Set<BankCompany> bankCompanies = loggedUser
	// .getManageableBankCompanies();
	// if ((terminal.getBankCompany() != null)
	// && (!bankCompanies.contains(terminal.getBankCompany()))) {
	// map.clear();
	// return "redirect:/terminals/list";
	// }
	// }
	// map.put("userMsg", userMsg);
	// map.put("ips", e.getIpsHtmlList());
	// redirectAttributes.addFlashAttribute("timeout",
	// "timeout.snmpUpdateTerminal");
	// return "redirect:/terminals/details/" + terminalId;
	// }

	try {
	    // We wait to avoid not loading the recently added DB data
	    Thread.sleep(1000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	return "redirect:/terminals/details/" + terminalId;
    }

    /**
     * List terminals URL.
     * 
     * @param map
     *            the map
     * @param principal
     *            the principal
     * @param p
     *            the page number
     * @param sort
     *            the fields for sorting terminals
     * @param order
     *            the order for sorting terminals
     * @param request
     *            the request
     * @param request
     *            the queryDate
     * @return the petition response
     */
    @RequestMapping(value = "/terminals/list", method = RequestMethod.GET)
    public String listTerminals(Map<String, Object> map, Principal principal,
	    String p, String sort, String order, HttpServletRequest request) {
	String userMsg = "";

	List<Terminal> terminals = new ArrayList<Terminal>();
	PagedListHolder<Terminal> pagedListHolder = new PagedListHolder<Terminal>();
	Set<BankCompany> bankCompanies = new HashSet<BankCompany>();
	Set<Query> userQueries = null;
	String sortValue = (sort == null) ? DEFAULT_SORT : sort;
	String orderValue = (order == null) ? DEFAULT_ORDER : order;
	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	    bankCompanies = this.bankCompanyService
		    .getUserManageableBankCompanies(principal.getName());
	    terminals = this.atmservice.listATMByBanks(bankCompanies, sort,
		    order);
	    pagedListHolder = new PagedListHolder<Terminal>(terminals);

	    userQueries = this.queryService.getQueriesByUser(principal
		    .getName());
	}
	map.put("banksList", bankCompanies);
	map.put("installationsList", this.atmservice.listATMInstallations());
	map.put("userQueries", userQueries);
	map.put("userMsg", userMsg);
	map.put("terminal", new Terminal());
	map.put("sort", sortValue);
	map.put("order", orderValue);
	int page = 0;
	if (p != null) {
	    try {
		page = Integer.parseInt(p);
	    } catch (NumberFormatException e) {
		e.printStackTrace();
	    }
	}
	pagedListHolder.setPage(page);
	pagedListHolder.setPageSize(pageSize);
	map.put("pagedListHolder", pagedListHolder);
	map.put("terminalIdsByLocation",
		buildTerminalIdsByLocationModel(terminals, null));

	return "terminals";
    }

    /**
     * Redirect to terminals URL.
     * 
     * @return the petition response
     */
    @RequestMapping(value = { "/terminals" })
    public String redirectToTerminals() {
	return "redirect:/terminals/list";
    }

    /**
     * Terminal details URL.
     * 
     * @param terminalId
     *            the terminal id
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping("/terminals/details/{terminalId}")
    public String terminalDetails(
	    @PathVariable("terminalId") Integer terminalId,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal, Long dateTime, String preselectedTab) {

	Date date = dateTime == null ? null : new Date(dateTime);

	Terminal terminal = this.atmservice.getATMById(terminalId);
	if (terminal == null) {
	    map.clear();
	    return "redirect:/terminals/list";
	}
	String userMsg = "";
	Set<BankCompany> bankCompanies = new HashSet<BankCompany>();
	if (principal != null) {

	    userMsg = this.getUserGreeting(principal, request);
	    bankCompanies = this.bankCompanyService
		    .getUserManageableBankCompanies(principal.getName());
	    if ((terminal.getBankCompany() != null)
		    && (!bankCompanies.contains(terminal.getBankCompany()))) {
		map.clear();
		return "redirect:/terminals/list";
	    }
	}

	Map<Class<? extends Auditable>, Map<Date, Integer>> historicalChanges = terminal
		.buildHistoricalChanges();
	map.put("historicalChanges", historicalChanges);

	map.put("banksList", bankCompanies);
	map.put("installationsList", this.atmservice.listATMInstallations());
	map.put("values", this.atmservice.listATMModelsByManufacturer());
	map.put("date", date);
	map.put("userMsg", userMsg);
	map.put("terminal", terminal);
	map.put("preselectedTab", preselectedTab);

	return "terminalDetails";
    }

    @RequestMapping("/terminals/summary")
    public String terminalSummary(
	    @RequestParam("terminalIds") ArrayList<Integer> terminalIds,
	    Map<String, Object> model, HttpServletRequest request,
	    Principal principal, Long dateTime) {

	Date date = dateTime == null ? null : new Date(dateTime);

	Set<BankCompany> bankCompanies = this.bankCompanyService
		.getUserManageableBankCompanies(principal.getName());
	List<Terminal> terminals = this.atmservice.listATMByBanksAndAtmId(
		bankCompanies, terminalIds);

	model.put("terminals", terminals);
	model.put("queryDate", date);
	return "terminalsDetailsSummary";
    }

    /**
     * Import terminals from json file URL.
     * 
     * @param file
     *            the json file
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     * @throws IOException
     */
    @RequestMapping(value = "/terminals/import", method = RequestMethod.POST)
    public String importTerminal(@RequestParam("file") CommonsMultipartFile file)
	    throws IOException {

	// boolean importResult = false;
	if (file != null) {
	    // importResult = terminalService.importJsonTerminal(file);
	    this.atmservice.addATMByFile(file.getInputStream());
	}
	return "redirect:/terminals/list";
    }

    /**
     * New terminal form URL.
     * 
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping(value = "/terminals/new", method = RequestMethod.GET)
    public String viewNewTerminal(Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {
	String userMsg = "";
	Set<BankCompany> bankCompanies = new HashSet<BankCompany>();
	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	    bankCompanies = this.bankCompanyService
		    .getUserManageableBankCompanies(principal.getName());
	}

	map.put("values", this.atmservice.listATMModelsByManufacturer());
	map.put("banksList", bankCompanies);
	map.put("terminal", new Terminal());
	map.put("userMsg", userMsg);

	return "newTerminal";
    }

    /**
     * Add terminal URL.
     * 
     * @param terminal
     *            the terminal
     * @param result
     *            the result
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @param p
     *            the page number
     * @return the petition response
     */
    @RequestMapping(value = "/terminals/list", method = RequestMethod.POST)
    public String addTerminal(
	    @Valid @ModelAttribute("terminal") Terminal terminal,
	    BindingResult result, Map<String, Object> map,
	    HttpServletRequest request, Principal principal, String p) {
	if ((terminal.getBankCompany() != null)
		&& (terminal.getBankCompany().getId() == null)) {
	    terminal.setBankCompany(null);
	}

	if ((terminal.getTerminalModel() != null)
		&& (terminal.getTerminalModel().getId() == null)) {
	    terminal.setTerminalModel(null);
	}
	String userMsg = "";
	PagedListHolder<Terminal> pagedListHolder = new PagedListHolder<Terminal>();
	Set<BankCompany> bankCompanies = new HashSet<BankCompany>();

	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	    Set<Query> userQueries = this.queryService
		    .getQueriesByUser(principal.getName());
	    map.put("userQueries", userQueries);
	    bankCompanies = this.bankCompanyService
		    .getUserManageableBankCompanies(principal.getName());
	    pagedListHolder = new PagedListHolder<Terminal>(
		    this.atmservice.listATMByBanks(bankCompanies, null, null));

	    if ((terminal.getBankCompany() != null)
		    && (!bankCompanies.contains(terminal.getBankCompany()))) {
		map.clear();
		return "redirect:/terminals/list";
	    }
	}
	int page = 0;
	if (p != null) {
	    try {
		page = Integer.parseInt(p);
	    } catch (NumberFormatException e) {
		e.printStackTrace();
	    }
	}
	if (result.hasErrors()) {
	    pagedListHolder.setPage(page);
	    pagedListHolder.setPageSize(pageSize);
	    map.put("pagedListHolder", pagedListHolder);
	    map.put("banksList", bankCompanies);
	    map.put("installationsList", this.atmservice.listATMInstallations());
	    map.put("userMsg", userMsg);
	    return "terminals";
	}

	this.atmservice.addUpdateATM(terminal, AtmFacade.ADD);

	try {
	    // We wait to avoid not loading the recently added DB data
	    Thread.sleep(500);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	map.clear();
	return "redirect:/terminals/list";
    }

    /**
     * Update terminal URL.
     * 
     * @param terminal
     *            the terminal
     * @param result
     *            the result
     * @param map
     *            the map
     * @param redirectAttributes
     *            the redirect attributes
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping(value = "/terminals/update", method = RequestMethod.POST)
    public String updateTerminal(
	    @Valid @ModelAttribute("terminal") Terminal terminal,
	    BindingResult result, Map<String, Object> map,
	    RedirectAttributes redirectAttributes, HttpServletRequest request,
	    Principal principal) {
	if ((terminal.getBankCompany() != null)
		&& (terminal.getBankCompany().getId() == null)) {
	    terminal.setBankCompany(null);
	}

	if ((terminal.getTerminalModel() != null)
		&& (terminal.getTerminalModel().getId() == null)) {
	    terminal.setTerminalModel(null);
	}
	String userMsg = "";
	List<Terminal> terminals = new ArrayList<Terminal>();
	Set<BankCompany> bankCompanies = new HashSet<BankCompany>();
	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	    bankCompanies = this.bankCompanyService
		    .getUserManageableBankCompanies(principal.getName());
	    terminals = this.atmservice.listATMByBanks(bankCompanies, null,
		    null);
	}
	map.put("banksList", bankCompanies);
	map.put("installationsList", this.atmservice.listATMInstallations());
	map.put("terminalsList", terminals);
	map.put("userMsg", userMsg);
	if (result.hasErrors()) {
	    map.put("errors", true);
	    return "terminalDetails";
	}

	Terminal auxTerminal = this.atmservice.getATMById(terminal.getId());
	auxTerminal.replaceTerminalData(terminal);
	this.atmservice.addUpdateATM(auxTerminal, AtmFacade.UPDATE);
	redirectAttributes.addFlashAttribute("success",
		"success.updatingTerminal");
	try {
	    // We wait to avoid not loading the recently added DB data
	    Thread.sleep(500);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	map.clear();
	return "redirect:/terminals/details/" + terminal.getId().intValue();
    }

    /**
     * List terminals by query URL.
     * 
     * @param map
     *            the map
     * @param queryId
     *            the query id
     * @param principal
     *            the principal
     * @param p
     *            the page number
     * @param sort
     *            the fields for sorting terminals
     * @param order
     *            the order for sorting terminals
     * @param request
     *            the request
     * @param queryDate
     *            the date the date
     * @return the petition response
     */
    @RequestMapping(value = "terminals/byQuery")
    public String listTerminalsByQuery(Map<String, Object> map,
	    Integer queryId, Principal principal, String p, String sort,
	    String order, HttpServletRequest request, Date queryDate) {
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);
	Set<Query> userQueries = null;
	String sortValue = (sort == null) ? DEFAULT_SORT : sort;
	String orderValue = (order == null) ? DEFAULT_ORDER : order;

	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	    userQueries = this.queryService.getQueriesByUser(principal
		    .getName());
	}
	map.put("userQueries", userQueries);
	map.put("userMsg", userMsg);
	Query query = null;
	List<Terminal> terminals = null;
	if (queryId != null) {
	    query = this.queryService.getQuery(queryId);
	    terminals = this.queryService.executeQuery(query, locale,
		    sortValue, orderValue, queryDate);
	}
	if (terminals == null) {
	    // terminals = terminalService.listTerminals();
	    terminals = this.atmservice.listAllATM();
	}

	PagedListHolder<Terminal> pagedListHolder = new PagedListHolder<Terminal>(
		terminals);

	int page = 0;
	if (p != null) {
	    try {
		page = Integer.parseInt(p);
	    } catch (NumberFormatException e) {
		e.printStackTrace();
	    }
	}
	pagedListHolder.setPage(page);
	pagedListHolder.setPageSize(pageSize);
	map.put("query", query);
	map.put("pagedListHolder", pagedListHolder);
	map.put("sort", sortValue);
	map.put("order", orderValue);
	map.put("queryDate", queryDate);
	map.put("terminalIdsByLocation",
		buildTerminalIdsByLocationModel(terminals, queryDate));

	return "terminals";
    }

    /**
     * Redirect to terminal models URL.
     * 
     * @return the petition response
     */
    @RequestMapping(value = { "/terminals/models" })
    public String redirectToTerminalModels() {
	return "redirect:/terminals/models/list";
    }

    /**
     * List terminal models URL.
     * 
     * @param map
     *            the map
     * @param principal
     *            the principal
     * @param p
     *            the page number
     * @param request
     *            the request
     * @return the petition response
     */
    @RequestMapping(value = "/terminals/models/list", method = RequestMethod.GET)
    public String listTerminalModels(Map<String, Object> map,
	    Principal principal, String p, HttpServletRequest request) {
	String userMsg = "";
	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	}
	PagedListHolder<TerminalModel> pagedListHolder = new PagedListHolder<TerminalModel>(
		this.atmservice.listATMModels());
	map.put("userMsg", userMsg);
	map.put("terminalModel", new TerminalModel());
	int page = 0;
	if (p != null) {
	    try {
		page = Integer.parseInt(p);
	    } catch (NumberFormatException e) {
		e.printStackTrace();
	    }
	}
	pagedListHolder.setPage(page);
	pagedListHolder.setPageSize(terminalModelsPageSize);
	map.put("pagedListHolder", pagedListHolder);

	return "terminalModels";
    }

    /**
     * Add terminal model URL.
     * 
     * @param terminalModel
     *            the terminal model
     * @param photo
     *            the photo
     * @param result
     *            the result
     * @param map
     *            the map
     * @param request
     *            the request
     * @param p
     *            the page number
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping(value = "/terminals/models/list", method = RequestMethod.POST)
    public String addTerminalModel(
	    @Valid @ModelAttribute("terminalModel") TerminalModel terminalModel,
	    @RequestParam("file") CommonsMultipartFile photo,
	    BindingResult result, Map<String, Object> map,
	    HttpServletRequest request, String p, Principal principal) {

	if (photo != null) {
	    terminalModel.setPhoto(photo.getBytes());
	}

	if (result.hasErrors()) {
	    String userMsg = "";
	    if (principal != null) {
		userMsg = this.getUserGreeting(principal, request);
	    }

	    PagedListHolder<TerminalModel> pagedListHolder = new PagedListHolder<TerminalModel>(
		    this.atmservice.listATMModels());
	    map.put("userMsg", userMsg);
	    int page = 0;
	    if (p != null) {
		try {
		    page = Integer.parseInt(p);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
	    }
	    pagedListHolder.setPage(page);
	    pagedListHolder.setPageSize(terminalModelsPageSize);
	    map.put("pagedListHolder", pagedListHolder);
	    map.put("userMsg", userMsg);
	    return "terminalModels";
	}

	this.atmservice.addUpdateATMModel(terminalModel, AtmFacade.ADD);

	try {
	    // We wait to avoid not loading the recently added DB data
	    Thread.sleep(500);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	map.clear();
	return "redirect:/terminals/models/list";
    }

    /**
     * Terminal model details URL.
     * 
     * @param terminalModelId
     *            the terminal model id
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping("/terminals/models/details/{terminalModelId}")
    public String terminalModelDetails(
	    @PathVariable("terminalModelId") Integer terminalModelId,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {
	TerminalModel terminalModel = this.atmservice
		.getATMModel(terminalModelId);
	if (terminalModel == null) {
	    map.clear();
	    return "redirect:/terminals/models/list";
	}
	String userMsg = "";
	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	}
	map.put("userMsg", userMsg);
	map.put("terminalModel", terminalModel);

	return "terminalModelDetails";
    }

    /**
     * Update terminal model URL.
     * 
     * @param terminalModel
     *            the terminal model
     * @param photo
     *            the photo
     * @param result
     *            the result
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping(value = "/terminals/models/update", method = RequestMethod.POST)
    public String updateTerminalModel(
	    @Valid @ModelAttribute("terminalModel") TerminalModel terminalModel,
	    @RequestParam("file") CommonsMultipartFile photo,
	    BindingResult result, Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {
	if ((photo != null) && (photo.getSize() > 0)) {
	    terminalModel.setPhoto(photo.getBytes());
	}

	if (result.hasErrors()) {
	    String userMsg = "";
	    if (principal != null) {
		userMsg = this.getUserGreeting(principal, request);
	    }
	    map.put("userMsg", userMsg);
	    return "terminalModelDetails";
	}

	this.atmservice.addUpdateATMModel(terminalModel, AtmFacade.UPDATE);

	try {
	    // We wait to avoid not loading the recently added DB data
	    Thread.sleep(500);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	map.clear();
	return "redirect:/terminals/models/details/"
		+ terminalModel.getId().intValue();
    }

    /**
     * Delete terminal model URL.
     * 
     * @param terminalModelId
     *            the terminal model id
     * @return the petition response
     */
    @RequestMapping("/terminals/models/delete/{terminalModelId}")
    public String deleteTerminalModel(
	    @PathVariable("terminalModelId") Integer terminalModelId) {
	TerminalModel terminalModel = this.atmservice
		.getATMModel(terminalModelId);
	if (terminalModel != null) {
	    this.atmservice.removeATMModel(terminalModelId);
	}

	return "redirect:/terminals/models/list";
    }

    /**
     * Get terminal model image URL.
     * 
     * @param terminalModelId
     *            the terminal model id
     * @param request
     *            the request
     * @param response
     *            the response
     * @param width
     *            the required image width
     * @param height
     *            the required image height
     * @return the terminal model image
     */
    @RequestMapping(value = { "terminals/models/image/{terminalModelId}" })
    public void getTerminalModelImage(
	    @PathVariable("terminalModelId") Integer terminalModelId,
	    HttpServletRequest request, HttpServletResponse response,
	    String width, String height) {

	TerminalModel model = this.atmservice.getATMModel(terminalModelId);
	try {
	    if ((model != null) && (model.getPhoto() != null)) {
		int realHeight = 0, realWidth = 0;
		if (width != null) {
		    try {
			realWidth = Integer.parseInt(width);
		    } catch (NumberFormatException e) {
		    }
		}
		if (height != null) {
		    try {
			realHeight = Integer.parseInt(height);
		    } catch (NumberFormatException e) {
		    }
		}

		BufferedImage img = model
			.getPhotoAsImage(realWidth, realHeight);
		if (img == null) {
		    response.sendRedirect("../../list");
		} else {
		    BufferedOutputStream output = new BufferedOutputStream(
			    response.getOutputStream());
		    ImageIO.write(img, "jpg", output);
		    output.close();
		}
	    } else {
		response.sendRedirect("../../list");
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * Download terminals data csv from query URL.
     * 
     * @param queryId
     *            the query id
     * @param response
     *            the response
     * @param request
     *            the request
     */
    @RequestMapping(value = "/terminals/export/{queryId}", method = RequestMethod.GET)
    public void downloadResultsCsvForQuery(
	    @PathVariable("queryId") Integer queryId,
	    HttpServletResponse response, HttpServletRequest request) {
	try {
	    response.setContentType("text/csv;charset=utf-8");
	    response.setHeader("Content-Disposition",
		    "attachment; filename=\"terminals.csv\"");
	    OutputStream resOs = response.getOutputStream();
	    OutputStream buffOs = new BufferedOutputStream(resOs);
	    OutputStreamWriter outputwriter = new OutputStreamWriter(buffOs);
	    outputwriter.write(Terminal.getCsvHeader());
	    List<Terminal> terminals = null;
	    if (queryId != null) {
		Query query = queryService.getQuery(queryId);
		if (query != null) {
		    logger.debug("Retrieving terminals from query " + queryId
			    + " for csv export");
		    terminals = queryService.executeQuery(query,
			    RequestContextUtils.getLocale(request));
		}
	    }
	    for (Terminal terminal : terminals) {
		outputwriter.write("\n" + terminal.getCsvDescription());
	    }
	    outputwriter.flush();
	    outputwriter.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

    /**
     * Download all terminals data as csv URL.
     * 
     * @param response
     *            the response
     * @param request
     *            the request
     * @param principal
     *            the principal
     */
    @RequestMapping(value = "/terminals/exportAll", method = RequestMethod.GET)
    public void downloadResultsCsv(HttpServletResponse response,
	    HttpServletRequest request, Principal principal) {
	try {
	    response.setContentType("text/csv;charset=utf-8");
	    response.setHeader("Content-Disposition",
		    "attachment; filename=\"terminals.csv\"");
	    OutputStream resOs = response.getOutputStream();
	    OutputStream buffOs = new BufferedOutputStream(resOs);
	    OutputStreamWriter outputwriter = new OutputStreamWriter(buffOs);
	    outputwriter.write(Terminal.getCsvHeader());
	    List<Terminal> terminals = null;
	    logger.debug("Exporting to CSV all terminals");
	    Set<BankCompany> banksCompanies = this.bankCompanyService
		    .getUserManageableBankCompanies(principal.getName());
	    terminals = this.atmservice.listATMByBanks(banksCompanies, null,
		    null);

	    for (Terminal terminal : terminals) {
		outputwriter.write("\n" + terminal.getCsvDescription());
	    }
	    outputwriter.flush();
	    outputwriter.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

    /**
     * New installation form URL.
     * 
     * @param map
     *            the map
     * @param matricula
     *            the generated id
     * @return the petition response
     */
    @RequestMapping(value = { "terminals/installations/new" }, method = RequestMethod.GET)
    public String newInstallationForm(Map<String, Object> map, String matricula) {
	Terminal terminal = null;
	if (matricula != null) {
	    try {
		terminal = this.atmservice.getATM(null,
			Long.parseLong(matricula), null, null);
	    } catch (NumberFormatException e) {
	    }
	}
	if (terminal == null) {
	    return "redirect:/terminals/list";
	}
	map.put("installation", new Installation());
	map.put("locationClasses", Installation.getLocationclasses());
	map.put("matricula", matricula);
	return "terminalInstallation";
    }

    /**
     * New installation URL.
     * 
     * @param installation
     *            the installation
     * @param result
     *            the result
     * @param map
     *            the map
     * @param matricula
     *            the generated id
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping(value = { "terminals/installations/new" }, method = RequestMethod.POST)
    public String newInstallation(
	    @Valid @ModelAttribute("installation") Installation installation,
	    BindingResult result, Map<String, Object> map, String matricula,
	    HttpServletRequest request, Principal principal) {
	Terminal terminal = null;
	if (matricula != null) {
	    try {
		terminal = this.atmservice.getATM(null,
			Long.parseLong(matricula), null, null);
	    } catch (NumberFormatException e) {
	    }
	}
	if (terminal == null) {
	    return "redirect:/terminals/list";
	}
	if ((installation.getLocation() != null)
		&& (installation.getLocation().getId() != null)) {
	    installation.setLocation(locationService.getLocation(installation
		    .getLocation().getId()));
	}
	this.atmservice.addUpdateATMInstallation(installation, AtmFacade.ADD);
	terminal.setCurrentInstallation(installation);
	this.atmservice.addUpdateATM(terminal, AtmFacade.UPDATE);
	map.put("installation", new Installation());
	map.put("locations", locationService.listLocations());
	return "closeIframeUpdateParent";
    }

    private Map<Location, List<Integer>> buildTerminalIdsByLocationModel(
	    List<Terminal> terminals, Date queryDate) {
	Map<Location, List<Integer>> terminalsLocationsInfo = new HashMap<Location, List<Integer>>();

	for (Terminal terminal : terminals) {
	    Installation installation = terminal
		    .getCurrentInstallationByDate(queryDate);
	    Location location = installation != null ? installation
		    .getLocation() : null;

	    if (location != null && location.hasCoordinates()) {
		List<Integer> terminalIds = terminalsLocationsInfo
			.get(location);
		if (terminalIds == null) {
		    terminalIds = new ArrayList<Integer>();
		    terminalsLocationsInfo.put(location, terminalIds);
		}
		terminalIds.add(terminal.getId());
	    }
	}

	return terminalsLocationsInfo;
    }
}
