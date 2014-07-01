<%@tag description="TerminalModels Table" pageEncoding="UTF-8"%>
<%@attribute name="terminalModels" required="true" type="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<table class="data subform">
<tr>
    <th width="135px"><i><spring:message code="label.terminalModel.model"/></i></th>
    <th width="120px"><i><spring:message code="label.terminalModel.manufacturer"/></i></th>
    <th width="70px">&nbsp;</th>
</tr>
<c:set var="alt" value="${false}"/>
<c:forEach items="${terminalModels}" var="terminalModel">
    <tr <c:if test="${alt}">class="alt"</c:if>>
        <td width="135px"><a href="terminals/models/details/${terminalModel.id}">${terminalModel.model}</a></td>
        <td width="120px">${terminalModel.manufacturer}</td>
		<td width="70px" class="center-cell">
	        <button onClick="deleteTerminalModel(${terminalModel.id})" class="form-submit"><spring:message code="label.terminalModel.deleteTerminalModel"/></button>
		</td>
    </tr>
	<c:set var="alt" value="${!alt}"/>
</c:forEach>
</table>

<script type="text/javascript">
	function deleteTerminalModel(id) {
		var confirm = window.confirm('<spring:message code="label.terminalModel.confirmDeletion"/>');
		if (confirm == true) {
			self.location = 'terminals/models/delete/' + id;
		};
	};
</script>
