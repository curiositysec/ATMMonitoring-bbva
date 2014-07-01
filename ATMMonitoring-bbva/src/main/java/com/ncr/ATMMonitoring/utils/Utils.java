package com.ncr.ATMMonitoring.utils;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.digest.DigestUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * The Class Utils.
 * 
 * Commodity methods for several purposes.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public abstract class Utils {

    /** Hardcoded key for the encrypted keystore. */
    public final static String KEYSTORE_KEY = "f|7,1e>Nr-$e1I2H";

    /** Hardcoded key for the encrypted privatekey. */
    public final static String PRIVATEKEY_KEY = "vq~aQ}a$DIg'ry47";

    /** Hardcoded license key. */
    private static final String HARDCODED_KEY = "4u%qyfw^";

    /** Terminal limit value that stands for no limit. */
    public static final long NO_TERMINAL_LIMIT = -1;

    /** Terminal limit value that stands for no limit (1970-01-01 01:00). */
    public static final Date NO_DATE_LIMIT = new Date(0);

    /** The Gson object. */
    private static Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    /**
     * Decrypts a string using the passed key and the hardcoded one.
     * 
     * @param configuredKey
     *            the configured encryption key
     * @param encrypted
     *            the string to decrypt
     * @return the decrypted string
     */
    public static String decrypt(String configuredKey, String encrypted)
	    throws GeneralSecurityException {
	String key = configuredKey.substring(1, 2)
		+ configuredKey.substring(3, 4) + configuredKey.substring(5, 6)
		+ configuredKey.substring(7, 8)
		+ configuredKey.substring(9, 10)
		+ configuredKey.substring(11, 12)
		+ configuredKey.substring(13, 14)
		+ configuredKey.substring(15, 16) + HARDCODED_KEY;

	byte[] encryptedBytes = DatatypeConverter.parseBase64Binary(encrypted);
	byte[] raw = key.getBytes(Charset.forName("UTF8"));
	if (raw.length != 16) {
	    throw new IllegalArgumentException("Invalid key size.");
	}
	SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

	Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	cipher.init(Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec(
		new byte[16]));
	byte[] original = cipher.doFinal(encryptedBytes);

	return new String(original, Charset.forName("UTF8"));
    }

    /**
     * Decrypts a string using the passed key.
     * 
     * @param key
     *            the encryption key
     * @param encrypted
     *            the string to decrypt
     * @return the decrypted string
     */
    public static String simpleDecrypt(String key, String encrypted)
	    throws GeneralSecurityException {

	byte[] encryptedBytes = DatatypeConverter.parseBase64Binary(encrypted);
	byte[] raw = key.getBytes(Charset.forName("UTF8"));
	if (raw.length != 16) {
	    throw new IllegalArgumentException("Invalid key size.");
	}
	SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

	Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	cipher.init(Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec(
		new byte[16]));
	byte[] original = cipher.doFinal(encryptedBytes);

	return new String(original, Charset.forName("UTF8"));
    }

    /**
     * Tranforms an object to its Gson json representation.
     * 
     * @param object
     *            the object
     * @return the json string
     */
    public static String toJson(Object object) {
	return gson.toJson(object);
    }

    /**
     * Tranforms a Gson json representation to its original object.
     * 
     * @param the
     *            json string
     * @param the
     *            destination class
     * @return the original object
     */
    public static <T> T fromJson(String json, Class<T> classOfT) {
	return gson.fromJson(json, classOfT);
    }

    /**
     * Concats strings with the given separator.
     * 
     * @param strings
     *            the strings
     * @param separator
     *            the separator
     * @return the concatted strings
     */
    public static String concatStrings(List<String> strings, char separator) {
	String result = "", separatorString = String.valueOf(separator);
	Iterator<String> iter = strings.iterator();
	if (iter.hasNext()) {
	    result += iter.next().replace(separatorString,
		    "/" + separatorString);
	    while (iter.hasNext()) {
		result += separator
			+ iter.next().replace(separatorString,
				"/" + separatorString);
	    }
	}
	return result;
    }

    /**
     * Splits strings concatted with the given separator.
     * 
     * @param strings
     *            the concatted strings
     * @param separator
     *            the separator
     * @return the list with all the split strings
     */
    public static List<String> splitStrings(String strings, char separator) {
	List<String> result = new ArrayList<String>();
	String separatorString = String.valueOf(separator);
	Iterator<String> iter = Arrays.asList(
		strings.split(String.valueOf(separator))).iterator();
	while (iter.hasNext()) {
	    result.add(iter.next().replace("/" + separatorString,
		    separatorString));
	}
	return result;
    }

    /**
     * Concat integers into an string with the given separator.
     * 
     * @param integers
     *            the integers
     * @param separator
     *            the separator
     * @return the concatted string
     */
    public static String concatIntegers(List<Integer> integers, char separator) {
	String result = "", separatorString = String.valueOf(separator);
	Iterator<Integer> iter = integers.iterator();
	if (iter.hasNext()) {
	    result += iter.next().toString()
		    .replace(separatorString, "/" + separatorString);
	    while (iter.hasNext()) {
		result += separator
			+ iter.next()
				.toString()
				.replace(separatorString, "/" + separatorString);
	    }
	}
	return result;
    }

    /**
     * Split integers concatted into an string with the given separator.
     * 
     * @param integers
     *            the integers
     * @param separator
     *            the separator
     * @return the list with all the split integers
     */
    public static List<Integer> splitIntegers(String integers, char separator) {
	List<Integer> result = new ArrayList<Integer>();
	String separatorString = String.valueOf(separator);
	Iterator<String> iter = Arrays.asList(
		integers.split(String.valueOf(separator))).iterator();
	while (iter.hasNext()) {
	    result.add(Integer.decode(iter.next().replace(
		    "/" + separatorString, separatorString)));
	}
	return result;
    }

    /**
     * Unescape special characters in a json chain.
     * 
     * @param chain
     *            the json chain
     * @return the unescaped chain
     */
    public static String unescapeJsonChain(String chain) {
	return chain.replaceAll("\\\\\\\\", "@@@@")
		.replaceAll("\\\\u003c", "<").replaceAll("\\\\u003d", "=")
		.replaceAll("\\\\u003e", ">").replaceAll("\\\\u0026", "&")
		.replaceAll("\\\\\\\"", "\"")
		.replaceAll("@@@@", Matcher.quoteReplacement("\\"));
    }

    /**
     * Gets the MD5 hex from the given string.
     * 
     * @param content
     *            the string
     * @return the MD5 hex
     */
    public static String getMD5Hex(String content) {
	return DigestUtils.md5Hex(content);
    }
}