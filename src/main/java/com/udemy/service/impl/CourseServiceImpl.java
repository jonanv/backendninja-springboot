package com.udemy.service.impl;

import java.util.List;

import com.udemy.entity.Course;
import com.udemy.repository.CourseJpaRepository;
import com.udemy.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CourseServiceImpl implements CourseService {

    @Autowired
    @Qualifier("courseJpaRepository")
    private CourseJpaRepository courseJpaRepository;

    @Override
    public Course addCourse(Course course) {
        return null;
    }

    @Override
    public List<Course> listAllCourses() {
        return null;
    }

    @Override
    public int removeCourse(int id) {
        return 0;
    }

    @Override
    public Course updateCourse(Course course) {
        return null;
    }
    
}
