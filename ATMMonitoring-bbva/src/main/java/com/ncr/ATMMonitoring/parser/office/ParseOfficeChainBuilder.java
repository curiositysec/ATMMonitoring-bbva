package com.ncr.ATMMonitoring.parser.office;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.Predicate;
import org.apache.log4j.Logger;

import com.ncr.ATMMonitoring.parser.GenericChainBuilder;
import com.ncr.ATMMonitoring.parser.GenericChainParser;
import com.ncr.ATMMonitoring.parser.exception.FileNotReadableException;
import com.ncr.ATMMonitoring.parser.exception.NoParserFoundException;
import com.ncr.ATMMonitoring.parser.exception.ParserException;
import com.ncr.ATMMonitoring.parser.office.annotation.OfficeParser;
import com.ncr.ATMMonitoring.parser.office.dto.OfficeInfo;
import com.ncr.ATMMonitoring.parser.ups.dto.UPSInfo;

/**
 * Class that builds and executes the chain of responsibility of office
 * (location) Parsers <BR>
 * It's possible to add parsers just by adding classes to the classpath which
 * extend from {@link ParseOfficeTxt} and are annotated with
 * {@link OfficeParser}<br>
 * The new classes can be added in jar format as well, as long as they are in
 * the classpath.<br>
 * To prioritize some classes in the chain use the annotation
 * {@link OfficeParser} with the value {@link OfficeParser#HIGH_PRIORITY} as
 * follows<br>
 * 
 * @UPSParser(priority = OfficeParser.HIGH_PRIORITY)<br>
 *                     public class MyParserClass extends ParseOfficeTxt {<br>
 *                     }<br>
 * 
 *                     To start the chain just call the method
 *                     {@link ParseOfficeChainBuilder#parse(InputStream)},
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 * @author Otto Abreu
 * 
 */
public class ParseOfficeChainBuilder extends GenericChainBuilder {

    /** The logger. */
    protected static final Logger logger = Logger
	    .getLogger(ParseOfficeChainBuilder.class);

    protected static final List<Class<? extends GenericChainParser>> PARSERS_CLASSES = new ArrayList<Class<? extends GenericChainParser>>();
    protected static final List<Class<? extends GenericChainParser>> NORMAL_PRIORITY_PARSERS = new ArrayList<Class<? extends GenericChainParser>>();
    private static final ParseOfficeChainBuilder PARSER_INSTANCE;

    static {
	// load all the classes
	List<Class<? extends GenericChainParser>> unorganizedClasses = ParseOfficeChainBuilder
		.findParsersClasses(OfficeParser.class);
	PARSERS_CLASSES.addAll( ParseOfficeChainBuilder
		.organizeClassesByPriority(unorganizedClasses,getPredicateForHighPriority(),NORMAL_PRIORITY_PARSERS));
	
	PARSER_INSTANCE =  ParseOfficeChainBuilder.getInstance();
	PARSER_INSTANCE.parsersClases.addAll(PARSERS_CLASSES);
	logger.debug("All found parsers: " + PARSERS_CLASSES);
    }
    
    private static Predicate getPredicateForHighPriority() {
	return new Predicate() {
	    @Override
	    public boolean evaluate(Object classObject) {
		boolean isHighPriority = false;
		@SuppressWarnings("unchecked")
		Class<? extends ParseOfficeTxt> parseClass = (Class<? extends ParseOfficeTxt>) classObject;
		OfficeParser annotation = parseClass
			.getAnnotation(OfficeParser.class);
		if (annotation.priority()) {
		    // is high so CollectionUtil will put it into a new
		    // List
		    isHighPriority = true;
		} else {
		    // is a default, so i added here because the list is
		    // final and i avoid another loop
		    NORMAL_PRIORITY_PARSERS.add(parseClass);
		}

		return isHighPriority;
	    }

	};
    }

    /**
     * Extract the information from the given txt in InputStream format
     * 
     * @param txtFile
     *            {@link InputStream}
     * @return {@link UPSInfo}
     * @throws ParserException
     *             if occurs a general error
     * @throws FileNotReadableException
     *             if can not read the txt
     * 
     * 
     * @throws NoParserFoundException
     *             if the end of the chain is reached an no suitable parser was
     *             found to the given txt
     */
    public static Collection<OfficeInfo> parse(InputStream txtFile)
	    throws ParserException, FileNotReadableException,
	    NoParserFoundException {
	ParseOfficeTxt firstLink = PARSER_INSTANCE.getParser();
	return firstLink.parseTxt(txtFile);
    }

    /**
     * Returns a new instance of the class
     * 
     * @return ParseUPSChainBuilder
     */
    public static ParseOfficeChainBuilder getInstance() {
	return new ParseOfficeChainBuilder();
    }

   


    /**
     * Private constructor
     */
    private ParseOfficeChainBuilder() {
	super();
    }

   
}
