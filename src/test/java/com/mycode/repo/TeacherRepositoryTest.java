package com.mycode.repo;

import com.mycode.entity.Course;
import com.mycode.entity.CourseMaterial;
import com.mycode.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        teacherRepository.save(Teacher.builder()
                .firstName("Adil")
                .lastName("Khan")
                .build());
    }

}