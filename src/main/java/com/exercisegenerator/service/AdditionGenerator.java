package com.exercisegenerator.service;

import org.springframework.stereotype.Service;

@Service
public class AdditionGenerator extends AbstractGenerator{

    public int getResult(int firstInt, int secondInt) {
        return firstInt+secondInt;
    }


}
