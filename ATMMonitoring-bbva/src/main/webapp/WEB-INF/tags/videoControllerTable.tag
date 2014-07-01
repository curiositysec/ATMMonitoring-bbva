<%@tag description="Video Controller Table" pageEncoding="UTF-8"%>
<%@attribute name="hardwareDevices" required="true" type="java.util.Set"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3 class="txt content_hide last"><spring:message code="label.videoControllers"/></h3>
<div class="margin-box collapsible hide">
<table class="data subform link">
<tr>
	<th><spring:message code="label.hardwareDevice.name"/></th>
	<th><spring:message code="label.hardwareDevice.description"/></th>
	<th><spring:message code="label.hardwareDevice.videoProcessor"/></th>
	<th><spring:message code="label.hardwareDevice.adapterRam"/></th>
	<th><spring:message code="label.hardwareDevice.currentBitsPerPixel"/></th>
	<th><spring:message code="label.hardwareDevice.currentNumberOfColors"/></th>
	<th><spring:message code="label.hardwareDevice.currentVerticalResolution"/></th>
	<th><spring:message code="label.hardwareDevice.currentHorizontalResolution"/></th>
	<th><spring:message code="label.hardwareDevice.currentRefreshRate"/></th>
</tr>
<c:forEach items="${hardwareDevices}" var="hardwareDevice">
    <tr >
    	<c:if test="${hardwareDevice.name != null}">
			<td>${hardwareDevice.name}</td>
		</c:if>
		<c:if test="${hardwareDevice.name == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.description != null}">
			<td>${hardwareDevice.description}</td>
		</c:if>
		<c:if test="${hardwareDevice.description == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.videoProcessor != null}">
			<td>${hardwareDevice.videoProcessor}</td>
		</c:if>
		<c:if test="${hardwareDevice.videoProcessor == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.adapterRam != null}">
			<td>${hardwareDevice.adapterRam}</td>
		</c:if>
		<c:if test="${hardwareDevice.adapterRam == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.currentBitsPerPixel != null}">
			<td>${hardwareDevice.currentBitsPerPixel}</td>
		</c:if>
		<c:if test="${hardwareDevice.currentBitsPerPixel == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.currentNumberOfColors != null}">
			<td>${hardwareDevice.currentNumberOfColors}</td>
		</c:if>
		<c:if test="${hardwareDevice.currentNumberOfColors == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.currentHorizontalResolution != null}">
			<td>${hardwareDevice.currentHorizontalResolution}</td>
		</c:if>
		<c:if test="${hardwareDevice.currentHorizontalResolution == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.currentVerticalResolution != null}">
			<td>${hardwareDevice.currentVerticalResolution}</td>
		</c:if>
		<c:if test="${hardwareDevice.currentVerticalResolution == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.currentRefreshRate != null}">
			<td>${hardwareDevice.currentRefreshRate}</td>
		</c:if>
		<c:if test="${hardwareDevice.currentRefreshRate == null}">
			<td/>
		</c:if>
    </tr>
</c:forEach>
</table>
