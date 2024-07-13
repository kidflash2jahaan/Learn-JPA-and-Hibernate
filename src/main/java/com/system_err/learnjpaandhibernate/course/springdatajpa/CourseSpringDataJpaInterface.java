package com.system_err.learnjpaandhibernate.course.springdatajpa;

import com.system_err.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaInterface extends JpaRepository<Course, Long> {
    List<Course> findByName(String name);
    List<Course> findByAuthor(String author);
}
