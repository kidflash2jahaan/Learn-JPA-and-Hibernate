package com.system_err.learnjpaandhibernate.course.jpa;

import com.system_err.learnjpaandhibernate.course.Course;
import com.system_err.learnjpaandhibernate.course.MyRepository;
import com.system_err.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaInterface;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Qualifier("JPA")
@Transactional
@Repository
public class CourseJpaRepository implements MyRepository<Course> {
    private final EntityManager manager;

    public CourseJpaRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public CourseSpringDataJpaInterface getSpringDataJpaInterface() {
        return null;
    }

    @Override
    public void insert(Course course) {
        manager.merge(course);
    }

    @Override
    public void delete(long id) {
        manager.remove(select(id));
    }

    @Override
    public Course select(long id) {
        return manager.find(Course.class, id);
    }
}
