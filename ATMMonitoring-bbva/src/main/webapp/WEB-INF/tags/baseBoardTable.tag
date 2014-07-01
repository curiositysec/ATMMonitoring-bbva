<%@tag description="Base Board Table" pageEncoding="UTF-8"%>
<%@attribute name="hardwareDevices" required="true" type="java.util.Set"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3 class="txt content_hide"><spring:message code="label.baseBoards"/></h3>

<div class="margin-box collapsible hide">

<table class="data subform link">
<tr>
	<th><spring:message code="label.hardwareDevice.name"/></th>
	<th><spring:message code="label.hardwareDevice.manufacturer"/></th>
	<th><spring:message code="label.hardwareDevice.model"/></th>
	<th><spring:message code="label.hardwareDevice.product"/></th>
	<th><spring:message code="label.hardwareDevice.serialNumber"/></th>
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

		<c:if test="${hardwareDevice.product != null}">
			<td>${hardwareDevice.product}</td>
		</c:if>
		<c:if test="${hardwareDevice.product == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.serialNumber != null}">
			<td>${hardwareDevice.serialNumber}</td>
		</c:if>
		<c:if test="${hardwareDevice.serialNumber == null}">
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
