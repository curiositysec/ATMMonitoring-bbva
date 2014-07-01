package com.ncr.ATMMonitoring.parser.users;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.ncr.ATMMonitoring.parser.GenericChainParser;
import com.ncr.ATMMonitoring.parser.exception.FileNotReadableException;
import com.ncr.ATMMonitoring.parser.exception.NoParserFoundException;
import com.ncr.ATMMonitoring.parser.exception.ParserException;
import com.ncr.ATMMonitoring.parser.ups.dto.UPSInfo;
import com.ncr.ATMMonitoring.parser.users.dto.UsersInfo;

/**
 * Interface that define a Excel Parser ( a Link in the responsibility chain) <br>
 * To start the chain and the parsing process call the
 * {@link ParseOfficeChainBuilder#parse(InputStream)}
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 * @author Otto Abreu
 * 
 */
public abstract class ParseUsersExcel extends GenericChainParser {

    /** The logger. */
    protected static final Logger logger = Logger
	    .getLogger(ParseUsersExcel.class);

    /** InputStream to the file to parse. */
    private String excelFile;

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
    public Collection<UsersInfo> parseExcel(String excelFile)
	    throws ParserException, FileNotReadableException,
	    NoParserFoundException {
	Collection<UsersInfo> userInfo = null;
	try {
	    this.excelFile = excelFile;

	    boolean willProcess = this.canParseExcel();
	    // verify if the parser can process the file
	    if (willProcess) {
		logger.debug(this.getClass() + " this parser will process");
		userInfo = this.applyParser();
		// otherwise it will call the next in the chain
	    } else {
		logger.debug(this.getClass() + " this parser will delegate");
		userInfo = this.callNextParserCollection();
	    }

	} catch (IOException e) {
	    logger.error(ParserException.GENERAL_ERROR, e);
	    throw new ParserException(ParserException.GENERAL_ERROR, e);
	}

	return userInfo;
    }

    @SuppressWarnings("unchecked")
    protected Collection<UsersInfo> executeParseOnNextParserCollection()
	    throws ParserException, FileNotReadableException,
	    NoParserFoundException {
	Collection<UsersInfo> userInfos = ((ParseUsersExcel) this.nextParser)
		.parseExcel(this.excelFile);
	return userInfos;
    }

    /**
     * Returns the excel String name
     * 
     * @return String
     */
    protected String getExcelFile() {
	return excelFile;
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
    protected abstract boolean canParseExcel() throws ParserException,
	    FileNotReadableException;

    /**
     * Method that holds the specific logic to parse each txt and must be
     * implemented by all the concrete classes
     * 
     * @return UPSInfo
     */
    protected abstract Collection<UsersInfo> applyParser()
	    throws ParserException, FileNotReadableException,
	    NoParserFoundException;

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
