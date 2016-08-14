<%@ include file="header.jsp" %>
	UserList
<%@ include file="nav.jsp" %>


    
    <ul class="nav nav-tabs nav-justified">
				<li>	<a href="javascript:formSubmit()"> Logout</a>	</li>
				<li>	<a href="userRole"><spring:message code="label.role"/></a>	</li>
				<li>	<a href="userList"><spring:message code="label.userList"/></a>
				<li>	<a href="purchasedItems"><spring:message code="label.purchasedItems"/></a>
	</ul>    
    
    
          <div class="table-responsive">
          <c:if  test="${!empty userList}">
            <table class="table table-striped">
              <thead>
                <tr>
                  
                  <th><spring:message code="label.userId"/></th>
                  <th><spring:message code="label.firstname"/></th>
                  <th><spring:message code="label.lastname"/></th>
                  <th><spring:message code="label.login"/></th>
                  <th><spring:message code="label.telephone"/></th>
                  <th><spring:message code="label.email"/></th>
                  
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${userList}" var="user">
                <tr>
                	
                  	<td>
                  		<a href="deleteUser/${user.id}.html"><span class="glyphicon glyphicon-remove"></span></a>
                  		${user.id}
                  	</td>
        			<td>${user.firstname} </td>
        			<td>${user.lastname}</td>
        			<td>${user.login}</td>
        			<td>${user.telephone}</td>
        			<td>${user.email}</td>
        			
                </tr>
              </c:forEach>
              </tbody>
            </table>
            </c:if>
          </div>
        </div>
      </div>
    </div>
    
    
    
<%@ include file="footer.jsp" %>
    
