package com.exercisegenerator.service;

import com.exercisegenerator.model.Exercise;
import com.exercisegenerator.model.ExerciseConditions;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;

abstract class AbstractGenerator implements RandomInt, Generator{

    private Set<Exercise> exerciseSet = new HashSet<>();

    abstract int getResult(int firstInt, int secondInt);



    @Override
    public void generate(@NonNull ExerciseConditions exCon) {
        Long id = 0L;
        int enteredResult = 0;
        int firstInt = getRandomInt(exCon.getFromInt(), exCon.getToInt());
        int secondInt = getRandomInt(exCon.getFromInt(), exCon.getToInt());
        String mathAction = exCon.getMathCondition();
        int counter = exCon.getExercisesCount();

        int correctResult = getResult(firstInt, secondInt);
        for (int i = 0; i < counter; i++) {
            exerciseSet.add(new Exercise(id, firstInt, secondInt, mathAction, correctResult, enteredResult));
        }

    }
}
