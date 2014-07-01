<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:wrapper titleCode="label.bankCompaniesManager" userMsg="${userMsg}">

<div class="box">
<h2><spring:message code="label.bankCompanyDetails"/></h2>

	<form:form method="post" action="banks/update" commandName="bankCompany">
		<form:hidden path="id"/>

		<div class="margin-box">
	    <table class="form">
	    <tr>
	        <td class="header first-header"><form:label path="name"><i><spring:message code="label.bankCompany.name"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="name" maxlength="20"/></td>
	        <td class="error-td"><form:errors path="name"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="vatIN"><i><spring:message code="label.bankCompany.vatIN"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="vatIN" maxlength="50"/></td>
	        <td class="error-td"><form:errors path="vatIN"/></td>
	    </tr>
	    <tr>
	    	<td class="header last-header"><form:label path="parentCompany"><i><spring:message code="label.bankCompany.parentCompany"/></i></form:label></td>
	    	<td>
	    		<form:select path="parentCompany.id" style="width: 100%;">
					<form:option value="" label=""/>
					<form:options items="${bankCompaniesList}" itemValue="id" itemLabel="name" />
				</form:select>
			</td>
		</tr>
		<tr><td colspan="2">
			<font size="2"><i><spring:message code="label.requiredFields"/></i></font>
			<input type="submit" class="form-submit" value="<spring:message code="label.bankCompany.updateBankCompany"/>" style="float: right;"/>
		</td></tr>
	</table>
	</div>
	</form:form>
</div>

</t:wrapper>