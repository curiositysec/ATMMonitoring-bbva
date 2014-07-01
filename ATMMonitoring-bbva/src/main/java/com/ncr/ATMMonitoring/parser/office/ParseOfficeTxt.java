package com.ncr.ATMMonitoring.parser.office;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.ncr.ATMMonitoring.parser.GenericChainParser;
import com.ncr.ATMMonitoring.parser.exception.FileNotReadableException;
import com.ncr.ATMMonitoring.parser.exception.NoParserFoundException;
import com.ncr.ATMMonitoring.parser.exception.ParserException;
import com.ncr.ATMMonitoring.parser.office.dto.OfficeInfo;
import com.ncr.ATMMonitoring.parser.ups.dto.UPSInfo;

/**
 * Interface that define a XML UPS Parser ( a Link in the responsibility chain) <br>
 * To start the chain and the parsing process call the
 * {@link ParseOfficeChainBuilder#parse(InputStream)}
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 * @author Otto Abreu
 * 
 */
public abstract class ParseOfficeTxt extends GenericChainParser{

    /** The logger. */
    protected static final Logger logger = Logger
	    .getLogger(ParseOfficeTxt.class);


    /** InputStream to the file to parse. */
    private InputStream txtFile;

    /**
     * Method that parses a txt for a group of offices<br>
     * If the txt can not be parsed by this method, the next parser will be
     * called (Chain of responsibility pattern)
     * 
     * @param txtFile
     *            {@link InputStream}
     * @return {@link UPSInfo}
     * @throws ParserException
     *             if a general error occurs
     * @throws FileNotReadableException
     *             if the txt can't be read
     * 
     * 
     * @throws NoParserFoundException
     *             if the end of the chain is reached an no suitable parser was
     *             found to the given txt
     */
    public Collection<OfficeInfo> parseTxt(InputStream txtFile)
	    throws ParserException, FileNotReadableException,
	    NoParserFoundException {
	Collection<OfficeInfo> officeInfos = null;
	try {
	    // logger.debug("original txt: " + this.originalTxtString);
	    this.txtFile = txtFile;

	    boolean willProcess = this.canParseTxt();
	    // verify if the parser can process the file
	    if (willProcess) {
		logger.debug(this.getClass() + " this parser will process");
		officeInfos = this.applyParser();
		// otherwise it will call the next in the chain
	    } else {
		logger.debug(this.getClass() + " this parser will delegate");
		officeInfos = this.callNextParser();
	    }

	} catch (IOException e) {
	    logger.error(ParserException.GENERAL_ERROR, e);
	    throw new ParserException(ParserException.GENERAL_ERROR, e);
	}

	return officeInfos;
    }

    /**
     * Returns the txt Inputstream
     * 
     * @return InputStream
     */
    protected InputStream getTxtFile() {
	return txtFile;
    }

    /**
     * Indicates if the parser is in charge of read the txt<br>
     * Returns true if the parser will process the file, false if it will
     * delegate the process to the next parser
     * 
     * @throws FileNotReadableException
     *             if can not read the txt
     * @throws ParserException
     *             if occurs a general error
     * 
     * @return boolean
     */
    protected abstract boolean canParseTxt() throws ParserException,
	    FileNotReadableException;

    /**
     * Method that holds the specific logic to parse each txt and must be
     * implemented by all the concrete classes
     * 
     * @return UPSInfo
     */
    protected abstract Collection<OfficeInfo> applyParser() throws IOException;

     
    @SuppressWarnings("unchecked")
    protected Collection<OfficeInfo> executeParseOnNextParserCollection()
	    throws ParserException, FileNotReadableException,
	    NoParserFoundException {
	return ((ParseOfficeTxt)this.nextParser).parseTxt(this.txtFile);
    }
    
    /**
     * this parser returns a collections, therefore if the
     * executeParseOnNextParser is called should be an exception
     */
    @SuppressWarnings("unchecked")
    protected Object executeParseOnNextParser() throws ParserException {
	throw new ParserException(ParserException.PARSER_EXECUTE_METHOD_ERROR
		+ "Return single object");
    }

}
