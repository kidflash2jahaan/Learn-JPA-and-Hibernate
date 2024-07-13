package com.system_err.learnjpaandhibernate.course;

import com.system_err.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaInterface;

public interface MyRepository<T> {
    CourseSpringDataJpaInterface getSpringDataJpaInterface();
    
    void insert(Course course);
    void delete(long id);
    T select(long id);
}
