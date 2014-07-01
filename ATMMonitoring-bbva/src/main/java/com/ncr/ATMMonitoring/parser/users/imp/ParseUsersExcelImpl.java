package com.ncr.ATMMonitoring.parser.users.imp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ncr.ATMMonitoring.parser.exception.FileNotReadableException;
import com.ncr.ATMMonitoring.parser.exception.NoParserFoundException;
import com.ncr.ATMMonitoring.parser.exception.ParserException;
import com.ncr.ATMMonitoring.parser.users.ParseUsersChainBuilder;
import com.ncr.ATMMonitoring.parser.users.ParseUsersExcel;
import com.ncr.ATMMonitoring.parser.users.annotation.UsersParser;
import com.ncr.ATMMonitoring.parser.users.dto.UsersInfo;

/**
 * Class that parses a users excel.
 * 
 * <b><i>Do not call the parser directly, call
 * {@link ParseUsersChainBuilder#parse(InputStream)}</i></b>
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 * @author Otto Abreu
 * @author Eva Pindado (EP410008.ncr.com)
 * 
 */
@UsersParser(priority = UsersParser.HIGH_PRIORITY)
public class ParseUsersExcelImpl extends ParseUsersExcel {

//    private final static String ENCODING = "ISO8859_15";

    private static final int FIRST_SHEET_ON_BOOK = 0;
    
    private static final int TITLE_ROW_INDEX = 0;

    private static final int FIRST_NAME_CELL_NUMBER = 0;
    private static final int FIRST_LAST_NAME_CELL_NUMBER = 1;
    private static final int SECOND_LAST_NAME_CELL_NUMBER = 2;
    private static final int COUNTRY_CELL_NUMBER = 3;
    private static final int QID_CELL_NUMBER = 4;

    /** The logger. */
    private static final Logger logger = Logger
	    .getLogger(ParseUsersExcelImpl.class);

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.parser.users.ParseUsersExcel#canParseExcel()
     */
    @Override
    protected boolean canParseExcel() throws ParserException,
	    FileNotReadableException {
	return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.parser.users.ParseUsersExcel#applyParser()
     */
    protected Collection<UsersInfo> applyParser() throws ParserException,
    FileNotReadableException, NoParserFoundException {
	
	return parseFile(getExcelFile());

    }

    /**
     * Method that parses one line from the users file and returns an
     * {@link UsersInfo} with its data.
     * 
     * @param line
     *            the users excel file line
     * @return an {@link UsersInfo} with the data
     * @throws FileNotReadableException 
     * @throws ParserException 
     */
    private Collection<UsersInfo> parseFile(String filename) throws FileNotReadableException, ParserException {

	Collection<UsersInfo> users = null;

	// Formato de la hoja xlsx --> Nombre Apellido1 Apellido2 País Uid
	try {
	    	users = this.parseExcelSheet(filename);
	    	logger.debug("obtained  users "+users);

	} catch (IOException e) {
	   throw new FileNotReadableException(FileNotReadableException.FILE_NOT_FOUND+filename);
	}catch (Exception e){
	    throw new ParserException(ParserException.GENERAL_ERROR,e);
	}

	return users;
    }
    
    
    private Collection<UsersInfo> parseExcelSheet(String filename) throws IOException{
	 XSSFSheet hssfSheet = this.getExcelSheet(filename);
	 return this.proccessExcelSheet(hssfSheet);
    }

    /**
     * Gets the excel sheet in XSSFSheet format(apache poi object)
     * 
     * @param filename
     * @return XSSFSheet
     * @throws IOException
     */
    private XSSFSheet getExcelSheet(String filename) throws IOException {
	File excelFile = new File(filename);
	FileInputStream excelInputStream = new FileInputStream(excelFile);
	XSSFWorkbook workBook = new XSSFWorkbook(excelInputStream);
	XSSFSheet hssfSheet = workBook.getSheetAt(FIRST_SHEET_ON_BOOK);
	return hssfSheet;
    }
    
    
    private Collection<UsersInfo> proccessExcelSheet(XSSFSheet hssfSheet){
	
	Collection<UsersInfo> users = new HashSet<UsersInfo>();
	Iterator<Row> rowIterator = hssfSheet.rowIterator();
	 while(rowIterator.hasNext()){
	     Row sheetRow = rowIterator.next();
	     UsersInfo userInfoInRow = this.processSheetRow(sheetRow);
	     users.add(userInfoInRow);
	 }
	 
	 return users;
    }
    
    private UsersInfo processSheetRow(Row sheetRow){
	
	UsersInfo userInfo = new UsersInfo();   
	    
	if(isNotTitleRow(sheetRow) ){
	   
	    Iterator<Cell> cellIterator = sheetRow.cellIterator();
	    
	    while(cellIterator.hasNext()){
		Cell rowCell = cellIterator.next();
		this.proccessCellContent(rowCell,userInfo);
		
	    }  
	}
	return userInfo ;
    }
    
    private boolean isNotTitleRow(Row row){
	if(row.getRowNum() != TITLE_ROW_INDEX){
	    return true;
	}else{
	    return false;
	}
    }
    
    private void proccessCellContent(Cell rowCell,UsersInfo user) {
	int cellNumber = rowCell.getColumnIndex();
	String cellContent = rowCell.getStringCellValue();

	switch (cellNumber) {
        	case FIRST_NAME_CELL_NUMBER:
        	    user.setFirstname(cellContent);
        	    break;
        	case FIRST_LAST_NAME_CELL_NUMBER:
        	    user.setLastname1(cellContent);
        	    break;
        	case SECOND_LAST_NAME_CELL_NUMBER:
        	    user.setLastname2(cellContent);
        	    break;
        	case COUNTRY_CELL_NUMBER:
        	    user.setCountry(cellContent);
        	    break;
        	case QID_CELL_NUMBER:
        	    user.setQid(cellContent);
        	    break;
	}

    }

}
