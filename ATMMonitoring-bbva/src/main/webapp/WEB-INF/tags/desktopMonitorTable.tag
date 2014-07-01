<%@tag description="Desktop Monitor Table" pageEncoding="UTF-8"%>
<%@attribute name="hardwareDevices" required="true" type="java.util.Set"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3 class="txt content_hide"><spring:message code="label.desktopMonitors"/></h3>
<div class="margin-box collapsible hide">
<table class="data subform link">
<tr>
	<th><spring:message code="label.hardwareDevice.name"/></th>
	<th><spring:message code="label.hardwareDevice.caption"/></th>
	<th><spring:message code="label.hardwareDevice.deviceId"/></th>
	<th><spring:message code="label.hardwareDevice.displayType"/></th>
	<th><spring:message code="label.hardwareDevice.monitorManufacturer"/></th>
	<th><spring:message code="label.hardwareDevice.monitorType"/></th>
	<th><spring:message code="label.hardwareDevice.pixelsPerXLogicalInch"/></th>
	<th><spring:message code="label.hardwareDevice.pixelsPerYLogicalInch"/></th>
	<th><spring:message code="label.hardwareDevice.status"/></th>
</tr>
<c:forEach items="${hardwareDevices}" var="hardwareDevice">
    <tr >
    	<c:if test="${hardwareDevice.name != null}">
			<td>${hardwareDevice.name}</td>
		</c:if>
		<c:if test="${hardwareDevice.name == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.caption != null}">
			<td>${hardwareDevice.caption}</td>
		</c:if>
		<c:if test="${hardwareDevice.caption == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.deviceId != null}">
			<td>${hardwareDevice.deviceId}</td>
		</c:if>
		<c:if test="${hardwareDevice.deviceId == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.displayType != null}">
			<td>${hardwareDevice.displayType}</td>
		</c:if>
		<c:if test="${hardwareDevice.displayType == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.monitorManufacturer != null}">
			<td>${hardwareDevice.monitorManufacturer}</td>
		</c:if>
		<c:if test="${hardwareDevice.monitorManufacturer == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.monitorType != null}">
			<td>${hardwareDevice.monitorType}</td>
		</c:if>
		<c:if test="${hardwareDevice.monitorType == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.pixelsPerXLogicalInch != null}">
			<td>${hardwareDevice.pixelsPerXLogicalInch}</td>
		</c:if>
		<c:if test="${hardwareDevice.pixelsPerXLogicalInch == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.pixelsPerYLogicalInch != null}">
			<td>${hardwareDevice.pixelsPerYLogicalInch}</td>
		</c:if>
		<c:if test="${hardwareDevice.pixelsPerYLogicalInch == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.status != null}">
			<td>${hardwareDevice.status}</td>
		</c:if>
		<c:if test="${hardwareDevice.status == null}">
			<td/>
		</c:if>
    </tr>
</c:forEach>
</table>
</div>