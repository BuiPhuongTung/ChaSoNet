<%-- 
    Document   : index.jsp
    Created on : Sep 20, 2021, 11:52:05 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="<c:url value="/css/style.css"/>" rel="stylesheet" />
    </head>
    <body>
        <h1>Hello ${name}</h1>    
        <a  href="<c:url value="/test"/> ">Redirect/forward</a>
        <div>
            <img src="<c:url value="/images/default.jpg"/>"/>
        </div>
        <h2>${fullName}</h2>
        <c:url value="/hello-post" var="hello"/>
        <form:form method="post" action="${hello}" modelAttribute="user">
            <spring:message code="user.firstName" />
            <form:input path="firstName"/>
            <br><!-- comment -->
            <spring:message code="user.lastName"/>
            <form:input path="lastName"/>
            <input type="submit" value="Send"/>
        </form:form>
    </body
</html>
