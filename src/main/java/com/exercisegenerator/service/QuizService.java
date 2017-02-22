package com.exercisegenerator.service;

import com.exercisegenerator.domain.model.Exercise;

import java.util.List;
import java.util.Map;

public interface QuizService {

    List<Exercise> getExercise(Integer id);

    Map<String, List<Exercise>>exerciseMap();

}
