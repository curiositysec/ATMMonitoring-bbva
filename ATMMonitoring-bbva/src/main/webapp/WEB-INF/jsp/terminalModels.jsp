<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:wrapper titleCode="label.terminalModelsManager" userMsg="${userMsg}">
<h1><spring:message code="label.terminalModelsManager"/></h1>

	<div class="box">
		<h2><spring:message code="label.terminalModels"/></h2>
		<div class="box-tableContainer">
			<c:if  test="${empty pagedListHolder.pageList}">
			<div class="empty-list"><spring:message code="label.terminalModel.noTerminalModels"/></div>
			</c:if>
			<c:if  test="${!empty pagedListHolder.pageList}">
				<t:terminalModelsTable terminalModels="${pagedListHolder.pageList}"/>
				<div class="pagingContainer">
				<t:paging pagedListHolder="${pagedListHolder}" pagedLink="terminalModels/list?p=~"/>
				</div>
			</c:if>
		</div>
	</div>
	
	<div class="box">
	<h2><spring:message code="label.newTerminalModel"/></h2>

	<form:form method="post" enctype="multipart/form-data" commandName="terminalModel">

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
	        <td class="header last-header"><form:label path="photo"><i><spring:message code="label.terminalModel.photo"/></i></form:label></td>
	        <td><input type="file" class='form-tf-grey' name="file"/></td>
	        <td class="error-td"><form:errors path="photo"/></td>
	    </tr>
		<tr><td colspan="2">
			<font size="2"><i><spring:message code="label.requiredFields"/></i></font>
			<input type="submit" class="form-submit" value="<spring:message code="label.terminalModel.addTerminalModel"/>" style="float: right;"/>
		</td></tr>
	</table>
	</form:form>
	</div>

</t:wrapper>