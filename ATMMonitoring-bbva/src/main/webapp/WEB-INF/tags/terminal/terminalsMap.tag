<%@tag description="Terminals location map" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib tagdir="/WEB-INF/tags/utils/" prefix="utils"%>

<c:choose>
	<c:when test="${empty terminalIdsByLocation }">
		<div class="message">
			<p> <spring:message code="label.terminal.noTerminalsLocations"/> </p>
		</div>
	</c:when>
	<c:otherwise>
	
		
		
		<div id="terminalsMap"> </div>
		<div class="hide">
			<div id="defaultInfoWindowContent" class="summaryContent"> 
				<spring:message code="label.terminal.map.summary.wait"/>
			</div>
		</div>
		<legend class="map">
			<ul>	
				<c:forEach var="markerName" items="simpleMarker,multipleMarker,clusteredMarker" >
					<li><img src="resources/images/maps/${markerName}_p.png" />
					<spring:message code="terminals.map.${markerName}" /></li>
				</c:forEach>
			</ul>
		</legend>
		<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
		<script src="resources/js/markerClusterer.js"></script>
		<script type="text/javascript" >
		
		$(function() {
			terminalMap = new TerminalsMap();
			terminalMap.initialize();
		});
		
		function TerminalsMap() {
			var terminalSummaryUrl = 'terminals/summary'
			var map;
			var bounds;
			var isMapPainted;
			
			this.paintIfNecessary = function() {
				if(!isMapPainted) {
					isMapPainted = true;
					google.maps.event.trigger(map, 'resize');
					fitMapToBounds();
				}
			}
			
			this.initialize = function() {
				var mapOptions = {
					zoom: 8,
					mapTypeId: google.maps.MapTypeId.ROADMAP
				};
			
				map = new google.maps.Map(document.getElementById('terminalsMap'), mapOptions);
				initMarkers();
			}
			
			function initMarkers() {
				bounds = new google.maps.LatLngBounds(); 
				
				var terminalLocations = retrieveTerminalLocationsInfo();
				
				var locationIndex, locationInfo, googleLocation, markerOptions;
				var markers = []
				for (locationIndex = 0; locationIndex < terminalLocations.length; locationIndex++) {
			    	locationInfo = terminalLocations[locationIndex];
			    	googleLocation = new google.maps.LatLng(locationInfo.lat, locationInfo.long); 
			    	bounds.extend(googleLocation);
				
					markers.push(createMarker(map, googleLocation, locationInfo.ids));
				    
				}
				fitMapToBounds();
				initMarkerClusterer(markers); 
			}
			
			function fitMapToBounds() {
				map.fitBounds(bounds);
			}
			
			function initMarkerClusterer(markers) {
				var markerClusterOptions = {
					maxZoom: 20,
					styles : [
						{ url : 'resources/images/maps/clusteredMarker.png' , 
						  height: 45 , 
						  width: 45 ,
						  textColor: "white"}
						
					]
				}
					
				var markerCluster = new MarkerClusterer(map, markers, markerClusterOptions);
			}
			
			function createMarker(map, location, terminalIds) {
				var numberOfTerminals = countOccurences(terminalIds, ',');
				
				var iconName = (numberOfTerminals > 1 ? 'multiple' : 'simple') + 'Marker.png'
				
				var markerOptions = { 
					icon: 'resources/images/maps/' + iconName,
				    title: '<spring:message code="label.terminals" /> ' + '(' + numberOfTerminals + ')'
				}
				
			    var marker = new google.maps.Marker( {
			    	position: location,
			    	options:markerOptions
			    });
			     
			    var infoWindow = new google.maps.InfoWindow({
      			 	content: document.getElementById('defaultInfoWindowContent')
      			});

				google.maps.event.addListener(marker, 'click', function() {
					infoWindow.open(map,marker);
					loadTerminalSummary(infoWindow, terminalIds);
				});
				
			    return marker
			}
			
			function loadTerminalSummary(infoWindow, terminalIds) {
				$.ajax({
				 		type: "POST",
						url: terminalSummaryUrl + '?dateTime=${queryDate.time}',
						data: { "terminalIds": terminalIds }
					})
					.done(function(html) {
						infoWindow.setContent(html);
					})
					.fail(function() {
						infoWindow.setContent('<spring:message code="label.terminal.map.summary.error"/>');
					})
			}
			
			function retrieveTerminalLocationsInfo() {
			    return [
					<c:forEach items="${terminalIdsByLocation}" var="terminalIds">
						<c:set var="location" value="${terminalIds.key}" />
						{ 'lat' : ${location.coordY} , 'long': ${location.coordX} , 'ids': <utils:printList list="${terminalIds.value}" />} ,	
					</c:forEach>
			    ]
			}
		}
		
		</script>
	</c:otherwise>
</c:choose>
