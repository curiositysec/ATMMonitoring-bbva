<%@tag description="Hardware Details" pageEncoding="UTF-8"%>
<%@attribute name="hardwareDevice" required="true" type="com.ncr.ATMMonitoring.pojo.HardwareDevice"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<div class="margin-box">
<div class="box">
<h3>${hardwareDevice.name} (<spring:message code="label.hardwareDevice.${hardwareDevice.hardwareClass}"/>)</h3>
<div class="margin-box">
<table class="form-disabled-generic subform link">
<c:if test="${hardwareDevice.manufacturer != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.manufacturer"/></label></i></td>
    <td><label>${hardwareDevice.manufacturer}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.model != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.model"/></label></i></td>
    <td><label>${hardwareDevice.model}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.numberOfProcessors != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.numberOfProcessors"/></label></i></td>
    <td><label>${hardwareDevice.numberOfProcessors}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.caption != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.caption"/></label></i></td>
    <td><label>${hardwareDevice.caption}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.totalPhysicalMemory != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.totalPhysicalMemory"/></label></i></td>
    <td><label>${hardwareDevice.totalPhysicalMemory}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.description != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.description"/></label></i></td>
    <td><label>${hardwareDevice.description}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.currentTimeZone != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.currentTimeZone"/></label></i></td>
    <td><label>${hardwareDevice.currentTimeZone}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.daylightInEffect != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.daylightInEffect"/></label></i></td>
    <td><label>${hardwareDevice.daylightInEffect}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.domain != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.domain"/></label></i></td>
    <td><label>${hardwareDevice.domain}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.workgroup != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.workgroup"/></label></i></td>
    <td><label>${hardwareDevice.workgroup}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.status != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.status"/></label></i></td>
    <td><label>${hardwareDevice.status}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.product != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.product"/></label></i></td>
    <td><label>${hardwareDevice.product}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.architecture != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.architecture"/></label></i></td>
    <td><label>${hardwareDevice.architecture}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.addressWidth != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.addressWidth"/></label></i></td>
    <td><label>${hardwareDevice.addressWidth}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.dataWidth != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.dataWidth"/></label></i></td>
    <td><label>${hardwareDevice.dataWidth}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.currentClockSpeed != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.currentClockSpeed"/></label></i></td>
    <td><label>${hardwareDevice.currentClockSpeed}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.extClock != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.extClock"/></label></i></td>
    <td><label>${hardwareDevice.extClock}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.stepping != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.stepping"/></label></i></td>
    <td><label>${hardwareDevice.stepping}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.capacity != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.capacity"/></label></i></td>
    <td><label>${hardwareDevice.capacity}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.speed != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.speed"/></label></i></td>
    <td><label>${hardwareDevice.speed}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.partitions != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.partitions"/></label></i></td>
    <td><label>${hardwareDevice.partitions}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.size != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.size"/></label></i></td>
    <td><label>${hardwareDevice.size}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.freeSpace != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.freeSpace"/></label></i></td>
    <td><label>${hardwareDevice.freeSpace}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.fileSystem != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.fileSystem"/></label></i></td>
    <td><label>${hardwareDevice.fileSystem}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.version != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.version"/></label></i></td>
    <td><label>${hardwareDevice.version}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.adapterType != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.adapterType"/></label></i></td>
    <td><label>${hardwareDevice.adapterType}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.dhcpEnabled != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.dhcpEnabled"/></label></i></td>
    <td><label>${hardwareDevice.dhcpEnabled}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.dhcpServer != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.dhcpServer"/></label></i></td>
    <td><label>${hardwareDevice.dhcpServer}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.ipAddress != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.ipAddress"/></label></i></td>
    <td><label>${hardwareDevice.ipAddress}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.ipSubnet != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.ipSubnet"/></label></i></td>
    <td><label>${hardwareDevice.ipSubnet}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.defaultIpGateway != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.defaultIpGateway"/></label></i></td>
    <td><label>${hardwareDevice.defaultIpGateway}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.macAddress != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.macAddress"/></label></i></td>
    <td><label>${hardwareDevice.macAddress}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.netConnectionId != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.netConnectionId"/></label></i></td>
    <td><label>${hardwareDevice.netConnectionId}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.netConnectionStatus != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.netConnectionStatus"/></label></i></td>
    <td><label>${hardwareDevice.netConnectionStatus}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.maxBaudRate != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.maxBaudRate"/></label></i></td>
    <td><label>${hardwareDevice.maxBaudRate}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.displayType != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.displayType"/></label></i></td>
    <td><label>${hardwareDevice.displayType}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.monitorManufacturer != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.monitorManufacturer"/></label></i></td>
    <td><label>${hardwareDevice.monitorManufacturer}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.monitorType != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.monitorType"/></label></i></td>
    <td><label>${hardwareDevice.monitorType}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.pixelsPerXLogicalInch != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.pixelsPerXLogicalInch"/></label></i></td>
    <td><label>${hardwareDevice.pixelsPerXLogicalInch}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.pixelsPerYLogicalInch != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.pixelsPerYLogicalInch"/></label></i></td>
    <td><label>${hardwareDevice.pixelsPerYLogicalInch}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.layout != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.layout"/></label></i></td>
    <td><label>${hardwareDevice.layout}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.hardwareType != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.hardwareType"/></label></i></td>
    <td><label>${hardwareDevice.hardwareType}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.pointingType != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.pointingType"/></label></i></td>
    <td><label>${hardwareDevice.pointingType}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.currentUsage != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.currentUsage"/></label></i></td>
    <td><label>${hardwareDevice.currentUsage}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.serialNumber != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.serialNumber"/></label></i></td>
    <td><label>${hardwareDevice.serialNumber}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.slotDesignation != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.slotDesignation"/></label></i></td>
    <td><label>${hardwareDevice.slotDesignation}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.tag != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.tag"/></label></i></td>
    <td><label>${hardwareDevice.tag}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.smbiosVersion != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.smbiosVersion"/></label></i></td>
    <td><label>${hardwareDevice.smbiosVersion}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.smbiosMajorVersion != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.smbiosMajorVersion"/></label></i></td>
    <td><label>${hardwareDevice.smbiosMajorVersion}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.smbiosMinorVersion != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.smbiosMinorVersion"/></label></i></td>
    <td><label>${hardwareDevice.smbiosMinorVersion}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.currentLanguage != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.currentLanguage"/></label></i></td>
    <td><label>${hardwareDevice.currentLanguage}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.primaryBios != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.primaryBios"/></label></i></td>
    <td><label>${hardwareDevice.primaryBios}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.releaseDate != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.releaseDate"/></label></i></td>
    <td><label>${hardwareDevice.releaseDate}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.smbiosPresent != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.smbiosPresent"/></label></i></td>
    <td><label>${hardwareDevice.smbiosPresent}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.currentVerticalResolution != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.currentVerticalResolution"/></label></i></td>
    <td><label>${hardwareDevice.currentVerticalResolution}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.currentHorizontalResolution != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.currentHorizontalResolution"/></label></i></td>
    <td><label>${hardwareDevice.currentHorizontalResolution}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.currentRefreshRate != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.currentRefreshRate"/></label></i></td>
    <td><label>${hardwareDevice.currentRefreshRate}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.verticalRes != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.verticalRes"/></label></i></td>
    <td><label>${hardwareDevice.verticalRes}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.horizontalRes != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.horizontalRes"/></label></i></td>
    <td><label>${hardwareDevice.horizontalRes}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.refreshRate != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.refreshRate"/></label></i></td>
    <td><label>${hardwareDevice.refreshRate}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.numberOfPorts != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.numberOfPorts"/></label></i></td>
    <td><label>${hardwareDevice.numberOfPorts}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.protocolCode != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.protocolCode"/></label></i></td>
    <td><label>${hardwareDevice.protocolCode}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.usbVersion != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.usbMajorVersion"/></label></i></td>
    <td><label>${hardwareDevice.usbVersion}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.videoMemory != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.videoMemory"/></label></i></td>
    <td><label>${hardwareDevice.videoMemory}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.maxClockSpeed != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.maxClockSpeed"/></label></i></td>
    <td><label>${hardwareDevice.maxClockSpeed}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.mediaType != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.mediaType"/></label></i></td>
    <td><label>${hardwareDevice.mediaType}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.firmwareRevision != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.firmwareRevision"/></label></i></td>
    <td><label>${hardwareDevice.firmwareRevision}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.hardwareVersion != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.hardwareMajorVersion"/></label></i></td>
    <td><label>${hardwareDevice.hardwareVersion}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.maxMediaSize != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.maxMediaSize"/></label></i></td>
    <td><label>${hardwareDevice.maxMediaSize}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.totalCylinders != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.totalCylinders"/></label></i></td>
    <td><label>${hardwareDevice.totalCylinders}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.statusInfo != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.statusInfo"/></label></i></td>
    <td><label>${hardwareDevice.statusInfo}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.tracksPerCylinder != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.tracksPerCylinder"/></label></i></td>
    <td><label>${hardwareDevice.tracksPerCylinder}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.videoProcessor != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.videoProcessor"/></label></i></td>
    <td><label>${hardwareDevice.videoProcessor}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.sectorsPerTrack != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.sectorsPerTrack"/></label></i></td>
    <td><label>${hardwareDevice.sectorsPerTrack}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.bytesPerSector != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.bytesPerSector"/></label></i></td>
    <td><label>${hardwareDevice.bytesPerSector}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.adapterRam != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.adapterRam"/></label></i></td>
    <td><label>${hardwareDevice.adapterRam}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.volumeSerialNumber != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.volumeSerialNumber"/></label></i></td>
    <td><label>${hardwareDevice.volumeSerialNumber}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.currentNumberOfColors != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.currentNumberOfColors"/></label></i></td>
    <td><label>${hardwareDevice.currentNumberOfColors}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.currentBitsPerPixel != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.currentBitsPerPixel"/></label></i></td>
    <td><label>${hardwareDevice.currentBitsPerPixel}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.bitsPerPixel != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.bitsPerPixel"/></label></i></td>
    <td><label>${hardwareDevice.bitsPerPixel}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.colors != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.colors"/></label></i></td>
    <td><label>${hardwareDevice.colors}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.interfaceIndex != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.interfaceIndex"/></label></i></td>
    <td><label>${hardwareDevice.interfaceIndex}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.driverName != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.driverName"/></label></i></td>
    <td><label>${hardwareDevice.driverName}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.volumeName != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.volumeName"/></label></i></td>
    <td><label>${hardwareDevice.volumeName}</label></td>
</tr>
</c:if>
<c:if test="${hardwareDevice.protocolSupported != null}">
<tr>
    <td class="header"><i><label><spring:message code="label.hardwareDevice.protocolSupported"/></label></i></td>
    <td><label>${hardwareDevice.protocolSupported}</label></td>
</tr>
</c:if>
</table>
</div>
</div>
</div>