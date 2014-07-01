package com.ncr.ATMMonitoring.socket;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ncr.ATMMonitoring.handler.QueueHandler;
import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.ATMMonitoring.service.QueryService;
import com.ncr.ATMMonitoring.service.TerminalService;
import com.ncr.agent.baseData.ATMDataStorePojo;

/**
 * The Class SocketServiceImpl.
 * 
 * Default implementation of SocketService.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service
public class SocketServiceImpl implements SocketService {

    /** The logger. */
    static private Logger logger = Logger.getLogger(SocketServiceImpl.class
	    .getName());

    /** The max number of threads. */
    @Value("${config.maxNumberUpdateThreads}")
    private double maxThreads;

    /** The max number of terminals per thread. */
    @Value("${config.maxNumberTerminalsPerThread}")
    private double maxTerminals;

    /** The response time out. */
    @Value("${config.socketTimeOut}")
    private int timeOut;

    /** The agent port. */
    @Value("${config.agentSocketPort}")
    private int agentPort;

    /** The sleep time between checks onto the sub-threads. */
    @Value("${config.sleepTimeRequestManager}")
    private int sleepTime;

    /** The max time we wait for the whole process to end. */
    @Value("${config.maxTimeRequestThread}")
    private int maxTime;

    /** The current hash seed for confirming ATM's identity. */
    @Value("${security.hashSeed}")
    private String hashSeed;

    /** The old hash seed for confirming ATM's identity. */
    @Value("${security.oldHashSeed}")
    private String oldHashSeed;

    /** The agent push comm model state. */
    @Value("${config.agentPushState}")
    private String agentPushState;

    /** The push server IP. */
    @Value("${config.pushServerIp}")
    private String pushServerIp;

    /** The push server port. */
    @Value("${config.pushServerPort}")
    private String pushServerPort;

    /** The socket listener. */
    @Autowired
    private SocketListener socketListener;

    /** The terminal service. */
    @Autowired
    private TerminalService terminalService;

    /** The query service. */
    @Autowired
    private QueryService queryService;

    /** The queue handler. */
    @Autowired
    private QueueHandler queueHandler;

    /** The request thread manager. */
    private RequestThreadManager requestThreadManager;

    /**
     * Inits the socketListener by setting this object as its service.
     */
    @PostConstruct
    public void init() {
	socketListener.setSocketService(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.socket.SocketService#updateAllTerminalsSocket()
     */
    @Override
    public void updateAllTerminalsSocket() {
	List<Terminal> terminals = terminalService.listTerminals();
	for (Terminal terminal : terminals) {
	    updateTerminalSocket(terminal);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.socket.SocketService#updateTerminalSocket(com.ncr
     * .ATMMonitoring.pojo.Terminal)
     */
    @Override
    public void updateTerminalSocket(Terminal terminal) {
	logger.debug("adding ip: " + terminal.getIp());
	this.addToQueue(terminal.getIp(), null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.socket.SocketService#updateTerminalSocket(java.
     * lang.String)
     */
    @Override
    public void updateTerminalSocket(String ip) {
	this.addToQueue(ip, null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.socket.SocketService#updateTerminalsSocket(java
     * .util.Collection)
     */
    @Override
    public void updateTerminalsSocket(Collection<String> ips) {
	logger.debug("adding collection: " + ips);
	this.addToQueue(null, ips);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.socket.SocketService#updateTerminalsSocket(com.
     * ncr.ATMMonitoring.pojo.Query)
     */
    @Override
    public void updateTerminalsSocket(Query query) {
	if (query != null) {
	    Set<String> ips = new HashSet<String>();
	    List<Terminal> terminals = queryService.executeQuery(query);
	    for (Terminal terminal : terminals) {
		ips.add(terminal.getIp());
	    }
	    updateTerminalsSocket(ips);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.socket.SocketService#processAwaitingIps()
     */
    @Override
    public void processAwaitingIps() {
	if (agentPushState.equalsIgnoreCase("on")) {
	    logger.error("Ips won't be processed."
		    + "Comms are set to push model, so updates cannot be requested from the server.");
	    return;
	}
	logger.info("Checking the IPs waiting for update...");
	this.queueHandler.loadQueue();
	if (this.queueHandler.isEmpty()) {
	    logger.info("Nothing in the queue, no ip to process");
	    return;
	}
	if ((requestThreadManager != null) && requestThreadManager.isAlive()) {
	    logger.info("Request threads manager still busy with previous requests...");
	    return;
	}
	logger.info("Processing the IPs waiting for update...");
	logger.debug("the queue collection: " + this.queueHandler.viewQueue());
	requestThreadManager = new RequestThreadManager(maxThreads,
		maxTerminals, timeOut * 1000, agentPort, sleepTime, maxTime,
		this, this.queueHandler.viewQueue());
	requestThreadManager.start();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.socket.SocketService#processTerminalJson(java.lang
     * .String)
     */
    public Long processTerminalJson(String json) {
	// logger.debug("Json received: " + json);
	ATMDataStorePojo data = ATMDataStorePojo.fromJson(json);
	logger.debug("ATMDataStore received: " + data.toString());
	// logger.debug("Resulting Json: " + data.toJson());
	Terminal terminal = terminalService.persistDataStoreTerminal(data);
	Long newMatricula = null;
	if ((data.getMatricula() == null)
		|| (data.getMatricula().length() == 0)) {
	    // La matrícula es nueva, la devolvemos
	    newMatricula = terminal.getMatricula();
	    data.setMatricula(newMatricula.toString());
	}
	sendDataToPushServer(data);
	return newMatricula;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.socket.SocketService#getHashSeed()
     */
    public String getHashSeed() {
	return hashSeed;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.socket.SocketService#getOldHashSeed()
     */
    public String getOldHashSeed() {
	return oldHashSeed;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.socket.SocketService#getIpToProcess()
     */
    @Override
    public String getIpToProcess() {
	this.queueHandler.loadQueue();
	String ip = this.queueHandler.poll();
	this.queueHandler.save();
	return ip;
    }

    /**
     * Adds elements to the queue
     * 
     * @param ip
     *            an individual ip to add
     * @param ips
     *            a collection of ips to add
     */
    private void addToQueue(String ip, Collection<String> ips) {
	if (agentPushState.equalsIgnoreCase("on")) {
	    logger.error("Ips won't be added to the Queue."
		    + "Comms are set to push model, so updates cannot be requested from the server.");
	    return;
	}
	this.queueHandler.loadQueue();
	boolean added = false;

	if (ips != null && !ips.isEmpty()) {
	    this.queueHandler.addAll(ips);
	    added = true;
	} else if (ip != null) {
	    this.queueHandler.add(ip);
	    added = true;
	}
	if (added) {
	    this.queueHandler.save();
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.socket.SocketService#sendDataToPushServer(com.ncr
     * .agent.baseData.ATMDataStorePojo)
     */
    @Override
    public void sendDataToPushServer(ATMDataStorePojo data) {
	if ((pushServerIp != null) && (pushServerIp != "")
		&& (pushServerPort != null) && (pushServerPort != "")) {
	    int port;
	    try {
		port = Integer.parseInt(pushServerPort);
	    } catch (NumberFormatException e) {
		logger.error("Invalid push server port number '"
			+ pushServerPort + "'");
		return;
	    }
	    PushThread thread = new PushThread(pushServerIp, port,
		    timeOut * 1000, hashSeed, data);
	    thread.start();
	    logger.debug("Starting thread for pushing data to push server...");
	}
    }
}