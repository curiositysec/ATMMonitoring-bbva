package com.ncr.ATMMonitoring.parser.ups.imp;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.SAXException;

import com.ncr.ATMMonitoring.parser.exception.FileNotReadableException;
import com.ncr.ATMMonitoring.parser.exception.ParserException;
import com.ncr.ATMMonitoring.parser.ups.ParseUPSChainBuilder;
import com.ncr.ATMMonitoring.parser.ups.ParseUPSXML;

/**
 * Class that defines a parse based on w3c DOM<br>
 * Holds the common logic to parse a XML based on DOM parser<br>
 * <b><i>Do not call the parser directly, call
 * {@link ParseUPSChainBuilder#parse(InputStream)}</i></b>
 * 
 * @author Otto Abreu
 * 
 */
public abstract class ParseUPSDom extends ParseUPSXML {

    /** Root element */
    private Element rootElement;

    /** XML in document format */
    private Document doc;

    /**
     * Generates a {@link Document} from the {@link InputStream}<br>
     * You should call this method before performing anything else in the parser
     * 
     * @param xmlFile
     *            {@link InputStream} with the XML
     * @return Document
     * @throws ParserException
     *             if can't get the document builder or a general error occurs
     * @throws FileNotReadableException
     *             if can not read the file while executing the
     *             {@link DocumentBuilder#parse(java.io.File)}
     */
    private void loadXML() throws ParserException, FileNotReadableException {

	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

	try {

	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    logger.debug("inputstream: " + this.getXmlFile());
	    this.doc = dBuilder.parse(this.getXmlFile());
	    this.doc.getDocumentElement().normalize();

	} catch (ParserConfigurationException e) {
	    throw new ParserException(
		    ParserException.PARSER_CONFIGURATION_ERROR, e);
	} catch (SAXException e) {
	    throw new FileNotReadableException(
		    FileNotReadableException.PARSE_ERROR, e);
	} catch (IOException e) {
	    throw new FileNotReadableException(
		    FileNotReadableException.IO_ERROR, e);
	} catch (Exception e) {
	    throw new ParserException(ParserException.GENERAL_ERROR
		    + e.getMessage(), e);
	}

    }

    /**
     * Returns the XML in String format
     * 
     * @param doc
     *            Document
     * @return String
     */
    protected String getStringFromDoc() {
	DOMImplementationLS domImplementation = (DOMImplementationLS) this.doc
		.getImplementation();
	LSSerializer lsSerializer = domImplementation.createLSSerializer();
	return lsSerializer.writeToString(this.doc);
    }

    /**
     * Returns the root element, can return null if the Inputstream has not bean
     * set
     * 
     * @return Element
     * @throws FileNotReadableException
     * @throws ParserException
     */
    protected Element getRootElement() throws ParserException,
	    FileNotReadableException {

	if (this.rootElement == null) {

	    this.rootElement = this.getDoc().getDocumentElement();
	}
	return rootElement;
    }

    /**
     * Returns the {@link Document}
     * 
     * @return Document
     * @throws FileNotReadableException
     * @throws ParserException
     */
    protected Document getDoc() throws ParserException,
	    FileNotReadableException {
	if (this.doc == null) {
	    this.loadXML();
	}
	return doc;
    }

}
