package com.exercisegenerator.service;

import com.exercisegenerator.model.Exercise;
import com.exercisegenerator.model.ExerciseConditions;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static java.lang.System.currentTimeMillis;


public class ExerciseGenerator implements Generator {

    private Set<Exercise> quiz = new HashSet<>();

    private int getRandomInt(int fromInt, int toInt) {
        return new Random(currentTimeMillis()).nextInt(toInt - fromInt) + fromInt;
    }

    private int resultInt;

    private int getResult(int firstInt, int secondInt, String mathAction) {
        try {
            if (mathAction.equals("+")) {
                resultInt = firstInt + secondInt;
            }
            if (mathAction.equals("-")) {
                resultInt = firstInt - secondInt;
            }
            if (mathAction.equals("*")) {
                resultInt = firstInt * secondInt;
            }
            if (mathAction.equals("/")) {
                resultInt = firstInt / secondInt;
            }
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exeption");
            resultInt = 100_000_000;
        }
        return resultInt;
    }

    @Override
    public void calculate(ExerciseConditions exCon) {

        Long id = 0L;
        int enteredResult = 0;
        int firstInt = getRandomInt( exCon.getFromInt(), exCon.getToInt());
        int secondInt = getRandomInt( exCon.getFromInt(), exCon.getToInt());
        String mathAction = exCon.getMathCondition();
        int counter = exCon.getExercisesCount();

        int correctResult = getResult(firstInt, secondInt, mathAction);
        for (int i = 0; i < counter; i++) {
            quiz.add(new Exercise(id, firstInt, secondInt, mathAction, correctResult, enteredResult));
        }
    }
}
