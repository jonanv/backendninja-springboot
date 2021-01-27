package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.udemy.model.Person;
import com.udemy.service.ExampleService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

    private static final Log LOG = LogFactory.getLog(ExampleService.class);

    @Override
    public List<Person> getListPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Juan", 26));
        people.add(new Person("Diego", 30));
        people.add(new Person("Eva", 22));
        people.add(new Person("Pedro", 35));
        LOG.info("HELLO FROM SERVICE");
        return people;
    }
    
}
