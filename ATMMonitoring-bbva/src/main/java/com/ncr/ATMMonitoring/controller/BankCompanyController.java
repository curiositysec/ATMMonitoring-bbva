package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.service.BankCompanyService;

/**
 * The Class BankCompanyController.
 * 
 * Controller for handling bank company related HTTP petitions.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Controller
public class BankCompanyController extends GenericController {

    /** The bank companies page size. */
    @Value("${config.bankCompaniesPageSize}")
    private int bankCompaniesPageSize;

    /** The bank company service. */
    @Autowired
    private BankCompanyService bankCompanyService;

    /**
     * Redirect to bank companies URL.
     * 
     * @return the petition response
     */
    @RequestMapping(value = { "/banks" })
    public String redirectToBankCompanies() {
	return "redirect:/banks/list";
    }

    /**
     * List bank companies URL.
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
    @RequestMapping(value = "/banks/list", method = RequestMethod.GET)
    public String listBankCompanies(Map<String, Object> map,
	    Principal principal, String p, HttpServletRequest request) {
	String userMsg = "";
	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	}
	PagedListHolder<BankCompany> pagedListHolder = new PagedListHolder<BankCompany>(
		bankCompanyService.listBankCompanies());
	map.put("userMsg", userMsg);
	map.put("bankCompany", new BankCompany());
	int page = 0;
	if (p != null) {
	    try {
		page = Integer.parseInt(p);
	    } catch (NumberFormatException e) {
		e.printStackTrace();
	    }
	}
	pagedListHolder.setPage(page);
	pagedListHolder.setPageSize(bankCompaniesPageSize);
	map.put("pagedListHolder", pagedListHolder);
	map.put("bankCompaniesList", bankCompanyService.listBankCompanies());

	return "bankCompanies";
    }

    /**
     * Add bank company URL.
     * 
     * @param bankCompany
     *            the bank company
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
    @RequestMapping(value = "/banks/list", method = RequestMethod.POST)
    public String addBankCompany(
	    @Valid @ModelAttribute("bankCompany") BankCompany bankCompany,
	    BindingResult result, Map<String, Object> map,
	    HttpServletRequest request, String p, Principal principal) {
	if ((bankCompany.getParentCompany() != null)
		&& (bankCompany.getParentCompany().getId() == null)) {
	    bankCompany.setParentCompany(null);
	}

	if (result.hasErrors()) {
	    String userMsg = "";
	    if (principal != null) {
		userMsg = this.getUserGreeting(principal, request);
	    }
	    map.put("userMsg", userMsg);

	    PagedListHolder<BankCompany> pagedListHolder = new PagedListHolder<BankCompany>(
		    bankCompanyService.listBankCompanies());
	    int page = 0;
	    if (p != null) {
		try {
		    page = Integer.parseInt(p);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
	    }
	    pagedListHolder.setPage(page);
	    pagedListHolder.setPageSize(bankCompaniesPageSize);
	    map.put("pagedListHolder", pagedListHolder);
	    map.put("userMsg", userMsg);
	    map.put("bankCompaniesList", bankCompanyService.listBankCompanies());
	    return "bankCompanies";
	}

	bankCompanyService.addBankCompany(bankCompany);

	try {
	    // We wait to avoid not loading the recently added DB data
	    Thread.sleep(500);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	map.clear();
	return "redirect:/banks/list";
    }

    /**
     * Bank company details URL.
     * 
     * @param bankCompanyId
     *            the bank company id
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping("/banks/details/{bankCompanyId}")
    public String bankCompanyDetails(
	    @PathVariable("bankCompanyId") Integer bankCompanyId,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {
	BankCompany bankCompany = bankCompanyService
		.getBankCompany(bankCompanyId);
	if (bankCompany == null) {
	    map.clear();
	    return "redirect:/banks/list";
	}
	String userMsg = "";
	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	}
	map.put("userMsg", userMsg);
	map.put("bankCompany", bankCompany);
	map.put("bankCompaniesList", bankCompanyService.listBankCompanies());

	return "bankCompanyDetails";
    }

    /**
     * Update bank company URL.
     * 
     * @param bankCompany
     *            the bank company
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
    @RequestMapping(value = "/banks/update", method = RequestMethod.POST)
    public String updateBankCompany(
	    @Valid @ModelAttribute("bankCompany") BankCompany bankCompany,
	    BindingResult result, Map<String, Object> map,
	    HttpServletRequest request, Principal principal) {
	if ((bankCompany.getParentCompany() != null)
		&& (bankCompany.getParentCompany().getId() == null)) {
	    bankCompany.setParentCompany(null);
	}
	BankCompany aux = bankCompanyService
		.getBankCompany(bankCompany.getId());
	bankCompany.setSubBankCompanies(aux.getSubBankCompanies());

	if (result.hasErrors()) {
	    String userMsg = "";
	    if (principal != null) {
		userMsg = this.getUserGreeting(principal, request);
	    }
	    map.put("userMsg", userMsg);
	    map.put("bankCompaniesList", bankCompanyService.listBankCompanies());
	    return "bankCompanyDetails";
	}

	bankCompanyService.updateBankCompany(bankCompany);

	try {
	    // We wait to avoid not loading the recently added DB data
	    Thread.sleep(500);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	map.clear();
	return "redirect:/banks/details/" + bankCompany.getId().intValue();
    }

    /**
     * Delete bank company URL.
     * 
     * @param bankCompanyId
     *            the bank company id
     * @return the petition response
     */
    @RequestMapping("/banks/delete/{bankCompanyId}")
    public String deleteBankCompany(
	    @PathVariable("bankCompanyId") Integer bankCompanyId) {
	BankCompany bankCompany = bankCompanyService
		.getBankCompany(bankCompanyId);
	if (bankCompany != null) {
	    bankCompanyService.removeBankCompany(bankCompanyId);
	}

	return "redirect:/banks/list";
    }
}