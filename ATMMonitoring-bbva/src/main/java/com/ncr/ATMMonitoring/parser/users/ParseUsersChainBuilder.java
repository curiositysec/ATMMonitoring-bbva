package com.ncr.ATMMonitoring.parser.users;

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
import com.ncr.ATMMonitoring.parser.ups.dto.UPSInfo;
import com.ncr.ATMMonitoring.parser.users.annotation.UsersParser;
import com.ncr.ATMMonitoring.parser.users.dto.UsersInfo;

/**
 * Class that builds and executes the chain of responsibility of users Parsers <BR>
 * It's possible to add parsers just by adding classes to the classpath which
 * extend from {@link ParseUsersExcel} and are annotated with
 * {@link UsersParser}<br>
 * The new classes can be added in jar format as well, as long as they are in
 * the classpath.<br>
 * To prioritize some classes in the chain use the annotation
 * {@link UsersParser} with the value {@link UsersParser#HIGH_PRIORITY} as
 * follows<br>
 * 
 * @UPSParser(priority = UsersParser.HIGH_PRIORITY)<br>
 *                     public class MyParserClass extends ParseUsersExcel {<br>
 *                     }<br>
 * 
 *                     To start the chain just call the method
 *                     {@link ParseUsersChainBuilder#parse(InputStream)},
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 * @author Otto Abreu
 * @author Eva Pindado (EP410008@ncr.com)
 * 
 */
public class ParseUsersChainBuilder extends GenericChainBuilder {

    /** The logger. */
    protected static final Logger logger = Logger
	    .getLogger(ParseUsersChainBuilder.class);

    protected static final List<Class<? extends GenericChainParser>> PARSERS_CLASSES = new ArrayList<Class<? extends GenericChainParser>>();
    protected static final List<Class<? extends GenericChainParser>> NORMAL_PRIORITY_PARSERS = new ArrayList<Class<? extends GenericChainParser>>();
    private static final ParseUsersChainBuilder PARSER_INSTANCE;
    
    static {
	// load all the classes
	List<Class<? extends GenericChainParser>> unorganizedClasses = ParseUsersChainBuilder
		.findParsersClasses(UsersParser.class);
	PARSERS_CLASSES.addAll(ParseUsersChainBuilder
		.organizeClassesByPriority(unorganizedClasses,
			getPredicateForHighPriority(),NORMAL_PRIORITY_PARSERS));
	
	PARSER_INSTANCE = ParseUsersChainBuilder.getInstance();
	PARSER_INSTANCE.parsersClases.addAll(PARSERS_CLASSES);
	logger.debug("All found parsers: " + PARSERS_CLASSES);
    }

    /**
     * Gets the predicate to use in the priority sort
     * @return
     */
    private static Predicate getPredicateForHighPriority() {
	return new Predicate() {

	    @Override
	    public boolean evaluate(Object classObject) {
		boolean isHighPriority = false;
		@SuppressWarnings("unchecked")
		Class<? extends ParseUsersExcel> parseClass = (Class<? extends ParseUsersExcel>) classObject;
		UsersParser annotation = parseClass
			.getAnnotation(UsersParser.class);
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
     *             if can not read the excel
     * 
     * 
     * @throws NoParserFoundException
     *             if the end of the chain is reached an no suitable parser was
     *             found to the given excel
     */
    public static Collection<UsersInfo> parse(String excelFile)
	    throws ParserException, FileNotReadableException,
	    NoParserFoundException {
	ParseUsersExcel firstLink = PARSER_INSTANCE.getParser();
	return firstLink.parseExcel(excelFile);
    }

    /**
     * Returns a new instance of the class
     * 
     * @return ParseUPSChainBuilder
     */
    public static ParseUsersChainBuilder getInstance() {
	return new ParseUsersChainBuilder();
    }

    /**
     * Private constructor
     */
    private ParseUsersChainBuilder() {
	super();
    }

}
