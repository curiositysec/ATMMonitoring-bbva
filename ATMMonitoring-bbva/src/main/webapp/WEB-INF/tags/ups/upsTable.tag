<%@tag description="UPS's Table" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@taglib tagdir="/WEB-INF/tags/ups/" prefix="ups"%>
<%@attribute name="upss" required="true" type="java.util.List"%>
<%@attribute name="baseUrl" required="true" type="java.lang.String"%>
<%@attribute name="query" required="false" type="java.lang.Object"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%
    String[] upsColumns = { "seriesNumber" , "ip", "model", "chargePercentage",
		"generalStatusMsg", "runningStatus", "type"};
    request.setAttribute("upsColumns", upsColumns);
  
%>
<div class="table_buttons">
	<ups:upsTableButtons query="${query}"/>
	<div class="margin-box">
		<table class="link">
		  <thead>
		 <c:if test="${upss.size() > 1}">
		  <tr>
		    <!--th></th-->
		    <c:forEach items="${upsColumns}" var="column">
		      <c:set var="isColumnSorted" value="${column.equals(sort)}"/>
		      <c:set var="orderValue" value="${(isColumnSorted && 'asc'.equals(order)) ? 'desc' : 'asc'}"/>
		      <c:if test="${isColumnSorted}">
		        <c:set var="sortClass" value="${('asc'.equals(order)) ? 'top' : 'bottom'}"/>
		      </c:if>
		      <c:if test="${!isColumnSorted}">
		        <c:set var="sortClass" value=""/>
		      </c:if>
		      <th class="order ${sortClass}"><a href="${baseUrl}?p=${pagedListHolder.page}&queryId=${query.id}&sort=${column}&order=${orderValue}"><spring:message code="label.ups.${column}"/></a></th>
		    </c:forEach>
		  </tr>
		  </c:if>
		  <c:if test="${upss.size() == 1}">
		  <tr>
		    <!--th></th-->
		    <c:forEach items="${upsColumns}" var="column">
		      <th><spring:message code="label.ups.${column}"/></th>
		    </c:forEach>
		  </tr> 
		  </c:if>
		  </thead>
		  <tbody>
		  <c:forEach items="${upss}" var="ups">
		    <tr>
		      <!--td class="check"><input type="checkbox"/></td-->
		      <td><a href="ups/details/${ups.id}">${ups.seriesNumber}</a></td>
		      <td>${ups.ip}</td>
			  <td>${ups.model}</td>
		      <td>${ups.chargePercentage}</td>
		      <td>${ups.generalStatusMsg}</td>
		      <td>${ups.runningStatus}</td>
		      <td>${ups.type}</td>
		    </tr>
		  </c:forEach>
		  </tbody>
		</table>
	</div>
	<ups:upsTableButtons query="${query}"/>
</div>
<div class="pagination" id="pagination">
	<div class="t_number">
		<span class="text">
			${pagedListHolder.source.size()}
			<spring:message code="label.upss"/>
		</span>
	</div>
	<div class="p_number">
		<c:if test="${pagedListHolder.getPageCount() > 1 }">
		<span class="text">
			<spring:message code="label.page"/>
		</span>
		<t:paging pagedListHolder="${pagedListHolder}" 
				  pagedLink="ups/${(query != null)?'byQuery':'list'}?p=~&queryId=${query.id}&sort=${sort}&order=${order}"/>
		</c:if>
	</div>
</div>