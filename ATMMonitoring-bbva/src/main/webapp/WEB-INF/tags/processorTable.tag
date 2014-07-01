 <%@tag description="Processor Table" pageEncoding="UTF-8"%>
<%@attribute name="hardwareDevices" required="true" type="java.util.Set"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3 class="txt content_hide"><spring:message code="label.processors"/></h3>

<div class="margin-box collapsible hide">

<table class="data subform link">
<tr>
	<th><spring:message code="label.hardwareDevice.name"/></th>
	<th><spring:message code="label.hardwareDevice.manufacturer"/></th>
	<th><spring:message code="label.hardwareDevice.caption"/></th>
	<th><spring:message code="label.hardwareDevice.architecture"/></th>
	<th><spring:message code="label.hardwareDevice.addressWidth"/></th>
	<th><spring:message code="label.hardwareDevice.dataWidth"/></th>
	<th><spring:message code="label.hardwareDevice.currentClockSpeed"/></th>
	<th><spring:message code="label.hardwareDevice.extClock"/></th>
	<th><spring:message code="label.hardwareDevice.stepping"/></th>
	<th><spring:message code="label.hardwareDevice.maxClockSpeed"/></th>
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

		<c:if test="${hardwareDevice.caption != null}">
			<td>${hardwareDevice.caption}</td>
		</c:if>
		<c:if test="${hardwareDevice.caption == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.architecture != null}">
			<td>${hardwareDevice.architecture}</td>
		</c:if>
		<c:if test="${hardwareDevice.architecture == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.addressWidth != null}">
			<td>${hardwareDevice.addressWidth}</td>
		</c:if>
		<c:if test="${hardwareDevice.addressWidth == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.dataWidth != null}">
			<td>${hardwareDevice.dataWidth}</td>
		</c:if>
		<c:if test="${hardwareDevice.dataWidth == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.currentClockSpeed != null}">
			<td>${hardwareDevice.currentClockSpeed}</td>
		</c:if>
		<c:if test="${hardwareDevice.currentClockSpeed == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.extClock != null}">
			<td>${hardwareDevice.extClock}</td>
		</c:if>
		<c:if test="${hardwareDevice.extClock == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.stepping != null}">
			<td>${hardwareDevice.stepping}</td>
		</c:if>
		<c:if test="${hardwareDevice.stepping == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.maxClockSpeed != null}">
			<td>${hardwareDevice.maxClockSpeed}</td>
		</c:if>
		<c:if test="${hardwareDevice.maxClockSpeed == null}">
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
