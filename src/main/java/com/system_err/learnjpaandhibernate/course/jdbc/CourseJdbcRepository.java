package com.system_err.learnjpaandhibernate.course.jdbc;

import com.system_err.learnjpaandhibernate.course.Course;
import com.system_err.learnjpaandhibernate.course.MyRepository;
import com.system_err.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Qualifier("JDBC")
@Repository
public class CourseJdbcRepository implements MyRepository<Course> {
    private static final String INSERT_QUERY = "insert into course (id, name, author) values (?, ?, ?);";
    private static final String DELETE_QUERY = "delete from course where id=?;";
    private static final String SELECT_QUERY = "select * from course where id=?;";

    private final JdbcTemplate springJdbcTemplate;

    public CourseJdbcRepository(JdbcTemplate springJdbcTemplate) {
        this.springJdbcTemplate = springJdbcTemplate;
    }
    
    @Override
    public CourseSpringDataJpaInterface getSpringDataJpaInterface() {
        return null;
    }

    @Override
    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    @Override
    public void delete(long id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    @Override
    public Course select(long id) {
        return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
