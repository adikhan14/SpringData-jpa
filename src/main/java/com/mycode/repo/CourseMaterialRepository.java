package com.mycode.repo;

import com.mycode.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
