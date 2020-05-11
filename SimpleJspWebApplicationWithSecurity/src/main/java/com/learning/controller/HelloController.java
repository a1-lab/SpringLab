package com.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {

    @RequestMapping(path = "welcome", method = RequestMethod.GET)
    public String welcome(ModelMap model) {
        model.addAttribute("message", "Spring MVC - Hello world");
        return "welcome";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String welcomeRoot(ModelMap model) {
        model.addAttribute("message", "Spring MVC - Hello world");
        return "welcome";
    }
}
