package com.ncr.ATMMonitoring.parser.users.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RolesParser {
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
