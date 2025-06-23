package com.btspring.btspring2.controller;

import com.btspring.btspring2.anotation.CheckLogin;
import com.btspring.btspring2.anotation.CheckRole;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {


    @CheckLogin
    @CheckRole("admin")
    @GetMapping("/")
    public String index() {
        return "start";
    }
}
