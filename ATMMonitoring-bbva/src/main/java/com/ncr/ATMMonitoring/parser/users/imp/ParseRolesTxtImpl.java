package com.ncr.ATMMonitoring.parser.users.imp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.ncr.ATMMonitoring.parser.exception.FileNotReadableException;
import com.ncr.ATMMonitoring.parser.exception.NoParserFoundException;
import com.ncr.ATMMonitoring.parser.exception.ParserException;
import com.ncr.ATMMonitoring.parser.office.dto.OfficeInfo;
import com.ncr.ATMMonitoring.parser.users.ParseRolesChainBuilder;
import com.ncr.ATMMonitoring.parser.users.ParseRolesTxt;
import com.ncr.ATMMonitoring.parser.users.annotation.RolesParser;
import com.ncr.ATMMonitoring.parser.users.dto.RolesInfo;

/**
 * Class that parses a users mdc file.
 * 
 * <b><i>Do not call the parser directly, call
 * {@link ParseRolesChainBuilder#parse(String)}</i></b>
 * 
 * @author Eva Pindado (EP410008.ncr.com)
 * 
 */
@RolesParser(priority = RolesParser.HIGH_PRIORITY)
public class ParseRolesTxtImpl extends ParseRolesTxt {

    private final static String ENCODING = "ISO8859_15";

    private static final String APP_CODE = "GNME";
    private static final String USERNAME_REGEX = "^[A-Za-z0-9]+";
    private static final String ROL_REGEX = "[0-9]{2}$";

    /** The logger. */
    private static final Logger logger = Logger
	    .getLogger(ParseRolesTxtImpl.class);

    @Override
    protected boolean canParseTxt() throws ParserException,
	    FileNotReadableException {
	// TODO Auto-generated method stub
	return true;
    }

    @Override
    protected Collection<RolesInfo> applyParser() throws ParserException,
	    FileNotReadableException, NoParserFoundException {
	// TODO Auto-generated method stub
	Collection<RolesInfo> roles = null;
	try (BufferedReader reader = getFileReader()) {

	    roles = this.readLinesFromFile(reader);

	} catch (FileNotFoundException e) {
	    throw new FileNotReadableException(
		    FileNotReadableException.FILE_NOT_FOUND + getMdcFile());
	} catch (IOException e) {
	    throw new FileNotReadableException(
		    FileNotReadableException.IO_ERROR + e.getMessage(), e);
	} catch (Exception e) {
	    throw new ParserException(ParserException.GENERAL_ERROR, e);
	}

	return roles;
    }

    private BufferedReader getFileReader() throws UnsupportedEncodingException {
	return new BufferedReader(new InputStreamReader(getMdcFile(), ENCODING));
    }

    private Collection<RolesInfo> readLinesFromFile(BufferedReader reader)
	    throws IOException {
	String line = null;
	Collection<RolesInfo> roles = new HashSet<RolesInfo>();

	while ((line = reader.readLine()) != null) {
	   this.addRollToColectionIfNotNull(line, roles);
	}
	return roles;

    }
    
    
    private void addRollToColectionIfNotNull(String line,Collection<RolesInfo> roles){
	RolesInfo rol = this.parseLine(line);
	if(rol != null){
	    roles.add(rol);
	}
    }

    /**
     * Method that parses one line from the offices file and returns an
     * {@link OfficeInfo} with its data.
     * 
     * @param line
     *            the offices txt file line
     * @return an {@link OfficeInfo} with the data
     */
    private RolesInfo parseLine(String line) {
	RolesInfo rol = null;
	if (isLineValid(line)) {
	    rol = new RolesInfo();
	    // rol.setUsername(line.substring(0, 7).trim());
	    // rol.setCode(line.substring(8, 16).trim());
	    // rol.setRol(line.substring(17, 19).trim());
	    String userName = this.getUserName(line);
	    String code = this.getCode(line);
	    String rolInLine = this.getRol(line);
	    rol.setUsername(userName);
	    rol.setCode(code);
	    rol.setRol(rolInLine);

	} else {
	    logger.info("Line invalid: " + line);
	}
	return rol;
    }

    private boolean isLineValid(String line) {
	if (isGNMEPresent(line) && isUsernamePresent(line)
		&& isRolPresent(line)) {
	    return true;
	} else {
	    return false;
	}
    }

    private boolean isGNMEPresent(String line) {
	return this.validateLineRegex(line, APP_CODE);

    }

    private boolean isUsernamePresent(String line) {
	return this.validateLineRegex(line, USERNAME_REGEX);
    }

    private boolean isRolPresent(String line) {
	return this.validateLineRegex(line, ROL_REGEX);
    }

    private boolean validateLineRegex(String line, String regex) {

	Matcher matcher = this.getMatcher(line, regex);
	return matcher.find();
    }

    private Matcher getMatcher(String line, String regex) {
	Pattern patt = Pattern.compile(regex);
	Matcher matcher = patt.matcher(line);
	return matcher;
    }

    private String getUserName(String line) {
	return this.getSegmentFromLine(line, USERNAME_REGEX);
    }

    private String getCode(String line) {
	return this.getSegmentFromLine(line, APP_CODE);
    }

    private String getRol(String line) {
	return this.getSegmentFromLine(line, ROL_REGEX);
    }

    private String getSegmentFromLine(String line, String regex) {
	Matcher matcher = this.getMatcher(line, regex);
	matcher.find();
	return matcher.group();
    }

}
