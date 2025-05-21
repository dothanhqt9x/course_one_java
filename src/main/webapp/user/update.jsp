<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
    User user = (User) request.getAttribute("user");
    User loggedInUser = (User) session.getAttribute("user");
    boolean isUserRole = loggedInUser != null && loggedInUser.getRole().name().equals("USER");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update User</title>
</head>
<body>
    <h2>Update User</h2>

    <form action="<%= request.getContextPath() %>/user/update" method="post">
        <input type="hidden" name="id" value="<%= user.getId() %>">

        <label for="username">Username:</label><br>
        <input type="text" id="username" name="username" value="<%= user.getUsername() %>" required><br><br>

        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password" value="<%= user.getPassword() %>" required><br><br>

       <label for="role">Role:</label><br>
               <% if (isUserRole) { %>
                   <input type="text" name="role" value="<%= user.getRole().name() %>" readonly>
               <% } else { %>
                   <select id="role" name="role" required>
                       <option value="ADMIN" <%= "ADMIN".equals(user.getRole().name()) ? "selected" : "" %>>Admin</option>
                       <option value="USER" <%= "USER".equals(user.getRole().name()) ? "selected" : "" %>>User</option>
                   </select>
               <% } %>
               <br><br>

        <input type="submit" value="Update User">
    </form>

    <br>
    <% if (isUserRole == false) { %>
        <a href="<%= request.getContextPath() %>/dashboard">Back to User List</a>
    <% } %>
</body>
</html>
