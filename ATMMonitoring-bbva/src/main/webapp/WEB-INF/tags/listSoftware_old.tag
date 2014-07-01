<%@tag description="Terminal Config Software List" pageEncoding="UTF-8"%>
<%@attribute name="config" required="true" type="com.ncr.ATMMonitoring.pojo.TerminalConfig"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3><spring:message code="label.operatingSystems"/></h3>
<c:if  test="${!empty config.operatingSystems}">
<table class="data subform link">
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
</table>
</c:if>

<h5><spring:message code="label.otherSoftware"/></h5>
<c:if  test="${!empty config.software}">

<c:choose>
<c:when  test="${config.software.size() > 7}">

<style type="text/css">
/* define height and width of scrollable area. Add 16px to width for scrollbar          */
div.tableContainerSw {
	height: 403px;
	width: 862px;
}

/* define width of table. IE browsers only                 */
div.tableContainerSw table {
	width: 863px
}

html>body tbody.scrollContentSw {
	height: 370px;
}
</style>
<div id="tableContainerSw" class="tableContainer tableContainerSw">
<table class="data subform">
<thead class="fixedHeader">
</c:when>
<c:otherwise>
<table class="data subform">
</c:otherwise>
</c:choose>
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
		<c:choose>
		<c:when  test="${config.software.size() > 7}">
		<th width="76px">
		</c:when>
		<c:otherwise>
		<th width="60px">
		</c:otherwise>
		</c:choose>
	    <i><spring:message code="label.software.vendor"/></i></th>
	</tr>
	<c:if  test="${config.software.size() > 7}">
	</thead>
	<tbody class="scrollContent scrollContentSw">
	</c:if>
	<c:set var="alt" value="${false}"/>
	<c:forEach items="${config.software}" var="software">
		<tr <c:if test="${alt}">class="alt"</c:if>>
	        <td width="90px">${software.nameVersion}</td>
	        <td width="70px"><spring:message code="${software.swType}"/></td>
	        <td width="90px">${software.caption}</td>
	        <td width="90px">${software.description}</td>
	        <td width="50px">${software.language}</td>
	        <td width="60px">${software.localPackage}</td>
	        <td width="60px">${software.packageName}</td>
	        <td width="60px">${software.productId}</td>
	        <td width="130px">${software.identifyingNumber}</td>
	        <td width="50px"><fmt:formatDate value="${software.installDate}" dateStyle="short" type="date" /></td>
	        <td width="60px">${software.vendor}</td>
	    </tr>
		<c:set var="alt" value="${!alt}"/>
	</c:forEach>
<c:choose>
<c:when  test="${config.software.size() > 7}">
</tbody>
</table>
</div>
</c:when>
<c:otherwise>
</table>
</c:otherwise>
</c:choose>
</c:if>