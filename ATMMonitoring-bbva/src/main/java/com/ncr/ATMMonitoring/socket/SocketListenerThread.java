package com.ncr.ATMMonitoring.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import org.apache.log4j.Logger;

/**
 * The Class SocketListenerThread.
 * 
 * Threads which process the incoming connections when listening for the ATMs'
 * agents.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public class SocketListenerThread extends Thread {

    /** The logger. */
    static private Logger logger = Logger.getLogger(SocketListenerThread.class
	    .getName());

    /** The ok message to send to the agent. */
    private String okMessage;

    /** The socket. */
    private Socket socket;

    /** The socket listener parent. */
    private SocketListener parent;

    /**
     * Instantiates a new socket listener thread.
     * 
     * @param socket
     *            the socket
     * @param okMessage
     *            the ok message to send to the agent
     * @param parent
     *            the socket listener parent
     */
    public SocketListenerThread(Socket socket, String okMessage,
	    SocketListener parent) {
	this.socket = socket;
	this.okMessage = okMessage;
	this.parent = parent;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Thread#run()
     */
    public void run() {
	String ip = socket.getInetAddress().getHostAddress();
	logger.info("Update requested from IP: " + ip);

	try {
	    try {
		PrintWriter out = new PrintWriter(socket.getOutputStream(),
			true);
		// Confirmamos al agente que hemos recibido la petici�n
		out.println(okMessage);
		logger.info("Update request confirmed ('" + okMessage
			+ "') to IP: " + ip);

		// Pedimos los datos al agente
		parent.requestData(ip);
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
}
