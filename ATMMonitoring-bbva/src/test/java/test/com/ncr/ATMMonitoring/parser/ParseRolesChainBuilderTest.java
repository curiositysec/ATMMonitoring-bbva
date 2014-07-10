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
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = {"classpath:/applicationContext.xml"})
public class ParseRolesChainBuilderTest {

    @Value("${test.config.roles.files.folder}")
    private  String rolesFilesFolder;
    @Value("${test.config.roles.file.name}")
    private  String MDC_FILE;
    @Value("${test.config.roles.file.blanks.name}")
    private  String MDC_WITH_BLANCS_FILE;
    @Value("${test.config.roles.file.malformed.name}")
    private  String MDC_MALFORMED;
  
    private  int BLANK_LINES=5;
   

    @Test
    public void testParseMDCFile() {
	
	String filename = rolesFilesFolder + MDC_FILE;
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
	
	String filename = rolesFilesFolder + MDC_WITH_BLANCS_FILE;
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
	String filename = rolesFilesFolder + MDC_MALFORMED;
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
