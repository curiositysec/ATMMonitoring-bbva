<%@tag description="terminal table buttons" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@attribute name="query" required="false" type="java.lang.Object"%>

<div class="botonera">
	<c:if test="${query == null}">
		<c:if test="${!agentPushState}">
			<sec:authorize access="hasAnyRole(${terminalsUpdateRequestAllowedRoles})">
				<a href="terminals/request" class="btn left update"> 
					<spring:message code="label.update" /> 
				</a>
			</sec:authorize>
			<sec:authorize access="hasAnyRole(${schedulesAccessAllowedRoles})">
				<a href="terminals/schedules/new" class="btn left clock"> 
					<spring:message code="label.update.schedule" /> 
				</a>
			</sec:authorize>
		</c:if>
		<a href="terminals/exportAll" class="btn download" target="_blank" id="exportTerminals"> 
			<spring:message code="label.query.downloadCsv" />
		</a>
	</c:if>
	<c:if test="${query != null}">
		<c:if test="${!agentPushState}">
			<sec:authorize access="hasAnyRole(${terminalsUpdateRequestAllowedRoles})">
				<a href="terminals/request?queryId=${query.id}" class="btn left update"> 
					<spring:message code="label.update" />
				</a>
			</sec:authorize>
			<sec:authorize access="hasAnyRole(${schedulesAccessAllowedRoles})">
				<a href="terminals/schedules/new?queryId=${query.id}" class="btn left clock"> 
					<spring:message code="label.update.schedule" />
				</a>
			</sec:authorize>
		</c:if>
		<a href="terminals/export/${query.id}" class="btn download" target="_blank" id="exportTerminals"> 
			<spring:message code="label.query.downloadCsv" />
		</a>
	</c:if>
</div>
