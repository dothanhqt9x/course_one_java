package controller;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Role;
import model.User;

import java.io.IOException;

@WebServlet("/user/update")
public class UpdateUserController extends HttpServlet {
    private final UserDAO userDAO = UserDAO.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null) {
            try {
                int id = Integer.parseInt(idParam);
                User user = userDAO.findById(id);
                request.setAttribute("user", user);
                request.getRequestDispatcher("/user/update.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                response.sendRedirect(request.getContextPath() + "/users");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/users");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String role = request.getParameter("role");

            User user = User.builder()
                    .id(id)
                    .username(username)
                    .password(password)
                    .role(Role.valueOf(role))
                    .build();

            userDAO.update(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/dashboard");
    }
}
