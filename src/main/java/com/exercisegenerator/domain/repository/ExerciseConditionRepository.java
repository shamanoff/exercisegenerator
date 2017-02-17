package com.exercisegenerator.domain.repository;

import com.exercisegenerator.domain.model.ExerciseCondition;
import org.springframework.data.repository.CrudRepository;

public interface ExerciseConditionRepository extends CrudRepository<ExerciseCondition, Long> {
}
