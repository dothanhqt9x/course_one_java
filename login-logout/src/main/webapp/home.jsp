<%@ page contentType="text/html;charset=UTF-8" %>
<%
    // Kiểm tra nếu session không tồn tại hoặc không có username
    if (session == null || session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<html>
<head><title>Home</title></head>
<body>
    <h2>Welcome, <%= session.getAttribute("username") %>!</h2>
    <form action="logout" method="get">
        <input type="submit" value="Logout" />
    </form>
</body>
</html>
