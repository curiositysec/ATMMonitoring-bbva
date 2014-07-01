
$(function() {

    $.fn.extend({
        unfold: function() {
            this.each(function() {
		        $(this).removeClass('content_hide');
		        $(this).next('.collapsible').show('slow');
		    });
        },
        fold: function() {
            this.each(function() {
			    $(this).next(".collapsible").hide('slow');
			    $(this).addClass('content_hide');
            });
        }
    });

	$(".content_hide").next('.collapsible').hide(); // Cierro todos los menun de las cajas

	$(document).on("click", ".desplegable .txt", function(event) {
        event.stopPropagation();
		if($(this).hasClass('content_hide')){ // si pulso en uno que está cerrado...
            $(this).unfold();
            
            try {
	            var contentContainer = $(this).parents('.contendorDelDesplegable')
	            if(contentContainer) {
	            	var contentContainerPossition = contentContainer.offset().top;
	            	var clickedElementPossition = $(this).offset().top;
					var currentScrollTop = contentContainer.scrollTop(); 
	
					contentContainer.animate({
	        			scrollTop:  currentScrollTop + (clickedElementPossition - contentContainerPossition)
	    			}, 500);
	    		}
    		} catch(e) {}
        }else{
            $(this).fold();
		}
	});

    $(document).on("click", "body", function() {
        $(".desplegable.autofold").find(".txt").fold();
    });

// Mostrar detalle de un TR
	$('table .detail').hide();
	$('table .showdetail').removeClass('open');
	$('table .showdetail').click(function() {
		if($(this).hasClass('open')){
			$(this).removeClass('open');
			$(this).next('.detail').hide();
		}else{
			$('.showdetail').removeClass('open');
			$('.detail').hide();
			$(this).addClass('open');
			$(this).next('.detail').show();
		}
	});

// Check all
	$("input.all_check").change(function(){
		$('.check input[type=checkbox]').each( function() {
			if($("input.all_check:checked").length == 1){
				this.checked = true;
			} else {
				this.checked = false;
			}
		});
	});
// Colorbox

   initIframes('')

// Instalacion ATM checkbox
	$('#isAgeSelected').click(function() {
	    $("#txtAge").toggle(this.checked);
	});

// Responsive menu
	$('#rButton').click(function() {
		if($(this).hasClass("btn_close")){
			$("#main").removeClass("btn_close")
			$("#main_nav").removeClass("btn_close")
			$(this).removeClass("btn_close");
		}else{
			$("#main").addClass("btn_close")
			$("#main_nav").addClass("btn_close")
			$(this).addClass("btn_close");
		}
	});
});

function initIframes(prefixSelector) {
	$(prefixSelector +".iframe").colorbox({iframe:true, width:"90%", height:"90%"}); // Iframes
	$(prefixSelector +".iframe_s").colorbox({iframe:true, width:"640", height:"480px", maxWidth:"100%", maxHeight:"100%"}); // Iframes
	$(prefixSelector +".iframe_medium").colorbox({iframe:true, width:"640", height:"550px", maxWidth:"100%", maxHeight:"100%"}); // Iframes
	$(prefixSelector +".iframe_m").colorbox({iframe:true, width:"1000px", height:"600px"}); // Iframes Mapa
	$(prefixSelector +".colorbox").colorbox({rel:'group1', maxWidth:"100%", maxHeight:"100%", photo: true}); // Photo
	$(prefixSelector +".inline").colorbox({inline:true,  width:"640", height:"480px"}); // pop-ups en la misma pagina
}
