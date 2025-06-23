package com.btspring.btspring2.controller;


import com.btspring.btspring2.model.dto.request.LoginRequestDTO;
import com.btspring.btspring2.model.dto.response.JwtResponseDTO;
import com.btspring.btspring2.model.entity.UserEntity;
import com.btspring.btspring2.repository.UserRepository;
import com.btspring.btspring2.util.BCriptUtil;
import com.btspring.btspring2.util.JWTUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class LoginController {

    private UserRepository userRepository;
    private BCriptUtil bCriptUtil;
    private JWTUtil jwtUtil;

    public LoginController(UserRepository userRepository, BCriptUtil bCriptUtil, JWTUtil jwtUtil) {
        this.userRepository = userRepository;
        this.bCriptUtil = bCriptUtil;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@ModelAttribute LoginRequestDTO loginRequestDTO, Model model, HttpServletResponse httpServletResponse) {

        Optional<UserEntity> optionalUserEntity = userRepository.findByUsername(loginRequestDTO.getUsername());
        if(optionalUserEntity.isEmpty()){
            model.addAttribute("error", "Ko tồn tại tài khoản!");
            return "login";
        }

        UserEntity userEntity = optionalUserEntity.get();
        if(!bCriptUtil.checkPassword(loginRequestDTO.getPassword(), userEntity.getPassword())) {
            model.addAttribute("error", "sai password");
            return "login";
        }

        //dang nhap thanh cong

        JwtResponseDTO jwtResponseDTO = new JwtResponseDTO();
        jwtResponseDTO.setUserId(userEntity.getId());
        jwtResponseDTO.setUsername(userEntity.getUsername());

        jwtResponseDTO.setRole(userEntity.getRole());

        String role = jwtResponseDTO.getRole();

        String token = jwtUtil.generateToken(jwtResponseDTO);
        System.out.println("TOKEN " + token);

        Cookie cookie = new Cookie("token", token);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        httpServletResponse.addCookie(cookie);
        if("admin".equals(role)){
            return "redirect:/";
        }else if("client".equals(role)){
            int id = jwtResponseDTO.getUserId();
            return "redirect:/client/" + id + "/buy";
        }
        return "redirect:/login";
    }
}
