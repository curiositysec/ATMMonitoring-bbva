<%@tag description="Print a list for can be readable by @RequestParam(...) ArrayList" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@attribute name="list" required="true" type="java.util.List"%>

<%
	String elements = "'";
	elements += list.remove(0);
	for(Object o : list) {
		elements += "," + o;
	}
	elements += "'";
	out.print(elements);
%>
