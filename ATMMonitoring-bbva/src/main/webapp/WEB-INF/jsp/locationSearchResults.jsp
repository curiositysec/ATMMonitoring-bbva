<%@page contentType="application/json" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
   response.setContentType("application/json");
   response.setHeader("Connection", "keep-alive");
%>
${locations}