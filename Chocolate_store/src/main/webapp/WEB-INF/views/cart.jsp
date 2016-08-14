<%@ include file="header.jsp" %>
	<spring:message code="shoppingCart"/>
<%@ include file="nav.jsp" %>


<c:if test="${not empty yCart}">
			<div class="alert alert-success alert-dismissable">
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
				<spring:message code="placeOrder.complete"/>
			</div>
</c:if>
	

<div class="container">


	
		<div class="panel panel-default">
			<div class="panel-heading"><h2><spring:message code="shoppingCart"/></h2></div>
			
			<table class="table">
		<tr>
			<th><spring:message code="item"/></th>
			<th><spring:message code="quantity"/></th>
			<th><spring:message code="price"/></th>
			
		</tr>
		
		<c:forEach var="item" items="${cart}">
			<tr>
				<td>
					<a href="cart/delete/${item.id}"><span class="glyphicon glyphicon-remove"></span></a>
					<c:out value="${item.name}"/>
				</td>
				<td>
					<c:out value="${item.quantity}"/>
					<a href="cart/lowerAmount/${item.id}"><span class="glyphicon glyphicon-minus"></span></a>
					<a href="cart/riseAmount/${item.id}"><span class="glyphicon glyphicon-plus"></span></a>
				</td>
				<td><c:out value="${item.price * item.quantity}"/> zl</td>
				
			</tr>
		</c:forEach>
		<tr></tr>
		<tr>
			<td><spring:message code="total"/></td>
			<td></td>
			<td>${totalCost} zl</td>
		</tr>
		
		</table>
			
		</div>
		
		<a href="placeOrder" class="btn btn-success"><spring:message code="placeOrder"/> </a>
	
</div>

<%@ include file="footer.jsp" %>