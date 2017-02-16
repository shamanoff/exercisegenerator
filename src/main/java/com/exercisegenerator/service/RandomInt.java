package com.exercisegenerator.service;

import java.util.Random;

import static java.lang.System.currentTimeMillis;

public interface RandomInt {

     default int getRandomInt(int fromInt, int toInt) {
          return new Random(currentTimeMillis()).nextInt(toInt - fromInt) + fromInt;
     }
}
