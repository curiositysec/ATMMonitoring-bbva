package com.ncr.ATMMonitoring.controller;

import java.security.Principal;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.FinancialDevice;
import com.ncr.ATMMonitoring.pojo.JxfsComponent;
import com.ncr.ATMMonitoring.pojo.XfsComponent;
import com.ncr.ATMMonitoring.service.BankCompanyService;
import com.ncr.ATMMonitoring.service.XfsComponentService;

/**
 * The Class XfsComponentController.
 * 
 * Controller for handling user related HTTP petitions.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Controller
public class XfsComponentController extends GenericController {

    /** The xfs component service. */
    @Autowired
    private XfsComponentService xfsComponentService;

    /** The bank company service. */
    @Autowired
    private BankCompanyService bankCompanyService;

    /**
     * Xfs component details URL.
     * 
     * @param xfsComponentId
     *            the xfs component id
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping("/terminals/xfsComponents/details/{xfsComponentId}")
    public String xfsComponentDetails(
	    @PathVariable("xfsComponentId") Integer xfsComponentId,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {
	XfsComponent xfsComponent = xfsComponentService
		.getXfsComponent(xfsComponentId);
	if (xfsComponent == null) {
	    return "redirect:/terminals/list";
	}
	String userMsg = "";
	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	    boolean allowed = false;
	    Set<BankCompany> banks = this.bankCompanyService
		    .getUserManageableBankCompanies(principal.getName());
	    for (FinancialDevice dev : xfsComponent.getFinancialDevices()) {
		BankCompany aux = dev.getTerminal().getBankCompany();
		if ((aux == null) || (banks.contains(aux))) {
		    allowed = true;
		    break;
		}
	    }
	    if (!allowed) {
		map.clear();
		return "redirect:/terminals/list";
	    }
	}
	map.put("userMsg", userMsg);
	map.put("xfsComponent", xfsComponent);

	return "xfsComponentDetails";
    }

    /**
     * Jxfs component details URL.
     * 
     * @param jxfsComponentId
     *            the jxfs component id
     * @param map
     *            the map
     * @param request
     *            the request
     * @param principal
     *            the principal
     * @return the petition response
     */
    @RequestMapping("/terminals/jxfsComponents/details/{jxfsComponentId}")
    public String jxfsComponentDetails(
	    @PathVariable("jxfsComponentId") Integer jxfsComponentId,
	    Map<String, Object> map, HttpServletRequest request,
	    Principal principal) {
	JxfsComponent jxfsComponent = xfsComponentService
		.getJxfsComponent(jxfsComponentId);
	if (jxfsComponent == null) {
	    return "redirect:/terminals/list";
	}
	String userMsg = "";
	if (principal != null) {
	    userMsg = this.getUserGreeting(principal, request);
	    boolean allowed = false;
	    Set<BankCompany> banks = this.bankCompanyService
		    .getUserManageableBankCompanies(principal.getName());
	    for (FinancialDevice dev : jxfsComponent.getFinancialDevices()) {
		BankCompany aux = dev.getTerminal().getBankCompany();
		if ((aux == null) || (banks.contains(aux))) {
		    allowed = true;
		    break;
		}
	    }
	    if (!allowed) {
		map.clear();
		return "redirect:/terminals/list";
	    }
	}
	map.put("userMsg", userMsg);
	map.put("jxfsComponent", jxfsComponent);

	return "jxfsComponentDetails";
    }

}