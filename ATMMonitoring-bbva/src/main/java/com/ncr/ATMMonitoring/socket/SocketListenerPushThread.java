package com.ncr.ATMMonitoring.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;

import com.ncr.ATMMonitoring.utils.Utils;

/**
 * The Class SocketListenerPushThread.
 * 
 * Threads which process the incoming connections when listening for the ATMs'
 * agents. For push connections model (i.e. data is directly sent from ATMs)
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class SocketListenerPushThread extends Thread {

    /** The logger. */
    static private Logger logger = Logger.getLogger(SocketListenerPushThread.class
	    .getName());

    /** The socket. */
    private Socket socket;

    /** The socket listener parent. */
    private SocketListener parent;

    /**
     * Instantiates a new socket listener push thread.
     * 
     * @param socket
     *            the socket
     * @param parent
     *            the socket listener parent
     */
    public SocketListenerPushThread(Socket socket, SocketListener parent) {
	this.socket = socket;
	this.parent = parent;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Thread#run()
     */
    public void run() {
	String ip = socket.getInetAddress().getHostAddress();
	logger.info("Update being sent from IP: " + ip);

	try {
	    try {
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
		PrintWriter out = new PrintWriter(socket.getOutputStream(),
			true);
		String json;
		String endMsg = RequestThread.endCommMsg;
		try {
		    // Recuperamos el Json con los datos del DataStore
		    json = in.readLine();
		    logger.info("Data received from IP: " + ip);
		    try {
			Long matricula = parent.handleIpSuccess(json);
			if (matricula != null) {
			    // Tenemos una matrícula nueva, así que la enviamos
			    // al
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
		    // Enviamos el mensaje que confirma el final de la
		    // comunicaci�n
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
	    } catch (IOException e) {
		logger.error("An exception was thrown while processing "
			+ "an update request from IP: " + ip, e);
	    } finally {
		socket.close();
	    }
	} catch (IOException e) {
	    logger.error("An exception was thrown while processing "
		    + "an update request from IP: " + ip, e);
	}
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
	    logger.info("Sending the authentication data ["
		    + RequestThread.hashSeed
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
		    + Utils.getMD5Hex(RequestThread.hashSeed)
		    + Utils.getMD5Hex(randomSeed));
	    if (response.equals(hash)) {
		// Confirmamos al agente que la autenticaci�n fue correcta
		out.println(RequestThread.authOkMsg);
		return true;
	    } else {
		String oldParentSeed = parent.getOldHashSeed();
		if ((oldParentSeed != null)
			&& (!oldParentSeed.equals(parentSeed))) {
		    hash = Utils.getMD5Hex(Utils.getMD5Hex(oldParentSeed)
			    + Utils.getMD5Hex(RequestThread.hashSeed)
			    + Utils.getMD5Hex(randomSeed));
		    if (response.equals(hash)) {
			logger.warn("Old hash seed has been detected in IP "
				+ socket.getInetAddress().getHostAddress()
				+ ". New one will be sent.");
			// Confirmamos al agente que la autenticaci�n fue
			// correcta y le pedimos que actualice su hash
			out.println(RequestThread.authUpdateMsg + ":"
				+ oldParentSeed + ":"
				+ parentSeed);
			return true;
		    }
		}
	    }

	    // La autenticaci�n ha fallado, avisamos al agente y terminamos
	    out.println(RequestThread.authErrorMsg);
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
}
