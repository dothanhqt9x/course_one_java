package com.thai.spring_mvc;

import com.thai.spring_mvc.utils.Jwt;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Jwt jwt = new Jwt(1, "2023-10-01T12:00:00Z", List.of("ROLE_USER", "ROLE_ADMIN"));
        System.out.println(jwt.getJwt());
    }
}
