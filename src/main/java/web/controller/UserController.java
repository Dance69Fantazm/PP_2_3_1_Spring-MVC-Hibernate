package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showUsersTable(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/adduser")
    public String addUserForm(@ModelAttribute("user") User user) {
        return "adduser";
    }

    @PostMapping("/adduser")
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "adduser";
        }
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/updateuser")
    public String updateUserForm(@RequestParam("id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "updateuser";
    }

    @PostMapping("/updateuser")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateuser";
        }
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@ModelAttribute("id") @Valid Long id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "deleteuser";
        }
        userService.deleteUser(id);
        return "redirect:/";
    }
}
