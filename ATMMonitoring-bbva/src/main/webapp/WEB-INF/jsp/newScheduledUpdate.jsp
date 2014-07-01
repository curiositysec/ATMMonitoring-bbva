<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.scheduledUpdatesManager" userMsg="${userMsg}" section="schedule">

<jsp:attribute name="header">
<script type="text/javascript">
	$(document).ready(function(){
        $("#periodicity").change(function(event) {
            var periodicity = $(this).val();
            $(".periodicity").hide();
            $("#" + periodicity).show();
            $('#month-selector').val('');
            $('.radioweek').attr('checked',false);
        });
	});
</script>
</jsp:attribute>

<jsp:body>

<div id="header_g">
  <nav id="breadcrumb">
    <ul>
      <li><a href="#"><spring:message code="breadcrumb.home"/></a></li>
      <li><a href="terminals/schedules/list"><spring:message code="label.scheduler"/></a></li>
      <li><spring:message code="label.schedule.new"/></li>
    </ul>
  </nav>
</div>

<h1><spring:message code="label.schedule.new"/></h1>
<div class="content">
<div class="form w33">
<c:if test="${error != null}">
    <div class="alert">
      <p><spring:message code="label.${error}"/></p>
    </div>
</c:if>

<form:form method="post" action="terminals/schedules/list" commandName="scheduledUpdate">

<div class="row"><label for="query"><strong><spring:message code="label.choose.query"/>:</strong></label>
<form:select name="query.id" size="1" path="query.id" >
  <option value="" ><spring:message code="label.select.default"/></option>
  <c:forEach items="${userQueries}" var="userQuery">
    <form:option value="${userQuery.id}" label="${userQuery.name}" selected="${(query.id == userQuery.id)? 'selected' :''}"/>
  </c:forEach>
</form:select></div>

<div class="row">
  <label for="name"><strong><spring:message code="label.schedule.name"/></strong></label>
  <form:input id="name" type="text" path="name"/>
</div>

<div class="row">
  <label for="description"><strong><spring:message code="label.description"/></strong></label>
  <form:textarea id="description" path="description"/>
</div>

<div class="row">
  <label for="periodicity"><strong><spring:message code="label.repeat.each"/>:</strong></label>
  <select id="periodicity">
    <option value=""></option>
    <option value="weekly"><spring:message code="label.weekly"/></option>
    <option value="monthly"><spring:message code="label.monthly"/></option>
  </select>
</div>


<div id="weekly" class="periodicity hide row">

<form:label path="weekDay"><strong><spring:message code="label.choose.days"/>:</strong></form:label>
<ul class="weekDay">
  <li><form:radiobutton class="radioweek" id="monday" path="weekDay" value="2"/><label for="monday"><spring:message code="label.scheduledUpdate.weekDay.monday"/></label></li>
  <li><form:radiobutton class="radioweek" id="tuesday" path="weekDay" value="3"/><label for="tuesday"><spring:message code="label.scheduledUpdate.weekDay.tuesday"/></label></li>
  <li><form:radiobutton class="radioweek" id="wednesday" path="weekDay" value="4"/><label for="wednesday"><spring:message code="label.scheduledUpdate.weekDay.wednesday"/></label></li>
  <li><form:radiobutton class="radioweek" id="thursday" path="weekDay" value="5"/><label for="thursday"><spring:message code="label.scheduledUpdate.weekDay.thursday"/></label></li>
  <li><form:radiobutton class="radioweek" id="friday" path="weekDay" value="6"/><label for="friday"><spring:message code="label.scheduledUpdate.weekDay.friday"/></label></li>
  <li><form:radiobutton class="radioweek" id="saturday" path="weekDay" value="7"/><label for="saturday"><spring:message code="label.scheduledUpdate.weekDay.saturday"/></label></li>
  <li><form:radiobutton class="radioweek" id="sunday" path="weekDay" value="1"/><label for="sunday"><spring:message code="label.scheduledUpdate.weekDay.sunday"/></label></li>
</ul>
</div>

<div id="monthly" class="periodicity hide row">

<form:label path="monthDay"><spring:message code="label.dayOfMonth"/>:</form:label>

<form:select path="monthDay" id="month-selector">
  <form:option value=""/>
  <c:forEach begin="1" end="31" var="day">
    <form:option value="${day}"/>
  </c:forEach>
</form:select>

</div>

<form:label path="hour"><spring:message code="label.scheduledUpdate.time"/></form:label>

<form:select path="hour" class="number-selector">
  <c:forEach begin="0" end="23" var="hour">
    <form:option value="${hour}">${hour < 10 ? '0' : ''}${hour}</form:option>
  </c:forEach>
</form:select> :
<form:select path="minute" class="number-selector">
  <c:forEach begin="0" end="59" var="minute">
    <form:option value="${minute}">${minute < 10 ? '0' : ''}${minute}</form:option>
  </c:forEach>
</form:select>
 <form:select path="timeZone">
  <c:forEach begin="0" end="24" var="timeZone">
    <form:option value="${timeZone - 12}">GMT ${timeZone > 12 ? '+' : ''}${timeZone - 12}</form:option>
  </c:forEach>
 </form:select>
<div class="botonera">
  <input type="submit" id="form-submit" class="form-submit" value="<spring:message code="label.scheduledUpdate.addScheduledUpdate"/>"/>
  <a href="terminals/schedules/list" class="btn cancel"><spring:message code="label.cancel"/></a>
</div>
</form:form></div></div>

</jsp:body>

</t:osoco-wrapper>
