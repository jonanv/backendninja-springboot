package com.udemy.controller;

import com.udemy.model.UserCredential;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private static final String LOGIN_VIEW = "login";
    
    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model, 
            @RequestParam(name="error", required=false) String error) {
        model.addAttribute("error", error);
        model.addAttribute("userCredential", new UserCredential());
        return LOGIN_VIEW;
    }

    @PostMapping("/logincheck")
    public String loginCheck(@ModelAttribute(name="userCredential") UserCredential userCredential) {
        if (userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")) {
            return "contacts";
        }
        return "redirect:/login?error";
    }

}