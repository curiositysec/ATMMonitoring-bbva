package com.ncr.ATMMonitoring.parser.office.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation that marks classes as valid office (location) Parsers
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 * @author Otto Abreu
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface OfficeParser {

    /**
     * Indicates that the target parser will have high priority when building
     * the execution chain HIGH_PRIORITY = true;
     */
    public static final boolean HIGH_PRIORITY = true;

    /**
     * Indicate that the target parser will not have any priority when building
     * the execution chain DEFAULT_PRIORITY = false;
     */
    public static final boolean DEFAULT_PRIORITY = false;

    /**
     * Sets the priority of execution of the target parser<Br>
     * For setting a high priority please use {@link OfficeParser#HIGH_PRIORITY}
     * , otherwise {@link OfficeParser#DEFAULT_PRIORITY}<br>
     * If no priority is set, {@link OfficeParser#DEFAULT_PRIORITY} is assumed
     * 
     * @return boolean
     */
    boolean priority() default false;

}
