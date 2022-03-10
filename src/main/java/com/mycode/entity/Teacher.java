package com.mycode.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @SequenceGenerators(
            @SequenceGenerator(
                    name = "teacher_sequence",
                    sequenceName = "teacher_sequence",
                    allocationSize = 1
            )
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long teacherId;
    private String firstName;
    private String lastName;


    @OneToMany(
            mappedBy = "teacher",
            cascade = CascadeType.ALL

    )
    private List<Course> courses;
}
