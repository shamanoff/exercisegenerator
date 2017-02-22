package com.exercisegenerator.service;

import com.exercisegenerator.domain.model.Exercise;
import com.exercisegenerator.domain.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuizServiceImpl implements QuizService {
    @Autowired
    ExerciseRepository exerciseRepository;

    List<Exercise> exList = new ArrayList<>();
    @Override
    public List<Exercise> getExercise(Integer id) {
        exList = exerciseRepository.findAll(id);
        return exList;
    }

    @Override
    public Map<String, List<Exercise>> exerciseMap() {
        return null;
    }
}
