package com.mycode.repo;

import com.mycode.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
