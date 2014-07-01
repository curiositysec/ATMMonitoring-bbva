<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.error" userMsg="${userMsg}" section="errors">
	<div id="error_box">
		<div class="message_box">
			<h1><spring:message code="label.error.errorPageTitle"/></h1>
			<h2><spring:message code="label.error.errorMessage1"/></h2>
			<div class="error">${exception.getClass().getCanonicalName()}:${exception.message}</div>
			<div class="alert"><spring:message code="label.error.errorMessage2"/></div>
		</div>
	</div>
	<div class="action_box">
      <h2><spring:message code="label.error.completeStackTrace"/></h2>
	  <c:forEach items="${exception.stackTrace}" var="element">
		<c:out value="${element}"/></br>
	  </c:forEach>
	</div>
</t:osoco-wrapper>
