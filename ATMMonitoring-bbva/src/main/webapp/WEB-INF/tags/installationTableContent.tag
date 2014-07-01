<%@tag description="Installation table content" pageEncoding="UTF-8"%>
<%@attribute name="installation" required="true" type="com.ncr.ATMMonitoring.pojo.Installation"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tr>
  <td>${installation.location.office}</td>
  <td>${installation.location.completeAddress}</td>
  <td>${installation.startDate}</td>
  <td>${installation.endDate}</td>
  <td>${installation.ip}</td>
  <td>${installation.type}</td>
  <c:choose>
      <c:when  test="${(installation.locationClass != null) && (installation.locationClass.length() > 0)}">
          <td><spring:message code="label.installation.${installation.locationClass}"/></td>
      </c:when>
      <c:otherwise>
      <td></td>
      </c:otherwise>
  </c:choose>
  <td>${installation.processed}</td>
  <td>${installation.location.publicAccess}</td>
</tr>