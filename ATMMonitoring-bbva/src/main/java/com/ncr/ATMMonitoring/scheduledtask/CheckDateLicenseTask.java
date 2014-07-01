package com.ncr.ATMMonitoring.scheduledtask;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ncr.ATMMonitoring.service.TerminalService;

/**
 * Class that periodically checks the date-limited license
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 * 
 */
@Component
public class CheckDateLicenseTask {

    /** The logger. */
    static private Logger logger = Logger.getLogger(CheckDateLicenseTask.class);

    /** The terminal service. */
    @Autowired
    private TerminalService terminalService;

    /** Runs at every minute start. */
    private static final String CRON_CONF = "0 * * * * *";

    /**
     * Method that calls the service in order to check the date-limited license
     */
    @Scheduled(cron = CRON_CONF)
    public void processIps() {
	logger.info("Calling service for checking the date-limited license...");
	terminalService.checkDateLicense();
    }

}
