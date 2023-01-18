<%--version 0.1--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Stylometry</title>
    <link rel="stylesheet" type="text/css" href="screen.css">
</head>
<body>
<div id="container">
    <div id="header">
        <p><b>Stylometry</b> - A Simple Web App for Stylometric text analysis</p>
    </div>
    <div id="content">
        <h3>text:</h3>
        <p>
            <%
            out.println(request.getAttribute("text"));
            %>
        </p>
        <h3>analysis results:</h3>
        <ul>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <c:forEach items="${results}" var="result" varStatus="loop">
                <li>${result}</li>
            </c:forEach>
        </ul>
    </div>
    <div id="footer">
        <p>(C) 2023 Marcin Knyć, MIT Licence</p>
    </div>
</div>
</body>
</html>