<%@tag description="Locations Table" pageEncoding="UTF-8"%>
<%@attribute name="locations" required="true" type="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<table class="data subform">
<tr>
    <th width="135px"><i><spring:message code="label.location.address"/></i></th>
    <th width="110px"><i><spring:message code="label.location.position"/></i></th>
    <th width="80px"><i><spring:message code="label.location.location"/></i></th>
    <th width="80px"><i><spring:message code="label.location.office"/></i></th>
    <th width="80px"><i><spring:message code="label.location.bank"/></i></th>
    <th width="70px">&nbsp;</th>
</tr>
<c:set var="alt" value="${false}"/>
<c:forEach items="${locations}" var="location">
    <tr <c:if test="${alt}">class="alt"</c:if>>
        <td width="135px"><a href="terminals/locations/details/${location.id}">${location.address}</a></td>
        <td width="110px">${location.position}</td>
        <td width="80px">${location.location}</td>
        <td width="80px">${location.office}</td>
        <td width="80px">${location.bank}</td>
		<td width="70px" class="center-cell">
	        <button onClick="deleteLocation(${location.id})" class="form-submit"><spring:message code="label.location.deleteLocation"/></button>
		</td>
    </tr>
	<c:set var="alt" value="${!alt}"/>
</c:forEach>
</table>

<script type="text/javascript">
	function deleteLocation(id) {
		var confirm = window.confirm('<spring:message code="label.location.confirmDeletion"/>');
		if (confirm == true) {
			self.location = 'terminals/locations/delete/' + id;
		};
	};
</script>
