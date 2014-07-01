package com.ncr.ATMMonitoring.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * The listener interface for receiving socket events. The class that is
 * interested in processing a socket event implements this interface, and the
 * object created with that class is registered with a component using the
 * component's <code>addSocketListener<code> method. When
 * the socket event occurs, that object's appropriate
 * method is invoked.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Component
public class SocketListener extends Thread {

    /** The logger. */
    static private Logger logger = Logger.getLogger(SocketListener.class
	    .getName());

    /** The server socket. */
    static private volatile ServerSocket serverSocket;

    /** The listener. */
    static private volatile Thread listener = null;

    /** The server port. */
    @Value("${config.serverSocketPort}")
    private int serverPort;

    /** The listener state. */
    @Value("${config.backgroundListener}")
    private String listenerState;

    /** The agent push comm model state. */
    @Value("${config.agentPushState}")
    private String agentPushState;

    /** The ok message to send to the agent. */
    @Value("${config.agentOkMessage}")
    private String okMessage;

    // Can't autowire because problems will arise related to the circular
    // reference
    // @Autowired
    /** The socket service. */
    private SocketService socketService;

    /**
     * Instantiates a new socket listener.
     */
    public SocketListener() {
	logger.info("Initializing SocketListener");
    }

    /**
     * Sets the socket service.
     * 
     * @param socketService
     *            the new socket service
     */
    public void setSocketService(SocketService socketService) {
	this.socketService = socketService;
    }

    /**
     * Instantiates a new socket listener.
     * 
     * @param okMessage
     *            the ok message
     */
    public SocketListener(String okMessage) {
	this.okMessage = okMessage;
    }

    /**
     * Request data from an ip through the socket service.
     * 
     * @param ip
     *            the ip
     */
    public void requestData(String ip) {
	socketService.updateTerminalSocket(ip);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Thread#run()
     */
    public void run() {
	// Cada vez que nos llegue una petici�n de conexi�n, la desviamos a un
	// hilo nuevo
	if (agentPushState.equalsIgnoreCase("on")) {
	    while (true) {
		try {
		    new SocketListenerPushThread(serverSocket.accept(), this)
			    .start();
		} catch (SocketException e) {
		    // Si el listener est� a nulo, eso quiere decir que se est�n
		    // liberando los recursos y no es un error
		    if (listener == null) {
			return;
		    }
		    logger.error("An exception was thrown while processing "
			    + "a socket connection.", e);
		} catch (Exception e) {
		    logger.error("An exception was thrown while processing "
			    + "a socket connection.", e);
		}
	    }
	} else {
	    while (true) {
		try {
		    new SocketListenerThread(serverSocket.accept(), okMessage,
			    this).start();
		} catch (SocketException e) {
		    // Si el listener est� a nulo, eso quiere decir que se est�n
		    // liberando los recursos y no es un error
		    if (listener == null) {
			return;
		    }
		    logger.error("An exception was thrown while processing "
			    + "a socket connection.", e);
		} catch (Exception e) {
		    logger.error("An exception was thrown while processing "
			    + "a socket connection.", e);
		}
	    }
	}
    }

    /**
     * Initialize the listener.
     * 
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public void doInit() throws IOException {
	// Abrimos un socket en el puerto designado
	serverSocket = RequestThreadManager.getServerSocketFactory()
		.createServerSocket(serverPort);
	listener = this;
	start();
	logger.info("Server socket listening to port " + serverPort);
    }

    /**
     * Stop the listener.
     * 
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public void doDestroy() throws IOException {
	listener = null;
	serverSocket.close();
    }

    /**
     * Check whether the listener should be initialized or not according to the
     * configuration, and initialize it if that's the case.
     */
    @PostConstruct
    public void checkInit() {
	if ((listenerState != null) && (listenerState.equalsIgnoreCase("on"))) {
	    logger.info("Initializing socket listener...");
	    try {
		doInit();
		logger.info("Socket listener initialized!!");
	    } catch (IOException e) {
		logger.error("Could not listen to port: " + serverPort, e);
	    }
	} else {
	    logger.warn("Socket listener is not being initialized, agent updates won't be available.");
	}
    }

    /**
     * Release resources from the listener if it was initialized.
     */
    @PreDestroy
    public void checkDestroy() {
	if (listener != null) {
	    logger.info("Releasing resources from socket listener...");
	    try {
		doDestroy();
		logger.info("Socket listener resources released!!");
	    } catch (IOException e) {
		logger.error("An exception was thrown while closing "
			+ "the listener socket.", e);
	    }
	}
    }

    /**
     * Gets the hash seed.
     * 
     * @return the hash seed
     */
    public String getHashSeed() {
	return socketService.getHashSeed();
    }

    /**
     * Gets the old hash seed.
     * 
     * @return the old hash seed
     */
    public String getOldHashSeed() {
	return socketService.getOldHashSeed();
    }

    /**
     * Handle ip success.
     * 
     * @param json
     *            the json
     * @return the long
     */
    public Long handleIpSuccess(String json) {
	return socketService.processTerminalJson(json);
    }
}
