<%-- 
    Document   : register
    Created on : Dec 21, 2021, 9:55:37 AM
    Author     : Hau Exoty
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-danger">Register</h1>

<c:if test = "${errMsg != null }">
    <div class = "alert alert-danger">
        ${errMsg}
        
    </div>
    
</c:if>


<c:url value = "/register" var = "action" />
<form:form method="post" action =${action} modelAttribute="user">
    <div class = "form-group">
        <label for="firstName">First Name</label>
        <form:input type="text" id="firstName" path="firstName" class ="form-control" /> 
    </div>
    <div class = "form-group">
        <label for="lastName">Last Name</label>
        <form:input type="text" id="lastName" path="lastName" class ="form-control" /> 
    </div> 
    <div class = "form-group">
        <label for="userName">UserName</label>
        <form:input type="text" id="userName" path="userName" class ="form-control" /> 
    </div>
    <div class = "form-group">
        <label for="email">Email</label>
        <form:input type="email" id="email" path="email" class ="form-control" /> 
    </div>
    <div class = "form-group">
        <label for="passWord">Password</label>
        <form:input type="password" id="passWord" path=" passWord" class ="form-control" /> 
    </div>
    <div class = "form-group">
        <label for="confirm-password">Confirm Password</label>
        <form:input type="password" id="confirm-password" path="confirmPassword" class ="form-control" /> 
    </div>
    <div class = "form-group">
        <input type ="submit" value="Register" class="btn btn-danger"/>
        
    </div>
</form:form>
