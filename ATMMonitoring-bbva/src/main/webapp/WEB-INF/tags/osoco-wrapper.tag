<%@tag description="OSOCO version of Simple Wrapper Tag" pageEncoding="UTF-8"%>
<%@attribute name="titleCode" required="true" type="java.lang.String"%>
<%@attribute name="section" required="true" type="java.lang.String"%>
<%@attribute name="userMsg" required="false" type="java.lang.String"%>
<%@attribute name="header" required="false" fragment="true" %>
<%@variable name-given="currentUrl" scope="NESTED"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="localeCode" scope="request" value="${pageContext.response.locale}" />

<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <c:set var="req" value="${pageContext.request}" />
        <c:set var="url">${req.requestURL}</c:set>
        <c:set var="base" value="${fn:substring(url, 0, fn:length(url) - fn:length(req.requestURI))}${req.contextPath}/" />
        <c:set var="currentUrl" value='${req.getAttribute("javax.servlet.forward.request_uri")}'/>

        <!-- Roles assigned to variables -->
        <spring:eval expression="@settings.getProperty('security.dashboardAccessAllowedRoles')" var="dashboardAccessAllowedRoles" scope="request"/>
        <spring:eval expression="@settings.getProperty('security.helpAccessAllowedRoles')" var="helpAccessAllowedRoles" scope="request"/>
        <spring:eval expression="@settings.getProperty('security.usersAccessAllowedRoles')" var="usersAccessAllowedRoles" scope="request"/>
        <spring:eval expression="@settings.getProperty('security.schedulesAccessAllowedRoles')" var="schedulesAccessAllowedRoles" scope="request"/>
        <spring:eval expression="@settings.getProperty('security.terminalsAccessAllowedRoles')" var="terminalsAccessAllowedRoles" scope="request"/>
        <spring:eval expression="@settings.getProperty('security.terminalsManagementAllowedRoles')" var="terminalsManagementAllowedRoles" scope="request"/>
        <spring:eval expression="@settings.getProperty('security.terminalsUpdateRequestAllowedRoles')" var="terminalsUpdateRequestAllowedRoles" scope="request"/>
        <spring:eval expression="@settings.getProperty('security.queriesAccessAllowedRoles')" var="queriesAccessAllowedRoles" scope="request"/>
        <spring:eval expression="@settings.getProperty('security.reportsAccessAllowedRoles')" var="reportsAccessAllowedRoles" scope="request"/>
		<spring:eval expression="@settings.getProperty('security.editWidgetsLibraryAllowedRoles')" var="editWidgetsLibraryAllowedRoles" scope="request"/>
		<spring:eval expression="@settings.getProperty('security.upsAccessAllowedRoles')" var="upsAccessAllowedRoles" scope="request"/>
		<spring:eval expression="@settings.getProperty('security.upsQueriesAccessAllowedRoles')" var="upsQueriesAccessAllowedRoles" scope="request"/>
		
		<!-- Push comm only -->
        <spring:eval expression="@settings.getProperty('config.agentPushState').equalsIgnoreCase('on')" var="agentPushState" scope="request"/>

        <base href="${base}"/>
        <script src="resources/js/jquery-1.8.3.min.js"></script>
	    <script type='text/javascript' src="resources/js/jquery-ui.min.js"></script>
	    <script type='text/javascript' src="resources/js/jquery.ui.touch-punch.min.js"></script>
	    <script type='text/javascript' src='resources/js/jquery.colorbox-min.js'></script>
        <script src="resources/js/windowLocationHenhancer.js"></script>
        <script src="resources/js/menu.js"></script>
        <script src="resources/js/application.js"></script>

        <title><spring:message code="label.baseTitle"/> - <spring:message code="${titleCode}"/></title>
        <link rel="stylesheet" type="text/css" href="resources/css/ncr_screen.css">
        <!--[if lt IE 9]>
        <script type="text/javascript">
            document.createElement("nav");
            document.createElement("header");
            document.createElement("footer");
            document.createElement("section");
            document.createElement("article");
            document.createElement("aside");
            document.createElement("hgroup");
        </script>
        <![endif]-->
        <jsp:invoke fragment="header"/>
    </head>
    <body id="${section}">

        <header id="main_header">
            <div id="rButton" class="hide btn_close">

            </div>
            <h1>
                <a href="dashboard"><img src="resources/images/general/logo.png"/></a>
                <div id="headName"><span><acronym title="Hardware and Software Asset Management">HSAM</acronym></span></div>
            </h1>
            <div id="user_info">
               ${userMsg}
                <div id="lang" class="desplegable autofold">
                    <div class="txt content_hide">
                        <span><spring:message code="language.${pageContext.response.locale}"/></span>
                    </div>
                    <ul class="collapsible">
                        <li><a href="${currentUrl}?lang=es"><spring:message code="language.es"/></a></li>
                        <li><a href="${currentUrl}?lang=en"><spring:message code="language.en"/></a></li>
                    </ul>
                </div>
                <sec:authorize access="isAuthenticated()">
                    <div id="exit">
                        <a href="logout"><span><spring:message code="label.menu.logout"/></span></a>
                    </div>
                </sec:authorize>
            </div>
        </header>
        <nav id="main_nav" class="btn_close">
            <ul id="nav_icons">
                <sec:authorize access="hasAnyRole(${dashboardAccessAllowedRoles})">
	                <li class="dashboard">
	                    <a href="dashboard"><span><spring:message code="label.menu.dashboard"/></span></a>
	                </li>
                </sec:authorize>
                <sec:authorize access="hasAnyRole(${terminalsAccessAllowedRoles})">
	                <li class="terminals">
	                    <a href="terminals"><span><spring:message code="label.menu.terminals"/></span></a>
	                </li>
                </sec:authorize>
                <sec:authorize access="hasAnyRole(${upsAccessAllowedRoles})">
	                <li class="ups">
	                    <a id="upsLink" href="ups"><span><spring:message code="label.menu.ups"/></span></a>
	                </li>
                </sec:authorize>
                <sec:authorize access="hasAnyRole(${reportsAccessAllowedRoles})">
	                <li class="reports">
	                    <a href="externalreports"><span><spring:message code="label.menu.externalreports"/></span></a>
	                </li>
                </sec:authorize>
                <c:if test="${!agentPushState}">
	                <sec:authorize access="hasAnyRole(${schedulesAccessAllowedRoles})">
		                <li class="schedule">
		                    <a href="terminals/schedules/list"><span><spring:message code="label.menu.scheduler"/></span></a>
		                </li>
	                </sec:authorize>
                </c:if>
                <sec:authorize access="hasAnyRole(${usersAccessAllowedRoles})">
	                <li class="users">
	                    <a href="users"><span><spring:message code="label.menu.users"/></span></a>
	                </li>
                </sec:authorize>
                <sec:authorize access="hasAnyRole(${helpAccessAllowedRoles})">
	                <li class="help">
	                    <a href="help"><span><spring:message code="label.menu.help"/></span></a>
	                </li>
                </sec:authorize>
            </ul>
        </nav>

        <div id="main" class="btn_close">
            <div id="primary">
                <article>
                    <jsp:doBody/>
                </article>
            </div>
            <!-- /primary -->
        </div>
        <!-- /#main -->

    </body>
</html>
