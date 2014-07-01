<%@tag description="1394 Controller Table" pageEncoding="UTF-8"%>
<%@attribute name="hardwareDevices" required="true" type="java.util.Set"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3 class="txt content_hide"><spring:message code="label.1394Controllers"/></h3>
<div class="margin-box collapsible hide">
<table class="data subform link">
<tr>
	<th><i><label><spring:message code="label.hardwareDevice.name"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.caption"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.description"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.manufacturer"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.deviceId"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.status"/></label></i></th>
</tr>
<c:set var="alt" value="${false}"/>
<c:forEach items="${hardwareDevices}" var="hardwareDevice">
    <tr <c:if test="${alt}">class="alt"</c:if>>
    	<c:if test="${hardwareDevice.name != null}">
			<td><label>${hardwareDevice.name}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.name == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.caption != null}">
			<td><label>${hardwareDevice.caption}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.caption == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.description != null}">
			<td><label>${hardwareDevice.description}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.description == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.manufacturer != null}">
			<td><label>${hardwareDevice.manufacturer}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.manufacturer == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.deviceId != null}">
			<td><label>${hardwareDevice.deviceId}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.deviceId == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.status != null}">
			<td><label>${hardwareDevice.status}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.status == null}">
			<td/>
		</c:if>
    </tr>
	<c:set var="alt" value="${!alt}"/>
</c:forEach>
</table>
</div>
