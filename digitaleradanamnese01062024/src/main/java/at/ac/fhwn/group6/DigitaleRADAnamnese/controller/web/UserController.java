package at.ac.fhwn.group6.DigitaleRADAnamnese.controller.web;

import at.ac.fhwn.group6.DigitaleRADAnamnese.enums.RoleEnum;
import at.ac.fhwn.group6.DigitaleRADAnamnese.model.UserModel;
import at.ac.fhwn.group6.DigitaleRADAnamnese.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("signUp")
    public String signUp() {
        return "/general/signUp";
    }

    @PostMapping("signUp")
    public String signUp(@ModelAttribute UserModel user, @RequestParam String confirmPassword, Model model) {
        if (!user.getPassword().equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match!");
            return "/general/signUp";
        }

        if (userService.findByUsername(user.getUsername()).isPresent()) {
            model.addAttribute("error", "Username already exists!");
            return "/general/signUp";
        }

        if (user.getRole() == null) {
            user.setRole(RoleEnum.PATIENT);
        }

        userService.createUser(user);
        return "/general/logIn";
    }

    @GetMapping("logIn")
    public String logIn() {
        return "/general/logIn";
    }
}
