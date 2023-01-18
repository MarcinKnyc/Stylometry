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
        <h2>An error occurred:</h2>
        <p>
            <%
                out.println(request.getAttribute("message"));
            %>
        </p>
    </div>
    <div id="footer">
        <p>(C) 2023 Marcin Knyc, MIT Licence</p>
    </div>
</div>
</body>
</html>