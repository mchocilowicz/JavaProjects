<%@ include file="header.jsp" %>
	Access Denied
<%@ include file="nav.jsp" %>


	
<h1><spring:message code="access.denied"/></h1>

<c:url value="/j_spring_security_logout" var="logoutUrl" />
 
	<!-- csrt for log out-->
	<form action="${logoutUrl}" method="post" id="logoutForm">
	  <input type="hidden" 
		name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

<a href="javascript:formSubmit()"> Logout</a>

<%@ include file="footer.jsp" %>


	