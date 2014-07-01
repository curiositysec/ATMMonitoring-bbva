<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.queryEngine" userMsg="${userMsg}"  section="reports">
<script type="text/javascript">
	$(document).ready(function(){
        $("#reportFrameContainer").hide();
        $("#toggleReportView").find("li").click(function(event) {
        	event.preventDefault();
            if (!$(this).hasClass("current")) {
            	$(this).parent().find("li").removeClass("current");
            	var active = $(this).attr('class');
            	$(".content.reportView").removeClass("column3 lista");
            	$(".content.reportView").addClass(active);
            	$(this).addClass("current");
            };
        });
        $(".box_list a").click(function(event) {
            event.preventDefault();
            var url = $(this).attr("href");
            loadInFrame(url);
            $(".content.reportView").hide();
            $("#reportFrameContainer").show("slow");
        });
        $("a.back").click(function(event) {
            event.preventDefault();
            $("#reportFrameContainer").hide();
            $(".content.reportView").show("slow");
        });
	});

    function loadInFrame(url) {
        $("#reportFrame").attr("src", url);
    }
</script>
<div id="header_g">
	<nav id="breadcrumb">
		<ul>
			<li>
				<a href="dashboard"><spring:message code="breadcrumb.home"/></a>
			</li>

			<li><spring:message code="breadcrumb.reports"/></li>
		</ul>
	</nav>
</div>

<h1>
  <spring:message code="label.externalreportsMan"/>
</h1>

<h2>
  <spring:message code="label.externalreports"/>
</h2>

<div id="reportFrameContainer">
    <div class="botonera">
        <a class="btn back left" href="externalreports">Return to reports</a>
    </div>
    <iframe id="reportFrame" width="100%" height="900"></iframe>
</div>

<div class="content reportView column3">
	<div id="header_g">
		<div id="toggleReportView" class="columns_botonera">
		  <nav>
		    <ul>
		        <li class="column3 current">
		          <a href="#"><span>Columnas</span></a>
		        </li>
		        <li class="lista">
		          <a href="#"><span>Lista</span></a>
		        </li>
		    </ul>
		  </nav>
		</div>
	</div>
	<div class="box_list">
		<a href="http://1.0.0.2/MicroStrategy/asp/Main.aspx?Server=PC-ELI&Project=Test&port=0&evt=4001&src=Main.aspx.4001&visMode=0&reportID=06E08F484207A7A6DAAB0F94B4C31261&reportViewMode=1&hiddensections=header,path,dockTop,dockLeft,footer">
			<h3><spring:message code="label.report.name"/></h3>
			<img src="resources/images/ejemplo/grafico.png"/>
			<p><spring:message code="label.report.description"/></p>
		</a>
	</div>
	<div class="box_list">
		<a href="http://1.0.0.2/MicroStrategy/asp/Main.aspx?Server=PC-ELI&Project=Test&port=0&evt=4001&src=Main.aspx.4001&visMode=0&reportID=06E08F484207A7A6DAAB0F94B4C31261&reportViewMode=1&hiddensections=header,path,dockTop,dockLeft,footer">
			<h3><spring:message code="label.report.name"/></h3>
			<img src="resources/images/ejemplo/grafico.png"/>
			<p><spring:message code="label.report.description"/></p>
		</a>
		</a>
	</div>
	<div class="box_list">
		<a href="http://1.0.0.2/MicroStrategy/asp/Main.aspx?Server=PC-ELI&Project=Test&port=0&evt=4001&src=Main.aspx.4001&visMode=0&reportID=06E08F484207A7A6DAAB0F94B4C31261&reportViewMode=1&hiddensections=header,path,dockTop,dockLeft,footer">
			<h3>Report Name</h3>
			<img src="resources/images/ejemplo/grafico.png"/>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quisquam, expedita, dolor, ad, quod quis ex doloribus enim reprehenderit est tenetur ducimus cum aliquid ratione. Quaerat dolor sint architecto culpa consequatur!</p>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quisquam, expedita, dolor, ad, quod quis ex doloribus enim reprehenderit est tenetur ducimus cum aliquid ratione. Quaerat dolor sint architecto culpa consequatur!</p>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quisquam, expedita, dolor, ad, quod quis ex doloribus enim reprehenderit est tenetur ducimus cum aliquid ratione. Quaerat dolor sint architecto culpa consequatur!</p>
		</a>
	</div>
	<div class="box_list">
		<a href="http://1.0.0.2/MicroStrategy/asp/Main.aspx?Server=PC-ELI&Project=Test&port=0&evt=4001&src=Main.aspx.4001&visMode=0&reportID=06E08F484207A7A6DAAB0F94B4C31261&reportViewMode=1&hiddensections=header,path,dockTop,dockLeft,footer">
			<h3>Report Name</h3>
			<img src="resources/images/ejemplo/grafico.png"/>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quisquam, expedita, dolor, ad, quod quis ex doloribus enim reprehenderit est tenetur ducimus cum aliquid ratione. Quaerat dolor sint architecto culpa consequatur!</p>
		</a>
	</div>
	<div class="box_list">
		<a href="http://1.0.0.2/MicroStrategy/asp/Main.aspx?Server=PC-ELI&Project=Test&port=0&evt=4001&src=Main.aspx.4001&visMode=0&reportID=06E08F484207A7A6DAAB0F94B4C31261&reportViewMode=1&hiddensections=header,path,dockTop,dockLeft,footer">
			<h3>Report Name</h3>
			<img src="resources/images/ejemplo/grafico.png"/>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quisquam, expedita, dolor, ad, quod quis ex doloribus enim reprehenderit est tenetur ducimus cum aliquid ratione. Quaerat dolor sint architecto culpa consequatur!</p>
		</a>
	</div>
	<div class="box_list">
		<a href="http://1.0.0.2/MicroStrategy/asp/Main.aspx?Server=PC-ELI&Project=Test&port=0&evt=4001&src=Main.aspx.4001&visMode=0&reportID=06E08F484207A7A6DAAB0F94B4C31261&reportViewMode=1&hiddensections=header,path,dockTop,dockLeft,footer">
			<h3><spring:message code="label.report.name"/></h3>
			<img src="resources/images/ejemplo/grafico.png"/>
			<p><spring:message code="label.report.description"/></p>
		</a>
	</div>
	<div class="box_list">
		<a href="http://1.0.0.2/MicroStrategy/asp/Main.aspx?Server=PC-ELI&Project=Test&port=0&evt=4001&src=Main.aspx.4001&visMode=0&reportID=06E08F484207A7A6DAAB0F94B4C31261&reportViewMode=1&hiddensections=header,path,dockTop,dockLeft,footer">
			<h3><spring:message code="label.report.name"/></h3>
			<img src="resources/images/ejemplo/grafico.png"/>
			<p><spring:message code="label.report.description"/></p>
		</a>
	</div>
	<div class="box_list">
		<a href="http://1.0.0.2/MicroStrategy/asp/Main.aspx?Server=PC-ELI&Project=Test&port=0&evt=4001&src=Main.aspx.4001&visMode=0&reportID=06E08F484207A7A6DAAB0F94B4C31261&reportViewMode=1&hiddensections=header,path,dockTop,dockLeft,footer">
			<h3>Report Name</h3>
			<img src="resources/images/ejemplo/grafico.png"/>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quisquam, expedita, dolor, ad, quod quis ex doloribus enim reprehenderit est tenetur ducimus cum aliquid ratione. Quaerat dolor sint architecto culpa consequatur!</p>
		</a>
	</div>
	<div class="box_list">
			<a href="http://1.0.0.2/MicroStrategy/asp/Main.aspx?Server=PC-ELI&Project=Test&port=0&evt=4001&src=Main.aspx.4001&visMode=0&reportID=06E08F484207A7A6DAAB0F94B4C31261&reportViewMode=1&hiddensections=header,path,dockTop,dockLeft,footer">
			<h3><spring:message code="label.report.name"/></h3>
			<img src="resources/images/ejemplo/grafico.png"/>
			<p><spring:message code="label.report.description"/></p>
		</a>
	</div>
	<div class="box_list">
		<a href="http://1.0.0.2/MicroStrategy/asp/Main.aspx?Server=PC-ELI&Project=Test&port=0&evt=4001&src=Main.aspx.4001&visMode=0&reportID=06E08F484207A7A6DAAB0F94B4C31261&reportViewMode=1&hiddensections=header,path,dockTop,dockLeft,footer">
			<h3><spring:message code="label.report.name"/></h3>
			<img src="resources/images/ejemplo/grafico.png"/>
			<p><spring:message code="label.report.description"/></p>
		</a>
	</div>
</div>

</t:osoco-wrapper>
