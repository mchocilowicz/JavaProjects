<%@ include file="header.jsp" %>
<spring:message code="recipe"/>
<%@ include file="nav.jsp" %>

	
	
	<div>
		
		<c:if test="${!empty recipeList }">
			<c:forEach items="${recipeList }" var="recipe">
				<div>
					
					<p><spring:message code="recipe.username"/>: ${recipe.username} <spring:message code="recipe.date"/>: ${recipe.date}</p>
					<center><h2><b>${recipe.name }</b></h2></center>
					
					<c:if test="${not empty recipe.image}">
						<img src="recipe/image/${recipe.id}" alt="${recipe.name}+.jpg" class="img-circle"/>
					</c:if>
					
					<center><h2><b><spring:message code="recipe.components"/></b></h2> <p>${recipe.components}</p></center>
					<center><h2><b><spring:message code="recipe.description"/></b></h2> <p>${recipe.description}</p></center>
					
					
					
					
					
					<sec:authorize access="hasRole('ROLE_ADMIN')">
					<a href="deleteRecipe/${recipe.id}.html"><span class="glyphicon glyphicon-remove"></span></a>
					<a href="recipe.html?recipeId=${recipe.id}"><span class="glyphicon glyphicon-edit"></span></a>
					</sec:authorize>
				</div>
				<hr>
			</c:forEach>
		</c:if>
	
	
	</div>
	
	
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		
		<form:form method="post" action="addRecipe.html?${_csrf.parameterName}=${_csrf.token}" commandName="recipe" enctype="multipart/form-data">
    
        	<form:hidden path="id"/>
            <form:input type="hidden" path="username" disabled="disabled" readonly="readonly" value="${ pageContext.request.userPrincipal.name}"/>
        
    
   
   
    	<div class="form-group">
   
        <form:label path="name" class="input-group-addon" id="basic-addon3"><spring:message code="recipe.name"/></form:label>
        <form:input path="name" class="form-control"  aria-describedby="basic-addon3"/>
        <form:errors path="name"/>
   		</div>
    
    	<div class="form-group">
        <form:label path="components" class="input-group-addon" id="basic-addon3"><spring:message code="recipe.components"/></form:label>
        <form:textarea path="components" class="form-control"  aria-describedby="basic-addon3"/>
        <form:errors path="components"/>
    	</div>
    
    	<div class="form-group">
        <form:label path="description" class="input-group-addon" id="basic-addon3"><spring:message code="recipe.description"/></form:label>
        <form:textarea path="description" class="form-control"  aria-describedby="basic-addon3"/>
        <form:errors path="description"/>
   		</div>
    
    	<div class="form-group">
    	<form:label path="image" class="" id="basic-addon3"><spring:message code="recipe.photo"/> </form:label>
    	<input id="image" name="image" type="file"  id="basic-url" aria-describedby="basic-addon3"/>
    	</div>
   
    
    
        
        <c:if test="${recipe.id==0}">
            <input type="submit" class="btn btn-default" value="<spring:message code="recipe.add"/>"/>
        </c:if>
        <c:if test="${recipe.id!=0}">
            <input type="submit" class="btn btn-default" value="<spring:message code="recipe.edit"/>"/>
        </c:if>
        
    
</form:form>
		
		
		
	</sec:authorize>
	
	
	
<%@ include file="footer.jsp" %>
	