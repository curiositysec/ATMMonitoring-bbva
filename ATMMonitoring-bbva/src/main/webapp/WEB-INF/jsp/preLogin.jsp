<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<html>
    <head>
        <script type="text/javascript">
	        (function() {
	            redirectToLoginPage() 
	            
	            function redirectToLoginPage() {
	                var targetWindow = window.parent || window
	                targetWindow.location.assign("index")        
	            }
	        })()
	    </script>
	</head>
    
    <body>
    </body>
    
</html>
    
