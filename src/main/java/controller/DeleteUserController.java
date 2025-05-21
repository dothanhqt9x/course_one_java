package controller;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user/delete")
public class DeleteUserController extends HttpServlet {
    private final UserDAO userDAO = UserDAO.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("id");
        if (idParam != null) {
            try {
                int id = Integer.parseInt(idParam);
                userDAO.deleteById(id);
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID: " + idParam);
            }
        }

        response.sendRedirect(request.getContextPath() + "/dashboard");
    }
}
