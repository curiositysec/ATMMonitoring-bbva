package com.ncr.ATMMonitoring.parser.ups.imp;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.ncr.ATMMonitoring.parser.exception.ParserException;
import com.ncr.ATMMonitoring.parser.exception.FileNotReadableException;
import com.ncr.ATMMonitoring.parser.ups.ParseUPSChainBuilder;
import com.ncr.ATMMonitoring.parser.ups.ParseUPSXML;

/**
 * Class that defines a parse based on SAX<br>
 * <b><i>Do not call the parser directly, call
 * {@link ParseUPSChainBuilder#parse(InputStream)}</i></b>
 * 
 * @author Otto Abreu
 * 
 */
public abstract class ParseUPSSAX extends ParseUPSXML {

    /**
     * Holds the logic related to how parse the XML
     * 
     * @return {@link DefaultHandler}
     */
    protected abstract DefaultHandler getDefaultHandler();

    /**
     * Executes the Parse method in the {@link SAXParser}<BR>
     * The concrete class <b>must implement the logic related to the
     * {@link DefaultHandler} <b>
     * 
     * @param xmlFile
     *            InputStream
     * @throws ParserException
     *             if can't get the SAX parser or a general error occurs
     * @throws FileNotReadableException
     *             if can not read the file while executing the
     *             {@link DocumentBuilder#parse(java.io.File)}
     */
    protected void parse(InputStream xmlFile) throws ParserException,
	    FileNotReadableException {

	DefaultHandler handler = this.getDefaultHandler();
	SAXParserFactory factory = SAXParserFactory.newInstance();

	try {

	    SAXParser saxParser = factory.newSAXParser();
	    saxParser.parse(xmlFile, handler);

	} catch (ParserConfigurationException e) {
	    throw new ParserException(
		    ParserException.PARSER_CONFIGURATION_ERROR, e);
	} catch (SAXException e) {
	    throw new FileNotReadableException(
		    FileNotReadableException.PARSE_ERROR, e);
	} catch (IOException e) {
	    throw new FileNotReadableException(FileNotReadableException.IO_ERROR,
		    e);
	} catch (Exception e) {
	    throw new ParserException(ParserException.GENERAL_ERROR
		    + e.getMessage(), e);
	}

    }

}
