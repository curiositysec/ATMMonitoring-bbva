<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.error" userMsg="${userMsg}" section="errors">
	<div id="error_box">
		<div class="message_box">
			<h1><spring:message code="label.error.error403"/></h1>
			<div class="error"><spring:message code="label.error.error403msg"/></div>
		</div>
	</div>
</t:osoco-wrapper>