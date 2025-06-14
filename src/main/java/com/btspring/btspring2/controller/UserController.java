package com.btspring.btspring2.controller;

import com.btspring.btspring2.convert.UserMapper;
import com.btspring.btspring2.model.dto.request.UserRequestDTO;
import com.btspring.btspring2.model.dto.request.UserSearchRequestDTO;
import com.btspring.btspring2.model.entity.UserEntity;
import com.btspring.btspring2.service.UserService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }


    @GetMapping("")
    public String home(Model model) {
        List<UserEntity> listUser = userService.getUsers();
        model.addAttribute("listUser", listUser);
        if (listUser.size() == 0) {
            model.addAttribute("message", "Ko có user nào");
        }
        return "user";
    }

    @GetMapping("/add")
    public String add() {
        return "user-add";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute UserRequestDTO userRequestDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "user-add";
        }

        userService.addUser(userRequestDTO);
        System.out.println("Controller" + userRequestDTO.getName() +
                userRequestDTO.getGender() +
                userRequestDTO.getBirthday() +
                userRequestDTO.getAddress());

        return "user-add-success";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        if (id < 0 || userService.getUserById(id) == null) {
            return "user-delete-fail";
        }
        userService.deleteUser(id);
        return "user-delete-success";
    }

    @GetMapping("/update")
    public String update(Model model, @ModelAttribute UserRequestDTO userRequestDTO, int id) {
        model.addAttribute("valueID", id);
        UserRequestDTO dto = userMapper.toUserRequestDTO(userService.getUserById(id));
        model.addAttribute("dto", dto);
        return "user-update";
    }

    @PostMapping("/update")
    public String update(@RequestParam Integer id, @ModelAttribute UserRequestDTO userRequestDTO) {
        userService.updateUser(id, userRequestDTO);
        return "user-update-success";
    }

    @GetMapping("/search")
    public String search(@ModelAttribute UserSearchRequestDTO userSearchRequestDTO, Model model) {


        model.addAttribute("valuedID", userSearchRequestDTO.getId());
        model.addAttribute("valuedName", userSearchRequestDTO.getName());
        model.addAttribute("valuedGender", userSearchRequestDTO.getGender());
        model.addAttribute("valueAddress", userSearchRequestDTO.getAddress());

        List<UserEntity> listUser = userService.getUsers();

        if (userSearchRequestDTO.getId() != null) {
            listUser = listUser.stream().
                    filter(u -> u.getId() == userSearchRequestDTO.getId()).
                    collect(Collectors.toList());
        }

        if (userSearchRequestDTO.getName() != null && !userSearchRequestDTO.getName().equals("")) {
            listUser = listUser.stream().filter(userEntity -> userEntity.getName().toLowerCase().
                            contains(userSearchRequestDTO.getName().toLowerCase())).
                    collect(Collectors.toList());
        }
        if (userSearchRequestDTO.getGender() != null && !userSearchRequestDTO.getGender().equals("")) {
            listUser = listUser.stream().filter(userEntity -> userEntity.getGender() == userSearchRequestDTO
                    .getGender()).collect(Collectors.toList());
        }
        if (userSearchRequestDTO.getAddress() != null && !userSearchRequestDTO.getAddress().equals("")) {
           listUser = listUser.stream().filter(userEntity -> userEntity.getAddress().
                   equalsIgnoreCase(userSearchRequestDTO.getAddress())).toList();
        }
        model.addAttribute("listUser", listUser);


        List<UserEntity> allUsers = userService.getUsers();
        model.addAttribute("allUsers", allUsers);

        return "user-search";
    }


}
