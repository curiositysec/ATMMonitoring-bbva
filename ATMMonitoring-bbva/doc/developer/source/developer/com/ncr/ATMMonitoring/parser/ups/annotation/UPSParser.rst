.. java:import:: java.lang.annotation ElementType

.. java:import:: java.lang.annotation Retention

.. java:import:: java.lang.annotation RetentionPolicy

.. java:import:: java.lang.annotation Target

UPSParser
=========

.. java:package:: com.ncr.ATMMonitoring.parser.ups.annotation
   :noindex:

.. java:type:: @Retention @Target public @interface UPSParser

   Annotation that marks classes as valid XML Parsers

   :author: Otto Abreu

Fields
------
DEFAULT_PRIORITY
^^^^^^^^^^^^^^^^

.. java:field:: public static final boolean DEFAULT_PRIORITY
   :outertype: UPSParser

   Indicate that the target parser will not have any priority when building the execution chain DEFAULT_PRIORITY = false;

HIGH_PRIORITY
^^^^^^^^^^^^^

.. java:field:: public static final boolean HIGH_PRIORITY
   :outertype: UPSParser

   Indicates that the target parser will have high priority when building the execution chain HIGH_PRIORITY = true;

