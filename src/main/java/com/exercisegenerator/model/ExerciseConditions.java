package com.exercisegenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "conditions")
@AllArgsConstructor
public class ExerciseConditions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long fromInt;
    @Column
    private final int toInt;
    @Column
    private final String mathCondition;
    @Column
    private final int exercisesCount;

}
