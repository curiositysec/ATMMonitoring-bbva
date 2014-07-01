package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ncr.ATMMonitoring.controller.propertyeditor.DatePropertyEditor;
import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.ScheduledUpdate;
import com.ncr.ATMMonitoring.service.QueryService;
import com.ncr.ATMMonitoring.servicefacade.AtmFacade;

/**
 * The Class ScheduledUpdateController.
 * 
 * Controller for handling scheduled update related HTTP petitions.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Controller
public class ScheduledUpdateController extends GenericController {

    /** The logger. */
    private static Logger logger = Logger
	    .getLogger(ScheduledUpdateController.class.getName());

    /** The agent push comm model state. */
    @Value("${config.agentPushState}")
    private String agentPushState;

    /** The event date formatter. */
    private static SimpleDateFormat eventDateFormat = new SimpleDateFormat(
	    "yyyy-MM-dd'T'HH:mm:ss'Z'");

    /** The weekly title date formatter. */
    private static SimpleDateFormat weeklyTitleDateFormat = new SimpleDateFormat(
	    "EEEE");

    /** The monthly title date formatter. */
    private static SimpleDateFormat monthlyTitleDateFormat = new SimpleDateFormat(
	    "'día' d");

    /** The event duration in milliseconds. */
    private static long EVENT_DURATION_IN_MILLIS = 60 * 60 * 1000;

    /** The atm service facade. */
    @Autowired
    private AtmFacade atmService;

    /** The query service */
    @Autowired
    private QueryService queryService;

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
	binder.registerCustomEditor(Date.class, new DatePropertyEditor(true));
    }

    /**
     * List schedules URL.
     * 
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping(value = "/terminals/schedules/list", method = RequestMethod.GET)
    public String listSchedules(Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {
	if (agentPushState.equalsIgnoreCase("on")) {
	    return "redirect:/dashboard";
	}
	String userMsg = "";
	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	    map.put("userMsg", userMsg);
	    map.put("weeklyScheduledUpdates",
		    this.atmService.listScheduledUpdates(AtmFacade.WEEKLY));
	    map.put("monthlyScheduledUpdates",
		    this.atmService.listScheduledUpdates(AtmFacade.MONTHLY));
	}
	return "scheduledUpdates";
    }

    /**
     * New scheduled update.
     * 
     * @param map
     *            the map
     * @param queryId
     *            the query id
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping(value = "/terminals/schedules/new", method = RequestMethod.GET)
    public String newScheduledUpdate(Map<String, Object> map, String queryId,
	    HttpServletRequest request, Principal principal) {
	if (agentPushState.equalsIgnoreCase("on")) {
	    return "redirect:/dashboard";
	}
	String userMsg = "";
	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	    Set<Query> userQueries = this.queryService
		    .getQueriesByUser(principal.getName());
	    map.put("userQueries", userQueries);
	    map.put("userMsg", userMsg);
	    map.put("scheduledUpdate", new ScheduledUpdate());
	}
	if (queryId != null) {

	    Query query = new Query();
	    query.setId(Integer.parseInt(queryId));
	    map.put("query", query);
	}
	return "newScheduledUpdate";
    }

    /**
     * List update events between two dates.
     * 
     * @param start
     *            the start date
     * @param end
     *            the end date
     * @param principal
     *            the principal
     * @return the list of update events
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/terminals/schedules/updates", method = RequestMethod.GET)
    @ResponseBody
    public List<Map> listUpdateEvents(long start, long end, Principal principal) {
	if (agentPushState.equalsIgnoreCase("on")) {
	    return new ArrayList<Map>();
	}
	logger.debug("update events from " + start + " to " + end);
	List<ScheduledUpdate> updates = null;
	if (principal != null) {
	    updates = new ArrayList<ScheduledUpdate>();
	    List<ScheduledUpdate> weeklyUpdates = this.atmService
		    .listScheduledUpdates(principal.getName(), AtmFacade.WEEKLY);
	    List<ScheduledUpdate> monthlyUpdates = this.atmService
		    .listScheduledUpdates(principal.getName(),
			    AtmFacade.MONTHLY);
	    updates = new ArrayList<ScheduledUpdate>();
	    updates.addAll(weeklyUpdates);
	    updates.addAll(monthlyUpdates);
	}
	return toCalendarEventsJSON(updates, start, end);
    }

    /**
     * Adds the scheduled update.
     * 
     * @param scheduledUpdate
     *            the scheduled update
     * @param result
     *            the result
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @param redirectAttributes
     *            the redirect attributes
     * @return the petition response
     */
    @RequestMapping(value = "/terminals/schedules/list", method = RequestMethod.POST)
    public String addScheduledUpdate(
	    @Valid @ModelAttribute("scheduledUpdate") ScheduledUpdate scheduledUpdate,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal, RedirectAttributes redirectAttributes) {
	if (agentPushState.equalsIgnoreCase("on")) {
	    return "redirect:/dashboard";
	}
	String userMsg = "";
	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	    Set<Query> userQueries = this.queryService
		    .getQueriesByUser(principal.getName());
	    map.put("userQueries", userQueries);
	    map.put("userMsg", userMsg);
	}

	logger.debug("update's query': " + scheduledUpdate.getQuery().getId());

	if ((scheduledUpdate.getQuery() == null)
		|| (scheduledUpdate.getQuery().getId() == null)) {
	    map.put("error", "scheduledUpdate.nullQuery");
	} else if ((scheduledUpdate.getWeekDay() == null)
		&& (scheduledUpdate.getMonthDay() == null)) {
	    map.put("error", "scheduledUpdate.missing.mandatory.fields");
	} else if (this.atmService.existScheduledUpdate(scheduledUpdate)) {
	    map.put("error", "duplicated.scheduledUpdate");
	}

	if (map.get("error") != null) {
	    ScheduledUpdate newScheduledUpdate = scheduledUpdate;
	    map.put("scheduledUpdate", newScheduledUpdate);
	    return "newScheduledUpdate";
	} else {
	    this.atmService.addScheduledUpdate(scheduledUpdate);
	    redirectAttributes.addFlashAttribute("success",
		    "label.new.scheduledUpdate.created");
	    map.clear();
	    return "redirect:/terminals/schedules/list";
	}
    }

    /**
     * Redirect to schedules.
     * 
     * @return the petition response
     */
    @RequestMapping("/terminals/schedules")
    public String redirectToSchedules() {
	return "redirect:/terminals/schedules/list";
    }

    /**
     * Delete scheduled update.
     * 
     * @param scheduledUpdateId
     *            the scheduled update id
     * @param redirectAttributes
     *            the redirect attributes
     * @return the petition response
     */
    @RequestMapping("/terminals/schedules/delete/{scheduledUpdateId}")
    public String deleteScheduledUpdate(
	    @PathVariable("scheduledUpdateId") Integer scheduledUpdateId,
	    RedirectAttributes redirectAttributes) {
	if (agentPushState.equalsIgnoreCase("on")) {
	    return "redirect:/dashboard";
	}
	this.atmService.removeScheduledUpdate(scheduledUpdateId);
	redirectAttributes.addFlashAttribute("success",
		"label.new.scheduledUpdate.deleted");
	return "redirect:/terminals/schedules/list";
    }

    /**
     * Transforms a json with events into a list of HashMaps with their data.
     * 
     * @param updates
     *            the updates
     * @param from
     *            the start date
     * @param to
     *            the end date
     * @return the list of HashMap events
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private List<Map> toCalendarEventsJSON(List<ScheduledUpdate> updates,
	    long from, long to) {
	logger.debug("updates: " + updates);
	List<Map> json = new ArrayList();
	if (updates != null) {
	    for (ScheduledUpdate update : updates) {
		List<Date> eventDates = update.getEventDates(from, to);
		for (Date eventDate : eventDates) {
		    Map event = new HashMap();
		    event.put("id", update.getId());
		    event.put("className", (update.isWeekly()) ? "weekly"
			    : "monthly");
		    SimpleDateFormat titleDateFormat = (update.isWeekly()) ? weeklyTitleDateFormat
			    : monthlyTitleDateFormat;
		    event.put("title", titleDateFormat.format(eventDate));
		    event.put("start",
			    eventDateFormat.format(eventDate.getTime()));
		    Date endDate = new Date(eventDate.getTime()
			    + EVENT_DURATION_IN_MILLIS);
		    event.put("end", eventDateFormat.format(endDate.getTime()));
		    json.add(event);
		}
	    }
	}
	return json;
    }

}
