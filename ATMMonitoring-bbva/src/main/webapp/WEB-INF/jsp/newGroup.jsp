<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.queryEngine" userMsg="${userMsg}"  section="users">
	<script type="text/javascript">
	$(function() {
		$('.next').click(function() {
			$(this).closest(".content").hide();
			$('#aplicada').show();
		});
	});
</script>
	<div id="header_g">
		<nav id="breadcrumb">
			<ul>
				<li>
					<a href="dashboard"><spring:message code="breadcrumb.home"/></a>
				</li>
				<li>
					<a href="users"><spring:message code="label.users"/></a>
				</li>
				<li><spring:message code="breadcrumb.group.new"/></li>
			</ul>
		</nav>
	</div>
	<div class="main">
		<div id="primary">
			<h1><spring:message code="breadcrumb.group.new"/></h1>
			<div class="content">
				<div class="form w33">
					<div class="row">
						<label for="name"><spring:message code="label.group.name"/></label>
						<input id="name" type="text"></div>
					<div class="row">
						<label for="ldapQuery"><spring:message code="label.query.ldap"/></label>
						<textarea id="ldapQuery" ></textarea>
					</div>
					<div class="botonera">
						<input type="button" class="btn next" id="" value="<spring:message code="label.apply"/>">
						<a href="users" class="btn cancel"><spring:message code="label.cancel"/></a>
					</div>
				</div>
			</div>
<div id="aplicada" class="content hide">
				<div class="form w33">
					<div class="row">
						<label for="name"><spring:message code="label.group.name"/></label>
						<input id="name" type="text"></div>
					<div class="row">
						<label for="ldapQuery"><spring:message code="label.query.ldap"/></label>
						<textarea id="ldapQuery" ></textarea>
					</div>
					<ul class="users_list">
						<li>Abraham Swaim</li>
						<li>Vivan Haller</li>
						<li>Blythe Lauritzen</li>
						<li>Paula Holifield</li>
						<li>Stuart Ayon</li>
						<li>Suk Hazen</li>
						<li>Donette Stollings</li>
						<li>Lavern Nord</li>
						<li>Nydia Obrien</li>
						<li>Cleta Schutz</li>
						<li>Perry Brandon</li>
						<li>Freeman Burney</li>
						<li>Julia Spiller</li>
						<li>Rena Mellon</li>
						<li>Karon Lederman</li>
						<li>Carly Laguna</li>
						<li>Eleanor Hawthorn</li>
						<li>Evan Canterbury</li>
						<li>Ardith Shewmaker</li>
						<li>Chantal Carini</li>
						<li>Abraham Swaim</li>
						<li>Vivan Haller</li>
						<li>Blythe Lauritzen</li>
						<li>Paula Holifield</li>
						<li>Stuart Ayon</li>
						<li>Suk Hazen</li>
						<li>Donette Stollings</li>
						<li>Lavern Nord</li>
						<li>Nydia Obrien</li>
						<li>Cleta Schutz</li>
						<li>Perry Brandon</li>
						<li>Freeman Burney</li>
						<li>Julia Spiller</li>
						<li>Rena Mellon</li>
						<li>Karon Lederman</li>
						<li>Carly Laguna</li>
						<li>Eleanor Hawthorn</li>
						<li>Evan Canterbury</li>
						<li>Ardith Shewmaker</li>
						<li>Chantal Carini</li>
						<li>Abraham Swaim</li>
						<li>Vivan Haller</li>
						<li>Blythe Lauritzen</li>
						<li>Paula Holifield</li>
						<li>Stuart Ayon</li>
						<li>Suk Hazen</li>
						<li>Donette Stollings</li>
						<li>Lavern Nord</li>
						<li>Nydia Obrien</li>
						<li>Cleta Schutz</li>
						<li>Perry Brandon</li>
						<li>Freeman Burney</li>
						<li>Julia Spiller</li>
						<li>Rena Mellon</li>
						<li>Karon Lederman</li>
						<li>Carly Laguna</li>
						<li>Eleanor Hawthorn</li>
						<li>Evan Canterbury</li>
						<li>Ardith Shewmaker</li>
						<li>Chantal Carini</li>
					</ul>
					<div class="botonera">
						<input type="button" class="btn" value="<spring:message code="label.group.save"/>">
						<a href="users" class="btn cancel"><spring:message code="label.cancel"/></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	</t:osoco-wrapper>