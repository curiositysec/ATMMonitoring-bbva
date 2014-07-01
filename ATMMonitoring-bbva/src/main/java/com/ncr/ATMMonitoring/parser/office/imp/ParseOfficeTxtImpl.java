package com.ncr.ATMMonitoring.parser.office.imp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashSet;

import com.ncr.ATMMonitoring.parser.exception.FileNotReadableException;
import com.ncr.ATMMonitoring.parser.exception.ParserException;
import com.ncr.ATMMonitoring.parser.office.ParseOfficeChainBuilder;
import com.ncr.ATMMonitoring.parser.office.ParseOfficeTxt;
import com.ncr.ATMMonitoring.parser.office.annotation.OfficeParser;
import com.ncr.ATMMonitoring.parser.office.dto.OfficeInfo;

/**
 * Class that parses an offices txt.
 * 
 * <b><i>Do not call the parser directly, call
 * {@link ParseOfficeChainBuilder#parse(InputStream)}</i></b>
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 * @author Otto Abreu
 * 
 */
@OfficeParser(priority = OfficeParser.HIGH_PRIORITY)
public class ParseOfficeTxtImpl extends ParseOfficeTxt {

    private final static String encoding = "ISO8859_15";

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.parser.office.ParseOfficeTxt#canParseTxt()
     */
    @Override
    protected boolean canParseTxt() throws ParserException,
	    FileNotReadableException {
	return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.parser.office.ParseOfficeTxt#applyParser()
     */
    @Override
    protected Collection<OfficeInfo> applyParser() throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(
		getTxtFile(), encoding));
	String line;
	Collection<OfficeInfo> offices = new HashSet<OfficeInfo>();
	OfficeInfo office;
	while ((line = reader.readLine()) != null) {
	    office = parseLine(line);
	    if (office != null) {
		offices.add(office);
	    }
	}
	reader.close();
	return offices;
    }

    /**
     * Method that parses one line from the offices file and returns an
     * {@link OfficeInfo} with its data.
     * 
     * @param line
     *            the offices txt file line
     * @return an {@link OfficeInfo} with the data
     */
    private OfficeInfo parseLine(String line) {
	if (line.length() >= 519) {
	    OfficeInfo office = new OfficeInfo();
	    office.setCode(line.substring(0, 12).trim());
	    office.setName(line.substring(27, 63).trim());
	    office.setAddress(line.substring(83, 119).trim());
	    office.setPostcode(line.substring(119, 124).trim());
	    office.setCity(line.substring(124, 154).trim());
	    office.setCountry(line.substring(515, 519).trim());
	    return office;
	}
	return null;
    }

}
