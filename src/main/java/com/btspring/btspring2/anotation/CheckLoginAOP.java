package com.btspring.btspring2.anotation;

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
public class CheckLoginAOP {

    private final JWTUtil jwtUtil;

    public CheckLoginAOP(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Around("@annotation(com.btspring.btspring2.anotation.CheckLogin)")
    public Object checkLogin(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attrs.getRequest();
        HttpServletResponse response = attrs.getResponse();

        String token = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }

        if (token == null || jwtUtil.verifyToken(token) == null) {
            return "redirect:/login";
        }

        return joinPoint.proceed();
    }
}
