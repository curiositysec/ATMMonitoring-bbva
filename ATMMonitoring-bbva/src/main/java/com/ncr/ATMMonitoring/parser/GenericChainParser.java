package com.ncr.ATMMonitoring.parser;

import java.io.IOException;
import java.util.Collection;

import com.ncr.ATMMonitoring.parser.exception.FileNotReadableException;
import com.ncr.ATMMonitoring.parser.exception.NoParserFoundException;
import com.ncr.ATMMonitoring.parser.exception.ParserException;

/**
 * Defines in a generic way a parser to be used in a chain of responsibility
 * 
 * @author Otto Abreu
 * 
 */
public abstract class GenericChainParser {

    /** Next link in the chain. */
    protected GenericChainParser nextParser;

   
    public void setNextParser(GenericChainParser nextInstance) {
	this.nextParser = nextInstance;

    }

    protected  <T> Collection<T> callNextParserCollection()
	    throws ParserException, FileNotReadableException,
	    NoParserFoundException, IOException {
	Collection<T> parsedObjects = null;

	if (this.nextParser != null) {
	    parsedObjects = this.executeParseOnNextParserCollection();

	} else {
	    // no parser can read the file
	    throw new NoParserFoundException(
		    NoParserFoundException.NO_PARSER_FOUND);
	}
	return parsedObjects;
    }

    /**
     * Execute the corresponding parse method and returns a collection of parsed
     * objects
     * @param <T>
     * 
     * @return
     */
    protected abstract <T> Collection<T> executeParseOnNextParserCollection()throws IOException, ParserException, FileNotReadableException, NoParserFoundException;

    
    /**
     * calls the next parser that returns only a object
     * @return
     * @throws ParserException
     * @throws FileNotReadableException
     * @throws NoParserFoundException
     * @throws IOException
     */
    protected  <T> T callNextParser() throws ParserException,
	    FileNotReadableException, NoParserFoundException, IOException {
	T dto= null;

	if (this.nextParser != null) {
	   
	    dto = this.executeParseOnNextParser();
	} else {
	    // no parser can read the file
	    throw new NoParserFoundException(
		    NoParserFoundException.NO_PARSER_FOUND);
	}
	return dto;
    }

    /**
     * Execute the corresponding parse method and returns parsed object
     * 
     * @return
     */
    protected abstract <T> T executeParseOnNextParser()throws IOException, ParserException, FileNotReadableException, NoParserFoundException;
}
