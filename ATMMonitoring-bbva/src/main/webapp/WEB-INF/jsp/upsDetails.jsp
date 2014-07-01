<%@taglib tagdir="/WEB-INF/tags/ups/" prefix="ups" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.upsDetails" userMsg="${userMsg}" section="ups">
	<jsp:attribute name="header">
		<script type="text/javascript">
			function autoResize(id, newheight, isMobile) {
				if (!isMobile) {
					document.getElementById(id).height = newheight + "px";
				}
			}
		</script>
	</jsp:attribute>
	<jsp:body>
		<div id="header_g">
			<nav id="breadcrumb">
				<ul>
					<li><a href="dashboard"><spring:message code="breadcrumb.home" /></a></li>
					<li><a href="ups"><spring:message code="breadcrumb.ups" /></a></li>
					<li><spring:message code="label.ups"/> ${ups.seriesNumber}</li>
				</ul>
			</nav>
		</div>
		<div class="content">
			<h1>
				<spring:message code="label.ups" />
				${ups.seriesNumber}
			</h1>
		
			<div id="ajaxMsg"></div>
			<div class="action_box data desplegable">
				<h2 class="txt last">
					<spring:message code="label.upsDetails" />
				</h2>
				<div class="collapsible last">
					<div id="showUps" class="ul_data only_data">
						<ups:upsSummary />
					</div>
					<h3 class="txt last content_hide">
						<spring:message code="label.ups.originalXML" />
					</h3>
					<div class="collapsible last" style="display: none;">
						${ups.originalXML}
					</div>
				</div>
			</div>
		</div>
	</jsp:body>
</t:osoco-wrapper>