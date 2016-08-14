</title>
<style>
.text-success {
  display: inline;
}
</style>
</head>
<body> 
	<nav class="navbar navbar-default">
			  <div class="container-fluid">
			    <!-- Brand and toggle get grouped for better mobile display -->
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			      <a class="navbar-brand" href="hello.html">Czeko</a>
			    </div>
			
			    <!-- Collect the nav links, forms, and other content for toggling -->
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			      <ul class="nav navbar-nav">
			        <li class="active"><a href="recipe.html">Recipe<span class="sr-only">(current)</span></a></li>
			         <li class="active"><a href="shop.html">Shop<span class="sr-only"></span></a></li>
			        <li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-globe"><spring:message code="language"/></span> <span class="caret"></span></a>
			          <ul class="dropdown-menu">
			            <li><a href="?lang=pl">PL</a></li>
			            <li><a href="?lang=en">ENG</a></li>
			            <li><a href="?lang=de">DE</a></li>
			          </ul>
			        </li>
			      </ul>
			      
			      <ul class="nav navbar-nav navbar-right">
			      	<sec:authorize access="isAnonymous()">
			      
			        <li>
			        	<a href="users.html"><span class="glyphicon glyphicon-list-alt"><spring:message code="register"/></span></a>
			        </li>
			        <li>
			        	<a href="login.html"><span class="glyphicon glyphicon-log-in"> <spring:message code="login"/></span></a>
			        </li>
			       </sec:authorize>
			       
			       <sec:authorize access= "isAuthenticated()">
			       <c:if test="${pageContext.request.userPrincipal.name != null}">
			       		<div class="dropdown">
			       		<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
			       			<span class="glyphicon glyphicon-user"></span>
				       			${ pageContext.request.userPrincipal.name}<span class="carret"></span>
			       		</button>
			       		<ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
			       			<li>
			       				<c:url value="/j_spring_security_logout" var="logoutUrl" >Logout</c:url>
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
									<a	href="javascript:formSubmit()"><span class="glyphicon glyphicon-off"><spring:message code="logout"/></span> </a>
			       			</li>
			       			<li><a href="profile.html"><span class="glyphicon glyphicon-briefcase"><spring:message code="profile"/></span></a></li>
			       			<li><a href="cart.html"><span class="glyphicon glyphicon-shopping-cart"><spring:message code="shoppingCart"/></span></a></li>&nbsp;
			       			<sec:authorize access= "hasRole('ROLE_ADMIN')">
			       			<li><a href="admin.html"><span class="glyphicon glyphicon-king"><spring:message code="admin"/></span></a></li>
			       			</sec:authorize>
			       		</ul>
			       		</div>
					</c:if>
					</sec:authorize>
			      
			      </ul>
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
		</nav>
		<div class="container">