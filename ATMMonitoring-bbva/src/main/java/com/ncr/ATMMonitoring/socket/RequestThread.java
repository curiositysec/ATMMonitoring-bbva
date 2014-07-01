package com.ncr.ATMMonitoring.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;

import com.ncr.ATMMonitoring.utils.Utils;

/**
 * The Class RequestThread.
 * 
 * This class retrieves the data from a series of ATM's by their ips.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class RequestThread extends Thread {

    /** The Constant hashSeed. */
    public static final String hashSeed = "V3zVFyxn9DnToZJ8067i";

    /** The Constant authOkMsg. */
    public static final String authOkMsg = "OK";

    /** The Constant authErrorMsg. */
    public static final String authErrorMsg = "ERROR";

    /** The Constant authUpdateMsg. */
    public static final String authUpdateMsg = "UPDATE";

    /** The Constant endCommMsg. */
    public static final String endCommMsg = "END";

    /** The logger. */
    private static Logger logger = Logger.getLogger(SocketListenerThread.class
	    .getName());

    /** The agent port. */
    private int agentPort;

    /** The response time out. */
    private int timeOut;

    /** The parent manager. */
    private RequestThreadManager parent;

    /** The number of ips to notify. */
    private int requestNumber;

    /**
     * Instantiates a new request thread.
     * 
     * @param requestNumber
     *            the number of ips to notify
     * @param agentPort
     *            the agent port
     * @param timeOut
     *            the response time out
     * @param parent
     *            the parent manager
     */
    public RequestThread(int requestNumber, int agentPort, int timeOut,
	    RequestThreadManager parent) {
	// this.ips = ips;
	this.agentPort = agentPort;
	this.timeOut = timeOut;
	this.parent = parent;
	this.requestNumber = requestNumber;
    }

    /**
     * Code executed before requesting data from an ATM for confirming it is
     * reliable.
     * 
     * For confirming an ATM's reliability we send it a random string which it
     * must hash, along with a hardcoded one and a configurable one, and then
     * send us the result so we can check whether it matches the expected one.
     * If we detect the agent is using an old version of the configurable
     * string, then we send it the new version so it can replace it.
     * 
     * @param socket
     *            the socket
     * @return true, if successful
     */
    private boolean confirmIdentity(Socket socket) {

	try {
	    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	    // Enviamos al agente la cadena base para el hash
	    String randomSeed = RandomStringUtils.randomAlphanumeric(20);
	    logger.info("Sending the authentication data [" + hashSeed
		    + "] to " + socket.getInetAddress().getHostAddress() + ":"
		    + socket.getPort());
	    out.println(randomSeed);

	    BufferedReader in = new BufferedReader(new InputStreamReader(
		    socket.getInputStream()));
	    // Recuperamos el hash
	    String response = in.readLine();
	    logger.info("Authentication data received [" + response
		    + "] from IP: " + socket.getInetAddress().getHostAddress());
	    String parentSeed = parent.getHashSeed();
	    String hash = Utils.getMD5Hex(Utils.getMD5Hex(parentSeed)
		    + Utils.getMD5Hex(hashSeed) + Utils.getMD5Hex(randomSeed));
	    if (response.equals(hash)) {
		// Confirmamos al agente que la autenticaci�n fue correcta
		out.println(authOkMsg);
		return true;
	    } else {
		String oldParentSeed = parent.getOldHashSeed();
		if ((oldParentSeed != null)
			&& (!oldParentSeed.equals(parentSeed))) {
		    hash = Utils.getMD5Hex(Utils.getMD5Hex(oldParentSeed)
			    + Utils.getMD5Hex(hashSeed)
			    + Utils.getMD5Hex(randomSeed));
		    if (response.equals(hash)) {
			logger.warn("Old hash seed has been detected in IP "
				+ socket.getInetAddress().getHostAddress()
				+ ". New one will be sent.");
			// Confirmamos al agente que la autenticaci�n fue
			// correcta y le pedimos que actualice su hash
			out.println(authUpdateMsg + ":" + oldParentSeed + ":"
				+ parentSeed);
			return true;
		    }
		}
	    }

	    // La autenticaci�n ha fallado, avisamos al agente y terminamos
	    out.println(authErrorMsg);
	} catch (SocketTimeoutException e) {
	    logger.error("We received no response during"
		    + " authentication from IP: "
		    + socket.getInetAddress().getHostAddress(), e);
	} catch (IOException e) {
	    logger.error("An exception was thrown while"
		    + " confirming identity of IP: "
		    + socket.getInetAddress().getHostAddress(), e);
	}
	return false;
    }

    /**
     * Request data json from an ATM.
     * 
     * @param ip
     *            the ATM ip
     * @throws Exception
     *             any kind of exception thrown with an error
     */
    private void requestDataJson(String ip) throws Exception {

	try {
	    // Abrimos el socket y un buffer de lectura
	    Socket socket = RequestThreadManager.getClientSocketFactory()
		    .createSocket(ip, agentPort);

	    // Ponemos un timeout para la recepci�n de datos
	    socket.setSoTimeout(timeOut * 1000);

	    // Confirmamos la identidad del agente
	    if (confirmIdentity(socket)) {
		logger.info("Id confirmed for IP: " + ip);
	    } else {
		logger.error("Id couldn't be confirmed for IP: " + ip);
		socket.close();
		return;
	    }

	    BufferedReader in = new BufferedReader(new InputStreamReader(
		    socket.getInputStream()));
	    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	    String json;
	    String endMsg = endCommMsg;
	    try {
		// Recuperamos el Json con los datos del DataStore
		json = in.readLine();
		logger.info("Data received from IP: " + ip);
		try {
		    Long matricula = parent.handleIpSuccess(json);
		    if (matricula != null) {
			// Tenemos una matrícula nueva, así que la enviamos al
			// agente
			logger.info("New generated id " + matricula
				+ " will be sent to IP: " + ip);
			endMsg += ":" + matricula;
		    }
		} catch (Exception e) {
		    logger.error(
			    "An error happened while saving data received from ip: "
				    + ip + "\nJson: " + json, e);
		}
		// Enviamos el mensaje que confirma el final de la comunicaci�n
		logger.info("Sending final comm message to IP: " + ip);
		out.println(endMsg);
	    } catch (SocketTimeoutException e) {
		logger.error("We received no response from IP: " + ip, e);
		throw e;
	    } finally {
		// Cerramos los recursos abiertos
		socket.close();
	    }
	    // Todo ha ido bien, terminamos.
	    return;

	} catch (UnknownHostException e) {
	    logger.error("Don't know about host: " + ip, e);
	    throw e;
	} catch (IOException e) {
	    logger.error("An exception was thrown while"
		    + " requesting data from IP: " + ip, e);
	    throw e;
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Thread#run()
     */
    public void run() {
	String ip = null;
	// for (String ip : ips) {
	for (int i = 0; i < this.requestNumber; i++) {
	    try {
		ip = this.parent.getIpToProcess();
		logger.info("requesting data to IP: " + ip);
		requestDataJson(ip);
	    } catch (Exception e) {
		logger.warn(
			"Couldn't update terminal with IP "
				+ ip
				+ ". Ip will be requested again in next request phase...",
			e);

		parent.handleIpError(ip);

	    }
	}
    }

}
