<%-- 
    Document   : index.jsp
    Created on : Sep 20, 2021, 11:52:05 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Hello ${name}</h1>    
        <h2>${fullName}</h2>
    </body>
    <form:form method="post" action="/CharitySocialNetworkDemo/hello-post" modelAttribute="user">
        <form:input path="firstName"/>
        <form:input path="lastName"/>
        <input type="submit" value="Send"/>
    </form:form>
</html>
