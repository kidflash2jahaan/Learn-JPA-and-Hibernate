package com.system_err.learnjpaandhibernate.course.springdatajpa;

import com.system_err.learnjpaandhibernate.course.Course;
import com.system_err.learnjpaandhibernate.course.MyRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Qualifier("SpringDataJPA")
@Repository
public class CourseSpringDataJpaRepository implements MyRepository<Course> {
    private final CourseSpringDataJpaInterface springDataJpaInterface;

    public CourseSpringDataJpaRepository(CourseSpringDataJpaInterface springDataJpaInterface) {
        this.springDataJpaInterface = springDataJpaInterface;
    }

    @Override
    public CourseSpringDataJpaInterface getSpringDataJpaInterface() {
        return springDataJpaInterface;
    }

    @Override
    public void insert(Course course) {
        springDataJpaInterface.save(course);
    }

    @Override
    public void delete(long id) {
        springDataJpaInterface.deleteById(id);
    }

    @Override
    public Course select(long id) {
        return springDataJpaInterface.findById(id).orElse(null);
    }
}
