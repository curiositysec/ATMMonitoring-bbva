<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:wrapper titleCode="label.scheduledUpdatesManager" userMsg="${userMsg}" >

<style type="text/css">
<c:if  test="${(!empty weeklyScheduledUpdates) || (!empty monthlyScheduledUpdates)}">
/* define height and width of scrollable area. Add 16px to width for scrollbar          */
div.tableContainer {
	height: 440px;
	width: 277px;
}

/* define width of table. IE browsers only                 */
div.tableContainer table {
	width: 277px
}

/* define width of table. Add 16px to width for scrollbar.           */
/* All other non-IE browsers.                                        */
html>body div.tableContainer table {
	width: 277px;
}

html>body tbody.scrollContent {
	height: 413px;
}
</c:if>
</style>
 
<h1><spring:message code="label.scheduledUpdatesManager"/></h1>

<div class="box">
<h2><spring:message code="label.weeklyScheduledUpdates"/></h2>
<div class="margin-box">
<c:if  test="${empty weeklyScheduledUpdates}">
<div class="empty-list"><spring:message code="label.scheduledUpdates.noWeeklyScheduledUpdates"/></div>
</c:if>
<c:if  test="${!empty weeklyScheduledUpdates}">
<c:choose>
<c:when  test="${weeklyScheduledUpdates.size() > 10}">
<div id="tableContainer" class="tableContainer">
<table class="data">
<thead class="fixedHeader">
</c:when>
<c:otherwise>
<table class="data">
</c:otherwise>
</c:choose>
<tr>
    <th width="100px"><i><spring:message code="label.scheduledUpdate.name"/></i></th>
    <th width="100px"><i><spring:message code="label.scheduledUpdate.description"/></i></th>
    <th width="100px"><i><spring:message code="label.scheduledUpdate.startDate"/></i></th>
    <th width="100px"><i><spring:message code="label.scheduledUpdate.weekDay"/></i></th>
    <th width="100px"><i><spring:message code="label.scheduledUpdate.time"/></i></th>
    <th width="100px"><i><spring:message code="label.scheduledUpdate.query"/></i></th>
	<c:choose>
	<c:when  test="${weeklyScheduledUpdates.size() > 10}">
	<th width="106px">
	</c:when>
	<c:otherwise>
	<th width="90px">
	</c:otherwise>
	</c:choose>
	&nbsp;</th>
</tr>
<c:if  test="${weeklyScheduledUpdates.size() > 10}">
</thead>
<tbody class="scrollContent">
</c:if>
<c:forEach items="${weeklyScheduledUpdates}" var="scheduledUpdate">
    <tr>
        <td width="100px" class="center-cell">${scheduledUpdate.name}</td>
        <td width="100px" class="center-cell">${scheduledUpdate.description}</td>
        <td width="100px" class="center-cell">${scheduledUpdate.startDateShort}</td>
        <td width="100px" class="center-cell">
        <c:choose>
	        <c:when test="${scheduledUpdate.weekDay == 1}">
	        <spring:message code="label.scheduledUpdate.weekDay.sunday"/>
	        </c:when>
	        <c:when test="${scheduledUpdate.weekDay == 2}">
	        <spring:message code="label.scheduledUpdate.weekDay.monday"/>
	        </c:when>
	        <c:when test="${scheduledUpdate.weekDay == 3}">
	        <spring:message code="label.scheduledUpdate.weekDay.tuesday"/>
	        </c:when>
	        <c:when test="${scheduledUpdate.weekDay == 4}">
	        <spring:message code="label.scheduledUpdate.weekDay.wednesday"/>
	        </c:when>
	        <c:when test="${scheduledUpdate.weekDay == 5}">
	        <spring:message code="label.scheduledUpdate.weekDay.thursday"/>
	        </c:when>
	        <c:when test="${scheduledUpdate.weekDay == 6}">
	        <spring:message code="label.scheduledUpdate.weekDay.friday"/>
	        </c:when>
	        <c:when test="${scheduledUpdate.weekDay == 7}">
	        <spring:message code="label.scheduledUpdate.weekDay.saturday"/>
	        </c:when>
        </c:choose>
        </td>
        <td width="100px" class="center-cell">${scheduledUpdate.completeHour} (${scheduledUpdate.timeZoneName})</td>
        <td width="100px" class="center-cell">${scheduledUpdate.query.name}</td>
		<td width="90px" class="center-cell">
			<button onClick="deleteScheduledUpdate(${scheduledUpdate.id})" class="form-submit"><spring:message code="label.scheduledUpdate.deleteScheduledUpdate"/></button>
		</td>	
    </tr>
</c:forEach>
<c:choose>
<c:when  test="${weeklyScheduledUpdates.size() > 10}">
</tbody>
</table>
</div>
</c:when>
<c:otherwise>
</table>
</c:otherwise>
</c:choose>
</c:if>
</div>
</div>

<div class="box">
<h2><spring:message code="label.monthlyScheduledUpdates"/></h2>
<div class="margin-box">
<c:if  test="${empty monthlyScheduledUpdates}">
<div class="empty-list"><spring:message code="label.scheduledUpdates.noMonthlyScheduledUpdates"/></div>
</c:if>
<c:if  test="${!empty monthlyScheduledUpdates}">
<c:choose>
<c:when  test="${monthlyScheduledUpdates.size() > 10}">
<div id="tableContainer" class="tableContainer">
<table class="data">
<thead class="fixedHeader">
</c:when>
<c:otherwise>
<table class="data">
</c:otherwise>
</c:choose>
<tr>
    <th width="100px"><i><spring:message code="label.scheduledUpdate.name"/></i></th>
    <th width="100px"><i><spring:message code="label.scheduledUpdate.description"/></i></th>
    <th width="100px"><i><spring:message code="label.scheduledUpdate.startDate"/></i></th>
    <th width="100px"><i><spring:message code="label.scheduledUpdate.monthDay"/></i></th>
    <th width="100px"><i><spring:message code="label.scheduledUpdate.time"/></i></th>
    <th width="100px"><i><spring:message code="label.scheduledUpdate.query"/></i></th>
	<c:choose>
	<c:when  test="${monthlyScheduledUpdates.size() > 10}">
	<th width="106px">
	</c:when>
	<c:otherwise>
	<th width="90px">
	</c:otherwise>
	</c:choose>
	&nbsp;</th>
</tr>
<c:if  test="${monthlyScheduledUpdates.size() > 10}">
</thead>
<tbody class="scrollContent">
</c:if>
<c:forEach items="${monthlyScheduledUpdates}" var="scheduledUpdate">
    <tr>
        <td width="100px" class="center-cell">${scheduledUpdate.name}</td>
        <td width="100px" class="center-cell">${scheduledUpdate.description}</td>
        <td width="100px" class="center-cell">${scheduledUpdate.startDateShort}</td>
        <td width="100px" class="center-cell">${scheduledUpdate.monthDay}</td>
        <td width="100px" class="center-cell">${scheduledUpdate.completeHour} (${scheduledUpdate.timeZoneName})</td>
        <td width="100px" class="center-cell">${scheduledUpdate.query.name}</td>
		<td width="90px" class="center-cell">
			<button onClick="deleteScheduledUpdate(${scheduledUpdate.id})" class="form-submit"><spring:message code="label.scheduledUpdate.deleteScheduledUpdate"/></button>
		</td>	
    </tr>
</c:forEach>
<c:choose>
<c:when  test="${monthlyScheduledUpdates.size() > 10}">
</tbody>
</table>
</div>
</c:when>
<c:otherwise>
</table>
</c:otherwise>
</c:choose>
</c:if>
</div>
</div>

<div class="box">
<h2><spring:message code="label.newScheduledUpdate"/></h2>
<div class="margin-box">
<table class="form">
<tr>
	<td class="error-td">
    <c:if test="${duplicatedScheduledUpdate == true}">
    <spring:message code="label.scheduledUpdate.duplicatedScheduledUpdate"/>
    </c:if>
    </td>
</tr>
</table>
<table>
<tr>
<td><input id="monthly-radiobutton" type="radio" name="scheduleType" checked onclick="typeChanged()"><label style="font-size: 11px;"><spring:message code="label.scheduledUpdate.monthly"/></label></td>
<td><input id="weekly-radiobutton" type="radio" name="scheduleType" onclick="typeChanged()"><label style="font-size: 11px;"><spring:message code="label.scheduledUpdate.weekly"/></label></td>
</tr>
</table>
<form:form method="post" commandName="scheduledUpdate">

    <table class="form">
    <tr>
    <td class="header first-header">
    	<label class="plain-label"><spring:message code="label.scheduledUpdate.name"/> </label>
    </td>
    <td>
    	<form:input class='form-tf-grey' path="name" maxlength="50"/>
    </td>
    </tr>
    <tr>
    <td class="header">
    	<label class="plain-label"><spring:message code="label.scheduledUpdate.description"/> </label>
    </td>
    <td>
    	<form:input class='form-tf-grey' path="description" maxlength="200"/>
    </td>
    </tr>
    <tr>
    <td class="header">
    	<label class="plain-label"><spring:message code="label.scheduledUpdate.query"/> </label>
    </td>
    <td>
        <form:select path="query.id" style="width: 100%;">
        	<form:option value="" label=""/>
           	<c:forEach items="${userQueries}" var="userQuery">
            	<form:option value="${userQuery.id}" label="${userQuery.name}"/>
            </c:forEach>
        </form:select>
    </td>
    </tr>
    <tr>
    <td class="header">
    	<label class="plain-label"><spring:message code="label.scheduledUpdate.startDate"/> </label>
    </td>
    <td>
    	<form:input class='form-tf-grey' path="startDate" maxlength="10"/>
    </td>
    <td class="error-td"><form:errors path="query"/>
		<c:if test="${nullQuery == true}">
	       <spring:message code="label.scheduledUpdate.nullQuery"/>
		</c:if>
    </td>
    </tr>
    <tr id="weekly-row" style="display: none;">
        <td class="header"><form:label path="weekDay"><i><spring:message code="label.scheduledUpdate.weekDay"/></i></form:label></td>
        <td>
    		<form:select id="week-selector" path="weekDay" onchange="dayChanged()">
				<form:option value=""/>
				<form:option value="2"><spring:message code="label.scheduledUpdate.weekDay.monday"/></form:option>
				<form:option value="3"><spring:message code="label.scheduledUpdate.weekDay.tuesday"/></form:option>
				<form:option value="4"><spring:message code="label.scheduledUpdate.weekDay.wednesday"/></form:option>
				<form:option value="5"><spring:message code="label.scheduledUpdate.weekDay.thursday"/></form:option>
				<form:option value="6"><spring:message code="label.scheduledUpdate.weekDay.friday"/></form:option>
				<form:option value="7"><spring:message code="label.scheduledUpdate.weekDay.saturday"/></form:option>
				<form:option value="1"><spring:message code="label.scheduledUpdate.weekDay.sunday"/></form:option>
			</form:select>
		</td>
    </tr>
    <tr id="monthly-row">
        <td class="header"><form:label path="monthDay"><i><spring:message code="label.scheduledUpdate.monthDay"/></i></form:label></td>
        <td>
    		<form:select path="monthDay" id="month-selector" onchange="dayChanged()">
				<form:option value=""/>
				<form:option value="1"/>
				<form:option value="2"/>
				<form:option value="3"/>
				<form:option value="4"/>
				<form:option value="5"/>
				<form:option value="6"/>
				<form:option value="7"/>
				<form:option value="8"/>
				<form:option value="9"/>
				<form:option value="10"/>
				<form:option value="11"/>
				<form:option value="12"/>
				<form:option value="13"/>
				<form:option value="14"/>
				<form:option value="15"/>
				<form:option value="16"/>
				<form:option value="17"/>
				<form:option value="18"/>
				<form:option value="19"/>
				<form:option value="20"/>
				<form:option value="21"/>
				<form:option value="22"/>
				<form:option value="23"/>
				<form:option value="24"/>
				<form:option value="25"/>
				<form:option value="26"/>
				<form:option value="27"/>
				<form:option value="28"/>
				<form:option value="29"/>
				<form:option value="30"/>
				<form:option value="31"/>
			</form:select>
		</td>
    </tr>
    <tr>
        <td class="header last-header"><form:label path="hour"><i><spring:message code="label.scheduledUpdate.time"/></i></form:label></td>
        <td>
    		<form:select path="hour" class="number-selector">
				<form:option value="0">00</form:option>
				<form:option value="1">01</form:option>
				<form:option value="2">02</form:option>
				<form:option value="3">03</form:option>
				<form:option value="4">04</form:option>
				<form:option value="5">05</form:option>
				<form:option value="6">06</form:option>
				<form:option value="7">07</form:option>
				<form:option value="8">08</form:option>
				<form:option value="9">09</form:option>
				<form:option value="10"/>
				<form:option value="11"/>
				<form:option value="12"/>
				<form:option value="13"/>
				<form:option value="14"/>
				<form:option value="15"/>
				<form:option value="16"/>
				<form:option value="17"/>
				<form:option value="18"/>
				<form:option value="19"/>
				<form:option value="20"/>
				<form:option value="21"/>
				<form:option value="22"/>
				<form:option value="23"/>
			</form:select>:<form:select path="minute" class="number-selector">
				<form:option value="0">00</form:option>
				<form:option value="1">01</form:option>
				<form:option value="2">02</form:option>
				<form:option value="3">03</form:option>
				<form:option value="4">04</form:option>
				<form:option value="5">05</form:option>
				<form:option value="6">06</form:option>
				<form:option value="7">07</form:option>
				<form:option value="8">08</form:option>
				<form:option value="9">09</form:option>
				<form:option value="10"/>
				<form:option value="11"/>
				<form:option value="12"/>
				<form:option value="13"/>
				<form:option value="14"/>
				<form:option value="15"/>
				<form:option value="16"/>
				<form:option value="17"/>
				<form:option value="18"/>
				<form:option value="19"/>
				<form:option value="20"/>
				<form:option value="21"/>
				<form:option value="22"/>
				<form:option value="23"/>
				<form:option value="24"/>
				<form:option value="25"/>
				<form:option value="26"/>
				<form:option value="27"/>
				<form:option value="28"/>
				<form:option value="29"/>
				<form:option value="30"/>
				<form:option value="31"/>
				<form:option value="32"/>
				<form:option value="33"/>
				<form:option value="34"/>
				<form:option value="35"/>
				<form:option value="36"/>
				<form:option value="37"/>
				<form:option value="38"/>
				<form:option value="39"/>
				<form:option value="40"/>
				<form:option value="41"/>
				<form:option value="42"/>
				<form:option value="43"/>
				<form:option value="44"/>
				<form:option value="45"/>
				<form:option value="46"/>
				<form:option value="47"/>
				<form:option value="48"/>
				<form:option value="49"/>
				<form:option value="50"/>
				<form:option value="51"/>
				<form:option value="52"/>
				<form:option value="53"/>
				<form:option value="54"/>
				<form:option value="55"/>
				<form:option value="56"/>
				<form:option value="57"/>
				<form:option value="58"/>
				<form:option value="59"/>
			</form:select> <form:select path="timeZone">
				<form:option value="-12">GMT -12</form:option>
				<form:option value="-11">GMT -11</form:option>
				<form:option value="-10">GMT -10</form:option>
				<form:option value="-9">GMT -9</form:option>
				<form:option value="-8">GMT -8</form:option>
				<form:option value="-7">GMT -7</form:option>
				<form:option value="-6">GMT -6</form:option>
				<form:option value="-5">GMT -5</form:option>
				<form:option value="-4">GMT -4</form:option>
				<form:option value="-3">GMT -3</form:option>
				<form:option value="-2">GMT -2</form:option>
				<form:option value="-1">GMT -1</form:option>
				<form:option value="0">GMT 0</form:option>
				<form:option value="1">GMT +1</form:option>
				<form:option value="2">GMT +2</form:option>
				<form:option value="3">GMT +3</form:option>
				<form:option value="4">GMT +4</form:option>
				<form:option value="5">GMT +5</form:option>
				<form:option value="6">GMT +6</form:option>
				<form:option value="7">GMT +7</form:option>
				<form:option value="8">GMT +8</form:option>
				<form:option value="9">GMT +9</form:option>
				<form:option value="10">GMT +10</form:option>
				<form:option value="11">GMT +11</form:option>
				<form:option value="12">GMT +12</form:option>
			</form:select>
		</td>
    </tr>
</table> 
<input type="submit" id="form-submit" class="form-submit" value="<spring:message code="label.scheduledUpdate.addScheduledUpdate"/>"/>
</form:form>
</div>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		<c:if test="${(scheduledUpdate.weekDay == null) && (scheduledUpdate.monthDay == null)}">
		$('#form-submit').addClass('ui-state-disabled');
		$('#form-submit').addClass('ui-button-disabled');
		</c:if>
		<c:if test="${scheduledUpdate.weekDay != null}">
		$('#weekly-radiobutton').attr('checked',true);
		$('#monthly-row').css('display', 'none');
		$('#weekly-row').css('display', '');
		</c:if>
	});
	function deleteScheduledUpdate(id) {
		var confirm = window.confirm('<spring:message code="label.scheduledUpdate.confirmDeletion"/>');
		if (confirm == true) {
			self.location = 'terminals/schedules/delete/' + id;
		};
	};
	function dayChanged() {
		if (($('#week-selector').val() != "") || ($('#month-selector').val() != "")) {
			$('#form-submit').prop('disabled', false);
			$('#form-submit').removeClass('ui-state-disabled');
			$('#form-submit').removeClass('ui-button-disabled');
		} else {
			$('#form-submit').prop('disabled', true);
			$('#form-submit').addClass('ui-state-disabled');
			$('#form-submit').addClass('ui-button-disabled');
		}
	};
	function typeChanged() {
		if ($('#monthly-radiobutton').is(':checked')) {
			$('#monthly-row').css('display', '');
			$('#weekly-row').css('display', 'none');
			$('#week-selector').val('');
			$('#form-submit').prop('disabled', true);
			$('#form-submit').addClass('ui-state-disabled');
			$('#form-submit').addClass('ui-button-disabled');
		} else {
			$('#monthly-row').css('display', 'none');
			$('#weekly-row').css('display', '');
			$('#month-selector').val('');
			$('#form-submit').prop('disabled', true);
			$('#form-submit').addClass('ui-state-disabled');
			$('#form-submit').addClass('ui-button-disabled');
		}
	};
</script>

</t:wrapper>