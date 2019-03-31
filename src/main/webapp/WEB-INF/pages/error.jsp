<%--
  Created by IntelliJ IDEA.
  User: Anya
  Date: 24.03.2019
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h1>Hello, I'm Error. Nice to meet you here!</h1>
    <p><%= request.getAttribute("msg") %></p>
</body>
</html>
