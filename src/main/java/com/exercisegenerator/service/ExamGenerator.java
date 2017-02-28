package com.exercisegenerator.service;

import com.exercisegenerator.domain.model.Exam;
import com.exercisegenerator.domain.model.Exercise;
import com.exercisegenerator.domain.model.ExerciseCondition;
import com.exercisegenerator.domain.repository.ExamRepository;
import com.exercisegenerator.domain.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamGenerator {

    @Autowired
    private ExerciseGenerator exerciseGenerator;
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private ExerciseRepository exerciseRepository;
    @Transactional
    public Long createExam(List<ExerciseCondition> exerciseConditions) {
        Long id = exerciseGenerator.getRandomLong(10_000_000L, 99_999_999L);
        Exam exam = new Exam();
        exam.setId(id);
        examRepository.save(exam).getId();
        List<Exercise> exercises = exerciseConditions
                .stream()
                .map(exerciseGenerator::generate)
                .flatMap(Collection::stream)
                .map(exercise -> exercise.setExamId(id))
                .map(exerciseRepository::save)
                .collect(Collectors.toList());

        return id;

    }


}
