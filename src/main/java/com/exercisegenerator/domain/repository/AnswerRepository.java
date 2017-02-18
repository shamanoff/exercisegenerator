package com.exercisegenerator.domain.repository;

import com.exercisegenerator.domain.model.UserAnswer;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<UserAnswer, Long> {
}
