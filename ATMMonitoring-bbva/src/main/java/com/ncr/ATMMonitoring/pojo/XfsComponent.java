package com.ncr.ATMMonitoring.pojo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;

import com.ncr.ATMMonitoring.utils.Operation;
import com.ncr.ATMMonitoring.utils.Utils;
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

/**
 * The XfsComponent Pojo.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "xfs_components")
public class XfsComponent {

    /** The comboboxes data related to this entity for the query designer. */
    private static final Map<String, Map> comboboxes;

    /** The Constant xfsClasses. */
    private static final Set<String> xfsClasses;

    static {
	comboboxes = new TreeMap<String, Map>();
	Map<String, Map> stringOperations = Operation
		.getOperationsByType(Operation.DataType.STRING);
	Map<String, Map> boolOperations = Operation
		.getOperationsByType(Operation.DataType.BOOLEAN);
	Map<String, Map> numOperations = Operation
		.getOperationsByType(Operation.DataType.NUMBER);
	comboboxes.put("xfsClass", stringOperations);
	comboboxes.put("acceptMedia", boolOperations);
	comboboxes.put("algorithms", stringOperations);
	comboboxes.put("autobeep", stringOperations);
	comboboxes.put("autodeposit", boolOperations);
	comboboxes.put("autoretractPeriod", numOperations);
	comboboxes.put("auxiliaries", stringOperations);
	comboboxes.put("backImageColorFormat", stringOperations);
	comboboxes.put("backscanColor", stringOperations);
	comboboxes.put("cameras", stringOperations);
	comboboxes.put("camdata", stringOperations);
	comboboxes.put("canFilterSymbologies", boolOperations);
	comboboxes.put("cards", numOperations);
	comboboxes.put("cashin", boolOperations);
	comboboxes.put("charSupport", stringOperations);
	comboboxes.put("chipio", boolOperations);
	comboboxes.put("chipPower", stringOperations);
	comboboxes.put("chipProtocol", stringOperations);
	comboboxes.put("codeLineFormat", stringOperations);
	comboboxes.put("coins", boolOperations);
	comboboxes.put("compound", boolOperations);
	comboboxes.put("comparemagneticstripe", boolOperations);
	comboboxes.put("control", stringOperations);
	comboboxes.put("cursor", boolOperations);
	comboboxes.put("cylinders", boolOperations);
	comboboxes.put("defaultBackscanColor", stringOperations);
	comboboxes.put("defaultFrontscanColor", stringOperations);
	comboboxes.put("deptransport", boolOperations);
	comboboxes.put("derivationAlgorithms", stringOperations);
	comboboxes.put("deviceName", stringOperations);
	comboboxes.put("isPrepareDispense", stringOperations);
	comboboxes.put("dipMode", stringOperations);
	comboboxes.put("dispenseTo", stringOperations);
	comboboxes.put("display", stringOperations);
	comboboxes.put("displayLight", boolOperations);
	comboboxes.put("doors", stringOperations);
	comboboxes.put("ejectPosition", stringOperations);
	comboboxes.put("emvHashAlgorithm", stringOperations);
	comboboxes.put("emvImportSchemes", stringOperations);
	comboboxes.put("encioProtocols", stringOperations);
	comboboxes.put("encoder", boolOperations);
	comboboxes.put("encodenames", stringOperations);
	comboboxes.put("endorser", boolOperations);
	comboboxes.put("envelopesupply", stringOperations);
	comboboxes.put("exchangeTypes", stringOperations);
	comboboxes.put("extents", stringOperations);
	comboboxes.put("extra", stringOperations);
	comboboxes.put("fontnames", stringOperations);
	comboboxes.put("forms", boolOperations);
	comboboxes.put("frontImageColorFormat", stringOperations);
	comboboxes.put("frontscanColor", stringOperations);
	comboboxes.put("guidlights", stringOperations);
	comboboxes.put("hasCashBox", boolOperations);
	comboboxes.put("hasInsertedSensor", boolOperations);
	comboboxes.put("hasShutter", boolOperations);
	comboboxes.put("hasTakenSensor", boolOperations);
	comboboxes.put("hsmVendor", stringOperations);
	comboboxes.put("idConnect", boolOperations);
	comboboxes.put("idKey", stringOperations);
	comboboxes.put("imagecapture", stringOperations);
	comboboxes.put("imageSource", stringOperations);
	comboboxes.put("imageType", stringOperations);
	comboboxes.put("indicators", stringOperations);
	comboboxes.put("insertOrientation", stringOperations);
	comboboxes.put("intermediateStacker", numOperations);
	comboboxes.put("isApplicationRefuse", boolOperations);
	comboboxes.put("isAutofeed", boolOperations);
	comboboxes.put("isCardTakenSensor", boolOperations);
	comboboxes.put("isCompareSignatures", boolOperations);
	comboboxes.put("isHsmJournaling", boolOperations);
	comboboxes.put("isIntermediateStacker", boolOperations);
	comboboxes.put("isItemsTakenSensor", boolOperations);
	comboboxes.put("isKeyImportThroughParts", boolOperations);
	comboboxes.put("isMediaPresented", boolOperations);
	comboboxes.put("isPinCanPersistAfterUse", boolOperations);
	comboboxes.put("isPresentControl", boolOperations);
	comboboxes.put("isRescan", boolOperations);
	comboboxes.put("isRetractCountsItems", boolOperations);
	comboboxes.put("isRetractToTransport", boolOperations);
	comboboxes.put("isSafeDoor", boolOperations);
	comboboxes.put("isSetPinBlockDataRequired", boolOperations);
	comboboxes.put("isStamp", boolOperations);
	comboboxes.put("isTypeCombined", boolOperations);
	comboboxes.put("itemInfoTypes", stringOperations);
	comboboxes.put("keyBlockImportFormats", stringOperations);
	comboboxes.put("keyCheckModes", stringOperations);
	comboboxes.put("keyLock", boolOperations);
	comboboxes.put("keyNum", numOperations);
	comboboxes.put("keys", stringOperations);
	comboboxes.put("logical", stringOperations);
	comboboxes.put("magneticstriperead", boolOperations);
	comboboxes.put("magneticstripewrite", boolOperations);
	comboboxes.put("max2Retract", numOperations);
	comboboxes.put("maxBills", numOperations);
	comboboxes.put("maxCashInItems", numOperations);
	comboboxes.put("maxCoins", numOperations);
	comboboxes.put("maxDataLength", numOperations);
	comboboxes.put("maxDispenseItems", numOperations);
	comboboxes.put("maxMediaOnStacker", numOperations);
	comboboxes.put("maxNumChars", numOperations);
	comboboxes.put("maxPictures", numOperations);
	comboboxes.put("maxRetract", stringOperations);
	comboboxes.put("mediaTaken", boolOperations);
	comboboxes.put("memoryChipProtocols", stringOperations);
	comboboxes.put("micr", boolOperations);
	comboboxes.put("moveItems", stringOperations);
	comboboxes.put("multiPage", boolOperations);
	comboboxes.put("numLeds", numOperations);
	comboboxes.put("ocr", stringOperations);
	comboboxes.put("outputPositions", stringOperations);
	comboboxes.put("paperSources", stringOperations);
	comboboxes.put("pinFormats", stringOperations);
	comboboxes.put("pockets", numOperations);
	comboboxes.put("powerOff", stringOperations);
	comboboxes.put("powerOn", stringOperations);
	comboboxes.put("powerSaveControl", boolOperations);
	comboboxes.put("presentationAlgorithms", stringOperations);
	comboboxes.put("printer", boolOperations);
	comboboxes.put("printOnRetracts", boolOperations);
	comboboxes.put("printSize", stringOperations);
	comboboxes.put("programaticallyDeactivate", boolOperations);
	comboboxes.put("provider", stringOperations);
	comboboxes.put("readForm", stringOperations);
	comboboxes.put("readTracks", stringOperations);
	comboboxes.put("refill", boolOperations);
	comboboxes.put("resetControl", stringOperations);
	comboboxes.put("resolutions", stringOperations);
	comboboxes.put("retract", boolOperations);
	comboboxes.put("retractAreas", stringOperations);
	comboboxes.put("retractBins", stringOperations);
	comboboxes.put("retractenvelope", stringOperations);
	comboboxes.put("retractStackerActions", stringOperations);
	comboboxes.put("retractTransportActions", stringOperations);
	comboboxes.put("retractToDeposit", boolOperations);
	comboboxes.put("rsaAuthenticationScheme", stringOperations);
	comboboxes.put("rsaCryptAlgorithm", stringOperations);
	comboboxes.put("rsaKeycheckMode", stringOperations);
	comboboxes.put("rsaSignatureAlgorithm", stringOperations);
	comboboxes.put("securityType", stringOperations);
	comboboxes.put("sensors", stringOperations);
	comboboxes.put("shutterControl", boolOperations);
	comboboxes.put("signatureScheme", stringOperations);
	comboboxes.put("stamp", stringOperations);
	comboboxes.put("positions", stringOperations);
	comboboxes.put("symbologies", stringOperations);
	comboboxes.put("toner", boolOperations);
	comboboxes.put("type", stringOperations);
	comboboxes.put("validationAlgorithms", stringOperations);
	comboboxes.put("vandalCheck", boolOperations);
	comboboxes.put("windowsPrinter", stringOperations);
	comboboxes.put("writeForm", stringOperations);
	comboboxes.put("writeMode", stringOperations);
	comboboxes.put("writeTracks", stringOperations);

	xfsClasses = new HashSet<String>();
	xfsClasses.add("ALM");
	xfsClasses.add("BCR");
	xfsClasses.add("CAM");
	xfsClasses.add("CDM");
	xfsClasses.add("CEU");
	xfsClasses.add("CHK");
	xfsClasses.add("CIM");
	xfsClasses.add("CRD");
	xfsClasses.add("DEP");
	xfsClasses.add("IDC");
	xfsClasses.add("IPM");
	xfsClasses.add("PIN");
	xfsClasses.add("PTR");
	xfsClasses.add("SIU");
	xfsClasses.add("TTU");
	xfsClasses.add("VDM");
    }

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "xfs_components_id_seq")
    @SequenceGenerator(name = "xfs_components_id_seq", sequenceName = "xfs_components_id_seq", allocationSize = 1)
    private Integer id;

    /** The financial devices. */
    @ManyToMany(fetch = FetchType.LAZY)
    @Cascade(CascadeType.REFRESH)
    @JoinTable(name = "financial_device_xfs_component", joinColumns = { @JoinColumn(name = "xfs_component_id") }, inverseJoinColumns = { @JoinColumn(name = "financial_device_id") })
    private List<FinancialDevice> financialDevices = new ArrayList<FinancialDevice>();

    /** The logical cash units. */
    @OneToMany(mappedBy = "xfsComponent", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @OrderBy("type")
    private List<LogicalCashUnit> logicalCashUnits = new ArrayList<LogicalCashUnit>();

    /** The xfs class. */
    @Column(name = "xfs_class", length = 50, nullable = false)
    private String xfsClass;

    /** The device name. */
    @Column(name = "device_name")
    private String deviceName;

    /** The accept media. */
    @Column(name = "accept_media")
    private Boolean acceptMedia;

    /** The algorithms. */
    @Column(name = "algorithms")
    @Type(type = "text")
    private String algorithms;

    /** The autobeep. */
    @Column(name = "autobeep")
    @Type(type = "text")
    private String autobeep;

    /** The autodeposit. */
    @Column(name = "autodeposit")
    private Boolean autodeposit;

    /** The autoretract period. */
    @Column(name = "autoretract_period")
    private Integer autoretractPeriod;

    /** The auxiliaries. */
    @Column(name = "auxiliaries")
    @Type(type = "text")
    private String auxiliaries;

    /** The back image color format. */
    @Column(name = "back_image_color_format")
    @Type(type = "text")
    private String backImageColorFormat;

    /** The backscan color. */
    @Column(name = "backscan_color")
    @Type(type = "text")
    private String backscanColor;

    /** The cameras. */
    @Column(name = "cameras")
    @Type(type = "text")
    private String cameras;

    /** The camdata. */
    @Column(name = "cam_data")
    @Type(type = "text")
    private String camdata;

    /** The cards. */
    @Column(name = "cards")
    private Integer cards;

    /** The cashin. */
    @Column(name = "cash_in")
    private Boolean cashin;

    /** The char support. */
    @Column(name = "char_support")
    @Type(type = "text")
    private String charSupport;

    /** The chipio. */
    @Column(name = "chip_io")
    private Boolean chipio;

    /** The chip power. */
    @Column(name = "chip_power")
    @Type(type = "text")
    private String chipPower;

    /** The chip protocol. */
    @Column(name = "chip_protocol")
    @Type(type = "text")
    private String chipProtocol;

    /** The code line format. */
    @Column(name = "code_line_format")
    @Type(type = "text")
    private String codeLineFormat;

    /** The coins. */
    @Column(name = "coins")
    private Boolean coins;

    /** The compound. */
    @Column(name = "compound")
    private Boolean compound;

    /** The comparemagneticstripe. */
    @Column(name = "compare_magnetic_stripe")
    private Boolean comparemagneticstripe;

    /** The control. */
    @Column(name = "control")
    @Type(type = "text")
    private String control;

    /** The cursor. */
    @Column(name = "cursor")
    private Boolean cursor;

    /** The cylinders. */
    @Column(name = "cylinders")
    private Boolean cylinders;

    /** The default backscan color. */
    @Column(name = "default_backscan_color")
    @Type(type = "text")
    private String defaultBackscanColor;

    /** The default frontscan color. */
    @Column(name = "default_frontscan_color")
    @Type(type = "text")
    private String defaultFrontscanColor;

    /** The deptransport. */
    @Column(name = "dep_transport")
    private Boolean deptransport;

    /** The derivation algorithms. */
    @Column(name = "derivation_algorithms")
    @Type(type = "text")
    private String derivationAlgorithms;

    /** The is prepare dispense. */
    @Column(name = "is_prepare_dispense")
    private Boolean isPrepareDispense;

    /** The dip mode. */
    @Column(name = "dip_mode")
    @Type(type = "text")
    private String dipMode;

    /** The dispense to. */
    @Column(name = "dispense_to")
    @Type(type = "text")
    private String dispenseTo;

    /** The display. */
    @Column(name = "display")
    @Type(type = "text")
    private String display;

    /** The display light. */
    @Column(name = "display_light")
    private Boolean displayLight;

    /** The doors. */
    @Column(name = "doors")
    @Type(type = "text")
    private String doors;

    /** The eject position. */
    @Column(name = "eject_position")
    @Type(type = "text")
    private String ejectPosition;

    /** The emv hash algorithm. */
    @Column(name = "emv_hash_algorithm")
    @Type(type = "text")
    private String emvHashAlgorithm;

    /** The emv import schemes. */
    @Column(name = "emv_import_schemes")
    @Type(type = "text")
    private String emvImportSchemes;

    /** The encio protocols. */
    @Column(name = "encio_protocols")
    @Type(type = "text")
    private String encioProtocols;

    /** The encoder. */
    @Column(name = "encoder")
    private Boolean encoder;

    /** The encodenames. */
    @Column(name = "encode_names")
    @Type(type = "text")
    private String encodenames;

    /** The endorser. */
    @Column(name = "endorser")
    private Boolean endorser;

    /** The envelopesupply. */
    @Column(name = "envelope_supply")
    @Type(type = "text")
    private String envelopesupply;

    /** The exchange types. */
    @Column(name = "exchange_types")
    @Type(type = "text")
    private String exchangeTypes;

    /** The extents. */
    @Column(name = "extents")
    @Type(type = "text")
    private String extents;

    /** The extra. */
    @Column(name = "extra")
    @Type(type = "text")
    private String extra;

    /** The fontnames. */
    @Column(name = "font_names")
    @Type(type = "text")
    private String fontnames;

    /** The forms. */
    @Column(name = "forms")
    private Boolean forms;

    /** The front image color format. */
    @Column(name = "front_image_color_format")
    @Type(type = "text")
    private String frontImageColorFormat;

    /** The frontscan color. */
    @Column(name = "frontscan_color")
    @Type(type = "text")
    private String frontscanColor;

    /** The guidlights. */
    @Column(name = "guidlights")
    @Type(type = "text")
    private String guidlights;

    /** The has cash box. */
    @Column(name = "has_cash_box")
    private Boolean hasCashBox;

    /** The has inserted sensor. */
    @Column(name = "has_inserted_sensor")
    private Boolean hasInsertedSensor;

    /** The has shutter. */
    @Column(name = "has_shutter")
    private Boolean hasShutter;

    /** The has taken sensor. */
    @Column(name = "has_taken_sensor")
    private Boolean hasTakenSensor;

    /** The hsm vendor. */
    @Column(name = "hsm_vendor")
    @Type(type = "text")
    private String hsmVendor;

    /** The id connect. */
    @Column(name = "id_connect")
    private Boolean idConnect;

    /** The id key. */
    @Column(name = "id_key")
    @Type(type = "text")
    private String idKey;

    /** The imagecapture. */
    @Column(name = "image_capture")
    @Type(type = "text")
    private String imagecapture;

    /** The image source. */
    @Column(name = "image_source")
    @Type(type = "text")
    private String imageSource;

    /** The image type. */
    @Column(name = "image_type")
    @Type(type = "text")
    private String imageType;

    /** The indicators. */
    @Column(name = "indicators")
    @Type(type = "text")
    private String indicators;

    /** The insert orientation. */
    @Column(name = "insert_orientation")
    @Type(type = "text")
    private String insertOrientation;

    /** The intermediate stacker. */
    @Column(name = "intermediate_stacker")
    private Integer intermediateStacker;

    /** The is application refuse. */
    @Column(name = "is_application_refuse")
    private Boolean isApplicationRefuse;

    /** The is autofeed. */
    @Column(name = "is_autofeed")
    private Boolean isAutofeed;

    /** The is card taken sensor. */
    @Column(name = "is_card_taken_sensor")
    private Boolean isCardTakenSensor;

    /** The is compare signatures. */
    @Column(name = "is_compare_signatures")
    private Boolean isCompareSignatures;

    /** The is hsm journaling. */
    @Column(name = "is_hsm_journaling")
    private Boolean isHsmJournaling;

    /** The is intermediate stacker. */
    @Column(name = "is_intermediate_stacker")
    private Boolean isIntermediateStacker;

    /** The is items taken sensor. */
    @Column(name = "is_items_taken_sensor")
    private Boolean isItemsTakenSensor;

    /** The is key import through parts. */
    @Column(name = "is_key_import_through_parts")
    private Boolean isKeyImportThroughParts;

    /** The is media presented. */
    @Column(name = "is_media_presented")
    private Boolean isMediaPresented;

    /** The is pin can persist after use. */
    @Column(name = "is_pin_can_persist_after_use")
    private Boolean isPinCanPersistAfterUse;

    /** The is present control. */
    @Column(name = "is_present_control")
    private Boolean isPresentControl;

    /** The is rescan. */
    @Column(name = "is_rescan")
    private Boolean isRescan;

    /** The is retract counts items. */
    @Column(name = "is_retract_counts_items")
    private Boolean isRetractCountsItems;

    /** The is retract to transport. */
    @Column(name = "is_retract_to_transport")
    private Boolean isRetractToTransport;

    /** The is safe door. */
    @Column(name = "is_safe_door")
    private Boolean isSafeDoor;

    /** The is set pin block data required. */
    @Column(name = "is_set_pin_block_data_requited")
    private Boolean isSetPinBlockDataRequired;

    /** The is stamp. */
    @Column(name = "is_stamp")
    private Boolean isStamp;

    /** The is type combined. */
    @Column(name = "is_type_combined")
    private Boolean isTypeCombined;

    /** The item info types. */
    @Column(name = "item_info_types")
    @Type(type = "text")
    private String itemInfoTypes;

    /** The key block import formats. */
    @Column(name = "key_block_import_formats")
    @Type(type = "text")
    private String keyBlockImportFormats;

    /** The key check modes. */
    @Column(name = "key_check_modes")
    @Type(type = "text")
    private String keyCheckModes;

    /** The key lock. */
    @Column(name = "key_lock")
    private Boolean keyLock;

    /** The key num. */
    @Column(name = "key_num")
    private Integer keyNum;

    /** The keys. */
    @Column(name = "keys")
    @Type(type = "text")
    private String keys;

    /** The logical. */
    @Column(name = "logical")
    @Type(type = "text")
    private String logical;

    /** The magneticstriperead. */
    @Column(name = "magnetic_stripe_read")
    private Boolean magneticstriperead;

    /** The magneticstripewrite. */
    @Column(name = "magnetic_stripe_write")
    private Boolean magneticstripewrite;

    /** The max 2 retract. */
    @Column(name = "max_2_retract")
    private Integer max2Retract;

    /** The max bills. */
    @Column(name = "max_bills")
    private Integer maxBills;

    /** The max cash in items. */
    @Column(name = "max_cash_in_items")
    private Integer maxCashInItems;

    /** The max coins. */
    @Column(name = "max_coins")
    private Integer maxCoins;

    /** The max data length. */
    @Column(name = "max_data_length")
    private Integer maxDataLength;

    /** The max dispense items. */
    @Column(name = "max_dispense_items")
    private Integer maxDispenseItems;

    /** The max media on stacker. */
    @Column(name = "max_media_on_stacker")
    private Integer maxMediaOnStacker;

    /** The max num chars. */
    @Column(name = "max_num_chars")
    private Integer maxNumChars;

    /** The max pictures. */
    @Column(name = "max_pictures")
    private Integer maxPictures;

    /** The max retract. */
    @Column(name = "max_retract")
    @Type(type = "text")
    private String maxRetract;

    /** The media taken. */
    @Column(name = "media_taken")
    private Boolean mediaTaken;

    /** The memory chip protocols. */
    @Column(name = "memory_chip_protocols")
    @Type(type = "text")
    private String memoryChipProtocols;

    /** The micr. */
    @Column(name = "micr")
    private Boolean micr;

    /** The move items. */
    @Column(name = "move_items")
    @Type(type = "text")
    private String moveItems;

    /** The multi page. */
    @Column(name = "multi_page")
    private Boolean multiPage;

    /** The num leds. */
    @Column(name = "num_leds")
    private Integer numLeds;

    /** The ocr. */
    @Column(name = "ocr")
    private Boolean ocr;

    /** The output positions. */
    @Column(name = "output_positions")
    @Type(type = "text")
    private String outputPositions;

    /** The paper sources. */
    @Column(name = "paper_sources")
    @Type(type = "text")
    private String paperSources;

    /** The pin formats. */
    @Column(name = "pin_formats")
    @Type(type = "text")
    private String pinFormats;

    /** The pockets. */
    @Column(name = "pockets")
    private Integer pockets;

    /** The power off. */
    @Column(name = "power_off")
    @Type(type = "text")
    private String powerOff;

    /** The power on. */
    @Column(name = "power_on")
    @Type(type = "text")
    private String powerOn;

    /** The power save control. */
    @Column(name = "power_save_control")
    private Boolean powerSaveControl;

    /** The presentation algorithms. */
    @Column(name = "presentation_algorithms")
    @Type(type = "text")
    private String presentationAlgorithms;

    /** The printer. */
    @Column(name = "printer")
    private Boolean printer;

    /** The print on retracts. */
    @Column(name = "print_on_retracts")
    private Boolean printOnRetracts;

    /** The print size. */
    @Column(name = "print_size")
    @Type(type = "text")
    private String printSize;

    /** The programatically deactivate. */
    @Column(name = "programatically_deactivate")
    private Boolean programaticallyDeactivate;

    /** The provider. */
    @Column(name = "provider")
    @Type(type = "text")
    private String provider;

    /** The read form. */
    @Column(name = "read_form")
    @Type(type = "text")
    private String readForm;

    /** The read tracks. */
    @Column(name = "read_tracks")
    @Type(type = "text")
    private String readTracks;

    /** The refill. */
    @Column(name = "refill")
    private Boolean refill;

    /** The reset control. */
    @Column(name = "reset_control")
    @Type(type = "text")
    private String resetControl;

    /** The resolutions. */
    @Column(name = "resolutions")
    @Type(type = "text")
    private String resolutions;

    /** The retract. */
    @Column(name = "retract")
    private Boolean retract;

    /** The retract areas. */
    @Column(name = "retract_areas")
    @Type(type = "text")
    private String retractAreas;

    /** The retract bins. */
    @Column(name = "retract_bins")
    @Type(type = "text")
    private String retractBins;

    /** The retractenvelope. */
    @Column(name = "retract_envelope")
    @Type(type = "text")
    private String retractenvelope;

    /** The retract stacker actions. */
    @Column(name = "retract_stacker_actions")
    @Type(type = "text")
    private String retractStackerActions;

    /** The retract to deposit. */
    @Column(name = "retract_to_deposit")
    private Boolean retractToDeposit;

    /** The retract transport actions. */
    @Column(name = "retract_transport_actions")
    @Type(type = "text")
    private String retractTransportActions;

    /** The rsa authentication scheme. */
    @Column(name = "rsa_auth_scheme")
    @Type(type = "text")
    private String rsaAuthenticationScheme;

    /** The rsa crypt algorithm. */
    @Column(name = "rsa_crypt_algorithm")
    @Type(type = "text")
    private String rsaCryptAlgorithm;

    /** The rsa keycheck mode. */
    @Column(name = "rsa_keycheck_mode")
    @Type(type = "text")
    private String rsaKeycheckMode;

    /** The rsa signature algorithm. */
    @Column(name = "rsa_signature_algorithm")
    @Type(type = "text")
    private String rsaSignatureAlgorithm;

    /** The security type. */
    @Column(name = "security_type")
    @Type(type = "text")
    private String securityType;

    /** The sensors. */
    @Column(name = "sensors")
    @Type(type = "text")
    private String sensors;

    /** The shutter control. */
    @Column(name = "shutter_control")
    private Boolean shutterControl;

    /** The signature scheme. */
    @Column(name = "signature_scheme")
    @Type(type = "text")
    private String signatureScheme;

    /** The stamp. */
    @Column(name = "stamp")
    @Type(type = "text")
    private String stamp;

    /** The positions. */
    @Column(name = "positions")
    @Type(type = "text")
    private String positions;

    /** The symbologies. */
    @Column(name = "symbologies")
    @Type(type = "text")
    private String symbologies;

    /** The can filter symbologies. */
    @Column(name = "can_filter_symbologies")
    private Boolean canFilterSymbologies;

    /** The toner. */
    @Column(name = "toner")
    private Boolean toner;

    /** The type. */
    @Column(name = "type")
    @Type(type = "text")
    private String type;

    /** The validation algorithms. */
    @Column(name = "validation_algorithms")
    @Type(type = "text")
    private String validationAlgorithms;

    /** The vandal check. */
    @Column(name = "vandal_check")
    private Boolean vandalCheck;

    /** The windows printer. */
    @Column(name = "windows_printer")
    @Type(type = "text")
    private String windowsPrinter;

    /** The write form. */
    @Column(name = "write_form")
    @Type(type = "text")
    private String writeForm;

    /** The write mode. */
    @Column(name = "write_mode")
    @Type(type = "text")
    private String writeMode;

    /** The write tracks. */
    @Column(name = "write_tracks")
    @Type(type = "text")
    private String writeTracks;

    /**
     * Instantiates a new xfs component.
     */
    public XfsComponent() {
    }

    /**
     * Instantiates a new xfs component based on ALM data from the agent.
     * 
     * @param xfs
     *            the ALM
     */
    public XfsComponent(ALM xfs) {
	xfsClass = "ALM";
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	logical = xfs.getLogical();
	provider = xfs.getProvider();
	programaticallyDeactivate = xfs.isProgramaticallydeactivate();
	deviceName = xfs.getDevicename();
    }

    /**
     * Instantiates a new xfs component based on BCR data from the agent.
     * 
     * @param xfs
     *            the BCR
     */
    public XfsComponent(BCR xfs) {
	xfsClass = "BCR";
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	guidlights = xfs.getGuidlights();
	logical = xfs.getLogical();
	provider = xfs.getProvider();
	compound = xfs.isCompound();
	symbologies = xfs.getSymbologies();
	canFilterSymbologies = xfs.isCanfiltersymbologies();
	powerSaveControl = xfs.isPowersavecontrol();
	deviceName = xfs.getDevicename();
    }

    /**
     * Instantiates a new xfs component based on CAM data from the agent.
     * 
     * @param xfs
     *            the CAM
     */
    public XfsComponent(CAM xfs) {
	xfsClass = "CAM";
	camdata = xfs.getCamdata();
	cameras = xfs.getCameras();
	charSupport = xfs.getCharsupport();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	logical = xfs.getLogical();
	maxDataLength = xfs.getMaxdatalength();
	maxPictures = xfs.getMaxpictures();
	provider = xfs.getProvider();
	type = xfs.getType();
	deviceName = xfs.getDevicename();
    }

    /**
     * Instantiates a new xfs component based on CDM data from the agent.
     * 
     * @param xfs
     *            the CDM
     */
    public XfsComponent(CDM xfs) {
	xfsClass = "CDM";
	// EP410008 - 28/01/2014
	// retract = xfs.isRetract();
	// cashin = xfs.isCashin();
	// <--
	exchangeTypes = xfs.getExchangetype();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	guidlights = xfs.getGuidlights();
	logical = xfs.getLogical();
	maxBills = xfs.getMaxbills();
	maxCoins = xfs.getMaxcoins();
	maxDispenseItems = xfs.getMaxdispenseitems();
	moveItems = xfs.getMoveitems();
	outputPositions = xfs.getOutputpositions();
	positions = xfs.getPositions();
	provider = xfs.getProvider();
	retract = xfs.isRetract();
	retractAreas = xfs.getRetractareas();
	retractStackerActions = xfs.getRetractstackeractions();
	retractTransportActions = xfs.getRetracttransportactions();
	type = xfs.getType();
	autodeposit = xfs.isAutodeposit();
	hasCashBox = xfs.isCashbox();
	coins = xfs.isCoins();
	compound = xfs.isCompound();
	cylinders = xfs.isCylinders();
	isIntermediateStacker = xfs.isIntermediatestacker();
	hasTakenSensor = xfs.isItemstakensensor();
	powerSaveControl = xfs.isPowersavecontrol();
	isPrepareDispense = xfs.isPreparedispense();
	refill = xfs.isRefill();
	isSafeDoor = xfs.isSafedoor();
	hasShutter = xfs.isShutter();
	shutterControl = xfs.isShuttercontrol();
	vandalCheck = xfs.isVandalcheck();
	deviceName = xfs.getDevicename();
    }

    /**
     * Instantiates a new xfs component based on CEU data from the agent.
     * 
     * @param xfs
     *            the CEU
     */
    public XfsComponent(CEU xfs) {
	xfsClass = "CEU";
	chipProtocol = xfs.getChipprotocol();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	logical = xfs.getLogical();
	provider = xfs.getProvider();
	chipio = xfs.isChipio();
	comparemagneticstripe = xfs.isComparemagneticstripe();
	compound = xfs.isCompound();
	magneticstriperead = xfs.isMagneticstriperead();
	magneticstripewrite = xfs.isMagneticstripewrite();
	powerSaveControl = xfs.isPowersavecontrol();
	deviceName = xfs.getDevicename();
    }

    /**
     * Instantiates a new xfs component based on CHK data from the agent.
     * 
     * @param xfs
     *            the CHK
     */
    public XfsComponent(CHK xfs) {
	xfsClass = "CHK";
	charSupport = xfs.getCharsupport();
	encodenames = xfs.getEncodenames();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	fontnames = xfs.getFontnames();
	guidlights = xfs.getGuidlights();
	imagecapture = xfs.getImagecapture();
	logical = xfs.getLogical();
	pockets = xfs.getPockets();
	provider = xfs.getProvider();
	stamp = xfs.getStamp();
	type = xfs.getType();
	isAutofeed = xfs.isAutofeed();
	compound = xfs.isCompound();
	encoder = xfs.isEncoder();
	endorser = xfs.isEndorser();
	micr = xfs.isMicr();
	ocr = xfs.isOcr();
	powerSaveControl = xfs.isPowersavecontrol();
	deviceName = xfs.getDevicename();
    }

    /**
     * Instantiates a new xfs component based on CIM data from the agent.
     * 
     * @param xfs
     *            the CIM
     */
    public XfsComponent(CIM xfs) {
	xfsClass = "CIM";
	exchangeTypes = xfs.getExchangetype();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	guidlights = xfs.getGuidlights();
	intermediateStacker = xfs.getIntermediatestacker();
	logical = xfs.getLogical();
	maxCashInItems = xfs.getMaxCashInItems();
	positions = xfs.getPositions();
	provider = xfs.getProvider();
	retractAreas = xfs.getRetractareas();
	retractStackerActions = xfs.getRetractstackeractions();
	retractTransportActions = xfs.getRetracttransportactions();
	type = xfs.getType();
	hasCashBox = xfs.isCashbox();
	compound = xfs.isCompound();
	hasInsertedSensor = xfs.isItemsinsertedsensor();
	powerSaveControl = xfs.isPowersavecontrol();
	refill = xfs.isRefill();
	isSafeDoor = xfs.isSafedoor();
	itemInfoTypes = xfs.getIteminfotypes();
	isCompareSignatures = xfs.isComparesignatures();
	isItemsTakenSensor = xfs.isItemstakensensor();
	hasShutter = xfs.isShutter();
	shutterControl = xfs.isShuttercontrol();
	deviceName = xfs.getDevicename();
    }

    /**
     * Instantiates a new xfs component based on CRD data from the agent.
     * 
     * @param xfs
     *            the CRD
     */
    public XfsComponent(CRD xfs) {
	xfsClass = "CRD";
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	guidlights = xfs.getGuidlights();
	logical = xfs.getLogical();
	powerOff = xfs.getPoweroffoption();
	powerOn = xfs.getPoweronoption();
	provider = xfs.getProvider();
	dispenseTo = xfs.getDispenseto();
	isCardTakenSensor = xfs.isCardtakensensor();
	compound = xfs.isCompound();
	powerSaveControl = xfs.isPowersavecontrol();
	deviceName = xfs.getDevicename();
    }

    /**
     * Instantiates a new xfs component based on DEP data from the agent.
     * 
     * @param xfs
     *            the DEP
     */
    public XfsComponent(DEP xfs) {
	xfsClass = "DEP";
	charSupport = xfs.getCharsupport();
	envelopesupply = xfs.getEnvsupply();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	guidlights = xfs.getGuidlights();
	logical = xfs.getLogical();
	maxNumChars = xfs.getMaxnumchars();
	provider = xfs.getProvider();
	retractenvelope = xfs.getRetractenvelope();
	type = xfs.getType();
	deptransport = xfs.isDeptransport();
	powerSaveControl = xfs.isPowersavecontrol();
	printer = xfs.isPrinter();
	printOnRetracts = xfs.isPrintonretracts();
	retractToDeposit = xfs.isRetracttodeposit();
	hasShutter = xfs.isShutter();
	toner = xfs.isToner();
	deviceName = xfs.getDevicename();
    }

    /**
     * Instantiates a new xfs component based on IDC data from the agent.
     * 
     * @param xfs
     *            the IDC
     */
    public XfsComponent(IDC xfs) {
	xfsClass = "IDC";
	cards = xfs.getCards();
	chipPower = xfs.getChippower();
	chipProtocol = xfs.getChipprotocols();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	guidlights = xfs.getGuidlights();
	logical = xfs.getLogical();
	dipMode = xfs.getDipmode();
	ejectPosition = xfs.getEjectposition();
	memoryChipProtocols = xfs.getMemorychipprotocols();
	powerOff = xfs.getPoweroffoption();
	powerOn = xfs.getPoweronoption();
	provider = xfs.getProvider();
	readTracks = xfs.getReadtracks();
	securityType = xfs.getSectype();
	type = xfs.getType();
	writeMode = xfs.getWritemode();
	writeTracks = xfs.getWritetracks();
	deviceName = xfs.getDevicename();
	powerSaveControl = xfs.isPowersavecontrol();
    }

    /**
     * Instantiates a new xfs component based on IPM data from the agent.
     * 
     * @param xfs
     *            the IPM
     */
    public XfsComponent(IPM xfs) {
	xfsClass = "IPM";
	backImageColorFormat = xfs.getBackimagecolorformat();
	codeLineFormat = xfs.getCodelineformat();
	imageSource = xfs.getDatasource();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	frontImageColorFormat = xfs.getFrontimagecolorformat();
	guidlights = xfs.getGuidlights();
	imageType = xfs.getImagetype();
	logical = xfs.getLogical();
	maxMediaOnStacker = xfs.getMaxmediaonstacker();
	positions = xfs.getPositions();
	provider = xfs.getProvider();
	retractAreas = xfs.getRetractlocation();
	type = xfs.getType();
	compound = xfs.isCompound();
	powerSaveControl = xfs.isPowersavecontrol();
	backscanColor = xfs.getBackscancolor();
	defaultBackscanColor = xfs.getDefaultbackscancolor();
	defaultFrontscanColor = xfs.getDefaultfrontscancolor();
	frontscanColor = xfs.getFrontscancolor();
	insertOrientation = xfs.getInsertorientation();
	printSize = xfs.getPrintsize();
	resetControl = xfs.getResetcontrol();
	isApplicationRefuse = xfs.isApplicationrefuse();
	isPresentControl = xfs.isPresentcontrol();
	isRescan = xfs.isRescan();
	isRetractCountsItems = xfs.isRetractcountsitems();
	isStamp = xfs.isStamp();
	deviceName = xfs.getDevicename();
    }

    /**
     * Instantiates a new xfs component based on PIN data from the agent.
     * 
     * @param xfs
     *            the PIN
     */
    public XfsComponent(PIN xfs) {
	xfsClass = "PIN";
	algorithms = xfs.getAlgorithms();
	derivationAlgorithms = xfs.getDerivationalgorithms();
	display = xfs.getDisplay();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	guidlights = xfs.getGuidlights();
	keyCheckModes = xfs.getKeycheckmodes();
	keyNum = xfs.getKeynum();
	logical = xfs.getLogical();
	pinFormats = xfs.getPinformats();
	presentationAlgorithms = xfs.getPresentationalgorithms();
	provider = xfs.getProvider();
	type = xfs.getType();
	validationAlgorithms = xfs.getValidationalgorithms();
	compound = xfs.isCompound();
	idConnect = xfs.isIdconnect();
	powerSaveControl = xfs.isPowersavecontrol();
	autobeep = xfs.getAutobeep();
	emvHashAlgorithm = xfs.getEmvhashalgorithm();
	emvImportSchemes = xfs.getEmvimportschemes();
	encioProtocols = xfs.getEncioprotocols();
	hsmVendor = xfs.getHsmvendor();
	idKey = xfs.getIdkey();
	keyBlockImportFormats = xfs.getKeyblockimportformats();
	rsaAuthenticationScheme = xfs.getRsaauthenticationscheme();
	rsaCryptAlgorithm = xfs.getRsacryptalgorithm();
	rsaKeycheckMode = xfs.getRsakeycheckmode();
	rsaSignatureAlgorithm = xfs.getRsasignaturealgorithm();
	signatureScheme = xfs.getSignaturescheme();
	isHsmJournaling = xfs.isHsmjournaling();
	isKeyImportThroughParts = xfs.isKeyimportthroughparts();
	isPinCanPersistAfterUse = xfs.isPincanpersistafteruse();
	isSetPinBlockDataRequired = xfs.isSetpinblockdatarequired();
	isTypeCombined = xfs.isTypecombined();
	deviceName = xfs.getDevicename();
    }

    /**
     * Instantiates a new xfs component based on PTR data from the agent.
     * 
     * @param xfs
     *            the PTR
     */
    public XfsComponent(PTR xfs) {
	xfsClass = "PTR";
	backImageColorFormat = xfs.getBackimagecolorformat();
	charSupport = xfs.getCharsupport();
	codeLineFormat = xfs.getCodelineformat();
	control = xfs.getControl();
	extents = xfs.getExtents();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	frontImageColorFormat = xfs.getFrontimagecolorformat();
	guidlights = xfs.getGuidlights();
	imageSource = xfs.getImagesource();
	imageType = xfs.getImagetype();
	logical = xfs.getLogical();
	maxMediaOnStacker = xfs.getMaxmediaonstacker();
	max2Retract = xfs.getMax2retract();
	paperSources = xfs.getPapersources();
	provider = xfs.getProvider();
	readForm = xfs.getReadform();
	resolutions = xfs.getResolution();
	retractBins = new Integer(xfs.getRetractbins()).toString();
	type = xfs.getType();
	writeForm = xfs.getWriteform();
	acceptMedia = xfs.isAcceptmedia();
	compound = xfs.isCompound();
	isPrepareDispense = xfs.isDispensepaper();
	mediaTaken = xfs.isMediataken();
	multiPage = xfs.isMultipage();
	powerSaveControl = xfs.isPowersavecontrol();
	autoretractPeriod = xfs.getAutoretractperiod();
	maxRetract = xfs.getMaxretract();
	windowsPrinter = xfs.getWindowsprinter();
	isMediaPresented = xfs.isMediapresented();
	isRetractToTransport = xfs.isRetracttotransport();
	deviceName = xfs.getDevicename();
    }

    /**
     * Instantiates a new xfs component based on SIU data from the agent.
     * 
     * @param xfs
     *            the SIU
     */
    public XfsComponent(SIU xfs) {
	xfsClass = "SIU";
	auxiliaries = xfs.getAuxiliaries();
	doors = xfs.getDoors();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	guidlights = xfs.getGuidlights();
	indicators = xfs.getIndicators();
	logical = xfs.getLogical();
	provider = xfs.getProvider();
	sensors = xfs.getSensors();
	type = xfs.getType();
	powerSaveControl = xfs.isPowersavecontrol();
	deviceName = xfs.getDevicename();
    }

    /**
     * Instantiates a new xfs component based on TTU data from the agent.
     * 
     * @param xfs
     *            the TTU
     */
    public XfsComponent(TTU xfs) {
	xfsClass = "TTU";
	charSupport = xfs.getCharsupport();
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	keys = xfs.getKeys();
	logical = xfs.getLogical();
	numLeds = xfs.getNumofleds();
	provider = xfs.getProvider();
	resolutions = xfs.getResolutions();
	type = xfs.getType();
	cursor = xfs.isCursor();
	displayLight = xfs.isDisplaylight();
	forms = xfs.isForms();
	keyLock = xfs.isKeylock();
	powerSaveControl = xfs.isPowersavecontrol();
	deviceName = xfs.getDevicename();
    }

    /**
     * Instantiates a new xfs component based on VDM data from the agent.
     * 
     * @param xfs
     *            the VDM
     */
    public XfsComponent(VDM xfs) {
	xfsClass = "VDM";
	extra = Utils.unescapeJsonChain(xfs.getExtra());
	logical = xfs.getLogical();
	provider = xfs.getProvider();
	deviceName = xfs.getDevicename();
    }

    /**
     * Instantiates a new agent specific xfs component data with the current
     * attributes.
     * 
     * @return the agent xfs component data
     */
    public Object getInventoryPojo() {
	if (xfsClass == null) {
	    return null;
	}

	if (xfsClass.equals("ALM")) {
	    ALM pojo = new ALM();
	    pojo.setExtra(extra);
	    pojo.setLogical(logical);
	    pojo.setProvider(provider);
	    if (programaticallyDeactivate != null) {
		pojo.setProgramaticallydeactivate(programaticallyDeactivate);
	    }
	    pojo.setDevicename(deviceName);
	    return pojo;
	}

	if (xfsClass.equals("BCR")) {
	    BCR pojo = new BCR();
	    pojo.setExtra(extra);
	    pojo.setGuidlights(guidlights);
	    pojo.setLogical(logical);
	    pojo.setProvider(provider);
	    if (compound != null) {
		pojo.setCompound(compound);
	    }
	    pojo.setSymbologies(symbologies);
	    if (canFilterSymbologies != null) {
		pojo.setCanfiltersymbologies(canFilterSymbologies);
	    }
	    if (powerSaveControl != null) {
		pojo.setPowersavecontrol(powerSaveControl);
	    }
	    pojo.setDevicename(deviceName);
	    return pojo;
	}

	if (xfsClass.equals("CAM")) {
	    CAM pojo = new CAM();
	    pojo.setCamdata(camdata);
	    pojo.setCameras(cameras);
	    pojo.setCharsupport(charSupport);
	    pojo.setExtra(extra);
	    pojo.setLogical(logical);
	    if (maxDataLength != null) {
		pojo.setMaxdatalength(maxDataLength);
	    }
	    if (maxPictures != null) {
		pojo.setMaxpictures(maxPictures);
	    }
	    pojo.setProvider(provider);
	    pojo.setType(type);
	    pojo.setDevicename(deviceName);
	    return pojo;
	}

	if (xfsClass.equals("CDM")) {
	    CDM pojo = new CDM();
	    pojo.setExchangetype(exchangeTypes);
	    pojo.setExtra(extra);
	    pojo.setGuidlights(guidlights);
	    pojo.setLogical(logical);
	    if (maxBills != null) {
		pojo.setMaxbills(maxBills);
	    }
	    if (maxBills != null) {
		pojo.setMaxcoins(maxCoins);
	    }
	    if (maxDispenseItems != null) {
		pojo.setMaxdispenseitems(maxDispenseItems);
	    }
	    pojo.setMoveitems(moveItems);
	    pojo.setOutputpositions(outputPositions);
	    pojo.setPositions(positions);
	    pojo.setProvider(provider);
	    pojo.setRetractareas(retractAreas);
	    pojo.setRetractstackeractions(retractStackerActions);
	    pojo.setRetracttransportactions(retractTransportActions);
	    pojo.setType(type);
	    if (autodeposit != null) {
		pojo.setAutodeposit(autodeposit);
	    }
	    if (hasCashBox != null) {
		pojo.setCashbox(hasCashBox);
	    }
	    if (coins != null) {
		pojo.setCoins(coins);
	    }
	    if (compound != null) {
		pojo.setCompound(compound);
	    }
	    if (cylinders != null) {
		pojo.setCylinders(cylinders);
	    }
	    if (isIntermediateStacker != null) {
		pojo.setIntermediatestacker(isIntermediateStacker);
	    }
	    if (hasTakenSensor != null) {
		pojo.setItemstakensensor(hasTakenSensor);
	    }
	    if (powerSaveControl != null) {
		pojo.setPowersavecontrol(powerSaveControl);
	    }
	    if (isPrepareDispense != null) {
		pojo.setPreparedispense(isPrepareDispense);
	    }
	    if (refill != null) {
		pojo.setRefill(refill);
	    }
	    if (isSafeDoor != null) {
		pojo.setSafedoor(isSafeDoor);
	    }
	    if (hasShutter != null) {
		pojo.setShutter(hasShutter);
	    }
	    if (shutterControl != null) {
		pojo.setShuttercontrol(shutterControl);
	    }
	    if (vandalCheck != null) {
		pojo.setVandalcheck(vandalCheck);
	    }
	    if (retract != null) {
		pojo.setRetract(retract);
	    }
	    pojo.setDevicename(deviceName);
	    return pojo;
	}

	if (xfsClass.equals("CEU")) {
	    CEU pojo = new CEU();
	    pojo.setChipprotocol(chipProtocol);
	    pojo.setExtra(extra);
	    pojo.setLogical(logical);
	    pojo.setProvider(provider);
	    if (chipio != null) {
		pojo.setChipio(chipio);
	    }
	    if (comparemagneticstripe != null) {
		pojo.setComparemagneticstripe(comparemagneticstripe);
	    }
	    if (compound != null) {
		pojo.setCompound(compound);
	    }
	    if (magneticstriperead != null) {
		pojo.setMagneticstriperead(magneticstriperead);
	    }
	    if (magneticstripewrite != null) {
		pojo.setMagneticstripewrite(magneticstripewrite);
	    }
	    if (powerSaveControl != null) {
		pojo.setPowersavecontrol(powerSaveControl);
	    }
	    pojo.setDevicename(deviceName);
	    return pojo;
	}

	if (xfsClass.equals("CHK")) {
	    CHK pojo = new CHK();
	    pojo.setCharsupport(charSupport);
	    pojo.setEncodenames(encodenames);
	    pojo.setExtra(extra);
	    pojo.setFontnames(fontnames);
	    pojo.setGuidlights(guidlights);
	    pojo.setImagecapture(imagecapture);
	    pojo.setLogical(logical);
	    if (pockets != null) {
		pojo.setPockets(pockets);
	    }
	    pojo.setProvider(provider);
	    pojo.setStamp(stamp);
	    pojo.setType(type);
	    if (isAutofeed != null) {
		pojo.setAutofeed(isAutofeed);
	    }
	    if (compound != null) {
		pojo.setCompound(compound);
	    }
	    if (encoder != null) {
		pojo.setEncoder(encoder);
	    }
	    if (endorser != null) {
		pojo.setEndorser(endorser);
	    }
	    if (micr != null) {
		pojo.setMicr(micr);
	    }
	    if (ocr != null) {
		pojo.setOcr(ocr);
	    }
	    if (powerSaveControl != null) {
		pojo.setPowersavecontrol(powerSaveControl);
	    }
	    pojo.setDevicename(deviceName);
	    return pojo;
	}

	if (xfsClass.equals("CIM")) {
	    CIM pojo = new CIM();
	    pojo.setExchangetype(exchangeTypes);
	    pojo.setExtra(extra);
	    pojo.setGuidlights(guidlights);
	    if (intermediateStacker != null) {
		pojo.setIntermediatestacker(intermediateStacker);
	    }
	    pojo.setLogical(logical);
	    if (maxCashInItems != null) {
		pojo.setMaxCashInItems(maxCashInItems);
	    }
	    pojo.setPositions(positions);
	    pojo.setProvider(provider);
	    pojo.setRetractareas(retractAreas);
	    pojo.setRetractstackeractions(retractStackerActions);
	    pojo.setRetracttransportactions(retractTransportActions);
	    pojo.setType(type);
	    if (hasCashBox != null) {
		pojo.setCashbox(hasCashBox);
	    }
	    if (compound != null) {
		pojo.setCompound(compound);
	    }
	    if (hasInsertedSensor != null) {
		pojo.setItemsinsertedsensor(hasInsertedSensor);
	    }
	    if (powerSaveControl != null) {
		pojo.setPowersavecontrol(powerSaveControl);
	    }
	    if (refill != null) {
		pojo.setRefill(refill);
	    }
	    if (isSafeDoor != null) {
		pojo.setSafedoor(isSafeDoor);
	    }
	    pojo.setIteminfotypes(itemInfoTypes);
	    if (isCompareSignatures != null) {
		pojo.setComparesignatures(isCompareSignatures);
	    }
	    if (hasTakenSensor != null) {
		pojo.setItemstakensensor(hasTakenSensor);
	    }
	    if (hasShutter != null) {
		pojo.setShutter(hasShutter);
	    }
	    if (shutterControl != null) {
		pojo.setShuttercontrol(shutterControl);
	    }
	    pojo.setDevicename(deviceName);
	    return pojo;
	}

	if (xfsClass.equals("CRD")) {
	    CRD pojo = new CRD();
	    pojo.setExtra(extra);
	    pojo.setGuidlights(guidlights);
	    pojo.setLogical(logical);
	    pojo.setPoweroffoption(powerOff);
	    pojo.setPoweronoption(powerOn);
	    pojo.setProvider(provider);
	    pojo.setDispenseto(dispenseTo);
	    if (isCardTakenSensor != null) {
		pojo.setCardtakensensor(isCardTakenSensor);
	    }
	    if (compound != null) {
		pojo.setCompound(compound);
	    }
	    if (powerSaveControl != null) {
		pojo.setPowersavecontrol(powerSaveControl);
	    }
	    pojo.setDevicename(deviceName);
	    return pojo;
	}

	if (xfsClass.equals("DEP")) {
	    DEP pojo = new DEP();
	    pojo.setCharsupport(charSupport);
	    pojo.setEnvsupply(envelopesupply);
	    pojo.setExtra(extra);
	    pojo.setGuidlights(guidlights);
	    pojo.setLogical(logical);
	    if (maxNumChars != null) {
		pojo.setMaxnumchars(maxNumChars);
	    }
	    pojo.setProvider(provider);
	    pojo.setRetractenvelope(retractenvelope);
	    pojo.setType(type);
	    if (deptransport != null) {
		pojo.setDeptransport(deptransport);
	    }
	    if (powerSaveControl != null) {
		pojo.setPowersavecontrol(powerSaveControl);
	    }
	    if (printer != null) {
		pojo.setPrinter(printer);
	    }
	    if (printOnRetracts != null) {
		pojo.setPrintonretracts(printOnRetracts);
	    }
	    if (retractToDeposit != null) {
		pojo.setRetracttodeposit(retractToDeposit);
	    }
	    if (hasShutter != null) {
		pojo.setShutter(hasShutter);
	    }
	    if (toner != null) {
		pojo.setToner(toner);
	    }
	    pojo.setDevicename(deviceName);
	    return pojo;
	}

	if (xfsClass.equals("IDC")) {
	    IDC pojo = new IDC();
	    if (cards != null) {
		pojo.setCards(cards);
	    }
	    pojo.setChippower(chipPower);
	    pojo.setChipprotocols(chipProtocol);
	    pojo.setExtra(extra);
	    pojo.setGuidlights(guidlights);
	    pojo.setLogical(logical);
	    pojo.setDipmode(dipMode);
	    pojo.setEjectposition(ejectPosition);
	    pojo.setMemorychipprotocols(memoryChipProtocols);
	    pojo.setPoweroffoption(powerOff);
	    pojo.setPoweronoption(powerOn);
	    pojo.setProvider(provider);
	    pojo.setReadtracks(readTracks);
	    pojo.setSectype(securityType);
	    pojo.setType(type);
	    pojo.setWritemode(writeMode);
	    pojo.setWritetracks(writeTracks);
	    if (powerSaveControl != null) {
		pojo.setPowersavecontrol(powerSaveControl);
	    }
	    pojo.setDevicename(deviceName);
	    return pojo;
	}

	if (xfsClass.equals("IPM")) {
	    IPM pojo = new IPM();
	    pojo.setBackimagecolorformat(backImageColorFormat);
	    pojo.setCodelineformat(codeLineFormat);
	    pojo.setDatasource(imageSource);
	    pojo.setExtra(extra);
	    pojo.setFrontimagecolorformat(frontImageColorFormat);
	    pojo.setGuidlights(guidlights);
	    pojo.setImagetype(imageType);
	    pojo.setLogical(logical);
	    if (maxMediaOnStacker != null) {
		pojo.setMaxmediaonstacker(maxMediaOnStacker);
	    }
	    pojo.setPositions(positions);
	    pojo.setProvider(provider);
	    pojo.setRetractlocation(retractAreas);
	    pojo.setType(type);
	    if (compound != null) {
		pojo.setCompound(compound);
	    }
	    if (powerSaveControl != null) {
		pojo.setPowersavecontrol(powerSaveControl);
	    }
	    pojo.setBackscancolor(backscanColor);
	    pojo.setDefaultbackscancolor(defaultBackscanColor);
	    pojo.setDefaultfrontscancolor(defaultFrontscanColor);
	    pojo.setFrontscancolor(frontscanColor);
	    pojo.setInsertorientation(insertOrientation);
	    pojo.setPrintsize(printSize);
	    pojo.setResetcontrol(resetControl);
	    if (isApplicationRefuse != null) {
		pojo.setApplicationrefuse(isApplicationRefuse);
	    }
	    if (isPresentControl != null) {
		pojo.setPresentcontrol(isPresentControl);
	    }
	    if (isRescan != null) {
		pojo.setRescan(isRescan);
	    }
	    if (isRetractCountsItems != null) {
		pojo.setRetractcountsitems(isRetractCountsItems);
	    }
	    if (isStamp != null) {
		pojo.setStamp(isStamp);
	    }
	    pojo.setDevicename(deviceName);
	    return pojo;
	}

	if (xfsClass.equals("PIN")) {
	    PIN pojo = new PIN();
	    pojo.setAlgorithms(algorithms);
	    pojo.setDerivationalgorithms(derivationAlgorithms);
	    pojo.setDisplay(display);
	    pojo.setExtra(extra);
	    pojo.setGuidlights(guidlights);
	    pojo.setKeycheckmodes(keyCheckModes);
	    if (keyNum != null) {
		pojo.setKeynum(keyNum);
	    }
	    pojo.setLogical(logical);
	    pojo.setPinformats(pinFormats);
	    pojo.setPresentationalgorithms(presentationAlgorithms);
	    pojo.setProvider(provider);
	    pojo.setType(type);
	    pojo.setValidationalgorithms(validationAlgorithms);
	    if (compound != null) {
		pojo.setCompound(compound);
	    }
	    if (idConnect != null) {
		pojo.setIdconnect(idConnect);
	    }
	    if (powerSaveControl != null) {
		pojo.setPowersavecontrol(powerSaveControl);
	    }
	    pojo.setAutobeep(autobeep);
	    pojo.setEmvhashalgorithm(emvHashAlgorithm);
	    pojo.setEmvimportschemes(emvImportSchemes);
	    pojo.setEncioprotocols(encioProtocols);
	    pojo.setHsmvendor(hsmVendor);
	    pojo.setKeyblockimportformats(keyBlockImportFormats);
	    pojo.setRsaauthenticationscheme(rsaAuthenticationScheme);
	    pojo.setRsacryptalgorithm(rsaCryptAlgorithm);
	    pojo.setRsakeycheckmode(rsaKeycheckMode);
	    pojo.setRsasignaturealgorithm(rsaSignatureAlgorithm);
	    pojo.setSignaturescheme(signatureScheme);
	    if (isHsmJournaling != null) {
		pojo.setHsmjournaling(isHsmJournaling);
	    }
	    if (isKeyImportThroughParts != null) {
		pojo.setKeyimportthroughparts(isKeyImportThroughParts);
	    }
	    if (isPinCanPersistAfterUse != null) {
		pojo.setPincanpersistafteruse(isPinCanPersistAfterUse);
	    }
	    if (isSetPinBlockDataRequired != null) {
		pojo.setSetpinblockdatarequired(isSetPinBlockDataRequired);
	    }
	    if (isTypeCombined != null) {
		pojo.setTypecombined(isTypeCombined);
	    }
	    pojo.setDevicename(deviceName);
	    return pojo;
	}

	if (xfsClass.equals("PTR")) {
	    PTR pojo = new PTR();
	    pojo.setBackimagecolorformat(backImageColorFormat);
	    pojo.setCharsupport(charSupport);
	    pojo.setCodelineformat(codeLineFormat);
	    pojo.setControl(control);
	    pojo.setExtents(extents);
	    pojo.setExtra(extra);
	    pojo.setFrontimagecolorformat(frontImageColorFormat);
	    pojo.setGuidlights(guidlights);
	    pojo.setImagesource(imageSource);
	    pojo.setImagetype(imageType);
	    pojo.setLogical(logical);
	    if (maxMediaOnStacker != null) {
		pojo.setMaxmediaonstacker(maxMediaOnStacker);
	    }
	    if (max2Retract != null) {
		pojo.setMax2retract(max2Retract);
	    }
	    pojo.setPapersources(paperSources);
	    pojo.setProvider(provider);
	    pojo.setReadform(readForm);
	    pojo.setResolution(resolutions);
	    if (retractBins != null) {
		pojo.setRetractbins(Integer.valueOf(retractBins));
	    }
	    pojo.setType(type);
	    pojo.setWriteform(writeForm);
	    if (acceptMedia != null) {
		pojo.setAcceptmedia(acceptMedia);
	    }
	    if (compound != null) {
		pojo.setCompound(compound);
	    }
	    if (isPrepareDispense != null) {
		pojo.setDispensepaper(isPrepareDispense);
	    }
	    if (mediaTaken != null) {
		pojo.setMediataken(mediaTaken);
	    }
	    if (multiPage != null) {
		pojo.setMultipage(multiPage);
	    }
	    if (powerSaveControl != null) {
		pojo.setPowersavecontrol(powerSaveControl);
	    }
	    if (autoretractPeriod != null) {
		pojo.setAutoretractperiod(autoretractPeriod);
	    }
	    pojo.setMaxretract(maxRetract);
	    pojo.setWindowsprinter(windowsPrinter);
	    if (isMediaPresented != null) {
		pojo.setMediapresented(isMediaPresented);
	    }
	    if (isRetractToTransport != null) {
		pojo.setRetracttotransport(isRetractToTransport);
	    }
	    pojo.setDevicename(deviceName);
	    return pojo;
	}

	if (xfsClass.equals("SIU")) {
	    SIU pojo = new SIU();
	    pojo.setAuxiliaries(auxiliaries);
	    pojo.setDoors(doors);
	    pojo.setExtra(extra);
	    pojo.setGuidlights(guidlights);
	    pojo.setIndicators(indicators);
	    pojo.setLogical(logical);
	    pojo.setProvider(provider);
	    pojo.setSensors(sensors);
	    pojo.setType(type);
	    if (powerSaveControl != null) {
		pojo.setPowersavecontrol(powerSaveControl);
	    }
	    pojo.setDevicename(deviceName);
	    return pojo;
	}

	if (xfsClass.equals("TTU")) {
	    TTU pojo = new TTU();
	    pojo.setCharsupport(charSupport);
	    pojo.setExtra(extra);
	    pojo.setKeys(keys);
	    pojo.setLogical(logical);
	    if (numLeds != null) {
		pojo.setNumofleds(numLeds);
	    }
	    pojo.setProvider(provider);
	    pojo.setResolutions(resolutions);
	    pojo.setType(type);
	    if (cursor != null) {
		pojo.setCursor(cursor);
	    }
	    if (displayLight != null) {
		pojo.setDisplaylight(displayLight);
	    }
	    if (forms != null) {
		pojo.setForms(forms);
	    }
	    if (keyLock != null) {
		pojo.setKeylock(keyLock);
	    }
	    if (powerSaveControl != null) {
		pojo.setPowersavecontrol(powerSaveControl);
	    }
	    pojo.setDevicename(deviceName);
	    return pojo;
	}

	if (xfsClass.equals("VDM")) {
	    VDM pojo = new VDM();
	    pojo.setExtra(extra);
	    pojo.setLogical(logical);
	    pojo.setProvider(provider);
	    pojo.setDevicename(deviceName);
	    return pojo;
	}

	return null;
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
     *            the new id
     */
    public void setId(Integer id) {
	this.id = id;
    }

    /**
     * Gets the device name.
     * 
     * @return the device name
     */
    public String getDeviceName() {
	return deviceName;
    }

    /**
     * Sets the device name.
     * 
     * @param deviceName
     *            the new device name
     */
    public void setDeviceName(String deviceName) {
	this.deviceName = deviceName;
    }

    /**
     * Gets the financial devices.
     * 
     * @return the financial devices
     */
    public List<FinancialDevice> getFinancialDevices() {
	return financialDevices;
    }

    /**
     * Sets the financial devices.
     * 
     * @param financialDevices
     *            the new financial devices
     */
    public void setFinancialDevices(List<FinancialDevice> financialDevices) {
	this.financialDevices = financialDevices;
    }

    /**
     * Gets the logical cash units.
     * 
     * @return the logical cash units
     */
    public List<LogicalCashUnit> getLogicalCashUnits() {
	return logicalCashUnits;
    }

    /**
     * Sets the logical cash units.
     * 
     * @param logicalCashUnits
     *            the new logical cash units
     */
    public void setLogicalCashUnits(List<LogicalCashUnit> logicalCashUnits) {
	this.logicalCashUnits = logicalCashUnits;
    }

    /**
     * Gets the xfs class.
     * 
     * @return the xfs class
     */
    public String getXfsClass() {
	return xfsClass;
    }

    /**
     * Sets the xfs class.
     * 
     * @param xfsClass
     *            the new xfs class
     */
    public void setXfsClass(String xfsClass) {
	this.xfsClass = xfsClass;
    }

    /**
     * Gets the accept media.
     * 
     * @return the accept media
     */
    public Boolean getAcceptMedia() {
	return acceptMedia;
    }

    /**
     * Sets the accept media.
     * 
     * @param acceptMedia
     *            the new accept media
     */
    public void setAcceptMedia(Boolean acceptMedia) {
	this.acceptMedia = acceptMedia;
    }

    /**
     * Gets the algorithms.
     * 
     * @return the algorithms
     */
    public String getAlgorithms() {
	return algorithms;
    }

    /**
     * Sets the algorithms.
     * 
     * @param algorithms
     *            the new algorithms
     */
    public void setAlgorithms(String algorithms) {
	this.algorithms = algorithms;
    }

    /**
     * Gets the autobeep.
     * 
     * @return the autobeep
     */
    public String getAutobeep() {
	return autobeep;
    }

    /**
     * Sets the autobeep.
     * 
     * @param autobeep
     *            the new autobeep
     */
    public void setAutobeep(String autobeep) {
	this.autobeep = autobeep;
    }

    /**
     * Gets the autoretract period.
     * 
     * @return the autoretract period
     */
    public Integer getAutoretractPeriod() {
	return autoretractPeriod;
    }

    /**
     * Sets the autoretract period.
     * 
     * @param autoretractPeriod
     *            the new autoretract period
     */
    public void setAutoretractPeriod(Integer autoretractPeriod) {
	this.autoretractPeriod = autoretractPeriod;
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
     * Gets the back image color format.
     * 
     * @return the back image color format
     */
    public String getBackImageColorFormat() {
	return backImageColorFormat;
    }

    /**
     * Sets the back image color format.
     * 
     * @param backImageColorFormat
     *            the new back image color format
     */
    public void setBackImageColorFormat(String backImageColorFormat) {
	this.backImageColorFormat = backImageColorFormat;
    }

    /**
     * Gets the backscan color.
     * 
     * @return the backscan color
     */
    public String getBackscanColor() {
	return backscanColor;
    }

    /**
     * Sets the backscan color.
     * 
     * @param backscanColor
     *            the new backscan color
     */
    public void setBackscanColor(String backscanColor) {
	this.backscanColor = backscanColor;
    }

    /**
     * Gets the cameras.
     * 
     * @return the cameras
     */
    public String getCameras() {
	return cameras;
    }

    /**
     * Sets the cameras.
     * 
     * @param cameras
     *            the new cameras
     */
    public void setCameras(String cameras) {
	this.cameras = cameras;
    }

    /**
     * Gets the camdata.
     * 
     * @return the camdata
     */
    public String getCamdata() {
	return camdata;
    }

    /**
     * Sets the camdata.
     * 
     * @param camdata
     *            the new camdata
     */
    public void setCamdata(String camdata) {
	this.camdata = camdata;
    }

    /**
     * Gets the cards.
     * 
     * @return the cards
     */
    public Integer getCards() {
	return cards;
    }

    /**
     * Sets the cards.
     * 
     * @param cards
     *            the new cards
     */
    public void setCards(Integer cards) {
	this.cards = cards;
    }

    /**
     * Gets the char support.
     * 
     * @return the char support
     */
    public String getCharSupport() {
	return charSupport;
    }

    /**
     * Sets the char support.
     * 
     * @param charSupport
     *            the new char support
     */
    public void setCharSupport(String charSupport) {
	this.charSupport = charSupport;
    }

    /**
     * Gets the chipio.
     * 
     * @return the chipio
     */
    public Boolean getChipio() {
	return chipio;
    }

    /**
     * Sets the chipio.
     * 
     * @param chipio
     *            the new chipio
     */
    public void setChipio(Boolean chipio) {
	this.chipio = chipio;
    }

    /**
     * Gets the chip power.
     * 
     * @return the chip power
     */
    public String getChipPower() {
	return chipPower;
    }

    /**
     * Sets the chip power.
     * 
     * @param chipPower
     *            the new chip power
     */
    public void setChipPower(String chipPower) {
	this.chipPower = chipPower;
    }

    /**
     * Gets the chip protocol.
     * 
     * @return the chip protocol
     */
    public String getChipProtocol() {
	return chipProtocol;
    }

    /**
     * Sets the chip protocol.
     * 
     * @param chipProtocol
     *            the new chip protocol
     */
    public void setChipProtocol(String chipProtocol) {
	this.chipProtocol = chipProtocol;
    }

    /**
     * Gets the code line format.
     * 
     * @return the code line format
     */
    public String getCodeLineFormat() {
	return codeLineFormat;
    }

    /**
     * Sets the code line format.
     * 
     * @param codeLineFormat
     *            the new code line format
     */
    public void setCodeLineFormat(String codeLineFormat) {
	this.codeLineFormat = codeLineFormat;
    }

    /**
     * Gets the compound.
     * 
     * @return the compound
     */
    public Boolean getCompound() {
	return compound;
    }

    /**
     * Sets the compound.
     * 
     * @param compound
     *            the new compound
     */
    public void setCompound(Boolean compound) {
	this.compound = compound;
    }

    /**
     * Gets the comparemagneticstripe.
     * 
     * @return the comparemagneticstripe
     */
    public Boolean getComparemagneticstripe() {
	return comparemagneticstripe;
    }

    /**
     * Sets the comparemagneticstripe.
     * 
     * @param comparemagneticstripe
     *            the new comparemagneticstripe
     */
    public void setComparemagneticstripe(Boolean comparemagneticstripe) {
	this.comparemagneticstripe = comparemagneticstripe;
    }

    /**
     * Gets the control.
     * 
     * @return the control
     */
    public String getControl() {
	return control;
    }

    /**
     * Sets the control.
     * 
     * @param control
     *            the new control
     */
    public void setControl(String control) {
	this.control = control;
    }

    /**
     * Gets the cursor.
     * 
     * @return the cursor
     */
    public Boolean getCursor() {
	return cursor;
    }

    /**
     * Sets the cursor.
     * 
     * @param cursor
     *            the new cursor
     */
    public void setCursor(Boolean cursor) {
	this.cursor = cursor;
    }

    /**
     * Gets the default backscan color.
     * 
     * @return the default backscan color
     */
    public String getDefaultBackscanColor() {
	return defaultBackscanColor;
    }

    /**
     * Sets the default backscan color.
     * 
     * @param defaultBackscanColor
     *            the new default backscan color
     */
    public void setDefaultBackscanColor(String defaultBackscanColor) {
	this.defaultBackscanColor = defaultBackscanColor;
    }

    /**
     * Gets the default frontscan color.
     * 
     * @return the default frontscan color
     */
    public String getDefaultFrontscanColor() {
	return defaultFrontscanColor;
    }

    /**
     * Sets the default frontscan color.
     * 
     * @param defaultFrontscanColor
     *            the new default frontscan color
     */
    public void setDefaultFrontscanColor(String defaultFrontscanColor) {
	this.defaultFrontscanColor = defaultFrontscanColor;
    }

    /**
     * Gets the deptransport.
     * 
     * @return the deptransport
     */
    public Boolean getDeptransport() {
	return deptransport;
    }

    /**
     * Sets the deptransport.
     * 
     * @param deptransport
     *            the new deptransport
     */
    public void setDeptransport(Boolean deptransport) {
	this.deptransport = deptransport;
    }

    /**
     * Gets the derivation algorithms.
     * 
     * @return the derivation algorithms
     */
    public String getDerivationAlgorithms() {
	return derivationAlgorithms;
    }

    /**
     * Sets the derivation algorithms.
     * 
     * @param derivationAlgorithms
     *            the new derivation algorithms
     */
    public void setDerivationAlgorithms(String derivationAlgorithms) {
	this.derivationAlgorithms = derivationAlgorithms;
    }

    /**
     * Gets the checks if is prepare dispense.
     * 
     * @return the checks if is prepare dispense
     */
    public Boolean getIsPrepareDispense() {
	return isPrepareDispense;
    }

    /**
     * Sets the checks if is prepare dispense.
     * 
     * @param isPrepareDispense
     *            the new checks if is prepare dispense
     */
    public void setIsPrepareDispense(Boolean isPrepareDispense) {
	this.isPrepareDispense = isPrepareDispense;
    }

    /**
     * Gets the dip mode.
     * 
     * @return the dip mode
     */
    public String getDipMode() {
	return dipMode;
    }

    /**
     * Sets the dip mode.
     * 
     * @param dipMode
     *            the new dip mode
     */
    public void setDipMode(String dipMode) {
	this.dipMode = dipMode;
    }

    /**
     * Gets the dispense to.
     * 
     * @return the dispense to
     */
    public String getDispenseTo() {
	return dispenseTo;
    }

    /**
     * Sets the dispense to.
     * 
     * @param dispenseTo
     *            the new dispense to
     */
    public void setDispenseTo(String dispenseTo) {
	this.dispenseTo = dispenseTo;
    }

    /**
     * Gets the display.
     * 
     * @return the display
     */
    public String getDisplay() {
	return display;
    }

    /**
     * Sets the display.
     * 
     * @param display
     *            the new display
     */
    public void setDisplay(String display) {
	this.display = display;
    }

    /**
     * Gets the display light.
     * 
     * @return the display light
     */
    public Boolean getDisplayLight() {
	return displayLight;
    }

    /**
     * Sets the display light.
     * 
     * @param displayLight
     *            the new display light
     */
    public void setDisplayLight(Boolean displayLight) {
	this.displayLight = displayLight;
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
     * Gets the eject position.
     * 
     * @return the eject position
     */
    public String getEjectPosition() {
	return ejectPosition;
    }

    /**
     * Sets the eject position.
     * 
     * @param ejectPosition
     *            the new eject position
     */
    public void setEjectPosition(String ejectPosition) {
	this.ejectPosition = ejectPosition;
    }

    /**
     * Gets the emv hash algorithm.
     * 
     * @return the emv hash algorithm
     */
    public String getEmvHashAlgorithm() {
	return emvHashAlgorithm;
    }

    /**
     * Sets the emv hash algorithm.
     * 
     * @param emvHashAlgorithm
     *            the new emv hash algorithm
     */
    public void setEmvHashAlgorithm(String emvHashAlgorithm) {
	this.emvHashAlgorithm = emvHashAlgorithm;
    }

    /**
     * Gets the emv import schemes.
     * 
     * @return the emv import schemes
     */
    public String getEmvImportSchemes() {
	return emvImportSchemes;
    }

    /**
     * Sets the emv import schemes.
     * 
     * @param emvImportSchemes
     *            the new emv import schemes
     */
    public void setEmvImportSchemes(String emvImportSchemes) {
	this.emvImportSchemes = emvImportSchemes;
    }

    /**
     * Gets the encio protocols.
     * 
     * @return the encio protocols
     */
    public String getEncioProtocols() {
	return encioProtocols;
    }

    /**
     * Sets the encio protocols.
     * 
     * @param encioProtocols
     *            the new encio protocols
     */
    public void setEncioProtocols(String encioProtocols) {
	this.encioProtocols = encioProtocols;
    }

    /**
     * Gets the encoder.
     * 
     * @return the encoder
     */
    public Boolean getEncoder() {
	return encoder;
    }

    /**
     * Sets the encoder.
     * 
     * @param encoder
     *            the new encoder
     */
    public void setEncoder(Boolean encoder) {
	this.encoder = encoder;
    }

    /**
     * Gets the encodenames.
     * 
     * @return the encodenames
     */
    public String getEncodenames() {
	return encodenames;
    }

    /**
     * Sets the encodenames.
     * 
     * @param encodenames
     *            the new encodenames
     */
    public void setEncodenames(String encodenames) {
	this.encodenames = encodenames;
    }

    /**
     * Gets the endorser.
     * 
     * @return the endorser
     */
    public Boolean getEndorser() {
	return endorser;
    }

    /**
     * Sets the endorser.
     * 
     * @param endorser
     *            the new endorser
     */
    public void setEndorser(Boolean endorser) {
	this.endorser = endorser;
    }

    /**
     * Gets the envelopesupply.
     * 
     * @return the envelopesupply
     */
    public String getEnvelopesupply() {
	return envelopesupply;
    }

    /**
     * Sets the envelopesupply.
     * 
     * @param envelopesupply
     *            the new envelopesupply
     */
    public void setEnvelopesupply(String envelopesupply) {
	this.envelopesupply = envelopesupply;
    }

    /**
     * Gets the exchange types.
     * 
     * @return the exchange types
     */
    public String getExchangeTypes() {
	return exchangeTypes;
    }

    /**
     * Sets the exchange types.
     * 
     * @param exchangeTypes
     *            the new exchange types
     */
    public void setExchangeTypes(String exchangeTypes) {
	this.exchangeTypes = exchangeTypes;
    }

    /**
     * Gets the extents.
     * 
     * @return the extents
     */
    public String getExtents() {
	return extents;
    }

    /**
     * Sets the extents.
     * 
     * @param extents
     *            the new extents
     */
    public void setExtents(String extents) {
	this.extents = extents;
    }

    /**
     * Gets the extra.
     * 
     * @return the extra
     */
    public String getExtra() {
	return extra;
    }

    /**
     * Sets the extra.
     * 
     * @param extra
     *            the new extra
     */
    public void setExtra(String extra) {
	this.extra = extra;
    }

    /**
     * Gets the fontnames.
     * 
     * @return the fontnames
     */
    public String getFontnames() {
	return fontnames;
    }

    /**
     * Sets the fontnames.
     * 
     * @param fontnames
     *            the new fontnames
     */
    public void setFontnames(String fontnames) {
	this.fontnames = fontnames;
    }

    /**
     * Gets the forms.
     * 
     * @return the forms
     */
    public Boolean getForms() {
	return forms;
    }

    /**
     * Sets the forms.
     * 
     * @param forms
     *            the new forms
     */
    public void setForms(Boolean forms) {
	this.forms = forms;
    }

    /**
     * Gets the front image color format.
     * 
     * @return the front image color format
     */
    public String getFrontImageColorFormat() {
	return frontImageColorFormat;
    }

    /**
     * Sets the front image color format.
     * 
     * @param frontImageColorFormat
     *            the new front image color format
     */
    public void setFrontImageColorFormat(String frontImageColorFormat) {
	this.frontImageColorFormat = frontImageColorFormat;
    }

    /**
     * Gets the frontscan color.
     * 
     * @return the frontscan color
     */
    public String getFrontscanColor() {
	return frontscanColor;
    }

    /**
     * Sets the frontscan color.
     * 
     * @param frontscanColor
     *            the new frontscan color
     */
    public void setFrontscanColor(String frontscanColor) {
	this.frontscanColor = frontscanColor;
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
     * Gets the checks for cash box.
     * 
     * @return the checks for cash box
     */
    public Boolean getHasCashBox() {
	return hasCashBox;
    }

    /**
     * Sets the checks for cash box.
     * 
     * @param hasCashBox
     *            the new checks for cash box
     */
    public void setHasCashBox(Boolean hasCashBox) {
	this.hasCashBox = hasCashBox;
    }

    /**
     * Gets the checks for inserted sensor.
     * 
     * @return the checks for inserted sensor
     */
    public Boolean getHasInsertedSensor() {
	return hasInsertedSensor;
    }

    /**
     * Sets the checks for inserted sensor.
     * 
     * @param hasInsertedSensor
     *            the new checks for inserted sensor
     */
    public void setHasInsertedSensor(Boolean hasInsertedSensor) {
	this.hasInsertedSensor = hasInsertedSensor;
    }

    /**
     * Gets the checks for shutter.
     * 
     * @return the checks for shutter
     */
    public Boolean getHasShutter() {
	return hasShutter;
    }

    /**
     * Sets the checks for shutter.
     * 
     * @param hasShutter
     *            the new checks for shutter
     */
    public void setHasShutter(Boolean hasShutter) {
	this.hasShutter = hasShutter;
    }

    /**
     * Gets the checks for taken sensor.
     * 
     * @return the checks for taken sensor
     */
    public Boolean getHasTakenSensor() {
	return hasTakenSensor;
    }

    /**
     * Sets the checks for taken sensor.
     * 
     * @param hasTakenSensor
     *            the new checks for taken sensor
     */
    public void setHasTakenSensor(Boolean hasTakenSensor) {
	this.hasTakenSensor = hasTakenSensor;
    }

    /**
     * Gets the hsm vendor.
     * 
     * @return the hsm vendor
     */
    public String getHsmVendor() {
	return hsmVendor;
    }

    /**
     * Sets the hsm vendor.
     * 
     * @param hsmVendor
     *            the new hsm vendor
     */
    public void setHsmVendor(String hsmVendor) {
	this.hsmVendor = hsmVendor;
    }

    /**
     * Gets the id connect.
     * 
     * @return the id connect
     */
    public Boolean getIdConnect() {
	return idConnect;
    }

    /**
     * Sets the id connect.
     * 
     * @param idConnect
     *            the new id connect
     */
    public void setIdConnect(Boolean idConnect) {
	this.idConnect = idConnect;
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
     * Gets the imagecapture.
     * 
     * @return the imagecapture
     */
    public String getImagecapture() {
	return imagecapture;
    }

    /**
     * Sets the imagecapture.
     * 
     * @param imagecapture
     *            the new imagecapture
     */
    public void setImagecapture(String imagecapture) {
	this.imagecapture = imagecapture;
    }

    /**
     * Gets the image source.
     * 
     * @return the image source
     */
    public String getImageSource() {
	return imageSource;
    }

    /**
     * Sets the image source.
     * 
     * @param imageSource
     *            the new image source
     */
    public void setImageSource(String imageSource) {
	this.imageSource = imageSource;
    }

    /**
     * Gets the image type.
     * 
     * @return the image type
     */
    public String getImageType() {
	return imageType;
    }

    /**
     * Sets the image type.
     * 
     * @param imageType
     *            the new image type
     */
    public void setImageType(String imageType) {
	this.imageType = imageType;
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
     * Gets the insert orientation.
     * 
     * @return the insert orientation
     */
    public String getInsertOrientation() {
	return insertOrientation;
    }

    /**
     * Sets the insert orientation.
     * 
     * @param insertOrientation
     *            the new insert orientation
     */
    public void setInsertOrientation(String insertOrientation) {
	this.insertOrientation = insertOrientation;
    }

    /**
     * Gets the intermediate stacker.
     * 
     * @return the intermediate stacker
     */
    public Integer getIntermediateStacker() {
	return intermediateStacker;
    }

    /**
     * Sets the intermediate stacker.
     * 
     * @param intermediateStacker
     *            the new intermediate stacker
     */
    public void setIntermediateStacker(Integer intermediateStacker) {
	this.intermediateStacker = intermediateStacker;
    }

    /**
     * Gets the checks if is application refuse.
     * 
     * @return the checks if is application refuse
     */
    public Boolean getIsApplicationRefuse() {
	return isApplicationRefuse;
    }

    /**
     * Sets the checks if is application refuse.
     * 
     * @param isApplicationRefuse
     *            the new checks if is application refuse
     */
    public void setIsApplicationRefuse(Boolean isApplicationRefuse) {
	this.isApplicationRefuse = isApplicationRefuse;
    }

    /**
     * Gets the checks if is autofeed.
     * 
     * @return the checks if is autofeed
     */
    public Boolean getIsAutofeed() {
	return isAutofeed;
    }

    /**
     * Sets the checks if is autofeed.
     * 
     * @param isAutofeed
     *            the new checks if is autofeed
     */
    public void setIsAutofeed(Boolean isAutofeed) {
	this.isAutofeed = isAutofeed;
    }

    /**
     * Gets the checks if is card taken sensor.
     * 
     * @return the checks if is card taken sensor
     */
    public Boolean getIsCardTakenSensor() {
	return isCardTakenSensor;
    }

    /**
     * Sets the checks if is card taken sensor.
     * 
     * @param isCardTakenSensor
     *            the new checks if is card taken sensor
     */
    public void setIsCardTakenSensor(Boolean isCardTakenSensor) {
	this.isCardTakenSensor = isCardTakenSensor;
    }

    /**
     * Gets the checks if is compare signatures.
     * 
     * @return the checks if is compare signatures
     */
    public Boolean getIsCompareSignatures() {
	return isCompareSignatures;
    }

    /**
     * Sets the checks if is compare signatures.
     * 
     * @param isCompareSignatures
     *            the new checks if is compare signatures
     */
    public void setIsCompareSignatures(Boolean isCompareSignatures) {
	this.isCompareSignatures = isCompareSignatures;
    }

    /**
     * Gets the checks if is hsm journaling.
     * 
     * @return the checks if is hsm journaling
     */
    public Boolean getIsHsmJournaling() {
	return isHsmJournaling;
    }

    /**
     * Sets the checks if is hsm journaling.
     * 
     * @param isHsmJournaling
     *            the new checks if is hsm journaling
     */
    public void setIsHsmJournaling(Boolean isHsmJournaling) {
	this.isHsmJournaling = isHsmJournaling;
    }

    /**
     * Gets the checks if is intermediate stacker.
     * 
     * @return the checks if is intermediate stacker
     */
    public Boolean getIsIntermediateStacker() {
	return isIntermediateStacker;
    }

    /**
     * Sets the checks if is intermediate stacker.
     * 
     * @param isIntermediateStacker
     *            the new checks if is intermediate stacker
     */
    public void setIsIntermediateStacker(Boolean isIntermediateStacker) {
	this.isIntermediateStacker = isIntermediateStacker;
    }

    /**
     * Gets the checks if is items taken sensor.
     * 
     * @return the checks if is items taken sensor
     */
    public Boolean getIsItemsTakenSensor() {
	return isItemsTakenSensor;
    }

    /**
     * Sets the checks if is items taken sensor.
     * 
     * @param isItemsTakenSensor
     *            the new checks if is items taken sensor
     */
    public void setIsItemsTakenSensor(Boolean isItemsTakenSensor) {
	this.isItemsTakenSensor = isItemsTakenSensor;
    }

    /**
     * Gets the checks if is key import through parts.
     * 
     * @return the checks if is key import through parts
     */
    public Boolean getIsKeyImportThroughParts() {
	return isKeyImportThroughParts;
    }

    /**
     * Sets the checks if is key import through parts.
     * 
     * @param isKeyImportThroughParts
     *            the new checks if is key import through parts
     */
    public void setIsKeyImportThroughParts(Boolean isKeyImportThroughParts) {
	this.isKeyImportThroughParts = isKeyImportThroughParts;
    }

    /**
     * Gets the checks if is media presented.
     * 
     * @return the checks if is media presented
     */
    public Boolean getIsMediaPresented() {
	return isMediaPresented;
    }

    /**
     * Sets the checks if is media presented.
     * 
     * @param isMediaPresented
     *            the new checks if is media presented
     */
    public void setIsMediaPresented(Boolean isMediaPresented) {
	this.isMediaPresented = isMediaPresented;
    }

    /**
     * Gets the checks if is pin can persist after use.
     * 
     * @return the checks if is pin can persist after use
     */
    public Boolean getIsPinCanPersistAfterUse() {
	return isPinCanPersistAfterUse;
    }

    /**
     * Sets the checks if is pin can persist after use.
     * 
     * @param isPinCanPersistAfterUse
     *            the new checks if is pin can persist after use
     */
    public void setIsPinCanPersistAfterUse(Boolean isPinCanPersistAfterUse) {
	this.isPinCanPersistAfterUse = isPinCanPersistAfterUse;
    }

    /**
     * Gets the checks if is present control.
     * 
     * @return the checks if is present control
     */
    public Boolean getIsPresentControl() {
	return isPresentControl;
    }

    /**
     * Sets the checks if is present control.
     * 
     * @param isPresentControl
     *            the new checks if is present control
     */
    public void setIsPresentControl(Boolean isPresentControl) {
	this.isPresentControl = isPresentControl;
    }

    /**
     * Gets the checks if is rescan.
     * 
     * @return the checks if is rescan
     */
    public Boolean getIsRescan() {
	return isRescan;
    }

    /**
     * Sets the checks if is rescan.
     * 
     * @param isRescan
     *            the new checks if is rescan
     */
    public void setIsRescan(Boolean isRescan) {
	this.isRescan = isRescan;
    }

    /**
     * Gets the checks if is retract counts items.
     * 
     * @return the checks if is retract counts items
     */
    public Boolean getIsRetractCountsItems() {
	return isRetractCountsItems;
    }

    /**
     * Sets the checks if is retract counts items.
     * 
     * @param isRetractCountsItems
     *            the new checks if is retract counts items
     */
    public void setIsRetractCountsItems(Boolean isRetractCountsItems) {
	this.isRetractCountsItems = isRetractCountsItems;
    }

    /**
     * Gets the checks if is retract to transport.
     * 
     * @return the checks if is retract to transport
     */
    public Boolean getIsRetractToTransport() {
	return isRetractToTransport;
    }

    /**
     * Sets the checks if is retract to transport.
     * 
     * @param isRetractToTransport
     *            the new checks if is retract to transport
     */
    public void setIsRetractToTransport(Boolean isRetractToTransport) {
	this.isRetractToTransport = isRetractToTransport;
    }

    /**
     * Gets the checks if is safe door.
     * 
     * @return the checks if is safe door
     */
    public Boolean getIsSafeDoor() {
	return isSafeDoor;
    }

    /**
     * Sets the checks if is safe door.
     * 
     * @param isSafeDoor
     *            the new checks if is safe door
     */
    public void setIsSafeDoor(Boolean isSafeDoor) {
	this.isSafeDoor = isSafeDoor;
    }

    /**
     * Gets the checks if is set pin block data required.
     * 
     * @return the checks if is set pin block data required
     */
    public Boolean getIsSetPinBlockDataRequired() {
	return isSetPinBlockDataRequired;
    }

    /**
     * Sets the checks if is set pin block data required.
     * 
     * @param isSetPinBlockDataRequired
     *            the new checks if is set pin block data required
     */
    public void setIsSetPinBlockDataRequired(Boolean isSetPinBlockDataRequired) {
	this.isSetPinBlockDataRequired = isSetPinBlockDataRequired;
    }

    /**
     * Gets the checks if is stamp.
     * 
     * @return the checks if is stamp
     */
    public Boolean getIsStamp() {
	return isStamp;
    }

    /**
     * Sets the checks if is stamp.
     * 
     * @param isStamp
     *            the new checks if is stamp
     */
    public void setIsStamp(Boolean isStamp) {
	this.isStamp = isStamp;
    }

    /**
     * Gets the checks if is type combined.
     * 
     * @return the checks if is type combined
     */
    public Boolean getIsTypeCombined() {
	return isTypeCombined;
    }

    /**
     * Sets the checks if is type combined.
     * 
     * @param isTypeCombined
     *            the new checks if is type combined
     */
    public void setIsTypeCombined(Boolean isTypeCombined) {
	this.isTypeCombined = isTypeCombined;
    }

    /**
     * Gets the item info types.
     * 
     * @return the item info types
     */
    public String getItemInfoTypes() {
	return itemInfoTypes;
    }

    /**
     * Sets the item info types.
     * 
     * @param itemInfoTypes
     *            the new item info types
     */
    public void setItemInfoTypes(String itemInfoTypes) {
	this.itemInfoTypes = itemInfoTypes;
    }

    /**
     * Gets the key block import formats.
     * 
     * @return the key block import formats
     */
    public String getKeyBlockImportFormats() {
	return keyBlockImportFormats;
    }

    /**
     * Sets the key block import formats.
     * 
     * @param keyBlockImportFormats
     *            the new key block import formats
     */
    public void setKeyBlockImportFormats(String keyBlockImportFormats) {
	this.keyBlockImportFormats = keyBlockImportFormats;
    }

    /**
     * Gets the key check modes.
     * 
     * @return the key check modes
     */
    public String getKeyCheckModes() {
	return keyCheckModes;
    }

    /**
     * Sets the key check modes.
     * 
     * @param keyCheckModes
     *            the new key check modes
     */
    public void setKeyCheckModes(String keyCheckModes) {
	this.keyCheckModes = keyCheckModes;
    }

    /**
     * Gets the key lock.
     * 
     * @return the key lock
     */
    public Boolean getKeyLock() {
	return keyLock;
    }

    /**
     * Sets the key lock.
     * 
     * @param keyLock
     *            the new key lock
     */
    public void setKeyLock(Boolean keyLock) {
	this.keyLock = keyLock;
    }

    /**
     * Gets the key num.
     * 
     * @return the key num
     */
    public Integer getKeyNum() {
	return keyNum;
    }

    /**
     * Sets the key num.
     * 
     * @param keyNum
     *            the new key num
     */
    public void setKeyNum(Integer keyNum) {
	this.keyNum = keyNum;
    }

    /**
     * Gets the logical.
     * 
     * @return the logical
     */
    public String getLogical() {
	return logical;
    }

    /**
     * Sets the logical.
     * 
     * @param logical
     *            the new logical
     */
    public void setLogical(String logical) {
	this.logical = logical;
    }

    /**
     * Gets the magneticstriperead.
     * 
     * @return the magneticstriperead
     */
    public Boolean getMagneticstriperead() {
	return magneticstriperead;
    }

    /**
     * Sets the magneticstriperead.
     * 
     * @param magneticstriperead
     *            the new magneticstriperead
     */
    public void setMagneticstriperead(Boolean magneticstriperead) {
	this.magneticstriperead = magneticstriperead;
    }

    /**
     * Gets the magneticstripewrite.
     * 
     * @return the magneticstripewrite
     */
    public Boolean getMagneticstripewrite() {
	return magneticstripewrite;
    }

    /**
     * Sets the magneticstripewrite.
     * 
     * @param magneticstripewrite
     *            the new magneticstripewrite
     */
    public void setMagneticstripewrite(Boolean magneticstripewrite) {
	this.magneticstripewrite = magneticstripewrite;
    }

    /**
     * Gets the max cash in items.
     * 
     * @return the max cash in items
     */
    public Integer getMaxCashInItems() {
	return maxCashInItems;
    }

    /**
     * Sets the max cash in items.
     * 
     * @param maxCashInItems
     *            the new max cash in items
     */
    public void setMaxCashInItems(Integer maxCashInItems) {
	this.maxCashInItems = maxCashInItems;
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
     * Gets the max dispense items.
     * 
     * @return the max dispense items
     */
    public Integer getMaxDispenseItems() {
	return maxDispenseItems;
    }

    /**
     * Sets the max dispense items.
     * 
     * @param maxDispenseItems
     *            the new max dispense items
     */
    public void setMaxDispenseItems(Integer maxDispenseItems) {
	this.maxDispenseItems = maxDispenseItems;
    }

    /**
     * Gets the max media on stacker.
     * 
     * @return the max media on stacker
     */
    public Integer getMaxMediaOnStacker() {
	return maxMediaOnStacker;
    }

    /**
     * Sets the max media on stacker.
     * 
     * @param maxMediaOnStacker
     *            the new max media on stacker
     */
    public void setMaxMediaOnStacker(Integer maxMediaOnStacker) {
	this.maxMediaOnStacker = maxMediaOnStacker;
    }

    /**
     * Gets the max num chars.
     * 
     * @return the max num chars
     */
    public Integer getMaxNumChars() {
	return maxNumChars;
    }

    /**
     * Sets the max num chars.
     * 
     * @param maxNumChars
     *            the new max num chars
     */
    public void setMaxNumChars(Integer maxNumChars) {
	this.maxNumChars = maxNumChars;
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
    public String getMaxRetract() {
	return maxRetract;
    }

    /**
     * Sets the max retract.
     * 
     * @param maxRetract
     *            the new max retract
     */
    public void setMaxRetract(String maxRetract) {
	this.maxRetract = maxRetract;
    }

    /**
     * Gets the media taken.
     * 
     * @return the media taken
     */
    public Boolean getMediaTaken() {
	return mediaTaken;
    }

    /**
     * Sets the media taken.
     * 
     * @param mediaTaken
     *            the new media taken
     */
    public void setMediaTaken(Boolean mediaTaken) {
	this.mediaTaken = mediaTaken;
    }

    /**
     * Gets the memory chip protocols.
     * 
     * @return the memory chip protocols
     */
    public String getMemoryChipProtocols() {
	return memoryChipProtocols;
    }

    /**
     * Sets the memory chip protocols.
     * 
     * @param memoryChipProtocols
     *            the new memory chip protocols
     */
    public void setMemoryChipProtocols(String memoryChipProtocols) {
	this.memoryChipProtocols = memoryChipProtocols;
    }

    /**
     * Gets the micr.
     * 
     * @return the micr
     */
    public Boolean getMicr() {
	return micr;
    }

    /**
     * Sets the micr.
     * 
     * @param micr
     *            the new micr
     */
    public void setMicr(Boolean micr) {
	this.micr = micr;
    }

    /**
     * Gets the move items.
     * 
     * @return the move items
     */
    public String getMoveItems() {
	return moveItems;
    }

    /**
     * Sets the move items.
     * 
     * @param moveItems
     *            the new move items
     */
    public void setMoveItems(String moveItems) {
	this.moveItems = moveItems;
    }

    /**
     * Gets the multi page.
     * 
     * @return the multi page
     */
    public Boolean getMultiPage() {
	return multiPage;
    }

    /**
     * Sets the multi page.
     * 
     * @param multiPage
     *            the new multi page
     */
    public void setMultiPage(Boolean multiPage) {
	this.multiPage = multiPage;
    }

    /**
     * Gets the num leds.
     * 
     * @return the num leds
     */
    public Integer getNumLeds() {
	return numLeds;
    }

    /**
     * Sets the num leds.
     * 
     * @param numLeds
     *            the new num leds
     */
    public void setNumLeds(Integer numLeds) {
	this.numLeds = numLeds;
    }

    /**
     * Gets the ocr.
     * 
     * @return the ocr
     */
    public Boolean getOcr() {
	return ocr;
    }

    /**
     * Sets the ocr.
     * 
     * @param ocr
     *            the new ocr
     */
    public void setOcr(Boolean ocr) {
	this.ocr = ocr;
    }

    /**
     * Gets the paper sources.
     * 
     * @return the paper sources
     */
    public String getPaperSources() {
	return paperSources;
    }

    /**
     * Sets the paper sources.
     * 
     * @param paperSources
     *            the new paper sources
     */
    public void setPaperSources(String paperSources) {
	this.paperSources = paperSources;
    }

    /**
     * Gets the pin formats.
     * 
     * @return the pin formats
     */
    public String getPinFormats() {
	return pinFormats;
    }

    /**
     * Sets the pin formats.
     * 
     * @param pinFormats
     *            the new pin formats
     */
    public void setPinFormats(String pinFormats) {
	this.pinFormats = pinFormats;
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
     * Gets the power save control.
     * 
     * @return the power save control
     */
    public Boolean getPowerSaveControl() {
	return powerSaveControl;
    }

    /**
     * Sets the power save control.
     * 
     * @param powerSaveControl
     *            the new power save control
     */
    public void setPowerSaveControl(Boolean powerSaveControl) {
	this.powerSaveControl = powerSaveControl;
    }

    /**
     * Gets the presentation algorithms.
     * 
     * @return the presentation algorithms
     */
    public String getPresentationAlgorithms() {
	return presentationAlgorithms;
    }

    /**
     * Sets the presentation algorithms.
     * 
     * @param presentationAlgorithms
     *            the new presentation algorithms
     */
    public void setPresentationAlgorithms(String presentationAlgorithms) {
	this.presentationAlgorithms = presentationAlgorithms;
    }

    /**
     * Gets the printer.
     * 
     * @return the printer
     */
    public Boolean getPrinter() {
	return printer;
    }

    /**
     * Sets the printer.
     * 
     * @param printer
     *            the new printer
     */
    public void setPrinter(Boolean printer) {
	this.printer = printer;
    }

    /**
     * Gets the prints the on retracts.
     * 
     * @return the prints the on retracts
     */
    public Boolean getPrintOnRetracts() {
	return printOnRetracts;
    }

    /**
     * Sets the prints the on retracts.
     * 
     * @param printOnRetracts
     *            the new prints the on retracts
     */
    public void setPrintOnRetracts(Boolean printOnRetracts) {
	this.printOnRetracts = printOnRetracts;
    }

    /**
     * Gets the prints the size.
     * 
     * @return the prints the size
     */
    public String getPrintSize() {
	return printSize;
    }

    /**
     * Sets the prints the size.
     * 
     * @param printSize
     *            the new prints the size
     */
    public void setPrintSize(String printSize) {
	this.printSize = printSize;
    }

    /**
     * Gets the programatically deactivate.
     * 
     * @return the programatically deactivate
     */
    public Boolean getProgramaticallyDeactivate() {
	return programaticallyDeactivate;
    }

    /**
     * Sets the programatically deactivate.
     * 
     * @param programaticallyDeactivate
     *            the new programatically deactivate
     */
    public void setProgramaticallyDeactivate(Boolean programaticallyDeactivate) {
	this.programaticallyDeactivate = programaticallyDeactivate;
    }

    /**
     * Gets the provider.
     * 
     * @return the provider
     */
    public String getProvider() {
	return provider;
    }

    /**
     * Sets the provider.
     * 
     * @param provider
     *            the new provider
     */
    public void setProvider(String provider) {
	this.provider = provider;
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
     * Gets the read tracks.
     * 
     * @return the read tracks
     */
    public String getReadTracks() {
	return readTracks;
    }

    /**
     * Sets the read tracks.
     * 
     * @param readTracks
     *            the new read tracks
     */
    public void setReadTracks(String readTracks) {
	this.readTracks = readTracks;
    }

    /**
     * Gets the refill.
     * 
     * @return the refill
     */
    public Boolean getRefill() {
	return refill;
    }

    /**
     * Sets the refill.
     * 
     * @param refill
     *            the new refill
     */
    public void setRefill(Boolean refill) {
	this.refill = refill;
    }

    /**
     * Gets the reset control.
     * 
     * @return the reset control
     */
    public String getResetControl() {
	return resetControl;
    }

    /**
     * Sets the reset control.
     * 
     * @param resetControl
     *            the new reset control
     */
    public void setResetControl(String resetControl) {
	this.resetControl = resetControl;
    }

    /**
     * Gets the resolutions.
     * 
     * @return the resolutions
     */
    public String getResolutions() {
	return resolutions;
    }

    /**
     * Sets the resolutions.
     * 
     * @param resolutions
     *            the new resolutions
     */
    public void setResolutions(String resolutions) {
	this.resolutions = resolutions;
    }

    /**
     * Gets the retract areas.
     * 
     * @return the retract areas
     */
    public String getRetractAreas() {
	return retractAreas;
    }

    /**
     * Sets the retract areas.
     * 
     * @param retractAreas
     *            the new retract areas
     */
    public void setRetractAreas(String retractAreas) {
	this.retractAreas = retractAreas;
    }

    /**
     * Gets the retract bins.
     * 
     * @return the retract bins
     */
    public String getRetractBins() {
	return retractBins;
    }

    /**
     * Sets the retract bins.
     * 
     * @param retractBins
     *            the new retract bins
     */
    public void setRetractBins(String retractBins) {
	this.retractBins = retractBins;
    }

    /**
     * Gets the retractenvelope.
     * 
     * @return the retractenvelope
     */
    public String getRetractenvelope() {
	return retractenvelope;
    }

    /**
     * Sets the retractenvelope.
     * 
     * @param retractenvelope
     *            the new retractenvelope
     */
    public void setRetractenvelope(String retractenvelope) {
	this.retractenvelope = retractenvelope;
    }

    /**
     * Gets the retract stacker actions.
     * 
     * @return the retract stacker actions
     */
    public String getRetractStackerActions() {
	return retractStackerActions;
    }

    /**
     * Sets the retract stacker actions.
     * 
     * @param retractStackerActions
     *            the new retract stacker actions
     */
    public void setRetractStackerActions(String retractStackerActions) {
	this.retractStackerActions = retractStackerActions;
    }

    /**
     * Gets the retract transport actions.
     * 
     * @return the retract transport actions
     */
    public String getRetractTransportActions() {
	return retractTransportActions;
    }

    /**
     * Sets the retract transport actions.
     * 
     * @param retractTransportActions
     *            the new retract transport actions
     */
    public void setRetractTransportActions(String retractTransportActions) {
	this.retractTransportActions = retractTransportActions;
    }

    /**
     * Gets the rsa authentication scheme.
     * 
     * @return the rsa authentication scheme
     */
    public String getRsaAuthenticationScheme() {
	return rsaAuthenticationScheme;
    }

    /**
     * Sets the rsa authentication scheme.
     * 
     * @param rsaAuthenticationScheme
     *            the new rsa authentication scheme
     */
    public void setRsaAuthenticationScheme(String rsaAuthenticationScheme) {
	this.rsaAuthenticationScheme = rsaAuthenticationScheme;
    }

    /**
     * Gets the rsa crypt algorithm.
     * 
     * @return the rsa crypt algorithm
     */
    public String getRsaCryptAlgorithm() {
	return rsaCryptAlgorithm;
    }

    /**
     * Sets the rsa crypt algorithm.
     * 
     * @param rsaCryptAlgorithm
     *            the new rsa crypt algorithm
     */
    public void setRsaCryptAlgorithm(String rsaCryptAlgorithm) {
	this.rsaCryptAlgorithm = rsaCryptAlgorithm;
    }

    /**
     * Gets the rsa keycheck mode.
     * 
     * @return the rsa keycheck mode
     */
    public String getRsaKeycheckMode() {
	return rsaKeycheckMode;
    }

    /**
     * Sets the rsa keycheck mode.
     * 
     * @param rsaKeycheckMode
     *            the new rsa keycheck mode
     */
    public void setRsaKeycheckMode(String rsaKeycheckMode) {
	this.rsaKeycheckMode = rsaKeycheckMode;
    }

    /**
     * Gets the rsa signature algorithm.
     * 
     * @return the rsa signature algorithm
     */
    public String getRsaSignatureAlgorithm() {
	return rsaSignatureAlgorithm;
    }

    /**
     * Sets the rsa signature algorithm.
     * 
     * @param rsaSignatureAlgorithm
     *            the new rsa signature algorithm
     */
    public void setRsaSignatureAlgorithm(String rsaSignatureAlgorithm) {
	this.rsaSignatureAlgorithm = rsaSignatureAlgorithm;
    }

    /**
     * Gets the security type.
     * 
     * @return the security type
     */
    public String getSecurityType() {
	return securityType;
    }

    /**
     * Sets the security type.
     * 
     * @param securityType
     *            the new security type
     */
    public void setSecurityType(String securityType) {
	this.securityType = securityType;
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
     * Gets the shutter control.
     * 
     * @return the shutter control
     */
    public Boolean getShutterControl() {
	return shutterControl;
    }

    /**
     * Sets the shutter control.
     * 
     * @param shutterControl
     *            the new shutter control
     */
    public void setShutterControl(Boolean shutterControl) {
	this.shutterControl = shutterControl;
    }

    /**
     * Gets the signature scheme.
     * 
     * @return the signature scheme
     */
    public String getSignatureScheme() {
	return signatureScheme;
    }

    /**
     * Sets the signature scheme.
     * 
     * @param signatureScheme
     *            the new signature scheme
     */
    public void setSignatureScheme(String signatureScheme) {
	this.signatureScheme = signatureScheme;
    }

    /**
     * Gets the stamp.
     * 
     * @return the stamp
     */
    public String getStamp() {
	return stamp;
    }

    /**
     * Sets the stamp.
     * 
     * @param stamp
     *            the new stamp
     */
    public void setStamp(String stamp) {
	this.stamp = stamp;
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
     * Gets the symbologies.
     * 
     * @return the symbologies
     */
    public String getSymbologies() {
	return symbologies;
    }

    /**
     * Sets the symbologies.
     * 
     * @param symbologies
     *            the new symbologies
     */
    public void setSymbologies(String symbologies) {
	this.symbologies = symbologies;
    }

    /**
     * Gets the can filter symbologies.
     * 
     * @return the can filter symbologies
     */
    public Boolean getCanFilterSymbologies() {
	return canFilterSymbologies;
    }

    /**
     * Sets the can filter symbologies.
     * 
     * @param canFilterSymbologies
     *            the new can filter symbologies
     */
    public void setCanFilterSymbologies(Boolean canFilterSymbologies) {
	this.canFilterSymbologies = canFilterSymbologies;
    }

    /**
     * Gets the toner.
     * 
     * @return the toner
     */
    public Boolean getToner() {
	return toner;
    }

    /**
     * Sets the toner.
     * 
     * @param toner
     *            the new toner
     */
    public void setToner(Boolean toner) {
	this.toner = toner;
    }

    /**
     * Gets the type.
     * 
     * @return the type
     */
    public String getType() {
	return type;
    }

    /**
     * Sets the type.
     * 
     * @param type
     *            the new type
     */
    public void setType(String type) {
	this.type = type;
    }

    /**
     * Gets the validation algorithms.
     * 
     * @return the validation algorithms
     */
    public String getValidationAlgorithms() {
	return validationAlgorithms;
    }

    /**
     * Sets the validation algorithms.
     * 
     * @param validationAlgorithms
     *            the new validation algorithms
     */
    public void setValidationAlgorithms(String validationAlgorithms) {
	this.validationAlgorithms = validationAlgorithms;
    }

    /**
     * Gets the windows printer.
     * 
     * @return the windows printer
     */
    public String getWindowsPrinter() {
	return windowsPrinter;
    }

    /**
     * Sets the windows printer.
     * 
     * @param windowsPrinter
     *            the new windows printer
     */
    public void setWindowsPrinter(String windowsPrinter) {
	this.windowsPrinter = windowsPrinter;
    }

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
     * Gets the write tracks.
     * 
     * @return the write tracks
     */
    public String getWriteTracks() {
	return writeTracks;
    }

    /**
     * Sets the write tracks.
     * 
     * @param writeTracks
     *            the new write tracks
     */
    public void setWriteTracks(String writeTracks) {
	this.writeTracks = writeTracks;
    }

    /**
     * Gets the xfsclasses (i.e. ALM, BCR, CAM, CDM...).
     * 
     * @return the xfsclasses
     */
    public static Set<String> getXfsclasses() {
	return xfsClasses;
    }

    /**
     * Gets the comboboxes data for the query GUI.
     * 
     * @return the comboboxes data
     */
    public static Map<String, Map> getComboboxes() {
	return comboboxes;
    }

    public Boolean getAutodeposit() {
	return autodeposit;
    }

    public void setAutodeposit(Boolean autodeposit) {
	this.autodeposit = autodeposit;
    }

    public Boolean getCoins() {
	return coins;
    }

    public void setCoins(Boolean coins) {
	this.coins = coins;
    }

    public Boolean getCylinders() {
	return cylinders;
    }

    public void setCylinders(Boolean cylinders) {
	this.cylinders = cylinders;
    }

    public String getKeys() {
	return keys;
    }

    public void setKeys(String keys) {
	this.keys = keys;
    }

    public Integer getMax2Retract() {
	return max2Retract;
    }

    public void setMax2Retract(Integer max2Retract) {
	this.max2Retract = max2Retract;
    }

    public Integer getMaxBills() {
	return maxBills;
    }

    public void setMaxBills(Integer maxBills) {
	this.maxBills = maxBills;
    }

    public Integer getMaxCoins() {
	return maxCoins;
    }

    public void setMaxCoins(Integer maxCoins) {
	this.maxCoins = maxCoins;
    }

    public String getOutputPositions() {
	return outputPositions;
    }

    public void setOutputPositions(String outputPositions) {
	this.outputPositions = outputPositions;
    }

    public Integer getPockets() {
	return pockets;
    }

    public void setPockets(Integer pockets) {
	this.pockets = pockets;
    }

    public Boolean getRetractToDeposit() {
	return retractToDeposit;
    }

    public void setRetractToDeposit(Boolean retractToDeposit) {
	this.retractToDeposit = retractToDeposit;
    }

    public Boolean getVandalCheck() {
	return vandalCheck;
    }

    public void setVandalCheck(Boolean vandalCheck) {
	this.vandalCheck = vandalCheck;
    }

    // EP410008 - 28/01/2014
    public Boolean getCashin() {
	return cashin;
    }

    public void setCashin(Boolean cashin) {
	this.cashin = cashin;
    }

    public Boolean getRetract() {
	return retract;
    }

    public void setRetract(Boolean retract) {
	this.retract = retract;
    }

    // <--

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((acceptMedia == null) ? 0 : acceptMedia.hashCode());
	result = prime * result
		+ ((algorithms == null) ? 0 : algorithms.hashCode());
	result = prime * result
		+ ((autobeep == null) ? 0 : autobeep.hashCode());
	result = prime * result
		+ ((autodeposit == null) ? 0 : autodeposit.hashCode());
	result = prime
		* result
		+ ((autoretractPeriod == null) ? 0 : autoretractPeriod
			.hashCode());
	result = prime * result
		+ ((auxiliaries == null) ? 0 : auxiliaries.hashCode());
	result = prime
		* result
		+ ((backImageColorFormat == null) ? 0 : backImageColorFormat
			.hashCode());
	result = prime * result
		+ ((backscanColor == null) ? 0 : backscanColor.hashCode());
	result = prime * result + ((camdata == null) ? 0 : camdata.hashCode());
	result = prime * result + ((cameras == null) ? 0 : cameras.hashCode());
	result = prime
		* result
		+ ((canFilterSymbologies == null) ? 0 : canFilterSymbologies
			.hashCode());
	result = prime * result + ((cards == null) ? 0 : cards.hashCode());
	result = prime * result + ((cashin == null) ? 0 : cashin.hashCode());
	result = prime * result
		+ ((charSupport == null) ? 0 : charSupport.hashCode());
	result = prime * result
		+ ((chipPower == null) ? 0 : chipPower.hashCode());
	result = prime * result
		+ ((chipProtocol == null) ? 0 : chipProtocol.hashCode());
	result = prime * result + ((chipio == null) ? 0 : chipio.hashCode());
	result = prime * result
		+ ((codeLineFormat == null) ? 0 : codeLineFormat.hashCode());
	result = prime * result + ((coins == null) ? 0 : coins.hashCode());
	result = prime
		* result
		+ ((comparemagneticstripe == null) ? 0 : comparemagneticstripe
			.hashCode());
	result = prime * result
		+ ((compound == null) ? 0 : compound.hashCode());
	result = prime * result + ((control == null) ? 0 : control.hashCode());
	result = prime * result + ((cursor == null) ? 0 : cursor.hashCode());
	result = prime * result
		+ ((cylinders == null) ? 0 : cylinders.hashCode());
	result = prime
		* result
		+ ((defaultBackscanColor == null) ? 0 : defaultBackscanColor
			.hashCode());
	result = prime
		* result
		+ ((defaultFrontscanColor == null) ? 0 : defaultFrontscanColor
			.hashCode());
	result = prime * result
		+ ((deptransport == null) ? 0 : deptransport.hashCode());
	result = prime
		* result
		+ ((derivationAlgorithms == null) ? 0 : derivationAlgorithms
			.hashCode());
	result = prime * result + ((dipMode == null) ? 0 : dipMode.hashCode());
	result = prime * result
		+ ((dispenseTo == null) ? 0 : dispenseTo.hashCode());
	result = prime * result + ((display == null) ? 0 : display.hashCode());
	result = prime * result
		+ ((displayLight == null) ? 0 : displayLight.hashCode());
	result = prime * result + ((doors == null) ? 0 : doors.hashCode());
	result = prime * result
		+ ((ejectPosition == null) ? 0 : ejectPosition.hashCode());
	result = prime
		* result
		+ ((emvHashAlgorithm == null) ? 0 : emvHashAlgorithm.hashCode());
	result = prime
		* result
		+ ((emvImportSchemes == null) ? 0 : emvImportSchemes.hashCode());
	result = prime * result
		+ ((encioProtocols == null) ? 0 : encioProtocols.hashCode());
	result = prime * result
		+ ((encodenames == null) ? 0 : encodenames.hashCode());
	result = prime * result + ((encoder == null) ? 0 : encoder.hashCode());
	result = prime * result
		+ ((endorser == null) ? 0 : endorser.hashCode());
	result = prime * result
		+ ((envelopesupply == null) ? 0 : envelopesupply.hashCode());
	result = prime * result
		+ ((exchangeTypes == null) ? 0 : exchangeTypes.hashCode());
	result = prime * result + ((extents == null) ? 0 : extents.hashCode());
	result = prime * result + ((extra == null) ? 0 : extra.hashCode());
	result = prime * result
		+ ((fontnames == null) ? 0 : fontnames.hashCode());
	result = prime * result + ((forms == null) ? 0 : forms.hashCode());
	result = prime
		* result
		+ ((frontImageColorFormat == null) ? 0 : frontImageColorFormat
			.hashCode());
	result = prime * result
		+ ((frontscanColor == null) ? 0 : frontscanColor.hashCode());
	result = prime * result
		+ ((guidlights == null) ? 0 : guidlights.hashCode());
	result = prime * result
		+ ((hasCashBox == null) ? 0 : hasCashBox.hashCode());
	result = prime
		* result
		+ ((hasInsertedSensor == null) ? 0 : hasInsertedSensor
			.hashCode());
	result = prime * result
		+ ((hasShutter == null) ? 0 : hasShutter.hashCode());
	result = prime * result
		+ ((hasTakenSensor == null) ? 0 : hasTakenSensor.hashCode());
	result = prime * result
		+ ((hsmVendor == null) ? 0 : hsmVendor.hashCode());
	result = prime * result
		+ ((idConnect == null) ? 0 : idConnect.hashCode());
	result = prime * result + ((idKey == null) ? 0 : idKey.hashCode());
	result = prime * result
		+ ((imageSource == null) ? 0 : imageSource.hashCode());
	result = prime * result
		+ ((imageType == null) ? 0 : imageType.hashCode());
	result = prime * result
		+ ((imagecapture == null) ? 0 : imagecapture.hashCode());
	result = prime * result
		+ ((indicators == null) ? 0 : indicators.hashCode());
	result = prime
		* result
		+ ((insertOrientation == null) ? 0 : insertOrientation
			.hashCode());
	result = prime
		* result
		+ ((intermediateStacker == null) ? 0 : intermediateStacker
			.hashCode());
	result = prime
		* result
		+ ((isApplicationRefuse == null) ? 0 : isApplicationRefuse
			.hashCode());
	result = prime * result
		+ ((isAutofeed == null) ? 0 : isAutofeed.hashCode());
	result = prime
		* result
		+ ((isCardTakenSensor == null) ? 0 : isCardTakenSensor
			.hashCode());
	result = prime
		* result
		+ ((isCompareSignatures == null) ? 0 : isCompareSignatures
			.hashCode());
	result = prime * result
		+ ((isHsmJournaling == null) ? 0 : isHsmJournaling.hashCode());
	result = prime
		* result
		+ ((isIntermediateStacker == null) ? 0 : isIntermediateStacker
			.hashCode());
	result = prime
		* result
		+ ((isItemsTakenSensor == null) ? 0 : isItemsTakenSensor
			.hashCode());
	result = prime
		* result
		+ ((isKeyImportThroughParts == null) ? 0
			: isKeyImportThroughParts.hashCode());
	result = prime
		* result
		+ ((isMediaPresented == null) ? 0 : isMediaPresented.hashCode());
	result = prime
		* result
		+ ((isPinCanPersistAfterUse == null) ? 0
			: isPinCanPersistAfterUse.hashCode());
	result = prime
		* result
		+ ((isPrepareDispense == null) ? 0 : isPrepareDispense
			.hashCode());
	result = prime
		* result
		+ ((isPresentControl == null) ? 0 : isPresentControl.hashCode());
	result = prime * result
		+ ((isRescan == null) ? 0 : isRescan.hashCode());
	result = prime
		* result
		+ ((isRetractCountsItems == null) ? 0 : isRetractCountsItems
			.hashCode());
	result = prime
		* result
		+ ((isRetractToTransport == null) ? 0 : isRetractToTransport
			.hashCode());
	result = prime * result
		+ ((isSafeDoor == null) ? 0 : isSafeDoor.hashCode());
	result = prime
		* result
		+ ((isSetPinBlockDataRequired == null) ? 0
			: isSetPinBlockDataRequired.hashCode());
	result = prime * result + ((isStamp == null) ? 0 : isStamp.hashCode());
	result = prime * result
		+ ((isTypeCombined == null) ? 0 : isTypeCombined.hashCode());
	result = prime * result
		+ ((itemInfoTypes == null) ? 0 : itemInfoTypes.hashCode());
	result = prime
		* result
		+ ((keyBlockImportFormats == null) ? 0 : keyBlockImportFormats
			.hashCode());
	result = prime * result
		+ ((keyCheckModes == null) ? 0 : keyCheckModes.hashCode());
	result = prime * result + ((keyLock == null) ? 0 : keyLock.hashCode());
	result = prime * result + ((keyNum == null) ? 0 : keyNum.hashCode());
	result = prime * result + ((keys == null) ? 0 : keys.hashCode());
	result = prime * result + ((logical == null) ? 0 : logical.hashCode());
	result = prime
		* result
		+ ((magneticstriperead == null) ? 0 : magneticstriperead
			.hashCode());
	result = prime
		* result
		+ ((magneticstripewrite == null) ? 0 : magneticstripewrite
			.hashCode());
	result = prime * result
		+ ((max2Retract == null) ? 0 : max2Retract.hashCode());
	result = prime * result
		+ ((maxBills == null) ? 0 : maxBills.hashCode());
	result = prime * result
		+ ((maxCashInItems == null) ? 0 : maxCashInItems.hashCode());
	result = prime * result
		+ ((maxCoins == null) ? 0 : maxCoins.hashCode());
	result = prime * result
		+ ((maxDataLength == null) ? 0 : maxDataLength.hashCode());
	result = prime
		* result
		+ ((maxDispenseItems == null) ? 0 : maxDispenseItems.hashCode());
	result = prime
		* result
		+ ((maxMediaOnStacker == null) ? 0 : maxMediaOnStacker
			.hashCode());
	result = prime * result
		+ ((maxNumChars == null) ? 0 : maxNumChars.hashCode());
	result = prime * result
		+ ((maxPictures == null) ? 0 : maxPictures.hashCode());
	result = prime * result
		+ ((maxRetract == null) ? 0 : maxRetract.hashCode());
	result = prime * result
		+ ((mediaTaken == null) ? 0 : mediaTaken.hashCode());
	result = prime
		* result
		+ ((memoryChipProtocols == null) ? 0 : memoryChipProtocols
			.hashCode());
	result = prime * result + ((micr == null) ? 0 : micr.hashCode());
	result = prime * result
		+ ((moveItems == null) ? 0 : moveItems.hashCode());
	result = prime * result
		+ ((multiPage == null) ? 0 : multiPage.hashCode());
	result = prime * result + ((numLeds == null) ? 0 : numLeds.hashCode());
	result = prime * result + ((ocr == null) ? 0 : ocr.hashCode());
	result = prime * result
		+ ((outputPositions == null) ? 0 : outputPositions.hashCode());
	result = prime * result
		+ ((paperSources == null) ? 0 : paperSources.hashCode());
	result = prime * result
		+ ((pinFormats == null) ? 0 : pinFormats.hashCode());
	result = prime * result + ((pockets == null) ? 0 : pockets.hashCode());
	result = prime * result
		+ ((positions == null) ? 0 : positions.hashCode());
	result = prime * result
		+ ((powerOff == null) ? 0 : powerOff.hashCode());
	result = prime * result + ((powerOn == null) ? 0 : powerOn.hashCode());
	result = prime
		* result
		+ ((powerSaveControl == null) ? 0 : powerSaveControl.hashCode());
	result = prime
		* result
		+ ((presentationAlgorithms == null) ? 0
			: presentationAlgorithms.hashCode());
	result = prime * result
		+ ((printOnRetracts == null) ? 0 : printOnRetracts.hashCode());
	result = prime * result
		+ ((printSize == null) ? 0 : printSize.hashCode());
	result = prime * result + ((printer == null) ? 0 : printer.hashCode());
	result = prime
		* result
		+ ((programaticallyDeactivate == null) ? 0
			: programaticallyDeactivate.hashCode());
	result = prime * result
		+ ((provider == null) ? 0 : provider.hashCode());
	result = prime * result
		+ ((readForm == null) ? 0 : readForm.hashCode());
	result = prime * result
		+ ((readTracks == null) ? 0 : readTracks.hashCode());
	result = prime * result + ((refill == null) ? 0 : refill.hashCode());
	result = prime * result
		+ ((resetControl == null) ? 0 : resetControl.hashCode());
	result = prime * result
		+ ((resolutions == null) ? 0 : resolutions.hashCode());
	result = prime * result + ((retract == null) ? 0 : retract.hashCode());
	result = prime * result
		+ ((retractAreas == null) ? 0 : retractAreas.hashCode());
	result = prime * result
		+ ((retractBins == null) ? 0 : retractBins.hashCode());
	result = prime
		* result
		+ ((retractStackerActions == null) ? 0 : retractStackerActions
			.hashCode());
	result = prime
		* result
		+ ((retractToDeposit == null) ? 0 : retractToDeposit.hashCode());
	result = prime
		* result
		+ ((retractTransportActions == null) ? 0
			: retractTransportActions.hashCode());
	result = prime * result
		+ ((retractenvelope == null) ? 0 : retractenvelope.hashCode());
	result = prime
		* result
		+ ((rsaAuthenticationScheme == null) ? 0
			: rsaAuthenticationScheme.hashCode());
	result = prime
		* result
		+ ((rsaCryptAlgorithm == null) ? 0 : rsaCryptAlgorithm
			.hashCode());
	result = prime * result
		+ ((rsaKeycheckMode == null) ? 0 : rsaKeycheckMode.hashCode());
	result = prime
		* result
		+ ((rsaSignatureAlgorithm == null) ? 0 : rsaSignatureAlgorithm
			.hashCode());
	result = prime * result
		+ ((securityType == null) ? 0 : securityType.hashCode());
	result = prime * result + ((sensors == null) ? 0 : sensors.hashCode());
	result = prime * result
		+ ((shutterControl == null) ? 0 : shutterControl.hashCode());
	result = prime * result
		+ ((signatureScheme == null) ? 0 : signatureScheme.hashCode());
	result = prime * result + ((stamp == null) ? 0 : stamp.hashCode());
	result = prime * result
		+ ((symbologies == null) ? 0 : symbologies.hashCode());
	result = prime * result + ((toner == null) ? 0 : toner.hashCode());
	result = prime * result + ((type == null) ? 0 : type.hashCode());
	result = prime
		* result
		+ ((validationAlgorithms == null) ? 0 : validationAlgorithms
			.hashCode());
	result = prime * result
		+ ((vandalCheck == null) ? 0 : vandalCheck.hashCode());
	result = prime * result
		+ ((windowsPrinter == null) ? 0 : windowsPrinter.hashCode());
	result = prime * result
		+ ((writeForm == null) ? 0 : writeForm.hashCode());
	result = prime * result
		+ ((writeMode == null) ? 0 : writeMode.hashCode());
	result = prime * result
		+ ((writeTracks == null) ? 0 : writeTracks.hashCode());
	result = prime * result
		+ ((xfsClass == null) ? 0 : xfsClass.hashCode());
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
	XfsComponent other = (XfsComponent) obj;
	if (acceptMedia == null) {
	    if (other.acceptMedia != null)
		return false;
	} else if (!acceptMedia.equals(other.acceptMedia))
	    return false;
	if (algorithms == null) {
	    if (other.algorithms != null)
		return false;
	} else if (!algorithms.equals(other.algorithms))
	    return false;
	if (autobeep == null) {
	    if (other.autobeep != null)
		return false;
	} else if (!autobeep.equals(other.autobeep))
	    return false;
	if (autodeposit == null) {
	    if (other.autodeposit != null)
		return false;
	} else if (!autodeposit.equals(other.autodeposit))
	    return false;
	if (autoretractPeriod == null) {
	    if (other.autoretractPeriod != null)
		return false;
	} else if (!autoretractPeriod.equals(other.autoretractPeriod))
	    return false;
	if (auxiliaries == null) {
	    if (other.auxiliaries != null)
		return false;
	} else if (!auxiliaries.equals(other.auxiliaries))
	    return false;
	if (backImageColorFormat == null) {
	    if (other.backImageColorFormat != null)
		return false;
	} else if (!backImageColorFormat.equals(other.backImageColorFormat))
	    return false;
	if (backscanColor == null) {
	    if (other.backscanColor != null)
		return false;
	} else if (!backscanColor.equals(other.backscanColor))
	    return false;
	if (camdata == null) {
	    if (other.camdata != null)
		return false;
	} else if (!camdata.equals(other.camdata))
	    return false;
	if (cameras == null) {
	    if (other.cameras != null)
		return false;
	} else if (!cameras.equals(other.cameras))
	    return false;
	if (canFilterSymbologies == null) {
	    if (other.canFilterSymbologies != null)
		return false;
	} else if (!canFilterSymbologies.equals(other.canFilterSymbologies))
	    return false;
	if (cards == null) {
	    if (other.cards != null)
		return false;
	} else if (!cards.equals(other.cards))
	    return false;
	if (cashin == null) {
	    if (other.cashin != null)
		return false;
	} else if (!cashin.equals(other.cashin))
	    return false;
	if (charSupport == null) {
	    if (other.charSupport != null)
		return false;
	} else if (!charSupport.equals(other.charSupport))
	    return false;
	if (chipPower == null) {
	    if (other.chipPower != null)
		return false;
	} else if (!chipPower.equals(other.chipPower))
	    return false;
	if (chipProtocol == null) {
	    if (other.chipProtocol != null)
		return false;
	} else if (!chipProtocol.equals(other.chipProtocol))
	    return false;
	if (chipio == null) {
	    if (other.chipio != null)
		return false;
	} else if (!chipio.equals(other.chipio))
	    return false;
	if (codeLineFormat == null) {
	    if (other.codeLineFormat != null)
		return false;
	} else if (!codeLineFormat.equals(other.codeLineFormat))
	    return false;
	if (coins == null) {
	    if (other.coins != null)
		return false;
	} else if (!coins.equals(other.coins))
	    return false;
	if (comparemagneticstripe == null) {
	    if (other.comparemagneticstripe != null)
		return false;
	} else if (!comparemagneticstripe.equals(other.comparemagneticstripe))
	    return false;
	if (compound == null) {
	    if (other.compound != null)
		return false;
	} else if (!compound.equals(other.compound))
	    return false;
	if (control == null) {
	    if (other.control != null)
		return false;
	} else if (!control.equals(other.control))
	    return false;
	if (cursor == null) {
	    if (other.cursor != null)
		return false;
	} else if (!cursor.equals(other.cursor))
	    return false;
	if (cylinders == null) {
	    if (other.cylinders != null)
		return false;
	} else if (!cylinders.equals(other.cylinders))
	    return false;
	if (defaultBackscanColor == null) {
	    if (other.defaultBackscanColor != null)
		return false;
	} else if (!defaultBackscanColor.equals(other.defaultBackscanColor))
	    return false;
	if (defaultFrontscanColor == null) {
	    if (other.defaultFrontscanColor != null)
		return false;
	} else if (!defaultFrontscanColor.equals(other.defaultFrontscanColor))
	    return false;
	if (deptransport == null) {
	    if (other.deptransport != null)
		return false;
	} else if (!deptransport.equals(other.deptransport))
	    return false;
	if (derivationAlgorithms == null) {
	    if (other.derivationAlgorithms != null)
		return false;
	} else if (!derivationAlgorithms.equals(other.derivationAlgorithms))
	    return false;
	if (dipMode == null) {
	    if (other.dipMode != null)
		return false;
	} else if (!dipMode.equals(other.dipMode))
	    return false;
	if (dispenseTo == null) {
	    if (other.dispenseTo != null)
		return false;
	} else if (!dispenseTo.equals(other.dispenseTo))
	    return false;
	if (display == null) {
	    if (other.display != null)
		return false;
	} else if (!display.equals(other.display))
	    return false;
	if (displayLight == null) {
	    if (other.displayLight != null)
		return false;
	} else if (!displayLight.equals(other.displayLight))
	    return false;
	if (doors == null) {
	    if (other.doors != null)
		return false;
	} else if (!doors.equals(other.doors))
	    return false;
	if (ejectPosition == null) {
	    if (other.ejectPosition != null)
		return false;
	} else if (!ejectPosition.equals(other.ejectPosition))
	    return false;
	if (emvHashAlgorithm == null) {
	    if (other.emvHashAlgorithm != null)
		return false;
	} else if (!emvHashAlgorithm.equals(other.emvHashAlgorithm))
	    return false;
	if (emvImportSchemes == null) {
	    if (other.emvImportSchemes != null)
		return false;
	} else if (!emvImportSchemes.equals(other.emvImportSchemes))
	    return false;
	if (encioProtocols == null) {
	    if (other.encioProtocols != null)
		return false;
	} else if (!encioProtocols.equals(other.encioProtocols))
	    return false;
	if (encodenames == null) {
	    if (other.encodenames != null)
		return false;
	} else if (!encodenames.equals(other.encodenames))
	    return false;
	if (encoder == null) {
	    if (other.encoder != null)
		return false;
	} else if (!encoder.equals(other.encoder))
	    return false;
	if (endorser == null) {
	    if (other.endorser != null)
		return false;
	} else if (!endorser.equals(other.endorser))
	    return false;
	if (envelopesupply == null) {
	    if (other.envelopesupply != null)
		return false;
	} else if (!envelopesupply.equals(other.envelopesupply))
	    return false;
	if (exchangeTypes == null) {
	    if (other.exchangeTypes != null)
		return false;
	} else if (!exchangeTypes.equals(other.exchangeTypes))
	    return false;
	if (extents == null) {
	    if (other.extents != null)
		return false;
	} else if (!extents.equals(other.extents))
	    return false;
	if (extra == null) {
	    if (other.extra != null)
		return false;
	} else if (!extra.equals(other.extra))
	    return false;
	if (fontnames == null) {
	    if (other.fontnames != null)
		return false;
	} else if (!fontnames.equals(other.fontnames))
	    return false;
	if (forms == null) {
	    if (other.forms != null)
		return false;
	} else if (!forms.equals(other.forms))
	    return false;
	if (frontImageColorFormat == null) {
	    if (other.frontImageColorFormat != null)
		return false;
	} else if (!frontImageColorFormat.equals(other.frontImageColorFormat))
	    return false;
	if (frontscanColor == null) {
	    if (other.frontscanColor != null)
		return false;
	} else if (!frontscanColor.equals(other.frontscanColor))
	    return false;
	if (guidlights == null) {
	    if (other.guidlights != null)
		return false;
	} else if (!guidlights.equals(other.guidlights))
	    return false;
	if (hasCashBox == null) {
	    if (other.hasCashBox != null)
		return false;
	} else if (!hasCashBox.equals(other.hasCashBox))
	    return false;
	if (hasInsertedSensor == null) {
	    if (other.hasInsertedSensor != null)
		return false;
	} else if (!hasInsertedSensor.equals(other.hasInsertedSensor))
	    return false;
	if (hasShutter == null) {
	    if (other.hasShutter != null)
		return false;
	} else if (!hasShutter.equals(other.hasShutter))
	    return false;
	if (hasTakenSensor == null) {
	    if (other.hasTakenSensor != null)
		return false;
	} else if (!hasTakenSensor.equals(other.hasTakenSensor))
	    return false;
	if (hsmVendor == null) {
	    if (other.hsmVendor != null)
		return false;
	} else if (!hsmVendor.equals(other.hsmVendor))
	    return false;
	if (idConnect == null) {
	    if (other.idConnect != null)
		return false;
	} else if (!idConnect.equals(other.idConnect))
	    return false;
	if (idKey == null) {
	    if (other.idKey != null)
		return false;
	} else if (!idKey.equals(other.idKey))
	    return false;
	if (imageSource == null) {
	    if (other.imageSource != null)
		return false;
	} else if (!imageSource.equals(other.imageSource))
	    return false;
	if (imageType == null) {
	    if (other.imageType != null)
		return false;
	} else if (!imageType.equals(other.imageType))
	    return false;
	if (imagecapture == null) {
	    if (other.imagecapture != null)
		return false;
	} else if (!imagecapture.equals(other.imagecapture))
	    return false;
	if (indicators == null) {
	    if (other.indicators != null)
		return false;
	} else if (!indicators.equals(other.indicators))
	    return false;
	if (insertOrientation == null) {
	    if (other.insertOrientation != null)
		return false;
	} else if (!insertOrientation.equals(other.insertOrientation))
	    return false;
	if (intermediateStacker == null) {
	    if (other.intermediateStacker != null)
		return false;
	} else if (!intermediateStacker.equals(other.intermediateStacker))
	    return false;
	if (isApplicationRefuse == null) {
	    if (other.isApplicationRefuse != null)
		return false;
	} else if (!isApplicationRefuse.equals(other.isApplicationRefuse))
	    return false;
	if (isAutofeed == null) {
	    if (other.isAutofeed != null)
		return false;
	} else if (!isAutofeed.equals(other.isAutofeed))
	    return false;
	if (isCardTakenSensor == null) {
	    if (other.isCardTakenSensor != null)
		return false;
	} else if (!isCardTakenSensor.equals(other.isCardTakenSensor))
	    return false;
	if (isCompareSignatures == null) {
	    if (other.isCompareSignatures != null)
		return false;
	} else if (!isCompareSignatures.equals(other.isCompareSignatures))
	    return false;
	if (isHsmJournaling == null) {
	    if (other.isHsmJournaling != null)
		return false;
	} else if (!isHsmJournaling.equals(other.isHsmJournaling))
	    return false;
	if (isIntermediateStacker == null) {
	    if (other.isIntermediateStacker != null)
		return false;
	} else if (!isIntermediateStacker.equals(other.isIntermediateStacker))
	    return false;
	if (isItemsTakenSensor == null) {
	    if (other.isItemsTakenSensor != null)
		return false;
	} else if (!isItemsTakenSensor.equals(other.isItemsTakenSensor))
	    return false;
	if (isKeyImportThroughParts == null) {
	    if (other.isKeyImportThroughParts != null)
		return false;
	} else if (!isKeyImportThroughParts
		.equals(other.isKeyImportThroughParts))
	    return false;
	if (isMediaPresented == null) {
	    if (other.isMediaPresented != null)
		return false;
	} else if (!isMediaPresented.equals(other.isMediaPresented))
	    return false;
	if (isPinCanPersistAfterUse == null) {
	    if (other.isPinCanPersistAfterUse != null)
		return false;
	} else if (!isPinCanPersistAfterUse
		.equals(other.isPinCanPersistAfterUse))
	    return false;
	if (isPrepareDispense == null) {
	    if (other.isPrepareDispense != null)
		return false;
	} else if (!isPrepareDispense.equals(other.isPrepareDispense))
	    return false;
	if (isPresentControl == null) {
	    if (other.isPresentControl != null)
		return false;
	} else if (!isPresentControl.equals(other.isPresentControl))
	    return false;
	if (isRescan == null) {
	    if (other.isRescan != null)
		return false;
	} else if (!isRescan.equals(other.isRescan))
	    return false;
	if (isRetractCountsItems == null) {
	    if (other.isRetractCountsItems != null)
		return false;
	} else if (!isRetractCountsItems.equals(other.isRetractCountsItems))
	    return false;
	if (isRetractToTransport == null) {
	    if (other.isRetractToTransport != null)
		return false;
	} else if (!isRetractToTransport.equals(other.isRetractToTransport))
	    return false;
	if (isSafeDoor == null) {
	    if (other.isSafeDoor != null)
		return false;
	} else if (!isSafeDoor.equals(other.isSafeDoor))
	    return false;
	if (isSetPinBlockDataRequired == null) {
	    if (other.isSetPinBlockDataRequired != null)
		return false;
	} else if (!isSetPinBlockDataRequired
		.equals(other.isSetPinBlockDataRequired))
	    return false;
	if (isStamp == null) {
	    if (other.isStamp != null)
		return false;
	} else if (!isStamp.equals(other.isStamp))
	    return false;
	if (isTypeCombined == null) {
	    if (other.isTypeCombined != null)
		return false;
	} else if (!isTypeCombined.equals(other.isTypeCombined))
	    return false;
	if (itemInfoTypes == null) {
	    if (other.itemInfoTypes != null)
		return false;
	} else if (!itemInfoTypes.equals(other.itemInfoTypes))
	    return false;
	if (keyBlockImportFormats == null) {
	    if (other.keyBlockImportFormats != null)
		return false;
	} else if (!keyBlockImportFormats.equals(other.keyBlockImportFormats))
	    return false;
	if (keyCheckModes == null) {
	    if (other.keyCheckModes != null)
		return false;
	} else if (!keyCheckModes.equals(other.keyCheckModes))
	    return false;
	if (keyLock == null) {
	    if (other.keyLock != null)
		return false;
	} else if (!keyLock.equals(other.keyLock))
	    return false;
	if (keyNum == null) {
	    if (other.keyNum != null)
		return false;
	} else if (!keyNum.equals(other.keyNum))
	    return false;
	if (keys == null) {
	    if (other.keys != null)
		return false;
	} else if (!keys.equals(other.keys))
	    return false;
	if (logical == null) {
	    if (other.logical != null)
		return false;
	} else if (!logical.equals(other.logical))
	    return false;
	if (logicalCashUnits == null) {
	    if (other.logicalCashUnits != null)
		return false;
	} else if (!logicalCashUnits.equals(other.logicalCashUnits))
	    return false;
	if (magneticstriperead == null) {
	    if (other.magneticstriperead != null)
		return false;
	} else if (!magneticstriperead.equals(other.magneticstriperead))
	    return false;
	if (magneticstripewrite == null) {
	    if (other.magneticstripewrite != null)
		return false;
	} else if (!magneticstripewrite.equals(other.magneticstripewrite))
	    return false;
	if (max2Retract == null) {
	    if (other.max2Retract != null)
		return false;
	} else if (!max2Retract.equals(other.max2Retract))
	    return false;
	if (maxBills == null) {
	    if (other.maxBills != null)
		return false;
	} else if (!maxBills.equals(other.maxBills))
	    return false;
	if (maxCashInItems == null) {
	    if (other.maxCashInItems != null)
		return false;
	} else if (!maxCashInItems.equals(other.maxCashInItems))
	    return false;
	if (maxCoins == null) {
	    if (other.maxCoins != null)
		return false;
	} else if (!maxCoins.equals(other.maxCoins))
	    return false;
	if (maxDataLength == null) {
	    if (other.maxDataLength != null)
		return false;
	} else if (!maxDataLength.equals(other.maxDataLength))
	    return false;
	if (maxDispenseItems == null) {
	    if (other.maxDispenseItems != null)
		return false;
	} else if (!maxDispenseItems.equals(other.maxDispenseItems))
	    return false;
	if (maxMediaOnStacker == null) {
	    if (other.maxMediaOnStacker != null)
		return false;
	} else if (!maxMediaOnStacker.equals(other.maxMediaOnStacker))
	    return false;
	if (maxNumChars == null) {
	    if (other.maxNumChars != null)
		return false;
	} else if (!maxNumChars.equals(other.maxNumChars))
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
	if (mediaTaken == null) {
	    if (other.mediaTaken != null)
		return false;
	} else if (!mediaTaken.equals(other.mediaTaken))
	    return false;
	if (memoryChipProtocols == null) {
	    if (other.memoryChipProtocols != null)
		return false;
	} else if (!memoryChipProtocols.equals(other.memoryChipProtocols))
	    return false;
	if (micr == null) {
	    if (other.micr != null)
		return false;
	} else if (!micr.equals(other.micr))
	    return false;
	if (moveItems == null) {
	    if (other.moveItems != null)
		return false;
	} else if (!moveItems.equals(other.moveItems))
	    return false;
	if (multiPage == null) {
	    if (other.multiPage != null)
		return false;
	} else if (!multiPage.equals(other.multiPage))
	    return false;
	if (numLeds == null) {
	    if (other.numLeds != null)
		return false;
	} else if (!numLeds.equals(other.numLeds))
	    return false;
	if (ocr == null) {
	    if (other.ocr != null)
		return false;
	} else if (!ocr.equals(other.ocr))
	    return false;
	if (outputPositions == null) {
	    if (other.outputPositions != null)
		return false;
	} else if (!outputPositions.equals(other.outputPositions))
	    return false;
	if (paperSources == null) {
	    if (other.paperSources != null)
		return false;
	} else if (!paperSources.equals(other.paperSources))
	    return false;
	if (pinFormats == null) {
	    if (other.pinFormats != null)
		return false;
	} else if (!pinFormats.equals(other.pinFormats))
	    return false;
	if (pockets == null) {
	    if (other.pockets != null)
		return false;
	} else if (!pockets.equals(other.pockets))
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
	if (powerSaveControl == null) {
	    if (other.powerSaveControl != null)
		return false;
	} else if (!powerSaveControl.equals(other.powerSaveControl))
	    return false;
	if (presentationAlgorithms == null) {
	    if (other.presentationAlgorithms != null)
		return false;
	} else if (!presentationAlgorithms.equals(other.presentationAlgorithms))
	    return false;
	if (printOnRetracts == null) {
	    if (other.printOnRetracts != null)
		return false;
	} else if (!printOnRetracts.equals(other.printOnRetracts))
	    return false;
	if (printSize == null) {
	    if (other.printSize != null)
		return false;
	} else if (!printSize.equals(other.printSize))
	    return false;
	if (printer == null) {
	    if (other.printer != null)
		return false;
	} else if (!printer.equals(other.printer))
	    return false;
	if (programaticallyDeactivate == null) {
	    if (other.programaticallyDeactivate != null)
		return false;
	} else if (!programaticallyDeactivate
		.equals(other.programaticallyDeactivate))
	    return false;
	if (provider == null) {
	    if (other.provider != null)
		return false;
	} else if (!provider.equals(other.provider))
	    return false;
	if (readForm == null) {
	    if (other.readForm != null)
		return false;
	} else if (!readForm.equals(other.readForm))
	    return false;
	if (readTracks == null) {
	    if (other.readTracks != null)
		return false;
	} else if (!readTracks.equals(other.readTracks))
	    return false;
	if (refill == null) {
	    if (other.refill != null)
		return false;
	} else if (!refill.equals(other.refill))
	    return false;
	if (resetControl == null) {
	    if (other.resetControl != null)
		return false;
	} else if (!resetControl.equals(other.resetControl))
	    return false;
	if (resolutions == null) {
	    if (other.resolutions != null)
		return false;
	} else if (!resolutions.equals(other.resolutions))
	    return false;
	if (retract == null) {
	    if (other.retract != null)
		return false;
	} else if (!retract.equals(other.retract))
	    return false;
	if (retractAreas == null) {
	    if (other.retractAreas != null)
		return false;
	} else if (!retractAreas.equals(other.retractAreas))
	    return false;
	if (retractBins == null) {
	    if (other.retractBins != null)
		return false;
	} else if (!retractBins.equals(other.retractBins))
	    return false;
	if (retractStackerActions == null) {
	    if (other.retractStackerActions != null)
		return false;
	} else if (!retractStackerActions.equals(other.retractStackerActions))
	    return false;
	if (retractToDeposit == null) {
	    if (other.retractToDeposit != null)
		return false;
	} else if (!retractToDeposit.equals(other.retractToDeposit))
	    return false;
	if (retractTransportActions == null) {
	    if (other.retractTransportActions != null)
		return false;
	} else if (!retractTransportActions
		.equals(other.retractTransportActions))
	    return false;
	if (retractenvelope == null) {
	    if (other.retractenvelope != null)
		return false;
	} else if (!retractenvelope.equals(other.retractenvelope))
	    return false;
	if (rsaAuthenticationScheme == null) {
	    if (other.rsaAuthenticationScheme != null)
		return false;
	} else if (!rsaAuthenticationScheme
		.equals(other.rsaAuthenticationScheme))
	    return false;
	if (rsaCryptAlgorithm == null) {
	    if (other.rsaCryptAlgorithm != null)
		return false;
	} else if (!rsaCryptAlgorithm.equals(other.rsaCryptAlgorithm))
	    return false;
	if (rsaKeycheckMode == null) {
	    if (other.rsaKeycheckMode != null)
		return false;
	} else if (!rsaKeycheckMode.equals(other.rsaKeycheckMode))
	    return false;
	if (rsaSignatureAlgorithm == null) {
	    if (other.rsaSignatureAlgorithm != null)
		return false;
	} else if (!rsaSignatureAlgorithm.equals(other.rsaSignatureAlgorithm))
	    return false;
	if (securityType == null) {
	    if (other.securityType != null)
		return false;
	} else if (!securityType.equals(other.securityType))
	    return false;
	if (sensors == null) {
	    if (other.sensors != null)
		return false;
	} else if (!sensors.equals(other.sensors))
	    return false;
	if (shutterControl == null) {
	    if (other.shutterControl != null)
		return false;
	} else if (!shutterControl.equals(other.shutterControl))
	    return false;
	if (signatureScheme == null) {
	    if (other.signatureScheme != null)
		return false;
	} else if (!signatureScheme.equals(other.signatureScheme))
	    return false;
	if (stamp == null) {
	    if (other.stamp != null)
		return false;
	} else if (!stamp.equals(other.stamp))
	    return false;
	if (symbologies == null) {
	    if (other.symbologies != null)
		return false;
	} else if (!symbologies.equals(other.symbologies))
	    return false;
	if (toner == null) {
	    if (other.toner != null)
		return false;
	} else if (!toner.equals(other.toner))
	    return false;
	if (type == null) {
	    if (other.type != null)
		return false;
	} else if (!type.equals(other.type))
	    return false;
	if (validationAlgorithms == null) {
	    if (other.validationAlgorithms != null)
		return false;
	} else if (!validationAlgorithms.equals(other.validationAlgorithms))
	    return false;
	if (vandalCheck == null) {
	    if (other.vandalCheck != null)
		return false;
	} else if (!vandalCheck.equals(other.vandalCheck))
	    return false;
	if (windowsPrinter == null) {
	    if (other.windowsPrinter != null)
		return false;
	} else if (!windowsPrinter.equals(other.windowsPrinter))
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
	if (writeTracks == null) {
	    if (other.writeTracks != null)
		return false;
	} else if (!writeTracks.equals(other.writeTracks))
	    return false;
	if (xfsClass == null) {
	    if (other.xfsClass != null)
		return false;
	} else if (!xfsClass.equals(other.xfsClass))
	    return false;
	return true;
    }

}