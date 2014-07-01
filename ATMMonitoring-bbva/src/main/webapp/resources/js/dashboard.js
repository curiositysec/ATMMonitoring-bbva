var dashboardUrl = 'dashboard/charts';
var chartUrl = 'dashboard/chart';
var updateChartPositionUrl = 'dashboard/updateChartPosition';
var hideChartUrl = 'dashboard/hideChart';
var showChartUrl = 'dashboard/showChart';
var changeDashboardColumnsUrl = 'dashboard/changeColumns';
var deleteChartUrl = 'dashboard/delete'
var editChartUrl = 'dashboard/edit/'
var addWidgetToLibraryUrl = 'dashboard/showAddToLibraryForm'
var removeWidgetFromLibrary = 'dashboard/removeFromLibrary'
var setWidgetAsDefaultUrl = 'dashboard/setAsDefault'
var unsetWidgetAsDefaultUrl = 'dashboard/unsetAsDefault'


var divChartSelector = 'li.chart '

var googleChartType = {
    'TABLE'    : 'google.visualization.Table',
    'PIE_CHART': 'google.visualization.PieChart',
    'BAR_CHART': 'google.visualization.BarChart',
    'COLUMN_CHART': 'google.visualization.ColumnChart',
    'GEO_CHART': 'google.visualization.GeoChart'
};

Array.prototype.move = function (old_index, new_index) {
    this.splice(new_index, 0, this.splice(old_index, 1)[0]);
};

google.load('visualization', '1', {'packages': ['corechart', 'geochart', 'table']});

$(function() {
    initDashboardModel();
    initColumnsControl();
    
    window.onresize = onLoadDashboard;
});

// Model ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

var dashboardModel = {}

function getVisibleWidgetModelById(widgetId) {
    for (var i = 0; i < dashboardModel.visibleCharts.length; i++) {
        if (dashboardModel.visibleCharts[i].id == widgetId) {
            return dashboardModel.visibleCharts[i];
        }
    }
}

function indexOfVisibleWidget(widgetId) {
    for (var i = 0; i < dashboardModel.visibleCharts.length; i++) {
        if (dashboardModel.visibleCharts[i].id == widgetId) {
            return i;
        }
    }
    return -1;
}

function indexOfHiddenWidget(widgetId) {
    for (var i = 0; i < dashboardModel.hiddenCharts.length; i++) {
        if (dashboardModel.hiddenCharts[i].id == widgetId) {
            return i;
        }
    }
    return -1;
}

function removeVisibleWidget(widgetId) {
    var index = indexOfVisibleWidget(widgetId);
    var widget = dashboardModel.visibleCharts[index];
    dashboardModel.visibleCharts.splice(index, 1);
    return widget;
}

function removeHiddenWidget(widgetId) {
    var index = indexOfHiddenWidget(widgetId);
    var widget = dashboardModel.hiddenCharts[index];
    dashboardModel.hiddenCharts.splice(index, 1);
    return widget;
}

function addHiddenWidget(widget) {
    dashboardModel.hiddenCharts.push(widget);
}

function addVisibleWidget(widget) {
    dashboardModel.visibleCharts.push(widget);
}

function moveVisibleChart(oldPosition, newPosition) {
    console.log("Moving widget from " + oldPosition + " to " + newPosition);
    console.log("old: " + dashboardModel.visibleCharts);
    dashboardModel.visibleCharts.move(oldPosition, newPosition);
    console.log("new: " + dashboardModel.visibleCharts);
}

// Controllers ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

function initDashboardModel() {
    	$.ajax({
	        url: dashboardUrl,
	        dataType: "json",
	        async: true
	    }).fail(function(xhr, ajaxOptions, thrownError) {
	        console.error("Error " + xhr.status + ": " + thrownError);
	    }).done(function(data) {
	        dashboardModel = data;
        	onLoadDashboard();
	    });
    }

function initColumnsControl() {
    $("#columns li").click(function(event) {
        event.preventDefault();
        var newColumns = $(this).data("columns");
        onChangedColumns(newColumns);
    });
}

function initSortableCharts() {
    $("#sortable").sortable({
        start: function(event, ui) {
            $(ui.item).data("startIndex", ui.item.index());
        },
        stop: function(event, ui) {
            var startIndex = $(ui.item).data("startIndex");
            var endIndex = $(ui.item).index();
            moveVisibleChart(startIndex, endIndex);
            onMovedVisibleChart($(ui.item).attr("id"), startIndex, endIndex);
        }
    });
    $("#sortable").disableSelection();
}

function hideWidget(widgetId) {
    var widget = removeVisibleWidget(widgetId);
    addHiddenWidget(widget);
    onHiddenWidget(widgetId);
}

function deleteWidget(widgetId) {
    var widget = removeVisibleWidget(widgetId);
    onDeleteWidget(widgetId);
}

function showWidget(widgetId) {
    var widget = removeHiddenWidget(widgetId);
    addVisibleWidget(widget);
    onVisibleWidget(widgetId);
}

function addWidgetToLibrary(widgetId) {
	onAddWidgetToLibrary(widgetId);
}

function openChartsMenu() {
    $("#myCharts").show();
    $("#myCharts").parent().find("div.txt").removeClass("content_hide");
}

function closeChartsMenu() {
    $("#myCharts").hide('slow');
    $("#myCharts").parent().find("div.txt").addClass("content_hide");
}

function showNoChartsMessage() {
    $("#noCharts").show();
}

function hideNoChartsMessage() {
    $("#noCharts").hide();
}

// Event Handlers++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

function onLoadDashboard() {
    if (dashboardModel.visibleCharts.length > 0) {
        drawCharts();
    } else {
        drawChartsMenu();
    }
    initSortableCharts();
}

function onChartsMenuDrawed() {
	$("#myCharts li.on").click(function(event) {
        event.preventDefault();
        var widgetId = $(this).attr("id");
        showWidget(widgetId);
        closeChartsMenu();
    });

    if (dashboardModel.visibleCharts.length == 0) {
        openChartsMenu();
        showNoChartsMessage();
    } else {
        hideNoChartsMessage();
    }
}

function onChartDrawed(chart) {
    var widgetId = $(chart).attr("id");
    var widget = getVisibleWidgetModelById(widgetId);
    $.ajax({
        url: chartUrl,
        data: {
            'widgetId': widgetId
        },
        dataType: "json",
        async: true
    }).fail(function(xhr, ajaxOptions, thrownError) {
        console.error("Error " + xhr.status + ": " + thrownError);
    }).done(function(data) {
        var chartData = new google.visualization.DataTable(data);
        var graph = $(chart).find("div.graph")[0];
        var googleChart = eval("new " + googleChartType[widget.type] + "(graph)");
        var options = {
            'region': widget.region,
            'displayMode': 'markers'
        };
        googleChart.draw(chartData, options);
        google.visualization.events.addListener(googleChart, 'ready', fixGeoMapRectElements($(chart)));
        chart.find(".content").removeClass('loading')
    });

    $(chart).find(".collapsible").hide();
    $(chart).find(".close").click(function() {
        hideWidget(widgetId);
	});
	$(chart).find(".delete").click(function() {
		deleteWidget(widgetId);
	});
	
	var addToLibraryElement = $(chart).find(".addToLibrary")
	var isWidgetAddedToLibrary = addToLibraryElement.data('checked');
	if( isWidgetAddedToLibrary ) {
		addToLibraryElement.attr("checked", "checked");
	}
	addToLibraryElement.click(function() {
		var clickedElement = $(this);
		var addToLibrary = clickedElement.is(':checked');
		return onAddOrRemoveWidgetToLibrary(clickedElement,widgetId, addToLibrary);
	});
	
	var setAsDefaultElement = $(chart).find(".setAsDefault")
	var isDefault = setAsDefaultElement.data('checked');
	if( isDefault ) {
		setAsDefaultElement.attr("checked", "checked");
	}
	setAsDefaultElement.click(function() {
		var isDefault = $(this).is(':checked');
		return onSetOrUnsetDefaultWidget(widgetId, isDefault);
	});
	
	initButtonsIframe($(chart).find('.chart_iframe').selector)
	drawChartsMenu();
}

function onHiddenWidget(widgetId) {
    postToUrlAndHideChart(hideChartUrl, widgetId)
}

function onDeleteWidget(widgetId) {
	if(confirm(strings['widget.delete.confirm'])) {
		postToUrlAndHideChart(deleteChartUrl, widgetId)
	}
}

function postToUrlAndHideChart(postUrl, widgetId) {
    $.post(
        postUrl,
        {
            widgetId: widgetId
        }
    );
    drawChartsMenu();
    $("#sortable li#" + widgetId).hide('slow');
    $("#sortable li#" + widgetId).remove();
}

function onAddOrRemoveWidgetToLibrary(clickedElement, widgetId, addToLibrary) {
	return addToLibrary ? addWidgetToLibrary() : removeFromLibrary();
   
    function addWidgetToLibrary() {
    	clickedElement.next().click();
    	return false;
    }
    
    function removeFromLibrary() {
	   if(confirm(strings['widget.remove.from.library.confirm'])) {
		   $.post(
		   		removeWidgetFromLibrary,
		        {
		            widgetId: widgetId
		        }
		    );
		    return true;
	    } else {
	    	return false;
	    }	
    } 
}

function onSetOrUnsetDefaultWidget(widgetId, defaultWidget) {
   if(confirm(strings['widget.' + (defaultWidget ? 'set' : 'unset') + '.as.default.confirm'])) {
	   $.post(
	        (defaultWidget ? setWidgetAsDefaultUrl : unsetWidgetAsDefaultUrl),
	        {
	            widgetId: widgetId
	        }
	    );
	    return true;
    } else {
    	return false;
    }
}

function onVisibleWidget(widgetId) {
    $.post(
        showChartUrl,
        {
            widgetId: widgetId
        }
    );
    var widget = getVisibleWidgetModelById(widgetId);
    drawChart(widget);
}

function onMovedVisibleChart(widgetId, oldPosition, newPosition) {
    if (oldPosition != newPosition) {
        $.post(
            updateChartPositionUrl,
            {
                widgetId: widgetId,
                oldPosition: oldPosition,
                newPosition: newPosition
            }
        );
    }
    drawChartsMenu();
}

function onChangedColumns(newColumns) {
    var oldColumns = $("#columns li.current").data("columns");
    if (oldColumns != newColumns) {
        $("#sortable").toggleClass("column" + oldColumns);
        $("#sortable").addClass("column" + newColumns);
        $("#columns li.current").removeClass("current");
        $("#columns li.column" + newColumns).addClass("current");
        drawCharts();
        $.post(
            changeDashboardColumnsUrl,
            {
                columns: newColumns
            }
        );
    }
}

// View +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

var transforms = {
    "chartsHiddenMenu": [ { tag: 'li', class: 'on', id: "${id}", html: "${title}" } ],
    "chartsVisibleMenu": [ { tag: 'li', class: 'off', id: "${id}", html: "${title}" } ],
    "charts": [ { tag: 'li', class: 'chart ui-state-default ${type}', id: "${id}",
                  children: [
                      { tag: 'span', class: 'title', html:'${description}' },
                      { tag: 'div', class: 'content loading',
                        children: [
                            { tag: 'div', class: 'icons_bg',
                              children: [
                                  { tag: 'div', class: 'close',
                                    children: [ { tag: 'span', html: 'cerrar' } ] },
                                  { tag: 'nav', class: 'icons_menu desplegable',
                                    children: [ { tag: 'div', class: 'icon16 config content_hide txt',
                                                  children: [ { tag: 'span', html: strings['label.widget.options'] } ] },
                                                { tag: 'ul', class: 'collapsible',
                                                  children: [ 
                                                  			  { tag: 'li', children: [ { tag: 'a', class: 'editWidget iframe_medium chart_iframe', href: (editChartUrl + '${id}'), html: strings['label.widget.edit'] } ] },
                                                              { tag: 'li', class: 'privilegedOption' , children: 
                                                              		[ 
                                                              			{ tag: 'label', children: 
                                                                            [
                                                                                { tag: 'input', class: 'addToLibrary', type:'checkbox', 'data-checked' : "${libraryWidget}" , html: strings['widget.add.to.library'] },
                                                              			        { tag: 'span', class:'hide iframe_medium chart_iframe', href: (addWidgetToLibraryUrl + '/${id}')} 
                                                                            ]
                                                                        }   

                                                              		] 
                                                              },
                                                              { tag: 'li', class: 'privilegedOption' , children: 
                                                              		[ 
                                                                        { tag: 'label', children: 
                                                                            [ { tag: 'input', class: 'setAsDefault', type:'checkbox', 'data-checked' : "${defaultWidget}" , html: strings['widget.set.as.default'] } ]
                                                                        }
                                                              		] 
                                                              },
                                                              { tag: 'li', children: [ { tag: 'a', class: 'delete', html: strings['label.widget.delete'] } ] }
                                                            ]
                                                }
                                              ]
                                  }
                              ]
                            },
                            { tag: 'div', class: 'graph' }
                        ]
                      }
                  ]
                }
              ]
};

function drawChartsMenu() {
    $("#myCharts li").remove();
    $("#myCharts").json2html(dashboardModel.hiddenCharts, transforms.chartsHiddenMenu);
    $("#myCharts").json2html(dashboardModel.visibleCharts, transforms.chartsVisibleMenu);
    onChartsMenuDrawed();
}

function drawCharts() {
    $("#sortable").contents().remove();
    for (var i = 0; i < dashboardModel.visibleCharts.length; i++) {
        var widget = dashboardModel.visibleCharts[i];
        drawChart(widget);
    }
}

function drawChart(widget) {
	widget.description = (widget.category ? widget.category + ' - ' : '') + widget.title,
	
	$("#sortable").json2html(widget, transforms.charts);
	var drawedElement = $("#sortable li#" + widget.id); 
	
	if(!hasPrivileges) {
		hideEditWidgetsLibraryOptions()
	}
	
	if(widget.libraryWidget) {
		drawedElement.find("div.graph").addClass("libraryWidget");
	}
	
	onChartDrawed(drawedElement);
}

function hideEditWidgetsLibraryOptions() {
	$('.privilegedOption').hide();
}

function initButtonsIframe(selectorPrefix) {
	//init edit links. This function is stored on menu.js
	return initIframes(selectorPrefix);
}

//WORKARROUND http://code.google.com/p/google-visualization-api-issues/issues/detail?id=598
function fixGeoMapRectElements(chartElementContent) {
	return function() {
		var element = findProblematicElement(chartElementContent)
		fixChart(chartElementContent);
		element.parent().bind("DOMNodeInserted", function(event) {
			fixChart(chartElementContent);
		});
	}
	
	function fixChart(chart) {
		var element = findProblematicElement(chart)
		if(element.attr('fill')) {
		  element.attr( 'fill', 'url(' + document.location + element.attr( 'fill' ).substring( 4 ) );
		}
	}
	
	function findProblematicElement(chart) {
		return chart.find('g rect[fill*="url(#"]');
	}
}
