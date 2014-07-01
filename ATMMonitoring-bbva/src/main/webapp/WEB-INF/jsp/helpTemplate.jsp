<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.queryEngine" userMsg="${userMsg}"  section="help">

<div class="documentation">
<div id="header_g">
		<nav id="breadcrumb">
			<ul>
				<sec:authorize access="hasAnyRole(${dashboardAccessAllowedRoles})">
					<li>
						<a href="dashboard">
							<spring:message code="breadcrumb.home"/>
						</a>
					</li>
				</sec:authorize>
				<li><spring:message code="label.menu.help"/></li>
			</ul>
		</nav>
	</div>
	<nav class="menu">
		<h1><spring:message code="label.menu.help"/></h1>
			<ul>
				<li><a href="help/user-main
					<c:if test="${section == 'user-main'}">
					#" class="current
					<c:set var="valid" value="${true}"/>
					</c:if>
				"><spring:message code="label.help.userMain"/></a></li>
				<li><a href="help/login-logout
					<c:if test="${section == 'login-logout'}">
					#" class="current
					<c:set var="valid" value="${true}"/>
					</c:if>
				"><spring:message code="label.help.loginLogout"/></a></li>
				<li><a href="help/dashboard
					<c:if test="${section == 'dashboard'}">
					#" class="current
					<c:set var="valid" value="${true}"/>
					</c:if>
				"><spring:message code="label.help.dashboard"/></a></li>
				<li><a href="help/terminals
					<c:if test="${section == 'terminals'}">
					#" class="current
					<c:set var="valid" value="${true}"/>
					</c:if>
				"><spring:message code="label.help.terminals"/></a></li>
				<li><a href="help/reports
					<c:if test="${section == 'reports'}">
					#" class="current
					<c:set var="valid" value="${true}"/>
					</c:if>
				"><spring:message code="label.help.reports"/></a></li>
				<li><a href="help/scheduled_updates
					<c:if test="${section == 'scheduled_updates'}">
					#" class="current
					<c:set var="valid" value="${true}"/>
					</c:if>
				"><spring:message code="label.help.scheduledUpdates"/></a></li>
                <sec:authorize access="hasAnyRole(${usersAccessAllowedRoles})">
					<li><a href="help/users
						<c:if test="${section == 'users'}">
						#" class="current
						<c:set var="valid" value="${true}"/>
						</c:if>
					"><spring:message code="label.help.users"/></a></li>
                </sec:authorize>
			</ul>
		</nav>
	<div class="scroll">
		<!-- <c:import url="/resources/help/${localeCode}/${section}.html" /> -->
		<c:import url="/resources/help/en/${section}.html" />
	</div><!-- /scroll --></div>
	
<c:if test="${!valid}">
	<c:redirect url="user-main"/>
</c:if>
	
</t:osoco-wrapper>