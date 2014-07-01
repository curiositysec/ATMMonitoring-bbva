function defaultInitTabs() {	
	$('#tabs .content_tab').hide(); // cierro todas las capas
    $('#tabs .content_tab:first').show(); // muestro la primera
    $('.sub_nav li').removeClass('current');
    $('.sub_nav li:first').addClass('current'); // activo el primer tab
    $('.sub_nav li').click(function(event) {
	    $('.sub_nav li').removeClass('current'); // borro estilo current de todos los li
	    $(this).addClass('current');
	    var tab_click =  $('.sub_nav li').index(this);
	    $('#tabs .content_tab').hide();
	    $('#tabs').find( ".content_tab" ).eq( tab_click ).show();
	    
	    event.preventDefault();
	    
	    var eventOnShowData = $(this).data('onShow');
	    if(eventOnShowData) {
	    	eval(eventOnShowData);
	    }
	});
}

function countOccurences(mainStr, strToCount) {
	return mainStr.split(strToCount).length
}