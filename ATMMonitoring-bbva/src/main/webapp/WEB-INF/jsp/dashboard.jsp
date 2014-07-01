<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>


<t:osoco-wrapper titleCode="label.terminalsManager" userMsg="${userMsg}" section="dashboard">

  <jsp:attribute name="header">
    <script type='text/javascript' src='https://www.google.com/jsapi'></script>
    <script type="text/javascript" src="resources/js/json2html.js"></script>
    <script type="text/javascript" src="resources/js/jquery.json2html.js"></script>
    <script type="text/javascript">
      var strings = new Array();
      strings['label.widget.options'] = "<spring:message code='label.widget.options' javaScriptEscape='true' />";
      strings['label.widget.edit'] = "<spring:message code='label.widget.edit' javaScriptEscape='true' />";
      strings['label.widget.delete'] = "<spring:message code='label.widget.delete' javaScriptEscape='true' />";
      strings['label.widget.cancel'] = "<spring:message code='label.widget.cancel' javaScriptEscape='true' />";
      strings['widget.delete.confirm'] = "<spring:message code='widget.delete.confirm' javaScriptEscape='true' />";
      strings['widget.add.to.library'] = "<spring:message code='widget.add.to.library' javaScriptEscape='true' />";
      strings['widget.remove.from.library.confirm'] = "<spring:message code='widget.remove.from.library.confirm' javaScriptEscape='true' />";
      strings['widget.set.as.default'] = "<spring:message code='widget.set.as.default' javaScriptEscape='true' />";
      strings['widget.set.as.default.confirm'] = "<spring:message code='widget.set.as.default.confirm' javaScriptEscape='true' />";
      strings['widget.unset.as.default.confirm'] = "<spring:message code='widget.unset.as.default.confirm' javaScriptEscape='true' />";
      
      var hasPrivileges = false;
      <sec:authorize access="hasAnyRole(${editWidgetsLibraryAllowedRoles})">
          hasPrivileges = true;
      </sec:authorize>
    </script>
    <script type='text/javascript' src='resources/js/dashboard.js'></script>
  </jsp:attribute>

  <jsp:body>
          <div id="header_g">
            <div id="components">
              <div id="my_components" class="desplegable autofold">
                <div class="txt content_hide">
                  <span><spring:message code="label.widgets.mine"/></span>
                </div>
                <ul id="myCharts" class="collapsible"></ul>
              </div>
              <a class="iframe_medium cboxElement btn add" href="dashboard/newWidget">
                <spring:message code="label.widget.new"/>
              </a>

            </div>
            <div id="columns" class="columns_botonera">
              <nav>
                <ul>
                  <c:forEach items="${columnOptions}" var="option">
                    <li class="column${option.getColumns()} ${((option.getColumns() == dashboard.getColumns()) ? 'current' : '')}" data-columns="${option.getColumns()}">
                      <a href="#">
                        <span>${option.getColumns()} <g:message code="label.columns"/></span>
                      </a>
                    </li>
                  </c:forEach>
                </ul>
              </nav>
            </div>
          </div>
          <ul id="sortable" class="ui-sortable column${dashboard.getColumns()}"></ul>
          <div id="noCharts" class="message left hide">
            <p><spring:message code="label.dashboard.explain"/></p>
          </div>
  </jsp:body>

</t:osoco-wrapper>
