<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:wrapper titleCode="label.terminalModelsManager" userMsg="${userMsg}">

<div class="box">
<h2><spring:message code="label.terminalModelDetails"/></h2>

	<form:form method="post" enctype="multipart/form-data" action="terminals/models/update" commandName="terminalModel">
		<form:hidden path="id"/>
		<form:hidden path="photo"/>

		<div class="margin-box">
	    <table class="form">
	    <tr>
	        <td class="header first-header"><form:label path="model"><i><spring:message code="label.terminalModel.model"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="model" maxlength="50"/></td>
	        <td class="error-td"><form:errors path="model"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="manufacturer"><i><spring:message code="label.terminalModel.manufacturer"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="manufacturer" maxlength="50"/></td>
	        <td class="error-td"><form:errors path="manufacturer"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="photo"><i><spring:message code="label.terminalModel.currentPhoto"/></i></form:label></td>
	        <td><img src="terminals/models/image/${terminalModel.id}" /></td>
	    </tr>
	    <tr>
	        <td class="header last-header"><form:label path="photo"><i><spring:message code="label.terminalModel.newPhoto"/></i></form:label></td>
	        <td><input type="file" class='form-tf-grey' name="file"/></td>
	        <td class="error-td"><form:errors path="photo"/></td>
	    </tr>
		<tr><td colspan="2">
			<font size="2"><i><spring:message code="label.requiredFields"/></i></font>
			<input type="submit" class="form-submit" value="<spring:message code="label.terminalModel.updateTerminalModel"/>" style="float: right;"/>
		</td></tr>
	</table>
	</div>
	</form:form>
</div>

</t:wrapper>