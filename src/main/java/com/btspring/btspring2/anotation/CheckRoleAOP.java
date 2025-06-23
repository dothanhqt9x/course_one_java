package com.btspring.btspring2.anotation;

import com.btspring.btspring2.model.dto.response.JwtResponseDTO;
import com.btspring.btspring2.util.JWTUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class CheckRoleAOP {

    private final JWTUtil jwtUtil;

    public CheckRoleAOP(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Around("@annotation(checkRole)")
    public Object checkRole(ProceedingJoinPoint joinPoint, CheckRole checkRole) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) return null;

        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();

        String token = null;
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if ("token".equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }

        if (token == null || token.isEmpty()) {
            if (response != null) response.sendRedirect("/login");
            return null;
        }

        JwtResponseDTO user = jwtUtil.verifyToken(token);
        String requiredRole = checkRole.value();

        if (!user.getRole().equalsIgnoreCase(requiredRole)) {
            if (response != null) {
                response.sendRedirect("/client/error-role");
                response.flushBuffer();
            }

            return null;
        }
        return joinPoint.proceed();
    }
}
