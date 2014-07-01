package test.com.ncr.ATMMonitoring.parser.testparsers;

import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.Test;

import com.ncr.ATMMonitoring.parser.office.ParseOfficeChainBuilder;

public class ParseOfficeChainBuilderTest {

    private static String OFFICES_FILES_FOLDER = "/home/oa250047/atmmonitoring-bbva_files/Offices/";
    private static String OFFICES_FILE = "TTGOFICI";

    @Test
    public void testParseofficeFile() {
	String filename = OFFICES_FILES_FOLDER + OFFICES_FILE;
	try {
	    InputStream is = getInputStream(filename);
	    ParseOfficeChainBuilder.parse(is);
	} catch (Exception e) {

	    e.printStackTrace();
	    fail("exception occured" + e.getMessage());
	}
    }

    private InputStream getInputStream(String fileName)
	    throws FileNotFoundException {

	return new FileInputStream(fileName);
    }

}
