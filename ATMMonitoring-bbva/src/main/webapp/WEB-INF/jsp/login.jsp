<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapperWoMenu titleCode="label.login" section="login_user">

<jsp:attribute name="header">
    <script type="text/javascript">
      $(function() {
        window.setTimeout(function(){
          $("#login_box").addClass("flipped");
        }, 1000);
        $("#username").focus();
      });
    </script>
</jsp:attribute>

<jsp:body>
    <div id="scene">
      <div id="login_box" >
        <h1><img src="resources/images/general/logo.png"/>
            <div id="headName"><span><acronym title="Hardware and Software Asset Management">HSAM</acronym></span></div>
        </h1>
        <c:if test="${error == true}">
        <div class="error bottom">
            ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
        </div>
        </c:if>

	    <form name='f' action="<c:url value='j_spring_security_check' />" method='POST'>
            <div class="row">
                <label for="username"><spring:message code="label.username"/>: </label>
                <input id="username" type="text" name="j_username"/>
            </div>
            <div class="row">
                <label for="password"><spring:message code="label.password"/>: </label>
                <input type="password" type="password" name="j_password"/>
            </div>
            <div class="botonera">
                <input name="submit" type="submit" class="btn" value="acceder"/>
                <input name="reset" type="reset" value="cancelar" class="btn cancel"/>
            </div>
        </form>
      </div>
    </div>
</jsp:body>

</t:osoco-wrapperWoMenu>
