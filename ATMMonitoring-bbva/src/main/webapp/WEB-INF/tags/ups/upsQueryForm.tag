<%@tag description="UPS list query form" pageEncoding="UTF-8"%>
<%@attribute name="userQueries" required="true" type="java.util.Set"%>
<%@attribute name="selectedQuery"  type="java.lang.Object"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="action_box">
	<h2>
		<spring:message code="label.queries"/>
		<a id="queryHelp" class="info inline cboxElement">
			<span>
				<spring:message code="label.moreInfo"/>
			</span>
		</a>
	</h2>

	<div class="row">
		<a href="upsQueries" class="btn right"> <spring:message code="label.queries.mine"/> </a>
		<c:if test="${empty userQueries}">
			<div class="message no_queries">
				<p>
					<spring:message code="label.queries.tip"/>
				</p>
				<div class="flecha"></div>
			</div>
		</c:if>
		<c:if test="${!empty userQueries}">
			<form method="post" name="userQueriesForm" action="ups/byQuery" id="userQueriesForm">
				<label>
					<spring:message code="label.choose.query"/>:
				</label>
				<select name="queryId" size="1">
					<option value="" ><spring:message code="label.select.default"/></option>
					<c:forEach items="${userQueries}" var="userQuery">
						<option value="${userQuery.id}" ${selectedQuery.id == userQuery.id? 'selected': ''}>${userQuery.name}</option>
					</c:forEach>
				</select>
				<input type="submit" value="<spring:message code="label.apply"/>" class="btn">
			</form>
		</c:if>
	</div>
</div>