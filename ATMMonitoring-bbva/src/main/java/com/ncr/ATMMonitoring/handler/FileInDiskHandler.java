package com.ncr.ATMMonitoring.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.ncr.ATMMonitoring.handler.exception.FileHandlerException;

/**
 * Class that facilitates the manipulation of files in the fileSystem
 * 
 * @author Otto Abreu
 * 
 */
public class FileInDiskHandler {

    /** The logger. */
    private static final Logger logger = Logger
	    .getLogger(FileInDiskHandler.class);

    /**
     * Indicates that the method will throw an exception if an operation fails
     * for one File
     */
    public static final boolean FAILS_ON_ERROR = true;

    /**
     * Indicates that the method will continue even if an operation fails for
     * one or more Files
     */
    public static final boolean IGNORES_ERROR = false;

    /**
     * Indicates that the original file will be deleted after copying it
     */
    public static final boolean REMOVE_FILE = false;

    /**
     * Indicates that the original file will be deleted after copying it
     */
    public static final boolean KEEP_FILE = true;

    /**
     * From a valid system path, returns the {@link InputStream}
     * 
     * @param file
     *            String with a valid path in the system
     * @return {@link InputStream}
     * @throws FileHandlerException
     *             If can not obtain the {@link InputStream}
     */
    public static InputStream getFileInputStream(String file)
	    throws FileHandlerException {
	File fileIo = FileInDiskHandler.getFileIO(file);
	InputStream is = null;
	try {

	    is = FileUtils.openInputStream(fileIo);

	} catch (IOException e) {
	    throw new FileHandlerException(
		    FileHandlerException.GET_INPUTSTREAM_ERROR, e);
	}
	return is;
    }

    /**
     * From a valid list of system paths, returns the {@link InputStream}
     * associated to each path<br>
     * To set the failsOnError please use
     * {@link FileInDiskHandler#FAILS_ON_ERROR}, that will make that this method
     * throw an exception if an error occurs<br>
     * If {@link FileInDiskHandler#IGNORES_ERROR} is set, this method will not
     * stop if an error occurs, only will return the {@link InputStream} that
     * was possible to obtain.<br>
     * this method calls {@link FileInDiskHandler#getFile(String)}<br>
     * Will return a empty List if the files param is empty or fails in all
     * attempts and the failsOnError is true
     * 
     * @param files
     *            List<String> with valid systems path
     * @param failsOnError
     *            indicate if this method will throw an exception if can not
     *            obtain an {@link InputStream}. use
     *            {@link FileInDiskHandler#FAILS_ON_ERROR}, or
     *            {@link FileInDiskHandler#IGNORES_ERROR}
     * @return List<InputStream>
     * @throws FileHandlerException
     *             if can not obtain a {@link InputStream} ( only if is set
     *             (true) the fails on error)
     */
    public static List<InputStream> getFilesInputStream(List<String> files,
	    boolean failsOnError) throws FileHandlerException {

	List<InputStream> fileIs = new ArrayList<InputStream>();

	for (String filePath : files) {

	    try {
		InputStream is = FileInDiskHandler.getFileInputStream(filePath);
		fileIs.add(is);
	    } catch (FileHandlerException e) {
		// only throws the exception if the boolean is true
		FileInDiskHandler.handleException(failsOnError, e, null,
			"can not get Inputstream from file: " + filePath
				+ " Operation will continue");

	    }
	}
	return fileIs;
    }

    /**
     * From an existing file, returns the {@link InputStream} associated to each
     * file<br>
     * To set the failsOnError please use
     * {@link FileInDiskHandler#FAILS_ON_ERROR}, that will make that this method
     * throw an exception if an error occurs<br>
     * If {@link FileInDiskHandler#IGNORES_ERROR} is set, this method will not
     * stop if an error occurs, only will return the {@link InputStream} that
     * was possible to obtain.<br>
     * this method calls {@link FileInDiskHandler#getFile(String)}
     * 
     * @param files
     *            Collection<File> with valid files
     * @param failsOnError
     *            indicate if this method will throw an exception if can not
     *            obtain an {@link InputStream}. use
     *            {@link FileInDiskHandler#FAILS_ON_ERROR}, or
     *            {@link FileInDiskHandler#IGNORES_ERROR}
     * @return List<InputStream>
     * @throws FileHandlerException
     *             if can not obtain a {@link InputStream} ( only if is set
     *             (true) the fails on error)
     **/
    public static List<InputStream> getFilesInputStream(Collection<File> files,
	    boolean failsOnError) throws FileHandlerException {

	List<InputStream> fileIs = new ArrayList<InputStream>();

	for (File file : files) {
	    try {

		fileIs.add(new FileInputStream(file));

	    } catch (IOException e) {
		// only throws the exception if the boolean is true
		FileInDiskHandler.handleException(
			failsOnError,
			e,
			FileHandlerException.GET_INPUTSTREAM_ERROR
				+ file.getAbsolutePath(),
			"can not get Inputstream from file: "
				+ file.getAbsolutePath()
				+ " Operation will continue");

	    }

	}
	return fileIs;
    }

    /**
     * Retrieves the file that has a certain extension (or all) from a given
     * folder retrieve the files<br>
     * If the given path (fileFolder param) is not a valid directory, or is
     * empty, will return a empty collection if the folder does not exist or the
     * folder is empty<br>
     * This method uses {@link FileUtils}.
     * 
     * @param fileExtension
     *            String with the file extension to retrieve,
     *            format:(\\.[a-zA-Z0-9]{2,5})$
     * @param fileFolder
     *            String with a valid system path
     * @return
     * @throws FileHandlerException
     *             if the fileExtension param do not have the required format or
     *             the path does not correspond to a folder in the file System
     */
    @SuppressWarnings("unchecked")
    public static Collection<File> getFiles(String fileExtension,
	    String fileFolder) throws FileHandlerException {

	File folder = new File(fileFolder);
	Collection<File> xmlFiles = new ArrayList<File>();
	// the folder must have at least one file and must exist
	if (folder.exists() && folder.isDirectory() && folder.list().length > 0) {
	    // if a extension was given, will retreive only the files that match
	    // that extension
	    // otherwise all
	    if (StringUtils.isNotEmpty(fileExtension)) {

		Matcher match = null;
		Pattern pattern = Pattern.compile("^(\\.[a-zA-Z0-9]{2,5})$");
		match = pattern.matcher(fileExtension);
		// must be a string .xxx ( or .xx or .xxxxx)
		if (match.find()) {

		    final IOFileFilter fileFilter = new SuffixFileFilter(
			    fileExtension);

		    xmlFiles = (Collection<File>) FileUtils.listFiles(folder,
			    fileFilter, null);
		} else {

		    // the given string is not a valid extension
		    logger.error(FileHandlerException.FILE_EXTENSION_ERROR
			    + fileExtension);
		    throw new FileHandlerException(
			    FileHandlerException.FILE_EXTENSION_ERROR
				    + fileExtension);
		}

	    } else {
		// i get all the files
		xmlFiles = (Collection<File>) FileUtils.listFiles(folder, null,
			false);
	    }
	    // if the folder is not an directory or it does not exist i rise the
	    // exception
	} else if (!folder.exists() || !folder.isDirectory()) {

	    throw new FileHandlerException(
		    FileHandlerException.NOT_A_VALID_FILE_FOLDER + fileFolder);
	}

	return xmlFiles;
    }

    /**
     * Returns the path from the given files
     * 
     * @param files
     *            Collection of File
     * @return List<String> with all the paths
     */
    public static List<String> getFilespath(Collection<File> files) {
	List<String> filesPath = new ArrayList<String>();

	for (File file : files) {

	    filesPath.add(file.getAbsolutePath());
	}

	return filesPath;
    }

    /**
     * Returns the path from the given files<br>
     * This method calls {@link FileInDiskHandler#getFilespath(String, String)}
     * and {@link FileInDiskHandler#getFilespath(Collection)}
     * 
     * @param fileExtension
     *            String with the file extension to retrieve,
     *            format:(\\.[a-zA-Z0-9]{2,5})$
     * @param fileFolder
     *            String with a valid system path
     * @return List<String> with all the paths
     * @throws FileHandlerException
     */
    public static List<String> getFilespath(String fileExtension,
	    String fileFolder) throws FileHandlerException {
	Collection<File> fileCollection = FileInDiskHandler.getFiles(
		fileExtension, fileFolder);
	return FileInDiskHandler.getFilespath(fileCollection);
    }

    /**
     * Executes the touch operation on the given file path
     * 
     * @param file
     *            String with a valid path in the system
     * @throws FileHandlerException
     *             if can not execute the touch operation
     */
    public static void touch(String file) throws FileHandlerException {
	File fileIo = FileInDiskHandler.getFileIO(file);
	try {
	    FileUtils.touch(fileIo);
	} catch (IOException e) {
	    throw new FileHandlerException(FileHandlerException.TOUCH_ERROR, e);
	}
    }

    /**
     * Executes the touch operation on the given files paths<br>
     * To set the failsOnError please use
     * {@link FileInDiskHandler#FAILS_ON_ERROR}, that will make that this method
     * throw an exception if an error occurs<br>
     * If {@link FileInDiskHandler#IGNORES_ERROR} is set, this method will not
     * stop if an error occurs, only will touch the files that not generate an
     * error <br>
     * 
     * this method calls {@link FileInDiskHandler#touch(String)}
     * 
     * 
     * @param files
     *            List<String> with valid systems path
     * @param failsOnError
     *            indicate if this method will throw an exception if can not
     *            obtain an {@link InputStream}. use
     *            {@link FileInDiskHandler#FAILS_ON_ERROR}, or
     *            {@link FileInDiskHandler#IGNORES_ERROR}
     * @throws FileHandlerException
     *             if can not execute the touch operation on a file ( only if is
     *             set (true) the fails on error)
     */
    public static void touch(List<String> files, boolean failsOnError)
	    throws FileHandlerException {

	for (String filePath : files) {

	    try {
		FileInDiskHandler.touch(filePath);
	    } catch (FileHandlerException e) {
		// only throws the exception if the boolean is true
		FileInDiskHandler.handleException(failsOnError, e, null,
			"can not touch file: " + filePath
				+ " Operation will continue");
	    }
	}
    }

    /**
     * Method that deletes the given file<BR>
     * It will try to delete using the {@link FileUtils#forceDelete(File)} and
     * if it fails ( throws an IOException), will try to execute the
     * {@link FileUtils#forceDeleteOnExit(File)}<br>
     * 
     * <b>IMPORTANT:<i> This method only deletes a file, if the path belongs to
     * a directory nothing will be done</i></b>
     * 
     * @param file
     *            String with a valid path in the system
     * @throws FileHandlerException
     *             if can not execute the delete operation
     */
    public static void delete(String file) throws FileHandlerException {
	File fileIo = FileInDiskHandler.getFileIO(file);
	if (!fileIo.isDirectory()) {
	    try {

		FileUtils.forceDelete(fileIo);

	    } catch (IOException e) {
		try {

		    FileUtils.forceDeleteOnExit(fileIo);
		} catch (IOException e1) {
		    throw new FileHandlerException(
			    FileHandlerException.DELETE_ERROR, e);
		}

	    }
	} else {

	}
    }

    /**
     * Method that deletes the given files<BR>
     * To set the failsOnError please use
     * {@link FileInDiskHandler#FAILS_ON_ERROR}, that will make that this method
     * throw an exception if an error occurs<br>
     * If {@link FileInDiskHandler#IGNORES_ERROR} is set, this method will not
     * stop if an error occurs, only will delete the files that do not throw an
     * exception<br>
     * 
     * <b>IMPORTANT:<i> This method only deletes files, if a path belongs to a
     * directory nothing will be done to that path</i></b> <br>
     * this method calls {@link FileInDiskHandler#delete(String)}
     * 
     * @param files
     *            List<String> with valid systems path
     * @param failsOnError
     *            indicate if this method will throw an exception if can not
     *            obtain an {@link InputStream}. use
     *            {@link FileInDiskHandler#FAILS_ON_ERROR}, or
     *            {@link FileInDiskHandler#IGNORES_ERROR}
     * @throws FileHandlerException
     *             if can not execute the delete operation on a file ( only if
     *             is set (true) the fails on error)
     */
    public static void delete(List<String> files, boolean failsOnError)
	    throws FileHandlerException {

	for (String filePath : files) {
	    try {

		FileInDiskHandler.delete(filePath);
		logger.info("deleted file: " + filePath);
	    } catch (FileHandlerException e) {
		// only throws the exception if the boolean is true
		FileInDiskHandler.handleException(failsOnError, e, null,
			"can not delete file: " + filePath
				+ " Operation will continue");
	    }
	}
    }

    /**
     * Executes a move operation (if the keepFile param is false) or a copy (if
     * the keepFile param is true)
     * 
     * @param file
     *            String with the full path of the file
     * @param dir
     *            String with the full path of the directory
     * @param keepFile
     *            indicates if will execute a move operation ( removes the file
     *            after being copied) or just copy ( leaves the original).use
     *            {@link FileInDiskHandler#KEEP_FILE}, or
     *            {@link FileInDiskHandler#REMOVE_FILE}
     * @throws FileHandlerException
     *             If the params are either a file and a directory, or an error
     *             occur while executing the operation ( only if is set (true)
     *             the fails on error)
     */
    public static void moveToFolder(String file, String dir, boolean keepFile)
	    throws FileHandlerException {

	File srcFile = new File(file);
	File destDir = new File(dir);

	if ((!srcFile.isDirectory()) && (destDir.isDirectory())) {

	    try {

		FileUtils.copyFileToDirectory(srcFile, destDir);
		if (!keepFile) {
		    FileInDiskHandler.delete(file);
		}

	    } catch (IOException e) {

		throw new FileHandlerException(FileHandlerException.MOVE_ERROR
			+ file + " - " + dir);

	    } catch (NullPointerException e) {

		throw new FileHandlerException(
			FileHandlerException.MOVE_NULL_ERROR + file + " - "
				+ dir);
	    }
	} else {

	    throw new FileHandlerException(
		    FileHandlerException.NOT_A_VALID_FILE_FOLDER + file + " - "
			    + dir);
	}
    }

    /**
     * Executes a move operation (if the keepFile param is false) or a copy (if
     * the keepFile param is true) for the given files<br>
     * This method calls
     * {@link FileInDiskHandler#moveToFolder(String, String, boolean)}
     * 
     * @param files
     *            List of Strings with the full path of the files
     * @param dir
     *            String with the full path of the directory
     * @param keepFile
     *            indicates if will execute a move operation (removes the file
     *            after being copied) or just copy (leaves the original).use
     *            {@link FileInDiskHandler#KEEP_FILE}, or
     *            {@link FileInDiskHandler#REMOVE_FILE}
     * @param failsOnError
     *            indicate if this method will throw an exception if can not
     *            obtain an {@link InputStream}. use
     *            {@link FileInDiskHandler#FAILS_ON_ERROR}, or
     *            {@link FileInDiskHandler#IGNORES_ERROR}
     * @throws FileHandlerException
     *             If the params are either a file and a directory, or an error
     *             occur while executing the operation
     */
    public static void moveToFolder(List<String> files, String dir,
	    boolean keepFile, boolean failsOnError) throws FileHandlerException {
	for (String filePath : files) {

	    try {
		FileInDiskHandler.moveToFolder(filePath, dir, keepFile);
	    } catch (FileHandlerException e) {
		// only throws the exception if the keepFile is true
		FileInDiskHandler.handleException(failsOnError, e, null,
			"can not move/copy file: " + filePath
				+ " Operation will continue");
		;
	    }
	}
    }

    /**
     * Returns a {@link File} from the given path
     * 
     * @param file
     *            String
     * @return {@link File}
     */
    private static File getFileIO(String file) {
	File fileIo = new File(file);
	return fileIo;
    }

    /**
     * Rise the exception only if failsOnError was set to true, otherwise log
     * the error as warning
     * 
     * @param failsOnError
     * @param e
     *            Exception to be handle
     * @param exceptionMsg
     *            can be null if the exception is FileHandlerException
     * @param logMsg
     *            Msg to write in the log
     * @throws FileHandlerException
     *             if the failsOnError is true
     */
    private static void handleException(boolean failsOnError, Exception e,
	    String exceptionMsg, String logMsg) throws FileHandlerException {
	if (failsOnError) {

	    if (e instanceof FileHandlerException) {

		throw (FileHandlerException) e;
	    } else {

		throw new FileHandlerException(exceptionMsg, e);
	    }

	} else {
	    logger.warn(logMsg);
	}
    }

    /**
     * Private constructor
     */
    private FileInDiskHandler() {

    }

}
