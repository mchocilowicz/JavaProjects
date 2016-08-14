<%@ include file="header.jsp" %>
	<spring:message code="shop"/>
<%@ include file="nav.jsp" %>

	

	<h2><spring:message code="shop.products"/></h2>
	<div>
		
		<c:if test="${!empty productList }">
			<c:forEach items="${productList }" var="product">
				<div class="row">
					<div class="col-lg-4">
						<div class="thumbnail">
						<center><h3>${product.name }</h3></center>
							<c:if test="${not empty product.photo}">
								<img src="product/image/${product.id}" class="img-rounded" height="250px" width="250px"/>
						    </c:if>
						    
						    <div class="caption">
						    	
						    	<p>${product.description}</p>
								<p>${product.price} zl</p>
								
								
								
								<a href="cartAdd/${product.id}" class="btn btn-default"><spring:message code="addToCart"/></a>
								<sec:authorize access="hasRole('ROLE_ADMIN')">
									<a href="deleteProduct/${product.id}.html"><spring:message code="product.delete"/></a>
									<a href="shop.html?productId=${product.id}"><spring:message code="product.edit"/></a>
								</sec:authorize>
								
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</c:if>
	
	
	</div>
		
	
	<div class="footer">
<sec:authorize access="hasRole('ROLE_ADMIN')">
		
		<form:form method="post" action="addProduct.html?${_csrf.parameterName}=${_csrf.token}" commandName="product" enctype="multipart/form-data">
    
    
        <form:hidden path="id"/>
    
    
        
   
    <div class="form-group">
    
        <form:label class="input-group-addon" id="basic-addon3" path="name"><spring:message code="product.name"/></form:label>
        <form:input class="form-control" path="name" aria-describedby="basic-addon3" />
        <form:errors path="name"/>
    
    </div>
    
    <div class="form-group">
    
        <form:label class="input-group-addon" id="basic-addon3" path="description"><spring:message code="product.description"/></form:label>
        <form:textarea class="form-control" path="description" aria-describedby="basic-addon3" />
        <form:errors path="description"/>
    
    </div>
    
    <div class="form-group">
   
	   <form:label class="input-group-addon" id="basic-addon3" path="price"><spring:message code="product.price"/></form:label>
	   <form:input  class="form-control" path="price" aria-describedby="basic-addon3" />
	   <form:errors path="price"/>
   
    </div>
    
    
    <div class="form-group">
    	<form:label  path="photo"><spring:message code="product.photo"/> </form:label>
    	<input id="photo" name="photo" type="file"/>
    </div>
    
    
    
    
        <c:if test="${product.id==0}">
            <input type="submit" class="btn btn-default" value="<spring:message code="product.add"/>"/>
        </c:if>
        <c:if test="${product.id!=0}">
            <input type="submit" class="btn btn-default" value="<spring:message code="product.edit"/>"/>
        </c:if>
     
</form:form>
		
		
		
</sec:authorize>
	</div>


	

<%@ include file="footer.jsp" %>