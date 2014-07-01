<%@tag description="Computer System Table" pageEncoding="UTF-8"%>
<%@attribute name="hardwareDevices" required="true" type="java.util.Set"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3 class="txt content_hide"><spring:message code="label.computerSystems"/></h3>

<div class="margin-box collapsible hide">
<table class="data subform link">
<tr>
	<th><spring:message code="label.hardwareDevice.name"/></th>
	<th><spring:message code="label.hardwareDevice.manufacturer"/></th>
	<th><spring:message code="label.hardwareDevice.model"/></th>
	<th><spring:message code="label.hardwareDevice.numberOfProcessors"/></th>
	<th><spring:message code="label.hardwareDevice.caption"/></th>
	<th><spring:message code="label.hardwareDevice.totalPhysicalMemory"/></th>
<%--	<th><spring:message code="label.hardwareDevice.description"/></th>
	<th><spring:message code="label.hardwareDevice.currentTimeZone"/></th>
	<th><spring:message code="label.hardwareDevice.daylightInEffect"/></th>
	<th><spring:message code="label.hardwareDevice.domain"/></th>
	<th><spring:message code="label.hardwareDevice.workgroup"/></th>
--%>
	<th><spring:message code="label.hardwareDevice.status"/></th>
	<th><div class="add"><span>Ver más información</span></div></th>
</tr>
<c:forEach items="${hardwareDevices}" var="hardwareDevice">
    <tr class="showdetail open">
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

		<c:if test="${hardwareDevice.numberOfProcessors != null}">
			<td>${hardwareDevice.numberOfProcessors}</td>
		</c:if>
		<c:if test="${hardwareDevice.numberOfProcessors == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.caption != null}">
			<td>${hardwareDevice.caption}</td>
		</c:if>
		<c:if test="${hardwareDevice.caption == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.totalPhysicalMemory != null}">
			<td>${hardwareDevice.totalPhysicalMemory}</td>
		</c:if>
		<c:if test="${hardwareDevice.totalPhysicalMemory == null}">
			<td/>
		</c:if>
<%--
		<c:if test="${hardwareDevice.description != null}">
			<td>${hardwareDevice.description}</td>
		</c:if>
		<c:if test="${hardwareDevice.description == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.currentTimeZone != null}">
			<td>${hardwareDevice.currentTimeZone}</td>
		</c:if>
		<c:if test="${hardwareDevice.currentTimeZone == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.daylightInEffect != null}">
			<td>${hardwareDevice.daylightInEffect}</td>
		</c:if>
		<c:if test="${hardwareDevice.daylightInEffect == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.domain != null}">
			<td>${hardwareDevice.domain}</td>
		</c:if>
		<c:if test="${hardwareDevice.domain == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.workgroup != null}">
			<td>${hardwareDevice.workgroup}</td>
		</c:if>
		<c:if test="${hardwareDevice.workgroup == null}">
			<td/>
		</c:if>

--%>
		<c:if test="${hardwareDevice.status != null}">
			<td>${hardwareDevice.status}</td>
		</c:if>
		<c:if test="${hardwareDevice.status == null}">
			<td/>
		</c:if>

	<td><div class="add"><span>Ver más información</span></div></td>
    </tr>
    <tr class="detail">
       <td colspan="8">
         <ul>
	   <li><strong><spring:message code="label.hardwareDevice.name"/>:</strong>${hardwareDevice.name}</li>
	   <li><strong><spring:message code="label.hardwareDevice.manufacturer"/>:</strong>${hardwareDevice.manufacturer}</li>
	   <li><strong><spring:message code="label.hardwareDevice.model"/>:</strong>${hardwareDevice.model}</li>
	   <li><strong><spring:message code="label.hardwareDevice.numberOfProcessors"/>:</strong>${hardwareDevice.numberOfProcessors}</li>
	   <li><strong><spring:message code="label.hardwareDevice.caption"/>:</strong>${hardwareDevice.caption}</li>
	   <li><strong><spring:message code="label.hardwareDevice.totalPhysicalMemory"/>:</strong>${hardwareDevice.totalPhysicalMemory}</li>
	   <li><strong><spring:message code="label.hardwareDevice.description"/>:</strong>${hardwareDevice.description}</li>
	   <li><strong><spring:message code="label.hardwareDevice.currentTimeZone"/>:</strong>${hardwareDevice.currentTimeZone}</li>
	   <li><strong><spring:message code="label.hardwareDevice.daylightInEffect"/>:</strong>${hardwareDevice.daylightInEffect}</li>
	   <li><strong><spring:message code="label.hardwareDevice.domain"/>:</strong>${hardwareDevice.domain}</li>
	   <li><strong><spring:message code="label.hardwareDevice.workgroup"/>:</strong>${hardwareDevice.workgroup}</li>
	   <li><strong><spring:message code="label.hardwareDevice.status"/>:</strong>${hardwareDevice.status}</li>
	 </ul>
	</td>

    </tr>
</c:forEach>
</table>

</div>
