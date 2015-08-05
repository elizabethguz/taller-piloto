function empty(el) {
	el.value = '';
	el.onfocus = null;
}

function upload_mode(mode) {
	if (mode == 0) {
		$('#up-file').show('slow');
		$('#up-url').hide('slow');
	} else {
		$('#up-file').hide('slow');
		$('#up-url').show('slow');
	}
}

function zoom(img) {
	window.open(img.src);
}

function show_link() {
	setTimeout(function(){$('.wait').css('visibility', 'visible');},Math.floor(Math.random()*7)*1000+3000);
}

$(function() {
	setTimeout(function(){
		$('#messages .message').hide(500);
	}, 10000);
	$('#messages .message').css('cursor', 'pointer').attr('title', 'Click para ocultar').click(function(){
		$(this).hide(500);
	});

	if ($('#url_forward').length) {
		$('#image-submit').before('<div class="space"><label class="big">Imágen para Adultos <input type="checkbox" name="adultos" id="adultos" value="1"></label></div>');
		$('#adultos').change(function() {
			var url = $('#url_forward').val();
			$('#url_forward').val($('#upform').attr('action'));
			$('#upform').attr('action', url);
		});
	}
});

/* UND */
function createCookie(c,e,d){if(d){var b=new Date();b.setTime(b.getTime()+(d*1000));var a="; expires="+b.toGMTString()}else{var a=""}document.cookie=c+"="+e+a+"; path=/"}function readCookie(b){var e=b+"=";var a=document.cookie.split(";");for(var d=0;d<a.length;d++){var f=a[d];while(f.charAt(0)==" "){f=f.substring(1,f.length)}if(f.indexOf(e)==0){return f.substring(e.length,f.length)}}return null}function eraseCookie(a){createCookie(a,"",-1)}function load_pop(c,b,e){var d=typeof(b)=="undefined"?document.body.clientWidth:b;var a=typeof(e)=="undefined"?document.body.clientHeight:e;var i="location=yes,scrollbars=yes,menubar=yes,toolbar=yes,left=0,top=0,height="+a+",width="+d;var f=1;var g=readCookie("under");if(g){g=parseInt(g)}else{g=0}if(g>=f){return false}win2=window.open("","bw"+g,i);if(!win2){return false}win2.blur();window.focus();win2.location=c;g++;createCookie("under",g,86400);return true}function set_under(b,a,c){$("body").click(function(){load_pop(b,a,c)})};
