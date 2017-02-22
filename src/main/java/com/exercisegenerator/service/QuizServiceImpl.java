package com.exercisegenerator.service;

import com.exercisegenerator.domain.model.Exercise;
import com.exercisegenerator.domain.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    ExerciseRepository exerciseRepository;

    Map<String, List<Exercise>> exMap = new HashMap<>();

    public Map<String, List<Exercise>> getExMap() {
        return exMap;
    }

    List<Exercise> exList = new ArrayList<>();

    @Override
    public List<Exercise> getExercise(Integer id) {
        exList = exerciseRepository.findAll(id);
        return exList;
    }

    @Override
    public Map<String, List<Exercise>> getExerciseMap() {

        exMap = exList.stream()
                .collect(
                        Collectors.groupingBy(
                                (i) -> i.getMathAction().toString(), Collectors.toList()
                        )
                );
        return exMap;
    }
}
