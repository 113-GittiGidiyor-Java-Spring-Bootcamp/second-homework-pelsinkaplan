package com.patika.secondhwpk.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private LocalDate birthDate;

    private String address;

    private String gender;

    @ManyToMany
    private List<Course> courses = new ArrayList<>();
}
