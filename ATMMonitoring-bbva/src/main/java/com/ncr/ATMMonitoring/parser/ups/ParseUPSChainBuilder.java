package com.ncr.ATMMonitoring.parser.ups;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.Predicate;
import org.apache.log4j.Logger;

import com.ncr.ATMMonitoring.parser.GenericChainBuilder;
import com.ncr.ATMMonitoring.parser.GenericChainParser;
import com.ncr.ATMMonitoring.parser.exception.FileNotReadableException;
import com.ncr.ATMMonitoring.parser.exception.NoParserFoundException;
import com.ncr.ATMMonitoring.parser.exception.ParserException;
import com.ncr.ATMMonitoring.parser.ups.annotation.UPSParser;
import com.ncr.ATMMonitoring.parser.ups.dto.UPSInfo;

/**
 * Class that builds and executes the chain of responsibility of UPS Parsers <BR>
 * Is possible to add parsers just adding classes to the classpath, all the
 * classes that extends from {@link ParseUPSXML} and are annotated with
 * {@link UPSParser} will be added automatically<br>
 * The new classes can be added in jar format, is only required that all the new
 * classes are in the classpath.<br>
 * To prioritize some classes in the chain use the annotation {@link UPSParser}
 * with the value {@link UPSParser#HIGH_PRIORITY} as follows<br>
 * 
 * @UPSParser(priority = UPSParser.HIGH_PRIORITY)<br>
 *                     public class MyParserClass extends ParseUPSXML {<br>
 *                     }<br>
 * 
 *                     To start the chain just call the method
 *                     {@link ParseUPSChainBuilder#parse(InputStream)},
 * 
 * @author Otto Abreu
 * 
 */
public class ParseUPSChainBuilder extends GenericChainBuilder {

    /** The logger. */
    protected static final Logger logger = Logger
	    .getLogger(ParseUPSChainBuilder.class);
    protected static final List<Class<? extends GenericChainParser>> PARSERS_CLASSES = new ArrayList<Class<? extends GenericChainParser>>();
    protected static final List<Class<? extends GenericChainParser>> NORMAL_PRIORITY_PARSERS = new ArrayList<Class<? extends GenericChainParser>>();
    private static final ParseUPSChainBuilder PARSER_INSTANCE;

    static {
	// load all the classes
	List<Class<? extends GenericChainParser>> unorganizedClasses = ParseUPSChainBuilder
		.findParsersClasses(UPSParser.class);
	PARSERS_CLASSES.addAll(ParseUPSChainBuilder.organizeClassesByPriority(
		unorganizedClasses, getPredicateForHighPriority(),
		NORMAL_PRIORITY_PARSERS));
	PARSER_INSTANCE = ParseUPSChainBuilder.getInstance();
	PARSER_INSTANCE.parsersClases.addAll(PARSERS_CLASSES);
	logger.debug("All found parsers: " + PARSERS_CLASSES);
    }

    private static Predicate getPredicateForHighPriority() {
	return new Predicate() {

	    @Override
	    public boolean evaluate(Object classObject) {
		boolean isHighPriority = false;
		@SuppressWarnings("unchecked")
		Class<? extends ParseUPSXML> parseClass = (Class<? extends ParseUPSXML>) classObject;
		UPSParser annotation = parseClass
			.getAnnotation(UPSParser.class);
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
     * Extract the information from the given xml in InputStream format
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
    public static UPSInfo parse(InputStream xmlFile) throws ParserException,
	    FileNotReadableException, NoParserFoundException {
	ParseUPSXML firstLink = PARSER_INSTANCE.getParser();
	return firstLink.parseXML(xmlFile);
    }

    /**
     * Returns a new instance of the class
     * 
     * @return ParseUPSChainBuilder
     */
    public static ParseUPSChainBuilder getInstance() {
	return new ParseUPSChainBuilder();
    }

    /**
     * Private constructor
     */
    private ParseUPSChainBuilder() {
	super();
    }
}
