<%@ include file="header.jsp" %>
	<spring:message code="label.purchasedItems"/>
<%@ include file="nav.jsp" %>


    <div class="container-fluid">
     
          <ul class="nav nav-tabs nav-justified">
				<li>	<a href="javascript:formSubmit()"> Logout</a>	</li>
				<li>	<a href="userRole"><spring:message code="label.role"/></a>	</li>
				<li>	<a href="userList"><spring:message code="label.userList"/></a>
				<li>	<a href="purchasedItems"><spring:message code="label.purchasedItems"/></a>
				</ul>

          

          <h2 class="sub-header"><spring:message code="label.purchasedItems"/></h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th><spring:message code="product.name"/></th>
                  <th><spring:message code="product.amount"/></th>
                  <th><spring:message code="label.orderBy"/></th>
                  <th><spring:message code="label.date"/></th>
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${purchased}" var="item">
                <tr>
                	<td>${item.product} </td>
        			<td>${item.quantity}</td>
        			<td>${item.orderBy}</td>
        			<td>${item.date}</td>
        		</tr>
              </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
    
    
    
<%@ include file="footer.jsp" %>
    
