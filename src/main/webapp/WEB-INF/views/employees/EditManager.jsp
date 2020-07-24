<%--
  Created by IntelliJ IDEA.
  User: Houssam
  Date: 23/07/2020
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Edit Employee Info | EmployeesPlateforme</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <style>
        .slidecontainer {
            width: 10%; /* Width of the outside container */
        }

    </style>
</head>
<body >
<div class="container">
    <jsp:directive.include file="../layout/header.jsp" />

    <form:form method="post" action="${pageContext.request.contextPath}/employee/edit" modelAttribute="employees" >
        <form:input path="id" type="hidden" />
        <div class="form-group">
            <label for="name">nom complete</label>
            <form:input path="name" cssClass="form-control"  placeholder="nom complete" />
            <form:errors path="name" cssClass="alert-danger" />
        </div>
        <div class="form-group">
            <label for="address">address</label>
            <form:input path="address" cssClass="form-control"  placeholder="address" />
            <form:errors path="address" cssClass="alert-danger" />
        </div>
        <div class="form-group">
            <label for="phone">phone</label>
            <form:input path="phone" cssClass="form-control"  placeholder="phone" />
            <form:errors path="phone" cssClass="alert-danger" />
        </div>
        <div class="form-check">
            <label class="form-check-label">
                remuneration : <c:out value="${employees.remuneration.name}"></c:out>
            </label>
        </div>
        <div class="form-check">
            <label class="form-check-label">
                deapartement : <c:out value="${employees.departement.name}"></c:out>
            </label>
        </div>


        <c:if test="${employees.normalEmployees.size()>0}">
            <label class="form-check-label">
                sous-adjacents :
            </label>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">name</th>
                    <th scope="col">departement</th>
                    <th scope="col">Handle</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>Larry</td>
                    <td>the Bird</td>
                    <td>@twitter</td>
                </tr>
                </tbody>
            </table>
        </c:if>


        <c:choose>
            <c:when test="${employees.remuneration.type.equals('fixe')}">
                <div class="form-group">
                    <label for="grade">grade employée : <p id="output"></p></label>
                    <div class="slidecontainer">
                        <form:input path="grade" cssClass="form-control" type="range" min="0" max="5" id="myRange" />
                    </div>
                    <span id="output">valeur remuniration : <p id="remVal"></p> Dh</span>
                    <form:errors path="grade" cssClass="alert-danger" />
                </div>
            </c:when>
            <c:when test="${employees.remuneration.type.equals('variable')}">
                <div class="form-group">
                    <label for="score">score employée : <p id="output"></p></label>
                    <div class="slidecontainer">
                        <form:input path="score" cssClass="form-control" type="range" value="${employees.score}" min="0" max="5" id="myRange" />
                    </div>
                    <span id="output">valeur remuniration : <p id="remVal"></p> Dh</span>
                    <form:errors path="score" cssClass="alert-danger" />
                </div>
            </c:when>
        </c:choose>

        <div class="form-check">
            <label class="form-check-label">
                departement
            </label>
            <form:select class="form-check-label"  path="departement" multiple="false">
                <c:forEach items="${departement}" var="dep">
                    <form:option value="${dep.id}">${dep.name}</form:option>
                </c:forEach>
            </form:select>
            <form:errors path="departement" cssClass="alert-danger" />
        </div>
        <div class="form-check">
            <form:select class="form-check-label"  path="remuneration" multiple="false" disabled="false">
                <c:forEach items="${remuneration}" var="dep">
                    <form:option value="${dep.id}">${dep.name}</form:option>
                </c:forEach>
            </form:select>
            <form:errors path="remuneration" cssClass="alert-danger" />
        </div>


        <div class="form-check">
            <label class="form-check-label">
                ajouter des sous-adjacents
            </label>
            <form:select class="form-check-label" path="normalEmployees" >
                <c:forEach items="${normalEmployees}" var="nempl">
                    <form:option value="${nempl.id}"> Name: ${nempl.name} | Grade: ${nempl.grade} | Département: ${nempl.departement.name}</form:option>
                </c:forEach>
            </form:select>
            <form:errors path="normalEmployees" cssClass="alert-danger" />
        </div>
        <input type = "submit" value = "Submit"/>
    </form:form>
</div>
<script>
    var slider = document.getElementById("myRange");
    var output = document.getElementById("output");
    var remval = document.getElementById("remVal");
    var ram = parseInt(${employees.remuneration.valeur});
    console.log(ram);
    output.innerHTML = slider.value; // Display the default slider value

    // Update the current slider value (each time you drag the slider handle)
    slider.oninput = function() {
        output.innerHTML = this.value;
        console.log(this.value);
        remval.innerHTML = (ram*parseInt(this.value));
    }
</script>
</body>
</html>
