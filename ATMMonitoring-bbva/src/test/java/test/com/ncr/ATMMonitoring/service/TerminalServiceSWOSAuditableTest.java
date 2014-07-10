package test.com.ncr.ATMMonitoring.service;

import static test.com.ncr.ATMMonitoring.service.CleanTerminal.cleanDB;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ncr.ATMMonitoring.dao.TerminalDAOImpl;
import com.ncr.ATMMonitoring.service.TerminalService;
import com.ncr.agent.baseData.ATMDataStorePojo;
import com.ncr.agent.baseData.os.module.OperatingSystemPojo;
import com.ncr.agent.baseData.os.module.ProductPojo;
import com.ncr.agent.baseData.vendor.utils.FinancialTerminalPojo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class TerminalServiceSWOSAuditableTest {

    @Autowired
    private TerminalService terminalService;

    @Autowired
    private TerminalDAOImpl terminalDao;

 private static final String ATM_MATRICULA = "-1224";


    private static final String TEST_VENDOR_NAME = "NCR testing";


    static private Logger logger = Logger
	    .getLogger(TerminalServiceSWOSAuditableTest.class);

    @Test
    public void testAddNewATMWithMatricula() {
	try {

	    ATMDataStorePojo atmData = TerminalServiceSWOSAuditableTest
		    .generateNewAtmDataStore();
	    this.terminalService.persistDataStoreTerminal(atmData);

	} catch (Throwable e) {
	    e.printStackTrace();
	    logger.error(e);
	    org.junit.Assert.fail("error saving the terminal: "
		    + e.getMessage());
	}
    }

    private static ATMDataStorePojo generateNewAtmDataStore() {

	ATMDataStorePojo newAtm = basicATMData();

	return newAtm;
    }

    @Test
    public void testUpdateSoftwareNewATMWithMatricula() {
	try {

	    ATMDataStorePojo atmData = TerminalServiceSWOSAuditableTest
		    .generateUpdatedAtmSoftwareDataStore();
	    this.terminalService.persistDataStoreTerminal(atmData);

	} catch (Throwable e) {
	    e.printStackTrace();
	    logger.error(e);
	    org.junit.Assert.fail("error saving the terminal: "
		    + e.getMessage());

	}
    }

    private static ATMDataStorePojo generateUpdatedAtmSoftwareDataStore() {

	ATMDataStorePojo updatedATM = basicATMData();
	updatedATM.setvProduct(newInstalledSoftware());

	return updatedATM;

    }

    private static Vector<ProductPojo> newInstalledSoftware() {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	String installDate = sdf.format(new Date());
	ProductPojo swProduct = new ProductPojo();
	swProduct.setName("my test software");
	swProduct.setVendor(TEST_VENDOR_NAME);
	swProduct.setVersion("4.0.554");
	swProduct.setIdentifyingNumber("12sde5-12324-ad4tg");
	swProduct.setInstallDate(installDate);

	ProductPojo swProduct2 = new ProductPojo();
	swProduct2.setName("my test software2");
	swProduct2.setVendor(TEST_VENDOR_NAME);
	swProduct2.setVersion("4.0.554");
	swProduct2.setIdentifyingNumber("13sde5-12324-ad4tg");
	swProduct2.setInstallDate(installDate);

	ProductPojo swProduct3 = new ProductPojo();
	swProduct3.setName("my test software3");
	swProduct3.setVendor(TEST_VENDOR_NAME);
	swProduct3.setVersion("4.0.554");
	swProduct3.setIdentifyingNumber("14sde5-12324-ad4tg");
	swProduct3.setInstallDate(installDate);

	Vector<ProductPojo> swInstalled = new Vector<ProductPojo>();
	swInstalled.add(swProduct);
	swInstalled.add(swProduct2);
	swInstalled.add(swProduct3);

	return swInstalled;
    }

    @Test
    public void testUpdateOperatingSystemNewATMWithMatricula() {
	try {

	    ATMDataStorePojo atmData = TerminalServiceSWOSAuditableTest
		    .generateUpdatedAtmOSDataStore();
	    this.terminalService.persistDataStoreTerminal(atmData);

	} catch (Throwable e) {
	    e.printStackTrace();
	    logger.error(e);
	    org.junit.Assert.fail("error saving the terminal: "
		    + e.getMessage());

	}
    }

    private static ATMDataStorePojo generateUpdatedAtmOSDataStore() {

	ATMDataStorePojo updatedATM = basicATMData();
	updatedATM.setvOperatingSystem(newOs());

	return updatedATM;

    }

    private static Vector<OperatingSystemPojo> newOs() {
	Vector<OperatingSystemPojo> osVector = new Vector<OperatingSystemPojo>();
	OperatingSystemPojo os = new OperatingSystemPojo();
	os.setManufacturer(TEST_VENDOR_NAME);
	os.setName("NCR Test OS");
	os.setSerialNumber("09201-908208010");
	os.setVersion("1.2.3.400");
	os.setOSLanguage("Testing");
	osVector.add(os);

	return osVector;
    }

    private static ATMDataStorePojo basicATMData() {
	ATMDataStorePojo atm = new ATMDataStorePojo();
	atm.setCurrentip("127.0.0.1");
	atm.setMatricula(ATM_MATRICULA);
	FinancialTerminalPojo financialTerminal = new FinancialTerminalPojo();
	financialTerminal.setModel("test model");
	financialTerminal.setVendor(TEST_VENDOR_NAME);
	atm.setFinancialTerminal(financialTerminal);
	return atm;
    }

    @AfterClass
    public static void cleanup() {


	cleanDB( ATM_MATRICULA);

    }


}
