package com.ncr.ATMMonitoring.pojo;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.type.Type;

import com.ncr.ATMMonitoring.utils.Operation;
import com.ncr.ATMMonitoring.utils.Operation.DataType;
import com.ncr.ATMMonitoring.utils.WidgetQueryAssociationType;

/**
 * The Query Pojo.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "queries")
public class Query implements Serializable {

    private static final long serialVersionUID = 1L;

    /** The comboboxes data for the query designer. */
    private static final Map<String, Map> comboboxes;

    static {
	comboboxes = new TreeMap<String, Map>();
	comboboxes.put("terminal", Terminal.getComboboxes());
	comboboxes.put("financialDevice", FinancialDevice.getComboboxes());
	comboboxes.put("xfsComponent", XfsComponent.getComboboxes());
	comboboxes.put("jxfsComponent", JxfsComponent.getComboboxes());
	comboboxes.put("hotfix", Hotfix.getComboboxes());
	comboboxes.put("internetExplorer", InternetExplorer.getComboboxes());
	comboboxes.put("operatingSystem", OperatingSystem.getComboboxes());
	comboboxes.put("software", Software.getComboboxes());
	comboboxes.put("xfsSw", Software.getComboboxes());
	comboboxes.put("featSw", Software.getComboboxes());
	comboboxes.put("hardwareDevice", HardwareDevice.getComboboxes());
	Map<String, Map> aux = new HashMap<String, Map>();
	aux.put("allOperations", Operation.getOperationsByType(DataType.ALL));
	comboboxes.put("allOperations", aux);
    }

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "queries_id_seq")
    @SequenceGenerator(name = "queries_id_seq", sequenceName = "queries_id_seq", allocationSize = 1)
    private Integer id;

    /** The name. */
    @Column(name = "query_name", length = 50, nullable = false)
    private String name = "";

    /** The description. */
    @Column(name = "description", length = 200)
    private String description = "";

    /** The creation date. */
    @Column(name = "creation_date")
    private Date creationDate;

    /** The user. */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /** The scheduled updates. */
    @OneToMany(mappedBy = "query", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private Set<ScheduledUpdate> scheduledUpdates = new HashSet<ScheduledUpdate>();

    /** The locale. */
    @Column(name = "locale", length = 10)
    private String locale;

    /** The terminal combo11 value. */
    @Column(name = "terminal_c11", length = 50)
    private String terminalCombo11 = "";

    /** The terminal combo12 value. */
    @Column(name = "terminal_c12", length = 50)
    private String terminalCombo12 = "";

    /** The terminal checkbox1 value. */
    @Column(name = "terminal_cb1")
    private Boolean terminalCB1 = false;

    /** The terminal field1 value. */
    @Column(name = "terminal_f1", length = 150)
    private String terminalField1 = "";

    /** The terminal combo21 value. */
    @Column(name = "terminal_c21", length = 50)
    private String terminalCombo21 = "";

    /** The terminal combo22 value. */
    @Column(name = "terminal_c22", length = 50)
    private String terminalCombo22 = "";

    /** The terminal checkbox2 value. */
    @Column(name = "terminal_cb2")
    private Boolean terminalCB2 = false;

    /** The terminal field2 value. */
    @Column(name = "terminal_f2", length = 150)
    private String terminalField2 = "";

    /** The terminal combo31 value. */
    @Column(name = "terminal_c31", length = 50)
    private String terminalCombo31 = "";

    /** The terminal combo32 value. */
    @Column(name = "terminal_c32", length = 50)
    private String terminalCombo32 = "";

    /** The terminal checkbox3 value. */
    @Column(name = "terminal_cb3")
    private Boolean terminalCB3 = false;

    /** The terminal field3 value. */
    @Column(name = "terminal_f3", length = 150)
    private String terminalField3 = "";

    /** The terminal combo41 value. */
    @Column(name = "terminal_c41", length = 50)
    private String terminalCombo41 = "";

    /** The terminal combo42 value. */
    @Column(name = "terminal_c42", length = 50)
    private String terminalCombo42 = "";

    /** The terminal checkbox4 value. */
    @Column(name = "terminal_cb4")
    private Boolean terminalCB4 = false;

    /** The terminal field4 value. */
    @Column(name = "terminal_f4", length = 150)
    private String terminalField4 = "";

    /** The terminal combo51 value. */
    @Column(name = "terminal_c51", length = 50)
    private String terminalCombo51 = "";

    /** The terminal combo52 value. */
    @Column(name = "terminal_c52", length = 50)
    private String terminalCombo52 = "";

    /** The terminal checkbox5 value. */
    @Column(name = "terminal_cb5")
    private Boolean terminalCB5 = false;

    /** The terminal field5 value. */
    @Column(name = "terminal_f5", length = 150)
    private String terminalField5 = "";

    /** The financial device combo11 value. */
    @Column(name = "financial_dev_c11", length = 50)
    private String financialDeviceCombo11 = "";

    /** The financial device combo12 value. */
    @Column(name = "financial_dev_c12", length = 50)
    private String financialDeviceCombo12 = "";

    /** The financial device checkbox1 value. */
    @Column(name = "financial_dev_cb1")
    private Boolean financialDeviceCB1 = false;

    /** The financial device field1 value. */
    @Column(name = "financial_dev_f1", length = 150)
    private String financialDeviceField1 = "";

    /** The financial device combo21 value. */
    @Column(name = "financial_dev_c21", length = 50)
    private String financialDeviceCombo21 = "";

    /** The financial device combo22 value. */
    @Column(name = "financial_dev_c22", length = 50)
    private String financialDeviceCombo22 = "";

    /** The financial device checkbox2 value. */
    @Column(name = "financial_dev_cb2")
    private Boolean financialDeviceCB2 = false;

    /** The financial device field2 value. */
    @Column(name = "financial_dev_f2", length = 150)
    private String financialDeviceField2 = "";

    /** The financial device combo31 value. */
    @Column(name = "financial_dev_c31", length = 50)
    private String financialDeviceCombo31 = "";

    /** The financial device combo32 value. */
    @Column(name = "financial_dev_c32", length = 50)
    private String financialDeviceCombo32 = "";

    /** The financial device checkbox3 value. */
    @Column(name = "financial_dev_cb3")
    private Boolean financialDeviceCB3 = false;

    /** The financial device field3 value. */
    @Column(name = "financial_dev_f3", length = 150)
    private String financialDeviceField3 = "";

    /** The financial device combo41 value. */
    @Column(name = "financial_dev_c41", length = 50)
    private String financialDeviceCombo41 = "";

    /** The financial device combo42 value. */
    @Column(name = "financial_dev_c42", length = 50)
    private String financialDeviceCombo42 = "";

    /** The financial device checkbox4 value. */
    @Column(name = "financial_dev_cb4")
    private Boolean financialDeviceCB4 = false;

    /** The financial device field4 value. */
    @Column(name = "financial_dev_f4", length = 150)
    private String financialDeviceField4 = "";

    /** The financial device combo51 value. */
    @Column(name = "financial_dev_c51", length = 50)
    private String financialDeviceCombo51 = "";

    /** The financial device combo52 value. */
    @Column(name = "financial_dev_c52", length = 50)
    private String financialDeviceCombo52 = "";

    /** The financial device checkbox5 value. */
    @Column(name = "financial_dev_cb5")
    private Boolean financialDeviceCB5 = false;

    /** The financial device field5 value. */
    @Column(name = "financial_dev_f5", length = 150)
    private String financialDeviceField5 = "";

    /** The hotfix combo11 value. */
    @Column(name = "hotfix_c11", length = 50)
    private String hotfixCombo11 = "";

    /** The hotfix combo12 value. */
    @Column(name = "hotfix_c12", length = 50)
    private String hotfixCombo12 = "";

    /** The hotfix checkbox1 value. */
    @Column(name = "hotfix_cb1")
    private Boolean hotfixCB1 = false;

    /** The hotfix field1 value. */
    @Column(name = "hotfix_f1", length = 150)
    private String hotfixField1 = "";

    /** The hotfix combo21 value. */
    @Column(name = "hotfix_c21", length = 50)
    private String hotfixCombo21 = "";

    /** The hotfix combo22 value. */
    @Column(name = "hotfix_c22", length = 50)
    private String hotfixCombo22 = "";

    /** The hotfix checkbox2 value. */
    @Column(name = "hotfix_cb2")
    private Boolean hotfixCB2 = false;

    /** The hotfix field2 value. */
    @Column(name = "hotfix_f2", length = 150)
    private String hotfixField2 = "";

    /** The hotfix combo31 value. */
    @Column(name = "hotfix_c31", length = 50)
    private String hotfixCombo31 = "";

    /** The hotfix combo32 value. */
    @Column(name = "hotfix_c32", length = 50)
    private String hotfixCombo32 = "";

    /** The hotfix checkbox3 value. */
    @Column(name = "hotfix_cb3")
    private Boolean hotfixCB3 = false;

    /** The hotfix field3 value. */
    @Column(name = "hotfix_f3", length = 150)
    private String hotfixField3 = "";

    /** The hotfix combo41 value. */
    @Column(name = "hotfix_c41", length = 50)
    private String hotfixCombo41 = "";

    /** The hotfix combo42 value. */
    @Column(name = "hotfix_c42", length = 50)
    private String hotfixCombo42 = "";

    /** The hotfix checkbox4 value. */
    @Column(name = "hotfix_cb4")
    private Boolean hotfixCB4 = false;

    /** The hotfix field4 value. */
    @Column(name = "hotfix_f4", length = 150)
    private String hotfixField4 = "";

    /** The hotfix combo51 value. */
    @Column(name = "hotfix_c51", length = 50)
    private String hotfixCombo51 = "";

    /** The hotfix combo52 value. */
    @Column(name = "hotfix_c52", length = 50)
    private String hotfixCombo52 = "";

    /** The hotfix checkbox5 value. */
    @Column(name = "hotfix_cb5")
    private Boolean hotfixCB5 = false;

    /** The hotfix field5 value. */
    @Column(name = "hotfix_f5", length = 150)
    private String hotfixField5 = "";

    /** The internet explorer combo11 value. */
    @Column(name = "ie_c11", length = 50)
    private String internetExplorerCombo11 = "";

    /** The internet explorer combo12 value. */
    @Column(name = "ie_c12", length = 50)
    private String internetExplorerCombo12 = "";

    /** The internet explorer checkbox1 value. */
    @Column(name = "ie_cb1")
    private Boolean internetExplorerCB1 = false;

    /** The internet explorer field1 value. */
    @Column(name = "ie_f1", length = 150)
    private String internetExplorerField1 = "";

    /** The internet explorer combo21 value. */
    @Column(name = "ie_c21", length = 50)
    private String internetExplorerCombo21 = "";

    /** The internet explorer combo22 value. */
    @Column(name = "ie_c22", length = 50)
    private String internetExplorerCombo22 = "";

    /** The internet explorer checkbox2 value. */
    @Column(name = "ie_cb2")
    private Boolean internetExplorerCB2 = false;

    /** The internet explorer field2 value. */
    @Column(name = "ie_f2", length = 150)
    private String internetExplorerField2 = "";

    /** The operating system combo11 value. */
    @Column(name = "op_system_c11", length = 50)
    private String operatingSystemCombo11 = "";

    /** The operating system combo12 value. */
    @Column(name = "op_system_c12", length = 50)
    private String operatingSystemCombo12 = "";

    /** The operating system checkbox1 value. */
    @Column(name = "op_system_cb1")
    private Boolean operatingSystemCB1 = false;

    /** The operating system field1 value. */
    @Column(name = "op_system_f1", length = 150)
    private String operatingSystemField1 = "";

    /** The operating system combo21 value. */
    @Column(name = "op_system_c21", length = 50)
    private String operatingSystemCombo21 = "";

    /** The operating system combo22 value. */
    @Column(name = "op_system_c22", length = 50)
    private String operatingSystemCombo22 = "";

    /** The operating system checkbox2 value. */
    @Column(name = "op_system_cb2")
    private Boolean operatingSystemCB2 = false;

    /** The operating system field2 value. */
    @Column(name = "op_system_f2", length = 150)
    private String operatingSystemField2 = "";

    /** The operating system combo31 value. */
    @Column(name = "op_system_c31", length = 50)
    private String operatingSystemCombo31 = "";

    /** The operating system combo32 value. */
    @Column(name = "op_system_c32", length = 50)
    private String operatingSystemCombo32 = "";

    /** The operating system checkbox3 value. */
    @Column(name = "op_system_cb3")
    private Boolean operatingSystemCB3 = false;

    /** The operating system field3 value. */
    @Column(name = "op_system_f3", length = 150)
    private String operatingSystemField3 = "";

    /** The operating system combo41 value. */
    @Column(name = "op_system_c41", length = 50)
    private String operatingSystemCombo41 = "";

    /** The operating system combo42 value. */
    @Column(name = "op_system_c42", length = 50)
    private String operatingSystemCombo42 = "";

    /** The operating system checkbox4 value. */
    @Column(name = "op_system_cb4")
    private Boolean operatingSystemCB4 = false;

    /** The operating system field4 value. */
    @Column(name = "op_system_f4", length = 150)
    private String operatingSystemField4 = "";

    /** The operating system combo51 value. */
    @Column(name = "op_system_c51", length = 50)
    private String operatingSystemCombo51 = "";

    /** The operating system combo52 value. */
    @Column(name = "op_system_c52", length = 50)
    private String operatingSystemCombo52 = "";

    /** The operating system checkbox5 value. */
    @Column(name = "op_system_cb5")
    private Boolean operatingSystemCB5 = false;

    /** The operating system field5 value. */
    @Column(name = "op_system_f5", length = 150)
    private String operatingSystemField5 = "";

    /** The software combo11 value. */
    @Column(name = "software_c11", length = 50)
    private String softwareCombo11 = "";

    /** The software combo12 value. */
    @Column(name = "software_c12", length = 50)
    private String softwareCombo12 = "";

    /** The software checkbox1 value. */
    @Column(name = "software_cb1")
    private Boolean softwareCB1 = false;

    /** The software field1 value. */
    @Column(name = "software_f1", length = 150)
    private String softwareField1 = "";

    /** The software combo21 value. */
    @Column(name = "software_c21", length = 50)
    private String softwareCombo21 = "";

    /** The software combo22 value. */
    @Column(name = "software_c22", length = 50)
    private String softwareCombo22 = "";

    /** The software checkbox2 value. */
    @Column(name = "software_cb2")
    private Boolean softwareCB2 = false;

    /** The software field2 value. */
    @Column(name = "software_f2", length = 150)
    private String softwareField2 = "";

    /** The software combo31 value. */
    @Column(name = "software_c31", length = 50)
    private String softwareCombo31 = "";

    /** The software combo32 value. */
    @Column(name = "software_c32", length = 50)
    private String softwareCombo32 = "";

    /** The software checkbox3 value. */
    @Column(name = "software_cb3")
    private Boolean softwareCB3 = false;

    /** The software field3 value. */
    @Column(name = "software_f3", length = 150)
    private String softwareField3 = "";

    /** The software combo41 value. */
    @Column(name = "software_c41", length = 50)
    private String softwareCombo41 = "";

    /** The software combo42 value. */
    @Column(name = "software_c42", length = 50)
    private String softwareCombo42 = "";

    /** The software checkbox4 value. */
    @Column(name = "software_cb4")
    private Boolean softwareCB4 = false;

    /** The software field4 value. */
    @Column(name = "software_f4", length = 150)
    private String softwareField4 = "";

    /** The software combo51 value. */
    @Column(name = "software_c51", length = 50)
    private String softwareCombo51 = "";

    /** The software combo52 value. */
    @Column(name = "software_c52", length = 50)
    private String softwareCombo52 = "";

    /** The software checkbox5 value. */
    @Column(name = "software_cb5")
    private Boolean softwareCB5 = false;

    /** The software field5 value. */
    @Column(name = "software_f5", length = 150)
    private String softwareField5 = "";

    /** The xfs sw combo11 value. */
    @Column(name = "xfs_sw_c11", length = 50)
    private String xfsSwCombo11 = "";

    /** The xfs sw combo12 value. */
    @Column(name = "xfs_sw_c12", length = 50)
    private String xfsSwCombo12 = "";

    /** The xfs sw checkbox1 value. */
    @Column(name = "xfs_sw_cb1")
    private Boolean xfsSwCB1 = false;

    /** The xfs sw field1 value. */
    @Column(name = "xfs_sw_f1", length = 150)
    private String xfsSwField1 = "";

    /** The xfs sw combo21 value. */
    @Column(name = "xfs_sw_c21", length = 50)
    private String xfsSwCombo21 = "";

    /** The xfs sw combo22 value. */
    @Column(name = "xfs_sw_c22", length = 50)
    private String xfsSwCombo22 = "";

    /** The xfs sw checkbox2 value. */
    @Column(name = "xfs_sw_cb2")
    private Boolean xfsSwCB2 = false;

    /** The xfs sw field2 value. */
    @Column(name = "xfs_sw_f2", length = 150)
    private String xfsSwField2 = "";

    /** The xfs sw combo31 value. */
    @Column(name = "xfs_sw_c31", length = 50)
    private String xfsSwCombo31 = "";

    /** The xfs sw combo32 value. */
    @Column(name = "xfs_sw_c32", length = 50)
    private String xfsSwCombo32 = "";

    /** The xfs sw checkbox3 value. */
    @Column(name = "xfs_sw_cb3")
    private Boolean xfsSwCB3 = false;

    /** The xfs sw field3 value. */
    @Column(name = "xfs_sw_f3", length = 150)
    private String xfsSwField3 = "";

    /** The xfs sw combo41 value. */
    @Column(name = "xfs_sw_c41", length = 50)
    private String xfsSwCombo41 = "";

    /** The xfs sw combo42 value. */
    @Column(name = "xfs_sw_c42", length = 50)
    private String xfsSwCombo42 = "";

    /** The xfs sw checkbox4 value. */
    @Column(name = "xfs_sw_cb4")
    private Boolean xfsSwCB4 = false;

    /** The xfs sw field4 value. */
    @Column(name = "xfs_sw_f4", length = 150)
    private String xfsSwField4 = "";

    /** The xfs sw combo51 value. */
    @Column(name = "xfs_sw_c51", length = 50)
    private String xfsSwCombo51 = "";

    /** The xfs sw combo52 value. */
    @Column(name = "xfs_sw_c52", length = 50)
    private String xfsSwCombo52 = "";

    /** The xfs sw checkbox5 value. */
    @Column(name = "xfs_sw_cb5")
    private Boolean xfsSwCB5 = false;

    /** The xfs sw field5 value. */
    @Column(name = "xfs_sw_f5", length = 150)
    private String xfsSwField5 = "";

    /** The feat sw combo11 value. */
    @Column(name = "feat_sw_c11", length = 50)
    private String featSwCombo11 = "";

    /** The feat sw combo12 value. */
    @Column(name = "feat_sw_c12", length = 50)
    private String featSwCombo12 = "";

    /** The feat sw checkbox1 value. */
    @Column(name = "feat_sw_cb1")
    private Boolean featSwCB1 = false;

    /** The feat sw field1 value. */
    @Column(name = "feat_sw_f1", length = 150)
    private String featSwField1 = "";

    /** The feat sw combo21 value. */
    @Column(name = "feat_sw_c21", length = 50)
    private String featSwCombo21 = "";

    /** The feat sw combo22 value. */
    @Column(name = "feat_sw_c22", length = 50)
    private String featSwCombo22 = "";

    /** The feat sw checkbox2 value. */
    @Column(name = "feat_sw_cb2")
    private Boolean featSwCB2 = false;

    /** The feat sw field2 value. */
    @Column(name = "feat_sw_f2", length = 150)
    private String featSwField2 = "";

    /** The feat sw combo31 value. */
    @Column(name = "feat_sw_c31", length = 50)
    private String featSwCombo31 = "";

    /** The feat sw combo32 value. */
    @Column(name = "feat_sw_c32", length = 50)
    private String featSwCombo32 = "";

    /** The feat sw checkbox3 value. */
    @Column(name = "feat_sw_cb3")
    private Boolean featSwCB3 = false;

    /** The feat sw field3 value. */
    @Column(name = "feat_sw_f3", length = 150)
    private String featSwField3 = "";

    /** The feat sw combo41 value. */
    @Column(name = "feat_sw_c41", length = 50)
    private String featSwCombo41 = "";

    /** The feat sw combo42 value. */
    @Column(name = "feat_sw_c42", length = 50)
    private String featSwCombo42 = "";

    /** The feat sw checkbox4 value. */
    @Column(name = "feat_sw_cb4")
    private Boolean featSwCB4 = false;

    /** The feat sw field4 value. */
    @Column(name = "feat_sw_f4", length = 150)
    private String featSwField4 = "";

    /** The feat sw combo51 value. */
    @Column(name = "feat_sw_c51", length = 50)
    private String featSwCombo51 = "";

    /** The feat sw combo52 value. */
    @Column(name = "feat_sw_c52", length = 50)
    private String featSwCombo52 = "";

    /** The feat sw checkbox5 value. */
    @Column(name = "feat_sw_cb5")
    private Boolean featSwCB5 = false;

    /** The feat sw field5 value. */
    @Column(name = "feat_sw_f5", length = 150)
    private String featSwField5 = "";

    /** The hardware device combo11 value. */
    @Column(name = "hw_device_c11", length = 50)
    private String hardwareDeviceCombo11 = "";

    /** The hardware device combo12 value. */
    @Column(name = "hw_device_c12", length = 50)
    private String hardwareDeviceCombo12 = "";

    /** The hardware device combo13 value. */
    @Column(name = "hw_device_c13", length = 50)
    private String hardwareDeviceCombo13 = "";

    /** The hardware device checkbox1 value. */
    @Column(name = "hw_device_cb1")
    private Boolean hardwareDeviceCB1 = false;

    /** The hardware device field1 value. */
    @Column(name = "hw_device_f1", length = 150)
    private String hardwareDeviceField1 = "";

    /** The hardware device combo21 value. */
    @Column(name = "hw_device_c21", length = 50)
    private String hardwareDeviceCombo21 = "";

    /** The hardware device combo22 value. */
    @Column(name = "hw_device_c22", length = 50)
    private String hardwareDeviceCombo22 = "";

    /** The hardware device combo23 value. */
    @Column(name = "hw_device_c23", length = 50)
    private String hardwareDeviceCombo23 = "";

    /** The hardware device checkbox2 value. */
    @Column(name = "hw_device_cb2")
    private Boolean hardwareDeviceCB2 = false;

    /** The hardware device field2 value. */
    @Column(name = "hw_device_f2", length = 150)
    private String hardwareDeviceField2 = "";

    /** The hardware device combo31 value. */
    @Column(name = "hw_device_c31", length = 50)
    private String hardwareDeviceCombo31 = "";

    /** The hardware device combo32 value. */
    @Column(name = "hw_device_c32", length = 50)
    private String hardwareDeviceCombo32 = "";

    /** The hardware device combo33 value. */
    @Column(name = "hw_device_c33", length = 50)
    private String hardwareDeviceCombo33 = "";

    /** The hardware device checkbox3 value. */
    @Column(name = "hw_device_cb3")
    private Boolean hardwareDeviceCB3 = false;

    /** The hardware device field3 value. */
    @Column(name = "hw_device_f3", length = 150)
    private String hardwareDeviceField3 = "";

    /** The hardware device combo41 value. */
    @Column(name = "hw_device_c41", length = 50)
    private String hardwareDeviceCombo41 = "";

    /** The hardware device combo42 value. */
    @Column(name = "hw_device_c42", length = 50)
    private String hardwareDeviceCombo42 = "";

    /** The hardware device combo43 value. */
    @Column(name = "hw_device_c43", length = 50)
    private String hardwareDeviceCombo43 = "";

    /** The hardware device checkbox4 value. */
    @Column(name = "hw_device_cb4")
    private Boolean hardwareDeviceCB4 = false;

    /** The hardware device field4 value. */
    @Column(name = "hw_device_f4", length = 150)
    private String hardwareDeviceField4 = "";

    /** The hardware device combo51 value. */
    @Column(name = "hw_device_c51", length = 50)
    private String hardwareDeviceCombo51 = "";

    /** The hardware device combo52 value. */
    @Column(name = "hw_device_c52", length = 50)
    private String hardwareDeviceCombo52 = "";

    /** The hardware device combo53 value. */
    @Column(name = "hw_device_c53", length = 50)
    private String hardwareDeviceCombo53 = "";

    /** The hardware device checkbox5 value. */
    @Column(name = "hw_device_cb5")
    private Boolean hardwareDeviceCB5 = false;

    /** The hardware device field5 value. */
    @Column(name = "hw_device_f5", length = 150)
    private String hardwareDeviceField5 = "";

    /** The xfs component combo11 value. */
    @Column(name = "xfs_component_c11", length = 50)
    private String xfsComponentCombo11 = "";

    /** The xfs component combo12 value. */
    @Column(name = "xfs_component_c12", length = 50)
    private String xfsComponentCombo12 = "";

    /** The xfs component checkbox1 value. */
    @Column(name = "xfs_component_cb1")
    private Boolean xfsComponentCB1 = false;

    /** The xfs component field1 value. */
    @Column(name = "xfs_component_f1", length = 150)
    private String xfsComponentField1 = "";

    /** The xfs component combo21 value. */
    @Column(name = "xfs_component_c21", length = 50)
    private String xfsComponentCombo21 = "";

    /** The xfs component combo22 value. */
    @Column(name = "xfs_component_c22", length = 50)
    private String xfsComponentCombo22 = "";

    /** The xfs component checkbox2 value. */
    @Column(name = "xfs_component_cb2")
    private Boolean xfsComponentCB2 = false;

    /** The xfs component field2 value. */
    @Column(name = "xfs_component_f2", length = 150)
    private String xfsComponentField2 = "";

    /** The xfs component combo31 value. */
    @Column(name = "xfs_component_c31", length = 50)
    private String xfsComponentCombo31 = "";

    /** The xfs component combo32 value. */
    @Column(name = "xfs_component_c32", length = 50)
    private String xfsComponentCombo32 = "";

    /** The xfs component checkbox3 value. */
    @Column(name = "xfs_component_cb3")
    private Boolean xfsComponentCB3 = false;

    /** The xfs component field3 value. */
    @Column(name = "xfs_component_f3", length = 150)
    private String xfsComponentField3 = "";

    /** The xfs component combo41 value. */
    @Column(name = "xfs_component_c41", length = 50)
    private String xfsComponentCombo41 = "";

    /** The xfs component combo42 value. */
    @Column(name = "xfs_component_c42", length = 50)
    private String xfsComponentCombo42 = "";

    /** The xfs component checkbox4 value. */
    @Column(name = "xfs_component_cb4")
    private Boolean xfsComponentCB4 = false;

    /** The xfs component field4 value. */
    @Column(name = "xfs_component_f4", length = 150)
    private String xfsComponentField4 = "";

    /** The xfs component combo51 value. */
    @Column(name = "xfs_component_c51", length = 50)
    private String xfsComponentCombo51 = "";

    /** The xfs component combo52 value. */
    @Column(name = "xfs_component_c52", length = 50)
    private String xfsComponentCombo52 = "";

    /** The xfs component checkbox5 value. */
    @Column(name = "xfs_component_cb5")
    private Boolean xfsComponentCB5 = false;

    /** The xfs component field5 value. */
    @Column(name = "xfs_component_f5", length = 150)
    private String xfsComponentField5 = "";

    /** The jxfs component combo11 value. */
    @Column(name = "jxfs_component_c11", length = 50)
    private String jxfsComponentCombo11 = "";

    /** The jxfs component combo12 value. */
    @Column(name = "jxfs_component_c12", length = 50)
    private String jxfsComponentCombo12 = "";

    /** The jxfs component checkbox1 value. */
    @Column(name = "jxfs_component_cb1")
    private Boolean jxfsComponentCB1 = false;

    /** The jxfs component field1 value. */
    @Column(name = "jxfs_component_f1", length = 150)
    private String jxfsComponentField1 = "";

    /** The jxfs component combo21 value. */
    @Column(name = "jxfs_component_c21", length = 50)
    private String jxfsComponentCombo21 = "";

    /** The jxfs component combo22 value. */
    @Column(name = "jxfs_component_c22", length = 50)
    private String jxfsComponentCombo22 = "";

    /** The jxfs component checkbox2 value. */
    @Column(name = "jxfs_component_cb2")
    private Boolean jxfsComponentCB2 = false;

    /** The jxfs component field2 value. */
    @Column(name = "jxfs_component_f2", length = 150)
    private String jxfsComponentField2 = "";

    /** The jxfs component combo31 value. */
    @Column(name = "jxfs_component_c31", length = 50)
    private String jxfsComponentCombo31 = "";

    /** The jxfs component combo32 value. */
    @Column(name = "jxfs_component_c32", length = 50)
    private String jxfsComponentCombo32 = "";

    /** The jxfs component checkbox3 value. */
    @Column(name = "jxfs_component_cb3")
    private Boolean jxfsComponentCB3 = false;

    /** The jxfs component field3 value. */
    @Column(name = "jxfs_component_f3", length = 150)
    private String jxfsComponentField3 = "";

    /** The jxfs component combo41 value. */
    @Column(name = "jxfs_component_c41", length = 50)
    private String jxfsComponentCombo41 = "";

    /** The jxfs component combo42 value. */
    @Column(name = "jxfs_component_c42", length = 50)
    private String jxfsComponentCombo42 = "";

    /** The jxfs component checkbox4 value. */
    @Column(name = "jxfs_component_cb4")
    private Boolean jxfsComponentCB4 = false;

    /** The jxfs component field4 value. */
    @Column(name = "jxfs_component_f4", length = 150)
    private String jxfsComponentField4 = "";

    /** The jxfs component combo51 value. */
    @Column(name = "jxfs_component_c51", length = 50)
    private String jxfsComponentCombo51 = "";

    /** The jxfs component combo52 value. */
    @Column(name = "jxfs_component_c52", length = 50)
    private String jxfsComponentCombo52 = "";

    /** The jxfs component checkbox5 value. */
    @Column(name = "jxfs_component_cb5")
    private Boolean jxfsComponentCB5 = false;

    /** The jxfs component field5 value. */
    @Column(name = "jxfs_component_f5", length = 150)
    private String jxfsComponentField5 = "";

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
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * Sets the name.
     * 
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Gets the user.
     * 
     * @return the user
     */
    public User getUser() {
	return user;
    }

    /**
     * Sets the user.
     * 
     * @param user
     *            the user to set
     */
    public void setUser(User user) {
	this.user = user;
    }

    /**
     * Gets the comboboxes data for the query GUI.
     * 
     * @return the comboboxes data
     */
    public static Map<String, Map> getComboboxes() {
	return comboboxes;
    }

    /**
     * Gets the terminal combo11 value.
     * 
     * @return the terminalCombo11
     */
    public String getTerminalCombo11() {
	return terminalCombo11;
    }

    /**
     * Gets the terminal combo12 value.
     * 
     * @return the terminalCombo12
     */
    public String getTerminalCombo12() {
	return terminalCombo12;
    }

    /**
     * Gets the terminal field1 value.
     * 
     * @return the terminalField1
     */
    public String getTerminalField1() {
	return terminalField1;
    }

    /**
     * Sets the terminal combo11 value.
     * 
     * @param terminalCombo11
     *            the terminalCombo11 to set
     */
    public void setTerminalCombo11(String terminalCombo11) {
	this.terminalCombo11 = terminalCombo11;
    }

    /**
     * Sets the terminal combo12 value.
     * 
     * @param terminalCombo12
     *            the terminalCombo12 to set
     */
    public void setTerminalCombo12(String terminalCombo12) {
	this.terminalCombo12 = terminalCombo12;
    }

    /**
     * Sets the terminal field1 value.
     * 
     * @param terminalField1
     *            the terminalField1 to set
     */
    public void setTerminalField1(String terminalField1) {
	this.terminalField1 = terminalField1;
    }

    /**
     * Gets the terminal combo21 value.
     * 
     * @return the terminalCombo21
     */
    public String getTerminalCombo21() {
	return terminalCombo21;
    }

    /**
     * Gets the terminal combo22 value.
     * 
     * @return the terminalCombo22
     */
    public String getTerminalCombo22() {
	return terminalCombo22;
    }

    /**
     * Gets the terminal field2 value.
     * 
     * @return the terminalField2
     */
    public String getTerminalField2() {
	return terminalField2;
    }

    /**
     * Gets the terminal combo31 value.
     * 
     * @return the terminalCombo31
     */
    public String getTerminalCombo31() {
	return terminalCombo31;
    }

    /**
     * Gets the terminal combo32 value.
     * 
     * @return the terminalCombo32
     */
    public String getTerminalCombo32() {
	return terminalCombo32;
    }

    /**
     * Gets the terminal field3 value.
     * 
     * @return the terminalField3
     */
    public String getTerminalField3() {
	return terminalField3;
    }

    /**
     * Gets the terminal combo41 value.
     * 
     * @return the terminalCombo41
     */
    public String getTerminalCombo41() {
	return terminalCombo41;
    }

    /**
     * Gets the terminal combo42 value.
     * 
     * @return the terminalCombo42
     */
    public String getTerminalCombo42() {
	return terminalCombo42;
    }

    /**
     * Gets the terminal field4 value.
     * 
     * @return the terminalField4
     */
    public String getTerminalField4() {
	return terminalField4;
    }

    /**
     * Gets the terminal combo51 value.
     * 
     * @return the terminalCombo51
     */
    public String getTerminalCombo51() {
	return terminalCombo51;
    }

    /**
     * Gets the terminal combo52 value.
     * 
     * @return the terminalCombo52
     */
    public String getTerminalCombo52() {
	return terminalCombo52;
    }

    /**
     * Gets the terminal field5 value.
     * 
     * @return the terminalField5
     */
    public String getTerminalField5() {
	return terminalField5;
    }

    /**
     * Sets the terminal combo21 value.
     * 
     * @param terminalCombo21
     *            the terminalCombo21 to set
     */
    public void setTerminalCombo21(String terminalCombo21) {
	this.terminalCombo21 = terminalCombo21;
    }

    /**
     * Sets the terminal combo22 value.
     * 
     * @param terminalCombo22
     *            the terminalCombo22 to set
     */
    public void setTerminalCombo22(String terminalCombo22) {
	this.terminalCombo22 = terminalCombo22;
    }

    /**
     * Sets the terminal field2 value.
     * 
     * @param terminalField2
     *            the terminalField2 to set
     */
    public void setTerminalField2(String terminalField2) {
	this.terminalField2 = terminalField2;
    }

    /**
     * Sets the terminal combo31 value.
     * 
     * @param terminalCombo31
     *            the terminalCombo31 to set
     */
    public void setTerminalCombo31(String terminalCombo31) {
	this.terminalCombo31 = terminalCombo31;
    }

    /**
     * Sets the terminal combo32 value.
     * 
     * @param terminalCombo32
     *            the terminalCombo32 to set
     */
    public void setTerminalCombo32(String terminalCombo32) {
	this.terminalCombo32 = terminalCombo32;
    }

    /**
     * Sets the terminal field3 value.
     * 
     * @param terminalField3
     *            the terminalField3 to set
     */
    public void setTerminalField3(String terminalField3) {
	this.terminalField3 = terminalField3;
    }

    /**
     * Sets the terminal combo41 value.
     * 
     * @param terminalCombo41
     *            the terminalCombo41 to set
     */
    public void setTerminalCombo41(String terminalCombo41) {
	this.terminalCombo41 = terminalCombo41;
    }

    /**
     * Sets the terminal combo42 value.
     * 
     * @param terminalCombo42
     *            the terminalCombo42 to set
     */
    public void setTerminalCombo42(String terminalCombo42) {
	this.terminalCombo42 = terminalCombo42;
    }

    /**
     * Sets the terminal field4 value.
     * 
     * @param terminalField4
     *            the terminalField4 to set
     */
    public void setTerminalField4(String terminalField4) {
	this.terminalField4 = terminalField4;
    }

    /**
     * Sets the terminal combo51 value.
     * 
     * @param terminalCombo51
     *            the terminalCombo51 to set
     */
    public void setTerminalCombo51(String terminalCombo51) {
	this.terminalCombo51 = terminalCombo51;
    }

    /**
     * Sets the terminal combo52 value.
     * 
     * @param terminalCombo52
     *            the terminalCombo52 to set
     */
    public void setTerminalCombo52(String terminalCombo52) {
	this.terminalCombo52 = terminalCombo52;
    }

    /**
     * Sets the terminal field5 value.
     * 
     * @param terminalField5
     *            the terminalField5 to set
     */
    public void setTerminalField5(String terminalField5) {
	this.terminalField5 = terminalField5;
    }

    /**
     * Gets the terminal checkbox1 value.
     * 
     * @return the terminalCB1
     */
    public Boolean getTerminalCB1() {
	return terminalCB1;
    }

    /**
     * Gets the terminal checkbox2 value.
     * 
     * @return the terminalCB2
     */
    public Boolean getTerminalCB2() {
	return terminalCB2;
    }

    /**
     * Gets the terminal checkbox3 value.
     * 
     * @return the terminalCB3
     */
    public Boolean getTerminalCB3() {
	return terminalCB3;
    }

    /**
     * Gets the terminal checkbox4 value.
     * 
     * @return the terminalCB4
     */
    public Boolean getTerminalCB4() {
	return terminalCB4;
    }

    /**
     * Gets the terminal checkbox5 value.
     * 
     * @return the terminalCB5
     */
    public Boolean getTerminalCB5() {
	return terminalCB5;
    }

    /**
     * Sets the terminal checkbox1 value.
     * 
     * @param terminalCB1
     *            the terminalCB1 to set
     */
    public void setTerminalCB1(Boolean terminalCB1) {
	this.terminalCB1 = terminalCB1;
    }

    /**
     * Sets the terminal checkbox2 value.
     * 
     * @param terminalCB2
     *            the terminalCB2 to set
     */
    public void setTerminalCB2(Boolean terminalCB2) {
	this.terminalCB2 = terminalCB2;
    }

    /**
     * Sets the terminal checkbox3 value.
     * 
     * @param terminalCB3
     *            the terminalCB3 to set
     */
    public void setTerminalCB3(Boolean terminalCB3) {
	this.terminalCB3 = terminalCB3;
    }

    /**
     * Sets the terminal checkbox4 value.
     * 
     * @param terminalCB4
     *            the terminalCB4 to set
     */
    public void setTerminalCB4(Boolean terminalCB4) {
	this.terminalCB4 = terminalCB4;
    }

    /**
     * Sets the terminal checkbox5 value.
     * 
     * @param terminalCB5
     *            the terminalCB5 to set
     */
    public void setTerminalCB5(Boolean terminalCB5) {
	this.terminalCB5 = terminalCB5;
    }

    /**
     * Gets the terminal HQL constraints.
     * 
     * @param values
     *            where we want it to store the values
     * @param types
     *            where we want it to store the types
     * @param locale
     *            the user's locale
     * @return the terminal HQL constraints
     */
    private String getTerminalConstraints(List<Object> values,
	    List<Type> types, Locale locale) {
	String constraints = "";
	constraints += getConstraint("terminal." + terminalCombo11,
		terminalCombo12, terminalField1, terminalCB1, values, types,
		locale);
	constraints += getConstraint("terminal." + terminalCombo21,
		terminalCombo22, terminalField2, terminalCB2, values, types,
		locale);
	constraints += getConstraint("terminal." + terminalCombo31,
		terminalCombo32, terminalField3, terminalCB3, values, types,
		locale);
	constraints += getConstraint("terminal." + terminalCombo41,
		terminalCombo42, terminalField4, terminalCB4, values, types,
		locale);
	constraints += getConstraint("terminal." + terminalCombo51,
		terminalCombo52, terminalField5, terminalCB5, values, types,
		locale);
	if (constraints.endsWith(" and ")) {
	    constraints = constraints.substring(0, constraints.length() - 5);
	}
	return constraints;
    }

    /**
     * Gets the bank company HQL constraints, which are based on the manageable
     * bank companies of this query's owner.
     * 
     * @return the bank company HQL constraints
     */
    private String getBankCompanyConstraints() {
	String constraints = "";
	if (user != null) {
	    constraints += "(terminal.bankCompany = null";
	    Set<BankCompany> bankCompanies = user.getManageableBankCompanies();
	    for (BankCompany bank : bankCompanies) {
		constraints += " OR ";
		constraints += "terminal.bankCompany.id = " + bank.getId();
	    }
	    constraints += ")";
	}
	return constraints;
    }

    /**
     * Gets the financial device combo11 value.
     * 
     * @return the financialDeviceCombo11
     */
    public String getFinancialDeviceCombo11() {
	return financialDeviceCombo11;
    }

    /**
     * Gets the financial device combo12 value.
     * 
     * @return the financialDeviceCombo12
     */
    public String getFinancialDeviceCombo12() {
	return financialDeviceCombo12;
    }

    /**
     * Gets the financial device checkbox1 value.
     * 
     * @return the financialDeviceCB1
     */
    public Boolean getFinancialDeviceCB1() {
	return financialDeviceCB1;
    }

    /**
     * Gets the financial device field1 value.
     * 
     * @return the financialDeviceField1
     */
    public String getFinancialDeviceField1() {
	return financialDeviceField1;
    }

    /**
     * Gets the financial device combo21 value.
     * 
     * @return the financialDeviceCombo21
     */
    public String getFinancialDeviceCombo21() {
	return financialDeviceCombo21;
    }

    /**
     * Gets the financial device combo22 value.
     * 
     * @return the financialDeviceCombo22
     */
    public String getFinancialDeviceCombo22() {
	return financialDeviceCombo22;
    }

    /**
     * Gets the financial device checkbox2 value.
     * 
     * @return the financialDeviceCB2
     */
    public Boolean getFinancialDeviceCB2() {
	return financialDeviceCB2;
    }

    /**
     * Gets the financial device field2 value.
     * 
     * @return the financialDeviceField2
     */
    public String getFinancialDeviceField2() {
	return financialDeviceField2;
    }

    /**
     * Gets the financial device combo31 value.
     * 
     * @return the financialDeviceCombo31
     */
    public String getFinancialDeviceCombo31() {
	return financialDeviceCombo31;
    }

    /**
     * Gets the financial device combo32 value.
     * 
     * @return the financialDeviceCombo32
     */
    public String getFinancialDeviceCombo32() {
	return financialDeviceCombo32;
    }

    /**
     * Gets the financial device checkbox3 value.
     * 
     * @return the financialDeviceCB3
     */
    public Boolean getFinancialDeviceCB3() {
	return financialDeviceCB3;
    }

    /**
     * Gets the financial device field3 value.
     * 
     * @return the financialDeviceField3
     */
    public String getFinancialDeviceField3() {
	return financialDeviceField3;
    }

    /**
     * Gets the financial device combo41 value.
     * 
     * @return the financialDeviceCombo41
     */
    public String getFinancialDeviceCombo41() {
	return financialDeviceCombo41;
    }

    /**
     * Gets the financial device combo42 value.
     * 
     * @return the financialDeviceCombo42
     */
    public String getFinancialDeviceCombo42() {
	return financialDeviceCombo42;
    }

    /**
     * Gets the financial device checkbox4 value.
     * 
     * @return the financialDeviceCB4
     */
    public Boolean getFinancialDeviceCB4() {
	return financialDeviceCB4;
    }

    /**
     * Gets the financial device field4 value.
     * 
     * @return the financialDeviceField4
     */
    public String getFinancialDeviceField4() {
	return financialDeviceField4;
    }

    /**
     * Gets the financial device combo51 value.
     * 
     * @return the financialDeviceCombo51
     */
    public String getFinancialDeviceCombo51() {
	return financialDeviceCombo51;
    }

    /**
     * Gets the financial device combo52 value.
     * 
     * @return the financialDeviceCombo52
     */
    public String getFinancialDeviceCombo52() {
	return financialDeviceCombo52;
    }

    /**
     * Gets the financial device checkbox5 value.
     * 
     * @return the financialDeviceCB5
     */
    public Boolean getFinancialDeviceCB5() {
	return financialDeviceCB5;
    }

    /**
     * Gets the financial device field5 value.
     * 
     * @return the financialDeviceField5
     */
    public String getFinancialDeviceField5() {
	return financialDeviceField5;
    }

    /**
     * Sets the financial device combo11 value.
     * 
     * @param financialDeviceCombo11
     *            the financialDeviceCombo11 to set
     */
    public void setFinancialDeviceCombo11(String financialDeviceCombo11) {
	this.financialDeviceCombo11 = financialDeviceCombo11;
    }

    /**
     * Sets the financial device combo12 value.
     * 
     * @param financialDeviceCombo12
     *            the financialDeviceCombo12 to set
     */
    public void setFinancialDeviceCombo12(String financialDeviceCombo12) {
	this.financialDeviceCombo12 = financialDeviceCombo12;
    }

    /**
     * Sets the financial device checkbox1 value.
     * 
     * @param financialDeviceCB1
     *            the financialDeviceCB1 to set
     */
    public void setFinancialDeviceCB1(Boolean financialDeviceCB1) {
	this.financialDeviceCB1 = financialDeviceCB1;
    }

    /**
     * Sets the financial device field1 value.
     * 
     * @param financialDeviceField1
     *            the financialDeviceField1 to set
     */
    public void setFinancialDeviceField1(String financialDeviceField1) {
	this.financialDeviceField1 = financialDeviceField1;
    }

    /**
     * Sets the financial device combo21 value.
     * 
     * @param financialDeviceCombo21
     *            the financialDeviceCombo21 to set
     */
    public void setFinancialDeviceCombo21(String financialDeviceCombo21) {
	this.financialDeviceCombo21 = financialDeviceCombo21;
    }

    /**
     * Sets the financial device combo22 value.
     * 
     * @param financialDeviceCombo22
     *            the financialDeviceCombo22 to set
     */
    public void setFinancialDeviceCombo22(String financialDeviceCombo22) {
	this.financialDeviceCombo22 = financialDeviceCombo22;
    }

    /**
     * Sets the financial device checkbox2 value.
     * 
     * @param financialDeviceCB2
     *            the financialDeviceCB2 to set
     */
    public void setFinancialDeviceCB2(Boolean financialDeviceCB2) {
	this.financialDeviceCB2 = financialDeviceCB2;
    }

    /**
     * Sets the financial device field2 value.
     * 
     * @param financialDeviceField2
     *            the financialDeviceField2 to set
     */
    public void setFinancialDeviceField2(String financialDeviceField2) {
	this.financialDeviceField2 = financialDeviceField2;
    }

    /**
     * Sets the financial device combo31 value.
     * 
     * @param financialDeviceCombo31
     *            the financialDeviceCombo31 to set
     */
    public void setFinancialDeviceCombo31(String financialDeviceCombo31) {
	this.financialDeviceCombo31 = financialDeviceCombo31;
    }

    /**
     * Sets the financial device combo32 value.
     * 
     * @param financialDeviceCombo32
     *            the financialDeviceCombo32 to set
     */
    public void setFinancialDeviceCombo32(String financialDeviceCombo32) {
	this.financialDeviceCombo32 = financialDeviceCombo32;
    }

    /**
     * Sets the financial device checkbox3 value.
     * 
     * @param financialDeviceCB3
     *            the financialDeviceCB3 to set
     */
    public void setFinancialDeviceCB3(Boolean financialDeviceCB3) {
	this.financialDeviceCB3 = financialDeviceCB3;
    }

    /**
     * Sets the financial device field3 value.
     * 
     * @param financialDeviceField3
     *            the financialDeviceField3 to set
     */
    public void setFinancialDeviceField3(String financialDeviceField3) {
	this.financialDeviceField3 = financialDeviceField3;
    }

    /**
     * Sets the financial device combo41 value.
     * 
     * @param financialDeviceCombo41
     *            the financialDeviceCombo41 to set
     */
    public void setFinancialDeviceCombo41(String financialDeviceCombo41) {
	this.financialDeviceCombo41 = financialDeviceCombo41;
    }

    /**
     * Sets the financial device combo42 value.
     * 
     * @param financialDeviceCombo42
     *            the financialDeviceCombo42 to set
     */
    public void setFinancialDeviceCombo42(String financialDeviceCombo42) {
	this.financialDeviceCombo42 = financialDeviceCombo42;
    }

    /**
     * Sets the financial device checkbox4 value.
     * 
     * @param financialDeviceCB4
     *            the financialDeviceCB4 to set
     */
    public void setFinancialDeviceCB4(Boolean financialDeviceCB4) {
	this.financialDeviceCB4 = financialDeviceCB4;
    }

    /**
     * Sets the financial device field4 value.
     * 
     * @param financialDeviceField4
     *            the financialDeviceField4 to set
     */
    public void setFinancialDeviceField4(String financialDeviceField4) {
	this.financialDeviceField4 = financialDeviceField4;
    }

    /**
     * Sets the financial device combo51 value.
     * 
     * @param financialDeviceCombo51
     *            the financialDeviceCombo51 to set
     */
    public void setFinancialDeviceCombo51(String financialDeviceCombo51) {
	this.financialDeviceCombo51 = financialDeviceCombo51;
    }

    /**
     * Sets the financial device combo52 value.
     * 
     * @param financialDeviceCombo52
     *            the financialDeviceCombo52 to set
     */
    public void setFinancialDeviceCombo52(String financialDeviceCombo52) {
	this.financialDeviceCombo52 = financialDeviceCombo52;
    }

    /**
     * Sets the financial device checkbox5 value.
     * 
     * @param financialDeviceCB5
     *            the financialDeviceCB5 to set
     */
    public void setFinancialDeviceCB5(Boolean financialDeviceCB5) {
	this.financialDeviceCB5 = financialDeviceCB5;
    }

    /**
     * Sets the financial device field5 value.
     * 
     * @param financialDeviceField5
     *            the financialDeviceField5 to set
     */
    public void setFinancialDeviceField5(String financialDeviceField5) {
	this.financialDeviceField5 = financialDeviceField5;
    }

    /**
     * Gets the financial device HQL constraints.
     * 
     * @param values
     *            where we want it to store the values
     * @param types
     *            where we want it to store the types
     * @param locale
     *            the user's locale
     * @return the financial device HQL constraints
     */
    private String getFinancialDeviceConstraints(List<Object> values,
	    List<Type> types, Locale locale, Date queryDate) {
	String constraints = "";
	constraints += getConstraint("financialDevice."
		+ financialDeviceCombo11, financialDeviceCombo12,
		financialDeviceField1, financialDeviceCB1, values, types,
		locale);
	constraints += getConstraint("financialDevice."
		+ financialDeviceCombo21, financialDeviceCombo22,
		financialDeviceField2, financialDeviceCB2, values, types,
		locale);
	constraints += getConstraint("financialDevice."
		+ financialDeviceCombo31, financialDeviceCombo32,
		financialDeviceField3, financialDeviceCB3, values, types,
		locale);
	constraints += getConstraint("financialDevice."
		+ financialDeviceCombo41, financialDeviceCombo42,
		financialDeviceField4, financialDeviceCB4, values, types,
		locale);
	constraints += getConstraint("financialDevice."
		+ financialDeviceCombo51, financialDeviceCombo52,
		financialDeviceField5, financialDeviceCB5, values, types,
		locale);

	constraints += storeIsElementActiveByDate("financialDevice.", values,
		types, locale, constraints, queryDate);

	if (constraints.endsWith(" and ")) {
	    constraints = constraints.substring(0, constraints.length() - 5);
	}
	return constraints;
    }

    /**
     * Gets the xfs component HQL constraints.
     * 
     * @param values
     *            where we want it to store the values
     * @param types
     *            where we want it to store the types
     * @param locale
     *            the user's locale
     * @return the xfs component HQL constraints
     */
    private String getXfsComponentConstraints(List<Object> values,
	    List<Type> types, Locale locale, Date queryDate) {
	String constraints = "";
	constraints += getConstraint("xfsComponent." + xfsComponentCombo11,
		xfsComponentCombo12, xfsComponentField1, xfsComponentCB1,
		values, types, locale);
	constraints += getConstraint("xfsComponent." + xfsComponentCombo21,
		xfsComponentCombo22, xfsComponentField2, xfsComponentCB2,
		values, types, locale);
	constraints += getConstraint("xfsComponent." + xfsComponentCombo31,
		xfsComponentCombo32, xfsComponentField3, xfsComponentCB3,
		values, types, locale);
	constraints += getConstraint("xfsComponent." + xfsComponentCombo41,
		xfsComponentCombo42, xfsComponentField4, xfsComponentCB4,
		values, types, locale);
	constraints += getConstraint("xfsComponent." + xfsComponentCombo51,
		xfsComponentCombo52, xfsComponentField5, xfsComponentCB5,
		values, types, locale);

	constraints += storeIsElementActiveByDate("financialDevice.", values,
		types, locale, constraints, queryDate);

	if (constraints.endsWith(" and ")) {
	    constraints = constraints.substring(0, constraints.length() - 5);
	}
	return constraints;
    }

    /**
     * Gets the jxfs component HQL constraints.
     * 
     * @param values
     *            where we want it to store the values
     * @param types
     *            where we want it to store the types
     * @param locale
     *            the user's locale
     * @return the jxfs component HQL constraints
     */
    private String getJxfsComponentConstraints(List<Object> values,
	    List<Type> types, Locale locale, Date queryDate) {
	String constraints = "";
	constraints += getConstraint("jxfsComponent." + jxfsComponentCombo11,
		jxfsComponentCombo12, jxfsComponentField1, jxfsComponentCB1,
		values, types, locale);
	constraints += getConstraint("jxfsComponent." + jxfsComponentCombo21,
		jxfsComponentCombo22, jxfsComponentField2, jxfsComponentCB2,
		values, types, locale);
	constraints += getConstraint("jxfsComponent." + jxfsComponentCombo31,
		jxfsComponentCombo32, jxfsComponentField3, jxfsComponentCB3,
		values, types, locale);
	constraints += getConstraint("jxfsComponent." + jxfsComponentCombo41,
		jxfsComponentCombo42, jxfsComponentField4, jxfsComponentCB4,
		values, types, locale);
	constraints += getConstraint("jxfsComponent." + jxfsComponentCombo51,
		jxfsComponentCombo52, jxfsComponentField5, jxfsComponentCB5,
		values, types, locale);

	constraints += storeIsElementActiveByDate("financialDevice.", values,
		types, locale, constraints, queryDate);

	if (constraints.endsWith(" and ")) {
	    constraints = constraints.substring(0, constraints.length() - 5);
	}
	return constraints;
    }

    /**
     * Gets the hotfix combo11 value.
     * 
     * @return the hotfixCombo11
     */
    public String getHotfixCombo11() {
	return hotfixCombo11;
    }

    /**
     * Sets the hotfix combo11 value.
     * 
     * @param hotfixCombo11
     *            the hotfixCombo11 to set
     */
    public void setHotfixCombo11(String hotfixCombo11) {
	this.hotfixCombo11 = hotfixCombo11;
    }

    /**
     * Gets the hotfix combo12 value.
     * 
     * @return the hotfixCombo12
     */
    public String getHotfixCombo12() {
	return hotfixCombo12;
    }

    /**
     * Sets the hotfix combo12 value.
     * 
     * @param hotfixCombo12
     *            the hotfixCombo12 to set
     */
    public void setHotfixCombo12(String hotfixCombo12) {
	this.hotfixCombo12 = hotfixCombo12;
    }

    /**
     * Gets the hotfix checkbox1 value.
     * 
     * @return the hotfixCB1
     */
    public Boolean getHotfixCB1() {
	return hotfixCB1;
    }

    /**
     * Sets the hotfix checkbox1 value.
     * 
     * @param hotfixCB1
     *            the hotfixCB1 to set
     */
    public void setHotfixCB1(Boolean hotfixCB1) {
	this.hotfixCB1 = hotfixCB1;
    }

    /**
     * Gets the hotfix field1 value.
     * 
     * @return the hotfixField1
     */
    public String getHotfixField1() {
	return hotfixField1;
    }

    /**
     * Sets the hotfix field1 value.
     * 
     * @param hotfixField1
     *            the hotfixField1 to set
     */
    public void setHotfixField1(String hotfixField1) {
	this.hotfixField1 = hotfixField1;
    }

    /**
     * Gets the hotfix combo21 value.
     * 
     * @return the hotfixCombo21
     */
    public String getHotfixCombo21() {
	return hotfixCombo21;
    }

    /**
     * Sets the hotfix combo21 value.
     * 
     * @param hotfixCombo21
     *            the hotfixCombo21 to set
     */
    public void setHotfixCombo21(String hotfixCombo21) {
	this.hotfixCombo21 = hotfixCombo21;
    }

    /**
     * Gets the hotfix combo22 value.
     * 
     * @return the hotfixCombo22
     */
    public String getHotfixCombo22() {
	return hotfixCombo22;
    }

    /**
     * Sets the hotfix combo22 value.
     * 
     * @param hotfixCombo22
     *            the hotfixCombo22 to set
     */
    public void setHotfixCombo22(String hotfixCombo22) {
	this.hotfixCombo22 = hotfixCombo22;
    }

    /**
     * Gets the hotfix checkbox2 value.
     * 
     * @return the hotfixCB2
     */
    public Boolean getHotfixCB2() {
	return hotfixCB2;
    }

    /**
     * Sets the hotfix checkbox2 value.
     * 
     * @param hotfixCB2
     *            the hotfixCB2 to set
     */
    public void setHotfixCB2(Boolean hotfixCB2) {
	this.hotfixCB2 = hotfixCB2;
    }

    /**
     * Gets the hotfix field2 value.
     * 
     * @return the hotfixField2
     */
    public String getHotfixField2() {
	return hotfixField2;
    }

    /**
     * Sets the hotfix field2 value.
     * 
     * @param hotfixField2
     *            the hotfixField2 to set
     */
    public void setHotfixField2(String hotfixField2) {
	this.hotfixField2 = hotfixField2;
    }

    /**
     * Gets the hotfix combo31 value.
     * 
     * @return the hotfixCombo31
     */
    public String getHotfixCombo31() {
	return hotfixCombo31;
    }

    /**
     * Sets the hotfix combo31 value.
     * 
     * @param hotfixCombo31
     *            the hotfixCombo31 to set
     */
    public void setHotfixCombo31(String hotfixCombo31) {
	this.hotfixCombo31 = hotfixCombo31;
    }

    /**
     * Gets the hotfix combo32 value.
     * 
     * @return the hotfixCombo32
     */
    public String getHotfixCombo32() {
	return hotfixCombo32;
    }

    /**
     * Sets the hotfix combo32 value.
     * 
     * @param hotfixCombo32
     *            the hotfixCombo32 to set
     */
    public void setHotfixCombo32(String hotfixCombo32) {
	this.hotfixCombo32 = hotfixCombo32;
    }

    /**
     * Gets the hotfix checkbox3 value.
     * 
     * @return the hotfixCB3
     */
    public Boolean getHotfixCB3() {
	return hotfixCB3;
    }

    /**
     * Sets the hotfix checkbox3 value.
     * 
     * @param hotfixCB3
     *            the hotfixCB3 to set
     */
    public void setHotfixCB3(Boolean hotfixCB3) {
	this.hotfixCB3 = hotfixCB3;
    }

    /**
     * Gets the hotfix field3 value.
     * 
     * @return the hotfixField3
     */
    public String getHotfixField3() {
	return hotfixField3;
    }

    /**
     * Sets the hotfix field3 value.
     * 
     * @param hotfixField3
     *            the hotfixField3 to set
     */
    public void setHotfixField3(String hotfixField3) {
	this.hotfixField3 = hotfixField3;
    }

    /**
     * Gets the hotfix combo41 value.
     * 
     * @return the hotfixCombo41
     */
    public String getHotfixCombo41() {
	return hotfixCombo41;
    }

    /**
     * Sets the hotfix combo41 value.
     * 
     * @param hotfixCombo41
     *            the hotfixCombo41 to set
     */
    public void setHotfixCombo41(String hotfixCombo41) {
	this.hotfixCombo41 = hotfixCombo41;
    }

    /**
     * Gets the hotfix combo42 value.
     * 
     * @return the hotfixCombo42
     */
    public String getHotfixCombo42() {
	return hotfixCombo42;
    }

    /**
     * Sets the hotfix combo42 value.
     * 
     * @param hotfixCombo42
     *            the hotfixCombo42 to set
     */
    public void setHotfixCombo42(String hotfixCombo42) {
	this.hotfixCombo42 = hotfixCombo42;
    }

    /**
     * Gets the hotfix checkbox4 value.
     * 
     * @return the hotfixCB4
     */
    public Boolean getHotfixCB4() {
	return hotfixCB4;
    }

    /**
     * Sets the hotfix checkbox4 value.
     * 
     * @param hotfixCB4
     *            the hotfixCB4 to set
     */
    public void setHotfixCB4(Boolean hotfixCB4) {
	this.hotfixCB4 = hotfixCB4;
    }

    /**
     * Gets the hotfix field4 value.
     * 
     * @return the hotfixField4
     */
    public String getHotfixField4() {
	return hotfixField4;
    }

    /**
     * Sets the hotfix field4 value.
     * 
     * @param hotfixField4
     *            the hotfixField4 to set
     */
    public void setHotfixField4(String hotfixField4) {
	this.hotfixField4 = hotfixField4;
    }

    /**
     * Gets the hotfix combo51 value.
     * 
     * @return the hotfixCombo51
     */
    public String getHotfixCombo51() {
	return hotfixCombo51;
    }

    /**
     * Sets the hotfix combo51 value.
     * 
     * @param hotfixCombo51
     *            the hotfixCombo51 to set
     */
    public void setHotfixCombo51(String hotfixCombo51) {
	this.hotfixCombo51 = hotfixCombo51;
    }

    /**
     * Gets the hotfix combo52 value.
     * 
     * @return the hotfixCombo52
     */
    public String getHotfixCombo52() {
	return hotfixCombo52;
    }

    /**
     * Sets the hotfix combo52 value.
     * 
     * @param hotfixCombo52
     *            the hotfixCombo52 to set
     */
    public void setHotfixCombo52(String hotfixCombo52) {
	this.hotfixCombo52 = hotfixCombo52;
    }

    /**
     * Gets the hotfix checkbox5 value.
     * 
     * @return the hotfixCB5
     */
    public Boolean getHotfixCB5() {
	return hotfixCB5;
    }

    /**
     * Sets the hotfix checkbox5 value.
     * 
     * @param hotfixCB5
     *            the hotfixCB5 to set
     */
    public void setHotfixCB5(Boolean hotfixCB5) {
	this.hotfixCB5 = hotfixCB5;
    }

    /**
     * Gets the hotfix field5 value.
     * 
     * @return the hotfixField5
     */
    public String getHotfixField5() {
	return hotfixField5;
    }

    /**
     * Sets the hotfix field5 value.
     * 
     * @param hotfixField5
     *            the hotfixField5 to set
     */
    public void setHotfixField5(String hotfixField5) {
	this.hotfixField5 = hotfixField5;
    }

    /**
     * Gets the hotfix HQL constraints.
     * 
     * @param values
     *            where we want it to store the values
     * @param types
     *            where we want it to store the types
     * @param locale
     *            the user's locale
     * @return the hotfix HQL constraints
     */
    private String getHotfixConstraints(List<Object> values, List<Type> types,
	    Locale locale, Date queryDate) {
	String constraints = "";
	constraints += getConstraint("hotfix." + hotfixCombo11, hotfixCombo12,
		hotfixField1, hotfixCB1, values, types, locale);
	constraints += getConstraint("hotfix." + hotfixCombo21, hotfixCombo22,
		hotfixField2, hotfixCB2, values, types, locale);
	constraints += getConstraint("hotfix." + hotfixCombo31, hotfixCombo32,
		hotfixField3, hotfixCB3, values, types, locale);
	constraints += getConstraint("hotfix." + hotfixCombo41, hotfixCombo42,
		hotfixField4, hotfixCB4, values, types, locale);
	constraints += getConstraint("hotfix." + hotfixCombo51, hotfixCombo52,
		hotfixField5, hotfixCB5, values, types, locale);
	constraints += storeIsElementActiveByDate("hotfix.", values, types,
		locale, constraints, queryDate);

	if (constraints.endsWith(" and ")) {
	    constraints = constraints.substring(0, constraints.length() - 5);
	}
	return constraints;
    }

    /**
     * Gets the internet explorer combo11 value.
     * 
     * @return the internetExplorerCombo11
     */
    public String getInternetExplorerCombo11() {
	return internetExplorerCombo11;
    }

    /**
     * Sets the internet explorer combo11 value.
     * 
     * @param internetExplorerCombo11
     *            the internetExplorerCombo11 to set
     */
    public void setInternetExplorerCombo11(String internetExplorerCombo11) {
	this.internetExplorerCombo11 = internetExplorerCombo11;
    }

    /**
     * Gets the internet explorer combo12 value.
     * 
     * @return the internetExplorerCombo12
     */
    public String getInternetExplorerCombo12() {
	return internetExplorerCombo12;
    }

    /**
     * Sets the internet explorer combo12 value.
     * 
     * @param internetExplorerCombo12
     *            the internetExplorerCombo12 to set
     */
    public void setInternetExplorerCombo12(String internetExplorerCombo12) {
	this.internetExplorerCombo12 = internetExplorerCombo12;
    }

    /**
     * Gets the internet explorer checkbox1 value.
     * 
     * @return the internetExplorerCB1
     */
    public Boolean getInternetExplorerCB1() {
	return internetExplorerCB1;
    }

    /**
     * Sets the internet explorer checkbox1 value.
     * 
     * @param internetExplorerCB1
     *            the internetExplorerCB1 to set
     */
    public void setInternetExplorerCB1(Boolean internetExplorerCB1) {
	this.internetExplorerCB1 = internetExplorerCB1;
    }

    /**
     * Gets the internet explorer field1 value.
     * 
     * @return the internetExplorerField1
     */
    public String getInternetExplorerField1() {
	return internetExplorerField1;
    }

    /**
     * Sets the internet explorer field1 value.
     * 
     * @param internetExplorerField1
     *            the internetExplorerField1 to set
     */
    public void setInternetExplorerField1(String internetExplorerField1) {
	this.internetExplorerField1 = internetExplorerField1;
    }

    /**
     * Gets the internet explorer combo21 value.
     * 
     * @return the internetExplorerCombo21
     */
    public String getInternetExplorerCombo21() {
	return internetExplorerCombo21;
    }

    /**
     * Sets the internet explorer combo21 value.
     * 
     * @param internetExplorerCombo21
     *            the internetExplorerCombo21 to set
     */
    public void setInternetExplorerCombo21(String internetExplorerCombo21) {
	this.internetExplorerCombo21 = internetExplorerCombo21;
    }

    /**
     * Gets the internet explorer combo22 value.
     * 
     * @return the internetExplorerCombo22
     */
    public String getInternetExplorerCombo22() {
	return internetExplorerCombo22;
    }

    /**
     * Sets the internet explorer combo22 value.
     * 
     * @param internetExplorerCombo22
     *            the internetExplorerCombo22 to set
     */
    public void setInternetExplorerCombo22(String internetExplorerCombo22) {
	this.internetExplorerCombo22 = internetExplorerCombo22;
    }

    /**
     * Gets the internet explorer checkbox2 value.
     * 
     * @return the internetExplorerCB2
     */
    public Boolean getInternetExplorerCB2() {
	return internetExplorerCB2;
    }

    /**
     * Sets the internet explorer checkbox2 value.
     * 
     * @param internetExplorerCB2
     *            the internetExplorerCB2 to set
     */
    public void setInternetExplorerCB2(Boolean internetExplorerCB2) {
	this.internetExplorerCB2 = internetExplorerCB2;
    }

    /**
     * Gets the internet explorer field2 value.
     * 
     * @return the internetExplorerField2
     */
    public String getInternetExplorerField2() {
	return internetExplorerField2;
    }

    /**
     * Sets the internet explorer field2 value.
     * 
     * @param internetExplorerField2
     *            the internetExplorerField2 to set
     */
    public void setInternetExplorerField2(String internetExplorerField2) {
	this.internetExplorerField2 = internetExplorerField2;
    }

    /**
     * Gets the internet explorer HQL constraints.
     * 
     * @param values
     *            where we want it to store the values
     * @param types
     *            where we want it to store the types
     * @param locale
     *            the user's locale
     * @return the internet explorer HQL constraints
     */
    private String getInternetExplorerConstraints(List<Object> values,
	    List<Type> types, Locale locale, Date queryDate) {
	String constraints = "";
	constraints += getConstraint("internetExplorer."
		+ internetExplorerCombo11, internetExplorerCombo12,
		internetExplorerField1, internetExplorerCB1, values, types,
		locale);
	constraints += getConstraint("internetExplorer."
		+ internetExplorerCombo21, internetExplorerCombo22,
		internetExplorerField2, internetExplorerCB2, values, types,
		locale);

	constraints += storeIsElementActiveByDate("auditableInternetExplorer.",
		values, types, locale, constraints, queryDate);

	if (constraints.endsWith(" and ")) {
	    constraints = constraints.substring(0, constraints.length() - 5);
	}
	return constraints;
    }

    /**
     * Gets the operating system combo11 value.
     * 
     * @return the operatingSystemCombo11
     */
    public String getOperatingSystemCombo11() {
	return operatingSystemCombo11;
    }

    /**
     * Sets the operating system combo11 value.
     * 
     * @param operatingSystemCombo11
     *            the operatingSystemCombo11 to set
     */
    public void setOperatingSystemCombo11(String operatingSystemCombo11) {
	this.operatingSystemCombo11 = operatingSystemCombo11;
    }

    /**
     * Gets the operating system combo12 value.
     * 
     * @return the operatingSystemCombo12
     */
    public String getOperatingSystemCombo12() {
	return operatingSystemCombo12;
    }

    /**
     * Sets the operating system combo12 value.
     * 
     * @param operatingSystemCombo12
     *            the operatingSystemCombo12 to set
     */
    public void setOperatingSystemCombo12(String operatingSystemCombo12) {
	this.operatingSystemCombo12 = operatingSystemCombo12;
    }

    /**
     * Gets the operating system checkbox1 value.
     * 
     * @return the operatingSystemCB1
     */
    public Boolean getOperatingSystemCB1() {
	return operatingSystemCB1;
    }

    /**
     * Sets the operating system checkbox1 value.
     * 
     * @param operatingSystemCB1
     *            the operatingSystemCB1 to set
     */
    public void setOperatingSystemCB1(Boolean operatingSystemCB1) {
	this.operatingSystemCB1 = operatingSystemCB1;
    }

    /**
     * Gets the operating system field1 value.
     * 
     * @return the operatingSystemField1
     */
    public String getOperatingSystemField1() {
	return operatingSystemField1;
    }

    /**
     * Sets the operating system field1 value.
     * 
     * @param operatingSystemField1
     *            the operatingSystemField1 to set
     */
    public void setOperatingSystemField1(String operatingSystemField1) {
	this.operatingSystemField1 = operatingSystemField1;
    }

    /**
     * Gets the operating system combo21 value.
     * 
     * @return the operatingSystemCombo21
     */
    public String getOperatingSystemCombo21() {
	return operatingSystemCombo21;
    }

    /**
     * Sets the operating system combo21 value.
     * 
     * @param operatingSystemCombo21
     *            the operatingSystemCombo21 to set
     */
    public void setOperatingSystemCombo21(String operatingSystemCombo21) {
	this.operatingSystemCombo21 = operatingSystemCombo21;
    }

    /**
     * Gets the operating system combo22 value.
     * 
     * @return the operatingSystemCombo22
     */
    public String getOperatingSystemCombo22() {
	return operatingSystemCombo22;
    }

    /**
     * Sets the operating system combo22 value.
     * 
     * @param operatingSystemCombo22
     *            the operatingSystemCombo22 to set
     */
    public void setOperatingSystemCombo22(String operatingSystemCombo22) {
	this.operatingSystemCombo22 = operatingSystemCombo22;
    }

    /**
     * Gets the operating system checkbox2 value.
     * 
     * @return the operatingSystemCB2
     */
    public Boolean getOperatingSystemCB2() {
	return operatingSystemCB2;
    }

    /**
     * Sets the operating system checkbox2 value.
     * 
     * @param operatingSystemCB2
     *            the operatingSystemCB2 to set
     */
    public void setOperatingSystemCB2(Boolean operatingSystemCB2) {
	this.operatingSystemCB2 = operatingSystemCB2;
    }

    /**
     * Gets the operating system field2 value.
     * 
     * @return the operatingSystemField2
     */
    public String getOperatingSystemField2() {
	return operatingSystemField2;
    }

    /**
     * Sets the operating system field2 value.
     * 
     * @param operatingSystemField2
     *            the operatingSystemField2 to set
     */
    public void setOperatingSystemField2(String operatingSystemField2) {
	this.operatingSystemField2 = operatingSystemField2;
    }

    /**
     * Gets the operating system combo31 value.
     * 
     * @return the operatingSystemCombo31
     */
    public String getOperatingSystemCombo31() {
	return operatingSystemCombo31;
    }

    /**
     * Sets the operating system combo31 value.
     * 
     * @param operatingSystemCombo31
     *            the operatingSystemCombo31 to set
     */
    public void setOperatingSystemCombo31(String operatingSystemCombo31) {
	this.operatingSystemCombo31 = operatingSystemCombo31;
    }

    /**
     * Gets the operating system combo32 value.
     * 
     * @return the operatingSystemCombo32
     */
    public String getOperatingSystemCombo32() {
	return operatingSystemCombo32;
    }

    /**
     * Sets the operating system combo32 value.
     * 
     * @param operatingSystemCombo32
     *            the operatingSystemCombo32 to set
     */
    public void setOperatingSystemCombo32(String operatingSystemCombo32) {
	this.operatingSystemCombo32 = operatingSystemCombo32;
    }

    /**
     * Gets the operating system checkbox3 value.
     * 
     * @return the operatingSystemCB3
     */
    public Boolean getOperatingSystemCB3() {
	return operatingSystemCB3;
    }

    /**
     * Sets the operating system checkbox3 value.
     * 
     * @param operatingSystemCB3
     *            the operatingSystemCB3 to set
     */
    public void setOperatingSystemCB3(Boolean operatingSystemCB3) {
	this.operatingSystemCB3 = operatingSystemCB3;
    }

    /**
     * Gets the operating system field3 value.
     * 
     * @return the operatingSystemField3
     */
    public String getOperatingSystemField3() {
	return operatingSystemField3;
    }

    /**
     * Sets the operating system field3 value.
     * 
     * @param operatingSystemField3
     *            the operatingSystemField3 to set
     */
    public void setOperatingSystemField3(String operatingSystemField3) {
	this.operatingSystemField3 = operatingSystemField3;
    }

    /**
     * Gets the operating system combo41 value.
     * 
     * @return the operatingSystemCombo41
     */
    public String getOperatingSystemCombo41() {
	return operatingSystemCombo41;
    }

    /**
     * Sets the operating system combo41 value.
     * 
     * @param operatingSystemCombo41
     *            the operatingSystemCombo41 to set
     */
    public void setOperatingSystemCombo41(String operatingSystemCombo41) {
	this.operatingSystemCombo41 = operatingSystemCombo41;
    }

    /**
     * Gets the operating system combo42 value.
     * 
     * @return the operatingSystemCombo42
     */
    public String getOperatingSystemCombo42() {
	return operatingSystemCombo42;
    }

    /**
     * Sets the operating system combo42 value.
     * 
     * @param operatingSystemCombo42
     *            the operatingSystemCombo42 to set
     */
    public void setOperatingSystemCombo42(String operatingSystemCombo42) {
	this.operatingSystemCombo42 = operatingSystemCombo42;
    }

    /**
     * Gets the operating system checkbox4 value.
     * 
     * @return the operatingSystemCB4
     */
    public Boolean getOperatingSystemCB4() {
	return operatingSystemCB4;
    }

    /**
     * Sets the operating system checkbox4 value.
     * 
     * @param operatingSystemCB4
     *            the operatingSystemCB4 to set
     */
    public void setOperatingSystemCB4(Boolean operatingSystemCB4) {
	this.operatingSystemCB4 = operatingSystemCB4;
    }

    /**
     * Gets the operating system field4 value.
     * 
     * @return the operatingSystemField4
     */
    public String getOperatingSystemField4() {
	return operatingSystemField4;
    }

    /**
     * Sets the operating system field4 value.
     * 
     * @param operatingSystemField4
     *            the operatingSystemField4 to set
     */
    public void setOperatingSystemField4(String operatingSystemField4) {
	this.operatingSystemField4 = operatingSystemField4;
    }

    /**
     * Gets the operating system combo51 value.
     * 
     * @return the operatingSystemCombo51
     */
    public String getOperatingSystemCombo51() {
	return operatingSystemCombo51;
    }

    /**
     * Sets the operating system combo51 value.
     * 
     * @param operatingSystemCombo51
     *            the operatingSystemCombo51 to set
     */
    public void setOperatingSystemCombo51(String operatingSystemCombo51) {
	this.operatingSystemCombo51 = operatingSystemCombo51;
    }

    /**
     * Gets the operating system combo52 value.
     * 
     * @return the operatingSystemCombo52
     */
    public String getOperatingSystemCombo52() {
	return operatingSystemCombo52;
    }

    /**
     * Sets the operating system combo52 value.
     * 
     * @param operatingSystemCombo52
     *            the operatingSystemCombo52 to set
     */
    public void setOperatingSystemCombo52(String operatingSystemCombo52) {
	this.operatingSystemCombo52 = operatingSystemCombo52;
    }

    /**
     * Gets the operating system checkbox5 value.
     * 
     * @return the operatingSystemCB5
     */
    public Boolean getOperatingSystemCB5() {
	return operatingSystemCB5;
    }

    /**
     * Sets the operating system checkbox5 value.
     * 
     * @param operatingSystemCB5
     *            the operatingSystemCB5 to set
     */
    public void setOperatingSystemCB5(Boolean operatingSystemCB5) {
	this.operatingSystemCB5 = operatingSystemCB5;
    }

    /**
     * Gets the operating system field5 value.
     * 
     * @return the operatingSystemField5
     */
    public String getOperatingSystemField5() {
	return operatingSystemField5;
    }

    /**
     * Sets the operating system field5 value.
     * 
     * @param operatingSystemField5
     *            the operatingSystemField5 to set
     */
    public void setOperatingSystemField5(String operatingSystemField5) {
	this.operatingSystemField5 = operatingSystemField5;
    }

    /**
     * Gets the operating system HQL constraints.
     * 
     * @param values
     *            where we want it to store the values
     * @param types
     *            where we want it to store the types
     * @param locale
     *            the user's locale
     * @return the operating system HQL constraints
     */
    private String getOperatingSystemConstraints(List<Object> values,
	    List<Type> types, Locale locale, Date queryDate) {
	String constraints = "";
	constraints += getConstraint("os." + operatingSystemCombo11,
		operatingSystemCombo12, operatingSystemField1,
		operatingSystemCB1, values, types, locale);
	constraints += getConstraint("os." + operatingSystemCombo21,
		operatingSystemCombo22, operatingSystemField2,
		operatingSystemCB2, values, types, locale);
	constraints += getConstraint("os." + operatingSystemCombo31,
		operatingSystemCombo32, operatingSystemField3,
		operatingSystemCB3, values, types, locale);
	constraints += getConstraint("os." + operatingSystemCombo41,
		operatingSystemCombo42, operatingSystemField4,
		operatingSystemCB4, values, types, locale);
	constraints += getConstraint("os." + operatingSystemCombo51,
		operatingSystemCombo52, operatingSystemField5,
		operatingSystemCB5, values, types, locale);

	if (constraints.endsWith(" and ")) {
	    constraints = constraints.substring(0, constraints.length() - 5);
	}

	return buildOperatingSystemConstratins(values, types, locale,
		queryDate, constraints);
    }

    /**
     * Gets the software combo11 value.
     * 
     * @return the softwareCombo11
     */
    public String getSoftwareCombo11() {
	return softwareCombo11;
    }

    /**
     * Sets the software combo11 value.
     * 
     * @param softwareCombo11
     *            the softwareCombo11 to set
     */
    public void setSoftwareCombo11(String softwareCombo11) {
	this.softwareCombo11 = softwareCombo11;
    }

    /**
     * Gets the software combo12 value.
     * 
     * @return the softwareCombo12
     */
    public String getSoftwareCombo12() {
	return softwareCombo12;
    }

    /**
     * Sets the software combo12 value.
     * 
     * @param softwareCombo12
     *            the softwareCombo12 to set
     */
    public void setSoftwareCombo12(String softwareCombo12) {
	this.softwareCombo12 = softwareCombo12;
    }

    /**
     * Gets the software checkbox1 value.
     * 
     * @return the softwareCB1
     */
    public Boolean getSoftwareCB1() {
	return softwareCB1;
    }

    /**
     * Sets the software checkbox1 value.
     * 
     * @param softwareCB1
     *            the softwareCB1 to set
     */
    public void setSoftwareCB1(Boolean softwareCB1) {
	this.softwareCB1 = softwareCB1;
    }

    /**
     * Gets the software field1 value.
     * 
     * @return the softwareField1
     */
    public String getSoftwareField1() {
	return softwareField1;
    }

    /**
     * Sets the software field1 value.
     * 
     * @param softwareField1
     *            the softwareField1 to set
     */
    public void setSoftwareField1(String softwareField1) {
	this.softwareField1 = softwareField1;
    }

    /**
     * Gets the software combo21 value.
     * 
     * @return the softwareCombo21
     */
    public String getSoftwareCombo21() {
	return softwareCombo21;
    }

    /**
     * Sets the software combo21 value.
     * 
     * @param softwareCombo21
     *            the softwareCombo21 to set
     */
    public void setSoftwareCombo21(String softwareCombo21) {
	this.softwareCombo21 = softwareCombo21;
    }

    /**
     * Gets the software combo22 value.
     * 
     * @return the softwareCombo22
     */
    public String getSoftwareCombo22() {
	return softwareCombo22;
    }

    /**
     * Sets the software combo22 value.
     * 
     * @param softwareCombo22
     *            the softwareCombo22 to set
     */
    public void setSoftwareCombo22(String softwareCombo22) {
	this.softwareCombo22 = softwareCombo22;
    }

    /**
     * Gets the software checkbox2 value.
     * 
     * @return the softwareCB2
     */
    public Boolean getSoftwareCB2() {
	return softwareCB2;
    }

    /**
     * Sets the software checkbox2 value.
     * 
     * @param softwareCB2
     *            the softwareCB2 to set
     */
    public void setSoftwareCB2(Boolean softwareCB2) {
	this.softwareCB2 = softwareCB2;
    }

    /**
     * Gets the software field2 value.
     * 
     * @return the softwareField2
     */
    public String getSoftwareField2() {
	return softwareField2;
    }

    /**
     * Sets the software field2 value.
     * 
     * @param softwareField2
     *            the softwareField2 to set
     */
    public void setSoftwareField2(String softwareField2) {
	this.softwareField2 = softwareField2;
    }

    /**
     * Gets the software combo31 value.
     * 
     * @return the softwareCombo31
     */
    public String getSoftwareCombo31() {
	return softwareCombo31;
    }

    /**
     * Sets the software combo31 value.
     * 
     * @param softwareCombo31
     *            the softwareCombo31 to set
     */
    public void setSoftwareCombo31(String softwareCombo31) {
	this.softwareCombo31 = softwareCombo31;
    }

    /**
     * Gets the software combo32 value.
     * 
     * @return the softwareCombo32
     */
    public String getSoftwareCombo32() {
	return softwareCombo32;
    }

    /**
     * Sets the software combo32 value.
     * 
     * @param softwareCombo32
     *            the softwareCombo32 to set
     */
    public void setSoftwareCombo32(String softwareCombo32) {
	this.softwareCombo32 = softwareCombo32;
    }

    /**
     * Gets the software checkbox3 value.
     * 
     * @return the softwareCB3
     */
    public Boolean getSoftwareCB3() {
	return softwareCB3;
    }

    /**
     * Sets the software checkbox3 value.
     * 
     * @param softwareCB3
     *            the softwareCB3 to set
     */
    public void setSoftwareCB3(Boolean softwareCB3) {
	this.softwareCB3 = softwareCB3;
    }

    /**
     * Gets the software field3 value.
     * 
     * @return the softwareField3
     */
    public String getSoftwareField3() {
	return softwareField3;
    }

    /**
     * Sets the software field3 value.
     * 
     * @param softwareField3
     *            the softwareField3 to set
     */
    public void setSoftwareField3(String softwareField3) {
	this.softwareField3 = softwareField3;
    }

    /**
     * Gets the software combo41 value.
     * 
     * @return the softwareCombo41
     */
    public String getSoftwareCombo41() {
	return softwareCombo41;
    }

    /**
     * Sets the software combo41 value.
     * 
     * @param softwareCombo41
     *            the softwareCombo41 to set
     */
    public void setSoftwareCombo41(String softwareCombo41) {
	this.softwareCombo41 = softwareCombo41;
    }

    /**
     * Gets the software combo42 value.
     * 
     * @return the softwareCombo42
     */
    public String getSoftwareCombo42() {
	return softwareCombo42;
    }

    /**
     * Sets the software combo42 value.
     * 
     * @param softwareCombo42
     *            the softwareCombo42 to set
     */
    public void setSoftwareCombo42(String softwareCombo42) {
	this.softwareCombo42 = softwareCombo42;
    }

    /**
     * Gets the software checkbox4 value.
     * 
     * @return the softwareCB4
     */
    public Boolean getSoftwareCB4() {
	return softwareCB4;
    }

    /**
     * Sets the software checkbox4 value.
     * 
     * @param softwareCB4
     *            the softwareCB4 to set
     */
    public void setSoftwareCB4(Boolean softwareCB4) {
	this.softwareCB4 = softwareCB4;
    }

    /**
     * Gets the software field4 value.
     * 
     * @return the softwareField4
     */
    public String getSoftwareField4() {
	return softwareField4;
    }

    /**
     * Sets the software field4 value.
     * 
     * @param softwareField4
     *            the softwareField4 to set
     */
    public void setSoftwareField4(String softwareField4) {
	this.softwareField4 = softwareField4;
    }

    /**
     * Gets the software combo51 value.
     * 
     * @return the softwareCombo51
     */
    public String getSoftwareCombo51() {
	return softwareCombo51;
    }

    /**
     * Sets the software combo51 value.
     * 
     * @param softwareCombo51
     *            the softwareCombo51 to set
     */
    public void setSoftwareCombo51(String softwareCombo51) {
	this.softwareCombo51 = softwareCombo51;
    }

    /**
     * Gets the software combo52 value.
     * 
     * @return the softwareCombo52
     */
    public String getSoftwareCombo52() {
	return softwareCombo52;
    }

    /**
     * Sets the software combo52 value.
     * 
     * @param softwareCombo52
     *            the softwareCombo52 to set
     */
    public void setSoftwareCombo52(String softwareCombo52) {
	this.softwareCombo52 = softwareCombo52;
    }

    /**
     * Gets the software checkbox5 value.
     * 
     * @return the softwareCB5
     */
    public Boolean getSoftwareCB5() {
	return softwareCB5;
    }

    /**
     * Sets the software checkbox5 value.
     * 
     * @param softwareCB5
     *            the softwareCB5 to set
     */
    public void setSoftwareCB5(Boolean softwareCB5) {
	this.softwareCB5 = softwareCB5;
    }

    /**
     * Gets the software field5 value.
     * 
     * @return the softwareField5
     */
    public String getSoftwareField5() {
	return softwareField5;
    }

    /**
     * Sets the software field5 value.
     * 
     * @param softwareField5
     *            the softwareField5 to set
     */
    public void setSoftwareField5(String softwareField5) {
	this.softwareField5 = softwareField5;
    }

    /**
     * Gets the software HQL constraints.
     * 
     * @param values
     *            where we want it to store the values
     * @param types
     *            where we want it to store the types
     * @param locale
     *            the user's locale
     * @return the software HQL constraints
     */
    private String getSoftwareConstraints(List<Object> values,
	    List<Type> types, Locale locale, Date queryDate) {
	String constraints = "";
	constraints += getConstraint("sw." + softwareCombo11, softwareCombo12,
		softwareField1, softwareCB1, values, types, locale);
	constraints += getConstraint("sw." + softwareCombo21, softwareCombo22,
		softwareField2, softwareCB2, values, types, locale);
	constraints += getConstraint("sw." + softwareCombo31, softwareCombo32,
		softwareField3, softwareCB3, values, types, locale);
	constraints += getConstraint("sw." + softwareCombo41, softwareCombo42,
		softwareField4, softwareCB4, values, types, locale);
	constraints += getConstraint("sw." + softwareCombo51, softwareCombo52,
		softwareField5, softwareCB5, values, types, locale);
	if (constraints.endsWith(" and ")) {
	    constraints = constraints.substring(0, constraints.length() - 5);
	}

	return buildSoftwareConstraintsBySwType(values, types, locale,
		queryDate, constraints, "Gen");
    }

    /**
     * Gets the xfs sw combo11 value.
     * 
     * @return the xfsSwCombo11
     */
    public String getXfsSwCombo11() {
	return xfsSwCombo11;
    }

    /**
     * Sets the xfs sw combo11 value.
     * 
     * @param xfsSwCombo11
     *            the xfsSwCombo11 to set
     */
    public void setXfsSwCombo11(String xfsSwCombo11) {
	this.xfsSwCombo11 = xfsSwCombo11;
    }

    /**
     * Gets the xfs sw combo12 value.
     * 
     * @return the xfsSwCombo12
     */
    public String getXfsSwCombo12() {
	return xfsSwCombo12;
    }

    /**
     * Sets the xfs sw combo12 value.
     * 
     * @param xfsSwCombo12
     *            the xfsSwCombo12 to set
     */
    public void setXfsSwCombo12(String xfsSwCombo12) {
	this.xfsSwCombo12 = xfsSwCombo12;
    }

    /**
     * Gets the xfs sw checkbox1 value.
     * 
     * @return the xfsSwCB1
     */
    public Boolean getXfsSwCB1() {
	return xfsSwCB1;
    }

    /**
     * ets the xfs sw checkbox1 value.
     * 
     * @param xfsSwCB1
     *            the xfsSwCB1 to set
     */
    public void setXfsSwCB1(Boolean xfsSwCB1) {
	this.xfsSwCB1 = xfsSwCB1;
    }

    /**
     * Gets the xfs sw field1 value.
     * 
     * @return the xfsSwField1
     */
    public String getXfsSwField1() {
	return xfsSwField1;
    }

    /**
     * Sets the xfs sw field1 value.
     * 
     * @param xfsSwField1
     *            the xfsSwField1 to set
     */
    public void setXfsSwField1(String xfsSwField1) {
	this.xfsSwField1 = xfsSwField1;
    }

    /**
     * Gets the xfs sw combo21 value.
     * 
     * @return the xfsSwCombo21
     */
    public String getXfsSwCombo21() {
	return xfsSwCombo21;
    }

    /**
     * Sets the xfs sw combo21 value.
     * 
     * @param xfsSwCombo21
     *            the xfsSwCombo21 to set
     */
    public void setXfsSwCombo21(String xfsSwCombo21) {
	this.xfsSwCombo21 = xfsSwCombo21;
    }

    /**
     * Gets the xfs sw combo22 value.
     * 
     * @return the xfsSwCombo22
     */
    public String getXfsSwCombo22() {
	return xfsSwCombo22;
    }

    /**
     * Sets the xfs sw combo22 value.
     * 
     * @param xfsSwCombo22
     *            the xfsSwCombo22 to set
     */
    public void setXfsSwCombo22(String xfsSwCombo22) {
	this.xfsSwCombo22 = xfsSwCombo22;
    }

    /**
     * Gets the xfs sw checkbox2 value.
     * 
     * @return the xfsSwCB2
     */
    public Boolean getXfsSwCB2() {
	return xfsSwCB2;
    }

    /**
     * Sets the xfs sw checkbox2 value.
     * 
     * @param xfsSwCB2
     *            the xfsSwCB2 to set
     */
    public void setXfsSwCB2(Boolean xfsSwCB2) {
	this.xfsSwCB2 = xfsSwCB2;
    }

    /**
     * Gets the xfs sw field2 value.
     * 
     * @return the xfsSwField2
     */
    public String getXfsSwField2() {
	return xfsSwField2;
    }

    /**
     * Sets the xfs sw field2 value.
     * 
     * @param xfsSwField2
     *            the xfsSwField2 to set
     */
    public void setXfsSwField2(String xfsSwField2) {
	this.xfsSwField2 = xfsSwField2;
    }

    /**
     * Gets the xfs sw combo31 value.
     * 
     * @return the xfsSwCombo31
     */
    public String getXfsSwCombo31() {
	return xfsSwCombo31;
    }

    /**
     * Sets the xfs sw combo31 value.
     * 
     * @param xfsSwCombo31
     *            the xfsSwCombo31 to set
     */
    public void setXfsSwCombo31(String xfsSwCombo31) {
	this.xfsSwCombo31 = xfsSwCombo31;
    }

    /**
     * Gets the xfs sw combo32 value.
     * 
     * @return the xfsSwCombo32
     */
    public String getXfsSwCombo32() {
	return xfsSwCombo32;
    }

    /**
     * Sets the xfs sw combo32 value.
     * 
     * @param xfsSwCombo32
     *            the xfsSwCombo32 to set
     */
    public void setXfsSwCombo32(String xfsSwCombo32) {
	this.xfsSwCombo32 = xfsSwCombo32;
    }

    /**
     * Gets the xfs sw checkbox3 value.
     * 
     * @return the xfsSwCB3
     */
    public Boolean getXfsSwCB3() {
	return xfsSwCB3;
    }

    /**
     * Sets the xfs sw checkbox3 value.
     * 
     * @param xfsSwCB3
     *            the xfsSwCB3 to set
     */
    public void setXfsSwCB3(Boolean xfsSwCB3) {
	this.xfsSwCB3 = xfsSwCB3;
    }

    /**
     * Gets the xfs sw field3 value.
     * 
     * @return the xfsSwField3
     */
    public String getXfsSwField3() {
	return xfsSwField3;
    }

    /**
     * Sets the xfs sw field3 value.
     * 
     * @param xfsSwField3
     *            the xfsSwField3 to set
     */
    public void setXfsSwField3(String xfsSwField3) {
	this.xfsSwField3 = xfsSwField3;
    }

    /**
     * Gets the xfs sw combo41 value.
     * 
     * @return the xfsSwCombo41
     */
    public String getXfsSwCombo41() {
	return xfsSwCombo41;
    }

    /**
     * Sets the xfs sw combo41 value.
     * 
     * @param xfsSwCombo41
     *            the xfsSwCombo41 to set
     */
    public void setXfsSwCombo41(String xfsSwCombo41) {
	this.xfsSwCombo41 = xfsSwCombo41;
    }

    /**
     * Gets the xfs sw combo42 value.
     * 
     * @return the xfsSwCombo42
     */
    public String getXfsSwCombo42() {
	return xfsSwCombo42;
    }

    /**
     * Sets the xfs sw combo42 value.
     * 
     * @param xfsSwCombo42
     *            the xfsSwCombo42 to set
     */
    public void setXfsSwCombo42(String xfsSwCombo42) {
	this.xfsSwCombo42 = xfsSwCombo42;
    }

    /**
     * Gets the xfs sw checkbox4 value.
     * 
     * @return the xfsSwCB4
     */
    public Boolean getXfsSwCB4() {
	return xfsSwCB4;
    }

    /**
     * Sets the xfs sw checkbox4 value.
     * 
     * @param xfsSwCB4
     *            the xfsSwCB4 to set
     */
    public void setXfsSwCB4(Boolean xfsSwCB4) {
	this.xfsSwCB4 = xfsSwCB4;
    }

    /**
     * Gets the xfs sw field4 value.
     * 
     * @return the xfsSwField4
     */
    public String getXfsSwField4() {
	return xfsSwField4;
    }

    /**
     * Sets the xfs sw field4 value.
     * 
     * @param xfsSwField4
     *            the xfsSwField4 to set
     */
    public void setXfsSwField4(String xfsSwField4) {
	this.xfsSwField4 = xfsSwField4;
    }

    /**
     * Gets the xfs sw combo51 value.
     * 
     * @return the xfsSwCombo51
     */
    public String getXfsSwCombo51() {
	return xfsSwCombo51;
    }

    /**
     * Sets the xfs sw combo51 value.
     * 
     * @param xfsSwCombo51
     *            the xfsSwCombo51 to set
     */
    public void setXfsSwCombo51(String xfsSwCombo51) {
	this.xfsSwCombo51 = xfsSwCombo51;
    }

    /**
     * Gets the xfs sw combo52 value.
     * 
     * @return the xfsSwCombo52
     */
    public String getXfsSwCombo52() {
	return xfsSwCombo52;
    }

    /**
     * Sets the xfs sw combo52 value.
     * 
     * @param xfsSwCombo52
     *            the xfsSwCombo52 to set
     */
    public void setXfsSwCombo52(String xfsSwCombo52) {
	this.xfsSwCombo52 = xfsSwCombo52;
    }

    /**
     * Gets the xfs sw checkbox5 value.
     * 
     * @return the xfsSwCB5
     */
    public Boolean getXfsSwCB5() {
	return xfsSwCB5;
    }

    /**
     * Sets the xfs sw checkbox5 value.
     * 
     * @param xfsSwCB5
     *            the xfsSwCB5 to set
     */
    public void setXfsSwCB5(Boolean xfsSwCB5) {
	this.xfsSwCB5 = xfsSwCB5;
    }

    /**
     * Gets the xfs sw field5 value.
     * 
     * @return the xfsSwField5
     */
    public String getXfsSwField5() {
	return xfsSwField5;
    }

    /**
     * Sets the xfs sw field5 value.
     * 
     * @param xfsSwField5
     *            the xfsSwField5 to set
     */
    public void setXfsSwField5(String xfsSwField5) {
	this.xfsSwField5 = xfsSwField5;
    }

    /**
     * Gets the xfs sw HQL constraints.
     * 
     * @param values
     *            where we want it to store the values
     * @param types
     *            where we want it to store the types
     * @param locale
     *            the user's locale
     * @return the xfs sw HQL constraints
     */
    private String getXfsSwConstraints(List<Object> values, List<Type> types,
	    Locale locale, Date queryDate) {
	String constraints = "";
	constraints += getConstraint("sw." + xfsSwCombo11, xfsSwCombo12,
		xfsSwField1, xfsSwCB1, values, types, locale);
	constraints += getConstraint("sw." + xfsSwCombo21, xfsSwCombo22,
		xfsSwField2, xfsSwCB2, values, types, locale);
	constraints += getConstraint("sw." + xfsSwCombo31, xfsSwCombo32,
		xfsSwField3, xfsSwCB3, values, types, locale);
	constraints += getConstraint("sw." + xfsSwCombo41, xfsSwCombo42,
		xfsSwField4, xfsSwCB4, values, types, locale);
	constraints += getConstraint("sw." + xfsSwCombo51, xfsSwCombo52,
		xfsSwField5, xfsSwCB5, values, types, locale);
	if (constraints.endsWith(" and ")) {
	    constraints = constraints.substring(0, constraints.length() - 5);
	}

	return buildSoftwareConstraintsBySwType(values, types, locale,
		queryDate, constraints, "XFS");
    }

    /**
     * Gets the feat sw combo11 value.
     * 
     * @return the featSwCombo11
     */
    public String getFeatSwCombo11() {
	return featSwCombo11;
    }

    /**
     * Sets the feat sw combo11 value.
     * 
     * @param featSwCombo11
     *            the featSwCombo11 to set
     */
    public void setFeatSwCombo11(String featSwCombo11) {
	this.featSwCombo11 = featSwCombo11;
    }

    /**
     * Gets the feat sw combo12 value.
     * 
     * @return the featSwCombo12
     */
    public String getFeatSwCombo12() {
	return featSwCombo12;
    }

    /**
     * Sets the feat sw combo12 value.
     * 
     * @param featSwCombo12
     *            the featSwCombo12 to set
     */
    public void setFeatSwCombo12(String featSwCombo12) {
	this.featSwCombo12 = featSwCombo12;
    }

    /**
     * Gets the feat sw checkbox1 value.
     * 
     * @return the featSwCB1
     */
    public Boolean getFeatSwCB1() {
	return featSwCB1;
    }

    /**
     * Sets the feat sw checkbox1 value.
     * 
     * @param featSwCB1
     *            the featSwCB1 to set
     */
    public void setFeatSwCB1(Boolean featSwCB1) {
	this.featSwCB1 = featSwCB1;
    }

    /**
     * Gets the feat sw field1 value.
     * 
     * @return the featSwField1
     */
    public String getFeatSwField1() {
	return featSwField1;
    }

    /**
     * Sets the feat sw field1 value.
     * 
     * @param featSwField1
     *            the featSwField1 to set
     */
    public void setFeatSwField1(String featSwField1) {
	this.featSwField1 = featSwField1;
    }

    /**
     * Gets the feat sw combo21 value.
     * 
     * @return the featSwCombo21
     */
    public String getFeatSwCombo21() {
	return featSwCombo21;
    }

    /**
     * Sets the feat sw combo21 value.
     * 
     * @param featSwCombo21
     *            the featSwCombo21 to set
     */
    public void setFeatSwCombo21(String featSwCombo21) {
	this.featSwCombo21 = featSwCombo21;
    }

    /**
     * Gets the feat sw combo22 value.
     * 
     * @return the featSwCombo22
     */
    public String getFeatSwCombo22() {
	return featSwCombo22;
    }

    /**
     * Sets the feat sw combo22 value.
     * 
     * @param featSwCombo22
     *            the featSwCombo22 to set
     */
    public void setFeatSwCombo22(String featSwCombo22) {
	this.featSwCombo22 = featSwCombo22;
    }

    /**
     * Gets the feat sw checkbox2 value.
     * 
     * @return the featSwCB2
     */
    public Boolean getFeatSwCB2() {
	return featSwCB2;
    }

    /**
     * Sets the feat sw checkbox2 value.
     * 
     * @param featSwCB2
     *            the featSwCB2 to set
     */
    public void setFeatSwCB2(Boolean featSwCB2) {
	this.featSwCB2 = featSwCB2;
    }

    /**
     * Gets the feat sw field2 value.
     * 
     * @return the featSwField2
     */
    public String getFeatSwField2() {
	return featSwField2;
    }

    /**
     * Sets the feat sw field2 value.
     * 
     * @param featSwField2
     *            the featSwField2 to set
     */
    public void setFeatSwField2(String featSwField2) {
	this.featSwField2 = featSwField2;
    }

    /**
     * Gets the feat sw combo31 value.
     * 
     * @return the featSwCombo31
     */
    public String getFeatSwCombo31() {
	return featSwCombo31;
    }

    /**
     * Sets the feat sw combo31 value.
     * 
     * @param featSwCombo31
     *            the featSwCombo31 to set
     */
    public void setFeatSwCombo31(String featSwCombo31) {
	this.featSwCombo31 = featSwCombo31;
    }

    /**
     * Gets the feat sw combo32 value.
     * 
     * @return the featSwCombo32
     */
    public String getFeatSwCombo32() {
	return featSwCombo32;
    }

    /**
     * Sets the feat sw combo32 value.
     * 
     * @param featSwCombo32
     *            the featSwCombo32 to set
     */
    public void setFeatSwCombo32(String featSwCombo32) {
	this.featSwCombo32 = featSwCombo32;
    }

    /**
     * Gets the feat sw checkbox3 value.
     * 
     * @return the featSwCB3
     */
    public Boolean getFeatSwCB3() {
	return featSwCB3;
    }

    /**
     * Sets the feat sw checkbox3 value.
     * 
     * @param featSwCB3
     *            the featSwCB3 to set
     */
    public void setFeatSwCB3(Boolean featSwCB3) {
	this.featSwCB3 = featSwCB3;
    }

    /**
     * Gets the feat sw field3 value.
     * 
     * @return the featSwField3
     */
    public String getFeatSwField3() {
	return featSwField3;
    }

    /**
     * Sets the feat sw field3 value.
     * 
     * @param featSwField3
     *            the featSwField3 to set
     */
    public void setFeatSwField3(String featSwField3) {
	this.featSwField3 = featSwField3;
    }

    /**
     * Gets the feat sw combo41 value.
     * 
     * @return the featSwCombo41
     */
    public String getFeatSwCombo41() {
	return featSwCombo41;
    }

    /**
     * Sets the feat sw combo41 value.
     * 
     * @param featSwCombo41
     *            the featSwCombo41 to set
     */
    public void setFeatSwCombo41(String featSwCombo41) {
	this.featSwCombo41 = featSwCombo41;
    }

    /**
     * Gets the feat sw combo42 value.
     * 
     * @return the featSwCombo42
     */
    public String getFeatSwCombo42() {
	return featSwCombo42;
    }

    /**
     * Sets the feat sw combo42 value.
     * 
     * @param featSwCombo42
     *            the featSwCombo42 to set
     */
    public void setFeatSwCombo42(String featSwCombo42) {
	this.featSwCombo42 = featSwCombo42;
    }

    /**
     * Gets the feat sw checkbox4 value.
     * 
     * @return the featSwCB4
     */
    public Boolean getFeatSwCB4() {
	return featSwCB4;
    }

    /**
     * Sets the feat sw checkbox4 value.
     * 
     * @param featSwCB4
     *            the featSwCB4 to set
     */
    public void setFeatSwCB4(Boolean featSwCB4) {
	this.featSwCB4 = featSwCB4;
    }

    /**
     * Gets the feat sw field4 value.
     * 
     * @return the featSwField4
     */
    public String getFeatSwField4() {
	return featSwField4;
    }

    /**
     * Sets the feat sw field4 value.
     * 
     * @param featSwField4
     *            the featSwField4 to set
     */
    public void setFeatSwField4(String featSwField4) {
	this.featSwField4 = featSwField4;
    }

    /**
     * Gets the feat sw combo51 value.
     * 
     * @return the featSwCombo51
     */
    public String getFeatSwCombo51() {
	return featSwCombo51;
    }

    /**
     * Sets the feat sw combo51 value.
     * 
     * @param featSwCombo51
     *            the featSwCombo51 to set
     */
    public void setFeatSwCombo51(String featSwCombo51) {
	this.featSwCombo51 = featSwCombo51;
    }

    /**
     * Gets the feat sw combo52 value.
     * 
     * @return the featSwCombo52
     */
    public String getFeatSwCombo52() {
	return featSwCombo52;
    }

    /**
     * Sets the feat sw combo52 value.
     * 
     * @param featSwCombo52
     *            the featSwCombo52 to set
     */
    public void setFeatSwCombo52(String featSwCombo52) {
	this.featSwCombo52 = featSwCombo52;
    }

    /**
     * Gets the feat sw checkbox5 value.
     * 
     * @return the featSwCB5
     */
    public Boolean getFeatSwCB5() {
	return featSwCB5;
    }

    /**
     * Sets the feat sw checkbox5 value.
     * 
     * @param featSwCB5
     *            the featSwCB5 to set
     */
    public void setFeatSwCB5(Boolean featSwCB5) {
	this.featSwCB5 = featSwCB5;
    }

    /**
     * Gets the feat sw field5 value.
     * 
     * @return the featSwField5
     */
    public String getFeatSwField5() {
	return featSwField5;
    }

    /**
     * Sets the feat sw field5 value.
     * 
     * @param featSwField5
     *            the featSwField5 to set
     */
    public void setFeatSwField5(String featSwField5) {
	this.featSwField5 = featSwField5;
    }

    private String buildOperatingSystemConstratins(List<Object> values,
	    List<Type> types, Locale locale, Date queryDate, String constraints) {
	if (constraints.length() > 0) {
	    String isActiveByDateConstraint = storeIsElementActiveByDate(
		    "osConfig.", values, types, locale, constraints, queryDate);

	    if (isActiveByDateConstraint.length() > 0) {
		isActiveByDateConstraint = " and " + isActiveByDateConstraint;
	    }

	    String constraintForNotDateQueries = "osConfig.startDate = (select max(startDate)"
		    + " from TerminalConfig tc where tc.terminal.id = terminal.id) and ";

	    constraints = "terminal.id in (select distinct osConfig.terminal.id"
		    + " from TerminalConfig osConfig join osConfig.operatingSystems os "
		    + "where "
		    + (queryDate == null ? constraintForNotDateQueries : "")
		    + constraints + isActiveByDateConstraint + ")";
	}
	return constraints;
    }

    private String buildSoftwareConstraintsBySwType(List<Object> values,
	    List<Type> types, Locale locale, Date queryDate,
	    String constraints, String swType) {

	if (constraints.length() > 0) {
	    String isActiveByDateConstraint = storeIsElementActiveByDate(
		    "swConfig.", values, types, locale, constraints, queryDate);

	    if (isActiveByDateConstraint.length() > 0) {
		isActiveByDateConstraint = " and " + isActiveByDateConstraint;
	    }

	    String constraintForNotDateQueries = "swConfig.startDate = (select max(startDate)"
		    + " from TerminalConfig tc where tc.terminal.id = terminal.id) and ";

	    constraints = "terminal.id in (select distinct swConfig.terminal.id"
		    + " from TerminalConfig swConfig join swConfig.software sw "
		    + "where sw.swType = '"
		    + swType
		    + "' and "
		    + (queryDate == null ? constraintForNotDateQueries : "")
		    + constraints + isActiveByDateConstraint + ")";
	}
	return constraints;
    }

    /**
     * Gets the feat sw HQL constraints.
     * 
     * @param values
     *            where we want it to store the values
     * @param types
     *            where we want it to store the types
     * @param locale
     *            the user's locale
     * @return the feat sw HQL constraints
     */
    private String getFeatSwConstraints(List<Object> values, List<Type> types,
	    Locale locale, Date queryDate) {
	String constraints = "";
	constraints += getConstraint("sw." + featSwCombo11, featSwCombo12,
		featSwField1, featSwCB1, values, types, locale);
	constraints += getConstraint("sw." + featSwCombo21, featSwCombo22,
		featSwField2, featSwCB2, values, types, locale);
	constraints += getConstraint("sw." + featSwCombo31, featSwCombo32,
		featSwField3, featSwCB3, values, types, locale);
	constraints += getConstraint("sw." + featSwCombo41, featSwCombo42,
		featSwField4, featSwCB4, values, types, locale);
	constraints += getConstraint("sw." + featSwCombo51, featSwCombo52,
		featSwField5, featSwCB5, values, types, locale);
	if (constraints.endsWith(" and ")) {
	    constraints = constraints.substring(0, constraints.length() - 5);
	}

	return buildSoftwareConstraintsBySwType(values, types, locale,
		queryDate, constraints, "Feat");
    }

    /**
     * Gets the hardware device combo11 value.
     * 
     * @return the hardwareDeviceCombo11
     */
    public String getHardwareDeviceCombo11() {
	return hardwareDeviceCombo11;
    }

    /**
     * Sets the hardware device combo11 value.
     * 
     * @param hardwareDeviceCombo11
     *            the hardwareDeviceCombo11 to set
     */
    public void setHardwareDeviceCombo11(String hardwareDeviceCombo11) {
	this.hardwareDeviceCombo11 = hardwareDeviceCombo11;
    }

    /**
     * Gets the hardware device combo12 value.
     * 
     * @return the hardwareDeviceCombo12
     */
    public String getHardwareDeviceCombo12() {
	return hardwareDeviceCombo12;
    }

    /**
     * Sets the hardware device combo12 value.
     * 
     * @param hardwareDeviceCombo12
     *            the hardwareDeviceCombo12 to set
     */
    public void setHardwareDeviceCombo12(String hardwareDeviceCombo12) {
	this.hardwareDeviceCombo12 = hardwareDeviceCombo12;
    }

    /**
     * Gets the hardware device combo13 value.
     * 
     * @return the hardwareDeviceCombo13
     */
    public String getHardwareDeviceCombo13() {
	return hardwareDeviceCombo13;
    }

    /**
     * Sets the hardware device combo13 value.
     * 
     * @param hardwareDeviceCombo13
     *            the hardwareDeviceCombo13 to set
     */
    public void setHardwareDeviceCombo13(String hardwareDeviceCombo13) {
	this.hardwareDeviceCombo13 = hardwareDeviceCombo13;
    }

    /**
     * Gets the hardware device checkbox1 value.
     * 
     * @return the hardwareDeviceCB1
     */
    public Boolean getHardwareDeviceCB1() {
	return hardwareDeviceCB1;
    }

    /**
     * Sets the hardware device checkbox1 value.
     * 
     * @param hardwareDeviceCB1
     *            the hardwareDeviceCB1 to set
     */
    public void setHardwareDeviceCB1(Boolean hardwareDeviceCB1) {
	this.hardwareDeviceCB1 = hardwareDeviceCB1;
    }

    /**
     * Gets the hardware device field1 value.
     * 
     * @return the hardwareDeviceField1
     */
    public String getHardwareDeviceField1() {
	return hardwareDeviceField1;
    }

    /**
     * Sets the hardware device field1 value.
     * 
     * @param hardwareDeviceField1
     *            the hardwareDeviceField1 to set
     */
    public void setHardwareDeviceField1(String hardwareDeviceField1) {
	this.hardwareDeviceField1 = hardwareDeviceField1;
    }

    /**
     * Gets the hardware device combo21 value.
     * 
     * @return the hardwareDeviceCombo21
     */
    public String getHardwareDeviceCombo21() {
	return hardwareDeviceCombo21;
    }

    /**
     * Sets the hardware device combo21 value.
     * 
     * @param hardwareDeviceCombo21
     *            the hardwareDeviceCombo21 to set
     */
    public void setHardwareDeviceCombo21(String hardwareDeviceCombo21) {
	this.hardwareDeviceCombo21 = hardwareDeviceCombo21;
    }

    /**
     * Gets the hardware device combo22 value.
     * 
     * @return the hardwareDeviceCombo22
     */
    public String getHardwareDeviceCombo22() {
	return hardwareDeviceCombo22;
    }

    /**
     * Sets the hardware device combo22 value.
     * 
     * @param hardwareDeviceCombo22
     *            the hardwareDeviceCombo22 to set
     */
    public void setHardwareDeviceCombo22(String hardwareDeviceCombo22) {
	this.hardwareDeviceCombo22 = hardwareDeviceCombo22;
    }

    /**
     * Gets the hardware device combo23 value.
     * 
     * @return the hardwareDeviceCombo23
     */
    public String getHardwareDeviceCombo23() {
	return hardwareDeviceCombo23;
    }

    /**
     * Sets the hardware device combo23 value.
     * 
     * @param hardwareDeviceCombo23
     *            the hardwareDeviceCombo23 to set
     */
    public void setHardwareDeviceCombo23(String hardwareDeviceCombo23) {
	this.hardwareDeviceCombo23 = hardwareDeviceCombo23;
    }

    /**
     * Gets the hardware device checkbox2 value.
     * 
     * @return the hardwareDeviceCB2
     */
    public Boolean getHardwareDeviceCB2() {
	return hardwareDeviceCB2;
    }

    /**
     * Sets the hardware device checkbox2 value.
     * 
     * @param hardwareDeviceCB2
     *            the hardwareDeviceCB2 to set
     */
    public void setHardwareDeviceCB2(Boolean hardwareDeviceCB2) {
	this.hardwareDeviceCB2 = hardwareDeviceCB2;
    }

    /**
     * Gets the hardware device field2 value.
     * 
     * @return the hardwareDeviceField2
     */
    public String getHardwareDeviceField2() {
	return hardwareDeviceField2;
    }

    /**
     * Sets the hardware device field2 value.
     * 
     * @param hardwareDeviceField2
     *            the hardwareDeviceField2 to set
     */
    public void setHardwareDeviceField2(String hardwareDeviceField2) {
	this.hardwareDeviceField2 = hardwareDeviceField2;
    }

    /**
     * Gets the hardware device combo31 value.
     * 
     * @return the hardwareDeviceCombo31
     */
    public String getHardwareDeviceCombo31() {
	return hardwareDeviceCombo31;
    }

    /**
     * Sets the hardware device combo31 value.
     * 
     * @param hardwareDeviceCombo31
     *            the hardwareDeviceCombo31 to set
     */
    public void setHardwareDeviceCombo31(String hardwareDeviceCombo31) {
	this.hardwareDeviceCombo31 = hardwareDeviceCombo31;
    }

    /**
     * Gets the hardware device combo32 value.
     * 
     * @return the hardwareDeviceCombo32
     */
    public String getHardwareDeviceCombo32() {
	return hardwareDeviceCombo32;
    }

    /**
     * Sets the hardware device combo32 value.
     * 
     * @param hardwareDeviceCombo32
     *            the hardwareDeviceCombo32 to set
     */
    public void setHardwareDeviceCombo32(String hardwareDeviceCombo32) {
	this.hardwareDeviceCombo32 = hardwareDeviceCombo32;
    }

    /**
     * Gets the hardware device combo33 value.
     * 
     * @return the hardwareDeviceCombo33
     */
    public String getHardwareDeviceCombo33() {
	return hardwareDeviceCombo33;
    }

    /**
     * Sets the hardware device combo33 value.
     * 
     * @param hardwareDeviceCombo33
     *            the hardwareDeviceCombo33 to set
     */
    public void setHardwareDeviceCombo33(String hardwareDeviceCombo33) {
	this.hardwareDeviceCombo33 = hardwareDeviceCombo33;
    }

    /**
     * Gets the hardware device checkbox3 value.
     * 
     * @return the hardwareDeviceCB3
     */
    public Boolean getHardwareDeviceCB3() {
	return hardwareDeviceCB3;
    }

    /**
     * Sets the hardware device checkbox3 value.
     * 
     * @param hardwareDeviceCB3
     *            the hardwareDeviceCB3 to set
     */
    public void setHardwareDeviceCB3(Boolean hardwareDeviceCB3) {
	this.hardwareDeviceCB3 = hardwareDeviceCB3;
    }

    /**
     * Gets the hardware device field3 value.
     * 
     * @return the hardwareDeviceField3
     */
    public String getHardwareDeviceField3() {
	return hardwareDeviceField3;
    }

    /**
     * Sets the hardware device field3 value.
     * 
     * @param hardwareDeviceField3
     *            the hardwareDeviceField3 to set
     */
    public void setHardwareDeviceField3(String hardwareDeviceField3) {
	this.hardwareDeviceField3 = hardwareDeviceField3;
    }

    /**
     * Gets the hardware device combo41 value.
     * 
     * @return the hardwareDeviceCombo41
     */
    public String getHardwareDeviceCombo41() {
	return hardwareDeviceCombo41;
    }

    /**
     * Sets the hardware device combo41 value.
     * 
     * @param hardwareDeviceCombo41
     *            the hardwareDeviceCombo41 to set
     */
    public void setHardwareDeviceCombo41(String hardwareDeviceCombo41) {
	this.hardwareDeviceCombo41 = hardwareDeviceCombo41;
    }

    /**
     * Gets the hardware device combo42 value.
     * 
     * @return the hardwareDeviceCombo42
     */
    public String getHardwareDeviceCombo42() {
	return hardwareDeviceCombo42;
    }

    /**
     * Sets the hardware device combo42 value.
     * 
     * @param hardwareDeviceCombo42
     *            the hardwareDeviceCombo42 to set
     */
    public void setHardwareDeviceCombo42(String hardwareDeviceCombo42) {
	this.hardwareDeviceCombo42 = hardwareDeviceCombo42;
    }

    /**
     * Gets the hardware device combo43 value.
     * 
     * @return the hardwareDeviceCombo43
     */
    public String getHardwareDeviceCombo43() {
	return hardwareDeviceCombo43;
    }

    /**
     * Sets the hardware device combo43 value.
     * 
     * @param hardwareDeviceCombo43
     *            the hardwareDeviceCombo43 to set
     */
    public void setHardwareDeviceCombo43(String hardwareDeviceCombo43) {
	this.hardwareDeviceCombo43 = hardwareDeviceCombo43;
    }

    /**
     * Gets the hardware device checkbox4 value.
     * 
     * @return the hardwareDeviceCB4
     */
    public Boolean getHardwareDeviceCB4() {
	return hardwareDeviceCB4;
    }

    /**
     * Sets the hardware device checkbox4 value.
     * 
     * @param hardwareDeviceCB4
     *            the hardwareDeviceCB4 to set
     */
    public void setHardwareDeviceCB4(Boolean hardwareDeviceCB4) {
	this.hardwareDeviceCB4 = hardwareDeviceCB4;
    }

    /**
     * Gets the hardware device field4 value.
     * 
     * @return the hardwareDeviceField4
     */
    public String getHardwareDeviceField4() {
	return hardwareDeviceField4;
    }

    /**
     * Sets the hardware device field4 value.
     * 
     * @param hardwareDeviceField4
     *            the hardwareDeviceField4 to set
     */
    public void setHardwareDeviceField4(String hardwareDeviceField4) {
	this.hardwareDeviceField4 = hardwareDeviceField4;
    }

    /**
     * Gets the hardware device combo51 value.
     * 
     * @return the hardwareDeviceCombo51
     */
    public String getHardwareDeviceCombo51() {
	return hardwareDeviceCombo51;
    }

    /**
     * Sets the hardware device combo51 value.
     * 
     * @param hardwareDeviceCombo51
     *            the hardwareDeviceCombo51 to set
     */
    public void setHardwareDeviceCombo51(String hardwareDeviceCombo51) {
	this.hardwareDeviceCombo51 = hardwareDeviceCombo51;
    }

    /**
     * Gets the hardware device combo52 value.
     * 
     * @return the hardwareDeviceCombo52
     */
    public String getHardwareDeviceCombo52() {
	return hardwareDeviceCombo52;
    }

    /**
     * Sets the hardware device combo52 value.
     * 
     * @param hardwareDeviceCombo52
     *            the hardwareDeviceCombo52 to set
     */
    public void setHardwareDeviceCombo52(String hardwareDeviceCombo52) {
	this.hardwareDeviceCombo52 = hardwareDeviceCombo52;
    }

    /**
     * Gets the hardware device combo53 value.
     * 
     * @return the hardwareDeviceCombo53
     */
    public String getHardwareDeviceCombo53() {
	return hardwareDeviceCombo53;
    }

    /**
     * Sets the hardware device combo53 value.
     * 
     * @param hardwareDeviceCombo53
     *            the hardwareDeviceCombo53 to set
     */
    public void setHardwareDeviceCombo53(String hardwareDeviceCombo53) {
	this.hardwareDeviceCombo53 = hardwareDeviceCombo53;
    }

    /**
     * Gets the hardware device checkbox5 value.
     * 
     * @return the hardwareDeviceCB5
     */
    public Boolean getHardwareDeviceCB5() {
	return hardwareDeviceCB5;
    }

    /**
     * Sets the hardware device checkbox5 value.
     * 
     * @param hardwareDeviceCB5
     *            the hardwareDeviceCB5 to set
     */
    public void setHardwareDeviceCB5(Boolean hardwareDeviceCB5) {
	this.hardwareDeviceCB5 = hardwareDeviceCB5;
    }

    /**
     * Gets the hardware device field5 value.
     * 
     * @return the hardwareDeviceField5
     */
    public String getHardwareDeviceField5() {
	return hardwareDeviceField5;
    }

    /**
     * Sets the hardware device field5 value.
     * 
     * @param hardwareDeviceField5
     *            the hardwareDeviceField5 to set
     */
    public void setHardwareDeviceField5(String hardwareDeviceField5) {
	this.hardwareDeviceField5 = hardwareDeviceField5;
    }

    /**
     * Stores a hardware device HQL constraint for a specific hw type in a
     * collection, so it can be processed later.
     * 
     * @param deviceClass
     *            the hardware device class
     * @param field
     *            the field
     * @param operation
     *            the operation
     * @param value
     *            the value
     * @param not
     *            whether it's negated or not
     * @param constraints
     *            where we want it to store the constraint
     * @param values
     *            where we want it to store the values
     * @param types
     *            where we want it to store the types
     * @param locale
     *            the locale
     */
    private void storeHardwareDeviceConstraint(String deviceClass,
	    String field, String operation, String value, boolean not,
	    Map<String, String> constraints, List<Object> values,
	    List<Type> types, Locale locale) {
	if ((deviceClass != null) && (deviceClass != "")) {
	    String constraint = getConstraint("hardwareDevice." + field,
		    operation, value, not, values, types, locale);
	    if (constraint != "") {
		if (constraints.containsKey(deviceClass)) {
		    constraints.put(deviceClass, constraints.get(deviceClass)
			    + constraint);
		} else {
		    constraints.put(deviceClass, constraint);
		}
	    }
	}
    }

    /**
     * Gets the hardware device HQL constraints.
     * 
     * @param values
     *            where we want it to store the values
     * @param types
     *            where we want it to store the types
     * @param locale
     *            the user's locale
     * @return the hardware device HQL constraints
     */
    private String getHardwareDeviceConstraints(List<Object> values,
	    List<Type> types, Locale locale, Date queryDate) {
	String globalConstraint = "";
	Map<String, String> constraints = new HashMap<String, String>();
	storeHardwareDeviceConstraint(hardwareDeviceCombo11,
		hardwareDeviceCombo12, hardwareDeviceCombo13,
		hardwareDeviceField1, hardwareDeviceCB1, constraints, values,
		types, locale);
	storeHardwareDeviceConstraint(hardwareDeviceCombo21,
		hardwareDeviceCombo22, hardwareDeviceCombo23,
		hardwareDeviceField2, hardwareDeviceCB2, constraints, values,
		types, locale);
	storeHardwareDeviceConstraint(hardwareDeviceCombo31,
		hardwareDeviceCombo32, hardwareDeviceCombo33,
		hardwareDeviceField3, hardwareDeviceCB3, constraints, values,
		types, locale);
	storeHardwareDeviceConstraint(hardwareDeviceCombo41,
		hardwareDeviceCombo42, hardwareDeviceCombo43,
		hardwareDeviceField4, hardwareDeviceCB4, constraints, values,
		types, locale);
	storeHardwareDeviceConstraint(hardwareDeviceCombo51,
		hardwareDeviceCombo52, hardwareDeviceCombo53,
		hardwareDeviceField5, hardwareDeviceCB5, constraints, values,
		types, locale);

	String isActiveByDateConstraint = storeIsElementActiveByDate(
		"hardwareDevice.", values, types, locale, constraints,
		queryDate);

	for (String hwClass : constraints.keySet()) {
	    String classConstraints = constraints.get(hwClass);
	    if (classConstraints.endsWith(" and ")) {
		classConstraints = classConstraints.substring(0,
			classConstraints.length() - 5);
	    }
	    globalConstraint += "terminal.id in (select distinct hardwareDevice.terminal.id"
		    + " from HardwareDevice hardwareDevice where hardwareDevice.hardwareClass = '"
		    + hwClass + "' and " + classConstraints + ") and ";
	}
	if (isActiveByDateConstraint.length() > 0) {
	    globalConstraint += "terminal.id in (select distinct hardwareDevice.terminal.id"
		    + " from HardwareDevice hardwareDevice where"
		    + isActiveByDateConstraint + ")";
	}

	if (globalConstraint.endsWith(" and ")) {
	    globalConstraint = globalConstraint.substring(0,
		    globalConstraint.length() - 5);
	}
	return globalConstraint;
    }

    public String buildIsAuditableElementActiveByDateWhere(
	    String fieldNamePrefix, List<Object> values, List<Type> types,
	    Locale locale, Date queryDate) {
	return storeIsElementActiveByDate(fieldNamePrefix, values, types,
		locale, queryDate);
    }

    private String storeIsElementActiveByDate(String fieldNamePrefix,
	    List<Object> values, List<Type> types, Locale locale,
	    Map<String, String> constraints, Date queryDate) {
	return constraints.keySet().size() > 0 ? storeIsElementActiveByDate(
		fieldNamePrefix, values, types, locale, queryDate) : "";
    }

    private String storeIsElementActiveByDate(String fieldNamePrefix,
	    List<Object> values, List<Type> types, Locale locale,
	    String constraints, Date queryDate) {
	return constraints.length() > 0 ? storeIsElementActiveByDate(
		fieldNamePrefix, values, types, locale, queryDate) : "";
    }

    private String storeIsElementActiveByDate(String fieldNamePrefix,
	    List<Object> values, List<Type> types, Locale locale, Date queryDate) {
	String constraint = "";
	if (queryDate != null) {
	    String queryDateValue = DateFormat.getDateInstance(
		    DateFormat.SHORT, locale).format(queryDate);
	    String startDateField = fieldNamePrefix + "startDate";
	    String endDateField = fieldNamePrefix + "endDate";

	    String startDateIsNullConstraint = Operation.getConstraintHQL(
		    startDateField, "is_null", queryDateValue, values, types,
		    locale);
	    String startDateLeqQueryDate = Operation.getConstraintHQL(
		    startDateField, "date_leq", queryDateValue, values, types,
		    locale);
	    String startDateConstraint = "(" + startDateIsNullConstraint
		    + " or " + startDateLeqQueryDate + ")";

	    String endDateIsNullConstraint = Operation.getConstraintHQL(
		    endDateField, "is_null", queryDateValue, values, types,
		    locale);
	    String endDateGeqQueryDate = Operation.getConstraintHQL(
		    endDateField, "date_geq", queryDateValue, values, types,
		    locale);
	    String endDateConstraint = "(" + endDateIsNullConstraint + " or "
		    + endDateGeqQueryDate + ")";

	    constraint += "(" + startDateConstraint + " and "
		    + endDateConstraint + ")";
	}

	return constraint;
    }

    /**
     * Gets the HQL constraint for the specified data.
     * 
     * @param column
     *            the DB column
     * @param operation
     *            the operation
     * @param value
     *            the value
     * @param not
     *            whether it's negated or not
     * @param values
     *            where we want it to store the values
     * @param types
     *            where we want it to store the types
     * @param locale
     *            the user's locale
     * @return the HQL constraint
     */
    private String getConstraint(String column, String operation, String value,
	    boolean not, List<Object> values, List<Type> types, Locale locale) {
	if (!(column.equals("") || operation.equals("") || (value.equals("") && Operation
		.needsNotVoidValue(operation)))) {
	    String constraint = "("
		    + Operation.getConstraintHQL(column, operation, value,
			    values, types, locale) + ")";
	    if (constraint.length() > 0) {
		if (not) {
		    constraint = "not " + constraint;
		}
		constraint += " and ";
	    }
	    return constraint;
	}
	return "";
    }

    /**
     * Gets the HQL grouping by.
     * 
     * @param values
     *            where we want it to store the values
     * @param types
     *            where we want it to store the types
     * @param locale
     *            the locale
     * @param groupByEntity
     *            the group by entity
     * @param groupByField
     *            the group by field
     * @return the hQL grouping by
     */
    public String getHQLGroupingBy(List<Object> values, List<Type> types,
	    Locale locale, WidgetQueryAssociationType queryAssociationType,
	    String groupByField, Date queryDate) {

	String rootTableAlias = "terminals";

	StringBuffer hql = new StringBuffer("");
	String groupName = queryAssociationType.buildGroupName(rootTableAlias,
		groupByField);
	String queryJoin = queryAssociationType.buildJoin(rootTableAlias);

	hql.append("select new map(" + groupName
		+ " as groupName, count(*) as count) from Terminal terminals");
	hql.append(queryJoin);

	hql.append(" where terminals in (");
	hql.append(getHQL(values, types, locale, false, false, queryDate));
	hql.append(") ");
	hql.append(queryAssociationType.buildWhere(queryDate, this, values,
		types, locale));
	hql.append("group by ");
	hql.append(groupName);
	return hql.toString();
    }

    /**
     * Gets the HQL for the stored data, and stores values and types in the
     * passed variables. No duplicated data is shown and terminals are ordered
     * by serial number and id.
     * 
     * @param values
     *            where we want it to store the values
     * @param types
     *            where we want it to store the types
     * @param locale
     *            the user's locale
     * @return the resulting HQL
     */
    public String getHQL(List<Object> values, List<Type> types, Locale locale) {
	return getHQL(values, types, locale, true, true, null);
    }

    public String getHQL(List<Object> values, List<Type> types, Locale locale,
	    boolean order, Date queryDate) {
	return getHQL(values, types, locale, true, order, queryDate);
    }

    /**
     * Gets the HQL for the stored data, and stores values and types in the
     * passed variables. No duplicated data is shown.
     * 
     * @param values
     *            where we want it to store the values
     * @param types
     *            where we want it to store the types
     * @param locale
     *            the user's locale
     * @param order
     *            whether we want the terminals ordered by serial number and id
     * @return the resulting HQL
     */
    public String getHQL(List<Object> values, List<Type> types, Locale locale,
	    boolean order) {
	return getHQL(values, types, locale, true, order, null);
    }

    /**
     * Gets the HQL for the stored data, and stores values and types in the
     * passed variables.
     * 
     * @param values
     *            where we want it to store the values
     * @param types
     *            where we want it to store the types
     * @param locale
     *            the user's locale
     * @param distinct
     *            whether we want to prevent duplicated data to appear
     * @param order
     *            whether we want the terminals ordered by serial number and id
     * @return the resulting HQL
     */
    public String getHQL(List<Object> values, List<Type> types, Locale locale,
	    boolean distinct, boolean order, Date queryDate) {
	String hql = "select";
	if (distinct) {
	    hql += " distinct";
	}
	hql += " terminal from Terminal terminal";
	String terminalConstraints = getTerminalConstraints(values, types,
		locale);
	String bankCompanyConstraints = getBankCompanyConstraints();
	String financialDeviceConstraints = getFinancialDeviceConstraints(
		values, types, locale, queryDate);
	String hotfixConstraints = getHotfixConstraints(values, types, locale,
		queryDate);
	String internetExplorerConstraints = getInternetExplorerConstraints(
		values, types, locale, queryDate);
	String softwareConstraints = getSoftwareConstraints(values, types,
		locale, queryDate);
	String xfsSwConstraints = getXfsSwConstraints(values, types, locale,
		queryDate);
	String featSwConstraints = getFeatSwConstraints(values, types, locale,
		queryDate);
	String operatingSystemConstraints = getOperatingSystemConstraints(
		values, types, locale, queryDate);
	String hardwareDeviceConstraints = getHardwareDeviceConstraints(values,
		types, locale, queryDate);
	String xfsComponentConstraints = getXfsComponentConstraints(values,
		types, locale, queryDate);
	String jxfsComponentConstraints = getJxfsComponentConstraints(values,
		types, locale, queryDate);
	if ((financialDeviceConstraints.length() > 0)
		|| (xfsComponentConstraints.length() > 0)
		|| (jxfsComponentConstraints.length() > 0)) {
	    hql += " join terminal.financialDevices financialDevice";
	}
	if (xfsComponentConstraints.length() > 0) {
	    hql += " join financialDevice.xfsComponents xfsComponent";
	}
	if (jxfsComponentConstraints.length() > 0) {
	    hql += " join financialDevice.jxfsComponents jxfsComponent";
	}
	if (hotfixConstraints.length() > 0) {
	    hql += " join terminal.hotfixes hotfix";
	}
	if (internetExplorerConstraints.length() > 0) {
	    hql += " join terminal.auditableInternetExplorers auditableInternetExplorer "
		    + "join auditableInternetExplorer.internetExplorer internetExplorer";
	}
	if (operatingSystemConstraints.length() > 0) {
	    hql += " join terminal.configs softwareConfig join softwareConfig.operatingSystems operatingSystem";
	}

	hql += " where ";
	if (terminalConstraints.length() > 0) {
	    hql += "(" + terminalConstraints + ") and ";
	}
	if (bankCompanyConstraints.length() > 0) {
	    hql += "(" + bankCompanyConstraints + ") and ";
	}
	if (financialDeviceConstraints.length() > 0) {
	    hql += "(" + financialDeviceConstraints + ") and ";
	}
	if (xfsComponentConstraints.length() > 0) {
	    hql += "(" + xfsComponentConstraints + ") and ";
	}
	if (jxfsComponentConstraints.length() > 0) {
	    hql += "(" + jxfsComponentConstraints + ") and ";
	}
	if (hotfixConstraints.length() > 0) {
	    hql += "(" + hotfixConstraints + ") and ";
	}
	if (internetExplorerConstraints.length() > 0) {
	    hql += "(" + internetExplorerConstraints + ") and ";
	}
	if (softwareConstraints.length() > 0) {
	    hql += "(" + softwareConstraints + ") and ";
	}
	if (xfsSwConstraints.length() > 0) {
	    hql += "(" + xfsSwConstraints + ") and ";
	}
	if (featSwConstraints.length() > 0) {
	    hql += "(" + featSwConstraints + ") and ";
	}
	if (operatingSystemConstraints.length() > 0) {
	    hql += "(" + operatingSystemConstraints + ") and ";
	}
	if (hardwareDeviceConstraints.length() > 0) {
	    hql += "(" + hardwareDeviceConstraints + ") and ";
	}

	if (hql.endsWith(" and ")) {
	    hql = hql.substring(0, hql.length() - 5);
	}
	if (hql.endsWith(" where ")) {
	    hql = hql.substring(0, hql.length() - 7);
	}
	if (order) {
	    hql += " order by terminal.serialNumber, terminal.id";
	}
	return hql;
    }

    /**
     * Gets the locale.
     * 
     * @return the locale
     */
    public String getLocale() {
	return locale;
    }

    /**
     * Sets the locale.
     * 
     * @param locale
     *            the new locale
     */
    public void setLocale(String locale) {
	this.locale = locale;
    }

    /**
     * Gets the true locale.
     * 
     * @return the true locale
     */
    public Locale getTrueLocale() {
	if (locale != null) {
	    String[] localeSplit = locale.split("-");
	    if (localeSplit.length >= 2) {
		return new Locale(localeSplit[0], localeSplit[1]);
	    } else {
		if (localeSplit.length == 1) {
		    return new Locale(localeSplit[0]);
		}
	    }
	}
	return null;
    }

    /**
     * Sets the true locale.
     * 
     * @param locale
     *            the new true locale
     */
    public void setTrueLocale(Locale locale) {
	this.locale = locale.getLanguage() + "-" + locale.getCountry();
    }

    /**
     * Gets the scheduled updates.
     * 
     * @return the scheduled updates
     */
    public Set<ScheduledUpdate> getScheduledUpdates() {
	return scheduledUpdates;
    }

    /**
     * Sets the scheduled updates.
     * 
     * @param scheduledUpdates
     *            the new scheduled updates
     */
    public void setScheduledUpdates(Set<ScheduledUpdate> scheduledUpdates) {
	this.scheduledUpdates = scheduledUpdates;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
	if (o == null) {
	    return false;
	}
	if (o instanceof Query) {
	    Query otherQuery = (Query) o;
	    return ((otherQuery.getName().equals(getName())) && (otherQuery
		    .getUser().equals(getUser())));
	} else {
	    return false;
	}

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	return getName().hashCode() + 13 * getUser().hashCode();
    }

    /**
     * Gets the description.
     * 
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /**
     * Sets the description.
     * 
     * @param description
     *            the new description
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * Gets the creation date.
     * 
     * @return the creation date
     */
    public Date getCreationDate() {
	return creationDate;
    }

    /**
     * Sets the creation date.
     * 
     * @param creationDate
     *            the new creation date
     */
    public void setCreationDate(Date creationDate) {
	this.creationDate = creationDate;
    }

    /**
     * Gets the creation date short.
     * 
     * @return the creation date short
     */
    public String getCreationDateShort() {
	return (creationDate != null) ? DateFormat.getDateInstance(
		DateFormat.SHORT, Locale.getDefault()).format(creationDate)
		: "";
    }

    /**
     * Gets the xfs component combo11 value.
     * 
     * @return the xfs component combo11 value
     */
    public String getXfsComponentCombo11() {
	return xfsComponentCombo11;
    }

    /**
     * Sets the xfs component combo11 value.
     * 
     * @param xfsComponentCombo11
     *            the new xfs component combo11 value
     */
    public void setXfsComponentCombo11(String xfsComponentCombo11) {
	this.xfsComponentCombo11 = xfsComponentCombo11;
    }

    /**
     * Gets the xfs component combo12 value.
     * 
     * @return the xfs component combo12 value
     */
    public String getXfsComponentCombo12() {
	return xfsComponentCombo12;
    }

    /**
     * Sets the xfs component combo12 value.
     * 
     * @param xfsComponentCombo12
     *            the new xfs component combo12 value
     */
    public void setXfsComponentCombo12(String xfsComponentCombo12) {
	this.xfsComponentCombo12 = xfsComponentCombo12;
    }

    /**
     * Gets the xfs component checkbox1 value.
     * 
     * @return the xfs component checkbox1 value
     */
    public Boolean getXfsComponentCB1() {
	return xfsComponentCB1;
    }

    /**
     * Sets the xfs component checkbox1 value.
     * 
     * @param xfsComponentCB1
     *            the new xfs component checkbox1 value
     */
    public void setXfsComponentCB1(Boolean xfsComponentCB1) {
	this.xfsComponentCB1 = xfsComponentCB1;
    }

    /**
     * Gets the xfs component field1 value.
     * 
     * @return the xfs component field1 value
     */
    public String getXfsComponentField1() {
	return xfsComponentField1;
    }

    /**
     * Sets the xfs component field1 value.
     * 
     * @param xfsComponentField1
     *            the new xfs component field1 value
     */
    public void setXfsComponentField1(String xfsComponentField1) {
	this.xfsComponentField1 = xfsComponentField1;
    }

    /**
     * Gets the xfs component combo21 value.
     * 
     * @return the xfs component combo21 value
     */
    public String getXfsComponentCombo21() {
	return xfsComponentCombo21;
    }

    /**
     * Sets the xfs component combo21 value.
     * 
     * @param xfsComponentCombo21
     *            the new xfs component combo21 value
     */
    public void setXfsComponentCombo21(String xfsComponentCombo21) {
	this.xfsComponentCombo21 = xfsComponentCombo21;
    }

    /**
     * Gets the xfs component combo22 value.
     * 
     * @return the xfs component combo22 value
     */
    public String getXfsComponentCombo22() {
	return xfsComponentCombo22;
    }

    /**
     * Sets the xfs component combo22 value.
     * 
     * @param xfsComponentCombo22
     *            the new xfs component combo22 value
     */
    public void setXfsComponentCombo22(String xfsComponentCombo22) {
	this.xfsComponentCombo22 = xfsComponentCombo22;
    }

    /**
     * Gets the xfs component checkbox2 value.
     * 
     * @return the xfs component checkbox2 value
     */
    public Boolean getXfsComponentCB2() {
	return xfsComponentCB2;
    }

    /**
     * Sets the xfs component checkbox2 value.
     * 
     * @param xfsComponentCB2
     *            the new xfs component checkbox2 value
     */
    public void setXfsComponentCB2(Boolean xfsComponentCB2) {
	this.xfsComponentCB2 = xfsComponentCB2;
    }

    /**
     * Gets the xfs component field2 value.
     * 
     * @return the xfs component field2 value
     */
    public String getXfsComponentField2() {
	return xfsComponentField2;
    }

    /**
     * Sets the xfs component field2 value.
     * 
     * @param xfsComponentField2
     *            the new xfs component field2 value
     */
    public void setXfsComponentField2(String xfsComponentField2) {
	this.xfsComponentField2 = xfsComponentField2;
    }

    /**
     * Gets the xfs component combo31 value.
     * 
     * @return the xfs component combo31 value
     */
    public String getXfsComponentCombo31() {
	return xfsComponentCombo31;
    }

    /**
     * Sets the xfs component combo31 value.
     * 
     * @param xfsComponentCombo31
     *            the new xfs component combo31 value
     */
    public void setXfsComponentCombo31(String xfsComponentCombo31) {
	this.xfsComponentCombo31 = xfsComponentCombo31;
    }

    /**
     * Gets the xfs component combo32 value.
     * 
     * @return the xfs component combo32 value
     */
    public String getXfsComponentCombo32() {
	return xfsComponentCombo32;
    }

    /**
     * Sets the xfs component combo32 value.
     * 
     * @param xfsComponentCombo32
     *            the new xfs component combo32 value
     */
    public void setXfsComponentCombo32(String xfsComponentCombo32) {
	this.xfsComponentCombo32 = xfsComponentCombo32;
    }

    /**
     * Gets the xfs component checkbox3 value.
     * 
     * @return the xfs component checkbox3 value
     */
    public Boolean getXfsComponentCB3() {
	return xfsComponentCB3;
    }

    /**
     * Sets the xfs component checkbox3 value.
     * 
     * @param xfsComponentCB3
     *            the new xfs component checkbox3 value
     */
    public void setXfsComponentCB3(Boolean xfsComponentCB3) {
	this.xfsComponentCB3 = xfsComponentCB3;
    }

    /**
     * Gets the xfs component field3 value.
     * 
     * @return the xfs component field3 value
     */
    public String getXfsComponentField3() {
	return xfsComponentField3;
    }

    /**
     * Sets the xfs component field3 value.
     * 
     * @param xfsComponentField3
     *            the new xfs component field3 value
     */
    public void setXfsComponentField3(String xfsComponentField3) {
	this.xfsComponentField3 = xfsComponentField3;
    }

    /**
     * Gets the xfs component combo41 value.
     * 
     * @return the xfs component combo41 value
     */
    public String getXfsComponentCombo41() {
	return xfsComponentCombo41;
    }

    /**
     * Sets the xfs component combo41 value.
     * 
     * @param xfsComponentCombo41
     *            the new xfs component combo41 value
     */
    public void setXfsComponentCombo41(String xfsComponentCombo41) {
	this.xfsComponentCombo41 = xfsComponentCombo41;
    }

    /**
     * Gets the xfs component combo42 value.
     * 
     * @return the xfs component combo42 value
     */
    public String getXfsComponentCombo42() {
	return xfsComponentCombo42;
    }

    /**
     * Sets the xfs component combo42 value.
     * 
     * @param xfsComponentCombo42
     *            the new xfs component combo42 value
     */
    public void setXfsComponentCombo42(String xfsComponentCombo42) {
	this.xfsComponentCombo42 = xfsComponentCombo42;
    }

    /**
     * Gets the xfs component checkbox4 value.
     * 
     * @return the xfs component checkbox4 value
     */
    public Boolean getXfsComponentCB4() {
	return xfsComponentCB4;
    }

    /**
     * Sets the xfs component checkbox4 value.
     * 
     * @param xfsComponentCB4
     *            the new xfs component checkbox4 value
     */
    public void setXfsComponentCB4(Boolean xfsComponentCB4) {
	this.xfsComponentCB4 = xfsComponentCB4;
    }

    /**
     * Gets the xfs component field4 value.
     * 
     * @return the xfs component field4 value
     */
    public String getXfsComponentField4() {
	return xfsComponentField4;
    }

    /**
     * Sets the xfs component field4 value.
     * 
     * @param xfsComponentField4
     *            the new xfs component field4 value
     */
    public void setXfsComponentField4(String xfsComponentField4) {
	this.xfsComponentField4 = xfsComponentField4;
    }

    /**
     * Gets the xfs component combo51 value.
     * 
     * @return the xfs component combo51 value
     */
    public String getXfsComponentCombo51() {
	return xfsComponentCombo51;
    }

    /**
     * Sets the xfs component combo51 value.
     * 
     * @param xfsComponentCombo51
     *            the new xfs component combo51 value
     */
    public void setXfsComponentCombo51(String xfsComponentCombo51) {
	this.xfsComponentCombo51 = xfsComponentCombo51;
    }

    /**
     * Gets the xfs component combo52 value.
     * 
     * @return the xfs component combo52 value
     */
    public String getXfsComponentCombo52() {
	return xfsComponentCombo52;
    }

    /**
     * Sets the xfs component combo52 value.
     * 
     * @param xfsComponentCombo52
     *            the new xfs component combo52 value
     */
    public void setXfsComponentCombo52(String xfsComponentCombo52) {
	this.xfsComponentCombo52 = xfsComponentCombo52;
    }

    /**
     * Gets the xfs component checkbox5 value.
     * 
     * @return the xfs component checkbox5 value
     */
    public Boolean getXfsComponentCB5() {
	return xfsComponentCB5;
    }

    /**
     * Sets the xfs component checkbox5 value.
     * 
     * @param xfsComponentCB5
     *            the new xfs component checkbox5 value
     */
    public void setXfsComponentCB5(Boolean xfsComponentCB5) {
	this.xfsComponentCB5 = xfsComponentCB5;
    }

    /**
     * Gets the xfs component field5 value.
     * 
     * @return the xfs component field5 value
     */
    public String getXfsComponentField5() {
	return xfsComponentField5;
    }

    /**
     * Sets the xfs component field5 value.
     * 
     * @param xfsComponentField5
     *            the new xfs component field5 value
     */
    public void setXfsComponentField5(String xfsComponentField5) {
	this.xfsComponentField5 = xfsComponentField5;
    }

    /**
     * Gets the jxfs component combo11 value.
     * 
     * @return the jxfs component combo11 value
     */
    public String getJxfsComponentCombo11() {
	return jxfsComponentCombo11;
    }

    /**
     * Sets the jxfs component combo11 value.
     * 
     * @param jxfsComponentCombo11
     *            the new jxfs component combo11 value
     */
    public void setJxfsComponentCombo11(String jxfsComponentCombo11) {
	this.jxfsComponentCombo11 = jxfsComponentCombo11;
    }

    /**
     * Gets the jxfs component combo12 value.
     * 
     * @return the jxfs component combo12 value
     */
    public String getJxfsComponentCombo12() {
	return jxfsComponentCombo12;
    }

    /**
     * Sets the jxfs component combo12 value.
     * 
     * @param jxfsComponentCombo12
     *            the new jxfs component combo12 value
     */
    public void setJxfsComponentCombo12(String jxfsComponentCombo12) {
	this.jxfsComponentCombo12 = jxfsComponentCombo12;
    }

    /**
     * Gets the jxfs component checkbox1 value.
     * 
     * @return the jxfs component checkbox1 value
     */
    public Boolean getJxfsComponentCB1() {
	return jxfsComponentCB1;
    }

    /**
     * Sets the jxfs component checkbox1 value.
     * 
     * @param jxfsComponentCB1
     *            the new jxfs component checkbox1 value
     */
    public void setJxfsComponentCB1(Boolean jxfsComponentCB1) {
	this.jxfsComponentCB1 = jxfsComponentCB1;
    }

    /**
     * Gets the jxfs component field1 value.
     * 
     * @return the jxfs component field1 value
     */
    public String getJxfsComponentField1() {
	return jxfsComponentField1;
    }

    /**
     * Sets the jxfs component field1 value.
     * 
     * @param jxfsComponentField1
     *            the new jxfs component field1 value
     */
    public void setJxfsComponentField1(String jxfsComponentField1) {
	this.jxfsComponentField1 = jxfsComponentField1;
    }

    /**
     * Gets the jxfs component combo21 value.
     * 
     * @return the jxfs component combo21 value
     */
    public String getJxfsComponentCombo21() {
	return jxfsComponentCombo21;
    }

    /**
     * Sets the jxfs component combo21 value.
     * 
     * @param jxfsComponentCombo21
     *            the new jxfs component combo21 value
     */
    public void setJxfsComponentCombo21(String jxfsComponentCombo21) {
	this.jxfsComponentCombo21 = jxfsComponentCombo21;
    }

    /**
     * Gets the jxfs component combo22 value.
     * 
     * @return the jxfs component combo22 value
     */
    public String getJxfsComponentCombo22() {
	return jxfsComponentCombo22;
    }

    /**
     * Sets the jxfs component combo22 value.
     * 
     * @param jxfsComponentCombo22
     *            the new jxfs component combo22 value
     */
    public void setJxfsComponentCombo22(String jxfsComponentCombo22) {
	this.jxfsComponentCombo22 = jxfsComponentCombo22;
    }

    /**
     * Gets the jxfs component checkbox2 value.
     * 
     * @return the jxfs component checkbox2 value
     */
    public Boolean getJxfsComponentCB2() {
	return jxfsComponentCB2;
    }

    /**
     * Sets the jxfs component checkbox2 value.
     * 
     * @param jxfsComponentCB2
     *            the new jxfs component checkbox2 value
     */
    public void setJxfsComponentCB2(Boolean jxfsComponentCB2) {
	this.jxfsComponentCB2 = jxfsComponentCB2;
    }

    /**
     * Gets the jxfs component field2 value.
     * 
     * @return the jxfs component field2 value
     */
    public String getJxfsComponentField2() {
	return jxfsComponentField2;
    }

    /**
     * Sets the jxfs component field2 value.
     * 
     * @param jxfsComponentField2
     *            the new jxfs component field2 value
     */
    public void setJxfsComponentField2(String jxfsComponentField2) {
	this.jxfsComponentField2 = jxfsComponentField2;
    }

    /**
     * Gets the jxfs component combo31 value.
     * 
     * @return the jxfs component combo31 value
     */
    public String getJxfsComponentCombo31() {
	return jxfsComponentCombo31;
    }

    /**
     * Sets the jxfs component combo31 value.
     * 
     * @param jxfsComponentCombo31
     *            the new jxfs component combo31 value
     */
    public void setJxfsComponentCombo31(String jxfsComponentCombo31) {
	this.jxfsComponentCombo31 = jxfsComponentCombo31;
    }

    /**
     * Gets the jxfs component combo32 value.
     * 
     * @return the jxfs component combo32 value
     */
    public String getJxfsComponentCombo32() {
	return jxfsComponentCombo32;
    }

    /**
     * Sets the jxfs component combo32 value.
     * 
     * @param jxfsComponentCombo32
     *            the new jxfs component combo32 value
     */
    public void setJxfsComponentCombo32(String jxfsComponentCombo32) {
	this.jxfsComponentCombo32 = jxfsComponentCombo32;
    }

    /**
     * Gets the jxfs component checkbox3 value.
     * 
     * @return the jxfs component checkbox3 value
     */
    public Boolean getJxfsComponentCB3() {
	return jxfsComponentCB3;
    }

    /**
     * Sets the jxfs component checkbox3 value.
     * 
     * @param jxfsComponentCB3
     *            the new jxfs component checkbox3 value
     */
    public void setJxfsComponentCB3(Boolean jxfsComponentCB3) {
	this.jxfsComponentCB3 = jxfsComponentCB3;
    }

    /**
     * Gets the jxfs component field3 value.
     * 
     * @return the jxfs component field3 value
     */
    public String getJxfsComponentField3() {
	return jxfsComponentField3;
    }

    /**
     * Sets the jxfs component field3 value.
     * 
     * @param jxfsComponentField3
     *            the new jxfs component field3 value
     */
    public void setJxfsComponentField3(String jxfsComponentField3) {
	this.jxfsComponentField3 = jxfsComponentField3;
    }

    /**
     * Gets the jxfs component combo41 value.
     * 
     * @return the jxfs component combo41 value
     */
    public String getJxfsComponentCombo41() {
	return jxfsComponentCombo41;
    }

    /**
     * Sets the jxfs component combo41 value.
     * 
     * @param jxfsComponentCombo41
     *            the new jxfs component combo41 value
     */
    public void setJxfsComponentCombo41(String jxfsComponentCombo41) {
	this.jxfsComponentCombo41 = jxfsComponentCombo41;
    }

    /**
     * Gets the jxfs component combo42 value.
     * 
     * @return the jxfs component combo42 value
     */
    public String getJxfsComponentCombo42() {
	return jxfsComponentCombo42;
    }

    /**
     * Sets the jxfs component combo42 value.
     * 
     * @param jxfsComponentCombo42
     *            the new jxfs component combo42 value
     */
    public void setJxfsComponentCombo42(String jxfsComponentCombo42) {
	this.jxfsComponentCombo42 = jxfsComponentCombo42;
    }

    /**
     * Gets the jxfs component checkbox4 value.
     * 
     * @return the jxfs component checkbox4 value
     */
    public Boolean getJxfsComponentCB4() {
	return jxfsComponentCB4;
    }

    /**
     * Sets the jxfs component checkbox4 value.
     * 
     * @param jxfsComponentCB4
     *            the new jxfs component checkbox4 value
     */
    public void setJxfsComponentCB4(Boolean jxfsComponentCB4) {
	this.jxfsComponentCB4 = jxfsComponentCB4;
    }

    /**
     * Gets the jxfs component field4 value.
     * 
     * @return the jxfs component field4 value
     */
    public String getJxfsComponentField4() {
	return jxfsComponentField4;
    }

    /**
     * Sets the jxfs component field4 value.
     * 
     * @param jxfsComponentField4
     *            the new jxfs component field4 value
     */
    public void setJxfsComponentField4(String jxfsComponentField4) {
	this.jxfsComponentField4 = jxfsComponentField4;
    }

    /**
     * Gets the jxfs component combo51 value.
     * 
     * @return the jxfs component combo51 value
     */
    public String getJxfsComponentCombo51() {
	return jxfsComponentCombo51;
    }

    /**
     * Sets the jxfs component combo51 value.
     * 
     * @param jxfsComponentCombo51
     *            the new jxfs component combo51 value
     */
    public void setJxfsComponentCombo51(String jxfsComponentCombo51) {
	this.jxfsComponentCombo51 = jxfsComponentCombo51;
    }

    /**
     * Gets the jxfs component combo52 value.
     * 
     * @return the jxfs component combo52 value
     */
    public String getJxfsComponentCombo52() {
	return jxfsComponentCombo52;
    }

    /**
     * Sets the jxfs component combo52 value.
     * 
     * @param jxfsComponentCombo52
     *            the new jxfs component combo52 value
     */
    public void setJxfsComponentCombo52(String jxfsComponentCombo52) {
	this.jxfsComponentCombo52 = jxfsComponentCombo52;
    }

    /**
     * Gets the jxfs component checkbox5 value.
     * 
     * @return the jxfs component checkbox5 value
     */
    public Boolean getJxfsComponentCB5() {
	return jxfsComponentCB5;
    }

    /**
     * Sets the jxfs component checkbox5 value.
     * 
     * @param jxfsComponentCB5
     *            the new jxfs component checkbox5 value
     */
    public void setJxfsComponentCB5(Boolean jxfsComponentCB5) {
	this.jxfsComponentCB5 = jxfsComponentCB5;
    }

    /**
     * Gets the jxfs component field5 value.
     * 
     * @return the jxfs component field5 value
     */
    public String getJxfsComponentField5() {
	return jxfsComponentField5;
    }

    /**
     * Sets the jxfs component field5 value.
     * 
     * @param jxfsComponentField5
     *            the new jxfs component field5 value
     */
    public void setJxfsComponentField5(String jxfsComponentField5) {
	this.jxfsComponentField5 = jxfsComponentField5;
    }

}
