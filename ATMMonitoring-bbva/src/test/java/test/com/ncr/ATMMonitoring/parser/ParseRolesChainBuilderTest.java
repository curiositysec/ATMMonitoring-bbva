package test.com.ncr.ATMMonitoring.parser;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;

import org.junit.Test;

import com.ncr.ATMMonitoring.parser.exception.FileNotReadableException;
import com.ncr.ATMMonitoring.parser.exception.NoParserFoundException;
import com.ncr.ATMMonitoring.parser.exception.ParserException;
import com.ncr.ATMMonitoring.parser.users.ParseRolesChainBuilder;
import com.ncr.ATMMonitoring.parser.users.dto.RolesInfo;

/**
 * The class <code>ParseRolesChainBuilderTest</code> contains tests for the
 * class {@link <code>ParseRolesChainBuilder</code>}
 * 
 * @pattern JUnit Test Case
 * 
 * @generatedBy CodePro at 30/06/14 15:30
 * 
 * @author Otto Abreu
 * 
 * @version $Revision$
 */
public class ParseRolesChainBuilderTest {

    private static String ROLES_FILES_FOLDER = "/home/oa250047/atmmonitoring-bbva_files/Users/";
    private static String MDC_FILE = "SL.ASAPLL00.MAESTRO.CAPACI.PRU1";
    private static String MDC_WITH_BLANCS_FILE = "SL.ASAPLL00.MAESTRO.CAPACI_blanks.PRU1";
    private static String MDC_MALFORMED="SL.ASAPLL00.MAESTRO.CAPACI_MALFORMED.PRU1";
    private static int BLANK_LINES=5;
   

    @Test
    public void testParseMDCFile() {
	
	String filename = ROLES_FILES_FOLDER + MDC_FILE;
	try {
	 
	    Collection<RolesInfo> roles = this.getRoles(filename);
	    int totalLines = this.countLinesInFile(filename);
	    assertTrue(roles.size() == totalLines);

	} catch (Exception e) {
	    e.printStackTrace();
	    fail("catched an exception: " + e.getMessage());

	}

    }
    @Test
    public void testParseWithBlanks(){
	
	String filename = ROLES_FILES_FOLDER + MDC_WITH_BLANCS_FILE;
	try {
	   
	    Collection<RolesInfo> roles = this.getRoles(filename);
	    int totalLines = this.countLinesInFile(filename);
	    assertTrue(roles.size() == (totalLines-BLANK_LINES));

	} catch (Exception e) {
	    e.printStackTrace();
	    fail("catched an exception: " + e.getMessage());

	}
    }
    
    @Test
    public void testParseBadFormat(){
	String filename = ROLES_FILES_FOLDER + MDC_MALFORMED;
	try {
	    Collection<RolesInfo> roles = this.getRoles(filename);
	    assertTrue(roles.size() == 0);
	} catch (Exception e) {
	    e.printStackTrace();
	    fail("catched an exception: " + e.getMessage());

	}
    }
    

    private  Collection<RolesInfo> getRoles(String filename) throws ParserException, FileNotReadableException, NoParserFoundException, FileNotFoundException{
	InputStream mdcFile = null;
	 mdcFile = this.getInputStream(filename);
	 Collection<RolesInfo> roles = ParseRolesChainBuilder.parse(mdcFile);
	 return roles;
    }
 

    private InputStream getInputStream(String fileName)
	    throws FileNotFoundException {

	return new FileInputStream(fileName);
    }

    private int countLinesInFile(String fileName) throws IOException {
	InputStream is = this.getInputStream(fileName);
	InputStreamReader isr = new InputStreamReader(is);
	BufferedReader reader = new BufferedReader(isr);

	int lines = 0;
	while (reader.readLine() != null) {
	    lines++;
	}
	return lines;
    }
}
