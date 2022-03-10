package com.mycode.repo;

import com.mycode.entity.Course;
import com.mycode.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        courseMaterialRepository.save(CourseMaterial.builder()
                .url("www.google.com")
                .course(Course.builder()
                        .title("DBA")
                        .credits(6)
                        .build())
                .build());
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll() ;
        System.out.println(courseMaterials);
    }

}