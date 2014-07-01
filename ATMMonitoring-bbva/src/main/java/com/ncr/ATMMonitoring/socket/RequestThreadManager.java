package com.ncr.ATMMonitoring.socket;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Queue;

import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.ncr.ATMMonitoring.utils.Utils;

/**
 * The Class RequestThreadManager.
 * 
 * The class in charge of distributing the pending to request data ip's among
 * multiple RequestThread's.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class RequestThreadManager extends Thread {

    /** The logger. */
    static private Logger logger = Logger.getLogger(RequestThreadManager.class
	    .getName());

    /** The server socket factory. */
    static private ServerSocketFactory SERVER_SOCKET_FACTORY;

    /** The client socket factory. */
    static private SocketFactory CLIENT_SOCKET_FACTORY;

    // Hack for avoiding the SSL authentification based on certifications,
    // because we only want it for encryption.
    static {
	TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
	    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
		return null;
	    }

	    public void checkClientTrusted(X509Certificate[] certs,
		    String authType) {
	    }

	    public void checkServerTrusted(X509Certificate[] certs,
		    String authType) {
	    }
	} };

	try {
	    Properties props = PropertiesLoaderUtils
		    .loadProperties(new ClassPathResource("config.properties"));
	    KeyManagerFactory kmf = KeyManagerFactory
		    .getInstance(KeyManagerFactory.getDefaultAlgorithm());
	    InputStream in = new ClassPathResource("keystore").getInputStream();
	    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
	    ks.load(in,
		    Utils.simpleDecrypt(Utils.KEYSTORE_KEY,
			    props.getProperty("security.keystorePass"))
		    .toCharArray());
	    kmf.init(
		    ks,
		    Utils.simpleDecrypt(Utils.PRIVATEKEY_KEY,
			    props.getProperty("security.privatekeyPass"))
		    .toCharArray());
	    // Install the all-trusting trust manager
	    SSLContext sc = SSLContext.getInstance("SSL");
	    sc.init(kmf.getKeyManagers(), trustAllCerts,
		    new java.security.SecureRandom());
	    SERVER_SOCKET_FACTORY = sc.getServerSocketFactory();
	    CLIENT_SOCKET_FACTORY = sc.getSocketFactory();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    /** The max number of threads. */
    private double maxThreads;

    /** The max number of terminals per thread. */
    private double maxTerminals;

    /** The response time out. */
    private int timeOut;

    /** The agent port. */
    private int agentPort;

    /** The sleep time between checks onto the sub-threads. */
    private int sleepTime;

    /** The max time we wait for the whole process to end. */
    private int maxTime;

    /** The socket service. */
    private SocketService socketService;

    /** The threads. */
    private List<RequestThread> threads = Collections
	    .synchronizedList(new ArrayList<RequestThread>());

    private Queue<String> ips;

    /**
     * Instantiates a new request thread manager.
     * 
     * @param maxThreads
     *            the max number of threads
     * @param maxTerminals
     *            the max number of terminals per thread
     * @param timeOut
     *            the response time out
     * @param agentPort
     *            the agent port
     * @param sleepTime
     *            the sleep time between checks onto the sub-threads
     * @param maxTime
     *            the max time we wait for the whole process to end
     * @param socketService
     *            the socket service
     * @param ips
     *            the ips
     */
    public RequestThreadManager(double maxThreads, double maxTerminals,
	    int timeOut, int agentPort, int sleepTime, int maxTime,
	    SocketService socketService, Queue<String> actualQueue) {
	this.maxThreads = maxThreads;
	this.maxTerminals = maxTerminals;
	this.timeOut = timeOut;
	this.agentPort = agentPort;
	this.sleepTime = sleepTime;
	this.maxTime = maxTime;
	this.socketService = socketService;
	this.ips = actualQueue;

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

    /**
     * Handle ip error.
     * 
     * @param ip
     *            the ip
     */
    public void handleIpError(String ip) {
	socketService.updateTerminalSocket(ip);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Thread#run()
     */
    public void run() {
	try {
	    Iterator<String> iterator = ips.iterator();
	    // Set<String> subSet;
	    String ip;
	    RequestThread thread;
	    if (ips.size() > (maxThreads * maxTerminals)) {
		// El número de ips no nos permite mantener el número m�ximo de
		// threads y de ips por cada una. Dividimos de la manera m�s
		// equitativa entre el número m�ximo de threads.
		double size = ips.size() / maxThreads;
		double roundedSize = Math.floor(size);
		int remainingTerminals = 0;
		if (size != roundedSize) {
		    remainingTerminals = ips.size()
			    - new Double(roundedSize * maxThreads).intValue();
		}
		int j;
		for (int i = 1; i <= maxThreads; i++) {
		    ;
		    int requestNum = 0;
		    j = 0;
		    while (iterator.hasNext() && (j++ < roundedSize)) {
			ip = iterator.next();
			logger.info("IP " + ip + " is gonna be updated...");

			requestNum++;
		    }
		    if ((remainingTerminals > 0) && (iterator.hasNext())) {
			remainingTerminals--;
			ip = iterator.next();
			logger.info("IP " + ip + " is gonna be updated...");

			requestNum++;
			j++;
		    }
		    if (j > 0) {
			logger.info("We create thread number " + i
				+ " for updating " + requestNum + " IPs...");
			thread = new RequestThread(requestNum, agentPort,
				timeOut, this);
			thread.start();
			threads.add(thread);
		    }
		}
	    } else {
		// Podemos dividirlo entre n threads que no sobrepasan el número
		// m�ximo de ips
		int j = 0, i = 1;

		int requestNum = 0;
		while (iterator.hasNext()) {
		    ip = iterator.next();
		    logger.info("IP " + ip + " is gonna be updated...");

		    requestNum++;
		    if ((++j == maxTerminals) || !iterator.hasNext()) {
			logger.info("We create thread number " + i
				+ " for updating " + requestNum + " IPs...");
			thread = new RequestThread(requestNum, agentPort,
				timeOut, this);
			thread.start();
			threads.add(thread);

			requestNum = 0;
			j = 0;
		    }
		}
	    }
	    // Calculamos el nº m�ximo de ciclos de comprobaci�n
	    double cycles = Math.ceil(maxTime / sleepTime);
	    while (!threads.isEmpty() && (cycles-- > 0)) {
		try {
		    Thread.sleep(sleepTime * 1000);
		    Iterator<RequestThread> iter = threads.iterator();
		    while (iter.hasNext()) {
			if (!iter.next().isAlive()) {
			    iter.remove();
			}
		    }
		} catch (InterruptedException e) {
		    logger.error("Error while sleeping"
			    + " between request threads checks...", e);
		}
	    }
	    // Si la colecci�n no est� vacía, es que no han terminado a tiempo.
	    if (!threads.isEmpty()) {
		logger.warn("Some request threads somehow couldn't finish in the configured max time."
			+ " Their ips will be requested again at next request phase...");

	    }
	} catch (Exception e) {
	    logger.error("Unexpected error when"
		    + " requesting updates to ips...", e);
	    for (Thread thread : threads) {
		thread.interrupt();
	    }
	    threads.clear();

	}
    }

    /**
     * Gets the server socket factory.
     * 
     * @return the serverSocketFactory
     */
    public static ServerSocketFactory getServerSocketFactory() {
	return SERVER_SOCKET_FACTORY;
    }

    /**
     * Gets the client socket factory.
     * 
     * @return the clientSocketFactory
     */
    public static SocketFactory getClientSocketFactory() {
	return CLIENT_SOCKET_FACTORY;
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
     * Returns the first ip to process in the queue
     * 
     * @return
     */
    public String getIpToProcess() {
	return this.socketService.getIpToProcess();
    }
}
