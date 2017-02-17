package com.exercisegenerator.domain.model;

import com.exercisegenerator.domain.converter.MathActionConverter;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "exercise_conditions")

public class ExerciseCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    @Column
    private final Long fromInt;
    @Column
    private final Long toInt;
    @Column
    @Convert(converter = MathActionConverter.class)
    private final MathAction mathCondition;
    @Column
    private final Byte exercisesCount;

}
