
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>success</h1>
    <c:forEach var="item" items="${fileList}">
        <a href="/${item}">${item}</a><br/>
    </c:forEach>
</center>
</body>
</html>
