<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:wrapper titleCode="label.installationsManager" userMsg="${userMsg}">

<div class="box">
<h2><spring:message code="label.installationDetails"/></h2>

	<form:form method="post" action="terminals/installations/update" commandName="installation">
		<form:hidden path="id"/>

		<div class="margin-box">
	    <table class="form">
	    <tr>
	        <td class="header first-header"><form:label path="luCode"><i><spring:message code="label.installation.luCode"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="luCode" maxlength="20"/></td>
	        <td class="error-td"><form:errors path="luCode"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="type"><i><spring:message code="label.installation.type"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="type" maxlength="50"/></td>
	        <td class="error-td"><form:errors path="type"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="post"><i><spring:message code="label.installation.post"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="post" maxlength="30"/></td>
	        <td class="error-td"><form:errors path="post"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="processed"><i><spring:message code="label.installation.processed"/></i></form:label></td>
	        <td><form:checkbox path="processed"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="startDate"><i><spring:message code="label.installation.startDate"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="startDate" maxlength="10"/></td>
	        <td class="error-td"><form:errors path="startDate"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="endDate"><i><spring:message code="label.installation.endDate"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="endDate" maxlength="10"/></td>
	        <td class="error-td"><form:errors path="endDate"/></td>
		</tr>
	    <tr>
	    	<td class="header last-header"><form:label path="location"><i><spring:message code="label.installation.location"/></i></form:label></td>
	    	<td>
	    		<form:select path="location.id" style="width: 100%;">
					<form:option value="" label=""/>
					<form:options items="${locationsList}" itemValue="id" itemLabel="office" />
				</form:select>
			</td>
		</tr>
		<tr><td colspan="2">
			<font size="2"><i><spring:message code="label.requiredFields"/></i></font>
			<input type="submit" class="form-submit" value="<spring:message code="label.installation.updateInstallation"/>" style="float: right;"/>
		</td></tr>
	</table>
	</div>
	</form:form>
</div>

</t:wrapper>