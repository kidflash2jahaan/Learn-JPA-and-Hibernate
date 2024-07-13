package com.system_err.learnjpaandhibernate.course;

import com.system_err.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.system_err.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.system_err.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
    private final MyRepository<Course> repository;

    @Autowired
    public CourseCommandLineRunner(@Qualifier("SpringDataJPA") MyRepository<Course> repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Course 1", "Author 1"));
        repository.insert(new Course(2, "Course 2", "Author 2"));
        repository.insert(new Course(3, "Course 3", "Author 3"));
        
        repository.delete(1);

        System.out.println(repository.select(2));
        System.out.println(repository.select(3));

        CourseSpringDataJpaInterface springDataJpaInterface = repository.getSpringDataJpaInterface();

        if (springDataJpaInterface != null) {
            System.out.println(springDataJpaInterface.findAll());
            System.out.println(springDataJpaInterface.count());
            System.out.println(springDataJpaInterface.findByAuthor("Author 3"));
            System.out.println(springDataJpaInterface.findByAuthor(""));
            System.out.println(springDataJpaInterface.findByName("Course 2"));
        }
    }
}
