<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:wrapper titleCode="label.error" userMsg="${userMsg}">
	<h1><spring:message code="label.error.errorSnmpTimeOutPageTitle"/></h1>
	<h4><spring:message code="label.error.errorSnmpTimeOutMessage"/><br>${ips}</h4>
</t:wrapper>