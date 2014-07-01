<%@tag description="USB hub Table" pageEncoding="UTF-8"%>
<%@attribute name="hardwareDevices" required="true" type="java.util.Set"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3><spring:message code="label.usbHubs"/></h3>

<table class="data subform link">
<tr>
</tr>
<c:set var="alt" value="${false}"/>
<c:forEach items="${hardwareDevices}" var="hardwareDevice">
    <tr <c:if test="${alt}">class="alt"</c:if>>
    </tr>
	<c:set var="alt" value="${!alt}"/>
</c:forEach>
</table>