<%@taglib uri="http://www.ncr.com/tags" prefix="ncr"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.terminalsManager" userMsg="${userMsg}" section="terminals">
				<div id="header_g">
					<nav id="breadcrumb">
						<ul>
							<li>
								<a href="dashboard"><spring:message code="breadcrumb.home"/></a>
							</li>
							<li>
								<a href="terminals"><spring:message code="breadcrumb.terminals"/></a>
							</li>
							<li><spring:message code="label.terminal.new"/></li>
						</ul>
					</nav>
				</div>
				<div class="content">
					<h1><spring:message code="label.terminal.new"/></h1>
					<div class=" botonera">
						<div class="desplegable button">
							<form method="post" action="terminals/import" enctype="multipart/form-data" >
								<div class="btn txt import content_hide"><spring:message code="label.import.file"/></div>
								<div class="hide collapsible" style="display: none;">
									<input type="file" name="file">
									<div class="botonera"><input type="submit" class="btn" value="<spring:message code="label.upload"/>"></div>
								</div>
							</form>
						</div>
					</div>
					<div class="action_box data">
						<h2><spring:message code="label.terminalDetails"/></h2>
						<form:form method="post" action="terminals/list" commandName="terminal">
						  <div class="collapsible last">
						  	<div class="model">
							<div class="photo">
								<a href="<ncr:terminalModelPhotoUrl/>" class="colorbox">
									<img src="<ncr:terminalModelPhotoUrl/>"/>
									<div class="zoom"></div>
								</a>
							</div>
							<div class="desplegable">
									<div class="txt content_hide"><span><spring:message code="label.moreInfo"/></span></div>
									<dl class="collapsible hide">
										<dt><spring:message code="label.terminalModel.model"/>: </dt>
											<dd id="field_model">${terminal.terminalModel.model}</dd>
										<dt><spring:message code="label.terminalModel.productClass"/>: </dt>
											<dd id="field_product_class">${terminal.terminalModel.productClass}</dd>
										<dt><spring:message code="label.terminalModel.manufacturer"/> : </dt>
											<dd id="field_manufacturer">${terminal.terminalModel.manufacturer}</dd>
										<dt><spring:message code="label.terminalModel.nickname"/>: </dt>
											<dd id="field_nickname">${terminal.terminalModel.nickname}</dd>
										<dt><spring:message code="label.terminalModel.height"/>: </dt>
											<dd id="field_height">${terminal.terminalModel.height}</dd>
										<dt><spring:message code="label.terminalModel.width"/>: </dt>
											<dd id="field_width">${terminal.terminalModel.width}</dd>
										<dt><spring:message code="label.terminalModel.depth"/>: </dt>
											<dd id="field_depth">${terminal.terminalModel.depth}</dd>
										<dt><spring:message code="label.terminalModel.minWeight"/>: </dt>
											<dd id="field_min_weight">${terminal.terminalModel.minWeight}</dd>
										<dt><spring:message code="label.terminalModel.maxWeight"/>: </dt>
											<dd id="field_max_weight">${terminal.terminalModel.maxWeight}</dd>
									</dl>
								</div>
							</div>

							<div class="ul_data editable">
							  <ul>
												<li> <strong><form:label path="mac">
															<spring:message code="label.terminal.mac"/>
															*
														</form:label></strong>

													<form:input class='form-tf-grey' path="mac" maxlength="17"/>


														<form:errors path="mac" element="div" cssClass="error top"/>
														<c:if test="${duplicatedMac == true}">
														   	<div class="error top">
															<spring:message code="label.terminal.duplicatedMac"/>
															</div>
														</c:if>

												</li>
												<li> <strong><form:label path="ip">
															<spring:message code="label.terminal.ip"/>
															*
														</form:label></strong>
													        <form:input class='form-tf-grey' path="ip" maxlength="23"/>

														<form:errors path="ip"  element="div" cssClass="error top"/>
														<c:if test="${duplicatedIp == true}">
														<div class="error top">
															<spring:message code="label.terminal.duplicatedIp"/>
												                </div>
														</c:if>
												</li>
												<li>
													<strong>
														<form:label path="terminalVendor">

															<spring:message code="label.terminal.terminalVendor"/>

														</form:label>
													</strong>
													<form:select id="ManufacturerCombo" path="terminalVendor" onchange="ChangeManufacturer()">
														<option value=""><spring:message code="label.select.default"/></option>
														<c:forEach items="${values.keySet()}" var="key" varStatus="status1">
														  <c:if test="${key != 'allManufacturers'}">
														  	<option value="${key}"
															  	<c:if test="${key.equals(terminal.terminalVendor)}">
															  		selected="true"
															  	</c:if>
														  	>${key}</option>
														  </c:if>
														</c:forEach>
													</form:select>
												</li>
												<li>
													<strong>
														<form:label path="terminalModel.productClass">

															<spring:message code="label.terminalModel.productClass"/>

														</form:label>
													</strong>
													<form:select id="ModelsCombo" path="terminalModel.id" onchange="ChangeModel()">
													  <option value="" ></option>
													  <c:forEach items="${values.get('allManufacturers')}" var="model">
														  	<option value="${model.id}"
															  	<c:if test="${model.productClass.equals(terminal.terminalModel.productClass)}">
															  		selected="true"
															  	</c:if>
														  	>${model.productClass}</option>
														</c:forEach>
						                            </form:select>
												</li>
												<li>
													<strong>
														<form:label path="productClassDescription">

															<spring:message code="label.terminal.productClassDescription"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="productClassDescription" maxlength="120"/>

												</li>
												<li>
													<strong>
														<form:label path="serialNumber">

															<spring:message code="label.terminal.serialNumber"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="serialNumber" maxlength="50"/>
													<form:errors path="serialNumber"  element="div" cssClass="error top"/>
													<c:if test="${duplicatedSerialNumber == true}">
														<div class="error top"><spring:message code="label.terminal.duplicatedSerialNumber"/></div>
													</c:if>
												</li>
												<li>
													<strong>
														<form:label path="terminalType">

															<spring:message code="label.terminal.terminalType"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="terminalType" maxlength="50"/>
													<form:errors path="terminalType"  elnement="div" cssClass="error top"/>
												</li>
												<li>
													<strong>
														<form:label path="frontReplenish">

															<spring:message code="label.terminal.frontReplenish"/>

														</form:label>
													</strong>
													<form:checkbox path="frontReplenish"/>

												</li>
												<li>
													<strong>
														<form:label path="bank">

															<spring:message code="label.terminal.bank"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="bank" maxlength="50"/>
													<form:errors path="bank"  element="div" cssClass="error top"/>
												</li>
												<li>
													<strong>
														<form:label path="branch">

															<spring:message code="label.terminal.branch"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="branch" maxlength="50"/>
													<form:errors path="branch"  element="div" cssClass="error top"/>
												</li>
												<li>
													<strong>
														<form:label path="manufacturingSite">

															<spring:message code="label.terminal.manufacturingSite"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="manufacturingSite" maxlength="20"/>
												</li>
												<li>
													<strong>
														<form:label path="tracerNumber">

															<spring:message code="label.terminal.tracerNumber"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="tracerNumber" maxlength="20"/>

												</li>
											</ul>
											<div id="txtAge" style="display:none">
											<h3><spring:message code="label.installation.data"/></h3>
												<div class="ul_data editable">
													<ul>
														<li>
															<strong><label for="date"><spring:message code="label.installation.startDate"/></label></strong>
															<input id="date" name="date" type="text" value="22/10/2013">
															<div class="error-td"></div>
														</li>
														<li class="td">
															<strong><label for="noff"><spring:message code="label.location.office"/></label></strong>
															<div class="row">
																<input id="noff" name="noff" type="text" class="num">
																<button class="btn"><spring:message code="label.validate"/></button>
															</div>
															<div class="message">
																La Caixa
																Oficina Avenida de los Andes, 24, 28042
																Madrid - España - Teléfono: 91 440 38 90
																X 40.454932, Y -3.620907
															</div>
															<div class="error-td"></div>
														</li>
														<li>
															<strong><label for="type"><spring:message code="label.installation.type"/></label></strong>
															<input id="type" name="type" type="text">
															<div class="error-td"></div>
														</li>
														<li>
															<strong><label for="date_off"><spring:message code="label.installation.endDate"/></label></strong>
															<input id="date_off" name="date_off" type="text">
															<div class="error-td"></div>
														</li>
														<li>
															<strong><label for="procesado"><spring:message code="label.location.processed"/></label></strong>
															<input id="procesado" name="procesado" type="text">
															<div class="error-td"></div>
														</li>
														<li>
															<strong><label for="date_off"><spring:message code="label.location.publicAccess"/></label></strong>
															<input type="checkbox">
														</li>
													</ul>
												</div>
											</div>

										</div>
										<div class="botonera">
											<input type="submit" class="btn save" value="<spring:message code="label.terminal.save"/>"/>
											<a href="terminals" class="btn cancel"><spring:message code="label.cancel"/></a>
										</div>
									</form:form>
						</div>
						<!-- // collapsible -->
					</div>
					<!-- // /action_box -->
				</div>

	</div>
	<script type="text/javascript">
	    $(function() {
	        onLoadModelCB();
	    });
	    var valuesTree = {
	        	<c:forEach items="${values.keySet()}" var="key" varStatus="status1">
	        		<c:set var="value" value="${values.get(key)}"/>
	       	 '${key}': {
					<c:forEach items="${value}" var="model" varStatus="status2">
						'${model.id}': {
							'model' : '${model.model}',
							'product_class' : '${model.productClass}',
							'manufacturer' : '${model.manufacturer}',
							'nickname' : '${model.nickname}',
							'height' : '${model.height}',
							'width' : '${model.width}',
							'depth' : '${model.depth}',
							'min_weight' : '${model.minWeight}',
							'max_weight' : '${model.maxWeight}'
						},
					</c:forEach>
                        'photoUrl': '<ncr:terminalModelPhotoUrl manufacturer="${key}"/>'
	       	 			}${not status1.last ? ',' : ''}
	       		</c:forEach>
	    };
	    function onLoadModelCB(){
		    	var value = $('#ManufacturerCombo').val();
		    	var $cb = $('#ModelsCombo');
		    	if (value == '') {
		    		$cb.empty();
					$cb.append($('<option selected="selected"></option>'));
		    	} else {
		    		var values = valuesTree[value];
		    		$('#ModelsCombo > option').each(function()
							{
								if (!(($(this).val() in values) || ($(this).val() == ''))) {
									$(this).remove();
								}
							}
		    		);
		    	}
	            if (!$cb.val()) {
					var photoUrl = valuesTree[value]['photoUrl'];
					$('.photo a').attr("href", photoUrl);
					$('.photo img').attr("src", photoUrl);
	          	};
	    };
	    function ChangeManufacturer(){
			var $cb1 = $('#ModelsCombo');
			var $cb2 = $('#ManufacturerCombo');
			$cb1.empty();
			$cb1.append($('<option selected="selected"></option>'));
			if ($cb2.val() != '') {
				var values = valuesTree[$cb2.val()];
				var keys = $.map(values, function(v, i){
					  return i;
					});
				keys.sort(function(a,b){
				    var compA = values[a].label;
				    var compB = values[b].label;
				    return (compA < compB) ? -1 : (compA > compB) ? 1 : 0;
				  });
				$.each(keys, function(index, key) {
                      if (key != 'photoUrl') {
				          $cb1.append($('<option/>')
					         .attr("value", key).text(values[key]['product_class']));
                      }
				});
				$cb1.prop('disabled', false);
			} else {
				$cb1.prop('disabled', true);
			};
			$('#field_model').text('');
			$('#field_product_class').text('');
			$('#field_manufacturer').text('');
			$('#field_nickname').text('');
			$('#field_width').text('');
			$('#field_height').text('');
			$('#field_depth').text('');
			$('#field_min_weight').text('');
			$('#field_max_weight').text('');
            var photoUrl;
            if ($cb2.val()) {
              photoUrl = valuesTree[$cb2.val()]['photoUrl'];
            } else {
              photoUrl = '<ncr:terminalModelPhotoUrl />'
            }
			$('.photo a').attr("href", photoUrl);
			$('.photo img').attr("src", photoUrl);
	    };

	    function ChangeModel(){
			var $cb1 = $('#ModelsCombo');
			var $cb2 = $('#ManufacturerCombo');
			if (($cb1.val() != '') && ($cb2.val() != '')) {
				var values = valuesTree[$cb2.val()][$cb1.val()];
				$('#field_model').text(values.model);
				$('#field_product_class').text(values.product_class);
				$('#field_manufacturer').text(values.manufacturer);
				$('#field_nickname').text(values.nickname);
				$('#field_width').text(values.width);
				$('#field_height').text(values.height);
				$('#field_depth').text(values.depth);
				$('#field_min_weight').text(values.min_weight);
				$('#field_max_weight').text(values.max_weight);
				$('.photo a').attr("href", 'terminals/models/image/' + $cb1.val());
				$('.photo img').attr("src", 'terminals/models/image/' + $cb1.val() + '?width=200');
			}
            if (!$cb1.val()) {
                  var photoUrl = valuesTree[$cb2.val()]['photoUrl'];
			      $('.photo a').attr("href", photoUrl);
			      $('.photo img').attr("src", photoUrl);
            }
	    };
    </script>

</t:osoco-wrapper>
