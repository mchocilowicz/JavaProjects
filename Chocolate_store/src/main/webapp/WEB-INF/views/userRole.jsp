<%@ include file="header.jsp" %>
	UserList
<%@ include file="nav.jsp" %>




<form:form method="post" action="addUserRole.html" commandName="userRole">
    <table>
    <tr>
        <td><form:hidden path="id"/>
    </tr>
    <tr class="form-group">
        <td><form:label path="role"><spring:message code="label.role"/></form:label></td>
        <td><form:input class="form-control" path="role" /></td>
        <td><form:errors path="role"/></td>
    </tr>
    
    <tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.addUserRole"/>"/>
        </td>
    </tr>
</table> 
</form:form>

<%@ include file="footer.jsp" %>
