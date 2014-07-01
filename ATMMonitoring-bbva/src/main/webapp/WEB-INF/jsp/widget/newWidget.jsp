<%@taglib tagdir="/WEB-INF/tags/widget/" prefix="widget" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapperWoMenu titleCode="label.terminalsManager" section="iframe">
<div id="main">
	<div id="primary">
		<article>
			<h1><spring:message code="widget.create.title" /></h1>
			<div class="content fixed">
				<label>
					<input type="radio" name="creationType" value="dashboard/create" checked="checked">
					<spring:message code="widget.create.new" />
				</label>
				
				<label>
					<input type="radio" name="creationType" value="dashboard/createFromLibrary" >
					<spring:message code="widget.create.from.library" />
				</label>
				
				<div class="botonera">
					<input id="next" type="button" class="btn next" value="Continuar">
				</div>
			</div><!-- /content -->
		</article>
	</div>
</div>

<script type="text/javascript">
	$("input#next").click(function() {
		var selectedOption = $("input[type=radio]:checked");
		window.location.assignWithBase(selectedOption.val());
	})
</script>

</t:osoco-wrapperWoMenu>