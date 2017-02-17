package com.exercisegenerator.service;

import com.exercisegenerator.model.ExerciseConditions;

import java.util.Collection;

public interface ExerciseService {

    Integer createExam(Collection<ExerciseConditions> createdExam);
}
