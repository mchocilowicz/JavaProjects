<%@ include file="header.jsp" %>
<spring:message code="profile"/>
<%@ include file="nav.jsp" %>

<div class="panel panel-primary">
	
	<div class="panel-heading">
		<h3 class="panel-title"><spring:message code="profile"/></h3>
	</div>
	
	<div class="panel-body">
		<dl class="dl-horizontal">
			<dt><spring:message code="label.login"/></dt>
			<dd><c:out value="${user.login}"/></dd>
			<dt><spring:message code="label.firstname"/></dt>
			<dd><c:out value="${user.firstname}"/></dd>
			<dt><spring:message code="label.lastname"/></dt>
			<dd><c:out value="${user.lastname}"/></dd>
			<dt><spring:message code="label.street"/></dt>
			<c:if test="${empty user.apartment }">
			<dd><c:out value="${user.street} ${user.number} "/></dd>
			</c:if>
			<c:if test="${!empty user.apartment }">
			<dd><c:out value="${user.street} ${user.number} / ${user.apartment}"/></dd>
			</c:if>
			<dt><spring:message code="label.zip-code"/></dt>
			<dd><c:out value="${user.zipCode}"/></dd>
			
			<dt><spring:message code="label.city"/></dt>
			<dd><c:out value="${user.city}"/></dd>
			
		</dl>
	</div>
	
	<div class="panel-footer">
		<a class="btn btn-link" href="users.html?userId=${user.id}"><spring:message code="label.editUser"/></a>
	</div>
</div>



<%@ include file="footer.jsp" %>