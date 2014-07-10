package test.com.ncr.ATMMonitoring.service;

import java.sql.Types;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public final class CleanTerminal {

    private static final String CLEANUP_QUERY_GET_TERMINAL_ID = "SELECT id FROM terminals WHERE   matricula ='{matricula}'";

    private static final String CLEANUP_QUERY_DELETE_FROM_TERMINAL = "DELETE FROM terminals where id = ?";

    private static final String CLEANUP_QUERY_DELETE_FROM_TERMINAL_CONFIGS = "DELETE FROM terminal_configs where terminal_id = ?";

    private static final String CLEANUP_QUERY_DELETE_FROM_TERMINAL_CONFIGS_AUDITABLE_SW = "DELETE FROM  terminal_config_auditable_sw "
	    + "WHERE terminal_config_id in (SELECT id  FROM terminal_configs WHERE terminal_id = ?)";

    private static final String CLEANUP_QUERY_DELETE_FROM_TERMINAL_CONFIGS_AUDITABLE_OS = "DELETE FROM  terminal_config_auditable_os "
	    + "WHERE terminal_config_id in (SELECT id  FROM terminal_configs WHERE terminal_id = ?)";

    private static final String CLEANUP_QUERY_DELETE_FROM_TERMINAL_CONFIGS_SOFTWARE = "DELETE FROM  terminal_config_software"
	    + " WHERE terminal_config_id in (SELECT id  FROM terminal_configs WHERE terminal_id = ?)";

    private static final String TEST_VENDOR_NAME = "NCR testing";

    private static final String CLEANUP_QUERY_DELETE_SOFTWARE = "delete from software where vendor = '"
	    + TEST_VENDOR_NAME + "'";
    private static final String CLEANUP_QUERY_DELETE_AUDITABLE_SOFTWARE = "delete from auditable_software where software_id in (select id from software where vendor = '"
	    + TEST_VENDOR_NAME + "')";

    private static final String CLEANUP_QUERY_DELETE_OS = "delete from operating_systems where manufacturer = '"
	    + TEST_VENDOR_NAME + "'";
    private static final String CLEANUP_QUERY_DELETE_AUDITABLE_OS = "delete from auditable_operating_systems where os_id in (select id from operating_systems where manufacturer = '"
	    + TEST_VENDOR_NAME + "')";

    private static final String CLEANUP_QUERY_DELETE_CONFIG_OS = "delete from t_config_op_system where operating_system_id in (select id from operating_systems where manufacturer = '"
	    + TEST_VENDOR_NAME + "')";

    private static final String CLEANUP_QUERY_JSON_DELETE_TERMINAL_CONFIG_SOFTWARE = "DELETE FROM terminal_config_software WHERE terminal_config_id in (SELECT id  FROM terminal_configs WHERE terminal_id in  (SELECT id from terminals where matricula ='{matricula}'));";
    private static final String CLEANUP_QUERY_JSON_DELETE_TERMINAL_CONFIG_AUDITABLE_OS = "DELETE FROM terminal_config_auditable_os WHERE terminal_config_id in (SELECT id  FROM terminal_configs WHERE terminal_id  in  (SELECT id FROM terminals WHERE matricula ='{matricula}'));";
    private static final String CLEANUP_QUERY_JSON_DELETE_TERMINAL_CONFIG_AUDITABLE_SW = "DELETE FROM terminal_config_auditable_sw WHERE terminal_config_id in (SELECT id  FROM terminal_configs WHERE terminal_id  in  (SELECT id FROM terminals WHERE matricula ='{matricula}'));";
    private static final String CLEANUP_QUERY_JSON_DELETE_TERMINAL_CONFIG_SW = "DELETE FROM terminal_config_software WHERE terminal_config_id in (SELECT id  FROM terminal_configs WHERE terminal_id in  (SELECT id from terminals where matricula ='{matricula}'));";
    private static final String CLEANUP_QUERY_JSON_DELETE_AUDITABLE_SW = "DELETE FROM auditable_software WHERE software_id in ( select software_id  FROM terminal_config_software WHERE terminal_config_id in ( SELECT id  FROM terminal_configs WHERE terminal_id = (SELECT id from terminals WHERE matricula ='{matricula}')));";
    private static final String CLEANUP_QUERY_JSON_DELETE_SW = "DELETE FROM software WHERE id in  ( select software_id  FROM terminal_config_software WHERE terminal_config_id in ( SELECT id  FROM terminal_configs WHERE terminal_id = (SELECT id FROM terminals WHERE matricula ='{matricula}')));";
    private static final String CLEANUP_QUERY_JSON_DELETE_AUDITABLE_OS = "DELETE FROM auditable_operating_systems where os_id in (SELECT operating_system_id FROM t_config_op_system WHERE terminal_config_id in ( SELECT id  FROM terminal_configs WHERE terminal_id = (SELECT id from terminals WHERE matricula ='{matricula}')));";
    private static final String CLEANUP_QUERY_JSON_DELETE_TERMINAL_CONFIG_OS = "DELETE FROM t_config_op_system  WHERE terminal_config_id in ( SELECT id  FROM terminal_configs WHERE terminal_id = (SELECT id from terminals WHERE matricula ='{matricula}'));";
    private static final String CLEANUP_QUERY_JSON_DELETE_TERMINAL_CONFIG = "DELETE FROM terminal_configs WHERE terminal_id = (SELECT id from terminals WHERE matricula ='{matricula}');";
    private static final String CLEANUP_QUERY_JSON_DELETE_FINANCIALDEVICE_JXFS = "DELETE FROM financial_device_jxfs_component WHERE financial_device_id in (SELECT id FROM financial_devices WHERE terminal_id = (SELECT id from terminals WHERE matricula ='{matricula}'));";
    private static final String CLEANUP_QUERY_JSON_DELETE_FINANCIALDEVICE_XFS = "DELETE FROm financial_device_xfs_component WHERE financial_device_id in (SELECT id FROM financial_devices WHERE terminal_id = (SELECT id from terminals WHERE matricula ='{matricula}'));";
    private static final String CLEANUP_QUERY_JSON_DELETE_DELETE_FINANCIALDEVICE = "DELETE FROM financial_devices WHERE terminal_id = (SELECT id from terminals WHERE matricula ='{matricula}');";
    private static final String CLEANUP_QUERY_JSON_DELETE_HARDWARE_DEVICES = "DELETE FROM hardware_devices WHERE terminal_id  = (SELECT id from terminals WHERE matricula ='{matricula}');";
    private static final String CLEANUP_QUERY_JSON_DELETE_TERMINALS_AUDITABLE_SW = "DELETE FROM terminals_auditable_software_aggregate WHERE terminals_id  = (SELECT id from terminals WHERE matricula ='{matricula}');";
    private static final String CLEANUP_QUERY_JSON_DELETE_HOTFIXES = "DELETE FROM hotfixes WHERE terminal_id  = (SELECT id from terminals WHERE matricula ='{matricula}');";
    private static final String CLEANUP_QUERY_JSON_DELETE_TERMINALS = "DELETE FROM terminals where id =  (SELECT id from terminals WHERE matricula ='{matricula}');";

    private static Logger logger = Logger
	    .getLogger(TerminalServiceSWOSAuditableTest.class);

    public static void cleanDB(String terminalMatricula) {
	
	JdbcTemplate jdbctemplate = getJdbcTemplate();
	int terminalId = jdbctemplate
		.queryForInt(generateCleanUpQueryForGetTerminalId(terminalMatricula));
	Object[] terminalIdParam = { terminalId };
	int[] types = { Types.INTEGER };
	System.out.println("el id:" + terminalId);

	try {
	    cleanTerminalConfigSoftware(jdbctemplate, terminalIdParam, types);
	    cleanTerminalConfigAuditableOS(jdbctemplate, terminalIdParam, types);
	    cleanTerminalConfigAuditableSw(jdbctemplate, terminalIdParam, types);
	    cleanTerminalConfigSoftware(jdbctemplate, terminalIdParam, types);
	    cleanAuditableSoftware(jdbctemplate);
	    cleanSoftware(jdbctemplate);
	    cleanAuditableOS(jdbctemplate);
	    cleanConfigOS(jdbctemplate);
	    cleanOS(jdbctemplate);
	    cleanTerminalConfigs(jdbctemplate, terminalIdParam, types);
	    cleanTerminal(jdbctemplate, terminalIdParam, types);
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }
    
    private static JdbcTemplate getJdbcTemplate(){
	ApplicationContext springContext = getSpringContext();
	org.apache.commons.dbcp.BasicDataSource ds = (BasicDataSource) springContext
		.getBean("dataSource");
	JdbcTemplate jdbctemplate = new JdbcTemplate(ds);
	return jdbctemplate;
    }
    
    private static ClassPathXmlApplicationContext getSpringContext() {
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
		"applicationContext.xml");
	return ctx;
    }

    private static String generateCleanUpQueryForGetTerminalId(String matricula) {
	String query = replaceMatricula(CLEANUP_QUERY_GET_TERMINAL_ID,
		matricula);
	return query;
    }

    private static String replaceMatricula(String query, String matricula) {
	query = query.replaceAll("\\{matricula\\}", matricula);
	return query;
    }

    private static void cleanTerminalConfigSoftware(JdbcTemplate jdbctemplate,
	    Object[] terminalIdParam, int[] types) {
	int rows = delete(jdbctemplate,
		CLEANUP_QUERY_DELETE_FROM_TERMINAL_CONFIGS_SOFTWARE,
		terminalIdParam, types);
	System.out.println("deleted config software:" + rows);
    }

    private static void cleanTerminalConfigAuditableSw(
	    JdbcTemplate jdbctemplate, Object[] terminalIdParam, int[] types) {
	int rows = delete(jdbctemplate,
		CLEANUP_QUERY_DELETE_FROM_TERMINAL_CONFIGS_AUDITABLE_SW,
		terminalIdParam, types);
	System.out.println("deleted auditable sw:" + rows);
    }

    private static void cleanTerminalConfigAuditableOS(
	    JdbcTemplate jdbctemplate, Object[] terminalIdParam, int[] types) {
	int rows = delete(jdbctemplate,
		CLEANUP_QUERY_DELETE_FROM_TERMINAL_CONFIGS_AUDITABLE_OS,
		terminalIdParam, types);
	System.out.println("deleted auditable os:" + rows);
    }

    private static void cleanTerminalConfigs(JdbcTemplate jdbctemplate,
	    Object[] terminalIdParam, int[] types) {
	int rows = delete(jdbctemplate,
		CLEANUP_QUERY_DELETE_FROM_TERMINAL_CONFIGS, terminalIdParam,
		types);
	System.out.println("deleted terminal configs:" + rows);
    }

    private static void cleanTerminal(JdbcTemplate jdbctemplate,
	    Object[] terminalIdParam, int[] types) {

	int rows = delete(jdbctemplate, CLEANUP_QUERY_DELETE_FROM_TERMINAL,
		terminalIdParam, types);
	System.out.println("deleted terminal :" + rows);
    }

    private static void cleanAuditableSoftware(JdbcTemplate jdbctemplate) {

	int rows = deleteNoParams(jdbctemplate,
		CLEANUP_QUERY_DELETE_AUDITABLE_SOFTWARE);
	System.out.println("deleted auditable software :" + rows);
    }

    private static void cleanSoftware(JdbcTemplate jdbctemplate) {

	int rows = deleteNoParams(jdbctemplate, CLEANUP_QUERY_DELETE_SOFTWARE);
	System.out.println("deleted  software :" + rows);
    }

    private static void cleanAuditableOS(JdbcTemplate jdbctemplate) {

	int rows = deleteNoParams(jdbctemplate,
		CLEANUP_QUERY_DELETE_AUDITABLE_OS);
	System.out.println("deleted auditable software :" + rows);
    }

    private static void cleanOS(JdbcTemplate jdbctemplate) {

	int rows = deleteNoParams(jdbctemplate, CLEANUP_QUERY_DELETE_OS);
	System.out.println("deleted  software :" + rows);
    }

    private static void cleanConfigOS(JdbcTemplate jdbctemplate) {

	int rows = deleteNoParams(jdbctemplate, CLEANUP_QUERY_DELETE_CONFIG_OS);
	System.out.println("deleted  software :" + rows);
    }

    public static void cleanDBJSON(String terminalMatricula) {

	JdbcTemplate jdbctemplate = getJdbcTemplate();
	
	try {
	    cleanJsonTerminalConfigSoftware(jdbctemplate, terminalMatricula);
	    cleanJsonTerminalConfigAuditableOs(jdbctemplate, terminalMatricula);
	    cleanJsonTerminalConfigAuditableSw(jdbctemplate, terminalMatricula);
	    cleanJsonTerminalConfigSw(jdbctemplate, terminalMatricula);
	    cleanJsonAuditableSw(jdbctemplate, terminalMatricula);
	    cleanJsonSw(jdbctemplate, terminalMatricula);
	    cleanJsonAuditableOS(jdbctemplate, terminalMatricula);
	    cleanJsonTerminalConfigOS(jdbctemplate, terminalMatricula);
	    cleanJsonTerminalConfig(jdbctemplate, terminalMatricula);
	    cleanJsonFinancialDeviceJXFS(jdbctemplate, terminalMatricula);
	    cleanJsonFinancialDeviceXFS(jdbctemplate, terminalMatricula);
	    cleanJsonFinancialDevice(jdbctemplate, terminalMatricula);
	    cleanJsonHardwarelDevice(jdbctemplate, terminalMatricula);
	    cleanJsonTerminalAuditableSW(jdbctemplate, terminalMatricula);
	    cleanJsonHotfixes(jdbctemplate, terminalMatricula);
	    cleanJsonTerminals(jdbctemplate, terminalMatricula);
	    
	} catch (Exception e) {

	    e.printStackTrace();
	}
    }

    private static void cleanJsonTerminalConfigSoftware(
	    JdbcTemplate jdbctemplate, String matricula) {
	String query = replaceMatricula(
		CLEANUP_QUERY_JSON_DELETE_TERMINAL_CONFIG_SOFTWARE, matricula);
	deleteNoParams(jdbctemplate, query);
    }

    private static void cleanJsonTerminalConfigAuditableOs(
	    JdbcTemplate jdbctemplate, String matricula) {
	String query = replaceMatricula(
		CLEANUP_QUERY_JSON_DELETE_TERMINAL_CONFIG_AUDITABLE_OS,
		matricula);
	deleteNoParams(jdbctemplate, query);
    }
    
    
    private static void cleanJsonTerminalConfigAuditableSw(
	    JdbcTemplate jdbctemplate, String matricula) {
	String query = replaceMatricula(
		CLEANUP_QUERY_JSON_DELETE_TERMINAL_CONFIG_AUDITABLE_SW,
		matricula);
	deleteNoParams(jdbctemplate, query);
    }
    
    private static void cleanJsonTerminalConfigSw(
	    JdbcTemplate jdbctemplate, String matricula) {
	String query = replaceMatricula(
		CLEANUP_QUERY_JSON_DELETE_TERMINAL_CONFIG_SW,
		matricula);
	deleteNoParams(jdbctemplate, query);
    }
    
    private static void cleanJsonAuditableSw(
	    JdbcTemplate jdbctemplate, String matricula) {
	String query = replaceMatricula(
		CLEANUP_QUERY_JSON_DELETE_AUDITABLE_SW,
		matricula);
	deleteNoParams(jdbctemplate, query);
    }
    
    private static void cleanJsonSw(
	    JdbcTemplate jdbctemplate, String matricula) {
	String query = replaceMatricula(
		CLEANUP_QUERY_JSON_DELETE_SW,
		matricula);
	deleteNoParams(jdbctemplate, query);
    } 
    
    private static void cleanJsonAuditableOS(
	    JdbcTemplate jdbctemplate, String matricula) {
	String query = replaceMatricula(
		CLEANUP_QUERY_JSON_DELETE_AUDITABLE_OS,
		matricula);
	deleteNoParams(jdbctemplate, query);
    }
    
    
    private static void cleanJsonTerminalConfigOS(
	    JdbcTemplate jdbctemplate, String matricula) {
	String query = replaceMatricula(
		CLEANUP_QUERY_JSON_DELETE_TERMINAL_CONFIG_OS,
		matricula);
	deleteNoParams(jdbctemplate, query);
    }
    
    private static void cleanJsonTerminalConfig(
	    JdbcTemplate jdbctemplate, String matricula) {
	String query = replaceMatricula(
		CLEANUP_QUERY_JSON_DELETE_TERMINAL_CONFIG,
		matricula);
	deleteNoParams(jdbctemplate, query);
    }
    
    private static void cleanJsonFinancialDeviceJXFS(
	    JdbcTemplate jdbctemplate, String matricula) {
	String query = replaceMatricula(
		CLEANUP_QUERY_JSON_DELETE_FINANCIALDEVICE_JXFS,
		matricula);
	deleteNoParams(jdbctemplate, query);
    }
    
    private static void cleanJsonFinancialDeviceXFS(
	    JdbcTemplate jdbctemplate, String matricula) {
	String query = replaceMatricula(
		CLEANUP_QUERY_JSON_DELETE_FINANCIALDEVICE_XFS,
		matricula);
	deleteNoParams(jdbctemplate, query);
    }
    
    private static void cleanJsonFinancialDevice(
	    JdbcTemplate jdbctemplate, String matricula) {
	String query = replaceMatricula(
		CLEANUP_QUERY_JSON_DELETE_DELETE_FINANCIALDEVICE,
		matricula);
	deleteNoParams(jdbctemplate, query);
    }
    
    private static void cleanJsonHardwarelDevice(
	    JdbcTemplate jdbctemplate, String matricula) {
	String query = replaceMatricula(
		CLEANUP_QUERY_JSON_DELETE_HARDWARE_DEVICES,
		matricula);
	deleteNoParams(jdbctemplate, query);
    }
    
    private static void cleanJsonTerminalAuditableSW(
	    JdbcTemplate jdbctemplate, String matricula) {
	String query = replaceMatricula(
		CLEANUP_QUERY_JSON_DELETE_TERMINALS_AUDITABLE_SW,
		matricula);
	deleteNoParams(jdbctemplate, query);
    }
    
    
    private static void cleanJsonHotfixes(
	    JdbcTemplate jdbctemplate, String matricula) {
	String query = replaceMatricula(
		CLEANUP_QUERY_JSON_DELETE_HOTFIXES,
		matricula);
	deleteNoParams(jdbctemplate, query);
    }
    
    private static void cleanJsonTerminals(
	    JdbcTemplate jdbctemplate, String matricula) {
	String query = replaceMatricula(
		CLEANUP_QUERY_JSON_DELETE_TERMINALS,
		matricula);
	deleteNoParams(jdbctemplate, query);
    }
    
    
    private static int deleteNoParams(JdbcTemplate jdbctemplate, String query) {
	return delete(jdbctemplate, query, null, null);
    }

    private static int delete(JdbcTemplate jdbctemplate, String query,
	    Object[] terminalIdParam, int[] types) {
	int rows = jdbctemplate.update(query, terminalIdParam, types);
	return rows;
    }
}
