package com.thai.spring_mvc.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class Jwt {
    private static final String SECRET = "secretKey123";
    private static final long EXPIRATION_TIME = 86400000; // 1 day in milliseconds

    private int userId;
    private String iat;
    private List<String> roles;
    private String jwt;

    public Jwt(int userId, String iat, List<String> roles) {
        this.userId = userId;
        this.iat = iat;
        this.roles = roles;
        this.jwt = generateJwt();
    }

    private Jwt(int userId, String iat, List<String> roles, String jwt) {
        this.userId = userId;
        this.iat = iat;
        this.roles = roles;
        this.jwt = jwt;
    }

    private String generateJwt() {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);

        return JWT.create()
                .withIssuer("my-app")
                .withSubject(String.valueOf(userId))
                .withClaim("iat", iat)
                .withClaim("roles", roles)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(algorithm);
    }

    public static Jwt decode(String token) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("your-app-name")
                .build();

        DecodedJWT decoded = verifier.verify(token);

        int userId = Integer.parseInt(decoded.getSubject());
        String iat = decoded.getClaim("iat").asString();
        List<String> roles = decoded.getClaim("roles").asList(String.class);

        return new Jwt(userId, iat, roles, token);
    }
}
