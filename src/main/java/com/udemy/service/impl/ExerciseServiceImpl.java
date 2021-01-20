package com.udemy.service.impl;

import com.udemy.service.ExerciseService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService {

    private static final Log LOG = LogFactory.getLog(ExerciseService.class);

    @Override
    public void showLog() {
        LOG.info("INGRESO AL METODO ShowLog");
    }
    
}
