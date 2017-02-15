package com.exercisegenerator.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ExerciseConditions {

    private final Long id;
    private final int fromInt;
    private final int toInt;
    private final String mathCondition;
    private final int exercisesCount;

}
