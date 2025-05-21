<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create User</title>
</head>
<body>
    <h2>Create New User</h2>

    <form action="<%= request.getContextPath() %>/user/create" method="post">
        <label for="username">Username:</label><br>
        <input type="text" name="username" id="username" required><br><br>

        <label for="password">Password:</label><br>
        <input type="password" name="password" id="password" required><br><br>

        <label for="role">Role:</label><br>
        <select name="role" id="role" required>
            <option value="ADMIN">Admin</option>
            <option value="USER">User</option>
        </select><br><br>

        <input type="submit" value="Create User">
    </form>

    <br>
    <a href="<%= request.getContextPath() %>/dashboard">Back to User List</a>
</body>
</html>
