package com.ncr.ATMMonitoring.pojo;

import java.util.Arrays;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;

import com.ncr.ATMMonitoring.utils.Operation;
import com.ncr.ATMMonitoring.utils.Utils;
import com.ncr.agent.baseData.standard.jxfs.alm.CapabilitiesJxfsALMCollector;
import com.ncr.agent.baseData.standard.jxfs.cam.CapabilitiesJxfsCAMCollector;
import com.ncr.agent.baseData.standard.jxfs.cdr.CapabilitiesJxfsCDRCollector;
import com.ncr.agent.baseData.standard.jxfs.cdr.PositionsJxfsCDRCollector;
import com.ncr.agent.baseData.standard.jxfs.chk.CapabilitiesJxfsCHKCollector;
import com.ncr.agent.baseData.standard.jxfs.dep.CapabilitiesJxfsDEPCollector;
import com.ncr.agent.baseData.standard.jxfs.msd.CapabilitiesJxfsMSDCollector;
import com.ncr.agent.baseData.standard.jxfs.pin.CapabilitiesJxfsPINCollector;
import com.ncr.agent.baseData.standard.jxfs.pin.PINSecureKeyDetailCollector;
import com.ncr.agent.baseData.standard.jxfs.ptr.CapabilitiesJxfsPTRCollector;
import com.ncr.agent.baseData.standard.jxfs.scn.BarcodeCapabilitiesCollector;
import com.ncr.agent.baseData.standard.jxfs.scn.CapabilitiesJxfsSCNCollector;
import com.ncr.agent.baseData.standard.jxfs.scn.ChequeCapabilitiesCollector;
import com.ncr.agent.baseData.standard.jxfs.scn.ImageCapabilitiesCollector;
import com.ncr.agent.baseData.standard.jxfs.scn.ScnCapabilitiesCollector;
import com.ncr.agent.baseData.standard.jxfs.siu.CapabilitiesJxfsSIUCollector;
import com.ncr.agent.baseData.standard.jxfs.tio.CapabilitiesJxfsTIOCollector;
import com.ncr.agent.baseData.standard.jxfs.vdm.CapabilitiesJxfsVDMCollector;

/**
 * The JxfsComponent Pojo.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "jxfs_components")
public class JxfsComponent {

    /** The comboboxes data related to this entity for the query designer. */
    private static final Map<String, Map> comboboxes;

    /** The Constant jxfsClasses. */
    private static final Set<String> jxfsClasses;

    static {
	comboboxes = new TreeMap<String, Map>();
	Map<String, Map> stringOperations = Operation
		.getOperationsByType(Operation.DataType.STRING);
	Map<String, Map> numOperations = Operation
		.getOperationsByType(Operation.DataType.NUMBER);
	comboboxes.put("jxfsClass", stringOperations);
	comboboxes.put("acceptLimit", stringOperations);
	comboboxes.put("autopresent", stringOperations);
	comboboxes.put("auxiliaries", stringOperations);
	comboboxes.put("availableResolution", stringOperations);
	comboboxes.put("baitTrap", stringOperations);
	comboboxes.put("barcodeCapabilities", stringOperations);
	comboboxes.put("beepOnPressSupported", stringOperations);
	comboboxes.put("beepSupported", stringOperations);
	comboboxes.put("billsTakenSensor", stringOperations);
	comboboxes.put("cashbox", stringOperations);
	comboboxes.put("category2", stringOperations);
	comboboxes.put("category3", stringOperations);
	comboboxes.put("cdType", stringOperations);
	comboboxes.put("checkVandalism", stringOperations);
	comboboxes.put("chequeCapabilities", stringOperations);
	comboboxes.put("coins", stringOperations);
	comboboxes.put("complex", stringOperations);
	comboboxes.put("compound", stringOperations);
	comboboxes.put("createSignatureCommandSupported", stringOperations);
	comboboxes.put("ctrlTurn", stringOperations);
	comboboxes.put("cursorSupported", stringOperations);
	comboboxes.put("cylinders", stringOperations);
	comboboxes.put("defaultInputPosition", stringOperations);
	comboboxes.put("defaultOutputPosition", stringOperations);
	comboboxes.put("defaultRollbackPosition", numOperations);
	comboboxes.put("deposit", stringOperations);
	comboboxes.put("detector", stringOperations);
	comboboxes.put("deviceControlName", stringOperations);
	comboboxes.put("deviceId", stringOperations);
	comboboxes.put("deviceOrientation", stringOperations);
	comboboxes.put("deviceScanningBothLongSide", stringOperations);
	comboboxes.put("deviceScanningBothShortSide", stringOperations);
	comboboxes.put("deviceServiceName", stringOperations);
	comboboxes.put("deviceType", stringOperations);
	comboboxes.put("dispense", stringOperations);
	comboboxes.put("displayLightSupported", stringOperations);
	comboboxes.put("keyboardLockSupported", stringOperations);
	comboboxes.put("keyboardSupported", stringOperations);
	comboboxes.put("keysSupported", stringOperations);
	comboboxes.put("doors", stringOperations);
	comboboxes.put("ejectStatus", stringOperations);
	comboboxes.put("entry", stringOperations);
	comboboxes.put("envSupply", stringOperations);
	comboboxes.put("escrow", stringOperations);
	comboboxes.put("escrowSize", numOperations);
	comboboxes.put("eventOnStartSupported", stringOperations);
	comboboxes.put("extent", stringOperations);
	comboboxes.put("guidlights", stringOperations);
	comboboxes.put("idKey", stringOperations);
	comboboxes.put("imageCapture", stringOperations);
	comboboxes.put("imageCapabilities", stringOperations);
	comboboxes.put("indicators", stringOperations);
	comboboxes.put("inputCookSupported", stringOperations);
	comboboxes.put("inputPositions", stringOperations);
	comboboxes.put("inputRawSupported", stringOperations);
	comboboxes.put("intermediateStacker", stringOperations);
	comboboxes.put("insertTextSupported", stringOperations);
	comboboxes.put("maxDataLength", numOperations);
	comboboxes.put("maxInBills", numOperations);
	comboboxes.put("maxInCoins", numOperations);
	comboboxes.put("maxLed", numOperations);
	comboboxes.put("maxNumOfChars", numOperations);
	comboboxes.put("maxOutBills", numOperations);
	comboboxes.put("maxOutCoins", numOperations);
	comboboxes.put("maxPictures", numOperations);
	comboboxes.put("maxRetract", numOperations);
	comboboxes.put("maxStacker", numOperations);
	comboboxes.put("multipleCurrenciesCashInSupported", stringOperations);
	comboboxes.put("numberOfKeys", numOperations);
	comboboxes.put("orientationToBeScanned", stringOperations);
	comboboxes.put("outputPositions", stringOperations);
	comboboxes.put("print", stringOperations);
	comboboxes.put("positions", stringOperations);
	comboboxes.put("powerOff", stringOperations);
	comboboxes.put("powerOn", stringOperations);
	comboboxes.put("ptrCapabilities", stringOperations);
	comboboxes.put("ptrControlMedia", stringOperations);
	comboboxes.put("readForm", stringOperations);
	comboboxes.put("readFonts", stringOperations);
	comboboxes.put("readImage", stringOperations);
	comboboxes.put("readKeyboardDataWithDefault", stringOperations);
	comboboxes.put("readMicr", stringOperations);
	comboboxes.put("readOcr", stringOperations);
	comboboxes.put("readStatus", stringOperations);
	comboboxes.put("refill", stringOperations);
	comboboxes.put("remoteKeyLoad", stringOperations);
	comboboxes.put("retain", stringOperations);
	comboboxes.put("retract", stringOperations);
	comboboxes.put("safeDoorCmd", stringOperations);
	comboboxes.put("safeDoorSequence", stringOperations);
	comboboxes.put("scnCapabilities", stringOperations);
	comboboxes.put("secureKeyDetail", stringOperations);
	comboboxes.put("secureKeyEntryState", stringOperations);
	comboboxes.put("secureKeyEntrySupported", stringOperations);
	comboboxes.put("secureModuleType", stringOperations);
	comboboxes.put("sensors", stringOperations);
	comboboxes.put("status", stringOperations);
	comboboxes.put("supportedChipPresentationModes", stringOperations);
	comboboxes.put("supportedChipProtocols", stringOperations);
	comboboxes.put("supportedCryptoModes", stringOperations);
	comboboxes.put("supportedFdKeys", stringOperations);
	comboboxes.put("supportedPinFormats", stringOperations);
	comboboxes.put("supportedReadTracks", stringOperations);
	comboboxes.put("supportedTextAttributes", stringOperations);
	comboboxes.put("supportedValidationAlgorithms", stringOperations);
	comboboxes.put("supportedWriteHicoTracks", stringOperations);
	comboboxes.put("supportedWriteTracks", stringOperations);
	comboboxes.put("shutterCmd", stringOperations);
	comboboxes.put("silentAlarm", stringOperations);
	comboboxes.put("testCashUnit", stringOperations);
	comboboxes.put("transport", stringOperations);
	comboboxes.put("trustedUser", stringOperations);
	comboboxes.put("unfit", stringOperations);
	comboboxes.put("vendorData", stringOperations);
	comboboxes.put("writeForm", stringOperations);
	comboboxes.put("writeMode", stringOperations);

	jxfsClasses = new HashSet<String>();
	jxfsClasses.add("ALM");
	jxfsClasses.add("CAM");
	jxfsClasses.add("CDR");
	jxfsClasses.add("CHK");
	jxfsClasses.add("DEP");
	jxfsClasses.add("MSD");
	jxfsClasses.add("PIN");
	jxfsClasses.add("PTR");
	jxfsClasses.add("SCN");
	jxfsClasses.add("SIU");
	jxfsClasses.add("TIO");
	jxfsClasses.add("VDM");
    }

    /**
     * Gets the barcode capabilities.
     * 
     * @return the barcode capabilities
     */
    public String getBarcodeCapabilities() {
	return barcodeCapabilities;
    }

    /**
     * Sets the barcode capabilities.
     * 
     * @param barcodeCapabilities
     *            the new barcode capabilities
     */
    public void setBarcodeCapabilities(String barcodeCapabilities) {
	this.barcodeCapabilities = barcodeCapabilities;
    }

    /**
     * Gets the cheque capabilities.
     * 
     * @return the cheque capabilities
     */
    public String getChequeCapabilities() {
	return chequeCapabilities;
    }

    /**
     * Sets the cheque capabilities.
     * 
     * @param chequeCapabilities
     *            the new cheque capabilities
     */
    public void setChequeCapabilities(String chequeCapabilities) {
	this.chequeCapabilities = chequeCapabilities;
    }

    /**
     * Gets the image capabilities.
     * 
     * @return the image capabilities
     */
    public String getImageCapabilities() {
	return imageCapabilities;
    }

    /**
     * Sets the image capabilities.
     * 
     * @param imageCapabilities
     *            the new image capabilities
     */
    public void setImageCapabilities(String imageCapabilities) {
	this.imageCapabilities = imageCapabilities;
    }

    /**
     * Gets the positions.
     * 
     * @return the positions
     */
    public String getPositions() {
	return positions;
    }

    /**
     * Sets the positions.
     * 
     * @param positions
     *            the new positions
     */
    public void setPositions(String positions) {
	this.positions = positions;
    }

    /**
     * Gets the scn capabilities.
     * 
     * @return the scn capabilities
     */
    public String getScnCapabilities() {
	return scnCapabilities;
    }

    /**
     * Sets the scn capabilities.
     * 
     * @param scnCapabilities
     *            the new scn capabilities
     */
    public void setScnCapabilities(String scnCapabilities) {
	this.scnCapabilities = scnCapabilities;
    }

    /**
     * Gets the secure key detail.
     * 
     * @return the secure key detail
     */
    public String getSecureKeyDetail() {
	return secureKeyDetail;
    }

    /**
     * Sets the secure key detail.
     * 
     * @param secureKeyDetail
     *            the new secure key detail
     */
    public void setSecureKeyDetail(String secureKeyDetail) {
	this.secureKeyDetail = secureKeyDetail;
    }

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jxfs_components_id_seq")
    @SequenceGenerator(name = "jxfs_components_id_seq", sequenceName = "jxfs_components_id_seq", allocationSize = 1)
    private Integer id;

    /** The financial devices. */
    @ManyToMany(fetch = FetchType.LAZY)
    @Cascade(CascadeType.REFRESH)
    @JoinTable(name = "financial_device_jxfs_component", joinColumns = { @JoinColumn(name = "jxfs_component_id") }, inverseJoinColumns = { @JoinColumn(name = "financial_device_id") })
    private Set<FinancialDevice> financialDevices = new HashSet<FinancialDevice>();

    /** The jxfs class. */
    @Column(name = "jxfs_class", length = 50, nullable = false)
    private String jxfsClass;

    /** The accept limit. */
    @Column(name = "accept_limit")
    @Type(type = "text")
    private String acceptLimit;

    /** The autopresent. */
    @Column(name = "autopresent")
    @Type(type = "text")
    private String autopresent;

    /** The auxiliaries. */
    @Column(name = "auxiliaries")
    @Type(type = "text")
    private String auxiliaries;

    /** The available resolution. */
    @Column(name = "available_resolution")
    @Type(type = "text")
    private String availableResolution;

    /** The bait trap. */
    @Column(name = "bait_trap")
    @Type(type = "text")
    private String baitTrap;

    /** The barcode capabilities. */
    @Column(name = "barcode_capabilites")
    @Type(type = "text")
    private String barcodeCapabilities;

    /** The beep on press supported. */
    @Column(name = "beep_on_press_supp")
    @Type(type = "text")
    private String beepOnPressSupported;

    /** The beep supported. */
    @Column(name = "beep_supp")
    @Type(type = "text")
    private String beepSupported;

    /** The bills taken sensor. */
    @Column(name = "bills_taken_sensor")
    @Type(type = "text")
    private String billsTakenSensor;

    /** The cashbox. */
    @Column(name = "cashbox")
    @Type(type = "text")
    private String cashbox;

    /** The category2. */
    @Column(name = "category2")
    @Type(type = "text")
    private String category2;

    /** The category3. */
    @Column(name = "category3")
    @Type(type = "text")
    private String category3;

    /** The cd type. */
    @Column(name = "cd_type")
    @Type(type = "text")
    private String cdType;

    /** The check vandalism. */
    @Column(name = "check_vandalism")
    @Type(type = "text")
    private String checkVandalism;

    /** The cheque capabilities. */
    @Column(name = "cheque_capabilities")
    @Type(type = "text")
    private String chequeCapabilities;

    /** The coins. */
    @Column(name = "coins")
    @Type(type = "text")
    private String coins;

    /** The complex. */
    @Column(name = "complex")
    @Type(type = "text")
    private String complex;

    /** The compound. */
    @Column(name = "compound")
    @Type(type = "text")
    private String compound;

    /** The create signature command supported. */
    @Column(name = "create_sign_cmd_supported")
    @Type(type = "text")
    private String createSignatureCommandSupported;

    /** The ctrl turn. */
    @Column(name = "ctrl_turn")
    @Type(type = "text")
    private String ctrlTurn;

    /** The cursor supported. */
    @Column(name = "cursor_supp")
    @Type(type = "text")
    private String cursorSupported;

    /** The cylinders. */
    @Column(name = "cylinders")
    @Type(type = "text")
    private String cylinders;

    /** The default input position. */
    @Column(name = "default_input_position")
    @Type(type = "text")
    private String defaultInputPosition;

    /** The default output position. */
    @Column(name = "default_output_position")
    @Type(type = "text")
    private String defaultOutputPosition;

    /** The default rollback position. */
    @Column(name = "default_rollback_position")
    private Integer defaultRollbackPosition;

    /** The deposit. */
    @Column(name = "deposit")
    @Type(type = "text")
    private String deposit;

    /** The detector. */
    @Column(name = "detector")
    @Type(type = "text")
    private String detector;

    /** The device control name. */
    @Column(name = "device_control_name")
    @Type(type = "text")
    private String deviceControlName;

    /** The device id. */
    @Column(name = "device_id")
    @Type(type = "text")
    private String deviceId;

    /** The device orientation. */
    @Column(name = "device_orientation")
    @Type(type = "text")
    private String deviceOrientation;

    /** The device scanning both long side. */
    @Column(name = "device_scan_both_long_side")
    @Type(type = "text")
    private String deviceScanningBothLongSide;

    /** The device scanning both short side. */
    @Column(name = "device_scan_both_short_side")
    @Type(type = "text")
    private String deviceScanningBothShortSide;

    /** The device service name. */
    @Column(name = "device_service_name")
    @Type(type = "text")
    private String deviceServiceName;

    /** The device type. */
    @Column(name = "device_type")
    @Type(type = "text")
    private String deviceType;

    /** The dispense. */
    @Column(name = "dispense")
    @Type(type = "text")
    private String dispense;

    /** The display light supported. */
    @Column(name = "display_light_supp")
    @Type(type = "text")
    private String displayLightSupported;

    /** The keyboard lock supported. */
    @Column(name = "keyboard_lock_supp")
    @Type(type = "text")
    private String keyboardLockSupported;

    /** The keyboard supported. */
    @Column(name = "keyboard_supp")
    @Type(type = "text")
    private String keyboardSupported;

    /** The keys supported. */
    @Column(name = "keys_supp")
    @Type(type = "text")
    private String keysSupported;

    /** The doors. */
    @Column(name = "doors")
    @Type(type = "text")
    private String doors;

    /** The eject status. */
    @Column(name = "eject_status")
    @Type(type = "text")
    private String ejectStatus;

    /** The entry. */
    @Column(name = "entry")
    @Type(type = "text")
    private String entry;

    /** The env supply. */
    @Column(name = "env_supply")
    @Type(type = "text")
    private String envSupply;

    /** The escrow. */
    @Column(name = "escrow")
    @Type(type = "text")
    private String escrow;

    /** The escrow size. */
    @Column(name = "escrow_size")
    private Integer escrowSize;

    /** The event on start supported. */
    @Column(name = "event_on_start_supp")
    @Type(type = "text")
    private String eventOnStartSupported;

    /** The extent. */
    @Column(name = "extent")
    @Type(type = "text")
    private String extent;

    /** The guidlights. */
    @Column(name = "guidlights")
    @Type(type = "text")
    private String guidlights;

    /** The id key. */
    @Column(name = "id_key")
    @Type(type = "text")
    private String idKey;

    /** The image capabilities. */
    @Column(name = "image_capabilities")
    @Type(type = "text")
    private String imageCapabilities;

    /** The image capture. */
    @Column(name = "image_capture")
    @Type(type = "text")
    private String imageCapture;

    /** The indicators. */
    @Column(name = "indicators")
    @Type(type = "text")
    private String indicators;

    /** The input cook supported. */
    @Column(name = "input_cook_supp")
    @Type(type = "text")
    private String inputCookSupported;

    /** The input positions. */
    @Column(name = "input_positions")
    @Type(type = "text")
    private String inputPositions;

    /** The input raw supported. */
    @Column(name = "input_raw_supp")
    @Type(type = "text")
    private String inputRawSupported;

    /** The intermediate stacker. */
    @Column(name = "intermediate_stacker")
    @Type(type = "text")
    private String intermediateStacker;

    /** The insert text supported. */
    @Column(name = "insert_text_supported")
    @Type(type = "text")
    private String insertTextSupported;

    /** The max data length. */
    @Column(name = "max_data_length")
    private Integer maxDataLength;

    /** The max in bills. */
    @Column(name = "max_in_bills")
    private Integer maxInBills;

    /** The max in coins. */
    @Column(name = "max_in_coins")
    private Integer maxInCoins;

    /** The max led. */
    @Column(name = "max_led")
    private Integer maxLed;

    /** The max num of chars. */
    @Column(name = "max_num_of_chars")
    private Integer maxNumOfChars;

    /** The max out bills. */
    @Column(name = "max_out_bills")
    private Integer maxOutBills;

    /** The max out coins. */
    @Column(name = "max_out_coins")
    private Integer maxOutCoins;

    /** The max pictures. */
    @Column(name = "max_pictures")
    private Integer maxPictures;

    /** The max retract. */
    @Column(name = "max_retract")
    private Integer maxRetract;

    /** The max stacker. */
    @Column(name = "max_stacker")
    private Integer maxStacker;

    /** The multiple currencies cash in supported. */
    @Column(name = "mult_curr_cash_in_supported")
    @Type(type = "text")
    private String multipleCurrenciesCashInSupported;

    /** The number of keys. */
    @Column(name = "number_of_keys")
    private Integer numberOfKeys;

    /** The orientation to be scanned. */
    @Column(name = "orientation_to_be_scanned")
    @Type(type = "text")
    private String orientationToBeScanned;

    /** The output positions. */
    @Column(name = "output_positions")
    @Type(type = "text")
    private String outputPositions;

    /** The print. */
    @Column(name = "print")
    @Type(type = "text")
    private String print;

    /** The positions. */
    @Column(name = "positions")
    @Type(type = "text")
    private String positions;

    /** The power off. */
    @Column(name = "power_off")
    @Type(type = "text")
    private String powerOff;

    /** The power on. */
    @Column(name = "power_on")
    @Type(type = "text")
    private String powerOn;

    /** The ptr capabilities. */
    @Column(name = "ptr_capabilities")
    @Type(type = "text")
    private String ptrCapabilities;

    /** The ptr control media. */
    @Column(name = "ptr_control_media")
    @Type(type = "text")
    private String ptrControlMedia;

    /** The read form. */
    @Column(name = "read_form")
    @Type(type = "text")
    private String readForm;

    /** The read fonts. */
    @Column(name = "read_fonts")
    @Type(type = "text")
    private String readFonts;

    /** The read image. */
    @Column(name = "read_image")
    @Type(type = "text")
    private String readImage;

    /** The read keyboard data with default. */
    @Column(name = "read_keyboard_data_w_default")
    @Type(type = "text")
    private String readKeyboardDataWithDefault;

    /** The read micr. */
    @Column(name = "read_micr")
    @Type(type = "text")
    private String readMicr;

    /** The read ocr. */
    @Column(name = "read_ocr")
    @Type(type = "text")
    private String readOcr;

    /** The read status. */
    @Column(name = "read_status")
    @Type(type = "text")
    private String readStatus;

    /** The refill. */
    @Column(name = "refill")
    @Type(type = "text")
    private String refill;

    /** The remote key load. */
    @Column(name = "remote_key_load")
    @Type(type = "text")
    private String remoteKeyLoad;

    /** The retain. */
    @Column(name = "retain")
    @Type(type = "text")
    private String retain;

    /** The retract. */
    @Column(name = "retract")
    @Type(type = "text")
    private String retract;

    /** The safe door cmd. */
    @Column(name = "safe_door_cmd")
    @Type(type = "text")
    private String safeDoorCmd;

    /** The safe door sequence. */
    @Column(name = "sade_door_seq")
    @Type(type = "text")
    private String safeDoorSequence;

    /** The scn capabilities. */
    @Column(name = "scn_capabilities")
    @Type(type = "text")
    private String scnCapabilities;

    /** The secure key detail. */
    @Column(name = "secure_key_detail")
    @Type(type = "text")
    private String secureKeyDetail;

    /** The secure key entry state. */
    @Column(name = "secure_key_entry_state")
    @Type(type = "text")
    private String secureKeyEntryState;

    /** The secure key entry supported. */
    @Column(name = "secure_key_entry_supp")
    @Type(type = "text")
    private String secureKeyEntrySupported;

    /** The secure module type. */
    @Column(name = "secure_module_type")
    @Type(type = "text")
    private String secureModuleType;

    /** The sensors. */
    @Column(name = "sensors")
    @Type(type = "text")
    private String sensors;

    /** The status. */
    @Column(name = "status")
    @Type(type = "text")
    private String status;

    /** The supported chip presentation modes. */
    @Column(name = "supp_chip_presentation_modes")
    @Type(type = "text")
    private String supportedChipPresentationModes;

    /** The supported chip protocols. */
    @Column(name = "supp_chip_protocols")
    @Type(type = "text")
    private String supportedChipProtocols;

    /** The supported crypto modes. */
    @Column(name = "supp_crypto_modes")
    @Type(type = "text")
    private String supportedCryptoModes;

    /** The supported fd keys. */
    @Column(name = "supp_fd_keys")
    @Type(type = "text")
    private String supportedFdKeys;

    /** The supported pin formats. */
    @Column(name = "supp_pin_formats")
    @Type(type = "text")
    private String supportedPinFormats;

    /** The supported read tracks. */
    @Column(name = "supp_read_tracks")
    @Type(type = "text")
    private String supportedReadTracks;

    /** The supported text attributes. */
    @Column(name = "supp_text_attributes")
    @Type(type = "text")
    private String supportedTextAttributes;

    /** The supported validation algorithms. */
    @Column(name = "supp_validation_algorithms")
    @Type(type = "text")
    private String supportedValidationAlgorithms;

    /** The supported write hico tracks. */
    @Column(name = "supp_write_hico_tracks")
    @Type(type = "text")
    private String supportedWriteHicoTracks;

    /** The supported write tracks. */
    @Column(name = "supp_write_tracks")
    @Type(type = "text")
    private String supportedWriteTracks;

    /** The shutter cmd. */
    @Column(name = "shutter_cmd")
    @Type(type = "text")
    private String shutterCmd;

    /** The silent alarm. */
    @Column(name = "silent_alarm")
    @Type(type = "text")
    private String silentAlarm;

    /** The test cash unit. */
    @Column(name = "test_cash_unit")
    @Type(type = "text")
    private String testCashUnit;

    /** The transport. */
    @Column(name = "transport")
    @Type(type = "text")
    private String transport;

    /** The trusted user. */
    @Column(name = "trusted_user")
    @Type(type = "text")
    private String trustedUser;

    /** The unfit. */
    @Column(name = "unfit")
    @Type(type = "text")
    private String unfit;

    /** The vendor data. */
    @Column(name = "vendor_data")
    @Type(type = "text")
    private String vendorData;

    // @Column(name = "vendor_info")
    // @Type(type = "text")
    // private String vendorInfo;

    /** The write form. */
    @Column(name = "write_form")
    @Type(type = "text")
    private String writeForm;

    /** The write mode. */
    @Column(name = "write_mode")
    @Type(type = "text")
    private String writeMode;

    /**
     * Instantiates a new jxfs component.
     */
    public JxfsComponent() {
    }

    /**
     * Instantiates a new jxfs component with the given ALM data from the agent.
     * 
     * @param jxfs
     *            the ALM
     */
    public JxfsComponent(CapabilitiesJxfsALMCollector jxfs) {
	jxfsClass = "ALM";
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	// setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
	// .getVendorinfo())));
    }

    /**
     * Instantiates a new jxfs component with the given CAM data from the agent.
     * 
     * @param jxfs
     *            the CAM
     */
    public JxfsComponent(CapabilitiesJxfsCAMCollector jxfs) {
	jxfsClass = "CAM";
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	insertTextSupported = jxfs.getInserttextsupported();
	maxDataLength = jxfs.getMaxdatalength();
	maxPictures = jxfs.getMaxpictures();
	// setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
	// .getVendorinfo())));
    }

    /**
     * Instantiates a new jxfs component with the given CDR data from the agent.
     * 
     * @param jxfs
     *            the CDR
     */
    public JxfsComponent(CapabilitiesJxfsCDRCollector jxfs) {
	jxfsClass = "CDR";
	acceptLimit = jxfs.getAcceptlimit();
	autopresent = jxfs.getAutopresent();
	baitTrap = jxfs.getBaittrap();
	billsTakenSensor = jxfs.getBillstakensensor();
	cashbox = jxfs.getCashbox();
	category2 = jxfs.getCategory2();
	category3 = jxfs.getCategory3();
	cdType = jxfs.getCdtype();
	checkVandalism = jxfs.getCheckvandalism();
	coins = jxfs.getCoins();
	compound = jxfs.getCompound();
	createSignatureCommandSupported = jxfs
		.getCreatesignaturecommandsupported();
	cylinders = jxfs.getCylinders();
	defaultInputPosition = jxfs.getDefaultinputposition();
	defaultOutputPosition = jxfs.getDefaultoutputposition();
	defaultRollbackPosition = jxfs.getDefaultrollbackposition();
	deposit = jxfs.getDeposit();
	detector = jxfs.getDetector();
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceOrientation = jxfs.getDeviceorientation();
	deviceScanningBothLongSide = jxfs.getDevicescanningbothlongside();
	deviceScanningBothShortSide = jxfs.getDevicescanningbothshortside();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	dispense = jxfs.getDispense();
	escrow = jxfs.getEscrow();
	escrowSize = jxfs.getEscrowsize();
	inputPositions = jxfs.getInputpositions();
	intermediateStacker = jxfs.getIntermediatestacker();
	maxInBills = jxfs.getMaxinbills();
	maxInCoins = jxfs.getMaxincoins();
	maxOutBills = jxfs.getMaxoutbills();
	maxOutCoins = jxfs.getMaxoutcoins();
	multipleCurrenciesCashInSupported = jxfs
		.getMultiplecurrenciescashinsupported();
	orientationToBeScanned = jxfs.getOrientationtobescanned();
	outputPositions = jxfs.getOutputpositions();
	positions = (jxfs.getPositions() != null) ? Utils.toJson(jxfs
		.getPositions().toArray(new PositionsJxfsCDRCollector[0]))
		: null;
	refill = jxfs.getRefill();
	retract = jxfs.getRetract();
	safeDoorCmd = jxfs.getSafedoorcmd();
	safeDoorSequence = jxfs.getSafedoorsequence();
	shutterCmd = jxfs.getShuttercmd();
	silentAlarm = jxfs.getSilentalarm();
	testCashUnit = jxfs.getTestcashunit();
	trustedUser = jxfs.getTrusteduser();
	unfit = jxfs.getUnfit();
	vendorData = jxfs.getVendordata();
	// setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
	// .getVendorinfo())));
    }

    /**
     * Instantiates a new jxfs component with the given CHK data from the agent.
     * 
     * @param jxfs
     *            the CHK
     */
    public JxfsComponent(CapabilitiesJxfsCHKCollector jxfs) {
	jxfsClass = "CHK";
	complex = jxfs.getComplex();
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	imageCapture = jxfs.getImagecapture();
	readFonts = jxfs.getReadfonts();
	readMicr = jxfs.getReadmicr();
	readOcr = jxfs.getReadocr();
	// setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
	// .getVendorinfo())));
    }

    /**
     * Instantiates a new jxfs component with the given DEP data from the agent.
     * 
     * @param jxfs
     *            the DEP
     */
    public JxfsComponent(CapabilitiesJxfsDEPCollector jxfs) {
	jxfsClass = "DEP";
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	entry = jxfs.getEntry();
	envSupply = jxfs.getEnvsupply();
	maxNumOfChars = jxfs.getMaxnumofchars();
	print = jxfs.getPrint();
	readImage = jxfs.getReadimage();
	retract = jxfs.getRetract();
	transport = jxfs.getTransport();
    }

    /**
     * Instantiates a new jxfs component with the given MSD data from the agent.
     * 
     * @param jxfs
     *            the MSD
     */
    public JxfsComponent(CapabilitiesJxfsMSDCollector jxfs) {
	jxfsClass = "MSD";
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	powerOff = jxfs.getPoweroff();
	powerOn = jxfs.getPoweron();
	retain = jxfs.getRetain();
	secureModuleType = jxfs.getSecuremoduletype();
	supportedChipProtocols = jxfs.getSupportedchipprotocols();
	supportedReadTracks = jxfs.getSupportedreadtracks();
	supportedWriteHicoTracks = jxfs.getSupportedwritehicotracks();
	supportedWriteTracks = jxfs.getSupportedwritetracks();
	// setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
	// .getVendorinfo())));
	writeMode = jxfs.getWritemode();
    }

    /**
     * Instantiates a new jxfs component with the given PIN data from the agent.
     * 
     * @param jxfs
     *            the PIN
     */
    public JxfsComponent(CapabilitiesJxfsPINCollector jxfs) {
	jxfsClass = "PIN";
	beepOnPressSupported = jxfs.getBeeponpresssupported();
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	eventOnStartSupported = jxfs.getEventonstartsupported();
	idKey = jxfs.getIdkey();
	inputCookSupported = jxfs.getInputcookedsupported();
	inputRawSupported = jxfs.getInputrawsupported();
	numberOfKeys = jxfs.getNumberofkeys();
	remoteKeyLoad = jxfs.getRemotekeyload();
	secureKeyDetail = (jxfs.getSecurekeydetail() != null) ? Utils
		.toJson(jxfs.getSecurekeydetail().toArray(
			new PINSecureKeyDetailCollector[0])) : null;
	secureKeyEntryState = jxfs.getSecurekeyentrystate();
	secureKeyEntrySupported = jxfs.getSecurekeyentrysupported();
	supportedChipPresentationModes = jxfs
		.getSupportedchippresentationmodes();
	supportedCryptoModes = jxfs.getSupportedcryptomodes();
	supportedFdKeys = jxfs.getSupportedfdkeys();
	supportedPinFormats = jxfs.getSupportedpinformats();
	supportedValidationAlgorithms = jxfs.getSupportedvalidationalgorithms();
	// setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
	// .getVendorinfo())));
    }

    /**
     * Instantiates a new jxfs component with the given PTR data from the agent.
     * 
     * @param jxfs
     *            the PTR
     */
    public JxfsComponent(CapabilitiesJxfsPTRCollector jxfs) {
	jxfsClass = "PTR";
	ctrlTurn = jxfs.getCtrlturn();
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	ejectStatus = jxfs.getEjectstatus();
	extent = jxfs.getExtent();
	maxRetract = jxfs.getMaxretract();
	maxStacker = jxfs.getMaxstacker();
	ptrCapabilities = jxfs.getPtrcapabilities();
	ptrControlMedia = jxfs.getPtrcontrolmedia();
	readForm = jxfs.getReadform();
	readImage = jxfs.getReadimage();
	readStatus = jxfs.getReadstatus();
	status = jxfs.getStatus();
	// setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
	// .getVendorinfo())));
	writeForm = jxfs.getWriteform();
    }

    /**
     * Instantiates a new jxfs component with the given SCN data from the agent.
     * 
     * @param jxfs
     *            the SCN
     */
    public JxfsComponent(CapabilitiesJxfsSCNCollector jxfs) {
	jxfsClass = "SCN";
	barcodeCapabilities = (jxfs.getBarcodecapabilities() != null) ? Utils
		.toJson(jxfs.getBarcodecapabilities().toArray(
			new BarcodeCapabilitiesCollector[0])) : null;
	chequeCapabilities = (jxfs.getChequecapabilities() != null) ? Utils
		.toJson(jxfs.getChequecapabilities().toArray(
			new ChequeCapabilitiesCollector[0])) : null;
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	imageCapabilities = (jxfs.getImagecapabilities() != null) ? Utils
		.toJson(jxfs.getImagecapabilities().toArray(
			new ImageCapabilitiesCollector[0])) : null;
	scnCapabilities = (jxfs.getScncapabilities() != null) ? Utils
		.toJson(jxfs.getScncapabilities().toArray(
			new ScnCapabilitiesCollector[0])) : null;
	// setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
	// .getVendorinfo())));
    }

    /**
     * Instantiates a new jxfs component with the given SIU data from the agent.
     * 
     * @param jxfs
     *            the SIU
     */
    public JxfsComponent(CapabilitiesJxfsSIUCollector jxfs) {
	jxfsClass = "SIU";
	auxiliaries = jxfs.getAuxiliaries();
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	doors = jxfs.getDoors();
	guidlights = jxfs.getGuidlights();
	indicators = jxfs.getIndicators();
	sensors = jxfs.getSensors();
	// setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
	// .getVendorinfo())));
    }

    /**
     * Instantiates a new jxfs component with the given TIO data from the agent.
     * 
     * @param jxfs
     *            the TIO
     */
    public JxfsComponent(CapabilitiesJxfsTIOCollector jxfs) {
	jxfsClass = "TIO";
	availableResolution = jxfs.getAvailableresolution();
	beepSupported = jxfs.getBeepsupported();
	cursorSupported = jxfs.getCursorsupported();
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	displayLightSupported = jxfs.getDisplaylightsupported();
	keyboardLockSupported = jxfs.getKeyboardlocksupported();
	keyboardSupported = jxfs.getKeyboardsupported();
	keysSupported = jxfs.getKeyssupported();
	maxLed = jxfs.getMaxled();
	readKeyboardDataWithDefault = jxfs.getReadkeyboarddatawithdefault();
	supportedTextAttributes = jxfs.getSupportedtextattributes();
	// setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
	// .getVendorinfo())));
    }

    /**
     * Instantiates a new jxfs component with the given VDM data from the agent.
     * 
     * @param jxfs
     *            the VDM
     */
    public JxfsComponent(CapabilitiesJxfsVDMCollector jxfs) {
	jxfsClass = "VDM";
	deviceControlName = jxfs.getDevicecontrolname();
	deviceId = jxfs.getDeviceid();
	deviceServiceName = jxfs.getDeviceservicename();
	deviceType = jxfs.getDevicetype();
	// setVendorInfoSplit(new ArrayList<String>(Arrays.asList(jxfs
	// .getVendorinfo())));
    }

    /**
     * Instantiates a new agent specific jxfs component data with the current
     * attributes.
     * 
     * @return the agent jxfs component data
     */
    public Object getInventoryPojo() {
	if (jxfsClass == null) {
	    return null;
	}

	if (jxfsClass.equals("ALM")) {
	    CapabilitiesJxfsALMCollector pojo = new CapabilitiesJxfsALMCollector();
	    pojo.setDevicecontrolname(deviceControlName);
	    pojo.setDeviceid(deviceId);
	    pojo.setDeviceservicename(deviceServiceName);
	    pojo.setDevicetype(deviceType);
	    return pojo;
	}

	if (jxfsClass.equals("CAM")) {
	    CapabilitiesJxfsCAMCollector pojo = new CapabilitiesJxfsCAMCollector();
	    pojo.setDevicecontrolname(deviceControlName);
	    pojo.setDeviceid(deviceId);
	    pojo.setDeviceservicename(deviceServiceName);
	    pojo.setDevicetype(deviceType);
	    pojo.setInserttextsupported(insertTextSupported);
	    if (maxDataLength != null) {
		pojo.setMaxdatalength(maxDataLength);
	    }
	    if (maxPictures != null) {
		pojo.setMaxpictures(maxPictures);
	    }
	    return pojo;
	}

	if (jxfsClass.equals("CDR")) {
	    CapabilitiesJxfsCDRCollector pojo = new CapabilitiesJxfsCDRCollector();
	    pojo.setAcceptlimit(acceptLimit);
	    pojo.setAutopresent(autopresent);
	    pojo.setBaittrap(baitTrap);
	    pojo.setBillstakensensor(billsTakenSensor);
	    pojo.setCashbox(cashbox);
	    pojo.setCategory2(category2);
	    pojo.setCategory3(category3);
	    pojo.setCdtype(cdType);
	    pojo.setCheckvandalism(checkVandalism);
	    pojo.setCoins(coins);
	    pojo.setCompound(compound);
	    pojo.setCreatesignaturecommandsupported(createSignatureCommandSupported);
	    pojo.setCylinders(cylinders);
	    pojo.setDefaultinputposition(defaultInputPosition);
	    pojo.setDefaultoutputposition(defaultOutputPosition);
	    if (defaultRollbackPosition != null) {
		pojo.setDefaultrollbackposition(defaultRollbackPosition);
	    }
	    pojo.setDeposit(deposit);
	    pojo.setDetector(detector);
	    pojo.setDevicecontrolname(deviceControlName);
	    pojo.setDeviceid(deviceId);
	    pojo.setDeviceorientation(deviceOrientation);
	    pojo.setDevicescanningbothlongside(deviceScanningBothLongSide);
	    pojo.setDevicescanningbothshortside(deviceScanningBothShortSide);
	    pojo.setDeviceservicename(deviceServiceName);
	    pojo.setDevicetype(deviceType);
	    pojo.setDispense(dispense);
	    pojo.setEscrow(escrow);
	    if (escrowSize != null) {
		pojo.setEscrowsize(escrowSize);
	    }
	    pojo.setInputpositions(inputPositions);
	    pojo.setIntermediatestacker(intermediateStacker);
	    if (maxInBills != null) {
		pojo.setMaxinbills(maxInBills);
	    }
	    if (maxInCoins != null) {
		pojo.setMaxincoins(maxInCoins);
	    }
	    if (maxOutBills != null) {
		pojo.setMaxoutbills(maxOutBills);
	    }
	    if (maxOutCoins != null) {
		pojo.setMaxoutcoins(maxOutCoins);
	    }
	    pojo.setMultiplecurrenciescashinsupported(multipleCurrenciesCashInSupported);
	    pojo.setOrientationtobescanned(orientationToBeScanned);
	    pojo.setOutputpositions(outputPositions);
	    if (positions != null) {
		pojo.setPositions(new Vector(
			Arrays.asList(Utils.fromJson(positions,
				new PositionsJxfsCDRCollector[0].getClass()))));
	    }
	    pojo.setRefill(refill);
	    pojo.setRetract(retract);
	    pojo.setSafedoorcmd(safeDoorCmd);
	    pojo.setSafedoorsequence(safeDoorSequence);
	    pojo.setShuttercmd(shutterCmd);
	    pojo.setSilentalarm(silentAlarm);
	    pojo.setTestcashunit(testCashUnit);
	    pojo.setTrusteduser(trustedUser);
	    pojo.setUnfit(unfit);
	    pojo.setVendordata(vendorData);
	    return pojo;
	}

	if (jxfsClass.equals("CHK")) {
	    CapabilitiesJxfsCHKCollector pojo = new CapabilitiesJxfsCHKCollector();
	    pojo.setComplex(complex);
	    pojo.setDevicecontrolname(deviceControlName);
	    pojo.setDeviceid(deviceId);
	    pojo.setDeviceservicename(deviceServiceName);
	    pojo.setDevicetype(deviceType);
	    pojo.setImagecapture(imageCapture);
	    pojo.setReadfonts(readFonts);
	    pojo.setReadmicr(readMicr);
	    pojo.setReadocr(readOcr);
	    return pojo;
	}

	if (jxfsClass.equals("DEP")) {
	    CapabilitiesJxfsDEPCollector pojo = new CapabilitiesJxfsDEPCollector();
	    pojo.setDevicecontrolname(deviceControlName);
	    pojo.setDeviceid(deviceId);
	    pojo.setDeviceservicename(deviceServiceName);
	    pojo.setDevicetype(deviceType);
	    pojo.setEntry(entry);
	    pojo.setEnvsupply(envSupply);
	    if (maxNumOfChars != null) {
		pojo.setMaxnumofchars(maxNumOfChars);
	    }
	    pojo.setPrint(print);
	    pojo.setReadimage(readImage);
	    pojo.setRetract(retract);
	    pojo.setTransport(transport);
	    return pojo;
	}

	if (jxfsClass.equals("MSD")) {
	    CapabilitiesJxfsMSDCollector pojo = new CapabilitiesJxfsMSDCollector();
	    pojo.setDevicecontrolname(deviceControlName);
	    pojo.setDeviceid(deviceId);
	    pojo.setDeviceservicename(deviceServiceName);
	    pojo.setDevicetype(deviceType);
	    pojo.setPoweroff(powerOff);
	    pojo.setPoweron(powerOn);
	    pojo.setRetain(retain);
	    pojo.setSecuremoduletype(secureModuleType);
	    pojo.setSupportedchipprotocols(supportedChipProtocols);
	    pojo.setSupportedreadtracks(supportedReadTracks);
	    pojo.setSupportedwritehicotracks(supportedWriteHicoTracks);
	    pojo.setSupportedwritetracks(supportedWriteTracks);
	    pojo.setWritemode(writeMode);
	    return pojo;
	}

	if (jxfsClass.equals("PIN")) {
	    CapabilitiesJxfsPINCollector pojo = new CapabilitiesJxfsPINCollector();
	    pojo.setBeeponpresssupported(beepOnPressSupported);
	    pojo.setDevicecontrolname(deviceControlName);
	    pojo.setDeviceid(deviceId);
	    pojo.setDeviceservicename(deviceServiceName);
	    pojo.setDevicetype(deviceType);
	    pojo.setEventonstartsupported(eventOnStartSupported);
	    pojo.setIdkey(idKey);
	    pojo.setInputcookedsupported(inputCookSupported);
	    pojo.setInputrawsupported(inputRawSupported);
	    pojo.setNumberofkeys(numberOfKeys);
	    pojo.setRemotekeyload(remoteKeyLoad);
	    if (secureKeyDetail != null) {
		pojo.setSecurekeydetail(new Vector(Arrays.asList(Utils
			.fromJson(secureKeyDetail,
				new PINSecureKeyDetailCollector[0].getClass()))));
	    }
	    pojo.setSecurekeyentrystate(secureKeyEntryState);
	    pojo.setSecurekeyentrysupported(secureKeyEntrySupported);
	    pojo.setSupportedchippresentationmodes(supportedChipPresentationModes);
	    pojo.setSupportedcryptomodes(supportedCryptoModes);
	    pojo.setSupportedfdkeys(supportedFdKeys);
	    pojo.setSupportedpinformats(supportedPinFormats);
	    pojo.setSupportedvalidationalgorithms(supportedValidationAlgorithms);
	    return pojo;
	}

	if (jxfsClass.equals("PTR")) {
	    CapabilitiesJxfsPTRCollector pojo = new CapabilitiesJxfsPTRCollector();
	    pojo.setCtrlturn(ctrlTurn);
	    pojo.setDevicecontrolname(deviceControlName);
	    pojo.setDeviceid(deviceId);
	    pojo.setDeviceservicename(deviceServiceName);
	    pojo.setDevicetype(deviceType);
	    pojo.setEjectstatus(ejectStatus);
	    pojo.setExtent(extent);
	    if (maxRetract != null) {
		pojo.setMaxretract(maxRetract);
	    }
	    if (maxStacker != null) {
		pojo.setMaxstacker(maxStacker);
	    }
	    pojo.setPtrcapabilities(ptrCapabilities);
	    pojo.setPtrcontrolmedia(ptrControlMedia);
	    pojo.setReadform(readForm);
	    pojo.setReadimage(readImage);
	    pojo.setReadstatus(readStatus);
	    pojo.setStatus(status);
	    pojo.setWriteform(writeForm);
	    return pojo;
	}

	if (jxfsClass.equals("SCN")) {
	    CapabilitiesJxfsSCNCollector pojo = new CapabilitiesJxfsSCNCollector();
	    if (barcodeCapabilities != null) {
		pojo.setBarcodecapabilities(new Vector(
			Arrays.asList(Utils.fromJson(barcodeCapabilities,
				new BarcodeCapabilitiesCollector[0].getClass()))));
	    }
	    if (chequeCapabilities != null) {
		pojo.setChequecapabilities(new Vector(Arrays.asList(Utils
			.fromJson(chequeCapabilities,
				new ChequeCapabilitiesCollector[0].getClass()))));
	    }
	    if (imageCapabilities != null) {
		pojo.setImagecapabilities(new Vector(Arrays.asList(Utils
			.fromJson(imageCapabilities,
				new ImageCapabilitiesCollector[0].getClass()))));
	    }
	    if (scnCapabilities != null) {
		pojo.setScncapabilities(new Vector(Arrays.asList(Utils
			.fromJson(scnCapabilities,
				new ScnCapabilitiesCollector[0].getClass()))));
	    }
	    pojo.setDevicecontrolname(deviceControlName);
	    pojo.setDeviceid(deviceId);
	    pojo.setDeviceservicename(deviceServiceName);
	    pojo.setDevicetype(deviceType);
	    return pojo;
	}

	if (jxfsClass.equals("SIU")) {
	    CapabilitiesJxfsSIUCollector pojo = new CapabilitiesJxfsSIUCollector();
	    pojo.setAuxiliaries(auxiliaries);
	    pojo.setDevicecontrolname(deviceControlName);
	    pojo.setDeviceid(deviceId);
	    pojo.setDeviceservicename(deviceServiceName);
	    pojo.setDevicetype(deviceType);
	    pojo.setDoors(doors);
	    pojo.setGuidlights(guidlights);
	    pojo.setIndicators(indicators);
	    pojo.setSensors(sensors);
	    return pojo;
	}

	if (jxfsClass.equals("TIO")) {
	    CapabilitiesJxfsTIOCollector pojo = new CapabilitiesJxfsTIOCollector();
	    pojo.setAvailableresolution(availableResolution);
	    pojo.setBeepsupported(beepSupported);
	    pojo.setCursorsupported(cursorSupported);
	    pojo.setDevicecontrolname(deviceControlName);
	    pojo.setDeviceid(deviceId);
	    pojo.setDeviceservicename(deviceServiceName);
	    pojo.setDevicetype(deviceType);
	    pojo.setDisplaylightsupported(displayLightSupported);
	    pojo.setKeyboardlocksupported(keyboardLockSupported);
	    pojo.setKeyboardsupported(keyboardSupported);
	    pojo.setKeyssupported(keysSupported);
	    if (maxLed != null) {
		pojo.setMaxled(maxLed);
	    }
	    pojo.setReadkeyboarddatawithdefault(readKeyboardDataWithDefault);
	    pojo.setSupportedtextattributes(supportedTextAttributes);
	    return pojo;
	}

	if (jxfsClass.equals("VDM")) {
	    CapabilitiesJxfsVDMCollector pojo = new CapabilitiesJxfsVDMCollector();
	    pojo.setDevicecontrolname(deviceControlName);
	    pojo.setDeviceid(deviceId);
	    pojo.setDeviceservicename(deviceServiceName);
	    pojo.setDevicetype(deviceType);
	    return pojo;
	}

	return null;
    }

    // /**
    // * @param vendor
    // * info the vendor info as a List<String> to set
    // */
    // public void setVendorInfoSplit(List<String> vendorInfo) {
    // this.vendorInfo = Utils.concatStrings(vendorInfo,
    // JxfsComponent.separator);
    // }

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
     *            the new id
     */
    public void setId(Integer id) {
	this.id = id;
    }

    /**
     * Gets the financial devices.
     * 
     * @return the financial devices
     */
    public Set<FinancialDevice> getFinancialDevices() {
	return financialDevices;
    }

    /**
     * Sets the financial devices.
     * 
     * @param financialDevices
     *            the new financial devices
     */
    public void setFinancialDevices(Set<FinancialDevice> financialDevices) {
	this.financialDevices = financialDevices;
    }

    /**
     * Gets the jxfs class.
     * 
     * @return the jxfs class
     */
    public String getJxfsClass() {
	return jxfsClass;
    }

    /**
     * Sets the jxfs class.
     * 
     * @param jxfsClass
     *            the new jxfs class
     */
    public void setJxfsClass(String jxfsClass) {
	this.jxfsClass = jxfsClass;
    }

    /**
     * Gets the accept limit.
     * 
     * @return the accept limit
     */
    public String getAcceptLimit() {
	return acceptLimit;
    }

    /**
     * Sets the accept limit.
     * 
     * @param acceptLimit
     *            the new accept limit
     */
    public void setAcceptLimit(String acceptLimit) {
	this.acceptLimit = acceptLimit;
    }

    /**
     * Gets the autopresent.
     * 
     * @return the autopresent
     */
    public String getAutopresent() {
	return autopresent;
    }

    /**
     * Sets the autopresent.
     * 
     * @param autopresent
     *            the new autopresent
     */
    public void setAutopresent(String autopresent) {
	this.autopresent = autopresent;
    }

    /**
     * Gets the auxiliaries.
     * 
     * @return the auxiliaries
     */
    public String getAuxiliaries() {
	return auxiliaries;
    }

    /**
     * Sets the auxiliaries.
     * 
     * @param auxiliaries
     *            the new auxiliaries
     */
    public void setAuxiliaries(String auxiliaries) {
	this.auxiliaries = auxiliaries;
    }

    /**
     * Gets the available resolution.
     * 
     * @return the available resolution
     */
    public String getAvailableResolution() {
	return availableResolution;
    }

    /**
     * Sets the available resolution.
     * 
     * @param availableResolution
     *            the new available resolution
     */
    public void setAvailableResolution(String availableResolution) {
	this.availableResolution = availableResolution;
    }

    /**
     * Gets the bait trap.
     * 
     * @return the bait trap
     */
    public String getBaitTrap() {
	return baitTrap;
    }

    /**
     * Sets the bait trap.
     * 
     * @param baitTrap
     *            the new bait trap
     */
    public void setBaitTrap(String baitTrap) {
	this.baitTrap = baitTrap;
    }

    /**
     * Gets the beep on press supported.
     * 
     * @return the beep on press supported
     */
    public String getBeepOnPressSupported() {
	return beepOnPressSupported;
    }

    /**
     * Sets the beep on press supported.
     * 
     * @param beepOnPressSupported
     *            the new beep on press supported
     */
    public void setBeepOnPressSupported(String beepOnPressSupported) {
	this.beepOnPressSupported = beepOnPressSupported;
    }

    /**
     * Gets the beep supported.
     * 
     * @return the beep supported
     */
    public String getBeepSupported() {
	return beepSupported;
    }

    /**
     * Sets the beep supported.
     * 
     * @param beepSupported
     *            the new beep supported
     */
    public void setBeepSupported(String beepSupported) {
	this.beepSupported = beepSupported;
    }

    /**
     * Gets the bills taken sensor.
     * 
     * @return the bills taken sensor
     */
    public String getBillsTakenSensor() {
	return billsTakenSensor;
    }

    /**
     * Sets the bills taken sensor.
     * 
     * @param billsTakenSensor
     *            the new bills taken sensor
     */
    public void setBillsTakenSensor(String billsTakenSensor) {
	this.billsTakenSensor = billsTakenSensor;
    }

    /**
     * Gets the cashbox.
     * 
     * @return the cashbox
     */
    public String getCashbox() {
	return cashbox;
    }

    /**
     * Sets the cashbox.
     * 
     * @param cashbox
     *            the new cashbox
     */
    public void setCashbox(String cashbox) {
	this.cashbox = cashbox;
    }

    /**
     * Gets the category2.
     * 
     * @return the category2
     */
    public String getCategory2() {
	return category2;
    }

    /**
     * Sets the category2.
     * 
     * @param category2
     *            the new category2
     */
    public void setCategory2(String category2) {
	this.category2 = category2;
    }

    /**
     * Gets the category3.
     * 
     * @return the category3
     */
    public String getCategory3() {
	return category3;
    }

    /**
     * Sets the category3.
     * 
     * @param category3
     *            the new category3
     */
    public void setCategory3(String category3) {
	this.category3 = category3;
    }

    /**
     * Gets the cd type.
     * 
     * @return the cd type
     */
    public String getCdType() {
	return cdType;
    }

    /**
     * Sets the cd type.
     * 
     * @param cdType
     *            the new cd type
     */
    public void setCdType(String cdType) {
	this.cdType = cdType;
    }

    /**
     * Gets the check vandalism.
     * 
     * @return the check vandalism
     */
    public String getCheckVandalism() {
	return checkVandalism;
    }

    /**
     * Sets the check vandalism.
     * 
     * @param checkVandalism
     *            the new check vandalism
     */
    public void setCheckVandalism(String checkVandalism) {
	this.checkVandalism = checkVandalism;
    }

    /**
     * Gets the coins.
     * 
     * @return the coins
     */
    public String getCoins() {
	return coins;
    }

    /**
     * Sets the coins.
     * 
     * @param coins
     *            the new coins
     */
    public void setCoins(String coins) {
	this.coins = coins;
    }

    /**
     * Gets the complex.
     * 
     * @return the complex
     */
    public String getComplex() {
	return complex;
    }

    /**
     * Sets the complex.
     * 
     * @param complex
     *            the new complex
     */
    public void setComplex(String complex) {
	this.complex = complex;
    }

    /**
     * Gets the compound.
     * 
     * @return the compound
     */
    public String getCompound() {
	return compound;
    }

    /**
     * Sets the compound.
     * 
     * @param compound
     *            the new compound
     */
    public void setCompound(String compound) {
	this.compound = compound;
    }

    /**
     * Gets the creates the signature command supported.
     * 
     * @return the creates the signature command supported
     */
    public String getCreateSignatureCommandSupported() {
	return createSignatureCommandSupported;
    }

    /**
     * Sets the creates the signature command supported.
     * 
     * @param createSignatureCommandSupported
     *            the new creates the signature command supported
     */
    public void setCreateSignatureCommandSupported(
	    String createSignatureCommandSupported) {
	this.createSignatureCommandSupported = createSignatureCommandSupported;
    }

    /**
     * Gets the ctrl turn.
     * 
     * @return the ctrl turn
     */
    public String getCtrlTurn() {
	return ctrlTurn;
    }

    /**
     * Sets the ctrl turn.
     * 
     * @param ctrlTurn
     *            the new ctrl turn
     */
    public void setCtrlTurn(String ctrlTurn) {
	this.ctrlTurn = ctrlTurn;
    }

    /**
     * Gets the cursor supported.
     * 
     * @return the cursor supported
     */
    public String getCursorSupported() {
	return cursorSupported;
    }

    /**
     * Sets the cursor supported.
     * 
     * @param cursorSupported
     *            the new cursor supported
     */
    public void setCursorSupported(String cursorSupported) {
	this.cursorSupported = cursorSupported;
    }

    /**
     * Gets the cylinders.
     * 
     * @return the cylinders
     */
    public String getCylinders() {
	return cylinders;
    }

    /**
     * Sets the cylinders.
     * 
     * @param cylinders
     *            the new cylinders
     */
    public void setCylinders(String cylinders) {
	this.cylinders = cylinders;
    }

    /**
     * Gets the default input position.
     * 
     * @return the default input position
     */
    public String getDefaultInputPosition() {
	return defaultInputPosition;
    }

    /**
     * Sets the default input position.
     * 
     * @param defaultInputPosition
     *            the new default input position
     */
    public void setDefaultInputPosition(String defaultInputPosition) {
	this.defaultInputPosition = defaultInputPosition;
    }

    /**
     * Gets the default output position.
     * 
     * @return the default output position
     */
    public String getDefaultOutputPosition() {
	return defaultOutputPosition;
    }

    /**
     * Sets the default output position.
     * 
     * @param defaultOutputPosition
     *            the new default output position
     */
    public void setDefaultOutputPosition(String defaultOutputPosition) {
	this.defaultOutputPosition = defaultOutputPosition;
    }

    /**
     * Gets the default rollback position.
     * 
     * @return the default rollback position
     */
    public Integer getDefaultRollbackPosition() {
	return defaultRollbackPosition;
    }

    /**
     * Sets the default rollback position.
     * 
     * @param defaultRollbackPosition
     *            the new default rollback position
     */
    public void setDefaultRollbackPosition(Integer defaultRollbackPosition) {
	this.defaultRollbackPosition = defaultRollbackPosition;
    }

    /**
     * Gets the deposit.
     * 
     * @return the deposit
     */
    public String getDeposit() {
	return deposit;
    }

    /**
     * Sets the deposit.
     * 
     * @param deposit
     *            the new deposit
     */
    public void setDeposit(String deposit) {
	this.deposit = deposit;
    }

    /**
     * Gets the detector.
     * 
     * @return the detector
     */
    public String getDetector() {
	return detector;
    }

    /**
     * Sets the detector.
     * 
     * @param detector
     *            the new detector
     */
    public void setDetector(String detector) {
	this.detector = detector;
    }

    /**
     * Gets the device control name.
     * 
     * @return the device control name
     */
    public String getDeviceControlName() {
	return deviceControlName;
    }

    /**
     * Sets the device control name.
     * 
     * @param deviceControlName
     *            the new device control name
     */
    public void setDeviceControlName(String deviceControlName) {
	this.deviceControlName = deviceControlName;
    }

    /**
     * Gets the device id.
     * 
     * @return the device id
     */
    public String getDeviceId() {
	return deviceId;
    }

    /**
     * Sets the device id.
     * 
     * @param deviceId
     *            the new device id
     */
    public void setDeviceId(String deviceId) {
	this.deviceId = deviceId;
    }

    /**
     * Gets the device orientation.
     * 
     * @return the device orientation
     */
    public String getDeviceOrientation() {
	return deviceOrientation;
    }

    /**
     * Sets the device orientation.
     * 
     * @param deviceOrientation
     *            the new device orientation
     */
    public void setDeviceOrientation(String deviceOrientation) {
	this.deviceOrientation = deviceOrientation;
    }

    /**
     * Gets the device scanning both long side.
     * 
     * @return the device scanning both long side
     */
    public String getDeviceScanningBothLongSide() {
	return deviceScanningBothLongSide;
    }

    /**
     * Sets the device scanning both long side.
     * 
     * @param deviceScanningBothLongSide
     *            the new device scanning both long side
     */
    public void setDeviceScanningBothLongSide(String deviceScanningBothLongSide) {
	this.deviceScanningBothLongSide = deviceScanningBothLongSide;
    }

    /**
     * Gets the device scanning both short side.
     * 
     * @return the device scanning both short side
     */
    public String getDeviceScanningBothShortSide() {
	return deviceScanningBothShortSide;
    }

    /**
     * Sets the device scanning both short side.
     * 
     * @param deviceScanningBothShortSide
     *            the new device scanning both short side
     */
    public void setDeviceScanningBothShortSide(
	    String deviceScanningBothShortSide) {
	this.deviceScanningBothShortSide = deviceScanningBothShortSide;
    }

    /**
     * Gets the device service name.
     * 
     * @return the device service name
     */
    public String getDeviceServiceName() {
	return deviceServiceName;
    }

    /**
     * Sets the device service name.
     * 
     * @param deviceServiceName
     *            the new device service name
     */
    public void setDeviceServiceName(String deviceServiceName) {
	this.deviceServiceName = deviceServiceName;
    }

    /**
     * Gets the device type.
     * 
     * @return the device type
     */
    public String getDeviceType() {
	return deviceType;
    }

    /**
     * Sets the device type.
     * 
     * @param deviceType
     *            the new device type
     */
    public void setDeviceType(String deviceType) {
	this.deviceType = deviceType;
    }

    /**
     * Gets the dispense.
     * 
     * @return the dispense
     */
    public String getDispense() {
	return dispense;
    }

    /**
     * Sets the dispense.
     * 
     * @param dispense
     *            the new dispense
     */
    public void setDispense(String dispense) {
	this.dispense = dispense;
    }

    /**
     * Gets the display light supported.
     * 
     * @return the display light supported
     */
    public String getDisplayLightSupported() {
	return displayLightSupported;
    }

    /**
     * Sets the display light supported.
     * 
     * @param displayLightSupported
     *            the new display light supported
     */
    public void setDisplayLightSupported(String displayLightSupported) {
	this.displayLightSupported = displayLightSupported;
    }

    /**
     * Gets the keyboard lock supported.
     * 
     * @return the keyboard lock supported
     */
    public String getKeyboardLockSupported() {
	return keyboardLockSupported;
    }

    /**
     * Sets the keyboard lock supported.
     * 
     * @param keyboardLockSupported
     *            the new keyboard lock supported
     */
    public void setKeyboardLockSupported(String keyboardLockSupported) {
	this.keyboardLockSupported = keyboardLockSupported;
    }

    /**
     * Gets the keyboard supported.
     * 
     * @return the keyboard supported
     */
    public String getKeyboardSupported() {
	return keyboardSupported;
    }

    /**
     * Sets the keyboard supported.
     * 
     * @param keyboardSupported
     *            the new keyboard supported
     */
    public void setKeyboardSupported(String keyboardSupported) {
	this.keyboardSupported = keyboardSupported;
    }

    /**
     * Gets the keys supported.
     * 
     * @return the keys supported
     */
    public String getKeysSupported() {
	return keysSupported;
    }

    /**
     * Sets the keys supported.
     * 
     * @param keysSupported
     *            the new keys supported
     */
    public void setKeysSupported(String keysSupported) {
	this.keysSupported = keysSupported;
    }

    /**
     * Gets the doors.
     * 
     * @return the doors
     */
    public String getDoors() {
	return doors;
    }

    /**
     * Sets the doors.
     * 
     * @param doors
     *            the new doors
     */
    public void setDoors(String doors) {
	this.doors = doors;
    }

    /**
     * Gets the eject status.
     * 
     * @return the eject status
     */
    public String getEjectStatus() {
	return ejectStatus;
    }

    /**
     * Sets the eject status.
     * 
     * @param ejectStatus
     *            the new eject status
     */
    public void setEjectStatus(String ejectStatus) {
	this.ejectStatus = ejectStatus;
    }

    /**
     * Gets the entry.
     * 
     * @return the entry
     */
    public String getEntry() {
	return entry;
    }

    /**
     * Sets the entry.
     * 
     * @param entry
     *            the new entry
     */
    public void setEntry(String entry) {
	this.entry = entry;
    }

    /**
     * Gets the env supply.
     * 
     * @return the env supply
     */
    public String getEnvSupply() {
	return envSupply;
    }

    /**
     * Sets the env supply.
     * 
     * @param envSupply
     *            the new env supply
     */
    public void setEnvSupply(String envSupply) {
	this.envSupply = envSupply;
    }

    /**
     * Gets the escrow.
     * 
     * @return the escrow
     */
    public String getEscrow() {
	return escrow;
    }

    /**
     * Sets the escrow.
     * 
     * @param escrow
     *            the new escrow
     */
    public void setEscrow(String escrow) {
	this.escrow = escrow;
    }

    /**
     * Gets the escrow size.
     * 
     * @return the escrow size
     */
    public Integer getEscrowSize() {
	return escrowSize;
    }

    /**
     * Sets the escrow size.
     * 
     * @param escrowSize
     *            the new escrow size
     */
    public void setEscrowSize(Integer escrowSize) {
	this.escrowSize = escrowSize;
    }

    /**
     * Gets the event on start supported.
     * 
     * @return the event on start supported
     */
    public String getEventOnStartSupported() {
	return eventOnStartSupported;
    }

    /**
     * Sets the event on start supported.
     * 
     * @param eventOnStartSupported
     *            the new event on start supported
     */
    public void setEventOnStartSupported(String eventOnStartSupported) {
	this.eventOnStartSupported = eventOnStartSupported;
    }

    /**
     * Gets the extent.
     * 
     * @return the extent
     */
    public String getExtent() {
	return extent;
    }

    /**
     * Sets the extent.
     * 
     * @param extent
     *            the new extent
     */
    public void setExtent(String extent) {
	this.extent = extent;
    }

    /**
     * Gets the guidlights.
     * 
     * @return the guidlights
     */
    public String getGuidlights() {
	return guidlights;
    }

    /**
     * Sets the guidlights.
     * 
     * @param guidlights
     *            the new guidlights
     */
    public void setGuidlights(String guidlights) {
	this.guidlights = guidlights;
    }

    /**
     * Gets the id key.
     * 
     * @return the id key
     */
    public String getIdKey() {
	return idKey;
    }

    /**
     * Sets the id key.
     * 
     * @param idKey
     *            the new id key
     */
    public void setIdKey(String idKey) {
	this.idKey = idKey;
    }

    /**
     * Gets the image capture.
     * 
     * @return the image capture
     */
    public String getImageCapture() {
	return imageCapture;
    }

    /**
     * Sets the image capture.
     * 
     * @param imageCapture
     *            the new image capture
     */
    public void setImageCapture(String imageCapture) {
	this.imageCapture = imageCapture;
    }

    /**
     * Gets the indicators.
     * 
     * @return the indicators
     */
    public String getIndicators() {
	return indicators;
    }

    /**
     * Sets the indicators.
     * 
     * @param indicators
     *            the new indicators
     */
    public void setIndicators(String indicators) {
	this.indicators = indicators;
    }

    /**
     * Gets the input cook supported.
     * 
     * @return the input cook supported
     */
    public String getInputCookSupported() {
	return inputCookSupported;
    }

    /**
     * Sets the input cook supported.
     * 
     * @param inputCookSupported
     *            the new input cook supported
     */
    public void setInputCookSupported(String inputCookSupported) {
	this.inputCookSupported = inputCookSupported;
    }

    /**
     * Gets the input positions.
     * 
     * @return the input positions
     */
    public String getInputPositions() {
	return inputPositions;
    }

    /**
     * Sets the input positions.
     * 
     * @param inputPositions
     *            the new input positions
     */
    public void setInputPositions(String inputPositions) {
	this.inputPositions = inputPositions;
    }

    /**
     * Gets the input raw supported.
     * 
     * @return the input raw supported
     */
    public String getInputRawSupported() {
	return inputRawSupported;
    }

    /**
     * Sets the input raw supported.
     * 
     * @param inputRawSupported
     *            the new input raw supported
     */
    public void setInputRawSupported(String inputRawSupported) {
	this.inputRawSupported = inputRawSupported;
    }

    /**
     * Gets the intermediate stacker.
     * 
     * @return the intermediate stacker
     */
    public String getIntermediateStacker() {
	return intermediateStacker;
    }

    /**
     * Sets the intermediate stacker.
     * 
     * @param intermediateStacker
     *            the new intermediate stacker
     */
    public void setIntermediateStacker(String intermediateStacker) {
	this.intermediateStacker = intermediateStacker;
    }

    /**
     * Gets the insert text supported.
     * 
     * @return the insert text supported
     */
    public String getInsertTextSupported() {
	return insertTextSupported;
    }

    /**
     * Sets the insert text supported.
     * 
     * @param insertTextSupported
     *            the new insert text supported
     */
    public void setInsertTextSupported(String insertTextSupported) {
	this.insertTextSupported = insertTextSupported;
    }

    /**
     * Gets the max data length.
     * 
     * @return the max data length
     */
    public Integer getMaxDataLength() {
	return maxDataLength;
    }

    /**
     * Sets the max data length.
     * 
     * @param maxDataLength
     *            the new max data length
     */
    public void setMaxDataLength(Integer maxDataLength) {
	this.maxDataLength = maxDataLength;
    }

    /**
     * Gets the max in bills.
     * 
     * @return the max in bills
     */
    public Integer getMaxInBills() {
	return maxInBills;
    }

    /**
     * Sets the max in bills.
     * 
     * @param maxInBills
     *            the new max in bills
     */
    public void setMaxInBills(Integer maxInBills) {
	this.maxInBills = maxInBills;
    }

    /**
     * Gets the max in coins.
     * 
     * @return the max in coins
     */
    public Integer getMaxInCoins() {
	return maxInCoins;
    }

    /**
     * Sets the max in coins.
     * 
     * @param maxInCoins
     *            the new max in coins
     */
    public void setMaxInCoins(Integer maxInCoins) {
	this.maxInCoins = maxInCoins;
    }

    /**
     * Gets the max led.
     * 
     * @return the max led
     */
    public Integer getMaxLed() {
	return maxLed;
    }

    /**
     * Sets the max led.
     * 
     * @param maxLed
     *            the new max led
     */
    public void setMaxLed(Integer maxLed) {
	this.maxLed = maxLed;
    }

    /**
     * Gets the max num of chars.
     * 
     * @return the max num of chars
     */
    public Integer getMaxNumOfChars() {
	return maxNumOfChars;
    }

    /**
     * Sets the max num of chars.
     * 
     * @param maxNumOfChars
     *            the new max num of chars
     */
    public void setMaxNumOfChars(Integer maxNumOfChars) {
	this.maxNumOfChars = maxNumOfChars;
    }

    /**
     * Gets the max out bills.
     * 
     * @return the max out bills
     */
    public Integer getMaxOutBills() {
	return maxOutBills;
    }

    /**
     * Sets the max out bills.
     * 
     * @param maxOutBills
     *            the new max out bills
     */
    public void setMaxOutBills(Integer maxOutBills) {
	this.maxOutBills = maxOutBills;
    }

    /**
     * Gets the max out coins.
     * 
     * @return the max out coins
     */
    public Integer getMaxOutCoins() {
	return maxOutCoins;
    }

    /**
     * Sets the max out coins.
     * 
     * @param maxOutCoins
     *            the new max out coins
     */
    public void setMaxOutCoins(Integer maxOutCoins) {
	this.maxOutCoins = maxOutCoins;
    }

    /**
     * Gets the max pictures.
     * 
     * @return the max pictures
     */
    public Integer getMaxPictures() {
	return maxPictures;
    }

    /**
     * Sets the max pictures.
     * 
     * @param maxPictures
     *            the new max pictures
     */
    public void setMaxPictures(Integer maxPictures) {
	this.maxPictures = maxPictures;
    }

    /**
     * Gets the max retract.
     * 
     * @return the max retract
     */
    public Integer getMaxRetract() {
	return maxRetract;
    }

    /**
     * Sets the max retract.
     * 
     * @param maxRetract
     *            the new max retract
     */
    public void setMaxRetract(Integer maxRetract) {
	this.maxRetract = maxRetract;
    }

    /**
     * Gets the max stacker.
     * 
     * @return the max stacker
     */
    public Integer getMaxStacker() {
	return maxStacker;
    }

    /**
     * Sets the max stacker.
     * 
     * @param maxStacker
     *            the new max stacker
     */
    public void setMaxStacker(Integer maxStacker) {
	this.maxStacker = maxStacker;
    }

    /**
     * Gets the multiple currencies cash in supported.
     * 
     * @return the multiple currencies cash in supported
     */
    public String getMultipleCurrenciesCashInSupported() {
	return multipleCurrenciesCashInSupported;
    }

    /**
     * Sets the multiple currencies cash in supported.
     * 
     * @param multipleCurrenciesCashInSupported
     *            the new multiple currencies cash in supported
     */
    public void setMultipleCurrenciesCashInSupported(
	    String multipleCurrenciesCashInSupported) {
	this.multipleCurrenciesCashInSupported = multipleCurrenciesCashInSupported;
    }

    /**
     * Gets the number of keys.
     * 
     * @return the number of keys
     */
    public Integer getNumberOfKeys() {
	return numberOfKeys;
    }

    /**
     * Sets the number of keys.
     * 
     * @param numberOfKeys
     *            the new number of keys
     */
    public void setNumberOfKeys(Integer numberOfKeys) {
	this.numberOfKeys = numberOfKeys;
    }

    /**
     * Gets the orientation to be scanned.
     * 
     * @return the orientation to be scanned
     */
    public String getOrientationToBeScanned() {
	return orientationToBeScanned;
    }

    /**
     * Sets the orientation to be scanned.
     * 
     * @param orientationToBeScanned
     *            the new orientation to be scanned
     */
    public void setOrientationToBeScanned(String orientationToBeScanned) {
	this.orientationToBeScanned = orientationToBeScanned;
    }

    /**
     * Gets the output positions.
     * 
     * @return the output positions
     */
    public String getOutputPositions() {
	return outputPositions;
    }

    /**
     * Sets the output positions.
     * 
     * @param outputPositions
     *            the new output positions
     */
    public void setOutputPositions(String outputPositions) {
	this.outputPositions = outputPositions;
    }

    /**
     * Gets the prints the.
     * 
     * @return the prints the
     */
    public String getPrint() {
	return print;
    }

    /**
     * Sets the prints the.
     * 
     * @param print
     *            the new prints the
     */
    public void setPrint(String print) {
	this.print = print;
    }

    /**
     * Gets the power off.
     * 
     * @return the power off
     */
    public String getPowerOff() {
	return powerOff;
    }

    /**
     * Sets the power off.
     * 
     * @param powerOff
     *            the new power off
     */
    public void setPowerOff(String powerOff) {
	this.powerOff = powerOff;
    }

    /**
     * Gets the power on.
     * 
     * @return the power on
     */
    public String getPowerOn() {
	return powerOn;
    }

    /**
     * Sets the power on.
     * 
     * @param powerOn
     *            the new power on
     */
    public void setPowerOn(String powerOn) {
	this.powerOn = powerOn;
    }

    /**
     * Gets the ptr capabilities.
     * 
     * @return the ptr capabilities
     */
    public String getPtrCapabilities() {
	return ptrCapabilities;
    }

    /**
     * Sets the ptr capabilities.
     * 
     * @param ptrCapabilities
     *            the new ptr capabilities
     */
    public void setPtrCapabilities(String ptrCapabilities) {
	this.ptrCapabilities = ptrCapabilities;
    }

    /**
     * Gets the ptr control media.
     * 
     * @return the ptr control media
     */
    public String getPtrControlMedia() {
	return ptrControlMedia;
    }

    /**
     * Sets the ptr control media.
     * 
     * @param ptrControlMedia
     *            the new ptr control media
     */
    public void setPtrControlMedia(String ptrControlMedia) {
	this.ptrControlMedia = ptrControlMedia;
    }

    /**
     * Gets the read form.
     * 
     * @return the read form
     */
    public String getReadForm() {
	return readForm;
    }

    /**
     * Sets the read form.
     * 
     * @param readForm
     *            the new read form
     */
    public void setReadForm(String readForm) {
	this.readForm = readForm;
    }

    /**
     * Gets the read fonts.
     * 
     * @return the read fonts
     */
    public String getReadFonts() {
	return readFonts;
    }

    /**
     * Sets the read fonts.
     * 
     * @param readFonts
     *            the new read fonts
     */
    public void setReadFonts(String readFonts) {
	this.readFonts = readFonts;
    }

    /**
     * Gets the read image.
     * 
     * @return the read image
     */
    public String getReadImage() {
	return readImage;
    }

    /**
     * Sets the read image.
     * 
     * @param readImage
     *            the new read image
     */
    public void setReadImage(String readImage) {
	this.readImage = readImage;
    }

    /**
     * Gets the read keyboard data with default.
     * 
     * @return the read keyboard data with default
     */
    public String getReadKeyboardDataWithDefault() {
	return readKeyboardDataWithDefault;
    }

    /**
     * Sets the read keyboard data with default.
     * 
     * @param readKeyboardDataWithDefault
     *            the new read keyboard data with default
     */
    public void setReadKeyboardDataWithDefault(
	    String readKeyboardDataWithDefault) {
	this.readKeyboardDataWithDefault = readKeyboardDataWithDefault;
    }

    /**
     * Gets the read micr.
     * 
     * @return the read micr
     */
    public String getReadMicr() {
	return readMicr;
    }

    /**
     * Sets the read micr.
     * 
     * @param readMicr
     *            the new read micr
     */
    public void setReadMicr(String readMicr) {
	this.readMicr = readMicr;
    }

    /**
     * Gets the read ocr.
     * 
     * @return the read ocr
     */
    public String getReadOcr() {
	return readOcr;
    }

    /**
     * Sets the read ocr.
     * 
     * @param readOcr
     *            the new read ocr
     */
    public void setReadOcr(String readOcr) {
	this.readOcr = readOcr;
    }

    /**
     * Gets the read status.
     * 
     * @return the read status
     */
    public String getReadStatus() {
	return readStatus;
    }

    /**
     * Sets the read status.
     * 
     * @param readStatus
     *            the new read status
     */
    public void setReadStatus(String readStatus) {
	this.readStatus = readStatus;
    }

    /**
     * Gets the refill.
     * 
     * @return the refill
     */
    public String getRefill() {
	return refill;
    }

    /**
     * Sets the refill.
     * 
     * @param refill
     *            the new refill
     */
    public void setRefill(String refill) {
	this.refill = refill;
    }

    /**
     * Gets the remote key load.
     * 
     * @return the remote key load
     */
    public String getRemoteKeyLoad() {
	return remoteKeyLoad;
    }

    /**
     * Sets the remote key load.
     * 
     * @param remoteKeyLoad
     *            the new remote key load
     */
    public void setRemoteKeyLoad(String remoteKeyLoad) {
	this.remoteKeyLoad = remoteKeyLoad;
    }

    /**
     * Gets the retain.
     * 
     * @return the retain
     */
    public String getRetain() {
	return retain;
    }

    /**
     * Sets the retain.
     * 
     * @param retain
     *            the new retain
     */
    public void setRetain(String retain) {
	this.retain = retain;
    }

    /**
     * Gets the retract.
     * 
     * @return the retract
     */
    public String getRetract() {
	return retract;
    }

    /**
     * Sets the retract.
     * 
     * @param retract
     *            the new retract
     */
    public void setRetract(String retract) {
	this.retract = retract;
    }

    /**
     * Gets the safe door cmd.
     * 
     * @return the safe door cmd
     */
    public String getSafeDoorCmd() {
	return safeDoorCmd;
    }

    /**
     * Sets the safe door cmd.
     * 
     * @param safeDoorCmd
     *            the new safe door cmd
     */
    public void setSafeDoorCmd(String safeDoorCmd) {
	this.safeDoorCmd = safeDoorCmd;
    }

    /**
     * Gets the safe door sequence.
     * 
     * @return the safe door sequence
     */
    public String getSafeDoorSequence() {
	return safeDoorSequence;
    }

    /**
     * Sets the safe door sequence.
     * 
     * @param safeDoorSequence
     *            the new safe door sequence
     */
    public void setSafeDoorSequence(String safeDoorSequence) {
	this.safeDoorSequence = safeDoorSequence;
    }

    /**
     * Gets the secure key entry state.
     * 
     * @return the secure key entry state
     */
    public String getSecureKeyEntryState() {
	return secureKeyEntryState;
    }

    /**
     * Sets the secure key entry state.
     * 
     * @param secureKeyEntryState
     *            the new secure key entry state
     */
    public void setSecureKeyEntryState(String secureKeyEntryState) {
	this.secureKeyEntryState = secureKeyEntryState;
    }

    /**
     * Gets the secure key entry supported.
     * 
     * @return the secure key entry supported
     */
    public String getSecureKeyEntrySupported() {
	return secureKeyEntrySupported;
    }

    /**
     * Sets the secure key entry supported.
     * 
     * @param secureKeyEntrySupported
     *            the new secure key entry supported
     */
    public void setSecureKeyEntrySupported(String secureKeyEntrySupported) {
	this.secureKeyEntrySupported = secureKeyEntrySupported;
    }

    /**
     * Gets the secure module type.
     * 
     * @return the secure module type
     */
    public String getSecureModuleType() {
	return secureModuleType;
    }

    /**
     * Sets the secure module type.
     * 
     * @param secureModuleType
     *            the new secure module type
     */
    public void setSecureModuleType(String secureModuleType) {
	this.secureModuleType = secureModuleType;
    }

    /**
     * Gets the sensors.
     * 
     * @return the sensors
     */
    public String getSensors() {
	return sensors;
    }

    /**
     * Sets the sensors.
     * 
     * @param sensors
     *            the new sensors
     */
    public void setSensors(String sensors) {
	this.sensors = sensors;
    }

    /**
     * Gets the status.
     * 
     * @return the status
     */
    public String getStatus() {
	return status;
    }

    /**
     * Sets the status.
     * 
     * @param status
     *            the new status
     */
    public void setStatus(String status) {
	this.status = status;
    }

    /**
     * Gets the supported chip presentation modes.
     * 
     * @return the supported chip presentation modes
     */
    public String getSupportedChipPresentationModes() {
	return supportedChipPresentationModes;
    }

    /**
     * Sets the supported chip presentation modes.
     * 
     * @param supportedChipPresentationModes
     *            the new supported chip presentation modes
     */
    public void setSupportedChipPresentationModes(
	    String supportedChipPresentationModes) {
	this.supportedChipPresentationModes = supportedChipPresentationModes;
    }

    /**
     * Gets the supported chip protocols.
     * 
     * @return the supported chip protocols
     */
    public String getSupportedChipProtocols() {
	return supportedChipProtocols;
    }

    /**
     * Sets the supported chip protocols.
     * 
     * @param supportedChipProtocols
     *            the new supported chip protocols
     */
    public void setSupportedChipProtocols(String supportedChipProtocols) {
	this.supportedChipProtocols = supportedChipProtocols;
    }

    /**
     * Gets the supported crypto modes.
     * 
     * @return the supported crypto modes
     */
    public String getSupportedCryptoModes() {
	return supportedCryptoModes;
    }

    /**
     * Sets the supported crypto modes.
     * 
     * @param supportedCryptoModes
     *            the new supported crypto modes
     */
    public void setSupportedCryptoModes(String supportedCryptoModes) {
	this.supportedCryptoModes = supportedCryptoModes;
    }

    /**
     * Gets the supported fd keys.
     * 
     * @return the supported fd keys
     */
    public String getSupportedFdKeys() {
	return supportedFdKeys;
    }

    /**
     * Sets the supported fd keys.
     * 
     * @param supportedFdKeys
     *            the new supported fd keys
     */
    public void setSupportedFdKeys(String supportedFdKeys) {
	this.supportedFdKeys = supportedFdKeys;
    }

    /**
     * Gets the supported pin formats.
     * 
     * @return the supported pin formats
     */
    public String getSupportedPinFormats() {
	return supportedPinFormats;
    }

    /**
     * Sets the supported pin formats.
     * 
     * @param supportedPinFormats
     *            the new supported pin formats
     */
    public void setSupportedPinFormats(String supportedPinFormats) {
	this.supportedPinFormats = supportedPinFormats;
    }

    /**
     * Gets the supported read tracks.
     * 
     * @return the supported read tracks
     */
    public String getSupportedReadTracks() {
	return supportedReadTracks;
    }

    /**
     * Sets the supported read tracks.
     * 
     * @param supportedReadTracks
     *            the new supported read tracks
     */
    public void setSupportedReadTracks(String supportedReadTracks) {
	this.supportedReadTracks = supportedReadTracks;
    }

    /**
     * Gets the supported text attributes.
     * 
     * @return the supported text attributes
     */
    public String getSupportedTextAttributes() {
	return supportedTextAttributes;
    }

    /**
     * Sets the supported text attributes.
     * 
     * @param supportedTextAttributes
     *            the new supported text attributes
     */
    public void setSupportedTextAttributes(String supportedTextAttributes) {
	this.supportedTextAttributes = supportedTextAttributes;
    }

    /**
     * Gets the supported validation algorithms.
     * 
     * @return the supported validation algorithms
     */
    public String getSupportedValidationAlgorithms() {
	return supportedValidationAlgorithms;
    }

    /**
     * Sets the supported validation algorithms.
     * 
     * @param supportedValidationAlgorithms
     *            the new supported validation algorithms
     */
    public void setSupportedValidationAlgorithms(
	    String supportedValidationAlgorithms) {
	this.supportedValidationAlgorithms = supportedValidationAlgorithms;
    }

    /**
     * Gets the supported write hico tracks.
     * 
     * @return the supported write hico tracks
     */
    public String getSupportedWriteHicoTracks() {
	return supportedWriteHicoTracks;
    }

    /**
     * Sets the supported write hico tracks.
     * 
     * @param supportedWriteHicoTracks
     *            the new supported write hico tracks
     */
    public void setSupportedWriteHicoTracks(String supportedWriteHicoTracks) {
	this.supportedWriteHicoTracks = supportedWriteHicoTracks;
    }

    /**
     * Gets the supported write tracks.
     * 
     * @return the supported write tracks
     */
    public String getSupportedWriteTracks() {
	return supportedWriteTracks;
    }

    /**
     * Sets the supported write tracks.
     * 
     * @param supportedWriteTracks
     *            the new supported write tracks
     */
    public void setSupportedWriteTracks(String supportedWriteTracks) {
	this.supportedWriteTracks = supportedWriteTracks;
    }

    /**
     * Gets the shutter cmd.
     * 
     * @return the shutter cmd
     */
    public String getShutterCmd() {
	return shutterCmd;
    }

    /**
     * Sets the shutter cmd.
     * 
     * @param shutterCmd
     *            the new shutter cmd
     */
    public void setShutterCmd(String shutterCmd) {
	this.shutterCmd = shutterCmd;
    }

    /**
     * Gets the silent alarm.
     * 
     * @return the silent alarm
     */
    public String getSilentAlarm() {
	return silentAlarm;
    }

    /**
     * Sets the silent alarm.
     * 
     * @param silentAlarm
     *            the new silent alarm
     */
    public void setSilentAlarm(String silentAlarm) {
	this.silentAlarm = silentAlarm;
    }

    /**
     * Gets the test cash unit.
     * 
     * @return the test cash unit
     */
    public String getTestCashUnit() {
	return testCashUnit;
    }

    /**
     * Sets the test cash unit.
     * 
     * @param testCashUnit
     *            the new test cash unit
     */
    public void setTestCashUnit(String testCashUnit) {
	this.testCashUnit = testCashUnit;
    }

    /**
     * Gets the transport.
     * 
     * @return the transport
     */
    public String getTransport() {
	return transport;
    }

    /**
     * Sets the transport.
     * 
     * @param transport
     *            the new transport
     */
    public void setTransport(String transport) {
	this.transport = transport;
    }

    /**
     * Gets the trusted user.
     * 
     * @return the trusted user
     */
    public String getTrustedUser() {
	return trustedUser;
    }

    /**
     * Sets the trusted user.
     * 
     * @param trustedUser
     *            the new trusted user
     */
    public void setTrustedUser(String trustedUser) {
	this.trustedUser = trustedUser;
    }

    /**
     * Gets the unfit.
     * 
     * @return the unfit
     */
    public String getUnfit() {
	return unfit;
    }

    /**
     * Sets the unfit.
     * 
     * @param unfit
     *            the new unfit
     */
    public void setUnfit(String unfit) {
	this.unfit = unfit;
    }

    /**
     * Gets the vendor data.
     * 
     * @return the vendor data
     */
    public String getVendorData() {
	return vendorData;
    }

    /**
     * Sets the vendor data.
     * 
     * @param vendorData
     *            the new vendor data
     */
    public void setVendorData(String vendorData) {
	this.vendorData = vendorData;
    }

    // public String getVendorInfo() {
    // return vendorInfo;
    // }
    //
    // public void setVendorInfo(String vendorInfo) {
    // this.vendorInfo = vendorInfo;
    // }

    /**
     * Gets the write form.
     * 
     * @return the write form
     */
    public String getWriteForm() {
	return writeForm;
    }

    /**
     * Sets the write form.
     * 
     * @param writeForm
     *            the new write form
     */
    public void setWriteForm(String writeForm) {
	this.writeForm = writeForm;
    }

    /**
     * Gets the write mode.
     * 
     * @return the write mode
     */
    public String getWriteMode() {
	return writeMode;
    }

    /**
     * Sets the write mode.
     * 
     * @param writeMode
     *            the new write mode
     */
    public void setWriteMode(String writeMode) {
	this.writeMode = writeMode;
    }

    /**
     * Gets the jxfs classes (i.e. ALM, CAM, CDM...).
     * 
     * @return the jxfs classes
     */
    public static Set<String> getJxfsclasses() {
	return jxfsClasses;
    }

    /**
     * Gets the comboboxes data for the query GUI.
     * 
     * @return the comboboxes data
     */
    public static Map<String, Map> getComboboxes() {
	return comboboxes;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((acceptLimit == null) ? 0 : acceptLimit.hashCode());
	result = prime * result
		+ ((autopresent == null) ? 0 : autopresent.hashCode());
	result = prime * result
		+ ((auxiliaries == null) ? 0 : auxiliaries.hashCode());
	result = prime
		* result
		+ ((availableResolution == null) ? 0 : availableResolution
			.hashCode());
	result = prime * result
		+ ((baitTrap == null) ? 0 : baitTrap.hashCode());
	result = prime
		* result
		+ ((barcodeCapabilities == null) ? 0 : barcodeCapabilities
			.hashCode());
	result = prime
		* result
		+ ((beepOnPressSupported == null) ? 0 : beepOnPressSupported
			.hashCode());
	result = prime * result
		+ ((beepSupported == null) ? 0 : beepSupported.hashCode());
	result = prime
		* result
		+ ((billsTakenSensor == null) ? 0 : billsTakenSensor.hashCode());
	result = prime * result + ((cashbox == null) ? 0 : cashbox.hashCode());
	result = prime * result
		+ ((category2 == null) ? 0 : category2.hashCode());
	result = prime * result
		+ ((category3 == null) ? 0 : category3.hashCode());
	result = prime * result + ((cdType == null) ? 0 : cdType.hashCode());
	result = prime * result
		+ ((checkVandalism == null) ? 0 : checkVandalism.hashCode());
	result = prime
		* result
		+ ((chequeCapabilities == null) ? 0 : chequeCapabilities
			.hashCode());
	result = prime * result + ((coins == null) ? 0 : coins.hashCode());
	result = prime * result + ((complex == null) ? 0 : complex.hashCode());
	result = prime * result
		+ ((compound == null) ? 0 : compound.hashCode());
	result = prime
		* result
		+ ((createSignatureCommandSupported == null) ? 0
			: createSignatureCommandSupported.hashCode());
	result = prime * result
		+ ((ctrlTurn == null) ? 0 : ctrlTurn.hashCode());
	result = prime * result
		+ ((cursorSupported == null) ? 0 : cursorSupported.hashCode());
	result = prime * result
		+ ((cylinders == null) ? 0 : cylinders.hashCode());
	result = prime
		* result
		+ ((defaultInputPosition == null) ? 0 : defaultInputPosition
			.hashCode());
	result = prime
		* result
		+ ((defaultOutputPosition == null) ? 0 : defaultOutputPosition
			.hashCode());
	result = prime
		* result
		+ ((defaultRollbackPosition == null) ? 0
			: defaultRollbackPosition.hashCode());
	result = prime * result + ((deposit == null) ? 0 : deposit.hashCode());
	result = prime * result
		+ ((detector == null) ? 0 : detector.hashCode());
	result = prime
		* result
		+ ((deviceControlName == null) ? 0 : deviceControlName
			.hashCode());
	result = prime * result
		+ ((deviceId == null) ? 0 : deviceId.hashCode());
	result = prime
		* result
		+ ((deviceOrientation == null) ? 0 : deviceOrientation
			.hashCode());
	result = prime
		* result
		+ ((deviceScanningBothLongSide == null) ? 0
			: deviceScanningBothLongSide.hashCode());
	result = prime
		* result
		+ ((deviceScanningBothShortSide == null) ? 0
			: deviceScanningBothShortSide.hashCode());
	result = prime
		* result
		+ ((deviceServiceName == null) ? 0 : deviceServiceName
			.hashCode());
	result = prime * result
		+ ((deviceType == null) ? 0 : deviceType.hashCode());
	result = prime * result
		+ ((dispense == null) ? 0 : dispense.hashCode());
	result = prime
		* result
		+ ((displayLightSupported == null) ? 0 : displayLightSupported
			.hashCode());
	result = prime * result + ((doors == null) ? 0 : doors.hashCode());
	result = prime * result
		+ ((ejectStatus == null) ? 0 : ejectStatus.hashCode());
	result = prime * result + ((entry == null) ? 0 : entry.hashCode());
	result = prime * result
		+ ((envSupply == null) ? 0 : envSupply.hashCode());
	result = prime * result + ((escrow == null) ? 0 : escrow.hashCode());
	result = prime * result
		+ ((escrowSize == null) ? 0 : escrowSize.hashCode());
	result = prime
		* result
		+ ((eventOnStartSupported == null) ? 0 : eventOnStartSupported
			.hashCode());
	result = prime * result + ((extent == null) ? 0 : extent.hashCode());
	result = prime
		* result
		+ ((financialDevices == null) ? 0 : financialDevices.hashCode());
	result = prime * result
		+ ((guidlights == null) ? 0 : guidlights.hashCode());
	result = prime * result + ((idKey == null) ? 0 : idKey.hashCode());
	result = prime
		* result
		+ ((imageCapabilities == null) ? 0 : imageCapabilities
			.hashCode());
	result = prime * result
		+ ((imageCapture == null) ? 0 : imageCapture.hashCode());
	result = prime * result
		+ ((indicators == null) ? 0 : indicators.hashCode());
	result = prime
		* result
		+ ((inputCookSupported == null) ? 0 : inputCookSupported
			.hashCode());
	result = prime * result
		+ ((inputPositions == null) ? 0 : inputPositions.hashCode());
	result = prime
		* result
		+ ((inputRawSupported == null) ? 0 : inputRawSupported
			.hashCode());
	result = prime
		* result
		+ ((insertTextSupported == null) ? 0 : insertTextSupported
			.hashCode());
	result = prime
		* result
		+ ((intermediateStacker == null) ? 0 : intermediateStacker
			.hashCode());
	result = prime * result
		+ ((jxfsClass == null) ? 0 : jxfsClass.hashCode());
	result = prime
		* result
		+ ((keyboardLockSupported == null) ? 0 : keyboardLockSupported
			.hashCode());
	result = prime
		* result
		+ ((keyboardSupported == null) ? 0 : keyboardSupported
			.hashCode());
	result = prime * result
		+ ((keysSupported == null) ? 0 : keysSupported.hashCode());
	result = prime * result
		+ ((maxDataLength == null) ? 0 : maxDataLength.hashCode());
	result = prime * result
		+ ((maxInBills == null) ? 0 : maxInBills.hashCode());
	result = prime * result
		+ ((maxInCoins == null) ? 0 : maxInCoins.hashCode());
	result = prime * result + ((maxLed == null) ? 0 : maxLed.hashCode());
	result = prime * result
		+ ((maxNumOfChars == null) ? 0 : maxNumOfChars.hashCode());
	result = prime * result
		+ ((maxOutBills == null) ? 0 : maxOutBills.hashCode());
	result = prime * result
		+ ((maxOutCoins == null) ? 0 : maxOutCoins.hashCode());
	result = prime * result
		+ ((maxPictures == null) ? 0 : maxPictures.hashCode());
	result = prime * result
		+ ((maxRetract == null) ? 0 : maxRetract.hashCode());
	result = prime * result
		+ ((maxStacker == null) ? 0 : maxStacker.hashCode());
	result = prime
		* result
		+ ((multipleCurrenciesCashInSupported == null) ? 0
			: multipleCurrenciesCashInSupported.hashCode());
	result = prime * result
		+ ((numberOfKeys == null) ? 0 : numberOfKeys.hashCode());
	result = prime
		* result
		+ ((orientationToBeScanned == null) ? 0
			: orientationToBeScanned.hashCode());
	result = prime * result
		+ ((outputPositions == null) ? 0 : outputPositions.hashCode());
	result = prime * result
		+ ((positions == null) ? 0 : positions.hashCode());
	result = prime * result
		+ ((powerOff == null) ? 0 : powerOff.hashCode());
	result = prime * result + ((powerOn == null) ? 0 : powerOn.hashCode());
	result = prime * result + ((print == null) ? 0 : print.hashCode());
	result = prime * result
		+ ((ptrCapabilities == null) ? 0 : ptrCapabilities.hashCode());
	result = prime * result
		+ ((ptrControlMedia == null) ? 0 : ptrControlMedia.hashCode());
	result = prime * result
		+ ((readFonts == null) ? 0 : readFonts.hashCode());
	result = prime * result
		+ ((readForm == null) ? 0 : readForm.hashCode());
	result = prime * result
		+ ((readImage == null) ? 0 : readImage.hashCode());
	result = prime
		* result
		+ ((readKeyboardDataWithDefault == null) ? 0
			: readKeyboardDataWithDefault.hashCode());
	result = prime * result
		+ ((readMicr == null) ? 0 : readMicr.hashCode());
	result = prime * result + ((readOcr == null) ? 0 : readOcr.hashCode());
	result = prime * result
		+ ((readStatus == null) ? 0 : readStatus.hashCode());
	result = prime * result + ((refill == null) ? 0 : refill.hashCode());
	result = prime * result
		+ ((remoteKeyLoad == null) ? 0 : remoteKeyLoad.hashCode());
	result = prime * result + ((retain == null) ? 0 : retain.hashCode());
	result = prime * result + ((retract == null) ? 0 : retract.hashCode());
	result = prime * result
		+ ((safeDoorCmd == null) ? 0 : safeDoorCmd.hashCode());
	result = prime
		* result
		+ ((safeDoorSequence == null) ? 0 : safeDoorSequence.hashCode());
	result = prime * result
		+ ((scnCapabilities == null) ? 0 : scnCapabilities.hashCode());
	result = prime * result
		+ ((secureKeyDetail == null) ? 0 : secureKeyDetail.hashCode());
	result = prime
		* result
		+ ((secureKeyEntryState == null) ? 0 : secureKeyEntryState
			.hashCode());
	result = prime
		* result
		+ ((secureKeyEntrySupported == null) ? 0
			: secureKeyEntrySupported.hashCode());
	result = prime
		* result
		+ ((secureModuleType == null) ? 0 : secureModuleType.hashCode());
	result = prime * result + ((sensors == null) ? 0 : sensors.hashCode());
	result = prime * result
		+ ((shutterCmd == null) ? 0 : shutterCmd.hashCode());
	result = prime * result
		+ ((silentAlarm == null) ? 0 : silentAlarm.hashCode());
	result = prime * result + ((status == null) ? 0 : status.hashCode());
	result = prime
		* result
		+ ((supportedChipPresentationModes == null) ? 0
			: supportedChipPresentationModes.hashCode());
	result = prime
		* result
		+ ((supportedChipProtocols == null) ? 0
			: supportedChipProtocols.hashCode());
	result = prime
		* result
		+ ((supportedCryptoModes == null) ? 0 : supportedCryptoModes
			.hashCode());
	result = prime * result
		+ ((supportedFdKeys == null) ? 0 : supportedFdKeys.hashCode());
	result = prime
		* result
		+ ((supportedPinFormats == null) ? 0 : supportedPinFormats
			.hashCode());
	result = prime
		* result
		+ ((supportedReadTracks == null) ? 0 : supportedReadTracks
			.hashCode());
	result = prime
		* result
		+ ((supportedTextAttributes == null) ? 0
			: supportedTextAttributes.hashCode());
	result = prime
		* result
		+ ((supportedValidationAlgorithms == null) ? 0
			: supportedValidationAlgorithms.hashCode());
	result = prime
		* result
		+ ((supportedWriteHicoTracks == null) ? 0
			: supportedWriteHicoTracks.hashCode());
	result = prime
		* result
		+ ((supportedWriteTracks == null) ? 0 : supportedWriteTracks
			.hashCode());
	result = prime * result
		+ ((testCashUnit == null) ? 0 : testCashUnit.hashCode());
	result = prime * result
		+ ((transport == null) ? 0 : transport.hashCode());
	result = prime * result
		+ ((trustedUser == null) ? 0 : trustedUser.hashCode());
	result = prime * result + ((unfit == null) ? 0 : unfit.hashCode());
	result = prime * result
		+ ((vendorData == null) ? 0 : vendorData.hashCode());
	result = prime * result
		+ ((writeForm == null) ? 0 : writeForm.hashCode());
	result = prime * result
		+ ((writeMode == null) ? 0 : writeMode.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	JxfsComponent other = (JxfsComponent) obj;
	if (acceptLimit == null) {
	    if (other.acceptLimit != null)
		return false;
	} else if (!acceptLimit.equals(other.acceptLimit))
	    return false;
	if (autopresent == null) {
	    if (other.autopresent != null)
		return false;
	} else if (!autopresent.equals(other.autopresent))
	    return false;
	if (auxiliaries == null) {
	    if (other.auxiliaries != null)
		return false;
	} else if (!auxiliaries.equals(other.auxiliaries))
	    return false;
	if (availableResolution == null) {
	    if (other.availableResolution != null)
		return false;
	} else if (!availableResolution.equals(other.availableResolution))
	    return false;
	if (baitTrap == null) {
	    if (other.baitTrap != null)
		return false;
	} else if (!baitTrap.equals(other.baitTrap))
	    return false;
	if (barcodeCapabilities == null) {
	    if (other.barcodeCapabilities != null)
		return false;
	} else if (!barcodeCapabilities.equals(other.barcodeCapabilities))
	    return false;
	if (beepOnPressSupported == null) {
	    if (other.beepOnPressSupported != null)
		return false;
	} else if (!beepOnPressSupported.equals(other.beepOnPressSupported))
	    return false;
	if (beepSupported == null) {
	    if (other.beepSupported != null)
		return false;
	} else if (!beepSupported.equals(other.beepSupported))
	    return false;
	if (billsTakenSensor == null) {
	    if (other.billsTakenSensor != null)
		return false;
	} else if (!billsTakenSensor.equals(other.billsTakenSensor))
	    return false;
	if (cashbox == null) {
	    if (other.cashbox != null)
		return false;
	} else if (!cashbox.equals(other.cashbox))
	    return false;
	if (category2 == null) {
	    if (other.category2 != null)
		return false;
	} else if (!category2.equals(other.category2))
	    return false;
	if (category3 == null) {
	    if (other.category3 != null)
		return false;
	} else if (!category3.equals(other.category3))
	    return false;
	if (cdType == null) {
	    if (other.cdType != null)
		return false;
	} else if (!cdType.equals(other.cdType))
	    return false;
	if (checkVandalism == null) {
	    if (other.checkVandalism != null)
		return false;
	} else if (!checkVandalism.equals(other.checkVandalism))
	    return false;
	if (chequeCapabilities == null) {
	    if (other.chequeCapabilities != null)
		return false;
	} else if (!chequeCapabilities.equals(other.chequeCapabilities))
	    return false;
	if (coins == null) {
	    if (other.coins != null)
		return false;
	} else if (!coins.equals(other.coins))
	    return false;
	if (complex == null) {
	    if (other.complex != null)
		return false;
	} else if (!complex.equals(other.complex))
	    return false;
	if (compound == null) {
	    if (other.compound != null)
		return false;
	} else if (!compound.equals(other.compound))
	    return false;
	if (createSignatureCommandSupported == null) {
	    if (other.createSignatureCommandSupported != null)
		return false;
	} else if (!createSignatureCommandSupported
		.equals(other.createSignatureCommandSupported))
	    return false;
	if (ctrlTurn == null) {
	    if (other.ctrlTurn != null)
		return false;
	} else if (!ctrlTurn.equals(other.ctrlTurn))
	    return false;
	if (cursorSupported == null) {
	    if (other.cursorSupported != null)
		return false;
	} else if (!cursorSupported.equals(other.cursorSupported))
	    return false;
	if (cylinders == null) {
	    if (other.cylinders != null)
		return false;
	} else if (!cylinders.equals(other.cylinders))
	    return false;
	if (defaultInputPosition == null) {
	    if (other.defaultInputPosition != null)
		return false;
	} else if (!defaultInputPosition.equals(other.defaultInputPosition))
	    return false;
	if (defaultOutputPosition == null) {
	    if (other.defaultOutputPosition != null)
		return false;
	} else if (!defaultOutputPosition.equals(other.defaultOutputPosition))
	    return false;
	if (defaultRollbackPosition == null) {
	    if (other.defaultRollbackPosition != null)
		return false;
	} else if (!defaultRollbackPosition
		.equals(other.defaultRollbackPosition))
	    return false;
	if (deposit == null) {
	    if (other.deposit != null)
		return false;
	} else if (!deposit.equals(other.deposit))
	    return false;
	if (detector == null) {
	    if (other.detector != null)
		return false;
	} else if (!detector.equals(other.detector))
	    return false;
	if (deviceControlName == null) {
	    if (other.deviceControlName != null)
		return false;
	} else if (!deviceControlName.equals(other.deviceControlName))
	    return false;
	if (deviceId == null) {
	    if (other.deviceId != null)
		return false;
	} else if (!deviceId.equals(other.deviceId))
	    return false;
	if (deviceOrientation == null) {
	    if (other.deviceOrientation != null)
		return false;
	} else if (!deviceOrientation.equals(other.deviceOrientation))
	    return false;
	if (deviceScanningBothLongSide == null) {
	    if (other.deviceScanningBothLongSide != null)
		return false;
	} else if (!deviceScanningBothLongSide
		.equals(other.deviceScanningBothLongSide))
	    return false;
	if (deviceScanningBothShortSide == null) {
	    if (other.deviceScanningBothShortSide != null)
		return false;
	} else if (!deviceScanningBothShortSide
		.equals(other.deviceScanningBothShortSide))
	    return false;
	if (deviceServiceName == null) {
	    if (other.deviceServiceName != null)
		return false;
	} else if (!deviceServiceName.equals(other.deviceServiceName))
	    return false;
	if (deviceType == null) {
	    if (other.deviceType != null)
		return false;
	} else if (!deviceType.equals(other.deviceType))
	    return false;
	if (dispense == null) {
	    if (other.dispense != null)
		return false;
	} else if (!dispense.equals(other.dispense))
	    return false;
	if (displayLightSupported == null) {
	    if (other.displayLightSupported != null)
		return false;
	} else if (!displayLightSupported.equals(other.displayLightSupported))
	    return false;
	if (doors == null) {
	    if (other.doors != null)
		return false;
	} else if (!doors.equals(other.doors))
	    return false;
	if (ejectStatus == null) {
	    if (other.ejectStatus != null)
		return false;
	} else if (!ejectStatus.equals(other.ejectStatus))
	    return false;
	if (entry == null) {
	    if (other.entry != null)
		return false;
	} else if (!entry.equals(other.entry))
	    return false;
	if (envSupply == null) {
	    if (other.envSupply != null)
		return false;
	} else if (!envSupply.equals(other.envSupply))
	    return false;
	if (escrow == null) {
	    if (other.escrow != null)
		return false;
	} else if (!escrow.equals(other.escrow))
	    return false;
	if (escrowSize == null) {
	    if (other.escrowSize != null)
		return false;
	} else if (!escrowSize.equals(other.escrowSize))
	    return false;
	if (eventOnStartSupported == null) {
	    if (other.eventOnStartSupported != null)
		return false;
	} else if (!eventOnStartSupported.equals(other.eventOnStartSupported))
	    return false;
	if (extent == null) {
	    if (other.extent != null)
		return false;
	} else if (!extent.equals(other.extent))
	    return false;
	if (financialDevices == null) {
	    if (other.financialDevices != null)
		return false;
	} else if (!financialDevices.equals(other.financialDevices))
	    return false;
	if (guidlights == null) {
	    if (other.guidlights != null)
		return false;
	} else if (!guidlights.equals(other.guidlights))
	    return false;
	if (idKey == null) {
	    if (other.idKey != null)
		return false;
	} else if (!idKey.equals(other.idKey))
	    return false;
	if (imageCapabilities == null) {
	    if (other.imageCapabilities != null)
		return false;
	} else if (!imageCapabilities.equals(other.imageCapabilities))
	    return false;
	if (imageCapture == null) {
	    if (other.imageCapture != null)
		return false;
	} else if (!imageCapture.equals(other.imageCapture))
	    return false;
	if (indicators == null) {
	    if (other.indicators != null)
		return false;
	} else if (!indicators.equals(other.indicators))
	    return false;
	if (inputCookSupported == null) {
	    if (other.inputCookSupported != null)
		return false;
	} else if (!inputCookSupported.equals(other.inputCookSupported))
	    return false;
	if (inputPositions == null) {
	    if (other.inputPositions != null)
		return false;
	} else if (!inputPositions.equals(other.inputPositions))
	    return false;
	if (inputRawSupported == null) {
	    if (other.inputRawSupported != null)
		return false;
	} else if (!inputRawSupported.equals(other.inputRawSupported))
	    return false;
	if (insertTextSupported == null) {
	    if (other.insertTextSupported != null)
		return false;
	} else if (!insertTextSupported.equals(other.insertTextSupported))
	    return false;
	if (intermediateStacker == null) {
	    if (other.intermediateStacker != null)
		return false;
	} else if (!intermediateStacker.equals(other.intermediateStacker))
	    return false;
	if (jxfsClass == null) {
	    if (other.jxfsClass != null)
		return false;
	} else if (!jxfsClass.equals(other.jxfsClass))
	    return false;
	if (keyboardLockSupported == null) {
	    if (other.keyboardLockSupported != null)
		return false;
	} else if (!keyboardLockSupported.equals(other.keyboardLockSupported))
	    return false;
	if (keyboardSupported == null) {
	    if (other.keyboardSupported != null)
		return false;
	} else if (!keyboardSupported.equals(other.keyboardSupported))
	    return false;
	if (keysSupported == null) {
	    if (other.keysSupported != null)
		return false;
	} else if (!keysSupported.equals(other.keysSupported))
	    return false;
	if (maxDataLength == null) {
	    if (other.maxDataLength != null)
		return false;
	} else if (!maxDataLength.equals(other.maxDataLength))
	    return false;
	if (maxInBills == null) {
	    if (other.maxInBills != null)
		return false;
	} else if (!maxInBills.equals(other.maxInBills))
	    return false;
	if (maxInCoins == null) {
	    if (other.maxInCoins != null)
		return false;
	} else if (!maxInCoins.equals(other.maxInCoins))
	    return false;
	if (maxLed == null) {
	    if (other.maxLed != null)
		return false;
	} else if (!maxLed.equals(other.maxLed))
	    return false;
	if (maxNumOfChars == null) {
	    if (other.maxNumOfChars != null)
		return false;
	} else if (!maxNumOfChars.equals(other.maxNumOfChars))
	    return false;
	if (maxOutBills == null) {
	    if (other.maxOutBills != null)
		return false;
	} else if (!maxOutBills.equals(other.maxOutBills))
	    return false;
	if (maxOutCoins == null) {
	    if (other.maxOutCoins != null)
		return false;
	} else if (!maxOutCoins.equals(other.maxOutCoins))
	    return false;
	if (maxPictures == null) {
	    if (other.maxPictures != null)
		return false;
	} else if (!maxPictures.equals(other.maxPictures))
	    return false;
	if (maxRetract == null) {
	    if (other.maxRetract != null)
		return false;
	} else if (!maxRetract.equals(other.maxRetract))
	    return false;
	if (maxStacker == null) {
	    if (other.maxStacker != null)
		return false;
	} else if (!maxStacker.equals(other.maxStacker))
	    return false;
	if (multipleCurrenciesCashInSupported == null) {
	    if (other.multipleCurrenciesCashInSupported != null)
		return false;
	} else if (!multipleCurrenciesCashInSupported
		.equals(other.multipleCurrenciesCashInSupported))
	    return false;
	if (numberOfKeys == null) {
	    if (other.numberOfKeys != null)
		return false;
	} else if (!numberOfKeys.equals(other.numberOfKeys))
	    return false;
	if (orientationToBeScanned == null) {
	    if (other.orientationToBeScanned != null)
		return false;
	} else if (!orientationToBeScanned.equals(other.orientationToBeScanned))
	    return false;
	if (outputPositions == null) {
	    if (other.outputPositions != null)
		return false;
	} else if (!outputPositions.equals(other.outputPositions))
	    return false;
	if (positions == null) {
	    if (other.positions != null)
		return false;
	} else if (!positions.equals(other.positions))
	    return false;
	if (powerOff == null) {
	    if (other.powerOff != null)
		return false;
	} else if (!powerOff.equals(other.powerOff))
	    return false;
	if (powerOn == null) {
	    if (other.powerOn != null)
		return false;
	} else if (!powerOn.equals(other.powerOn))
	    return false;
	if (print == null) {
	    if (other.print != null)
		return false;
	} else if (!print.equals(other.print))
	    return false;
	if (ptrCapabilities == null) {
	    if (other.ptrCapabilities != null)
		return false;
	} else if (!ptrCapabilities.equals(other.ptrCapabilities))
	    return false;
	if (ptrControlMedia == null) {
	    if (other.ptrControlMedia != null)
		return false;
	} else if (!ptrControlMedia.equals(other.ptrControlMedia))
	    return false;
	if (readFonts == null) {
	    if (other.readFonts != null)
		return false;
	} else if (!readFonts.equals(other.readFonts))
	    return false;
	if (readForm == null) {
	    if (other.readForm != null)
		return false;
	} else if (!readForm.equals(other.readForm))
	    return false;
	if (readImage == null) {
	    if (other.readImage != null)
		return false;
	} else if (!readImage.equals(other.readImage))
	    return false;
	if (readKeyboardDataWithDefault == null) {
	    if (other.readKeyboardDataWithDefault != null)
		return false;
	} else if (!readKeyboardDataWithDefault
		.equals(other.readKeyboardDataWithDefault))
	    return false;
	if (readMicr == null) {
	    if (other.readMicr != null)
		return false;
	} else if (!readMicr.equals(other.readMicr))
	    return false;
	if (readOcr == null) {
	    if (other.readOcr != null)
		return false;
	} else if (!readOcr.equals(other.readOcr))
	    return false;
	if (readStatus == null) {
	    if (other.readStatus != null)
		return false;
	} else if (!readStatus.equals(other.readStatus))
	    return false;
	if (refill == null) {
	    if (other.refill != null)
		return false;
	} else if (!refill.equals(other.refill))
	    return false;
	if (remoteKeyLoad == null) {
	    if (other.remoteKeyLoad != null)
		return false;
	} else if (!remoteKeyLoad.equals(other.remoteKeyLoad))
	    return false;
	if (retain == null) {
	    if (other.retain != null)
		return false;
	} else if (!retain.equals(other.retain))
	    return false;
	if (retract == null) {
	    if (other.retract != null)
		return false;
	} else if (!retract.equals(other.retract))
	    return false;
	if (safeDoorCmd == null) {
	    if (other.safeDoorCmd != null)
		return false;
	} else if (!safeDoorCmd.equals(other.safeDoorCmd))
	    return false;
	if (safeDoorSequence == null) {
	    if (other.safeDoorSequence != null)
		return false;
	} else if (!safeDoorSequence.equals(other.safeDoorSequence))
	    return false;
	if (scnCapabilities == null) {
	    if (other.scnCapabilities != null)
		return false;
	} else if (!scnCapabilities.equals(other.scnCapabilities))
	    return false;
	if (secureKeyDetail == null) {
	    if (other.secureKeyDetail != null)
		return false;
	} else if (!secureKeyDetail.equals(other.secureKeyDetail))
	    return false;
	if (secureKeyEntryState == null) {
	    if (other.secureKeyEntryState != null)
		return false;
	} else if (!secureKeyEntryState.equals(other.secureKeyEntryState))
	    return false;
	if (secureKeyEntrySupported == null) {
	    if (other.secureKeyEntrySupported != null)
		return false;
	} else if (!secureKeyEntrySupported
		.equals(other.secureKeyEntrySupported))
	    return false;
	if (secureModuleType == null) {
	    if (other.secureModuleType != null)
		return false;
	} else if (!secureModuleType.equals(other.secureModuleType))
	    return false;
	if (sensors == null) {
	    if (other.sensors != null)
		return false;
	} else if (!sensors.equals(other.sensors))
	    return false;
	if (shutterCmd == null) {
	    if (other.shutterCmd != null)
		return false;
	} else if (!shutterCmd.equals(other.shutterCmd))
	    return false;
	if (silentAlarm == null) {
	    if (other.silentAlarm != null)
		return false;
	} else if (!silentAlarm.equals(other.silentAlarm))
	    return false;
	if (status == null) {
	    if (other.status != null)
		return false;
	} else if (!status.equals(other.status))
	    return false;
	if (supportedChipPresentationModes == null) {
	    if (other.supportedChipPresentationModes != null)
		return false;
	} else if (!supportedChipPresentationModes
		.equals(other.supportedChipPresentationModes))
	    return false;
	if (supportedChipProtocols == null) {
	    if (other.supportedChipProtocols != null)
		return false;
	} else if (!supportedChipProtocols.equals(other.supportedChipProtocols))
	    return false;
	if (supportedCryptoModes == null) {
	    if (other.supportedCryptoModes != null)
		return false;
	} else if (!supportedCryptoModes.equals(other.supportedCryptoModes))
	    return false;
	if (supportedFdKeys == null) {
	    if (other.supportedFdKeys != null)
		return false;
	} else if (!supportedFdKeys.equals(other.supportedFdKeys))
	    return false;
	if (supportedPinFormats == null) {
	    if (other.supportedPinFormats != null)
		return false;
	} else if (!supportedPinFormats.equals(other.supportedPinFormats))
	    return false;
	if (supportedReadTracks == null) {
	    if (other.supportedReadTracks != null)
		return false;
	} else if (!supportedReadTracks.equals(other.supportedReadTracks))
	    return false;
	if (supportedTextAttributes == null) {
	    if (other.supportedTextAttributes != null)
		return false;
	} else if (!supportedTextAttributes
		.equals(other.supportedTextAttributes))
	    return false;
	if (supportedValidationAlgorithms == null) {
	    if (other.supportedValidationAlgorithms != null)
		return false;
	} else if (!supportedValidationAlgorithms
		.equals(other.supportedValidationAlgorithms))
	    return false;
	if (supportedWriteHicoTracks == null) {
	    if (other.supportedWriteHicoTracks != null)
		return false;
	} else if (!supportedWriteHicoTracks
		.equals(other.supportedWriteHicoTracks))
	    return false;
	if (supportedWriteTracks == null) {
	    if (other.supportedWriteTracks != null)
		return false;
	} else if (!supportedWriteTracks.equals(other.supportedWriteTracks))
	    return false;
	if (testCashUnit == null) {
	    if (other.testCashUnit != null)
		return false;
	} else if (!testCashUnit.equals(other.testCashUnit))
	    return false;
	if (transport == null) {
	    if (other.transport != null)
		return false;
	} else if (!transport.equals(other.transport))
	    return false;
	if (trustedUser == null) {
	    if (other.trustedUser != null)
		return false;
	} else if (!trustedUser.equals(other.trustedUser))
	    return false;
	if (unfit == null) {
	    if (other.unfit != null)
		return false;
	} else if (!unfit.equals(other.unfit))
	    return false;
	if (vendorData == null) {
	    if (other.vendorData != null)
		return false;
	} else if (!vendorData.equals(other.vendorData))
	    return false;
	if (writeForm == null) {
	    if (other.writeForm != null)
		return false;
	} else if (!writeForm.equals(other.writeForm))
	    return false;
	if (writeMode == null) {
	    if (other.writeMode != null)
		return false;
	} else if (!writeMode.equals(other.writeMode))
	    return false;
	return true;
    }
}
