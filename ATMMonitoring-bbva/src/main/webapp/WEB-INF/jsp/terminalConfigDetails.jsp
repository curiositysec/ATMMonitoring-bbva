<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:wrapper titleCode="label.terminalsManager" userMsg="${userMsg}">
<div class="box">
<h2><spring:message code="label.terminalConfigDetails"/></h2>
<div class="margin-box">
	<table class="form-disabled">
	<tr>
	    <td class="header first-header"><label><i><spring:message code="label.terminalConfig.startDate"/></i></label></td>
	    <td class="first-header"><label><fmt:formatDate value="${config.startDate}" dateStyle="short" type="both" /></label></td>
	</tr>
	<%-- <c:choose>
	<c:when test="${config.author != null}">
		<tr>
		    <td><label><i><spring:message code="label.terminalConfig.author"/></i></label></td>
		    <td><label>${config.author.lastname}, ${config.author.firstname}</label></td>
		</tr>
	</c:when>
	<c:otherwise>
		<tr>
		    <td><label><i><spring:message code="label.terminalConfig.author"/></i></label></td>
		    <td><label>----</label></td>
		</tr>
	</c:otherwise>
	</c:choose> --%>
	<tr>
	    <td class="header last-header"><label><i><spring:message code="label.terminalConfig.terminal"/></i></label></td>
	    <td class="last-header"><a href="terminals/details/${config.terminal.id}">${config.terminal.serialNumber}</a></td>
	</tr>
	</table>

<t:listSoftware config="${config}"/>
</div>
</div>

</t:wrapper>