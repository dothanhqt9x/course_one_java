package com.btspring.btspring2.util;

import com.btspring.btspring2.model.dto.response.JwtResponseDTO;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JWTUtil {

    private static final String SECRET = "jfXSwNzdrhUEX196X1q76DrXm5mRpD2AxzjivzCGAtHTAfNtrOLwumwClz/i50GO";

    public Key generateKey() {
        byte[] keyBytes = SECRET.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(JwtResponseDTO jwtResponseDTO) {
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(String.valueOf(jwtResponseDTO.getUserId()));
        builder.claim("username", jwtResponseDTO.getUsername());
        builder.claim("role", jwtResponseDTO.getRole());

        Date now = new Date();
        Date exp = new Date(now.getTime() + 1000 * 60 * 60 * 24 * 7);

        builder.setExpiration(exp);
        builder.setIssuedAt(now);

        builder.signWith(generateKey());

        return builder.compact();
    }

    public JwtResponseDTO verifyToken(String token) {
        JwtParser jwtParser = Jwts.parser().setSigningKey(SECRET.getBytes(StandardCharsets.UTF_8));
        Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);
        Claims claims = claimsJws.getBody();

        JwtResponseDTO dto = new JwtResponseDTO();
        dto.setUserId(Integer.parseInt(claims.getSubject()));
        dto.setUsername((String) claims.get("username"));
        dto.setRole((String) claims.get("role"));
        return dto;
    }



}
