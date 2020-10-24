<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Pick a hero class</title>
</head>
<body>
    <div align="center">
        <h1>Pick Your Class:</h1>
        <c:forEach items="${heroClassList}" var="heroClass">
             <p>${heroClass.name}</p>
        </c:forEach>
        <a href="<c:url value="/"/>">Home Page</a></li>
    </div>
</body>
</html>