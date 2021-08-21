package com.patika.secondhwpk.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String courseName;

    private String courseCode;

    private int creditScore;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    @ManyToOne
    private Instructor instructor;
}
