<script>

function show(which) {
var hide = new Array();
hide = document.getElementsByName(which);
for (i=0; i<hide.length; i++) {
hide[i].style.display = 'inline';
}
}
function hide(which) {
var hide = new Array();
hide = document.getElementsByName(which);
for (i=0; i<hide.length; i++) {
hide[i].style.display = 'none';
}
}
</script>

<style type="text/css">
	iframe { display: none; }
</style>


<b>Terminales</b>
<input type="button" value="Show" onclick="show('iframe');">
<input type="button" value="Hide" onclick="hide('iframe');">
<iframe width="640" height="480" src="http://135.130.12.225/MicroStrategy/asp/Main.aspx?Server=PC-ELI&Project=inventory&port=0&evt=2048001&src=Main.aspx.2048001&visMode=0&documentID=3438E8F542936CA3E0D0C7A1662D35DB&currentViewMedia=2&hiddensections=header,path,dockTop,dockLeft,footer"  name='iframe'></iframe>