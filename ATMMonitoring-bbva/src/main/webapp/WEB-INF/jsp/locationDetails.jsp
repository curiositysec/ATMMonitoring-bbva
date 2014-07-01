<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:wrapper titleCode="label.locationsManager" userMsg="${userMsg}">

<div class="box">
<h2><spring:message code="label.locationDetails"/></h2>

	<form:form method="post" action="terminals/locations/update" commandName="location">
		<form:hidden path="id"/>

		<div class="margin-box">
	    <table class="form">
	    <tr>
	        <td class="header first-header"><form:label path="address"><i><spring:message code="label.location.address"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="address" maxlength="80"/></td>
	        <td class="error-td"><form:errors path="address"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="coordX"><i><spring:message code="label.location.coordX"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="coordX" maxlength="30"/></td>
	        <td class="error-td"><form:errors path="coordX"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="coordY"><i><spring:message code="label.location.coordY"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="coordY" maxlength="30"/></td>
	        <td class="error-td"><form:errors path="coordY"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="position"><i><spring:message code="label.location.position"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="position" maxlength="50"/></td>
	        <td class="error-td"><form:errors path="position"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="location"><i><spring:message code="label.location.location"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="location" maxlength="30"/></td>
	        <td class="error-td"><form:errors path="location"/></td>
		</tr>
	    <tr>
	        <td class="header"><form:label path="office"><i><spring:message code="label.location.office"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="office" maxlength="20"/></td>
	        <td class="error-td"><form:errors path="office"/></td>
		</tr>
	    <tr>
	        <td class="header"><form:label path="bank"><i><spring:message code="label.location.bank"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="bank" maxlength="20"/></td>
	        <td class="error-td"><form:errors path="bank"/></td>
		</tr>
	    <tr>
	        <td class="header"><form:label path="bankCompany"><i><spring:message code="label.location.bankCompany"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="bankCompany" maxlength="20"/></td>
	        <td class="error-td"><form:errors path="bankCompany"/></td>
		</tr>
	    <tr>
	        <td class="header"><form:label path="ip"><i><spring:message code="label.location.ip"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="ip" maxlength="20"/></td>
	        <td class="error-td"><form:errors path="ip"/></td>
		</tr>
	    <tr>
	        <td class="header last-header"><form:label path="publicAccess"><i><spring:message code="label.location.publicAccess"/></i></form:label></td>
	        <td><form:checkbox path="publicAccess"/></td>
	    </tr>
		<tr><td colspan="2">
			<font size="2"><i><spring:message code="label.requiredFields"/></i></font>
			<input type="submit" class="form-submit" value="<spring:message code="label.location.updateLocation"/>" style="float: right;"/>
		</td></tr>
	</table>
	</div>
	</form:form>
</div>

</t:wrapper>