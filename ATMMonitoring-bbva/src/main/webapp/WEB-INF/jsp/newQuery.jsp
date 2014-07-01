<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.queryEngine" userMsg="${userMsg}"  section="terminals">

				<div id="header_g">
					<nav id="breadcrumb">
						<ul>
							<li>
								<a href="#"><spring:message code="breadcrumb.home"/></a>
							</li>
							<li><a href="terminals"><spring:message code="breadcrumb.terminals"/></a></li>
							<li><a href="queries"><spring:message code="label.queries.mine"/></a></li>
							<li><spring:message code="label.query.new"/></li>
						</ul>
					</nav>
				</div>

				<div class="content">
	<h1><spring:message code="label.query.new"/></h1>
	<c:if test="${error != null}">
       <div class="alert"><p><spring:message code="${error}"/></p></div>
    </c:if>
	<div class="botonera"><a href="queries" class="btn back left"><spring:message code="label.query.return"/></a></div>
	<!-- Pegado de querie.jsp -->
	<div class="action_box desplegable">
			<form:form method="post" action="queries/results" commandName="query">
				<h2 class="txt" id="terminalSection">
					<spring:message code="label.query.terminalSection"/>
				</h2>
					<div class="collapsible">
						<table class="query-form">
							<tr>
								<th>
									<spring:message code="label.query.field"/>
								</th>
								<th>
									<spring:message code="label.query.not"/>
								</th>
								<th>
									<spring:message code="label.query.comparison"/>
								</th>
								<th>
									<spring:message code="label.query.value"/>
								</th>
								<th></th>
							</tr>
							<c:forEach var="i" begin="1" end="5" varStatus="status">
								<tr id="terminalRow${i}" <c:if test="${!status.first}">class="hidden"</c:if>>
									<td>
										<form:select path="terminalCombo${i}1" id="terminalCombo${i}1" class="query_selectors" size="1" onchange="ChangeValue2CB1('terminal',${i})">
											<form:option value="" label=""/>
											<c:forEach items="${values.get('terminal').keySet()}" var="value">
												<form:option value="${value}">
													<spring:message code="label.terminal.${value}"/>
												</form:option>
											</c:forEach>
										</form:select>
									</td>
									<td>
										<form:checkbox path="terminalCB${i}" id="terminalCB${i}" disabled="true"/>
									</td>
									<td>
										<form:select path="terminalCombo${i}2" id="terminalCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="ChangeValue2CB2('terminal',${i})">
											<form:option value="" label=""/>
										</form:select>
									</td>
									<td>
										<form:input class='form-tf-grey' path="terminalField${i}" id="terminalField${i}" disabled="true" maxlength="150"/>
										</td>
									<c:if test="${!status.last}">
										<td class="btn_add">
											<div id="terminalShowButton${i}" onclick="showHiddenRow('terminal', ${i})" class="btn add"><span><spring:message code="label.query.add"/></span></div>
										</td>
									</c:if>
									<c:if test="${status.last}">
										<td> </td>
									</c:if>
								</tr>
							</c:forEach>
						</table>
					</div><!-- /collapsible -->
				<h2 class="txt content_hide" id="hwSection">
					<spring:message code="label.query.hardwareSection"/>
					<span></span>
				</h2>
					<div class="collapsible">
						<h3>
							<spring:message code="label.query.hardwareDeviceSection"/>
						</h3>
						<table class="query-form">
							<tr>
								<th>
									<spring:message code="label.query.deviceType"/>
								</th>
								<th>
									<spring:message code="label.query.field"/>
								</th>
								<th>
									<spring:message code="label.query.not"/>
								</th>
								<th>
									<spring:message code="label.query.comparison"/>
								</th>
								<th>
									<spring:message code="label.query.value"/>
								</th>
								<th></th>
							</tr>
							<c:forEach var="i" begin="1" end="5" varStatus="status">
								<tr id="hardwareDeviceRow${i}" <c:if test="${!status.first}">class="hidden"</c:if>>
									<td>
										<form:select path="hardwareDeviceCombo${i}1" id="hardwareDeviceCombo${i}1" class="query_selectors" size="1" onchange="ChangeValue3CB1('hardwareDevice', ${i})">
											<form:option value="" label=""/>
											<c:forEach items="${values.get('hardwareDevice').keySet()}" var="value">
												<c:if test="${value != 'allHwDevices'}">
													<form:option value="${value}">
														<spring:message code="label.hardwareDevice.${value}"/>
													</form:option>
												</c:if>
											</c:forEach>
										</form:select>
									</td>
									<td>
										<form:select path="hardwareDeviceCombo${i}2" id="hardwareDeviceCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="ChangeValue3CB2('hardwareDevice', ${i})">
											<form:option value="" label=""/>
										</form:select>
									</td>
									<td>
										<form:checkbox path="hardwareDeviceCB${i}" id="hardwareDeviceCB${i}" disabled="true"/>
									</td>
									<td>
										<form:select path="hardwareDeviceCombo${i}3" id="hardwareDeviceCombo${i}3" class="query_selectors" size="1" disabled="true" onchange="ChangeValue3CB3('hardwareDevice', ${i})">
											<form:option value="" label=""/>
										</form:select>
									</td>
									<td>
										<form:input class='form-tf-grey' path="hardwareDeviceField${i}" id="hardwareDeviceField${i}" disabled="true" maxlength="150"/>
										</td>
									<c:if test="${!status.last}">
										<td class="btn_add">
											<div id="hardwareDeviceShowButton${i}" onclick="showHiddenRow('hardwareDevice', ${i})" class="btn add"><span><spring:message code="label.query.add"/></span></div>
										</td>
									</c:if>
									<c:if test="${status.last}">
										<td> </td>
									</c:if>
								</tr>
							</c:forEach>
						</table>
						<h3>
							<spring:message code="label.query.financialDeviceSection"/>
						</h3>
						<table class="query-form">
							<tr>
								<th>
									<spring:message code="label.query.field"/>
								</th>
								<th>
									<spring:message code="label.query.not"/>
								</th>
								<th>
									<spring:message code="label.query.comparison"/>
								</th>
								<th>
									<spring:message code="label.query.value"/>
								</th>
								<th></th>
							</tr>
							<c:forEach var="i" begin="1" end="5" varStatus="status">
								<tr id="financialDeviceRow${i}" <c:if test="${!status.first}">class="hidden"</c:if>>
									<td>
										<form:select path="financialDeviceCombo${i}1" id="financialDeviceCombo${i}1" class="query_selectors" size="1" onchange="ChangeValue2CB1('financialDevice', ${i})">
											<form:option value="" label=""/>
											<c:forEach items="${values.get('financialDevice').keySet()}" var="value">
												<form:option value="${value}">
													<spring:message code="label.financialDevice.${value}"/>
												</form:option>
											</c:forEach>
										</form:select>
									</td>
									<td>
										<form:checkbox path="financialDeviceCB${i}" id="financialDeviceCB${i}" disabled="true"/>
									</td>
									<td>
										<form:select path="financialDeviceCombo${i}2" id="financialDeviceCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="ChangeValue2CB2('financialDevice', ${i})">
											<form:option value="" label=""/>
										</form:select>
									</td>
									<td>
										<form:input class='form-tf-grey' path="financialDeviceField${i}" id="financialDeviceField${i}" disabled="true" maxlength="150"/>
										</td>
									<c:if test="${!status.last}">
										<td class="btn_add">
											<div id="financialDeviceShowButton${i}" onclick="showHiddenRow('financialDevice', ${i})" class="btn add"><span><spring:message code="label.query.add"/></span></div>
										</td>
									</c:if>
									<c:if test="${status.last}">
										<td> </td>
									</c:if>
								</tr>
							</c:forEach>
						</table>
						<h3>
							<spring:message code="label.query.xfsComponentSection"/>
						</h3>
						<table class="query-form">
							<tr>
								<th>
									<spring:message code="label.query.field"/>
								</th>
								<th>
									<spring:message code="label.query.not"/>
								</th>
								<th>
									<spring:message code="label.query.comparison"/>
								</th>
								<th>
									<spring:message code="label.query.value"/>
								</th>
								<th></th>
							</tr>
							<c:forEach var="i" begin="1" end="5" varStatus="status">
								<tr id="xfsComponentRow${i}" <c:if test="${!status.first}">class="hidden"</c:if>>
									<td>
										<form:select path="xfsComponentCombo${i}1" id="xfsComponentCombo${i}1" class="query_selectors" size="1" onchange="ChangeValue2CB1('xfsComponent', ${i})">
											<form:option value="" label=""/>
											<c:forEach items="${values.get('xfsComponent').keySet()}" var="value">
												<form:option value="${value}">
													<spring:message code="label.xfsComponent.${value}"/>
												</form:option>
											</c:forEach>
										</form:select>
									</td>
									<td>
										<form:checkbox path="xfsComponentCB${i}" id="xfsComponentCB${i}" disabled="true"/>
									</td>
									<td>
										<form:select path="xfsComponentCombo${i}2" id="xfsComponentCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="ChangeValue2CB2('xfsComponent', ${i})">
											<form:option value="" label=""/>
										</form:select>
									</td>
									<td>
										<form:input class='form-tf-grey' path="xfsComponentField${i}" id="xfsComponentField${i}" disabled="true" maxlength="150"/>
										</td>
									<c:if test="${!status.last}">
										<td class="btn_add">
											<div id="xfsComponentShowButton${i}" onclick="showHiddenRow('xfsComponent', ${i})" class="btn add"><span><spring:message code="label.query.add"/></span></div>
										</td>
									</c:if>
									<c:if test="${status.last}">
										<td> </td>
									</c:if>
								</tr>
							</c:forEach>
						</table>
						<h3>
							<spring:message code="label.query.jxfsComponentSection"/>
						</h3>
						<table class="query-form">
							<tr>
								<th>
									<spring:message code="label.query.field"/>
								</th>
								<th>
									<spring:message code="label.query.not"/>
								</th>
								<th>
									<spring:message code="label.query.comparison"/>
								</th>
								<th>
									<spring:message code="label.query.value"/>
								</th>
								<th></th>
							</tr>
							<c:forEach var="i" begin="1" end="5" varStatus="status">
								<tr id="jxfsComponentRow${i}" <c:if test="${!status.first}">class="hidden"</c:if>>
									<td>
										<form:select path="jxfsComponentCombo${i}1" id="jxfsComponentCombo${i}1" class="query_selectors" size="1" onchange="ChangeValue2CB1('jxfsComponent', ${i})">
											<form:option value="" label=""/>
											<c:forEach items="${values.get('jxfsComponent').keySet()}" var="value">
												<form:option value="${value}">
													<spring:message code="label.jxfsComponent.${value}"/>
												</form:option>
											</c:forEach>
										</form:select>
									</td>
									<td>
										<form:checkbox path="jxfsComponentCB${i}" id="jxfsComponentCB${i}" disabled="true"/>
									</td>
									<td>
										<form:select path="jxfsComponentCombo${i}2" id="jxfsComponentCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="ChangeValue2CB2('jxfsComponent', ${i})">
											<form:option value="" label=""/>
										</form:select>
									</td>
									<td>
										<form:input class='form-tf-grey' path="jxfsComponentField${i}" id="jxfsComponentField${i}" disabled="true" maxlength="150"/>
										</td>
									<c:if test="${!status.last}">
										<td class="btn_add">
											<div id="jxfsComponentShowButton${i}" onclick="showHiddenRow('jxfsComponent', ${i})" class="btn add"><span><spring:message code="label.query.add"/></span></div>
										</td>
									</c:if>
									<c:if test="${status.last}">
										<td> </td>
									</c:if>
								</tr>
							</c:forEach>
						</table>
					</div><!-- /collapsible -->
				<h2 class="txt content_hide" id="swSection">
					<spring:message code="label.query.softwareGlobalSection"/>
				</h2>
					<div class="collapsible">
						<h3>
							<spring:message code="label.query.operatingSystemSection"/>
						</h3>
						<table class="query-form">
							<tr>
								<th>
									<spring:message code="label.query.field"/>
								</th>
								<th>
									<spring:message code="label.query.not"/>
								</th>
								<th>
									<spring:message code="label.query.comparison"/>
								</th>
								<th>
									<spring:message code="label.query.value"/>
								</th>
								<th></th>
							</tr>
							<c:forEach var="i" begin="1" end="5" varStatus="status">
								<tr id="operatingSystemRow${i}" <c:if test="${!status.first}">class="hidden"</c:if>>
									<td>
										<form:select path="operatingSystemCombo${i}1" id="operatingSystemCombo${i}1" class="query_selectors" size="1" onchange="ChangeValue2CB1('operatingSystem', ${i})">
											<form:option value="" label=""/>
											<c:forEach items="${values.get('operatingSystem').keySet()}" var="value">
												<form:option value="${value}">
													<spring:message code="label.operatingSystem.${value}"/>
												</form:option>
											</c:forEach>
										</form:select>
									</td>
									<td>
										<form:checkbox path="operatingSystemCB${i}" id="operatingSystemCB${i}" disabled="true"/>
									</td>
									<td>
										<form:select path="operatingSystemCombo${i}2" id="operatingSystemCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="ChangeValue2CB2('operatingSystem', ${i})">
											<form:option value="" label=""/>
										</form:select>
									</td>
									<td>
										<form:input class='form-tf-grey' path="operatingSystemField${i}" id="operatingSystemField${i}" disabled="true" maxlength="150"/>
										</td>
									<c:if test="${!status.last}">
										<td class="btn_add">
											<div id="operatingSystemShowButton${i}" onclick="showHiddenRow('operatingSystem', ${i})"  class="btn add"><span><spring:message code="label.query.add"/></span></div>
										</td>
									</c:if>
									<c:if test="${status.last}">
										<td> </td>
									</c:if>
								</tr>
							</c:forEach>
						</table>
						<h3>
							<spring:message code="label.query.internetExplorerSection"/>
						</h3>
						<table class="query-form">
							<tr>
								<th>
									<spring:message code="label.query.field"/>
								</th>
								<th>
									<spring:message code="label.query.not"/>
								</th>
								<th>
									<spring:message code="label.query.comparison"/>
								</th>
								<th>
									<spring:message code="label.query.value"/>
								</th>
								<th></th>
							</tr>
							<c:forEach var="i" begin="1" end="2" varStatus="status">
								<tr id="internetExplorerRow${i}" <c:if test="${!status.first}">class="hidden"</c:if>>
									<td>
										<form:select path="internetExplorerCombo${i}1" id="internetExplorerCombo${i}1" class="query_selectors" size="1" onchange="ChangeValue2CB1('internetExplorer', ${i})">
											<form:option value="" label=""/>
											<c:forEach items="${values.get('internetExplorer').keySet()}" var="value">
												<form:option value="${value}">
													<spring:message code="label.internetExplorer.${value}"/>
												</form:option>
											</c:forEach>
										</form:select>
									</td>
									<td>
										<form:checkbox path="internetExplorerCB${i}" id="internetExplorerCB${i}" disabled="true"/>
									</td>
									<td>
										<form:select path="internetExplorerCombo${i}2" id="internetExplorerCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="ChangeValue2CB2('internetExplorer', ${i})">
											<form:option value="" label=""/>
										</form:select>
									</td>
									<td>
										<form:input class='form-tf-grey' path="internetExplorerField${i}" id="internetExplorerField${i}" disabled="true" maxlength="150"/>
										</td>
									<c:if test="${!status.last}">
										<td class="btn_add">
											<div id="internetExplorerShowButton${i}" onclick="showHiddenRow('internetExplorer', ${i})" class="btn add"><span><spring:message code="label.query.add"/></span></div>
										</td>
									</c:if>
									<c:if test="${status.last}">
										<td> </td>
									</c:if>
								</tr>
							</c:forEach>
						</table>
						<h3>
							<spring:message code="label.query.hotfixSection"/>
						</h3>
			<table class="query-form">
				<tr>
					<th>

						<spring:message code="label.query.field"/>

					</th>
					<th>

						<spring:message code="label.query.not"/>

					</th>
					<th>

						<spring:message code="label.query.comparison"/>

					</th>
					<th>

						<spring:message code="label.query.value"/>

					</th>
					<th></th>
				</tr>
				<c:forEach var="i" begin="1" end="5" varStatus="status">
					<tr id="hotfixRow${i}" <c:if test="${!status.first}">class="hidden"</c:if>>
						<td>
							<form:select path="hotfixCombo${i}1" id="hotfixCombo${i}1" class="query_selectors" size="1" onchange="ChangeValue2CB1('hotfix', ${i})">
								<form:option value="" label=""/>
								<c:forEach items="${values.get('hotfix').keySet()}" var="value">
									<form:option value="${value}">
										<spring:message code="label.hotfix.${value}"/>
									</form:option>
								</c:forEach>
							</form:select>
						</td>
						<td>
							<form:checkbox path="hotfixCB${i}" id="hotfixCB${i}" disabled="true"/>
						</td>
						<td>
							<form:select path="hotfixCombo${i}2" id="hotfixCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="ChangeValue2CB2('hotfix', ${i})">
								<form:option value="" label=""/>
							</form:select>
						</td>
						<td>
							<form:input class='form-tf-grey' path="hotfixField${i}" id="hotfixField${i}" disabled="true" maxlength="150"/>
							</td>
						<c:if test="${!status.last}">
							<td class="btn_add">
								<div id="hotfixShowButton${i}" onclick="showHiddenRow('hotfix', ${i})" class="btn add"><span><spring:message code="label.query.add"/></span></div>
							</td>
						</c:if>
						<c:if test="${status.last}">
							<td> </td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
			<h3>
				<spring:message code="label.query.softwareSection"/>
			</h3>
			<table class="query-form">
				<tr>
					<th>

						<spring:message code="label.query.field"/>

					</th>
					<th>

						<spring:message code="label.query.not"/>

					</th>
					<th>

						<spring:message code="label.query.comparison"/>

					</th>
					<th>

						<spring:message code="label.query.value"/>

					</th>
					<th></th>
				</tr>
				<c:forEach var="i" begin="1" end="5" varStatus="status">
					<tr id="softwareRow${i}" <c:if test="${!status.first}">class="hidden"</c:if>
					>
					<td>
						<form:select path="softwareCombo${i}1" id="softwareCombo${i}1" class="query_selectors" size="1" onchange="ChangeValue2CB1('software', ${i})">
							<form:option value="" label=""/>
							<c:forEach items="${values.get('software').keySet()}" var="value">
								<form:option value="${value}">
									<spring:message code="label.software.${value}"/>
								</form:option>
							</c:forEach>
						</form:select>
					</td>
					<td>
						<form:checkbox path="softwareCB${i}" id="softwareCB${i}" disabled="true"/>
					</td>
					<td>
						<form:select path="softwareCombo${i}2" id="softwareCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="ChangeValue2CB2('software', ${i})">
							<form:option value="" label=""/>
						</form:select>
					</td>
					<td>
						<form:input class='form-tf-grey' path="softwareField${i}" id="softwareField${i}" disabled="true" maxlength="150"/>
						</td>
					<c:if test="${!status.last}">
						<td class="btn_add">
							<div id="softwareShowButton${i}" onclick="showHiddenRow('software', ${i})"  class="btn add"><span><spring:message code="label.query.add"/></span></div>
						</td>
					</c:if>
					<c:if test="${status.last}">
						<td> </td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
		<h3>
			<spring:message code="label.query.featSwSection"/>
		</h3>
		<table class="query-form">
			<tr>
				<th>
					<spring:message code="label.query.field"/>
				</th>
				<th>
					<spring:message code="label.query.not"/>
				</th>
				<th>
					<spring:message code="label.query.comparison"/>
				</th>
				<th>
					<spring:message code="label.query.value"/>
				</th>
				<th></th>
			</tr>
			<c:forEach var="i" begin="1" end="5" varStatus="status">
				<tr id="featSwRow${i}" <c:if test="${!status.first}">class="hidden"</c:if>
				>
				<td>
					<form:select path="featSwCombo${i}1" id="featSwCombo${i}1" class="query_selectors" size="1" onchange="ChangeValue2CB1('featSw', ${i})">
						<form:option value="" label=""/>
						<c:forEach items="${values.get('featSw').keySet()}" var="value">
							<form:option value="${value}">
								<spring:message code="label.featSw.${value}"/>
							</form:option>
						</c:forEach>
					</form:select>
				</td>
				<td>
					<form:checkbox path="featSwCB${i}" id="featSwCB${i}" disabled="true"/>
				</td>
				<td>
					<form:select path="featSwCombo${i}2" id="featSwCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="ChangeValue2CB2('featSw', ${i})">
						<form:option value="" label=""/>
					</form:select>
				</td>
				<td>
					<form:input class='form-tf-grey' path="featSwField${i}" id="featSwField${i}" disabled="true" maxlength="150"/>
					</td>
				<c:if test="${!status.last}">
					<td class="btn_add">
						<div id="featSwShowButton${i}" onclick="showHiddenRow('featSw', ${i})" class="btn add"><span><spring:message code="label.query.add"/></span></div>
					</td>
				</c:if>
				<c:if test="${status.last}">
					<td> </td>
				</c:if>
			</tr>
		</c:forEach>
		</table>
		<h3>
			<spring:message code="label.query.xfsSwSection"/>
		</h3>
		<table class="query-form">
		<tr>
			<th>

				<spring:message code="label.query.field"/>

			</th>
			<th>

				<spring:message code="label.query.not"/>

			</th>
			<th>

				<spring:message code="label.query.comparison"/>

			</th>
			<th>

				<spring:message code="label.query.value"/>

			</th>
			<th></th>
		</tr>
		<c:forEach var="i" begin="1" end="5" varStatus="status">
			<tr id="xfsSwRow${i}" <c:if test="${!status.first}">class="hidden"</c:if>
			>
			<td>
				<form:select path="xfsSwCombo${i}1" id="xfsSwCombo${i}1" class="query_selectors" size="1" onchange="ChangeValue2CB1('xfsSw', ${i})">
					<form:option value="" label=""/>
					<c:forEach items="${values.get('xfsSw').keySet()}" var="value">
						<form:option value="${value}">
							<spring:message code="label.xfsSw.${value}"/>
						</form:option>
					</c:forEach>
				</form:select>
			</td>
			<td>
				<form:checkbox path="xfsSwCB${i}" id="xfsSwCB${i}" disabled="true"/>
			</td>
			<td>
				<form:select path="xfsSwCombo${i}2" id="xfsSwCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="ChangeValue2CB2('xfsSw', ${i})">
					<form:option value="" label=""/>
				</form:select>
			</td>
			<td>
				<form:input class='form-tf-grey' path="xfsSwField${i}" id="xfsSwField${i}" disabled="true" maxlength="150"/>
				</td>
			<c:if test="${!status.last}">
				<td class="btn_add">
					<div id="xfsSwShowButton${i}" onclick="showHiddenRow('xfsSw', ${i})" class="add btn"><span><spring:message code="label.query.add"/></span></div>
				</td>
			</c:if>
			<c:if test="${status.last}">
				<td> </td>
			</c:if>
		</tr>
		</c:forEach>
		</table>
	</div>
	<div class="botonera">
		<div class="desplegable button">
			<div class="btn txt content_hide"><spring:message code="label.query.save"/></div>
			<div class="hide collapsible">
				<ul>
					<li><label for="namequery">Nombre</label> <form:input type="text" path="name"/></li>
					<li><label for="descriptionquery">Descripción</label> <form:textarea path="description"/></li>
				</ul>
				<div class="botonera"><input type="submit" id="save" name="save" class="save" value="<spring:message code="label.save"/>" /></div>
			</div>
		</div><!-- /desplegable -->

		<input type="submit" class="form-submit play" name="execute" id="execute" value="<spring:message code="label.query.execute"/>"/>
		<input type="reset" class="cancel right" value="<spring:message code="label.cancel"/>" />
	</div>

</form:form>


</div>
<script type="text/javascript">
	    $(document).ready(function(){
			<t:queryCbJs query="${query}"/>
			$('#queryName').val('');
			displayOnLoad('terminal', 5);
			displayOnLoad('hardwareDevice', 5);
			displayOnLoad('financialDevice', 5);
			displayOnLoad('xfsComponent', 5);
			displayOnLoad('jxfsComponent', 5);
			displayOnLoad('operatingSystem', 5);
			displayOnLoad('internetExplorer', 2);
			displayOnLoad('hotfix', 5);
			displayOnLoad('software', 5);
			displayOnLoad('featSw', 5);
			displayOnLoad('xfsSw', 5);
		});
	    var valuesTree = {
	        	<c:forEach items="${values.keySet()}" var="key" varStatus="status1">
	        		<c:set var="value" value="${values.get(key)}"/>
	       	 '${key}': {
					<c:forEach items="${value.keySet()}" var="subkey" varStatus="status2">
		        		<c:set var="subvalue" value="${value.get(subkey)}"/>
						'${subkey}':
							{
								label: <c:if test="${(key != 'allOperations') && (subkey != 'allHwDevices')}">'<spring:message code="label.${key}.${subkey}"/>'</c:if><c:if test="${(key == 'allOperations') || (subkey == 'allHwDevices')}">''</c:if>,
								values: {
									<c:forEach items="${subvalue.keySet()}" var="subsubkey" varStatus="status3">
					        		<c:set var="subsubvalue" value="${subvalue.get(subsubkey)}"/>
									'${subsubkey}':
										{
											<c:if test="${subsubvalue.getClass().getSimpleName() == 'TreeMap'}">
											label: <c:if test="${key != 'allOperations'}">'<spring:message code="label.${key}.${subsubkey}"/>'</c:if><c:if test="${key == 'allOperations'}">''</c:if>,
											values: {
												<c:forEach items="${subsubvalue.keySet()}" var="subsubsubkey" varStatus="status4">
								        		<c:set var="subsubsubvalue" value="${subsubvalue.get(subsubsubkey)}"/>
												'${subsubsubkey}':
												{
													label: '<spring:message code="label.query.operation.${subsubsubkey}"/>',
													values: ${subsubsubvalue}
												}${not status4.last ? ',' : ''}
												</c:forEach>
											}
											</c:if>
											<c:if test="${subsubvalue.getClass().getSimpleName() != 'TreeMap'}">
											label: '<spring:message code="label.query.operation.${subsubkey}"/>',
											values: ${subsubvalue}
											</c:if>
										}${not status3.last ? ',' : ''}
									</c:forEach>
								}
							}${not status2.last ? ',' : ''}
					</c:forEach>
	       	 			}${not status1.last ? ',' : ''}
	       		</c:forEach>
	    };
	    function displayOnLoad(name, maxValue) {
	    	for (i=maxValue; i>1; i--) {
	    		if ($('#' + name + 'Combo' + i + '1').val() != '') {
	    			for (j=1; j<i; j++) {
		    			showHiddenRow(name, j);
	    			}
	    			break;
	    		}
	    	}
	    };
	    function ChangeValue2CB1(entity, number){
			var $cb = $('#' + entity + 'Combo' + number + '2');
			$cb.empty();
			$cb.append($('<option selected="selected"></option>'));
			if ($('#' + entity + 'Combo' + number + '1').val() != '') {
				var values = valuesTree[entity][$('#' + entity + 'Combo' + number + '1').val()].values;
				var keys = $.map(values, function(v, i){
					  return i;
					});
				keys.sort(function(a,b){
				    var compA = values[a].label;
				    var compB = values[b].label;
				    return (compA < compB) ? -1 : (compA > compB) ? 1 : 0;
				  });
				$.each(keys, function(index, key) {
					  $cb.append($('<option/>')
					     .attr("value", key).text(values[key].label));
				});
			    $('#' + entity + 'CB' + number).prop('disabled', false);
				$cb.prop('disabled', false);
			} else {
			    $('#' + entity + 'CB' + number).prop('disabled', true);
				$cb.prop('disabled', true);
			};
		    $('#' + entity + 'Field' + number).prop('disabled', true);
	    };
	    function ChangeValue2CB2(entity, number){
			if ($('#' + entity + 'Combo' + number + '2').val() != '') {
				if (valuesTree[entity][$('#' + entity + 'Combo' + number + '1').val()].values[$('#' + entity + 'Combo' + number + '2').val()].values) {
				    $('#' + entity + 'Field' + number).prop('disabled', false);
				} else {
					$('#' + entity + 'Field' + number).prop('disabled', true);
				}
			} else {
			    $('#' + entity + 'Field' + number).prop('disabled', true);
			};
	    };
	    function ChangeValue3CB1(entity, number){
			var $cb = $('#' + entity + 'Combo' + number + '2');
			$cb.empty();
			$cb.append($('<option selected="selected"></option>'));
			if ($('#' + entity + 'Combo' + number + '1').val() != '') {
				var values = valuesTree[entity][$('#' + entity + 'Combo' + number + '1').val()].values;
				var keys = $.map(values, function(v, i){
					  return i;
					});
				keys.sort(function(a,b){
				    var compA = values[a].label;
				    var compB = values[b].label;
				    return (compA < compB) ? -1 : (compA > compB) ? 1 : 0;
				  });
				$.each(keys, function(index, key) {
					  $cb.append($('<option/>')
					     .attr("value", key).text(values[key].label));
				});
			    $('#' + entity + 'CB' + number).prop('disabled', false);
				$cb.prop('disabled', false);
			} else {
				$cb.prop('disabled', true);
			};
			$('#' + entity + 'Combo' + number + '3').prop('disabled', true);
		    $('#' + entity + 'CB' + number).prop('disabled', true);
		    $('#' + entity + 'Field' + number).prop('disabled', true);
	    };
	    function ChangeValue3CB2(entity, number){
			var $cb = $('#' + entity + 'Combo' + number + '3');
			$cb.empty();
			$cb.append($('<option selected="selected"></option>'));
			if ($('#' + entity + 'Combo' + number + '2').val() != '') {
				var values = valuesTree[entity][$('#' + entity + 'Combo' + number + '1').val()].values[$('#' + entity + 'Combo' + number + '2').val()].values
				var keys = $.map(values, function(v, i){
					  return i;
					});
				keys.sort(function(a,b){
				    var compA = values[a].label;
				    var compB = values[b].label;
				    return (compA < compB) ? -1 : (compA > compB) ? 1 : 0;
				  });
				$.each(keys, function(index, key) {
					  $cb.append($('<option/>')
					     .attr("value", key).text(values[key].label));
				});
			    $('#' + entity + 'CB' + number).prop('disabled', false);
				$cb.prop('disabled', false);
			} else {
			    $('#' + entity + 'CB' + number).prop('disabled', true);
				$cb.prop('disabled', true);
			};
		    $('#' + entity + 'Field' + number).prop('disabled', true);
	    };
	    function ChangeValue3CB3(entity, number){
			if ($('#' + entity + 'Combo' + number + '3').val() != '') {
				if (valuesTree[entity][$('#' + entity + 'Combo' + number + '1').val()].values[$('#' + entity + 'Combo' + number + '2').val()].values[$('#' + entity + 'Combo' + number + '3').val()].values) {
				    $('#' + entity + 'Field' + number).prop('disabled', false);
				} else {
					$('#' + entity + 'Field' + number).prop('disabled', true);
				}
			} else {
			    $('#' + entity + 'Field' + number).prop('disabled', true);
			};
	    };
	    function checkSaveExecute() {
	    	if ($('#queryName').val().length > 0) {
	    		if ($("#save_execute").button("option", "disabled")) {
	    			$("#save_execute").button("option", "disabled", false);
	    		}
	    	} else {
	    		if (!$("#save_execute").button("option", "disabled")) {
	    			$("#save_execute").button("option", "disabled", true);
	    		}
	    	}
	    }
	    function showHiddenRow(name, rowNumber) {
	    	$('#' + name + 'Row' + (rowNumber + 1)).removeClass('hidden');
	    	$('#' + name + 'ShowButton' + rowNumber).addClass('hidden');
	    }
	    function userQuerySelected()
	    {
	    	document.userQueriesForm.submit();
	    }
    </script>
					</div><!-- /collapsible -->

</div>

</t:osoco-wrapper>
