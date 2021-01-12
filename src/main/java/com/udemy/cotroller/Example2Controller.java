package com.udemy.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class Example2Controller {

    private static final String EXAMPLE2_VIEW = "example2";

    //localhost:8080/example2/requestMAV?nm=JON
    //localhost:8080/example2/requestMAV?nm=MIKEL
    @GetMapping("/requestMAV")
    public ModelAndView requestMAV(@RequestParam(name="nm", required=false, defaultValue="NULL") String name) {
        ModelAndView mav = new ModelAndView(EXAMPLE2_VIEW);
        mav.addObject("nm_in_model", name);
        return mav;
    }
}
