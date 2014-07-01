<%@tag description="System Slot Table" pageEncoding="UTF-8"%>
<%@attribute name="hardwareDevices" required="true" type="java.util.Set"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3 class="txt content_hide"><spring:message code="label.systemSlots"/></h3>
<div class="margin-box collapsible hide">
<table class="data subform link">
<tr>
	<th><spring:message code="label.hardwareDevice.name"/></th>
	<th><spring:message code="label.hardwareDevice.manufacturer"/></th>
	<th><spring:message code="label.hardwareDevice.caption"/></th>
	<th><spring:message code="label.hardwareDevice.currentUsage"/></th>
	<th><spring:message code="label.hardwareDevice.serialNumber"/></th>
	<th><spring:message code="label.hardwareDevice.slotDesignation"/></th>
	<th><spring:message code="label.hardwareDevice.tag"/></th>
	<th><spring:message code="label.hardwareDevice.version"/></th>
</tr>
<c:forEach items="${hardwareDevices}" var="hardwareDevice">
    <tr >
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
		
    	<c:if test="${hardwareDevice.caption != null}">
			<td>${hardwareDevice.caption}</td>
		</c:if>
		<c:if test="${hardwareDevice.caption == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.currentUsage != null}">
			<td>${hardwareDevice.currentUsage}</td>
		</c:if>
		<c:if test="${hardwareDevice.currentUsage == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.serialNumber != null}">
			<td>${hardwareDevice.serialNumber}</td>
		</c:if>
		<c:if test="${hardwareDevice.serialNumber == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.slotDesignation != null}">
			<td>${hardwareDevice.slotDesignation}</td>
		</c:if>
		<c:if test="${hardwareDevice.slotDesignation == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.tag != null}">
			<td>${hardwareDevice.tag}</td>
		</c:if>
		<c:if test="${hardwareDevice.tag == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.version != null}">
			<td>${hardwareDevice.version}</td>
		</c:if>
		<c:if test="${hardwareDevice.version == null}">
			<td/>
		</c:if>
    </tr>
</c:forEach>
</table>
</div>
