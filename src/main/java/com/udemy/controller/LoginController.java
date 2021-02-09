package com.udemy.controller;

import com.udemy.constant.ViewConstant;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private static final Log LOG = LogFactory.getLog(LoginController.class);
    
    // @GetMapping("/")
    // public String redirectToLogin() {
    //     LOG.info("METHOD: redirectToLogin()");
    //     return "redirect:/login";
    // }

    @GetMapping("/login")
    public String showLoginForm(Model model, 
            @RequestParam(name="error", required=false) String error,
            @RequestParam(name="logout", required=false) String logout) {
        LOG.info("METHOD: showLoginForm() -- PARAMS: error=" + error + ", logout=" + logout);

        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        // model.addAttribute("userCredential", new UserCredential());
        return ViewConstant.LOGIN_VIEW;
    }

    @GetMapping({"/loginsuccess", "/"})
    public String loginCheck() {
        LOG.info("METHOD: loginCheck()");
        LOG.info("Returning to contacts view");
        return "redirect:/contacts/showcontacts";
    }

}
