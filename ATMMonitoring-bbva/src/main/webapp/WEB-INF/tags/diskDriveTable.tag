<%@tag description="Disk Drive Table" pageEncoding="UTF-8"%>
<%@attribute name="hardwareDevices" required="true" type="java.util.Set"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3 class="txt content_hide"><spring:message code="label.diskDrives"/></h3>

<div class="margin-box collapsible hide">

<table class="data subform link">
<tr>	
	<th><spring:message code="label.hardwareDevice.name"/></th>
	<th><spring:message code="label.hardwareDevice.manufacturer"/></th>
	<th><spring:message code="label.hardwareDevice.model"/></th>
	<th><spring:message code="label.hardwareDevice.caption"/></th>
	<th><spring:message code="label.hardwareDevice.partitions"/></th>
	<th><spring:message code="label.hardwareDevice.size"/></th>
	<th><spring:message code="label.hardwareDevice.status"/></th>
<%--
	<th><spring:message code="label.hardwareDevice.description"/></th>
	<th><spring:message code="label.hardwareDevice.deviceId"/></th>
	<th><spring:message code="label.hardwareDevice.firmwareRevision"/></th>
	<th><spring:message code="label.hardwareDevice.serialNumber"/></th>
	<th><spring:message code="label.hardwareDevice.mediaType"/></th>
	<th><spring:message code="label.hardwareDevice.maxMediaSize"/></th>
	<th><spring:message code="label.hardwareDevice.totalCylinders"/></th>
	<th><spring:message code="label.hardwareDevice.tracksPerCylinder"/></th>
	<th><spring:message code="label.hardwareDevice.sectorsPerTrack"/></th>
	<th><spring:message code="label.hardwareDevice.bytesPerSector"/></th>
	<th><spring:message code="label.hardwareDevice.signature"/></th>
--%>
	<th><div class="add"><span>Ver más información</span></div></th>
</tr>
<c:forEach items="${hardwareDevices}" var="hardwareDevice">
    <tr class="showdetail open" >
		<c:if test="${hardwareDevice.name != null}">
			<td>${hardwareDevice.name}</td>
		</c:if>
		<c:if test="${hardwareDevice.name == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.manufacturer != null}">
			<td>${hardwareDevice.manufacturer}</td>
		</c:if>
		<c:if test="${hardwareDevice.manufacturer == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.model != null}">
			<td>${hardwareDevice.model}</td>
		</c:if>
		<c:if test="${hardwareDevice.model == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.caption != null}">
			<td>${hardwareDevice.caption}</td>
		</c:if>
		<c:if test="${hardwareDevice.caption == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.partitions != null}">
			<td>${hardwareDevice.partitions}</td>
		</c:if>
		<c:if test="${hardwareDevice.partitions == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.size != null}">
			<td>${hardwareDevice.size}</td>
		</c:if>
		<c:if test="${hardwareDevice.size == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.status != null}">
			<td>${hardwareDevice.status}</td>
		</c:if>
		<c:if test="${hardwareDevice.status == null}">
			<td/>
		</c:if>
<%--
		<c:if test="${hardwareDevice.description != null}">
			<td>${hardwareDevice.description}</td>
		</c:if>
		<c:if test="${hardwareDevice.description == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.deviceId != null}">
			<td>${hardwareDevice.deviceId}</td>
		</c:if>
		<c:if test="${hardwareDevice.deviceId == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.firmwareRevision != null}">
			<td>${hardwareDevice.firmwareRevision}</td>
		</c:if>
		<c:if test="${hardwareDevice.firmwareRevision == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.serialNumber != null}">
			<td>${hardwareDevice.serialNumber}</td>
		</c:if>
		<c:if test="${hardwareDevice.serialNumber == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.mediaType != null}">
			<td>${hardwareDevice.mediaType}</td>
		</c:if>
		<c:if test="${hardwareDevice.mediaType == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.maxMediaSize != null}">
			<td>${hardwareDevice.maxMediaSize}</td>
		</c:if>
		<c:if test="${hardwareDevice.maxMediaSize == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.totalCylinders != null}">
			<td>${hardwareDevice.totalCylinders}</td>
		</c:if>
		<c:if test="${hardwareDevice.totalCylinders == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.tracksPerCylinder != null}">
			<td>${hardwareDevice.tracksPerCylinder}</td>
		</c:if>
		<c:if test="${hardwareDevice.tracksPerCylinder == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.sectorsPerTrack != null}">
			<td>${hardwareDevice.sectorsPerTrack}</td>
		</c:if>
		<c:if test="${hardwareDevice.sectorsPerTrack == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.bytesPerSector != null}">
			<td>${hardwareDevice.bytesPerSector}</td>
		</c:if>
		<c:if test="${hardwareDevice.bytesPerSector == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.signature != null}">
			<td>${hardwareDevice.signature}</td>
		</c:if>
		<c:if test="${hardwareDevice.signature == null}">
			<td/>
		</c:if>
--%>
	<td><div class="add"><span>Ver más información</span></div></td>
    </tr>

 <tr class="detail">
    <td colspan="8">
        <ul>
		<li><strong><spring:message code="label.hardwareDevice.name"/>:</strong>${(hardwareDevice.name != null)? hardwareDevice.name : ''}</li>
		<li><strong><spring:message code="label.hardwareDevice.manufacturer"/>:</strong>${(hardwareDevice.manufacturer != null) ? hardwareDevice.manufacturer: ''}</li>
		<li><strong><spring:message code="label.hardwareDevice.model"/>:</strong>${(hardwareDevice.model != null) ? hardwareDevice.model : ''}</li>
		<li><strong><spring:message code="label.hardwareDevice.caption"/>:</strong>${(hardwareDevice.caption != null ) ? hardwareDevice.caption : ''}</li>
		<li><strong><spring:message code="label.hardwareDevice.partitions"/>:</strong>${(hardwareDevice.partitions != null) ? hardwareDevice.partitions : ''}</li>
		<li><strong><spring:message code="label.hardwareDevice.size"/>:</strong>${(hardwareDevice.size != null ) ? hardwareDevice.size : ''}</li>
		<li><strong><spring:message code="label.hardwareDevice.status"/>:</strong>${(hardwareDevice.status != null ) ? hardwareDevice.status : ''}</li>
		<li><strong><spring:message code="label.hardwareDevice.description"/>:</strong>${(hardwareDevice.description != null )? hardwareDevice.description : ''}</li>
		<li><strong><spring:message code="label.hardwareDevice.deviceId"/>:</strong>${(hardwareDevice.deviceId != null) ? hardwareDevice.deviceId : ''}</li>
		<li><strong><spring:message code="label.hardwareDevice.firmwareRevision"/>:</strong>${(hardwareDevice.firmwareRevision != null )? hardwareDevice.firmwareRevision : ''}</li>
		<li><strong><spring:message code="label.hardwareDevice.serialNumber"/>:</strong>${(hardwareDevice.serialNumber != null )? hardwareDevice.serialNumber : ''}</li>
		<li><strong><spring:message code="label.hardwareDevice.mediaType"/>:</strong>${(hardwareDevice.mediaType != null) ? hardwareDevice.mediaType : ''}</li>
		<li><strong><spring:message code="label.hardwareDevice.maxMediaSize"/>:</strong>${(hardwareDevice.maxMediaSize != null) ? hardwareDevice.maxMediaSize : ''}</li>
		<li><strong><spring:message code="label.hardwareDevice.totalCylinders"/>:</strong>${(hardwareDevice.totalCylinders != null) ? hardwareDevice.totalCylinders : ''}</li>
		<li><strong><spring:message code="label.hardwareDevice.tracksPerCylinder"/>:</strong>${(hardwareDevice.tracksPerCylinder != null )? hardwareDevice.tracksPerCylinder : ''}</li>
		<li><strong><spring:message code="label.hardwareDevice.sectorsPerTrack"/>:</strong>${(hardwareDevice.sectorsPerTrack != null ) ? hardwareDevice.sectorsPerTrack : ''}</li>
		<li><strong><spring:message code="label.hardwareDevice.bytesPerSector"/>:</strong>${(hardwareDevice.bytesPerSector != null) ? hardwareDevice.bytesPerSector : '' }</li>
		<li><strong><spring:message code="label.hardwareDevice.signature"/>:</strong>${(hardwareDevice.signature != null) ? hardwareDevice.signature : '' }</li>
	</ul>
    </td>
</tr>
	
</c:forEach>
</table>
	
</div>
