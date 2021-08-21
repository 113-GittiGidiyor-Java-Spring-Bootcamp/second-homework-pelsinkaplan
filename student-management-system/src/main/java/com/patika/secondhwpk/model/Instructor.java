package com.patika.secondhwpk.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String address;

    private String phoneNumber;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courses = new ArrayList<>();
}
