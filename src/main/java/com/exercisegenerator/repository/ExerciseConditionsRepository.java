package com.exercisegenerator.repository;

import com.exercisegenerator.model.ExerciseConditions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseConditionsRepository extends JpaRepository<ExerciseConditions, Long> {
}
