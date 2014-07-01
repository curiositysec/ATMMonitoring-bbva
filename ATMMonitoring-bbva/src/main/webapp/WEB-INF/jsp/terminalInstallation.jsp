<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapperWoMenu titleCode="label.terminalsManager" section="iframe">

<jsp:attribute name="header">
    <link rel="stylesheet" type="text/css" href="resources/css/black-tie/jquery-ui-1.9.2.custom.min.css">
    <script type="text/javascript" src="resources/js/terminalInstallation.js"></script>
    <script type="text/javascript">
    	$(function() {
    		var item = null;
	    	function refreshInputs() {
	    		if (item != null) {
	    			$( ".inOffice #id" ).val(item.id);
	    			$( ".inOffice #code" ).val( item.officeCode );
	    			$( ".inOffice #name" ).val( item.office );
	    			$( ".inOffice #address" ).val( item.completeAddress );
	    		} else {
	    			$( ".inOffice #id" ).val( '' );
	    			$( ".inOffice #code" ).val( '' );
	    			$( ".inOffice #name" ).val( '' );
	    			$( ".inOffice #address" ).val( '' );
	    		}
	    	}
	    	refreshInputs();
	    	$( ".inOffice input" ).blur(refreshInputs);
	    	$( ".inOffice #code" ).autocomplete({
	    		minLength: 3,
	    		source: "terminals/locations/search/officeCode",
	    		focus: function( event, ui ) {
	    			$( "#code" ).val( ui.item.officeCode );
	    			return false;
	    		},
	    		select: function( event, ui ) {
	    			item = ui.item;
	    			refreshInputs();
	    			return false;
	    		}
	    	}).data( "ui-autocomplete" )._renderItem = function( ul, item ) {
	    		return $( "<li>" )
	    		.append( "<a>" + item.officeCode + "<br>" + item.office + "</a>" )
	    		.appendTo( ul );
	    	};
	    	$( ".inOffice #name" ).autocomplete({
	    		minLength: 3,
	    		source: "terminals/locations/search/office",
	    		focus: function( event, ui ) {
	    			$( "#name" ).val( ui.item.office );
	    			return false;
	    		},
	    		select: function( event, ui ) {
	    			item = ui.item;
	    			refreshInputs();
	    			return false;
	    		}
	    	}).data( "ui-autocomplete" )._renderItem = function( ul, item ) {
	    		return $( "<li>" )
	    		.append( "<a>" + item.office + "<br>" + item.officeCode + "</a>" )
	    		.appendTo( ul );
	    	};
	    	$( ".inOffice #address" ).autocomplete({
	    		minLength: 3,
	    		source: "terminals/locations/search/completeAddress",
	    		focus: function( event, ui ) {
	    			$( "#address" ).val( ui.item.completeAddress );
	    			return false;
	    		},
	    		select: function( event, ui ) {
	    			item = ui.item;
	    			refreshInputs();
	    			return false;
	    		}
	    	}).data( "ui-autocomplete" )._renderItem = function( ul, item ) {
	    		return $( "<li>" )
	    		.append( "<a>" + item.completeAddress + "<br>" + item.officeCode + "</a>" )
	    		.appendTo( ul );
	    	};
    	});
    </script>
</jsp:attribute>

<jsp:body>

<div id="main" class="installation">

	<div id="primary" class="w50 left">
		<h1><spring:message code="label.installation.new"/></h1>
		<article>
			<form:form method="post" action="terminals/installations/new?matricula=${matricula}" commandName="installation">
				<div class="content">
					<div class="ul_data editable">
						<div class="row">
	
							<label for="inOffice"><input type="radio" id="inOffice" name="installationType" value="inOffice"><spring:message code="label.installation.inOffice"/></label>
	
							<label for="outOffice"><input type="radio" id="outOffice" name="installationType" value="outOffice"><spring:message code="label.installation.outOffice"/></label>
						</div>
						<ul class="">
							<li class="inOffice">
								<form:input id="id" type="hidden" path="location.id" name="location.id"/>
							</li>
							<li class="inOffice">
	                            <label style="font-style: italic;"><spring:message code="label.location.quickSearch"/>:</label>
							</li>
							<li class="inOffice">
								<label><spring:message code="label.location.officeCode"/></label>
	                            <input type="text" id="code"/>
							</li>
							<li class="inOffice">
								<label><spring:message code="label.location.office"/></label>
	                            <input  type="text" id="name"/>
							</li>
							<li class="inOffice">
								<label><spring:message code="label.location.address"/></label>
	                            <input  type="text" id="address"/>
							</li>
							<li class="outOffice">
								<label for="address"><spring:message code="label.location.address"/></label>
							</li>
							<li class="outOffice">
								<label for="addressStreet"><spring:message code="label.location.addressStreet"/></label>
								<form:input id="addressStreet" path="location.addressStreet" name="addressStreet"/>
							</li>
							<li class="outOffice">
								<label for="addressCity"><spring:message code="label.location.addressCity"/></label>
								<form:input id="addressCity" path="location.addressCity" name="addressCity"/>
							</li>
							<li class="outOffice">
								<label for="addressPostcode"><spring:message code="label.location.addressPostcode"/></label>
								<form:input id="addressPostcode" path="location.addressPostcode" name="addressPostcode"/>
							</li>
							<li class="outOffice">
								<label for="addressCountry"><spring:message code="label.location.addressCountry"/></label>
								<form:input id="addressCountry" path="location.addressCountry" name="addressCountry"/>
							</li>
							<li class="outOffice">
								<label for="coordX"><spring:message code="label.location.coordX"/></label>
								<form:input id="coordX" path="location.coordX" name="coordX"/>
							</li>
							<li class="outOffice">
								<label for="coordY"><spring:message code="label.location.coordY"/></label>
								<form:input id="coordY" path="location.coordY" name="coordY"/>
							</li>
							<li class="outOffice">
								<label for="bankCompany"><spring:message code="label.location.bankCompany"/></label>
								<form:input id="bankCompany" path="location.bankCompany" name="bankCompany"/>
							</li>
							<li class="outOffice">
								<label for="publicAccess"><spring:message code="label.location.publicAccess"/></label>
								<form:checkbox id="publicAccess" path="location.publicAccess" name="publicAccess"/>
							</li>
							<li class="outOffice">
								<label for="displaced"><spring:message code="label.location.displaced"/></label>
								<form:checkbox id="displaced" path="location.displaced" name="displaced"/>
							</li>
							<hr>
							<li>
								<label for="startDate"><spring:message code="label.installation.startDate"/></label>
	                            <c:set var="now" value="<%=new java.util.Date()%>" />
	                            <fmt:formatDate value="${now}" pattern="dd/MM/yyyy" var="currentDate"/>
								<form:input id="startDate" path="startDate" class="date" name="date" type="text" value="${currentDate}"/>
								<a href="" id="startDateButton" class="btn calendar">
									<span>
										<spring:message code="label.calendar.open"/>
									</span>
								</a>
							</li>
							<li>
								<label for="endDate"><spring:message code="label.installation.endDate"/></label>
								<form:input id="endDate" path="endDate" class="date" name="date_off" type="text"/>
								<a href="" id="endDateButton" class="btn calendar">
									<span>
										<spring:message code="label.calendar.open"/>
									</span>
								</a>
							</li>
							<li>
								<label for="locationClass"><spring:message code="label.installation.locationClass"/></label>
								<form:select id="locationClass" path="locationClass" name="locationClass" type="text">
									<option value=""></option>
								  	<c:forEach items="${locationClasses}" var="locationClass">
	                              		<option value="${locationClass}"><spring:message code="label.installation.${locationClass}"/></option>
	                              	</c:forEach>
								</form:select>
							</li>
							<li>
								<label for="ip"><spring:message code="label.terminal.ip"/></label>
								<form:input id="ip" path="ip" name="ip" type="text"/>
							</li>
							<li>
								<label for="type"><spring:message code="label.installation.type"/></label>
								<form:input id="type" path="type" name="type" type="text"/>
							</li>
							<li>
								<label for="post"><spring:message code="label.installation.post"/></label>
								<form:input id="post" path="post" name="post" type="text"/>
							</li>
							<li>
								<label for="processed"><spring:message code="label.installation.processed"/></label>
								<form:checkbox id="processed" path="processed" name="processed"/>
							</li>
						</ul>
					</div>
				</div>
			    <div class="botonera">
			    	<input type="submit" class="btn" value="<spring:message code="label.installation.addInstallation"/>"/>
			    </div>
		    </form:form>
		</article>
	</div>

    <div id="map"></div>

</div>
</jsp:body>

</t:osoco-wrapperWoMenu>
