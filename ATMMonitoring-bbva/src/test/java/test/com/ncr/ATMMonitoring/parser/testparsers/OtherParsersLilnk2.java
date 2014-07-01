package test.com.ncr.ATMMonitoring.parser.testparsers;

import org.apache.log4j.Logger;

import com.ncr.ATMMonitoring.parser.exception.NoParserFoundException;
import com.ncr.ATMMonitoring.parser.exception.ParserException;
import com.ncr.ATMMonitoring.parser.exception.FileNotReadableException;
import com.ncr.ATMMonitoring.parser.ups.ParseUPSXML;
import com.ncr.ATMMonitoring.parser.ups.annotation.UPSParser;
import com.ncr.ATMMonitoring.parser.ups.dto.UPSInfo;

@UPSParser
public class OtherParsersLilnk2 extends ParseUPSXML {

    private String xml;
    private static final Logger logger = Logger
	    .getLogger(OtherParsersLilnk2.class);

    @Override
    protected boolean canParseXML() {
	this.xml = this.getOriginalXmlString();
	boolean parse = this.xml.equals("<link2></link2>");
	logger.debug("OtherParsersLilnk2 evaluating:" + this.xml + " acepted? "
		+ parse);
	return parse;

    }

    @Override
    protected UPSInfo applyParser() throws ParserException,
	    FileNotReadableException, NoParserFoundException {

	return null;
    }

}
