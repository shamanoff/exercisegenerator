package com.exercisegenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Table(name = "exercise_conditions")

public class ExerciseConditions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    @Column
    private final int fromInt;
    @Column
    private final int toInt;
    @Column
    private final String mathCondition;
    @Column
    private final int exercisesCount;

}
