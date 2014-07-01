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

import com.ncr.ATMMonitoring.parser.exception.FileNotReadableException;
import com.ncr.ATMMonitoring.parser.exception.NoParserFoundException;
import com.ncr.ATMMonitoring.parser.exception.ParserException;
import com.ncr.ATMMonitoring.parser.users.ParseUsersChainBuilder;
import com.ncr.ATMMonitoring.parser.users.dto.UsersInfo;

public class ParseUsersChainBuilderTest {

    private static final int FIRST_SHEET_ON_BOOK = 0;
    private static String EXCEL_FILES_FOLDER = "/home/oa250047/atmmonitoring-bbva_files/Users/";
    private static String EXCEL_FILE = "Consulta.xlsx";
    private static String EXCEL_FILE_SOME_BLANKS = "Consulta_blanks.xlsx";
    private static String EXCEL_FILE_NOT_EXISTING = "Consultano.xlsx";
    private static int TOTAL_REMOVED_ROWS_FROM_EXCEL_FILE=4;
 
    
    @Test
    public void testExcelParse() {
	try {
	    String fileCompleteName = EXCEL_FILES_FOLDER + EXCEL_FILE;
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
	    String fileCompleteName = EXCEL_FILES_FOLDER + EXCEL_FILE_SOME_BLANKS;
	    String fileCompleteNameOriginal = EXCEL_FILES_FOLDER + EXCEL_FILE;
	    
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
	 String fileCompleteName = EXCEL_FILES_FOLDER + EXCEL_FILE_NOT_EXISTING;
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
