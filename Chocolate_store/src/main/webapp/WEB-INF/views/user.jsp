<%@ include file="header.jsp" %>
User
<%@ include file="nav.jsp" %>


<c:if test="${not empty flash}">
			<div class="alert alert-success alert-dismissable">
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
				<spring:message code="register.success"/>
			</div>
</c:if>
	
<div class="panel panel-primary">	
	<div class="panel-heading">
	<c:if test="${user.id==0}">
           <h2 class="panel-title"><spring:message code="label.user"/></h2>
        </c:if>
        <c:if test="${user.id!=0}">
           <h2 class="panel-title"> <spring:message code="label.editUser"/></h2>
        </c:if>
	</div>


<form:form method="post" action="addUser.html" commandName="user" >
<div class="panel-body">
    <table class="dl-horizontal">
    <tr>
        <td><form:hidden path="id"/></td>
    </tr>
    <tr class="form-group">
        <td><form:label path="login"><spring:message code="label.login"/></form:label></td>
        <td><form:input class="form-control" path="login" /></td>
        <td><form:errors path="login"/></td>
    </tr>
    <tr class="form-group">
        <td><form:label path="password"><spring:message code="label.password"/></form:label></td>
        <td><form:input class="form-control" path="password" /></td>
        <td><form:errors path="password"/></td>
    </tr>
    <tr class="form-group">
        <td><form:label path="firstname"><spring:message code="label.firstname"/></form:label></td>
        <td><form:input class="form-control" path="firstname" /></td>
        <td><form:errors path="firstname"/></td>
    </tr>
    <tr class="form-group">
        <td><form:label path="lastname"><spring:message code="label.lastname"/></form:label></td>
        <td><form:input class="form-control" path="lastname" /></td>
        <td><form:errors path="lastname"/></td>
    </tr>
	<tr class="form-group"> 
        <td><form:label path="email"><spring:message code="label.email"/></form:label></td>
        <td><form:input class="form-control" path="email" /></td>
        <td><form:errors path="email"/></td>
    </tr>
    <tr class="form-group">
        <td><form:label path="telephone"><spring:message code="label.telephone"/></form:label></td>
        <td><form:input class="form-control" path="telephone" /></td>
        <td><form:errors path="telephone"/></td>
    </tr>
    
	<tr class="hidden">
        <td><form:label path="enabled"><spring:message code="label.enabled"/></form:label></td>
        <td><form:checkbox path="enabled" /></td>
        <td><form:errors path="enabled"/></td>
    </tr>
    
    <tr class="form-group">
        <td><form:label path="street"><spring:message code="label.street"/></form:label></td>
        <td><form:input class="form-control" path="street" /></td>
        <td><form:errors path="street"/></td>
    </tr>
    <tr class="form-group">
        <td><form:label path="number"><spring:message code="label.number"/></form:label></td>
        <td><form:input class="form-control" path="number" /></td>
        <td><form:errors path="number"/></td>
    </tr>
    <tr class="form-group">
        <td><form:label path="apartment"><spring:message code="label.apartment"/></form:label></td>
        <td><form:input class="form-control" path="apartment" /></td>
        <td><form:errors path="apartment"/></td>
    </tr>
    <tr class="form-group">
        <td><form:label path="zipCode"><spring:message code="label.zip-code"/></form:label></td>
        <td><form:input class="form-control" path="zipCode" /></td>
        <td><form:errors path="zipCode"/></td>
    </tr>
    <tr class="form-group">
        <td><form:label path="city"><spring:message code="label.city"/></form:label></td>
        <td><form:input class="form-control" path="city" /></td>
        <td><form:errors path="city"/></td>
    </tr>
    <tr class="form-group">
        <td><form:label path="country"><spring:message code="label.country"/></form:label></td>
        <td><form:input class="form-control" path="country" /></td>
        <td><form:errors path="country"/></td>
    </tr>
    
    
    
    
    <tr>
        <td colspan="2">
        <c:if test="${user.id==0}">
            <input type="submit" class="btn btn-default" value="<spring:message code="label.addUser"/>"/>
        </c:if>
        <c:if test="${user.id!=0}">
            <input type="submit" class="btn btn-default" value="<spring:message code="label.editUser"/>"/>
        </c:if>
        </td>
    </tr>
</table> 
</div>
</form:form>
</div>

<%@ include file="footer.jsp" %>