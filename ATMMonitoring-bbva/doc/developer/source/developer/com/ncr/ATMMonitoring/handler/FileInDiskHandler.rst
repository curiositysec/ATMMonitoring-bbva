.. java:import:: java.io File

.. java:import:: java.io FileInputStream

.. java:import:: java.io IOException

.. java:import:: java.io InputStream

.. java:import:: java.util ArrayList

.. java:import:: java.util Collection

.. java:import:: java.util List

.. java:import:: java.util.regex Matcher

.. java:import:: java.util.regex Pattern

.. java:import:: org.apache.commons.io FileUtils

.. java:import:: org.apache.commons.io.filefilter IOFileFilter

.. java:import:: org.apache.commons.io.filefilter SuffixFileFilter

.. java:import:: org.apache.commons.lang StringUtils

.. java:import:: org.apache.log4j Logger

.. java:import:: com.ncr ATMMonitoring.handler.exception.FileHandlerException

FileInDiskHandler
=================

.. java:package:: com.ncr.ATMMonitoring.handler
   :noindex:

.. java:type:: public class FileInDiskHandler

   Class that facilitates the manipulation of files in the fileSystem

   :author: Otto Abreu

Fields
------
FAILS_ON_ERROR
^^^^^^^^^^^^^^

.. java:field:: public static final boolean FAILS_ON_ERROR
   :outertype: FileInDiskHandler

   Indicates that the method will throw an exception if an operation fails for one File

IGNORES_ERROR
^^^^^^^^^^^^^

.. java:field:: public static final boolean IGNORES_ERROR
   :outertype: FileInDiskHandler

   Indicates that the method will continue even if an operation fails for one or more Files

KEEP_FILE
^^^^^^^^^

.. java:field:: public static final boolean KEEP_FILE
   :outertype: FileInDiskHandler

   Indicates that the original file will be deleted after copying it

REMOVE_FILE
^^^^^^^^^^^

.. java:field:: public static final boolean REMOVE_FILE
   :outertype: FileInDiskHandler

   Indicates that the original file will be deleted after copying it

Methods
-------
delete
^^^^^^

.. java:method:: public static void delete(String file) throws FileHandlerException
   :outertype: FileInDiskHandler

   Method that deletes the given file It will try to delete using the \ :java:ref:`FileUtils.forceDelete(File)`\  and if it fails ( throws an IOException), will try to execute the \ :java:ref:`FileUtils.forceDeleteOnExit(File)`\  IMPORTANT: This method only deletes a file, if the path belongs to
   a directory nothing will be done

   :param file: String with a valid path in the system

delete
^^^^^^

.. java:method:: public static void delete(List<String> files, boolean failsOnError) throws FileHandlerException
   :outertype: FileInDiskHandler

   Method that deletes the given files To set the failsOnError please use \ :java:ref:`FileInDiskHandler.FAILS_ON_ERROR`\ , that will make that this method throw an exception if an error occurs If \ :java:ref:`FileInDiskHandler.IGNORES_ERROR`\  is set, this method will not stop if an error occurs, only will delete the files that do not throw an exception IMPORTANT: This method only deletes files, if a path belongs to a
   directory nothing will be done to that path  this method calls \ :java:ref:`FileInDiskHandler.delete(String)`\

   :param files: List with valid systems path
   :param failsOnError: indicate if this method will throw an exception if can not obtain an \ :java:ref:`InputStream`\ . use \ :java:ref:`FileInDiskHandler.FAILS_ON_ERROR`\ , or \ :java:ref:`FileInDiskHandler.IGNORES_ERROR`\

getFileInputStream
^^^^^^^^^^^^^^^^^^

.. java:method:: public static InputStream getFileInputStream(String file) throws FileHandlerException
   :outertype: FileInDiskHandler

   From a valid system path, returns the \ :java:ref:`InputStream`\

   :param file: String with a valid path in the system
   :return: \ :java:ref:`InputStream`\

getFiles
^^^^^^^^

.. java:method:: @SuppressWarnings public static Collection<File> getFiles(String fileExtension, String fileFolder) throws FileHandlerException
   :outertype: FileInDiskHandler

   Retrieves the file that has a certain extension (or all) from a given folder retrieve the files If the given path (fileFolder param) is not a valid directory, or is empty, will return a empty collection if the folder does not exist or the folder is empty This method uses \ :java:ref:`FileUtils`\ .

   :param fileExtension: String with the file extension to retrieve, format:(\\.[a-zA-Z0-9]{2,5})$
   :param fileFolder: String with a valid system path

getFilesInputStream
^^^^^^^^^^^^^^^^^^^

.. java:method:: public static List<InputStream> getFilesInputStream(List<String> files, boolean failsOnError) throws FileHandlerException
   :outertype: FileInDiskHandler

   From a valid list of system paths, returns the \ :java:ref:`InputStream`\  associated to each path To set the failsOnError please use \ :java:ref:`FileInDiskHandler.FAILS_ON_ERROR`\ , that will make that this method throw an exception if an error occurs If \ :java:ref:`FileInDiskHandler.IGNORES_ERROR`\  is set, this method will not stop if an error occurs, only will return the \ :java:ref:`InputStream`\  that was possible to obtain. this method calls \ :java:ref:`FileInDiskHandler.getFile(String)`\  Will return a empty List if the files param is empty or fails in all attempts and the failsOnError is true

   :param files: List with valid systems path
   :param failsOnError: indicate if this method will throw an exception if can not obtain an \ :java:ref:`InputStream`\ . use \ :java:ref:`FileInDiskHandler.FAILS_ON_ERROR`\ , or \ :java:ref:`FileInDiskHandler.IGNORES_ERROR`\
   :return: List

getFilesInputStream
^^^^^^^^^^^^^^^^^^^

.. java:method:: public static List<InputStream> getFilesInputStream(Collection<File> files, boolean failsOnError) throws FileHandlerException
   :outertype: FileInDiskHandler

   From an existing file, returns the \ :java:ref:`InputStream`\  associated to each file To set the failsOnError please use \ :java:ref:`FileInDiskHandler.FAILS_ON_ERROR`\ , that will make that this method throw an exception if an error occurs If \ :java:ref:`FileInDiskHandler.IGNORES_ERROR`\  is set, this method will not stop if an error occurs, only will return the \ :java:ref:`InputStream`\  that was possible to obtain. this method calls \ :java:ref:`FileInDiskHandler.getFile(String)`\

   :param files: Collection with valid files
   :param failsOnError: indicate if this method will throw an exception if can not obtain an \ :java:ref:`InputStream`\ . use \ :java:ref:`FileInDiskHandler.FAILS_ON_ERROR`\ , or \ :java:ref:`FileInDiskHandler.IGNORES_ERROR`\
   :return: List

getFilespath
^^^^^^^^^^^^

.. java:method:: public static List<String> getFilespath(Collection<File> files)
   :outertype: FileInDiskHandler

   Returns the path from the given files

   :param files: Collection of File
   :return: List with all the paths

getFilespath
^^^^^^^^^^^^

.. java:method:: public static List<String> getFilespath(String fileExtension, String fileFolder) throws FileHandlerException
   :outertype: FileInDiskHandler

   Returns the path from the given files This method calls \ :java:ref:`FileInDiskHandler.getFilespath(String,String)`\  and \ :java:ref:`FileInDiskHandler.getFilespath(Collection)`\

   :param fileExtension: String with the file extension to retrieve, format:(\\.[a-zA-Z0-9]{2,5})$
   :param fileFolder: String with a valid system path
   :return: List with all the paths

moveToFolder
^^^^^^^^^^^^

.. java:method:: public static void moveToFolder(String file, String dir, boolean keepFile) throws FileHandlerException
   :outertype: FileInDiskHandler

   Executes a move operation (if the keepFile param is false) or a copy (if the keepFile param is true)

   :param file: String with the full path of the file
   :param dir: String with the full path of the directory
   :param keepFile: indicates if will execute a move operation ( removes the file after being copied) or just copy ( leaves the original).use \ :java:ref:`FileInDiskHandler.KEEP_FILE`\ , or \ :java:ref:`FileInDiskHandler.REMOVE_FILE`\

moveToFolder
^^^^^^^^^^^^

.. java:method:: public static void moveToFolder(List<String> files, String dir, boolean keepFile, boolean failsOnError) throws FileHandlerException
   :outertype: FileInDiskHandler

   Executes a move operation (if the keepFile param is false) or a copy (if the keepFile param is true) for the given files This method calls \ :java:ref:`FileInDiskHandler.moveToFolder(String,String,boolean)`\

   :param files: List of Strings with the full path of the files
   :param dir: String with the full path of the directory
   :param keepFile: indicates if will execute a move operation (removes the file after being copied) or just copy (leaves the original).use \ :java:ref:`FileInDiskHandler.KEEP_FILE`\ , or \ :java:ref:`FileInDiskHandler.REMOVE_FILE`\
   :param failsOnError: indicate if this method will throw an exception if can not obtain an \ :java:ref:`InputStream`\ . use \ :java:ref:`FileInDiskHandler.FAILS_ON_ERROR`\ , or \ :java:ref:`FileInDiskHandler.IGNORES_ERROR`\

touch
^^^^^

.. java:method:: public static void touch(String file) throws FileHandlerException
   :outertype: FileInDiskHandler

   Executes the touch operation on the given file path

   :param file: String with a valid path in the system

touch
^^^^^

.. java:method:: public static void touch(List<String> files, boolean failsOnError) throws FileHandlerException
   :outertype: FileInDiskHandler

   Executes the touch operation on the given files paths To set the failsOnError please use \ :java:ref:`FileInDiskHandler.FAILS_ON_ERROR`\ , that will make that this method throw an exception if an error occurs If \ :java:ref:`FileInDiskHandler.IGNORES_ERROR`\  is set, this method will not stop if an error occurs, only will touch the files that not generate an error  this method calls \ :java:ref:`FileInDiskHandler.touch(String)`\

   :param files: List with valid systems path
   :param failsOnError: indicate if this method will throw an exception if can not obtain an \ :java:ref:`InputStream`\ . use \ :java:ref:`FileInDiskHandler.FAILS_ON_ERROR`\ , or \ :java:ref:`FileInDiskHandler.IGNORES_ERROR`\

