package com.ncr.ATMMonitoring.scheduledtask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ncr.ATMMonitoring.handler.FileInDiskHandler;
import com.ncr.ATMMonitoring.service.UserService;

/**
 * Scheduled task that reads a excel file (xlsx) with Users data from the file system
 * and processes them. To know which files it must read and what to do with
 * them, this class uses the following properties:
 * <ul>
 * <li><b>config.usersfile</b>: <U>Required</u>, holds the system path where
 * the xlsx is</li>
 * <li><i>config.userstask.behavior</I></li> Optional, defines what to do with
 * successfully processed files. Accepted values are: 'delete', 'copy', 'move',
 * 'none'. Default value is 'delete'.
 * <li><i>config.userstask.copyto</i></li> Optional only if the
 * config.upstask.behavior is 'delete' (explicitly or as the default one),
 * otherwise is required to determine where to put the processed files
 * </ul>
 * <br>
 * 
 * This class uses {@link IOFileFilter} and FileUtils
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 * @author Otto Abreu
 * @author Eva Pindado (EP410008@ncr.com)
 * 
 */
@Component
public class UsersGetExcelTask {

    /** The logger. */
    private static final Logger logger = Logger.getLogger(UsersGetExcelTask.class);

    /** Path to the users excel file */
    @Value("${config.usersfile}")
    private String excelPath;
    
    /** Path to the users mdc file */
    @Value("${config.mdcfile}")
    private String mdcPath;

    /** Operation to do with processed files */
    @Value("${config.userstask.behavior:}")
    private String behavior = null;

    /**
     * Folder where we want to copy/move the processed files (only needed with
     * 'move' and 'copy')
     */
    @Value("${config.userstask.copyto:}")
    private String copyFolder = null;

    /** Runs at every five minutes starting at each x0 or x5 where x={0...5} */
    private static final String CRON_CONF = "0 0/5 * 1/1 * ?";

    /**
     * Internal variable with the operation to do with processed files (delete
     * by default)
     */
    private int copyDeleteMove = 0;

    /**
     * Copy option: each successfully processed file will be copied to a folder
     * keeping the original
     */
    private static final int COPY_SUCCESSFUL_FILE = 1;

    /**
     * Delete option: each successfully processed file will be permanently
     * deleted
     */
    private static final int DELETE_SUCCESSFUL_FILE = 0;

    /**
     * Move option: each successfully processed file will be copied to a folder
     * deleting the original
     */
    private static final int MOVE_SUCCESSFUL_FILE = 2;

    @Autowired
    private UserService userService;

    /**
     * Scheduled task that checks the folder for XML, and calls the service to
     * begin the XML processing
     */
    @Scheduled(cron = CRON_CONF)
    public void checkForUsersUpdates() {

		logger.info("Checking the users excel file: " + this.excelPath);
		logger.info("Checking the Mdc text file: " + this.mdcPath);
	
		try {
		    File fileA = new File(excelPath);
		    File fileB = new File(mdcPath);
		    
		    if (fileA.exists() && fileB.exists()) {
				if (!fileA.canRead()) {
				    logger.error("Can not read the users excel file (" + excelPath + " ).");
				    return;
				}
				if(!fileB.canRead()) {
					logger.error("Cannot read the users txt file (" + mdcPath + ").");
					return;
				}
				boolean success = userService.storeUsersInfo(excelPath, new FileInputStream(mdcPath));
				if (success) {
				    logger.info("Users files has been successfully processed: " + this.excelPath + " & " + this.mdcPath);
				    handleSuccess(Arrays.asList(new String[] { excelPath, mdcPath }));
				} else {
				    logger.error("Some error happened while parsing the users excel file or the users tx file " + excelPath + " or " + mdcPath);
				}
		    }
		} catch (Exception e) {
		    logger.error("Can not read the users excel file or the users txt file " + excelPath +" or " + mdcPath + " (" + e + ")");
		}

    }

    /**
     * Method that create the folder in the object instance
     */
    @PostConstruct
    public void initTask() {

	if (!StringUtils.isEmpty(this.behavior)) {

	    this.behavior = this.behavior.trim();
	    logger.debug("Success file behavior: " + this.behavior);
	    if (this.behavior.equalsIgnoreCase("delete")) {

		this.copyDeleteMove = DELETE_SUCCESSFUL_FILE;

	    } else if (this.behavior.equalsIgnoreCase("copy")
		    && !StringUtils.isEmpty(this.copyFolder)) {

		this.copyDeleteMove = COPY_SUCCESSFUL_FILE;

	    } else if (this.behavior.equalsIgnoreCase("move")
		    && !StringUtils.isEmpty(this.copyFolder)) {

		this.copyDeleteMove = MOVE_SUCCESSFUL_FILE;

	    } else {
		// We check if the configured values are correct, and if not
		// we log the error and throw an Exception
		if (!this.behavior.equalsIgnoreCase("move")
			&& !this.behavior.equalsIgnoreCase("copy")
			&& !this.behavior.equalsIgnoreCase("delete")) {
		    String errorMsg = "The given value to the property config.userstask.behavior does not have a valid value "
			    + "( delete | move | copy) given:  "
			    + this.behavior;
		    logger.error(errorMsg);
		    throw new IllegalArgumentException(errorMsg);
		} else {

		    String errorMsg = "While using copy or move it is required to set the property config.userstask.copyto "
			    + "with a valid folder path";
		    logger.error(errorMsg);
		    throw new IllegalArgumentException(errorMsg);
		}
	    }
	}
	logger.info("Excel file: " + this.excelPath);

    }

    /**
     * Handles the processed files.
     * 
     * @param filesPaths
     *            list with paths to the files to process
     */
    private void handleSuccess(List<String> filesPaths) {

		switch (this.copyDeleteMove) {
	
		case DELETE_SUCCESSFUL_FILE:
	
		    FileInDiskHandler.delete(filesPaths,
			    FileInDiskHandler.IGNORES_ERROR);
		    break;
	
		case COPY_SUCCESSFUL_FILE:
		    FileInDiskHandler.moveToFolder(filesPaths, this.copyFolder,
			    FileInDiskHandler.KEEP_FILE,
			    FileInDiskHandler.IGNORES_ERROR);
		    break;
	
		case MOVE_SUCCESSFUL_FILE:
		    FileInDiskHandler.moveToFolder(filesPaths, this.copyFolder,
			    FileInDiskHandler.REMOVE_FILE,
			    FileInDiskHandler.IGNORES_ERROR);
		    break;
		}

    }

}
