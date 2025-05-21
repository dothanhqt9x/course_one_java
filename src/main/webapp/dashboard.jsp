<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard Page</title>
</head>
<body>
    <h2>Dashboard</h2>
    <a href="logout">Logout</a>
    <a href="user/create.jsp">Create</a>
    <h3>User List</h3>
    <table>
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Role</th>
            <th>Actions</th>
        </tr>

        <%
            List<User> users = (List<User>) request.getAttribute("users");
            if (users != null) {
                for (User user : users) {
        %>
                    <tr>
                        <td><%= user.getId() %></td>
                        <td><%= user.getUsername() %></td>
                        <td><%= user.getRole() %></td>
                        <td>
                            <a href="<%= request.getContextPath() %>/user/update?id=<%= user.getId() %>">Edit</a>
                            <form action="<%= request.getContextPath() %>/user/delete" method="post" style="display:inline;">
                                <input type="hidden" name="id" value="<%= user.getId() %>">
                                <input type="submit" value="Delete" onclick="return confirm('Are you sure you want to delete this user?')">
                            </form>
                        </td>
                    </tr>
        <%
                }
            } else {
        %>
                <tr>
                    <td colspan="4">No users found.</td>
                </tr>
        <%
            }
        %>
    </table>
</body>
</html>
