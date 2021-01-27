package com.udemy.controller;

import com.udemy.service.ExerciseService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/exercise")
public class ExerciseController {

    private static final String EXERCISE_VIEW = "exercise";
    private static final Log LOG = LogFactory.getLog(ExerciseController.class);

    @Autowired
    @Qualifier("exerciseService")
    private ExerciseService exerciseService;

    @GetMapping("/method1")
    public RedirectView method1() {
        return new RedirectView("/exercise/method2");
    }

    @GetMapping("/method2")
    public ModelAndView method2() {
        Long startTime = System.currentTimeMillis();

        ModelAndView mav = new ModelAndView();
        String mensaje = "Esta es la vista de exercise";
        mav.addObject("mensaje", mensaje);
        mav.setViewName(EXERCISE_VIEW);

        exerciseService.showLog();

        Long endTime = System.currentTimeMillis();
        Long timeResponse = endTime - startTime;

        LOG.info("--Tiempo de respuesta: '" + timeResponse + "'ms");
        mav.addObject("timeResponse", timeResponse);

        return mav;
    }
}
