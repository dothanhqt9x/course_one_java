package com.btspring.btspring2.controller;

import com.btspring.btspring2.anotation.CheckLogin;
import com.btspring.btspring2.anotation.CheckRole;
import com.btspring.btspring2.convert.UserMapper;
import com.btspring.btspring2.model.dto.request.UserRequestDTO;
import com.btspring.btspring2.model.dto.request.UserSearchRequestDTO;
import com.btspring.btspring2.model.entity.UserEntity;
import com.btspring.btspring2.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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


    @CheckLogin
    @CheckRole("admin")
    @GetMapping("")
    public String home(Model model) {
        List<UserEntity> listUser = userService.getUsers();
        model.addAttribute("listUser", listUser);
        if (listUser.size() == 0) {
            model.addAttribute("message", "Ko có user nào");
        }
        return "user";
    }

    @CheckLogin
    @CheckRole("admin")
    @GetMapping("/add")
    public String add() {
        return "user-add";
    }


    @CheckLogin
    @CheckRole("admin")
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute UserRequestDTO userRequestDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "user-add";
        }

        userService.addUser(userRequestDTO);

        return "user-add-success";
    }

    @CheckLogin
    @CheckRole("admin")
    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        if (id < 0 || userService.getUserById(id) == null) {
            return "user-delete-fail";
        }
        userService.deleteUser(id);
        return "user-delete-success";
    }

    @CheckLogin
    @CheckRole("admin")
    @GetMapping("/update")
    public String update(Model model, @ModelAttribute UserRequestDTO userRequestDTO, int id) {
        model.addAttribute("valueID", id);
        UserRequestDTO dto = userMapper.toUserRequestDTO(userService.getUserById(id));
        model.addAttribute("dto", dto);
        return "user-update";
    }

    @CheckLogin
    @CheckRole("admin")
    @PostMapping("/update")
    public String update(@RequestParam Integer id, @Valid @ModelAttribute UserRequestDTO userRequestDTO,BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("valueID", id);
            model.addAttribute("dto", userMapper.toUserRequestDTO(userService.getUserById(id)));
            return "user-update";
        }
        userService.updateUser(id, userRequestDTO);
        return "user-update-success";
    }

    @CheckRole("admin")
    @CheckLogin
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
