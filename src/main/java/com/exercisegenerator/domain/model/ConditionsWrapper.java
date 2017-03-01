package com.exercisegenerator.domain.model;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ConditionsWrapper {

    public List<ExerciseCondition> conditions = new ArrayList<>();


    public boolean notEmpty(ConditionsWrapper conditionsWrapper) {


      return conditionsWrapper.getConditions().stream()
                .anyMatch(exerciseCondition -> exerciseCondition.getExerciseCount() > 0);

    }

}
