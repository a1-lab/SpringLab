package com.learning.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

    @GetMapping(path = "welcome")
    public String welcome(ModelMap model) {
        return "welcome";
    }

    @GetMapping
    public String welcomeRoot(ModelMap model) {
        return "welcome";
    }

    @GetMapping("/authenticated")
    public String adminPage(ModelMap model){
        model.addAttribute("user", getPrincipal());
        return "authenticated";
    }

    private String getPrincipal() {
        String userName = null;
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if (null == securityContext) {
            throw new RuntimeException("securityContext is null");
        }

        Authentication authentication = securityContext.getAuthentication();
        if (null == authentication) {
            throw new RuntimeException("authentication is null");
        }

        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }

        return userName;
    }
}
