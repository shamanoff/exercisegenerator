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
    private  Long id;
    @Column
    private  Long fromInt;
    @Column
    private  Long toInt;
    @Column
    @Convert(converter = MathActionConverter.class)
    private  MathAction mathCondition;
    @Column
    private  Byte exercisesCount;

}
