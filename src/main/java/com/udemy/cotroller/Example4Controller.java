package com.udemy.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example4")
public class Example4Controller {

    public static final String NOT_FOUND_404 = "404";
    
    @GetMapping("")
    public String showView() {
        return NOT_FOUND_404;
    }
}
