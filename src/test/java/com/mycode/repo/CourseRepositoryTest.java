package com.mycode.repo;

import com.mycode.entity.Course;
import com.mycode.entity.Guardian;
import com.mycode.entity.Student;
import com.mycode.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        System.out.println(courseRepository.findAll());
    }

    @Test
    public void saveCourse(){
        System.out.println(courseRepository.save(Course.builder()
                .title("Math")
                .credits(5)
                .teacher(Teacher.builder()
                        .firstName("Abdul")
                        .lastName("Majid")
                        .build())
                .build()));
    }

    @Test
    public void findAllPagination(){
        Pageable coursePages = PageRequest.of(0,2);
        List<Course> courses = courseRepository.findAll(coursePages).getContent();
        System.out.println(courses);
    }

    @Test
    public void findAllPaginationWithSorting(){
        Pageable coursePages = PageRequest.of(
                0,
                2,
                Sort.by("title"));
        List<Course> courses = courseRepository.findAll(coursePages).getContent();
        System.out.println(courses);

        System.out.println("Total Elements: "+courseRepository.findAll(coursePages).getTotalElements());

        System.out.println("Total Pages: "+courseRepository.findAll(coursePages).getTotalPages());
    }

    @Test
    public void saveCourseWithStudents(){
        System.out.println(courseRepository.save(Course.builder()
                .title("English")
                .credits(5)
                .teacher(Teacher.builder()
                        .firstName("Khawar")
                        .lastName("Hussain")
                        .build())
                .students(Arrays.asList(Student.builder()
                        .firstName("Farhan")
                        .lastName("khan")
                        .guardian(Guardian.builder()
                                .name("f")
                                .email("f@gmail.com")
                                .mobile("+934234539193")
                                .build())
                        .email("farhan@gmail.com")
                        .age(29)
                        .build(),Student.builder()
                        .firstName("Zaryab")
                        .lastName("khan")
                        .guardian(Guardian.builder()
                                .name("z")
                                .email("z@gmail.com")
                                .mobile("+934234539193")
                                .build())
                        .email("zaryab@gmail.com")
                        .age(29)
                        .build()))
                .build()));
    }

}