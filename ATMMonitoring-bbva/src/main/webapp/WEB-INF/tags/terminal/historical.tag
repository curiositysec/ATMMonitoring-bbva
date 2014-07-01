<%@tag description="Historical timeline" pageEncoding="UTF-8"%>
<%@attribute name="historicalChanges" required="true" type="java.util.Map"%>
<%@attribute name="timelineDates" required="true" type="java.util.Map"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h2><spring:message code="label.terminal.history"/></h2>

<div class="botonera">
	<a href="#" class="timelineZoom on" data-zoom-in="true"  >  </a>
	<a href="#" class="timelineZoom off" data-zoom-in="false" >  </a>
</div>

<div class="history_legend">
	<div id="timeline" style="height:120px"> </div>
	<ul class="legend">
		<c:forEach items="${historicalChanges}" var="changesByType">
		    <li><c:set var="changeName" value="${changesByType.key.simpleName}"> </c:set>
		    <img src="<c:url value="/resources/timeline/api/images/${changeName}.png" />" />
		    <spring:message code="label.historical.${changeName}"/></li>
		</c:forEach>	
		<li>
		    <img src="<c:url value="/resources/timeline/api/images/Current.png" />" />
		    <spring:message code="label.historical.Current"/>
		</li>
		<li>
		    <img src="<c:url value="/resources/timeline/api/images/Cluster.png" />" />
		    <spring:message code="label.historical.Cluster"/>
		</li>
	</ul>
</div>

<script>
    var Timeline_urlPrefix = 'resources/timeline/api/';
    var Timeline_ajax_url= 'resources/timeline/ajax/simile-ajax-api.js';       
</script>
<script src="resources/timeline/api/timeline-api.js" type="text/javascript"></script>
<script src="resources/js/elementClusterer.js" type="text/javascript"></script>

<script>

    window.onload = function() { executeOnTimelineLoaded(loadTimeline) };
    
    var tl;
    
    function loadTimeline() {
    	var elementsSize = 16;
    	var eventSource = new Timeline.DefaultEventSource();

        var zones = [];
        var zones2 = [];
        
        var theme = Timeline.ClassicTheme.create();
        theme.event.bubble.width = 250;
        
        var bandInfos = [
            Timeline.createHotZoneBandInfo({
            	<c:if test="${!(date == null)}">  
	            	date : new Date(${date.time}) ,     
	        	</c:if>  
	        	width:          "66%", 
                intervalUnit:   Timeline.DateTime.MONTH, 
                intervalPixels: 200,
                zones:          zones,
                eventSource:    eventSource,
                zoomIndex:      16,
            zoomSteps:      new Array(
              {pixelsPerInterval: 3000,  unit: Timeline.DateTime.HOUR},
              {pixelsPerInterval: 2500,  unit: Timeline.DateTime.HOUR},
              {pixelsPerInterval: 2000,  unit: Timeline.DateTime.HOUR},
              {pixelsPerInterval: 1600,  unit: Timeline.DateTime.HOUR},
              {pixelsPerInterval: 2500,  unit: Timeline.DateTime.DAY},
              {pixelsPerInterval: 2000,  unit: Timeline.DateTime.DAY},
              {pixelsPerInterval: 1700,  unit: Timeline.DateTime.DAY},
              {pixelsPerInterval: 1500,  unit: Timeline.DateTime.DAY},
              {pixelsPerInterval: 1500,  unit: Timeline.DateTime.WEEK},
              {pixelsPerInterval: 1200,  unit: Timeline.DateTime.WEEK},
              {pixelsPerInterval: 800,  unit: Timeline.DateTime.WEEK},
              {pixelsPerInterval: 400,  unit: Timeline.DateTime.WEEK},
              {pixelsPerInterval: 500,  unit: Timeline.DateTime.MONTH},
              {pixelsPerInterval: 400,  unit: Timeline.DateTime.MONTH},
              {pixelsPerInterval: 300,  unit: Timeline.DateTime.MONTH},
              {pixelsPerInterval: 200,  unit: Timeline.DateTime.MONTH},
              {pixelsPerInterval: 400,  unit: Timeline.DateTime.YEAR}
            )
                
              //  theme:          theme
            }),
            Timeline.createHotZoneBandInfo({
                width:          "34%", 
                intervalUnit:   Timeline.DateTime.YEAR, 
                zones:          zones2, 
                intervalPixels: 400,
                eventSource:    eventSource,
                overview:       true,
                zoomIndex:      1,
                zoomSteps:      new Array(
                    {pixelsPerInterval: 400,  unit: Timeline.DateTime.YEAR},
                    {pixelsPerInterval: 200,  unit: Timeline.DateTime.YEAR},
                    {pixelsPerInterval: 100,  unit: Timeline.DateTime.YEAR},
                    {pixelsPerInterval: 50,  unit: Timeline.DateTime.YEAR},
                    {pixelsPerInterval: 200,  unit: Timeline.DateTime.DECADE},
                    {pixelsPerInterval: 100,  unit: Timeline.DateTime.DECADE}
                 )
               // theme:          theme
            })
        ];
        bandInfos[1].syncWith = 0;
        bandInfos[1].highlight = true;
        
        
        tl = Timeline.create(document.getElementById("timeline"), bandInfos, Timeline.HORIZONTAL);
        addOnEventPaintFinished(elementsSize);
        eventSource.loadJSON(buildEventsJSONData(), '');
        
        Timeline.OriginalEventPainter.prototype._showBubble = function(x, y, evt) {
            window.location.assign(document.location.pathname + evt.getDescription());
  		}
  		
  		var resizeTimerID = null;
		function onResize() {
			if (resizeTimerID == null) {
				resizeTimerID = window.setTimeout(function() {
					resizeTimerID = null;
					tl.layout();
				}, 500);
			}
		}
		
		window.onresize = onResize;  
		
		$("div.botonera .timelineZoom").click( function() {
			var target = document.getElementById("timeline-band-0");
			var zoomIn = $(this).data('zoomIn');
			
			tl.zoom(zoomIn, tl.getCenterPixel(0) ,1,target);
		});
		
		
		
	}
    
    function addOnEventPaintFinished(elementsSize) {
		tl._bands[0].addOnEventPaintFinished(function(event,op) { 
			if (op == 'paintEnded') {
				clusterizeTimeline(elementsSize)
			} 
		});
	}
		
	function clusterizeTimeline(elementsSize) {
		var elements = $("div#timeline .timeline-event-icon")
		var parent = elements.parent(); 
		var createdClusters = []
			
		var clusterer = new ElementsClusterer(elements.toArray(), elementsSize);
				
		clusterer.addOnElementChangeListener(function(event) {
		    event.HTMLElement.style.left = event.leftPosition+"px";
		});
		clusterer.addOnClusterCreateListener(onClusterCreaterdListener);
		
		clusterer.clusterize()
		initClusterNumberOfElements();
		
		function initClusterNumberOfElements() {
			var index = 0;
			for( index; index < createdClusters.length ;  index++) {
				var cluster = createdClusters[index]
				var clusteredElementsSize = cluster.elements.length;
				var clusterDiv = cluster.clusterDivElement;
				clusterDiv.append(
					'<span class="cluster">' + clusteredElementsSize + '</span>'
				)
			}
		}
		
		
		function onClusterCreaterdListener(event) {
		    var clusteredElements = event.clusteredElements,
		   	elementSpace = elementsSize,
		   	leftPosition = event.leftPosition;
		   	
		   	var clusterDivString = '<div class="timeline-event-icon cluster" id="cluster-' + leftPosition+ '"style="left: ' + 
		    leftPosition + 'px; top: 7px;"><img src="resources/timeline/api/images/Cluster.png"></div>'
		    parent.append(clusterDivString);
		    
		    var clusterDivElement = $('div#cluster-'+ leftPosition); 
		    createdClusters.push({leftPosition:leftPosition, elements:clusteredElements, clusterDivElement:clusterDivElement})
		    
		    clusterDivElement.click(function() {
		    	var index = 0,
		    		totalClusteredElements = clusteredElements.length,
		    		totalWidth = elementSpace * totalClusteredElements,
		    		firstLeftPosition = (leftPosition - totalWidth / 2 ) + elementSpace/1.25 ,
		    		currentLeftPosition = firstLeftPosition;
		    		
		    	restoreClusters();
		    	
		    	for(index ; index < totalClusteredElements; index++) {
		    		var htmlElement = clusteredElements[index].HTMLElement 
		    		var element = $(htmlElement);
		    		element.addClass('secondLine');
		    		
		    		element.animate({
						left: currentLeftPosition + "px",
					}, 500 );
		    		currentLeftPosition += elementSpace;
		    	}
		    });
		    
		    function restoreClusters() {
				var index = 0;
				for( index; index < createdClusters.length ;  index++) {
					var cluster = createdClusters[index]
					var elementIndex = 0;
					var clusteredElements = cluster.elements;
					
					for(elementIndex ; elementIndex < clusteredElements.length; elementIndex++) {
		    			var htmlElement = clusteredElements[elementIndex].HTMLElement 
		    			var element = $(htmlElement);
		    			element.removeClass('secondLine');
		    			htmlElement.style.left = cluster.leftPosition + "px";
		    		}
				}
			}
		}
	}
	
    function buildEventsJSONData() {
    	var eventData = {
    	   events : [
    	   <c:set var="times" value="${0}" />
    	       <c:forEach items="${historicalChanges}" var="changesByType">
    	           <c:forEach items="${changesByType.getValue()}" var="changeDates">
	               <c:set var="changeDate" value="${changeDates.getKey()}" />
	               <c:set var="numberOfChanges" value="${changeDates.getValue()}" />
	               <c:set var="times" value="${times + 1}" />
			{
			 		 start : new Date(${changeDate.time}) ,
    	          	 description : "?dateTime=${changeDate.time}&preselectedTab=${changesByType.key.simpleName}",
    	          	 classname : 'firstLine',
    	          	 icon : '<c:url 
    	          	 	value="/resources/timeline/api/images/${changesByType.key.simpleName}${date.time == changeDate.time ? '_current' : ''}.png" 
    	          	 />',
    	          	 iconTitle : '<spring:message code="label.historical.tooltip.${changesByType.key.simpleName}"/>: ' +
    	          	             '<fmt:formatDate value="${changeDate}" pattern="dd/MM/yyyy HH:mm:ss" />'
    	      		},
    	      	    </c:forEach>
    	        </c:forEach>	
    	   ] 
        }
        return eventData;
    }
    
</script>