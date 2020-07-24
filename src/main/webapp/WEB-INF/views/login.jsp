<%--
  Created by IntelliJ IDEA.
  User: Houssam
  Date: 24/07/2020
  Time: 19:26
  To change this templatlle use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>

<html>
<head>
    <title>Login</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
<div class="container">
    <jsp:directive.include file="layout/header.jsp" />
    <header class="col-lg-4">
        <h1>Connexion</h1>
        <form:form method="post" action="${pageContext.request.contextPath}/auth/login" modelAttribute="user">
            <div class="form-group">
                <label for="email">Username</label>
                <form:input path="email" cssClass="form-control"  placeholder="email" />
                <form:errors path="email" cssClass="alert-danger" />
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <form:input path="password" cssClass="form-control"  placeholder="password" />
                <form:errors path="password" cssClass="alert-danger" />
            </div>
            <input class="btn btn-default" type="submit" value="Submit"/>
        </form:form>
    </header>
    <a class="btn-default btn" href="${pageContext.request.contextPath}/auth/register">register</a>
</div>
</html>
