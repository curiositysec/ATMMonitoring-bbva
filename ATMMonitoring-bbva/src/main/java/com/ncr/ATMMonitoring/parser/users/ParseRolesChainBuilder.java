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
import com.ncr.ATMMonitoring.parser.users.annotation.RolesParser;
import com.ncr.ATMMonitoring.parser.users.dto.RolesInfo;

/**
 * 
 * @author Eva Pindado (EP410008@ncr.com)
 * 
 */
public class ParseRolesChainBuilder extends GenericChainBuilder {

    /** The logger. */
    protected static final Logger logger = Logger
	    .getLogger(ParseUsersChainBuilder.class);
    
    protected static final List<Class<? extends GenericChainParser>> PARSERS_CLASSES = new ArrayList<Class<? extends GenericChainParser>>();
    protected static final List<Class<? extends GenericChainParser>> NORMAL_PRIORITY_PARSERS = new ArrayList<Class<? extends GenericChainParser>>();
    private static final ParseRolesChainBuilder PARSER_INSTANCE;
    static {
	// load all the classes
	List<Class<? extends GenericChainParser>> unorganizedClasses = ParseRolesChainBuilder
		.findParsersClasses(RolesParser.class);
	PARSERS_CLASSES.addAll(ParseRolesChainBuilder
		.organizeClassesByPriority(unorganizedClasses,
			getPredicateForHighPriority(),NORMAL_PRIORITY_PARSERS));
	
	PARSER_INSTANCE = ParseRolesChainBuilder.getInstance();
	PARSER_INSTANCE.parsersClases.addAll(PARSERS_CLASSES);
	
	logger.debug("All found parsers: " + PARSERS_CLASSES);
    }

    private static Predicate getPredicateForHighPriority() {
	return new Predicate() {
	    @Override
	    public boolean evaluate(Object classObject) {
		boolean isHighPriority = false;
		@SuppressWarnings("unchecked")
		Class<? extends ParseRolesTxt> parseClass = (Class<? extends ParseRolesTxt>) classObject;
		RolesParser annotation = parseClass
			.getAnnotation(RolesParser.class);
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
    public static Collection<RolesInfo> parse(InputStream mdcFile)
	    throws ParserException, FileNotReadableException,
	    NoParserFoundException {
	ParseRolesTxt firstLink = PARSER_INSTANCE.getParser();
	return firstLink.parseTxt(mdcFile);
    }

    /**
     * Returns a new instance of the class
     * 
     * @return ParseUPSChainBuilder
     */
    public static ParseRolesChainBuilder getInstance() {
	return new ParseRolesChainBuilder();
    }

    /**
     * Private constructor
     */
    private ParseRolesChainBuilder() {
	super();
    }

}
