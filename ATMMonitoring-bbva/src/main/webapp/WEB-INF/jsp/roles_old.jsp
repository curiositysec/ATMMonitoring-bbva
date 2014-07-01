<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.queryEngine" userMsg="${userMsg}"  section="users">
	<div  class="documentation">
		<div id="header_g">
			<nav id="breadcrumb">
				<ul>
					<li>
						<a href="dashboard"><spring:message code="breadcrumb.home"/></a>
					</li>
					<li><spring:message code="breadcrumb.users"/></li>
				</ul>
			</nav>
		</div>
		<div class="menu">
			<nav>
			<h1>
				<spring:message code="label.usersManager"/>
			</h1>
				<h2><spring:message code="label.user.groups"/></h2>
				<ul class="user_groups">
					<li><a href="#" class="current"><spring:message code="label.group"/> 1</a></li>
					<li><a href="#"><spring:message code="label.group"/> 2</a></li>
					<li><a href="#"><spring:message code="label.group"/> 3</a></li>
					<li><a href="#"><spring:message code="label.group"/> 4</a></li>
					<li><a href="#"><spring:message code="label.group"/> 5</a></li>
					<li><a href="#"><spring:message code="label.group"/> 6</a></li>
				</ul>
			</nav>

			<div class="botonera">
					<a href="users/newGroup" class="btn add left"><spring:message code="label.group.new.create"/></a>
			</div>
		</div>
			<div class="scroll">
				<h2><spring:message code="label.features"/></h2>
				<ul class="features">
					<li><h3><spring:message code="label.terminals"/></h3>
						<ul>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
						</ul>
					</li>
					<li><h3><spring:message code="label.queries"/></h3>
						<ul>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
						</ul>
					</li>
					<li><h3><spring:message code="label.reports"/></h3>
						<ul>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>
</t:osoco-wrapper>