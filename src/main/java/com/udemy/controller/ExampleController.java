package com.udemy.controller;

import com.udemy.component.ExampleComponent;
import com.udemy.service.ExampleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class ExampleController {

    public static final String EXAMPLE_VIEW = "example";

    @Autowired // Le indica a Spring que se va inyectar un componente que se encuentra en la memoria
    @Qualifier("exampleComponent") // Le indica Spring el nombre del bean que esta en su memoria
    private ExampleComponent exampleComponent;

    @Autowired
    @Qualifier("exampleService")
    private ExampleService exampleService;
    
    //Primera forma
    // @RequestMapping(method=RequestMethod.GET, value="/exampleString")
    @GetMapping("/exampleString")
    public String exampleString(Model model) {
        exampleComponent.sayHello();
        model.addAttribute("people", exampleService.getListPeople());
        return EXAMPLE_VIEW;
    }

    //Segunda forma
    @GetMapping("/exampleMAV")
    public ModelAndView exampleMAV() {
        ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
        mav.addObject("people", exampleService.getListPeople());

        return mav;
    }
}
