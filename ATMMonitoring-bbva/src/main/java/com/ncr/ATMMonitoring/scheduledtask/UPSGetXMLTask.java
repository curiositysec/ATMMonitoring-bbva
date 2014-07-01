package com.ncr.ATMMonitoring.scheduledtask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ncr.ATMMonitoring.handler.FileInDiskHandler;
import com.ncr.ATMMonitoring.handler.exception.FileHandlerException;
import com.ncr.ATMMonitoring.service.UpsService;

/**
 * Scheduled task that reads XML files with UPS data from the file system and
 * processes them. To know which files it must read and what to do with them,
 * this class uses the following properties:
 * <ul>
 * <li><b>config.upsfolder</b>: <U>Required</u>, holds the system path where the
 * xml are</li>
 * <li><i>config.upstask.behavior</I></li> Optional, defines what to do with
 * successfully processed files. Accepted values are: 'delete', 'copy', 'move'.
 * Default value is 'delete'.
 * <li><i>config.upstask.copyto</i></li> Optional only if the
 * config.upstask.behavior is 'delete' (explicitly or as the default one),
 * otherwise is required to determine where to put the processed files
 * </ul>
 * <br>
 * 
 * This class uses {@link IOFileFilter} and FileUtils
 * 
 * @author Otto Abreu
 * 
 */
@Component
public class UPSGetXMLTask {

    /** File extension to check */
    private static final String FILE_EXTENSION = ".xml";

    /** The logger. */
    private static final Logger logger = Logger.getLogger(UPSGetXMLTask.class);

    /** Path to the UPS xml folder */
    @Value("${config.upsfolder}")
    private String xmlFolderPath;

    /** Operation to do with processed files */
    @Value("${config.upstask.behavior:}")
    private String behavior = null;

    /**
     * Folder where we want to copy/move the processed files (only needed with
     * 'move' and 'copy')
     */
    @Value("${config.upstask.copyto:}")
    private String copyFolder = null;

    /** Runs at every minute start. */
    private static final String CRON_CONF = "0 * * * * *";

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
    private UpsService upsService;

    /**
     * Scheduled task that checks the folder for XML, and calls the service to
     * begin the XML processing
     */
    @Scheduled(cron = CRON_CONF)
    public void checkForUPSUpdates() {

	List<String> filesPath = new ArrayList<String>();
	List<String> filesPathError = new ArrayList<String>();

	logger.info("Checking folder for UPS XML files: " + this.xmlFolderPath);

	try {

	    filesPath = FileInDiskHandler.getFilespath(FILE_EXTENSION,
		    this.xmlFolderPath);

	    if (!filesPath.isEmpty()) {

		// call the service
		filesPathError = this.upsService.storeUPSinfo(filesPath);
		// if has errors, i will only manage those who was processed
		if (!filesPathError.isEmpty()) {
		    // i get only those proceed
		    @SuppressWarnings("unchecked")
		    Collection<String> toProcess = (Collection<String>) CollectionUtils
			    .disjunction(filesPathError, filesPath);
		    this.handleSuccess(new ArrayList<String>(toProcess));

		} else {
		    // all the files where processed
		    this.handleSuccess(filesPath);
		}

	    } else {

		logger.debug(" UPS XML folder( " + xmlFolderPath
			+ " ) is empty, nothing to process");
	    }
	} catch (FileHandlerException e) {

	    logger.error("Can not read the UPS XML folder( " + xmlFolderPath
		    + " ) because it is not a directory");
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
		    String errorMsg = "The given value to the property config.upstask.behavior does not have a valid value "
			    + "( delete | move | copy) given:  "
			    + this.behavior;
		    logger.error(errorMsg);
		    throw new IllegalArgumentException(errorMsg);
		} else {

		    String errorMsg = "While using copy or move it is required to set the property config.upstask.copyto "
			    + "with a valid folder path";
		    logger.error(errorMsg);
		    throw new IllegalArgumentException(errorMsg);
		}
	    }
	}
	logger.info("XML folder: " + this.xmlFolderPath);

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
