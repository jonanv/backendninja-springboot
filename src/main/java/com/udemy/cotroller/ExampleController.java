package com.udemy.cotroller;

import com.udemy.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/example")
public class ExampleController {

    public static final String EXAMPLE_VIEW = "example";
    
    //Primera forma
    // @RequestMapping(method=RequestMethod.GET, value="/exampleString")
    @GetMapping("/exampleString")
    public String exampleString(Model model) {
        model.addAttribute("people", getPeople());
        return EXAMPLE_VIEW;
    }

    //Segunda forma
    @GetMapping("/exampleMAV")
    public ModelAndView exampleMAV() {
        ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
        mav.addObject("people", getPeople());

        return mav;
    }

    private List<Person> getPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Juan", 26));
        people.add(new Person("Diego", 30));
        people.add(new Person("Eva", 22));
        people.add(new Person("Pedro", 35));
        return people;
    }
}
