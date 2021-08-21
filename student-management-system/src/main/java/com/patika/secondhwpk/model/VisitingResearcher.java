package com.patika.secondhwpk.model;

import lombok.Data;
import javax.persistence.Entity;

@Data
@Entity
public class VisitingResearcher extends Instructor {
    private double hourlySalary;
}
