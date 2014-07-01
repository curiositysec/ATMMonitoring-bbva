/**
 * 
 */
package com.ncr.ATMMonitoring.parser;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.log4j.Logger;
import org.reflections.Reflections;

import com.ncr.ATMMonitoring.parser.exception.NoParserFoundException;
import com.ncr.ATMMonitoring.parser.ups.ParseUPSChainBuilder;
import com.ncr.ATMMonitoring.parser.ups.ParseUPSXML;
import com.ncr.ATMMonitoring.parser.ups.annotation.UPSParser;

/**
 * Class that builds  the chain of responsibility for all  Parsers <BR>
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
public abstract class GenericChainBuilder {
    
    /** The logger. */
    protected static final Logger logger = Logger
	    .getLogger(GenericChainBuilder.class);

    /** List with all the possible parser classes. */
    protected  final List<Class<? extends GenericChainParser>> parsersClases = new ArrayList<Class<? extends GenericChainParser>>();

    /** List with all the possible parser instances. */
    protected  static List< GenericChainParser> parsersInstances = new ArrayList<GenericChainParser>();
    

    

    /**
     * Reads the package <b>com.ncr.ATMMonitoring.parse.otherParsers</B> to add
     * new parsers to the chain
     * 
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     */
    protected static List<Class<? extends GenericChainParser>> findParsersClasses(Class<? extends Annotation> annotationClass) {

	Reflections reflections = new Reflections("");

	Set<Class<? extends Object>> subTypes = reflections
		.getTypesAnnotatedWith(annotationClass);
	logger.debug("all the classes: " + subTypes);

	@SuppressWarnings("unchecked")
	List<Class<? extends GenericChainParser>> parsersClass = (List<Class<? extends GenericChainParser>>) CollectionUtils
		.select(subTypes, new Predicate() {
		    // only loads concrete classes that extends from T
		    @Override
		    public boolean evaluate(Object parser) {
			boolean isGenericChainParser = false;
			Class<? extends Object> parserClass = (Class<? extends Object>) parser;

			if (!Modifier.isAbstract(parserClass.getModifiers())
				&& !Modifier.isInterface(parserClass
					.getModifiers())) {

			    if (GenericChainParser.class.isAssignableFrom(parserClass)) {
				isGenericChainParser = true;
			    } else {
				logger.warn("the class "
					+ parserClass
					+ " is not an instance of T and will be not included");
			    }
			}

			return isGenericChainParser;
		    }

		});
	logger.debug(" Added parsers: " + parsersClass);
	return parsersClass;
    }

    /**
     * Execute the {@link Class#newInstance()} in each class element to generate
     * a new instance, then add it into the Parser Instance list<br>
     * If the object can not be instantiated will do nothing
     */
    private  void createInstances() {
	// make sure that always generate a new instance
	parsersInstances.clear();

	for (int i = 0; i < parsersClases.size(); i++) {

	    Class<? extends GenericChainParser> parserClass = (Class<? extends GenericChainParser>) parsersClases
		    .get(i);

	    GenericChainParser instance = null;
	    try {

		instance = parserClass.newInstance();
		parsersInstances
			.add((GenericChainParser) instance);

	    } catch (InstantiationException e) {
		logger.warn("Can not instantiate the given parser: "
			+ parserClass + "  and will not be added to the chain",
			e);
		;
	    } catch (IllegalAccessException e) {
		logger.warn(
			"Can not instantiate the given parser: "
				+ parserClass
				+ "  because represents an abstract class, an interface, an array class, a primitive type, or void; or if the class has no nullary constructor; ",
			e);
	    } catch (Throwable t) {
		logger.warn("Can not instantiate the given parser: "
			+ parserClass + " due  " + t.getMessage()
			+ "  and will not be added to the chain", t);
	    }

	}

    }

    /**
     * Builds the chain. Iterates over the list of instances and add the next
     * parser to each parser
     */
    private static void buildChain() {

	// only iterate to the i-1 element of the list because the last does not
	// need a next parser
	for (int i = 0; i < (parsersInstances.size() - 1); i++) {

	    GenericChainParser instance = parsersInstances.get(i);

	    GenericChainParser nextInstance = parsersInstances.get(i + 1);
	    instance.setNextParser(nextInstance);

	}

    }

    /**
     * Returns the first link in the chain
     * @param <T>
     * 
     * @return GenericChainParser
     * @throws NoParserFoundException
     *             if no parsers were found
     */
    @SuppressWarnings("unchecked")
    protected  <T extends GenericChainParser> T getParser() throws NoParserFoundException {
	// always get new instances
	this.createInstances();

	if (!parsersInstances.isEmpty()) {
	    // create the chain adding the next parser to each instance
	    GenericChainBuilder.buildChain();
	    return (T)parsersInstances.get(0);
	} else {
	    throw new NoParserFoundException(
		    NoParserFoundException.NO_PARSERS_FOUND);
	}

    }

    /**
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    protected static  List<Class<? extends GenericChainParser>> organizeClassesByPriority(
	    List<Class<? extends GenericChainParser>> unorganizedClasses, Predicate predicateForHighPriority, List<Class<? extends GenericChainParser>> normalPriority ) {

	// holds all the classes marked as high priority
	List<Class<? extends GenericChainParser>> organized = new ArrayList<Class<? extends GenericChainParser>>();
	// holds all the classes marked with default priority
	// is final because i want to used it inside an Anonymous class
	// i separate the high from the defautl
	List<Class<? extends GenericChainParser>> highPriority = (List<Class<? extends GenericChainParser>>) CollectionUtils
		.select(unorganizedClasses, predicateForHighPriority);
	// i add first those marked as high priority, then the rest
	organized.addAll(highPriority);
	logger.debug("high priority parsers:" + highPriority);
	organized.addAll(normalPriority);
	logger.debug("default priority parsers:" + normalPriority);
	return organized;
    }
}
