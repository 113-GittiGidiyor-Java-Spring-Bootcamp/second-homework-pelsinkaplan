package com.patika.secondhwpk.model;

import lombok.Data;
import javax.persistence.Entity;

@Data
@Entity
public class PermanentInstructor extends Instructor {
    private double fixedSalary;
}
