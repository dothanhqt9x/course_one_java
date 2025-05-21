package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Role;
import model.User;

import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        // not check login page
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        if (uri.equals(contextPath + "/login")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        boolean isLoggedIn = (session != null && session.getAttribute("user") != null);
        if (isLoggedIn) {
            User user = (User) session.getAttribute("user");
            Role role = user.getRole();
            if (role == Role.USER && uri.equals(contextPath + "/dashboard") || uri.equals(contextPath + "/user/create")) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
                return;
            }
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
