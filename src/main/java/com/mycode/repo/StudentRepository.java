package com.mycode.repo;

import com.mycode.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String firstName);
    List<Student> findByGuardianName(String name);

    //JPQL
    @Query("Select s from Student s where s.email = ?1")
    Student getStudentByEmailAddress(String emailId);

    //NATIVE
    @Query(value = "Select * from Student s where s.email = ?1",
    nativeQuery = true)
    Student getStudentByEmailAddressNative (String emailId);

    //NATIVE With Param
    @Query(value = "Select * from Student s where s.email = :email",
            nativeQuery = true)
    Student getStudentByEmailAddressNativeParam(@Param("email") String emailId);

    @Modifying
    @Transactional
    @Query(value = "Update Student set first_name = :firstName where email = :email",
    nativeQuery = true)
    int updateStudentNameByEmailId(@Param("email") String email, @Param("firstName") String firstName);
}
