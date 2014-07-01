<%@tag description="Terminal Config Software List" pageEncoding="UTF-8"%>
<%@attribute name="config" required="true" type="com.ncr.ATMMonitoring.pojo.TerminalConfig"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<h3 class="txt content_hide"><spring:message code="label.operatingSystems"/></h3>
<c:if  test="${!empty config.operatingSystems}">
<div class="margin-box collapsible hide"><table class="data subform link">
	<tr>
	    <th width="80px"><i><spring:message code="label.operatingSystem.name"/> + <spring:message code="label.operatingSystem.majorVersion"/></i></th>
	    <th width="40px"><i><spring:message code="label.operatingSystem.osType"/></i></th>
	    <th width="80px"><i><spring:message code="label.operatingSystem.serialNumber"/></i></th>
	    <th width="70px"><i><spring:message code="label.operatingSystem.manufacturer"/></i></th>
	    <th width="60px"><i><spring:message code="label.operatingSystem.servicePackMajorVersion"/></i></th>
	    <th width="70px"><i><spring:message code="label.operatingSystem.organization"/></i></th>
	    <th width="60px"><i><spring:message code="label.operatingSystem.osLanguage"/></i></th>
	</tr>
	<c:set var="alt" value="${false}"/>
	<c:forEach items="${config.operatingSystems}" var="operatingSystem">
		<tr <c:if test="${alt}">class="alt"</c:if>>
	        <td width="80px">${operatingSystem.nameVersion}</td>
	        <td width="40px">${operatingSystem.osType}</td>
	        <td width="80px">${operatingSystem.serialNumber}</td>
	        <td width="70px">${operatingSystem.manufacturer}</td>
	        <td width="60px">${operatingSystem.servicePackVersion}</td>
	        <td width="70px">${operatingSystem.organization}</td>
	        <td width="60px">${operatingSystem.osLanguage}</td>
	    </tr>
		<c:set var="alt" value="${!alt}"/>
	</c:forEach>
</table></div>
</c:if>



<h3 clasS="txt content_hide"><spring:message code="label.otherSoftware"/></h3>
<div class="margin-box collapsible hide">
<c:if  test="${!empty config.software}">
<c:choose>
<c:when test="${config.software.size() > 7}">
	<table id="SoftwareChromatable" class="data subform link">
	<thead>
	<tr>
	    <th><i><spring:message code="label.software.name"/> + <spring:message code="label.software.majorVersion"/></i></th>
	    <th><i><spring:message code="label.software.swType"/></i></th>
	    <th><i><spring:message code="label.software.caption"/></i></th>
	    <th><i><spring:message code="label.software.description"/></i></th>
	    <th><i><spring:message code="label.software.language"/></i></th>
	    <th><i><spring:message code="label.software.localPackage"/></i></th>
	    <th><i><spring:message code="label.software.packageName"/></i></th>
	    <th><i><spring:message code="label.software.productId"/></i></th>
	    <th><i><spring:message code="label.software.identifyingNumber"/></i></th>
	    <th><i><spring:message code="label.software.installDate"/></i></th>
	    <th><i><spring:message code="label.software.vendor"/></i></th>
	</tr>
	</thead>
</c:when>
<c:otherwise>
	<table class="data subform">
	<tr>
	    <th width="90px"><i><spring:message code="label.software.name"/> + <spring:message code="label.software.majorVersion"/></i></th>
	    <th width="70px"><i><spring:message code="label.software.swType"/></i></th>
	    <th width="90px"><i><spring:message code="label.software.caption"/></i></th>
	    <th width="90px"><i><spring:message code="label.software.description"/></i></th>
	    <th width="50px"><i><spring:message code="label.software.language"/></i></th>
	    <th width="60px"><i><spring:message code="label.software.localPackage"/></i></th>
	    <th width="60px"><i><spring:message code="label.software.packageName"/></i></th>
	    <th width="60px"><i><spring:message code="label.software.productId"/></i></th>
	    <th width="130px"><i><spring:message code="label.software.identifyingNumber"/></i></th>
	    <th width="50px"><i><spring:message code="label.software.installDate"/></i></th>
		<th width="60px"><i><spring:message code="label.software.vendor"/></i></th>
	</tr>
</c:otherwise>
</c:choose>
	<tbody>
	<c:set var="alt" value="${false}"/>
	<c:forEach items="${config.software}" var="software">
		<tr <c:if test="${alt}">class="alt"</c:if>>
	        <td>${software.nameVersion}</td>
	        <td>
		        <c:if test="${software.swType != null && software.swType != ''}">
        			<spring:message code="${software.swType}"/>
		        </c:if>
		    </td>
	        <td>${software.caption}</td>
	        <td>${software.description}</td>
	        <td>${software.language}</td>
	        <td>${software.localPackage}</td>
	        <td>${software.packageName}</td>
	        <td>${software.productId}</td>
	        <td>${software.identifyingNumber}</td>
	        <td><fmt:formatDate value="${software.installDate}" dateStyle="short" type="date" /></td>
	        <td>${software.vendor}</td>
	    </tr>
		<c:set var="alt" value="${!alt}"/>
	</c:forEach>
	</tbody>
</table>
</c:if>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		/*$("#SoftwareChromatable").chromatable({
				width: "950px",
				height: "220px",
				scrolling: "yes"
		});*/
	});
</script>
