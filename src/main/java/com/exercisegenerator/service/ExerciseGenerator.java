package com.exercisegenerator.service;

import com.exercisegenerator.model.Exercise;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static java.lang.System.currentTimeMillis;


public class ExerciseGenerator implements Generator {

    private Set<Exercise> quiz = new HashSet<>();

    private int getRandomInt(int fromInt, int toInt) {
        return new Random(currentTimeMillis()).nextInt(toInt - fromInt) + fromInt;
    }

    private final int DEFRESULT = 1000000000;
    private int resultInt = DEFRESULT;

    private int getResult(int firstInt, int secondInt, String mathAction) {


        if (mathAction.equals("+")) {
            return resultInt = firstInt + secondInt;
        }
        if (mathAction.equals("-")) {
            return resultInt = firstInt - secondInt;
        }
        if (mathAction.equals("*")) {
            return resultInt = firstInt * secondInt;
        }
        if (mathAction.equals("/")) {
            return resultInt = firstInt / secondInt;
        }
        return resultInt;

    }

    @Override
    public void calculate(Exercise exercise) {

    }
}
