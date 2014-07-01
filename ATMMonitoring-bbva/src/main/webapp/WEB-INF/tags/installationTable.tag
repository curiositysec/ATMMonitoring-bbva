<%@tag description="Installation table Table" pageEncoding="UTF-8"%>
<%@attribute name="installations" required="true" type="java.lang.Object"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<table>
    <tr>
        <th><spring:message code="label.location.office"/></th>
        <th><spring:message code="label.location.address"/></th>
        <th><spring:message code="label.creationDate"/></th>
        <th><spring:message code="label.installation.endDate"/></th>
        <th><spring:message code="label.terminal.ip"/></th>
        <th><spring:message code="label.installation.type"/></th>
        <th><spring:message code="label.installation.locationClass"/></th>
        <th><spring:message code="label.location.processed"/></th>
        <th><spring:message code="label.location.publicAccess"/></th>
    </tr>
    
    <c:choose>  
        <c:when test="${installations.getClass().getName() == 'com.ncr.ATMMonitoring.pojo.Installation'}">  
            <t:installationTableContent installation="${installations}"/>    
        </c:when>  
        <c:otherwise>  
            <c:forEach items="${installations}" var="installation" >
                <t:installationTableContent installation="${installation}"/>
            </c:forEach>    
        </c:otherwise>  
    </c:choose>  
</table>