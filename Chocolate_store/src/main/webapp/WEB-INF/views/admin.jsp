<%@ include file="header.jsp" %>
	<spring:message code="admin"/>
<%@ include file="nav.jsp" %>


	
	
 
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
 
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} <br> 
				
				<ul class="nav nav-tabs nav-justified">
				<li>	<a href="javascript:formSubmit()"> Logout</a>	</li>
				<li>	<a href="userRole.html"><spring:message code="label.role"/></a>	</li>
				<li>	<a href="userList"><spring:message code="label.userList"/></a>
				<li>	<a href="purchasedItems"><spring:message code="label.purchasedItems"/></a>
				</ul>
				
				
				 
		</h2>
	</c:if>
	
	

 <%@ include file="footer.jsp" %>