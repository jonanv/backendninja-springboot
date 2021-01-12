package com.udemy.cotroller;

import com.udemy.model.Person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example3")
public class Example3Controller {

    private static final String FORM_VIEW = "form";

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("person", new Person());
        return FORM_VIEW;
    }
    
}
