<%-- 
    Document   : header
    Created on : Dec 12, 2021, 6:27:50 PM
    Author     : ACER
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>




<!-- Nav tabs -->
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item active">
        <a class="nav-link" href="<c:url value="/" /> ">Home</a>
    </li>
    <c:if test = "${pageContext.request.userPrincipal.name == null}">
    <li class="nav-item active">
        <a class="nav-link text-danger" href="<c:url value="/login" /> ">Login</a>
    </li>
    </c:if>
    <c:if test = "${pageContext.request.userPrincipal.name != null}">
        <li class="nav-item active">
        <a class="nav-link text-danger" href="<c:url value="/" /> ">${pageContext.request.userPrincipal.name}</a>
        </li>
        
    </c:if>
  </ul>
</nav>



