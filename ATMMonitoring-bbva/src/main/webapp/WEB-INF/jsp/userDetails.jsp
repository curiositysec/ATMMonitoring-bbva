<%@taglib uri="http://www.ncr.com/tags" prefix="ncr"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.usersManager" userMsg="${userMsg}" section="users">

<jsp:attribute name="header">
    <script type="text/javascript">
        $(function() {
            $("#editUserButton").click(function(event) {
                $("#showUser").hide();
                $("#editForm").show();
	        });
            $("#cancelEdit").click(function(event) {
                $("#showUser").show();
                $("#editForm").hide();
	        });
	    });
    </script>
</jsp:attribute>

<jsp:body>
			<div id="header_g">
					<nav id="breadcrumb">
						<ul>
							<li>
								<a href="dashboard"><spring:message code="breadcrumb.home"/></a>
							</li>
							<li>
								<a href="users"><spring:message code="breadcrumb.users"/></a>
							</li>
							<li><spring:message code="label.user"/> ${user.username}</li>
						</ul>
					</nav>
				</div>
			<div class="content">
				<h1><spring:message code="label.user.username"/> ${user.username}</h1>

				<div class="action_box data desplegable">
					<h2 class="txt last"><spring:message code="label.userDetails"/></h2>
					<div class="collapsible last">
							<c:if test="${(canEdit == true) && ((user.role == null) || (user.role.manageable))}">
						      <div id="editForm" class="${errors != null ? '': 'hide'}">
								<form:form method="post" action="users/update" commandName="user">
									<form:hidden path="id"/>
									<div class="ul_data ul_data_wide editable">
										<ul>
											<li> <strong><form:label path="username">
														<spring:message code="label.user.username"/>
													</form:label></strong>

												<form:input class='form-tf-grey' readonly='true' path="username" maxlength="50"/>
											</li>
											<li> <strong><form:label path="firstname">
														<spring:message code="label.user.firstname"/>
													</form:label></strong>

												<form:input class='form-tf-grey' readonly='true' path="firstname" maxlength="50"/>
											</li>
											<li> <strong><form:label path="lastname">
														<spring:message code="label.user.lastname"/>
													</form:label></strong>

												<form:input class='form-tf-grey' readonly='true' path="lastname" maxlength="50"/>
											</li>
											<li> <strong><form:label path="bankCompany.name">
														<spring:message code="label.user.bankCompany"/>
													</form:label></strong>

												<form:select class='form-tf-grey' path="bankCompany">
													<form:option label="${user.bankCompany.name}" value="${user.bankCompany.id}"/>
												</form:select>
											</li>
											<li> <strong><form:label path="role.name">
														<spring:message code="label.user.role"/>
													</form:label></strong>
		
													<form:select class='form-tf-grey' path="role">
														<form:option label="" value=""/>
														<form:options items="${manageableRolesList}" itemValue="id" itemLabel="name"/>
													</form:select>
											</li>
										</ul>
									<div class="botonera">

										<input type="submit" class="btn" value="<spring:message code="label.user.updateUser"/>"/>
	                                    <input id="cancelEdit" type="reset" class="cancel right" value="<spring:message code="label.cancel"/>" />
									</div>

									</div>
								</form:form>
						            </div>
							</c:if>

								<div id="showUser"  class="ul_data ul_data_wide ${errors  != null ? 'hide': ''}">
									<ul>
										<li>
											<strong>
												<spring:message code="label.user.username"/>
											</strong>
											${user.username}
										</li>
										<li>
											<strong>
												<spring:message code="label.user.firstname"/>
											</strong>
											${user.firstname}
										</li>
										<li>
											<strong>
												<spring:message code="label.user.lastname"/>
											</strong>
											${user.lastname}
										</li>
										<li>
											<strong>
												<spring:message code="label.user.bankCompany"/>
											</strong>
											${user.bankCompany.name}
										</li>
										<li>
											<strong>
												<spring:message code="label.user.role"/>
											</strong>
											${user.role.name}
										</li>
									</ul>

								<c:if test="${(canEdit == true) && ((user.role == null) || (user.role.manageable))}">
									<div class="botonera">
										<button id="editUserButton" class="btn">Editar Usuario</button>
									</div>
								</c:if>

								</div>
								<!-- //ul-data -->

					</div>
					<!-- // collapsible -->
				</div>
			</div>

</jsp:body>

</t:osoco-wrapper>
