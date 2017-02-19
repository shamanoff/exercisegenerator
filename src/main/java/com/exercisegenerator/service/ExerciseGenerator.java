package com.exercisegenerator.service;

import com.exercisegenerator.domain.model.Exercise;
import com.exercisegenerator.domain.model.ExerciseCondition;
import com.exercisegenerator.domain.model.MathAction;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExerciseGenerator implements Generator{


    @Override
    public Set<Exercise> generate(@NonNull ExerciseCondition exCon) {
        Set<Exercise> exercises = new HashSet<>(exCon.getExercisesCount());
        for (int i = 0; i < exCon.getExercisesCount(); i++) {
            Long firstLong = getRandomLong(exCon.getFromInt(), exCon.getToInt());
            Long secondLong = getRandomLong(exCon.getFromInt(), exCon.getToInt());
            MathAction mathAction = exCon.getMathCondition();
            Long correctResult = mathAction.apply(firstLong, secondLong);


            exercises.add(new Exercise(firstLong, secondLong, mathAction, correctResult));
        }
        return exercises;
    }
}
