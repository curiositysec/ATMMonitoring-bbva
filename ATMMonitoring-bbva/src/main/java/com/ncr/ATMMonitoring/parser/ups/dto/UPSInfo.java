package com.ncr.ATMMonitoring.parser.ups.dto;

import java.util.Date;

/**
 * DTO that holds the basic information retrieved from an UPS XML
 * 
 * @author Otto Abreu
 * 
 */
public class UPSInfo {

    /** The ip. */
    private String ip;

    /** The firmware version. */
    private String firmware;

    /** The running status. */
    private String runningStatus;

    /** The charge percentage. */
    private Float chargePercentage;

    /** The expense percentage. */
    private Float expensePercentage;

    /** The alarm message. */
    private String alarmMsg;

    /** The type. */
    private String type;

    /** The model. */
    private String model;

    /** The serial number. */
    private String seriesNumber;

    /** The running time in millisecs. */
    private Long runningTimeMillisec;

    /** The autonomy in millisecs. */
    private Long autonomyMillisec;

    /** The position number. */
    private String numPosition;

    /** The aud fmo. */
    private Date audFmo;

    /** The general status message. */
    private String generalStatusMsg;

    /** The last execution date. */
    private Date lastExecutionDate;

    /** The original xml. */
    private String originalXML;

    /** The class with the additional info. */
    private UPSExtraInfo extraInfo;

    /**
     * Getter method for ip
     * 
     * @return the ip
     */
    public String getIp() {
	return ip;
    }

    /**
     * Setter method for the ip
     * 
     * @param ip
     *            the ip to set
     */
    public void setIp(String ip) {
	this.ip = ip;
    }

    /**
     * Getter method for firmware
     * 
     * @return the firmware
     */
    public String getFirmware() {
	return firmware;
    }

    /**
     * Setter method for the firmware
     * 
     * @param firmware
     *            the firmware to set
     */
    public void setFirmware(String firmware) {
	this.firmware = firmware;
    }

    /**
     * Getter method for runningStatus
     * 
     * @return the runningStatus
     */
    public String getRunningStatus() {
	return runningStatus;
    }

    /**
     * Setter method for the runningStatus
     * 
     * @param runningStatus
     *            the runningStatus to set
     */
    public void setRunningStatus(String runningStatus) {
	this.runningStatus = runningStatus;
    }

    /**
     * Getter method for chargePercentage
     * 
     * @return the chargePercentage
     */
    public float getChargePercentage() {
	return chargePercentage;
    }

    /**
     * Setter method for the chargePercentage
     * 
     * @param chargePercentage
     *            the chargePercentage to set
     */
    public void setChargePercentage(float chargePercentage) {
	this.chargePercentage = chargePercentage;
    }

    /**
     * Getter method for expensePercentage
     * 
     * @return the expensePercentage
     */
    public float getExpensePercentage() {
	return expensePercentage;
    }

    /**
     * Setter method for the expensePercentage
     * 
     * @param expensePercentage
     *            the expensePercentage to set
     */
    public void setExpensePercentage(float expensePercentage) {
	this.expensePercentage = expensePercentage;
    }

    /**
     * Getter method for alarmMsg
     * 
     * @return the alarmMsg
     */
    public String getAlarmMsg() {
	return alarmMsg;
    }

    /**
     * Setter method for the alarmMsg
     * 
     * @param alarmMsg
     *            the alarmMsg to set
     */
    public void setAlarmMsg(String alarmMsg) {
	this.alarmMsg = alarmMsg;
    }

    /**
     * Getter method for ups type
     * 
     * @return the ups type
     */
    public String getType() {
	return type;
    }

    /**
     * Setter method for the ups type
     * 
     * @param type
     *            the ups type to set
     */
    public void setType(String type) {
	this.type = type;
    }

    /**
     * Getter method for ups model
     * 
     * @return the ups model
     */
    public String getModel() {
	return model;
    }

    /**
     * Setter method for the ups model
     * 
     * @param model
     *            the upsModel to set
     */
    public void setModel(String model) {
	this.model = model;
    }

    /**
     * Getter method for seriesNumber
     * 
     * @return the seriesNumber
     */
    public String getSeriesNumber() {
	return seriesNumber;
    }

    /**
     * Setter method for the seriesNumber
     * 
     * @param seriesNumber
     *            the seriesNumber to set
     */
    public void setSeriesNumber(String seriesNumber) {
	this.seriesNumber = seriesNumber;
    }

    /**
     * Getter method for runningTimeMillisec
     * 
     * @return the runningTimeMillisec
     */
    public long getRunningTimeMillisec() {
	return runningTimeMillisec;
    }

    /**
     * Setter method for the runningTimeMillisec
     * 
     * @param runningTimeMillisec
     *            the runningTimeMillisec to set
     */
    public void setRunningTimeMillisec(long runningTimeMillisec) {
	this.runningTimeMillisec = runningTimeMillisec;
    }

    /**
     * Getter method for autonomyMillisec
     * 
     * @return the autonomyMillisec
     */
    public long getAutonomyMillisec() {
	return autonomyMillisec;
    }

    /**
     * Setter method for the autonomyMillisec
     * 
     * @param autonomyMillisec
     *            the autonomyMillisec to set
     */
    public void setAutonomyMillisec(long autonomyMillisec) {
	this.autonomyMillisec = autonomyMillisec;
    }

    /**
     * Getter method for numPosition
     * 
     * @return the numPosition
     */
    public String getNumPosition() {
	return numPosition;
    }

    /**
     * Setter method for the numPosition
     * 
     * @param numPosition
     *            the numPosition to set
     */
    public void setNumPosition(String numPosition) {
	this.numPosition = numPosition;
    }

    /**
     * Getter method for audFmo
     * 
     * @return the audFmo
     */
    public Date getAudFmo() {
	return audFmo;
    }

    /**
     * Setter method for the audFmo
     * 
     * @param audFmo
     *            the audFmo to set
     */
    public void setAudFmo(Date audFmo) {
	this.audFmo = audFmo;
    }

    /**
     * Getter method for generalStatusMsg
     * 
     * @return the generalStatusMsg
     */
    public String getGeneralStatusMsg() {
	return generalStatusMsg;
    }

    /**
     * Setter method for the generalStatusMsg
     * 
     * @param generalStatusMsg
     *            the generalStatusMsg to set
     */
    public void setGeneralStatusMsg(String generalStatusMsg) {
	this.generalStatusMsg = generalStatusMsg;
    }

    /**
     * Getter method for lastExecutionDate
     * 
     * @return the lastExecutionDate
     */
    public Date getLastExecutionDate() {
	return lastExecutionDate;
    }

    /**
     * Setter method for the lastExecutionDate
     * 
     * @param lastExecutionDate
     *            the lastExecutionDate to set
     */
    public void setLastExecutionDate(Date lastExecutionDate) {
	this.lastExecutionDate = lastExecutionDate;
    }

    /**
     * Getter method for originalXML
     * 
     * @return the originalXML
     */
    public String getOriginalXML() {
	return originalXML;
    }

    /**
     * Setter method for the originalXML
     * 
     * @param originalXML
     *            the originalXML to set
     */
    public void setOriginalXML(String originalXML) {
	this.originalXML = originalXML;
    }

    /**
     * Getter method for extraInfo
     * 
     * @return the extraInfo
     */
    public UPSExtraInfo getExtraInfo() {
	return extraInfo;
    }

    /**
     * Setter method for the extraInfo
     * 
     * @param extraInfo
     *            the extraInfo to set
     */
    public void setExtraInfo(UPSExtraInfo extraInfo) {
	this.extraInfo = extraInfo;
    }

    @Override
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {
	StringBuffer sb = new StringBuffer("[");
	sb.append("| ip= " + this.ip);
	sb.append("| firmware= " + this.firmware);
	sb.append("| runningStatus= " + this.runningStatus);
	sb.append("| chargePercentage= " + this.chargePercentage);
	sb.append("| expensePercentage= " + this.expensePercentage);
	sb.append("| alarmMsg= " + this.alarmMsg);
	sb.append("| upsType= " + this.type);
	sb.append("| upsModel= " + this.model);
	sb.append("| seriesNumber= " + this.seriesNumber);
	sb.append("| runningTimeMilisec= " + this.runningTimeMillisec);
	sb.append("| autonomyMilisec= " + this.autonomyMillisec);
	sb.append("| numPosition= " + this.numPosition);
	sb.append("| audFmo= " + this.audFmo);
	sb.append("| generalStatusMsg= " + this.generalStatusMsg);
	sb.append("| lastExecutionDate= " + this.lastExecutionDate);
	sb.append("| originalXML= " + this.originalXML);
	sb.append("| extraInfo= " + this.extraInfo);
	sb.append(" ]");
	return sb.toString();
    }

}
