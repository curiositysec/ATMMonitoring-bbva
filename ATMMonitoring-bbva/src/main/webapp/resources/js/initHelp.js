 $(function() {
	 var helpLayout = $('div#helpLayout');
	 
	 if (helpLayout) {
	 	initHelpHandlers();
	 }
	 
	 
	 function initHelpHandlers() {
	 	 helpLayout.find('a#goHelp').click(function(event)  {
		 	goToHelp();
		 	event.preventDefault();
		 });
		 
		 helpLayout.find('a#returnFromHelp').click(function(event)  {
		 	returnFromHelp();
		 	event.preventDefault();
		 });
	 }
	 
	 function goToHelp() {
	 	animateHelpLayout('-100%')
	 }
	 
	 function returnFromHelp() {
	 	animateHelpLayout('0')
	 }
	 
	 function animateHelpLayout(leftStyle) {
	 	helpLayout.animate({
			left: leftStyle
		}, 500)
	 }
	 
 });
 