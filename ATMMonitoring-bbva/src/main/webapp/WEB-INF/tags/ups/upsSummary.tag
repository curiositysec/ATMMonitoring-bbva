<%@tag description="terminal summary" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@attribute name="ups" required="false" type="com.ncr.ATMMonitoring.pojo.Ups"%>


<ul>
	<li>
		<strong>
			<spring:message code="label.ups.seriesNumber"/>
		</strong>
		${ups.seriesNumber}
	</li>

	<li>
		<strong>
			<spring:message code="label.ups.ip"/>
		</strong>
		${ups.ip}
	</li>
	<li>
		<strong>
			<spring:message code="label.ups.model"/>
		</strong>
		${ups.model}
	</li>
	<li>
		<strong>
			<spring:message code="label.ups.alarmMsg"/>
		</strong>
		${ups.alarmMsg}
	</li>
	<li>
		<strong>
			<spring:message code="label.ups.audFmo"/>
		</strong>
		${ups.audFmo}
	</li>
	<li>
		<strong>
			<spring:message code="label.ups.autonomyMillisec"/>
		</strong>
		${ups.autonomyMillisec}
	</li>
	<li>
		<strong>
			<spring:message code="label.ups.chargePercentage"/>
		</strong>
		${ups.chargePercentage}
	</li>
	<li>
		<strong>
			<spring:message code="label.ups.expensePercentage"/>
		</strong>
		${ups.expensePercentage}
	</li>
	<li>
		<strong>
			<spring:message code="label.ups.firmware"/>
		</strong>
		${ups.firmware}
	</li>
	<li>
		<strong>
			<spring:message code="label.ups.generalStatusMsg"/>
		</strong>
		${ups.generalStatusMsg}
	</li>
	<li>
		<strong>
			<spring:message code="label.ups.lastExecutionDate"/>
		</strong>
		${ups.lastExecutionDate}
	</li>
	<li>
		<strong>
			<spring:message code="label.ups.numPosition"/>
		</strong>
		${ups.numPosition}
	</li>
	<li>
		<strong>
			<spring:message code="label.ups.runningStatus"/>
		</strong>
		${ups.runningStatus}
	</li>
	<li>
		<strong>
			<spring:message code="label.ups.runningTimeMillisec"/>
		</strong>
		${ups.runningTimeMillisec}
	</li>
	<li>
		<strong>
			<spring:message code="label.ups.type"/>
		</strong>
		${ups.type}
	</li>
</ul>
