package test.com.ncr.ATMMonitoring.parser;

import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ncr.ATMMonitoring.parser.exception.NoParserFoundException;
import com.ncr.ATMMonitoring.parser.exception.ParserException;
import com.ncr.ATMMonitoring.parser.exception.FileNotReadableException;
import com.ncr.ATMMonitoring.parser.ups.ParseUPSChainBuilder;

public class ParseUPSChainBuilderTest {

    static private Logger logger = Logger
	    .getLogger(ParseUPSChainBuilderTest.class);

    private static final String XMLUPS = "<PK-C1-UPS>"
	    + "<NUMPUESTO>C1</NUMPUESTO>"
	    + "<IP_UPS>32.20.205.103</IP_UPS> "
	    + "<FIRMWARE_UPS>2.70.030702</FIRMWARE_UPS> "
	    + "<ESTADO_UPS>Normal</ESTADO_UPS> "
	    + "<PORCENTAJE_CARGA_UPS>100</PORCENTAJE_CARGA_UPS> "
	    + "<PORCENTAJE_GASTO_UPS>14</PORCENTAJE_GASTO_UPS> "
	    + "<ALARMAS_UPS>Las baterías necesitan ser sustituidas</ALARMAS_UPS> "
	    + "<NOMBRE_UPS>POWER LAN+ 1500</NOMBRE_UPS> "
	    + "<MODELO_UPS>POWER LAN+ 1500</MODELO_UPS> "
	    + "<NUM_SERIE_UPS>C63R0259</NUM_SERIE_UPS> "
	    + "<TIEMPO_ENCENDIDO_UPS>1389 Días 11 Hor. 20 Min.</TIEMPO_ENCENDIDO_UPS> "
	    + "<AUTONOMIA_UPS>6 Min. (1</AUTONOMIA_UPS> "
	    + "<AUD_FMO_UPS>21/11/2013</AUD_FMO_UPS> "
	    + "<STATUS>Las baterías necesitan ser sustituidas</STATUS>"
	    + "<FECHA_ULTIMA_EJECUCION>21/11/13</FECHA_ULTIMA_EJECUCION>"
	    + "</PK-C1-UPS>";

    private static final String LINK2XML = "<link1></link1>";

    private static final String LINK3XML = "<link2></link2>";

    private static final String LINKXML_NO_PARSER = "<link50></link50>";

    private static final String XMLUPS_SAX = "<PK-C2-UPS>"
	    + "<NUMPUESTO>C1</NUMPUESTO>" + "<IP_UPS>32.20.205.103</IP_UPS> "
	    + "<FIRMWARE_UPS>2.70.030702</FIRMWARE_UPS> " + "</PK-C2-UPS>";

    private InputStream upsInputStream;

    private InputStream link2InputStream;

    private InputStream link3InputStream;

    private InputStream link4InputStream;

    private InputStream saxParserInputStream;

    @Before
    public void setUp() throws Exception {

	this.upsInputStream = new ByteArrayInputStream(XMLUPS.getBytes());
	this.link2InputStream = new ByteArrayInputStream(LINK2XML.getBytes());
	this.link3InputStream = new ByteArrayInputStream(LINK3XML.getBytes());
	this.link4InputStream = new ByteArrayInputStream(
		LINKXML_NO_PARSER.getBytes());
	this.saxParserInputStream = new ByteArrayInputStream(
		XMLUPS_SAX.getBytes());
    }

    @After
    public void tearDown() throws Exception {

	this.upsInputStream = null;
	this.link2InputStream = null;
	this.link3InputStream = null;
	this.link4InputStream = null;
	this.saxParserInputStream = null;
	logger.debug("----------Test ends------------------");

    }

    @Test
    public void testParse() {
	try {
	    this.testParser(link2InputStream);
	    this.testParser(link3InputStream);
	    this.testParser(upsInputStream);
	    this.testParser(saxParserInputStream);

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    logger.error(e.getMessage(), e);

	    fail(e.getMessage());
	}

    }

    @Test(expected = com.ncr.ATMMonitoring.parser.exception.NoParserFoundException.class)
    public void testNoParser() throws ParserException, FileNotReadableException,
	    NoParserFoundException {

	this.testParser(link4InputStream);

    }

    private void testParser(InputStream is) throws ParserException,
	    FileNotReadableException, NoParserFoundException {

	ParseUPSChainBuilder.parse(is);

    }

}
