package controller;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Role;
import model.User;

import java.io.IOException;

@WebServlet("/user/create")
public class CreateUserController extends HttpServlet {
    private final UserDAO userDAO = UserDAO.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        if (username != null && password != null && role != null) {
            User user = User.builder()
                    .username(username)
                    .password(password)
                    .role(Role.valueOf(role)).
                    build();
            userDAO.insert(user);
        }

        response.sendRedirect(request.getContextPath() + "/dashboard");
    }
}
