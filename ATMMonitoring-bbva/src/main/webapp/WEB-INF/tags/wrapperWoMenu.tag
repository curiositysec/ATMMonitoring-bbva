<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<%@attribute name="titleCode" %>
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
		<script src="resources/js/jquery-ui-1.9.2.custom.js"></script>
	    <title><spring:message code="label.baseTitle"/> - <spring:message code="${titleCode}"/></title>
		<link rel="stylesheet" type="text/css" href="resources/css/black-tie/jquery-ui-1.9.2.custom.css">
		<link rel="stylesheet" type="text/css" href="resources/css/atmMonitoring.css">
	</head>
	<body>
		<div style="text-align: center; width: 100%;">
			<div class="wide-horizontal" style="overflow: hidden; zoom: 1; margin: 0px auto; text-align: center;">
			    <script type="text/javascript">
					$(document).ready(function(){
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