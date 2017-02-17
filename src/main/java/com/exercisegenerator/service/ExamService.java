package com.exercisegenerator.service;

import com.exercisegenerator.model.ExerciseConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ExamService implements ExerciseService {

    @Autowired
    private Generator generator;




    @Override
    public Integer createExam(Collection<ExerciseConditions> createdExam) {

        return null;
    }
}
