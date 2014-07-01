package com.ncr.ATMMonitoring.parser.ups;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.ncr.ATMMonitoring.parser.GenericChainParser;
import com.ncr.ATMMonitoring.parser.exception.NoParserFoundException;
import com.ncr.ATMMonitoring.parser.exception.ParserException;
import com.ncr.ATMMonitoring.parser.exception.FileNotReadableException;
import com.ncr.ATMMonitoring.parser.ups.dto.UPSInfo;

/**
 * Interface that define a XML UPS Parser ( a Link in the responsibility chain) <br>
 * To start the chain and the parsing process call the
 * {@link ParseUPSChainBuilder#parse(InputStream)}
 * 
 * @author Otto Abreu
 * 
 */
public abstract class ParseUPSXML extends GenericChainParser {

    /** The logger. */
    protected static final Logger logger = Logger.getLogger(ParseUPSXML.class);

    /** InputStream to the file to parse. */
    private InputStream xmlFile;

    /** Xml content. */
    private String originalXmlString;

    /**
     * Method that parses an XML from an specific UPS<br>
     * If the XML can not be parsed by this method, the next parser will be
     * called (Chain of responsibility pattern)
     * 
     * @param xmlFile
     *            {@link InputStream}
     * @return {@link UPSInfo}
     * @throws ParserException
     *             if occurs a general error
     * @throws FileNotReadableException
     *             if can not read the XML or the content of a node
     * 
     * 
     * @throws NoParserFoundException
     *             if the end of the chain is reached an no suitable parser was
     *             found to the given XML
     */
    public UPSInfo parseXML(InputStream xmlFile) throws ParserException,
	    FileNotReadableException, NoParserFoundException {
	UPSInfo upsInfo = null;
	try {
	    // in order to avoid the stream closing after each read,
	    // i save the original xml as string an get a new inputstream each
	    // time
	    this.originalXmlString = IOUtils.toString(xmlFile);
	    logger.debug("original xml: " + this.originalXmlString);
	    this.xmlFile = IOUtils.toInputStream(this.originalXmlString);

	    boolean willProcess = this.canParseXML();
	    // verify if the parser can process the file
	    if (willProcess) {
		logger.debug(this.getClass() + " this parser will process");
		upsInfo = this.applyParser();
		// otherwise it will call the next in the chain
	    } else {
		logger.debug(this.getClass() + " this parser will delegate");
		upsInfo = this.callNextParser();
	    }

	} catch (IOException e) {
	    logger.error(ParserException.GENERAL_ERROR, e);
	    throw new ParserException(ParserException.GENERAL_ERROR, e);
	}

	return upsInfo;
    }

    /**
     * Returns the XML Inputstream
     * 
     * @return InputStream
     */
    protected InputStream getXmlFile() {
	return xmlFile;
    }

    /**
     * Indicates if the parser is in charge of read the XML<br>
     * Returns true if the parser will process the file, false if it will
     * delegate the process to the next parser
     * 
     * @throws FileNotReadableException
     *             if can not read the XML or the content of a node
     * @throws ParserException
     *             if occurs a general error
     * 
     * @return boolean
     */
    protected abstract boolean canParseXML() throws ParserException,
	    FileNotReadableException;

    /**
     * Method that holds the specific logic to parse each XML and must be
     * implemented by all the concrete classes
     * 
     * @return UPSInfo
     */
    protected abstract UPSInfo applyParser() throws ParserException,
	    FileNotReadableException, NoParserFoundException;

    
    @SuppressWarnings("unchecked")
    protected  UPSInfo executeParseOnNextParser() throws IOException, ParserException, FileNotReadableException, NoParserFoundException{
	this.xmlFile = IOUtils.toInputStream(this.originalXmlString, null);
	UPSInfo upsInfo = ((ParseUPSXML)this.nextParser).parseXML(this.xmlFile);
	return upsInfo;
    }

    /**
     * Returns the original xml in string format
     * 
     * @return String
     */
    protected String getOriginalXmlString() {
	return originalXmlString;
    }
    
    
    @SuppressWarnings("unchecked")
    protected Collection<?> executeParseOnNextParserCollection() throws ParserException{
	throw new ParserException(ParserException.PARSER_EXECUTE_METHOD_ERROR);
	
    }

}
