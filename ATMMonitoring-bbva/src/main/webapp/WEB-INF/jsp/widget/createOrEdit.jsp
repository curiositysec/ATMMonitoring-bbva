<%@taglib tagdir="/WEB-INF/tags/widget/" prefix="widget" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapperWoMenu titleCode="label.terminalsManager" section="iframe">
<div id="main">
	<div id="primary">
		<article>
			<h1><spring:message code="widget.${operationType}.title" /></h1>
			<div class="content graph_content fixed">
				<form id="newWidgetForm" method="post" action="dashboard/save" >
					<widget:widgetFormContent />
				</form>				
			</div><!-- /content -->
		</article>
	</div>
</div>
</t:osoco-wrapperWoMenu>