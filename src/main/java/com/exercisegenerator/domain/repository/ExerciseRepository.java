package com.exercisegenerator.domain.repository;

import com.exercisegenerator.domain.model.Exercise;
import org.springframework.data.repository.CrudRepository;


public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
}
