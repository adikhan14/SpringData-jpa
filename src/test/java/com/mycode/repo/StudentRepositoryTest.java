package com.mycode.repo;

import com.mycode.entity.Guardian;
import com.mycode.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {

        Student student = Student.builder()
                .firstName("bilal")
                .lastName("khan")
                .email("bilal@gmail.com")
                .age(32)
                .guardian(Guardian.builder()
                        .name("uzair")
                        .email("uzair@gmail.com")
                        .mobile("+934234539193")
                        .build())
                .build();
        studentRepository.save(student);
    }
    @Test
    public void getStudentByFirstName(){
        System.out.println("getStudentByFirstName: "+studentRepository.findByFirstName("adil"));
    }

    @Test
    public void getStudentByFirstNameContaining(){
        System.out.println("getStudentByFirstNameContaining: "+studentRepository.findByFirstNameContaining("i"));
    }

    @Test
    public void findByGuardianName(){
        System.out.println("findByGuardianName: "+studentRepository.findByGuardianName("uzair"));
    }

    @Test
    public void getStudentByEmailAddress(){
        System.out.println("getStudentByEmailAddress: "+studentRepository.getStudentByEmailAddress("adil@gmail.com"));
    }
    @Test
    public void getStudentByEmailAddressNative(){
        System.out.println("getStudentByEmailAddressNative: "+studentRepository.getStudentByEmailAddressNative("adil@gmail.com"));
    }

    @Test
    public void getStudentByEmailAddressNativeParam(){
        System.out.println("getStudentByEmailAddressNativeParam: "+studentRepository.getStudentByEmailAddressNativeParam("adil@gmail.com"));
    }

    @Test
    public void updateStudentNameByEmailId(){
        System.out.println("updateStudentNameByEmailId: "+studentRepository.updateStudentNameByEmailId("adil@gmail.com","adilahmed"));
    }

    @Test
    public void saveStudentWithGuardian() {
        Student student = Student.builder()
                .firstName("khurram")
                .lastName("khan")
                .guardian(Guardian.builder()
                        .name("uzair")
                        .email("uzair@gmail.com")
                        .mobile("+934234539193")
                        .build())
                .email("khurram@gmail.com")
                .age(29)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("printAllStudent: "+studentList);
    }


}