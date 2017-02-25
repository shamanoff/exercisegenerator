package com.exercisegenerator.service;

import com.exercisegenerator.domain.model.Exercise;
import com.exercisegenerator.domain.model.MathAction;

import java.util.List;
import java.util.Map;

public interface QuizService {

    List<Exercise> getExercise(Long id);

    Map<MathAction, List<Exercise>> getExerciseMap(Long id);

}
