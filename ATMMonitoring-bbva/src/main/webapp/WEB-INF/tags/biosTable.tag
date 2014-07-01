<%@tag description="Bios Table" pageEncoding="UTF-8"%>
<%@attribute name="hardwareDevices" required="true" type="java.util.Set"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3 class="txt content_hide"><spring:message code="label.bios"/></h3>
<div class="margin-box collapsible hide">
<table class="data subform link">
<tr>
	<th><spring:message code="label.hardwareDevice.name"/></th>
	<th><spring:message code="label.hardwareDevice.caption"/></th>
	<th><spring:message code="label.hardwareDevice.manufacturer"/></th>
	<th><spring:message code="label.hardwareDevice.smbiosVersion"/></th>
	<th><spring:message code="label.hardwareDevice.smbiosMajorVersion"/></th>
	<th><spring:message code="label.hardwareDevice.smbiosMinorVersion"/></th>
	<th><spring:message code="label.hardwareDevice.caption"/></th>
	<th><spring:message code="label.hardwareDevice.currentLanguage"/></th>
	<th><spring:message code="label.hardwareDevice.primaryBios"/></th>
	<th><spring:message code="label.hardwareDevice.releaseDate"/></th>
	<th><spring:message code="label.hardwareDevice.smbiosPresent"/></th>
	<th><spring:message code="label.hardwareDevice.serialNumber"/></th>
	<th><spring:message code="label.hardwareDevice.version"/></th>
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
		
    	<c:if test="${hardwareDevice.manufacturer != null}">
			<td>${hardwareDevice.manufacturer}</td>
		</c:if>
		<c:if test="${hardwareDevice.manufacturer == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.smbiosVersion != null}">
			<td>${hardwareDevice.smbiosVersion}</td>
		</c:if>
		<c:if test="${hardwareDevice.smbiosVersion == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.smbiosMajorVersion != null}">
			<td>${hardwareDevice.smbiosMajorVersion}</td>
		</c:if>
		<c:if test="${hardwareDevice.smbiosMajorVersion == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.smbiosMinorVersion != null}">
			<td>${hardwareDevice.smbiosMinorVersion}</td>
		</c:if>
		<c:if test="${hardwareDevice.smbiosMinorVersion == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.caption != null}">
			<td>${hardwareDevice.caption}</td>
		</c:if>
		<c:if test="${hardwareDevice.caption == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.currentLanguage != null}">
			<td>${hardwareDevice.currentLanguage}</td>
		</c:if>
		<c:if test="${hardwareDevice.currentLanguage == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.primaryBios != null}">
			<td>${hardwareDevice.primaryBios}</td>
		</c:if>
		<c:if test="${hardwareDevice.primaryBios == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.releaseDate != null}">
			<td>${hardwareDevice.releaseDate}</td>
		</c:if>
		<c:if test="${hardwareDevice.releaseDate == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.smbiosPresent != null}">
			<td>${hardwareDevice.smbiosPresent}</td>
		</c:if>
		<c:if test="${hardwareDevice.smbiosPresent == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.serialNumber != null}">
			<td>${hardwareDevice.serialNumber}</td>
		</c:if>
		<c:if test="${hardwareDevice.serialNumber == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.version != null}">
			<td>${hardwareDevice.version}</td>
		</c:if>
		<c:if test="${hardwareDevice.version == null}">
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
