.. java:import:: java.nio.charset Charset

.. java:import:: java.security GeneralSecurityException

.. java:import:: java.util ArrayList

.. java:import:: java.util Arrays

.. java:import:: java.util Date

.. java:import:: java.util Iterator

.. java:import:: java.util List

.. java:import:: java.util.regex Matcher

.. java:import:: javax.crypto Cipher

.. java:import:: javax.crypto.spec IvParameterSpec

.. java:import:: javax.crypto.spec SecretKeySpec

.. java:import:: javax.xml.bind DatatypeConverter

.. java:import:: org.apache.commons.codec.digest DigestUtils

.. java:import:: com.google.gson Gson

.. java:import:: com.google.gson GsonBuilder

Utils
=====

.. java:package:: com.ncr.ATMMonitoring.utils
   :noindex:

.. java:type:: public abstract class Utils

   The Class Utils. Commodity methods for several purposes.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Fields
------
KEYSTORE_KEY
^^^^^^^^^^^^

.. java:field:: public static final String KEYSTORE_KEY
   :outertype: Utils

   Hardcoded key for the encrypted keystore.

NO_DATE_LIMIT
^^^^^^^^^^^^^

.. java:field:: public static final Date NO_DATE_LIMIT
   :outertype: Utils

   Terminal limit value that stands for no limit (1970-01-01 01:00).

NO_TERMINAL_LIMIT
^^^^^^^^^^^^^^^^^

.. java:field:: public static final long NO_TERMINAL_LIMIT
   :outertype: Utils

   Terminal limit value that stands for no limit.

PRIVATEKEY_KEY
^^^^^^^^^^^^^^

.. java:field:: public static final String PRIVATEKEY_KEY
   :outertype: Utils

   Hardcoded key for the encrypted privatekey.

Methods
-------
concatIntegers
^^^^^^^^^^^^^^

.. java:method:: public static String concatIntegers(List<Integer> integers, char separator)
   :outertype: Utils

   Concat integers into an string with the given separator.

   :param integers: the integers
   :param separator: the separator
   :return: the concatted string

concatStrings
^^^^^^^^^^^^^

.. java:method:: public static String concatStrings(List<String> strings, char separator)
   :outertype: Utils

   Concats strings with the given separator.

   :param strings: the strings
   :param separator: the separator
   :return: the concatted strings

decrypt
^^^^^^^

.. java:method:: public static String decrypt(String configuredKey, String encrypted) throws GeneralSecurityException
   :outertype: Utils

   Decrypts a string using the passed key and the hardcoded one.

   :param configuredKey: the configured encryption key
   :param encrypted: the string to decrypt
   :return: the decrypted string

getMD5Hex
^^^^^^^^^

.. java:method:: public static String getMD5Hex(String content)
   :outertype: Utils

   Gets the MD5 hex from the given string.

   :param content: the string
   :return: the MD5 hex

simpleDecrypt
^^^^^^^^^^^^^

.. java:method:: public static String simpleDecrypt(String key, String encrypted) throws GeneralSecurityException
   :outertype: Utils

   Decrypts a string using the passed key.

   :param key: the encryption key
   :param encrypted: the string to decrypt
   :return: the decrypted string

splitIntegers
^^^^^^^^^^^^^

.. java:method:: public static List<Integer> splitIntegers(String integers, char separator)
   :outertype: Utils

   Split integers concatted into an string with the given separator.

   :param integers: the integers
   :param separator: the separator
   :return: the list with all the split integers

splitStrings
^^^^^^^^^^^^

.. java:method:: public static List<String> splitStrings(String strings, char separator)
   :outertype: Utils

   Splits strings concatted with the given separator.

   :param strings: the concatted strings
   :param separator: the separator
   :return: the list with all the split strings

toJson
^^^^^^

.. java:method:: public static String toJson(Object object)
   :outertype: Utils

   Tranforms an object to its Gson json representation.

   :param object: the object
   :return: the json string

unescapeJsonChain
^^^^^^^^^^^^^^^^^

.. java:method:: public static String unescapeJsonChain(String chain)
   :outertype: Utils

   Unescape special characters in a json chain.

   :param chain: the json chain
   :return: the unescaped chain

