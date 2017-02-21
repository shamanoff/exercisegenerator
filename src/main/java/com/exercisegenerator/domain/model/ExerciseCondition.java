package com.exercisegenerator.domain.model;

import com.exercisegenerator.domain.converter.MathActionConverter;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "exerciseconditions")

public class ExerciseCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "fromint")
    private  Long fromInt;
    @Column(name = "toint")
    private  Long toInt;
    @Column(name = "mathcondition")
    @Convert(converter = MathActionConverter.class)
    private  MathAction mathCondition;
    @Column(name = "exercisecount")
    private  Byte exerciseCount;

}
