package com.ncr.ATMMonitoring.service;

import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.TerminalDAO;
import com.ncr.ATMMonitoring.pojo.AuditableInternetExplorer;
import com.ncr.ATMMonitoring.pojo.AuditableOperatingSystem;
import com.ncr.ATMMonitoring.pojo.AuditableSoftware;
import com.ncr.ATMMonitoring.pojo.AuditableSoftwareAggregate;
import com.ncr.ATMMonitoring.pojo.BankCompany;
import com.ncr.ATMMonitoring.pojo.FinancialDevice;
import com.ncr.ATMMonitoring.pojo.HardwareDevice;
import com.ncr.ATMMonitoring.pojo.Hotfix;
import com.ncr.ATMMonitoring.pojo.Installation;
import com.ncr.ATMMonitoring.pojo.InternetExplorer;
import com.ncr.ATMMonitoring.pojo.JxfsComponent;
import com.ncr.ATMMonitoring.pojo.OperatingSystem;
import com.ncr.ATMMonitoring.pojo.Software;
import com.ncr.ATMMonitoring.pojo.SoftwareAggregate;
import com.ncr.ATMMonitoring.pojo.Terminal;
import com.ncr.ATMMonitoring.pojo.TerminalConfig;
import com.ncr.ATMMonitoring.pojo.TerminalModel;
import com.ncr.ATMMonitoring.pojo.XfsComponent;
import com.ncr.ATMMonitoring.socket.ATMWrongDataException;
import com.ncr.ATMMonitoring.utils.Utils;
import com.ncr.agent.baseData.ATMDataStorePojo;
import com.ncr.agent.baseData.os.module.BaseBoardPojo;
import com.ncr.agent.baseData.os.module.BiosPojo;
import com.ncr.agent.baseData.os.module.CDROMDrivePojo;
import com.ncr.agent.baseData.os.module.ComputerSystemPojo;
import com.ncr.agent.baseData.os.module.DesktopMonitorPojo;
import com.ncr.agent.baseData.os.module.DiskDrivePojo;
import com.ncr.agent.baseData.os.module.FloppyDrivePojo;
import com.ncr.agent.baseData.os.module.HotfixPojo;
import com.ncr.agent.baseData.os.module.IExplorerPojo;
import com.ncr.agent.baseData.os.module.KeyboardPojo;
import com.ncr.agent.baseData.os.module.LogicalDiskPojo;
import com.ncr.agent.baseData.os.module.NetworkAdapterSettingPojo;
import com.ncr.agent.baseData.os.module.OperatingSystemPojo;
import com.ncr.agent.baseData.os.module.ParallelPortPojo;
import com.ncr.agent.baseData.os.module.PhysicalMemoryPojo;
import com.ncr.agent.baseData.os.module.PointingDevicePojo;
import com.ncr.agent.baseData.os.module.ProcessorPojo;
import com.ncr.agent.baseData.os.module.ProductPojo;
import com.ncr.agent.baseData.os.module.SCSIControllerPojo;
import com.ncr.agent.baseData.os.module.SerialPortPojo;
import com.ncr.agent.baseData.os.module.SoundDevicePojo;
import com.ncr.agent.baseData.os.module.SystemSlotPojo;
import com.ncr.agent.baseData.os.module.USBControllerPojo;
import com.ncr.agent.baseData.os.module.UsbHubPojo;
import com.ncr.agent.baseData.os.module.VideoControllerPojo;
import com.ncr.agent.baseData.os.module._1394ControllerPojo;
import com.ncr.agent.baseData.standard.jxfs.alm.CapabilitiesJxfsALMCollector;
import com.ncr.agent.baseData.standard.jxfs.cam.CapabilitiesJxfsCAMCollector;
import com.ncr.agent.baseData.standard.jxfs.cdr.CapabilitiesJxfsCDRCollector;
import com.ncr.agent.baseData.standard.jxfs.chk.CapabilitiesJxfsCHKCollector;
import com.ncr.agent.baseData.standard.jxfs.dep.CapabilitiesJxfsDEPCollector;
import com.ncr.agent.baseData.standard.jxfs.msd.CapabilitiesJxfsMSDCollector;
import com.ncr.agent.baseData.standard.jxfs.pin.CapabilitiesJxfsPINCollector;
import com.ncr.agent.baseData.standard.jxfs.ptr.CapabilitiesJxfsPTRCollector;
import com.ncr.agent.baseData.standard.jxfs.scn.CapabilitiesJxfsSCNCollector;
import com.ncr.agent.baseData.standard.jxfs.siu.CapabilitiesJxfsSIUCollector;
import com.ncr.agent.baseData.standard.jxfs.tio.CapabilitiesJxfsTIOCollector;
import com.ncr.agent.baseData.standard.jxfs.vdm.CapabilitiesJxfsVDMCollector;
import com.ncr.agent.baseData.standard.xfs.module.ALM;
import com.ncr.agent.baseData.standard.xfs.module.BCR;
import com.ncr.agent.baseData.standard.xfs.module.CAM;
import com.ncr.agent.baseData.standard.xfs.module.CDM;
import com.ncr.agent.baseData.standard.xfs.module.CEU;
import com.ncr.agent.baseData.standard.xfs.module.CHK;
import com.ncr.agent.baseData.standard.xfs.module.CIM;
import com.ncr.agent.baseData.standard.xfs.module.CRD;
import com.ncr.agent.baseData.standard.xfs.module.DEP;
import com.ncr.agent.baseData.standard.xfs.module.IDC;
import com.ncr.agent.baseData.standard.xfs.module.IPM;
import com.ncr.agent.baseData.standard.xfs.module.PIN;
import com.ncr.agent.baseData.standard.xfs.module.PTR;
import com.ncr.agent.baseData.standard.xfs.module.SIU;
import com.ncr.agent.baseData.standard.xfs.module.TTU;
import com.ncr.agent.baseData.standard.xfs.module.VDM;
import com.ncr.agent.baseData.vendor.utils.FinancialDevicePojo;
import com.ncr.agent.baseData.vendor.utils.FinancialPackagePojo;
import com.ncr.agent.baseData.vendor.utils.FinancialTerminalPojo;

/**
 * The Class TerminalServiceImpl.
 * 
 * Default implementation of the TerminalService.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("terminalService")
@Transactional
public class TerminalServiceImpl implements TerminalService {

    /** The logger. */
    static private Logger logger = Logger.getLogger(TerminalServiceImpl.class
	    .getName());

    /** The encrypted date limit for this version. */
    @Value("${license.dateLimit}")
    private String dateLimit;

    /** The key for the current license. */
    @Value("${license.licenseKey}")
    private String licenseKey;

    /** The terminal dao. */
    @Autowired
    private TerminalDAO terminalDAO;

    /** The hardware device service. */
    @Autowired
    private HardwareDeviceService hardwareDeviceService;

    /** The financial device service. */
    @Autowired
    private FinancialDeviceService financialDeviceService;

    /** The internet explorer service. */
    @Autowired
    private InternetExplorerService internetExplorerService;

    /** The hotfix service. */
    @Autowired
    private HotfixService hotfixService;

    /** The software aggregate service. */
    @Autowired
    private SoftwareAggregateService softwareAggregateService;

    /** The software service. */
    @Autowired
    private SoftwareService softwareService;

    /** The operating system service. */
    @Autowired
    private OperatingSystemService operatingSystemService;

    /** The terminal model service. */
    @Autowired
    private TerminalModelService terminalModelService;

    /**
     * @see com.ncr.ATMMonitoring.service.TerminalService#addTerminal(com.ncr.ATMMonitoring.pojo.Terminal)
     */
    @Override
    public void addTerminal(Terminal terminal) {
	terminalDAO.addTerminal(terminal);
    }

    /**
     * @see com.ncr.ATMMonitoring.service.TerminalService#updateTerminal(com.ncr.ATMMonitoring.pojo.Terminal)
     */
    @Override
    public void updateTerminal(Terminal terminal) {
	terminalDAO.updateTerminal(terminal);
    }

    /**
     * @see com.ncr.ATMMonitoring.service.TerminalService#listTerminalsByBankCompanies(java.util.Set)
     */
    @Override
    public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> banks) {
	return terminalDAO.listTerminalsByBankCompanies(banks);
    }

    /**
     * @see com.ncr.ATMMonitoring.service.TerminalService#listTerminalsByBankCompany(com.ncr.ATMMonitoring.pojo.BankCompany)
     */
    @Override
    public List<Terminal> listTerminalsByBankCompany(BankCompany bank) {
	return terminalDAO.listTerminalsByBankCompany(bank);
    }

    /**
     * @see com.ncr.ATMMonitoring.service.TerminalService#listTerminalsByBankCompanies(java.util.Set,
     *      java.lang.String, java.lang.String)
     */
    @Override
    public List<Terminal> listTerminalsByBankCompanies(Set<BankCompany> banks,
	    String sort, String order) {
	return terminalDAO.listTerminalsByBankCompanies(banks, sort, order,
		null);
    }

    /**
     * @see com.ncr.ATMMonitoring.service.TerminalService#listTerminals()
     */
    @Override
    public List<Terminal> listTerminals() {
	return terminalDAO.listTerminals();
    }

    /**
     * @see com.ncr.ATMMonitoring.service.TerminalService#getTerminal(java.lang.Integer)
     */
    @Override
    public Terminal getTerminal(Integer id) {
	return terminalDAO.getTerminal(id);
    }

    /**
     * @see TerminalService
     */
    @Override
    public List<Terminal> listTerminalsByIdsAndBankCompanies(
	    List<Integer> terminalIds, Set<BankCompany> bankCompanies) {
	return terminalDAO.listTerminalsByIdsAndBankCompanies(terminalIds,
		bankCompanies);
    }

    /**
     * @see com.ncr.ATMMonitoring.service.TerminalService#loadTerminalBySerialNumber(java.lang.String)
     */
    @Override
    public Terminal loadTerminalBySerialNumber(String serialNumber) {
	return terminalDAO.getTerminalBySerialNumber(serialNumber);
    }

    /**
     * @see com.ncr.ATMMonitoring.service.TerminalService#loadTerminalByMatricula(java.lang.Long)
     */
    @Override
    public Terminal loadTerminalByMatricula(Long matricula) {
	return terminalDAO.getTerminalByMatricula(matricula);
    }

    /**
     * @see com.ncr.ATMMonitoring.service.TerminalService#loadTerminalByIp(java.lang.String)
     */
    @Override
    public Terminal loadTerminalByIp(String ip) {
	return terminalDAO.getTerminalByIp(ip);
    }

    /**
     * @see com.ncr.ATMMonitoring.service.TerminalService#loadTerminalByMac(java.lang.String)
     */
    @Override
    public Terminal loadTerminalByMac(String mac) {
	return terminalDAO.getTerminalByMac(mac);
    }

    /**
     * @see com.ncr.ATMMonitoring.service.TerminalService#importJsonTerminal(org.springframework.web.multipart.commons.CommonsMultipartFile)
     */
    @Override
    public boolean importJsonTerminal(InputStream is) {
	try {
	    String json = IOUtils.toString(is, "ISO-8859-1");
	    ATMDataStorePojo data = ATMDataStorePojo.fromJson(json);
	    if (data == null) {
		logger.error("Invalid json file for importing terminal...");
		return false;
	    }
	    logger.debug("ATMDataStore read: " + data.toString());
	    persistDataStoreTerminal(data);
	} catch (Exception e) {
	    logger.error(
		    "Error while importing terminal from uploaded json file...",
		    e);
	    return false;
	}
	return true;
    }

    /**
     * Adds the entities related to a terminal from an agent's pojo data.
     * 
     * @param terminal
     *            the terminal
     * @param dataStoreTerminal
     *            the agent's pojo
     */
    private void addNewEntities(Terminal terminal,
	    ATMDataStorePojo dataStoreTerminal) {

	// a general date to create the auditables
	Date eventDate = new Date();

	TerminalModel model = getTerminalModel(dataStoreTerminal);
	if (model != null) {
	    terminal.setTerminalModel(model);
	    terminal.setTerminalVendor(model.getManufacturer());
	}
	terminal.updateHardwareDevices(getHwDevs(terminal, dataStoreTerminal,
		eventDate));
	terminal.updateHotfixes(getHotfixes(terminal, dataStoreTerminal,
		eventDate));
	terminal.updateFinancialDevices(getFinancialDevs(terminal,
		dataStoreTerminal, eventDate));

	Set<InternetExplorer> ies = getInternetExplorers(dataStoreTerminal);
	terminal.updateAuditableInternetExplorers(buildAuditableInternetExplorers(
		ies, eventDate));

	TerminalConfig newConfig = getTerminalConfig(dataStoreTerminal,
		terminal, eventDate);
	logger.debug("terminal config auditable sets:"
		+ newConfig.getAuditableOperatingSystems().size() + " -- "
		+ newConfig.getAuditableSoftware().size());
	terminal.setCurrentTerminalConfig(newConfig);
	logger.debug("Adding new Software Config to Terminal with IP "
		+ terminal.getIp());

	Set<SoftwareAggregate> swAggregates = getSwAggregates(dataStoreTerminal);
	terminal.updateAuditableSoftwareAggregates(buildAuditableSoftwareAggregate(
		swAggregates, eventDate));
    }

    /**
     * @see com.ncr.ATMMonitoring.service.TerminalService#persistDataStoreTerminal(com.ncr.agent.baseData.ATMDataStorePojo)
     */
    @Override
    public Terminal persistDataStoreTerminal(ATMDataStorePojo dataStoreTerminal) {
	Terminal terminal = null;
	try {
	    try {
		terminal = new Terminal(dataStoreTerminal);
	    } catch (NumberFormatException e) {
		logger.error("Couldn't parse generated id number...", e);
		throw e;
	    }
	    Terminal dbTerminal = terminalDAO.getTerminalByMatricula(terminal
		    .getMatricula());
	    if ((dbTerminal == null) && (terminal.getMatricula() != null)) {
		terminalDAO.addTerminal(terminal);
		logger.debug("Created Terminal from ATMDataStore with IP "
			+ terminal.getIp() + " and externally assigned id "
			+ terminal.getMatricula());
	    } else {
		if ((dbTerminal == null)
			&& (terminal.getSerialNumber() != null)
			&& (terminal.getSerialNumber().trim().length() > 0)) {
		    dbTerminal = terminalDAO.getTerminalBySerialNumber(terminal
			    .getSerialNumber());
		}
		if (dbTerminal == null) {
		    dbTerminal = terminalDAO
			    .getTerminalBySimilarity(dataStoreTerminal);
		}
		if (dbTerminal != null) {
		    dbTerminal.replaceTerminalDataWoVoidValues(terminal);
		    terminal = dbTerminal;
		    // terminalDAO.updateTerminal(terminal);
		    // logger.debug("Updated Terminal from ATMDataStore with IP "
		    // + terminal.getIp() + " and generated id "
		    // + terminal.getMatricula());
		} else {
		    terminalDAO.addTerminal(terminal);
		    logger.debug("Created Terminal from ATMDataStore with IP "
			    + terminal.getIp() + " and generated id "
			    + terminal.getMatricula());
		}
	    }
	    addNewEntities(terminal, dataStoreTerminal);
	    terminalDAO.updateTerminal(terminal);
	    logger.debug("Created all new devices and software for Terminal with IP "
		    + terminal.getIp()
		    + " and generated id "
		    + terminal.getMatricula());
	} catch (ATMWrongDataException e) {
	    logger.error(
		    "Couldn't persist ATM with IP "
			    + dataStoreTerminal.getCurrentip()
			    + "due to error: ", e);
	}
	return terminal;
    }

    /**
     * Gets the terminal model from an agent's pojo data.
     * 
     * @param dataStoreTerminal
     *            the agent's pojo
     * @return the terminal model
     */
    private TerminalModel getTerminalModel(ATMDataStorePojo dataStoreTerminal) {

	FinancialTerminalPojo ft = dataStoreTerminal.getFinancialTerminal();
	TerminalModel model = null;
	String productClass = ft.getProductclass();
	if ((productClass != null) && (productClass.length() > 0)
		&& (!productClass.equals("null"))) {
	    model = terminalModelService
		    .getTerminalModelByProductClass(productClass);
	    if (model == null) {
		logger.error("Couldn't find a TerminalModel with product class '"
			+ productClass + "'");
	    }
	}
	return model;
    }

    /**
     * Gets the sw aggregates from an agent's pojo data.
     * 
     * @param dataStoreTerminal
     *            the agent's pojo
     * @return the sw aggregates
     */
    private Set<SoftwareAggregate> getSwAggregates(
	    ATMDataStorePojo dataStoreTerminal) {
	Set<SoftwareAggregate> swAggregates = new HashSet<SoftwareAggregate>();
	Vector<FinancialPackagePojo> vector = dataStoreTerminal
		.getvFinancialPackage();
	if (vector != null) {
	    for (FinancialPackagePojo item : vector) {
		SoftwareAggregate swAggregate = new SoftwareAggregate(item);

		swAggregates.add(swAggregate);
	    }
	}
	return swAggregates;
    }

    /**
     * Gets the internet explorers from an agent's pojo data.
     * 
     * @param dataStoreTerminal
     *            the agent's pojo
     * @return the internet explorers
     */
    private Set<InternetExplorer> getInternetExplorers(
	    ATMDataStorePojo dataStoreTerminal) {
	Set<InternetExplorer> internetExplorers = new HashSet<InternetExplorer>();
	Vector<IExplorerPojo> vector = dataStoreTerminal.getvIExplorer();
	if (vector != null) {
	    for (IExplorerPojo item : vector) {
		InternetExplorer ie = new InternetExplorer(item);
		internetExplorers.add(ie);
	    }
	}
	return internetExplorers;
    }

    /**
     * Gets the software from an agent's pojo data.
     * 
     * @param dataStoreTerminal
     *            the agent's pojo
     * @return the software
     */
    private Set<Software> getSoftware(ATMDataStorePojo dataStoreTerminal,
	    Date event) {
	Set<Software> software = new HashSet<Software>();
	Vector<ProductPojo> vector = dataStoreTerminal.getvProduct();
	if (vector != null) {
	    for (ProductPojo item : vector) {
		Software sw = new Software(item);
		software.add(sw);

	    }
	}
	return software;
    }

    /**
     * Gets the operating systems from an agent's pojo data.
     * 
     * @param dataStoreTerminal
     *            the agent's pojo
     * @return the operating systems
     */
    private Set<OperatingSystem> getOperatingSystems(
	    ATMDataStorePojo dataStoreTerminal, Date event) {
	Set<OperatingSystem> oss = new HashSet<OperatingSystem>();
	Vector<OperatingSystemPojo> vector = dataStoreTerminal
		.getvOperatingSystem();
	if (vector != null) {
	    for (OperatingSystemPojo item : vector) {
		OperatingSystem os = new OperatingSystem(item);
		oss.add(os);
	    }
	}
	return oss;
    }

    /**
     * Assign an xfs component to its financial devices by their names.
     * 
     * @param xfs
     *            the xfs component
     * @param finDevs
     *            the financial devices we have
     * @param names
     *            the xfs' financial device names
     */
    private void assignXfsComponent(XfsComponent xfs,
	    Collection<FinancialDevice> finDevs, String[] names) {
	boolean found;
	for (String name : names) {
	    found = false;
	    for (FinancialDevice dev : finDevs) {
		if (name.equals(dev.getName()) || name.equals(dev.getCaption())) {
		    dev.getXfsComponents().add(xfs);
		    found = true;
		    break;
		}
	    }
	    if (!found) {
		logger.warn("Couldn't find financial device '" + name
			+ "' for xfs component '" + xfs.getXfsClass() + "'");
	    }
	}
    }

    /**
     * Assign an jxfs component to its financial devices by their names.
     * 
     * @param jxfs
     *            the jxfs component
     * @param finDevs
     *            the financial devices we have
     * @param names
     *            the jxfs' financial device names
     */
    private void assignJxfsComponent(JxfsComponent jxfs,
	    Collection<FinancialDevice> finDevs, String[] names) {
	boolean found;
	for (String name : names) {
	    found = false;
	    for (FinancialDevice dev : finDevs) {
		if (name.equals(dev.getName()) || name.equals(dev.getCaption())) {
		    dev.getJxfsComponents().add(jxfs);
		    found = true;
		    break;
		}
	    }
	    if (!found) {
		logger.warn("Couldn't find financial device '" + name
			+ "' for jxfs component '" + jxfs.getJxfsClass() + "'");
	    }
	}
    }

    /**
     * Gets the financial devs from an agent's pojo data. It also assigns the
     * passed terminal to them.
     * 
     * @param terminal
     *            the terminal
     * @param dataStoreTerminal
     *            the agent's pojo
     * @return the financial devs
     */
    private Set<FinancialDevice> getFinancialDevs(Terminal terminal,
	    ATMDataStorePojo dataStoreTerminal, Date event) {

	Set<FinancialDevice> finDevs = new HashSet<FinancialDevice>();
	Vector<FinancialDevicePojo> vector = dataStoreTerminal
		.getvFinancialDevice();
	// Create and assign xfs components
	if (vector != null) {
	    for (FinancialDevicePojo item : vector) {
		FinancialDevice finDev = new FinancialDevice(item);
		finDev.setTerminal(terminal);
		finDev.setStartDate(event);
		finDevs.add(finDev);
	    }
	}

	// Eva - Si el size es 0
	// - Creamos un Financial Device
	// - Cogemos la info de XFS y o JXFS (provider o algo así)
	// - Asignamos el dato al Financial Device en la posición correcta
	// - Recorridos todos los xfs y o jxfs, asignamos el FinancialDevice al
	// terminal
	if ((vector != null) && (vector.size() == 0)) {
	    // Eva
	    logger.warn("El vector no es nulo pero sí su tamaño");
	    FinancialDevicePojo fdp = null;
	    XfsComponent xfs = null;
	    JxfsComponent jxfs = null;

	    if (dataStoreTerminal.getvAlm() != null) {
		for (ALM xfsPojo : dataStoreTerminal.getvAlm()) {
		    fdp = new FinancialDevicePojo();
		    if (xfsPojo.getLogical().length() < 10)
			fdp.setName("Alarms_Device_" + xfsPojo.getLogical());
		    else
			fdp.setName(xfsPojo.getLogical());
		    fdp.setCaption("Alarms_Device_" + xfsPojo.getProvider());
		    fdp.setDescription("Alarms_Device_" + xfsPojo.getProvider());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    xfs = new XfsComponent(xfsPojo);
		    finDev.getXfsComponents().add(xfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo " + xfsPojo.getLogical());
		}
	    }

	    if (dataStoreTerminal.getvBcr() != null) {
		for (BCR xfsPojo : dataStoreTerminal.getvBcr()) {
		    fdp = new FinancialDevicePojo();
		    if (xfsPojo.getLogical().length() < 10)
			fdp.setName("BarcodeReader_Device_"
				+ xfsPojo.getLogical());
		    else
			fdp.setName(xfsPojo.getLogical());
		    fdp.setCaption("BarcodeReader_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDescription("BarcodeReader_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    xfs = new XfsComponent(xfsPojo);
		    finDev.getXfsComponents().add(xfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo " + xfsPojo.getLogical());
		}
	    }

	    if (dataStoreTerminal.getvCam() != null) {
		for (CAM xfsPojo : dataStoreTerminal.getvCam()) {
		    fdp = new FinancialDevicePojo();
		    if (xfsPojo.getLogical().length() < 10)
			fdp.setName("Camera_Device_" + xfsPojo.getLogical());
		    else
			fdp.setName(xfsPojo.getLogical());
		    fdp.setCaption("Camera_Device_" + xfsPojo.getProvider());
		    fdp.setDescription("Camera_Device_" + xfsPojo.getProvider());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    xfs = new XfsComponent(xfsPojo);
		    finDev.getXfsComponents().add(xfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo " + xfsPojo.getLogical());
		}
	    }

	    if (dataStoreTerminal.getvCdm() != null) {
		for (CDM xfsPojo : dataStoreTerminal.getvCdm()) {
		    fdp = new FinancialDevicePojo();
		    if (xfsPojo.getLogical().length() < 10)
			fdp.setName("CashDispenserModule_Device_"
				+ xfsPojo.getLogical());
		    else
			fdp.setName(xfsPojo.getLogical());
		    fdp.setCaption("CashDispenserModule_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDescription("CashDispenserModule_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    xfs = new XfsComponent(xfsPojo);
		    finDev.getXfsComponents().add(xfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo " + xfsPojo.getLogical());
		}
	    }

	    if (dataStoreTerminal.getvCeu() != null) {
		for (CEU xfsPojo : dataStoreTerminal.getvCeu()) {
		    fdp = new FinancialDevicePojo();
		    if (xfsPojo.getLogical().length() < 10)
			fdp.setName("CardEmbossingUnit_Device_"
				+ xfsPojo.getLogical());
		    else
			fdp.setName(xfsPojo.getLogical());
		    fdp.setCaption("CardEmbossingUnit_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDescription("CardEmbossingUnit_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    xfs = new XfsComponent(xfsPojo);
		    finDev.getXfsComponents().add(xfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo " + xfsPojo.getLogical());
		}
	    }

	    if (dataStoreTerminal.getvChk() != null) {
		for (CHK xfsPojo : dataStoreTerminal.getvChk()) {
		    fdp = new FinancialDevicePojo();
		    if (xfsPojo.getLogical().length() < 10)
			fdp.setName("CheckReader_Scanner_Device_"
				+ xfsPojo.getLogical());
		    else
			fdp.setName(xfsPojo.getLogical());
		    fdp.setCaption("CheckReader_Scanner_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDescription("CheckReader_Scanner_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    xfs = new XfsComponent(xfsPojo);
		    finDev.getXfsComponents().add(xfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo " + xfsPojo.getLogical());
		}
	    }

	    if (dataStoreTerminal.getvCim() != null) {
		for (CIM xfsPojo : dataStoreTerminal.getvCim()) {
		    fdp = new FinancialDevicePojo();
		    if (xfsPojo.getLogical().length() < 10)
			fdp.setName("CashInModule_Device_"
				+ xfsPojo.getLogical());
		    else
			fdp.setName(xfsPojo.getLogical());
		    fdp.setCaption("CashInModule_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDescription("CashInModule_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    xfs = new XfsComponent(xfsPojo);
		    finDev.getXfsComponents().add(xfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo " + xfsPojo.getLogical());
		}
	    }

	    if (dataStoreTerminal.getvCrd() != null) {
		for (CRD xfsPojo : dataStoreTerminal.getvCrd()) {
		    fdp = new FinancialDevicePojo();
		    if (xfsPojo.getLogical().length() < 10)
			fdp.setName("CardDispenser_Device_"
				+ xfsPojo.getLogical());
		    else
			fdp.setName(xfsPojo.getLogical());
		    fdp.setCaption("CardDispenser_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDescription("CardDispenser_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    xfs = new XfsComponent(xfsPojo);
		    finDev.getXfsComponents().add(xfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo " + xfsPojo.getLogical());
		}
	    }

	    if (dataStoreTerminal.getvDep() != null) {
		for (DEP xfsPojo : dataStoreTerminal.getvDep()) {
		    fdp = new FinancialDevicePojo();
		    if (xfsPojo.getLogical().length() < 10)
			fdp.setName("CardDispenser_Device_"
				+ xfsPojo.getLogical());
		    else
			fdp.setName(xfsPojo.getLogical());
		    fdp.setCaption("CardDispenser_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDescription("CardDispenser_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    xfs = new XfsComponent(xfsPojo);
		    finDev.getXfsComponents().add(xfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo " + xfsPojo.getLogical());
		}
	    }

	    if (dataStoreTerminal.getvIdc() != null) {
		for (IDC xfsPojo : dataStoreTerminal.getvIdc()) {
		    fdp = new FinancialDevicePojo();
		    if (xfsPojo.getLogical().length() < 10)
			fdp.setName("IdentificationCard_Device_"
				+ xfsPojo.getLogical());
		    else
			fdp.setName(xfsPojo.getLogical());
		    fdp.setCaption("IdentificationCard_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDescription("IdentificationCard_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    xfs = new XfsComponent(xfsPojo);
		    finDev.getXfsComponents().add(xfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo " + xfsPojo.getLogical());
		}
	    }

	    if (dataStoreTerminal.getvIpm() != null) {
		for (IPM xfsPojo : dataStoreTerminal.getvIpm()) {
		    fdp = new FinancialDevicePojo();
		    if (xfsPojo.getLogical().length() < 10)
			fdp.setName("ItemProcessingModule_Device_"
				+ xfsPojo.getLogical());
		    else
			fdp.setName(xfsPojo.getLogical());
		    fdp.setCaption("ItemProcessingModule_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDescription("ItemProcessingModule_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    xfs = new XfsComponent(xfsPojo);
		    finDev.getXfsComponents().add(xfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo " + xfsPojo.getLogical());
		}
	    }

	    if (dataStoreTerminal.getvPin() != null) {
		for (PIN xfsPojo : dataStoreTerminal.getvPin()) {
		    fdp = new FinancialDevicePojo();
		    if (xfsPojo.getLogical().length() < 10)
			fdp.setName("PinKeypad_Device_" + xfsPojo.getLogical());
		    else
			fdp.setName(xfsPojo.getLogical());
		    fdp.setCaption("PinKeypad_Device_" + xfsPojo.getProvider());
		    fdp.setDescription("PinKeypad_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    xfs = new XfsComponent(xfsPojo);
		    finDev.getXfsComponents().add(xfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo " + xfsPojo.getLogical());
		}
	    }

	    if (dataStoreTerminal.getvPtr() != null) {
		for (PTR xfsPojo : dataStoreTerminal.getvPtr()) {
		    fdp = new FinancialDevicePojo();
		    if (xfsPojo.getLogical().length() < 10)
			fdp.setName("PrinterAndScanning_Device_"
				+ xfsPojo.getLogical());
		    else
			fdp.setName(xfsPojo.getLogical());
		    fdp.setCaption("PrinterAndScanning_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDescription("PrinterAndScanning_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    xfs = new XfsComponent(xfsPojo);
		    finDev.getXfsComponents().add(xfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo " + xfsPojo.getLogical());
		}
	    }

	    if (dataStoreTerminal.getvSiu() != null) {
		for (SIU xfsPojo : dataStoreTerminal.getvSiu()) {
		    fdp = new FinancialDevicePojo();
		    if (xfsPojo.getLogical().length() < 10)
			fdp.setName("SensorsAndIndicators_Device_"
				+ xfsPojo.getLogical());
		    else
			fdp.setName(xfsPojo.getLogical());
		    fdp.setCaption("SensorsAndIndicators_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDescription("SensorsAndIndicators_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    xfs = new XfsComponent(xfsPojo);
		    finDev.getXfsComponents().add(xfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo " + xfsPojo.getLogical());
		}
	    }

	    if (dataStoreTerminal.getvTtu() != null) {
		for (TTU xfsPojo : dataStoreTerminal.getvTtu()) {
		    fdp = new FinancialDevicePojo();
		    if (xfsPojo.getLogical().length() < 10)
			fdp.setName("TextTerminalUnit_Device_"
				+ xfsPojo.getLogical());
		    else
			fdp.setName(xfsPojo.getLogical());
		    fdp.setCaption("TextTerminalUnit_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDescription("TextTerminalUnit_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    xfs = new XfsComponent(xfsPojo);
		    finDev.getXfsComponents().add(xfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo " + xfsPojo.getLogical());
		}
	    }

	    if (dataStoreTerminal.getvVdm() != null) {
		for (VDM xfsPojo : dataStoreTerminal.getvVdm()) {
		    fdp = new FinancialDevicePojo();
		    if (xfsPojo.getLogical().length() < 10)
			fdp.setName("VendorDependantModule_Device_"
				+ xfsPojo.getLogical());
		    else
			fdp.setName(xfsPojo.getLogical());
		    fdp.setCaption("VendorDependantModule_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDescription("VendorDependantModule_Device_"
			    + xfsPojo.getProvider());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    xfs = new XfsComponent(xfsPojo);
		    finDev.getXfsComponents().add(xfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo " + xfsPojo.getLogical());
		}
	    }

	    if (dataStoreTerminal.getVjAlm() != null) {
		for (CapabilitiesJxfsALMCollector jxfsPojo : dataStoreTerminal
			.getVjAlm()) {
		    fdp = new FinancialDevicePojo();

		    fdp.setName(jxfsPojo.getDevicecontrolname());
		    fdp.setCaption(jxfsPojo.getDevicecontrolname());
		    fdp.setDescription(jxfsPojo.getDevicecontrolname());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    jxfs = new JxfsComponent(jxfsPojo);
		    finDev.getJxfsComponents().add(jxfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo "
			    + jxfsPojo.getDevicecontrolname());
		}
	    }

	    if (dataStoreTerminal.getVjCam() != null) {
		for (CapabilitiesJxfsCAMCollector jxfsPojo : dataStoreTerminal
			.getVjCam()) {
		    fdp = new FinancialDevicePojo();

		    fdp.setName(jxfsPojo.getDevicecontrolname());
		    fdp.setCaption(jxfsPojo.getDevicecontrolname());
		    fdp.setDescription(jxfsPojo.getDevicecontrolname());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    jxfs = new JxfsComponent(jxfsPojo);
		    finDev.getJxfsComponents().add(jxfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo "
			    + jxfsPojo.getDevicecontrolname());
		}
	    }

	    if (dataStoreTerminal.getVjCdr() != null) {
		for (CapabilitiesJxfsCDRCollector jxfsPojo : dataStoreTerminal
			.getVjCdr()) {
		    fdp = new FinancialDevicePojo();

		    fdp.setName(jxfsPojo.getDevicecontrolname());
		    fdp.setCaption(jxfsPojo.getDevicecontrolname());
		    fdp.setDescription(jxfsPojo.getDevicecontrolname());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    jxfs = new JxfsComponent(jxfsPojo);
		    finDev.getJxfsComponents().add(jxfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo "
			    + jxfsPojo.getDevicecontrolname());
		}
	    }

	    if (dataStoreTerminal.getVjChk() != null) {
		for (CapabilitiesJxfsCHKCollector jxfsPojo : dataStoreTerminal
			.getVjChk()) {
		    fdp = new FinancialDevicePojo();

		    fdp.setName(jxfsPojo.getDevicecontrolname());
		    fdp.setCaption(jxfsPojo.getDevicecontrolname());
		    fdp.setDescription(jxfsPojo.getDevicecontrolname());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    jxfs = new JxfsComponent(jxfsPojo);
		    finDev.getJxfsComponents().add(jxfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo "
			    + jxfsPojo.getDevicecontrolname());
		}
	    }

	    if (dataStoreTerminal.getVjDep() != null) {
		for (CapabilitiesJxfsDEPCollector jxfsPojo : dataStoreTerminal
			.getVjDep()) {
		    fdp = new FinancialDevicePojo();

		    fdp.setName(jxfsPojo.getDevicecontrolname());
		    fdp.setCaption(jxfsPojo.getDevicecontrolname());
		    fdp.setDescription(jxfsPojo.getDevicecontrolname());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    jxfs = new JxfsComponent(jxfsPojo);
		    finDev.getJxfsComponents().add(jxfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo "
			    + jxfsPojo.getDevicecontrolname());
		}
	    }

	    if (dataStoreTerminal.getVjMsd() != null) {
		for (CapabilitiesJxfsMSDCollector jxfsPojo : dataStoreTerminal
			.getVjMsd()) {
		    fdp = new FinancialDevicePojo();

		    fdp.setName(jxfsPojo.getDevicecontrolname());
		    fdp.setCaption(jxfsPojo.getDevicecontrolname());
		    fdp.setDescription(jxfsPojo.getDevicecontrolname());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    jxfs = new JxfsComponent(jxfsPojo);
		    finDev.getJxfsComponents().add(jxfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo "
			    + jxfsPojo.getDevicecontrolname());
		}
	    }

	    if (dataStoreTerminal.getVjPin() != null) {
		for (CapabilitiesJxfsPINCollector jxfsPojo : dataStoreTerminal
			.getVjPin()) {
		    fdp = new FinancialDevicePojo();

		    fdp.setName(jxfsPojo.getDevicecontrolname());
		    fdp.setCaption(jxfsPojo.getDevicecontrolname());
		    fdp.setDescription(jxfsPojo.getDevicecontrolname());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    jxfs = new JxfsComponent(jxfsPojo);
		    finDev.getJxfsComponents().add(jxfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo "
			    + jxfsPojo.getDevicecontrolname());
		}
	    }

	    if (dataStoreTerminal.getVjPtr() != null) {
		for (CapabilitiesJxfsPTRCollector jxfsPojo : dataStoreTerminal
			.getVjPtr()) {
		    fdp = new FinancialDevicePojo();

		    fdp.setName(jxfsPojo.getDevicecontrolname());
		    fdp.setCaption(jxfsPojo.getDevicecontrolname());
		    fdp.setDescription(jxfsPojo.getDevicecontrolname());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    jxfs = new JxfsComponent(jxfsPojo);
		    finDev.getJxfsComponents().add(jxfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo "
			    + jxfsPojo.getDevicecontrolname());
		}
	    }

	    if (dataStoreTerminal.getVjScn() != null) {
		for (CapabilitiesJxfsSCNCollector jxfsPojo : dataStoreTerminal
			.getVjScn()) {
		    fdp = new FinancialDevicePojo();

		    fdp.setName(jxfsPojo.getDevicecontrolname());
		    fdp.setCaption(jxfsPojo.getDevicecontrolname());
		    fdp.setDescription(jxfsPojo.getDevicecontrolname());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    jxfs = new JxfsComponent(jxfsPojo);
		    finDev.getJxfsComponents().add(jxfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo "
			    + jxfsPojo.getDevicecontrolname());
		}
	    }

	    if (dataStoreTerminal.getVjSiu() != null) {
		for (CapabilitiesJxfsSIUCollector jxfsPojo : dataStoreTerminal
			.getVjSiu()) {
		    fdp = new FinancialDevicePojo();

		    fdp.setName(jxfsPojo.getDevicecontrolname());
		    fdp.setCaption(jxfsPojo.getDevicecontrolname());
		    fdp.setDescription(jxfsPojo.getDevicecontrolname());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    jxfs = new JxfsComponent(jxfsPojo);
		    finDev.getJxfsComponents().add(jxfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo "
			    + jxfsPojo.getDevicecontrolname());
		}
	    }

	    if (dataStoreTerminal.getVjTio() != null) {
		for (CapabilitiesJxfsTIOCollector jxfsPojo : dataStoreTerminal
			.getVjTio()) {
		    fdp = new FinancialDevicePojo();

		    fdp.setName(jxfsPojo.getDevicecontrolname());
		    fdp.setCaption(jxfsPojo.getDevicecontrolname());
		    fdp.setDescription(jxfsPojo.getDevicecontrolname());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    jxfs = new JxfsComponent(jxfsPojo);
		    finDev.getJxfsComponents().add(jxfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo "
			    + jxfsPojo.getDevicecontrolname());
		}
	    }

	    if (dataStoreTerminal.getVjVdm() != null) {
		for (CapabilitiesJxfsVDMCollector jxfsPojo : dataStoreTerminal
			.getVjVdm()) {
		    fdp = new FinancialDevicePojo();

		    fdp.setName(jxfsPojo.getDevicecontrolname());
		    fdp.setCaption(jxfsPojo.getDevicecontrolname());
		    fdp.setDescription(jxfsPojo.getDevicecontrolname());
		    fdp.setDeviceinstance("0");
		    fdp.setDevicestatus("0");
		    fdp.setFirmwareversion("xxxx");
		    fdp.setHotswappable(" ");
		    fdp.setManufacturer(" ");
		    fdp.setModel(" ");
		    fdp.setPmstatus("0");
		    fdp.setRemovable(" ");
		    fdp.setReplaceable(" ");
		    fdp.setSerialnumber("xxxxxxxx");
		    fdp.setUniversalid(" ");
		    fdp.setVariant(" ");
		    fdp.setVersion(" ");

		    FinancialDevice finDev = new FinancialDevice(fdp);
		    finDev.setTerminal(terminal);
		    jxfs = new JxfsComponent(jxfsPojo);
		    finDev.getJxfsComponents().add(jxfs);

		    finDevs.add(finDev);

		    logger.warn("Añadido dispositivo "
			    + jxfsPojo.getDevicecontrolname());
		}
	    }
	} else {

	    if (dataStoreTerminal.getvAlm() != null) {
		for (ALM xfsPojo : dataStoreTerminal.getvAlm()) {
		    XfsComponent xfs = new XfsComponent(xfsPojo);
		    if (xfsPojo.getDevicename() != null) {
			assignXfsComponent(xfs, finDevs, xfsPojo
				.getDevicename().split(","));
		    } else {
			logger.warn("Xfs component of type '"
				+ xfs.getXfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getvBcr() != null) {
		for (BCR xfsPojo : dataStoreTerminal.getvBcr()) {
		    XfsComponent xfs = new XfsComponent(xfsPojo);
		    if (xfsPojo.getDevicename() != null) {
			assignXfsComponent(xfs, finDevs, xfsPojo
				.getDevicename().split(","));
		    } else {
			logger.warn("Xfs component of type '"
				+ xfs.getXfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getvCam() != null) {
		for (CAM xfsPojo : dataStoreTerminal.getvCam()) {
		    XfsComponent xfs = new XfsComponent(xfsPojo);
		    if (xfsPojo.getDevicename() != null) {
			assignXfsComponent(xfs, finDevs, xfsPojo
				.getDevicename().split(","));
		    } else {
			logger.warn("Xfs component of type '"
				+ xfs.getXfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getvCdm() != null) {
		for (CDM xfsPojo : dataStoreTerminal.getvCdm()) {
		    XfsComponent xfs = new XfsComponent(xfsPojo);
		    if (xfsPojo.getDevicename() != null) {
			assignXfsComponent(xfs, finDevs, xfsPojo
				.getDevicename().split(","));
		    } else {
			logger.warn("Xfs component of type '"
				+ xfs.getXfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getvCeu() != null) {
		for (CEU xfsPojo : dataStoreTerminal.getvCeu()) {
		    XfsComponent xfs = new XfsComponent(xfsPojo);
		    if (xfsPojo.getDevicename() != null) {
			assignXfsComponent(xfs, finDevs, xfsPojo
				.getDevicename().split(","));
		    } else {
			logger.warn("Xfs component of type '"
				+ xfs.getXfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getvChk() != null) {
		for (CHK xfsPojo : dataStoreTerminal.getvChk()) {
		    XfsComponent xfs = new XfsComponent(xfsPojo);
		    if (xfsPojo.getDevicename() != null) {
			assignXfsComponent(xfs, finDevs, xfsPojo
				.getDevicename().split(","));
		    } else {
			logger.warn("Xfs component of type '"
				+ xfs.getXfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getvCim() != null) {
		for (CIM xfsPojo : dataStoreTerminal.getvCim()) {
		    XfsComponent xfs = new XfsComponent(xfsPojo);
		    if (xfsPojo.getDevicename() != null) {
			assignXfsComponent(xfs, finDevs, xfsPojo
				.getDevicename().split(","));
		    } else {
			logger.warn("Xfs component of type '"
				+ xfs.getXfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getvCrd() != null) {
		for (CRD xfsPojo : dataStoreTerminal.getvCrd()) {
		    XfsComponent xfs = new XfsComponent(xfsPojo);
		    if (xfsPojo.getDevicename() != null) {
			assignXfsComponent(xfs, finDevs, xfsPojo
				.getDevicename().split(","));
		    } else {
			logger.warn("Xfs component of type '"
				+ xfs.getXfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getvDep() != null) {
		for (DEP xfsPojo : dataStoreTerminal.getvDep()) {
		    XfsComponent xfs = new XfsComponent(xfsPojo);
		    if (xfsPojo.getDevicename() != null) {
			assignXfsComponent(xfs, finDevs, xfsPojo
				.getDevicename().split(","));
		    } else {
			logger.warn("Xfs component of type '"
				+ xfs.getXfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getvIdc() != null) {
		for (IDC xfsPojo : dataStoreTerminal.getvIdc()) {
		    XfsComponent xfs = new XfsComponent(xfsPojo);
		    if (xfsPojo.getDevicename() != null) {
			assignXfsComponent(xfs, finDevs, xfsPojo
				.getDevicename().split(","));
		    } else {
			logger.warn("Xfs component of type '"
				+ xfs.getXfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getvIpm() != null) {
		for (IPM xfsPojo : dataStoreTerminal.getvIpm()) {
		    XfsComponent xfs = new XfsComponent(xfsPojo);
		    if (xfsPojo.getDevicename() != null) {
			assignXfsComponent(xfs, finDevs, xfsPojo
				.getDevicename().split(","));
		    } else {
			logger.warn("Xfs component of type '"
				+ xfs.getXfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getvPin() != null) {
		for (PIN xfsPojo : dataStoreTerminal.getvPin()) {
		    XfsComponent xfs = new XfsComponent(xfsPojo);
		    if (xfsPojo.getDevicename() != null) {
			assignXfsComponent(xfs, finDevs, xfsPojo
				.getDevicename().split(","));
		    } else {
			logger.warn("Xfs component of type '"
				+ xfs.getXfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getvPtr() != null) {
		for (PTR xfsPojo : dataStoreTerminal.getvPtr()) {
		    XfsComponent xfs = new XfsComponent(xfsPojo);
		    if (xfsPojo.getDevicename() != null) {
			assignXfsComponent(xfs, finDevs, xfsPojo
				.getDevicename().split(","));
		    } else {
			logger.warn("Xfs component of type '"
				+ xfs.getXfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getvSiu() != null) {
		for (SIU xfsPojo : dataStoreTerminal.getvSiu()) {
		    XfsComponent xfs = new XfsComponent(xfsPojo);
		    if (xfsPojo.getDevicename() != null) {
			assignXfsComponent(xfs, finDevs, xfsPojo
				.getDevicename().split(","));
		    } else {
			logger.warn("Xfs component of type '"
				+ xfs.getXfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getvTtu() != null) {
		for (TTU xfsPojo : dataStoreTerminal.getvTtu()) {
		    XfsComponent xfs = new XfsComponent(xfsPojo);
		    if (xfsPojo.getDevicename() != null) {
			assignXfsComponent(xfs, finDevs, xfsPojo
				.getDevicename().split(","));
		    } else {
			logger.warn("Xfs component of type '"
				+ xfs.getXfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getvVdm() != null) {
		for (VDM xfsPojo : dataStoreTerminal.getvVdm()) {
		    XfsComponent xfs = new XfsComponent(xfsPojo);
		    if (xfsPojo.getDevicename() != null) {
			assignXfsComponent(xfs, finDevs, xfsPojo
				.getDevicename().split(","));
		    } else {
			logger.warn("Xfs component of type '"
				+ xfs.getXfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }

	    // Create and assign jxfs components
	    if (dataStoreTerminal.getVjAlm() != null) {
		for (CapabilitiesJxfsALMCollector jxfsPojo : dataStoreTerminal
			.getVjAlm()) {
		    JxfsComponent jxfs = new JxfsComponent(jxfsPojo);
		    String[] devs = jxfsPojo.getVendorinfo();
		    if ((devs != null) && (devs.length > 0)) {
			assignJxfsComponent(jxfs, finDevs, devs);
		    } else {
			logger.warn("Jxfs component of type '"
				+ jxfs.getJxfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getVjCam() != null) {
		for (CapabilitiesJxfsCAMCollector jxfsPojo : dataStoreTerminal
			.getVjCam()) {
		    JxfsComponent jxfs = new JxfsComponent(jxfsPojo);
		    String[] devs = jxfsPojo.getVendorinfo();
		    if ((devs != null) && (devs.length > 0)) {
			assignJxfsComponent(jxfs, finDevs, devs);
		    } else {
			logger.warn("Jxfs component of type '"
				+ jxfs.getJxfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getVjCdr() != null) {
		for (CapabilitiesJxfsCDRCollector jxfsPojo : dataStoreTerminal
			.getVjCdr()) {
		    JxfsComponent jxfs = new JxfsComponent(jxfsPojo);
		    String[] devs = jxfsPojo.getVendorinfo();
		    if ((devs != null) && (devs.length > 0)) {
			assignJxfsComponent(jxfs, finDevs, devs);
		    } else {
			logger.warn("Jxfs component of type '"
				+ jxfs.getJxfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getVjChk() != null) {
		for (CapabilitiesJxfsCHKCollector jxfsPojo : dataStoreTerminal
			.getVjChk()) {
		    JxfsComponent jxfs = new JxfsComponent(jxfsPojo);
		    String[] devs = jxfsPojo.getVendorinfo();
		    if ((devs != null) && (devs.length > 0)) {
			assignJxfsComponent(jxfs, finDevs, devs);
		    } else {
			logger.warn("Jxfs component of type '"
				+ jxfs.getJxfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getVjDep() != null) {
		for (CapabilitiesJxfsDEPCollector jxfsPojo : dataStoreTerminal
			.getVjDep()) {
		    JxfsComponent jxfs = new JxfsComponent(jxfsPojo);
		    String[] devs = jxfsPojo.getVendorinfo();
		    if ((devs != null) && (devs.length > 0)) {
			assignJxfsComponent(jxfs, finDevs, devs);
		    } else {
			logger.warn("Jxfs component of type '"
				+ jxfs.getJxfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getVjMsd() != null) {
		for (CapabilitiesJxfsMSDCollector jxfsPojo : dataStoreTerminal
			.getVjMsd()) {
		    JxfsComponent jxfs = new JxfsComponent(jxfsPojo);
		    String[] devs = jxfsPojo.getVendorinfo();
		    if ((devs != null) && (devs.length > 0)) {
			assignJxfsComponent(jxfs, finDevs, devs);
		    } else {
			logger.warn("Jxfs component of type '"
				+ jxfs.getJxfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getVjPin() != null) {
		for (CapabilitiesJxfsPINCollector jxfsPojo : dataStoreTerminal
			.getVjPin()) {
		    JxfsComponent jxfs = new JxfsComponent(jxfsPojo);
		    String[] devs = jxfsPojo.getVendorinfo();
		    if ((devs != null) && (devs.length > 0)) {
			assignJxfsComponent(jxfs, finDevs, devs);
		    } else {
			logger.warn("Jxfs component of type '"
				+ jxfs.getJxfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getVjPtr() != null) {
		for (CapabilitiesJxfsPTRCollector jxfsPojo : dataStoreTerminal
			.getVjPtr()) {
		    JxfsComponent jxfs = new JxfsComponent(jxfsPojo);
		    String[] devs = jxfsPojo.getVendorinfo();
		    if ((devs != null) && (devs.length > 0)) {
			assignJxfsComponent(jxfs, finDevs, devs);
		    } else {
			logger.warn("Jxfs component of type '"
				+ jxfs.getJxfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getVjScn() != null) {
		for (CapabilitiesJxfsSCNCollector jxfsPojo : dataStoreTerminal
			.getVjScn()) {
		    JxfsComponent jxfs = new JxfsComponent(jxfsPojo);
		    String[] devs = jxfsPojo.getVendorinfo();
		    if ((devs != null) && (devs.length > 0)) {
			assignJxfsComponent(jxfs, finDevs, devs);
		    } else {
			logger.warn("Jxfs component of type '"
				+ jxfs.getJxfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getVjSiu() != null) {
		for (CapabilitiesJxfsSIUCollector jxfsPojo : dataStoreTerminal
			.getVjSiu()) {
		    JxfsComponent jxfs = new JxfsComponent(jxfsPojo);
		    String[] devs = jxfsPojo.getVendorinfo();
		    if ((devs != null) && (devs.length > 0)) {
			assignJxfsComponent(jxfs, finDevs, devs);
		    } else {
			logger.warn("Jxfs component of type '"
				+ jxfs.getJxfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getVjTio() != null) {
		for (CapabilitiesJxfsTIOCollector jxfsPojo : dataStoreTerminal
			.getVjTio()) {
		    JxfsComponent jxfs = new JxfsComponent(jxfsPojo);
		    String[] devs = jxfsPojo.getVendorinfo();
		    if ((devs != null) && (devs.length > 0)) {
			assignJxfsComponent(jxfs, finDevs, devs);
		    } else {
			logger.warn("Jxfs component of type '"
				+ jxfs.getJxfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	    if (dataStoreTerminal.getVjVdm() != null) {
		for (CapabilitiesJxfsVDMCollector jxfsPojo : dataStoreTerminal
			.getVjVdm()) {
		    JxfsComponent jxfs = new JxfsComponent(jxfsPojo);
		    String[] devs = jxfsPojo.getVendorinfo();
		    if ((devs != null) && (devs.length > 0)) {
			assignJxfsComponent(jxfs, finDevs, devs);
		    } else {
			logger.warn("Jxfs component of type '"
				+ jxfs.getJxfsClass()
				+ "' won't be saved because it has no financial device info!!");
		    }
		}
	    }
	}
	return finDevs;
    }

    /**
     * Gets the hotfixes from an agent's pojo data. It also assigns the passed
     * terminal to them.
     * 
     * @param terminal
     *            the terminal
     * @param dataStoreTerminal
     *            the agent's pojo
     * @return the hotfixes
     */
    private Set<Hotfix> getHotfixes(Terminal terminal,
	    ATMDataStorePojo dataStoreTerminal, Date event) {
	Set<Hotfix> hotfixes = new HashSet<Hotfix>();
	Vector<HotfixPojo> vector = dataStoreTerminal.getvHotfix();
	if (vector != null) {
	    for (HotfixPojo item : vector) {
		Hotfix hotfix = new Hotfix(item);
		hotfix.setTerminal(terminal);
		hotfix.setStartDate(event);
		hotfixes.add(hotfix);
	    }
	}
	return hotfixes;
    }

    /**
     * Gets the hardware devices from an agent's pojo data. It also assigns the
     * passed terminal to them.
     * 
     * @param terminal
     *            the terminal
     * @param dataStoreTerminal
     *            the agent's pojo
     * @return the hardware devices
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private Set<HardwareDevice> getHwDevs(Terminal terminal,
	    ATMDataStorePojo dataStoreTerminal, Date event) {

	Set<HardwareDevice> hwDevs = new HashSet<HardwareDevice>();
	Vector vector = dataStoreTerminal.getV1394Controller();
	if (vector != null) {
	    for (_1394ControllerPojo item : (Vector<_1394ControllerPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDev.setStartDate(event);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvBaseBoard();
	if (vector != null) {
	    for (BaseBoardPojo item : (Vector<BaseBoardPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDev.setStartDate(event);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvBios();
	if (vector != null) {
	    for (BiosPojo item : (Vector<BiosPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDev.setStartDate(event);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvCDROMDrive();
	if (vector != null) {
	    for (CDROMDrivePojo item : (Vector<CDROMDrivePojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDev.setStartDate(event);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvComputerSystem();
	if (vector != null) {
	    for (ComputerSystemPojo item : (Vector<ComputerSystemPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDev.setStartDate(event);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvDesktopMonitor();
	if (vector != null) {
	    for (DesktopMonitorPojo item : (Vector<DesktopMonitorPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDev.setStartDate(event);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvDiskDrive();
	if (vector != null) {
	    for (DiskDrivePojo item : (Vector<DiskDrivePojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDev.setStartDate(event);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvFloppyDrive();
	if (vector != null) {
	    for (FloppyDrivePojo item : (Vector<FloppyDrivePojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDev.setStartDate(event);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvKeyboard();
	if (vector != null) {
	    for (KeyboardPojo item : (Vector<KeyboardPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDev.setStartDate(event);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvLogicalDisk();
	if (vector != null) {
	    for (LogicalDiskPojo item : (Vector<LogicalDiskPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDev.setStartDate(event);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvNetworkAdapterSetting();
	if (vector != null) {
	    for (NetworkAdapterSettingPojo item : (Vector<NetworkAdapterSettingPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDev.setStartDate(event);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvParallelPort();
	if (vector != null) {
	    for (ParallelPortPojo item : (Vector<ParallelPortPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDev.setStartDate(event);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvPhysicalMemory();
	if (vector != null) {
	    for (PhysicalMemoryPojo item : (Vector<PhysicalMemoryPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDev.setStartDate(event);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvPointingDevice();
	if (vector != null) {
	    for (PointingDevicePojo item : (Vector<PointingDevicePojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDev.setStartDate(event);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvProcessor();
	if (vector != null) {
	    for (ProcessorPojo item : (Vector<ProcessorPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDev.setStartDate(event);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvSCSIController();
	if (vector != null) {
	    for (SCSIControllerPojo item : (Vector<SCSIControllerPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDev.setStartDate(event);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvSerialPort();
	if (vector != null) {
	    for (SerialPortPojo item : (Vector<SerialPortPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDev.setStartDate(event);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvSoundDevice();
	if (vector != null) {
	    for (SoundDevicePojo item : (Vector<SoundDevicePojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDev.setStartDate(event);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvSystemSlot();
	if (vector != null) {
	    for (SystemSlotPojo item : (Vector<SystemSlotPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDev.setStartDate(event);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvUSBController();
	if (vector != null) {
	    for (USBControllerPojo item : (Vector<USBControllerPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDev.setStartDate(event);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvUSBHub();
	if (vector != null) {
	    for (UsbHubPojo item : (Vector<UsbHubPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDev.setStartDate(event);
		hwDevs.add(hwDev);
	    }
	}
	vector = dataStoreTerminal.getvVideoController();
	if (vector != null) {
	    for (VideoControllerPojo item : (Vector<VideoControllerPojo>) vector) {
		HardwareDevice hwDev = new HardwareDevice(item);
		hwDev.setTerminal(terminal);
		hwDev.setStartDate(event);
		hwDevs.add(hwDev);
	    }
	}
	return hwDevs;
    }

    /**
     * Build terminal config from a data store pojo
     * 
     * @param dataStoreTerminal
     *            The data store pojo
     * @param terminal
     * @return The terminal config
     */
    private TerminalConfig getTerminalConfig(
	    ATMDataStorePojo dataStoreTerminal, Terminal terminal, Date event) {

	TerminalConfig newConfig = new TerminalConfig();
	newConfig.setTerminal(terminal);
	Set<Software> sws = getSoftware(dataStoreTerminal, event);
	Set<OperatingSystem> oss = getOperatingSystems(dataStoreTerminal, event);

	Set<AuditableSoftware> auditableSW = this.buildAuditableSoftware(
		terminal, sws, event);
	Set<AuditableOperatingSystem> auditableOperatingSystems = this
		.buildAuditableOperativeSystems(terminal, oss, event);

	newConfig.setSoftware(sws);
	newConfig.setOperatingSystems(oss);
	newConfig.setDateCreated(event);
	newConfig.setAuditableOperatingSystems(auditableOperatingSystems);
	newConfig.setAuditableSoftware(auditableSW);
	return newConfig;
    }

    /**
     * Build terminal internet explorers from a data store pojo
     * 
     * @param dataStoreTerminal
     *            The data store pojo
     * @return The auditable internet explorer
     */
    private Set<AuditableInternetExplorer> buildAuditableInternetExplorers(
	    Set<InternetExplorer> ies, Date event) {
	Set<AuditableInternetExplorer> iesAux = new HashSet<AuditableInternetExplorer>();
	for (InternetExplorer ie : ies) {
	    InternetExplorer storedIE = internetExplorerService
		    .getInternetExplorerByVersion(ie.getMajorVersion(),
			    ie.getMinorVersion(), ie.getBuildVersion(),
			    ie.getRevisionVersion(), ie.getRemainingVersion());

	    AuditableInternetExplorer auditableIE = new AuditableInternetExplorer(
		    storedIE != null ? storedIE : ie);
	    auditableIE.setStartDate(event);
	    iesAux.add(auditableIE);
	}

	return iesAux;
    }

    /**
     * Build auditables software aggregates from a data store pojo
     * 
     * @param dataStoreTerminal
     *            The data store pojo
     * @return The auditable terminal configs
     */
    private Set<AuditableSoftwareAggregate> buildAuditableSoftwareAggregate(
	    Set<SoftwareAggregate> swAggregates, Date event) {
	Set<AuditableSoftwareAggregate> swAggregatesAux = new HashSet<AuditableSoftwareAggregate>();
	for (SoftwareAggregate swAggregate : swAggregates) {
	    SoftwareAggregate swAggregateAux = softwareAggregateService
		    .getSoftwareAggregateByVersionName(
			    swAggregate.getMajorVersion(),
			    swAggregate.getMinorVersion(),
			    swAggregate.getBuildVersion(),
			    swAggregate.getRevisionVersion(),
			    swAggregate.getRemainingVersion(),
			    swAggregate.getName());

	    AuditableSoftwareAggregate auditableSwAggregate = new AuditableSoftwareAggregate(
		    swAggregateAux != null ? swAggregateAux : swAggregate);
	    auditableSwAggregate.setStartDate(event);
	    swAggregatesAux.add(auditableSwAggregate);
	}

	return swAggregatesAux;
    }

    /**
     * Build auditables software
     * 
     * @param Set
     *            <Software> swSet the software set
     * @param event
     *            date when the software is being added
     * @return The auditable AuditableSoftware
     */
    private Set<AuditableSoftware> buildAuditableSoftware(Terminal terminal,
	    Set<Software> swSet, Date event) {
	Set<AuditableSoftware> swAuditableSet = new HashSet<AuditableSoftware>();
	for (Software sw : swSet) {
	    Software swAux = this.terminalHasSoftwareInstalled(sw, terminal);
	    if (swAux == null) {

		AuditableSoftware auditableSw = new AuditableSoftware(sw);
		auditableSw.setStartDate(event);
		swAuditableSet.add(auditableSw);
	    }
	}

	return swAuditableSet;
    }

    private Software terminalHasSoftwareInstalled(Software newSoftware,
	    Terminal terminal) {
	TerminalConfig activeConfig = terminal.getCurrentTerminalConfig();
	Software installedInTerminal = null;

	if (activeConfig != null) {
	    logger.debug("active config is not null");
	    Set<Software> actualInstalledSoftware = activeConfig.getSoftware();

	    for (Software installedSoftware : actualInstalledSoftware) {
		if (newSoftware.equals(installedSoftware)) {
		    logger.debug("software is installed:"
			    + installedSoftware.getCaption());
		    installedInTerminal = installedSoftware;
		    break;
		}
	    }

	}

	return installedInTerminal;
    }

    private Set<AuditableOperatingSystem> buildAuditableOperativeSystems(
	    Terminal terminal, Set<OperatingSystem> osSet, Date event) {
	Set<AuditableOperatingSystem> osAuditableAux = new HashSet<AuditableOperatingSystem>();
	for (OperatingSystem os : osSet) {
	    OperatingSystem osAux = terminalHasOSInstalled(os, terminal);

	    if (osAux == null) {
		AuditableOperatingSystem auditableOS = new AuditableOperatingSystem(
			osAux != null ? osAux : os);
		auditableOS.setStartDate(event);
		osAuditableAux.add(auditableOS);
	    }

	}

	return osAuditableAux;
    }

    private OperatingSystem terminalHasOSInstalled(OperatingSystem newOS,
	    Terminal terminal) {
	TerminalConfig activeConfig = terminal.getCurrentTerminalConfig();
	OperatingSystem installedOS = null;

	if (activeConfig != null) {

	    Set<OperatingSystem> actualInstalledOS = activeConfig
		    .getOperatingSystems();

	    for (OperatingSystem terminalOS : actualInstalledOS) {
		if (newOS.equals(terminalOS)) {
		    installedOS = terminalOS;
		    break;
		}
	    }

	}

	return installedOS;
    }

    /**
     * @see TerminalService
     */
    public void addInstallationAndUpdateHistoricalData(Terminal terminal,
	    Installation installation) {
	terminal.setCurrentInstallation(installation);
	updateTerminal(terminal);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.service.TerminalService#checkDateLicense ()
     */
    @Override
    public void checkDateLicense() {
	try {
	    if ((licenseKey == null) || (licenseKey.length() != 16)) {
		logger.fatal("The configured license key isn't correct."
			+ " Deleting DB. Please contact the support team.");
		terminalDAO.deleteAllTerminalData();
	    } else {
		if ((dateLimit == null) || (dateLimit.length() < 1)) {
		    logger.fatal("The configured limit date key isn't correct."
			    + " Deleting DB. Please contact the support team.");
		    terminalDAO.deleteAllTerminalData();
		} else {
		    String dateLimitString = Utils.decrypt(licenseKey,
			    this.dateLimit);
		    Date dateLimit = new SimpleDateFormat("yyyy-MM-dd hh:mm")
			    .parse(dateLimitString);
		    if ((dateLimit.compareTo(Utils.NO_DATE_LIMIT) != 0)
			    && (new Date().compareTo(dateLimit) >= 0)) {
			logger.fatal("Trial time has expired. Deleting DB.");
			terminalDAO.deleteAllTerminalData();
		    }
		}
	    }
	} catch (GeneralSecurityException e) {
	    logger.fatal(
		    "There was some problem while checking your license key."
			    + " Deleting DB. Please contact the support team.",
		    e);
	    terminalDAO.deleteAllTerminalData();
	} catch (ParseException e) {
	    logger.fatal("The configured limit date key isn't correct."
		    + " Deleting DB. Please contact the support team.", e);
	    terminalDAO.deleteAllTerminalData();
	} catch (ArrayIndexOutOfBoundsException e) {
	    logger.fatal("The configured limit date key isn't correct."
		    + " Deleting DB. Please contact the support team.", e);
	    terminalDAO.deleteAllTerminalData();
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.TerminalService#deleteTerminal(java.lang
     * .Integer)
     */
    @Override
    public void deleteTerminal(Integer id) {
	this.terminalDAO.deleteTerminal(id);

    }
}