package com.ncr.ATMMonitoring.scheduledtask;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.service.ScheduledUpdateService;

/**
 * Class that periodically checks if there are any Scheduled updates to execute
 * 
 * @author Otto Abreu
 * 
 */
@Component
public class ScheduledUpdateTask {

    /** The logger. */
    static final private Logger logger = Logger
	    .getLogger(ScheduledUpdateTask.class);

    /** The agent push comm model state. */
    @Value("${config.agentPushState}")
    private String agentPushState;

    /** Runs at every minute start. */
    private static final String CRON_CONF = "0 * * * * *";

    /** The financial device service. */
    @Autowired
    private ScheduledUpdateService scheduledUpdateService;

    /**
     * Method that checks if there are any Scheduled updates to execute, and in
     * that case runs them
     */
    @Scheduled(cron = CRON_CONF)
    @Transactional
    public void callToCheckCurrentUpdates() {
	if (!agentPushState.equalsIgnoreCase("on")) {
	    logger.info("Calling service for checking Current Updates ");
	    this.scheduledUpdateService.checkCurrentUpdates();
	}
    }
}
