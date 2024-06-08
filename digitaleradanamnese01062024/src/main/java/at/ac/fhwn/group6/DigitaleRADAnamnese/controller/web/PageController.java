package at.ac.fhwn.group6.DigitaleRADAnamnese.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {
    @GetMapping("/")
    public String showIndex() {
        return "/general/index";
    }

    @GetMapping("/help")
    public String showHelp() {
        return "/general/help";
    }

}
