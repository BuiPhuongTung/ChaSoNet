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
       
            <ul>
                <c:forEach var="cmt" items="${comments}">
                    <li>
                        ${cmt.content}
                    </li>
                </c:forEach>
            </ul>
    </body
</html>
