package test.com.ncr.ATMMonitoring.parser;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ncr.ATMMonitoring.parser.exception.FileNotReadableException;
import com.ncr.ATMMonitoring.parser.exception.NoParserFoundException;
import com.ncr.ATMMonitoring.parser.exception.ParserException;
import com.ncr.ATMMonitoring.parser.users.ParseUsersChainBuilder;
import com.ncr.ATMMonitoring.parser.users.dto.UsersInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = {"classpath:/applicationContext.xml"})
public class ParseUsersChainBuilderTest {

    private static final int FIRST_SHEET_ON_BOOK = 0;
    @Value("${test.config.users.files.folder}")
    private  String excelFilesFolder = "/home/oa250047/atmmonitoring-bbva_files/Users/";
    @Value("${test.config.users.file.name}")
    private  String excelFile = "Consulta.xlsx";
    @Value("${test.config.users.file.blanks.name}")
    private  String excelFileSomeBlanks = "Consulta_blanks.xlsx";
    @Value("${test.config.users.file.nonexisting.name}")
    private  String excelFileNonExisting = "Consultano.xlsx";
    
    private static int TOTAL_REMOVED_ROWS_FROM_EXCEL_FILE=4;
 
    
    @Test
    public void testExcelParse() {
	try {
	    String fileCompleteName = excelFilesFolder + excelFile;
	    Collection<UsersInfo> userInfo = ParseUsersChainBuilder
		    .parse(fileCompleteName);
	    int rowsInDocument = getExcelSheetRowCount(fileCompleteName) + 1;// starts
									     // in
									     // 0

	    assertTrue(userInfo.size() == rowsInDocument);
	} catch (Exception e) {
	    fail("catched an exception: " + e.getMessage());

	}
    }
    
    @Test
    public void testExcelParseWhitEmptyRows() {
	try {
	    String fileCompleteName = excelFilesFolder + excelFileSomeBlanks;
	    String fileCompleteNameOriginal = excelFilesFolder + excelFile;
	    
	    Collection<UsersInfo> userInfo = ParseUsersChainBuilder
		    .parse(fileCompleteName);
	    int rowsInDocumentOriginal = getExcelSheetRowCount(fileCompleteNameOriginal) + 1;// starts
									     // in
									     // 0
	   
	    assertTrue(userInfo.size() == (rowsInDocumentOriginal -TOTAL_REMOVED_ROWS_FROM_EXCEL_FILE) );
	} catch (Exception e) {
	    fail("catched an exception: " + e.getMessage());

	}
    }
    
    @Test(expected=FileNotReadableException.class)
    public void testNonExistingDocument() throws ParserException, FileNotReadableException, NoParserFoundException{
	 String fileCompleteName = excelFilesFolder + excelFileNonExisting;
	   ParseUsersChainBuilder
	    	    .parse(fileCompleteName);
	
    }

    
    private int getExcelSheetRowCount(String filename) throws IOException {
	XSSFSheet hssfSheet = this.getSheet(filename);
	return hssfSheet.getLastRowNum();

    }
    
    
    
    private XSSFSheet getSheet(String filename) throws IOException{
	File excelFile = new File(filename);
	FileInputStream excelInputStream = new FileInputStream(excelFile);
	XSSFWorkbook workBook = new XSSFWorkbook(excelInputStream);
	XSSFSheet hssfSheet = workBook.getSheetAt(FIRST_SHEET_ON_BOOK);
	return hssfSheet;
    }
}
