<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<%@attribute name="titleCode" required="true" type="java.lang.String"%>
<%@attribute name="userMsg" required="false" type="java.lang.String"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE HTML>
<html>
	<head>
        <c:set var="req" value="${pageContext.request}" />
        <c:set var="url">${req.requestURL}</c:set>
        <c:set var="base" value="${fn:substring(url, 0, fn:length(url) - fn:length(req.requestURI))}${req.contextPath}/" />
        <base href="${base}">
		<script src="resources/js/jquery-1.8.3.min.js"></script>
		<script src="resources/js/jquery.collapsible.min.js"></script>
		<script src="resources/js/jquery-ui-1.9.2.custom.js"></script>
		<script src="resources/js/jquery.blockUI.js"></script>
		<script src="resources/js/spin.min.js"></script>
		<script src="resources/js/jquery.spin.js"></script>
	    <title><spring:message code="label.baseTitle"/> - <spring:message code="${titleCode}"/></title>
		<link rel="stylesheet" type="text/css" href="resources/css/black-tie/jquery-ui-1.9.2.custom.css">
		<link rel="stylesheet" type="text/css" href="resources/css/collapsible.css">
		<link rel="stylesheet" type="text/css" href="resources/css/atmMonitoring.css">
		<!--[if IE]>
                <link rel="stylesheet" type="text/css" href="resources/css/atmMonitoringIE.css">
        <![endif]-->
	</head>
	<body>
		<div style="text-align: center; width: 100%;">
			<div class="wide-horizontal" style="overflow: hidden; zoom: 1; margin: 0px auto; text-align: center;">
				<table class="welcome-msg-table" border=0>
				<tr>
					<td width="1062" height="105" background="resources/images/BannerUp.png" valign="middle" align="right">
						<c:if test="${userMsg != null}">
						<label class="welcome-msg"><spring:message code="label.welcomeMessage"/> ${userMsg}</label>
						</c:if>
					</td>
				</tr>
				</table>
				<div class="ui-corner-all" style="overflow: hidden;">
				    <ul id="nav" class="ui-menu ui-widget ui-corner-all ui-vertical-menu atm-top-menu" role="menu" tabindex="0" aria-activedescendant="ui-id-1">
						<li class="ui-menu-item ui-vertical-menu-item" role="presentation">
						<a id="ui-id-1" class="menu-item ui-corner-all" href="terminals" role="menuitem"><spring:message code="label.menu.terminals"/></a>
						</li>
						<li class="ui-menu-item ui-vertical-menu-item" role="presentation">
						<a id="ui-id-2" class="menu-item ui-corner-all" href="terminals/models" role="menuitem"><spring:message code="label.menu.terminalModels"/></a>
						</li>
						<li class="ui-menu-item ui-vertical-menu-item" role="presentation">
						<a id="ui-id-3" class="menu-item ui-corner-all" href="terminals/installations" role="menuitem"><spring:message code="label.menu.installations"/></a>
						</li>
						<li class="ui-menu-item ui-vertical-menu-item" role="presentation">
						<a id="ui-id-4" class="menu-item ui-corner-all" href="terminals/locations" role="menuitem"><spring:message code="label.menu.locations"/></a>
						</li>
						<!-- href="http://localhost:8080/externalreports.jsp"-->
						<li class="ui-menu-item ui-vertical-menu-item" role="presentation">
						<a id="ui-id-10" class="menu-item ui-corner-all" href="externalreports" role="menuitem"><spring:message code="label.menu.externalreports"/></a>
						</li>
						<li class="ui-menu-item ui-vertical-menu-item" role="presentation">
						<a id="ui-id-5" class="menu-item ui-corner-all" href="queries" role="menuitem"><spring:message code="label.menu.queries"/></a>
						</li>
						<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_SUPERADMIN')">
							<li class="ui-menu-item ui-vertical-menu-item" role="presentation">
							<a id="ui-id-6" class="menu-item ui-corner-all" href="users" role="menuitem"><spring:message code="label.menu.users"/></a>
							</li>
							<li class="ui-menu-item ui-vertical-menu-item" role="presentation">
							<a id="ui-id-7" class="menu-item ui-corner-all" href="banks" role="menuitem"><spring:message code="label.menu.bankCompanies"/></a>
							</li>
						</sec:authorize>
						<li class="ui-menu-item ui-vertical-menu-item" style="float:right;" role="presentation">
						<sec:authorize access="isAnonymous()">
							<a id="ui-id-8" class="menu-item ui-corner-all" href="login" role="menuitem"><spring:message code="label.menu.login"/></a>
						</sec:authorize>
				    	<sec:authorize access="isAuthenticated()">
							<a id="ui-id-9" class="menu-item ui-corner-all" href="logout" role="menuitem"><spring:message code="label.menu.logout"/></a>
						</sec:authorize>
						</li>
					</ul>
				</div>
			    <script type="text/javascript">
					$('#nav').menu();
					$(document).ready(function(){
						 $("select.number-selector").each(function(){
			
							  $(this).css("width", "45px");
			
						  });
						 $(".form-submit").each(function(){
							 
						  $(this).button();
							 
						  });
						});
				</script>
		  		<jsp:doBody/>
		  	</div>
	  	</div>
	</body>
</html>