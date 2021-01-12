package com.udemy.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class ExampleController {

    public static final String EXAMPLE_VIEW = "example";
    
    //Primera forma
    @GetMapping("/exampleString")
    public String exampleString(Model model) {
        model.addAttribute("name", "Giovanni");
        return EXAMPLE_VIEW;
    }

    //Segunda forma
    @GetMapping("/exampleMAV")
    public ModelAndView exampleMAV() {
        ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
        mav.addObject("name", "Johanny");

        return mav;
    }

}
