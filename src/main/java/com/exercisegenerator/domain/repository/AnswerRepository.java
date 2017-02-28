package com.exercisegenerator.domain.repository;

import com.exercisegenerator.domain.model.UserAnswer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnswerRepository extends CrudRepository<UserAnswer, Long> {
//    List<UserAnswer> findAllByExerciseid(Long id);
    List<Long> findAllByExerciseid(Long id);
}
