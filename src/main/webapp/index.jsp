<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; margin-top: 50px; }
        h1 { color: #333; }
        a { text-decoration: none; color: #007bff; }
        a:hover { text-decoration: underline; }
    </style>
</head>
<body>
    <%
        User user = (User) session.getAttribute("user");
    %>
        <h1>Welcome, <%= user.getUsername()  %>!</h1>
        <a href="logout">Logout</a>
        <a href="<%= request.getContextPath() %>/user/update?id=<%= user.getId() %>">Edit</a>
</body>
</html>