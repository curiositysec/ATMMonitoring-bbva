<%@tag description="ups table buttons" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@attribute name="query" required="false" type="java.lang.Object"%>
<div class="botonera">
	<c:if test="${query == null}">
		<a href="ups/exportAll" class="btn download" target="_blank" id="exportUps"> 
			<spring:message code="label.query.downloadCsv" />
		</a>
	</c:if>
	<c:if test="${query != null && query.id != null}">
		<a href="ups/export/${query.id}" class="btn download" target="_blank" id="exportUps"> 
			<spring:message code="label.query.downloadCsv" />
		</a>
	</c:if>
</div>
