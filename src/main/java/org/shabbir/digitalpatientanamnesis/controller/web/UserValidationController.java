package org.shabbir.digitalpatientanamnesis.controller.web;

import org.shabbir.digitalpatientanamnesis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserValidationController {
    private final UserService userService;
    @Autowired
    public UserValidationController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("registrierung")
    public String Registrierung() {
        return "signUp";
    }
}
