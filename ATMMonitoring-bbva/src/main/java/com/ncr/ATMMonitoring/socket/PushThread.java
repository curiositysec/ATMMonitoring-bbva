package com.ncr.ATMMonitoring.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import com.ncr.ATMMonitoring.utils.Utils;
import com.ncr.agent.baseData.ATMDataStorePojo;
import com.ncr.agent.baseData.DataStore;

/**
 * The Class PushThread.
 * 
 * Thread in charge of sending an ATM data as json to another server via push
 * method.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class PushThread extends Thread {

    /** The max number of tries for sending the data. */
    private final static int maxTries = 3;

    /** The logger. */
    private static Logger logger = Logger.getLogger(PushThread.class.getName());

    /** The server ip. */
    private String serverIp;

    /** The server port. */
    private int serverPort;

    /** The response time out. */
    private int timeOut;

    /** The configured hash seed. */
    private String hashSeed;

    /** The data to send to the server. */
    private ATMDataStorePojo data;

    /**
     * Instantiates a new push thread.
     * 
     * @param serverIp
     *            the push server IP
     * @param serverPort
     *            the push server port
     * @param timeOut
     *            the response time out
     * @param hashSeed
     *            the configurable hash seed used for authentication
     * @param data
     *            the ATM agent pojo we want to send to the server
     */
    public PushThread(String serverIp, int serverPort, int timeOut,
	    String hashSeed, ATMDataStorePojo data) {
	this.hashSeed = hashSeed;
	this.serverPort = serverPort;
	this.serverIp = serverIp;
	this.timeOut = timeOut;
	this.data = data;
    }

    /**
     * Method that confirms the server identity through a socket in the same way
     * the agent does.
     * 
     * @param socket
     *            the socket used for communication
     * @return true if the process went okay, false otherwise.
     */
    private boolean confirmIdentity(Socket socket) {

	try {
	    logger.debug("Confirming identity to push server...");

	    BufferedReader in = new BufferedReader(new InputStreamReader(
		    socket.getInputStream()));
	    try {
		socket.setSoTimeout(timeOut);
		// Recibimos la semilla hash
		String string = in.readLine();
		if (string != null) {
		    logger.debug("Auth info received from push server: "
			    + string);
		    String hash = Utils.getMD5Hex(Utils.getMD5Hex(hashSeed)
			    + Utils.getMD5Hex(RequestThread.hashSeed)
			    + Utils.getMD5Hex(string));
		    PrintWriter out = new PrintWriter(socket.getOutputStream(),
			    true);
		    // Confirmamos al agente que hemos
		    // recibido la petición
		    logger.debug("We send the auth hash [" + hash
			    + "] to push server "
			    + socket.getInetAddress().getHostAddress() + ":"
			    + socket.getPort());
		    out.println(hash);
		    string = in.readLine();
		    if (string != null) {
			if (string.equals(RequestThread.authOkMsg)) {
			    logger.debug("Server confirms success in the authentication...");
			    return true;
			}
			if (string.equals(RequestThread.authErrorMsg)) {
			    logger.debug("Push server confirms an error in authentication...");
			    return false;
			}
			if (string.startsWith(RequestThread.authUpdateMsg)) {
			    String[] split = string.split(":");
			    if ((split.length >= 3) && (split[1] != null)
				    && (split[1].equals(hashSeed))
				    && (split[2] != null)
				    && (split[2].length() > 0)) {
				logger.warn("Push server has sent an updated hash seed that will be ignored...");
				return true;
			    }
			}
		    }
		}
		logger.warn("Invalid response from push server, or the connection has been abruptly closed.");
	    } catch (SocketTimeoutException e) {
		logger.warn("Auth info not received from push server.");
	    }
	} catch (IOException e) {
	    logger.error("I/O error with the connection to push server"
		    + socket.getInetAddress().getHostAddress() + ":", e);
	}
	logger.error("Push server authentication process couldn't be completed...");
	return false;
    }

    /**
     * Method that sends an ATM data as json through a socket in the same way
     * the agent does.
     * 
     * @param data
     *            the data we want to send to the push server
     * @param socket
     *            the socket used for communication
     * @return true if the process went okay, false otherwise.
     */
    private boolean sendDataJsonThroughSocket(DataStore data, Socket socket) {
	try {

	    // Primero confirmamos la identidad del agente
	    if (!confirmIdentity(socket)) {
		logger.error("Unsuccessful authentication with push server...");
		return false;
	    }

	    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	    BufferedReader in = new BufferedReader(new InputStreamReader(
		    socket.getInputStream()));
	    // Confirmamos al agente que hemos recibido la petición
	    logger.debug("Sending json with dataStore data to "
		    + socket.getInetAddress().getHostAddress() + ":"
		    + socket.getPort());
	    out.println(data.toJson());
	    // Esperamos al mensaje final por parte del servidor
	    String string = in.readLine();
	    logger.debug("Received final answer from "
		    + socket.getInetAddress().getHostAddress() + ":"
		    + socket.getPort() + " : " + string);
	} catch (IOException e) {
	    logger.error("Comm exception: " + e.toString(), e);
	    return false;
	}
	return true;
    }

    /**
     * Method that sends the locally stored ATM data as json through a socket in
     * the same way the agent does.
     * 
     * @return true if the process went okay, false otherwise.
     */
    private boolean sendDataToServer() {
	// Abrimos el socket al puerto de comunicaciones push del
	// servidor, y realizamos el proceso de autenticación/envío de
	// datos
	try {
	    logger.debug("Connecting to push port of push server...");
	    Socket socket = RequestThreadManager.getClientSocketFactory()
		    .createSocket(serverIp, serverPort);
	    socket.setSoTimeout(timeOut);

	    boolean value = sendDataJsonThroughSocket(data, socket);
	    socket.close();
	    return value;
	} catch (UnknownHostException e) {
	    logger.error("Don't know about push server " + serverIp + ":", e);
	} catch (IOException e) {
	    logger.error("I/O error with the connection to push server"
		    + serverIp + ":", e);
	}

	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Thread#run()
     */
    public void run() {
	for (int i = 0; i < maxTries; i++) {
	    if (sendDataToServer()) {
		logger.info("Data with matricula " + data.getMatricula()
			+ " sent to server " + serverIp + ":" + serverPort);
		return;
	    }
	    logger.warn("Couldn't send data with matricula "
		    + data.getMatricula() + " to server " + serverIp + ":"
		    + serverPort + ". Will try again...");
	}
	logger.error("After " + maxTries
		+ " tries couldn't send data with matricula "
		+ data.getMatricula() + " to server " + serverIp + ":"
		+ serverPort);
    }

}
