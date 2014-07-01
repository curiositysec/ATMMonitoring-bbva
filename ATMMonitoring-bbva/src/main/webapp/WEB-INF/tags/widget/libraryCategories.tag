<%@tag description="List widgets by category" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@attribute name="formAction" required="true" type="String"%>
<%@attribute name="widgetId" required="false" type="Integer"%>
<%@attribute name="selectCategory" required="true" type="Boolean"%>
<%@attribute name="messageKey" required="false" type="String"%>


<div id="main">
	<div id="primary">
		<article>
			<h1><spring:message code="widget.${messageKey}.library.title" /></h1>
			<c:choose>
				<c:when test="${empty categories}">
					<div class="message">
		            	<p><spring:message code="widget.create.from.library.no.categories"/></p>
		          	</div>
				</c:when>
				<c:otherwise>
					
					<div class="content graph_content fixed">
						<form method="post" action="${formAction}" >
							<input type="hidden" name="widgetId" value="${widgetId}" />
							<ul class="category_library">
								<c:forEach var="category" items="${categories}"> 
									<li class="category">
										<label>
											<c:if test="${selectCategory}">
												<input type="radio" name="categoryId" value="${category.id}"> 
											</c:if> 
											${category.name}
										</label>
										
										<ul class="widgets">
											<c:forEach var="widget" items="${category.widgets}"> 
												<li><label>
													<c:if test="${!selectCategory}">
														<input type="checkbox" name="widgetIds" value="${widget.id}">
													</c:if>
													${widget.title}
												</label></li>	
											</c:forEach>
										</ul>
									</li>
								</c:forEach>
							</ul>
							<div class="botonera">
								<input type="submit" class="btn next" value="<spring:message code="widget.${messageKey}.library.button.label"/>">
							</div>
						</form>				
					</div><!-- /content -->		
				</c:otherwise>
			</c:choose>
		</article>
	</div>
</div>

<script type="text/javascript">
$(function() {
	var categoryListElement = $("ul.category_library > li.category > label");
	var widgetsByCategory = $("ul.category_library li.category ul");
	
	categoryListElement.click(function(event)  {
		var clickedElement = $(this);
		widgetsByCategory.hide();
		categoryListElement.removeClass('selected');
		
		clickedElement.addClass('selected');
		clickedElement.siblings("ul.widgets").show();
	});
});	
</script>