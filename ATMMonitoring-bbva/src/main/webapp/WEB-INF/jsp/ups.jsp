<%@taglib tagdir="/WEB-INF/tags/ups/" prefix="ups" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.upss" userMsg="${userMsg}" section="ups">
	<jsp:attribute name="header">
		<script type="text/javascript">
				 function initPageJS() {
					loadHelpHTML('terminals',"#help_pop",'#queries'); 
					$("#queryHelp").click(function() {
						$("#queryHelp").colorbox({inline:true, href: "#help_pop"});
					});
				 }
		</script>
	</jsp:attribute>
	<jsp:body>
		<div id="header_g">
			<nav id="breadcrumb">
				<ul>
					<li><a href="dashboard"> <spring:message code="breadcrumb.home"/> </a> </li>
					<li> <spring:message code="breadcrumb.ups"/> </li>
				</ul>
			</nav>
		</div>
		<div  id="contentparent">
			<div class="content" id="contentUps">
				<h1>
					<spring:message code="label.upss"/>
				</h1>
				<sec:authorize access="hasAnyRole(${upsQueriesAccessAllowedRoles})">
					<ups:upsQueryForm userQueries="${userQueries}" selectedQuery="${query}" />
				</sec:authorize>
				<c:if test="${timeout}">
					<div class="message">
						<p>${timeout}</p>
					</div>
				</c:if>
				<c:if test="${success}">
					<div class="notification">
						<p>${success}</p>
					</div>
				</c:if>
				<div id="ajaxMsg"><p id="ajaxMsg"></p></div>
				<c:if  test="${empty pagedListHolder.pageList}">
					<div class="message">
						<p> <spring:message code="label.ups.noUpss"/> </p>
					</div>
				</c:if>
				<c:if  test="${!empty pagedListHolder.pageList}">
					<h2 id="upsTotalResult"> 
					    ${pagedListHolder.source.size()}
						<spring:message code="label.upss"/>
		
						<c:if test="${query != null}">
							<spring:message code="label.forquery"/> : ${query.name}
							<a href="upsQueries/show?queryId=${query.id}" class="edit">
								<span> <g:message code="label.edit"/> </span>
							</a>
						</c:if>
					</h2>
					<div id="pagTable">
						<ups:upsTable upss="${pagedListHolder.pageList}" baseUrl="${query != null ? 'ups/byQuery' : 'ups/list'}"
				                             query="${selectedQuery}"/>
					</div>
				</c:if>
				<div class="hide">
					<div id="help_pop" class="inline" style="width:800px;height: 500px">
						
					</div>
				</div>
			</div>
		</div>
	</jsp:body>
</t:osoco-wrapper>