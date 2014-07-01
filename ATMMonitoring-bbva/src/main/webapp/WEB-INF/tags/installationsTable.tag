<%@tag description="Installations Table" pageEncoding="UTF-8"%>
<%@attribute name="installations" required="true" type="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<table class="data subform">
<tr>
    <th width="135px"><i><spring:message code="label.installation.luCode"/></i></th>
    <th width="120px"><i><spring:message code="label.installation.type"/></i></th>
    <th width="110px"><i><spring:message code="label.installation.post"/></i></th>
    <th width="80px"><i><spring:message code="label.installation.processed"/></i></th>
    <th width="80px"><i><spring:message code="label.installation.startDate"/></i></th>
    <th width="80px"><i><spring:message code="label.installation.endDate"/></i></th>
    <th width="70px">&nbsp;</th>
</tr>
<c:set var="alt" value="${false}"/>
<c:forEach items="${installations}" var="installation">
    <tr <c:if test="${alt}">class="alt"</c:if>>
        <td width="135px"><a href="terminals/installations/details/${installation.id}">${installation.luCode}</a></td>
        <td width="120px">${installation.type}</td>
	    <td width="110px">${installation.post}</td>
        <td width="80px">${installation.processed}</td>
        <td width="80px"><fmt:formatDate value="${installation.startDate}" dateStyle="short" type="date" /></td>
        <td width="80px"><fmt:formatDate value="${installation.endDate}" dateStyle="short" type="date" /></td>
		<td width="70px" class="center-cell">
	        <button onClick="deleteInstallation(${installation.id})" class="form-submit"><spring:message code="label.installation.deleteInstallation"/></button>
		</td>
    </tr>
	<c:set var="alt" value="${!alt}"/>
</c:forEach>
</table>

<script type="text/javascript">
	function deleteInstallation(id) {
		var confirm = window.confirm('<spring:message code="label.installation.confirmDeletion"/>');
		if (confirm == true) {
			self.location = 'terminals/installations/delete/' + id;
		};
	};
</script>
