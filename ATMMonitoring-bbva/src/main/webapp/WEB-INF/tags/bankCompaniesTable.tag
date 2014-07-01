<%@tag description="BankCompanies Table" pageEncoding="UTF-8"%>
<%@attribute name="bankCompanies" required="true" type="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<table class="data subform">
<tr>
    <th width="135px"><i><spring:message code="label.bankCompany.name"/></i></th>
    <th width="120px"><i><spring:message code="label.bankCompany.vatIN"/></i></th>
    <th width="120px"><i><spring:message code="label.bankCompany.parentCompany"/></i></th>
    <th width="70px">&nbsp;</th>
</tr>
<c:set var="alt" value="${false}"/>
<c:forEach items="${bankCompanies}" var="bankCompany">
    <tr <c:if test="${alt}">class="alt"</c:if>>
        <td width="135px"><a href="banks/details/${bankCompany.id}">${bankCompany.name}</a></td>
        <td width="120px">${bankCompany.vatIN}</td>
        <td width="120px">${bankCompany.parentCompany.name}</td>
		<td width="70px" class="center-cell">
	        <button onClick="deleteBankCompany(${bankCompany.id})" class="form-submit"><spring:message code="label.bankCompany.deleteBankCompany"/></button>
		</td>
    </tr>
	<c:set var="alt" value="${!alt}"/>
</c:forEach>
</table>

<script type="text/javascript">
	function deleteBankCompany(id) {
		var confirm = window.confirm('<spring:message code="label.bankCompany.confirmDeletion"/>');
		if (confirm == true) {
			self.location = 'banks/delete/' + id;
		};
	};
</script>
