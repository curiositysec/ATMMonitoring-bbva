<%@tag description="terminal summary" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@attribute name="terminal" required="false" type="com.ncr.ATMMonitoring.pojo.Terminal"%>


<ul>
	<li>
		<strong>
			<spring:message code="label.terminal.mac"/>
		</strong>
		${terminal.mac}
	</li>

	<li>
		<strong>
			<spring:message code="label.terminal.ip"/>
		</strong>
		${terminal.ip}
	</li>
	<li>
		<strong>
			<spring:message code="label.terminal.terminalVendor"/>
		</strong>
		${terminal.terminalVendor}
	</li>
	<li>
		<strong>
			<spring:message code="label.terminalModel.productClass"/>
		</strong>
		${terminal.terminalModel.productClass}
	</li>
	<li>
		<strong>
			<spring:message code="label.terminal.productClassDescription"/>
		</strong>
		${terminal.productClassDescription}
	</li>
	<li>
		<strong>
			<spring:message code="label.terminal.serialNumber"/>
		</strong>
		${terminal.serialNumber}
	</li>
	<li>
		<strong>
			<spring:message code="label.terminal.terminalType"/>
		</strong>
		${terminal.terminalType}
	</li>
	<li>
		<strong>
			<spring:message code="label.terminal.frontReplenish"/>
		</strong>
		${terminal.frontReplenish}
	</li>
	<li>
		<strong>
			<spring:message code="label.terminal.bank"/>
		</strong>
		${terminal.bank}
	</li>
	<li>
		<strong>
			<spring:message code="label.terminal.branch"/>
		</strong>
		${terminal.branch}
	</li>
	<li>
		<strong>
			<spring:message code="label.terminal.manufacturingSite"/>
		</strong>
		${terminal.manufacturingSite}
	</li>
	<li>
		<strong>
			<spring:message code="label.terminal.tracerNumber"/>
		</strong>
		${terminal.tracerNumber}
	</li>
</ul>
