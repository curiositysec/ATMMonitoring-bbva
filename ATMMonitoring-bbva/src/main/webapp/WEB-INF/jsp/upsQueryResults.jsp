<%@taglib tagdir="/WEB-INF/tags/ups/" prefix="ups"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.queryEngine" userMsg="${userMsg}"
	section="ups">

	<jsp:attribute name="header">
    <script type="text/javascript" src="resources/js/purl.js"></script>
    <script type="text/javascript">
        $(function() {
	        $("#editQuery").click(function(event) {
		        if ($(this).hasClass('content_hide')) {
	                $(this).removeClass('content_hide');
	                $("#submits").prepend($("#saveQuery"));
	                $(this).next('.collapsible').show('slow');
		        } else {
	                $(this).next('.collapsible').hide('slow');
	                $(this).parent().prepend($("#saveQuery"));
	                $(this).addClass('content_hide');
		        }
	        });
            $(".pagingItem").click(function(event) {
                executeQuery(event);
            });
            $(".order").click(function(event) {
                executeQuery(event);
            });
	    });

        function executeQuery(event) {
            event.preventDefault();
            var url = $(event.target).attr("href") ?
                $(event.target).attr("href") :
                $(event.target).find("a").attr("href")
            var page = $.url(url).param("p");
            var sort = $.url(url).param("sort");
            var order = $.url(url).param("order");
            populateHiddenFields(page, sort, order);
            submitExecuteQuery();
        }

        function populateHiddenFields(page, sort, order) {
            $("#queryForm input[name='p']").val(page);
            $("#queryForm input[name='sort']").val(sort);
            $("#queryForm input[name='order']").val(order);
        }

        function submitExecuteQuery() {
            var nameElement = $("<input type='hidden' name='execute'/>");
            $("#queryForm").append(nameElement);
            $("#queryForm").submit();
        }
  </script>
</jsp:attribute>

	<jsp:body>

				<div id="header_g">
					<nav id="breadcrumb">
						<ul>
							<li>
								<a href="#"><spring:message code="breadcrumb.home" /></a>
							</li>
							<li><a href="ups"><spring:message code="breadcrumb.ups" /></a></li>
							<li><a href="upsQueries"><spring:message
								code="label.queries.mine" /></a></li>
							<li>
						            <c:if test="${query.name != null}">
				 	   		    	   ${query.name}
						            </c:if>
 							    <c:if test="${query.name == ''}">
							        <spring:message code="label.query.new" />
						            </c:if>
							</li>
						</ul>
					</nav>
				</div>

				<div class="content">
        			 <h1>
						<c:if test="${query.name != null}">
					 	    ${query.name}
						</c:if>
						<c:if test="${query.name ==  ''}">
					            <spring:message code="label.query.new" />
					        </c:if>
					</h1>
				<div class="botonera">
				<a href="queries" class="btn back left"><spring:message
						code="label.query.return" /></a>
			</div>
	<!-- Pegado de upsquerie.jsp -->
	<form:form method="post" action="upsQueries/results" commandName="query">
      <input type="hidden" name="p" value="${p}"/>
      <input type="hidden" name="sort" value="${sort}"/>
      <input type="hidden" name="order" value="${order}"/>
				<div class="action_box desplegable">

					<div id="saveQuery" class="desplegable button txt_btn">
						<div class="btn txt content_hide"><spring:message code="label.query.save"/></div>
						<div class="hide collapsible">
							<ul>
								<li><label for="namequery"><spring:message code="label.name"/></label> <form:input type="text" path="name"/></li>
								<li><label for="descriptionquery"><spring:message code="label.description"/></label> <form:textarea path="description"/></li>
							</ul>
                                                         <form:hidden path="id" value="${query.id}"/>

							<div class="botonera">
                              <input type="submit" id="save" name="save" class="save" value="<spring:message code="label.save"/>"/>
                            </div>
                        </div>
                        </div>

                        <h2 id="editQuery" class="last content_hide"><spring:message code="label.query.edit"/></h2>

					<div class="collapsible last hide">

						<h2 class="txt" id="upsSection">
							<spring:message code="label.upsQuery.upsSection"/>
						</h2>
						
						<div class="collapsible">
							<table class="query-form">
								<tr>
									<th>
										<spring:message code="label.query.field"/>
									</th>
									<th>
										<spring:message code="label.query.not"/>
									</th>
									<th>
										<spring:message code="label.query.comparison"/>
									</th>
									<th>
										<spring:message code="label.query.value"/>
									</th>
									<th></th>
								</tr>
								<c:forEach var="i" begin="1" end="5" varStatus="status">
									<tr id="upsRow${i}" <c:if test="${!status.first}">class="hidden"</c:if>
									>
									<td>
										<form:select path="upsCombo${i}1" id="upsCombo${i}1" class="query_selectors" size="1" onchange="ChangeValue2CB1('ups',${i})">
											<form:option value="" label=""/>
											<c:forEach items="${values.get('ups').keySet()}" var="value">
												<form:option value="${value}">
													<spring:message code="label.ups.${value}"/>
												</form:option>
											</c:forEach>
										</form:select>
									</td>
									<td>
										<form:checkbox path="upsCB${i}" id="upsCB${i}" disabled="true"/>
									</td>
									<td>
										<form:select path="upsCombo${i}2" id="upsCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="ChangeValue2CB2('ups',${i})">
											<form:option value="" label=""/>
											<c:forEach items="${values.get('allOperations').get('allOperations').keySet()}" var="value">
												<form:option value="${value}">
													<spring:message code="label.query.operation.${value}"/>
												</form:option>
											</c:forEach>
										</form:select>
									</td>
									<td>
										<form:input class='form-tf-grey' path="upsField${i}" id="upsField${i}" disabled="true" maxlength="150"/>
										<br></td>
									<c:if test="${!status.last}">
										<td class="btn_add">
											<div id="upsShowButton${i}" onclick="showHiddenRow('ups', ${i})" class="btn add"><span><spring:message code="label.query.add"/></span></div>
										</td>
									</c:if>
								</tr>
							</c:forEach>
						</table>
						</div>
<div id="submits" class="botonera">
	<input type="submit" class="form-submit" name="execute" id="execute" value="<spring:message code="label.query.execute"/>"/>
	<input type="submit" class="delete right" name="delete" id="delete" value="<spring:message code="label.delete"/>" onclick="return confirm('<spring:message code="label.query.confirmDeletion"/>')"/>
	<input type="reset" class="cancel right" value="<spring:message code="label.cancel"/>" />
</div>
</div>

</div>
</form:form>


<script type="text/javascript">

	$(document).ready(function(){
		<t:upsQueryCbJs query="${query}"/>
		$('#queryName').val('');
		displayOnLoad('ups', 5);
	});
	var valuesTree = {
	    	<c:forEach items="${values.keySet()}" var="key" varStatus="status1">
	    		<c:set var="value" value="${values.get(key)}"/>
	   	 '${key}': {
				<c:forEach items="${value.keySet()}" var="subkey" varStatus="status2">
	        		<c:set var="subvalue" value="${value.get(subkey)}"/>
					'${subkey}': 
						{
							label: <c:if test="${(key != 'allOperations') && (subkey != 'allHwDevices')}">'<spring:message code="label.${key}.${subkey}"/>'</c:if><c:if test="${(key == 'allOperations') || (subkey == 'allHwDevices')}">''</c:if>,
							values: {
								<c:forEach items="${subvalue.keySet()}" var="subsubkey" varStatus="status3">
				        		<c:set var="subsubvalue" value="${subvalue.get(subsubkey)}"/>
								'${subsubkey}': 
									{
										<c:if test="${subsubvalue.getClass().getSimpleName() == 'TreeMap'}">
										label: <c:if test="${key != 'allOperations'}">'<spring:message code="label.${key}.${subsubkey}"/>'</c:if><c:if test="${key == 'allOperations'}">''</c:if>,
										values: {
											<c:forEach items="${subsubvalue.keySet()}" var="subsubsubkey" varStatus="status4">
							        		<c:set var="subsubsubvalue" value="${subsubvalue.get(subsubsubkey)}"/>
											'${subsubsubkey}': 
											{
												label: '<spring:message code="label.query.operation.${subsubsubkey}"/>',
												values: ${subsubsubvalue}
											}${not status4.last ? ',' : ''}
											</c:forEach>
										}
										</c:if>
										<c:if test="${subsubvalue.getClass().getSimpleName() != 'TreeMap'}">
										label: '<spring:message code="label.query.operation.${subsubkey}"/>',
										values: ${subsubvalue}
										</c:if>
									}${not status3.last ? ',' : ''}
								</c:forEach>
							}
						}${not status2.last ? ',' : ''}
				</c:forEach>
	   	 			}${not status1.last ? ',' : ''}
	   		</c:forEach>
	};
	function displayOnLoad(name, maxValue) {
		for (i=maxValue; i>1; i--) {
			if ($('#' + name + 'Combo' + i + '1').val() != '') {
				for (j=1; j<i; j++) {
	    			showHiddenRow(name, j);
				}
				break;
			}
		}
	};
	function onLoadValueCB2(entity, maxNumber){
		for (var number = 1; number <= maxNumber; number++) {
	    	var value = $('#' + entity + 'Combo' + number + '1').val();
	    	var $cb = $('#' + entity + 'Combo' + number + '2');
	    	if (value == '') {
	    		$cb.empty();
				$cb.append($('<option selected="selected"></option>'));
	    	} else {
	    		$cb.prop('disabled', false);
	    		var values = valuesTree[entity][value].values;
	    		$('#' + entity + 'Combo' + number + '2 > option').each(function()
						{
							if (!(($(this).val() in values) || ($(this).val() == ''))) {
								$(this).remove();
							}
						}
	    		);
	    		if ($cb.val() != '') {
	    			$('#' + entity + 'Field' + number).prop('disabled', false);
	    		}
	    	}
		}
	};
	function ChangeValue2CB1(entity, number){
		var $cb = $('#' + entity + 'Combo' + number + '2');
		$cb.empty();
		$cb.append($('<option selected="selected"></option>'));
		if ($('#' + entity + 'Combo' + number + '1').val() != '') {
			var values = valuesTree[entity][$('#' + entity + 'Combo' + number + '1').val()].values;
			var keys = $.map(values, function(v, i){
				  return i;
				});
			keys.sort(function(a,b){
			    var compA = values[a].label;
			    var compB = values[b].label;
			    return (compA < compB) ? -1 : (compA > compB) ? 1 : 0;
			  });
			$.each(keys, function(index, key) {
				  $cb.append($('<option/>')
				     .attr("value", key).text(values[key].label));
			});
		    $('#' + entity + 'CB' + number).prop('disabled', false);
			$cb.prop('disabled', false);
		} else {
		    $('#' + entity + 'CB' + number).prop('disabled', true);
			$cb.prop('disabled', true);
		};
	    $('#' + entity + 'Field' + number).prop('disabled', true);
	};
	function ChangeValue2CB2(entity, number){
		if ($('#' + entity + 'Combo' + number + '2').val() != '') {
			if (valuesTree[entity][$('#' + entity + 'Combo' + number + '1').val()].values[$('#' + entity + 'Combo' + number + '2').val()].values) {
			    $('#' + entity + 'Field' + number).prop('disabled', false);
			} else {
				$('#' + entity + 'Field' + number).prop('disabled', true);
			}
		} else {
		    $('#' + entity + 'Field' + number).prop('disabled', true);
		};
	};
	function checkSaveExecute() {
		if ($('#queryName').val().length > 0) {
			if ($("#save_execute").button("option", "disabled")) {
				$("#save_execute").button("option", "disabled", false);
			}
		} else {
			if (!$("#save_execute").button("option", "disabled")) {
				$("#save_execute").button("option", "disabled", true);
			}
		}
	}
	function showHiddenRow(name, rowNumber) {
		$('#' + name + 'Row' + (rowNumber + 1)).removeClass('hidden');
		$('#' + name + 'ShowButton' + rowNumber).addClass('hidden');
	}
	function userQuerySelected()
	{
		document.userQueriesForm.submit();
	}
    </script>
		<!-- // pegado de queries.jsp -->
	<div class="box-tableContainer">
		<c:if test="${empty pagedListHolder.pageList}">
		<div class="message">
		     <spring:message code="label.query.noResults" />
                </div>
		</c:if>
		<c:if test="${!empty pagedListHolder.pageList}">
		<h2>${pagedListHolder.source.size()} <spring:message
						code="label.results" />
				</h2>
		  <ups:upsTable baseUrl="upsQueries/results"
					upss="${pagedListHolder.pageList}" query="${query}" />
		    <script type="text/javascript">
		      $(function() {
		          $("#exportUps").click(function(event) {
		              $("#exportForm").submit();
		              event.preventDefault();
		          });
		      });
		    </script>  
            <form:form id="exportForm" method="post"
					action="upsQueries/results/export" commandName="query" target="_blank">
              <input type="hidden" name="sort" value="${sort}" />
              <input type="hidden" name="order" value="${order}" />
				<c:forEach var="i" begin="1" end="5">
					<form:hidden path="upsCombo${i}1" />
					<form:hidden path="upsCB${i}" />
					<form:hidden path="upsCombo${i}2" />
					<form:hidden path="upsField${i}" />
				</c:forEach>
            </form:form>
		</c:if>
	</div>
</div>

</jsp:body>

</t:osoco-wrapper>
