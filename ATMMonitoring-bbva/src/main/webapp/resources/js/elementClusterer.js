(function() {

	//*************************************************************************************
	//**************************      ELEMENT WRAPPER            **************************
	//*************************************************************************************
	
	function ElementWrapper( HTMLElement, onElementChangeListeners ) {
		var styles = HTMLElement.style;
		
		this.onElementChangeListeners = onElementChangeListeners;
		this.leftPosition = parseInt(styles.left);
		this.originalLeftPosition = this.leftPosition;
		this.HTMLElement = HTMLElement;
	}
	
	ElementWrapper.prototype.overlaps = function(otherElement, margin) {
		var elementAtLeft =  ElementWrapper.getLeftElement(this, otherElement);
		var elementAtRight = this === elementAtLeft ? otherElement : this;
		return (elementAtLeft.leftPosition + margin > elementAtRight.leftPosition);
	}
	
	ElementWrapper.prototype.changeLeftPosition = function(newLeftPosition) {
		if(newLeftPosition != this.leftPosition) {
			this.leftPosition = newLeftPosition;
			this.notifyChangePositionListeners();
		}
	}
	
	ElementWrapper.prototype.notifyChangePositionListeners = function() {
		var index = 0,
			elementChangeEvent,
			listener;
		elementChangeEvent = new ElementWrapper.ElementChangeEvent(this.HTMLElement, this.leftPosition)
		for(var index = 0; index < this.onElementChangeListeners.length; index++) {
			listener = this.onElementChangeListeners[index](elementChangeEvent);
		}
	}
    
    ElementWrapper.ElementChangeEvent = function(HTMLElement, leftPosition) {
    	this.HTMLElement = HTMLElement;
    	this.leftPosition = leftPosition;
    }
    
    ElementWrapper.getLeftElement = function(element1, element2) {
    	return element1.leftPosition <= element2.leftPosition ? element1 : element2;
    }
    
    ElementWrapper.compare = function (elementA, elementB) { 
		return  elementA.leftPosition - elementB.leftPosition
	}
    
    //*************************************************************************************
	//**************************      ELEMENTS CLUSTER           **************************
	//*************************************************************************************
    
    function Cluster(leftPosition, clusterCreatedListeners) {
    	this.clusteredElements = []
    	this.leftPosition = leftPosition
    	this.clusterCreatedListeners = clusterCreatedListeners
    	this.notifyNewClusterCreated(this);
	}
	
	Cluster.prototype.addElement = function(element) {
		if(!this.contains(element)) {
			element.changeLeftPosition(this.leftPosition);
			this.clusteredElements.push(element);
		}
	}
	
	Cluster.prototype.getClusterSize = function() {
		return this.clusteredElements.length;
	}
	
	Cluster.prototype.contains = function(element) {
		var index = 0;
		for(index; index < this.clusteredElements.length ; index ++) {
			if(this.clusteredElements[index] == element) {
				return true;
			}
		}
		return false;
	}
	
	Cluster.prototype.notifyNewClusterCreated = function(element) {
		clusterCreatedEvent = new Cluster.NewClusterCreatedEvent(this.clusteredElements, this.leftPosition);
		for(var index = 0; index < this.clusterCreatedListeners.length; index++) {
			listener = this.clusterCreatedListeners[index](clusterCreatedEvent);
		}
	}
	
	Cluster.NewClusterCreatedEvent = function(clusteredElements, leftPosition) {
		this.clusteredElements = clusteredElements;
		this.leftPosition = leftPosition;
	}

 	//*************************************************************************************
	//**************************      ELEMENTS CLUSTERER         **************************
	//*************************************************************************************
    
    ElementsClusterer = function(elementsToClusterize, elementMargin) {
		var that = this;
		this.initialize(elementsToClusterize, elementMargin)
	
		return {
			initialize : function() { return that.initialize.apply(that,arguments)},
			clusterize : function() { return that.clusterize.apply(that,arguments)},
			addOnClusterCreateListener : function() { return that.addOnClusterCreateListener.apply(that,arguments)},
			addOnElementChangeListener : function() { return that.addOnElementChangeListener.apply(that,arguments)}
		}
	}
	
	ElementsClusterer.DEFAULT_ELEMENT_MARGIN = 10
	
	//---------------- PUBLIC FUNCTIONS -----------------------------
	
	ElementsClusterer.prototype.initialize = function(elementsToClusterize, elementMargin) {
		this.elementMargin = elementMargin || ElementsClusterer.DEFAULT_ELEMENT_MARGIN;
		this.elements = [];
		this.clusters = {}; 
		this.clusterCreatedListeners=[];
		this.elementChangedListeners=[];
		
		var elementToClusterize,
			elementWrapper;
			
		for(key in elementsToClusterize) {
			elementToClusterize = elementsToClusterize[key];
			elementWrapper = new ElementWrapper(elementToClusterize, this.elementChangedListeners);
			this.elements.push(elementWrapper);
		}
		this.elements.sort(ElementWrapper.compare)
	}
	
	ElementsClusterer.prototype.clusterize = function() {
		var index = 0,
			element,
			nextElement;
		
		for( ; index < this.elements.length -1 ; index++) {
			currentElement = this.elements[index];
			nextElement = this.elements[index + 1];
			
			if(currentElement.overlaps(nextElement, this.elementMargin)) {
				this.addElementsToACluster(currentElement, nextElement);	
			}
		}
	}
	
	ElementsClusterer.prototype.addElementsToACluster = function(overlapedElement1, overlapedElement2) {
		var leftElement = ElementWrapper.getLeftElement(overlapedElement1, overlapedElement2);
		var cluster = this.findOrCreateCluster(leftElement.leftPosition);
		cluster.addElement(overlapedElement1);
		cluster.addElement(overlapedElement2);
	}
	
	ElementsClusterer.prototype.findOrCreateCluster = function(position) {
		return this.clusters[position] || this.createNewCluster(position);
	}
	
	ElementsClusterer.prototype.createNewCluster = function(position) {
		var newCluster = new Cluster(position, this.clusterCreatedListeners)
		this.clusters[position] = newCluster ;
		return newCluster;
	}
	
	//------------------------ ADD LISTENERS ----------------------------------------------
	
	ElementsClusterer.prototype.addOnClusterCreateListener = function(listener) {
		this.clusterCreatedListeners.push(listener);
	}
	
	ElementsClusterer.prototype.addOnElementChangeListener = function(listener) {
		this.elementChangedListeners.push(listener);
	}
})();