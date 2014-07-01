package test.com.ncr.ATMMonitoring.parser.testparsers;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import com.ncr.ATMMonitoring.parser.exception.NoParserFoundException;
import com.ncr.ATMMonitoring.parser.exception.ParserException;
import com.ncr.ATMMonitoring.parser.exception.FileNotReadableException;
import com.ncr.ATMMonitoring.parser.ups.annotation.UPSParser;
import com.ncr.ATMMonitoring.parser.ups.dto.UPSInfo;
import com.ncr.ATMMonitoring.parser.ups.imp.ParseUPSSAX;

@UPSParser(priority = UPSParser.HIGH_PRIORITY)
public class SaxParserTest extends ParseUPSSAX {

    private UPSInfo parsedInfo = new UPSInfo();
    private boolean parseable = false;

    // logger
    private static final Logger logger = Logger.getLogger(SaxParserTest.class);

    @Override
    protected DefaultHandler getDefaultHandler() {
	DefaultHandler handler = new DefaultHandler() {
	    private String temp;

	    public void startElement(String uri, String localName,
		    String qName, Attributes attributes) throws SAXException {

		this.temp = "";

		if (qName.equalsIgnoreCase("PK-C2-UPS")) {

		    SaxParserTest.this.parseable = true;

		}

	    }

	    public void endElement(String uri, String localName, String qName)
		    throws SAXException {

		if (SaxParserTest.this.parseable) {

		    if (qName.equalsIgnoreCase("NUMPUESTO")) {

			SaxParserTest.this.parsedInfo.setNumPosition(this.temp);

		    } else if (qName.equalsIgnoreCase("IP_UPS")) {

			SaxParserTest.this.parsedInfo.setIp(this.temp);

		    } else if (qName.equalsIgnoreCase("FIRMWARE_UPS")) {

			SaxParserTest.this.parsedInfo.setFirmware(this.temp);
		    }
		}

	    }

	    public void characters(char[] ch, int start, int length)
		    throws SAXException {
		this.temp = new String(ch, start, length);
	    }

	};
	return handler;
    }

    @Override
    protected boolean canParseXML() throws ParserException,
	    FileNotReadableException {
	logger.debug("Sax evaluating: " + this.getOriginalXmlString()
		+ " acepted:" + this.parseable);
	this.parse(this.getXmlFile());
	return this.parseable;
    }

    @Override
    protected UPSInfo applyParser() throws ParserException,
	    FileNotReadableException, NoParserFoundException {
	logger.debug("Sax parser returning: " + this.parsedInfo);
	return this.parsedInfo;
    }

}
