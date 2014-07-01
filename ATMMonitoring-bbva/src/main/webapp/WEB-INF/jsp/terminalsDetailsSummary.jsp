<%@taglib prefix="terminal" tagdir="/WEB-INF/tags/terminal/" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<div class="summaryContent contendorDelDesplegable" >
	<c:if test="${terminals.size() > 1}">
		<h2> ${terminals.size()} <spring:message code="label.terminals"/></h2>
		<c:set var="hideContentClass" value="hide" />
	</c:if> 
	
	<div class="action_box data desplegable">
		<c:forEach items="${terminals}" var="terminal">
			<div class="margin-box">
				<h3 class="txt content_${hideContentClass}"> <spring:message code="label.terminal"/> ${terminal.mac}</h3>
				<div class="margin-box collapsible ${hideContentClass} ul_data">
					<terminal:terminalSummary terminal="${terminal}"/>
					
					<div class="botonera">
						<a class="btn" onclick="loadInnerSection('#primary','terminals/details/${terminal.id}?dateTime=${queryDate.time}')">
							<spring:message code="label.terminal.map.summary.show" />
				 		</a>
					</div>
				</div>	
			</div>
		</c:forEach>
	</div>
</div>
