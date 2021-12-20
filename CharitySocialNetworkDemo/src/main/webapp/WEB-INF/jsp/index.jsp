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
<<<<<<< HEAD
        
        <ul>
            <c:forEach var="u" items="${users}" >
            <li>${u.passWord}-${u.email}-${u.numberPhone}-${u.role}-${u.image}-${u.address}-${u.firstName}-${u.lastName}</li>
            </c:forEach>>
                
        </ul>
=======
        <div class="container"> 
            <ul>
                <c:forEach var="cmt" items="${comments}">
                    <li>
                        ${cmt.content}
                    </li>
                </c:forEach>
            </ul>
        </div>
>>>>>>> 5c94eeab34c013143e389724a13a23c8cf297888

    </body
</html>
