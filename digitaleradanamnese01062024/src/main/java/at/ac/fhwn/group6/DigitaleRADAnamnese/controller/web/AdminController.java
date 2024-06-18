package at.ac.fhwn.group6.DigitaleRADAnamnese.controller.web;

import at.ac.fhwn.group6.DigitaleRADAnamnese.enums.RoleEnum;
import at.ac.fhwn.group6.DigitaleRADAnamnese.model.UserModel;
import at.ac.fhwn.group6.DigitaleRADAnamnese.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/user-management")
    public String userManagement(Model model) {
        List<UserModel> staffUsers = userService.findAllUsersByRole("STAFF");
        model.addAttribute("users", staffUsers);
        return "admin/manageUsers";
    }

    @PostMapping("/create-staff")
    public ModelAndView createStaff(UserModel user) {
        user.setRole(RoleEnum.STAFF);
        userService.createUser(user);
        return new ModelAndView("redirect:/admin/user-management");
    }
}
