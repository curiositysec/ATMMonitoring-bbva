<%@tag description="Logical Disk Table" pageEncoding="UTF-8"%>
<%@attribute name="hardwareDevices" required="true" type="java.util.Set"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3 class="txt content_hide"><spring:message code="label.logicalDisks"/></h3>

<div class="margin-box collapsible hide">

<table class="data subform link">
<tr>
	<th><spring:message code="label.hardwareDevice.name"/></th>
	<th><spring:message code="label.hardwareDevice.size"/></th>
	<th><spring:message code="label.hardwareDevice.freeSpace"/></th>
	<th><spring:message code="label.hardwareDevice.fileSystem"/></th>
	<th><spring:message code="label.hardwareDevice.caption"/></th>
	<th><spring:message code="label.hardwareDevice.description"/></th>
	<th><spring:message code="label.hardwareDevice.deviceId"/></th>
	<th><spring:message code="label.hardwareDevice.volumeName"/></th>
	<th><spring:message code="label.hardwareDevice.volumeSerialNumber"/></th>
</tr>
<c:forEach items="${hardwareDevices}" var="hardwareDevice">
    <tr >
		<c:if test="${hardwareDevice.name != null}">
			<td>${hardwareDevice.name}</td>
		</c:if>
		<c:if test="${hardwareDevice.name == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.size != null}">
			<td>${hardwareDevice.size}</td>
		</c:if>
		<c:if test="${hardwareDevice.size == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.freeSpace != null}">
			<td>${hardwareDevice.freeSpace}</td>
		</c:if>
		<c:if test="${hardwareDevice.freeSpace == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.fileSystem != null}">
			<td>${hardwareDevice.fileSystem}</td>
		</c:if>
		<c:if test="${hardwareDevice.fileSystem == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.caption != null}">
			<td>${hardwareDevice.caption}</td>
		</c:if>
		<c:if test="${hardwareDevice.caption == null}">
			<td/>
		</c:if>

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

		<c:if test="${hardwareDevice.volumeName != null}">
			<td>${hardwareDevice.volumeName}</td>
		</c:if>
		<c:if test="${hardwareDevice.volumeName == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.volumeSerialNumber != null}">
			<td>${hardwareDevice.volumeSerialNumber}</td>
		</c:if>
		<c:if test="${hardwareDevice.volumeSerialNumber == null}">
			<td/>
		</c:if>
    </tr>
</c:forEach>
</table>
</div>
