package com.ncr.ATMMonitoring.pojo;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;

import com.ncr.ATMMonitoring.service.AuditableSetOperations;
import com.ncr.ATMMonitoring.service.AuditableSetOperationsImpl;
import com.ncr.ATMMonitoring.socket.ATMWrongDataException;
import com.ncr.ATMMonitoring.utils.Operation;
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
 * The Terminal Pojo.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "terminals")
public class Terminal {

    /** The logger. */
    static private Logger logger = Logger.getLogger(Terminal.class.getName());

    /** The comboboxes data related to this entity for the query designer. */
    private static final Map<String, Map> comboboxes;

    @Transient
    private AuditableSetOperations auditableSetOperations = new AuditableSetOperationsImpl();

    static {
	comboboxes = new TreeMap<String, Map>();
	Map<String, Map> operations = Operation
		.getOperationsByType(Operation.DataType.STRING);
	comboboxes.put("terminalType", operations);
	comboboxes.put("terminalVendor", operations);
	comboboxes.put("frontReplenish",
		Operation.getOperationsByType(Operation.DataType.BOOLEAN));
	comboboxes.put("geographicAddress", operations);
	comboboxes.put("branch", operations);
	comboboxes.put("bank", operations);
	comboboxes.put("manufacturingSite", operations);
	comboboxes.put("productClassDescription", operations);
	comboboxes.put("serialNumber", operations);
	comboboxes.put("tracerNumber", operations);
	comboboxes.put("ip", operations);
	comboboxes.put("mac", operations);
    }

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "terminals_id_seq")
    @SequenceGenerator(name = "terminals_id_seq", sequenceName = "terminals_id_seq", allocationSize = 1)
    private Integer id;

    @OneToMany(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @OrderBy("start_date desc")
    private Set<Installation> installations = new HashSet<Installation>();;

    /** The bank company. */
    @ManyToOne
    @JoinColumn(name = "bank_id")
    private BankCompany bankCompany;

    /** The terminal model. */
    @ManyToOne
    @JoinColumn(name = "terminal_model_id")
    private TerminalModel terminalModel;

    /** The terminal type. */
    @Column(name = "terminal_type")
    @Type(type = "text")
    private String terminalType;

    /** The terminal vendor. */
    @Column(name = "terminal_vendor")
    @Type(type = "text")
    private String terminalVendor;

    /** The front replenish. */
    @Column(name = "front_replenish")
    private Boolean frontReplenish;

    /** The geographic address. */
    @Column(name = "geographic_address")
    @Type(type = "text")
    private String geographicAddress;

    /** The branch. */
    @Column(name = "branch")
    @Type(type = "text")
    private String branch;

    /** The bank. */
    @Column(name = "bank")
    @Type(type = "text")
    private String bank;

    /** The manufacturing site. */
    @Column(name = "manufacturing_site")
    @Type(type = "text")
    private String manufacturingSite;

    /** The product class description. */
    @Column(name = "product_class_description")
    @Type(type = "text")
    private String productClassDescription;

    /** The serial number. */
    @Column(name = "serial_number")
    @Type(type = "text")
    private String serialNumber;

    /** The tracer number. */
    @Column(name = "tracer_number")
    @Type(type = "text")
    private String tracerNumber;

    /** The generated id. */
    @Column(name = "matricula", nullable = false)
    private Long matricula;

    /** The configs. */
    @OneToMany(mappedBy = "terminal", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @OrderBy("start_date desc")
    private Set<TerminalConfig> configs = new HashSet<TerminalConfig>();

    /** The financial devices. */
    @OneToMany(mappedBy = "terminal", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @OrderBy("serial_number")
    private Set<FinancialDevice> financialDevices = new HashSet<FinancialDevice>();

    /** The hardware devices. */
    @OneToMany(mappedBy = "terminal", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @OrderBy("hardware_class")
    private Set<HardwareDevice> hardwareDevices = new HashSet<HardwareDevice>();

    /** The hotfixes. */
    @OneToMany(mappedBy = "terminal", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @OrderBy("hotfix_id")
    private Set<Hotfix> hotfixes = new HashSet<Hotfix>();

    /** The software aggregates. */
    @OneToMany(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @OrderBy("start_date desc")
    private Set<AuditableSoftwareAggregate> auditableSoftwareAggregates = new HashSet<AuditableSoftwareAggregate>();

    /** The internet explorers. */
    @OneToMany(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @OrderBy("start_date desc")
    private Set<AuditableInternetExplorer> auditableInternetExplorers = new HashSet<AuditableInternetExplorer>();

    /** The ip. */
    @Column(name = "ip", length = 23)
    private String ip;

    /** The mac. */
    @Column(name = "mac", length = 17)
    private String mac;

    /**
     * Gets the comboboxes data for the query designer.
     * 
     * @return the comboboxes data
     */
    public static Map<String, Map> getComboboxes() {
	return comboboxes;
    }

    /**
     * Gets the csv header for exporting terminals' data.
     * 
     * @return the csv header
     */
    public static String getCsvHeader() {
	return "Serial Number;IP;MAC;Terminal Type;Vendor;Product Class;"
		+ "Product Class Description;Front Replenish;Bank;"
		+ "Branch;Geographic Address;Address;Manufacturing Site;"
		+ "Tracer Number";
    }

    /**
     * Instantiates a new terminal.
     */
    public Terminal() {
    }

    /**
     * Instantiates a new terminal with the given terminal data from the agent.
     * 
     * @param terminal
     *            the terminal
     * @throws ATMWrongDataException
     *             the ATM wrong data exception
     */
    public Terminal(ATMDataStorePojo terminal) throws ATMWrongDataException {
	this.ip = terminal.getCurrentip();
	this.mac = terminal.getCurrentmac();
	FinancialTerminalPojo financialTerminal = terminal
		.getFinancialTerminal();
	if (financialTerminal == null) {
	    throw new ATMWrongDataException(
		    "No subobject FinancialTerminal in Terminal related to IP "
			    + ip);
	}
	this.geographicAddress = financialTerminal.getGeographicaddress();
	this.frontReplenish = Boolean.parseBoolean(financialTerminal
		.getFrontreplenish());
	this.manufacturingSite = financialTerminal.getManufacturingsite();
	this.productClassDescription = financialTerminal
		.getProductclassdescription();
	// if ((financialTerminal.getSerialnumber() != null)
	// && (financialTerminal.getSerialnumber().length() > 0)
	// && !financialTerminal.getSerialnumber().equals("null")) {
	this.serialNumber = financialTerminal.getSerialnumber();
	// }
	this.terminalType = financialTerminal.getTerminaltype();
	this.terminalVendor = financialTerminal.getVendor();
	this.tracerNumber = financialTerminal.getTracernumber();
	String matricula = terminal.getMatricula();
	if ((matricula != null) && (matricula.length() > 0)) {
	    this.matricula = Long.parseLong(terminal.getMatricula());
	}
    }

    /**
     * Instantiates a new agent terminal data with the active attributes and
     * related components for a specified instant.
     * 
     * @param date
     *            the instant we want to retrieve the data for
     * 
     * @return the agent terminal data
     */
    public ATMDataStorePojo getInventoryPojo(Date date) {
	// First of all we recreate the terminal and its own data
	ATMDataStorePojo terminal = new ATMDataStorePojo();
	FinancialTerminalPojo financialTerminal = new FinancialTerminalPojo();
	financialTerminal.setGeographicaddress(geographicAddress);
	if (frontReplenish != null) {
	    financialTerminal.setFrontreplenish(Boolean.valueOf(frontReplenish)
		    .toString());
	}
	financialTerminal.setManufacturingsite(manufacturingSite);
	financialTerminal.setProductclassdescription(productClassDescription);
	financialTerminal.setSerialnumber(serialNumber);
	financialTerminal.setTerminaltype(terminalType);
	financialTerminal.setVendor(terminalVendor);
	financialTerminal.setTracernumber(tracerNumber);
	terminal.setFinancialTerminal(financialTerminal);

	// We recreate the hotfixes
	Vector<HotfixPojo> hotfixes = new Vector<HotfixPojo>();
	for (Hotfix hotfix : this.getActiveHotfixesByDate(date)) {
	    hotfixes.add(hotfix.getInventoryPojo());
	}
	terminal.setvHotfix(hotfixes);

	// We recreate the financial devices and their xfs/jxfs components
	Vector<ALM> xfsAlm = new Vector<ALM>();
	Vector<BCR> xfsBcr = new Vector<BCR>();
	Vector<CAM> xfsCam = new Vector<CAM>();
	Vector<CDM> xfsCdm = new Vector<CDM>();
	Vector<CEU> xfsCeu = new Vector<CEU>();
	Vector<CHK> xfsChk = new Vector<CHK>();
	Vector<CIM> xfsCim = new Vector<CIM>();
	Vector<CRD> xfsCrd = new Vector<CRD>();
	Vector<DEP> xfsDep = new Vector<DEP>();
	Vector<IDC> xfsIdc = new Vector<IDC>();
	Vector<IPM> xfsIpm = new Vector<IPM>();
	Vector<PIN> xfsPin = new Vector<PIN>();
	Vector<PTR> xfsPtr = new Vector<PTR>();
	Vector<SIU> xfsSiu = new Vector<SIU>();
	Vector<TTU> xfsTtu = new Vector<TTU>();
	Vector<VDM> xfsVdm = new Vector<VDM>();

	Vector<CapabilitiesJxfsALMCollector> jxfsAlm = new Vector<CapabilitiesJxfsALMCollector>();
	Vector<CapabilitiesJxfsCAMCollector> jxfsCam = new Vector<CapabilitiesJxfsCAMCollector>();
	Vector<CapabilitiesJxfsCDRCollector> jxfsCdr = new Vector<CapabilitiesJxfsCDRCollector>();
	Vector<CapabilitiesJxfsCHKCollector> jxfsChk = new Vector<CapabilitiesJxfsCHKCollector>();
	Vector<CapabilitiesJxfsDEPCollector> jxfsDep = new Vector<CapabilitiesJxfsDEPCollector>();
	Vector<CapabilitiesJxfsMSDCollector> jxfsMsd = new Vector<CapabilitiesJxfsMSDCollector>();
	Vector<CapabilitiesJxfsPINCollector> jxfsPin = new Vector<CapabilitiesJxfsPINCollector>();
	Vector<CapabilitiesJxfsPTRCollector> jxfsPtr = new Vector<CapabilitiesJxfsPTRCollector>();
	Vector<CapabilitiesJxfsSCNCollector> jxfsScn = new Vector<CapabilitiesJxfsSCNCollector>();
	Vector<CapabilitiesJxfsSIUCollector> jxfsSiu = new Vector<CapabilitiesJxfsSIUCollector>();
	Vector<CapabilitiesJxfsTIOCollector> jxfsTio = new Vector<CapabilitiesJxfsTIOCollector>();
	Vector<CapabilitiesJxfsVDMCollector> jxfsVdm = new Vector<CapabilitiesJxfsVDMCollector>();

	Vector<FinancialDevicePojo> financialDevices = new Vector<FinancialDevicePojo>();
	for (FinancialDevice financialDevice : this
		.getActiveFinancialDevicesByDate(date)) {
	    for (XfsComponent xfs : financialDevice.getXfsComponents()) {
		Object xfsPojo = xfs.getInventoryPojo();

		if (xfsPojo instanceof ALM) {
		    xfsAlm.add((ALM) xfsPojo);
		    continue;
		}

		if (xfsPojo instanceof BCR) {
		    xfsBcr.add((BCR) xfsPojo);
		    continue;
		}

		if (xfsPojo instanceof CAM) {
		    xfsCam.add((CAM) xfsPojo);
		    continue;
		}

		if (xfsPojo instanceof CDM) {
		    xfsCdm.add((CDM) xfsPojo);
		    continue;
		}

		if (xfsPojo instanceof CEU) {
		    xfsCeu.add((CEU) xfsPojo);
		    continue;
		}

		if (xfsPojo instanceof CHK) {
		    xfsChk.add((CHK) xfsPojo);
		    continue;
		}

		if (xfsPojo instanceof CIM) {
		    xfsCim.add((CIM) xfsPojo);
		    continue;
		}

		if (xfsPojo instanceof CRD) {
		    xfsCrd.add((CRD) xfsPojo);
		    continue;
		}

		if (xfsPojo instanceof DEP) {
		    xfsDep.add((DEP) xfsPojo);
		    continue;
		}

		if (xfsPojo instanceof IDC) {
		    xfsIdc.add((IDC) xfsPojo);
		    continue;
		}

		if (xfsPojo instanceof IPM) {
		    xfsIpm.add((IPM) xfsPojo);
		    continue;
		}

		if (xfsPojo instanceof PIN) {
		    xfsPin.add((PIN) xfsPojo);
		    continue;
		}

		if (xfsPojo instanceof PTR) {
		    xfsPtr.add((PTR) xfsPojo);
		    continue;
		}

		if (xfsPojo instanceof SIU) {
		    xfsSiu.add((SIU) xfsPojo);
		    continue;
		}

		if (xfsPojo instanceof TTU) {
		    xfsTtu.add((TTU) xfsPojo);
		    continue;
		}

		if (xfsPojo instanceof VDM) {
		    xfsVdm.add((VDM) xfsPojo);
		    continue;
		}
	    }

	    for (JxfsComponent jxfs : financialDevice.getJxfsComponents()) {
		Object jxfsPojo = jxfs.getInventoryPojo();

		if (jxfsPojo instanceof CapabilitiesJxfsALMCollector) {
		    jxfsAlm.add((CapabilitiesJxfsALMCollector) jxfsPojo);
		    continue;
		}

		if (jxfsPojo instanceof CapabilitiesJxfsCAMCollector) {
		    jxfsCam.add((CapabilitiesJxfsCAMCollector) jxfsPojo);
		    continue;
		}

		if (jxfsPojo instanceof CapabilitiesJxfsCDRCollector) {
		    jxfsCdr.add((CapabilitiesJxfsCDRCollector) jxfsPojo);
		    continue;
		}

		if (jxfsPojo instanceof CapabilitiesJxfsCHKCollector) {
		    jxfsChk.add((CapabilitiesJxfsCHKCollector) jxfsPojo);
		    continue;
		}

		if (jxfsPojo instanceof CapabilitiesJxfsDEPCollector) {
		    jxfsDep.add((CapabilitiesJxfsDEPCollector) jxfsPojo);
		    continue;
		}

		if (jxfsPojo instanceof CapabilitiesJxfsMSDCollector) {
		    jxfsMsd.add((CapabilitiesJxfsMSDCollector) jxfsPojo);
		    continue;
		}

		if (jxfsPojo instanceof CapabilitiesJxfsPINCollector) {
		    jxfsPin.add((CapabilitiesJxfsPINCollector) jxfsPojo);
		    continue;
		}

		if (jxfsPojo instanceof CapabilitiesJxfsPTRCollector) {
		    jxfsPtr.add((CapabilitiesJxfsPTRCollector) jxfsPojo);
		    continue;
		}

		if (jxfsPojo instanceof CapabilitiesJxfsSCNCollector) {
		    jxfsScn.add((CapabilitiesJxfsSCNCollector) jxfsPojo);
		    continue;
		}

		if (jxfsPojo instanceof CapabilitiesJxfsSIUCollector) {
		    jxfsSiu.add((CapabilitiesJxfsSIUCollector) jxfsPojo);
		    continue;
		}

		if (jxfsPojo instanceof CapabilitiesJxfsTIOCollector) {
		    jxfsTio.add((CapabilitiesJxfsTIOCollector) jxfsPojo);
		    continue;
		}

		if (jxfsPojo instanceof CapabilitiesJxfsVDMCollector) {
		    jxfsVdm.add((CapabilitiesJxfsVDMCollector) jxfsPojo);
		    continue;
		}
	    }

	    financialDevices.add(financialDevice.getInventoryPojo());
	}
	terminal.setvFinancialDevice(financialDevices);

	terminal.setVjAlm(jxfsAlm);
	terminal.setVjCam(jxfsCam);
	terminal.setVjCdr(jxfsCdr);
	terminal.setVjChk(jxfsChk);
	terminal.setVjDep(jxfsDep);
	terminal.setVjMsd(jxfsMsd);
	terminal.setVjPin(jxfsPin);
	terminal.setVjPtr(jxfsPtr);
	terminal.setVjScn(jxfsScn);
	terminal.setVjSiu(jxfsSiu);
	terminal.setVjTio(jxfsTio);
	terminal.setVjVdm(jxfsVdm);

	terminal.setvAlm(xfsAlm.toArray(new ALM[0]));
	terminal.setvBcr(xfsBcr.toArray(new BCR[0]));
	terminal.setvCam(xfsCam.toArray(new CAM[0]));
	terminal.setvCdm(xfsCdm.toArray(new CDM[0]));
	terminal.setvCeu(xfsCeu.toArray(new CEU[0]));
	terminal.setvChk(xfsChk.toArray(new CHK[0]));
	terminal.setvCim(xfsCim.toArray(new CIM[0]));
	terminal.setvCrd(xfsCrd.toArray(new CRD[0]));
	terminal.setvDep(xfsDep.toArray(new DEP[0]));
	terminal.setvIdc(xfsIdc.toArray(new IDC[0]));
	terminal.setvIpm(xfsIpm.toArray(new IPM[0]));
	terminal.setvPin(xfsPin.toArray(new PIN[0]));
	terminal.setvPtr(xfsPtr.toArray(new PTR[0]));
	terminal.setvSiu(xfsSiu.toArray(new SIU[0]));
	terminal.setvTtu(xfsTtu.toArray(new TTU[0]));
	terminal.setvVdm(xfsVdm.toArray(new VDM[0]));

	// We recreate the IExplorers
	Vector<IExplorerPojo> internetExplorers = new Vector<IExplorerPojo>();
	for (AuditableInternetExplorer internetExplorer : this
		.getActiveAuditableInternetExplorersByDate(date)) {
	    internetExplorers.add(internetExplorer.getInternetExplorer()
		    .getInventoryPojo());
	}
	terminal.setvIExplorer(internetExplorers);

	// We recreate the operating systems
	TerminalConfig config = getCurrentTerminalConfigActiveByDate(date);
	Vector<OperatingSystemPojo> operatingSystems = new Vector<OperatingSystemPojo>();
	for (OperatingSystem operatingSystem : config.getOperatingSystems()) {
	    operatingSystems.add(operatingSystem.getInventoryPojo());
	}
	terminal.setvOperatingSystem(operatingSystems);

	// We recreate the software entries
	Vector<ProductPojo> software = new Vector<ProductPojo>();
	for (Software sw : config.getSoftware()) {
	    software.add(sw.getInventoryPojo());
	}
	terminal.setvProduct(software);

	// We recreate the software aggregates
	Vector<FinancialPackagePojo> softwareAggregates = new Vector<FinancialPackagePojo>();
	for (AuditableSoftwareAggregate sw : this
		.getActiveAuditableSoftwareAggregatesByDate(date)) {
	    softwareAggregates
		    .add(sw.getSoftwareAggregate().getInventoryPojo());
	}
	terminal.setvFinancialPackage(softwareAggregates);

	// We recreate the hardware devices
	Vector<_1394ControllerPojo> _1394Controllers = new Vector<_1394ControllerPojo>();
	Vector<BaseBoardPojo> baseBoards = new Vector<BaseBoardPojo>();
	Vector<BiosPojo> bios = new Vector<BiosPojo>();
	Vector<CDROMDrivePojo> cdroms = new Vector<CDROMDrivePojo>();
	Vector<ComputerSystemPojo> computerSystems = new Vector<ComputerSystemPojo>();
	Vector<DesktopMonitorPojo> desktopMonitors = new Vector<DesktopMonitorPojo>();
	Vector<DiskDrivePojo> diskDrives = new Vector<DiskDrivePojo>();
	Vector<FloppyDrivePojo> floppyDrives = new Vector<FloppyDrivePojo>();
	Vector<KeyboardPojo> keyboards = new Vector<KeyboardPojo>();
	Vector<LogicalDiskPojo> logicalDisks = new Vector<LogicalDiskPojo>();
	Vector<NetworkAdapterSettingPojo> networkAdapters = new Vector<NetworkAdapterSettingPojo>();
	Vector<ParallelPortPojo> parallelPorts = new Vector<ParallelPortPojo>();
	Vector<PhysicalMemoryPojo> physicalMemories = new Vector<PhysicalMemoryPojo>();
	Vector<PointingDevicePojo> pointingDevices = new Vector<PointingDevicePojo>();
	Vector<ProcessorPojo> processors = new Vector<ProcessorPojo>();
	Vector<SCSIControllerPojo> scsiControllers = new Vector<SCSIControllerPojo>();
	Vector<SerialPortPojo> serialPorts = new Vector<SerialPortPojo>();
	Vector<SoundDevicePojo> soundDevices = new Vector<SoundDevicePojo>();
	Vector<SystemSlotPojo> systemSlots = new Vector<SystemSlotPojo>();
	Vector<USBControllerPojo> usbControllers = new Vector<USBControllerPojo>();
	Vector<UsbHubPojo> usbHubs = new Vector<UsbHubPojo>();
	Vector<VideoControllerPojo> videoControllers = new Vector<VideoControllerPojo>();
	for (HardwareDevice hw : this.getActiveHardwareDevicesByDate(date)) {
	    Object hwPojo = hw.getInventoryPojo();

	    if (hwPojo instanceof _1394ControllerPojo) {
		_1394Controllers.add((_1394ControllerPojo) hwPojo);
		continue;
	    }

	    if (hwPojo instanceof BaseBoardPojo) {
		baseBoards.add((BaseBoardPojo) hwPojo);
		continue;
	    }

	    if (hwPojo instanceof BiosPojo) {
		bios.add((BiosPojo) hwPojo);
		continue;
	    }

	    if (hwPojo instanceof CDROMDrivePojo) {
		cdroms.add((CDROMDrivePojo) hwPojo);
		continue;
	    }

	    if (hwPojo instanceof ComputerSystemPojo) {
		computerSystems.add((ComputerSystemPojo) hwPojo);
		continue;
	    }

	    if (hwPojo instanceof DesktopMonitorPojo) {
		desktopMonitors.add((DesktopMonitorPojo) hwPojo);
		continue;
	    }

	    if (hwPojo instanceof DiskDrivePojo) {
		diskDrives.add((DiskDrivePojo) hwPojo);
		continue;
	    }

	    if (hwPojo instanceof FloppyDrivePojo) {
		floppyDrives.add((FloppyDrivePojo) hwPojo);
		continue;
	    }

	    if (hwPojo instanceof KeyboardPojo) {
		keyboards.add((KeyboardPojo) hwPojo);
		continue;
	    }

	    if (hwPojo instanceof LogicalDiskPojo) {
		logicalDisks.add((LogicalDiskPojo) hwPojo);
		continue;
	    }

	    if (hwPojo instanceof NetworkAdapterSettingPojo) {
		networkAdapters.add((NetworkAdapterSettingPojo) hwPojo);
		continue;
	    }

	    if (hwPojo instanceof ParallelPortPojo) {
		parallelPorts.add((ParallelPortPojo) hwPojo);
		continue;
	    }

	    if (hwPojo instanceof PhysicalMemoryPojo) {
		physicalMemories.add((PhysicalMemoryPojo) hwPojo);
		continue;
	    }

	    if (hwPojo instanceof PointingDevicePojo) {
		pointingDevices.add((PointingDevicePojo) hwPojo);
		continue;
	    }

	    if (hwPojo instanceof ProcessorPojo) {
		processors.add((ProcessorPojo) hwPojo);
		continue;
	    }

	    if (hwPojo instanceof SCSIControllerPojo) {
		scsiControllers.add((SCSIControllerPojo) hwPojo);
		continue;
	    }

	    if (hwPojo instanceof SerialPortPojo) {
		serialPorts.add((SerialPortPojo) hwPojo);
		continue;
	    }

	    if (hwPojo instanceof SoundDevicePojo) {
		soundDevices.add((SoundDevicePojo) hwPojo);
		continue;
	    }

	    if (hwPojo instanceof SystemSlotPojo) {
		systemSlots.add((SystemSlotPojo) hwPojo);
		continue;
	    }

	    if (hwPojo instanceof USBControllerPojo) {
		usbControllers.add((USBControllerPojo) hwPojo);
		continue;
	    }

	    if (hwPojo instanceof UsbHubPojo) {
		usbHubs.add((UsbHubPojo) hwPojo);
		continue;
	    }

	    if (hwPojo instanceof VideoControllerPojo) {
		videoControllers.add((VideoControllerPojo) hwPojo);
		continue;
	    }
	}
	terminal.setV1394Controller(_1394Controllers);
	terminal.setvBaseBoard(baseBoards);
	terminal.setvBios(bios);
	terminal.setvCDROMDrive(cdroms);
	terminal.setvComputerSystem(computerSystems);
	terminal.setvDesktopMonitor(desktopMonitors);
	terminal.setvDiskDrive(diskDrives);
	terminal.setvFloppyDrive(floppyDrives);
	terminal.setvKeyboard(keyboards);
	terminal.setvLogicalDisk(logicalDisks);
	terminal.setvNetworkAdapterSetting(networkAdapters);
	terminal.setvParallelPort(parallelPorts);
	terminal.setvPhysicalMemory(physicalMemories);
	terminal.setvPointingDevice(pointingDevices);
	terminal.setvProcessor(processors);
	terminal.setvSCSIController(scsiControllers);
	terminal.setvSerialPort(serialPorts);
	terminal.setvSoundDevice(soundDevices);
	terminal.setvSystemSlot(systemSlots);
	terminal.setvUSBController(usbControllers);
	terminal.setvUSBHub(usbHubs);
	terminal.setvVideoController(videoControllers);

	terminal.setCurrentip(ip);
	terminal.setCurrentmac(mac);
	if (matricula != null) {
	    terminal.setMatricula(Long.valueOf(matricula).toString());
	}
	return terminal;
    }

    /**
     * Replaces most terminal fields with the data from another Terminal entity.
     * 
     * @param terminal
     *            the terminal with its data rewritten
     */
    public void replaceTerminalData(Terminal terminal) {
	this.bank = terminal.bank;
	this.branch = terminal.branch;
	this.frontReplenish = terminal.frontReplenish;
	this.geographicAddress = terminal.geographicAddress;
	this.ip = terminal.ip;
	this.mac = terminal.mac;
	this.manufacturingSite = terminal.manufacturingSite;
	this.productClassDescription = terminal.productClassDescription;
	this.serialNumber = terminal.serialNumber;
	this.terminalType = terminal.terminalType;
	this.terminalVendor = terminal.terminalVendor;
	this.tracerNumber = terminal.tracerNumber;
	this.bankCompany = terminal.bankCompany;
	this.terminalModel = terminal.terminalModel;
    }

    /**
     * Replaces most terminal fields with the data from another Terminal entity
     * ignoring null or void values so they don't overwrite the original values.
     * 
     * @param terminal
     *            the terminal with its data rewritten
     */
    public void replaceTerminalDataWoVoidValues(Terminal terminal) {
	this.bank = ((terminal.bank != null) && (terminal.bank.trim().length() > 0)) ? terminal.bank
		: this.bank;
	this.branch = ((terminal.branch != null) && (terminal.branch.trim()
		.length() > 0)) ? terminal.branch : this.branch;
	this.frontReplenish = (terminal.frontReplenish != null) ? terminal.frontReplenish
		: this.frontReplenish;
	this.geographicAddress = ((terminal.geographicAddress != null) && (terminal.geographicAddress
		.trim().length() > 0)) ? terminal.geographicAddress
		: this.geographicAddress;
	this.ip = ((terminal.ip != null) && (terminal.ip.trim().length() > 0)) ? terminal.ip
		: this.ip;
	this.mac = ((terminal.mac != null) && (terminal.mac.trim().length() > 0)) ? terminal.mac
		: this.mac;
	this.manufacturingSite = ((terminal.manufacturingSite != null) && (terminal.manufacturingSite
		.trim().length() > 0)) ? terminal.manufacturingSite
		: this.manufacturingSite;
	this.productClassDescription = ((terminal.productClassDescription != null) && (terminal.productClassDescription
		.trim().length() > 0)) ? terminal.productClassDescription
		: this.productClassDescription;
	this.serialNumber = ((terminal.serialNumber != null) && (terminal.serialNumber
		.trim().length() > 0)) ? terminal.serialNumber
		: this.serialNumber;
	this.terminalType = ((terminal.terminalType != null) && (terminal.terminalType
		.trim().length() > 0)) ? terminal.terminalType
		: this.terminalType;
	this.terminalVendor = ((terminal.terminalVendor != null) && (terminal.terminalVendor
		.trim().length() > 0)) ? terminal.terminalVendor
		: this.terminalVendor;
	this.tracerNumber = ((terminal.tracerNumber != null) && (terminal.tracerNumber
		.trim().length() > 0)) ? terminal.tracerNumber
		: this.tracerNumber;
	// We don't know if we can retrieve this information yet
	// this.bankCompany = (terminal.bankCompany != null) ?
	// terminal.bankCompany
	// : this.bankCompany;
	this.terminalModel = (terminal.terminalModel != null) ? terminal.terminalModel
		: this.terminalModel;
    }

    /**
     * Gets the id.
     * 
     * @return the id
     */
    public Integer getId() {
	return id;
    }

    /**
     * Sets the id.
     * 
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
	this.id = id;
    }

    /**
     * Gets the bank company.
     * 
     * @return the bankCompany
     */
    public BankCompany getBankCompany() {
	return bankCompany;
    }

    /**
     * Sets the bank company.
     * 
     * @param bankCompany
     *            the bankCompany to set
     */
    public void setBankCompany(BankCompany bankCompany) {
	this.bankCompany = bankCompany;
    }

    /**
     * Gets the terminal type.
     * 
     * @return the terminalType
     */
    public String getTerminalType() {
	return terminalType;
    }

    /**
     * Sets the terminal type.
     * 
     * @param terminalType
     *            the terminalType to set
     */
    public void setTerminalType(String terminalType) {
	this.terminalType = terminalType;
    }

    /**
     * Gets the terminal vendor.
     * 
     * @return the terminalVendor
     */
    public String getTerminalVendor() {
	return terminalVendor;
    }

    /**
     * Sets the terminal vendor.
     * 
     * @param terminalVendor
     *            the terminalVendor to set
     */
    public void setTerminalVendor(String terminalVendor) {
	this.terminalVendor = terminalVendor;
    }

    /**
     * Gets the front replenish.
     * 
     * @return the frontReplenish
     */
    public Boolean getFrontReplenish() {
	return frontReplenish;
    }

    /**
     * Sets the front replenish.
     * 
     * @param frontReplenish
     *            the frontReplenish to set
     */
    public void setFrontReplenish(Boolean frontReplenish) {
	this.frontReplenish = frontReplenish;
    }

    /**
     * Gets the geographic address.
     * 
     * @return the geographicAddress
     */
    public String getGeographicAddress() {
	return geographicAddress;
    }

    /**
     * Sets the geographic address.
     * 
     * @param geographicAddress
     *            the geographicAddress to set
     */
    public void setGeographicAddress(String geographicAddress) {
	this.geographicAddress = geographicAddress;
    }

    /**
     * Gets the manufacturing site.
     * 
     * @return the manufacturingSite
     */
    public String getManufacturingSite() {
	return manufacturingSite;
    }

    /**
     * Sets the manufacturing site.
     * 
     * @param manufacturingSite
     *            the manufacturingSite to set
     */
    public void setManufacturingSite(String manufacturingSite) {
	this.manufacturingSite = manufacturingSite;
    }

    /**
     * Gets the product class description.
     * 
     * @return the productClassDescription
     */
    public String getProductClassDescription() {
	return productClassDescription;
    }

    /**
     * Sets the product class description.
     * 
     * @param productClassDescription
     *            the productClassDescription to set
     */
    public void setProductClassDescription(String productClassDescription) {
	this.productClassDescription = productClassDescription;
    }

    /**
     * Gets the serial number.
     * 
     * @return the serialNumber
     */
    public String getSerialNumber() {
	return serialNumber;
    }

    /**
     * Sets the serial number.
     * 
     * @param serialNumber
     *            the serialNumber to set
     */
    public void setSerialNumber(String serialNumber) {
	this.serialNumber = serialNumber;
    }

    /**
     * Gets the tracer number.
     * 
     * @return the tracerNumber
     */
    public String getTracerNumber() {
	return tracerNumber;
    }

    /**
     * Sets the tracer number.
     * 
     * @param tracerNumber
     *            the tracerNumber to set
     */
    public void setTracerNumber(String tracerNumber) {
	this.tracerNumber = tracerNumber;
    }

    /**
     * Gets the configs.
     * 
     * @return the configs
     */
    public Set<TerminalConfig> getConfigs() {
	return configs;
    }

    /**
     * Sets the configs.
     * 
     * @param configs
     *            the configs to set
     */
    public void setConfigs(Set<TerminalConfig> configs) {
	this.configs = configs;
    }

    /**
     * Gets the financial devices.
     * 
     * @return the financialDevices
     */
    public Set<FinancialDevice> getFinancialDevices() {
	return financialDevices;
    }

    /**
     * Sets the financial devices.
     * 
     * @param financialDevices
     *            the financialDevices to set
     */
    public void setFinancialDevices(Set<FinancialDevice> financialDevices) {
	this.financialDevices = financialDevices;
    }

    /**
     * Gets the hardware devices.
     * 
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getHardwareDevices() {
	return hardwareDevices;
    }

    /**
     * Gets the computer systems.
     * 
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getComputerSystems() {
	return HardwareDevice.filterComputerSystem(hardwareDevices);
    }

    /**
     * Gets the processors.
     * 
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getProcessors() {
	return HardwareDevice.filterProcessor(hardwareDevices);
    }

    /**
     * Gets the physical memories.
     * 
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getPhysicalMemories() {
	return HardwareDevice.filterPhysicalMemory(hardwareDevices);
    }

    /**
     * Gets the disk drives.
     * 
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getDiskDrives() {
	return HardwareDevice.filterDiskDrive(hardwareDevices);
    }

    /**
     * Gets the logical disks.
     * 
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getLogicalDisks() {
	return HardwareDevice.filterLogicalDisk(hardwareDevices);
    }

    /**
     * Gets the base boards.
     * 
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getBaseBoards() {
	return HardwareDevice.filterBaseBoard(hardwareDevices);
    }

    /**
     * Gets the network adapters.
     * 
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getNetworkAdapters() {
	return HardwareDevice.filterNetworkAdapter(hardwareDevices);
    }

    /**
     * Gets the floppy drives.
     * 
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getFloppyDrives() {
	return HardwareDevice.filterFloppyDrive(hardwareDevices);
    }

    /**
     * Gets the cdrom drives.
     * 
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getCdromDrives() {
	return HardwareDevice.filterCdromDrive(hardwareDevices);
    }

    /**
     * Gets the sound devices.
     * 
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getSoundDevices() {
	return HardwareDevice.filterSoundDevice(hardwareDevices);
    }

    /**
     * Gets the usb controllers.
     * 
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getUsbControllers() {
	return HardwareDevice.filterUsbController(hardwareDevices);
    }

    /**
     * Gets the serial ports.
     * 
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getSerialPorts() {
	return HardwareDevice.filterSerialPort(hardwareDevices);
    }

    /**
     * Gets the parallel ports.
     * 
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getParallelPorts() {
	return HardwareDevice.filterParallelPort(hardwareDevices);
    }

    /**
     * Gets the controllers1394.
     * 
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getControllers1394() {
	return HardwareDevice.filter1394Controller(hardwareDevices);
    }

    /**
     * Gets the scsi controllers.
     * 
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getScsiControllers() {
	return HardwareDevice.filterScsiController(hardwareDevices);
    }

    /**
     * Gets the desktop monitors.
     * 
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getDesktopMonitors() {
	return HardwareDevice.filterDesktopMonitor(hardwareDevices);
    }

    /**
     * Gets the keyboards.
     * 
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getKeyboards() {
	return HardwareDevice.filterKeyboard(hardwareDevices);
    }

    /**
     * Gets the pointing devices.
     * 
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getPointingDevices() {
	return HardwareDevice.filterPointingDevice(hardwareDevices);
    }

    /**
     * Gets the system slots.
     * 
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getSystemSlots() {
	return HardwareDevice.filterSystemSlot(hardwareDevices);
    }

    /**
     * Gets the bios.
     * 
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getBios() {
	return HardwareDevice.filterBios(hardwareDevices);
    }

    /**
     * Gets the video controllers.
     * 
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getVideoControllers() {
	return HardwareDevice.filterVideoController(hardwareDevices);
    }

    /**
     * Sets the hardware devices.
     * 
     * @param hardwareDevices
     *            the hardwareDevices to set
     */
    public void setHardwareDevices(Set<HardwareDevice> hardwareDevices) {
	this.hardwareDevices = hardwareDevices;
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getActiveComputerSystemsByDate(Date date) {
	return HardwareDevice
		.filterComputerSystem(getActiveHardwareDevicesByDate(date));
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getActiveProcessorsByDate(Date date) {
	return HardwareDevice
		.filterProcessor(getActiveHardwareDevicesByDate(date));
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getActivePhysicalMemoriesByDate(Date date) {
	return HardwareDevice
		.filterPhysicalMemory(getActiveHardwareDevicesByDate(date));
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getActiveDiskDrivesByDate(Date date) {
	return HardwareDevice
		.filterDiskDrive(getActiveHardwareDevicesByDate(date));
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getActiveLogicalDisksByDate(Date date) {
	return HardwareDevice
		.filterLogicalDisk(getActiveHardwareDevicesByDate(date));
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getActiveBaseBoardsByDate(Date date) {
	return HardwareDevice
		.filterBaseBoard(getActiveHardwareDevicesByDate(date));
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getActiveNetworkAdaptersByDate(Date date) {
	return HardwareDevice
		.filterNetworkAdapter(getActiveHardwareDevicesByDate(date));
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getActiveFloppyDrivesByDate(Date date) {
	return HardwareDevice
		.filterFloppyDrive(getActiveHardwareDevicesByDate(date));
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getActiveCdromDrivesByDate(Date date) {
	return HardwareDevice
		.filterCdromDrive(getActiveHardwareDevicesByDate(date));
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getActiveSoundDevicesByDate(Date date) {
	return HardwareDevice
		.filterSoundDevice(getActiveHardwareDevicesByDate(date));
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getActiveUsbControllersByDate(Date date) {
	return HardwareDevice
		.filterUsbController(getActiveHardwareDevicesByDate(date));
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getActiveSerialPortsByDate(Date date) {
	return HardwareDevice
		.filterSerialPort(getActiveHardwareDevicesByDate(date));
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getActiveParallelPortsByDate(Date date) {
	return HardwareDevice
		.filterParallelPort(getActiveHardwareDevicesByDate(date));
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getActiveControllers1394ByDate(Date date) {
	return HardwareDevice
		.filter1394Controller(getActiveHardwareDevicesByDate(date));
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getActiveScsiControllersByDate(Date date) {
	return HardwareDevice
		.filterScsiController(getActiveHardwareDevicesByDate(date));
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getActiveDesktopMonitorsByDate(Date date) {
	return HardwareDevice
		.filterDesktopMonitor(getActiveHardwareDevicesByDate(date));
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getActiveKeyboardsByDate(Date date) {
	return HardwareDevice
		.filterKeyboard(getActiveHardwareDevicesByDate(date));
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getActivePointingDevicesByDate(Date date) {
	return HardwareDevice
		.filterPointingDevice(getActiveHardwareDevicesByDate(date));
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getActiveSystemSlotsByDate(Date date) {
	return HardwareDevice
		.filterSystemSlot(getActiveHardwareDevicesByDate(date));
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getActiveBiosByDate(Date date) {
	return HardwareDevice.filterBios(getActiveHardwareDevicesByDate(date));
    }

    /**
     * @return the hardwareDevices
     */
    public Set<HardwareDevice> getActiveVideoControllersByDate(Date date) {
	return HardwareDevice
		.filterVideoController(getActiveHardwareDevicesByDate(date));
    }

    /**
     * Gets the bank.
     * 
     * @return the bank
     */
    public String getBank() {
	return bank;
    }

    /**
     * Sets the bank.
     * 
     * @param bank
     *            the bank to set
     */
    public void setBank(String bank) {
	this.bank = bank;
    }

    /**
     * Gets the branch.
     * 
     * @return the branch
     */
    public String getBranch() {
	return branch;
    }

    /**
     * Sets the branch.
     * 
     * @param branch
     *            the branch to set
     */
    public void setBranch(String branch) {
	this.branch = branch;
    }

    /**
     * Gets the ip.
     * 
     * @return the ip
     */
    public String getIp() {
	return ip;
    }

    /**
     * Sets the ip.
     * 
     * @param ip
     *            the ip to set
     */
    public void setIp(String ip) {
	this.ip = ip;
    }

    /**
     * Gets the software aggregates.
     * 
     * @return the softwareAggregates
     */
    public Set<SoftwareAggregate> getSoftwareAggregates() {
	Set<SoftwareAggregate> aggregates = new HashSet<SoftwareAggregate>();
	for (AuditableSoftwareAggregate auditableAggregate : auditableSoftwareAggregates) {
	    aggregates.add(auditableAggregate.getSoftwareAggregate());
	}
	return aggregates;
    }

    /**
     * Gets the hotfixes.
     * 
     * @return the hotfixes
     */
    public Set<Hotfix> getHotfixes() {
	return hotfixes;
    }

    /**
     * Sets the hotfixes.
     * 
     * @param hotfixes
     *            the hotfixes to set
     */
    public void setHotfixes(Set<Hotfix> hotfixes) {
	this.hotfixes = hotfixes;
    }

    /**
     * Gets the internet explorers.
     * 
     * @return the internetExplorers
     */
    public Set<InternetExplorer> getInternetExplorers() {
	Set<InternetExplorer> ies = new HashSet<InternetExplorer>();
	for (AuditableInternetExplorer auditableIE : auditableInternetExplorers) {
	    ies.add(auditableIE.getInternetExplorer());
	}
	return ies;
    }

    /**
     * Sets the internet explorers.
     * 
     * @param internetExplorers
     *            the internetExplorers to set
     */
    public void setAuditableInternetExplorers(
	    Set<AuditableInternetExplorer> auditableInternetExplorers) {
	this.auditableInternetExplorers = auditableInternetExplorers;
    }

    /**
     * Gets a recap of the terminal data in csv format.
     * 
     * @returna a recap of the data in csv format.
     */
    public String getCsvDescription() {
	return (serialNumber != null ? serialNumber.toString() : "")
		+ ";"
		+ (ip != null ? ip.toString() : "")
		+ ";"
		+ (mac != null ? mac.toString() : "")
		+ ";"
		+ (terminalType != null ? terminalType.toString() : "")
		+ ";"
		+ (((terminalModel != null) && (terminalModel.getManufacturer() != null)) ? terminalModel
			.getManufacturer() : "")
		+ ";"
		+ (((terminalModel != null) && (terminalModel.getProductClass() != null)) ? terminalModel
			.getProductClass() : "")
		+ ";"
		+ (productClassDescription != null ? productClassDescription
			.toString() : "")
		+ ";"
		+ (frontReplenish != null ? frontReplenish.toString() : "")
		+ ";"
		+ (bank != null ? bank.toString() : "")
		+ ";"
		+ (branch != null ? branch.toString() : "")
		+ ";"
		+ (geographicAddress != null ? geographicAddress.toString()
			: "")
		+ ";"
		+ (((getCurrentInstallation() != null) && (getCurrentInstallation()
			.getLocation() != null)) ? getCurrentInstallation()
			.getLocation().getCompleteAddress() : "")
		+ ";"
		+ (manufacturingSite != null ? manufacturingSite.toString()
			: "") + ";"
		+ (tracerNumber != null ? tracerNumber.toString() : "");
    }

    /**
     * Gets the mac.
     * 
     * @return the mac
     */
    public String getMac() {
	return mac;
    }

    /**
     * Sets the mac.
     * 
     * @param mac
     *            the mac to set
     */
    public void setMac(String mac) {
	this.mac = mac;
    }

    /**
     * Gets the terminal model.
     * 
     * @return the terminal model
     */
    public TerminalModel getTerminalModel() {
	return terminalModel;
    }

    /**
     * Sets the terminal model.
     * 
     * @param terminalModel
     *            the new terminal model
     */
    public void setTerminalModel(TerminalModel terminalModel) {
	this.terminalModel = terminalModel;
    }

    /**
     * Get the installations
     * 
     * @return The installations
     */
    public Set<Installation> getInstallations() {
	return installations;
    }

    /**
     * Set current installation
     * 
     * @param installation
     *            The current installation
     */
    public void setCurrentInstallation(Installation installation) {
	auditableSetOperations.setCurrentAuditableElement(installations,
		installation);
    }

    /**
     * Set the current terminal config
     * 
     * @param terminalConfig
     *            The terminal config
     */
    public void setCurrentTerminalConfig(TerminalConfig terminalConfig) {
	auditableSetOperations.setCurrentAuditableElement(configs,
		terminalConfig);
    }

    /**
     * Get the current terminal config
     * 
     * @return The terminal config
     */
    public TerminalConfig getCurrentTerminalConfig() {
	return auditableSetOperations.getCurrentAuditable(configs);
    }

    /**
     * Get the current installation
     * 
     * @return The current installation
     */
    public Installation getCurrentInstallation() {
	return auditableSetOperations.getCurrentAuditable(installations);
    }

    /**
     * Get current terminal config active by date
     * 
     * @param date
     *            The date
     * @return The current terminal config
     */
    public TerminalConfig getCurrentTerminalConfigActiveByDate(Date date) {
	return auditableSetOperations.getCurrentAuditableElementByDate(configs,
		date);
    }

    /**
     * Get the current installation by date
     * 
     * @param date
     *            The date
     * @return The current installation
     */
    public Installation getCurrentInstallationByDate(Date date) {
	return auditableSetOperations.getCurrentAuditableElementByDate(
		installations, date);
    }

    /**
     * Get active hardware device by date
     * 
     * @param date
     *            The date
     * @return The active hardware device
     */
    public Set<HardwareDevice> getActiveHardwareDevicesByDate(Date date) {
	return auditableSetOperations.getActiveAuditableElementsByDate(
		hardwareDevices, date);
    }

    /**
     * Get the active installations by date
     * 
     * @param date
     *            The date
     * @return The active installations
     */
    public Set<Installation> getActiveInstallationsByDate(Date date) {
	return auditableSetOperations.getActiveAuditableElementsByDate(
		installations, date);
    }

    /**
     * Get the active financial devices by date
     * 
     * @param date
     *            The date
     * @return The active financial devices
     */
    public Set<FinancialDevice> getActiveFinancialDevicesByDate(Date date) {
	return auditableSetOperations.getActiveAuditableElementsByDate(
		financialDevices, date);
    }

    /**
     * Get active software aggregates by date
     * 
     * @param date
     *            The date
     * @return The active software aggregates
     */
    public Set<AuditableSoftwareAggregate> getActiveAuditableSoftwareAggregatesByDate(
	    Date date) {
	return auditableSetOperations.getActiveAuditableElementsByDate(
		auditableSoftwareAggregates, date);
    }

    /**
     * Get the active hotfixes by date
     * 
     * @param date
     *            The date
     * @return The active hotfixes
     */
    public Set<Hotfix> getActiveHotfixesByDate(Date date) {
	return auditableSetOperations.getActiveAuditableElementsByDate(
		hotfixes, date);
    }

    /**
     * Get the auditable internet explorers by date
     * 
     * @param date
     *            The date
     * @return The auditable internet explorers
     */
    public Set<AuditableInternetExplorer> getActiveAuditableInternetExplorersByDate(
	    Date date) {
	return auditableSetOperations.getActiveAuditableElementsByDate(
		auditableInternetExplorers, date);
    }

    /**
     * Update the collection hardware devices of auditable elements
     * 
     * @param hardwareDevices
     *            The hardware devices
     */
    public void updateHardwareDevices(Set<HardwareDevice> newHardwareDevices) {
	auditableSetOperations.updateAuditableElements(this.hardwareDevices,
		newHardwareDevices);
    }

    /**
     * Update the collection hardware devices of auditable elements
     * 
     * @param hardwareDevices
     *            The hotfixes
     */
    public void updateHotfixes(Set<Hotfix> newHotfixes) {
	auditableSetOperations.updateAuditableElements(this.hotfixes,
		newHotfixes);
    }

    /**
     * Update the collection financial devices of auditable elements
     * 
     * @param hardwareDevices
     *            The financial devices
     */
    public void updateFinancialDevices(Set<FinancialDevice> newFinancialDevices) {
	auditableSetOperations.updateAuditableElements(this.financialDevices,
		newFinancialDevices);
    }

    /**
     * Update the collection of auditable internet explorer
     * 
     * @param newAuditableInternetExplorers
     *            the internetExplorers to set
     */
    public void updateAuditableInternetExplorers(
	    Set<AuditableInternetExplorer> newAuditableInternetExplorers) {
	auditableSetOperations.updateAuditableElements(
		this.auditableInternetExplorers, newAuditableInternetExplorers);
    }

    /**
     * Update the collection of auditable sofware aggregates
     * 
     * @param newAuditableSoftwareAggregate
     *            the new software aggregates
     */
    public void updateAuditableSoftwareAggregates(
	    Set<AuditableSoftwareAggregate> newAuditableSoftwareAggregate) {
	auditableSetOperations
		.updateAuditableElements(this.auditableSoftwareAggregates,
			newAuditableSoftwareAggregate);
    }

    /**
     * Gets the generated id.
     * 
     * @return the generated id
     */
    public Long getMatricula() {
	return matricula;
    }

    /**
     * Sets the generated id.
     * 
     * @param matricula
     *            the new generated id
     */
    public void setMatricula(Long matricula) {
	this.matricula = matricula;
    }

    /**
     * Build the historical changes
     * 
     * @return The historicalChanges
     */
    public Map<Class<? extends Auditable>, Map<Date, Integer>> buildHistoricalChanges() {
	Map<Class<? extends Auditable>, Map<Date, Integer>> historicableChanges = new HashMap<Class<? extends Auditable>, Map<Date, Integer>>();

	historicableChanges.put(HardwareDevice.class, auditableSetOperations
		.buildAuditableChangesForCollection(hardwareDevices));
	historicableChanges.put(Installation.class, auditableSetOperations
		.buildAuditableChangesForCollection(installations));
	historicableChanges.put(TerminalConfig.class, auditableSetOperations
		.buildAuditableChangesForCollection(configs));
	historicableChanges.put(Hotfix.class, auditableSetOperations
		.buildAuditableChangesForCollection(hotfixes));
	historicableChanges.put(FinancialDevice.class, auditableSetOperations
		.buildAuditableChangesForCollection(financialDevices));
	historicableChanges
		.put(AuditableInternetExplorer.class,
			auditableSetOperations
				.buildAuditableChangesForCollection(auditableInternetExplorers));
	historicableChanges
		.put(AuditableSoftwareAggregate.class,
			auditableSetOperations
				.buildAuditableChangesForCollection(auditableSoftwareAggregates));

	return historicableChanges;
    }
}
