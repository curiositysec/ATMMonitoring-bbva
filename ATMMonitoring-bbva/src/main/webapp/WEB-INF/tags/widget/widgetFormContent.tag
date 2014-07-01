<%@tag description="New widget form content" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<input type="hidden" name="id" value="${widget.id}" />

<div class="row">
	<label for="name"><spring:message code="widget.name.label" /></label>
	<input type="text" id="name" name="title" required="" value="${widget.title}">
</div>
<h2><spring:message code="widget.chartType.label" /></h2>
<div id="inputGraph" class="graph_component">
	<c:set var="index" value="0" />
	<c:forEach var="chartType" items="${chartTypes}">
		<label class="graph graph_0${index + 1}">
			<span><spring:message code="ChartType.${chartType.name()}" /></span>
			<input type="radio" class="inputGraph" value="${chartType.name()}" name="chartType" id="chartType" 
			       required="" ${chartType == widget.chartType ? 'checked' : '' }/> 
		</label>
		<c:set var="index" value="${index + 1}" />
	</c:forEach>
</div>

<div id="GEO_CHART" class="chartTypeFields hide">
	<div class="row">
		<label for="region"><spring:message code="widget.region.title"/></label>
		<select id="region" name="region" size="1">
			<c:forEach items="${regionTypes}" var="regionType">
				<option value="${regionType.name()}" ${regionType == widget.region ? 'selected' : '' }>
					<spring:message code="RegionType.${regionType.name()}"/>
				</option>
			</c:forEach>
		</select>		
	</div>
</div>

<div class="row">
	<label for="apquery"><spring:message code="widget.query.label" /></label>
	<select name="query.id" size="1" required="">
		<option value="" ><spring:message code="label.select.default"/></option>
		<c:forEach items="${userQueries}" var="userQuery">
			<option value="${userQuery.id}" ${userQuery.id == widget.query.id ? 'selected' : '' }>
				${userQuery.name}
			</option>
		</c:forEach>
	</select>	
</div>

<div class="row">
	<label for="queryDate"><spring:message code="widget.queryDate.label" /> </label>
	<input type="text" id="queryDate" name="queryDate" 
		   value="<fmt:formatDate value="${widget.queryDate}" pattern="dd/MM/yyyy" />"/>
 		   
	<a href="" id="queryDateButton" class="btn calendar">
		<span>
			<spring:message code="label.calendar.open"/>
		</span>
	</a>
</div>

<div class="charTypeGroupByFields">	
	<input type="hidden" class="groupByEntitySelectValue" name="groupByEntity" value="${widget.groupByEntity}"/>
	<div class="row">
		<label><spring:message code="widget.join.label" /> </label>
		
		<select id="groupByEntity" required=""> 
			<option value="" ><spring:message code="label.select.default"/></option>
			<c:forEach items="${queryTypes}" var="queryType">
				<option value="${queryType.name()}" ${queryType == widget.groupByEntity ? 'selected' : '' } >
					<spring:message code="WidgetQueryAssociationType.${queryType}" />
				</option>
			</c:forEach>
		</select>
	</div>
		
	<c:forEach items="${queryTypes}" var="queryType">
		<div id="${queryType.name()}" class="row hide queryTypeValueRows">
			<label></label>
			<select id="groupBy" name="groupBy" disabled="disabled">
				<option value="" ><spring:message code="label.select.default"/></option>
				<c:forEach items="${queryType.comboboxes}" var="groupByField">
					<option value="${groupByField.key}" ${groupByField.key == widget.groupBy ? 'selected' : '' }>
						<spring:message code="${queryType.buildI18nMessage(groupByField.key)}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</c:forEach>
</div>		


<div class="botonera">
	<input type="submit" class="btn next" value="<spring:message code="widget.${operationType}.button.label"/>">
</div>

<script type="text/javascript">
$(function() {
	var queryTypeSelectRestrictions = { 'GEO_CHART' : 'GEO_INFO' }
	
	var chartTypeRadios = $("input#chartType");
	var chartTypeFieldsDivs = $("div.chartTypeFields");
	var chartTypeFieldSelects = chartTypeFieldsDivs.find("select");
	
	init();
	
	function init() {
		chartTypeRadios.change(function(event) {
			var selectedRadio = $(this);
			onRadioChanged(selectedRadio);
		});
		
		var selectedRadio = chartTypeRadios.filter(':checked');
		onRadioChanged(selectedRadio);
	}
	
	function onRadioChanged(selectedRadio) {
		var selectedRadioValue = selectedRadio.val()
		addSelectedClass(selectedRadio)
		showChartTypeFields(selectedRadioValue);
		applyQueryTypeSelectRestrictions(selectedRadioValue);
	}
	
	function addSelectHiddenValueToForm(value) {
		chartTypeFieldSelects.parent
	}
	
	function addSelectedClass(selectedRadio) {
		chartTypeRadios.parent().removeClass('current');
		selectedRadio.parent().addClass('current')
	}
	
	function showChartTypeFields(chartType) {
		chartTypeFieldsDivs.hide();
	    chartTypeFieldSelects.attr("disabled", "disabled");
		chartTypeFieldSelects.removeAttr("required");
		
		chartTypeFieldsDivs.filter('#' + chartType).show();
		chartTypeFieldsDivs.filter('#' + chartType).find('select').removeAttr('disabled');
	}
	
	function applyQueryTypeSelectRestrictions(selectedValue) {
		var valueToSetFixed = queryTypeSelectRestrictions[selectedValue]
		var queryTypeSelect = $('select#groupByEntity');
		if(valueToSetFixed) {
			queryTypeSelect.val(valueToSetFixed);
			queryTypeSelect.attr("disabled", "disabled");
			queryTypeSelect.change();
		} else {
			queryTypeSelect.removeAttr("disabled");
		}
	}
	
});

$(function() {
	var groupByEntitySelectValueInput = $('input.groupByEntitySelectValue');
	var groupByEntitySelect = $('select#groupByEntity');
	var queryTypeValueRows = $("div.queryTypeValueRows");
	var queryTypeValuesByRow = $("div.queryTypeValueRows select#groupBy");
	
	initSelectChangeListener();
	initSelectValues();
	
	function initSelectChangeListener() {
		groupByEntitySelect.change(function(event) {
			var queryTypeSelect = $(this);
			var queryType = queryTypeSelect.val();
			
			if(queryType) {
				groupByEntitySelectValueInput.val(queryType);
				
				queryTypeValueRows.addClass("hide");
				queryTypeValuesByRow.attr("disabled", "disabled");
				queryTypeValuesByRow.removeAttr("required");
				
				$('div#' + queryType).removeClass("hide");
				var groupBySelectByQueryType = getGroupBySelectByQueryType(queryType);
				groupBySelectByQueryType.removeAttr("disabled");
				groupBySelectByQueryType.attr("required", "required");
			}	
		})
	}
	
	function initSelectValues() {
		groupByEntitySelect.change();
	}
		
	function getGroupBySelectByQueryType(queryType) {
		return $('div#' + queryType + ' select#groupBy');
	}
});

$(function() {
	initQueryDateInput();	
	function initQueryDateInput() {
		var inputQueryDate = $("input#queryDate"); 
		inputQueryDate.datepicker({ dateFormat: "dd/mm/yy" });
	    $('#queryDateButton').click(function(event) {
	        event.preventDefault();
	        inputQueryDate.datepicker("show");
		});
	}
});

</script>