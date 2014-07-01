package com.ncr.ATMMonitoring.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.util.WebUtils;

import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.ATMMonitoring.pojo.Ups;
import com.ncr.ATMMonitoring.pojo.UpsQuery;
import com.ncr.ATMMonitoring.pojo.User;
import com.ncr.ATMMonitoring.service.QueryService;
import com.ncr.ATMMonitoring.service.UserService;

/**
 * The Class QueryController.
 * 
 * Controller for handling query related HTTP petitions.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */
@Controller
public class QueryController extends GenericController {

    /** The logger. */
    static private Logger logger = Logger.getLogger(QueryController.class
	    .getName());

    /** The default field for sorting terminals in csv downloads. */
    public static final String DEFAULT_SORT = "serialNumber";

    /** The default sorting order for terminals in csv downloads. */
    public static final String DEFAULT_ORDER = "asc";

    /** The default field for sorting UPS in csv downloads. */
    public static final String DEFAULT_UPS_SORT = "seriesNumber";

    /** The default sorting order for UPS in csv downloads. */
    public static final String DEFAULT_UPS_ORDER = "asc";

    /** The query page size. */
    @Value("${config.queriesPageSize}")
    private int pageSize;

    /** The query service. */
    @Autowired
    private QueryService queryService;

    /** The user service. */
    @Autowired
    private UserService userService;

    /**
     * Create query URL.
     * 
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping(value = "/queries/create", method = RequestMethod.GET)
    public String createQuery(Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {
	String userMsg = "";
	Locale locale = RequestContextUtils.getLocale(request);

	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	}

	String datePattern = ((SimpleDateFormat) DateFormat.getDateInstance(
		DateFormat.SHORT, locale)).toLocalizedPattern();

	if (!datePattern.contains("dd")) {
	    datePattern = datePattern.replace("d", "dd");
	}

	map.put("userMsg", userMsg);
	map.put("query", new Query());
	map.put("values", Query.getComboboxes());

	return "newQuery";

    }

    /**
     * Show user query URL.
     * 
     * @param queryId
     *            the query id
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping(value = "/queries/show", method = RequestMethod.GET)
    public String showUserQuery(Integer queryId, Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {

	String userMsg = "";
	Query query = null;

	if (queryId != null) {
	    query = queryService.getQuery(queryId);
	}

	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	}

	map.put("userMsg", userMsg);
	map.put("query", query);
	map.put("values", Query.getComboboxes());

	return "queries";

    }

    /**
     * Delete user query URL.
     * 
     * @param queryId
     *            the query id
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping(value = "/queries/delete", method = RequestMethod.GET)
    public String deleteUserQuery(Integer queryId, Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {

	String userMsg = "";
	Query query = null;
	Set<Query> userQueries = null;

	if (queryId != null) {
	    query = queryService.getQuery(queryId);
	    if (query != null) {
		try {
		    queryService.deleteQuery(query);
		    map.put("success", "success.deletingNewQuery");
		} catch (Throwable e) {
		    map.put("error", "error.deletingQuery");
		}
	    }
	}

	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	}
	PagedListHolder<Query> pagedListHolder = new PagedListHolder<Query>(
		new ArrayList<Query>(userQueries));
	int page = 0;

	pagedListHolder.setPage(page);
	pagedListHolder.setPageSize(pageSize);
	map.put("pagedListHolder", pagedListHolder);

	map.put("userMsg", userMsg);

	return "queryList";

    }

    /**
     * Select user query URL.
     * 
     * @param query
     *            the query
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping(value = "/queries/create", method = RequestMethod.POST)
    public String selectUserQuery(@ModelAttribute("query") Query query,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {
	Set<Query> userQueries = null;
	String userMsg = "";

	Locale locale = RequestContextUtils.getLocale(request);

	if (query.getId() != null) {
	    query = queryService.getQuery(query.getId());
	    if (WebUtils.hasSubmitParameter(request, "delete")) {
		queryService.deleteQuery(query);
		query = new Query();
	    }
	} else {
	    query = new Query();
	}

	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	}

	String datePattern = ((SimpleDateFormat) DateFormat.getDateInstance(
		DateFormat.SHORT, locale)).toLocalizedPattern();

	if (!datePattern.contains("dd")) {
	    datePattern = datePattern.replace("d", "dd");
	}

	map.put("userMsg", userMsg);
	map.put("query", query);
	map.put("userQueries", userQueries);
	map.put("datePattern", datePattern);
	map.put("values", Query.getComboboxes());

	return "queries";

    }

    /**
     * Redirect to queries URL.
     * 
     * @return the petition response
     */
    @RequestMapping("/queries")
    public String redirectToQueries() {
	return "redirect:/queries/list";
    }

    /**
     * List queries URL.
     * 
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
    @RequestMapping("/queries/list")
    public String listQueries(Map<String, Object> map,
	    HttpServletRequest request, Principal principal, String p) {
	Set<Query> userQueries = null;
	String userMsg = "";

	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	    userQueries = this.queryService.getQueriesByUser(principal
		    .getName());
	}

	PagedListHolder<Query> pagedListHolder = new PagedListHolder<Query>(
		new ArrayList<Query>(userQueries));
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
	map.put("userMsg", userMsg);
	return "queryList";
    }

    /**
     * Save or update query URL.
     * 
     * @param query
     *            the query
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @param redirectAttributes
     *            the redirect attributes
     * @param p
     *            the page number
     * @param sort
     *            the sort
     * @param order
     *            the order
     * @return the petition response
     * @throws Exception
     *             the exception
     */
    @RequestMapping(value = "/queries/results", method = RequestMethod.POST)
    public String saveOrUpdateQuery(@ModelAttribute("query") Query query,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal, RedirectAttributes redirectAttributes,
	    String p, String sort, String order) throws Exception {

	Locale locale = RequestContextUtils.getLocale(request);

	if (WebUtils.hasSubmitParameter(request, "save")) {
	    if (principal != null) {
		User loggedUser = userService.getUserByUsername(principal
			.getName());
		query.setUser(loggedUser);
		if (query.getName() != null
			&& !query.getName().trim().isEmpty()) {
		    if (query.getId() != null) {
			try {
			    logger.debug("Updating query - " + query.getName());
			    queryService.updateQuery(query);
			    redirectAttributes.addFlashAttribute("success",
				    "success.updatingQuery");
			} catch (Exception e) {
			    redirectAttributes.addFlashAttribute("error",
				    "error.updatingQuery");
			}
		    } else {
			query.setCreationDate(new Date());
			query.setTrueLocale(locale);
			try {
			    logger.debug("Guardando nueva query- "
				    + query.getName());
			    queryService.addQuery(query);
			    redirectAttributes.addFlashAttribute("success",
				    "success.savingNewQuery");
			} catch (Exception e) {
			    redirectAttributes.addFlashAttribute("error",
				    "error.savingNewQuery");
			}
		    }
		} else {
		    map.put("error", "query.name.blank");
		    map.put("userMsg", loggedUser.getHtmlWelcomeMessage(locale));
		    map.put("query", query);
		    map.put("values", Query.getComboboxes());

		    return "newQuery";
		}
	    }
	    return "redirect:/queries/list";
	} else if (WebUtils.hasSubmitParameter(request, "update")) {
	    if (principal != null) {
		if (query.getId() != null) {
		    try {
			logger.debug("Updating query - " + query.getName());
			this.queryService.updateQuery(query,
				principal.getName());
			redirectAttributes.addFlashAttribute("success",
				"success.updatingQuery");
		    } catch (Exception e) {
			redirectAttributes.addFlashAttribute("error",
				"error.updatingQuery");
		    }
		} else {
		    query.setCreationDate(new Date());
		    query.setTrueLocale(locale);
		    try {
			logger.debug("Guardando nueva query- "
				+ query.getName());
			queryService.addQuery(query, principal.getName());
			redirectAttributes.addFlashAttribute("success",
				"success.savingNewQuery");
		    } catch (Exception e) {
			redirectAttributes.addFlashAttribute("error",
				"error.savingNewQuery");
		    }
		}
	    }
	    return "redirect:/queries/list";
	} else if (WebUtils.hasSubmitParameter(request, "execute")) {
	    logger.debug("Executing query... " + query.getName());
	    String sortValue = (sort == null) ? DEFAULT_SORT : sort;
	    String orderValue = (order == null) ? DEFAULT_ORDER : order;
	    List<Terminal> terminals = queryService.executeQuery(query, locale,
		    sortValue, orderValue);

	    logger.debug("terminals " + terminals);

	    if (terminals == null) {
		throw new Exception("Query execution returned a NULL list.");
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

	    logger.debug("pageListHolder " + pagedListHolder);

	    map.put("userMsg", this.getUserGreeting(principal, request));
	    map.put("pagedListHolder", pagedListHolder);
	    map.put("query", query);
	    map.put("values", Query.getComboboxes());
	    map.put("p", page);
	    map.put("sort", sortValue);
	    map.put("order", orderValue);

	} else if (WebUtils.hasSubmitParameter(request, "delete")) {
	    logger.debug("Deleting query -" + query.getName());
	    return "redirect:/queries/delete?queryId=" + query.getId();
	}
	return "queryResults";

    }

    /**
     * Wrong download query results as csv URL.
     * 
     * @return the petition response
     */
    @RequestMapping(value = "/queries/results", method = RequestMethod.GET)
    public String redirectFromWrongResults() {
	return "redirect:/queries/create";
    }

    /**
     * Wrong download query results as csv URL.
     * 
     * @return the petition response
     */
    @RequestMapping(value = "/queries/results/export", method = RequestMethod.GET)
    public String redirectFromWrongResultsExport() {
	return "redirect:/queries/create";
    }

    /**
     * Download query results as csv URL.
     * 
     * @param query
     *            the query
     * @param response
     *            the response
     * @param request
     *            the request
     * @param sort
     *            the fields for sorting the results
     * @param order
     *            the sorting order
     */
    @RequestMapping(value = "/queries/results/export", method = RequestMethod.POST)
    public void downloadResultsCsv(@ModelAttribute("query") Query query,
	    HttpServletResponse response, HttpServletRequest request,
	    String sort, String order) {
	try {
	    String sortValue = (sort == null) ? DEFAULT_SORT : sort;
	    String orderValue = (order == null) ? DEFAULT_ORDER : order;
	    response.setContentType("text/csv;charset=utf-8");
	    response.setHeader("Content-Disposition",
		    "attachment; filename=\"terminals.csv\"");
	    OutputStream resOs = response.getOutputStream();
	    OutputStream buffOs = new BufferedOutputStream(resOs);
	    OutputStreamWriter outputwriter = new OutputStreamWriter(buffOs);
	    outputwriter.write(Terminal.getCsvHeader());
	    List<Terminal> terminals = queryService.executeQuery(query,
		    RequestContextUtils.getLocale(request), sortValue,
		    orderValue);
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
     * Create UPS query URL.
     * 
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping(value = "/upsQueries/create", method = RequestMethod.GET)
    public String createUpsQuery(Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {
	String userMsg = "";

	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	}

	map.put("userMsg", userMsg);
	map.put("query", new UpsQuery());
	map.put("values", UpsQuery.getComboboxes());

	return "newUpsQuery";

    }

    /**
     * Show user UPS query URL.
     * 
     * @param queryId
     *            the UPS query id
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping(value = "/upsQueries/show", method = RequestMethod.GET)
    public String showUserUpsQuery(Integer queryId, Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {

	String userMsg = "";
	UpsQuery query = null;

	if (queryId != null) {
	    query = queryService.getUpsQuery(queryId);
	}

	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	}

	map.put("userMsg", userMsg);
	map.put("query", query);
	map.put("values", UpsQuery.getComboboxes());

	return "upsQueries";

    }

    /**
     * Delete user UPS query URL.
     * 
     * @param queryId
     *            the UPS query id
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping(value = "/upsQueries/delete", method = RequestMethod.GET)
    public String deleteUserUpsQuery(Integer queryId, Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {

	String userMsg = "";
	UpsQuery query = null;
	Set<UpsQuery> userQueries = new HashSet<UpsQuery>();

	if (queryId != null) {
	    query = queryService.getUpsQuery(queryId);
	    if (query != null) {
		try {
		    queryService.deleteUpsQuery(query);
		    map.put("success", "success.deletingNewQuery");
		} catch (Throwable e) {
		    map.put("error", "error.deletingQuery");
		}
	    }
	}

	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	    userQueries = this.queryService.getUpsQueriesByUser(principal
		    .getName());
	}
	PagedListHolder<UpsQuery> pagedListHolder = new PagedListHolder<UpsQuery>(
		new ArrayList<UpsQuery>(userQueries));
	int page = 0;

	pagedListHolder.setPage(page);
	pagedListHolder.setPageSize(pageSize);
	map.put("pagedListHolder", pagedListHolder);

	map.put("userMsg", userMsg);

	return "upsQueryList";

    }

    /**
     * Select user UPS query URL.
     * 
     * @param query
     *            the UPS query
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping(value = "/upsQueries/create", method = RequestMethod.POST)
    public String selectUserUpsQuery(@ModelAttribute("query") UpsQuery query,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {
	Set<Query> userQueries = null;
	String userMsg = "";

	if (query.getId() != null) {
	    query = queryService.getUpsQuery(query.getId());
	    if (WebUtils.hasSubmitParameter(request, "delete")) {
		queryService.deleteUpsQuery(query);
		query = new UpsQuery();
	    }
	} else {
	    query = new UpsQuery();
	}

	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	}

	map.put("userMsg", userMsg);
	map.put("query", query);
	map.put("userQueries", userQueries);
	map.put("values", UpsQuery.getComboboxes());

	return "upsQueries";

    }

    /**
     * Redirect to UPS queries URL.
     * 
     * @return the petition response
     */
    @RequestMapping("/upsQueries")
    public String redirectToUpsQueries() {
	return "redirect:/upsQueries/list";
    }

    /**
     * List UPS queries URL.
     * 
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
    @RequestMapping("/upsQueries/list")
    public String listUpsQueries(Map<String, Object> map,
	    HttpServletRequest request, Principal principal, String p) {
	Set<UpsQuery> userQueries = null;
	String userMsg = "";

	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	    userQueries = this.queryService.getUpsQueriesByUser(principal
		    .getName());
	}

	PagedListHolder<UpsQuery> pagedListHolder = new PagedListHolder<UpsQuery>(
		new ArrayList<UpsQuery>(userQueries));
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
	map.put("userMsg", userMsg);
	return "upsQueryList";
    }

    /**
     * Save or update UPS query URL.
     * 
     * @param query
     *            the UPS query
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @param redirectAttributes
     *            the redirect attributes
     * @param p
     *            the page number
     * @param sort
     *            the sort
     * @param order
     *            the order
     * @return the petition response
     * @throws Exception
     *             the exception
     */
    @RequestMapping(value = "/upsQueries/results", method = RequestMethod.POST)
    public String saveOrUpdateUpsQuery(@ModelAttribute("query") UpsQuery query,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal, RedirectAttributes redirectAttributes,
	    String p, String sort, String order) throws Exception {

	Locale locale = RequestContextUtils.getLocale(request);

	if (WebUtils.hasSubmitParameter(request, "save")) {
	    if (principal != null) {
		User loggedUser = userService.getUserByUsername(principal
			.getName());
		query.setUser(loggedUser);
		if (query.getName() != null
			&& !query.getName().trim().isEmpty()) {
		    if (query.getId() != null) {
			try {
			    logger.debug("Updating UPS query - "
				    + query.getName());
			    queryService.updateUpsQuery(query);
			    redirectAttributes.addFlashAttribute("success",
				    "success.updatingQuery");
			} catch (Exception e) {
			    redirectAttributes.addFlashAttribute("error",
				    "error.updatingQuery");
			}
		    } else {
			query.setCreationDate(new Date());
			query.setTrueLocale(locale);
			try {
			    logger.debug("Saving new UPS query- "
				    + query.getName());
			    queryService.addUpsQuery(query);
			    redirectAttributes.addFlashAttribute("success",
				    "success.savingNewQuery");
			} catch (Exception e) {
			    redirectAttributes.addFlashAttribute("error",
				    "error.savingNewQuery");
			}
		    }
		} else {
		    map.put("error", "query.name.blank");
		    map.put("userMsg", loggedUser.getHtmlWelcomeMessage(locale));
		    map.put("query", query);
		    map.put("values", UpsQuery.getComboboxes());

		    return "newUpsQuery";
		}
	    }
	    return "redirect:/upsQueries/list";
	} else if (WebUtils.hasSubmitParameter(request, "update")) {
	    if (principal != null) {
		if (query.getId() != null) {
		    try {
			logger.debug("Updating UPS query - " + query.getName());
			this.queryService.updateUpsQuery(query,
				principal.getName());
			redirectAttributes.addFlashAttribute("success",
				"success.updatingQuery");
		    } catch (Exception e) {
			redirectAttributes.addFlashAttribute("error",
				"error.updatingQuery");
		    }
		} else {
		    query.setCreationDate(new Date());
		    query.setTrueLocale(locale);
		    try {
			logger.debug("Guardando nueva query- "
				+ query.getName());
			queryService.addUpsQuery(query, principal.getName());
			redirectAttributes.addFlashAttribute("success",
				"success.savingNewQuery");
		    } catch (Exception e) {
			redirectAttributes.addFlashAttribute("error",
				"error.savingNewQuery");
		    }
		}
	    }
	    return "redirect:/upsQueries/list";
	} else if (WebUtils.hasSubmitParameter(request, "execute")) {
	    logger.debug("Executing query... " + query.getName());
	    String sortValue = (sort == null) ? DEFAULT_UPS_SORT : sort;
	    String orderValue = (order == null) ? DEFAULT_UPS_ORDER : order;
	    List<Ups> ups = queryService.executeUpsQuery(query, locale,
		    sortValue, orderValue);

	    logger.debug("ups " + ups);

	    if (ups == null) {
		throw new Exception("UPS query execution returned a NULL list.");
	    }

	    PagedListHolder<Ups> pagedListHolder = new PagedListHolder<Ups>(ups);
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

	    logger.debug("pageListHolder " + pagedListHolder);

	    map.put("userMsg", this.getUserGreeting(principal, request));
	    map.put("pagedListHolder", pagedListHolder);
	    map.put("query", query);
	    map.put("values", UpsQuery.getComboboxes());
	    map.put("p", page);
	    map.put("sort", sortValue);
	    map.put("order", orderValue);

	} else if (WebUtils.hasSubmitParameter(request, "delete")) {
	    logger.debug("Deleting UPS query -" + query.getName());
	    return "redirect:/upsQueries/delete?queryId=" + query.getId();
	}
	return "upsQueryResults";

    }

    /**
     * Wrong download UPS query results as csv URL.
     * 
     * @return the petition response
     */
    @RequestMapping(value = "/upsQueries/results", method = RequestMethod.GET)
    public String redirectFromWrongResultsUps() {
	return "redirect:/upsQueries/create";
    }

    /**
     * Wrong download query results as csv URL.
     * 
     * @return the petition response
     */
    @RequestMapping(value = "/upsQueries/results/export", method = RequestMethod.GET)
    public String redirectFromWrongResultsExportUps() {
	return "redirect:/upsQueries/create";
    }

    /**
     * Download UPS query results as csv URL.
     * 
     * @param query
     *            the UPS query
     * @param response
     *            the response
     * @param request
     *            the request
     * @param sort
     *            the fields for sorting the results
     * @param order
     *            the sorting order
     */
    @RequestMapping(value = "/upsQueries/results/export", method = RequestMethod.POST)
    public void downloadUpsResultsCsv(@ModelAttribute("query") UpsQuery query,
	    HttpServletResponse response, HttpServletRequest request,
	    String sort, String order) {
	try {
	    String sortValue = (sort == null) ? DEFAULT_UPS_SORT : sort;
	    String orderValue = (order == null) ? DEFAULT_UPS_ORDER : order;
	    response.setContentType("text/csv;charset=utf-8");
	    response.setHeader("Content-Disposition",
		    "attachment; filename=\"ups.csv\"");
	    OutputStream resOs = response.getOutputStream();
	    OutputStream buffOs = new BufferedOutputStream(resOs);
	    OutputStreamWriter outputwriter = new OutputStreamWriter(buffOs);
	    outputwriter.write(Ups.getCsvHeader());
	    List<Ups> upss = queryService.executeUpsQuery(query,
		    RequestContextUtils.getLocale(request), sortValue,
		    orderValue);
	    for (Ups ups : upss) {
		outputwriter.write("\n" + ups.getCsvDescription());
	    }
	    outputwriter.flush();
	    outputwriter.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

}
