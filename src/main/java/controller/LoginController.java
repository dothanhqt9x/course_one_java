package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Role;
import model.User;
import service.Auth;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = Auth.login(username, password);
        if (user != null){
            req.getSession().setAttribute("user", user);
            if (user.getRole() == Role.ADMIN){
                resp.sendRedirect("dashboard");
            }else {
                resp.sendRedirect("index.jsp");
            }
        } else {
            resp.sendRedirect("login?error=invalid");
        }
    }
}
