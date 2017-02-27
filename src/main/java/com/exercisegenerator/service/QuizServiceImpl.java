package com.exercisegenerator.service;

import com.exercisegenerator.domain.model.Exercise;
import com.exercisegenerator.domain.model.MathAction;
import com.exercisegenerator.domain.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class QuizServiceImpl implements QuizService {
    private final ExerciseRepository exerciseRepository;
    @Autowired
    public QuizServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }
    @Override
    public List<Exercise> getExercise(Long id) {
        return  exerciseRepository.findByExamId(id);
    }
    @Override
    public Map<MathAction, List<Exercise>> getExerciseMap(Long id) {
      return  this.getExercise(id).stream()
                .collect(
                        Collectors.groupingBy(
                                Exercise::getMathAction, Collectors.toList()
                        )
                );
    }
}
