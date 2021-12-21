<%-- 
    Document   : login
    Created on : Dec 20, 2021, 3:29:36 PM
    Author     : Hau Exoty
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-danger">Login</h1>

<c:if test = "${param.error != null }">
    <div class = "alert alert-danger">
        Bad Request
        
    </div>
    
</c:if>

<c:url value = "/login" var = "action" />
<form method="post" action = ${action}>
    <div class = "form-group">
        <label for="userName">UserName</label>
        <input type="text" id ="userName" name ="userName" class ="form-control" /> 
    </div>  
    <div class = "form-group">
        <label for="passWord">PassWord</label>
        <input type="password" id ="passWord" name ="passWord" class ="form-control" /> 
    </div> 
    <div class = "form-group">
        <input type ="submit" value="Login" class="btn btn-danger"/>
        
    </div>
</form>
