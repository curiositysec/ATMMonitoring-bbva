package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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

import com.ncr.ATMMonitoring.controller.propertyeditor.DatePropertyEditor;
import com.ncr.ATMMonitoring.pojo.Installation;
import com.ncr.ATMMonitoring.pojo.Location;
import com.ncr.ATMMonitoring.service.InstallationService;
import com.ncr.ATMMonitoring.service.LocationService;
import com.ncr.ATMMonitoring.utils.Utils;

/**
 * The Class InstallationController.
 * 
 * Controller for handling installation related HTTP petitions.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Controller
public class InstallationController extends GenericController {

    /** The installations page size. */
    @Value("${config.installationsPageSize}")
    private int installationsPageSize;

    /** The locations page size. */
    @Value("${config.locationsPageSize}")
    private int locationsPageSize;

    /** The installation service. */
    @Autowired
    private InstallationService installationService;

    /** The location service. */
    @Autowired
    private LocationService locationService;

    // /** The user service. */
    // @Autowired
    // private UserService userService;

    /**
     * Binds custom editors.
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
     * Redirect to installations list URL.
     * 
     * @return the petition response
     */
    @RequestMapping(value = { "/terminals/installations" })
    public String redirectToInstallations() {
	return "redirect:/terminals/installations/list";
    }

    /**
     * List installations URL.
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
    @RequestMapping(value = "/terminals/installations/list", method = RequestMethod.GET)
    public String listInstallations(Map<String, Object> map,
	    Principal principal, String p, HttpServletRequest request) {
	String userMsg = "";
	// Locale locale = RequestContextUtils.getLocale(request);
	if (principal != null) {
	    // User loggedUser = userService
	    // .getUserByUsername(principal.getName());
	    // userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	    userMsg = this.getUserGreeting(principal, request);
	}
	PagedListHolder<Installation> pagedListHolder = new PagedListHolder<Installation>(
		installationService.listInstallations());
	map.put("userMsg", userMsg);
	map.put("installation", new Installation());
	int page = 0;
	if (p != null) {
	    try {
		page = Integer.parseInt(p);
	    } catch (NumberFormatException e) {
		e.printStackTrace();
	    }
	}
	map.put("locationsList", locationService.listLocations());
	pagedListHolder.setPage(page);
	pagedListHolder.setPageSize(installationsPageSize);
	map.put("pagedListHolder", pagedListHolder);

	return "installations";
    }

    /**
     * Add installation URL.
     * 
     * @param installation
     *            the installation
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
    @RequestMapping(value = "/terminals/installations/list", method = RequestMethod.POST)
    public String addInstallation(
	    @Valid @ModelAttribute("installation") Installation installation,
	    BindingResult result, Map<String, Object> map,
	    HttpServletRequest request, String p, Principal principal) {
	if ((installation.getLocation() != null)
		&& (installation.getLocation().getId() == null)) {
	    installation.setLocation(null);
	}

	if (result.hasErrors()) {
	    String userMsg = "";
	    // Locale locale = RequestContextUtils.getLocale(request);
	    if (principal != null) {
		// User loggedUser = userService.getUserByUsername(principal
		// .getName());
		// userMsg = loggedUser.getHtmlWelcomeMessage(locale);
		userMsg = this.getUserGreeting(principal, request);
	    }

	    PagedListHolder<Installation> pagedListHolder = new PagedListHolder<Installation>(
		    installationService.listInstallations());
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
	    pagedListHolder.setPageSize(installationsPageSize);
	    map.put("pagedListHolder", pagedListHolder);
	    map.put("userMsg", userMsg);
	    map.put("locationsList", locationService.listLocations());
	    return "installations";
	}

	installationService.addInstallation(installation);

	try {
	    // We wait to avoid not loading the recently added DB data
	    Thread.sleep(500);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	map.clear();
	return "redirect:/terminals/installations/list";
    }

    /**
     * Installation details URL.
     * 
     * @param installationId
     *            the installation id
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping("/terminals/installations/details/{installationId}")
    public String installationDetails(
	    @PathVariable("installationId") Integer installationId,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {
	Installation installation = installationService
		.getInstallation(installationId);
	if (installation == null) {
	    map.clear();
	    return "redirect:/terminals/installations/list";
	}
	String userMsg = "";
	// Locale locale = RequestContextUtils.getLocale(request);
	if (principal != null) {
	    // User loggedUser = userService
	    // .getUserByUsername(principal.getName());
	    // userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	    userMsg = this.getUserGreeting(principal, request);
	}
	map.put("userMsg", userMsg);
	map.put("installation", installation);
	map.put("locationsList", locationService.listLocations());

	return "installationDetails";
    }

    /**
     * Update installation URL.
     * 
     * @param installation
     *            the installation
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
    @RequestMapping(value = "/terminals/installations/update", method = RequestMethod.POST)
    public String updateInstallation(
	    @Valid @ModelAttribute("installation") Installation installation,
	    BindingResult result, Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {
	if ((installation.getLocation() != null)
		&& (installation.getLocation().getId() == null)) {
	    installation.setLocation(null);
	}

	if (result.hasErrors()) {
	    String userMsg = "";
	    // Locale locale = RequestContextUtils.getLocale(request);
	    if (principal != null) {
		// User loggedUser = userService.getUserByUsername(principal
		// .getName());
		// userMsg = loggedUser.getHtmlWelcomeMessage(locale);
		userMsg = this.getUserGreeting(principal, request);
	    }
	    map.put("userMsg", userMsg);

	    map.put("locationsList", locationService.listLocations());
	    return "installationDetails";
	}

	installationService.updateInstallation(installation);

	try {
	    // We wait to avoid not loading the recently added DB data
	    Thread.sleep(500);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	map.clear();
	return "redirect:/terminals/installations/details/"
		+ installation.getId().intValue();
    }

    /**
     * Delete installation URL.
     * 
     * @param installationId
     *            the installation id
     * @return the petition response
     */
    @RequestMapping("/terminals/installations/delete/{installationId}")
    public String deleteInstallation(
	    @PathVariable("installationId") Integer installationId) {
	Installation installation = installationService
		.getInstallation(installationId);
	if (installation != null) {
	    installationService.removeInstallation(installationId);
	}

	return "redirect:/terminals/installations/list";
    }

    /**
     * Redirect to locations URL.
     * 
     * @return the petition response
     */
    @RequestMapping(value = { "/terminals/locations" })
    public String redirectToLocations() {
	return "redirect:/terminals/locations/list";
    }

    /**
     * Search locations.
     * 
     * @param map
     *            the map
     * @param principal
     *            the principal
     * @param term
     *            the term to search by
     * @param request
     *            the request
     * @return the petition response
     */
    @RequestMapping(value = "/terminals/locations/search/{field}", method = RequestMethod.GET)
    public String searchLocations(@PathVariable("field") String field,
	    Map<String, Object> map, Principal principal, String term,
	    HttpServletRequest request) {
	map.put("locations",
		Utils.toJson(locationService.searchLocations(field, term)));
	return "locationSearchResults";
    }

    /**
     * List locations URL.
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
    @RequestMapping(value = "/terminals/locations/list", method = RequestMethod.GET)
    public String listLocations(Map<String, Object> map, Principal principal,
	    String p, HttpServletRequest request) {
	String userMsg = "";
	// Locale locale = RequestContextUtils.getLocale(request);
	if (principal != null) {
	    // User loggedUser = userService
	    // .getUserByUsername(principal.getName());
	    // userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	    userMsg = this.getUserGreeting(principal, request);
	}
	PagedListHolder<Location> pagedListHolder = new PagedListHolder<Location>(
		locationService.listLocations());
	map.put("userMsg", userMsg);
	map.put("location", new Location());
	int page = 0;
	if (p != null) {
	    try {
		page = Integer.parseInt(p);
	    } catch (NumberFormatException e) {
		e.printStackTrace();
	    }
	}
	pagedListHolder.setPage(page);
	pagedListHolder.setPageSize(locationsPageSize);
	map.put("pagedListHolder", pagedListHolder);

	return "locations";
    }

    /**
     * Add location URL.
     * 
     * @param location
     *            the location
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
    @RequestMapping(value = "/terminals/locations/list", method = RequestMethod.POST)
    public String addLocation(
	    @Valid @ModelAttribute("location") Location location,
	    BindingResult result, Map<String, Object> map,
	    HttpServletRequest request, String p, Principal principal) {

	if (result.hasErrors()) {
	    String userMsg = "";
	    // Locale locale = RequestContextUtils.getLocale(request);
	    if (principal != null) {
		// User loggedUser = userService.getUserByUsername(principal
		// .getName());
		// userMsg = loggedUser.getHtmlWelcomeMessage(locale);
		userMsg = this.getUserGreeting(principal, request);
	    }

	    PagedListHolder<Location> pagedListHolder = new PagedListHolder<Location>(
		    locationService.listLocations());
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
	    pagedListHolder.setPageSize(locationsPageSize);
	    map.put("pagedListHolder", pagedListHolder);
	    map.put("userMsg", userMsg);
	    return "locations";
	}

	locationService.addLocation(location);

	try {
	    // We wait to avoid not loading the recently added DB data
	    Thread.sleep(500);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	map.clear();
	return "redirect:/terminals/locations/list";
    }

    /**
     * Location details URL.
     * 
     * @param locationId
     *            the location id
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping("/terminals/locations/details/{locationId}")
    public String locationDetails(
	    @PathVariable("locationId") Integer locationId,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {
	Location location = locationService.getLocation(locationId);
	if (location == null) {
	    map.clear();
	    return "redirect:/terminals/locations/list";
	}
	String userMsg = "";
	// Locale locale = RequestContextUtils.getLocale(request);
	if (principal != null) {
	    // User loggedUser = userService
	    // .getUserByUsername(principal.getName());
	    // userMsg = loggedUser.getHtmlWelcomeMessage(locale);
	    userMsg = this.getUserGreeting(principal, request);
	}
	map.put("userMsg", userMsg);
	map.put("location", location);

	return "locationDetails";
    }

    /**
     * Update location URL.
     * 
     * @param location
     *            the location
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
    @RequestMapping(value = "/terminals/locations/update", method = RequestMethod.POST)
    public String updateLocation(
	    @Valid @ModelAttribute("location") Location location,
	    BindingResult result, Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {

	if (result.hasErrors()) {
	    String userMsg = "";
	    // Locale locale = RequestContextUtils.getLocale(request);
	    if (principal != null) {
		// User loggedUser = userService.getUserByUsername(principal
		// .getName());
		// userMsg = loggedUser.getHtmlWelcomeMessage(locale);
		userMsg = this.getUserGreeting(principal, request);
	    }
	    map.put("userMsg", userMsg);
	    return "locationDetails";
	}

	locationService.updateLocation(location);

	try {
	    // We wait to avoid not loading the recently added DB data
	    Thread.sleep(500);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	map.clear();
	return "redirect:/terminals/locations/details/"
		+ location.getId().intValue();
    }

    /**
     * Delete location URL.
     * 
     * @param locationId
     *            the location id
     * @return the petition response
     */
    @RequestMapping("/terminals/locations/delete/{locationId}")
    public String deleteLocation(@PathVariable("locationId") Integer locationId) {
	Location location = locationService.getLocation(locationId);
	if (location != null) {
	    locationService.removeLocation(locationId);
	}

	return "redirect:/terminals/locations/list";
    }
}