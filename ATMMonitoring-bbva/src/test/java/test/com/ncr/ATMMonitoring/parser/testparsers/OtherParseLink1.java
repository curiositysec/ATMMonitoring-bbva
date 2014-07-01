package test.com.ncr.ATMMonitoring.parser.testparsers;

import org.apache.log4j.Logger;

import com.ncr.ATMMonitoring.parser.exception.FileNotReadableException;
import com.ncr.ATMMonitoring.parser.exception.NoParserFoundException;
import com.ncr.ATMMonitoring.parser.exception.ParserException;
import com.ncr.ATMMonitoring.parser.ups.annotation.UPSParser;
import com.ncr.ATMMonitoring.parser.ups.dto.UPSInfo;
import com.ncr.ATMMonitoring.parser.ups.imp.ParseUPSDom;

@UPSParser
public class OtherParseLink1 extends ParseUPSDom {

    private String xml;
    private static final Logger logger = Logger
	    .getLogger(OtherParseLink1.class);

    @Override
    protected UPSInfo applyParser() throws ParserException,
	    FileNotReadableException, NoParserFoundException {
	logger.debug("Link1 parsing: " + this.xml);
	return new UPSInfo();
    }

    @Override
    protected boolean canParseXML() throws ParserException {
	this.xml = this.getOriginalXmlString();
	boolean parse = xml.equals("<link1></link1>");
	logger.debug("OtherParseLink1 evaluating:" + this.xml + " acepted? "
		+ parse);
	return parse;

    }

}
