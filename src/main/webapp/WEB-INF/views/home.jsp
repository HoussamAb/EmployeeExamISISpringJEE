<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Home | Employee</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
<div class="container">
    <jsp:directive.include file="layout/header.jsp" />
 <header class="col-lg-12">
    <h1>Tous les employees</h1>

     <c:forEach items="${data}" var="item">
         <div style="border-style: solid;">


             <div>${item.id}</div><div>${item.name}</div><div>${item.created}</div><div>${item.type()}</div>
             <div>
                 <a href="${pageContext.request.contextPath}/delete/${item.id}" class="btn btn-danger"
                    onclick="if (!(confirm('Vous Voulez supprimer cet element?'))) return false">Supprimer</a>
                 <a href="${pageContext.request.contextPath}/employee/edit/${item.id}" class="btn btn-success">Modifier</a>
             </div>
         </div>
     </c:forEach>


 </header>

</div>

</body>
</html>