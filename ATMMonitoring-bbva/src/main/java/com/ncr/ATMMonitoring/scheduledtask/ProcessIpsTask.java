package com.ncr.ATMMonitoring.scheduledtask;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ncr.ATMMonitoring.socket.SocketService;

/**
 * Class that periodically executes the ATM Update Process
 * 
 * @author Otto Abreu
 * 
 */
@Component
public class ProcessIpsTask {

    /** The logger. */
    static private Logger logger = Logger.getLogger(ProcessIpsTask.class);

    /** The socket service. */
    @Autowired
    private SocketService socketService;

    /** The agent push comm model state. */
    @Value("${config.agentPushState}")
    private String agentPushState;

    /** Runs at every minute 30 seconds. */
    private static final String CRON_CONF = "30 * * * * *";

    /**
     * Method that calls the service in order to start the ATM update process
     */
    @Scheduled(cron = CRON_CONF)
    public void processIps() {
	if (!agentPushState.equalsIgnoreCase("on")) {
	    logger.info("Calling service for checking the IPs waiting for update...");
	    this.socketService.processAwaitingIps();
	}
    }

}
