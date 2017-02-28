package com.exercisegenerator.service;

import com.exercisegenerator.domain.model.Exam;
import com.exercisegenerator.domain.model.Exercise;
import com.exercisegenerator.domain.model.MathAction;
import com.exercisegenerator.domain.repository.ExamRepository;
import com.exercisegenerator.domain.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private ExamRepository examRepository;

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
    public boolean isSolved(Long id){
        Exam exam = examRepository.findOne(id);
        return exam !=null&&exam.isSolved();
    }
    @Override
    public void solveQuiz(Long id){
        Exam exam = examRepository.findOne(id);
        exam.setSolved(true);
        examRepository.save(exam);
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
