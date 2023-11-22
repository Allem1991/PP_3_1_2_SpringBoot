package ru.khusnullin.SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.khusnullin.SpringBoot.model.User;
import ru.khusnullin.SpringBoot.service.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String printAllUsers(ModelMap model) {
        model.addAttribute("users", userService.listUsers());
        return "users/allUsers";
    }

    @GetMapping(params = "id")
    public String printUser(@RequestParam(value = "id", required = false) long id, ModelMap model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/user";
    }

    @GetMapping("/new")
    public String getCreatePage(@ModelAttribute("user") User user) {
        return "users/create";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/users/create";
        }
        userService.addUser(user);
        return "redirect:/users";
    }

    @PostMapping(value = "/delete", params = "id")
    public String deleteUser(@RequestParam(value = "id", required = false) long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/edit", params = "id")
    public String getEditPage(@RequestParam(value = "id", required = false) long id, ModelMap model) {
        model.addAttribute("userEdit", userService.getUserById(id));
        return "users/edit";
    }

    @PostMapping(params = "id")
    public String editUser(@RequestParam(value = "id", required = false) long id,
                           @ModelAttribute("userEdit") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/edit";
        }
        userService.updateUser(user);
        return "redirect:/users";
    }

}
