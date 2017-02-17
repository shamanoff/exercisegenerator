package com.exercisegenerator.service;

import com.exercisegenerator.domain.model.Exercise;
import com.exercisegenerator.domain.model.ExerciseCondition;

import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public interface Generator {

    Set<Exercise> generate(ExerciseCondition exCon);

    default long getRandomLong(long fromInt, long toInt) {
        return ThreadLocalRandom.current().nextLong(toInt - fromInt) + fromInt;
    }
}
