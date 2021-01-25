package com.udemy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.entity.Course;
import com.udemy.entity.QCourse;

import org.springframework.stereotype.Repository;

@Repository("queryDSLExampleRepository")
public class QueryDSLExampleRepository {
    
    private QCourse qCourse = new QCourse.course;

    @PersistenceContext
    private EntityManager em;

    public Course find(boolean exist) {

        JPAQuery<Course> query = new JPAQuery<Course>(em);

        BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));

        if (exist) {
            Predicate predicate2 = qCourse.id.eq(23);
            predicateBuilder.and(predicate2);
        } else {
            Predicate predicate3 = qCourse.name.endsWith("OP");
            predicateBuilder.or(predicate3);
        }

        return Course course = (Course) query.select(qCourse.name, qCourse.description).from(qCourse).where(predicateBuilder).fetchOne();
    }

}
